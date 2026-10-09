package dev.vulxts.mixin;

import dev.vulxts.VulxtsClient;
import dev.vulxts.license.LicenseGuard;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.render.AccessoryRenderer;
import dev.vulxts.render.BlockEspRenderer;
import dev.vulxts.render.BlockOutlineRenderer;
import dev.vulxts.render.ChunkFinderRenderer;
import dev.vulxts.render.ClusterEspRenderer;
import dev.vulxts.render.EntityEspRenderer;
import dev.vulxts.render.HitParticleRenderer;
import dev.vulxts.render.HoleEspRenderer;
import dev.vulxts.render.JumpCircleRenderer;
import dev.vulxts.render.MiscBlockEspRenderer;
import dev.vulxts.render.NetheriteFinderRenderer;
import dev.vulxts.render.NetheriteProbabilityRenderer;
import dev.vulxts.render.StorageEspRenderer;
import dev.vulxts.render.SusChunkRenderer;
import net.minecraft.class_11658;
import net.minecraft.class_12074;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_761.class})
public class LevelRendererMixin {
   @Inject(
      method = {"method_62210(Lnet/minecraft/class_4597$class_4598;Lnet/minecraft/class_4587;ZLnet/minecraft/class_11658;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void vulxtsclient$customBlockOutline(class_4597.class_4598 var1, class_4587 var2, boolean var3, class_11658 var4, CallbackInfo var5) {
      LicenseGuard.checkpoint();
      ModuleManager var6 = VulxtsClient.modules();
      if (var6 != null) {
         if (var3 && var6.susChunkFinder.isEnabled()) {
            SusChunkRenderer.render(var1, var2, var4.field_63082.field_63078, var6.susChunkFinder);
         }

         if (var3 && var6.chunkFinder != null && var6.chunkFinder.isEnabled()) {
            ChunkFinderRenderer.render(var1, var2, var4.field_63082.field_63078, var6.chunkFinder);
         }

         if (var3 && var6.storageEsp != null && var6.storageEsp.isEnabled()) {
            StorageEspRenderer.render(var1, var2, var4.field_63082.field_63078, var6.storageEsp);
         }

         if (var3 && var6.blockEsp != null && var6.blockEsp.isEnabled()) {
            BlockEspRenderer.render(var1, var2, var4.field_63082.field_63078, var6.blockEsp);
         }

         if (var3 && var6.clusterEsp != null && var6.clusterEsp.isEnabled()) {
            ClusterEspRenderer.render(var1, var2, var4.field_63082.field_63078, var6.clusterEsp);
         }

         if (var3 && var6.netheriteFinder != null && var6.netheriteFinder.isEnabled()) {
            NetheriteFinderRenderer.render(var1, var2, var4.field_63082.field_63078, var6.netheriteFinder);
            NetheriteProbabilityRenderer.renderBoxes(var1, var2, var4.field_63082.field_63078, var6.netheriteFinder);
         }

         if (var3 && var6.spawnerNametags != null && var6.spawnerNametags.isEnabled()) {
            MiscBlockEspRenderer.renderSpawners(var1, var2, var4.field_63082.field_63078, var6.spawnerNametags);
         }

         if (var3 && var6.debugHoleEsp != null && var6.debugHoleEsp.isEnabled()) {
            HoleEspRenderer.render(var1, var2, var4.field_63082.field_63078, var6.debugHoleEsp);
         }

         if (var3 && var6.playerEsp != null && var6.playerEsp.isEnabled()) {
            EntityEspRenderer.renderPlayers(var1, var2, var4.field_63082.field_63078, var6.playerEsp);
         }

         if (var3 && var6.mobEsp != null && var6.mobEsp.isEnabled()) {
            EntityEspRenderer.renderMobs(var1, var2, var4.field_63082.field_63078, var6.mobEsp);
         }

         if (var3 && var6.jumpCircles != null && var6.jumpCircles.isEnabled()) {
            JumpCircleRenderer.render(var1, var2, var4.field_63082.field_63078, var6.jumpCircles);
         }

         if (var3 && var6.hitParticles != null && var6.hitParticles.isEnabled()) {
            HitParticleRenderer.render(var1, var2, var4.field_63082.field_63078, var6.hitParticles);
         }

         if (var3 && var6.customAccessories != null && var6.customAccessories.isEnabled()) {
            AccessoryRenderer.render(var1, var2, var4.field_63082.field_63078, var6.customAccessories);
         }

         if (var6.freecam != null && var6.freecam.isActive()) {
            var5.cancel();
         } else if (var6.blockOutline.isEnabled()) {
            var5.cancel();
            class_12074 var7 = var4.field_63083;
            if (var7 != null && var7.comp_4933() == var3) {
               BlockOutlineRenderer.render(var1, var2, var7, var4.field_63082.field_63078, var6.blockOutline);
            }
         }
      }

   }
}
