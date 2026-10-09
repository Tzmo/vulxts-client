package dev.vulxts.render;

import dev.vulxts.module.impl.SpawnerNametagsModule;
import java.util.Iterator;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import net.minecraft.class_4597;

public final class MiscBlockEspRenderer {
   private MiscBlockEspRenderer() {
   }

   public static void renderSpawners(class_4597.class_4598 var0, class_4587 var1, class_243 var2, SpawnerNametagsModule var3) {
      int var4 = (Integer)var3.color.get();
      Iterator var5 = var3.visiblePositions().iterator();

      while(var5.hasNext()) {
         class_2338 var6 = (class_2338)var5.next();
         EspBoxRenderer.beam(var0, var1, var2, (double)var6.method_10263() + 0.5, (double)var6.method_10264() + 0.5, (double)var6.method_10260() + 0.5, (double)var6.method_10264() + 500.5, var4, 8.0F);
      }

      EspBoxRenderer.flush(var0);
   }
}
