package dev.vulxts.hud;

import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.theme.Theme;
import dev.vulxts.util.Colors;

public final class HudChrome {
   private HudChrome() {
   }

   public static void underlay(NVGRenderer var0, Theme var1, float var2, float var3, float var4, float var5) {
      if (isRound(var4, var5)) {
         var0.circleGlow(var2 + var4 / 2.0F, var3 + var5 / 2.0F, var4 / 2.0F - 1.0F, 5.0F, Colors.withAlpha(var1.accent(), 0.12F));
      } else {
         var0.glow(var2, var3, var4, var5, 3.0F, 7.0F, Colors.withAlpha(-16777216, 0.28F));
      }

   }

   public static void overlay(NVGRenderer var0, Theme var1, float var2, float var3, float var4, float var5) {
      if (!(var4 < 12.0F) && !(var5 < 10.0F)) {
         if (isRound(var4, var5)) {
            float var9 = var2 + var4 / 2.0F;
            float var7 = var3 + var5 / 2.0F;
            float var8 = var4 / 2.0F - 0.7F;
            var0.circleOutline(var9, var7, var8, 1.0F, Colors.withAlpha(var1.accent(), 0.34F));
            var0.line(var9 - 4.0F, var3 + 1.0F, var9 + 4.0F, var3 + 1.0F, 1.6F, var1.accentBright());
         } else {
            var0.rectOutline(var2 + 0.5F, var3 + 0.5F, var4 - 1.0F, var5 - 1.0F, 3.0F, 1.0F, Colors.withAlpha(var1.accent(), 0.3F));
            var0.line(var2 + 11.0F, var3 + 1.0F, var2 + Math.min(var4 - 9.0F, 42.0F), var3 + 1.0F, 1.6F, var1.accentBright());
            var0.save();
            var0.translate(var2 + 6.0F, var3 + 6.0F);
            var0.rotate(0.7853982F);
            var0.rect(-2.0F, -2.0F, 4.0F, 4.0F, 0.7F, var1.accent());
            var0.restore();
            int var6 = Colors.withAlpha(var1.accent(), 0.44F);
            var0.line(var2 + var4 - 9.0F, var3 + var5 - 1.0F, var2 + var4 - 1.0F, var3 + var5 - 1.0F, 1.0F, var6);
            var0.line(var2 + var4 - 1.0F, var3 + var5 - 9.0F, var2 + var4 - 1.0F, var3 + var5 - 1.0F, 1.0F, var6);
         }
      }

   }

   private static boolean isRound(float var0, float var1) {
      return var0 >= 56.0F && Math.abs(var0 - var1) < 1.5F;
   }
}
