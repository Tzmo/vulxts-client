package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.util.Colors;

public class CustomCrosshairModule extends Module {
   private static final int HOT_PINK = -49508;
   public final ModeSetting style = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("%\u001e+Im"), Deobf.decrypt("5\u0018=V{\u0080\u0084ÓæŞĠœšƼƤ"), Deobf.decrypt("5\u0018=V{"), new String[]{Deobf.decrypt("2\u0005&"), Deobf.decrypt("5\u0018=V{"), Deobf.decrypt("5\u0003 Fd\u008d"), Deobf.decrypt("\"G\u0001Mi\u0098\u0080"), Deobf.decrypt("4\u00183Fc\u008d\u0091É"), Deobf.decrypt("5\u00027Sz\u0087\u008b"), Deobf.decrypt(" ")}));
   public final SliderSetting size = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u0003(@"), Deobf.decrypt("9\u001c7Wi\u0084\u0089\u009a÷ČļňųƤƠǌǰɆȳɃɉʅ"), 7.0, 2.0, 24.0, 1.0, Deobf.decrypt("\u0006\u0012")));
   public final SliderSetting thickness = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("\"\u0002;Fc\u0086\u0080Éç"), Deobf.decrypt(":\u0003<@(ÇÅÞûĊųŏŨƥƢǎǬȃȳə"), 2.0, 1.0, 6.0, 0.5, Deobf.decrypt("\u0006\u0012")));
   public final SliderSetting gap = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("1\u000b\""), Deobf.decrypt("5\u000f<Qm\u009aÅÝõĎųŝůƾǡǉǫȈȥȊɀʔʶ˜˒̂"), 3.0, 0.0, 12.0, 1.0, Deobf.decrypt("\u0006\u0012")));
   public final ColorSetting color = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("5\u0005>Jz"), Deobf.decrypt("5\u0018=V{\u0080\u0084ÓæŞİŔŬƣƳ"), -49508));
   public final BooleanSetting rainbow = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("$\u000b;Kj\u0087\u0092"), Deobf.decrypt("5\u00131ImÈ\u0091ÒæđĦŜŨǬƵǍǧɆȲɋɚʎʭ˟ˀ"), false));
   public final BooleanSetting centerDot = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u000f<Qm\u009aÅþûĊ"), Deobf.decrypt("7\u000e6\u0005iÈ\u0083ÓøĒĶşĠƨƮǑƢȇȴȊɇʈʪʐˁ̱̔ͥ͊ΌοϛϧυЏ"), false));
   public final BooleanSetting outline = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("9\u001f&Ia\u0086\u0080"), Deobf.decrypt("2\u000b N(\u008a\u008aÈðěġěŦƣƳƅǡȉȮɞɁʁʼ˄ʗ̞\u0379̓Ͱ\u0381ΣΕϱρОкђѬқҸөӠ"), true));
   public final BooleanSetting glow = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("1\u0006=R"), Deobf.decrypt("%\u00054Q(\u008f\u0089ÕãŞıŞŨƥƯǁƢȒȨɏȓʃʽ˟˄̂Ϳ͒\u0378Ν"), true));
   public final BooleanSetting hideVanilla = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u00036@(¾\u0084ÔýĒĿŚ"), Deobf.decrypt(">\u00036@(¥\u008cÔñĝġŚŦƸǦǖƢȂȥɌɒʕʣ˄ʗ̒ͥ͜͢ΜβϔϺϒ"), true));

   public CustomCrosshairModule() {
      super(Deobf.decrypt("5\u001f!Qg\u0085¦ÈûčĠœšƥƳ"), Deobf.decrypt("2\u00183R{È\u0084\u009a÷ċĠŏůơǡǆǰȉȳəɛʁʦ˂"), Category.MISC);
   }

   public boolean shouldHideVanilla() {
      return this.isEnabled() && (Boolean)this.hideVanilla.get();
   }

   private int resolveColor() {
      if ((Boolean)this.rainbow.get()) {
         float hue = (float)(System.nanoTime() % 3000000000L) / 3.0E9F;
         return -16777216 | Colors.hsvToRgb(hue, 0.85F, 1.0F) & 16777215;
      } else {
         return (Integer)this.color.get();
      }
   }

   public void render(NVGRenderer vg, float cx, float cy) {
      int col = this.resolveColor();
      int line = (Boolean)this.outline.get() ? -1342177280 : 0;
      float t = this.thickness.getFloat();
      float s = this.size.getFloat();
      float g = this.gap.getFloat();
      if ((Boolean)this.glow.get()) {
         vg.circleGlow(cx, cy, s + 2.0F, 6.0F, Colors.withAlpha(col, 0.45F));
      }

      switch ((String)this.style.get()) {
         case "Dot":
            this.dot(vg, cx, cy, Math.max(1.5F, s * 0.35F), col, line);
            break;
         case "Cross":
            this.cross(vg, cx, cy, s, t, g, col, line, true, true);
            break;
         case "T-Shape":
            this.cross(vg, cx, cy, s, t, g, col, line, false, true);
            break;
         case "Circle":
            this.ring(vg, cx, cy, s, t, col, line);
            break;
         case "Brackets":
            this.brackets(vg, cx, cy, s, t, g, col, line);
            break;
         case "Chevron":
            if (line != 0) {
               vg.chevron(cx, cy + s * 0.15F, s + 2.0F, t + 2.0F, line, true);
            }

            vg.chevron(cx, cy + s * 0.15F, s, t, col, true);
            break;
         case "V":
            this.logo(vg, cx, cy, s, col);
            break;
         default:
            this.cross(vg, cx, cy, s, t, g, col, line, true, true);
      }

      if ((Boolean)this.centerDot.get() && !this.style.is(Deobf.decrypt("2\u0005&")) && !this.style.is(Deobf.decrypt(" "))) {
         this.dot(vg, cx, cy, Math.max(1.2F, t * 0.8F), col, line);
      }

   }

   private void dot(NVGRenderer vg, float cx, float cy, float r, int col, int line) {
      if (line != 0) {
         vg.circle(cx, cy, r + 1.0F, line);
      }

      vg.circle(cx, cy, r, col);
   }

   private void ring(NVGRenderer vg, float cx, float cy, float r, float t, int col, int line) {
      if (line != 0) {
         vg.circleOutline(cx, cy, r, t + 2.0F, line);
      }

      vg.circleOutline(cx, cy, r, t, col);
   }

   private void cross(NVGRenderer vg, float cx, float cy, float len, float t, float g, int col, int line, boolean top, boolean bottom) {
      if (line != 0) {
         this.segments(vg, cx, cy, len, t + 2.0F, g, line, top, bottom);
      }

      this.segments(vg, cx, cy, len, t, g, col, top, bottom);
   }

   private void segments(NVGRenderer vg, float cx, float cy, float len, float t, float g, int argb, boolean top, boolean bottom) {
      vg.line(cx + g, cy, cx + g + len, cy, t, argb);
      vg.line(cx - g, cy, cx - g - len, cy, t, argb);
      if (top) {
         vg.line(cx, cy - g, cx, cy - g - len, t, argb);
      }

      if (bottom) {
         vg.line(cx, cy + g, cx, cy + g + len, t, argb);
      }

   }

   private void brackets(NVGRenderer vg, float cx, float cy, float len, float t, float g, int col, int line) {
      float arm = Math.max(2.0F, len * 0.5F);
      float d = len + g * 0.4F;
      if (line != 0) {
         this.drawBrackets(vg, cx, cy, d, arm, t + 2.0F, line);
      }

      this.drawBrackets(vg, cx, cy, d, arm, t, col);
   }

   private void drawBrackets(NVGRenderer vg, float cx, float cy, float d, float arm, float t, int argb) {
      vg.line(cx - d, cy - d, cx - d + arm, cy - d, t, argb);
      vg.line(cx - d, cy - d, cx - d, cy - d + arm, t, argb);
      vg.line(cx + d, cy - d, cx + d - arm, cy - d, t, argb);
      vg.line(cx + d, cy - d, cx + d, cy - d + arm, t, argb);
      vg.line(cx - d, cy + d, cx - d + arm, cy + d, t, argb);
      vg.line(cx - d, cy + d, cx - d, cy + d - arm, t, argb);
      vg.line(cx + d, cy + d, cx + d - arm, cy + d, t, argb);
      vg.line(cx + d, cy + d, cx + d, cy + d - arm, t, argb);
   }

   private void logo(NVGRenderer vg, float cx, float cy, float s, int col) {
      float font = s * 2.4F;
      float w = vg.textWidth(Deobf.decrypt(" "), font);
      float tx = cx - w / 2.0F;
      vg.textGlow(Deobf.decrypt(" "), tx, cy, font, Colors.withAlpha(-49508, 0.6F));
      vg.text(Deobf.decrypt(" "), tx, cy, font, col);
   }
}
