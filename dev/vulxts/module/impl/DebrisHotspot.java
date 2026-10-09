package dev.vulxts.module.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.class_2246;
import net.minecraft.class_2680;

final class DebrisHotspot {
   static final int SECTION_SIZE = 16;
   static final int HOTSPOT_SIZE = 7;
   private static final int SECTION_VOLUME = 4096;
   private static final int MAX_ORIGIN = 9;
   private static final int MIN_EVIDENCE = 4;
   private static final double MIN_PROMINENCE = 0.025;
   private static final double MIN_DISTINCT_ADVANTAGE = 0.012;
   private static final byte OTHER = 0;
   private static final byte EVIDENCE = 1;
   private static final byte AIR = 2;
   private static final byte LAVA = 3;
   private static final int[][] DIRECTIONS = new int[][]{{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

   private DebrisHotspot() {
   }

   static Analysis find(class_2680[] var0, int var1, double var2, boolean[] var4) {
      return find(var0, var1, var2, var4, (Result)null);
   }

   static Analysis find(class_2680[] var0, int var1, double var2, boolean[] var4, Result var5) {
      if (var0 != null && var0.length == 4096 && (var4 == null || var4.length == 4096)) {
         Grid var6 = classify(var0, var4);
         if (var6 == null) {
            return DebrisHotspot.Analysis.EMPTY;
         } else {
            Result var7 = var5 == null ? null : validateLocked(var6, var1, var5);
            if (var7 == null) {
               var7 = selectHotspot(var6, var1, var2);
            }

            if (var7 == null) {
               var7 = fallbackHotspot(var6, var1);
            }

            return new Analysis(var7 == null ? List.of() : List.of(var7));
         }
      } else {
         return DebrisHotspot.Analysis.EMPTY;
      }
   }

   static Result validateLocked(class_2680[] var0, int var1, boolean[] var2, Result var3) {
      if (var3 == null) {
         return null;
      } else {
         Grid var4 = classify(var0, var2);
         return var4 == null ? null : validateLocked(var4, var1, var3);
      }
   }

   private static Result validateLocked(Grid var0, int var1, Result var2) {
      Candidate var3 = scoreHotspot(var0, var2.x1(), var2.y1(), var2.z1(), var1);
      int var4 = Math.max(4, (int)Math.ceil((double)var2.evidenceCount() * 0.5));
      return var3 != null && var3.evidenceCount() >= var4 && !(var3.score() < var2.rawScore() * 0.58) ? var2 : null;
   }

   static boolean isPredictionEvidence(class_2680 var0) {
      return isDebrisEvidence(var0);
   }

   static boolean isDebrisEvidence(class_2680 var0) {
      return var0 != null && (var0.method_27852(class_2246.field_10515) || var0.method_27852(class_2246.field_22091) || var0.method_27852(class_2246.field_29032) || var0.method_27852(class_2246.field_23869));
   }

   private static Grid classify(class_2680[] var0, boolean[] var1) {
      if (var0 != null && var0.length == 4096 && (var1 == null || var1.length == 4096)) {
         byte[] var2 = new byte[4096];
         int var3 = 0;

         for(int var4 = 0; var4 < 4096; ++var4) {
            class_2680 var5 = var0[var4];
            if ((var1 == null || !var1[var4]) && var5 != null) {
               if (isDebrisEvidence(var5)) {
                  var2[var4] = 1;
                  ++var3;
               } else if (var5.method_27852(class_2246.field_10164)) {
                  var2[var4] = 3;
               } else if (var5.method_26215()) {
                  var2[var4] = 2;
               } else {
                  var2[var4] = 0;
               }
            } else {
               var2[var4] = 0;
            }
         }

         int[] var7 = new int[4096];
         int[] var8 = new int[4096];
         int[] var6 = new int[4096];
         computeLocalMetrics(var2, var7, var8, var6);
         return new Grid(var2, var3, DebrisHotspot.Prefix.of(var2, (byte)1), DebrisHotspot.Prefix.of(var2, (byte)2), DebrisHotspot.Prefix.of(var2, (byte)3), DebrisHotspot.Prefix.ofValues(var7), DebrisHotspot.Prefix.ofValues(var8), DebrisHotspot.Prefix.ofValues(var6));
      } else {
         return null;
      }
   }

   private static void computeLocalMetrics(byte[] var0, int[] var1, int[] var2, int[] var3) {
      boolean[] var4 = new boolean[4096];
      int[] var5 = new int[4096];
      int[] var6 = new int[4096];

      for(int var7 = 0; var7 < 4096; ++var7) {
         if (var0[var7] == 1) {
            int var8 = var7 >>> 8;
            int var9 = var7 >>> 4 & 15;
            int var10 = var7 & 15;
            int[][] var11 = DIRECTIONS;
            int var12 = var11.length;

            int var13;
            int var15;
            int var16;
            int var18;
            for(var13 = 0; var13 < var12; ++var13) {
               int[] var14 = var11[var13];
               var15 = var10 + var14[0];
               var16 = var8 + var14[1];
               int var17 = var9 + var14[2];
               if (inside(var15, var16, var17)) {
                  var18 = var0[index(var15, var16, var17)];
                  int var10002;
                  if (var18 == 1) {
                     var10002 = var1[var7]++;
                  } else if (var18 == 3) {
                     var10002 = var2[var7]++;
                  }
               }
            }

            if (!var4[var7]) {
               int var25 = 0;
               byte var26 = 0;
               var12 = var26 + 1;
               var5[var26] = var7;
               var4[var7] = true;

               int var27;
               while(var25 < var12) {
                  var13 = var5[var25++];
                  var6[var25 - 1] = var13;
                  var27 = var13 >>> 8;
                  var15 = var13 >>> 4 & 15;
                  var16 = var13 & 15;
                  int[][] var28 = DIRECTIONS;
                  var18 = var28.length;

                  for(int var19 = 0; var19 < var18; ++var19) {
                     int[] var20 = var28[var19];
                     int var21 = var16 + var20[0];
                     int var22 = var27 + var20[1];
                     int var23 = var15 + var20[2];
                     if (inside(var21, var22, var23)) {
                        int var24 = index(var21, var22, var23);
                        if (var0[var24] == 1 && !var4[var24]) {
                           var4[var24] = true;
                           var5[var12++] = var24;
                        }
                     }
                  }
               }

               var13 = Math.min(var12, 32);

               for(var27 = 0; var27 < var12; ++var27) {
                  var3[var6[var27]] = var13;
               }
            }
         }
      }

   }

   private static Result selectHotspot(Grid var0, int var1, double var2) {
      if (var0.totalEvidence() >= 4 && var0.totalEvidence() != 4096) {
         ArrayList var4 = new ArrayList(1000);

         Candidate var8;
         for(int var5 = 0; var5 <= 9; ++var5) {
            for(int var6 = 0; var6 <= 9; ++var6) {
               for(int var7 = 0; var7 <= 9; ++var7) {
                  var8 = scoreHotspot(var0, var7, var5, var6, var1);
                  if (var8 != null) {
                     var4.add(var8);
                  }
               }
            }
         }

         if (var4.isEmpty()) {
            return null;
         } else {
            var4.sort(Comparator.comparingDouble(Candidate::score).reversed().thenComparing(Comparator.comparingInt(Candidate::evidenceCount).reversed()).thenComparingInt(Candidate::y).thenComparingInt(Candidate::z).thenComparingInt(Candidate::x));
            Candidate var23 = (Candidate)var4.getFirst();
            double var24 = ((Candidate)var4.get(var4.size() / 2)).score();
            var8 = null;

            for(int var9 = 1; var9 < var4.size(); ++var9) {
               Candidate var10 = (Candidate)var4.get(var9);
               int var11 = Math.max(Math.abs(var10.x() - var23.x()), Math.max(Math.abs(var10.y() - var23.y()), Math.abs(var10.z() - var23.z())));
               if (var11 >= 4) {
                  var8 = var10;
                  break;
               }
            }

            double var25 = Math.max(1.0, Math.abs(var23.score()));
            double var26 = (var23.score() - var24) / var25;
            double var13 = var8 == null ? 1.0 : (var23.score() - var8.score()) / var25;
            double var15 = Math.clamp((double)var23.evidenceCount() / 28.0, 0.0, 1.0);
            double var17 = Math.clamp(var26 * 4.0, 0.0, 1.0);
            double var19 = Math.clamp(var13 * 7.0, 0.0, 1.0);
            double var21 = 0.28 + var15 * 0.24 + var23.connectivity() * 0.18 + var23.centering() * 0.1 + var17 * 0.12 + var19 * 0.08;
            var21 = Math.clamp(var21, 0.01, 0.99);
            return new Result(var23.x(), var23.y(), var23.z(), var23.x() + 7, var23.y() + 7, var23.z() + 7, var21, var23.score(), var23.evidenceCount());
         }
      } else {
         return null;
      }
   }

   private static Result fallbackHotspot(Grid var0, int var1) {
      int var2 = 4;
      int var3 = 4;
      int var4 = 4;
      int var5 = 0;
      double var6 = Double.NEGATIVE_INFINITY;

      for(int var8 = 0; var8 <= 9; ++var8) {
         for(int var9 = 0; var9 <= 9; ++var9) {
            for(int var10 = 0; var10 <= 9; ++var10) {
               int var11 = var0.evidence().sum(var10, var8, var9, var10 + 7, var8 + 7, var9 + 7);
               int var12 = var0.air().sum(var10, var8, var9, var10 + 7, var8 + 7, var9 + 7);
               int var13 = var0.lava().sum(var10, var8, var9, var10 + 7, var8 + 7, var9 + 7);
               double var14 = (double)var11 - (double)var12 * 1.5 - (double)var13 * 0.5 + averageGenerationPrior(var1 + var8, var1 + var8 + 7) * 18.0;
               if (var14 > var6) {
                  var6 = var14;
                  var2 = var10;
                  var3 = var8;
                  var4 = var9;
                  var5 = var11;
               }
            }
         }
      }

      double var16 = (double)var5 / 343.0;
      double var17 = averageGenerationPrior(var1 + var3, var1 + var3 + 7);
      double var18 = Math.clamp(0.08 + var16 * 0.2 + (var17 - 0.75) * 0.12, 0.05, 0.35);
      return new Result(var2, var3, var4, var2 + 7, var3 + 7, var4 + 7, var18, var6, var5);
   }

   private static Candidate scoreHotspot(Grid var0, int var1, int var2, int var3, int var4) {
      int var5 = var1 + 7;
      int var6 = var2 + 7;
      int var7 = var3 + 7;
      int var8 = var0.evidence().sum(var1, var2, var3, var5, var6, var7);
      if (var8 < 4) {
         return null;
      } else {
         int var9 = var0.air().sum(var1, var2, var3, var5, var6, var7);
         int var10 = var0.lava().sum(var1, var2, var3, var5, var6, var7);
         int var11 = var0.neighbours().sum(var1, var2, var3, var5, var6, var7);
         int var12 = var0.lavaBorders().sum(var1, var2, var3, var5, var6, var7);
         int var13 = var0.componentSupport().sum(var1, var2, var3, var5, var6, var7);
         int var14 = Math.max(0, var1 - 1);
         int var15 = Math.max(0, var2 - 1);
         int var16 = Math.max(0, var3 - 1);
         int var17 = Math.min(16, var5 + 1);
         int var18 = Math.min(16, var6 + 1);
         int var19 = Math.min(16, var7 + 1);
         int var20 = (var17 - var14) * (var18 - var15) * (var19 - var16);
         int var21 = var0.evidence().sum(var14, var15, var16, var17, var18, var19) - var8;
         double var22 = (double)var21 / (double)Math.max(1, var20 - 343);
         int var24 = strongestOutsideSide(var0.evidence(), var1, var2, var3, var5, var6, var7);
         double var25 = 0.0;

         for(int var27 = var2; var27 < var6; ++var27) {
            for(int var28 = var3; var28 < var7; ++var28) {
               for(int var29 = var1; var29 < var5; ++var29) {
                  if (var0.types()[index(var29, var27, var28)] == 1) {
                     int var30 = var29 - var1 - 3;
                     int var31 = var27 - var2 - 3;
                     int var32 = var28 - var3 - 3;
                     var25 += 1.0 / (1.0 + (double)(var30 * var30 + var31 * var31 + var32 * var32) * 0.18);
                  }
               }
            }
         }

         double var43 = (double)var8 / 343.0;
         double var44 = Math.clamp((double)var11 / ((double)var8 * 6.0), 0.0, 1.0);
         double var45 = Math.clamp((double)var13 / ((double)var8 * 32.0), 0.0, 1.0);
         double var33 = var25 / (double)var8;
         double var35 = (double)var9 / 343.0;
         double var37 = (double)var10 / 343.0;
         double var39 = averageGenerationPrior(var4 + var2, var4 + var6);
         double var41 = (double)var8 * (1.0 + var44 * 2.4 + var45 * 0.9) + var43 * 210.0 + var33 * 105.0 + var22 * 28.0 + (double)var12 * 0.75 + var39 * 18.0 - var35 * 155.0 - var37 * 18.0 - (double)var24 * 0.75;
         return var41 > 0.0 ? new Candidate(var1, var2, var3, var41, var8, var44, var33) : null;
      }
   }

   private static int strongestOutsideSide(Prefix var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = 0;
      if (var1 > 0) {
         var7 = Math.max(var7, var0.sum(var1 - 1, var2, var3, var1, var5, var6));
      }

      if (var4 < 16) {
         var7 = Math.max(var7, var0.sum(var4, var2, var3, var4 + 1, var5, var6));
      }

      if (var2 > 0) {
         var7 = Math.max(var7, var0.sum(var1, var2 - 1, var3, var4, var2, var6));
      }

      if (var5 < 16) {
         var7 = Math.max(var7, var0.sum(var1, var5, var3, var4, var5 + 1, var6));
      }

      if (var3 > 0) {
         var7 = Math.max(var7, var0.sum(var1, var2, var3 - 1, var4, var5, var3));
      }

      if (var6 < 16) {
         var7 = Math.max(var7, var0.sum(var1, var2, var6, var4, var5, var6 + 1));
      }

      return var7;
   }

   private static double averageGenerationPrior(int var0, int var1) {
      double var2 = 0.0;

      for(int var4 = var0; var4 < var1; ++var4) {
         double var5 = var4 >= 8 && var4 <= 24 ? (9.0 - (double)Math.abs(var4 - 16)) / 9.0 : 0.0;
         double var7 = var4 >= 8 && var4 <= 247 ? 1.0 : 0.0;
         var2 += 0.75 + var5 * 0.65 + var7 * 0.1;
      }

      return var2 / 7.0;
   }

   private static boolean inside(int var0, int var1, int var2) {
      return var0 >= 0 && var0 < 16 && var1 >= 0 && var1 < 16 && var2 >= 0 && var2 < 16;
   }

   private static int index(int var0, int var1, int var2) {
      return (var1 * 16 + var2) * 16 + var0;
   }

   static record Result(int x1, int y1, int z1, int x2, int y2, int z2, double chance, double rawScore, int evidenceCount) {
      Result(int x1, int y1, int z1, int x2, int y2, int z2, double chance, double rawScore, int evidenceCount) {
         this.x1 = x1;
         this.y1 = y1;
         this.z1 = z1;
         this.x2 = x2;
         this.y2 = y2;
         this.z2 = z2;
         this.chance = chance;
         this.rawScore = rawScore;
         this.evidenceCount = evidenceCount;
      }

      public int x1() {
         return this.x1;
      }

      public int y1() {
         return this.y1;
      }

      public int z1() {
         return this.z1;
      }

      public int x2() {
         return this.x2;
      }

      public int y2() {
         return this.y2;
      }

      public int z2() {
         return this.z2;
      }

      public double chance() {
         return this.chance;
      }

      public double rawScore() {
         return this.rawScore;
      }

      public int evidenceCount() {
         return this.evidenceCount;
      }
   }

   static record Analysis(List predictionResults) {
      private static final Analysis EMPTY = new Analysis(List.of());

      Analysis(List predictionResults) {
         this.predictionResults = predictionResults;
      }

      public List predictionResults() {
         return this.predictionResults;
      }
   }

   private static record Grid(byte[] types, int totalEvidence, Prefix evidence, Prefix air, Prefix lava, Prefix neighbours, Prefix lavaBorders, Prefix componentSupport) {
      private Grid(byte[] types, int totalEvidence, Prefix evidence, Prefix air, Prefix lava, Prefix neighbours, Prefix lavaBorders, Prefix componentSupport) {
         this.types = types;
         this.totalEvidence = totalEvidence;
         this.evidence = evidence;
         this.air = air;
         this.lava = lava;
         this.neighbours = neighbours;
         this.lavaBorders = lavaBorders;
         this.componentSupport = componentSupport;
      }

      public byte[] types() {
         return this.types;
      }

      public int totalEvidence() {
         return this.totalEvidence;
      }

      public Prefix evidence() {
         return this.evidence;
      }

      public Prefix air() {
         return this.air;
      }

      public Prefix lava() {
         return this.lava;
      }

      public Prefix neighbours() {
         return this.neighbours;
      }

      public Prefix lavaBorders() {
         return this.lavaBorders;
      }

      public Prefix componentSupport() {
         return this.componentSupport;
      }
   }

   private static record Candidate(int x, int y, int z, double score, int evidenceCount, double connectivity, double centering) {
      private Candidate(int x, int y, int z, double score, int evidenceCount, double connectivity, double centering) {
         this.x = x;
         this.y = y;
         this.z = z;
         this.score = score;
         this.evidenceCount = evidenceCount;
         this.connectivity = connectivity;
         this.centering = centering;
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

      public double score() {
         return this.score;
      }

      public int evidenceCount() {
         return this.evidenceCount;
      }

      public double connectivity() {
         return this.connectivity;
      }

      public double centering() {
         return this.centering;
      }
   }

   private static final class Prefix {
      private static final int SIZE = 17;
      private final int[] values = new int[4913];

      static Prefix of(byte[] var0, byte var1) {
         int[] var2 = new int[4096];

         for(int var3 = 0; var3 < 4096; ++var3) {
            var2[var3] = var0[var3] == var1 ? 1 : 0;
         }

         return ofValues(var2);
      }

      static Prefix ofValues(int[] var0) {
         Prefix var1 = new Prefix();

         for(int var2 = 1; var2 < 17; ++var2) {
            for(int var3 = 1; var3 < 17; ++var3) {
               for(int var4 = 1; var4 < 17; ++var4) {
                  int var5 = var0[DebrisHotspot.index(var4 - 1, var2 - 1, var3 - 1)];
                  var1.values[prefixIndex(var4, var2, var3)] = var5 + var1.get(var4 - 1, var2, var3) + var1.get(var4, var2 - 1, var3) + var1.get(var4, var2, var3 - 1) - var1.get(var4 - 1, var2 - 1, var3) - var1.get(var4 - 1, var2, var3 - 1) - var1.get(var4, var2 - 1, var3 - 1) + var1.get(var4 - 1, var2 - 1, var3 - 1);
               }
            }
         }

         return var1;
      }

      int sum(int var1, int var2, int var3, int var4, int var5, int var6) {
         return this.get(var4, var5, var6) - this.get(var1, var5, var6) - this.get(var4, var2, var6) - this.get(var4, var5, var3) + this.get(var1, var2, var6) + this.get(var1, var5, var3) + this.get(var4, var2, var3) - this.get(var1, var2, var3);
      }

      private int get(int var1, int var2, int var3) {
         return this.values[prefixIndex(var1, var2, var3)];
      }

      private static int prefixIndex(int var0, int var1, int var2) {
         return (var1 * 17 + var2) * 17 + var0;
      }
   }
}
