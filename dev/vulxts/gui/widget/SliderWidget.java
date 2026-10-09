package dev.vulxts.gui.widget;

import dev.vulxts.render.anim.Animation;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;

public class SliderWidget extends SettingWidget {
   public static final float HEIGHT = 27.0F;
   private static final float BAR_HEIGHT = 5.0F;
   private static final float KNOB_RADIUS = 5.0F;
   private final SliderSetting setting;
   private final Animation fill = new Animation(90.0F, 0.0F);
   private boolean dragging;

   public SliderWidget(ThemeManager var1, SliderSetting var2) {
      super(var1, var2);
      this.setting = var2;
      this.fill.snapTo((float)var2.getNormalized());
   }

   public float height(NVGRenderer var1) {
      return 27.0F;
   }

   public void render(NVGRenderer var1, float var2, float var3) {
      Theme var4 = this.theme();
      float var5 = this.y + 8.0F;
      var1.text(this.setting.getName(), this.x, var5, 12.5F, var4.textMuted());
      String var6 = this.setting.formatValue();
      float var7 = var1.textWidth(var6, 11.0F) + 10.0F;
      float var8 = this.x + this.width - var7;
      var1.rect(var8, var5 - 7.0F, var7, 14.0F, 2.0F, Colors.withAlpha(var4.accent(), 0.12F));
      var1.text(var6, var8 + 5.0F, var5, 11.0F, var4.accentBright());
      float var9 = this.y + 27.0F - 5.0F - 5.0F;
      this.fill.setTarget((float)this.setting.getNormalized());
      float var10 = Math.clamp(this.fill.value(), 0.0F, 1.0F);
      var1.rect(this.x, var9 + 1.0F, this.width, 3.0F, 0.8F, Colors.withAlpha(var4.statusDisabled(), 0.55F));
      float var11 = Math.max(3.0F, var10 * this.width);
      var1.rectGradient(this.x, var9 + 1.0F, var11, 3.0F, 0.8F, var4.accent(), var4.accentBright(), false);
      float var12 = this.x + var10 * this.width;
      if (this.dragging) {
         var1.glow(var12 - 4.0F, var9 - 1.5F, 8.0F, 8.0F, 1.0F, 6.0F, var4.accentHover());
      }

      var1.save();
      var1.translate(var12, var9 + 2.5F);
      var1.rotate((float)Math.toRadians(45.0));
      var1.rect(-3.5F, -3.5F, 7.0F, 7.0F, 1.0F, var4.accentBright());
      var1.rect(-1.5F, -1.5F, 3.0F, 3.0F, 0.5F, var4.textPrimary());
      var1.restore();
   }

   public boolean mouseClicked(float var1, float var2, int var3) {
      if (var3 == 0 && this.contains(var1, var2) && !(var2 < this.y + 10.0F)) {
         this.dragging = true;
         this.applyMouse(var1);
         return true;
      } else {
         return false;
      }
   }

   public void mouseDragged(float var1, float var2) {
      if (this.dragging) {
         this.applyMouse(var1);
      }

   }

   public void mouseReleased() {
      this.dragging = false;
   }

   private void applyMouse(float var1) {
      double var2 = this.setting.getNormalized();
      this.setting.setNormalized((double)((var1 - this.x) / this.width));
      if (this.setting.getNormalized() != var2) {
         UiSounds.sliderTick((float)this.setting.getNormalized());
      }

   }
}
