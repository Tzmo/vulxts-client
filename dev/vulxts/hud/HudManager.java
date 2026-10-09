package dev.vulxts.hud;

import com.google.gson.JsonObject;
import dev.vulxts.hud.components.ArmorHud;
import dev.vulxts.hud.components.ArrayListHud;
import dev.vulxts.hud.components.InfoHud;
import dev.vulxts.hud.components.KeystrokesHud;
import dev.vulxts.hud.components.PotionsHud;
import dev.vulxts.hud.components.RadarHud;
import dev.vulxts.hud.components.RegionMapHud;
import dev.vulxts.hud.components.SpotifyHud;
import dev.vulxts.hud.components.StaffListHud;
import dev.vulxts.hud.components.WatermarkHud;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.Modules;
import dev.vulxts.notification.NotificationManager;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.spotify.SpotifyService;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.CpsTracker;
import dev.vulxts.util.TpsTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_310;
import net.minecraft.class_640;
import net.minecraft.class_746;

public class HudManager {
   private final List components = new ArrayList();
   private final ThemeManager themes;

   public HudManager(ModuleManager var1, ThemeManager var2, SpotifyService var3, NotificationManager var4) {
      this.themes = var2;
      Modules.HudModule var5 = var1.hud;
      this.components.add(new WatermarkHud(var2, () -> {
         return var5.isEnabled() && (Boolean)var5.watermark.get();
      }));
      this.components.add(new ArrayListHud(var1, var5, var2, () -> {
         return var5.isEnabled() && (Boolean)var5.arrayList.get();
      }));
      this.components.add(new InfoHud(Deobf.decrypt("\u0010\u001a!"), var2, Deobf.decrypt("0:\u0001"), () -> {
         return Integer.toString(class_310.method_1551().method_47599());
      }, 0.006F, 0.985F, () -> {
         return var5.isEnabled() && (Boolean)var5.fps.get();
      }));
      this.components.add(new InfoHud(Deobf.decrypt("\u0006\u0003<B"), var2, Deobf.decrypt("&\u0003<B"), HudManager::pingString, 0.055F, 0.985F, () -> {
         return var5.isEnabled() && (Boolean)var5.ping.get();
      }));
      this.components.add(new InfoHud(Deobf.decrypt("\u0015\u0005=Wl\u009b"), var2, Deobf.decrypt(".3\b"), HudManager::coordsString, 0.115F, 0.985F, () -> {
         return var5.isEnabled() && (Boolean)var5.coordinates.get();
      }));
      this.components.add(new InfoHud(Deobf.decrypt("\u0012\u0003 @k\u009c\u008cÕú"), var2, Deobf.decrypt("0\u000b1Lf\u008f"), HudManager::directionString, 0.24F, 0.985F, () -> {
         return var5.isEnabled() && (Boolean)var5.direction.get();
      }));
      this.components.add(new InfoHud(Deobf.decrypt("\u0002\u001a!"), var2, Deobf.decrypt("\":\u0001"), () -> {
         return String.format(Deobf.decrypt("SDcC"), TpsTracker.get());
      }, 0.33F, 0.985F, () -> {
         return var5.isEnabled() && (Boolean)var5.tps.get();
      }));
      this.components.add(new InfoHud(Deobf.decrypt("\u0015\u001a!"), var2, Deobf.decrypt("5:\u0001"), () -> {
         int var10000 = CpsTracker.get(0);
         return "" + var10000 + " | " + CpsTracker.get(1);
      }, 0.4F, 0.985F, () -> {
         return var5.isEnabled() && (Boolean)var5.cps.get();
      }));
      this.components.add(new ArmorHud(var2, () -> {
         return var5.isEnabled() && (Boolean)var5.armor.get();
      }));
      this.components.add(new PotionsHud(var2, () -> {
         return var5.isEnabled() && (Boolean)var5.potions.get();
      }));
      this.components.add(new KeystrokesHud(var2, () -> {
         return var5.isEnabled() && (Boolean)var5.keystrokes.get();
      }));
      this.components.add(new RadarHud(var5, var1.susChunkFinder, var2, () -> {
         return var5.isEnabled() && (Boolean)var5.radar.get();
      }));
      this.components.add(new RegionMapHud(var1.regionMap, var2));
      this.components.add(new StaffListHud(var1.staffList, var2));
      this.components.add(new SpotifyHud(var1.spotify, var3, var2));
      this.components.add(var4);
   }

   private static String coordsString() {
      class_746 var0 = class_310.method_1551().field_1724;
      if (var0 == null) {
         return Deobf.decrypt("FFr\u0015$ÈÕ");
      } else {
         class_2338 var1 = var0.method_24515();
         int var10000 = var1.method_10263();
         return "" + var10000 + ", " + var1.method_10264() + ", " + var1.method_10260();
      }
   }

   private static String pingString() {
      class_310 var0 = class_310.method_1551();
      if (var0.field_1724 != null && var0.method_1562() != null) {
         class_640 var1 = var0.method_1562().method_2871(var0.field_1724.method_5667());
         return var1 == null ? Deobf.decrypt("F\u0007!") : var1.method_2959() + "ms";
      } else {
         return Deobf.decrypt("F\u0007!");
      }
   }

   private static String directionString() {
      class_746 var0 = class_310.method_1551().field_1724;
      if (var0 == null) {
         return Deobf.decrypt("8");
      } else {
         class_2350 var1 = var0.method_5735();
         String var10000;
         switch (var1) {
            case field_11043:
               var10000 = Deobf.decrypt("8Jr\bR");
               break;
            case field_11035:
               var10000 = Deobf.decrypt("%Jr\u000eR");
               break;
            case field_11039:
               var10000 = Deobf.decrypt("!Jr\bP");
               break;
            case field_11034:
               var10000 = Deobf.decrypt("3Jr\u000eP");
               break;
            default:
               var10000 = var1.method_10151().toUpperCase();
         }

         return var10000;
      }
   }

   public List getComponents() {
      return this.components;
   }

   public List layout(NVGRenderer var1, float var2, float var3, boolean var4) {
      ArrayList var5 = new ArrayList();
      Iterator var6 = this.components.iterator();

      while(true) {
         HudComponent var7;
         do {
            if (!var6.hasNext()) {
               return var5;
            }

            var7 = (HudComponent)var6.next();
         } while(!var4 && !var7.visible());

         float var8 = var7.getScale();
         float var9 = var7.measureWidth(var1) * var8;
         float var10 = var7.measureHeight(var1) * var8;
         float var11 = var7.getFx() * (var2 - var9);
         float var12 = var7.getFy() * (var3 - var10);
         var5.add(new Placement(var7, var11, var12, var9, var10));
      }
   }

   public void render(NVGRenderer var1, float var2, float var3) {
      Iterator var4 = this.layout(var1, var2, var3, false).iterator();

      while(var4.hasNext()) {
         Placement var5 = (Placement)var4.next();
         this.renderPlacement(var1, var5);
      }

   }

   public void renderPlacement(NVGRenderer var1, Placement var2) {
      float var3 = var2.component().getScale();
      Theme var4 = this.themes.current();
      var1.save();
      var1.translate((float)Math.round(var2.x()), (float)Math.round(var2.y()));
      var1.scale(var3);
      HudChrome.underlay(var1, var4, 0.0F, 0.0F, var2.w() / var3, var2.h() / var3);
      var2.component().render(var1, 0.0F, 0.0F, var2.w() / var3, var2.h() / var3);
      HudChrome.overlay(var1, var4, 0.0F, 0.0F, var2.w() / var3, var2.h() / var3);
      var1.restore();
   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      Iterator var2 = this.components.iterator();

      while(var2.hasNext()) {
         HudComponent var3 = (HudComponent)var2.next();
         JsonObject var4 = new JsonObject();
         var4.addProperty(Deobf.decrypt("\u0010\u0012"), var3.getFx());
         var4.addProperty(Deobf.decrypt("\u0010\u0013"), var3.getFy());
         var4.addProperty(Deobf.decrypt("\u0005\t3Im"), var3.getScale());
         var1.add(var3.getId(), var4);
      }

      return var1;
   }

   public void fromJson(JsonObject var1) {
      Iterator var2 = this.components.iterator();

      while(var2.hasNext()) {
         HudComponent var3 = (HudComponent)var2.next();
         JsonObject var4 = var1.getAsJsonObject(var3.getId());
         if (var4 != null && var4.has(Deobf.decrypt("\u0010\u0012")) && var4.has(Deobf.decrypt("\u0010\u0013"))) {
            var3.setPosition(var4.get(Deobf.decrypt("\u0010\u0012")).getAsFloat(), var4.get(Deobf.decrypt("\u0010\u0013")).getAsFloat());
            if (var4.has(Deobf.decrypt("\u0005\t3Im"))) {
               var3.setScale(var4.get(Deobf.decrypt("\u0005\t3Im")).getAsFloat());
            }
         }
      }

   }

   public static record Placement(HudComponent component, float x, float y, float w, float h) {
      public Placement(HudComponent component, float x, float y, float w, float h) {
         this.component = component;
         this.x = x;
         this.y = y;
         this.w = w;
         this.h = h;
      }

      public boolean contains(float var1, float var2) {
         return var1 >= this.x && var1 <= this.x + this.w && var2 >= this.y && var2 <= this.y + this.h;
      }

      public HudComponent component() {
         return this.component;
      }

      public float x() {
         return this.x;
      }

      public float y() {
         return this.y;
      }

      public float w() {
         return this.w;
      }

      public float h() {
         return this.h;
      }
   }
}
