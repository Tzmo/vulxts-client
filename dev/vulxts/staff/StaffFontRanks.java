package dev.vulxts.staff;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_11719;
import net.minecraft.class_2583;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;

public final class StaffFontRanks {
   private static final Map cache = new HashMap();
   private static long expires;

   private StaffFontRanks() {
   }

   public static String describe(class_2583 var0, String var1) {
      if (System.nanoTime() > expires) {
         cache.clear();
         expires = System.nanoTime() + 10000000000L;
      }

      class_11719 var3 = var0.method_27708();
      if (var3 instanceof class_11719.class_11721 var2) {
         String var11 = var2.comp_4590().toString();
         StringBuilder var4 = new StringBuilder();
         int[] var5 = var1.codePoints().toArray();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            int var8 = var5[var7];
            if (var8 >= 57344) {
               Glyph var9 = new Glyph(var11, var8);
               String var10 = (String)cache.computeIfAbsent(var9, (var0x) -> {
                  return resolve(var0x.font(), var0x.codepoint(), new HashSet(), 0);
               });
               if (!var10.isEmpty()) {
                  var4.append(' ').append(var10);
               }
            }
         }

         return var4.toString();
      } else {
         return "";
      }
   }

   private static String resolve(String var0, int var1, Set var2, int var3) {
      if (var3 <= 8 && var2.add(var0)) {
         try {
            String[] var4 = var0.split(":", 2);
            String var5 = var4.length == 2 ? var4[0] : "minecraft";
            String var6 = var4.length == 2 ? var4[1] : var4[0];
            class_2960 var7 = class_2960.method_60655(var5, "font/" + var6 + ".json");
            HashSet var8 = new HashSet();
            boolean var9 = false;
            Iterator var10 = class_310.method_1551().method_1478().method_14489(var7).iterator();

            while(var10.hasNext()) {
               class_3298 var11 = (class_3298)var10.next();
               InputStream var12 = var11.method_14482();

               try {
                  byte[] var13 = var12.readNBytes(524289);
                  if (var13.length <= 524288) {
                     JsonObject var14 = JsonParser.parseString(new String(var13, StandardCharsets.UTF_8)).getAsJsonObject();
                     if (var14.has("providers")) {
                        Iterator var15 = var14.getAsJsonArray("providers").iterator();

                        label117:
                        while(true) {
                           while(true) {
                              if (!var15.hasNext()) {
                                 break label117;
                              }

                              JsonElement var16 = (JsonElement)var15.next();
                              JsonObject var17 = var16.getAsJsonObject();
                              String var18 = var17.has("type") ? var17.get("type").getAsString() : "";
                              if (var18.endsWith("reference") && var17.has("id")) {
                                 String var30 = resolve(var17.get("id").getAsString(), var1, new HashSet(var2), var3 + 1);
                                 if (!var30.isEmpty()) {
                                    var8.add(var30);
                                 }
                              } else if (var18.endsWith("bitmap") && var17.has("chars") && var17.has("file")) {
                                 boolean var19 = false;
                                 int var20 = 0;
                                 Iterator var21 = var17.getAsJsonArray("chars").iterator();

                                 while(var21.hasNext()) {
                                    JsonElement var22 = (JsonElement)var21.next();
                                    int[] var23 = var22.getAsString().codePoints().toArray();
                                    int var24 = var23.length;

                                    for(int var25 = 0; var25 < var24; ++var25) {
                                       int var26 = var23[var25];
                                       if (var26 != 0 && var26 != 32) {
                                          ++var20;
                                       }

                                       if (var26 == var1) {
                                          var19 = true;
                                       }
                                    }
                                 }

                                 if (var19) {
                                    String var31 = rankImage(var17.get("file").getAsString(), var20);
                                    if (var31 == null) {
                                       var9 = true;
                                    } else {
                                       var8.add(var31);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               } catch (Throwable var28) {
                  if (var12 != null) {
                     try {
                        var12.close();
                     } catch (Throwable var27) {
                        var28.addSuppressed(var27);
                     }
                  }

                  throw var28;
               }

               if (var12 != null) {
                  var12.close();
               }
            }

            return !var9 && var8.size() == 1 ? (String)var8.iterator().next() : "";
         } catch (LinkageError | Exception var29) {
            return "";
         }
      } else {
         return "";
      }
   }

   public static String rankImage(String var0, int var1) {
      if (var1 != 1) {
         return null;
      } else {
         String var2 = var0.substring(Math.max(var0.lastIndexOf(47), var0.lastIndexOf(58)) + 1);
         int var3 = var2.lastIndexOf(46);
         if (var3 > 0) {
            var2 = var2.substring(0, var3);
         }

         return StaffRankMatcher.match(var2, StaffDetector.DEFAULT_RANK_KEYWORDS);
      }
   }

   private static record Glyph(String font, int codepoint) {
      private Glyph(String font, int codepoint) {
         this.font = font;
         this.codepoint = codepoint;
      }

      public String font() {
         return this.font;
      }

      public int codepoint() {
         return this.codepoint;
      }
   }
}
