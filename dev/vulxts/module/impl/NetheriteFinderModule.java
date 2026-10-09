package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.class_1923;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class NetheriteFinderModule extends Module {
   private static final int SCAN_INTERVAL_TICKS = 20;
   public final SliderSetting maxShown = (SliderSetting)this.addSetting(new SliderSetting("Max Shown", "Maximum number of nearest results to display.", 100.0, 1.0, 1000.0, 1.0));
   public final BooleanSetting tracers = (BooleanSetting)this.addSetting(new BooleanSetting("Tracers", "Draw tracers to suspicious anti-xray sections as well as exact debris.", false));
   public final ModeSetting closestLayer = (ModeSetting)this.addSetting(new ModeSetting("Closest Layer", "Selects which Netherite layer supplies the one specially highlighted suspicious box.", "ALL", new String[]{"ALL", "TOP", "MIDDLE", "BOTTOM"}));
   public final ModeSetting terrainFiltering = (ModeSetting)this.addSetting(new ModeSetting("Terrain Filtering", "Requires at least 90% selected terrain when compared only with its competing Nether terrain.", "ALL", new String[]{"ALL", "NETHERRACK", "BASALT + BLACKSTONE"}));
   public final ColorSetting closestColor = (ColorSetting)this.addSetting(new ColorSetting("Closest Color", "Color used for the closest suspicious Netherite box in the selected layer.", -23296));
   public final BooleanSetting debrisHotspot = (BooleanSetting)this.addSetting(new BooleanSetting("Debris Hotspot", "Shows the best 7x7x7 hotspot and its terrain confidence in every detected search section.", false));
   public final SliderSetting hotspotTarget = (SliderSetting)this.addSetting(new SliderSetting("Hotspot Chance", "Minimum confidence required before a hotspot and percentage are shown.", 75.0, 25.0, 95.0, 5.0, "%"));
   public final SliderSetting hotspotMoveDelay = (SliderSetting)this.addSetting(new SliderSetting("Hotspot Move Delay", "Seconds an invalid hotspot remains before choosing another qualifying area.", 15.0, 0.0, 30.0, 1.0, "s"));
   public final BooleanSetting hotspotMovement = (BooleanSetting)this.addSetting(new BooleanSetting("Hotspot Movement", "Allows an invalid hotspot to move to another qualifying area after the delay.", true));
   public final ColorSetting outerBoxColor = (ColorSetting)this.addSetting(new ColorSetting("Outer Box Color", "Color used for debris and suspicious-region boxes.", -4302081));
   public final ColorSetting hotspotColor = (ColorSetting)this.addSetting(new ColorSetting("Hotspot Color", "Color used for the separate probability box and percentage.", -12388997));
   private final AtomicBoolean scanning = new AtomicBoolean();
   private final Set playerPlacedBlocks = ConcurrentHashMap.newKeySet();
   private final Set minedDebrisBlocks = ConcurrentHashMap.newKeySet();
   private final Set foundDebrisSections = ConcurrentHashMap.newKeySet();
   private final Set retiredSections = ConcurrentHashMap.newKeySet();
   private final Set missedHotspotSections = ConcurrentHashMap.newKeySet();
   private final Map lockedHotspots = new ConcurrentHashMap();
   private final Map invalidHotspotSince = new ConcurrentHashMap();
   private volatile List hits = List.of();
   private ExecutorService worker;
   private int timer;
   private class_638 trackedWorld;

   public NetheriteFinderModule() {
      super("Netherite Finder", "Finds visible Ancient Debris and suspicious anti-xray sections.", Category.RENDER);
      SliderSetting var10000 = this.hotspotTarget;
      BooleanSetting var10001 = this.debrisHotspot;
      Objects.requireNonNull(var10001);
      var10000.visibleWhen(var10001::get);
      BooleanSetting var1 = this.hotspotMovement;
      var10001 = this.debrisHotspot;
      Objects.requireNonNull(var10001);
      var1.visibleWhen(var10001::get);
      this.hotspotMoveDelay.visibleWhen(() -> {
         return (Boolean)this.debrisHotspot.get() && (Boolean)this.hotspotMovement.get();
      });
      ColorSetting var2 = this.hotspotColor;
      var10001 = this.debrisHotspot;
      Objects.requireNonNull(var10001);
      var2.visibleWhen(var10001::get);
   }

   protected synchronized void onEnable() {
      this.hits = List.of();
      this.timer = 20;
      this.scanning.set(false);
      this.clearTracking();
      this.worker = Executors.newSingleThreadExecutor((var0) -> {
         Thread var1 = new Thread(var0, "vulxts-netherite-scan");
         var1.setDaemon(true);
         return var1;
      });
   }

   protected synchronized void onDisable() {
      ExecutorService var1 = this.worker;
      this.worker = null;
      if (var1 != null) {
         var1.shutdownNow();
      }

      this.scanning.set(false);
      this.hits = List.of();
      this.timer = 0;
      this.clearTracking();
   }

   public void onTick() {
      class_310 var1 = class_310.method_1551();
      class_638 var2 = var1.field_1687;
      class_746 var3 = var1.field_1724;
      if (var2 != null && var3 != null) {
         if (this.trackedWorld != var2) {
            this.clearTracking();
            this.trackedWorld = var2;
         }

         boolean var4 = (Boolean)this.debrisHotspot.get();
         String var5 = (String)this.terrainFiltering.get();
         if (!var4) {
            this.lockedHotspots.clear();
            this.invalidHotspotSince.clear();
         }

         if (++this.timer >= 20) {
            this.timer = 0;
            ExecutorService var6 = this.worker;
            if (var6 != null && !var6.isShutdown() && this.scanning.compareAndSet(false, true)) {
               double var7 = var3.method_23317();
               double var9 = var3.method_23318();
               double var11 = var3.method_23321();
               int var13 = (Integer)var1.field_1690.method_42503().method_41753();
               class_1923 var14 = var3.method_31476();
               ArrayList var15 = new ArrayList();

               int var16;
               for(var16 = var14.field_9181 - var13; var16 <= var14.field_9181 + var13; ++var16) {
                  for(int var17 = var14.field_9180 - var13; var17 <= var14.field_9180 + var13; ++var17) {
                     if (var2.method_2935().method_12123(var16, var17)) {
                        var15.add(var2.method_8497(var16, var17));
                     }
                  }
               }

               var16 = this.maxShown.getInt();
               double var24 = (Double)this.hotspotTarget.get() / 100.0;
               long var19 = (long)this.hotspotMoveDelay.getInt() * 1000L;
               boolean var21 = (Boolean)this.hotspotMovement.get();

               try {
                  var6.submit(() -> {
                     try {
                        List var17 = this.scan(var15, var16, var7, var9, var11, var24, var19, var21, var4, var5);
                        if (this.isEnabled() && class_310.method_1551().field_1687 == var2) {
                           this.hits = this.applyMiningResults(var17);
                        }
                     } catch (Throwable var21x) {
                     } finally {
                        this.scanning.set(false);
                     }

                  });
               } catch (RuntimeException var23) {
                  this.scanning.set(false);
               }
            }
         }
      } else {
         this.hits = List.of();
         this.clearTracking();
      }

   }

   public List hits() {
      return this.hits;
   }

   public static Hit closestSuspiciousHit(Iterable var0, String var1, double var2, double var4) {
      Hit var6 = null;
      double var7 = Double.POSITIVE_INFINITY;
      Iterator var9 = var0.iterator();

      while(true) {
         Hit var10;
         double var15;
         do {
            do {
               do {
                  if (!var9.hasNext()) {
                     return var6;
                  }

                  var10 = (Hit)var9.next();
               } while(var10.exact());
            } while(!var10.matchesLayer(var1));

            double var11 = (var10.x1() + var10.x2()) * 0.5 - var2;
            double var13 = (var10.z1() + var10.z2()) * 0.5 - var4;
            var15 = var11 * var11 + var13 * var13;
         } while(!(var15 < var7) && (var15 != var7 || !comesBefore(var10, var6)));

         var6 = var10;
         var7 = var15;
      }
   }

   private static boolean comesBefore(Hit var0, Hit var1) {
      if (var1 == null) {
         return true;
      } else if (var0.x1() != var1.x1()) {
         return var0.x1() < var1.x1();
      } else if (var0.z1() != var1.z1()) {
         return var0.z1() < var1.z1();
      } else {
         return var0.y1() < var1.y1();
      }
   }

   public void recordPlayerPlacement(class_2338 var1) {
      if (this.isEnabled() && var1 != null) {
         this.playerPlacedBlocks.add(new BlockKey(var1.method_10263(), var1.method_10264(), var1.method_10260()));
      }

   }

   public void onServerBlockUpdate(class_2338 var1, class_2680 var2) {
      class_638 var3 = class_310.method_1551().field_1687;
      if (this.isEnabled() && var3 != null && var1 != null && var2 != null) {
         class_2680 var4 = var3.method_8320(var1);
         if (isAncientDebris(var4) && !isAncientDebris(var2)) {
            this.retireMinedSection(var1);
         }

      }
   }

   public void recordMinedDebris(class_2338 var1) {
      if (this.isEnabled() && var1 != null) {
         this.retireMinedSection(var1);
      }

   }

   private synchronized void retireMinedSection(class_2338 var1) {
      SectionKey var2 = NetheriteFinderModule.SectionKey.from(var1.method_10263(), var1.method_10264(), var1.method_10260());
      BlockKey var3 = new BlockKey(var1.method_10263(), var1.method_10264(), var1.method_10260());
      this.foundDebrisSections.remove(var2);
      this.retiredSections.add(var2);
      this.lockedHotspots.remove(var2);
      this.invalidHotspotSince.remove(var2);
      this.minedDebrisBlocks.add(var3);
      this.hits = this.applyMiningResults(this.hits);
   }

   private static boolean contains(DebrisHotspot.Result var0, BlockKey var1) {
      int var2 = Math.floorMod(var1.x(), 16);
      int var3 = Math.floorMod(var1.y(), 16);
      int var4 = Math.floorMod(var1.z(), 16);
      return var2 >= var0.x1() && var2 < var0.x2() && var3 >= var0.y1() && var3 < var0.y2() && var4 >= var0.z1() && var4 < var0.z2();
   }

   private List applyMiningResults(List var1) {
      ArrayList var2 = new ArrayList(var1.size() + this.missedHotspotSections.size());
      Iterator var3 = var1.iterator();

      while(true) {
         Hit var4;
         SectionKey var5;
         do {
            do {
               if (!var3.hasNext()) {
                  return List.copyOf(var2);
               }

               var4 = (Hit)var3.next();
               var5 = var4.section();
            } while(!var4.exact() && this.retiredSections.contains(var5));
         } while(var4.exact() && this.minedDebrisBlocks.contains(var4.block()));

         var2.add(var4);
      }
   }

   private void clearTracking() {
      this.playerPlacedBlocks.clear();
      this.minedDebrisBlocks.clear();
      this.foundDebrisSections.clear();
      this.retiredSections.clear();
      this.missedHotspotSections.clear();
      this.lockedHotspots.clear();
      this.invalidHotspotSince.clear();
      this.trackedWorld = null;
   }

   private List scan(List var1, int var2, double var3, double var5, double var7, double var9, long var11, boolean var13, boolean var14, String var15) {
      ArrayList var16 = new ArrayList();
      Iterator var17 = var1.iterator();

      while(var17.hasNext()) {
         class_2818 var18 = (class_2818)var17.next();
         class_2826[] var19 = var18.method_12006();
         int var20 = var18.method_32891();
         class_1923 var21 = var18.method_12004();

         for(int var22 = 0; var22 < var19.length; ++var22) {
            class_2826 var23 = var19[var22];
            if (var23 != null && !var23.method_38292()) {
               int var24 = var20 + var22 << 4;
               SectionKey var25 = new SectionKey(var21.field_9181, var24 >> 4, var21.field_9180);
               if (!var23.method_12265().method_19526(NetheriteFinderModule::isAncientDebris)) {
                  this.lockedHotspots.remove(var25);
                  this.invalidHotspotSince.remove(var25);
                  if (this.missedHotspotSections.contains(var25)) {
                     var16.add(NetheriteFinderModule.Hit.outerSection(var25));
                  }
               } else {
                  int var26 = var16.size();
                  class_2680[] var27 = new class_2680[4096];
                  boolean[] var28 = new boolean[4096];
                  int var29 = var21.method_8326();
                  int var30 = var21.method_8328();

                  for(int var31 = 0; var31 < 16; ++var31) {
                     for(int var32 = 0; var32 < 16; ++var32) {
                        for(int var33 = 0; var33 < 16; ++var33) {
                           class_2680 var34 = var23.method_12254(var33, var31, var32);
                           int var35 = (var31 * 16 + var32) * 16 + var33;
                           boolean var36 = this.playerPlacedBlocks.contains(new BlockKey(var29 + var33, var24 + var31, var30 + var32));
                           var28[var35] = var36;
                           var27[var35] = var36 ? null : var34;
                           if (!var36 && var34.method_27852(class_2246.field_22109)) {
                              int var37 = var29 + var33;
                              int var38 = var24 + var31;
                              int var39 = var30 + var32;
                              var16.add(new Hit((double)var37, (double)var38, (double)var39, (double)(var37 + 1), (double)(var38 + 1), (double)(var39 + 1), true, List.of()));
                           }
                        }
                     }
                  }

                  if (var16.size() != var26) {
                     this.foundDebrisSections.add(var25);
                     this.lockedHotspots.remove(var25);
                     this.invalidHotspotSince.remove(var25);
                  } else if (!matchesHostFilter(var27, var15)) {
                     this.lockedHotspots.remove(var25);
                     this.invalidHotspotSince.remove(var25);
                  } else if (this.retiredSections.contains(var25)) {
                     this.lockedHotspots.remove(var25);
                  } else {
                     DebrisHotspot.Analysis var40;
                     if (var14) {
                        DebrisHotspot.Result var41 = (DebrisHotspot.Result)this.lockedHotspots.get(var25);
                        if (var41 != null && var41.chance() < var9) {
                           this.lockedHotspots.remove(var25, var41);
                           this.invalidHotspotSince.remove(var25);
                           var41 = null;
                        }

                        DebrisHotspot.Result var43;
                        if (var41 != null) {
                           var43 = DebrisHotspot.validateLocked(var27, var24, var28, var41);
                           if (var43 != null) {
                              this.invalidHotspotSince.remove(var25);
                              var40 = new DebrisHotspot.Analysis(List.of(var41));
                           } else {
                              long var44 = System.currentTimeMillis();
                              long var45 = (Long)this.invalidHotspotSince.computeIfAbsent(var25, (var2x) -> {
                                 return var44;
                              });
                              if (var13 && var44 - var45 >= var11) {
                                 this.lockedHotspots.remove(var25, var41);
                                 this.invalidHotspotSince.remove(var25);
                                 var40 = DebrisHotspot.find(var27, var24, var9, var28);
                              } else {
                                 var40 = new DebrisHotspot.Analysis(List.of(var41));
                              }
                           }
                        } else {
                           var40 = DebrisHotspot.find(var27, var24, var9, var28);
                        }

                        if (var40.predictionResults().isEmpty()) {
                           this.lockedHotspots.remove(var25);
                           this.invalidHotspotSince.remove(var25);
                        } else {
                           var43 = (DebrisHotspot.Result)var40.predictionResults().getFirst();
                           if (var43.chance() >= var9) {
                              this.lockedHotspots.put(var25, var43);
                              if (var41 == null || !var43.equals(var41)) {
                                 this.invalidHotspotSince.remove(var25);
                              }
                           } else {
                              this.lockedHotspots.remove(var25);
                              this.invalidHotspotSince.remove(var25);
                              var40 = new DebrisHotspot.Analysis(List.of());
                           }
                        }
                     } else {
                        var40 = new DebrisHotspot.Analysis(List.of());
                     }

                     List var42 = var40.predictionResults().stream().map((var3x) -> {
                        return new ProbabilityRegion((double)(var29 + var3x.x1()), (double)(var24 + var3x.y1()), (double)(var30 + var3x.z1()), (double)(var29 + var3x.x2()), (double)(var24 + var3x.y2()), (double)(var30 + var3x.z2()), var3x.chance());
                     }).toList();
                     var16.add(new Hit((double)var29, (double)var24, (double)var30, (double)(var29 + 16), (double)(var24 + 16), (double)(var30 + 16), false, var42));
                  }
               }
            }
         }
      }

      var16.sort(Comparator.comparingInt((var0) -> {
         return var0.exact ? 0 : 1;
      }).thenComparingDouble((var6) -> {
         return var6.distanceSquared(var3, var5, var7);
      }));
      return var16.size() > var2 ? List.copyOf(var16.subList(0, var2)) : List.copyOf(var16);
   }

   private static boolean isAncientDebris(class_2680 var0) {
      return var0.method_27852(class_2246.field_22109);
   }

   public static boolean matchesHostFilter(class_2680[] var0, String var1) {
      if ("ALL".equals(var1)) {
         return true;
      } else {
         int var2 = 0;
         int var3 = 0;
         class_2680[] var4 = var0;
         int var5 = var0.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            class_2680 var7 = var4[var6];
            if (var7 != null) {
               boolean var8 = var7.method_27852(class_2246.field_10515);
               boolean var9 = var7.method_27852(class_2246.field_22091) || var7.method_27852(class_2246.field_29032) || var7.method_27852(class_2246.field_23869);
               if ("NETHERRACK".equals(var1)) {
                  if (var8) {
                     ++var2;
                  } else if (var9) {
                     ++var3;
                  }
               } else if ("BASALT + BLACKSTONE".equals(var1)) {
                  if (var9) {
                     ++var2;
                  } else if (var8) {
                     ++var3;
                  }
               }
            }
         }

         int var10 = var2 + var3;
         return var10 > 0 && var2 * 100 >= var10 * 90;
      }
   }

   public static record Hit(double x1, double y1, double z1, double x2, double y2, double z2, boolean exact, List probabilityRegions) {
      public Hit(double x1, double y1, double z1, double x2, double y2, double z2, boolean exact, List probabilityRegions) {
         this.x1 = x1;
         this.y1 = y1;
         this.z1 = z1;
         this.x2 = x2;
         this.y2 = y2;
         this.z2 = z2;
         this.exact = exact;
         this.probabilityRegions = probabilityRegions;
      }

      public boolean matchesLayer(String var1) {
         if ("ALL".equals(var1)) {
            return true;
         } else {
            int var2 = (int)Math.floor((this.y1 + this.y2) * 0.5);
            boolean var10000;
            switch (var1) {
               case "TOP":
                  var10000 = var2 >= 93 && var2 <= 127;
                  break;
               case "MIDDLE":
                  var10000 = var2 >= 45 && var2 <= 92;
                  break;
               case "BOTTOM":
                  var10000 = var2 >= 0 && var2 <= 44;
                  break;
               default:
                  var10000 = false;
            }

            return var10000;
         }
      }

      private boolean isInSection(SectionKey var1) {
         return this.section().equals(var1);
      }

      private SectionKey section() {
         return NetheriteFinderModule.SectionKey.from((int)Math.floor(this.x1), (int)Math.floor(this.y1), (int)Math.floor(this.z1));
      }

      private BlockKey block() {
         return new BlockKey((int)Math.floor(this.x1), (int)Math.floor(this.y1), (int)Math.floor(this.z1));
      }

      private Hit withoutHotspot() {
         return new Hit(this.x1, this.y1, this.z1, this.x2, this.y2, this.z2, false, List.of());
      }

      private static Hit outerSection(SectionKey var0) {
         int var1 = var0.x() << 4;
         int var2 = var0.y() << 4;
         int var3 = var0.z() << 4;
         return new Hit((double)var1, (double)var2, (double)var3, (double)(var1 + 16), (double)(var2 + 16), (double)(var3 + 16), false, List.of());
      }

      private double distanceSquared(double var1, double var3, double var5) {
         double var7 = (this.x1 + this.x2) * 0.5 - var1;
         double var9 = (this.y1 + this.y2) * 0.5 - var3;
         double var11 = (this.z1 + this.z2) * 0.5 - var5;
         return var7 * var7 + var9 * var9 + var11 * var11;
      }

      public double x1() {
         return this.x1;
      }

      public double y1() {
         return this.y1;
      }

      public double z1() {
         return this.z1;
      }

      public double x2() {
         return this.x2;
      }

      public double y2() {
         return this.y2;
      }

      public double z2() {
         return this.z2;
      }

      public boolean exact() {
         return this.exact;
      }

      public List probabilityRegions() {
         return this.probabilityRegions;
      }
   }

   private static record BlockKey(int x, int y, int z) {
      private BlockKey(int x, int y, int z) {
         this.x = x;
         this.y = y;
         this.z = z;
      }

      public int x() {
         return this.x;
      }

      public int y() {
         return this.y;
      }

      public int z() {
         return this.z;
      }
   }

   private static record SectionKey(int x, int y, int z) {
      private SectionKey(int x, int y, int z) {
         this.x = x;
         this.y = y;
         this.z = z;
      }

      private static SectionKey from(int var0, int var1, int var2) {
         return new SectionKey(var0 >> 4, var1 >> 4, var2 >> 4);
      }

      public int x() {
         return this.x;
      }

      public int y() {
         return this.y;
      }

      public int z() {
         return this.z;
      }
   }

   public static record ProbabilityRegion(double x1, double y1, double z1, double x2, double y2, double z2, double chance) {
      public ProbabilityRegion(double x1, double y1, double z1, double x2, double y2, double z2, double chance) {
         this.x1 = x1;
         this.y1 = y1;
         this.z1 = z1;
         this.x2 = x2;
         this.y2 = y2;
         this.z2 = z2;
         this.chance = chance;
      }

      public double x1() {
         return this.x1;
      }

      public double y1() {
         return this.y1;
      }

      public double z1() {
         return this.z1;
      }

      public double x2() {
         return this.x2;
      }

      public double y2() {
         return this.y2;
      }

      public double z2() {
         return this.z2;
      }

      public double chance() {
         return this.chance;
      }
   }
}
