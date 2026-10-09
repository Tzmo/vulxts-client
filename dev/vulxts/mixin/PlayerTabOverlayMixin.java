package dev.vulxts.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.authlib.GameProfile;
import dev.vulxts.VulxtsClient;
import dev.vulxts.module.ModuleManager;
import net.minecraft.class_2561;
import net.minecraft.class_355;
import net.minecraft.class_640;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_355.class})
public class PlayerTabOverlayMixin {
   @ModifyReturnValue(
      method = {"method_1918"},
      at = {@At("RETURN")}
   )
   private class_2561 vulxtsclient$protectTabName(class_2561 original, class_640 playerInfo) {
      ModuleManager modules = VulxtsClient.modules();
      if (modules == null) {
         return original;
      } else {
         GameProfile profile = playerInfo.method_2966();
         String name = profile == null ? null : profile.name();
         class_2561 result = original;
         if (modules.nameProtect != null && modules.nameProtect.isEnabled() && name != null && !name.isEmpty()) {
            String replacement = modules.nameProtect.replacementForDisplay(name);
            if (replacement != null) {
               result = class_2561.method_43470(replacement);
            }
         }

         if (modules.fakeRoles != null && name != null) {
            result = modules.fakeRoles.decorateTab((class_2561)result, name);
         }

         return (class_2561)result;
      }
   }
}
