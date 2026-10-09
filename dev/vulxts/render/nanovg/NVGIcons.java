package dev.vulxts.render.nanovg;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Category;
import dev.vulxts.rt.Deobf;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.nanovg.NSVGImage;
import org.lwjgl.nanovg.NanoSVG;
import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.system.MemoryUtil;

public final class NVGIcons {
   private static final int RASTER_SIZE = 64;
   private static final Map ICONS = new HashMap();
   private static boolean loaded;

   private NVGIcons() {
   }

   public static int get(Category category) {
      ensureLoaded();
      return (Integer)ICONS.getOrDefault(category.getIconId(), -1);
   }

   private static void ensureLoaded() {
      if (!loaded) {
         loaded = true;
         Category[] var0 = Category.values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            Category category = var0[var2];
            int handle = loadSvg("assets/vulxtsclient/icons/" + category.getIconId() + ".svg");
            if (handle > 0) {
               ICONS.put(category.getIconId(), handle);
            }
         }
      }

   }

   private static int loadSvg(String resourcePath) {
      long ctx = NVGRenderer.get().ctx();

      try {
         InputStream in = NVGIcons.class.getClassLoader().getResourceAsStream(resourcePath);

         byte var22;
         label193: {
            byte var23;
            label194: {
               int var12;
               try {
                  if (in == null) {
                     VulxtsClient.LOGGER.warn(Deobf.decrypt("?\t=K(\u009a\u0080ÉûċġŘťǬƬǌǱȕȩɄɔ˚˯ˋˊ"), resourcePath);
                     var22 = -1;
                     break label193;
                  }

                  String svg = new String(in.readAllBytes(), StandardCharsets.UTF_8);
                  svg = svg.replaceAll(Deobf.decrypt("U1b\b1\u0089ÈÜÕœĕŦŻǺƼ"), Deobf.decrypt("U\f4Cn\u008e\u0083")).replaceAll(Deobf.decrypt("U1b\b1\u0089ÈÜÕœĕŦŻǿƼǹǠ"), Deobf.decrypt("U\f4C")).replace(Deobf.decrypt("\u0015\u001f Wm\u0086\u0091ùûĒļŉ"), Deobf.decrypt("U\f4Cn\u008e\u0083")).replace(Deobf.decrypt("T\b>Dk\u0083Ç"), Deobf.decrypt("T\u001d:L|\u008dÇ"));
                  ByteBuffer svgData = MemoryUtil.memUTF8(svg, true);
                  ByteBuffer units = MemoryUtil.memASCII(Deobf.decrypt("\u0006\u0012"));
                  NSVGImage image = null;
                  long rasterizer = 0L;
                  ByteBuffer pixels = null;

                  try {
                     image = NanoSVG.nsvgParse(svgData, units, 96.0F);
                     if (image == null) {
                        var23 = -1;
                        break label194;
                     }

                     rasterizer = NanoSVG.nsvgCreateRasterizer();
                     float scale = 64.0F / Math.max(image.width(), image.height());
                     pixels = MemoryUtil.memAlloc(16384);
                     NanoSVG.nsvgRasterize(rasterizer, image, 0.0F, 0.0F, scale, pixels, 64, 64, 256);
                     var12 = NanoVG.nvgCreateImageRGBA(ctx, 64, 64, 0, pixels);
                  } finally {
                     if (pixels != null) {
                        MemoryUtil.memFree(pixels);
                     }

                     if (rasterizer != 0L) {
                        NanoSVG.nsvgDeleteRasterizer(rasterizer);
                     }

                     if (image != null) {
                        NanoSVG.nsvgDelete(image);
                     }

                     MemoryUtil.memFree(svgData);
                     MemoryUtil.memFree(units);
                  }
               } catch (Throwable var20) {
                  if (in != null) {
                     try {
                        in.close();
                     } catch (Throwable var18) {
                        var20.addSuppressed(var18);
                     }
                  }

                  throw var20;
               }

               if (in != null) {
                  in.close();
               }

               return var12;
            }

            if (in != null) {
               in.close();
            }

            return var23;
         }

         if (in != null) {
            in.close();
         }

         return var22;
      } catch (Exception var21) {
         VulxtsClient.LOGGER.error(Deobf.decrypt("0\u000b;Im\u008cÅÎûŞġŚųƸƤǗǫȜȥȊɚʃʠ˞ʗ̊ͪ"), resourcePath, var21);
         return -1;
      }
   }
}
