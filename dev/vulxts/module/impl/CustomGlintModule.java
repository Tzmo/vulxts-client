package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.util.Colors;
import java.util.Locale;

public class CustomGlintModule extends Module {
   public final ModeSetting style = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("%\u001e+Im"), Deobf.decrypt("1\u0006;K|È\u0091ßìĊĦŉťǢǡǡǧȀȡɟɟʔ˯˂˒̒\u0378͟;ΝΩΕϧψИѱуѿҚҤӫӨԃէ՛ղ֜ւր֪\u0603ؚٟٺڎڹۗ۫ݒܷݩݥߎޫߐ߂\u07fe࠭ࠢࠏ\u0878\u0891ࢢ\u08c4\u08ccऌिख़"), Deobf.decrypt("2\u000f4D}\u0084\u0091"), new String[]{Deobf.decrypt("2\u000f4D}\u0084\u0091"), Deobf.decrypt("3\u00046@z"), Deobf.decrypt(" \u0005;A"), Deobf.decrypt("1\u000b>Dp\u0091"), Deobf.decrypt("\"\u0005*Lk"), Deobf.decrypt("7\u00077Q`\u0091\u0096Î"), Deobf.decrypt("5\u00130@z"), Deobf.decrypt("%\u0005>Dz"), Deobf.decrypt("&\u0018;Ve\u0089\u0091Ó÷"), Deobf.decrypt("7\b+V{")}));
   public final ModeSetting mode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt(";\u00056@"), Deobf.decrypt("!\u00027WmÈ\u0091ÒñŞĴŗũƢƵƅǡȉȬɅɁˀʬ˟˚̔ͤ̓ͷΝεϘ"), Deobf.decrypt("%\u0005>Ll"), new String[]{Deobf.decrypt("%\u0005>Ll"), Deobf.decrypt("$\u000b;Kj\u0087\u0092"), Deobf.decrypt("\"\u00027Hm")}));
   public final ColorSetting color = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("5\u0005>Jz"), Deobf.decrypt("1\u0006;K|È\u0086Õøđġ"), -49508));
   public final SliderSetting strength = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001e @f\u008f\u0091Ò"), Deobf.decrypt("1\u0006;K|È\u008cÔàěĽňũƸƸ"), 60.0, 0.0, 100.0, 5.0, Deobf.decrypt("S")));
   public final SliderSetting speed = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001a7@l"), Deobf.decrypt("$\u000b;Kj\u0087\u0092\u009a÷ćİŗťǬƲǕǧȃȤ"), 100.0, 10.0, 300.0, 10.0, Deobf.decrypt("S")));

   public CustomGlintModule() {
      super(Deobf.decrypt("5\u001f!Qg\u0085¢ÖýĐħ"), Deobf.decrypt("$\u000f1Jd\u0087\u0097É´đġěŲƩƲǑǻȊȥəȓʔʧ˕ʗ̔\u0379͐\u0379ΎδρϾυГХЕѹҘҤөӰ"), Category.MISC);
      this.mode.visibleWhen(() -> {
         return this.style.is(Deobf.decrypt("2\u000f4D}\u0084\u0091"));
      });
      this.color.visibleWhen(() -> {
         return this.style.is(Deobf.decrypt("2\u000f4D}\u0084\u0091")) && this.mode.is(Deobf.decrypt("%\u0005>Ll"));
      });
      this.speed.visibleWhen(() -> {
         return this.style.is(Deobf.decrypt("2\u000f4D}\u0084\u0091")) && this.mode.is(Deobf.decrypt("$\u000b;Kj\u0087\u0092"));
      });
   }

   public boolean isActive() {
      return this.isEnabled();
   }

   public boolean usesTexture() {
      return !this.style.is(Deobf.decrypt("2\u000f4D}\u0084\u0091"));
   }

   public String textureName() {
      return ((String)this.style.get()).toLowerCase(Locale.ROOT);
   }

   public float strengthUnit() {
      return this.strength.getFloat() / 100.0F;
   }

   public int glintColor() {
      int var10000;
      switch ((String)this.mode.get()) {
         case "Rainbow":
            var10000 = this.rainbow();
            break;
         case "Theme":
            var10000 = VulxtsClient.themes().current().accent();
            break;
         default:
            var10000 = (Integer)this.color.get();
      }

      int base = var10000;
      float s = this.strength.getFloat() / 100.0F;
      r = Math.round((float)Colors.red(base) * s);
      int g = Math.round((float)Colors.green(base) * s);
      int b = Math.round((float)Colors.blue(base) * s);
      return Colors.rgb(r, g, b);
   }

   private int rainbow() {
      double seconds = (double)(System.nanoTime() % 1000000000000L) / 1.0E9;
      double hue = seconds * 36.0 * (double)(this.speed.getFloat() / 100.0F) % 360.0;
      return Colors.hsvToRgb((float)hue, 0.85F, 1.0F);
   }
}
