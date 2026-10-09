package dev.vulxts.gui.widget;

import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModeWidget extends SettingWidget {
   private static final float LINE_HEIGHT = 16.0F;
   private static final float FONT_SIZE = 12.5F;
   private static final float GAP = 10.0F;
   private final ModeSetting setting;
   private final List optionBounds = new ArrayList();
   private int lines = 1;

   public ModeWidget(ThemeManager var1, ModeSetting var2) {
      super(var1, var2);
      this.setting = var2;
   }

   public float height(NVGRenderer var1) {
      return 17.0F + (float)this.lines * 16.0F + 3.0F;
   }

   public void render(NVGRenderer var1, float var2, float var3) {
      Theme var4 = this.theme();
      var1.text(this.setting.getName(), this.x, this.y + 8.0F, 12.5F, var4.textMuted());
      this.optionBounds.clear();
      float var5 = this.x;
      float var6 = this.y + 17.0F + 8.0F;
      this.lines = 1;

      float var11;
      for(Iterator var7 = this.setting.getModes().iterator(); var7.hasNext(); var5 += var11 + 5.0F) {
         String var8 = (String)var7.next();
         float var10 = var1.textWidth(var8, 11.5F);
         var11 = var10 + 12.0F;
         if (var5 + var11 > this.x + this.width && var5 > this.x) {
            var5 = this.x;
            var6 += 16.0F;
            ++this.lines;
         }

         boolean var12 = this.setting.is(var8);
         boolean var9 = var2 >= var5 && var2 <= var5 + var11 && var3 >= var6 - 8.0F && var3 <= var6 + 8.0F;
         int var14 = var12 ? Colors.withAlpha(var4.accent(), 0.24F) : Colors.withAlpha(var4.statusDisabled(), var9 ? 0.34F : 0.18F);
         var1.rect(var5, var6 - 7.0F, var11, 14.0F, 2.0F, var14);
         var1.rectOutline(var5, var6 - 7.0F, var11, 14.0F, 2.0F, 1.0F, Colors.withAlpha(var12 ? var4.accentBright() : var4.accent(), var12 ? 0.55F : 0.12F));
         if (var12) {
            var1.text(var8, var5 + 6.0F, var6, 11.5F, var4.accentBright());
         } else {
            var1.text(var8, var5 + 6.0F, var6, 11.5F, var9 ? var4.textPrimary() : var4.textDisabled());
         }

         this.optionBounds.add(new float[]{var5, var6 - 8.0F, var11});
      }

   }

   public boolean mouseClicked(float var1, float var2, int var3) {
      if (var3 != 0) {
         return false;
      } else {
         List var4 = this.setting.getModes();

         for(int var5 = 0; var5 < this.optionBounds.size() && var5 < var4.size(); ++var5) {
            float[] var6 = (float[])this.optionBounds.get(var5);
            if (var1 >= var6[0] && var1 <= var6[0] + var6[2] && var2 >= var6[1] && var2 <= var6[1] + 16.0F) {
               this.setting.set((String)var4.get(var5));
               UiSounds.select();
               return true;
            }
         }

         return false;
      }
   }
}
