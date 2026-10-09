package dev.vulxts.settings;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.vulxts.rt.Deobf;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class BlockListSetting extends Setting {
   public static final int DEFAULT_COLOR = -16711736;
   private final Set ids = new HashSet();

   public BlockListSetting(String name, String description) {
      super(name, description, new ArrayList());
   }

   public List targets() {
      return (List)this.value;
   }

   public int size() {
      return ((List)this.value).size();
   }

   public long enabledCount() {
      return ((List)this.value).stream().filter((t) -> {
         return (Boolean)t.enabled.get();
      }).count();
   }

   public boolean contains(class_2960 id) {
      return this.ids.contains(id);
   }

   public Target find(class_2248 block) {
      if (block == null) {
         return null;
      } else {
         class_2960 id = class_7923.field_41175.method_10221(block);
         if (id != null && this.ids.contains(id)) {
            Iterator var3 = ((List)this.value).iterator();

            Target t;
            do {
               if (!var3.hasNext()) {
                  return null;
               }

               t = (Target)var3.next();
            } while(!t.id().equals(id));

            return t;
         } else {
            return null;
         }
      }
   }

   public boolean isActive(class_2248 block) {
      Target t = this.find(block);
      return t != null && (Boolean)t.enabled.get();
   }

   public Target add(class_2248 block, boolean enabled, int color) {
      if (block != null && block != class_2246.field_10124) {
         class_2960 id = class_7923.field_41175.method_10221(block);
         if (id != null && !this.ids.contains(id)) {
            Target target = new Target(id, block, enabled, color);
            ((List)this.value).add(target);
            this.ids.add(id);
            return target;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public void remove(Target target) {
      if (((List)this.value).remove(target)) {
         this.ids.remove(target.id());
      }

   }

   public void clear() {
      ((List)this.value).clear();
      this.ids.clear();
   }

   public List searchRegistry(String rawQuery, int limit) {
      String q = rawQuery == null ? Deobf.decrypt("") : rawQuery.trim().toLowerCase(Locale.ROOT);
      List out = new ArrayList();
      if (!q.isEmpty() && limit > 0) {
         Iterator var5 = class_7923.field_41175.iterator();

         while(var5.hasNext()) {
            class_2248 block = (class_2248)var5.next();
            if (block != class_2246.field_10124 && block != class_2246.field_10543 && block != class_2246.field_10243) {
               class_2960 id = class_7923.field_41175.method_10221(block);
               if (id != null && !this.ids.contains(id)) {
                  String path = id.method_12832().toLowerCase(Locale.ROOT);
                  String ns = id.method_12836().toLowerCase(Locale.ROOT);
                  String name = displayName(block).toLowerCase(Locale.ROOT);
                  if (path.contains(q) || ns.contains(q) || name.contains(q)) {
                     out.add(block);
                     if (out.size() >= limit) {
                        break;
                     }
                  }
               }
            }
         }

         return out;
      } else {
         return out;
      }
   }

   public static String displayName(class_2248 block) {
      try {
         return block.method_9518().getString();
      } catch (Throwable var3) {
         class_2960 id = class_7923.field_41175.method_10221(block);
         return id != null ? id.method_12832() : Deobf.decrypt("\u0014\u0006=Fc");
      }
   }

   public void seedDefaults() {
      this.clear();
      this.add(class_2246.field_10442, true, -16711736);
      this.add(class_2246.field_29029, true, -16711736);
      this.add(class_2246.field_10013, false, -16711868);
      this.add(class_2246.field_29220, false, -16711868);
      this.add(class_2246.field_22109, true, -39356);
      this.add(class_2246.field_23077, false, -10496);
      this.add(class_2246.field_10571, false, -10496);
      this.add(class_2246.field_29026, false, -10496);
      this.add(class_2246.field_10212, false, -3618616);
      this.add(class_2246.field_29027, false, -3618616);
      this.add(class_2246.field_10418, false, -12303292);
      this.add(class_2246.field_29219, false, -12303292);
      this.add(class_2246.field_27120, false, -4689101);
      this.add(class_2246.field_29221, false, -4689101);
      this.add(class_2246.field_10090, false, -12490271);
      this.add(class_2246.field_29028, false, -12490271);
      this.add(class_2246.field_10080, false, -65536);
      this.add(class_2246.field_29030, false, -65536);
      this.add(class_2246.field_10260, false, -7846657);
      this.add(class_2246.field_10398, false, -12255250);
      this.add(class_2246.field_10034, false, -22016);
   }

   public JsonElement toJson() {
      JsonArray arr = new JsonArray();
      Iterator var2 = ((List)this.value).iterator();

      while(var2.hasNext()) {
         Target t = (Target)var2.next();
         JsonObject o = new JsonObject();
         o.addProperty(Deobf.decrypt("\u001f\u000e"), t.id().toString());
         o.addProperty(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081"), (Boolean)t.enabled.get());
         o.addProperty(Deobf.decrypt("\u0015\u0005>Jz"), (Number)t.color.get());
         arr.add(o);
      }

      return arr;
   }

   public void fromJson(JsonElement element) {
      if (element != null && element.isJsonArray()) {
         this.clear();
         Iterator var2 = element.getAsJsonArray().iterator();

         while(true) {
            JsonObject o;
            class_2248 block;
            do {
               do {
                  class_2960 id;
                  while(true) {
                     do {
                        JsonElement el;
                        do {
                           if (!var2.hasNext()) {
                              return;
                           }

                           el = (JsonElement)var2.next();
                        } while(!el.isJsonObject());

                        o = el.getAsJsonObject();
                     } while(!o.has(Deobf.decrypt("\u001f\u000e")));

                     try {
                        id = class_2960.method_60654(o.get(Deobf.decrypt("\u001f\u000e")).getAsString());
                        break;
                     } catch (Exception var8) {
                     }
                  }

                  block = (class_2248)class_7923.field_41175.method_63535(id);
               } while(block == null);
            } while(block == class_2246.field_10124);

            boolean en = !o.has(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081")) || o.get(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081")).getAsBoolean();
            int color = o.has(Deobf.decrypt("\u0015\u0005>Jz")) ? o.get(Deobf.decrypt("\u0015\u0005>Jz")).getAsInt() : -16711736;
            this.add(block, en, color);
         }
      }
   }

   public static final class Target {
      private final class_2960 id;
      private final class_2248 block;
      public final BooleanSetting enabled;
      public final ColorSetting color;

      Target(class_2960 id, class_2248 block, boolean enabled, int color) {
         this.id = id;
         this.block = block;
         this.enabled = new BooleanSetting(Deobf.decrypt("3\u00043Gd\u008d\u0081"), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàŞħœũƿǡǇǮȉȣɁ"), enabled);
         this.color = new ColorSetting(BlockListSetting.displayName(block), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàŞİŔŬƣƳ"), color);
      }

      public class_2960 id() {
         return this.id;
      }

      public class_2248 block() {
         return this.block;
      }

      public String label() {
         return this.color.getName();
      }
   }
}
