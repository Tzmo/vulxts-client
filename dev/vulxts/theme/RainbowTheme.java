package dev.vulxts.theme;

import dev.vulxts.rt.Deobf;
import dev.vulxts.util.Colors;

public class RainbowTheme extends Theme {
   public RainbowTheme() {
      super(Deobf.decrypt("$\u000b;Kj\u0087\u0092"), -49508, false);
   }

   public int accent() {
      double seconds = (double)(System.nanoTime() % 1000000000000L) / 1.0E9;
      return Colors.hsvToRgb((float)(seconds * 36.0 % 360.0), 0.72F, 1.0F);
   }
}
