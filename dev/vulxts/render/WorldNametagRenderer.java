package dev.vulxts.render;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.Modules;
import dev.vulxts.module.impl.NameProtectModule;
import dev.vulxts.module.impl.NameTagsModule;
import dev.vulxts.module.impl.SpawnerNametagsModule;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.theme.Theme;
import dev.vulxts.util.Colors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2636;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_8961;
import org.joml.Matrix3x2fStack;

public final class WorldNametagRenderer {
   private static final int SPAWNER_ACCENT = -22733;
   private static final int MAX_TAGS = 80;

   private WorldNametagRenderer() {
   }

   public static void render(NVGRenderer var0) {
      if (WorldProjection.isValid()) {
         ModuleManager var1 = VulxtsClient.modules();
         if (var1 != null) {
            class_310 var2 = class_310.method_1551();
            class_638 var3 = var2.field_1687;
            class_746 var4 = var2.field_1724;
            if (var3 != null && var4 != null) {
               NameTagsModule var5 = var1.nameTags;
               SpawnerNametagsModule var6 = var1.spawnerNametags;
               boolean var7 = var5 != null && var5.isEnabled();
               boolean var8 = false;
               if (var7 || var8) {
                  float var9 = WorldProjection.partialTick();
                  Theme var10 = VulxtsClient.themes().current();
                  Modules.HudModule var11 = var1.hud;
                  int var12 = var11 != null && !(Boolean)var11.themeSync.get() ? (Integer)var11.listColor.get() : var10.accent();
                  ArrayList var13 = new ArrayList();
                  double var43;
                  if (var7) {
                     double var14 = (Double)var5.range.get();
                     double var16 = var14 * var14;
                     float var18 = var5.scale.getFloat();
                     float var19 = (float)((Double)var5.opacity.get() / 100.0);
                     if ((Boolean)var5.players.get()) {
                        NameProtectModule var20 = var1.nameProtect;
                        boolean var21 = var20 != null && var20.isEnabled();
                        boolean var22 = (Boolean)var5.self.get() && !var2.field_1690.method_31044().method_31034();
                        Iterator var23 = var3.method_18456().iterator();

                        label153:
                        while(true) {
                           class_742 var24;
                           double var26;
                           String var28;
                           float var30;
                           String var32;
                           do {
                              boolean var25;
                              do {
                                 do {
                                    do {
                                       do {
                                          if (!var23.hasNext()) {
                                             break label153;
                                          }

                                          var24 = (class_742)var23.next();
                                          var25 = var24 == var4;
                                       } while(var25 && !var22);
                                    } while(var24.method_7325());
                                 } while(!var24.method_5805());

                                 var26 = var4.method_5858(var24);
                              } while(!var25 && var26 > var16);

                              var28 = var24.method_7334().name();
                              String var29;
                              if (var21 && (var29 = var20.replacementForDisplay(var28)) != null) {
                                 var28 = var29;
                              }

                              var30 = -1.0F;
                              float var31;
                              if ((Boolean)var5.health.get() && (var31 = var24.method_6063()) > 0.0F) {
                                 var30 = class_3532.method_15363(var24.method_6032() / var31, 0.0F, 1.0F);
                              }

                              var32 = !var25 && (Boolean)var5.distance.get() ? (int)Math.sqrt(var26) + "m" : null;
                           } while(var28.isEmpty() && var32 == null && var30 < 0.0F);

                           var13.add(entityTag(var24, var9, Math.sqrt(var26), var28, var32, var12, var30, var18, var19));
                        }
                     }

                     if ((Boolean)var5.items.get()) {
                        Iterator var39 = var3.method_18112().iterator();

                        while(var39.hasNext()) {
                           class_1297 var40 = (class_1297)var39.next();
                           class_1799 var42;
                           class_1542 var44;
                           if (var40 instanceof class_1542 && (var44 = (class_1542)var40).method_5805() && !((var43 = var4.method_5858(var44)) > var16) && !(var42 = var44.method_6983()).method_7960()) {
                              String var46 = itemSuffix(var42.method_7947(), (Boolean)var5.itemAmount.get(), (Boolean)var5.distance.get() ? (int)Math.sqrt(var43) + "m" : null);
                              var13.add(entityTag(var44, var9, Math.sqrt(var43), var42.method_7964().getString(), var46, var12, -1.0F, var18, var19));
                           }
                        }
                     }
                  }

                  int var33;
                  if (var8) {
                     var33 = (Integer)var6.color.get();
                     Iterator var15 = var6.visiblePositions().iterator();

                     while(var15.hasNext()) {
                        class_2338 var35 = (class_2338)var15.next();
                        double var17 = (double)var35.method_10263() + 0.5;
                        double var38 = (double)var35.method_10264() + 1.35;
                        double var41 = (double)var35.method_10260() + 0.5;
                        var43 = var4.method_5649(var17, (double)var35.method_10264() + 0.5, var41);
                        String var45 = (int)Math.sqrt(var43) + "m";
                        var13.add(new Tag(Math.sqrt(var43), var17, var38, var41, spawnerName(var3, var35), var45, var33, -1.0F, 1.0F, 0.95F));
                     }
                  }

                  if (!var13.isEmpty()) {
                     var13.sort(Comparator.comparingDouble(Tag::dist));
                     var33 = Math.min(var13.size(), 80);

                     for(int var34 = var33 - 1; var34 >= 0; --var34) {
                        Tag var36 = (Tag)var13.get(var34);
                        float[] var37 = WorldProjection.project(var36.wx, var36.wy, var36.wz);
                        if (var37 != null) {
                           drawTag(var0, var10, var37[0], var37[1], var36);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   private static Tag entityTag(class_1297 var0, float var1, double var2, String var4, String var5, int var6, float var7, float var8, float var9) {
      double var10 = class_3532.method_16436((double)var1, var0.field_6038, var0.method_23317());
      double var12 = class_3532.method_16436((double)var1, var0.field_5971, var0.method_23318()) + (double)var0.method_17682() + 0.5;
      double var14 = class_3532.method_16436((double)var1, var0.field_5989, var0.method_23321());
      return new Tag(var2, var10, var12, var14, var4, var5, var6, var7, var8, var9);
   }

   private static String itemSuffix(int var0, boolean var1, String var2) {
      StringBuilder var3 = new StringBuilder();
      if (var1 && var0 > 1) {
         var3.append('x').append(var0);
      }

      if (var2 != null) {
         if (var3.length() > 0) {
            var3.append(Deobf.decrypt("VJ"));
         }

         var3.append(var2);
      }

      return var3.length() == 0 ? null : var3.toString();
   }

   private static String spawnerName(class_638 var0, class_2338 var1) {
      try {
         class_2586 var2 = var0.method_8321(var1);
         class_1297 var4;
         if (var2 instanceof class_2636 var6) {
            var4 = var6.method_11390().method_8283(var0, var1);
            return var4 != null ? var4.method_5864().method_5897().getString() + " Spawner" : Deobf.decrypt("%\u001a3Rf\u008d\u0097");
         }

         if (var2 instanceof class_8961 var3) {
            var4 = var3.method_55150().method_55174().method_55190(var3.method_55150(), var0, var3.method_55151());
            return var4 != null ? "Trial: " + var4.method_5864().method_5897().getString() : Deobf.decrypt("\"\u0018;DdÈ¶ÊõĉĽŞŲ");
         }
      } catch (Exception var5) {
      }

      return Deobf.decrypt("%\u001a3Rf\u008d\u0097");
   }

   private static float pillHeight(float var0, boolean var1) {
      float var2 = 12.5F * var0 + 3.5F * var0 * 2.0F;
      return var2 + (var1 ? 3.0F * var0 + 3.5F * var0 : 0.0F);
   }

   public static void renderEquipment(class_332 var0) {
      if (WorldProjection.isValid()) {
         ModuleManager var1 = VulxtsClient.modules();
         if (var1 != null) {
            NameTagsModule var2 = var1.nameTags;
            if (var2 != null && var2.isEnabled() && (Boolean)var2.players.get()) {
               boolean var3 = (Boolean)var2.armor.get();
               boolean var4 = (Boolean)var2.heldItem.get();
               if (var3 || var4) {
                  class_310 var5 = class_310.method_1551();
                  if (var5.field_1755 == null && !var5.field_1690.field_1842) {
                     class_638 var6 = var5.field_1687;
                     class_746 var7 = var5.field_1724;
                     if (var6 != null && var7 != null) {
                        float var8 = WorldProjection.partialTick();
                        double var9 = (Double)var2.range.get();
                        double var11 = var9 * var9;
                        float var13 = var2.scale.getFloat();
                        float var14 = pillHeight(var13, (Boolean)var2.health.get());
                        float var15 = OverlayRenderer.uiScale();
                        double var16 = (double)var5.method_22683().method_4495();
                        boolean var18 = (Boolean)var2.self.get() && !var5.field_1690.method_31044().method_31034();
                        ArrayList var19 = new ArrayList();
                        Iterator var20 = var6.method_18456().iterator();

                        while(true) {
                           class_742 var21;
                           float[] var23;
                           do {
                              do {
                                 boolean var22;
                                 do {
                                    do {
                                       do {
                                          do {
                                             if (!var20.hasNext()) {
                                                return;
                                             }

                                             var21 = (class_742)var20.next();
                                             var22 = var21 == var7;
                                          } while(var22 && !var18);
                                       } while(var21.method_7325());
                                    } while(!var21.method_5805());
                                 } while(!var22 && var7.method_5858(var21) > var11);

                                 var19.clear();
                                 if (var3) {
                                    addItem(var19, var21.method_6118(class_1304.field_6169));
                                    addItem(var19, var21.method_6118(class_1304.field_6174));
                                    addItem(var19, var21.method_6118(class_1304.field_6172));
                                    addItem(var19, var21.method_6118(class_1304.field_6166));
                                 }

                                 if (var4) {
                                    addItem(var19, var21.method_6047());
                                    addItem(var19, var21.method_6118(class_1304.field_6171));
                                 }
                              } while(var19.isEmpty());
                           } while((var23 = WorldProjection.projectRaw(class_3532.method_16436((double)var8, var21.field_6038, var21.method_23317()), class_3532.method_16436((double)var8, var21.field_5971, var21.method_23318()) + (double)var21.method_17682() + 0.5, class_3532.method_16436((double)var8, var21.field_5989, var21.method_23321()))) == null);

                           float var24 = (float)((double)var23[0] / var16);
                           float var25 = (float)((double)(var23[1] - var14 * var15) / var16) - 3.0F;
                           float var26 = 11.0F * var13;
                           float var27 = var26 + 1.5F;
                           float var28 = (float)var19.size() * var26 + (float)(var19.size() - 1) * 1.5F;
                           float var29 = var24 - var28 / 2.0F;
                           float var30 = var25 - var26;
                           Matrix3x2fStack var31 = var0.method_51448();

                           for(int var32 = 0; var32 < var19.size(); ++var32) {
                              class_1799 var33 = (class_1799)var19.get(var32);
                              var31.pushMatrix();
                              var31.translate(var29 + (float)var32 * var27, var30);
                              var31.scale(var26 / 16.0F, var26 / 16.0F);
                              var0.method_51423(var21, var33, 0, 0, 0);
                              var0.method_51431(var5.field_1772, var33, 0, 0);
                              var31.popMatrix();
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   private static void addItem(List var0, class_1799 var1) {
      if (var1 != null && !var1.method_7960()) {
         var0.add(var1);
      }

   }

   private static void drawTag(NVGRenderer var0, Theme var1, float var2, float var3, Tag var4) {
      float var5 = var4.scale;
      int var6 = Colors.lighten(var4.accent, 0.35F);
      float var7 = 12.5F * var5;
      float var8 = 10.0F * var5;
      float var9 = 6.0F * var5;
      float var10 = 3.5F * var5;
      float var11 = 5.0F * var5;
      boolean var12 = var4.healthFrac >= 0.0F;
      float var13 = 3.0F * var5;
      float var14 = var0.textWidth(var4.name, var7);
      float var15 = var4.suffix != null ? var11 + var0.textWidth(var4.suffix, var8) : 0.0F;
      float var16 = var14 + var15 + var9 * 2.0F;
      float var17 = var7 + var10 * 2.0F;
      float var18 = var17 + (var12 ? var13 + var10 : 0.0F);
      float var19 = var2 - var16 / 2.0F;
      float var20 = var3 - var18;
      float var21 = Math.min(6.0F * var5, var18 / 2.0F);
      boolean var22 = var4.opacity < 0.999F;
      if (var22) {
         var0.save();
         var0.alpha(var4.opacity);
      }

      var0.glow(var19, var20, var16, var18, var21, 4.0F, Colors.withAlpha(var4.accent, 0.12F));
      var0.rectGradient(var19, var20, var16, var18, var21, var1.background(), var1.backgroundTo(), true);
      float var23 = var20 + var10 + var7 / 2.0F;
      float var24 = var19 + var9;
      var24 += var0.textGradient(var4.name, var24, var23, var7, var6, var4.accent);
      if (var4.suffix != null) {
         var0.text(var4.suffix, var24 + var11, var23, var8, var1.textMuted());
      }

      if (var12) {
         float var25 = var20 + var17;
         float var26 = var19 + var9;
         float var27 = var16 - var9 * 2.0F;
         var0.rect(var26, var25, var27, var13, var13 / 2.0F, Colors.withAlpha(-16777216, 0.55F));
         int var28 = Colors.lerp(-2080450, -11671924, var4.healthFrac);
         var0.rect(var26, var25, Math.max(var13, var27 * var4.healthFrac), var13, var13 / 2.0F, var28);
      }

      if (var22) {
         var0.restore();
      }

   }

   private static record Tag(double dist, double wx, double wy, double wz, String name, String suffix, int accent, float healthFrac, float scale, float opacity) {
      private Tag(double dist, double wx, double wy, double wz, String name, String suffix, int accent, float healthFrac, float scale, float opacity) {
         this.dist = dist;
         this.wx = wx;
         this.wy = wy;
         this.wz = wz;
         this.name = name;
         this.suffix = suffix;
         this.accent = accent;
         this.healthFrac = healthFrac;
         this.scale = scale;
         this.opacity = opacity;
      }

      public double dist() {
         return this.dist;
      }

      public double wx() {
         return this.wx;
      }

      public double wy() {
         return this.wy;
      }

      public double wz() {
         return this.wz;
      }

      public String name() {
         return this.name;
      }

      public String suffix() {
         return this.suffix;
      }

      public int accent() {
         return this.accent;
      }

      public float healthFrac() {
         return this.healthFrac;
      }

      public float scale() {
         return this.scale;
      }

      public float opacity() {
         return this.opacity;
      }
   }
}
