package dev.vulxts.hud.components;

import dev.vulxts.hud.HudComponent;
import dev.vulxts.render.nanovg.NVGImages;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class PotionsHud extends HudComponent {
   private static final float ROW = 24.0F;
   private static final float ICON = 18.0F;
   private static final float PAD = 7.0F;
   private static final float FONT = 12.5F;
   private final ThemeManager themes;

   public PotionsHud(ThemeManager var1, BooleanSupplier var2) {
      super(Deobf.decrypt("\u0006\u0005&Lg\u0086\u0096"), 0.995F, 0.6F, var2);
      this.themes = var1;
   }

   private List effects() {
      class_746 var1 = class_310.method_1551().field_1724;
      if (var1 == null) {
         return List.of();
      } else {
         ArrayList var2 = new ArrayList(var1.method_6026());
         var2.sort(Comparator.comparingInt(class_1293::method_5584).reversed());
         return var2;
      }
   }

   private static String label(class_1293 var0) {
      String var1 = ((class_1291)var0.method_5579().comp_349()).method_5560().getString();
      int var2 = var0.method_5578();
      return var2 > 0 ? var1 + " " + (var2 + 1) : var1;
   }

   private static String timer(class_1293 var0) {
      if (var0.method_48559()) {
         return Deobf.decrypt("≨");
      } else {
         int var1 = var0.method_5584() / 20;
         return String.format(Deobf.decrypt("S\u000eh\u00008Ú\u0081"), var1 / 60, var1 % 60);
      }
   }

   public float measureWidth(NVGRenderer var1) {
      float var2 = 110.0F;

      class_1293 var4;
      for(Iterator var3 = this.effects().iterator(); var3.hasNext(); var2 = Math.max(var2, 31.0F + var1.textWidth(label(var4), 12.5F) + 10.0F + var1.textWidth(timer(var4), 12.5F) + 7.0F)) {
         var4 = (class_1293)var3.next();
      }

      return var2;
   }

   public float measureHeight(NVGRenderer var1) {
      return Math.max(24.0F, (float)this.effects().size() * 24.0F);
   }

   public void render(NVGRenderer var1, float var2, float var3, float var4, float var5) {
      Theme var6 = this.themes.current();
      List var7 = this.effects();
      if (!var7.isEmpty()) {
         boolean var8 = this.rightAnchored();
         float var9 = var3;

         for(Iterator var10 = var7.iterator(); var10.hasNext(); var9 += 24.0F) {
            class_1293 var11 = (class_1293)var10.next();
            float var13 = var1.textWidth(label(var11), 12.5F);
            float var14 = var1.textWidth(timer(var11), 12.5F);
            float var15 = 31.0F + var13 + 10.0F + var14 + 7.0F;
            float var16 = var8 ? var2 + var4 - var15 : var2;
            float var17 = var9 + 12.0F;
            var1.rect(var16, var9 + 1.0F, var15, 22.0F, 3.0F, Colors.withAlpha(-15462118, 0.84F));
            var1.rect(var16 + 2.0F, var9 + 6.0F, 2.0F, 12.0F, 1.0F, Colors.withAlpha(var6.accent(), 0.72F));
            class_2960 var18 = (class_2960)var11.method_5579().method_40230().map((var0) -> {
               return var0.method_29177();
            }).orElse((Object)null);
            int var12;
            if (var18 != null && (var12 = NVGImages.fromResource(class_2960.method_60655(var18.method_12836(), "textures/mob_effect/" + var18.method_12832() + ".png"))) > 0) {
               var1.imagePattern(var12, var16 + 7.0F, var17 - 9.0F, 18.0F, 18.0F, var16 + 7.0F, var17 - 9.0F, 18.0F, 18.0F, 1.0F);
            }

            var1.text(label(var11), var16 + 7.0F + 18.0F + 6.0F, var17, 12.5F, var6.textPrimary());
            var1.textGradient(timer(var11), var16 + var15 - 7.0F - var14, var17, 12.5F, var6.accentBright(), var6.accent());
         }
      }

   }
}
