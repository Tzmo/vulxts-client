package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_310;
import net.minecraft.class_3283;

public final class PanoramaModule extends Module {
   private static final String PACK_FILE = "vulxts-panorama.zip";
   private static final String EMBEDDED_PACK = "/assets/vulxtsclient/embedded/vulxts-panorama.zip";

   public PanoramaModule() {
      super("Panorama", "Uses the bundled Vulxts menu panorama while enabled.", Category.RENDER);
   }

   protected void onEnable() {
      this.apply(true);
   }

   protected void onDisable() {
      this.apply(false);
   }

   private void apply(boolean var1) {
      try {
         class_310 var2 = class_310.method_1551();
         class_3283 var3 = var2.method_1520();
         if (var1) {
            Path var4 = FabricLoader.getInstance().getGameDir().resolve("resourcepacks");
            Files.createDirectories(var4);
            InputStream var5 = PanoramaModule.class.getResourceAsStream("/assets/vulxtsclient/embedded/vulxts-panorama.zip");

            label79: {
               try {
                  if (var5 != null) {
                     Files.copy(var5, var4.resolve("vulxts-panorama.zip"), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                     break label79;
                  }
               } catch (Throwable var9) {
                  if (var5 != null) {
                     try {
                        var5.close();
                     } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                     }
                  }

                  throw var9;
               }

               if (var5 != null) {
                  var5.close();
               }

               return;
            }

            if (var5 != null) {
               var5.close();
            }

            var3.method_14445();
         }

         String var11 = null;
         Iterator var12 = var3.method_29206().iterator();

         while(var12.hasNext()) {
            Object var6 = var12.next();
            String var7 = String.valueOf(var6);
            if (var7.endsWith("vulxts-panorama.zip")) {
               var11 = var7;
               break;
            }
         }

         if (var11 == null) {
            return;
         }

         boolean var13 = var1 ? var3.method_49427(var11) : var3.method_49428(var11);
         if (var13) {
            var2.method_1521();
         }
      } catch (Exception var10) {
      }

   }
}
