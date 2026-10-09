package dev.vulxts.gametest;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.impl.RegionMapModule;
import net.fabricmc.fabric.api.client.gametest.v1.FabricClientGameTest;
import net.fabricmc.fabric.api.client.gametest.v1.context.ClientGameTestContext;
import net.fabricmc.fabric.api.client.gametest.v1.context.TestServerContext;
import net.fabricmc.fabric.api.client.gametest.v1.context.TestSingleplayerContext;

public class RegionMapGameTest implements FabricClientGameTest {
   public void runTest(ClientGameTestContext context) {
      TestSingleplayerContext world = context.worldBuilder().create();

      try {
         world.getClientWorld().waitForChunksRender();
         context.runOnClient((mc) -> {
            mc.field_1690.field_1837 = false;
         });
         context.getInput().resizeWindow(1600, 900);
         context.waitTicks(2);
         TestServerContext server = world.getServer();
         context.runOnClient((mc) -> {
            ModuleManager m = VulxtsClient.modules();
            require(m.regionMap != null, "RegionMap registered");
            m.regionMap.setEnabled(true);
         });
         server.runCommand("gamemode spectator @a");
         server.runCommand("tp @a 0 80 0");
         context.waitTicks(5);
         context.runOnClient((mc) -> {
            RegionMapModule rm = VulxtsClient.modules().regionMap;
            require(rm.hasData(), "RegionMap has data");
            require(rm.currentRegionId() >= 0, "Player is on the map at spawn");
         });
         context.takeScreenshot("region-map-spawn");
         server.runCommand("tp @a -100000 80 -100000");
         context.waitTicks(5);
         context.runOnClient((mc) -> {
            require(VulxtsClient.modules().regionMap.currentRegionId() >= 0, "Player is on the map after moving one region");
         });
         context.takeScreenshot("region-map-other-region");
         server.runCommand("tp @a 400000 80 400000");
         context.waitTicks(5);
         context.runOnClient((mc) -> {
            require(VulxtsClient.modules().regionMap.currentRegionId() < 0, "Player is off the map when far away");
         });
         context.takeScreenshot("region-map-offmap");
      } catch (Throwable var6) {
         if (world != null) {
            try {
               world.close();
            } catch (Throwable var5) {
               var6.addSuppressed(var5);
            }
         }

         throw var6;
      }

      if (world != null) {
         world.close();
      }

   }

   private static void require(boolean condition, String message) {
      if (!condition) {
         throw new AssertionError(message);
      }
   }
}
