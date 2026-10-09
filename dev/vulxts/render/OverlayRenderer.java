package dev.vulxts.render;

import com.mojang.blaze3d.textures.GpuTexture;
import dev.vulxts.VulxtsClient;
import dev.vulxts.hud.HudDragController;
import dev.vulxts.hud.HudManager;
import dev.vulxts.module.impl.CustomCrosshairModule;
import dev.vulxts.module.impl.MotionBlurModule;
import dev.vulxts.notification.NotificationManager;
import dev.vulxts.render.nanovg.GlStateSnapshot;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.theme.Theme;
import dev.vulxts.util.Colors;
import java.util.Iterator;
import net.minecraft.class_10868;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_433;
import net.minecraft.class_4667;
import org.lwjgl.opengl.GL33C;

public final class OverlayRenderer {
   private static HudManager hudManager;
   private static NotificationManager notifications;
   private static int fbo = -1;
   private static boolean crashed;

   private OverlayRenderer() {
   }

   public static void init(HudManager var0, NotificationManager var1) {
      hudManager = var0;
      notifications = var1;
   }

   public static float uiScale() {
      class_310 var0 = class_310.method_1551();
      return Math.max(1.0F, (float)var0.method_22683().method_4506() / 1080.0F);
   }

   public static void render() {
      try {
         GlintTextureTinter.tick();
      } catch (Throwable var21) {
      }

      if (!crashed && hudManager != null) {
         class_310 var2 = class_310.method_1551();
         class_276 var3 = var2.method_1522();
         GpuTexture var1;
         if (var3 != null && (var1 = var3.method_30277()) instanceof class_10868) {
            class_10868 var4 = (class_10868)var1;
            boolean var5 = var2.field_1755 instanceof NvgDrawable;
            boolean var6 = var2.field_1755 instanceof class_408;
            boolean var7 = var2.field_1755 instanceof class_433 || var2.field_1755 instanceof class_4667;
            boolean var8 = !var2.field_1690.field_1842 && var2.field_1687 != null && !var5 && !var7;
            boolean var9 = var2.field_1687 != null && !var2.field_1690.field_1842 && !var7;
            MotionBlurModule var10 = VulxtsClient.modules() != null ? VulxtsClient.modules().motionBlur : null;
            boolean var0 = var10 != null && var10.isEnabled() && var2.field_1687 != null && !var5;
            if (var5 || var8 || var9 || var0) {
               try {
                  GlStateSnapshot var12 = GlStateSnapshot.capture();

                  try {
                     if (!bindOverlayFbo(var4, var3.field_1482, var3.field_1481)) {
                        return;
                     }

                     NVGRenderer var13 = NVGRenderer.get();
                     if (var0) {
                        MotionBlurRenderer.render(var13, var3.field_1482, var3.field_1481, var10);
                     }

                     var13.setFontMode((String)VulxtsClient.modules().clickGui.font.get());
                     if (!var13.hasFont()) {
                        return;
                     }

                     float var14 = uiScale();
                     float var15 = (float)var3.field_1482 / var14;
                     float var16 = (float)var3.field_1481 / var14;
                     var13.beginFrame((float)var3.field_1482, (float)var3.field_1481, 1.0F);
                     var13.save();
                     var13.scale(var14);
                     if (var8) {
                        if (var6 && HudDragController.isDragging()) {
                           HudDragController.updateDrag(var13);
                        }

                        CustomCrosshairModule var17;
                        if ((var17 = VulxtsClient.modules().customCrosshair).isEnabled() && var2.field_1755 == null) {
                           var17.render(var13, var15 / 2.0F, var16 / 2.0F);
                        }

                        if (var2.field_1755 == null) {
                           WorldNametagRenderer.render(var13);
                           NetheriteProbabilityRenderer.renderLabels(var13);
                        }

                        hudManager.render(var13, var15, var16);
                        if (var6) {
                           renderChatEditOverlay(var13, var15, var16);
                        }
                     }

                     if (var9) {
                        notifications.renderToasts(var13, var15, var16);
                     }

                     if (var5) {
                        ((NvgDrawable)var2.field_1755).renderNvg(var13, uiMouseX(), uiMouseY(), var15, var16);
                     }

                     var13.restore();
                     var13.endFrame();
                  } finally {
                     var12.restore();
                  }

                  return;
               } catch (Throwable var23) {
                  crashed = true;
                  VulxtsClient.LOGGER.error(Deobf.decrypt(" \u001f>]|\u009b¦ÖýěĽŏĠƣƷǀǰȊȡɓȓʒʪ˞˓͖̔ͥͣϏιχϲϓЕдёХӔҩӮӷԃԥՑմ֛։֛ץ\u0601ؗوضڝڥ"), var23);
               }
            }
         }
      }

   }

   private static void renderChatEditOverlay(NVGRenderer var0, float var1, float var2) {
      Theme var3 = VulxtsClient.themes().current();
      float var4 = uiMouseX();
      float var5 = uiMouseY();
      String var6 = "VULXTS CLIENT  /  DRAG TO MOVE  /  SCROLL TO SCALE";
      var0.text(var6, (var1 - var0.textWidth(var6, 14.0F)) / 2.0F, 22.0F, 14.0F, Colors.withAlpha(var3.textMuted(), 0.9F));
      Iterator var7 = hudManager.layout(var0, var1, var2, true).iterator();

      while(var7.hasNext()) {
         HudManager.Placement var8 = (HudManager.Placement)var7.next();
         boolean var10 = !var8.component().visible();
         boolean var9 = var8.contains(var4, var5) || var8.component() == HudDragController.draggedComponent();
         if (var10) {
            var0.save();
            var0.alpha(0.35F);
            hudManager.renderPlacement(var0, var8);
            var0.restore();
         }

         int var12 = var9 ? var3.accentBright() : Colors.withAlpha(var3.accent(), 0.5F);
         var0.rectOutline(var8.x() - 3.0F, var8.y() - 3.0F, var8.w() + 6.0F, var8.h() + 6.0F, 6.0F, var9 ? 1.6F : 1.0F, var12);
         var0.rect(var8.x() + var8.w() - 2.0F, var8.y() + var8.h() - 2.0F, 6.0F, 6.0F, 2.0F, var12);
         if (var9) {
            float var10000 = var8.component().getScale();
            String var13 = Math.round(var10000 * 100.0F) + "%";
            var0.text(var13, var8.x() + var8.w() + 6.0F, var8.y() + var8.h() / 2.0F, 11.0F, var3.accentBright());
         }
      }

   }

   private static boolean bindOverlayFbo(class_10868 var0, int var1, int var2) {
      if (fbo == -1) {
         fbo = GL33C.glGenFramebuffers();
      }

      GL33C.glBindFramebuffer(36160, fbo);
      GL33C.glFramebufferTexture2D(36160, 36064, 3553, var0.method_68427(), 0);
      if (GL33C.glCheckFramebufferStatus(36160) != 36053) {
         return false;
      } else {
         GL33C.glViewport(0, 0, var1, var2);
         GL33C.glDisable(3089);
         return true;
      }
   }

   public static float uiMouseX() {
      class_310 var0 = class_310.method_1551();
      return (float)(var0.field_1729.method_1603() * (double)var0.method_22683().method_4489() / (double)Math.max(1, var0.method_22683().method_4480())) / uiScale();
   }

   public static float uiMouseY() {
      class_310 var0 = class_310.method_1551();
      return (float)(var0.field_1729.method_1604() * (double)var0.method_22683().method_4506() / (double)Math.max(1, var0.method_22683().method_4507())) / uiScale();
   }

   public static float guiToUi(double var0) {
      class_310 var2 = class_310.method_1551();
      float var3 = (float)(var0 * (double)var2.method_22683().method_4495());
      return var3 / uiScale();
   }

   public static float uiWidth() {
      class_310 var0 = class_310.method_1551();
      return (float)var0.method_22683().method_4489() / uiScale();
   }

   public static float uiHeight() {
      class_310 var0 = class_310.method_1551();
      return (float)var0.method_22683().method_4506() / uiScale();
   }
}
