package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_5498;
import org.lwjgl.glfw.GLFW;

public class FreeLookModule extends Module {
   private static FreeLookModule instance;
   public final ModeSetting mode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt(";\u00056@"), Deobf.decrypt("!\u0002;F`È\u0080ÔàėħłĠƸƩǀƢȋȯɟɀʅ˯˂˘̅Ͷ͇ʹΜϴ"), Deobf.decrypt("&\u00063\\m\u009a"), new String[]{Deobf.decrypt("&\u00063\\m\u009a"), Deobf.decrypt("5\u000b?@z\u0089")}));
   public final BooleanSetting togglePerspective = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u00055Bd\u008dÅêñČĠŋťƯƵǌǴȃ"), Deobf.decrypt("%\u001d;Qk\u0080ÅÎûŞħœũƾƥƅǲȃȲəɜʎ˯˟˙͑ͣ͜ͶΈζϐν"), true));
   public final BooleanSetting throughWalls = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u0002 J}\u008f\u008d\u009aÃğĿŗų"), Deobf.decrypt("%\u000f7\u0005|\u0080\u0097ÕáęĻěŷƭƭǉǱɆ≔Ȋɇʈʪʐ˃̙;́͵ςΪϐϡϓВпЕѽҕҠӢӶԃէՔպ֛ց\u05c9\u05ef\u0604ٍْػڐڰڄۼܝܺݷݩޝޡߊߟޤ"), false));
   public final SliderSetting sensitivity = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("5\u000b?@z\u0089ÅéñĐĠŒŴƥƷǌǶȟ"), Deobf.decrypt(">\u0005%\u0005n\u0089\u0096Î´ĊĻŞĠƯƠǈǧȔȡȊɞʏʹ˕˄͑;̱͝άλϘ϶ϒМѱјѱҐҨҩ"), 8.0, 0.0, 10.0, 0.1));
   public final BooleanSetting arrows = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u0018 J\u007f\u009bÅùûĐħŉůƠǡǪǲȖȯəɚʔʪ"), Deobf.decrypt("5\u0005<Qz\u0087\u0089\u009aàĖĶěůƸƩǀǰɆȥɄɇʉʻˉʐ̷̂́;ΛλρϺϏГѱтѷҀҥҧӰԊԢԝռև֜ה\u05fdؙٟٗأڏ۲"), true));
   public final SliderSetting arrowSpeed = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("7\u0018 J\u007fÈ¶Êñěķ"), Deobf.decrypt("$\u0005&D|\u0081\u008aÔ´čģŞťƨǡǒǫȒȨȊɇʈʪʐ˖̃ͥͦ͜ϏαϐϪϓѓ"), 4.0, 0.0, 10.0, 0.5));
   private float cameraYaw;
   private float cameraPitch;
   private class_5498 prePers;

   public FreeLookModule() {
      super(Deobf.decrypt("0\u00187@D\u0087\u008aÑ"), Deobf.decrypt("7\u0006>J\u007f\u009bÅ×ûČĶěŲƣƵǄǶȏȯɄȓʏʿ˄˞̞\u0379̱̀ΆδΕϧψДУёо҄Ҩӵӷԍԩԓ"), Category.MISC);
      instance = this;
   }

   public static FreeLookModule get() {
      return instance;
   }

   protected void onEnable() {
      class_310 mc = class_310.method_1551();
      if (mc.field_1724 != null) {
         this.cameraYaw = mc.field_1724.method_36454();
         this.cameraPitch = mc.field_1724.method_36455();
         this.prePers = mc.field_1690.method_31044();
         if (this.prePers != class_5498.field_26665 && (Boolean)this.togglePerspective.get()) {
            mc.field_1690.method_31043(class_5498.field_26665);
         }
      }

   }

   protected void onDisable() {
      class_310 mc = class_310.method_1551();
      if (this.prePers != null && mc.field_1690.method_31044() != this.prePers && (Boolean)this.togglePerspective.get()) {
         mc.field_1690.method_31043(this.prePers);
      }

   }

   public void onTick() {
      class_310 mc = class_310.method_1551();
      if (mc.field_1724 != null) {
         if ((Boolean)this.arrows.get()) {
            long win = mc.method_22683().method_4490();
            boolean left = GLFW.glfwGetKey(win, 263) == 1;
            boolean right = GLFW.glfwGetKey(win, 262) == 1;
            boolean up = GLFW.glfwGetKey(win, 265) == 1;
            boolean down = GLFW.glfwGetKey(win, 264) == 1;
            int iterations = (int)((Double)this.arrowSpeed.get() * 2.0);

            for(int i = 0; i < iterations; ++i) {
               if (this.mode.is(Deobf.decrypt("&\u00063\\m\u009a"))) {
                  if (left) {
                     this.cameraYaw -= 0.5F;
                  }

                  if (right) {
                     this.cameraYaw += 0.5F;
                  }

                  if (up) {
                     this.cameraPitch -= 0.5F;
                  }

                  if (down) {
                     this.cameraPitch += 0.5F;
                  }
               } else {
                  float yaw = mc.field_1724.method_36454();
                  float pitch = mc.field_1724.method_36455();
                  if (left) {
                     yaw -= 0.5F;
                  }

                  if (right) {
                     yaw += 0.5F;
                  }

                  if (up) {
                     pitch -= 0.5F;
                  }

                  if (down) {
                     pitch += 0.5F;
                  }

                  mc.field_1724.method_36456(yaw);
                  mc.field_1724.method_36457(pitch);
               }
            }
         }

         mc.field_1724.method_36457(class_3532.method_15363(mc.field_1724.method_36455(), -90.0F, 90.0F));
         this.cameraPitch = class_3532.method_15363(this.cameraPitch, -90.0F, 90.0F);
      }

   }

   public boolean isActive() {
      return this.isEnabled() && class_310.method_1551().field_1724 != null;
   }

   public boolean seeThroughWalls() {
      return this.isActive() && (Boolean)this.throughWalls.get();
   }

   public boolean cameraMode() {
      return this.isActive() && this.mode.is(Deobf.decrypt("5\u000b?@z\u0089"));
   }

   public boolean playerMode() {
      return this.isActive() && class_310.method_1551().field_1690.method_31044() == class_5498.field_26665 && this.mode.is(Deobf.decrypt("&\u00063\\m\u009a"));
   }

   public void addCameraLook(double deltaX, double deltaY) {
      float sens = this.sensitivity.getFloat();
      if (sens <= 0.0F) {
         sens = 1.0F;
      }

      this.cameraYaw += (float)(deltaX / (double)sens);
      this.cameraPitch += (float)(deltaY / (double)sens);
      if (Math.abs(this.cameraPitch) > 90.0F) {
         this.cameraPitch = this.cameraPitch > 0.0F ? 90.0F : -90.0F;
      }

   }

   public float getCameraYaw() {
      return this.cameraYaw;
   }

   public float getCameraPitch() {
      return this.cameraPitch;
   }
}
