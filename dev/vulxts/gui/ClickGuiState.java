package dev.vulxts.gui;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.vulxts.module.Category;
import dev.vulxts.rt.Deobf;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class ClickGuiState {
   public static final String THEMES_PANEL = "__themes__";
   private final Map panels = new LinkedHashMap();
   private final Set expandedModules = new HashSet();
   private final Set favourites = new HashSet();
   private boolean laidOut;
   private boolean customized;
   private float lastLayoutWidth = -1.0F;
   private float lastLayoutHeight = -1.0F;
   private static final int LAYOUT_VERSION = 3;
   private static final float PANEL_W = 210.0F;
   private static final float SEARCH_W = 280.0F;

   public boolean isFavourite(String var1) {
      return this.favourites.contains(var1);
   }

   public void toggleFavourite(String var1) {
      if (!this.favourites.remove(var1)) {
         this.favourites.add(var1);
      }

   }

   public void markCustomized() {
      this.customized = true;
   }

   public ClickGuiState() {
      float var1 = 16.0F;
      Category[] var2 = Category.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Category var5 = var2[var4];
         this.panels.put(var5.name(), new PanelState(var1, 16.0F));
         var1 += 222.0F;
      }

      this.panels.put(Deobf.decrypt(")5&Mm\u0085\u0080ÉËġ"), new PanelState(var1, 320.0F));
   }

   public void ensureDefaultLayout(float var1, float var2) {
      if (!this.customized && (!this.laidOut || var1 != this.lastLayoutWidth || var2 != this.lastLayoutHeight)) {
         this.laidOut = true;
         this.lastLayoutWidth = var1;
         this.lastLayoutHeight = var2;
         String[] var3 = new String[]{Category.COMBAT.name(), Category.MISC.name(), Category.RENDER.name(), Category.VISUALS.name(), Category.CLIENT.name(), Deobf.decrypt(")5&Mm\u0085\u0080ÉËġ")};
         float var4 = 1344.0F;
         float var5;
         int var7;
         PanelState var8;
         if (var1 >= var4) {
            float var6 = var5 = (var1 - 1260.0F) / 7.0F;

            for(var7 = 0; var7 < var3.length; ++var7) {
               var8 = this.panel(var3[var7]);
               var8.x = var6;
               var8.y = 76.0F;
               var8.collapsed = false;
               var6 += 210.0F + var5;
            }
         } else {
            var5 = 222.0F;
            int var10 = Math.max(1, (int)((var1 - 24.0F) / var5));

            for(var7 = 0; var7 < var3.length; ++var7) {
               var8 = this.panel(var3[var7]);
               var8.x = 12.0F + (float)(var7 % var10) * var5;
               var8.y = 76.0F + (float)(var7 / var10) * var2 * 0.4F;
               var8.collapsed = var7 / var10 > 0;
            }
         }
      }

   }

   public PanelState panel(String var1) {
      return (PanelState)this.panels.computeIfAbsent(var1, (var0) -> {
         return new PanelState(16.0F, 16.0F);
      });
   }

   public boolean isExpanded(String var1) {
      return this.expandedModules.contains(var1);
   }

   public void setExpanded(String var1, boolean var2) {
      if (var2) {
         this.expandedModules.add(var1);
      } else {
         this.expandedModules.remove(var1);
      }

   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      JsonArray var2 = new JsonArray();
      Stream var10000 = this.favourites.stream().sorted();
      Objects.requireNonNull(var2);
      var10000.forEach(var2::add);
      var1.add("favourites", var2);
      var1.addProperty(Deobf.decrypt("\u0000"), 3);
      var1.addProperty(Deobf.decrypt("\u0015\u001f!Qg\u0085"), this.customized);
      Iterator var3 = this.panels.entrySet().iterator();

      while(var3.hasNext()) {
         Map.Entry var4 = (Map.Entry)var3.next();
         JsonObject var5 = new JsonObject();
         var5.addProperty(Deobf.decrypt("\u000e"), ((PanelState)var4.getValue()).x);
         var5.addProperty(Deobf.decrypt("\u000f"), ((PanelState)var4.getValue()).y);
         var5.addProperty(Deobf.decrypt("\u0015\u0005>Ii\u0098\u0096ßð"), ((PanelState)var4.getValue()).collapsed);
         var1.add((String)var4.getKey(), var5);
      }

      return var1;
   }

   public void fromJson(JsonObject var1) {
      this.favourites.clear();
      Iterator var2;
      if (var1.has("favourites") && var1.get("favourites").isJsonArray()) {
         var2 = var1.getAsJsonArray("favourites").iterator();

         while(var2.hasNext()) {
            JsonElement var3 = (JsonElement)var2.next();
            if (var3.isJsonPrimitive() && var3.getAsJsonPrimitive().isString()) {
               this.favourites.add(var3.getAsString().replace("VulxtsJumpCircles@", "JumpCircles@"));
            }
         }
      }

      if (var1.has(Deobf.decrypt("\u0000")) && var1.get(Deobf.decrypt("\u0000")).getAsInt() >= 3 && var1.has(Deobf.decrypt("\u0015\u001f!Qg\u0085")) && var1.get(Deobf.decrypt("\u0015\u001f!Qg\u0085")).getAsBoolean()) {
         this.laidOut = true;
         this.customized = true;
         var2 = this.panels.entrySet().iterator();

         while(var2.hasNext()) {
            Map.Entry var6 = (Map.Entry)var2.next();
            JsonObject var4 = var1.getAsJsonObject((String)var6.getKey());
            if (var4 != null) {
               if (var4.has(Deobf.decrypt("\u000e"))) {
                  ((PanelState)var6.getValue()).x = var4.get(Deobf.decrypt("\u000e")).getAsFloat();
               }

               if (var4.has(Deobf.decrypt("\u000f"))) {
                  ((PanelState)var6.getValue()).y = var4.get(Deobf.decrypt("\u000f")).getAsFloat();
               }

               if (var4.has(Deobf.decrypt("\u0015\u0005>Ii\u0098\u0096ßð"))) {
                  ((PanelState)var6.getValue()).collapsed = var4.get(Deobf.decrypt("\u0015\u0005>Ii\u0098\u0096ßð")).getAsBoolean();
               }
            }
         }
      }

   }

   public static class PanelState {
      public float x;
      public float y;
      public boolean collapsed;

      PanelState(float var1, float var2) {
         this.x = var1;
         this.y = var2;
      }
   }
}
