package dev.vulxts.gui.picker;

import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.IconListSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1799;

public final class IconListGridModel implements PickerGrid {
   private final IconListSetting setting;
   private List cells;

   public IconListGridModel(IconListSetting setting) {
      this.setting = setting;
   }

   public String title() {
      return this.setting.getName();
   }

   public long activeCount() {
      return this.setting.enabledCount();
   }

   public List cells() {
      if (this.cells == null) {
         List out = new ArrayList(this.setting.entries().size());
         Iterator var2 = this.setting.entries().iterator();

         while(var2.hasNext()) {
            IconListSetting.Entry entry = (IconListSetting.Entry)var2.next();
            out.add(new EntryCell(entry));
         }

         this.cells = out;
      }

      return this.cells;
   }

   private static final class EntryCell implements PickerGrid.Cell {
      private final IconListSetting.Entry entry;
      private final class_1799 icon;

      EntryCell(IconListSetting.Entry entry) {
         this.entry = entry;
         this.icon = new class_1799(entry.icon());
      }

      public class_1799 icon() {
         return this.icon;
      }

      public String label() {
         return this.entry.label();
      }

      public boolean matches(String lowerQuery) {
         return this.entry.matches(lowerQuery);
      }

      public boolean tracked() {
         return true;
      }

      public boolean enabled() {
         return (Boolean)this.entry.enabled.get();
      }

      public boolean selected() {
         return (Boolean)this.entry.enabled.get();
      }

      public int color() {
         return (Integer)this.entry.color.get();
      }

      public void toggle() {
         this.entry.enabled.toggle();
      }

      public ColorSetting colorTarget() {
         return this.entry.color;
      }
   }
}
