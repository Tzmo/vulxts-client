package dev.vulxts.render;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Modules;
import dev.vulxts.rt.Deobf;
import dev.vulxts.suschunk.SusChunkScanner;
import dev.vulxts.util.Colors;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.class_1923;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import net.minecraft.class_4597;

public final class SusChunkRenderer {
   private static final float FADE_IN_SECONDS = 0.3F;
   private static final float FADE_OUT_SECONDS = 0.45F;
   private static final float MOVE_RATE = 7.0F;
   private static final Map chunkFades = new HashMap();
   private static final Map zoneFades = new HashMap();
   private static long lastFrameNanos;

   private SusChunkRenderer() {
   }

   public static void reset() {
      chunkFades.clear();
      zoneFades.clear();
   }

   public static String debugState() {
      StringBuilder var0 = new StringBuilder();
      Iterator var1 = chunkFades.entrySet().iterator();

      Map.Entry var5;
      while(var1.hasNext()) {
         var5 = (Map.Entry)var1.next();
         ChunkFade var3 = (ChunkFade)var5.getValue();
         var0.append(new class_1923((Long)var5.getKey())).append(Deobf.decrypt("\r\u000bo")).append(var3.alpha).append(Deobf.decrypt("Z\u001eo")).append(var3.tier).append(Deobf.decrypt("Z\fo")).append(var3.flagged).append(Deobf.decrypt("\u000bJ"));
      }

      var1 = zoneFades.entrySet().iterator();

      while(var1.hasNext()) {
         var5 = (Map.Entry)var1.next();
         ZoneFade var6 = (ZoneFade)var5.getValue();
         var0.append(Deobf.decrypt("\f\u0005<@")).append(new class_1923((Long)var5.getKey())).append(Deobf.decrypt("\r\u000bo")).append(var6.alpha).append(Deobf.decrypt("Z\u0019o")).append(var6.size).append(Deobf.decrypt("Z\fo")).append(var6.flagged).append(Deobf.decrypt("\u000bJ"));
      }

      return var0.toString();
   }

   public static void render(class_4597.class_4598 var0, class_4587 var1, class_243 var2, Modules.SusChunkFinderModule var3) {
      SusChunkScanner var4 = var3.scanner;
      double var5 = (Double)var3.renderY.get();
      int var7 = VulxtsClient.themes().current().accent();
      float var8 = var3.fillOpacity.getFloat() / 255.0F;
      float var9 = var3.outlineOpacity.getFloat() / 255.0F;
      boolean var10 = (Boolean)var3.outline.get();
      boolean var11 = (Boolean)var3.smartMode.get();
      int var12 = var4.threshold();
      updateTargets(var4, var11, var12);
      float var13 = frameDelta();
      float var14 = 1.0F - (float)Math.exp((double)(-var13 * 7.0F));
      Iterator var15 = chunkFades.entrySet().iterator();

      double var24;
      while(var15.hasNext()) {
         Map.Entry var16 = (Map.Entry)var15.next();
         ChunkFade var17 = (ChunkFade)var16.getValue();
         var17.alpha += var17.flagged ? var13 / 0.3F : -var13 / 0.45F;
         var17.alpha = Math.clamp(var17.alpha, 0.0F, 1.0F);
         if (!var17.flagged && var17.alpha <= 0.0F) {
            var15.remove();
         } else {
            var24 = (double)class_1923.method_8325((Long)var16.getKey()) * 16.0;
            double var20 = (double)class_1923.method_8332((Long)var16.getKey()) * 16.0;
            drawQuad(var0, var1, var2, var24, var20, var24 + 16.0, var20 + 16.0, var5, var7, var8 * var17.tier * var17.alpha, var10 ? var9 * var17.alpha : 0.0F);
         }
      }

      Iterator var22 = zoneFades.entrySet().iterator();

      while(true) {
         while(var22.hasNext()) {
            ZoneFade var23 = (ZoneFade)((Map.Entry)var22.next()).getValue();
            var23.alpha += var23.flagged ? var13 / 0.3F : -var13 / 0.45F;
            var23.alpha = Math.clamp(var23.alpha, 0.0F, 1.0F);
            if (!var23.flagged && var23.alpha <= 0.0F) {
               var22.remove();
            } else {
               var23.centerX += (var23.targetX - var23.centerX) * (double)var14;
               var23.centerZ += (var23.targetZ - var23.centerZ) * (double)var14;
               var23.size += (var23.targetSize - var23.size) * var14;
               var24 = (double)var23.size / 2.0;
               drawQuad(var0, var1, var2, var23.centerX - var24, var23.centerZ - var24, var23.centerX + var24, var23.centerZ + var24, var5, var7, var8 * var23.tier * var23.alpha, var10 ? var9 * var23.alpha : 0.0F);
               if ((Boolean)var3.centroidMarker.get()) {
                  drawCircleMarker(var0, var1, var2, var23.centerX, var23.centerZ, var5 + 0.05, 2.0, Colors.withAlpha(var7, 0.95F * var23.alpha));
               }
            }
         }

         FlatOverlay.flush(var0);
         return;
      }
   }

   private static void drawQuad(class_4597.class_4598 var0, class_4587 var1, class_243 var2, double var3, double var5, double var7, double var9, double var11, int var13, float var14, float var15) {
      FlatOverlay.fillQuad(var0, var1, var2, var3, var5, var7, var9, var11, Colors.withAlpha(var13, var14));
      if (var15 > 0.004F) {
         int var16 = Colors.withAlpha(var13, var15);
         FlatOverlay.edge(var0, var1, var2, var3, var5, var7, var5, var11, var16, 2.5F);
         FlatOverlay.edge(var0, var1, var2, var3, var9, var7, var9, var11, var16, 2.5F);
         FlatOverlay.edge(var0, var1, var2, var3, var5, var3, var9, var11, var16, 2.5F);
         FlatOverlay.edge(var0, var1, var2, var7, var5, var7, var9, var11, var16, 2.5F);
      }

   }

   private static void drawCircleMarker(class_4597.class_4598 var0, class_4587 var1, class_243 var2, double var3, double var5, double var7, double var9, int var11) {
      byte var12 = 24;
      int var13 = Colors.withAlpha(var11, 0.24F);

      for(int var14 = 0; var14 < var12; ++var14) {
         double var15 = (double)var14 * Math.PI * 2.0 / (double)var12;
         double var17 = (double)(var14 + 1) * Math.PI * 2.0 / (double)var12;
         FlatOverlay.edge(var0, var1, var2, var3 + Math.cos(var15) * var9 * 1.32, var5 + Math.sin(var15) * var9 * 1.32, var3 + Math.cos(var17) * var9 * 1.32, var5 + Math.sin(var17) * var9 * 1.32, var7, var13, 3.0F);
         FlatOverlay.edge(var0, var1, var2, var3 + Math.cos(var15) * var9, var5 + Math.sin(var15) * var9, var3 + Math.cos(var17) * var9, var5 + Math.sin(var17) * var9, var7, var11, 2.4F);
      }

      FlatOverlay.fillQuad(var0, var1, var2, var3 - 0.22, var5 - 0.22, var3 + 0.22, var5 + 0.22, var7, var11);
   }

   private static void updateTargets(SusChunkScanner var0, boolean var1, int var2) {
      Iterator var3;
      ChunkFade var4;
      for(var3 = chunkFades.values().iterator(); var3.hasNext(); var4.flagged = false) {
         var4 = (ChunkFade)var3.next();
      }

      ZoneFade var13;
      for(var3 = zoneFades.values().iterator(); var3.hasNext(); var13.flagged = false) {
         var13 = (ZoneFade)var3.next();
      }

      if (var1) {
         var3 = var0.zones().iterator();

         while(true) {
            while(var3.hasNext()) {
               SusChunkScanner.Zone var14 = (SusChunkScanner.Zone)var3.next();
               long var5;
               if (var14.members().size() == 1) {
                  var5 = (Long)var14.members().iterator().next();
                  ChunkFade var18 = (ChunkFade)chunkFades.computeIfAbsent(var5, (var0x) -> {
                     return new ChunkFade();
                  });
                  var18.flagged = true;
                  var18.tier = confidence(var14.maxScore(), var2);
               } else {
                  var5 = Long.MAX_VALUE;

                  long var8;
                  for(Iterator var7 = var14.members().iterator(); var7.hasNext(); var5 = Math.min(var5, var8)) {
                     var8 = (Long)var7.next();
                  }

                  ZoneFade var19 = (ZoneFade)zoneFades.get(var5);
                  if (var19 == null) {
                     var19 = new ZoneFade(var14.centroidX(), var14.centroidZ());
                     zoneFades.put(var5, var19);
                  }

                  var19.flagged = true;
                  var19.targetX = var14.centroidX();
                  var19.targetZ = var14.centroidZ();
                  var19.targetSize = Math.min(48.0F, 16.0F + (float)(var14.members().size() - 1) * 8.0F);
                  var19.tier = confidence(var14.maxScore(), var2);
               }
            }

            return;
         }
      } else {
         ChunkFade var17;
         for(var3 = var0.flags().iterator(); var3.hasNext(); var17.tier = 1.0F) {
            SusChunkScanner.Flag var15 = (SusChunkScanner.Flag)var3.next();
            var17 = (ChunkFade)chunkFades.computeIfAbsent(var15.chunkKey(), (var0x) -> {
               return new ChunkFade();
            });
            var17.flagged = true;
         }

      }
   }

   private static float confidence(double var0, int var2) {
      if (var2 <= 0) {
         return 1.0F;
      } else {
         float var3 = (float)((var0 - (double)var2) / ((double)var2 * 2.0));
         return 0.55F + 0.45F * Math.clamp(var3, 0.0F, 1.0F);
      }
   }

   private static float frameDelta() {
      long var0 = System.nanoTime();
      float var2 = lastFrameNanos == 0L ? 0.016F : (float)(var0 - lastFrameNanos) / 1.0E9F;
      lastFrameNanos = var0;
      return Math.min(var2, 0.1F);
   }

   private static final class ChunkFade {
      float alpha;
      float tier = 1.0F;
      boolean flagged;
   }

   private static final class ZoneFade {
      double centerX;
      double centerZ;
      double targetX;
      double targetZ;
      float size = 16.0F;
      float targetSize = 16.0F;
      float alpha;
      float tier = 1.0F;
      boolean flagged;

      ZoneFade(double var1, double var3) {
         this.centerX = this.targetX = var1;
         this.centerZ = this.targetZ = var3;
      }
   }
}
