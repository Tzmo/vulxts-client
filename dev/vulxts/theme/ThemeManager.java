package dev.vulxts.theme;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.vulxts.rt.Deobf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThemeManager {
   public static final int PINK = -49508;
   private final List themes = new ArrayList();
   private Theme current;

   public ThemeManager() {
      this.themes.add(new Theme("Slate", -9255492, false));
      this.themes.add(new Theme(Deobf.decrypt("&\u0003<N"), -49508, false));
      this.themes.add(new Theme(Deobf.decrypt("&\u001f Ud\u008d"), -5743361, false));
      this.themes.add(new Theme(Deobf.decrypt("4\u0006'@"), -11689985, false));
      this.themes.add(new Theme(Deobf.decrypt("$\u000f6"), -45715, false));
      this.themes.add(new Theme(Deobf.decrypt("3\u00077Wi\u0084\u0081"), -12654960, false));
      this.themes.add(new RainbowTheme());
      this.current = (Theme)this.themes.getFirst();
   }

   public Theme current() {
      return this.current;
   }

   public List getThemes() {
      return this.themes;
   }

   public void select(Theme var1) {
      if (this.themes.contains(var1)) {
         this.current = var1;
      }

   }

   public Theme addCustom(int var1) {
      int var2 = 1;
      Iterator var3 = this.themes.iterator();

      while(var3.hasNext()) {
         Theme var4 = (Theme)var3.next();
         if (var4.isCustom()) {
            ++var2;
         }
      }

      Theme var5 = new Theme("Custom " + var2, var1, true);
      this.themes.add(var5);
      return var5;
   }

   public void removeCustom(Theme var1) {
      if (var1.isCustom() && this.themes.remove(var1) && this.current == var1) {
         this.current = (Theme)this.themes.getFirst();
      }

   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      var1.addProperty(Deobf.decrypt("\u0015\u001f Wm\u0086\u0091"), this.current.getName());
      JsonArray var2 = new JsonArray();
      Iterator var3 = this.themes.iterator();

      while(var3.hasNext()) {
         Theme var4 = (Theme)var3.next();
         if (var4.isCustom()) {
            JsonObject var5 = new JsonObject();
            var5.addProperty(Deobf.decrypt("\u0018\u000b?@"), var4.getName());
            var5.addProperty(Deobf.decrypt("\u0017\t1@f\u009c"), var4.accent());
            var2.add(var5);
         }
      }

      var1.add(Deobf.decrypt("\u0015\u001f!Qg\u0085"), var2);
      return var1;
   }

   public void fromJson(JsonObject var1) {
      if (var1 != null) {
         this.themes.removeIf(Theme::isCustom);
         if (var1.has(Deobf.decrypt("\u0015\u001f!Qg\u0085"))) {
            Iterator var2 = var1.getAsJsonArray(Deobf.decrypt("\u0015\u001f!Qg\u0085")).iterator();

            while(var2.hasNext()) {
               JsonElement var3 = (JsonElement)var2.next();
               JsonObject var4 = var3.getAsJsonObject();
               this.themes.add(new Theme(var4.get(Deobf.decrypt("\u0018\u000b?@")).getAsString(), var4.get(Deobf.decrypt("\u0017\t1@f\u009c")).getAsInt(), true));
            }
         }

         if (var1.has(Deobf.decrypt("\u0015\u001f Wm\u0086\u0091"))) {
            String var5 = var1.get(Deobf.decrypt("\u0015\u001f Wm\u0086\u0091")).getAsString();
            Iterator var6 = this.themes.iterator();

            while(var6.hasNext()) {
               Theme var7 = (Theme)var6.next();
               if (var7.getName().equals(var5)) {
                  this.current = var7;
                  break;
               }
            }
         }
      }

   }
}
