package dev.vulxts.gui.widget;

import dev.vulxts.gui.ClickGuiScreen;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BlockListSetting;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;
import net.minecraft.class_310;
import net.minecraft.class_437;

public class BlockListWidget extends SettingWidget {
   private static final float ROW = 26.0F;
   private final BlockListSetting setting;

   public BlockListWidget(ThemeManager var1, BlockListSetting var2) {
      super(var1, var2);
      this.setting = var2;
   }

   public float height(NVGRenderer var1) {
      return 26.0F;
   }

   public void render(NVGRenderer var1, float var2, float var3) {
      Theme var4 = this.theme();
      float var5 = this.y + 13.0F;
      var1.text(this.setting.getName(), this.x, var5, 12.5F, var4.textMuted());
      float var6 = 88.0F;
      float var7 = 18.0F;
      float var8 = this.x + this.width - var6;
      float var9 = var5 - var7 / 2.0F;
      boolean var10 = var2 >= var8 && var2 <= var8 + var6 && var3 >= var9 && var3 <= var9 + var7;
      var1.rectGradient(var8, var9, var6, var7, 4.0F, var4.headerTop(), var4.headerBottom(), true);
      var1.rect(var8, var9 + 4.0F, 2.0F, var7 - 8.0F, 1.0F, var10 ? var4.accentBright() : var4.accent());
      var1.rectOutline(var8, var9, var6, var7, 2.0F, 1.1F, Colors.withAlpha(var10 ? var4.accentBright() : var4.accent(), var10 ? 0.9F : 0.32F));
      String var11 = Deobf.decrypt("&\u00031N(ª\u0089Õ÷ĕ");
      float var12 = var1.textWidth(var11, 12.0F);
      var1.textGradient(var11, var8 + (var6 - var12) / 2.0F, var9 + var7 / 2.0F, 12.0F, var4.accentBright(), var4.accent());
      long var10000 = this.setting.enabledCount();
      String var13 = "" + var10000 + "/" + this.setting.size();
      var1.text(var13, var8 - 8.0F - var1.textWidth(var13, 11.5F), var5, 11.5F, var4.textDisabled());
   }

   public boolean mouseClicked(float var1, float var2, int var3) {
      if (var3 == 0 && this.contains(var1, var2)) {
         class_437 var5 = class_310.method_1551().field_1755;
         if (var5 instanceof ClickGuiScreen) {
            ClickGuiScreen var5 = (ClickGuiScreen)var5;
            var5.openBlockPicker(this.setting);
            UiSounds.select();
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
