package dev.vulxts.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Module;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.Setting;
import dev.vulxts.theme.ThemeManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.fabricmc.loader.api.FabricLoader;

public class ConfigManager {
   private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
   private final Path file = FabricLoader.getInstance().getConfigDir().resolve(Deobf.decrypt("\u0000\u001f>]|\u009b\u0086ÖýěĽŏĮƦƲǊǬ"));
   private final ModuleManager modules;
   private final ThemeManager themes;
   private final Map sections = new LinkedHashMap();

   public ConfigManager(ModuleManager var1, ThemeManager var2) {
      this.modules = var1;
      this.themes = var2;
   }

   public void addSection(String var1, Supplier var2, Consumer var3) {
      this.sections.put(var1, new Section(var2, var3));
   }

   public JsonObject captureState() {
      JsonObject var1 = new JsonObject();
      var1.add(Deobf.decrypt("\u0002\u00027Hm"), this.themes.toJson());
      JsonObject var2 = new JsonObject();
      Iterator var3 = this.modules.all().iterator();

      while(var3.hasNext()) {
         Module var4 = (Module)var3.next();
         JsonObject var5 = new JsonObject();
         var5.addProperty(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081"), var4.isEnabled());
         var5.add(Deobf.decrypt("\u001d\u000f+Ga\u0086\u0081"), var4.getKeybind().toJson());
         JsonObject var6 = new JsonObject();
         Iterator var7 = var4.getSettings().iterator();

         while(var7.hasNext()) {
            Setting var8 = (Setting)var7.next();
            var6.add(var8.getName(), var8.toJson());
         }

         var5.add(Deobf.decrypt("\u0005\u000f&Qa\u0086\u0082É"), var6);
         var2.add(var4.getName() + "@" + var4.getCategory().name(), var5);
      }

      var1.add(Deobf.decrypt("\u001b\u00056Pd\u008d\u0096"), var2);
      var3 = this.sections.entrySet().iterator();

      while(var3.hasNext()) {
         Map.Entry var10 = (Map.Entry)var3.next();
         var1.add((String)var10.getKey(), (JsonElement)((Section)var10.getValue()).save().get());
      }

      return var1;
   }

   public void applyState(JsonObject var1) {
      if (var1 != null) {
         if (var1.has(Deobf.decrypt("\u0002\u00027Hm")) && var1.get(Deobf.decrypt("\u0002\u00027Hm")).isJsonObject()) {
            this.themes.fromJson(var1.getAsJsonObject(Deobf.decrypt("\u0002\u00027Hm")));
         }

         if (var1.has(Deobf.decrypt("\u001b\u00056Pd\u008d\u0096")) && var1.get(Deobf.decrypt("\u001b\u00056Pd\u008d\u0096")).isJsonObject()) {
            JsonObject var2 = var1.getAsJsonObject(Deobf.decrypt("\u001b\u00056Pd\u008d\u0096"));
            Iterator var3 = this.modules.all().iterator();

            label75:
            while(true) {
               Module var4;
               JsonObject var6;
               JsonObject var5;
               do {
                  do {
                     if (!var3.hasNext()) {
                        break label75;
                     }

                     var4 = (Module)var3.next();
                     String var10001 = var4.getName();
                     var6 = var2.getAsJsonObject(var10001 + "@" + var4.getCategory().name());
                     if (var6 == null && var4.getName().equals("JumpCircles")) {
                        var6 = var2.getAsJsonObject("VulxtsJumpCircles@" + var4.getCategory().name());
                     }
                  } while(var6 == null);

                  if (var6.has(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081")) && var6.get(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081")).getAsBoolean() != var4.isEnabled()) {
                     var4.setEnabled(var6.get(Deobf.decrypt("\u0013\u00043Gd\u008d\u0081")).getAsBoolean());
                  }

                  if (var6.has(Deobf.decrypt("\u001d\u000f+Ga\u0086\u0081"))) {
                     var4.getKeybind().fromJson(var6.get(Deobf.decrypt("\u001d\u000f+Ga\u0086\u0081")));
                  }
               } while((var5 = var6.getAsJsonObject(Deobf.decrypt("\u0005\u000f&Qa\u0086\u0082É"))) == null);

               Iterator var7 = var4.getSettings().iterator();

               while(var7.hasNext()) {
                  Setting var8 = (Setting)var7.next();
                  if (var5.has(var8.getName())) {
                     var8.fromJson(var5.get(var8.getName()));
                  }
               }
            }
         }

         Iterator var9 = this.sections.entrySet().iterator();

         while(var9.hasNext()) {
            Map.Entry var10 = (Map.Entry)var9.next();
            if (var1.has((String)var10.getKey()) && var1.get((String)var10.getKey()).isJsonObject()) {
               ((Section)var10.getValue()).load().accept(var1.getAsJsonObject((String)var10.getKey()));
            }
         }
      }

   }

   public synchronized void save() {
      try {
         Files.createDirectories(this.file.getParent());
         Files.writeString(this.file, GSON.toJson(this.captureState()));
      } catch (IOException var2) {
         VulxtsClient.LOGGER.error(Deobf.decrypt("0\u000b;Im\u008cÅÎûŞĠŚŶƩǡǆǭȈȦɃɔ"), var2);
      }

   }

   public synchronized void load() {
      if (Files.exists(this.file, new LinkOption[0])) {
         JsonObject var1;
         try {
            var1 = JsonParser.parseString(Files.readString(this.file)).getAsJsonObject();
         } catch (Exception var3) {
            VulxtsClient.LOGGER.error(Deobf.decrypt("0\u000b;Im\u008cÅÎûŞġŞšƨǡǆǭȈȦɃɔˌ˯˅˄̘\u0379͔̱\u038bοϓϲϕБХц"), var3);
            return;
         }

         this.applyState(var1);
      }

   }

   public static record Section(Supplier save, Consumer load) {
      public Section(Supplier save, Consumer load) {
         this.save = save;
         this.load = load;
      }

      public Supplier save() {
         return this.save;
      }

      public Consumer load() {
         return this.load;
      }
   }
}
