package dev.vulxts.render;

import dev.vulxts.module.impl.StorageEspModule;
import dev.vulxts.rt.Deobf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_2248;
import net.minecraft.class_2260;
import net.minecraft.class_2281;
import net.minecraft.class_2315;
import net.minecraft.class_2336;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2363;
import net.minecraft.class_2377;
import net.minecraft.class_243;
import net.minecraft.class_2480;
import net.minecraft.class_2496;
import net.minecraft.class_2531;
import net.minecraft.class_2680;
import net.minecraft.class_2745;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_310;
import net.minecraft.class_3708;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.joml.Vector3fc;

public final class StorageEspRenderer {
   private static final int MAX_CHUNK_RADIUS = 32;
   private static final int MAX_RESULTS = 6000;
   private static final int MAX_PENDING_CHUNKS = 512;
   private static final int PENDING_CHUNKS_PER_TICK = 12;
   private static final int PACKET_RESCAN_PASSES = 6;
   private static final int RETAIN_TICKS = 400;
   private static final float BOX_INFLATE = 0.002F;
   private static final double CHEST_INSET = 0.0625;
   private static final int INTERACTED_RGB = 6579300;
   private static final float LINE_WIDTH = 1.0F;
   private static final float TRACER_WIDTH = 1.15F;
   private static final int TRACER_ALPHA = 180;
   private static final IncrementalScan SCAN = new IncrementalScan(48, 80000, 20);
   private static final Map retainedUntil = new LinkedHashMap();
   private static final Map pendingChunks = new LinkedHashMap();
   private static final Object PENDING_CHUNKS_LOCK = new Object();
   private static volatile List retained = List.of();
   private static int retentionTick;
   private static StorageEspModule lastModule;
   private static class_638 scanLevel;

   private StorageEspRenderer() {
   }

   public static void clear() {
      SCAN.clear();
      retainedUntil.clear();
      synchronized(PENDING_CHUNKS_LOCK) {
         pendingChunks.clear();
      }

      retained = List.of();
      retentionTick = 0;
      if (lastModule != null) {
         lastModule.clearInteractions();
         lastModule = null;
      }

      scanLevel = null;
   }

   public static int cachedCount() {
      return retained.size();
   }

   public static long cachedShulkerCount() {
      return retained.stream().filter((var0) -> {
         return var0.type() == StorageEspModule.StorageType.SHULKER;
      }).count();
   }

   public static void markDirty() {
      SCAN.markDirty();
   }

   public static void markChunkDirty(int var0, int var1) {
      ChunkPos var2 = new ChunkPos(var0, var1);
      synchronized(PENDING_CHUNKS_LOCK) {
         if (pendingChunks.containsKey(var2) || pendingChunks.size() < 512) {
            pendingChunks.put(var2, 6);
         }

      }
   }

   public static void scan(StorageEspModule var0) {
      class_638 var1 = class_310.method_1551().field_1687;
      if (scanLevel != var1) {
         clear();
         scanLevel = var1;
      }

      lastModule = var0;
      double var2 = (Double)var0.range.get();
      double var4 = var2 * var2;
      int var6 = (int)Math.ceil(var2 / 16.0) + 1;
      int var7 = Math.min(32, var6);
      ++retentionTick;
      scanPendingChunks();
      SCAN.tick(var7, (var2x, var3) -> {
         return scanChunk(var2x, var4, var3);
      });
      refreshRetained();
   }

   private static void refreshRetained() {
      Iterator var2 = SCAN.get().iterator();

      while(var2.hasNext()) {
         Hit var1 = (Hit)var2.next();
         retain(var1, false);
      }

      var2 = retainedUntil.entrySet().iterator();

      while(var2.hasNext()) {
         if ((Integer)((Map.Entry)var2.next()).getValue() <= retentionTick) {
            var2.remove();
         }
      }

      retained = List.copyOf(retainedUntil.keySet());
   }

   private static void scanPendingChunks() {
      class_310 var0 = class_310.method_1551();
      if (var0.field_1687 != null) {
         ArrayList var1 = new ArrayList();
         Iterator var3;
         synchronized(PENDING_CHUNKS_LOCK) {
            var3 = pendingChunks.entrySet().iterator();

            while(var3.hasNext() && var1.size() < 12) {
               Map.Entry var4 = (Map.Entry)var3.next();
               var1.add(new PendingChunk((ChunkPos)var4.getKey(), (Integer)var4.getValue()));
               var3.remove();
            }
         }

         if (!var1.isEmpty()) {
            ArrayList var14 = new ArrayList();
            var3 = var1.iterator();

            while(var3.hasNext()) {
               PendingChunk var17 = (PendingChunk)var3.next();
               ChunkPos var5 = var17.pos();
               int var6 = var17.passes();
               class_2818 var7 = var0.field_1687.method_2935().method_12126(var5.x(), var5.z(), false);
               if (var7 != null) {
                  ArrayList var8 = new ArrayList();
                  scanChunk(var7, 0.0, var8, false);
                  if (!var8.isEmpty() || var6 == 1) {
                     retainedUntil.keySet().removeIf((var1x) -> {
                        return var1x.x() >> 4 == var5.x() && var1x.z() >> 4 == var5.z();
                     });
                     Iterator var9 = var8.iterator();

                     while(var9.hasNext()) {
                        Hit var10 = (Hit)var9.next();
                        retain(var10, true);
                     }
                  }
               }

               if (var6 > 1) {
                  var14.add(new PendingChunk(var5, var6 - 1));
               }
            }

            synchronized(PENDING_CHUNKS_LOCK) {
               Iterator var14 = var14.iterator();

               while(var14.hasNext()) {
                  PendingChunk var19 = (PendingChunk)var14.next();
                  pendingChunks.merge(var19.pos(), var19.passes(), Math::max);
               }
            }
         }
      }

   }

   private static void retain(Hit var0, boolean var1) {
      if (retainedUntil.containsKey(var0)) {
         retainedUntil.put(var0, retentionTick + 400);
      } else {
         if (retainedUntil.size() >= 6000) {
            if (!var1) {
               return;
            }

            Iterator var2 = retainedUntil.keySet().iterator();
            if (var2.hasNext()) {
               var2.next();
               var2.remove();
            }
         }

         retainedUntil.put(var0, retentionTick + 400);
      }

   }

   private static int scanChunk(class_2818 var0, double var1, List var3) {
      return scanChunk(var0, var1, var3, true);
   }

   private static int scanChunk(class_2818 var0, double var1, List var3, boolean var4) {
      class_746 var5 = class_310.method_1551().field_1724;
      if (var5 == null) {
         return 0;
      } else {
         class_2826[] var6 = var0.method_12006();
         int var7 = var0.method_32891();
         int var8 = var0.method_12004().method_8326();
         int var9 = var0.method_12004().method_8328();
         short var10 = 0;
         if (var3.size() >= 6000) {
            return 0;
         } else {
            for(int var11 = 0; var11 < var6.length; ++var11) {
               class_2826 var12 = var6[var11];
               if (!var12.method_38292() && var12.method_19523(StorageEspRenderer::isStorage)) {
                  int var13 = var7 + var11 << 4;
                  var10 = (short)(var10 + 4096);

                  for(int var14 = 0; var14 < 16; ++var14) {
                     for(int var15 = 0; var15 < 16; ++var15) {
                        for(int var16 = 0; var16 < 16; ++var16) {
                           int var17 = var8 + var16;
                           int var18 = var13 + var14;
                           int var19 = var9 + var15;
                           class_2680 var20 = var12.method_12254(var16, var14, var15);
                           StorageEspModule.StorageType var21 = classify(var20.method_26204());
                           double var22 = (double)var17 + 0.5 - var5.method_23317();
                           double var24 = (double)var19 + 0.5 - var5.method_23321();
                           if (var21 != null && (!var4 || !(var22 * var22 + var24 * var24 > var1)) && !isSecondaryChestHalf(var20, var17, var18, var19)) {
                              var3.add(new Hit(var17, var18, var19, var21));
                              if (var3.size() >= 6000) {
                                 return var10;
                              }
                           }
                        }
                     }
                  }
               }
            }

            return var10;
         }
      }
   }

   public static void render(class_4597.class_4598 var0, class_4587 var1, class_243 var2, StorageEspModule var3) {
      List var4 = retained;
      if (!var4.isEmpty()) {
         class_310 var5 = class_310.method_1551();
         class_638 var6 = var5.field_1687;
         if (var6 != null) {
            boolean var7 = var3.mode.is(Deobf.decrypt("0\u001f>I"));
            int var8 = Math.max(0, Math.min(255, var3.highlightAlpha.getInt())) << 24;
            boolean var9 = (Boolean)var3.tracers.get();
            boolean var10 = var3.hideOpened();
            Vector3fc var11 = var5.field_1773.method_19418().method_19335();
            Iterator var12 = var4.iterator();

            while(true) {
               Hit var13;
               StorageEspModule.StorageType var15;
               boolean var14;
               do {
                  do {
                     if (!var12.hasNext()) {
                        EspBoxRenderer.flush(var0);
                        return;
                     }

                     var13 = (Hit)var12.next();
                     var15 = var13.type();
                  } while(!var3.isTypeEnabled(var15));
               } while((var14 = var3.isInteracted(var13.x(), var13.y(), var13.z())) && var10);

               int var16 = var14 ? 6579300 : var3.colorFor(var15) & 16777215;
               int var17 = var8 | var16;
               double var18 = (double)var13.x();
               double var20 = (double)var13.y();
               double var22 = (double)var13.z();
               double var24 = var18 + 1.0;
               double var26 = var20 + 1.0;
               double var28 = var22 + 1.0;
               if (var15 == StorageEspModule.StorageType.CHEST || var15 == StorageEspModule.StorageType.TRAPPED || var15 == StorageEspModule.StorageType.ENDER) {
                  var18 += 0.0625;
                  var22 += 0.0625;
                  var24 -= 0.0625;
                  var26 -= 0.125;
                  var28 -= 0.0625;
                  class_2680 var30;
                  if ((var15 == StorageEspModule.StorageType.CHEST || var15 == StorageEspModule.StorageType.TRAPPED) && (var30 = var6.method_8320(new class_2338(var13.x(), var13.y(), var13.z()))).method_26204() instanceof class_2281 && var30.method_11654(class_2281.field_10770) != class_2745.field_12569) {
                     class_2350 var32 = (class_2350)var30.method_11654(class_2281.field_10768);
                     class_2745 var33 = (class_2745)var30.method_11654(class_2281.field_10770);
                     class_2350 var31 = var33 == class_2745.field_12574 ? var32.method_10170() : var32.method_10160();
                     if (var31 == class_2350.field_11039) {
                        var18 = (double)var13.x() - 1.0 + 0.0625;
                     } else if (var31 == class_2350.field_11034) {
                        var24 = (double)var13.x() + 2.0 - 0.0625;
                     } else if (var31 == class_2350.field_11043) {
                        var22 = (double)var13.z() - 1.0 + 0.0625;
                     } else if (var31 == class_2350.field_11035) {
                        var28 = (double)var13.z() + 2.0 - 0.0625;
                     }
                  }
               }

               if (var7) {
                  EspBoxRenderer.fill(var0, var1, var2, var18 - 0.0020000000949949026, var20 - 0.0020000000949949026, var22 - 0.0020000000949949026, var24 + 0.0020000000949949026, var26 + 0.0020000000949949026, var28 + 0.0020000000949949026, var17);
               } else {
                  EspBoxRenderer.outline(var0, var1, var2, var18, var20, var22, var24, var26, var28, var17, 1.0F);
               }

               if (var9) {
                  int var35 = -1275068416 | var16;
                  EspBoxRenderer.tracer(var0, var1, var2, var11, (var18 + var24) / 2.0, (var20 + var26) / 2.0, (var22 + var28) / 2.0, var35, 1.15F);
               }
            }
         }
      }

   }

   private static boolean isStorage(class_2680 var0) {
      return classify(var0.method_26204()) != null;
   }

   private static boolean isSecondaryChestHalf(class_2680 var0, int var1, int var2, int var3) {
      if (!(var0.method_26204() instanceof class_2281)) {
         return false;
      } else {
         class_2745 var4 = (class_2745)var0.method_11654(class_2281.field_10770);
         if (var4 == class_2745.field_12569) {
            return false;
         } else {
            class_2350 var5 = (class_2350)var0.method_11654(class_2281.field_10768);
            class_2350 var6 = var4 == class_2745.field_12574 ? var5.method_10170() : var5.method_10160();
            class_2338 var7 = (new class_2338(var1, var2, var3)).method_10093(var6);
            return var1 > var7.method_10263() || var1 == var7.method_10263() && var3 > var7.method_10260();
         }
      }
   }

   private static StorageEspModule.StorageType classify(class_2248 var0) {
      if (var0 instanceof class_2531) {
         return StorageEspModule.StorageType.TRAPPED;
      } else if (var0 instanceof class_2281) {
         return StorageEspModule.StorageType.CHEST;
      } else if (var0 instanceof class_2336) {
         return StorageEspModule.StorageType.ENDER;
      } else if (var0 instanceof class_2480) {
         return StorageEspModule.StorageType.SHULKER;
      } else if (var0 instanceof class_3708) {
         return StorageEspModule.StorageType.BARREL;
      } else if (var0 instanceof class_2496) {
         return StorageEspModule.StorageType.SPAWNER;
      } else if (var0 instanceof class_2377) {
         return StorageEspModule.StorageType.HOPPER;
      } else if (var0 instanceof class_2363) {
         return StorageEspModule.StorageType.FURNACE;
      } else if (var0 instanceof class_2260) {
         return StorageEspModule.StorageType.FURNACE;
      } else {
         return var0 instanceof class_2315 ? StorageEspModule.StorageType.HOPPER : null;
      }
   }

   private static record ChunkPos(int x, int z) {
      private ChunkPos(int x, int z) {
         this.x = x;
         this.z = z;
      }

      public int x() {
         return this.x;
      }

      public int z() {
         return this.z;
      }
   }

   private static record Hit(int x, int y, int z, StorageEspModule.StorageType type) {
      private Hit(int x, int y, int z, StorageEspModule.StorageType type) {
         this.x = x;
         this.y = y;
         this.z = z;
         this.type = type;
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

      public StorageEspModule.StorageType type() {
         return this.type;
      }
   }

   private static record PendingChunk(ChunkPos pos, int passes) {
      private PendingChunk(ChunkPos pos, int passes) {
         this.pos = pos;
         this.passes = passes;
      }

      public ChunkPos pos() {
         return this.pos;
      }

      public int passes() {
         return this.passes;
      }
   }
}
