package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;

public class PlayerEspModule extends Module {
   public final ModeSetting style = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("%\u001e+Im"), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàŞĠŏŹƠƤ"), Deobf.decrypt("9\u001f&Ia\u0086\u0080"), new String[]{Deobf.decrypt("4\u0005*"), Deobf.decrypt("9\u001f&Ia\u0086\u0080"), Deobf.decrypt("1\u0006=R")}));
   public final ColorSetting color = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("5\u0005>Jz"), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàŞİŔŬƣƳ"), -49508));
   public final BooleanSetting tracers = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u00183Fm\u009a\u0096"), Deobf.decrypt("2\u00183R(\u0084\u008cÔñčųŝŲƣƬƅǶȎȥȊɐʒʠ˃˄̙Ͷ͚ͣϏήϚγυМвѝо҄ҡӦӽԇԵ"), false));

   public PlayerEspModule() {
      super(Deobf.decrypt("&\u00063\\m\u009a éÄ"), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàčųŋŬƭƸǀǰȕɠɞɛʒʠ˅ː̷̙̈́Ͱ\u0383ζφ"), Category.RENDER);
   }
}
