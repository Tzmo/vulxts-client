package dev.vulxts.gui.panel;

import dev.vulxts.gui.ClickGuiState;
import dev.vulxts.gui.widget.BlockListWidget;
import dev.vulxts.gui.widget.BooleanWidget;
import dev.vulxts.gui.widget.ColorWidget;
import dev.vulxts.gui.widget.IconListWidget;
import dev.vulxts.gui.widget.KeybindWidget;
import dev.vulxts.gui.widget.ModeWidget;
import dev.vulxts.gui.widget.SettingWidget;
import dev.vulxts.gui.widget.SliderWidget;
import dev.vulxts.gui.widget.StringWidget;
import dev.vulxts.module.Module;
import dev.vulxts.render.anim.Animation;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.settings.BlockListSetting;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.IconListSetting;
import dev.vulxts.settings.KeybindSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.Setting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.settings.StringSetting;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModuleEntry {
   public static final float ROW_H = 30.0F;
   private static final float RADIUS = 8.0F;
   private static final float SETTING_INDENT = 12.0F;
   private final Module module;
   private final ThemeManager themes;
   private final ClickGuiState state;
   private final String key;
   private final List widgets = new ArrayList();
   private final Animation hover = new Animation(140.0F, 0.0F);
   private final Animation enable = new Animation(160.0F, 0.0F);
   private final Animation expand;
   private float x;
   private float y;
   private float width;

   public ModuleEntry(Module var1, ThemeManager var2, ClickGuiState var3) {
      this.module = var1;
      this.themes = var2;
      this.state = var3;
      String var10001 = var1.getName();
      this.key = var10001 + "@" + var1.getCategory().name();
      this.expand = new Animation(190.0F, var3.isExpanded(this.key) ? 1.0F : 0.0F);
      this.enable.snapTo(var1.isEnabled() ? 1.0F : 0.0F);
      Iterator var4 = var1.getSettings().iterator();

      while(var4.hasNext()) {
         Setting var5 = (Setting)var4.next();
         if (var5 instanceof BooleanSetting var6) {
            this.widgets.add(new BooleanWidget(var2, var6));
         } else if (var5 instanceof SliderSetting var7) {
            this.widgets.add(new SliderWidget(var2, var7));
         } else if (var5 instanceof ModeSetting var8) {
            this.widgets.add(new ModeWidget(var2, var8));
         } else if (var5 instanceof ColorSetting var9) {
            this.widgets.add(new ColorWidget(var2, var9));
         } else if (var5 instanceof BlockListSetting var10) {
            this.widgets.add(new BlockListWidget(var2, var10));
         } else if (var5 instanceof IconListSetting var11) {
            this.widgets.add(new IconListWidget(var2, var11));
         } else if (var5 instanceof StringSetting var12) {
            this.widgets.add(new StringWidget(var2, var12));
         } else if (var5 instanceof KeybindSetting var13) {
            this.widgets.add(new KeybindWidget(var2, var13));
         }
      }

      this.widgets.add(new KeybindWidget(var2, var1.getKeybind()));
   }

   public Module getModule() {
      return this.module;
   }

   public boolean isFavourite() {
      return this.state.isFavourite(this.key);
   }

   private void drawFavourite(NVGRenderer var1, float var2, float var3, int var4) {
      for(int var5 = 0; var5 < 10; ++var5) {
         double var6 = -1.5707963267948966 + (double)var5 * Math.PI / 5.0;
         double var8 = var6 + 0.6283185307179586;
         float var10 = var5 % 2 == 0 ? 5.5F : 2.5F;
         float var11 = var5 % 2 == 0 ? 2.5F : 5.5F;
         var1.line(var2 + (float)Math.cos(var6) * var10, var3 + (float)Math.sin(var6) * var10, var2 + (float)Math.cos(var8) * var11, var3 + (float)Math.sin(var8) * var11, 1.2F, var4);
      }

   }

   public void setBounds(float var1, float var2, float var3) {
      this.x = var1;
      this.y = var2;
      this.width = var3;
   }

   private float settingsHeight(NVGRenderer var1) {
      float var2 = 6.0F;
      Iterator var3 = this.widgets.iterator();

      while(var3.hasNext()) {
         SettingWidget var4 = (SettingWidget)var3.next();
         if (var4.isVisible()) {
            var2 += var4.height(var1) + 3.0F;
         }
      }

      return var2 + 3.0F;
   }

   public float height(NVGRenderer var1) {
      float var2 = this.expand.value();
      return 30.0F + (var2 <= 0.005F ? 0.0F : var2 * this.settingsHeight(var1));
   }

   public void render(NVGRenderer var1, float var2, float var3, float var4) {
      Theme var6 = this.theme();
      boolean var5 = var2 >= this.x && var2 <= this.x + this.width && var3 >= this.y && var3 <= this.y + 30.0F;
      if (var5 && this.hover.getTarget() < 0.5F) {
         UiSounds.hover();
      }

      this.hover.setTarget(var5 ? 1.0F : 0.0F);
      this.enable.setTarget(this.module.isEnabled() ? 1.0F : 0.0F);
      float var8 = this.hover.value();
      float var9 = this.enable.value();
      float var10 = this.expand.value();
      var1.save();
      var1.alpha(var4);
      var1.rect(this.x, this.y, this.width, 30.0F, 2.0F, -14671066);
      if (var9 > 0.01F) {
         var1.save();
         var1.alpha(var9);
         var1.rect(this.x, this.y, this.width, 30.0F, 2.0F, var6.moduleActiveFill());
         var1.rect(this.x + 8.0F, this.y, 24.0F, 2.0F, 1.0F, var6.accent());
         var1.restore();
      }

      if (var8 > 0.01F) {
         var1.rect(this.x, this.y, this.width, 30.0F, 4.0F, Colors.withAlpha(var6.accent(), 0.07F * var8));
      }

      float var11 = this.y + 15.0F;
      var1.save();
      var1.scissor(this.x + 10.0F, this.y, this.width - 68.0F, 30.0F);
      if (var9 > 0.01F) {
         var1.save();
         var1.alpha(var9);
         var1.text(this.module.getName(), this.x + 10.0F, var11, 12.5F, var6.textPrimary());
         var1.restore();
      }

      if (var9 < 0.99F) {
         var1.save();
         var1.alpha(1.0F - var9);
         int var12 = Colors.lerp(var6.textMuted(), var6.textPrimary(), var8);
         var1.text(this.module.getName(), this.x + 10.0F, var11, 12.5F, var12);
         var1.restore();
      }

      var1.restore();
      this.drawFavourite(var1, this.x + this.width - 47.0F, var11, this.isFavourite() ? -1918092 : var6.textDisabled());
      float var22 = 22.0F;
      float var13 = 10.0F;
      float var14 = this.x + this.width - var22 - 8.0F;
      float var15 = var11 - var13 / 2.0F;
      int var16 = Colors.lerp(Colors.withAlpha(var6.statusDisabled(), 0.55F), Colors.withAlpha(var6.accent(), 0.75F), var9);
      var1.rect(var14, var15, var22, var13, 2.0F, var16);
      float var17 = var14 + 5.0F + var9 * (var22 - 10.0F);
      var1.rect(var17 - 3.0F, var11 - 3.0F, 6.0F, 6.0F, 1.4F, Colors.lerp(var6.textMuted(), var6.textPrimary(), var9));
      if (var10 > 0.005F) {
         float var18 = this.settingsHeight(var1) * var10;
         var1.save();
         var1.scissor(this.x, this.y + 30.0F, this.width, var18);
         var1.alpha(var10);
         var1.rect(this.x + 3.0F, this.y + 30.0F - 3.0F, this.width - 6.0F, var18, 2.0F, -15395047);
         var1.rectOutline(this.x + 3.0F, this.y + 30.0F - 3.0F, this.width - 6.0F, var18, 2.0F, 1.0F, Colors.withAlpha(var6.accent(), 0.16F));
         var1.rect(this.x + 12.0F, this.y + 30.0F - 3.0F, 30.0F, 1.5F, 0.75F, Colors.withAlpha(var6.accent(), 0.45F));
         float var19 = this.y + 30.0F + 6.0F;
         Iterator var19 = this.widgets.iterator();

         while(var19.hasNext()) {
            SettingWidget var21 = (SettingWidget)var19.next();
            if (var21.isVisible()) {
               var21.setBounds(this.x + 12.0F, var19, this.width - 24.0F);
               var21.render(var1, var2, var3);
               var19 += var21.height(var1) + 3.0F;
            }
         }

         var1.restore();
      }

      var1.restore();
   }

   private Theme theme() {
      return this.themes.current();
   }

   public boolean mouseClicked(float var1, float var2, int var3) {
      if (var1 >= this.x && var1 <= this.x + this.width && var2 >= this.y && var2 <= this.y + 30.0F) {
         if (var3 == 0 && var1 >= this.x + this.width - 58.0F && var1 < this.x + this.width - 36.0F) {
            this.state.toggleFavourite(this.key);
            UiSounds.select();
            return true;
         } else {
            if (var3 == 0) {
               this.module.toggle();
               UiSounds.toggle(this.module.isEnabled());
            } else if (var3 == 1) {
               boolean var6 = !(this.expand.getTarget() > 0.5F);
               this.expand.setTarget(var6 ? 1.0F : 0.0F);
               this.state.setExpanded(this.key, var6);
               UiSounds.select();
            }

            return true;
         }
      } else if (this.expand.getTarget() > 0.5F && var2 >= this.y + 30.0F && var2 <= this.y + this.height((NVGRenderer)null)) {
         Iterator var4 = this.widgets.iterator();

         while(var4.hasNext()) {
            SettingWidget var5 = (SettingWidget)var4.next();
            if (var5.isVisible() && var5.mouseClicked(var1, var2, var3)) {
               return true;
            }
         }

         return var1 >= this.x && var1 <= this.x + this.width;
      } else {
         return false;
      }
   }

   public void mouseDragged(float var1, float var2) {
      Iterator var3 = this.widgets.iterator();

      while(var3.hasNext()) {
         SettingWidget var4 = (SettingWidget)var3.next();
         var4.mouseDragged(var1, var2);
      }

   }

   public void mouseReleased() {
      Iterator var1 = this.widgets.iterator();

      while(var1.hasNext()) {
         SettingWidget var2 = (SettingWidget)var1.next();
         var2.mouseReleased();
      }

   }

   public boolean keyPressed(int var1) {
      Iterator var2 = this.widgets.iterator();

      SettingWidget var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (SettingWidget)var2.next();
      } while(!var3.keyPressed(var1));

      return true;
   }

   public boolean charTyped(int var1) {
      Iterator var2 = this.widgets.iterator();

      SettingWidget var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (SettingWidget)var2.next();
      } while(!var3.charTyped(var1));

      return true;
   }

   public boolean isListening() {
      Iterator var1 = this.widgets.iterator();

      SettingWidget var2;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         var2 = (SettingWidget)var1.next();
      } while(!var2.isListening());

      return true;
   }
}
