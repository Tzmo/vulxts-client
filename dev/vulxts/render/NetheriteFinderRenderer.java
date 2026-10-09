package dev.vulxts.render;

import dev.vulxts.module.impl.NetheriteFinderModule;
import dev.vulxts.util.Colors;
import java.util.Iterator;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1802;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_638;
import org.joml.Vector3fc;

public final class NetheriteFinderRenderer {
   private NetheriteFinderRenderer() {
   }

   public static void render(class_4597.class_4598 var0, class_4587 var1, class_243 var2, NetheriteFinderModule var3) {
      class_310 var4 = class_310.method_1551();
      class_638 var5 = var4.field_1687;
      if (var5 != null) {
         long var6 = System.currentTimeMillis() % 2000L;
         double var8 = var6 < 1000L ? (double)var6 / 1000.0 : (double)(2000L - var6) / 1000.0;
         int var10 = (Integer)var3.outerBoxColor.get();
         int var11 = Colors.withAlpha(var10, 90 - (int)(35.0 * var8));
         Colors.withAlpha(var10, 45 - (int)(15.0 * var8));
         boolean var13 = (Boolean)var3.tracers.get();
         Vector3fc var14 = var4.field_1773.method_19418().method_19335();
         NetheriteFinderModule.Hit var15 = var4.field_1724 == null ? null : NetheriteFinderModule.closestSuspiciousHit(var3.hits(), (String)var3.closestLayer.get(), var4.field_1724.method_23317(), var4.field_1724.method_23321());
         Iterator var16 = var3.hits().iterator();

         while(true) {
            NetheriteFinderModule.Hit var17;
            int var18;
            do {
               if (!var16.hasNext()) {
                  var16 = var5.method_18112().iterator();

                  while(var16.hasNext()) {
                     class_1297 var20 = (class_1297)var16.next();
                     if (var20 instanceof class_1542) {
                        class_1542 var21 = (class_1542)var20;
                        if (var21.method_6983().method_31574(class_1802.field_22019)) {
                           class_238 var22 = var21.method_5829();
                           if (!isInsideOrNear(var4, var2, var22.field_1323, var22.field_1322, var22.field_1321, var22.field_1320, var22.field_1325, var22.field_1324, true)) {
                              EspBoxRenderer.fill(var0, var1, var2, var22.field_1323, var22.field_1322, var22.field_1321, var22.field_1320, var22.field_1325, var22.field_1324, var11);
                           }

                           EspBoxRenderer.outline(var0, var1, var2, var22.field_1323, var22.field_1322, var22.field_1321, var22.field_1320, var22.field_1325, var22.field_1324, Colors.withAlpha(var10, 255), 2.0F);
                           EspBoxRenderer.tracer(var0, var1, var2, var14, var21.method_23317(), var21.method_23318(), var21.method_23321(), Colors.withAlpha(var10, 255), 1.2F);
                        }
                     }
                  }

                  EspBoxRenderer.flush(var0);
                  return;
               }

               var17 = (NetheriteFinderModule.Hit)var16.next();
               var18 = var17 == var15 ? (Integer)var3.closestColor.get() : var10;
               int var19 = Colors.withAlpha(var18, var17.exact() ? 90 - (int)(35.0 * var8) : 45 - (int)(15.0 * var8));
               if (!isInsideOrNear(var4, var2, var17.x1(), var17.y1(), var17.z1(), var17.x2(), var17.y2(), var17.z2(), var17.exact())) {
                  EspBoxRenderer.fill(var0, var1, var2, var17.x1(), var17.y1(), var17.z1(), var17.x2(), var17.y2(), var17.z2(), var19);
               }

               EspBoxRenderer.outline(var0, var1, var2, var17.x1(), var17.y1(), var17.z1(), var17.x2(), var17.y2(), var17.z2(), Colors.withAlpha(var18, 255), var17.exact() ? 2.0F : 1.5F);
            } while(!var17.exact() && !var13);

            EspBoxRenderer.tracer(var0, var1, var2, var14, (var17.x1() + var17.x2()) * 0.5, (var17.y1() + var17.y2()) * 0.5, (var17.z1() + var17.z2()) * 0.5, Colors.withAlpha(var18, 255), 1.2F);
         }
      }
   }

   private static boolean isInsideOrNear(class_310 var0, class_243 var1, double var2, double var4, double var6, double var8, double var10, double var12, boolean var14) {
      double var15 = var14 ? 1.35 : 0.05;
      double var17 = var2 - var15;
      double var19 = var4 - var15;
      double var21 = var6 - var15;
      double var23 = var8 + var15;
      double var25 = var10 + var15;
      double var27 = var12 + var15;
      if (var0.field_1724 != null) {
         class_238 var29 = var0.field_1724.method_5829();
         if (var29.field_1320 >= var17 && var29.field_1323 <= var23 && var29.field_1325 >= var19 && var29.field_1322 <= var25 && var29.field_1324 >= var21 && var29.field_1321 <= var27) {
            return true;
         }
      }

      return var1.field_1352 >= var17 && var1.field_1352 <= var23 && var1.field_1351 >= var19 && var1.field_1351 <= var25 && var1.field_1350 >= var21 && var1.field_1350 <= var27;
   }
}
