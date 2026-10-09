package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;

public class MobEspModule extends Module {
   public final ColorSetting hostile = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt(">\u0005!Qa\u0084\u0080"), Deobf.decrypt(">\u0005!Qa\u0084\u0080\u009a÷đĿŔŲ"), -45715));
   public final ColorSetting passive = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("&\u000b!Va\u009e\u0080"), Deobf.decrypt("&\u000b!Va\u009e\u0080\u009a÷đĿŔŲ"), -12654960));
   public final BooleanSetting passiveToo = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("&\u000b!Va\u009e\u0080\u009aÀđļ"), Deobf.decrypt("?\u00041I}\u008c\u0080\u009aäğĠňũƺƤƅǯȉȢə"), false));
   public final BooleanSetting tracers = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u00183Fm\u009a\u0096"), Deobf.decrypt("2\u00183R(\u0084\u008cÔñčųŝŲƣƬƅǶȎȥȊɐʒʠ˃˄̙Ͷ͚ͣϏήϚγυМвѝоҙҢӥ"), false));

   public MobEspModule() {
      super(Deobf.decrypt(";\u00050`[¸"), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàčųœůƿƵǌǮȃɠɇɜʂʼ"), Category.RENDER);
   }
}
