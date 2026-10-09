package dev.vulxts.spotify;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class SpotifyMediaBridge {
   private final Path directory = Files.createTempDirectory("vulxts-spotify-");
   private final Path executable;
   private final Path artwork;
   private volatile Process process;
   private BufferedWriter input;
   private BlockingQueue responses;
   private byte[] lastArt = new byte[0];
   private int version;

   public SpotifyMediaBridge() throws IOException {
      this.executable = this.directory.resolve("SpotifyMediaBridge.exe");
      this.artwork = this.directory.resolve("cover.img");
      this.directory.toFile().deleteOnExit();
      this.executable.toFile().deleteOnExit();
      this.artwork.toFile().deleteOnExit();
      InputStream var1 = this.getClass().getResourceAsStream("/assets/vulxtsclient/native/SpotifyMediaBridge.exe");

      try {
         if (var1 == null) {
            throw new IOException("Bundled media helper missing");
         }

         Files.copy(var1, this.executable, new CopyOption[0]);
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

   }

   private synchronized void start() throws IOException {
      if (this.process == null || !this.process.isAlive()) {
         Process var1 = (new ProcessBuilder(new String[]{this.executable.toString()})).redirectError(Redirect.DISCARD).start();
         this.process = var1;
         this.input = new BufferedWriter(new OutputStreamWriter(var1.getOutputStream(), StandardCharsets.UTF_8));
         ArrayBlockingQueue var2 = new ArrayBlockingQueue(1);
         this.responses = var2;
         Thread var3 = new Thread(() -> {
            try {
               BufferedReader var2xx = new BufferedReader(new InputStreamReader(var1.getInputStream(), StandardCharsets.UTF_8));

               try {
                  StringBuilder var3x = new StringBuilder();

                  int var4;
                  while((var4 = var2xx.read()) >= 0) {
                     if (var4 == 10) {
                        if (!var2.offer(var3x.toString())) {
                           break;
                        }

                        var3x.setLength(0);
                     } else if (var4 != 13) {
                        if (var3x.length() >= 2100000) {
                           break;
                        }

                        var3x.append((char)var4);
                     }
                  }
               } catch (Throwable var11) {
                  try {
                     var2xx.close();
                  } catch (Throwable var10) {
                     var11.addSuppressed(var10);
                  }

                  throw var11;
               }

               var2xx.close();
            } catch (IOException var12) {
            } finally {
               var1.destroyForcibly();
            }

         }, "Vulxts-Spotify-metadata");
         var3.setDaemon(true);
         var3.start();
      }

   }

   public SpotifyState read() throws IOException, InterruptedException {
      this.start();
      this.input.write("poll\n");
      this.input.flush();
      String var1 = (String)this.responses.poll(5L, TimeUnit.SECONDS);
      if (var1 == null) {
         this.close();
         throw new IOException("Media helper timeout");
      } else {
         JsonObject var2 = JsonParser.parseString(var1).getAsJsonObject();
         if (var2.has("active") && var2.get("active").getAsBoolean()) {
            byte[] var3 = var2.has("artwork") ? Base64.getDecoder().decode(var2.get("artwork").getAsString()) : new byte[0];
            if (var3.length > 1500000) {
               throw new IOException("Artwork too large");
            } else {
               if (!Arrays.equals(var3, this.lastArt)) {
                  if (var3.length > 0) {
                     Path var4 = this.directory.resolve("cover.tmp");
                     var4.toFile().deleteOnExit();
                     Files.write(var4, var3, new OpenOption[0]);
                     Files.move(var4, this.artwork, StandardCopyOption.REPLACE_EXISTING);
                  }

                  this.lastArt = var3;
                  ++this.version;
               }

               long var8 = Math.max(0L, var2.get("duration").getAsLong());
               long var6 = Math.max(0L, var2.get("position").getAsLong());
               return new SpotifyState(true, var2.get("title").getAsString(), var2.get("artist").getAsString(), var8 > 0L ? Math.min(var6, var8) : var6, var8, var2.get("playing").getAsBoolean(), false, var3.length == 0 ? 0 : this.version, -1, System.nanoTime());
            }
         } else {
            return SpotifyState.INACTIVE;
         }
      }
   }

   public Path artPath() {
      return this.artwork;
   }

   public synchronized void close() {
      Process var1 = this.process;
      this.process = null;
      if (var1 != null) {
         var1.destroyForcibly();
      }

   }
}
