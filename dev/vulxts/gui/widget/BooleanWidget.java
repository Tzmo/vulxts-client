package dev.vulxts.gui.widget;

import dev.vulxts.render.anim.Animation;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;

public class BooleanWidget extends SettingWidget {
   public static final float HEIGHT = 22.0F;
   private static final float BOX = 14.0F;
   private final BooleanSetting setting;
   private final Animation check = new Animation(150.0F, 0.0F);

   public BooleanWidget(ThemeManager var1, BooleanSetting var2) {
      super(var1, var2);
      this.setting = var2;
      this.check.snapTo((Boolean)var2.get() ? 1.0F : 0.0F);
   }

   public float height(NVGRenderer var1) {
      return 22.0F;
   }

   public void render(NVGRenderer var1, float var2, float var3) {
      Theme var4 = this.theme();
      float var5 = this.y + 11.0F;
      var1.text(this.setting.getName(), this.x, var5, 12.5F, var4.textMuted());
      this.check.setTarget((Boolean)this.setting.get() ? 1.0F : 0.0F);
      float var6 = this.check.value();
      float var7 = 28.0F;
      float var8 = 14.0F;
      float var9 = this.x + this.width - var7;
      float var10 = var5 - var8 / 2.0F;
      int var11 = Colors.lerp(Colors.withAlpha(var4.statusDisabled(), 0.55F), Colors.withAlpha(var4.accent(), 0.82F), var6);
      var1.rect(var9, var10, var7, var8, 2.0F, var11);
      var1.rectOutline(var9, var10, var7, var8, 2.0F, 1.0F, Colors.withAlpha(var4.accentBright(), 0.15F + 0.45F * var6));
      float var12 = var9 + 7.0F + var6 * (var7 - 14.0F);
      if (var6 > 0.5F) {
         var1.glow(var12 - 4.0F, var5 - 4.0F, 8.0F, 8.0F, 1.5F, 3.0F, Colors.withAlpha(var4.accent(), 0.35F));
      }

      var1.rect(var12 - 4.0F, var5 - 4.0F, 8.0F, 8.0F, 1.5F, Colors.lerp(var4.textMuted(), var4.textPrimary(), var6));
   }

   public boolean mouseClicked(float var1, float var2, int var3) {
      if (var3 == 0 && this.contains(var1, var2)) {
         this.setting.toggle();
         UiSounds.checkbox((Boolean)this.setting.get());
         return true;
      } else {
         return false;
      }
   }
}
