package dev.vulxts.module.impl;

import dev.vulxts.mixin.KeyMappingAccessor;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3675;
import net.minecraft.class_3675.class_307;

public class AutoWalkModule extends Module {
   public final ModeSetting mode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt(";\u00056@"), Deobf.decrypt("!\u000b>Na\u0086\u0082\u009aùđķŞĮ"), Deobf.decrypt("%\u0003?Ud\u008d"), new String[]{Deobf.decrypt("%\u0003?Ud\u008d"), Deobf.decrypt("%\u00073W|")}));
   public final ModeSetting direction = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("2\u0003 @k\u009c\u008cÕú"), Deobf.decrypt("\"\u00027\u0005l\u0081\u0097ß÷ĊĺŔŮǬƵǊƢȑȡɆɘˀʦ˞ʗ̢;͞͡\u0383οΕϾϏЙдЛ"), Deobf.decrypt("0\u0005 Ri\u009a\u0081É"), new String[]{Deobf.decrypt("0\u0005 Ri\u009a\u0081É"), Deobf.decrypt("4\u000b1N\u007f\u0089\u0097Þç"), Deobf.decrypt(":\u000f4Q"), Deobf.decrypt("$\u00035M|")}));
   public final BooleanSetting disableOnInput = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("2\u0003!Dj\u0084\u0080\u009aÛĐųŲŮƼƴǑ"), Deobf.decrypt("2\u0003!Dj\u0084\u0080\u009aàĖĶěŭƣƥǐǮȃɠɅɝˀʢˑ˙̄Ͷ̱͟\u0382εσ϶ύИпсоҝңӷӱԖթ"), false));
   public final BooleanSetting disableOnY = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("2\u0003!Dj\u0084\u0080\u009aÛĐųŢĠƏƩǄǬȁȥ"), Deobf.decrypt("2\u0003!Dj\u0084\u0080\u009aàĖĶěŭƣƥǐǮȃɠɃɕˀʶ˟˂͑ͺͧ͜ΊϺσ϶ϒЉиіѿҘҡӾҪ"), false));
   public final BooleanSetting waitForChunks = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("8\u0005rpf\u0084\u008aÛðěķěŃƤƴǋǩȕ"), Deobf.decrypt("2\u0005rKg\u009cÅÍõĒĸěũƢƵǊƢȓȮɆɜʁʫ˕˓͑ʹ͛ͤ\u0381αφν"), true));

   public AutoWalkModule() {
      super(Deobf.decrypt("7\u001f&J_\u0089\u0089Ñ"), Deobf.decrypt("7\u001f&Je\u0089\u0091Ó÷ğĿŗŹǬƶǄǮȍȳȊɕʏʽˇ˖̃ͳ̝"), Category.MISC);
      this.direction.visibleWhen(() -> {
         return this.mode.is(Deobf.decrypt("%\u0003?Ud\u008d"));
      });
      this.disableOnY.visibleWhen(() -> {
         return this.mode.is(Deobf.decrypt("%\u0003?Ud\u008d"));
      });
      this.waitForChunks.visibleWhen(() -> {
         return this.mode.is(Deobf.decrypt("%\u0003?Ud\u008d"));
      });
   }

   protected void onDisable() {
      this.release(class_310.method_1551());
   }

   public void onTick() {
      class_310 mc = class_310.method_1551();
      if (mc.field_1724 != null && mc.field_1687 != null) {
         this.release(mc);
         if (this.mode.is(Deobf.decrypt("%\u00073W|"))) {
            mc.field_1690.field_1894.method_23481(true);
            mc.field_1690.field_1867.method_23481(true);
            if (mc.field_1724.field_5976 && mc.field_1724.method_24828()) {
               mc.field_1690.field_1903.method_23481(true);
            }
         } else if ((Boolean)this.disableOnY.get() && mc.field_1724.field_6036 != mc.field_1724.method_23318()) {
            this.toggle();
         } else if (!(Boolean)this.waitForChunks.get() || this.chunkAheadLoaded(mc)) {
            switch ((String)this.direction.get()) {
               case "Forwards":
                  mc.field_1690.field_1894.method_23481(true);
                  break;
               case "Backwards":
                  mc.field_1690.field_1881.method_23481(true);
                  break;
               case "Left":
                  mc.field_1690.field_1913.method_23481(true);
                  break;
               case "Right":
                  mc.field_1690.field_1849.method_23481(true);
            }
         }
      } else {
         this.release(mc);
      }

   }

   public boolean onKeyPress(int keyCode) {
      class_310 mc = class_310.method_1551();
      if ((Boolean)this.disableOnInput.get() && mc.field_1755 == null && this.isMovementKey(mc, keyCode)) {
         this.toggle();
      }

      return false;
   }

   private boolean chunkAheadLoaded(class_310 mc) {
      double yawRad = Math.toRadians((double)mc.field_1724.method_36454());
      double fx = -Math.sin(yawRad);
      double fz = Math.cos(yawRad);
      double dx;
      double dz;
      switch ((String)this.direction.get()) {
         case "Backwards":
            dx = -fx;
            dz = -fz;
            break;
         case "Left":
            dx = -fz;
            dz = fx;
            break;
         case "Right":
            dx = fz;
            dz = -fx;
            break;
         default:
            dx = fx;
            dz = fz;
      }

      int bx = (int)Math.floor(mc.field_1724.method_23317() + dx * 2.0);
      bz = (int)Math.floor(mc.field_1724.method_23321() + dz * 2.0);
      return mc.field_1687.method_2935().method_12123(bx >> 4, bz >> 4);
   }

   private void release(class_310 mc) {
      if (mc.field_1690 != null) {
         mc.field_1690.field_1894.method_23481(false);
         mc.field_1690.field_1881.method_23481(false);
         mc.field_1690.field_1913.method_23481(false);
         mc.field_1690.field_1849.method_23481(false);
         mc.field_1690.field_1903.method_23481(false);
         mc.field_1690.field_1867.method_23481(false);
      }

   }

   private boolean isMovementKey(class_310 mc, int keyCode) {
      class_315 o = mc.field_1690;
      return matches(o.field_1894, keyCode) || matches(o.field_1881, keyCode) || matches(o.field_1913, keyCode) || matches(o.field_1849, keyCode) || matches(o.field_1903, keyCode) || matches(o.field_1832, keyCode);
   }

   private static boolean matches(class_304 km, int keyCode) {
      class_3675.class_306 key = ((KeyMappingAccessor)km).vulxtsclient$getKey();
      return key.method_1442() == class_307.field_1668 && key.method_1444() == keyCode;
   }
}
