package dev.vulxts.license;

import dev.vulxts.license.dev.vulxts.license.LicenseGuardVM.MAvvyFT;
import dev.vulxts.license.dev.vulxts.license.LicenseGuardVM.pCn;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Base64;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import org.slf4j.Logger;

public final class LicenseGuard {
   private static final String PRODUCT = "vulxts_client";
   private static final String PUBLIC_KEY = "TUkkYVMP7nb-g_XL6VMyy59I2U_LlHpH1o4bkOCuXTE";
   private static final String BOOTSTRAP = "assets/vulxts/activation.json";
   private static final Path CACHE = Path.of(System.getProperty("user.home"), ".vulxts", "license.cache");
   private static final long CHECK_INTERVAL_MS = 90000L;
   private static final long SERVER_CHECK_INTERVAL_MS = 30000L;
   private static final long SERVER_RETRY_INTERVAL_MS = 15000L;
   private static volatile long validUntilMs;
   private static volatile long nextIntegrityCheckMs;
   private static volatile long nextServerCheckMs;
   private static volatile String approvedDigest = "";
   private static volatile Logger activeLogger;
   private static volatile boolean serverCheckRunning;
   private static volatile boolean denied;

   private LicenseGuard() {
   }

   public static synchronized byte[] enforce(Logger var0) {
      activeLogger = var0;

      try {
         if (denied) {
            throw new ActivationRejectedException(403);
         } else {
            String var1 = fingerprint();
            String var2 = releaseDigest();
            String var3;
            if (Files.isRegularFile(CACHE, new LinkOption[0])) {
               try {
                  var3 = Files.readString(CACHE);
                  if (verifyEnvelope(var3, var1, var2)) {
                     approve(var3, var2);
                     checkpoint();
                     return var1.getBytes(StandardCharsets.UTF_8);
                  }
               } catch (Exception var4) {
                  if (var0 != null) {
                     var0.warn("Ignoring an invalid Vulxts licence cache.");
                  }
               }

               Files.deleteIfExists(CACHE);
            }

            var3 = requestGrant(var1, var2);
            approve(var3, var2);
            save(var3);
            checkpoint();
            return var1.getBytes(StandardCharsets.UTF_8);
         }
      } catch (ActivationRejectedException var5) {
         deny(var0);
         throw new IllegalStateException("This Vulxts Client licence has been revoked.", var5);
      } catch (Exception var6) {
         validUntilMs = 0L;
         approvedDigest = "";
         var0.error("Vulxts Client activation failed: {}", var6.getMessage());
         throw new IllegalStateException("Vulxts Client could not verify this licence. Log in and download a fresh copy, then check your internet connection.", var6);
      }
   }

   public static void checkpoint() {
      long var0 = System.currentTimeMillis();
      if (denied) {
         throw new SecurityException("This Vulxts Client licence has been revoked");
      } else if (validUntilMs <= var0 && activeLogger != null) {
         enforce(activeLogger);
      } else if (validUntilMs > var0 && !approvedDigest.isBlank()) {
         if (var0 >= nextIntegrityCheckMs) {
            Class var2 = LicenseGuard.class;
            synchronized(LicenseGuard.class) {
               var0 = System.currentTimeMillis();
               if (var0 >= nextIntegrityCheckMs) {
                  try {
                     String var3 = releaseDigest();
                     if (!MessageDigest.isEqual(var3.getBytes(StandardCharsets.UTF_8), approvedDigest.getBytes(StandardCharsets.UTF_8))) {
                        validUntilMs = 0L;
                        throw new SecurityException("Vulxts Client integrity check failed");
                     }

                     nextIntegrityCheckMs = var0 + 90000L;
                  } catch (SecurityException var5) {
                     throw var5;
                  } catch (Exception var6) {
                     validUntilMs = 0L;
                     throw new SecurityException("Vulxts Client integrity check failed", var6);
                  }
               }
            }
         }

         checkServerAsync();
      } else {
         throw new SecurityException("Vulxts Client licence is not active");
      }
   }

   private static void approve(String var0, String var1) {
      String var2 = decodedPayload(var0);
      validUntilMs = Long.parseLong(number(var2, "expiresAt")) * 1000L;
      approvedDigest = var1;
      nextIntegrityCheckMs = 0L;
   }

   private static String requestGrant(String var0, String var1) throws Exception {
      String var2 = resource("/assets/vulxts/activation.json");
      String var3 = field(var2, "endpoint");
      String var4 = field(var2, "activationToken");
      if (!MessageDigest.isEqual(field(var2, "publicKey").getBytes(StandardCharsets.UTF_8), "TUkkYVMP7nb-g_XL6VMyy59I2U_LlHpH1o4bkOCuXTE".getBytes(StandardCharsets.UTF_8))) {
         throw new SecurityException("Release signature mismatch");
      } else {
         String var5 = base64(random(24));
         String var6 = "{\"activationToken\":\"" + var4 + "\",\"device\":\"" + var0 + "\",\"nonce\":\"" + var5 + "\"}";
         HttpResponse var7 = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).build().send(HttpRequest.newBuilder(URI.create(var3)).timeout(Duration.ofSeconds(12L)).header("Content-Type", "application/json").POST(BodyPublishers.ofString(var6)).build(), BodyHandlers.ofString());
         if (var7.statusCode() != 200) {
            if (var7.statusCode() != 400 && var7.statusCode() != 401 && var7.statusCode() != 403) {
               throw new IOException("Activation service returned HTTP " + var7.statusCode());
            } else {
               throw new ActivationRejectedException(var7.statusCode());
            }
         } else {
            String var8 = (String)var7.body();
            if (var8 != null && !var8.isBlank() && var8.contains("\"payload\"") && var8.contains("\"signature\"")) {
               if (verifyEnvelope(var8, var0, var1) && json(decodedPayload(var8), "nonce").equals(var5)) {
                  return var8;
               } else {
                  throw new SecurityException("Invalid activation response");
               }
            } else {
               throw new IOException("Activation service returned an invalid response");
            }
         }
      }
   }

   private static void checkServerAsync() {
      long var0 = System.currentTimeMillis();
      Class var2 = LicenseGuard.class;
      synchronized(LicenseGuard.class) {
         if (serverCheckRunning || var0 < nextServerCheckMs || denied) {
            return;
         }

         serverCheckRunning = true;
         nextServerCheckMs = var0 + 30000L;
      }

      Thread.ofVirtual().name("vulxts-license-check").start(() -> {
         try {
            String var0 = fingerprint();
            String var18 = releaseDigest();
            String var2 = requestGrant(var0, var18);
            Class var3 = LicenseGuard.class;
            synchronized(LicenseGuard.class) {
               approve(var2, var18);
               save(var2);
            }
         } catch (ActivationRejectedException var14) {
            deny(activeLogger);
         } catch (Exception var15) {
            Class var1 = LicenseGuard.class;
            synchronized(LicenseGuard.class) {
               nextServerCheckMs = System.currentTimeMillis() + 15000L;
            }

            Logger var17 = activeLogger;
            if (var17 != null) {
               var17.warn("Vulxts Client could not refresh its licence yet: {}", var15.getMessage());
            }
         } finally {
            serverCheckRunning = false;
         }

      });
   }

   private static void save(String var0) throws Exception {
      Files.createDirectories(CACHE.getParent());
      Files.writeString(CACHE, var0, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
   }

   private static synchronized void deny(Logger var0) {
      denied = true;
      validUntilMs = 0L;
      approvedDigest = "";

      try {
         Files.deleteIfExists(CACHE);
      } catch (Exception var2) {
      }

      if (var0 != null) {
         var0.error("Vulxts Client licence was revoked.");
      }

   }

   static boolean verifyEnvelope(String var0, String var1, String var2) throws Exception {
      Object[] var3 = new Object[]{var0, var1, var2};
      Object var10000 = pCn.execute(-405389606, (Object)null, var3);
      return (boolean)(var10000 instanceof Boolean ? (Boolean)var10000 : (var10000 instanceof Character ? (Character)var10000 : ((Number)var10000).intValue()));
   }

   static String releaseDigest() throws Exception {
      Path var0 = Path.of(LicenseGuard.class.getProtectionDomain().getCodeSource().getLocation().toURI());
      if (!Files.isRegularFile(var0, new LinkOption[0])) {
         throw new SecurityException("Release container is unavailable");
      } else {
         return releaseDigest(var0);
      }
   }

   static String releaseDigest(Path var0) throws Exception {
      Object[] var1 = new Object[]{var0};
      return (String)MAvvyFT.execute(-510289430, (Object)null, var1);
   }

   static String fingerprint() throws Exception {
      Object[] var0 = new Object[0];
      return (String)pCn.execute(-369510846, (Object)null, var0);
   }

   static byte[] random(int var0) {
      byte[] var1 = new byte[var0];
      (new SecureRandom()).nextBytes(var1);
      return var1;
   }

   static String base64(byte[] var0) {
      return Base64.getUrlEncoder().withoutPadding().encodeToString(var0);
   }

   static String resource(String var0) throws Exception {
      InputStream var1 = LicenseGuard.class.getResourceAsStream(var0);

      String var2;
      try {
         if (var1 == null) {
            throw new SecurityException("This download is not activated");
         }

         var2 = new String(var1.readAllBytes(), StandardCharsets.UTF_8);
      } catch (Throwable var5) {
         if (var1 != null) {
            try {
               var1.close();
            } catch (Throwable var4) {
               var5.addSuppressed(var4);
            }
         }

         throw var5;
      }

      if (var1 != null) {
         var1.close();
      }

      return var2;
   }

   static String field(String var0, String var1) {
      return json(var0, var1);
   }

   static String decodedPayload(String var0) {
      Object[] var1 = new Object[]{var0};
      return (String)MAvvyFT.execute(1411901961, (Object)null, var1);
   }

   static String json(String var0, String var1) {
      Object[] var2 = new Object[]{var0, var1};
      return (String)pCn.execute(-1375225559, (Object)null, var2);
   }

   static String number(String var0, String var1) {
      Object[] var2 = new Object[]{var0, var1};
      return (String)MAvvyFT.execute(-24800153, (Object)null, var2);
   }

   // $FF: synthetic method
   private static String YhRTT(String var0) {
      return "\\\"" + var0 + "\\\"\\s*:\\s*\\\"([^\\\"]*)\\\"";
   }

   // $FF: synthetic method
   private static String jAcIp(String var0) {
      return "Missing " + var0;
   }

   // $FF: synthetic method
   private static Predicate YUk() {
      return (var0) -> {
         return !var0.isDirectory() && !"assets/vulxts/activation.json".equals(var0.getName());
      };
   }

   // $FF: synthetic method
   private static Function gyao() {
      return ZipEntry::getName;
   }

   // $FF: synthetic method
   private static String vChBIav(String var0) {
      return "\\\"" + var0 + "\\\"\\s*:\\s*(\\d+)";
   }

   // $FF: synthetic method
   private static String JvqMgCz(String var0) {
      return "Missing " + var0;
   }

   private static final class ActivationRejectedException extends SecurityException {
      ActivationRejectedException(int var1) {
         super("Activation was rejected (HTTP " + var1 + ")");
      }
   }
}
