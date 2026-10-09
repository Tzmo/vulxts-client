package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.util.Colors;
import java.util.ArrayDeque;
import java.util.Deque;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_5819;

public class HitParticlesModule extends Module {
   public static final int STYLE_SPARKS = 0;
   public static final int STYLE_HEARTS = 1;
   public static final int STYLE_LIGHTNING = 2;
   public static final int STYLE_VULXTS = 3;
   public final ModeSetting style = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("%\u001e+Im"), Deobf.decrypt("4\u001f V|È\u0096ÎíĒĶ"), Deobf.decrypt("%\u001a3Wc\u009b"), new String[]{Deobf.decrypt("%\u001a3Wc\u009b"), Deobf.decrypt(">\u000f3W|\u009b"), Deobf.decrypt(":\u00035M|\u0086\u008cÔó"), Deobf.decrypt(" \u001f>]|\u009b")}));
   public final SliderSetting amount = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("7\u0007=Pf\u009c"), Deobf.decrypt("&\u000b Qa\u008b\u0089ßçŞĠŋšƻƯǀǦɆȰɏɁˀʧ˙˃"), 14.0, 4.0, 40.0, 1.0));
   public final SliderSetting size = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u0003(@"), Deobf.decrypt("&\u000b Qa\u008b\u0089ß´čİŚŬƩ"), 1.0, 0.3, 3.0, 0.1, Deobf.decrypt("\u000e")));
   public final SliderSetting lifetime = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(":\u00034@|\u0081\u0088ß"), Deobf.decrypt(">\u0005%\u0005d\u0087\u008bÝ´ĊĻŞĠƮƴǗǱȒɠɆɚʎʨ˕˅̂"), 0.7, 0.3, 2.0, 0.1, Deobf.decrypt("\u0005")));
   public final SliderSetting spread = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001a @i\u008c"), Deobf.decrypt(">\u0005%\u0005n\u0089\u0097\u009aäğġŏũƯƭǀǱɆȦɆɊˀʠ˅˃"), 1.0, 0.3, 2.5, 0.1, Deobf.decrypt("\u000e")));
   public final ColorSetting color = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("5\u0005>Jz"), Deobf.decrypt("&\u000b Qa\u008b\u0089ß´ĊĺŕŴ"), -49508));
   public final BooleanSetting rainbow = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("$\u000b;Kj\u0087\u0092"), Deobf.decrypt("5\u00131ImÈ\u0080Û÷ĖųřŵƾƲǑƢȒȨɘɜʕʨ˘ʗ̅Ϳ͖̱ΝλϜϽςВЦ"), false));
   public final SliderSetting glow = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("1\u0006=R"), Deobf.decrypt("%\u00054Q(\u0087\u0090ÎñČųœšƠƮƅǫȈȴɏɝʓʦ˄ˎ"), 65.0, 0.0, 100.0, 5.0, Deobf.decrypt("S")));
   public final BooleanSetting shockwave = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0002=Fc\u009f\u0084Ìñ"), Deobf.decrypt("3\u0012\"Df\u008c\u008cÔóŞġŒŮƫǡǊǬɆȥɋɐʈ˯˘˞̅"), true));
   private final Deque particles = new ArrayDeque();
   private final Deque shocks = new ArrayDeque();
   private static final int MAX_PARTICLES = 600;
   private static final int MAX_SHOCKS = 24;

   public HitParticlesModule() {
      super(Deobf.decrypt(">\u0003&ui\u009a\u0091Ó÷ĒĶň"), Deobf.decrypt("\"\u00027Hm\u008cÅÊõČħŒţƠƤƅǠȓȲəɇʓ˯ˇ˟̔\u0379̓ͨ\u0380ίΕϻωЉѱєѰӔҨөӰԋԳՄ"), Category.VISUALS);
   }

   public Deque particles() {
      return this.particles;
   }

   public Deque shocks() {
      return this.shocks;
   }

   protected void onDisable() {
      this.clear();
   }

   public void clear() {
      this.particles.clear();
      this.shocks.clear();
   }

   private int currentRgb() {
      if ((Boolean)this.rainbow.get()) {
         float hue = (float)(System.currentTimeMillis() % 3500L) / 3500.0F * 360.0F;
         return Colors.hsvToRgb(hue, 0.85F, 1.0F) & 16777215;
      } else {
         return (Integer)this.color.get() & 16777215;
      }
   }

   public void onHit(class_1297 target) {
      if (this.isEnabled() && target != null) {
         double cx = target.method_23317();
         double cy = target.method_23318() + (double)target.method_17682() * 0.6;
         double cz = target.method_23321();
         this.spawnAt(cx, cy, cz);
      }

   }

   public void spawnAt(double cx, double cy, double cz) {
      class_310 mc = class_310.method_1551();
      if (mc.field_1687 != null) {
         class_5819 random = mc.field_1687.field_9229;
         int styleId = this.styleId();
         int rgb = this.currentRgb();
         int count = this.amount.getInt();
         float life = this.lifetime.getFloat();
         float spreadScale = this.spread.getFloat();
         float sizeScale = this.size.getFloat();
         long now = System.nanoTime();

         for(int i = 0; i < count; ++i) {
            this.spawnOne(random, styleId, rgb, cx, cy, cz, life, spreadScale, sizeScale, now);
         }

         if ((Boolean)this.shockwave.get()) {
            this.shocks.addLast(new Shock(cx, cy, cz, rgb, styleId, now));

            while(this.shocks.size() > 24) {
               this.shocks.removeFirst();
            }
         }

         while(this.particles.size() > 600) {
            this.particles.removeFirst();
         }
      }

   }

   private void spawnOne(class_5819 random, int styleId, int rgb, double cx, double cy, double cz, float life, float spreadScale, float sizeScale, long now) {
      double theta = random.method_43058() * Math.PI * 2.0;
      double cosPhi = 2.0 * random.method_43058() - 1.0;
      double sinPhi = Math.sqrt(Math.max(0.0, 1.0 - cosPhi * cosPhi));
      float dx = (float)(sinPhi * Math.cos(theta));
      float dy = (float)cosPhi;
      float dz = (float)(sinPhi * Math.sin(theta));
      float particleLife = life * (0.75F + random.method_43057() * 0.25F);
      float pSize = sizeScale * (0.7F + random.method_43057() * 0.6F);
      float speed;
      float gravity;
      float vx;
      switch (styleId) {
         case 1:
            dx *= 0.5F;
            dz *= 0.5F;
            dy = 0.4F + Math.abs(dy) * 0.5F;
            speed = (1.6F + random.method_43057() * 1.0F) * spreadScale;
            gravity = 1.2F;
            particleLife = life * (1.0F + random.method_43057() * 0.3F);
            break;
         case 2:
            dy *= 0.25F;
            vx = class_3532.method_15355(Math.max(1.0E-4F, dx * dx + dz * dz));
            dx /= vx;
            dz /= vx;
            speed = (5.0F + random.method_43057() * 3.0F) * spreadScale;
            gravity = 0.6F;
            particleLife = life * (0.45F + random.method_43057() * 0.25F);
            break;
         case 3:
            dy = 0.12F + dy * 0.35F;
            speed = (1.9F + random.method_43057() * 1.4F) * spreadScale;
            gravity = 1.3F;
            particleLife = life * (1.0F + random.method_43057() * 0.25F);
            break;
         default:
            dy = dy * 0.7F + 0.3F;
            speed = (4.0F + random.method_43057() * 3.5F) * spreadScale;
            gravity = 6.5F;
      }

      vx = dx * speed;
      float vy = dy * speed;
      float vz = dz * speed;
      float rot = random.method_43057() * 6.2831855F;
      float rotSpeed = (random.method_43057() - 0.5F) * 8.0F;
      this.particles.addLast(new HitParticle(cx, cy, cz, vx, vy, vz, rgb, styleId, pSize, rot, rotSpeed, gravity, particleLife, now));
   }

   private int styleId() {
      if (this.style.is(Deobf.decrypt(">\u000f3W|\u009b"))) {
         return 1;
      } else if (this.style.is(Deobf.decrypt(":\u00035M|\u0086\u008cÔó"))) {
         return 2;
      } else {
         return this.style.is(Deobf.decrypt(" \u001f>]|\u009b")) ? 3 : 0;
      }
   }

   public float glowStrength() {
      return this.glow.getFloat() / 100.0F;
   }

   public static final class Shock {
      public final double x;
      public final double y;
      public final double z;
      public final int rgb;
      public final int styleId;
      public final long spawnNanos;

      Shock(double x, double y, double z, int rgb, int styleId, long spawnNanos) {
         this.x = x;
         this.y = y;
         this.z = z;
         this.rgb = rgb;
         this.styleId = styleId;
         this.spawnNanos = spawnNanos;
      }

      public float ageSeconds(long nowNanos) {
         return (float)(nowNanos - this.spawnNanos) / 1.0E9F;
      }
   }

   public static final class HitParticle {
      public final double ox;
      public final double oy;
      public final double oz;
      public final float vx;
      public final float vy;
      public final float vz;
      public final int rgb;
      public final int styleId;
      public final float size;
      public final float rot;
      public final float rotSpeed;
      public final float gravity;
      public final float lifetime;
      public final long spawnNanos;

      HitParticle(double ox, double oy, double oz, float vx, float vy, float vz, int rgb, int styleId, float size, float rot, float rotSpeed, float gravity, float lifetime, long spawnNanos) {
         this.ox = ox;
         this.oy = oy;
         this.oz = oz;
         this.vx = vx;
         this.vy = vy;
         this.vz = vz;
         this.rgb = rgb;
         this.styleId = styleId;
         this.size = size;
         this.rot = rot;
         this.rotSpeed = rotSpeed;
         this.gravity = gravity;
         this.lifetime = lifetime;
         this.spawnNanos = spawnNanos;
      }

      public float ageSeconds(long nowNanos) {
         return (float)(nowNanos - this.spawnNanos) / 1.0E9F;
      }

      public double x(float age) {
         return this.ox + (double)(this.vx * age);
      }

      public double y(float age) {
         return this.oy + (double)(this.vy * age) - 0.5 * (double)this.gravity * (double)age * (double)age;
      }

      public double z(float age) {
         return this.oz + (double)(this.vz * age);
      }
   }
}
