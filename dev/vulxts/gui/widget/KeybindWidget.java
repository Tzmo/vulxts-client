package dev.vulxts.gui.widget;

import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.KeybindSetting;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;

public class KeybindWidget extends SettingWidget {
   public static final float HEIGHT = 22.0F;
   private final KeybindSetting setting;
   private boolean listening;

   public KeybindWidget(ThemeManager var1, KeybindSetting var2) {
      super(var1, var2);
      this.setting = var2;
   }

   public float height(NVGRenderer var1) {
      return 22.0F;
   }

   public void render(NVGRenderer var1, float var2, float var3) {
      Theme var4 = this.theme();
      float var5 = this.y + 11.0F;
      var1.text(this.setting.getName(), this.x, var5, 12.5F, var4.textMuted());
      String var6 = this.listening ? Deobf.decrypt("XD|") : this.setting.keyName();
      float var7 = Math.max(30.0F, var1.textWidth(var6, 11.5F) + 12.0F);
      float var8 = this.x + this.width - var7;
      float var9 = 16.0F;
      float var10 = var5 - var9 / 2.0F;
      int var11 = this.listening ? Colors.withAlpha(var4.accent(), 0.3F) : Colors.withAlpha(-16777216, 0.45F);
      var1.rect(var8, var10, var7, var9, 2.0F, var11);
      var1.rect(var8, var10 + 3.0F, 2.0F, var9 - 6.0F, 1.0F, this.listening ? var4.accentBright() : var4.textDisabled());
      if (this.listening) {
         float var12 = (float)(0.5 + 0.5 * Math.sin((double)System.nanoTime() / 2.2E8));
         var1.rectOutline(var8, var10, var7, var9, 2.0F, 1.2F, Colors.withAlpha(var4.accentBright(), 0.4F + 0.6F * var12));
      } else {
         var1.rectOutline(var8, var10, var7, var9, 2.0F, 1.0F, Colors.withAlpha(var4.accent(), 0.16F));
      }

      var1.text(var6, var8 + (var7 - var1.textWidth(var6, 11.5F)) / 2.0F, var5, 11.5F, this.listening ? var4.accentBright() : var4.textPrimary());
   }

   public boolean mouseClicked(float var1, float var2, int var3) {
      if (this.listening) {
         this.setting.set(var3);
         this.listening = false;
         UiSounds.keybindSet();
         return true;
      } else if (var3 == 0 && this.contains(var1, var2)) {
         this.listening = true;
         UiSounds.keybindListen();
         return true;
      } else {
         return false;
      }
   }

   public boolean keyPressed(int var1) {
      if (!this.listening) {
         return false;
      } else {
         if (var1 == 256) {
            this.setting.set(-1);
         } else {
            this.setting.set(var1);
         }

         this.listening = false;
         UiSounds.keybindSet();
         return true;
      }
   }

   public boolean isListening() {
      return this.listening;
   }
}
