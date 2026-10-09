package dev.vulxts.hud.components;

import dev.vulxts.hud.HudComponent;
import dev.vulxts.render.nanovg.NVGImages;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import java.util.function.BooleanSupplier;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_746;
import net.minecraft.class_7923;

public class ArmorHud extends HudComponent {
   private static final class_1304[] SLOTS;
   private static final float ICON = 22.0F;
   private static final float PAD = 7.0F;
   private static final float GAP = 6.0F;
   private static final float BAR_H = 3.0F;
   private final ThemeManager themes;

   public ArmorHud(ThemeManager var1, BooleanSupplier var2) {
      super(Deobf.decrypt("\u0017\u0018?Jz"), 0.5F, 0.8F, var2);
      this.themes = var1;
   }

   public float measureWidth(NVGRenderer var1) {
      return 14.0F + (float)SLOTS.length * 22.0F + (float)(SLOTS.length - 1) * 6.0F;
   }

   public float measureHeight(NVGRenderer var1) {
      return 38.0F;
   }

   public void render(NVGRenderer var1, float var2, float var3, float var4, float var5) {
      Theme var6 = this.themes.current();
      class_746 var7 = class_310.method_1551().field_1724;
      if (var7 != null) {
         var1.rectGradient(var2, var3, var4, var5, 3.0F, var6.background(), var6.backgroundTo(), true);
         var1.rect(var2 + 6.0F, var3 + 5.0F, var4 - 12.0F, 1.0F, 0.5F, Colors.withAlpha(var6.accent(), 0.22F));
         float var8 = var2 + 7.0F;
         class_1304[] var9 = SLOTS;
         int var10 = var9.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            class_1304 var12 = var9[var11];
            class_1799 var13 = var7.method_6118(var12);
            float var14 = var3 + 4.0F;
            if (var13.method_7960()) {
               var1.rectOutline(var8, var14, 22.0F, 22.0F, 5.0F, 1.0F, Colors.withAlpha(var6.textDisabled(), 0.5F));
            } else {
               class_2960 var15 = class_7923.field_41178.method_10221(var13.method_7909());
               int var16 = NVGImages.fromResource(class_2960.method_60655(var15.method_12836(), "textures/item/" + var15.method_12832() + ".png"));
               if (var16 > 0) {
                  var1.imagePattern(var16, var8, var14, 22.0F, 22.0F, var8, var14, 22.0F, 22.0F, 1.0F);
               } else {
                  var1.rect(var8, var14, 22.0F, 22.0F, 5.0F, Colors.withAlpha(var6.accent(), 0.3F));
               }

               if (var13.method_7963()) {
                  float var17 = 1.0F - (float)var13.method_7919() / (float)var13.method_7936();
                  int var18 = Colors.lerp(-1684147, -11671924, var17);
                  float var19 = var14 + 22.0F + 3.0F;
                  var1.rect(var8, var19, 22.0F, 3.0F, 1.5F, Colors.withAlpha(-16777216, 0.45F));
                  var1.rect(var8, var19, Math.max(3.0F, 22.0F * var17), 3.0F, 1.5F, var18);
               }
            }

            var8 += 28.0F;
         }
      }

   }

   static {
      SLOTS = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};
   }
}
