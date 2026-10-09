package dev.vulxts.settings;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.vulxts.rt.Deobf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.class_1792;

public class IconListSetting extends Setting {
   private final Map byKey = new LinkedHashMap();

   public IconListSetting(String name, String description) {
      super(name, description, new ArrayList());
   }

   public Entry add(String key, String label, class_1792 icon, boolean enabled, int color) {
      Entry entry = new Entry(key, label, icon, enabled, color);
      ((List)this.value).add(entry);
      this.byKey.put(key, entry);
      return entry;
   }

   public List entries() {
      return (List)this.value;
   }

   public Entry get(String key) {
      return (Entry)this.byKey.get(key);
   }

   public boolean isEnabled(String key) {
      Entry e = (Entry)this.byKey.get(key);
      return e != null && (Boolean)e.enabled.get();
   }

   public int color(String key) {
      Entry e = (Entry)this.byKey.get(key);
      return e != null ? (Integer)e.color.get() : -1;
   }

   public int size() {
      return ((List)this.value).size();
   }

   public long enabledCount() {
      return ((List)this.value).stream().filter((e) -> {
         return (Boolean)e.enabled.get();
      }).count();
   }

   public JsonElement toJson() {
      JsonArray arr = new JsonArray();
      Iterator var2 = ((List)this.value).iterator();

      while(var2.hasNext()) {
         Entry e = (Entry)var2.next();
         JsonObject o = new JsonObject();
         o.addProperty(Deobf.decrypt("\u001d\u000f+"), e.key);
         o.addProperty(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081"), (Boolean)e.enabled.get());
         o.addProperty(Deobf.decrypt("\u0015\u0005>Jz"), (Number)e.color.get());
         arr.add(o);
      }

      return arr;
   }

   public void fromJson(JsonElement element) {
      if (element != null && element.isJsonArray()) {
         Iterator var2 = element.getAsJsonArray().iterator();

         while(var2.hasNext()) {
            JsonElement el = (JsonElement)var2.next();
            if (el.isJsonObject()) {
               JsonObject o = el.getAsJsonObject();
               if (o.has(Deobf.decrypt("\u001d\u000f+"))) {
                  Entry e = (Entry)this.byKey.get(o.get(Deobf.decrypt("\u001d\u000f+")).getAsString());
                  if (e != null) {
                     if (o.has(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081"))) {
                        e.enabled.set(o.get(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081")).getAsBoolean());
                     }

                     if (o.has(Deobf.decrypt("\u0015\u0005>Jz"))) {
                        e.color.set(o.get(Deobf.decrypt("\u0015\u0005>Jz")).getAsInt());
                     }
                  }
               }
            }
         }
      }

   }

   public static final class Entry {
      private final String key;
      private final String label;
      private final class_1792 icon;
      public final BooleanSetting enabled;
      public final ColorSetting color;

      Entry(String key, String label, class_1792 icon, boolean enabled, int color) {
         this.key = key;
         this.label = label;
         this.icon = icon;
         this.enabled = new BooleanSetting(Deobf.decrypt("3\u00043Gd\u008d\u0081"), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàŞħœũƿǡǑǻȖȥ"), enabled);
         this.color = new ColorSetting(label, Deobf.decrypt(">\u00035Md\u0081\u0082ÒàŞİŔŬƣƳ"), color);
      }

      public String key() {
         return this.key;
      }

      public String label() {
         return this.label;
      }

      public class_1792 icon() {
         return this.icon;
      }

      public boolean matches(String lowerQuery) {
         return this.label.toLowerCase(Locale.ROOT).contains(lowerQuery) || this.key.contains(lowerQuery);
      }
   }
}
