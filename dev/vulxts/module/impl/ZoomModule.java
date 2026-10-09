package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;

public class ZoomModule extends Module {
   private static final double EASE_SPEED = 14.0;
   public final SliderSetting factor = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("0\u000b1Qg\u009a"), Deobf.decrypt(",\u0005=H(\u008e\u0084Ùàđġ"), 4.0, 2.0, 10.0, 0.5, Deobf.decrypt("\u000e")));
   public final BooleanSetting smooth = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0007=J|\u0080"), Deobf.decrypt("%\u0007=J|\u0080ÅÀûđľěũƢǮǊǷȒ"), true));
   private double current = 1.0;
   private long lastNanos = 0L;

   public ZoomModule() {
      super(Deobf.decrypt(",\u0005=H"), Deobf.decrypt("9\u001a&Lk\u0089\u0089\u009aîđļŖĠƣƯƅǣɆȫɏɊ"), Category.MISC);
   }

   public double currentFactor() {
      long now = System.nanoTime();
      double dt = this.lastNanos == 0L ? 0.0 : (double)(now - this.lastNanos) / 1.0E9;
      this.lastNanos = now;
      double target = this.isEnabled() ? (double)this.factor.getFloat() : 1.0;
      if (!(Boolean)this.smooth.get()) {
         this.current = target;
         return this.current;
      } else {
         double t = 1.0 - Math.exp(-14.0 * Math.max(0.0, dt));
         this.current += (target - this.current) * t;
         if (Math.abs(this.current - target) < 0.001) {
            this.current = target;
         }

         return this.current;
      }
   }
}
