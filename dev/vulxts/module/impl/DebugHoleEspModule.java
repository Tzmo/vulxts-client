package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.render.HoleEspRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;

public class DebugHoleEspModule extends Module {
   public final ModeSetting depth = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("2\u000f\"Q`"), Deobf.decrypt(">\u0005>@(\u008c\u0080ÊàĖųŘŨƩƢǎ"), Deobf.decrypt("D"), new String[]{Deobf.decrypt("D"), Deobf.decrypt("E"), Deobf.decrypt("7\u0004+")}));
   public final ColorSetting safe = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("%\u000b4@"), Deobf.decrypt("%\u000b4@(\u0080\u008aÖñŞİŔŬƣƳ"), -12654960));
   public final ColorSetting unsafe = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("#\u0004!Dn\u008d"), Deobf.decrypt("#\u0004!Dn\u008dÅÒûĒĶěţƣƭǊǰ"), -45715));
   public final BooleanSetting tracers = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u00183Fm\u009a\u0096"), Deobf.decrypt("2\u00183R(\u0084\u008cÔñčųŝŲƣƬƅǶȎȥȊɐʒʠ˃˄̙Ͷ͚ͣϏήϚγυМвѝоҜҢӫӡ"), false));

   public DebugHoleEspModule() {
      super(Deobf.decrypt("2\u000f0Po \u008aÖñĻĀū"), Deobf.decrypt(";\u000b N{È\u0096ÛòěųŘŲƵƲǑǣȊɭɚɅʐ˯˘˘̝Ͳ̀"), Category.RENDER);
   }

   public void onTick() {
      HoleEspRenderer.scan(this);
   }

   protected void onDisable() {
      HoleEspRenderer.clear();
   }
}
