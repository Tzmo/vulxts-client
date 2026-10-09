package dev.vulxts.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public final class ConfigShareService {
   public static final String NETWORK_DISCLOSURE = "Vulxts Client config sharing: optional code export/import via vulxtsclient.org only.";
   private static final URI ORIGIN = URI.create("https://vulxtsclient.org");
   private static final HttpClient HTTP = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).build();
   private static final ConcurrentHashMap EXPORTED = new ConcurrentHashMap();
   private static final ConcurrentHashMap IMPORTED = new ConcurrentHashMap();

   private ConfigShareService() {
   }

   public static CompletableFuture export(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = (String)EXPORTED.get(var0);
         if (var1 != null) {
            return CompletableFuture.completedFuture(new Result(true, var1, (String)null));
         } else {
            JsonObject var2 = new JsonObject();
            var2.addProperty("config", var0);
            return post("/v2/configs/export", var2).thenApply((var1x) -> {
               if (!var1x.ok()) {
                  return var1x;
               } else {
                  try {
                     String var2x = JsonParser.parseString(var1x.config()).getAsJsonObject().get("code").getAsString();
                     EXPORTED.put(var0, var2x);
                     return new Result(true, var2x, (String)null);
                  } catch (RuntimeException var3) {
                     return new Result(false, "Config service returned an invalid code.", (String)null);
                  }
               }
            });
         }
      } else {
         return CompletableFuture.completedFuture(new Result(false, "Save a config before exporting.", (String)null));
      }
   }

   public static CompletableFuture importCode(String var0) {
      String var1 = var0 == null ? "" : var0.trim().toUpperCase(Locale.ROOT);
      if (!var1.matches("[A-Z0-9]{6}")) {
         return CompletableFuture.completedFuture(new Result(false, "Enter a six-character config code.", (String)null));
      } else {
         String var2 = (String)IMPORTED.get(var1);
         if (var2 != null) {
            return CompletableFuture.completedFuture(new Result(true, "Config imported.", var2));
         } else {
            JsonObject var3 = new JsonObject();
            var3.addProperty("code", var1);
            return post("/v2/configs/import", var3).thenApply((var1x) -> {
               if (!var1x.ok()) {
                  return var1x;
               } else {
                  try {
                     String var2x = JsonParser.parseString(var1x.config()).getAsJsonObject().get("config").getAsString();
                     IMPORTED.put(var1, var2x);
                     return new Result(true, "Config imported.", var2x);
                  } catch (RuntimeException var3) {
                     return new Result(false, "Config service returned invalid data.", (String)null);
                  }
               }
            });
         }
      }
   }

   private static CompletableFuture post(String var0, JsonObject var1) {
      HttpRequest var2 = HttpRequest.newBuilder(ORIGIN.resolve(var0)).timeout(Duration.ofSeconds(12L)).header("Content-Type", "application/json").POST(BodyPublishers.ofString(var1.toString())).build();
      return HTTP.sendAsync(var2, BodyHandlers.ofString()).handle((var0x, var1x) -> {
         if (var1x != null) {
            return new Result(false, "Config service is unavailable. Try again.", (String)null);
         } else if (var0x.statusCode() >= 200 && var0x.statusCode() < 300) {
            return new Result(true, "", (String)var0x.body());
         } else {
            try {
               String var2x = JsonParser.parseString((String)var0x.body()).getAsJsonObject().get("error").getAsString();
               return new Result(false, var2x, (String)null);
            } catch (RuntimeException var3) {
               return new Result(false, "Config service rejected the request.", (String)null);
            }
         }
      });
   }

   public static record Result(boolean ok, String message, String config) {
      public Result(boolean ok, String message, String config) {
         this.ok = ok;
         this.message = message;
         this.config = config;
      }

      public boolean ok() {
         return this.ok;
      }

      public String message() {
         return this.message;
      }

      public String config() {
         return this.config;
      }
   }
}
