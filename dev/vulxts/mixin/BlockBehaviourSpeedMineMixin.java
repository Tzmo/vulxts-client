package dev.vulxts.mixin;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.impl.SpeedMineModule;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_4970.class})
public abstract class BlockBehaviourSpeedMineMixin {
   @Inject(
      method = {"method_9594"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void vulxtsclient$applySpeedMine(class_2680 var1, class_1657 var2, class_1922 var3, class_2338 var4, CallbackInfoReturnable var5) {
      ModuleManager var6 = VulxtsClient.modules();
      if (var6 != null) {
         SpeedMineModule var7 = var6.speedMine;
         if (var7 != null && var7.isEnabled()) {
            var5.setReturnValue(var7.apply(var5.getReturnValueF()));
         }
      }

   }
}
