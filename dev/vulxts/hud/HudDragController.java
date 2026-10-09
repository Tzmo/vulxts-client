package dev.vulxts.hud;

import dev.vulxts.render.OverlayRenderer;
import dev.vulxts.render.nanovg.NVGRenderer;
import java.util.Iterator;
import net.minecraft.class_310;
import net.minecraft.class_408;

public final class HudDragController {
   private static HudComponent dragging;
   private static float grabDx;
   private static float grabDy;

   private HudDragController() {
   }

   public static boolean isEditing() {
      return class_310.method_1551().field_1755 instanceof class_408;
   }

   public static boolean isDragging() {
      return dragging != null;
   }

   public static boolean tryStartDrag(HudManager hud) {
      NVGRenderer vg = NVGRenderer.get();
      float mx = OverlayRenderer.uiMouseX();
      float my = OverlayRenderer.uiMouseY();
      Iterator var4 = hud.layout(vg, OverlayRenderer.uiWidth(), OverlayRenderer.uiHeight(), true).iterator();

      HudManager.Placement p;
      do {
         if (!var4.hasNext()) {
            return false;
         }

         p = (HudManager.Placement)var4.next();
      } while(!p.contains(mx, my));

      float scale = p.component().getScale();
      if (p.component().onEditClick((mx - p.x()) / scale, (my - p.y()) / scale)) {
         return true;
      } else {
         dragging = p.component();
         grabDx = mx - p.x();
         grabDy = my - p.y();
         return true;
      }
   }

   public static boolean tryResize(HudManager hud, double scrollY) {
      NVGRenderer vg = NVGRenderer.get();
      float mx = OverlayRenderer.uiMouseX();
      float my = OverlayRenderer.uiMouseY();
      Iterator var6 = hud.layout(vg, OverlayRenderer.uiWidth(), OverlayRenderer.uiHeight(), true).iterator();

      HudManager.Placement p;
      do {
         if (!var6.hasNext()) {
            return false;
         }

         p = (HudManager.Placement)var6.next();
      } while(!p.contains(mx, my));

      HudComponent component = p.component();
      component.setScale(component.getScale() + (float)scrollY * 0.06F);
      return true;
   }

   public static void updateDrag(NVGRenderer vg) {
      if (dragging != null) {
         float uiWidth = OverlayRenderer.uiWidth();
         float uiHeight = OverlayRenderer.uiHeight();
         float scale = dragging.getScale();
         float w = dragging.measureWidth(vg) * scale;
         float h = dragging.measureHeight(vg) * scale;
         float freeW = Math.max(1.0F, uiWidth - w);
         float freeH = Math.max(1.0F, uiHeight - h);
         dragging.setPosition((OverlayRenderer.uiMouseX() - grabDx) / freeW, (OverlayRenderer.uiMouseY() - grabDy) / freeH);
      }

   }

   public static void stopDrag() {
      dragging = null;
   }

   public static HudComponent draggedComponent() {
      return dragging;
   }
}
