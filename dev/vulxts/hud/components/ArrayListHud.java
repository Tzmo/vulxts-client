package dev.vulxts.hud.components;

import dev.vulxts.hud.HudComponent;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.Modules;
import dev.vulxts.render.anim.Animation;
import dev.vulxts.render.anim.Easing;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class ArrayListHud extends HudComponent {
   private static final float ENTRY_HEIGHT = 20.0F;
   private static final float FONT_SIZE = 13.5F;
   private static final float PAD_X = 8.0F;
   private static final float STRIP_W = 2.5F;
   private final ModuleManager modules;
   private final Modules.HudModule hudModule;
   private final ThemeManager themes;
   private final Map slide = new HashMap();

   public ArrayListHud(ModuleManager var1, Modules.HudModule var2, ThemeManager var3, BooleanSupplier var4) {
      super("Active Modules", 1.0F, 0.008F, var4);
      this.modules = var1;
      this.hudModule = var2;
      this.themes = var3;
   }

   private List animatedEntries(NVGRenderer var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.modules.all().iterator();

      while(true) {
         Module var4;
         Animation var5;
         do {
            do {
               if (!var3.hasNext()) {
                  var2.sort(Comparator.comparingDouble((var1x) -> {
                     return (double)var1.textWidth(var1x.getName(), 13.5F);
                  }).reversed());
                  return var2;
               }

               var4 = (Module)var3.next();
            } while(var4.getCategory() == Category.CLIENT);

            var5 = (Animation)this.slide.computeIfAbsent(var4, (var0) -> {
               return new Animation(240.0F, var0.isEnabled() ? 1.0F : 0.0F, Easing.EASE_OUT_CUBIC);
            });
            var5.setTarget(var4.isEnabled() ? 1.0F : 0.0F);
         } while(!var4.isEnabled() && !(var5.value() > 0.01F));

         var2.add(var4);
      }
   }

   public float measureWidth(NVGRenderer var1) {
      float var2 = 40.0F;

      Module var4;
      for(Iterator var3 = this.animatedEntries(var1).iterator(); var3.hasNext(); var2 = Math.max(var2, var1.textWidth(var4.getName(), 13.5F) + 16.0F + 2.5F + 2.0F)) {
         var4 = (Module)var3.next();
      }

      return var2;
   }

   public float measureHeight(NVGRenderer var1) {
      float var2 = 0.0F;

      Module var4;
      for(Iterator var3 = this.animatedEntries(var1).iterator(); var3.hasNext(); var2 += 20.0F * ((Animation)this.slide.get(var4)).value()) {
         var4 = (Module)var3.next();
      }

      return Math.max(20.0F, var2);
   }

   public void render(NVGRenderer var1, float var2, float var3, float var4, float var5) {
      Theme var6 = this.themes.current();
      boolean var7 = (Boolean)this.hudModule.themeSync.get();
      boolean var8 = this.rightAnchored();
      float var9 = var3;
      Iterator var10 = this.animatedEntries(var1).iterator();

      while(var10.hasNext()) {
         Module var11 = (Module)var10.next();
         float var12 = ((Animation)this.slide.get(var11)).value();
         if (!(var12 <= 0.01F)) {
            int var13 = var7 ? var6.accent() : (Integer)this.hudModule.listColor.get();
            int var14 = var7 ? var6.accentBright() : Colors.lighten(var13, 0.35F);
            float var15 = var1.textWidth(var11.getName(), 13.5F);
            float var16 = (1.0F - var12) * (var15 + 12.0F) * (float)(var8 ? 1 : -1);
            float var17 = (float)Math.round((var8 ? var2 + var4 - var15 : var2) + var16);
            float var18 = (float)Math.round(var9);
            var1.save();
            var1.alpha(var12);
            var1.textGradient(var11.getName(), var17, var18 + 10.0F, 13.5F, var14, var13);
            var1.restore();
            var9 += 20.0F * var12;
         }
      }

   }
}
