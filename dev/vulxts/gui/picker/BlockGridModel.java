package dev.vulxts.gui.picker;

import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BlockListSetting;
import dev.vulxts.settings.ColorSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.IntSupplier;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public final class BlockGridModel implements PickerGrid {
   private static List allBlocks;
   private final BlockListSetting setting;
   private final IntSupplier defaultColor;
   private final String title;
   private List cells;

   public BlockGridModel(BlockListSetting setting, IntSupplier defaultColor, String title) {
      this.setting = setting;
      this.defaultColor = defaultColor;
      this.title = title;
   }

   private static List allBlocks() {
      if (allBlocks == null) {
         List list = new ArrayList();
         Iterator var1 = class_7923.field_41175.iterator();

         while(var1.hasNext()) {
            class_2248 block = (class_2248)var1.next();
            if (block != class_2246.field_10124 && block != class_2246.field_10543 && block != class_2246.field_10243) {
               list.add(block);
            }
         }

         allBlocks = list;
      }

      return allBlocks;
   }

   public String title() {
      return this.title;
   }

   public long activeCount() {
      return this.setting.enabledCount();
   }

   public List cells() {
      if (this.cells == null) {
         List out = new ArrayList(allBlocks().size());
         Iterator var2 = allBlocks().iterator();

         while(var2.hasNext()) {
            class_2248 block = (class_2248)var2.next();
            out.add(new BlockCell(block));
         }

         this.cells = out;
      }

      return this.cells;
   }

   private final class BlockCell implements PickerGrid.Cell {
      private final class_2248 block;
      private final String search;
      private class_1799 icon;

      BlockCell(class_2248 block) {
         this.block = block;
         class_2960 id = class_7923.field_41175.method_10221(block);
         String path = id != null ? id.method_12832() : Deobf.decrypt("");
         String ns = id != null ? id.method_12836() : Deobf.decrypt("");
         this.search = (path + " " + ns + " " + BlockListSetting.displayName(block)).toLowerCase(Locale.ROOT);
      }

      public class_1799 icon() {
         if (this.icon == null) {
            class_1792 item = this.block.method_8389();
            this.icon = new class_1799(item == class_1802.field_8162 ? class_1802.field_8077 : item);
         }

         return this.icon;
      }

      public String label() {
         return BlockListSetting.displayName(this.block);
      }

      public boolean matches(String lowerQuery) {
         return this.search.contains(lowerQuery);
      }

      public boolean tracked() {
         return BlockGridModel.this.setting.find(this.block) != null;
      }

      public boolean enabled() {
         BlockListSetting.Target t = BlockGridModel.this.setting.find(this.block);
         return t != null && (Boolean)t.enabled.get();
      }

      public boolean selected() {
         return BlockGridModel.this.setting.find(this.block) != null;
      }

      public int color() {
         BlockListSetting.Target t = BlockGridModel.this.setting.find(this.block);
         return t != null ? (Integer)t.color.get() : BlockGridModel.this.defaultColor.getAsInt();
      }

      public void toggle() {
         BlockListSetting.Target t = BlockGridModel.this.setting.find(this.block);
         if (t == null) {
            BlockGridModel.this.setting.add(this.block, true, BlockGridModel.this.defaultColor.getAsInt());
         } else {
            t.enabled.toggle();
         }

      }

      public ColorSetting colorTarget() {
         BlockListSetting.Target t = BlockGridModel.this.setting.find(this.block);
         if (t == null) {
            t = BlockGridModel.this.setting.add(this.block, true, BlockGridModel.this.defaultColor.getAsInt());
         }

         return t != null ? t.color : null;
      }
   }
}
