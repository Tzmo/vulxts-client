package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;
import java.util.Objects;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;

public class CustomFovModule extends Module {
   private static final double EASE_SPEED = 12.0;
   private static final double SPRINT_SPEED = 0.2825;
   public final SliderSetting fov = (SliderSetting)this.addSetting((new SliderSetting(Deobf.decrypt("0%\u0004"), Deobf.decrypt("\"\u000b Bm\u009cÅÜýěĿşĠƣƧƅǴȏȥɝ"), 95.0, 30.0, 140.0, 1.0, Deobf.decrypt("Æ"))).withLabel((v) -> {
      return (int)v + "° · " + tag((int)v);
   }));
   public final BooleanSetting smooth = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0007=J|\u0080"), Deobf.decrypt("3\u000b!@(®ªì´ĝĻŚŮƫƤǖƢȏȮȊɒʎʫʐ˘̄ͣ"), true));
   public final BooleanSetting noSprintZoom = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("8\u0005rvx\u009a\u008cÔàŞĉŔůơ"), Deobf.decrypt("5\u000b<Fm\u0084ÅÎüěųōšƢƨǉǮȇɠəɃʒʦ˞˃̸͑̓͢ΟοϐϷ\u0380лОѣо҄ҸөӧԊ"), true));
   public final BooleanSetting speedFov = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u001a7@lÈ£õÂ"), Deobf.decrypt("!\u00036@fÈ\u0091ÒñŞĥŒťƻǡǒǫȒȨȊɊʏʺ˂ʗ̜\u0378ͅʹ\u0382οϛϧ\u0380ЎСѐѻҐ"), false));
   public final SliderSetting speedStrength = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001a7@lÈ¶ÎæěĽŜŴƤ"), Deobf.decrypt("3\u0012&WiÈ\u0081ßóČĶŞųǬƠǑƢȀȵɆɟˀʼˀ˅̘\u0379͇"), 12.0, 0.0, 30.0, 1.0, Deobf.decrypt("Æ")));
   private double current = -1.0;
   private long lastNanos = 0L;

   public CustomFovModule() {
      super(Deobf.decrypt("5\u001f!Qg\u0085£õÂ"), Deobf.decrypt("9\u001c7Wz\u0081\u0081ßçŞħœťǬƧǌǧȊȤȊɜʆ˯ˆ˞̔͠"), Category.MISC);
      SliderSetting var10000 = this.speedStrength;
      BooleanSetting var10001 = this.speedFov;
      Objects.requireNonNull(var10001);
      var10000.visibleWhen(var10001::get);
   }

   public float fovMultiplier(float vanillaSprintMultiplier) {
      class_310 mc = class_310.method_1551();
      int optionsFov = (Integer)mc.field_1690.method_41808().method_41753();
      if (optionsFov <= 0) {
         return vanillaSprintMultiplier;
      } else {
         double target = this.isEnabled() ? (Double)this.fov.get() + this.speedBonus(mc) : (double)optionsFov;
         long now = System.nanoTime();
         double dt = this.lastNanos == 0L ? 0.0 : (double)(now - this.lastNanos) / 1.0E9;
         this.lastNanos = now;
         if (this.current < 0.0) {
            this.current = (double)optionsFov;
         }

         if (!(Boolean)this.smooth.get()) {
            this.current = target;
         } else {
            double t = 1.0 - Math.exp(-12.0 * Math.max(0.0, dt));
            this.current += (target - this.current) * t;
            if (Math.abs(this.current - target) < 0.05) {
               this.current = target;
            }
         }

         if (!this.isEnabled() && this.current == (double)optionsFov) {
            return vanillaSprintMultiplier;
         } else {
            float sprint = this.isEnabled() && (Boolean)this.noSprintZoom.get() ? 1.0F : vanillaSprintMultiplier;
            return (float)(this.current / (double)optionsFov) * sprint;
         }
      }
   }

   public double currentFov() {
      return this.current;
   }

   private double speedBonus(class_310 mc) {
      if (!(Boolean)this.speedFov.get()) {
         return 0.0;
      } else {
         class_1657 p = mc.field_1724;
         if (p == null) {
            return 0.0;
         } else {
            class_243 v = p.method_18798();
            double horizontal = Math.sqrt(v.field_1352 * v.field_1352 + v.field_1350 * v.field_1350);
            double t = Math.min(1.0, horizontal / 0.2825);
            return (double)this.speedStrength.getFloat() * t;
         }
      }
   }

   private static String tag(int v) {
      if (v <= 45) {
         return Deobf.decrypt("\"\u001f<Km\u0084");
      } else if (v <= 65) {
         return Deobf.decrypt("0\u00051P{\u008d\u0081");
      } else if (v <= 80) {
         return Deobf.decrypt("8\u0005 Hi\u0084");
      } else if (v <= 100) {
         return Deobf.decrypt("!\u00036@");
      } else {
         return v <= 118 ? Deobf.decrypt("#\u0006&Wi") : Deobf.decrypt("0\u0003!Mm\u0091\u0080");
      }
   }
}
