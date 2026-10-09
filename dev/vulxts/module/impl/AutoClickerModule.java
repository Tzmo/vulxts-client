package dev.vulxts.module.impl;

import dev.vulxts.mixin.MinecraftAccessor;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import net.minecraft.class_310;

public class AutoClickerModule extends Module {
   public final BooleanSetting inScreens = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("!\u0002;ImÈ¬Ô´ĭİŉťƩƯǖ"), Deobf.decrypt("!\u00027Q`\u008d\u0097\u009aàđųŘŬƥƢǎƢȑȨɃɟʅ˯ˑʗ̂ʹ́ʹΊδΕϺϓѝохѻҚӣ"), true));
   public final ModeSetting leftMode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt(":\u000f4Q(«\u0089Ó÷ĕųŶůƨƤ"), Deobf.decrypt("\"\u00027\u0005e\u008d\u0091ÒûĚųŔŦǬƢǉǫȅȫɃɝʇ˯˖˘̷̃͟ʹΉήΕϰόДвўѭӚ"), Deobf.decrypt("&\u00187V{"), new String[]{Deobf.decrypt("2\u0003!Dj\u0084\u0080Þ"), Deobf.decrypt(">\u0005>A"), Deobf.decrypt("&\u00187V{")}));
   public final SliderSetting leftDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(":\u000f4Q(«\u0089Ó÷ĕųſťƠƠǜ"), Deobf.decrypt("2\u000f>DqÈ\u0087ßàĉĶŞŮǬƭǀǤȒɠɉɟʉʬ˛˄͑;̱͝Λγϖϸϓѓ"), 2.0, 0.0, 60.0, 1.0, Deobf.decrypt("V\u001e;Fc\u009b")));
   public final ModeSetting rightMode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("$\u00035M|È¦Öýĝĸěōƣƥǀ"), Deobf.decrypt("\"\u00027\u0005e\u008d\u0091ÒûĚųŔŦǬƢǉǫȅȫɃɝʇ˯˖˘̷̃́\u0378ΈβργσБиіѵ҇ӣ"), Deobf.decrypt("&\u00187V{"), new String[]{Deobf.decrypt("2\u0003!Dj\u0084\u0080Þ"), Deobf.decrypt(">\u0005>A"), Deobf.decrypt("&\u00187V{")}));
   public final SliderSetting rightDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("$\u00035M|È¦ÖýĝĸěńƩƭǄǻ"), Deobf.decrypt("2\u000f>DqÈ\u0087ßàĉĶŞŮǬƳǌǥȎȴȊɐʌʦ˓˜̷͚̂ͿϏήϜϰϋЎѿ"), 2.0, 0.0, 60.0, 1.0, Deobf.decrypt("V\u001e;Fc\u009b")));
   private int leftTimer;
   private int rightTimer;

   public AutoClickerModule() {
      super(Deobf.decrypt("7\u001f&JK\u0084\u008cÙÿěġ"), Deobf.decrypt("7\u001f&Je\u0089\u0091Ó÷ğĿŗŹǬƢǉǫȅȫəȝ"), Category.MISC);
      this.leftDelay.visibleWhen(() -> {
         return this.leftMode.is(Deobf.decrypt("&\u00187V{"));
      });
      this.rightDelay.visibleWhen(() -> {
         return this.rightMode.is(Deobf.decrypt("&\u00187V{"));
      });
   }

   protected void onEnable() {
      this.leftTimer = 0;
      this.rightTimer = 0;
      this.release();
   }

   protected void onDisable() {
      this.release();
   }

   private void release() {
      class_310 mc = class_310.method_1551();
      if (mc.field_1690 != null) {
         mc.field_1690.field_1886.method_23481(false);
         mc.field_1690.field_1904.method_23481(false);
      }

   }

   public void onTick() {
      class_310 mc = class_310.method_1551();
      if (mc.field_1724 != null && ((Boolean)this.inScreens.get() || mc.field_1755 == null)) {
         switch ((String)this.leftMode.get()) {
            case "Hold":
               mc.field_1690.field_1886.method_23481(true);
               break;
            case "Press":
               ++this.leftTimer;
               if (this.leftTimer > this.leftDelay.getInt()) {
                  this.leftClick(mc);
                  this.leftTimer = 0;
               }
         }

         switch ((String)this.rightMode.get()) {
            case "Hold":
               mc.field_1690.field_1904.method_23481(true);
               break;
            case "Press":
               ++this.rightTimer;
               if (this.rightTimer > this.rightDelay.getInt()) {
                  this.rightClick(mc);
                  this.rightTimer = 0;
               }
         }
      }

   }

   private void leftClick(class_310 mc) {
      if (mc.field_1771 == 10000) {
         mc.field_1771 = 0;
      }

      mc.field_1690.field_1886.method_23481(true);
      ((MinecraftAccessor)mc).vulxtsclient$startAttack();
      mc.field_1690.field_1886.method_23481(false);
   }

   private void rightClick(class_310 mc) {
      ((MinecraftAccessor)mc).vulxtsclient$startUseItem();
   }
}
