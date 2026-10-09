package dev.vulxts.mixin;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.impl.FakeMediaModule;
import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_11890;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1007.class})
public final class PlayerEntityRendererMixin {
   @Inject(
      method = {"method_62604"},
      at = {@At("TAIL")}
   )
   private void vulxts$fakeMediaBadge(class_11890 var1, class_10055 var2, float var3, CallbackInfo var4) {
      FakeMediaModule var5 = module();
      class_310 var6 = class_310.method_1551();
      if (var5 != null && var5.hasVisibleBadge() && var6.field_1724 != null && var2.field_53528 == var6.field_1724.method_5628()) {
         if (var2.field_53525 != null) {
            var2.field_53525 = var5.decorate(var2.field_53525);
         } else if (var2.field_53337 != null) {
            var2.field_53525 = var5.decorate(var2.field_53337);
         }

         var2.field_53337 = null;
      }

   }

   @Inject(
      method = {"method_74935"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void vulxts$showOwnMediaLabel(class_11890 var1, double var2, CallbackInfoReturnable var4) {
      FakeMediaModule var5 = module();
      class_310 var6 = class_310.method_1551();
      if (var5 != null && var5.hasVisibleBadge() && var6.field_1724 != null && var1.method_5628() == var6.field_1724.method_5628()) {
         var4.setReturnValue(true);
      }

   }

   private static FakeMediaModule module() {
      ModuleManager var0 = VulxtsClient.modules();
      return var0 == null ? null : var0.fakeMedia;
   }
}
