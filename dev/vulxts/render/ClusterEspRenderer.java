package dev.vulxts.render;

import dev.vulxts.module.impl.ClusterEspModule;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import org.joml.Vector3fc;

public final class ClusterEspRenderer {
   private static final int[][] DIRECTIONS = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
   private static final int MAX_CLUSTERS = 512;
   private static final int MAX_RESULTS = 12000;
   private static final int RETAIN_TICKS = 400;
   private static final IncrementalScan SCAN = new IncrementalScan(48, 80000, 20);
   private static final Map retainedUntil = new LinkedHashMap();
   private static final Set pendingChunks = new LinkedHashSet();
   private static final Object PENDING_LOCK = new Object();
   private static volatile List retained = List.of();
   private static int retentionTick;
   private static long revision;
   private static volatile List clusters = List.of();
   private static long lastRevision = Long.MIN_VALUE;
   private static int lastFingerprint = Integer.MIN_VALUE;

   private ClusterEspRenderer() {
   }

   public static void clear() {
      SCAN.clear();
      retainedUntil.clear();
      synchronized(PENDING_LOCK) {
         pendingChunks.clear();
      }

      retained = List.of();
      retentionTick = 0;
      ++revision;
      clusters = List.of();
      lastRevision = Long.MIN_VALUE;
      lastFingerprint = Integer.MIN_VALUE;
   }

   public static int cachedCount() {
      int var0 = 0;

      Cluster var2;
      for(Iterator var1 = clusters.iterator(); var1.hasNext(); var0 += var2.hits().size()) {
         var2 = (Cluster)var1.next();
      }

      return var0;
   }

   public static void update(ClusterEspModule var0) {
      ++retentionTick;
      scanPendingChunks();
      int var1 = Math.min(32, (Integer)class_310.method_1551().field_1690.method_42503().method_41753());
      SCAN.tick(var1, ClusterEspRenderer::scanChunk);
      refreshRetained();
      int var2 = var0.minimumBlocks.getInt();
      if (revision != lastRevision || var2 != lastFingerprint) {
         lastRevision = revision;
         lastFingerprint = var2;
         clusters = build(retained, var2);
      }

   }

   public static void markChunkDirty(int var0, int var1) {
      synchronized(PENDING_LOCK) {
         if (pendingChunks.size() < 512) {
            pendingChunks.add(new ChunkPos(var0, var1));
         }

      }
   }

   public static void markDirty() {
      SCAN.markDirty();
   }

   private static boolean isAmethyst(class_2248 var0) {
      return var0 == class_2246.field_27161;
   }

   private static int scanChunk(class_2818 var0, List var1) {
      class_2826[] var2 = var0.method_12006();
      int var3 = var0.method_32891();
      int var4 = var0.method_12004().method_8326();
      int var5 = var0.method_12004().method_8328();
      short var6 = 0;
      int var7 = Integer.MIN_VALUE;
      int var8 = Integer.MIN_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < var2.length && var1.size() < 12000; ++var10) {
         class_2826 var11 = var2[var10];
         if (!var11.method_38292() && var11.method_19523((var0x) -> {
            class_2248 var1x = var0x.method_26204();
            return isAmethyst(var1x) || isGeodeAnchor(var1x);
         })) {
            int var12 = var3 + var10 << 4;
            var6 = (short)(var6 + 4096);

            for(int var13 = 0; var13 < 16; ++var13) {
               for(int var14 = 0; var14 < 16; ++var14) {
                  for(int var15 = 0; var15 < 16; ++var15) {
                     class_2248 var16 = var11.method_12254(var15, var13, var14).method_26204();
                     int var17 = var4 + var15;
                     int var18 = var12 + var13;
                     int var19 = var5 + var14;
                     if (isAmethyst(var16)) {
                        var1.add(new Hit(var17, var18, var19));
                     }

                     if (var7 == Integer.MIN_VALUE && isGeodeAnchor(var16)) {
                        var7 = var17;
                        var8 = var18;
                        var9 = var19;
                     }

                     if (var1.size() >= 12000) {
                        return var6;
                     }
                  }
               }
            }
         }
      }

      if (var7 != Integer.MIN_VALUE) {
         scanMaskedClusters(var7, var8, var9, var1);
      }

      return var6;
   }

   private static boolean isGeodeAnchor(class_2248 var0) {
      return var0 == class_2246.field_27159 || var0 == class_2246.field_27160;
   }

   private static void scanMaskedClusters(int var0, int var1, int var2, List var3) {
      class_310 var4 = class_310.method_1551();
      if (var4.field_1687 != null) {
         byte var5 = 8;

         for(int var6 = var1 - var5; var6 <= var1 + var5 && var3.size() < 12000; ++var6) {
            for(int var7 = var0 - var5; var7 <= var0 + var5 && var3.size() < 12000; ++var7) {
               for(int var8 = var2 - var5; var8 <= var2 + var5 && var3.size() < 12000; ++var8) {
                  class_2338 var9 = new class_2338(var7, var6, var8);
                  class_2680 var10 = var4.field_1687.method_8320(var9);
                  if (var10.method_26215() || var10.method_27852(class_2246.field_27161)) {
                     int var11 = var4.field_1687.method_22336().method_22363(var9, 0);
                     if (var11 == 4) {
                        int var12 = 0;
                        boolean var13 = false;
                        int[][] var14 = DIRECTIONS;
                        int var15 = var14.length;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           int[] var17 = var14[var16];
                           class_2338 var18 = var9.method_10069(var17[0], var17[1], var17[2]);
                           int var19 = var4.field_1687.method_22336().method_22363(var18, 0);
                           var12 = Math.max(var12, var19);
                           class_2680 var20 = var4.field_1687.method_8320(var18);
                           if (var19 == 4 && (var20.method_26215() || var20.method_27852(class_2246.field_27161))) {
                              var13 = true;
                           }
                        }

                        if (var12 == 4 && var13) {
                           var3.add(new Hit(var7, var6, var8));
                        }
                     }
                  }
               }
            }
         }
      }

   }

   private static void scanPendingChunks() {
      class_310 var0 = class_310.method_1551();
      if (var0.field_1687 != null) {
         ArrayList var1 = new ArrayList();
         Iterator var3;
         synchronized(PENDING_LOCK) {
            var3 = pendingChunks.iterator();

            while(var3.hasNext() && var1.size() < 4) {
               var1.add((ChunkPos)var3.next());
               var3.remove();
            }
         }

         ArrayList var12 = new ArrayList();
         var3 = var1.iterator();

         while(true) {
            label52:
            while(var3.hasNext()) {
               ChunkPos var4 = (ChunkPos)var3.next();
               class_2818 var5 = var0.field_1687.method_2935().method_12126(var4.x(), var4.z(), false);
               if (var5 == null) {
                  var12.add(var4);
               } else {
                  retainedUntil.keySet().removeIf((var1x) -> {
                     return var1x.x() >> 4 == var4.x() && var1x.z() >> 4 == var4.z();
                  });
                  ArrayList var6 = new ArrayList();
                  scanChunk(var5, var6);
                  Iterator var7 = var6.iterator();

                  while(true) {
                     Hit var8;
                     do {
                        if (!var7.hasNext()) {
                           continue label52;
                        }

                        var8 = (Hit)var7.next();
                     } while(!retainedUntil.containsKey(var8) && retainedUntil.size() >= 12000);

                     retainedUntil.put(var8, retentionTick + 400);
                  }
               }
            }

            synchronized(PENDING_LOCK) {
               pendingChunks.addAll(var12);
               break;
            }
         }
      }

   }

   private static void refreshRetained() {
      Iterator var0 = SCAN.get().iterator();

      while(true) {
         Hit var1;
         do {
            if (!var0.hasNext()) {
               retainedUntil.entrySet().removeIf((var0x) -> {
                  return (Integer)var0x.getValue() <= retentionTick;
               });
               List var2 = List.copyOf(retainedUntil.keySet());
               if (!var2.equals(retained)) {
                  retained = var2;
                  ++revision;
               }

               return;
            }

            var1 = (Hit)var0.next();
         } while(!retainedUntil.containsKey(var1) && retainedUntil.size() >= 12000);

         retainedUntil.put(var1, retentionTick + 400);
      }
   }

   private static List build(List var0, int var1) {
      if (var0.isEmpty()) {
         return List.of();
      } else {
         HashMap var2 = new HashMap();
         Iterator var3 = var0.iterator();

         while(var3.hasNext()) {
            Hit var4 = (Hit)var3.next();
            ((Accumulator)var2.computeIfAbsent(new ChunkPos(var4.x() >> 4, var4.z() >> 4), (var0x) -> {
               return new Accumulator();
            })).add(var4);
         }

         ArrayList var6 = new ArrayList();
         Iterator var7 = var2.values().iterator();

         while(var7.hasNext()) {
            Accumulator var5 = (Accumulator)var7.next();
            if (var5.count >= var1) {
               var6.add(var5.finish());
            }
         }

         var6.sort(Comparator.comparingInt(Cluster::count).reversed());
         if (var6.size() > 512) {
            var6.subList(512, var6.size()).clear();
         }

         return List.copyOf(var6);
      }
   }

   public static void render(class_4597.class_4598 var0, class_4587 var1, class_243 var2, ClusterEspModule var3) {
      List var4 = clusters;
      if (!var4.isEmpty()) {
         int var5 = (Integer)var3.color.get() & 16777215;
         int var6 = var5 | Math.clamp((long)var3.fillAlpha.getInt(), 0, 255) << 24;
         int var7 = var5 | Math.clamp((long)var3.outlineAlpha.getInt(), 0, 255) << 24;
         boolean var8 = (Boolean)var3.tracers.get();
         Vector3fc var9 = var8 ? class_310.method_1551().field_1773.method_19418().method_19335() : null;
         Iterator var10 = var4.iterator();

         while(var10.hasNext()) {
            Cluster var11 = (Cluster)var10.next();
            Iterator var12 = var11.hits().iterator();

            while(var12.hasNext()) {
               Hit var13 = (Hit)var12.next();
               double var14 = 0.025;
               EspBoxRenderer.fill(var0, var1, var2, (double)var13.x() + var14, (double)var13.y() + var14, (double)var13.z() + var14, (double)var13.x() + 1.0 - var14, (double)var13.y() + 1.0 - var14, (double)var13.z() + 1.0 - var14, var6);
               EspBoxRenderer.outline(var0, var1, var2, (double)var13.x() + var14, (double)var13.y() + var14, (double)var13.z() + var14, (double)var13.x() + 1.0 - var14, (double)var13.y() + 1.0 - var14, (double)var13.z() + 1.0 - var14, var7, 1.8F);
            }

            if (var8) {
               EspBoxRenderer.tracer(var0, var1, var2, var9, var11.centerX(), var11.centerY(), var11.centerZ(), var7, 1.25F);
            }
         }

         EspBoxRenderer.flush(var0);
      }

   }

   private static record Cluster(int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int count, List hits) {
      private Cluster(int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int count, List hits) {
         this.minX = minX;
         this.minY = minY;
         this.minZ = minZ;
         this.maxX = maxX;
         this.maxY = maxY;
         this.maxZ = maxZ;
         this.count = count;
         this.hits = hits;
      }

      double centerX() {
         return ((double)this.minX + (double)this.maxX + 1.0) * 0.5;
      }

      double centerY() {
         return ((double)this.minY + (double)this.maxY + 1.0) * 0.5;
      }

      double centerZ() {
         return ((double)this.minZ + (double)this.maxZ + 1.0) * 0.5;
      }

      public int minX() {
         return this.minX;
      }

      public int minY() {
         return this.minY;
      }

      public int minZ() {
         return this.minZ;
      }

      public int maxX() {
         return this.maxX;
      }

      public int maxY() {
         return this.maxY;
      }

      public int maxZ() {
         return this.maxZ;
      }

      public int count() {
         return this.count;
      }

      public List hits() {
         return this.hits;
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

   private static record Hit(int x, int y, int z) {
      private Hit(int x, int y, int z) {
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

   private static final class Accumulator {
      int minX = Integer.MAX_VALUE;
      int minY = Integer.MAX_VALUE;
      int minZ = Integer.MAX_VALUE;
      int maxX = Integer.MIN_VALUE;
      int maxY = Integer.MIN_VALUE;
      int maxZ = Integer.MIN_VALUE;
      int count;
      final ArrayList hits = new ArrayList();

      void add(Hit var1) {
         this.minX = Math.min(this.minX, var1.x());
         this.minY = Math.min(this.minY, var1.y());
         this.minZ = Math.min(this.minZ, var1.z());
         this.maxX = Math.max(this.maxX, var1.x());
         this.maxY = Math.max(this.maxY, var1.y());
         this.maxZ = Math.max(this.maxZ, var1.z());
         this.hits.add(var1);
         ++this.count;
      }

      Cluster finish() {
         return new Cluster(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ, this.count, List.copyOf(this.hits));
      }
   }
}
