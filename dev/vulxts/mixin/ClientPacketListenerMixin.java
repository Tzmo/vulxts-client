package dev.vulxts.mixin;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.impl.NetheriteFinderModule;
import dev.vulxts.module.impl.SpawnerProtectModule;
import dev.vulxts.render.BlockEspRenderer;
import dev.vulxts.render.ClusterEspRenderer;
import dev.vulxts.render.StorageEspRenderer;
import dev.vulxts.util.TpsTracker;
import net.minecraft.class_2338;
import net.minecraft.class_2620;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2672;
import net.minecraft.class_2761;
import net.minecraft.class_310;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public class ClientPacketListenerMixin {
   @Inject(
      method = {"method_11079"},
      at = {@At("HEAD")}
   )
   private void vulxtsclient$trackTps(class_2761 var1, CallbackInfo var2) {
      TpsTracker.onTimePacket();
   }

   @Inject(
      method = {"method_45730"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void vulxtsclient$fakeCommands(String var1, CallbackInfo var2) {
      ModuleManager var3 = VulxtsClient.modules();
      if (var3 != null) {
         try {
            if (var3.fakePay != null && var3.fakePay.tryIntercept(var1)) {
               var2.cancel();
               return;
            }

            if (var3.fakeStats != null && var3.fakeStats.tryInterceptBalance(var1)) {
               var2.cancel();
            }
         } catch (Exception var5) {
         }
      }

   }

   @Inject(
      method = {"method_11128"},
      at = {@At("TAIL")}
   )
   private void vulxtsclient$blockEntityChunk(class_2672 var1, CallbackInfo var2) {
      BlockEspRenderer.markChunkDirty(var1.method_11523(), var1.method_11524());
      ClusterEspRenderer.markChunkDirty(var1.method_11523(), var1.method_11524());
      StorageEspRenderer.markChunkDirty(var1.method_11523(), var1.method_11524());
      ModuleManager var3 = VulxtsClient.modules();
      if (var3 != null && var3.spawnerNametags != null && var3.spawnerNametags.isEnabled()) {
         var3.spawnerNametags.markChunkDirty(var1.method_11523(), var1.method_11524());
      }

      markSusChunkDirty(var1.method_11523(), var1.method_11524());
   }

   private static SpawnerProtectModule spawnerProtect() {
      ModuleManager var0 = VulxtsClient.modules();
      return var0 != null ? var0.spawnerProtect : null;
   }

   private static NetheriteFinderModule netheriteFinder() {
      ModuleManager modules = VulxtsClient.modules();
      return modules != null ? modules.netheriteFinder : null;
   }

   private static void markSusChunkDirty(int var0, int var1) {
      ModuleManager var2 = VulxtsClient.modules();
      if (var2 != null && var2.susChunkFinder != null && var2.susChunkFinder.isEnabled()) {
         var2.susChunkFinder.scanner.requestRescan(var0, var1);
      }

   }

   private static void markSpawnerNotifierDirty() {
      ModuleManager var0 = VulxtsClient.modules();
      if (var0 != null && var0.spawnerNametags != null && var0.spawnerNametags.isEnabled()) {
         var0.spawnerNametags.markDirty();
      }

   }

   @Inject(
      method = {"method_11116"},
      at = {@At("HEAD")}
   )
   private void vulxtsclient$spawnerProtectDestruction(class_2620 var1, CallbackInfo var2) {
      SpawnerProtectModule var3 = spawnerProtect();
      if (var3 != null && var3.isEnabled() && class_310.method_1551().method_18854()) {
         try {
            var3.onBlockDestructionPacket(var1.method_11280(), var1.method_11277());
         } catch (Exception var5) {
         }
      }

   }

   @Inject(
      method = {"method_11136"},
      at = {@At("HEAD")}
   )
   private void vulxtsclient$spawnerProtectBlockUpdate(class_2626 var1, CallbackInfo var2) {
      BlockEspRenderer.markDirty();
      ClusterEspRenderer.markDirty();
      class_2338 var3 = var1.method_11309();
      BlockEspRenderer.markChunkDirty(var3.method_10263() >> 4, var3.method_10260() >> 4);
      ClusterEspRenderer.markChunkDirty(var3.method_10263() >> 4, var3.method_10260() >> 4);
      StorageEspRenderer.markChunkDirty(var3.method_10263() >> 4, var3.method_10260() >> 4);
      markSpawnerNotifierDirty();
      markSusChunkDirty(var3.method_10263() >> 4, var3.method_10260() >> 4);
      NetheriteFinderModule finder = netheriteFinder();
      if (finder != null) {
         finder.onServerBlockUpdate(var3, var1.method_11308());
      }

      SpawnerProtectModule var4 = spawnerProtect();
      if (var4 != null && var4.isEnabled() && var4.detectBlockUpdatesEnabled() && class_310.method_1551().method_18854()) {
         try {
            var4.onServerBlockUpdate(var1.method_11309(), var1.method_11308(), false);
         } catch (Exception var7) {
         }
      }

   }

   @Inject(
      method = {"method_11100"},
      at = {@At("HEAD")}
   )
   private void vulxtsclient$spawnerProtectSectionUpdate(class_2637 var1, CallbackInfo var2) {
      BlockEspRenderer.markDirty();
      ClusterEspRenderer.markDirty();
      markSpawnerNotifierDirty();
      SpawnerProtectModule var3 = spawnerProtect();
      boolean var4 = var3 != null && var3.isEnabled() && var3.detectBlockUpdatesEnabled() && class_310.method_1551().method_18854();

      try {
         var1.method_30621((var2x, var3x) -> {
            BlockEspRenderer.markChunkDirty(var2x.method_10263() >> 4, var2x.method_10260() >> 4);
            ClusterEspRenderer.markChunkDirty(var2x.method_10263() >> 4, var2x.method_10260() >> 4);
            StorageEspRenderer.markChunkDirty(var2x.method_10263() >> 4, var2x.method_10260() >> 4);
            markSusChunkDirty(var2x.method_10263() >> 4, var2x.method_10260() >> 4);
            NetheriteFinderModule finder = netheriteFinder();
            if (finder != null) {
               finder.onServerBlockUpdate(var2x, var3x);
            }

            if (var4) {
               var3.onServerBlockUpdate(var2x, var3x, true);
            }

         });
      } catch (Exception var6) {
      }

   }
}
