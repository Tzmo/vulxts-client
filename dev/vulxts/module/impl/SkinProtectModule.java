package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.settings.ModeSetting;
import java.util.UUID;
import net.minecraft.class_1068;
import net.minecraft.class_310;
import net.minecraft.class_8685;

public class SkinProtectModule extends Module {
   public final ModeSetting applyTo = (ModeSetting)this.addSetting(new ModeSetting("Apply To", "Which players use the random skin locally.", "Self", new String[]{"Everyone", "Others", "Self"}));
   private volatile class_8685 replacement;

   public SkinProtectModule() {
      super("Skin Protect", "Uses a random built-in Minecraft skin locally while enabled.", Category.MISC);
   }

   protected void onEnable() {
      this.replacement = class_1068.method_4648(UUID.randomUUID());
   }

   protected void onDisable() {
      this.replacement = null;
   }

   public class_8685 replacementSkin() {
      return this.replacement;
   }

   public boolean shouldReplace(UUID var1) {
      if (var1 == null) {
         return false;
      } else {
         class_310 var3 = class_310.method_1551();
         UUID var2 = var3.field_1724 == null ? null : var3.field_1724.method_5667();
         if (this.applyTo.is("Everyone")) {
            return true;
         } else {
            return this.applyTo.is("Self") ? var2 != null && var2.equals(var1) : var2 == null || !var2.equals(var1);
         }
      }
   }
}
