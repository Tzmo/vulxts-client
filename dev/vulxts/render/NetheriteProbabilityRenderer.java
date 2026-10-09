package dev.vulxts.render;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.impl.NetheriteFinderModule;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.util.Colors;
import java.util.Iterator;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;

public final class NetheriteProbabilityRenderer {
   private static final int MAX_LABELS = 100;

   private NetheriteProbabilityRenderer() {
   }

   public static void renderBoxes(class_4597.class_4598 var0, class_4587 var1, class_243 var2, NetheriteFinderModule var3) {
      if ((Boolean)var3.debrisHotspot.get()) {
         class_310 var4 = class_310.method_1551();
         long var5 = System.currentTimeMillis() % 2000L;
         double var7 = var5 < 1000L ? (double)var5 / 1000.0 : (double)(2000L - var5) / 1000.0;
         int var9 = (Integer)var3.hotspotColor.get();
         Iterator var10 = var3.hits().iterator();

         while(var10.hasNext()) {
            NetheriteFinderModule.Hit var11 = (NetheriteFinderModule.Hit)var10.next();
            if (!var11.exact() && (Boolean)var3.debrisHotspot.get() && !var11.probabilityRegions().isEmpty()) {
               NetheriteFinderModule.ProbabilityRegion var12 = (NetheriteFinderModule.ProbabilityRegion)var11.probabilityRegions().getFirst();
               if (!isInsideOrNear(var4, var2, var12)) {
                  EspBoxRenderer.fill(var0, var1, var2, var12.x1(), var12.y1(), var12.z1(), var12.x2(), var12.y2(), var12.z2(), Colors.withAlpha(var9, 34 - (int)(10.0 * var7)));
               }

               EspBoxRenderer.outline(var0, var1, var2, var12.x1(), var12.y1(), var12.z1(), var12.x2(), var12.y2(), var12.z2(), Colors.withAlpha(var9, 220), 1.4F);
            }
         }

         EspBoxRenderer.flush(var0);
      }
   }

   public static void renderLabels(NVGRenderer var0) {
      if (WorldProjection.isValid()) {
         ModuleManager var1 = VulxtsClient.modules();
         NetheriteFinderModule var2 = var1 == null ? null : var1.netheriteFinder;
         if (var2 != null && var2.isEnabled() && (Boolean)var2.debrisHotspot.get()) {
            int var3 = (Integer)var2.hotspotColor.get();
            int var4 = 0;
            Iterator var5 = var2.hits().iterator();

            while(var5.hasNext()) {
               NetheriteFinderModule.Hit var6 = (NetheriteFinderModule.Hit)var5.next();
               if (!var6.exact() && !var6.probabilityRegions().isEmpty()) {
                  NetheriteFinderModule.ProbabilityRegion var7 = (NetheriteFinderModule.ProbabilityRegion)var6.probabilityRegions().getFirst();
                  float[] var8 = WorldProjection.project((var7.x1() + var7.x2()) * 0.5, var7.y2() + 0.25, (var7.z1() + var7.z2()) * 0.5);
                  if (var8 != null && var8[0] >= -40.0F && var8[0] <= OverlayRenderer.uiWidth() + 40.0F && var8[1] >= -20.0F && var8[1] <= OverlayRenderer.uiHeight() + 20.0F) {
                     drawLabel(var0, var8[0], var8[1], var7.chance(), var3);
                     ++var4;
                     if (var4 >= 100) {
                        return;
                     }
                  }
               }
            }

         }
      }
   }

   private static void drawLabel(NVGRenderer var0, float var1, float var2, double var3, int var5) {
      String var6 = Math.round(var3 * 100.0) + "%";
      float var7 = 13.0F;
      float var8 = 6.0F;
      float var9 = var0.textWidth(var6, var7) + var8 * 2.0F;
      float var10 = 19.0F;
      float var11 = var1 - var9 * 0.5F;
      float var12 = var2 - var10 * 0.5F;
      var0.glow(var11, var12, var9, var10, 5.0F, 3.0F, Colors.withAlpha(var5, 0.25F));
      var0.rect(var11, var12, var9, var10, 5.0F, Colors.withAlpha(-16777216, 0.68F));
      var0.rectOutline(var11, var12, var9, var10, 5.0F, 1.0F, Colors.withAlpha(var5, 0.85F));
      var0.text(var6, var1 - var0.textWidth(var6, var7) * 0.5F, var2, var7, Colors.lighten(var5, 0.75F));
   }

   private static boolean isInsideOrNear(class_310 var0, class_243 var1, NetheriteFinderModule.ProbabilityRegion var2) {
      double var3 = 0.05;
      double var5 = var2.x1() - var3;
      double var7 = var2.y1() - var3;
      double var9 = var2.z1() - var3;
      double var11 = var2.x2() + var3;
      double var13 = var2.y2() + var3;
      double var15 = var2.z2() + var3;
      if (var0.field_1724 != null) {
         class_238 var17 = var0.field_1724.method_5829();
         if (var17.field_1320 >= var5 && var17.field_1323 <= var11 && var17.field_1325 >= var7 && var17.field_1322 <= var13 && var17.field_1324 >= var9 && var17.field_1321 <= var15) {
            return true;
         }
      }

      return var1.field_1352 >= var5 && var1.field_1352 <= var11 && var1.field_1351 >= var7 && var1.field_1351 <= var13 && var1.field_1350 >= var9 && var1.field_1350 <= var15;
   }
}
