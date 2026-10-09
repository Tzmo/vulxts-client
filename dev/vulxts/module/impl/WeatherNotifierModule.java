package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.notification.NotificationManager;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import net.minecraft.class_1109;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3417;

public class WeatherNotifierModule extends Module {
   public final BooleanSetting rain = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("$\u000b;K"), Deobf.decrypt("7\u0004<J}\u0086\u0086ß´ĉĻŞŮǬƳǄǫȈɠəɇʁʽ˄˄͇ͤ͞;ΟΩ"), true));
   public final BooleanSetting thunder = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u0002'Kl\u008d\u0097"), Deobf.decrypt("7\u0004<J}\u0086\u0086ß´ĉĻŞŮǬƠƅǶȎȵɄɗʅʽ˃˃̞̱ͥ͞ΜήϔϡϔЎѾцѪқҽӴ"), true));
   public final BooleanSetting sound = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0005'Kl"), Deobf.decrypt("&\u00063\\(\u0089ÅÊýĐĴěůƢǡǀǣȅȨȊɐʈʮ˞ː̔"), true));
   public final ModeSetting output = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("9\u001f&U}\u009c"), Deobf.decrypt(">\u0005%\u0005|\u0080\u0080\u009a÷ĖĲŕŧƩǡǌǱɆȳɂɜʗʡ"), Deobf.decrypt("8\u0005&Ln\u0081\u0086Ûàėļŕ"), new String[]{Deobf.decrypt("8\u0005&Ln\u0081\u0086Ûàėļŕ"), Deobf.decrypt("5\u00023Q"), Deobf.decrypt("7\t&Lg\u0086ÅøõČ")}));
   private Boolean lastRaining;
   private Boolean lastThundering;

   public WeatherNotifierModule() {
      super(Deobf.decrypt("!\u000f3Q`\u008d\u0097ôûĊĺŝũƩƳ"), Deobf.decrypt("\"\u00027Hm\u008cÅÎûğĠŏĠƻƩǀǬɆȴɂɖˀʸ˕˖̅Ϳ͖ͣϏιϝϲώКдц"), Category.MISC);
   }

   protected void onEnable() {
      this.lastRaining = null;
      this.lastThundering = null;
   }

   public void onTick() {
      class_310 mc = class_310.method_1551();
      class_1937 level = mc.field_1687;
      if (level != null && mc.field_1724 != null) {
         boolean raining = level.method_8419();
         boolean thundering = level.method_8546();
         if (this.lastRaining != null && this.lastThundering != null) {
            if (thundering != this.lastThundering) {
               this.lastThundering = thundering;
               if ((Boolean)this.thunder.get()) {
                  if (thundering) {
                     this.notify(mc, Deobf.decrypt("\"\u0002'Kl\u008d\u0097ÉàđġŖ"), Deobf.decrypt("7J!Qg\u009a\u0088\u009aæđĿŗųǬƨǋ"), NotificationManager.Weather.THUNDER, true);
                  } else {
                     this.notify(mc, Deobf.decrypt("%\u001e=WeÈ\u0086ÖñğġŞŤ"), Deobf.decrypt("\"\u00027\u0005|\u0080\u0090ÔðěġěŨƭƲƅǲȇȳəɖʄ"), NotificationManager.Weather.CLEAR, false);
                  }
               }
            }

            if (raining != this.lastRaining) {
               this.lastRaining = raining;
               if ((Boolean)this.rain.get() && !thundering) {
                  if (raining) {
                     this.notify(mc, Deobf.decrypt("$\u000b;K"), Deobf.decrypt("$\u000b;K(\u009b\u0091ÛæĊĠěŴƣǡǃǣȊȬ"), NotificationManager.Weather.RAIN, true);
                  } else {
                     this.notify(mc, Deobf.decrypt("%\u0001;@{È\u0086ÖñğġŞŤ"), Deobf.decrypt("\"\u00027\u0005z\u0089\u008cÔ´ĖĲňĠƿƵǊǲȖȥɎ"), NotificationManager.Weather.CLEAR, false);
                  }
               }
            }
         } else {
            this.lastRaining = raining;
            this.lastThundering = thundering;
         }
      }

   }

   private void notify(class_310 mc, String title, String subtitle, NotificationManager.Weather weather, boolean started) {
      if (mc.field_1724 != null) {
         if (this.output.is(Deobf.decrypt("8\u0005&Ln\u0081\u0086Ûàėļŕ"))) {
            if (VulxtsClient.notifications() != null) {
               VulxtsClient.notifications().pushWeather(title, subtitle, weather, started);
            }
         } else {
            boolean actionBar = this.output.is(Deobf.decrypt("7\t&Lg\u0086ÅøõČ"));
            mc.field_1724.method_7353(class_2561.method_43470("§d[Vulxts] §f" + title + " — " + subtitle), actionBar);
         }

         if ((Boolean)this.sound.get()) {
            float pitch = started ? 1.2F : 0.8F;
            mc.method_1483().method_4873(class_1109.method_4757((class_3414)class_3417.field_14793.comp_349(), pitch, 0.6F));
         }
      }

   }
}
