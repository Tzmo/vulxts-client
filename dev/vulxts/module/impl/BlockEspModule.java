package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.render.BlockEspRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BlockListSetting;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import java.util.Objects;

public class BlockEspModule extends Module {
   public final BlockListSetting targets = (BlockListSetting)this.addSetting(new BlockListSetting(Deobf.decrypt("\"\u000b Bm\u009cÅøøđİŐų"), Deobf.decrypt("&\u00031N(\u009f\u008dÓ÷ĖųřŬƣƢǎǱɆȴɅȓʈʦ˗˟̝;͔\u0379Λ")));
   public final ModeSetting shapeMode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("%\u00023UmÈ¨Õðě"), Deobf.decrypt(">\u0005%\u0005`\u0081\u0082ÒøėĴœŴƿǡǄǰȃɠɎɁʁʸ˞"), Deobf.decrypt("4\u0005&M"), new String[]{Deobf.decrypt("4\u0005&M"), Deobf.decrypt(":\u0003<@{"), Deobf.decrypt("%\u00036@{")}));
   public final ColorSetting lineColor = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("2\u000f4D}\u0084\u0091\u009aÛċħŗũƢƤƅǁȉȬɅɁ"), Deobf.decrypt("5\u0005>JzÈ\u0090ÉñĚųŝůƾǡǋǧȑȬɓȓʁʫ˔˒̷͑̕ͽ\u0380ιϞϠ"), -16711736));
   public final ColorSetting sideColor = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("0\u0003>I(§\u0093ßæĒĲł"), Deobf.decrypt("2\u000f4D}\u0084\u0091\u009aòėĿŗĠƸƨǋǶ"), 419495880));
   public final BooleanSetting tracers = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u00183Fm\u009a\u0096"), Deobf.decrypt("2\u00183R(\u0084\u008cÔñčųŝŲƣƬƅǶȎȥȊɐʒʠ˃˄̙Ͷ͚ͣϏήϚγυМвѝоҖҡӨӧԉ"), false));
   public final BooleanSetting tracer = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u00183Fm\u009a"), Deobf.decrypt("%\u000f1Jf\u008c\u0084ÈíŞħŉšƯƤǗƢȃȮɋɑʌʪ"), true));
   public final ColorSetting tracerColor = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("2\u000f4D}\u0084\u0091\u009aÀČĲŘťƾǡǱǫȈȴ"), Deobf.decrypt("\"\u00183Fm\u009aÅÖýĐĶěţƣƭǊǰɆɯȊɒʌʿ˘˖"), 2097217480));
   public final SliderSetting highlightAlpha = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(">\u00035Md\u0081\u0082ÒàŞĒŗŰƤƠ"), Deobf.decrypt("4\u0005*\u0005g\u0098\u0084ÙýĊĪ"), 255.0, 0.0, 255.0, 5.0));
   public final SliderSetting rangeExtraChunks = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("$\u000b<BmÈ ÂàČĲěŃƤƴǋǩȕ"), Deobf.decrypt("3\u0012&WiÈ\u0096ÙõĐųŉšƨƨǐǱɆȢɏɊʏʡ˔ʗ̃Ͳ͝͵ΊΨΕϷωЎХєѰҗҨ"), 8.0, 0.0, 24.0, 1.0));

   public BlockEspModule() {
      super(Deobf.decrypt("4\u0006=Fc\u00ad¶ê"), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàčųŘŨƣƲǀǬɆȢɆɜʃʤ˃ʗ̅Ϳ́;ΚνϝγϗМнљѭ"), Category.RENDER);
      this.targets.seedDefaults();
      BooleanSetting var10000 = this.tracer;
      BooleanSetting var10001 = this.tracers;
      Objects.requireNonNull(var10001);
      var10000.visibleWhen(var10001::get);
      ColorSetting var1 = this.tracerColor;
      var10001 = this.tracers;
      Objects.requireNonNull(var10001);
      var1.visibleWhen(var10001::get);
   }

   public void onTick() {
      BlockEspRenderer.scan(this);
   }

   protected void onDisable() {
      BlockEspRenderer.clear();
   }
}
