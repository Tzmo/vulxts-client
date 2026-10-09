package dev.vulxts.module.impl;

import dev.vulxts.license.ProtectedContent;
import dev.vulxts.module.AimAssistCompute;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AimAssistModule extends Module {
   private static final Logger LOG = LoggerFactory.getLogger(Deobf.decrypt(" \u001f>]|\u009b¦ÖýěĽŏįƍƨǈǃȕȳɃɀʔ"));
   public final SliderSetting range = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("$\u000b<Bm"), Deobf.decrypt("7\u0019!L{\u009cÅÛúćųŏšƾƦǀǶɆȷɃɇʈʦ˞ʗ̅Ϳ͚͢ϏξϜϠϔМпіѻ"), 4.0, 1.0, 8.0, 0.5, Deobf.decrypt("\u001b")));
   public final SliderSetting speed = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001a7@l"), Deobf.decrypt(">\u0005%\u0005n\u0089\u0096Î´ĊĻŞĠƭƨǈƢȏȳȊɃʕʣ˜˒̷̛̕\u0379Άνϝ϶ϒѝѬЕѭҚҬӷӴԋԢՏԴ"), 4.0, 1.0, 10.0, 1.0));
   public final SliderSetting smoothness = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u0007=J|\u0080\u008bßçč"), Deobf.decrypt(">\u0005%\u0005m\u0089\u0096ßðŞżěŨƹƬǄǬɆȴɂɖˀʿ˅˛̷̝͚͢ϏϲϝϺχЕдчоӉӭӴөԍԨՉյ\u0590֜֒"), 6.0, 1.0, 10.0, 1.0));
   public final ModeSetting targetPart = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("\"\u000b Bm\u009c"), Deobf.decrypt("!\u0002;F`È\u0095ÛæĊųŔŦǬƵǍǧɆȴɋɁʇʪ˄ʗ̅\u0378̓ͰΆηΕϲϔ"), Deobf.decrypt("4\u00056\\"), new String[]{Deobf.decrypt(">\u000f3A"), Deobf.decrypt("4\u00056\\"), Deobf.decrypt("0\u000f7Q"), Deobf.decrypt("8\u000f3Wm\u009b\u0091")}));
   public final SliderSetting fov = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("0%\u0004"), Deobf.decrypt("9\u0004>\\(\u0089\u0096ÉýčħěŷƥƵǍǫȈɠɞɛʉʼʐˑ̐ʹ͚ͿΈϺϖϼώИѱНЯӌӽҧҹՂԦՑձו֏\u05c9ץ\u0602\u061cٞٳ"), 180.0, 10.0, 180.0, 5.0, Deobf.decrypt("Æ")));
   public final BooleanSetting vertical = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(" \u000f Qa\u008b\u0084Ö"), Deobf.decrypt("7\u0006!J(\u008b\u008aÈæěİŏĠƼƨǑǡȎɠȂɆʐˠ˔˘̆\u0379̽̚ϏδϚϧ\u0380ЗФцѪӔҴӦӳ"), true));
   public final BooleanSetting players = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("&\u00063\\m\u009a\u0096"), Deobf.decrypt("\"\u000b Bm\u009cÅÕàĖĶŉĠƼƭǄǻȃȲə"), true));
   public final BooleanSetting hostiles = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u0005!Qa\u0084\u0080É"), Deobf.decrypt("\"\u000b Bm\u009cÅÒûčħŒŬƩǡǈǭȄȳ"), false));
   public final BooleanSetting passive = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("&\u000b!Va\u009e\u0080"), Deobf.decrypt("\"\u000b Bm\u009cÅÊõčĠŒŶƩǡǈǭȄȳ"), false));
   public final BooleanSetting invisibles = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("?\u0004$L{\u0081\u0087Öñč"), Deobf.decrypt("7\u0006!J(\u009c\u0084ÈóěħěũƢƷǌǱȏȢɆɖˀʪ˞˃̘͚ͣʹΜ"), false));
   public final BooleanSetting wallCheck = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("!\u000b>I(«\u008dß÷ĕ"), Deobf.decrypt("9\u0004>\\(\u0089\u0096ÉýčħěŴƭƳǂǧȒȳȊɊʏʺʐ˔̐\u0379̓ͰΌήπϲόБШЕѭґҨ"), false));
   public final BooleanSetting alwaysActive = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u0006%Dq\u009bÅû÷Ċĺōť"), Deobf.decrypt("7\u0019!L{\u009cÅÛøĒųŏŨƩǡǑǫȋȥȊ∧ˀʠ˖ˑ̪͑̓;\u0381ζόγϗЕиљѻӔҬӳӰԃԤՖմ֛։֛֢؟\u061dٖؾڕڲۃڿܞܳݽݴ߃ޫ߉ߘߩࠩࡦ"), true));
   public final BooleanSetting sticky = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u001e;Fc\u0091ÅîõČĴŞŴ"), Deobf.decrypt("=\u000f7U(\u0087\u008bß´ĊĲŉŧƩƵƅǷȈȴɃɟˀʦ˄ʗ̝Ͳ͒ͧΊΩΕϡρГжѐ"), true));
   private final AimAssistCompute logic;

   public AimAssistModule() {
      super(Deobf.decrypt("7\u0003?d{\u009b\u008cÉà"), Deobf.decrypt(":\u000f5L|È\u0084ÓùŞĲňųƥƲǑƢ≲ɠəɞʏʠ˄˟̝ͮ̓͡ΚζϙϠ\u0380Љотѿ҆ҩҧӰԃԵ՚ոց֛֝ףؙْوػڒڻہ"), Category.COMBAT);
      this.logic = (AimAssistCompute)ProtectedContent.load(AimAssistCompute.class, Deobf.decrypt("\u0012\u000f$\u000b~\u009d\u0089ÂàčŽňťƯƴǗǧȂɮɫɚʍʎ˃˄̘͇ͤ͝\u0380νϜϰ"), LOG);
   }

   public void onTick() {
   }

   protected void onDisable() {
      if (this.logic != null) {
         this.logic.reset();
      }

   }

   public double[] computePixels(double dt, double userDX, double userDY) {
      return this.logic == null ? null : this.logic.computePixels(this, dt, userDX, userDY);
   }
}
