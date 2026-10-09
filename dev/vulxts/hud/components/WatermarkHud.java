package dev.vulxts.hud.components;

import dev.vulxts.hud.HudComponent;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import java.util.function.BooleanSupplier;

public class WatermarkHud extends HudComponent {
   private static final float HEIGHT = 30.0F;
   private static final float PAD = 13.0F;
   private static final float LOGO_SIZE = 18.0F;
   private static final float TEXT_SIZE = 14.0F;
   private final ThemeManager themes;

   public WatermarkHud(ThemeManager var1, BooleanSupplier var2) {
      super("Vulxts Client", 0.006F, 0.01F, var2);
      this.themes = var1;
   }

   public float measureWidth(NVGRenderer var1) {
      return 48.0F + var1.textWidth("VULXTS", 16.0F) + var1.textWidth("CLIENT", 11.0F);
   }

   public float measureHeight(NVGRenderer var1) {
      return 30.0F;
   }

   public void render(NVGRenderer var1, float var2, float var3, float var4, float var5) {
      Theme var6 = this.themes.current();
      float var7 = var3 + var5 / 2.0F;
      var1.rectGradient(var2, var3, var4, var5, 2.0F, var6.background(), var6.backgroundTo(), true);
      var1.rectOutline(var2, var3, var4, var5, 2.0F, 1.0F, Colors.withAlpha(var6.accent(), 0.35F));
      float var8 = var2 + 18.0F;
      var1.save();
      var1.translate(var8, var7);
      var1.rotate(0.7853982F);
      var1.rectOutline(-5.0F, -5.0F, 10.0F, 10.0F, 1.3F, 1.6F, var6.accentBright());
      var1.rect(-1.8F, -1.8F, 3.6F, 3.6F, 0.7F, var6.accentBright());
      var1.restore();
      float var9 = var2 + 31.0F;
      var1.text("VULXTS", var9, var7, 16.0F, var6.textPrimary());
      var9 += var1.textWidth("VULXTS", 16.0F) + 7.0F;
      var1.text("CLIENT", var9, var7, 11.0F, var6.textMuted());
   }
}
