package dev.vulxts.module;

import dev.vulxts.license.LicenseGuard;
import dev.vulxts.module.impl.AimAssistModule;
import dev.vulxts.module.impl.AnchorMacroModule;
import dev.vulxts.module.impl.ArmorTrimHiderModule;
import dev.vulxts.module.impl.AutoClickerModule;
import dev.vulxts.module.impl.AutoCrystalModule;
import dev.vulxts.module.impl.AutoInventoryTotemModule;
import dev.vulxts.module.impl.AutoTotemModule;
import dev.vulxts.module.impl.AutoTpaModule;
import dev.vulxts.module.impl.AutoWalkModule;
import dev.vulxts.module.impl.BlockEspModule;
import dev.vulxts.module.impl.ChatMacroModule;
import dev.vulxts.module.impl.ChunkFinderModule;
import dev.vulxts.module.impl.ClusterEspModule;
import dev.vulxts.module.impl.CoordSnapperModule;
import dev.vulxts.module.impl.CustomAccessoriesModule;
import dev.vulxts.module.impl.CustomCrosshairModule;
import dev.vulxts.module.impl.CustomFovModule;
import dev.vulxts.module.impl.CustomGlintModule;
import dev.vulxts.module.impl.DebugHoleEspModule;
import dev.vulxts.module.impl.DoubleAnchorModule;
import dev.vulxts.module.impl.ElytraSwapModule;
import dev.vulxts.module.impl.FakeMediaModule;
import dev.vulxts.module.impl.FakePayModule;
import dev.vulxts.module.impl.FakeRolesModule;
import dev.vulxts.module.impl.FakeStatsModule;
import dev.vulxts.module.impl.FastUseModule;
import dev.vulxts.module.impl.FreeLookModule;
import dev.vulxts.module.impl.FreecamModule;
import dev.vulxts.module.impl.FullbrightModule;
import dev.vulxts.module.impl.HitBoxModule;
import dev.vulxts.module.impl.HitParticlesModule;
import dev.vulxts.module.impl.HomeMethodModule;
import dev.vulxts.module.impl.HoverTotemModule;
import dev.vulxts.module.impl.JumpCirclesModule;
import dev.vulxts.module.impl.MaceBomberModule;
import dev.vulxts.module.impl.MaceSwapModule;
import dev.vulxts.module.impl.MobEspModule;
import dev.vulxts.module.impl.MotionBlurModule;
import dev.vulxts.module.impl.NameProtectModule;
import dev.vulxts.module.impl.NameTagsModule;
import dev.vulxts.module.impl.NetheriteFinderModule;
import dev.vulxts.module.impl.PanoramaModule;
import dev.vulxts.module.impl.PlayerEspModule;
import dev.vulxts.module.impl.RegionMapModule;
import dev.vulxts.module.impl.ShieldBreakerModule;
import dev.vulxts.module.impl.SkinProtectModule;
import dev.vulxts.module.impl.SpawnerNametagsModule;
import dev.vulxts.module.impl.SpawnerProtectModule;
import dev.vulxts.module.impl.SpeedMineModule;
import dev.vulxts.module.impl.SpotifyHudModule;
import dev.vulxts.module.impl.StaffListModule;
import dev.vulxts.module.impl.StorageEspModule;
import dev.vulxts.module.impl.SwingSpeedModule;
import dev.vulxts.module.impl.TriggerbotModule;
import dev.vulxts.module.impl.WeatherNotifierModule;
import dev.vulxts.module.impl.ZoomModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ModuleManager {
   private final List modules = new ArrayList();
   private final Map byCategory = new LinkedHashMap();
   public final Modules.ClickGuiModule clickGui;
   public final Modules.HudModule hud;
   public final Modules.SpotifyModule spotify;
   public final Modules.BlockOutlineModule blockOutline;
   public final Modules.SusChunkFinderModule susChunkFinder;
   public FullbrightModule fullbright;
   public AutoWalkModule autoWalk;
   public WeatherNotifierModule weatherNotifier;
   public SwingSpeedModule swingSpeed;
   public StorageEspModule storageEsp;
   public BlockEspModule blockEsp;
   public ClusterEspModule clusterEsp;
   public AutoTotemModule autoTotem;
   public MaceSwapModule maceSwap;
   public AnchorMacroModule anchorMacro;
   public AutoCrystalModule autoCrystal;
   public HitBoxModule hitBox;
   public ElytraSwapModule elytraSwap;
   public HoverTotemModule hoverTotem;
   public ShieldBreakerModule shieldBreaker;
   public TriggerbotModule triggerbot;
   public AimAssistModule aimAssist;
   public DoubleAnchorModule doubleAnchor;
   public MaceBomberModule maceBomber;
   public NameProtectModule nameProtect;
   public SkinProtectModule skinProtect;
   public NameTagsModule nameTags;
   public FastUseModule fastUse;
   public AutoInventoryTotemModule autoInventoryTotem;
   public PlayerEspModule playerEsp;
   public MobEspModule mobEsp;
   public NetheriteFinderModule netheriteFinder;
   public SpawnerNametagsModule spawnerNametags;
   public DebugHoleEspModule debugHoleEsp;
   public FreecamModule freecam;
   public AutoTpaModule autoTpa;
   public JumpCirclesModule jumpCircles;
   public CustomCrosshairModule customCrosshair;
   public ZoomModule zoom;
   public CustomFovModule customFov;
   public HitParticlesModule hitParticles;
   public MotionBlurModule motionBlur;
   public CustomGlintModule customGlint;
   public CustomAccessoriesModule customAccessories;
   public ChunkFinderModule chunkFinder;
   public FreeLookModule freeLook;
   public AutoClickerModule autoClicker;
   public CoordSnapperModule coordSnapper;
   public RegionMapModule regionMap;
   public ChatMacroModule chatMacro;
   public FakePayModule fakePay;
   public FakeMediaModule fakeMedia;
   public FakeStatsModule fakeStats;
   public FakeRolesModule fakeRoles;
   public StaffListModule staffList;
   public ArmorTrimHiderModule armorTrimHider;
   public SpawnerProtectModule spawnerProtect;
   public SpeedMineModule speedMine;
   public HomeMethodModule homeMethod;
   public PanoramaModule panorama;
   private Runnable openGuiAction = () -> {
   };
   private BiConsumer toggleListener = (var0, var1x) -> {
   };

   public ModuleManager() {
      Category[] var1 = Category.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Category var4 = var1[var3];
         this.byCategory.put(var4, new ArrayList());
      }

      this.susChunkFinder = new Modules.SusChunkFinderModule();
      this.registerPlaceholders();
      this.blockOutline = new Modules.BlockOutlineModule();
      this.register(this.blockOutline);
      this.hud = new Modules.HudModule();
      this.register(this.hud);
      this.spotify = new SpotifyHudModule();
      this.register(this.spotify);
      this.chatMacro = new ChatMacroModule();
      this.register(this.chatMacro);
      this.swingSpeed = new SwingSpeedModule();
      this.register(this.swingSpeed);
      this.jumpCircles = new JumpCirclesModule();
      this.register(this.jumpCircles);
      this.clickGui = new Modules.ClickGuiModule();
      this.register(this.clickGui);
   }

   private void registerPlaceholders() {
      this.autoTotem = new AutoTotemModule();
      this.register(this.autoTotem);
      this.autoCrystal = new AutoCrystalModule();
      this.register(this.autoCrystal);
      this.anchorMacro = new AnchorMacroModule();
      this.register(this.anchorMacro);
      this.doubleAnchor = new DoubleAnchorModule();
      this.register(this.doubleAnchor);
      this.autoInventoryTotem = new AutoInventoryTotemModule();
      this.register(this.autoInventoryTotem);
      this.maceSwap = new MaceSwapModule();
      this.register(this.maceSwap);
      this.hitBox = new HitBoxModule();
      this.register(this.hitBox);
      this.elytraSwap = new ElytraSwapModule();
      this.register(this.elytraSwap);
      this.hoverTotem = new HoverTotemModule();
      this.register(this.hoverTotem);
      this.shieldBreaker = new ShieldBreakerModule();
      this.register(this.shieldBreaker);
      this.triggerbot = new TriggerbotModule();
      this.register(this.triggerbot);
      this.maceBomber = new MaceBomberModule();
      this.register(this.maceBomber);
      this.skinProtect = new SkinProtectModule();
      this.register(this.skinProtect);
      this.nameProtect = new NameProtectModule();
      this.register(this.nameProtect);
      this.freecam = new FreecamModule();
      this.register(this.freecam);
      this.autoTpa = new AutoTpaModule();
      this.register(this.autoTpa);
      this.autoClicker = new AutoClickerModule();
      this.register(this.autoClicker);
      this.fastUse = new FastUseModule();
      this.register(this.fastUse);
      this.nameTags = new NameTagsModule();
      this.register(this.nameTags);
      this.weatherNotifier = new WeatherNotifierModule();
      this.register(this.weatherNotifier);
      this.armorTrimHider = new ArmorTrimHiderModule();
      this.register(this.armorTrimHider);
      this.customCrosshair = new CustomCrosshairModule();
      this.register(this.customCrosshair);
      this.staffList = new StaffListModule();
      this.register(this.staffList);
      this.customGlint = new CustomGlintModule();
      this.register(this.customGlint);
      this.customFov = new CustomFovModule();
      this.register(this.customFov);
      this.coordSnapper = new CoordSnapperModule();
      this.register(this.coordSnapper);
      this.autoWalk = new AutoWalkModule();
      this.register(this.autoWalk);
      this.zoom = new ZoomModule();
      this.register(this.zoom);
      this.freeLook = new FreeLookModule();
      this.register(this.freeLook);
      this.spawnerProtect = new SpawnerProtectModule();
      this.register(this.spawnerProtect);
      this.speedMine = new SpeedMineModule();
      this.register(this.speedMine);
      this.homeMethod = new HomeMethodModule();
      this.register(this.homeMethod);
      this.panorama = new PanoramaModule();
      this.register(this.panorama);
      this.fakePay = new FakePayModule();
      this.register(this.fakePay);
      this.fakeMedia = new FakeMediaModule();
      this.register(this.fakeMedia);
      this.blockEsp = new BlockEspModule();
      this.register(this.blockEsp);
      this.clusterEsp = new ClusterEspModule();
      this.register(this.clusterEsp);
      this.storageEsp = new StorageEspModule();
      this.register(this.storageEsp);
      this.fullbright = new FullbrightModule();
      this.register(this.fullbright);
      this.playerEsp = new PlayerEspModule();
      this.register(this.playerEsp);
      this.mobEsp = new MobEspModule();
      this.register(this.mobEsp);
      this.netheriteFinder = new NetheriteFinderModule();
      this.register(this.netheriteFinder);
      this.spawnerNametags = new SpawnerNametagsModule();
      this.register(this.spawnerNametags);
      this.register(this.susChunkFinder);
      this.chunkFinder = new ChunkFinderModule();
      this.register(this.chunkFinder);
      this.regionMap = new RegionMapModule();
      this.register(this.regionMap);
   }

   public void register(Module var1) {
      this.modules.add(var1);
      ((List)this.byCategory.get(var1.getCategory())).add(var1);
      var1.setToggleCallback(this::notifyToggle);
   }

   public List all() {
      return this.modules;
   }

   public List inCategory(Category var1) {
      return (List)this.byCategory.get(var1);
   }

   public void setOpenGuiAction(Runnable var1) {
      this.openGuiAction = var1;
   }

   public void setToggleListener(BiConsumer var1) {
      this.toggleListener = var1;
   }

   public void notifyToggle(Module var1, boolean var2) {
      this.toggleListener.accept(var1, var2);
   }

   public boolean onKeyPressed(int var1) {
      if (this.clickGui.getKeybind().matches(var1)) {
         this.openGuiAction.run();
         return true;
      } else {
         boolean var2 = false;
         Iterator var3 = this.modules.iterator();

         Module var4;
         while(var3.hasNext()) {
            var4 = (Module)var3.next();
            if (var4 != this.clickGui && var4.getKeybind().matches(var1)) {
               var4.toggle();
               var2 = true;
            }
         }

         var3 = this.modules.iterator();

         while(var3.hasNext()) {
            var4 = (Module)var3.next();
            if (var4.isEnabled() && var4.onKeyPress(var1)) {
               var2 = true;
            }
         }

         return var2;
      }
   }

   public void onTick() {
      LicenseGuard.checkpoint();
      Iterator var1 = this.modules.iterator();

      while(var1.hasNext()) {
         Module var2 = (Module)var1.next();
         if (var2.isEnabled() && var2.getCategory() != Category.COMBAT) {
            var2.onTick();
         }
      }

   }

   public void onCombatTick() {
      LicenseGuard.checkpoint();
      Iterator var1 = this.modules.iterator();

      while(var1.hasNext()) {
         Module var2 = (Module)var1.next();
         if (var2.isEnabled() && var2.getCategory() == Category.COMBAT) {
            var2.onTick();
         }
      }

   }
}
