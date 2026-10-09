package dev.vulxts.render;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.impl.ChunkFinderModule;
import dev.vulxts.util.Colors;
import java.util.Iterator;
import net.minecraft.class_1923;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import net.minecraft.class_4597;

public final class ChunkFinderRenderer {
   private static final float RENDER_Y = 55.0F;
   private static final int FILL_ALPHA = 190;

   private ChunkFinderRenderer() {
   }

   public static void render(class_4597.class_4598 bufferSource, class_4587 poseStack, class_243 camera, ChunkFinderModule module) {
      if (!module.flaggedChunks().isEmpty()) {
         int accent = VulxtsClient.themes().current().accent();
         int fill = Colors.withAlpha(Colors.darken(accent, 0.58F), 190);
         int outline = Colors.withAlpha(accent, 255);
         Iterator var7 = module.flaggedChunks().iterator();

         while(var7.hasNext()) {
            long key = (Long)var7.next();
            double x0 = (double)class_1923.method_8325(key) * 16.0;
            double z0 = (double)class_1923.method_8332(key) * 16.0;
            double x1 = x0 + 16.0;
            double z1 = z0 + 16.0;
            FlatOverlay.fillQuad(bufferSource, poseStack, camera, x0, z0, x1, z1, 55.0, fill);
            FlatOverlay.edge(bufferSource, poseStack, camera, x0, z0, x1, z0, 55.0, outline, 2.0F);
            FlatOverlay.edge(bufferSource, poseStack, camera, x1, z0, x1, z1, 55.0, outline, 2.0F);
            FlatOverlay.edge(bufferSource, poseStack, camera, x1, z1, x0, z1, 55.0, outline, 2.0F);
            FlatOverlay.edge(bufferSource, poseStack, camera, x0, z1, x0, z0, 55.0, outline, 2.0F);
         }

         FlatOverlay.flush(bufferSource);
      }

   }
}
