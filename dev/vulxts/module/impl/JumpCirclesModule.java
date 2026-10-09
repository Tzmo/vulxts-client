package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.SliderSetting;
import java.util.ArrayDeque;
import java.util.Deque;
import net.minecraft.class_2390;
import net.minecraft.class_5819;
import net.minecraft.class_746;

public class JumpCirclesModule extends Module {
   public final SliderSetting size = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u0003(@"), Deobf.decrypt("2\u000f1DdÈ\u0096ÙõĒĶěĨǽǯƕƢɛɠɅɝʅ˯˒˛̞ʹ̱͘Θγϑ϶Ή"), 1.0, 0.5, 3.0, 0.1, Deobf.decrypt("\u000e")));
   public final ColorSetting color = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("5\u0005>Jz"), Deobf.decrypt("2\u000f1DdÈ\u0086ÕøđġěĨƭƭǕǪȇɠɃɀˀʮ˞˞̜Ͷ͇ʹ\u038bϳ"), -38476));
   public final SliderSetting lifetime = (SliderSetting)this.addSetting(new SliderSetting("Lifetime", "How long a jump circle stays visible", 1.5, 0.5, 4.0, 0.1, "s"));
   public final BooleanSetting rainbow = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("$\u000b;Kj\u0087\u0092"), Deobf.decrypt("5\u00131ImÈ\u0091ÒñŞİŔŬƣƳƅǶȎȲɅɆʇʧʐ˃̙Ͳ̓ͣΎγϛϱϏЊ"), false));
   public final BooleanSetting shockwave = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0002=Fc\u009f\u0084Ìñ"), Deobf.decrypt("3\u0012\"Df\u008c\u008cÔóŞġŒŮƫǡǊǬɆȳɚɒʗʡ"), true));
   public final BooleanSetting particles = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("&\u000b Qa\u008b\u0089ßç"), Deobf.decrypt("2\u0018;C|\u0081\u008bÝ´ĚĦňŴǬƬǊǶȃȳȊɜʎ˯˚˂̜ͧ"), true));
   public final SliderSetting maxCircles = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(";\u000b*"), Deobf.decrypt(";\u000b*\u0005{\u0081\u0088ÏøĊĲŕťƣƴǖƢȂȥɉɒʌʼʐʟ̞ͻ͗ʹΜήΕϷϒВСцоҒҤӵӷԖծ"), 10.0, 1.0, 30.0, 1.0));
   private final Deque circles = new ArrayDeque();
   private int spawnCounter;

   public JumpCirclesModule() {
      super("JumpCircles", "Draws animated circles on the ground when you jump.", Category.CLIENT);
   }

   public Deque circles() {
      return this.circles;
   }

   protected void onDisable() {
      this.clear();
   }

   public void clear() {
      this.circles.clear();
   }

   public int baseRgb() {
      return (Integer)this.color.get() & 16777215;
   }

   public void onPlayerJump(class_746 var1) {
      if (this.isEnabled()) {
         double var2 = var1.method_23317();
         double var4 = var1.method_23318();
         double var6 = var1.method_23321();
         float var8 = 0.01F + (float)(this.spawnCounter % 8) * 0.001F;
         ++this.spawnCounter;
         this.circles.addLast(new JumpCircle(var2, var4, var6, var1.method_36454(), var8, System.nanoTime()));
         int var9 = Math.max(1, this.maxCircles.getInt());

         while(this.circles.size() > var9) {
            this.circles.removeFirst();
         }

         if ((Boolean)this.particles.get()) {
            this.spawnParticles(var1);
         }
      }

   }

   private void spawnParticles(class_746 var1) {
      class_5819 var2 = var1.method_59922();
      int var3 = this.baseRgb();

      for(int var4 = 0; var4 < 10; ++var4) {
         double var5 = var2.method_43058() * Math.PI * 2.0;
         double var7 = 0.15 + var2.method_43058() * 0.45;
         var1.method_73183().method_8406(new class_2390(var3, 0.9F), var1.method_23317() + Math.cos(var5) * var7, var1.method_23318() + 0.05, var1.method_23321() + Math.sin(var5) * var7, 0.0, 0.6 + var2.method_43058() * 0.4, 0.0);
      }

   }

   public static final class JumpCircle {
      public final double x;
      public final double y;
      public final double z;
      public final float yawDegrees;
      public final float yLift;
      public final long spawnNanos;

      JumpCircle(double var1, double var3, double var5, float var7, float var8, long var9) {
         this.x = var1;
         this.y = var3;
         this.z = var5;
         this.yawDegrees = var7;
         this.yLift = var8;
         this.spawnNanos = var9;
      }

      public float ageSeconds(long var1) {
         return (float)(var1 - this.spawnNanos) / 1.0E9F;
      }
   }
}
