package dev.vulxts.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.vulxts.VulxtsClient;
import dev.vulxts.rt.Deobf;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import net.fabricmc.loader.api.FabricLoader;

public class ConfigStore {
   public static final int SLOT_COUNT = 5;
   public static final int CONFIG_VERSION = 1;
   public static final String FORMAT = "vulxtsclient-config";
   private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
   public static volatile boolean applying;
   private final ConfigManager config;
   private final Path dir;
   private final Slot[] slots = new Slot[5];
   private int active = -1;

   public ConfigStore(ConfigManager var1) {
      this.config = var1;
      this.dir = FabricLoader.getInstance().getConfigDir().resolve(Deobf.decrypt("\u0000\u001f>]|\u009b\u0086ÖýěĽŏĭƯƮǋǤȏȧə"));

      for(int var2 = 0; var2 < 5; ++var2) {
         this.slots[var2] = new Slot(var2);
      }

   }

   public static String defaultName(int var0) {
      return "Config " + (var0 + 1);
   }

   public Slot slot(int var1) {
      return this.slots[var1];
   }

   public Slot[] slots() {
      return this.slots;
   }

   public int activeIndex() {
      return this.active;
   }

   public Path directory() {
      return this.dir;
   }

   public void loadAll() {
      for(int var2 = 0; var2 < 5; ++var2) {
         this.refreshSlot(var2);
      }

      JsonObject var3 = this.readJson(this.dir.resolve(Deobf.decrypt("\u001f\u00046@pÆ\u008fÉûĐ")));
      int var1;
      if (var3 != null && var3.has(Deobf.decrypt("\u0017\t&L~\u008d")) && (var1 = var3.get(Deobf.decrypt("\u0017\t&L~\u008d")).getAsInt()) >= 0 && var1 < 5 && this.slots[var1].filled) {
         this.active = var1;
      }

   }

   private void refreshSlot(int var1) {
      Slot var2 = this.slots[var1];
      JsonObject var3 = this.readJson(this.slotPath(var1));
      JsonObject var4 = this.extractState(var3);
      if (var4 == null) {
         var2.filled = false;
         var2.savedAt = 0L;
         var2.name = defaultName(var1);
      } else {
         var2.filled = true;
         var2.name = var3.has(Deobf.decrypt("\u0018\u000b?@")) && !var3.get(Deobf.decrypt("\u0018\u000b?@")).getAsString().isBlank() ? var3.get(Deobf.decrypt("\u0018\u000b?@")).getAsString() : defaultName(var1);
         var2.savedAt = var3.has(Deobf.decrypt("\u0005\u000b$@l©\u0091")) ? var3.get(Deobf.decrypt("\u0005\u000b$@l©\u0091")).getAsLong() : 0L;
      }

   }

   public boolean save(int var1) {
      Slot var2 = this.slots[var1];
      JsonObject var3 = new JsonObject();
      var3.addProperty(Deobf.decrypt("\u0010\u0005 Hi\u009c"), Deobf.decrypt("\u0000\u001f>]|\u009b\u0086ÖýěĽŏĭƯƮǋǤȏȧ"));
      var3.addProperty(Deobf.decrypt("\u0000\u000f Va\u0087\u008b"), 1);
      var3.addProperty(Deobf.decrypt("\u0018\u000b?@"), var2.name);
      var3.addProperty(Deobf.decrypt("\u0005\u000b$@l©\u0091"), System.currentTimeMillis());
      var3.addProperty(Deobf.decrypt("\u0015\u0006;@f\u009c"), Deobf.decrypt("GDd\u000b:"));
      var3.add(Deobf.decrypt("\u0005\u001e3Qm"), this.config.captureState());
      if (!this.write(this.slotPath(var1), var3)) {
         return false;
      } else {
         this.refreshSlot(var1);
         return true;
      }
   }

   public boolean activate(int var1) {
      JsonObject var2 = this.extractState(this.readJson(this.slotPath(var1)));
      if (var2 == null) {
         return false;
      } else {
         applying = true;

         try {
            this.config.applyState(var2);
         } finally {
            applying = false;
         }

         this.active = var1;
         this.writeIndex();
         return true;
      }
   }

   public boolean delete(int var1) {
      try {
         Files.deleteIfExists(this.slotPath(var1));
      } catch (IOException var3) {
         VulxtsClient.LOGGER.error(Deobf.decrypt("0\u000b;Im\u008cÅÎûŞķŞŬƩƵǀƢȅȯɄɕʉʨʐˑ̘ͻ͖̱ΔΧ"), this.slotPath(var1).getFileName(), var3);
         return false;
      }

      if (this.active == var1) {
         this.active = -1;
         this.writeIndex();
      }

      this.refreshSlot(var1);
      return true;
   }

   public boolean rename(int var1, String var2) {
      Slot var3 = this.slots[var1];
      String var4 = this.sanitizeName(var2);
      if (var4.isEmpty()) {
         var4 = defaultName(var1);
      }

      var3.name = var4;
      if (!var3.filled) {
         return true;
      } else {
         JsonObject var5 = this.readJson(this.slotPath(var1));
         if (var5 == null) {
            return false;
         } else {
            var5.addProperty(Deobf.decrypt("\u0018\u000b?@"), var4);
            return this.write(this.slotPath(var1), var5);
         }
      }
   }

   public String export(int var1) {
      JsonObject var2 = this.readJson(this.slotPath(var1));
      return this.extractState(var2) == null ? null : GSON.toJson(var2);
   }

   public ImportResult importInto(int var1, String var2) {
      if (var2 != null && !var2.isBlank()) {
         JsonObject var3;
         try {
            var3 = JsonParser.parseString(var2).getAsJsonObject();
         } catch (Exception var8) {
            return new ImportResult(false, Deobf.decrypt("8\u0005&\u0005~\u0089\u0089ÓðŞİŔŮƪƨǂƢȬȓɥɽ"));
         }

         if (var3.has(Deobf.decrypt("\u0000\u000f Va\u0087\u008b")) && var3.get(Deobf.decrypt("\u0000\u000f Va\u0087\u008b")).isJsonPrimitive() && var3.get(Deobf.decrypt("\u0000\u000f Va\u0087\u008b")).getAsInt() > 1) {
            return new ImportResult(false, Deobf.decrypt("5\u0005<Ca\u008fÅÓçŞĵŉůơǡǄƢȈȥɝɖʒ˯˓˛̘Ͳͥ͝"));
         } else {
            JsonObject var4 = this.extractState(var3);
            if (var4 == null) {
               return new ImportResult(false, Deobf.decrypt("8\u0005rFg\u0086\u0083ÓóŞķŚŴƭǡǃǭȓȮɎ"));
            } else {
               Slot var5 = this.slots[var1];
               String var6 = var3.has(Deobf.decrypt("\u0018\u000b?@")) && !var3.get(Deobf.decrypt("\u0018\u000b?@")).getAsString().isBlank() ? this.sanitizeName(var3.get(Deobf.decrypt("\u0018\u000b?@")).getAsString()) : var5.name;
               JsonObject var7 = new JsonObject();
               var7.addProperty(Deobf.decrypt("\u0010\u0005 Hi\u009c"), Deobf.decrypt("\u0000\u001f>]|\u009b\u0086ÖýěĽŏĭƯƮǋǤȏȧ"));
               var7.addProperty(Deobf.decrypt("\u0000\u000f Va\u0087\u008b"), 1);
               var7.addProperty(Deobf.decrypt("\u0018\u000b?@"), var6);
               var7.addProperty(Deobf.decrypt("\u0005\u000b$@l©\u0091"), var3.has(Deobf.decrypt("\u0005\u000b$@l©\u0091")) ? var3.get(Deobf.decrypt("\u0005\u000b$@l©\u0091")).getAsLong() : System.currentTimeMillis());
               if (var3.has(Deobf.decrypt("\u0015\u0006;@f\u009c"))) {
                  var7.addProperty(Deobf.decrypt("\u0015\u0006;@f\u009c"), var3.get(Deobf.decrypt("\u0015\u0006;@f\u009c")).getAsString());
               }

               var7.add(Deobf.decrypt("\u0005\u001e3Qm"), var4);
               if (!this.write(this.slotPath(var1), var7)) {
                  return new ImportResult(false, Deobf.decrypt("5\u0005'Il\u0086ÂÎ´ĉġŒŴƩǡǑǪȃɠəɟʏʻʐˑ̘ͻ͖"));
               } else {
                  this.refreshSlot(var1);
                  return new ImportResult(true, "Imported \"" + var5.name + "\"");
               }
            }
         }
      } else {
         return new ImportResult(false, Deobf.decrypt("5\u0006;Uj\u0087\u0084ÈðŞĺňĠƩƬǕǶȟ"));
      }
   }

   private JsonObject extractState(JsonObject var1) {
      if (var1 == null) {
         return null;
      } else if (var1.has(Deobf.decrypt("\u0005\u001e3Qm")) && var1.get(Deobf.decrypt("\u0005\u001e3Qm")).isJsonObject()) {
         return var1.getAsJsonObject(Deobf.decrypt("\u0005\u001e3Qm"));
      } else {
         return var1.has(Deobf.decrypt("\u001b\u00056Pd\u008d\u0096")) && var1.get(Deobf.decrypt("\u001b\u00056Pd\u008d\u0096")).isJsonObject() ? var1 : null;
      }
   }

   private Path slotPath(int var1) {
      return this.dir.resolve("slot" + (var1 + 1) + ".json");
   }

   private void writeIndex() {
      JsonObject var1 = new JsonObject();
      var1.addProperty(Deobf.decrypt("\u0017\t&L~\u008d"), this.active);
      this.write(this.dir.resolve(Deobf.decrypt("\u001f\u00046@pÆ\u008fÉûĐ")), var1);
   }

   private JsonObject readJson(Path var1) {
      if (!Files.exists(var1, new LinkOption[0])) {
         return null;
      } else {
         try {
            return JsonParser.parseString(Files.readString(var1)).getAsJsonObject();
         } catch (Exception var3) {
            VulxtsClient.LOGGER.warn(Deobf.decrypt("?\r<Jz\u0081\u008bÝ´ċĽŉťƭƥǄǠȊȥȊɐʏʡ˖˞̷̖͕\u0378\u0383οΕϨϝ"), var1.getFileName(), var3);
            return null;
         }
      }
   }

   private boolean write(Path var1, JsonObject var2) {
      try {
         Files.createDirectories(this.dir);
         Files.writeString(var1, GSON.toJson(var2));
         return true;
      } catch (IOException var4) {
         VulxtsClient.LOGGER.error(Deobf.decrypt("0\u000b;Im\u008cÅÎûŞĤŉũƸƤƅǡȉȮɌɚʇ˯˖˞̝Ͳ̓ͪΒ"), var1.getFileName(), var4);
         return false;
      }
   }

   private String sanitizeName(String var1) {
      if (var1 == null) {
         return Deobf.decrypt("");
      } else {
         String var2 = var1.replaceAll(Deobf.decrypt("-6 yf´\u0091ç"), Deobf.decrypt("V")).trim();
         return var2.length() > 24 ? var2.substring(0, 24) : var2;
      }
   }

   public static final class Slot {
      private final int index;
      private String name;
      private boolean filled;
      private long savedAt;

      Slot(int var1) {
         this.index = var1;
         this.name = ConfigStore.defaultName(var1);
      }

      public int index() {
         return this.index;
      }

      public String name() {
         return this.name;
      }

      public boolean filled() {
         return this.filled;
      }

      public long savedAt() {
         return this.savedAt;
      }
   }

   public static record ImportResult(boolean ok, String message) {
      public ImportResult(boolean ok, String message) {
         this.ok = ok;
         this.message = message;
      }

      public boolean ok() {
         return this.ok;
      }

      public String message() {
         return this.message;
      }
   }
}
