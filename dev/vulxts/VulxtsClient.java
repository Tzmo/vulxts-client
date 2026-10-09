package dev.vulxts;

import dev.vulxts.config.ConfigManager;
import dev.vulxts.config.ConfigStore;
import dev.vulxts.gui.ClickGuiScreen;
import dev.vulxts.gui.ClickGuiState;
import dev.vulxts.hud.HudManager;
import dev.vulxts.license.LicenseGuard;
import dev.vulxts.module.Category;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.impl.FreecamModule;
import dev.vulxts.notification.NotificationManager;
import dev.vulxts.render.BlockEspRenderer;
import dev.vulxts.render.ClusterEspRenderer;
import dev.vulxts.render.MotionBlurRenderer;
import dev.vulxts.render.OverlayRenderer;
import dev.vulxts.render.StorageEspRenderer;
import dev.vulxts.render.SusChunkRenderer;
import dev.vulxts.spotify.SpotifyService;
import dev.vulxts.suschunk.ServerLightCache;
import dev.vulxts.theme.SoundSettings;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.UiSoundEvents;
import dev.vulxts.util.UiSounds;
import java.util.Objects;
import java.util.function.Supplier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.class_310;
import net.minecraft.class_442;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VulxtsClient implements ClientModInitializer {
   public static final String MOD_ID = "vulxtsclient";
   public static final String NAME = "Vulxts Client";
   public static final String VERSION = "1.6.2";
   public static final Logger LOGGER = LoggerFactory.getLogger("VulxtsClient");
   private static ModuleManager modules;
   private static ThemeManager themes;
   private static ConfigManager config;
   private static ConfigStore configStore;
   private static HudManager hud;
   private static NotificationManager notifications;
   private static SpotifyService spotify;
   private static SoundSettings soundSettings;
   private static boolean startupSoundPlayed;

   public static ModuleManager modules() {
      return modules;
   }

   public static ThemeManager themes() {
      return themes;
   }

   public static ConfigManager config() {
      return config;
   }

   public static ConfigStore configStore() {
      return configStore;
   }

   public static HudManager hud() {
      return hud;
   }

   public static SpotifyService spotify() {
      return spotify;
   }

   public static SoundSettings sounds() {
      return soundSettings;
   }

   public static NotificationManager notifications() {
      return notifications;
   }

   public void onInitializeClient() {
      LicenseGuard.enforce(LOGGER);
      LOGGER.info("{} {} initializing", "Vulxts Client", "1.6.2");
      UiSoundEvents.bootstrap();
      themes = new ThemeManager();
      soundSettings = new SoundSettings();
      modules = new ModuleManager();
      spotify = new SpotifyService();
      notifications = new NotificationManager(themes, modules.hud);
      hud = new HudManager(modules, themes, spotify, notifications);
      config = new ConfigManager(modules, themes);
      ConfigManager var10000 = config;
      HudManager var10002 = hud;
      Objects.requireNonNull(var10002);
      Supplier var1 = var10002::toJson;
      HudManager var10003 = hud;
      Objects.requireNonNull(var10003);
      var10000.addSection("hud", var1, var10003::fromJson);
      var10000 = config;
      ClickGuiState var2 = ClickGuiScreen.state();
      Objects.requireNonNull(var2);
      var1 = var2::toJson;
      ClickGuiState var3 = ClickGuiScreen.state();
      Objects.requireNonNull(var3);
      var10000.addSection("panels", var1, var3::fromJson);
      var10000 = config;
      SoundSettings var4 = soundSettings;
      Objects.requireNonNull(var4);
      var1 = var4::toJson;
      SoundSettings var5 = soundSettings;
      Objects.requireNonNull(var5);
      var10000.addSection("sounds", var1, var5::fromJson);
      config.load();
      configStore = new ConfigStore(config);
      configStore.loadAll();
      UiSounds.init(soundSettings);
      modules.setOpenGuiAction(() -> {
         class_310.method_1551().method_1507(new ClickGuiScreen());
      });
      modules.setToggleListener((var0, var1x) -> {
         if (!ConfigStore.applying && var0.getCategory() != Category.CLIENT && class_310.method_1551().field_1687 != null && (Boolean)modules.hud.notifications.get()) {
            notifications.push(var0.getName(), var1x);
            UiSounds.notification(var1x);
         }

      });
      OverlayRenderer.init(hud, notifications);
      ScreenEvents.AFTER_INIT.register((var0, var1x, var2x, var3x) -> {
         if (var1x instanceof class_442 && !startupSoundPlayed) {
            startupSoundPlayed = true;
            UiSounds.playStartup();
         }

      });
      spotify.start();
      ClientPlayConnectionEvents.JOIN.register((var0, var1x, var2x) -> {
         clearSusState();
      });
      ClientPlayConnectionEvents.DISCONNECT.register((var0, var1x) -> {
         clearSusState();
      });
      ClientTickEvents.END_CLIENT_TICK.register((var0) -> {
         modules.onTick();
      });
      ClientTickEvents.START_CLIENT_TICK.register((var0) -> {
         FreecamModule var1 = modules.freecam;
         if (var1 != null && var1.isActive()) {
            FreecamModule.reapplyBodyInput(var0);
         }

         modules.onCombatTick();
      });
      ClientLifecycleEvents.CLIENT_STOPPING.register((var0) -> {
         config.save();
         spotify.stop();
      });
   }

   private static void clearSusState() {
      BlockEspRenderer.clear();
      ClusterEspRenderer.clear();
      StorageEspRenderer.clear();
      ServerLightCache.get().clear();
      modules.susChunkFinder.scanner.clear();
      SusChunkRenderer.reset();
      if (modules.chunkFinder != null) {
         modules.chunkFinder.clear();
      }

      if (modules.spawnerNametags != null) {
         modules.spawnerNametags.clear();
      }

      if (modules.jumpCircles != null) {
         modules.jumpCircles.clear();
      }

      if (modules.hitParticles != null) {
         modules.hitParticles.clear();
      }

      if (modules.customAccessories != null) {
         modules.customAccessories.clear();
      }

      MotionBlurRenderer.reset();
   }
}
