package dev.vulxts.spotify;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import java.util.HashMap;

public final class WindowsSpotify {
   private final User32 api = (User32)Native.load("user32", User32.class);
   private volatile Pointer spotifyWindow;

   private boolean isSpotify(Pointer var1) {
      IntByReference var2 = new IntByReference();
      this.api.GetWindowThreadProcessId(var1, var2);
      return var2.getValue() == 0 ? false : (Boolean)ProcessHandle.of(Integer.toUnsignedLong(var2.getValue())).flatMap((var0) -> {
         return var0.info().command();
      }).map(SpotifyWindowTitle::isSpotifyExecutable).orElse(false);
   }

   public SpotifyState read() {
      SpotifyState[] var1 = new SpotifyState[]{SpotifyState.INACTIVE};
      Pointer[] var2 = new Pointer[]{null};
      HashMap var3 = new HashMap();
      this.api.EnumWindows((var4, var5) -> {
         IntByReference var6 = new IntByReference();
         this.api.GetWindowThreadProcessId(var4, var6);
         if (var6.getValue() == 0) {
            return true;
         } else {
            char[] var7 = new char[2048];
            int var8 = this.api.GetWindowTextW(var4, var7, var7.length);
            if (var8 <= 0) {
               return true;
            } else {
               boolean var9 = (Boolean)var3.computeIfAbsent(var6.getValue(), (var0) -> {
                  return (Boolean)ProcessHandle.of(Integer.toUnsignedLong(var0)).flatMap((var0x) -> {
                     return var0x.info().command();
                  }).map(SpotifyWindowTitle::isSpotifyExecutable).orElse(false);
               });
               if (!var9) {
                  return true;
               } else {
                  SpotifyState var10 = SpotifyWindowTitle.parse(new String(var7, 0, var8), System.nanoTime());
                  if (var2[0] == null || var10.active()) {
                     var2[0] = var4;
                  }

                  if (var10.active()) {
                     var1[0] = var10;
                  }

                  return !var10.active();
               }
            }
         }
      }, (Pointer)null);
      this.spotifyWindow = var2[0];
      return var1[0];
   }

   public void command(int var1) {
      Pointer var2 = this.spotifyWindow;
      if (var2 != null && this.isSpotify(var2)) {
         this.api.PostMessageW(var2, 793, var2, Pointer.createConstant((long)var1 << 16));
      }

   }

   public interface User32 extends StdCallLibrary {
      boolean EnumWindows(WindowCallback var1, Pointer var2);

      int GetWindowThreadProcessId(Pointer var1, IntByReference var2);

      int GetWindowTextW(Pointer var1, char[] var2, int var3);

      boolean PostMessageW(Pointer var1, int var2, Pointer var3, Pointer var4);

      public interface WindowCallback extends StdCallLibrary.StdCallCallback {
         boolean invoke(Pointer var1, Pointer var2);
      }
   }
}
