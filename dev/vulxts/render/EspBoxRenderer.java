package dev.vulxts.render;

import net.minecraft.class_243;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public final class EspBoxRenderer {
   private static final float TRACER_START = 0.35F;
   private static final float TRACER_NEAR = 0.1F;

   private EspBoxRenderer() {
   }

   public static void outline(class_4597.class_4598 var0, class_4587 var1, class_243 var2, double var3, double var5, double var7, double var9, double var11, double var13, int var15, float var16) {
      class_4588 var17 = var0.method_73477(FlatOverlay.LINES);
      class_4587.class_4665 var18 = var1.method_23760();
      float var19 = (float)(var3 - var2.field_1352);
      float var20 = (float)(var5 - var2.field_1351);
      float var21 = (float)(var7 - var2.field_1350);
      float var22 = (float)(var9 - var2.field_1352);
      float var23 = (float)(var11 - var2.field_1351);
      float var24 = (float)(var13 - var2.field_1350);
      line(var17, var18, var19, var20, var21, var22, var20, var21, var15, var16);
      line(var17, var18, var22, var20, var21, var22, var20, var24, var15, var16);
      line(var17, var18, var22, var20, var24, var19, var20, var24, var15, var16);
      line(var17, var18, var19, var20, var24, var19, var20, var21, var15, var16);
      line(var17, var18, var19, var23, var21, var22, var23, var21, var15, var16);
      line(var17, var18, var22, var23, var21, var22, var23, var24, var15, var16);
      line(var17, var18, var22, var23, var24, var19, var23, var24, var15, var16);
      line(var17, var18, var19, var23, var24, var19, var23, var21, var15, var16);
      line(var17, var18, var19, var20, var21, var19, var23, var21, var15, var16);
      line(var17, var18, var22, var20, var21, var22, var23, var21, var15, var16);
      line(var17, var18, var22, var20, var24, var22, var23, var24, var15, var16);
      line(var17, var18, var19, var20, var24, var19, var23, var24, var15, var16);
   }

   public static void fill(class_4597.class_4598 var0, class_4587 var1, class_243 var2, double var3, double var5, double var7, double var9, double var11, double var13, int var15) {
      class_4588 var16 = var0.method_73477(FlatOverlay.FILL);
      class_4587.class_4665 var17 = var1.method_23760();
      float var18 = (float)(var3 - var2.field_1352);
      float var19 = (float)(var5 - var2.field_1351);
      float var20 = (float)(var7 - var2.field_1350);
      float var21 = (float)(var9 - var2.field_1352);
      float var22 = (float)(var11 - var2.field_1351);
      float var23 = (float)(var13 - var2.field_1350);
      quad(var16, var17, var15, var18, var19, var20, var21, var19, var20, var21, var19, var23, var18, var19, var23);
      quad(var16, var17, var15, var18, var22, var20, var18, var22, var23, var21, var22, var23, var21, var22, var20);
      quad(var16, var17, var15, var18, var19, var20, var18, var22, var20, var21, var22, var20, var21, var19, var20);
      quad(var16, var17, var15, var18, var19, var23, var21, var19, var23, var21, var22, var23, var18, var22, var23);
      quad(var16, var17, var15, var18, var19, var20, var18, var19, var23, var18, var22, var23, var18, var22, var20);
      quad(var16, var17, var15, var21, var19, var20, var21, var22, var20, var21, var22, var23, var21, var19, var23);
   }

   public static void tracer(class_4597.class_4598 var0, class_4587 var1, class_243 var2, Vector3fc var3, double var4, double var6, double var8, int var10, float var11) {
      float var12 = var3.x();
      float var13 = var3.y();
      float var14 = var3.z();
      float var15 = (float)Math.sqrt((double)(var12 * var12 + var13 * var13 + var14 * var14));
      if (var15 > 1.0E-6F) {
         var12 /= var15;
         var13 /= var15;
         var14 /= var15;
      }

      float var16 = var12 * 0.35F;
      float var17 = var13 * 0.35F;
      float var18 = var14 * 0.35F;
      float var19 = (float)(var4 - var2.field_1352);
      float var20 = (float)(var6 - var2.field_1351);
      float var21 = (float)(var8 - var2.field_1350);
      float var22 = var19 * var12 + var20 * var13 + var21 * var14;
      if (var22 < 0.1F) {
         float var23 = -0.25F / (var22 - 0.35F);
         var19 = var16 + (var19 - var16) * var23;
         var20 = var17 + (var20 - var17) * var23;
         var21 = var18 + (var21 - var18) * var23;
      }

      class_4588 var25 = var0.method_73477(FlatOverlay.LINES);
      class_4587.class_4665 var24 = var1.method_23760();
      line(var25, var24, var16, var17, var18, var19, var20, var21, var10, var11);
   }

   public static void beam(class_4597.class_4598 var0, class_4587 var1, class_243 var2, double var3, double var5, double var7, double var9, int var11, float var12) {
      class_4588 var13 = var0.method_73477(FlatOverlay.LINES);
      class_4587.class_4665 var14 = var1.method_23760();
      line(var13, var14, (float)(var3 - var2.field_1352), (float)(var5 - var2.field_1351), (float)(var7 - var2.field_1350), (float)(var3 - var2.field_1352), (float)(var9 - var2.field_1351), (float)(var7 - var2.field_1350), var11, var12);
   }

   public static void ring(class_4597.class_4598 var0, class_4587 var1, class_243 var2, double var3, double var5, double var7, double var9, int var11, int var12, float var13) {
      class_4588 var14 = var0.method_73477(FlatOverlay.LINES);
      class_4587.class_4665 var15 = var1.method_23760();
      float var16 = (float)(var5 - var2.field_1351);
      double var17 = var3 + var9;
      double var19 = var7;

      for(int var21 = 1; var21 <= var11; ++var21) {
         double var22 = 6.283185307179586 * (double)var21 / (double)var11;
         double var24 = var3 + Math.cos(var22) * var9;
         double var26 = var7 + Math.sin(var22) * var9;
         line(var14, var15, (float)(var17 - var2.field_1352), var16, (float)(var19 - var2.field_1350), (float)(var24 - var2.field_1352), var16, (float)(var26 - var2.field_1350), var12, var13);
         var17 = var24;
         var19 = var26;
      }

   }

   public static void flush(class_4597.class_4598 var0) {
      FlatOverlay.flush(var0);
   }

   private static void line(class_4588 var0, class_4587.class_4665 var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8, float var9) {
      Vector3f var10 = new Vector3f(var5 - var2, var6 - var3, var7 - var4);
      if (var10.lengthSquared() > 1.0E-9F) {
         var10.normalize();
      } else {
         var10.set(0.0F, 1.0F, 0.0F);
      }

      var0.method_56824(var1, var2, var3, var4).method_39415(var8).method_61959(var1, var10).method_75298(var9);
      var0.method_56824(var1, var5, var6, var7).method_39415(var8).method_61959(var1, var10).method_75298(var9);
   }

   private static void quad(class_4588 var0, class_4587.class_4665 var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14) {
      var0.method_56824(var1, var3, var4, var5).method_39415(var2);
      var0.method_56824(var1, var6, var7, var8).method_39415(var2);
      var0.method_56824(var1, var9, var10, var11).method_39415(var2);
      var0.method_56824(var1, var12, var13, var14).method_39415(var2);
   }
}
