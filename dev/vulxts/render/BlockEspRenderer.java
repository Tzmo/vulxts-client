package dev.vulxts.render;

import dev.vulxts.module.impl.BlockEspModule;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BlockListSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_2248;
import net.minecraft.class_243;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import org.joml.Vector3fc;

public final class BlockEspRenderer {
   private static final int MAX_CHUNK_RADIUS = 32;
   private static final int MAX_RESULTS = 8000;
   private static final int RETAIN_TICKS = 400;
   private static final double INSET = 0.002;
   private static final IncrementalScan SCAN = new IncrementalScan(48, 80000, 20);
   private static Set lastWanted = Set.of();
   private static final Map retainedUntil = new LinkedHashMap();
   private static final Set pendingChunks = new LinkedHashSet();
   private static final Object PENDING_CHUNKS_LOCK = new Object();
   private static volatile List retained = List.of();
   private static int retentionTick;
   private static long retainedRevision;

   private BlockEspRenderer() {
   }

   public static void clear() {
      SCAN.clear();
      lastWanted = Set.of();
      retainedUntil.clear();
      synchronized(PENDING_CHUNKS_LOCK) {
         pendingChunks.clear();
      }

      retained = List.of();
      retentionTick = 0;
      ++retainedRevision;
   }

   public static int cachedCount() {
      return retained.size();
   }

   public static List snapshotHits() {
      return retained;
   }

   public static long revision() {
      return retainedRevision;
   }

   public static void markDirty() {
      SCAN.markDirty();
   }

   public static void markChunkDirty(int var0, int var1) {
      synchronized(PENDING_CHUNKS_LOCK) {
         if (pendingChunks.size() < 512) {
            pendingChunks.add(new ChunkPos(var0, var1));
         }

      }
   }

   public static void scan(BlockEspModule var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.targets.targets().iterator();

      while(var2.hasNext()) {
         BlockListSetting.Target var3 = (BlockListSetting.Target)var2.next();
         if ((Boolean)var3.enabled.get() && var3.block() != null) {
            var1.add(var3.block());
         }
      }

      if (var1.isEmpty()) {
         SCAN.clear();
         lastWanted = Set.of();
         clearRetained();
      } else {
         if (!var1.equals(lastWanted)) {
            lastWanted = var1;
            SCAN.markDirty();
            clearRetained();
         }

         int var4 = var0.rangeExtraChunks.getInt();
         int var5 = Math.min(32, (Integer)class_310.method_1551().field_1690.method_42503().method_41753() + var4);
         ++retentionTick;
         scanPendingChunks(var1);
         SCAN.tick(var5, (var1x, var2x) -> {
            return scanChunk(var1x, var1, var2x);
         });
         refreshRetained();
      }

   }

   private static void clearRetained() {
      retainedUntil.clear();
      synchronized(PENDING_CHUNKS_LOCK) {
         pendingChunks.clear();
      }

      retained = List.of();
      retentionTick = 0;
      ++retainedRevision;
   }

   private static void refreshRetained() {
      Iterator var2 = SCAN.get().iterator();

      while(true) {
         Hit var1;
         do {
            if (!var2.hasNext()) {
               var2 = retainedUntil.entrySet().iterator();

               while(var2.hasNext()) {
                  if ((Integer)((Map.Entry)var2.next()).getValue() <= retentionTick) {
                     var2.remove();
                  }
               }

               List var3 = List.copyOf(retainedUntil.keySet());
               if (!var3.equals(retained)) {
                  retained = var3;
                  ++retainedRevision;
               }

               return;
            }

            var1 = (Hit)var2.next();
         } while(!retainedUntil.containsKey(var1) && retainedUntil.size() >= 8000);

         retainedUntil.put(var1, retentionTick + 400);
      }
   }

   private static void scanPendingChunks(Set var0) {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1687 != null) {
         ArrayList var2 = new ArrayList();
         Iterator var4;
         synchronized(PENDING_CHUNKS_LOCK) {
            var4 = pendingChunks.iterator();

            while(var4.hasNext() && var2.size() < 4) {
               var2.add((ChunkPos)var4.next());
               var4.remove();
            }
         }

         if (!var2.isEmpty()) {
            ArrayList var13 = new ArrayList();
            var4 = var2.iterator();

            while(true) {
               label53:
               while(var4.hasNext()) {
                  ChunkPos var5 = (ChunkPos)var4.next();
                  class_2818 var6 = var1.field_1687.method_2935().method_12126(var5.x(), var5.z(), false);
                  if (var6 == null) {
                     var13.add(var5);
                  } else {
                     retainedUntil.keySet().removeIf((var1x) -> {
                        return var1x.x() >> 4 == var5.x() && var1x.z() >> 4 == var5.z();
                     });
                     ArrayList var7 = new ArrayList();
                     scanChunk(var6, var0, var7);
                     Iterator var8 = var7.iterator();

                     while(true) {
                        Hit var9;
                        do {
                           if (!var8.hasNext()) {
                              continue label53;
                           }

                           var9 = (Hit)var8.next();
                        } while(!retainedUntil.containsKey(var9) && retainedUntil.size() >= 8000);

                        retainedUntil.put(var9, retentionTick + 400);
                     }
                  }
               }

               synchronized(PENDING_CHUNKS_LOCK) {
                  pendingChunks.addAll(var13);
                  break;
               }
            }
         }
      }

   }

   private static int scanChunk(class_2818 var0, Set var1, List var2) {
      class_2826[] var3 = var0.method_12006();
      int var4 = var0.method_32891();
      int var5 = var0.method_12004().method_8326();
      int var6 = var0.method_12004().method_8328();
      short var7 = 0;
      if (var2.size() >= 8000) {
         return 0;
      } else {
         for(int var8 = 0; var8 < var3.length; ++var8) {
            class_2826 var9 = var3[var8];
            if (!var9.method_38292() && var9.method_19523((var1x) -> {
               return var1.contains(var1x.method_26204());
            })) {
               int var10 = var4 + var8 << 4;
               var7 = (short)(var7 + 4096);

               for(int var11 = 0; var11 < 16; ++var11) {
                  for(int var12 = 0; var12 < 16; ++var12) {
                     for(int var13 = 0; var13 < 16; ++var13) {
                        class_2248 var14 = var9.method_12254(var13, var11, var12).method_26204();
                        if (var1.contains(var14)) {
                           var2.add(new Hit(var5 + var13, var10 + var11, var6 + var12, var14));
                           if (var2.size() >= 8000) {
                              return var7;
                           }
                        }
                     }
                  }
               }
            }
         }

         return var7;
      }
   }

   public static void render(class_4597.class_4598 var0, class_4587 var1, class_243 var2, BlockEspModule var3) {
      List var4 = retained;
      if (!var4.isEmpty()) {
         HashMap var5 = new HashMap();
         Iterator var6 = var3.targets.targets().iterator();

         while(var6.hasNext()) {
            BlockListSetting.Target var7 = (BlockListSetting.Target)var6.next();
            if (var7.block() != null) {
               var5.put(var7.block(), (Integer)var7.color.get());
            }
         }

         int var17 = (Integer)var3.lineColor.get();
         int var18 = Math.clamp((long)var3.highlightAlpha.getInt(), 0, 255);
         boolean var8 = var3.shapeMode.is(Deobf.decrypt("4\u0005&M")) || var3.shapeMode.is(Deobf.decrypt(":\u0003<@{"));
         boolean var9 = var3.shapeMode.is(Deobf.decrypt("4\u0005&M")) || var3.shapeMode.is(Deobf.decrypt("%\u00036@{"));
         boolean var10 = (Boolean)var3.tracers.get() && (Boolean)var3.tracer.get();
         Iterator var11 = var4.iterator();

         while(var11.hasNext()) {
            Hit var12 = (Hit)var11.next();
            int var13 = (Integer)var5.getOrDefault(var12.block(), var17) & 16777215;
            int var14 = var13 | var18 << 24;
            if (var9) {
               EspBoxRenderer.fill(var0, var1, var2, (double)var12.x() + 0.002, (double)var12.y() + 0.002, (double)var12.z() + 0.002, (double)(var12.x() + 1) - 0.002, (double)(var12.y() + 1) - 0.002, (double)(var12.z() + 1) - 0.002, var14);
            }

            if (var8) {
               EspBoxRenderer.outline(var0, var1, var2, (double)var12.x() + 0.002, (double)var12.y() + 0.002, (double)var12.z() + 0.002, (double)(var12.x() + 1) - 0.002, (double)(var12.y() + 1) - 0.002, (double)(var12.z() + 1) - 0.002, var14, 1.6F);
            }
         }

         if (var10) {
            int var19 = (Integer)var3.tracerColor.get() >>> 24 & 255;
            if (var19 == 0) {
               var19 = 200;
            }

            Vector3fc var20 = class_310.method_1551().field_1773.method_19418().method_19335();
            Iterator var21 = var4.iterator();

            while(var21.hasNext()) {
               Hit var22 = (Hit)var21.next();
               int var15 = (Integer)var5.getOrDefault(var22.block(), var17) & 16777215;
               int var16 = var15 | var19 << 24;
               EspBoxRenderer.tracer(var0, var1, var2, var20, (double)var22.x() + 0.5, (double)var22.y() + 0.5, (double)var22.z() + 0.5, var16, 1.2F);
            }
         }

         EspBoxRenderer.flush(var0);
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

   public static record Hit(int x, int y, int z, class_2248 block) {
      public Hit(int x, int y, int z, class_2248 block) {
         this.x = x;
         this.y = y;
         this.z = z;
         this.block = block;
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

      public class_2248 block() {
         return this.block;
      }
   }
}
