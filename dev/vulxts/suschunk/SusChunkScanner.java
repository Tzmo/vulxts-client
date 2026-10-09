package dev.vulxts.suschunk;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Modules;
import dev.vulxts.rt.Deobf;
import dev.vulxts.util.UiSounds;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1923;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_310;
import net.minecraft.class_4076;
import net.minecraft.class_638;

public class SusChunkScanner {
   private static final int[] SENSITIVITY_THRESHOLDS = new int[]{25, 32, 39, 46, 54, 61, 68, 75, 82, 89, 96, 104, 111, 118, 125};
   private static final int GEODE_LINK_DISTANCE = 12;
   private static final int EVIDENCE_SPACING = 4;
   private static final int MAX_REMEMBERED_CHUNKS = 8192;
   private static final double GEODE_SCORE_CAP = 512.0;
   private static final double NEARBY_BASE_BONUS = 12.0;
   private static final double NEARBY_LOCAL_RATIO = 0.75;
   private static final double FULLNESS_SPAN_TARGET = 8.0;
   private static final double FULLNESS_ACTIVITY_TARGET = 54.0;
   private static final double CAP_VERTICAL_SPAN_TARGET = 5.0;
   private static final double CAP_ACTIVITY_TARGET = 36.0;
   private static final double FULL_ROOF_SPAN_TARGET = 8.0;
   private static final double FULL_ROOF_ACTIVITY_TARGET = 18.0;
   private static final double HALF_RENDERED_ROOF_MULTIPLIER = 2.0;
   private static final boolean DEBUG_LOG = Boolean.getBoolean(Deobf.decrypt("\u0000\u001f>]|\u009bËÉáčŽşťƮƴǂ"));
   private final Modules.SusChunkFinderModule module;
   private final Map scores = new ConcurrentHashMap();
   private final Deque queue = new ArrayDeque();
   private final Set lightRescans = ConcurrentHashMap.newKeySet();
   private final Set alertedChunks = new HashSet();
   private volatile List flags = List.of();
   private volatile List zones = List.of();
   private class_1923 lastQueueCenter;
   private class_638 scoreLevel;
   private int tickCounter;
   private int lastSignalFingerprint = Integer.MIN_VALUE;

   public SusChunkScanner(Modules.SusChunkFinderModule var1) {
      this.module = var1;
      ServerLightCache var10000 = ServerLightCache.get();
      Set var10001 = this.lightRescans;
      Objects.requireNonNull(var10001);
      var10000.addDirtyListener(var10001::add);
   }

   public List flags() {
      return this.flags;
   }

   public List zones() {
      return this.zones;
   }

   public int threshold() {
      return thresholdForSensitivity(this.module.sensitivity.getInt());
   }

   public static int thresholdForSensitivity(int var0) {
      int var1 = Math.clamp((long)var0, 1, 15);
      return SENSITIVITY_THRESHOLDS[var1 - 1];
   }

   public void requestRescan(int var1, int var2) {
      this.lightRescans.add(class_1923.method_8331(var1, var2));
   }

   public void clear() {
      this.scores.clear();
      this.queue.clear();
      this.lightRescans.clear();
      this.alertedChunks.clear();
      this.flags = List.of();
      this.zones = List.of();
      this.lastQueueCenter = null;
      this.scoreLevel = null;
   }

   public void tick() {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1687 != null && var1.field_1724 != null) {
         try {
            if (this.scoreLevel != var1.field_1687) {
               this.clear();
               ServerLightCache.get().clear();
               this.scoreLevel = var1.field_1687;
            }

            this.invalidateForSignalChanges();
            this.refillQueueIfNeeded(var1);
            int var2 = this.module.scanSpeed.getInt();
            long var3 = System.nanoTime() + 2000000L;
            int var5 = this.scanLightRescans(var1, var2, var3);
            this.scanQueue(var1, var2 - var5, var3);
            if (++this.tickCounter % 20 == 0) {
               this.rebuild(var1);
            }
         } catch (Exception var6) {
            VulxtsClient.LOGGER.warn(Deobf.decrypt("%\u001f!f`\u009d\u008bÑÒėĽşťƾǡǖǡȇȮȊɖʒʽ˟˅̷͈͋ͬ"), var6.toString());
         }
      }

   }

   private void invalidateForSignalChanges() {
      int var1 = 1;
      var1 = 31 * var1 + ((Boolean)this.module.amethyst.get() ? 1 : 0);
      var1 = 31 * var1 + ((Boolean)this.module.kelp.get() ? 1 : 0);
      var1 = 31 * var1 + ((Boolean)this.module.bamboo.get() ? 1 : 0);
      var1 = 31 * var1 + ((Boolean)this.module.berries.get() ? 1 : 0);
      var1 = 31 * var1 + ((Boolean)this.module.vines.get() ? 1 : 0);
      var1 = 31 * var1 + ((Boolean)this.module.dripstone.get() ? 1 : 0);
      if (var1 != this.lastSignalFingerprint) {
         this.lastSignalFingerprint = var1;
         this.clear();
      }

   }

   private int scanLightRescans(class_310 var1, int var2, long var3) {
      if (this.lightRescans.isEmpty()) {
         return 0;
      } else {
         int var5 = 0;
         ArrayList var6 = new ArrayList();
         Iterator var7 = this.lightRescans.iterator();

         while(var7.hasNext() && var5 < var2 && System.nanoTime() < var3) {
            long var8 = (Long)var7.next();
            var7.remove();
            class_2818 var10 = var1.field_1687.method_2935().method_12126(class_1923.method_8325(var8), class_1923.method_8332(var8), false);
            if (var10 == null) {
               var6.add(var8);
            } else {
               this.scores.put(var8, this.scanChunk(var1, var10));
               ++var5;
            }
         }

         this.lightRescans.addAll(var6);
         return var5;
      }
   }

   private void scanQueue(class_310 var1, int var2, long var3) {
      int var5 = 0;

      for(int var6 = 0; var5 < var2 && var6 < 128 && !this.queue.isEmpty() && System.nanoTime() < var3; ++var6) {
         long var8 = (Long)this.queue.pollFirst();
         class_2818 var7;
         if (!this.scores.containsKey(var8) && (var7 = var1.field_1687.method_2935().method_12126(class_1923.method_8325(var8), class_1923.method_8332(var8), false)) != null) {
            this.scores.put(var8, this.scanChunk(var1, var7));
            ++var5;
         }
      }

   }

   private void refillQueueIfNeeded(class_310 var1) {
      class_1923 var2 = var1.field_1724.method_31476();
      if (this.queue.isEmpty() || this.lastQueueCenter == null || Math.max(Math.abs(var2.field_9181 - this.lastQueueCenter.field_9181), Math.abs(var2.field_9180 - this.lastQueueCenter.field_9180)) >= 3) {
         this.lastQueueCenter = var2;
         this.queue.clear();
         int var3 = Math.min((Integer)var1.field_1690.method_42503().method_41753() + 1, 16);
         ArrayList var4 = new ArrayList();

         for(int var5 = -var3; var5 <= var3; ++var5) {
            for(int var6 = -var3; var6 <= var3; ++var6) {
               long var7 = class_1923.method_8331(var2.field_9181 + var5, var2.field_9180 + var6);
               if (!this.scores.containsKey(var7)) {
                  var4.add(var7);
               }
            }
         }

         var4.sort(Comparator.comparingDouble((var1x) -> {
            return Math.hypot((double)(class_1923.method_8325(var1x) - var2.field_9181), (double)(class_1923.method_8332(var1x) - var2.field_9180));
         }));
         this.queue.addAll(var4);
      }

   }

   private static boolean isPlantTarget(class_2680 var0) {
      class_2248 var1 = var0.method_26204();
      return var1 == class_2246.field_9993 || var1 == class_2246.field_10463 || var1 == class_2246.field_10211 || var1 == class_2246.field_16999 || var1 == class_2246.field_10597 || var1 == class_2246.field_28048;
   }

   private static boolean isAmethystStructure(class_2680 var0) {
      return var0.method_27852(class_2246.field_27160) || var0.method_27852(class_2246.field_27159);
   }

   private static boolean isAmethystSignal(class_2680 var0) {
      class_2248 var1 = var0.method_26204();
      return var1 == class_2246.field_27161 || var1 == class_2246.field_27162 || var1 == class_2246.field_27163 || var1 == class_2246.field_27164;
   }

   private static boolean isGeodeEvidence(class_2680 var0) {
      return isAmethystSignal(var0) || isAmethystStructure(var0) || var0.method_27852(class_2246.field_29032);
   }

   private static void addGeodeEvidence(Map var0, class_2338 var1, double var2) {
      Iterator var4 = var0.entrySet().iterator();

      Map.Entry var8;
      while(var4.hasNext()) {
         var8 = (Map.Entry)var4.next();
         class_2338 var6 = (class_2338)var8.getKey();
         int var7 = Math.max(Math.abs(var6.method_10263() - var1.method_10263()), Math.max(Math.abs(var6.method_10264() - var1.method_10264()), Math.abs(var6.method_10260() - var1.method_10260())));
         if (var7 < 4) {
            if (var2 <= (Double)var8.getValue()) {
               return;
            }

            var4.remove();
            break;
         }
      }

      if (var0.size() >= SusChunkScanner.SignalType.AMETHYST.cap) {
         var8 = null;
         Iterator var8 = var0.entrySet().iterator();

         while(true) {
            if (!var8.hasNext()) {
               if (var8 == null || var2 <= (Double)var8.getValue()) {
                  return;
               }

               var0.remove(var8.getKey());
               break;
            }

            Map.Entry var10 = (Map.Entry)var8.next();
            if (var8 == null || (Double)var10.getValue() < (Double)var8.getValue()) {
               var8 = var10;
            }
         }
      }

      var0.put(var1, var2);
   }

   private ChunkScore scanChunk(class_310 var1, class_2818 var2) {
      ChunkScore var3 = new ChunkScore(var2.method_12004().method_8324());
      if ((Boolean)this.module.amethyst.get()) {
         this.detectAmethyst(var1, var2, var3);
      }

      this.detectGrowth(var1, var2, var3);
      var3.computeScore();
      if (DEBUG_LOG && var3.score > 0.0) {
         VulxtsClient.LOGGER.info(Deobf.decrypt("-\u0019'VUÈ\u0086ÒáĐĸěŻƱǡǖǡȉȲɏȎʛʲʐ˟̘̬ͣ̀ΔΧ"), new Object[]{var2.method_12004(), var3.score, var3.hits});
      }

      return var3;
   }

   private void detectAmethyst(class_310 var1, class_2818 var2, ChunkScore var3) {
      HashMap var4 = new HashMap();
      class_2826[] var5 = var2.method_12006();
      int var6 = var2.method_32891();
      int var7 = var2.method_12004().method_8326();
      int var8 = var2.method_12004().method_8328();
      class_2338.class_2339 var9 = new class_2338.class_2339();
      class_2338.class_2339 var10 = new class_2338.class_2339();

      for(int var11 = 0; var11 < var5.length; ++var11) {
         class_2826 var12 = var5[var11];
         if (!var12.method_38292() && var12.method_12265().method_19526(SusChunkScanner::isGeodeEvidence)) {
            int var13 = var6 + var11 << 4;

            for(int var14 = 0; var14 < 16; ++var14) {
               for(int var15 = 0; var15 < 16; ++var15) {
                  for(int var16 = 0; var16 < 16; ++var16) {
                     class_2680 var17 = var12.method_12254(var16, var14, var15);
                     if (isGeodeEvidence(var17)) {
                        var9.method_10103(var7 + var16, var13 + var14, var8 + var15);
                        if (isAmethystStructure(var17)) {
                           addGeodeEvidence(var4, var9.method_10062(), 2.0);
                        } else if (var17.method_27852(class_2246.field_29032)) {
                           addGeodeEvidence(var4, var9.method_10062(), 1.0);
                        } else if (hasAmethystNeighbour(var1, var9, var10)) {
                           class_2338 var18 = var9.method_10062();
                           addGeodeEvidence(var4, var18, 3.0);
                           if (DEBUG_LOG) {
                              VulxtsClient.LOGGER.info("[SusChunk] amethyst growth at {}", var18);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      ServerLightCache var19 = ServerLightCache.get();
      Iterator var20 = var19.light5Positions(var7 >> 4, var8 >> 4).iterator();

      while(var20.hasNext()) {
         class_2338 var22 = (class_2338)var20.next();
         if (isLevelFiveLightSource(var19, var22)) {
            addGeodeEvidence(var4, var22, 5.0);
            if (DEBUG_LOG) {
               VulxtsClient.LOGGER.info("[SusChunk] hidden level-5 amethyst candidate at {}", var22);
            }
         }
      }

      var20 = var4.entrySet().iterator();

      while(var20.hasNext()) {
         Map.Entry var23 = (Map.Entry)var20.next();
         var3.amethystCells.add(new AmethystEvidence((class_2338)var23.getKey(), (Double)var23.getValue()));
      }

   }

   private static boolean isLevelFiveLightSource(ServerLightCache var0, class_2338 var1) {
      int var2 = var1.method_10263();
      int var3 = var1.method_10264();
      int var4 = var1.method_10260();
      return var0.serverBlockLight(var2 + 1, var3, var4) <= 5 && var0.serverBlockLight(var2 - 1, var3, var4) <= 5 && var0.serverBlockLight(var2, var3 + 1, var4) <= 5 && var0.serverBlockLight(var2, var3 - 1, var4) <= 5 && var0.serverBlockLight(var2, var3, var4 + 1) <= 5 && var0.serverBlockLight(var2, var3, var4 - 1) <= 5;
   }

   private static boolean hasAmethystNeighbour(class_310 var0, class_2338 var1, class_2338.class_2339 var2) {
      for(int var3 = -1; var3 <= 1; ++var3) {
         for(int var4 = -1; var4 <= 1; ++var4) {
            for(int var5 = -1; var5 <= 1; ++var5) {
               if (var3 != 0 || var4 != 0 || var5 != 0) {
                  var2.method_10103(var1.method_10263() + var3, var1.method_10264() + var4, var1.method_10260() + var5);
                  if (isAmethystStructure(var0.field_1687.method_8320(var2))) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   private void detectGrowth(class_310 var1, class_2818 var2, ChunkScore var3) {
      class_2826[] var4 = var2.method_12006();
      int var5 = var2.method_32891();
      int var6 = class_4076.method_18675(-12);
      int var7 = class_4076.method_18675(80);
      int var8 = var2.method_12004().method_8326();
      int var9 = var2.method_12004().method_8328();
      class_2338.class_2339 var10 = new class_2338.class_2339();

      for(int var11 = 0; var11 < var4.length; ++var11) {
         int var13 = var5 + var11;
         class_2826 var12;
         if (var13 >= var6 && var13 <= var7 && !(var12 = var4[var11]).method_38292() && var12.method_12265().method_19526(SusChunkScanner::isPlantTarget)) {
            int var14 = var13 << 4;

            for(int var15 = 0; var15 < 16; ++var15) {
               int var16 = var14 + var15;
               if (var16 >= -12 && var16 <= 80) {
                  for(int var17 = 0; var17 < 16; ++var17) {
                     for(int var18 = 0; var18 < 16; ++var18) {
                        class_2680 var19 = var12.method_12254(var18, var15, var17);
                        if (isPlantTarget(var19)) {
                           var10.method_10103(var8 + var18, var16, var9 + var17);
                           this.inspectPlant(var1, var19, var10, var3);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   private void inspectPlant(class_310 var1, class_2680 var2, class_2338 var3, ChunkScore var4) {
      class_2248 var5 = var2.method_26204();
      if ((var5 == class_2246.field_9993 || var5 == class_2246.field_10463) && (Boolean)this.module.kelp.get()) {
         class_2680 var7 = var1.field_1687.method_8320(var3.method_10084());
         if (var7.method_27852(class_2246.field_9993) || var7.method_27852(class_2246.field_10463)) {
            return;
         }

         int var8 = columnLength(var1, var3, class_2350.field_11033, class_2246.field_9993, class_2246.field_10463);
         boolean var12 = var5 == class_2246.field_9993 && var2.method_28498(class_2741.field_12517) && (Integer)var2.method_11654(class_2741.field_12517) == 25;
         if (var12 && var8 >= 8 || var8 >= 14) {
            var4.add(SusChunkScanner.SignalType.KELP, var3);
            if (DEBUG_LOG) {
               VulxtsClient.LOGGER.info(Deobf.decrypt("-\u0019'VUÈ®ÿØĮųŻŻƱǡǍǧȏȧɂɇ˝ʴˍʗ̜Ͷ͋͐ΈοΈϨϝ"), new Object[]{var3, var8, var12});
            }
         }
      } else {
         int var6;
         if (var5 == class_2246.field_10211 && (Boolean)this.module.bamboo.get()) {
            if (var1.field_1687.method_8320(var3.method_10074()).method_27852(class_2246.field_10211)) {
               return;
            }

            var6 = columnLength(var1, var3, class_2350.field_11036, class_2246.field_10211);
            if (var6 >= 12) {
               var4.add(SusChunkScanner.SignalType.BAMBOO, var3);
               if (DEBUG_LOG) {
                  VulxtsClient.LOGGER.info(Deobf.decrypt("-\u0019'VUÈ§ûÙļĜŴĠƌƺǘƢȎȥɃɔʈʻʍˌ̌"), var3, var6);
               }
            }
         } else if (var5 == class_2246.field_16999 && (Boolean)this.module.berries.get()) {
            if (var2.method_28498(class_2741.field_12497) && (Integer)var2.method_11654(class_2741.field_12497) == 3) {
               var4.add(SusChunkScanner.SignalType.BERRIES, var3);
               if (DEBUG_LOG) {
                  VulxtsClient.LOGGER.info(Deobf.decrypt("-\u0019'VUÈ§ÿÆĬĚžœǬƬǄǺɆȡɍɖˀʏˋˊ"), var3);
               }
            }
         } else if (var5 == class_2246.field_10597 && (Boolean)this.module.vines.get()) {
            if (var1.field_1687.method_8320(var3.method_10084()).method_27852(class_2246.field_10597)) {
               return;
            }

            var6 = columnLength(var1, var3, class_2350.field_11033, class_2246.field_10597);
            if (var6 >= 7) {
               var4.add(SusChunkScanner.SignalType.VINES, var3);
               if (DEBUG_LOG) {
                  VulxtsClient.LOGGER.info(Deobf.decrypt("-\u0019'VUÈ³óÚĻĀěŀƷƼƅǪȇȮɍȎʛʲ"), var3, var6);
               }
            }
         } else if (var5 == class_2246.field_28048 && (Boolean)this.module.dripstone.get()) {
            if (var1.field_1687.method_8320(var3.method_10084()).method_27852(class_2246.field_28048) || !var1.field_1687.method_8320(var3.method_10074()).method_27852(class_2246.field_28048)) {
               return;
            }

            var6 = columnLength(var1, var3, class_2350.field_11033, class_2246.field_28048);
            if (var6 >= 5) {
               var4.add(SusChunkScanner.SignalType.DRIPSTONE, var3);
               if (DEBUG_LOG) {
                  VulxtsClient.LOGGER.info(Deobf.decrypt("-\u0019'VUÈ¡èÝĮĀůŏƂƄƅǂȝȽȊɟʅʡ˗˃̙̪͈ͬ"), var3, var6);
               }
            }
         }
      }

   }

   private static int columnLength(class_310 var0, class_2338 var1, class_2350 var2, class_2248... var3) {
      class_2338.class_2339 var5 = var1.method_25503();

      int var4;
      for(var4 = 1; var4 < 40; ++var4) {
         var5.method_10098(var2);
         class_2680 var6 = var0.field_1687.method_8320(var5);
         class_2248[] var7 = var3;
         int var8 = var3.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            class_2248 var10 = var7[var9];
            if (var6.method_27852(var10)) {
               break;
            }
         }
      }

      return var4;
   }

   private void rebuild(class_310 var1) {
      this.trimRememberedScores(var1);
      int var2 = this.threshold();
      int var3 = Math.min(var2, 50);
      HashMap var4 = new HashMap();
      Iterator var5 = this.scores.values().iterator();

      FlagAggregate var27;
      while(var5.hasNext()) {
         ChunkScore var6 = (ChunkScore)var5.next();
         if (var6.score >= (double)var3) {
            var27 = (FlagAggregate)var4.computeIfAbsent(var6.chunkKey, FlagAggregate::new);
            var27.score = Math.max(var27.score, var6.score);
            var27.hitWeight += var6.hitWeight;
            var27.hitX += var6.hitX;
            var27.hitZ += var6.hitZ;
         }
      }

      var5 = this.clusterGeodes().iterator();

      while(var5.hasNext()) {
         Geode var24 = (Geode)var5.next();
         HashMap var26 = new HashMap();
         Iterator var8 = var24.cells().iterator();

         long var33;
         while(var8.hasNext()) {
            AmethystEvidence var9 = (AmethystEvidence)var8.next();
            class_2338 var10 = var9.pos();
            var33 = class_1923.method_8331(var10.method_10263() >> 4, var10.method_10260() >> 4);
            var26.merge(var33, var9.weight(), Double::sum);
         }

         HashSet var28 = new HashSet();
         Iterator var27 = var26.entrySet().iterator();

         double var35;
         while(var27.hasNext()) {
            Map.Entry var31 = (Map.Entry)var27.next();
            var33 = (Long)var31.getKey();
            double var13 = (Double)var31.getValue() * var24.fullnessMultiplier();
            var35 = Math.max(0.0, var24.score() - var13);
            double var17 = Math.min(var35, Math.max(12.0 * var24.fullnessMultiplier(), var13 * 0.75));
            double var19 = var13 + var17;
            if (!(var19 < (double)var2)) {
               FlagAggregate var21 = (FlagAggregate)var4.computeIfAbsent(var33, FlagAggregate::new);
               var21.score = Math.max(var21.score, var19);
               var28.add(var33);
            }
         }

         var27 = var24.cells().iterator();

         while(var27.hasNext()) {
            AmethystEvidence var32 = (AmethystEvidence)var27.next();
            class_2338 var34 = var32.pos();
            long var12 = class_1923.method_8331(var34.method_10263() >> 4, var34.method_10260() >> 4);
            if (var28.contains(var12)) {
               FlagAggregate var14 = (FlagAggregate)var4.get(var12);
               var35 = var32.weight();
               var14.hitWeight += var35;
               var14.hitX += ((double)var34.method_10263() + 0.5) * var35;
               var14.hitZ += ((double)var34.method_10260() + 0.5) * var35;
            }
         }

         if (DEBUG_LOG) {
            VulxtsClient.LOGGER.info(Deobf.decrypt("-\u0019'VUÈ¢ÿÛĺĖěŻƱǡǆǧȊȬəȓˏ˯ˋˊ͑ʹ͛ͤ\u0381αφο\u0380ЎвњѬґӭӼӹՂժԃԽֳ֢\u05fa\u05cd"), new Object[]{var24.cells().size(), var24.chunks().size(), var24.score()});
            VulxtsClient.LOGGER.info("[SusChunk] geode fullness={} multiplier={}", var24.fullness(), var24.fullnessMultiplier());
         }
      }

      ArrayList var23 = new ArrayList();
      Iterator var24 = var4.values().iterator();

      while(var24.hasNext()) {
         var27 = (FlagAggregate)var24.next();
         var23.add(new Flag(var27.chunkKey, var27.score));
      }

      this.flags = List.copyOf(var23);
      this.zones = this.buildZones(var23, var4);
      this.fireAlerts(var1);
   }

   private void trimRememberedScores(class_310 var1) {
      if (this.scores.size() > 8192) {
         class_1923 var2 = var1.field_1724.method_31476();
         ArrayList var3 = new ArrayList(this.scores.keySet());
         var3.sort(Comparator.comparingLong((var1x) -> {
            long var2xx = (long)class_1923.method_8325(var1x) - (long)var2.field_9181;
            long var4x = (long)class_1923.method_8332(var1x) - (long)var2.field_9180;
            return var2xx * var2xx + var4x * var4x;
         }));

         for(int var4 = 8192; var4 < var3.size(); ++var4) {
            long var5 = (Long)var3.get(var4);
            this.scores.remove(var5);
            this.alertedChunks.remove(var5);
         }
      }

   }

   private List clusterGeodes() {
      ArrayList var2 = new ArrayList();
      HashMap var3 = new HashMap();
      Iterator var3 = this.scores.values().iterator();

      while(var3.hasNext()) {
         ChunkScore var5 = (ChunkScore)var3.next();
         Iterator var5 = var5.amethystCells.iterator();

         while(var5.hasNext()) {
            AmethystEvidence var7 = (AmethystEvidence)var5.next();
            addGlobalEvidence(var2, var3, var7);
         }
      }

      int var36 = var2.size();
      if (var36 == 0) {
         return List.of();
      } else {
         int[] var37 = new int[var36];

         for(int var1 = 0; var1 < var36; var37[var1] = var1++) {
         }

         HashMap var38 = new HashMap();

         for(int var35 = 0; var35 < var36; ++var35) {
            class_2338 var39 = ((AmethystEvidence)var2.get(var35)).pos();
            EvidenceBucket var8 = bucket(var39, 12);

            for(int var9 = -1; var9 <= 1; ++var9) {
               for(int var10 = -1; var10 <= 1; ++var10) {
                  for(int var11 = -1; var11 <= 1; ++var11) {
                     List var12 = (List)var38.get(new EvidenceBucket(var8.x() + var9, var8.y() + var10, var8.z() + var11));
                     if (var12 != null) {
                        Iterator var14 = var12.iterator();

                        while(var14.hasNext()) {
                           int var14 = (Integer)var14.next();
                           class_2338 var15 = ((AmethystEvidence)var2.get(var14)).pos();
                           int var16 = Math.max(Math.abs(var39.method_10263() - var15.method_10263()), Math.max(Math.abs(var39.method_10264() - var15.method_10264()), Math.abs(var39.method_10260() - var15.method_10260())));
                           if (var16 <= 12) {
                              var37[find(var37, var35)] = find(var37, var14);
                           }
                        }
                     }
                  }
               }
            }

            ((List)var38.computeIfAbsent(var8, (var0) -> {
               return new ArrayList();
            })).add(var35);
         }

         HashMap var40 = new HashMap();

         for(int var41 = 0; var41 < var36; ++var41) {
            ((List)var40.computeIfAbsent(find(var37, var41), (var0) -> {
               return new ArrayList();
            })).add((AmethystEvidence)var2.get(var41));
         }

         ArrayList var42 = new ArrayList();
         Iterator var42 = var40.values().iterator();

         while(var42.hasNext()) {
            List var44 = (List)var42.next();
            HashSet var45 = new HashSet();
            double var46 = 0.0;
            double var47 = 0.0;
            double var48 = 0.0;
            double var18 = 0.0;

            AmethystEvidence var21;
            for(Iterator var20 = var44.iterator(); var20.hasNext(); var18 += var21.weight()) {
               var21 = (AmethystEvidence)var20.next();
               class_2338 var22 = var21.pos();
               var45.add(class_1923.method_8331(var22.method_10263() >> 4, var22.method_10260() >> 4));
               var46 += ((double)var22.method_10263() + 0.5) * var21.weight();
               var47 += ((double)var22.method_10264() + 0.5) * var21.weight();
               var48 += ((double)var22.method_10260() + 0.5) * var21.weight();
            }

            double var49 = Math.max(1.0, var18);
            double var50 = var46 / var49;
            double var24 = var47 / var49;
            double var26 = var48 / var49;
            GeodeShape var28 = geodeFullness(var44, var50, var24, var26, var18);
            double var29 = var28.fullness();
            double var31 = var28.multiplier();
            double var33 = Math.min(var18 * var31, 512.0);
            var42.add(new Geode(List.copyOf(var44), Set.copyOf(var45), var33, var50, var26, var29, var31));
         }

         return var42;
      }
   }

   private static GeodeShape geodeFullness(List var0, double var1, double var3, double var5, double var7) {
      if (var0.size() < 4) {
         return new GeodeShape(0.0, 1.0);
      } else {
         byte var9 = 0;
         int var10 = 0;
         int var11 = 0;
         int var12 = Integer.MAX_VALUE;
         int var13 = Integer.MAX_VALUE;
         int var14 = Integer.MAX_VALUE;
         int var15 = Integer.MIN_VALUE;
         int var16 = Integer.MIN_VALUE;
         int var17 = Integer.MIN_VALUE;
         Iterator var18 = var0.iterator();

         double var23;
         double var25;
         while(var18.hasNext()) {
            AmethystEvidence var19 = (AmethystEvidence)var18.next();
            class_2338 var20 = var19.pos();
            var12 = Math.min(var12, var20.method_10263());
            var13 = Math.min(var13, var20.method_10264());
            var14 = Math.min(var14, var20.method_10260());
            var15 = Math.max(var15, var20.method_10263());
            var16 = Math.max(var16, var20.method_10264());
            var17 = Math.max(var17, var20.method_10260());
            double var21 = (double)var20.method_10263() + 0.5 - var1;
            var23 = (double)var20.method_10264() + 0.5 - var3;
            var25 = (double)var20.method_10260() + 0.5 - var5;
            if (var21 >= 1.5) {
               var9 = (byte)(var9 | 1);
            }

            if (var21 <= -1.5) {
               var9 = (byte)(var9 | 2);
            }

            if (var23 >= 1.5) {
               var9 = (byte)(var9 | 4);
            }

            if (var23 <= -1.5) {
               var9 = (byte)(var9 | 8);
            }

            if (var25 >= 1.5) {
               var9 = (byte)(var9 | 16);
            }

            if (var25 <= -1.5) {
               var9 = (byte)(var9 | 32);
            }

            int var91;
            if (Math.abs(var21) >= 1.0 && Math.abs(var23) >= 1.0 && Math.abs(var25) >= 1.0) {
               var91 = (var21 >= 0.0 ? 1 : 0) | (var23 >= 0.0 ? 2 : 0) | (var25 >= 0.0 ? 4 : 0);
               var10 |= 1 << var91;
            }

            if (Math.abs(var21) >= 1.0 && Math.abs(var25) >= 1.0) {
               var91 = (var21 >= 0.0 ? 1 : 0) | (var25 >= 0.0 ? 2 : 0);
               var11 |= 1 << var91;
            }
         }

         double var87 = (double)Integer.bitCount(var9) / 6.0;
         double var88 = (double)Integer.bitCount(var10) / 8.0;
         int var22 = Math.min(var15 - var12 + 1, Math.min(var16 - var13 + 1, var17 - var14 + 1));
         var23 = Math.clamp((double)var22 / 8.0, 0.0, 1.0);
         var25 = Math.clamp(var7 / 54.0, 0.0, 1.0);
         double var92 = var87 * 0.35 + var88 * 0.35 + var23 * 0.2 + var25 * 0.1;
         double var29 = Math.clamp((var92 - 0.3) / 0.7, 0.0, 1.0);
         int var31 = var9 & 51;
         double var32 = (double)Integer.bitCount(var31) / 4.0;
         double var34 = (double)Integer.bitCount(var11) / 4.0;
         int var36 = Math.min(var15 - var12 + 1, var17 - var14 + 1);
         int var37 = var16 - var13 + 1;
         double var38 = Math.clamp((double)var36 / 8.0, 0.0, 1.0);
         double var40 = Math.clamp((double)var37 / 5.0, 0.0, 1.0);
         double var42 = Math.clamp(var7 / 36.0, 0.0, 1.0);
         double var44 = (double)var13 + (double)(var16 - var13) * 0.55;
         double var46 = 0.0;
         double var48 = 0.0;
         int var50 = 0;
         int var51 = 0;
         int var52 = 0;
         byte var53 = 0;
         int var54 = 0;
         int var55 = 0;
         double var56 = 0.0;
         int var58 = Integer.MAX_VALUE;
         int var59 = Integer.MAX_VALUE;
         int var60 = Integer.MIN_VALUE;
         int var61 = Integer.MIN_VALUE;
         double var62 = (double)var13 + (double)(var16 - var13) * 0.55;
         Iterator var64 = var0.iterator();

         int var73;
         while(var64.hasNext()) {
            AmethystEvidence var65 = (AmethystEvidence)var64.next();
            class_2338 var66 = var65.pos();
            double var67 = (double)var66.method_10263() + 0.5 - var1;
            double var69 = (double)var66.method_10260() + 0.5 - var5;
            double var71 = Math.hypot(var67, var69);
            if ((double)var66.method_10264() > var44) {
               var46 += var71;
               ++var50;
            } else {
               var48 += var71;
               ++var51;
            }

            if ((double)var66.method_10264() >= var62 && var65.weight() >= 2.0) {
               ++var55;
               var56 += var65.weight();
               var58 = Math.min(var58, var66.method_10263());
               var59 = Math.min(var59, var66.method_10260());
               var60 = Math.max(var60, var66.method_10263());
               var61 = Math.max(var61, var66.method_10260());
               if (var67 >= 1.5) {
                  var53 = (byte)(var53 | 1);
               }

               if (var67 <= -1.5) {
                  var53 = (byte)(var53 | 2);
               }

               if (var69 >= 1.5) {
                  var53 = (byte)(var53 | 4);
               }

               if (var69 <= -1.5) {
                  var53 = (byte)(var53 | 8);
               }

               if (Math.abs(var67) >= 1.0 && Math.abs(var69) >= 1.0) {
                  var73 = (var67 >= 0.0 ? 1 : 0) | (var69 >= 0.0 ? 2 : 0);
                  var54 |= 1 << var73;
               }
            }

            if (var66.method_10264() <= var13 + 2 && !(Math.abs(var67) < 1.0) && !(Math.abs(var69) < 1.0)) {
               var73 = (var67 >= 0.0 ? 1 : 0) | (var69 >= 0.0 ? 2 : 0);
               var52 |= 1 << var73;
            }
         }

         double var93 = (double)Integer.bitCount(var52) / 4.0;
         double var94 = 0.0;
         double var95;
         double var96;
         if (var50 > 0 && var51 > 0) {
            var95 = var46 / (double)var50;
            var96 = var48 / (double)var51;
            var94 = Math.clamp((var96 - var95) / Math.max(2.0, (double)var36 * 0.25), 0.0, 1.0);
         }

         var95 = var32 * 0.2 + var34 * 0.25 + var38 * 0.15 + var40 * 0.1 + var42 * 0.15 + var93 * 0.1 + var94 * 0.05;
         var96 = Math.clamp((var95 - 0.5) / 0.4, 0.0, 1.0);
         int var72 = var55 == 0 ? 0 : var60 - var58 + 1;
         var73 = var55 == 0 ? 0 : var61 - var59 + 1;
         double var74 = Math.clamp((double)Math.min(var72, var73) / 8.0, 0.0, 1.0);
         double var76 = Math.clamp(var56 / 18.0, 0.0, 1.0);
         int var78 = Integer.bitCount(var53);
         int var79 = Integer.bitCount(var54);
         boolean var80 = false;

         for(int var81 = 0; var81 < 3 && !var80; ++var81) {
            var80 = isConvincingHalfShell(var0, var1, var3, var5, var81, -1) || isConvincingHalfShell(var0, var1, var3, var5, var81, 1);
         }

         if (var80) {
            var96 = Math.max(var96, 0.92);
         }

         boolean var99 = var55 >= 6 && var78 == 4 && var79 == 4 && var74 >= 1.0 && var76 >= 1.0 && var40 >= 0.6;
         boolean var82 = var55 >= 5 && var78 >= 3 && var79 >= 3 && var74 >= 1.0 && var76 >= 0.85 && var40 >= 0.6 && var95 >= 0.6;
         if (var99 || var82) {
            var96 = 1.0;
         }

         double var83 = Math.max(var29, var96);
         double var85 = 1.0 + Math.pow(var83, 1.5);
         if (var80 && !var99) {
            var85 = Math.max(var85, 2.0);
         }

         return new GeodeShape(var83, var85);
      }
   }

   private static boolean isConvincingHalfShell(List var0, double var1, double var3, double var5, int var7, int var8) {
      double var9 = Double.POSITIVE_INFINITY;
      double var11 = Double.NEGATIVE_INFINITY;

      double var59;
      for(Iterator var13 = var0.iterator(); var13.hasNext(); var11 = Math.max(var11, var59)) {
         AmethystEvidence var14 = (AmethystEvidence)var13.next();
         var59 = coordinate(var14.pos(), var7);
         var9 = Math.min(var9, var59);
      }

      if (var11 - var9 < 3.0) {
         return false;
      } else {
         double var58 = var8 > 0 ? var9 + (var11 - var9) * 0.55 : var9 + (var11 - var9) * 0.45;
         var59 = var8 > 0 ? var9 + (var11 - var9) * 0.45 : var9 + (var11 - var9) * 0.55;
         int var17 = (var7 + 1) % 3;
         int var18 = (var7 + 2) % 3;
         double var19 = var17 == 0 ? var1 : (var17 == 1 ? var3 : var5);
         double var21 = var18 == 0 ? var1 : (var18 == 1 ? var3 : var5);
         byte var23 = 0;
         int var24 = 0;
         int var25 = 0;
         double var26 = 0.0;
         double var28 = 0.0;
         double var30 = Double.POSITIVE_INFINITY;
         double var32 = Double.NEGATIVE_INFINITY;
         double var34 = Double.POSITIVE_INFINITY;
         double var36 = Double.NEGATIVE_INFINITY;
         double var38 = Double.POSITIVE_INFINITY;
         double var40 = Double.NEGATIVE_INFINITY;
         Iterator var42 = var0.iterator();

         while(var42.hasNext()) {
            AmethystEvidence var43 = (AmethystEvidence)var42.next();
            if (!(var43.weight() < 2.0)) {
               class_2338 var44 = var43.pos();
               double var45 = coordinate(var44, var7);
               boolean var47 = var8 > 0 ? var45 >= var58 : var45 <= var58;
               boolean var48 = var8 > 0 ? var45 <= var59 : var45 >= var59;
               if (var48) {
                  var28 += var43.weight();
               }

               if (var47) {
                  ++var25;
                  var26 += var43.weight();
                  var38 = Math.min(var38, var45);
                  var40 = Math.max(var40, var45);
                  double var49 = coordinate(var44, var17);
                  double var51 = coordinate(var44, var18);
                  var30 = Math.min(var30, var49);
                  var32 = Math.max(var32, var49);
                  var34 = Math.min(var34, var51);
                  var36 = Math.max(var36, var51);
                  double var53 = var49 + 0.5 - var19;
                  double var55 = var51 + 0.5 - var21;
                  if (var53 >= 1.5) {
                     var23 = (byte)(var23 | 1);
                  }

                  if (var53 <= -1.5) {
                     var23 = (byte)(var23 | 2);
                  }

                  if (var55 >= 1.5) {
                     var23 = (byte)(var23 | 4);
                  }

                  if (var55 <= -1.5) {
                     var23 = (byte)(var23 | 8);
                  }

                  if (Math.abs(var53) >= 1.0 && Math.abs(var55) >= 1.0) {
                     int var57 = (var53 >= 0.0 ? 1 : 0) | (var55 >= 0.0 ? 2 : 0);
                     var24 |= 1 << var57;
                  }
               }
            }
         }

         if (var25 == 0) {
            return false;
         } else {
            double var60 = var32 - var30 + 1.0;
            double var61 = var36 - var34 + 1.0;
            double var46 = var40 - var38 + 1.0;
            double var62 = Math.clamp(Math.min(var60, var61) / 8.0, 0.0, 1.0);
            double var50 = Math.clamp(var26 / 18.0, 0.0, 1.0);
            boolean var52 = var28 <= var26 * 0.5;
            return var25 >= 5 && Integer.bitCount(var23) >= 3 && Integer.bitCount(var24) >= 3 && var62 >= 0.85 && var50 >= 0.8 && var46 >= 2.0 && var52;
         }
      }
   }

   private static double coordinate(class_2338 var0, int var1) {
      double var10000;
      switch (var1) {
         case 0:
            var10000 = (double)var0.method_10263();
            break;
         case 1:
            var10000 = (double)var0.method_10264();
            break;
         default:
            var10000 = (double)var0.method_10260();
      }

      return var10000;
   }

   private static void addGlobalEvidence(List var0, Map var1, AmethystEvidence var2) {
      EvidenceBucket var3 = bucket(var2.pos(), 4);

      int var4;
      for(var4 = -1; var4 <= 1; ++var4) {
         for(int var5 = -1; var5 <= 1; ++var5) {
            for(int var6 = -1; var6 <= 1; ++var6) {
               List var7 = (List)var1.get(new EvidenceBucket(var3.x() + var4, var3.y() + var5, var3.z() + var6));
               if (var7 != null) {
                  Iterator var8 = var7.iterator();

                  while(var8.hasNext()) {
                     int var9 = (Integer)var8.next();
                     AmethystEvidence var10 = (AmethystEvidence)var0.get(var9);
                     class_2338 var11 = var10.pos();
                     class_2338 var12 = var2.pos();
                     int var13 = Math.max(Math.abs(var11.method_10263() - var12.method_10263()), Math.max(Math.abs(var11.method_10264() - var12.method_10264()), Math.abs(var11.method_10260() - var12.method_10260())));
                     if (var13 < 4) {
                        if (var2.weight() > var10.weight()) {
                           var0.set(var9, new AmethystEvidence(var10.pos(), var2.weight()));
                        }

                        return;
                     }
                  }
               }
            }
         }
      }

      var4 = var0.size();
      var0.add(var2);
      ((List)var1.computeIfAbsent(var3, (var0x) -> {
         return new ArrayList();
      })).add(var4);
   }

   private static EvidenceBucket bucket(class_2338 var0, int var1) {
      return new EvidenceBucket(Math.floorDiv(var0.method_10263(), var1), Math.floorDiv(var0.method_10264(), var1), Math.floorDiv(var0.method_10260(), var1));
   }

   private static int find(int[] var0, int var1) {
      while(var0[var1] != var1) {
         var0[var1] = var0[var0[var1]];
         var1 = var0[var1];
      }

      return var1;
   }

   private List buildZones(List var1, Map var2) {
      int var3 = Math.max(1, this.module.mergeRadius.getInt());
      HashMap var4 = new HashMap();
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         Flag var6 = (Flag)var5.next();
         var4.put(var6.chunkKey(), var6);
      }

      ArrayList var17 = new ArrayList();
      HashSet var18 = new HashSet();
      Iterator var7 = var1.iterator();

      while(true) {
         Flag var8;
         do {
            if (!var7.hasNext()) {
               var17.sort(Comparator.comparingDouble(Zone::totalScore).reversed());
               return var17;
            }

            var8 = (Flag)var7.next();
         } while(!var18.add(var8.chunkKey()));

         ArrayList var9 = new ArrayList();
         ArrayDeque var10 = new ArrayDeque(List.of(var8));

         while(!var10.isEmpty()) {
            Flag var11 = (Flag)var10.poll();
            var9.add(var11);
            int var12 = class_1923.method_8325(var11.chunkKey());
            int var13 = class_1923.method_8332(var11.chunkKey());

            for(int var14 = -var3; var14 <= var3; ++var14) {
               for(int var15 = -var3; var15 <= var3; ++var15) {
                  Flag var16;
                  if ((var14 != 0 || var15 != 0) && (var16 = (Flag)var4.get(class_1923.method_8331(var12 + var14, var13 + var15))) != null && var18.add(var16.chunkKey())) {
                     var10.add(var16);
                  }
               }
            }
         }

         var17.add(this.makeZone(var9, var2));
      }
   }

   private Zone makeZone(List var1, Map var2) {
      HashSet var3 = new HashSet();
      double var4 = 0.0;
      double var6 = 0.0;
      double var8 = 0.0;
      double var10 = 0.0;
      double var12 = 0.0;
      double var14 = 0.0;
      double var16 = 0.0;

      Flag var19;
      for(Iterator var18 = var1.iterator(); var18.hasNext(); var16 += (double)(class_1923.method_8332(var19.chunkKey()) * 16 + 8) * var19.score()) {
         var19 = (Flag)var18.next();
         var3.add(var19.chunkKey());
         var4 += var19.score();
         var6 = Math.max(var6, var19.score());
         FlagAggregate var20 = (FlagAggregate)var2.get(var19.chunkKey());
         if (var20 != null && var20.hitWeight > 0.0) {
            var8 += var20.hitWeight;
            var10 += var20.hitX;
            var12 += var20.hitZ;
         }

         var14 += (double)(class_1923.method_8325(var19.chunkKey()) * 16 + 8) * var19.score();
      }

      double var22 = var8 > 0.0 ? var10 / var8 : var14 / var4;
      double var23 = var8 > 0.0 ? var12 / var8 : var16 / var4;
      return new Zone(Set.copyOf(var3), var22, var23, var4, var6);
   }

   private void fireAlerts(class_310 var1) {
      Iterator var2 = this.zones.iterator();

      while(true) {
         while(var2.hasNext()) {
            Zone var3 = (Zone)var2.next();
            boolean var4 = true;
            Iterator var5 = var3.members().iterator();

            while(var5.hasNext()) {
               long var6 = (Long)var5.next();
               if (this.alertedChunks.contains(var6)) {
                  var4 = false;
                  break;
               }
            }

            if (!var4) {
               this.alertedChunks.addAll(var3.members());
            } else {
               this.alertedChunks.addAll(var3.members());
               if (!this.module.notifications.is(Deobf.decrypt("9\f4"))) {
                  int var9 = (int)Math.round(var3.centroidX());
                  int var10 = (int)Math.round(var3.centroidZ());
                  int var7 = (int)Math.hypot((double)var9 - var1.field_1724.method_23317(), (double)var10 - var1.field_1724.method_23321());
                  String var8 = "Sus zone · " + var7 + "m · " + var9 + ", " + var10;
                  if (this.module.notifications.is(Deobf.decrypt("\"\u00053V|")) && VulxtsClient.notifications() != null) {
                     VulxtsClient.notifications().pushInfo(var8);
                     UiSounds.notification(true);
                  } else if (this.module.notifications.is(Deobf.decrypt("5\u00023Q"))) {
                     var1.field_1724.method_7353(class_2561.method_43470("§d[Vulxts] §f" + var8), false);
                  }
               }
            }
         }

         return;
      }
   }

   public static final class ChunkScore {
      public final long chunkKey;
      public final EnumMap hits = new EnumMap(SignalType.class);
      public final List amethystCells = new ArrayList();
      public double score;
      double hitWeight;
      double hitX;
      double hitZ;

      ChunkScore(long var1) {
         this.chunkKey = var1;
      }

      void add(SignalType var1, class_2338 var2) {
         this.hits.merge(var1, 1, Integer::sum);
         this.hitWeight += var1.weight;
         this.hitX += ((double)var2.method_10263() + 0.5) * var1.weight;
         this.hitZ += ((double)var2.method_10260() + 0.5) * var1.weight;
      }

      void computeScore() {
         double var1 = 0.0;

         Map.Entry var4;
         for(Iterator var3 = this.hits.entrySet().iterator(); var3.hasNext(); var1 += ((SignalType)var4.getKey()).weight * (double)Math.min((Integer)var4.getValue(), ((SignalType)var4.getKey()).cap)) {
            var4 = (Map.Entry)var3.next();
         }

         this.score = var1;
      }
   }

   public static enum SignalType {
      AMETHYST(2.0, 64),
      KELP(2.0, 6),
      BAMBOO(2.0, 6),
      BERRIES(2.0, 5),
      VINES(2.0, 6),
      DRIPSTONE(2.0, 5);

      public final double weight;
      public final int cap;

      private SignalType(double nullxx, int nullxxx) {
         this.weight = nullxx;
         this.cap = nullxxx;
      }

      // $FF: synthetic method
      private static SignalType[] $values() {
         return new SignalType[]{AMETHYST, KELP, BAMBOO, BERRIES, VINES, DRIPSTONE};
      }
   }

   public static record AmethystEvidence(class_2338 pos, double weight) {
      public AmethystEvidence(class_2338 pos, double weight) {
         this.pos = pos;
         this.weight = weight;
      }

      public class_2338 pos() {
         return this.pos;
      }

      public double weight() {
         return this.weight;
      }
   }

   private static final class FlagAggregate {
      final long chunkKey;
      double score;
      double hitWeight;
      double hitX;
      double hitZ;

      FlagAggregate(long var1) {
         this.chunkKey = var1;
      }
   }

   public static record Geode(List cells, Set chunks, double score, double centroidX, double centroidZ, double fullness, double fullnessMultiplier) {
      public Geode(List cells, Set chunks, double score, double centroidX, double centroidZ, double fullness, double fullnessMultiplier) {
         this.cells = cells;
         this.chunks = chunks;
         this.score = score;
         this.centroidX = centroidX;
         this.centroidZ = centroidZ;
         this.fullness = fullness;
         this.fullnessMultiplier = fullnessMultiplier;
      }

      public List cells() {
         return this.cells;
      }

      public Set chunks() {
         return this.chunks;
      }

      public double score() {
         return this.score;
      }

      public double centroidX() {
         return this.centroidX;
      }

      public double centroidZ() {
         return this.centroidZ;
      }

      public double fullness() {
         return this.fullness;
      }

      public double fullnessMultiplier() {
         return this.fullnessMultiplier;
      }
   }

   public static record Flag(long chunkKey, double score) {
      public Flag(long chunkKey, double score) {
         this.chunkKey = chunkKey;
         this.score = score;
      }

      public long chunkKey() {
         return this.chunkKey;
      }

      public double score() {
         return this.score;
      }
   }

   private static record EvidenceBucket(int x, int y, int z) {
      private EvidenceBucket(int x, int y, int z) {
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

   private static record GeodeShape(double fullness, double multiplier) {
      private GeodeShape(double fullness, double multiplier) {
         this.fullness = fullness;
         this.multiplier = multiplier;
      }

      public double fullness() {
         return this.fullness;
      }

      public double multiplier() {
         return this.multiplier;
      }
   }

   public static record Zone(Set members, double centroidX, double centroidZ, double totalScore, double maxScore) {
      public Zone(Set members, double centroidX, double centroidZ, double totalScore, double maxScore) {
         this.members = members;
         this.centroidX = centroidX;
         this.centroidZ = centroidZ;
         this.totalScore = totalScore;
         this.maxScore = maxScore;
      }

      public Set members() {
         return this.members;
      }

      public double centroidX() {
         return this.centroidX;
      }

      public double centroidZ() {
         return this.centroidZ;
      }

      public double totalScore() {
         return this.totalScore;
      }

      public double maxScore() {
         return this.maxScore;
      }
   }
}
