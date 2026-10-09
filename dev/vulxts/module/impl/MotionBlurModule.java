package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.render.MotionBlurRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;
import java.util.Objects;

public class MotionBlurModule extends Module {
   public final SliderSetting strength = (SliderSetting)this.addSetting((new SliderSetting(Deobf.decrypt("%\u001e @f\u008f\u0091Ò"), Deobf.decrypt("4\u0006'W(\u009b\u0091ÈñĐĴŏŨ"), 30.0, 5.0, 100.0, 5.0, Deobf.decrypt("S"))).withLabel((v) -> {
      int pct = (int)Math.round(v);
      String tier = pct <= 20 ? Deobf.decrypt("%\u001f0Qd\u008d") : (pct <= 45 ? Deobf.decrypt("4\u000b>Df\u008b\u0080Þ") : (pct <= 70 ? Deobf.decrypt("%\u0007=J|\u0080") : (pct <= 90 ? Deobf.decrypt(">\u000f3Sq") : Deobf.decrypt("5\u0003<@e\u0089\u0091Ó÷"))));
      return "" + pct + "% · " + tier;
   }));
   public final BooleanSetting pinkTrails = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("&\u0003<N(¼\u0097ÛýĒĠ"), Deobf.decrypt("\"\u0003<Q(\u009c\u008dß´ĊġŚũƠƲƅǵȏȴɂȓʙʠ˅˅͑ͣ͛ʹ\u0382οΕϲσОдћѪӔӥӑӱԎԿՉծוւהץ\u061cٛ"), true));
   public final SliderSetting tint = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("\"\u0003<Q"), Deobf.decrypt(">\u0005%\u0005{\u009c\u0097ÕúęĿłĠƸƳǄǫȊȳȊɇʁʤ˕ʗ̅Ϳ͖̱ΛβϐϾυѝвњѲқҿ"), 30.0, 0.0, 100.0, 5.0, Deobf.decrypt("S")));
   public final BooleanSetting fpsCompensated = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("0:\u0001\u0005K\u0087\u0088ÊñĐĠŚŴƩƥ"), Deobf.decrypt("=\u000f7U(\u009c\u008dß´ĜĿŎŲǬƢǊǬȕȩəɇʅʡ˄ʗ̐ʹ́;ΜΩΕϵϒМмѐѬҕҹӢӷ"), true));

   public MotionBlurModule() {
      super(Deobf.decrypt(";\u0005&Lg\u0086§ÖáČ"), Deobf.decrypt("5\u0003<@e\u0089\u0091Ó÷ŞľŔŴƥƮǋƢȄȬɟɁ"), Category.VISUALS);
      SliderSetting var10000 = this.tint;
      BooleanSetting var10001 = this.pinkTrails;
      Objects.requireNonNull(var10001);
      var10000.visibleWhen(var10001::get);
   }

   protected void onDisable() {
      MotionBlurRenderer.reset();
   }

   public double retention() {
      return Math.clamp((double)this.strength.getFloat() / 100.0, 0.05, 0.95);
   }

   public float tintAmount() {
      return (Boolean)this.pinkTrails.get() ? (float)Math.clamp((double)this.tint.getFloat() / 100.0, 0.0, 1.0) : 0.0F;
   }

   public int accentColor() {
      return VulxtsClient.themes().current().accent();
   }
}
