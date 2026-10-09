package dev.vulxts.hud.components;

import dev.vulxts.hud.HudComponent;
import dev.vulxts.render.anim.Animation;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.CpsTracker;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;

public class KeystrokesHud extends HudComponent {
   private static final float KEY = 26.0F;
   private static final float GAP = 3.0F;
   private static final float FONT = 12.5F;
   private final ThemeManager themes;
   private final Map press = new HashMap();

   public KeystrokesHud(ThemeManager var1, BooleanSupplier var2) {
      super(Deobf.decrypt("\u001d\u000f+V|\u009a\u008aÑñč"), 0.03F, 0.72F, var2);
      this.themes = var1;
   }

   public float measureWidth(NVGRenderer var1) {
      return 84.0F;
   }

   public float measureHeight(NVGRenderer var1) {
      float var2 = 55.0F;
      var2 += 29.0F;
      float var4;
      return var4 = var2 + 18.6F;
   }

   private float pressT(String var1, boolean var2) {
      Animation var3 = (Animation)this.press.computeIfAbsent(var1, (var0) -> {
         return new Animation(110.0F, 0.0F);
      });
      var3.setTarget(var2 ? 1.0F : 0.0F);
      return var3.value();
   }

   private void key(NVGRenderer var1, Theme var2, String var3, String var4, boolean var5, float var6, float var7, float var8, float var9) {
      float var10 = this.pressT(var3, var5);
      int var11 = Colors.lerp(Colors.withAlpha(-15462118, 0.78F), Colors.withAlpha(var2.accent(), 0.85F), var10);
      var1.rect(var6, var7, var8, var9, 2.0F, var11);
      var1.rectOutline(var6, var7, var8, var9, 2.0F, 1.0F, Colors.withAlpha(var2.accentBright(), 0.16F + 0.38F * var10));
      int var12 = Colors.lerp(var2.textMuted(), -1, var10);
      var1.text(var4, var6 + (var8 - var1.textWidth(var4, 12.5F)) / 2.0F, var7 + var9 / 2.0F, 12.5F, var12);
   }

   public void render(NVGRenderer var1, float var2, float var3, float var4, float var5) {
      Theme var6 = this.themes.current();
      class_315 var7 = class_310.method_1551().field_1690;
      this.key(var1, var6, Deobf.decrypt("\u0001"), Deobf.decrypt("!"), isDown(var7.field_1894), var2 + 26.0F + 3.0F, var3, 26.0F, 26.0F);
      float var13;
      this.key(var1, var6, Deobf.decrypt("\u0017"), Deobf.decrypt("7"), isDown(var7.field_1913), var2, var13 = var3 + 29.0F, 26.0F, 26.0F);
      this.key(var1, var6, Deobf.decrypt("\u0005"), Deobf.decrypt("%"), isDown(var7.field_1881), var2 + 26.0F + 3.0F, var13, 26.0F, 26.0F);
      this.key(var1, var6, Deobf.decrypt("\u0012"), Deobf.decrypt("2"), isDown(var7.field_1849), var2 + 58.0F, var13, 26.0F, 26.0F);
      float var9 = (var4 - 3.0F) / 2.0F;
      float var8;
      this.key(var1, var6, Deobf.decrypt("\u001a\u00070"), "LMB " + CpsTracker.get(0), isDown(var7.field_1886), var2, var8 = var13 + 29.0F, var9, 26.0F);
      this.key(var1, var6, Deobf.decrypt("\u0004\u00070"), "RMB " + CpsTracker.get(1), isDown(var7.field_1904), var2 + var9 + 3.0F, var8, var9, 26.0F);
      float var10 = this.pressT(Deobf.decrypt("\u0005\u001a3Fm"), isDown(var7.field_1903));
      float var11 = 15.6F;
      int var12 = Colors.lerp(Colors.withAlpha(-15462118, 0.78F), Colors.withAlpha(var6.accent(), 0.85F), var10);
      float var15;
      var1.rect(var2, var15 = var8 + 29.0F, var4, var11, 2.0F, var12);
      var1.rectOutline(var2, var15, var4, var11, 2.0F, 1.0F, Colors.withAlpha(var6.accentBright(), 0.16F + 0.38F * var10));
      var1.rect(var2 + var4 * 0.25F, var15 + var11 / 2.0F - 1.25F, var4 * 0.5F, 2.5F, 1.25F, Colors.lerp(var6.textMuted(), -1, var10));
   }

   private static boolean isDown(class_304 var0) {
      return var0.method_1434();
   }
}
