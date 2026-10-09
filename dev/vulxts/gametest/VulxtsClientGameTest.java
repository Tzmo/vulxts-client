package dev.vulxts.gametest;

import dev.vulxts.VulxtsClient;
import dev.vulxts.gui.ClickGuiScreen;
import dev.vulxts.gui.IconPickerScreen;
import dev.vulxts.module.Modules;
import dev.vulxts.module.impl.ChunkFinderModule;
import dev.vulxts.module.impl.CustomAccessoriesModule;
import dev.vulxts.module.impl.CustomCrosshairModule;
import dev.vulxts.module.impl.CustomFovModule;
import dev.vulxts.module.impl.CustomGlintModule;
import dev.vulxts.module.impl.FreecamModule;
import dev.vulxts.module.impl.HitParticlesModule;
import dev.vulxts.module.impl.MotionBlurModule;
import dev.vulxts.module.impl.NameProtectModule;
import dev.vulxts.module.impl.NameTagsModule;
import dev.vulxts.module.impl.SpawnerNametagsModule;
import dev.vulxts.module.impl.StorageEspModule;
import dev.vulxts.notification.NotificationManager;
import dev.vulxts.render.BlockEspRenderer;
import dev.vulxts.render.MotionBlurRenderer;
import dev.vulxts.render.StorageEspRenderer;
import dev.vulxts.suschunk.ServerLightCache;
import dev.vulxts.suschunk.SusChunkScanner;
import dev.vulxts.theme.Theme;
import dev.vulxts.util.Colors;
import java.util.Iterator;
import net.fabricmc.fabric.api.client.gametest.v1.FabricClientGameTest;
import net.fabricmc.fabric.api.client.gametest.v1.context.ClientGameTestContext;
import net.fabricmc.fabric.api.client.gametest.v1.context.TestServerContext;
import net.fabricmc.fabric.api.client.gametest.v1.context.TestSingleplayerContext;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1531;
import net.minecraft.class_1923;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_490;
import net.minecraft.class_5498;

public class VulxtsClientGameTest implements FabricClientGameTest {
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

         int x;
         int i;
         for(x = -60; x <= -58; ++x) {
            for(i = 8; i <= 10; ++i) {
               server.runCommand("setblock " + x + " 0 " + i + " minecraft:budding_amethyst");
               server.runCommand("setblock " + x + " 1 " + i + " minecraft:amethyst_cluster");
            }
         }

         for(x = 8; x <= 12; ++x) {
            for(i = 8; i <= 11; ++i) {
               server.runCommand("setblock " + x + " 0 " + i + " minecraft:budding_amethyst");
            }
         }

         for(x = 20; x <= 23; ++x) {
            for(i = 8; i <= 10; ++i) {
               server.runCommand("setblock " + x + " 0 " + i + " minecraft:budding_amethyst");
            }
         }

         for(x = 14; x <= 17; ++x) {
            server.runCommand("setblock " + x + " 0 64 minecraft:budding_amethyst");
         }

         for(x = 97; x <= 99; ++x) {
            for(i = 9; i <= 11; ++i) {
               server.runCommand("setblock " + x + " -1 " + i + " minecraft:dirt");
               server.runCommand("setblock " + x + " 0 " + i + " minecraft:sweet_berry_bush[age=3]");
            }
         }

         server.runCommand("setblock 40 0 40 minecraft:beehive[honey_level=5]");
         server.runCommand("setblock 40 0 72 minecraft:beehive[honey_level=5]");
         server.runCommand("setblock 72 0 40 minecraft:beehive[honey_level=0]");
         context.waitTicks(10);
         context.runOnClient((mc) -> {
            Modules.SusChunkFinderModule finder = VulxtsClient.modules().susChunkFinder;
            finder.sensitivity.set(3.0);
            finder.notifications.set("Toast");
            finder.smartMode.set(true);
            finder.outline.set(true);
            finder.showOnRadar.set(true);
            finder.renderY.set(-59.0);
            finder.setEnabled(true);
         });
         server.runCommand("tp @a 3000 -58 3000");
         world.getClientWorld().waitForChunksRender();
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(-90.0F);
               mc.field_1724.method_36457(0.0F);
            }

         });
         context.waitTicks(60);
         context.runOnClient((mc) -> {
            SusChunkScanner scanner = VulxtsClient.modules().susChunkFinder.scanner;
            assertThat(scanner.flags().isEmpty(), "fresh area must produce zero flags, got " + scanner.flags().size());
         });
         context.takeScreenshot("01-fresh-area-clean");
         server.runCommand("tp @a -14 -58 -10");
         world.getClientWorld().waitForChunksRender();
         context.waitTicks(80);
         context.runOnClient((mc) -> {
            SusChunkScanner scanner = VulxtsClient.modules().susChunkFinder.scanner;
            boolean realGeodeFlagged = scanner.flags().stream().anyMatch((f) -> {
               return f.chunkKey() == class_1923.method_8331(-4, 0);
            });
            assertThat(realGeodeFlagged, "REAL geode (visible clusters, packet light) must flag after chunk reload");
         });
         context.runOnClient((mc) -> {
            int x;
            int z;
            for(x = 8; x <= 12; ++x) {
               for(z = 8; z <= 11; ++z) {
                  ServerLightCache.get().injectForTest(x, 1, z, 5);
               }
            }

            for(x = 20; x <= 23; ++x) {
               for(z = 8; z <= 10; ++z) {
                  ServerLightCache.get().injectForTest(x, 1, z, 5);
               }
            }

         });
         context.waitTicks(30);
         context.runOnClient((mc) -> {
            SusChunkScanner scanner = VulxtsClient.modules().susChunkFinder.scanner;
            boolean var10000 = scanner.flags().size() == 3;
            int var10001 = scanner.flags().size();
            assertThat(var10000, "real geode + two synth chunks must flag, got " + var10001);
            assertThat(scanner.zones().size() == 2, "expected 2 zones (real geode; merged synth pair), got " + scanner.zones().size());
         });
         server.runCommand("tp @a 16 -58 64");
         world.getClientWorld().waitForChunksRender();
         context.waitTicks(25);
         context.runOnClient((mc) -> {
            for(int x = 14; x <= 17; ++x) {
               ServerLightCache.get().injectForTest(x, 1, 64, 5);
            }

         });
         context.waitTicks(30);
         context.runOnClient((mc) -> {
            SusChunkScanner scanner = VulxtsClient.modules().susChunkFinder.scanner;
            boolean left = scanner.flags().stream().anyMatch((f) -> {
               return f.chunkKey() == class_1923.method_8331(0, 4);
            });
            boolean right = scanner.flags().stream().anyMatch((f) -> {
               return f.chunkKey() == class_1923.method_8331(1, 4);
            });
            assertThat(left && right, "split geode: BOTH 2-cluster sub-chunks must flag via per-geode counting");
            boolean sameZone = scanner.zones().stream().anyMatch((z) -> {
               return z.members().contains(class_1923.method_8331(0, 4)) && z.members().contains(class_1923.method_8331(1, 4));
            });
            assertThat(sameZone, "split geode's two chunks must share one zone");
         });
         server.runCommand("tp @a 16 -33 92");
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(180.0F);
               mc.field_1724.method_36457(46.0F);
            }

         });
         context.waitTicks(3);
         context.takeScreenshot("02b-split-geode-both-chunks");
         server.runCommand("tp @a -58 -42 35");
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(180.0F);
               mc.field_1724.method_36457(36.0F);
            }

         });
         context.waitTicks(3);
         context.takeScreenshot("02-real-geode-flagged");
         server.runCommand("tp @a -20 -35 -8");
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(-66.0F);
               mc.field_1724.method_36457(33.0F);
            }

         });
         context.waitTicks(3);
         context.takeScreenshot("03-smart-merged-quad");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().susChunkFinder.smartMode.set(false);
         });
         server.runCommand("tp @a -20 -35 -8");
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(-66.0F);
               mc.field_1724.method_36457(33.0F);
            }

         });
         context.waitTicks(3);
         context.takeScreenshot("04-per-chunk");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().susChunkFinder.smartMode.set(true);
         });
         server.runCommand("tp @a -20 -58 -8");
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(-66.0F);
               mc.field_1724.method_36457(10.0F);
            }

         });
         context.waitTicks(10);
         context.takeScreenshot("05-radar-inrange");
         server.runCommand("tp @a 100 -58 8");
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(-90.0F);
               mc.field_1724.method_36457(5.0F);
            }

         });
         context.waitTicks(25);
         context.takeScreenshot("06-radar-clamped-label");
         context.runOnClient((mc) -> {
            Modules.SusChunkFinderModule finder = VulxtsClient.modules().susChunkFinder;
            finder.notifications.set("Chat");
            finder.sensitivity.set(2.0);
         });
         context.waitTicks(30);
         context.runOnClient((mc) -> {
            SusChunkScanner scanner = VulxtsClient.modules().susChunkFinder.scanner;
            boolean berryFlagged = scanner.flags().stream().anyMatch((f) -> {
               return f.chunkKey() == class_1923.method_8331(6, 0);
            });
            assertThat(berryFlagged, "berry chunk must join at sensitivity 2");
         });
         context.takeScreenshot("07-berries-sens2-chat");
         context.runOnClient((mc) -> {
            Modules.SusChunkFinderModule finder = VulxtsClient.modules().susChunkFinder;
            finder.sensitivity.set(3.0);
            finder.notifications.set("Toast");
            ClickGuiScreen.state().setExpanded("SusChunkFinder@RENDER", true);
         });
         context.getInput().pressKey(344);
         context.waitForScreen(ClickGuiScreen.class);
         context.waitTicks(10);
         context.takeScreenshot("08-settings");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().susChunkFinder.setEnabled(false);
            ClickGuiScreen.state().setExpanded("SusChunkFinder@RENDER", false);
         });
         context.getInput().pressKey(344);
         context.waitForScreen((Class)null);
         String[] containers = new String[]{"chest", "trapped_chest", "barrel", "white_shulker_box", "furnace", "blast_furnace", "smoker", "hopper", "dropper", "dispenser", "ender_chest", "brewing_stand", "spawner"};

         for(i = 0; i < containers.length; ++i) {
            server.runCommand("setblock " + (2 + i) + " -59 25 minecraft:" + containers[i]);
         }

         server.runCommand("tp @a 3000 -58 3000");
         world.getClientWorld().waitForChunksRender();
         server.runCommand("tp @a 8 -57 18");
         world.getClientWorld().waitForChunksRender();
         context.waitTicks(10);
         context.runOnClient((mc) -> {
            StorageEspModule esp = VulxtsClient.modules().storageEsp;
            esp.tracers.set(false);
            esp.setEnabled(true);
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(12.0F);
            }

         });
         context.waitTicks(40);
         context.runOnClient((mc) -> {
            int count = StorageEspRenderer.cachedCount();
            long shulkers = StorageEspRenderer.cachedShulkerCount();
            StringBuilder seen = new StringBuilder();
            if (mc.field_1687 != null) {
               for(int i = 0; i < containers.length; ++i) {
                  seen.append(mc.field_1687.method_8320(new class_2338(2 + i, -59, 25)).method_26204().method_9518().getString()).append(' ');
               }
            }

            String ctx = " [cache=" + count + "/" + containers.length + " shulkers=" + shulkers + " playerChunk=" + String.valueOf(mc.field_1724 != null ? mc.field_1724.method_31476() : "null") + " clientBlocks=" + seen.toString().trim() + "]";
            assertThat(count >= containers.length, "StorageESP must detect every container type," + ctx);
            assertThat(shulkers >= 1L, "StorageESP must detect the shulker box," + ctx);
         });
         context.takeScreenshot("10-storage-esp-all-types");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().storageEsp.setEnabled(false);
         });
         server.runCommand("tp @a 8 -57 18");
         context.runOnClient((mc) -> {
            StorageEspModule esp = VulxtsClient.modules().storageEsp;
            esp.tracers.set(true);
            esp.setEnabled(true);
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(8.0F);
            }

         });
         context.waitTicks(20);
         context.takeScreenshot("10b-tracers-front-crosshair");
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(90.0F);
            }

         });
         context.waitTicks(20);
         context.takeScreenshot("10c-tracers-offcamera-side");
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(180.0F);
            }

         });
         context.waitTicks(20);
         context.takeScreenshot("10d-tracers-behind");
         context.runOnClient((mc) -> {
            StorageEspModule esp = VulxtsClient.modules().storageEsp;
            esp.tracers.set(false);
            esp.setEnabled(false);
         });
         server.runCommand("tp @a 8 -57 18");
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(0.0F);
            }

            CustomCrosshairModule xhair = VulxtsClient.modules().customCrosshair;
            xhair.hideVanilla.set(true);
            xhair.rainbow.set(false);
            xhair.setEnabled(true);
         });
         String[] xhairStyles = new String[]{"Cross", "Dot", "Circle", "T-Shape", "Brackets", "Chevron", "Vulxts"};

         for(int i = 0; i < xhairStyles.length; ++i) {
            String s = xhairStyles[i];
            context.runOnClient((mc) -> {
               VulxtsClient.modules().customCrosshair.style.set(s);
            });
            context.waitTicks(2);
            context.takeScreenshot(String.format("11%c-crosshair-%s", (char)(97 + i), s.toLowerCase()));
         }

         context.runOnClient((mc) -> {
            assertThat(VulxtsClient.modules().customCrosshair.style.is("Vulxts"), "crosshair style must be the Vulxts logo for the final shot");
         });
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.method_1507(new class_490(mc.field_1724));
            }

         });
         context.waitTicks(2);
         context.takeScreenshot("11h-crosshair-hidden-in-inventory");
         context.runOnClient((mc) -> {
            mc.method_1507((class_437)null);
            VulxtsClient.modules().customCrosshair.setEnabled(false);
         });
         server.runCommand("tp @a 8 -57 18");
         world.getClientWorld().waitForChunksRender();
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(0.0F);
            }

         });
         context.waitTicks(4);
         context.takeScreenshot("12a-zoom-off");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().zoom.setEnabled(true);
         });
         context.waitTicks(40);
         context.takeScreenshot("12b-zoom-on-4x");
         context.runOnClient((mc) -> {
            assertThat(VulxtsClient.modules().zoom.currentFactor() > 3.9, "Zoom must ease to the 4x target, was " + VulxtsClient.modules().zoom.currentFactor());
         });
         context.runOnClient((mc) -> {
            VulxtsClient.modules().zoom.setEnabled(false);
         });
         context.runOnClient((mc) -> {
            Modules.SpotifyModule s = VulxtsClient.modules().spotify;
            s.source.set("Demo");
            s.controls.set(true);
            s.volume.set(true);
            s.setEnabled(true);
         });
         context.waitTicks(5);
         context.takeScreenshot("13-spotify-volume-slider");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().spotify.setEnabled(false);
         });
         server.runCommand("tp @a 8 -57 18");
         world.getClientWorld().waitForChunksRender();
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(0.0F);
            }

         });
         context.waitTicks(4);
         context.takeScreenshot("14a-fov-off");
         context.runOnClient((mc) -> {
            CustomFovModule f = VulxtsClient.modules().customFov;
            f.fov.set(140.0);
            f.setEnabled(true);
         });
         context.waitTicks(40);
         context.takeScreenshot("14b-fov-140-fisheye");
         context.runOnClient((mc) -> {
            assertThat(VulxtsClient.modules().customFov.currentFov() > 135.0, "CustomFOV must ease to 140, was " + VulxtsClient.modules().customFov.currentFov());
         });
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customFov.fov.set(40.0);
         });
         context.waitTicks(40);
         context.takeScreenshot("14c-fov-40-tunnel");
         context.runOnClient((mc) -> {
            assertThat(VulxtsClient.modules().customFov.currentFov() < 45.0, "CustomFOV must ease to 40, was " + VulxtsClient.modules().customFov.currentFov());
         });
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customFov.setEnabled(false);
         });
         server.runCommand("tp @a 8 -57 18");
         world.getClientWorld().waitForChunksRender();
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(7.0F);
            }

            HitParticlesModule hp = VulxtsClient.modules().hitParticles;
            hp.amount.set(20.0);
            hp.size.set(1.4);
            hp.spread.set(1.1);
            hp.lifetime.set(1.0);
            hp.glow.set(80.0);
            hp.shockwave.set(true);
            hp.rainbow.set(false);
            hp.setEnabled(true);
         });
         context.waitTicks(15);
         String[] hitStyles = new String[]{"Sparks", "Hearts", "Lightning", "Vulxts"};

         int i;
         for(i = 0; i < hitStyles.length; ++i) {
            String s = hitStyles[i];
            context.runOnClient((mc) -> {
               HitParticlesModule hp = VulxtsClient.modules().hitParticles;
               hp.clear();
               hp.style.set(s);
               if (mc.field_1724 != null) {
                  class_243 eye = mc.field_1724.method_5836(1.0F);
                  class_243 look = mc.field_1724.method_5828(1.0F);
                  class_243 a = eye.method_1019(look.method_1021(3.0));
                  class_243 b = eye.method_1019(look.method_1021(3.9));
                  hp.spawnAt(a.field_1352 - 0.4, a.field_1351, a.field_1350);
                  hp.spawnAt(b.field_1352 + 0.4, b.field_1351 - 0.3, b.field_1350);
               }

            });
            context.runOnClient((mc) -> {
               assertThat(!VulxtsClient.modules().hitParticles.particles().isEmpty(), "HitParticles must spawn particles for style " + s);
            });
            context.waitTicks(3);
            context.takeScreenshot(String.format("15%c-hitparticles-%s", (char)(97 + i), s.toLowerCase()));
         }

         context.runOnClient((mc) -> {
            VulxtsClient.modules().hitParticles.clear();
            VulxtsClient.modules().hitParticles.style.set("Sparks");
         });
         server.runCommand("summon minecraft:armor_stand 8.5 -57 22 {NoGravity:1b}");
         context.waitTicks(10);
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null) {
               class_1297 target = null;
               Iterator var2 = mc.field_1687.method_18112().iterator();

               while(var2.hasNext()) {
                  class_1297 e = (class_1297)var2.next();
                  if (e instanceof class_1531) {
                     target = e;
                     break;
                  }
               }

               if (target != null) {
                  mc.field_1761.method_2918(mc.field_1724, target);
                  assertThat(!VulxtsClient.modules().hitParticles.particles().isEmpty(), "attack() mixin must feed HitParticles a burst on a real hit");
               }
            }

         });
         context.waitTicks(3);
         context.takeScreenshot("15e-hitparticles-real-hit");
         context.runOnClient((mc) -> {
            HitParticlesModule hp = VulxtsClient.modules().hitParticles;
            hp.style.set("Vulxts");
            ClickGuiScreen.state().setExpanded("HitParticles@VISUALS", true);
         });
         context.getInput().pressKey(344);
         context.waitForScreen(ClickGuiScreen.class);
         context.waitTicks(8);
         context.takeScreenshot("15f-hitparticles-settings");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().hitParticles.setEnabled(false);
            ClickGuiScreen.state().setExpanded("HitParticles@VISUALS", false);
         });
         context.getInput().pressKey(344);
         context.waitForScreen((Class)null);
         context.runOnClient((mc) -> {
            Modules.HudModule hudModule = VulxtsClient.modules().hud;
            hudModule.notifications.set(true);
            hudModule.notifyDuration.set(6.0);
            NotificationManager toasts = VulxtsClient.notifications();
            toasts.setPosition(0.99F, 0.71F);
            toasts.setScale(1.0F);
            toasts.push("SpeedMine", true);
            toasts.pushInfo("Sus chunk found  ·  1,247 blocks");
            toasts.pushWeather("Thunderstorm", "brewing overhead", NotificationManager.Weather.THUNDER, true);
         });
         context.waitTicks(12);
         context.takeScreenshot("16a-toasts-default-anchor");
         context.runOnClient((mc) -> {
            mc.method_1507(new class_408("", false));
         });
         context.waitForScreen(class_408.class);
         context.waitTicks(5);
         context.takeScreenshot("16b-toasts-editor-outline");
         context.runOnClient((mc) -> {
            NotificationManager toasts = VulxtsClient.notifications();
            toasts.setPosition(0.1F, 0.32F);
            toasts.setScale(1.3F);
         });
         context.waitTicks(8);
         context.takeScreenshot("16c-toasts-moved-scaled");
         context.runOnClient((mc) -> {
            NotificationManager toasts = VulxtsClient.notifications();
            assertThat(Math.abs(toasts.getFx() - 0.1F) < 0.001F && Math.abs(toasts.getScale() - 1.3F) < 0.001F, "notification anchor must hold its dragged position & scale");
         });
         context.runOnClient((mc) -> {
            mc.method_1507((class_437)null);
         });
         context.waitForScreen((Class)null);
         context.runOnClient((mc) -> {
            VulxtsClient.notifications().setPosition(0.99F, 0.71F);
            VulxtsClient.notifications().setScale(1.0F);
         });
         server.runCommand("tp @a 8 -57 18");
         world.getClientWorld().waitForChunksRender();
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(0.0F);
            }

            MotionBlurModule mb = VulxtsClient.modules().motionBlur;
            mb.strength.set(85.0);
            mb.pinkTrails.set(true);
            mb.tint.set(45.0);
            mb.fpsCompensated.set(false);
            mb.setEnabled(true);
         });
         context.waitTicks(6);
         context.takeScreenshot("17a-motionblur-static");

         for(i = 0; i < 12; ++i) {
            float yaw = (float)i * 22.0F;
            context.runOnClient((mc) -> {
               if (mc.field_1724 != null) {
                  mc.field_1724.method_36456(yaw);
               }

            });
            context.waitTicks(1);
         }

         context.runOnClient((mc) -> {
            boolean var10000 = MotionBlurRenderer.framesRendered() > 0 && MotionBlurRenderer.lastRetention() > 0.0F;
            int var10001 = MotionBlurRenderer.framesRendered();
            assertThat(var10000, "MotionBlur render path must run with retention > 0, frames=" + var10001 + " retention=" + MotionBlurRenderer.lastRetention());
         });
         context.takeScreenshot("17b-motionblur-spin-trails");
         context.runOnClient((mc) -> {
            ClickGuiScreen.state().setExpanded("MotionBlur@VISUALS", true);
         });
         context.getInput().pressKey(344);
         context.waitForScreen(ClickGuiScreen.class);
         context.waitTicks(8);
         context.takeScreenshot("17c-motionblur-settings");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().motionBlur.setEnabled(false);
            ClickGuiScreen.state().setExpanded("MotionBlur@VISUALS", false);
         });
         context.getInput().pressKey(344);
         context.waitForScreen((Class)null);
         server.runCommand("setblock 6 -59 30 minecraft:spawner{SpawnData:{entity:{id:\"minecraft:zombie\"}}}");
         server.runCommand("setblock 11 -59 30 minecraft:trial_spawner");
         server.runCommand("tp @a 3000 -58 3000");
         world.getClientWorld().waitForChunksRender();
         server.runCommand("tp @a 8 -57 22");
         world.getClientWorld().waitForChunksRender();
         context.waitTicks(10);
         server.runCommand("summon item 7 -58 28 {Item:{id:\"minecraft:diamond\",count:32}}");
         server.runCommand("summon item 9 -58 28 {Item:{id:\"minecraft:golden_apple\",count:3}}");
         server.runCommand("summon item 8 -58 27 {Item:{id:\"minecraft:netherite_ingot\",count:1}}");
         context.waitTicks(10);
         context.runOnClient((mc) -> {
            NameTagsModule nt = VulxtsClient.modules().nameTags;
            nt.items.set(true);
            nt.distance.set(true);
            nt.setEnabled(true);
            SpawnerNametagsModule sn = VulxtsClient.modules().spawnerNametags;
            sn.setEnabled(true);
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(12.0F);
            }

         });
         context.waitTicks(20);
         context.runOnClient((mc) -> {
            assertThat(!VulxtsClient.modules().spawnerNametags.scan.get().isEmpty(), "SpawnerNametags scan must find the placed spawners");
         });
         context.takeScreenshot("18a-nametags-items-spawners");
         context.runOnClient((mc) -> {
            NameProtectModule np = VulxtsClient.modules().nameProtect;
            np.ownName.set("Vulxts");
            np.setEnabled(true);
            ClickGuiScreen.state().setExpanded("NameTags@MISC", true);
         });
         context.getInput().pressKey(344);
         context.waitForScreen(ClickGuiScreen.class);
         context.waitTicks(8);
         context.takeScreenshot("18b-nametags-settings");
         context.runOnClient((mc) -> {
            ClickGuiScreen.state().setExpanded("NameTags@MISC", false);
         });
         context.getInput().pressKey(344);
         context.waitForScreen((Class)null);
         context.runOnClient((mc) -> {
            VulxtsClient.modules().nameTags.setEnabled(false);
            VulxtsClient.modules().spawnerNametags.setEnabled(false);
            NameProtectModule np = VulxtsClient.modules().nameProtect;
            np.selfOnly.set(false);
            np.setEnabled(true);
            if (mc.field_1724 != null) {
               String real = mc.field_1724.method_7334().name();
               String out = np.censorChat(class_2561.method_43470(real + " left the game")).getString();
               assertThat(!out.contains(real) && out.contains("Vulxts"), "NameProtect must censor the player's name in chat, got: " + out);
               mc.field_1705.method_1743().method_1812(class_2561.method_43470("<" + real + "> gg wp"));
               mc.field_1705.method_1743().method_1812(class_2561.method_43470(real + " joined the game"));
            }

         });
         context.waitTicks(6);
         context.takeScreenshot("18c-nameprotect-chat");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().nameProtect.setEnabled(false);
         });
         server.runCommand("item replace entity @a armor.head with minecraft:diamond_helmet");
         server.runCommand("item replace entity @a armor.chest with minecraft:netherite_chestplate");
         server.runCommand("item replace entity @a armor.legs with minecraft:iron_leggings");
         server.runCommand("item replace entity @a armor.feet with minecraft:golden_boots");
         server.runCommand("item replace entity @a weapon.mainhand with minecraft:diamond_sword");
         server.runCommand("item replace entity @a weapon.offhand with minecraft:shield");
         context.waitTicks(6);
         context.runOnClient((mc) -> {
            NameTagsModule nt = VulxtsClient.modules().nameTags;
            nt.setEnabled(true);
            nt.self.set(true);
            nt.armor.set(true);
            nt.heldItem.set(true);
            mc.field_1690.method_31043(class_5498.field_26666);
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(0.0F);
               assertThat(!mc.field_1724.method_6047().method_7960() && !mc.field_1724.method_6118(class_1304.field_6169).method_7960(), "self player must be geared up for the armor/held-item tag");
            }

         });
         context.waitTicks(15);
         context.takeScreenshot("18d-self-tag-armor-held-item");
         context.runOnClient((mc) -> {
            mc.field_1690.method_31043(class_5498.field_26664);
         });
         context.waitTicks(15);
         context.takeScreenshot("18d2-self-tag-hidden-first-person");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().spawnerNametags.setEnabled(true);
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(0.0F);
               mc.field_1724.method_36457(12.0F);
            }

         });
         context.waitTicks(6);
         context.runOnClient((mc) -> {
            mc.method_1507(new class_490(mc.field_1724));
         });
         context.waitForScreen(class_490.class);
         context.waitTicks(5);
         context.takeScreenshot("18e-nametags-hidden-in-inventory");
         context.runOnClient((mc) -> {
            mc.method_1507((class_437)null);
            VulxtsClient.modules().nameTags.setEnabled(false);
            VulxtsClient.modules().spawnerNametags.setEnabled(false);
         });
         context.waitForScreen((Class)null);
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customGlint.setEnabled(false);
         });
         String[] glintGear = new String[]{"netherite_sword", "diamond_chestplate", "diamond_pickaxe", "bow", "golden_apple", "elytra"};
         String[] var20 = glintGear;
         int bx = glintGear.length;

         int by;
         String cs;
         for(by = 0; by < bx; ++by) {
            cs = var20[by];
            server.runCommand("give @a minecraft:" + cs + "[enchantment_glint_override=true] 1");
         }

         context.waitTicks(10);
         context.runOnClient((mc) -> {
            mc.method_1507(new class_490(mc.field_1724));
         });
         context.waitForScreen(class_490.class);
         context.waitTicks(5);
         context.takeScreenshot("19a-glint-vanilla-off");
         context.runOnClient((mc) -> {
            CustomGlintModule cg = VulxtsClient.modules().customGlint;
            cg.mode.set("Solid");
            cg.color.set(-49508);
            cg.strength.set(100.0);
            cg.setEnabled(true);
         });
         context.waitTicks(3);
         context.runOnClient((mc) -> {
            CustomGlintModule cg = VulxtsClient.modules().customGlint;
            assertThat(cg.isActive(), "CustomGlint must report active once enabled");
            assertThat(cg.glintColor() == -49508, "solid pink @100% must compute to PINK, got " + Integer.toHexString(cg.glintColor()));
         });
         context.takeScreenshot("19b-glint-solid-pink");
         context.runOnClient((mc) -> {
            CustomGlintModule cg = VulxtsClient.modules().customGlint;
            cg.strength.set(0.0);
            assertThat(cg.glintColor() == Colors.rgb(0, 0, 0), "0% strength must zero the glint RGB, got " + Integer.toHexString(cg.glintColor()));
            cg.strength.set(100.0);
         });
         context.runOnClient((mc) -> {
            Iterator var1 = VulxtsClient.themes().getThemes().iterator();

            while(var1.hasNext()) {
               Theme t = (Theme)var1.next();
               if (t.getName().equals("Blue")) {
                  VulxtsClient.themes().select(t);
               }
            }

            VulxtsClient.modules().customGlint.mode.set("Theme");
         });
         context.waitTicks(3);
         context.runOnClient((mc) -> {
            int accent = VulxtsClient.themes().current().accent();
            assertThat(VulxtsClient.modules().customGlint.glintColor() == accent, "theme mode @100% must equal the live accent, got " + Integer.toHexString(VulxtsClient.modules().customGlint.glintColor()));
         });
         context.takeScreenshot("19c-glint-theme-blue");
         context.runOnClient((mc) -> {
            Iterator var1 = VulxtsClient.themes().getThemes().iterator();

            while(var1.hasNext()) {
               Theme t = (Theme)var1.next();
               if (t.getName().equals("Pink")) {
                  VulxtsClient.themes().select(t);
               }
            }

         });
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customGlint.mode.set("Rainbow");
         });
         context.waitTicks(3);
         context.takeScreenshot("19d-glint-rainbow");
         context.runOnClient((mc) -> {
            mc.method_1507((class_437)null);
         });
         context.waitForScreen((Class)null);
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customGlint.mode.set("Solid");
            ClickGuiScreen.state().setExpanded("CustomGlint@MISC", true);
         });
         context.getInput().pressKey(344);
         context.waitForScreen(ClickGuiScreen.class);
         context.waitTicks(8);
         context.takeScreenshot("19e-glint-settings");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customGlint.setEnabled(false);
            ClickGuiScreen.state().setExpanded("CustomGlint@MISC", false);
         });
         context.getInput().pressKey(344);
         context.waitForScreen((Class)null);
         server.runCommand("tp @a 500 -60 500 -90 0");
         world.getClientWorld().waitForChunksRender();
         context.runOnClient((mc) -> {
            VulxtsClient.modules().susChunkFinder.setEnabled(false);
            VulxtsClient.modules().blockOutline.setEnabled(false);
            VulxtsClient.modules().motionBlur.setEnabled(false);
            mc.field_1690.method_31043(class_5498.field_26665);
            if (mc.field_1724 != null) {
               mc.field_1724.method_36456(-90.0F);
               mc.field_1724.method_5636(-90.0F);
               mc.field_1724.method_36457(0.0F);
            }

            CustomAccessoriesModule acc = VulxtsClient.modules().customAccessories;
            acc.color.set(-49508);
            acc.rainbow.set(false);
            acc.glow.set(75.0);
            acc.cape.set(true);
            acc.capePhysics.set(true);
            acc.trail.set(false);
            acc.aura.set(false);
            acc.crown.set(false);
            acc.setEnabled(true);
         });
         context.waitTicks(20);
         var20 = new String[]{"Vulxts", "Wave", "Grid", "Solid"};
         bx = var20.length;

         for(by = 0; by < bx; ++by) {
            cs = var20[by];
            context.runOnClient((mc) -> {
               VulxtsClient.modules().customAccessories.capeStyle.set(cs);
            });
            context.waitTicks(6);
            context.takeScreenshot("20-cape-" + cs.toLowerCase());
         }

         context.runOnClient((mc) -> {
            CustomAccessoriesModule acc = VulxtsClient.modules().customAccessories;
            acc.cape.set(false);
            acc.trail.set(true);
            acc.trailLength.set(2.0);
            acc.trailStyle.set("Ribbon");
         });
         walkEast(context, 500.0);
         context.runOnClient((mc) -> {
            assertThat(!VulxtsClient.modules().customAccessories.trailNodes().isEmpty(), "CustomAccessories must record trail nodes while moving");
         });
         context.takeScreenshot("20-trail-ribbon");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customAccessories.trailStyle.set("Sparkle");
         });
         walkEast(context, 510.0);
         context.takeScreenshot("20-trail-sparkle");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customAccessories.trailStyle.set("Echo");
         });
         walkEast(context, 520.0);
         context.takeScreenshot("20-trail-echo");
         context.runOnClient((mc) -> {
            CustomAccessoriesModule acc = VulxtsClient.modules().customAccessories;
            acc.trail.set(false);
            acc.aura.set(true);
            acc.auraStyle.set("Orbit");
         });
         context.waitTicks(10);
         context.takeScreenshot("20-aura-orbit");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customAccessories.auraStyle.set("Ring");
         });
         context.waitTicks(10);
         context.takeScreenshot("20-aura-ring");
         context.runOnClient((mc) -> {
            CustomAccessoriesModule acc = VulxtsClient.modules().customAccessories;
            acc.aura.set(false);
            acc.crown.set(true);
         });
         context.waitTicks(12);
         context.takeScreenshot("20-crown");
         context.runOnClient((mc) -> {
            CustomAccessoriesModule acc = VulxtsClient.modules().customAccessories;
            acc.cape.set(true);
            acc.capeStyle.set("Vulxts");
            acc.trail.set(true);
            acc.trailStyle.set("Ribbon");
            acc.aura.set(true);
            acc.auraStyle.set("Orbit");
            acc.crown.set(true);
         });
         walkEast(context, 500.0);
         context.takeScreenshot("20-all-combined");
         context.runOnClient((mc) -> {
            mc.field_1690.method_31043(class_5498.field_26664);
            ClickGuiScreen.state().setExpanded("CustomAccessories@VISUALS", true);
         });
         context.getInput().pressKey(344);
         context.waitForScreen(ClickGuiScreen.class);
         context.waitTicks(8);
         context.takeScreenshot("20-accessories-settings");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().customAccessories.setEnabled(false);
            ClickGuiScreen.state().setExpanded("CustomAccessories@VISUALS", false);
         });
         context.getInput().pressKey(344);
         context.waitForScreen((Class)null);
         int[] savedRenderDistance = new int[]{12};
         context.runOnClient((mc) -> {
            VulxtsClient.modules().susChunkFinder.setEnabled(false);
            VulxtsClient.modules().blockOutline.setEnabled(false);
            VulxtsClient.modules().motionBlur.setEnabled(false);
            mc.field_1690.method_31043(class_5498.field_26664);
            savedRenderDistance[0] = (Integer)mc.field_1690.method_42503().method_41753();
            mc.field_1690.method_42503().method_41748(8);
         });
         server.runCommand("tp @a 34 -59 40 0 0");
         world.getClientWorld().waitForChunksRender();
         context.waitTicks(10);
         context.runOnClient((mc) -> {
            class_2680 bs = mc.field_1687.method_8320(new class_2338(40, 0, 40));
            class_2680 bs2 = mc.field_1687.method_8320(new class_2338(40, 0, 72));
            boolean loaded = mc.field_1687.method_2935().method_12126(2, 2, false) != null;
            boolean loaded2 = mc.field_1687.method_2935().method_12126(2, 4, false) != null;
            boolean var10000 = bs.method_27852(class_2246.field_20422);
            String var10001 = String.valueOf(bs);
            assertThat(var10000, "test setup: client must see the beehive at (40,0,40); saw " + var10001 + " (chunk loaded=" + loaded + ")");
            var10000 = bs2.method_27852(class_2246.field_20422);
            var10001 = String.valueOf(bs2);
            assertThat(var10000, "test setup: client must see the second beehive at (40,0,72); saw " + var10001 + " (chunk loaded=" + loaded2 + ")");
         });
         context.runOnClient((mc) -> {
            ChunkFinderModule cf = VulxtsClient.modules().chunkFinder;
            cf.mergeRadius.set(1.0);
            cf.clear();
            cf.setEnabled(true);
         });
         context.waitTicks(260);
         context.runOnClient((mc) -> {
            ChunkFinderModule cf = VulxtsClient.modules().chunkFinder;
            long fullA = class_1923.method_8331(2, 2);
            long fullB = class_1923.method_8331(2, 4);
            long empty = class_1923.method_8331(4, 2);
            boolean var10000 = cf.flaggedChunks().contains(fullA) && cf.flaggedChunks().contains(fullB);
            String var10001 = String.valueOf(cf.flaggedChunks());
            assertThat(var10000, "radius 1 must leave BOTH full-honey beehive chunks flagged (unmerged); flags=" + var10001);
            assertThat(!cf.flaggedChunks().contains(empty), "an empty (honey 0) beehive must NOT flag");
         });
         server.runCommand("tp @a 40 78 26 0 42");
         context.waitTicks(20);
         context.takeScreenshot("21-chunkfinder-fullhoney");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().chunkFinder.mergeRadius.set(4.0);
         });
         context.waitTicks(10);
         context.runOnClient((mc) -> {
            ChunkFinderModule cf = VulxtsClient.modules().chunkFinder;
            long middle = class_1923.method_8331(2, 3);
            long fullA = class_1923.method_8331(2, 2);
            long fullB = class_1923.method_8331(2, 4);
            assertThat(cf.flaggedChunks().contains(middle), "Smart must flag the middle chunk (2,3) between the two hives; flags=" + String.valueOf(cf.flaggedChunks()));
            assertThat(!cf.flaggedChunks().contains(fullA) && !cf.flaggedChunks().contains(fullB), "Smart must merge the hive chunks away, leaving only the middle; flags=" + String.valueOf(cf.flaggedChunks()));
         });
         server.runCommand("tp @a 40 78 26 0 42");
         context.waitTicks(20);
         context.takeScreenshot("21b-chunkfinder-smart");
         context.runOnClient((mc) -> {
            FreecamModule fc = VulxtsClient.modules().freecam;
            fc.showPlayerModel.set(false);
            fc.smoothing.set(false);
            fc.setEnabled(true);
         });
         context.waitTicks(30);
         context.runOnClient((mc) -> {
            assertThat(VulxtsClient.modules().freecam.isActive(), "Freecam must be active for the regression shot");
            assertThat(!VulxtsClient.modules().chunkFinder.flaggedChunks().isEmpty(), "chunk finder must still hold its flag under freecam; flags=" + String.valueOf(VulxtsClient.modules().chunkFinder.flaggedChunks()));
         });
         context.takeScreenshot("21c-chunkfinder-freecam");
         context.runOnClient((mc) -> {
            VulxtsClient.modules().freecam.setEnabled(false);
         });
         context.waitTicks(5);
         context.runOnClient((mc) -> {
            VulxtsClient.modules().chunkFinder.setEnabled(false);
            mc.field_1690.method_42503().method_41748(savedRenderDistance[0]);
         });
         context.runOnClient((mc) -> {
            VulxtsClient.modules().blockOutline.setEnabled(false);
            mc.field_1690.method_31043(class_5498.field_26664);
         });
         server.runCommand("tp @a 2 -58 0 0 0");
         context.waitTicks(20);
         bx = 1;

         while(true) {
            if (bx > 3) {
               server.runCommand("setblock 6 -58 6 minecraft:emerald_ore");
               context.waitTicks(5);
               context.runOnClient((mc) -> {
                  assertThat(mc.field_1687.method_8320(new class_2338(2, -58, 6)).method_27852(class_2246.field_10442), "test setup: client must see the placed diamond ore");
               });
               context.runOnClient((mc) -> {
                  VulxtsClient.modules().blockEsp.setEnabled(true);
               });
               context.waitTicks(20);
               context.runOnClient((mc) -> {
                  assertThat(BlockEspRenderer.cachedCount() > 0, "BlockESP must detect the enabled diamond ore (emerald is off); cached=" + BlockEspRenderer.cachedCount());
               });
               server.runCommand("tp @a 2 -55 -4 0 22");
               context.waitTicks(20);
               context.takeScreenshot("30-blockesp-boxes");
               context.runOnClient((mc) -> {
                  ClickGuiScreen.state().setExpanded("BlockESP@RENDER", true);
               });
               context.getInput().pressKey(344);
               context.waitForScreen(ClickGuiScreen.class);
               context.waitTicks(8);
               context.takeScreenshot("31-blockesp-settings");
               context.runOnClient((mc) -> {
                  class_437 patt0$temp = mc.field_1755;
                  if (patt0$temp instanceof ClickGuiScreen cg) {
                     cg.openBlockPicker(VulxtsClient.modules().blockEsp.targets);
                  }

               });
               context.waitForScreen(IconPickerScreen.class);
               context.waitTicks(8);
               context.takeScreenshot("32-blockpicker-grid");
               context.runOnClient((mc) -> {
                  class_437 patt0$temp = mc.field_1755;
                  if (patt0$temp instanceof IconPickerScreen picker) {
                     picker.debugSetSearch("ore");
                  }

               });
               context.waitTicks(8);
               context.takeScreenshot("33-blockpicker-search");
               context.runOnClient((mc) -> {
                  class_437 patt0$temp = mc.field_1755;
                  if (patt0$temp instanceof IconPickerScreen picker) {
                     picker.debugOpenColor(0);
                  }

               });
               context.waitTicks(8);
               context.takeScreenshot("34-blockpicker-color");
               context.runOnClient((mc) -> {
                  mc.method_1507((class_437)null);
                  VulxtsClient.modules().blockEsp.setEnabled(false);
                  ClickGuiScreen.state().setExpanded("BlockESP@RENDER", false);
               });
               context.waitForScreen((Class)null);
               break;
            }

            for(by = -59; by <= -57; ++by) {
               server.runCommand("setblock " + bx + " " + by + " 6 minecraft:diamond_ore");
            }

            ++bx;
         }
      } catch (Throwable var13) {
         if (world != null) {
            try {
               world.close();
            } catch (Throwable var12) {
               var13.addSuppressed(var12);
            }
         }

         throw var13;
      }

      if (world != null) {
         world.close();
      }

   }

   private static void walkEast(ClientGameTestContext context, double startX) {
      for(int i = 0; i < 10; ++i) {
         double x = startX + (double)i * 0.45;
         context.runOnClient((mc) -> {
            if (mc.field_1724 != null) {
               mc.field_1724.method_5814(x, -60.0, 500.0);
            }

         });
         context.waitTicks(1);
      }

      context.waitTicks(4);
   }

   private static void assertThat(boolean condition, String message) {
      if (!condition) {
         throw new AssertionError(message);
      }
   }
}
