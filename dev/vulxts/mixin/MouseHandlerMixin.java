package dev.vulxts.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.vulxts.VulxtsClient;
import dev.vulxts.hud.HudDragController;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.util.CpsTracker;
import net.minecraft.class_11910;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_408;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_312.class})
public class MouseHandlerMixin {
   @Shadow
   private double field_1789;
   @Shadow
   private double field_1787;

   @Inject(
      method = {"method_1606"},
      at = {@At("HEAD")}
   )
   private void vulxtsclient$aimAssist(double var1, CallbackInfo var3) {
      ModuleManager var4 = VulxtsClient.modules();
      if (var4 != null && var4.aimAssist != null && var4.aimAssist.isEnabled()) {
         double[] var5 = var4.aimAssist.computePixels(var1, this.field_1789, this.field_1787);
         if (var5 != null) {
            this.field_1789 += var5[0];
            this.field_1787 += var5[1];
         }
      }

   }

   @Inject(
      method = {"method_1601(JLnet/minecraft/class_11910;I)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void vulxtsclient$onButton(long var1, class_11910 var3, int var4, CallbackInfo var5) {
      class_310 var6 = class_310.method_1551();
      if (var1 == var6.method_22683().method_4490()) {
         if (var4 == 1 && var6.field_1755 == null) {
            CpsTracker.onClick(var3.comp_4801());
            ModuleManager var7 = VulxtsClient.modules();
            if (var7 != null && var6.field_1687 != null) {
               var7.onKeyPressed(var3.comp_4801());
            }
         }

         if (var6.field_1755 instanceof class_408 && var3.comp_4801() == 0 && VulxtsClient.hud() != null) {
            if (var4 == 1) {
               if (HudDragController.tryStartDrag(VulxtsClient.hud())) {
                  var5.cancel();
               }
            } else if (var4 == 0 && HudDragController.isDragging()) {
               HudDragController.stopDrag();
               VulxtsClient.config().save();
               var5.cancel();
            }
         }
      }

   }

   @ModifyExpressionValue(
      method = {"method_1606"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/class_7172;method_41753()Ljava/lang/Object;"
)},
      slice = {@Slice(
   from = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/class_315;method_42495()Lnet/minecraft/class_7172;"
)
)}
   )
   private Object vulxtsclient$zoomSensitivity(Object var1) {
      ModuleManager var2 = VulxtsClient.modules();
      if (var2 != null && var2.zoom != null && var1 instanceof Double var3) {
         double var4 = var2.zoom.currentFactor();
         if (var4 <= 1.0001) {
            return var1;
         } else {
            double var6 = var3 * 0.6 + 0.2;
            double var8 = var6 / Math.cbrt(var4);
            double var10 = (var8 - 0.2) / 0.6;
            return Math.max(0.0, var10);
         }
      } else {
         return var1;
      }
   }

   @Inject(
      method = {"method_1598(JDD)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void vulxtsclient$onScroll(long var1, double var3, double var5, CallbackInfo var7) {
      class_310 var8 = class_310.method_1551();
      if (var1 == var8.method_22683().method_4490() && var8.field_1755 instanceof class_408 && VulxtsClient.hud() != null && HudDragController.tryResize(VulxtsClient.hud(), var5)) {
         var7.cancel();
      }

   }
}
