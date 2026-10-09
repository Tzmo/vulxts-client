package dev.vulxts.module.impl;

import dev.vulxts.mixin.MinecraftAccessor;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.ModeSetting;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_310;

public class FastUseModule extends Module {
   public final ModeSetting items = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("?\u001e7H{"), Deobf.decrypt("!\u00023Q(\u009c\u008a\u009açĎĶŞŤǬƴǕ"), Deobf.decrypt("7\u0006>"), new String[]{Deobf.decrypt("7\u0006>"), Deobf.decrypt("&\u000f3Wd\u009b"), Deobf.decrypt(".:rgg\u009c\u0091Öñč")}));

   public FastUseModule() {
      super(Deobf.decrypt("0\u000b!Q]\u009b\u0080"), Deobf.decrypt("$\u000f?J~\u008d\u0096\u009aýĊĶŖĠƹƲǀƢȅȯɅɟʄʠˇ˙̂"), Category.MISC);
   }

   public void onTick() {
      class_310 mc = class_310.method_1551();
      if (mc.field_1724 != null && this.appliesTo(mc)) {
         ((MinecraftAccessor)mc).vulxtsclient$setRightClickDelay(0);
      }

   }

   private boolean appliesTo(class_310 mc) {
      if (this.items.is(Deobf.decrypt("7\u0006>"))) {
         return true;
      } else {
         class_1792 target = this.items.is(Deobf.decrypt("&\u000f3Wd\u009b")) ? class_1802.field_8634 : class_1802.field_8287;
         return mc.field_1724.method_6047().method_31574(target) || mc.field_1724.method_6079().method_31574(target);
      }
   }
}
