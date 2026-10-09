package dev.vulxts.gui.picker;

import dev.vulxts.settings.ColorSetting;
import java.util.List;
import net.minecraft.class_1799;

public interface PickerGrid {
   String title();

   long activeCount();

   List cells();

   public interface Cell {
      class_1799 icon();

      String label();

      boolean matches(String var1);

      boolean tracked();

      boolean enabled();

      boolean selected();

      int color();

      void toggle();

      ColorSetting colorTarget();
   }
}
