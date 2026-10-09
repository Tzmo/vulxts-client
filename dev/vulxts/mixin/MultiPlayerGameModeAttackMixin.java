package dev.vulxts.mixin;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.impl.NetheriteFinderModule;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1747;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_636;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_636.class})
public class MultiPlayerGameModeAttackMixin {
   @Unique
   private class_2338 vulxtsclient$pendingPlacement;
   @Unique
   private class_2338 vulxtsclient$pendingMinedDebris;

   @Inject(
      method = {"method_2918"},
      at = {@At("HEAD")}
   )
   private void vulxtsclient$onAttack(class_1657 player, class_1297 target, CallbackInfo ci) {
      if (player == class_310.method_1551().field_1724 && target != player) {
         ModuleManager modules = VulxtsClient.modules();
         if (modules != null && modules.hitParticles != null && modules.hitParticles.isEnabled()) {
            modules.hitParticles.onHit(target);
         }
      }

   }

   @Inject(
      method = {"method_2899"},
      at = {@At("HEAD")}
   )
   private void vulxtsclient$beginBlockBreak(class_2338 pos, CallbackInfoReturnable cir) {
      this.vulxtsclient$pendingMinedDebris = null;
      class_310 mc = class_310.method_1551();
      if (mc.field_1687 != null && mc.field_1687.method_8320(pos).method_27852(class_2246.field_22109)) {
         this.vulxtsclient$pendingMinedDebris = new class_2338(pos.method_10263(), pos.method_10264(), pos.method_10260());
      }

   }

   @Inject(
      method = {"method_2899"},
      at = {@At("RETURN")}
   )
   private void vulxtsclient$finishBlockBreak(class_2338 pos, CallbackInfoReturnable cir) {
      class_2338 mined = this.vulxtsclient$pendingMinedDebris;
      this.vulxtsclient$pendingMinedDebris = null;
      if (mined != null && Boolean.TRUE.equals(cir.getReturnValue())) {
         ModuleManager modules = VulxtsClient.modules();
         NetheriteFinderModule finder = modules == null ? null : modules.netheriteFinder;
         if (finder != null) {
            finder.recordMinedDebris(mined);
         }

      }
   }

   @Inject(
      method = {"method_2896"},
      at = {@At("HEAD")}
   )
   private void vulxtsclient$beginPlacement(class_746 player, class_1268 hand, class_3965 hit, CallbackInfoReturnable cir) {
      this.vulxtsclient$pendingPlacement = null;
      class_310 mc = class_310.method_1551();
      if (player == mc.field_1724 && mc.field_1687 != null) {
         if ((hand == class_1268.field_5808 ? player.method_6047() : player.method_6079()).method_7909() instanceof class_1747) {
            class_2338 clicked = hit.method_17777();
            class_2338 target = mc.field_1687.method_8320(clicked).method_45474() ? clicked : clicked.method_10093(hit.method_17780());
            this.vulxtsclient$pendingPlacement = new class_2338(target.method_10263(), target.method_10264(), target.method_10260());
         }
      }
   }

   @Inject(
      method = {"method_2896"},
      at = {@At("RETURN")}
   )
   private void vulxtsclient$finishPlacement(class_746 player, class_1268 hand, class_3965 hit, CallbackInfoReturnable cir) {
      class_2338 target = this.vulxtsclient$pendingPlacement;
      this.vulxtsclient$pendingPlacement = null;
      if (target != null && cir.getReturnValue() != null && ((class_1269)cir.getReturnValue()).method_23665()) {
         ModuleManager modules = VulxtsClient.modules();
         NetheriteFinderModule finder = modules == null ? null : modules.netheriteFinder;
         if (finder != null) {
            finder.recordPlayerPlacement(target);
         }

      }
   }
}
