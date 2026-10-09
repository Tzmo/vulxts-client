package dev.vulxts.gui.panel;

import dev.vulxts.gui.ClickGuiState;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.render.nanovg.NVGIcons;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.theme.ThemeManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CategoryPanel extends Panel {
   private static final float ENTRY_GAP = 3.0F;
   private static final float ENTRY_INSET = 6.0F;
   private final Category category;
   private final List entries = new ArrayList();
   private boolean favouritesOnly;
   private String filter = Deobf.decrypt("");

   public void setFavouritesOnly(boolean var1) {
      this.favouritesOnly = var1;
   }

   public CategoryPanel(Category var1, ModuleManager var2, ThemeManager var3, ClickGuiState var4) {
      super(var3, var4.panel(var1.name()));
      this.category = var1;
      Iterator var5 = var2.inCategory(var1).iterator();

      while(var5.hasNext()) {
         Module var6 = (Module)var5.next();
         this.entries.add(new ModuleEntry(var6, var3, var4));
      }

   }

   public void setFilter(String var1) {
      this.filter = var1 == null ? Deobf.decrypt("") : var1.toLowerCase(Locale.ROOT).trim();
   }

   private List visibleEntries() {
      return this.entries.stream().filter((var1) -> {
         return !this.favouritesOnly || var1.isFavourite();
      }).filter((var1) -> {
         return var1.getModule().getName().toLowerCase(Locale.ROOT).contains(this.filter);
      }).sorted(Comparator.comparing((var0) -> {
         return !var0.isFavourite();
      })).toList();
   }

   protected String title() {
      return this.category.getDisplayName();
   }

   protected int icon() {
      return NVGIcons.get(this.category);
   }

   protected float contentHeight(NVGRenderer var1) {
      if (this.visibleEntries().isEmpty()) {
         return 36.0F;
      } else {
         float var2 = 12.0F;

         ModuleEntry var4;
         for(Iterator var3 = this.visibleEntries().iterator(); var3.hasNext(); var2 += var4.height(var1) + 3.0F) {
            var4 = (ModuleEntry)var3.next();
         }

         return var2 - 3.0F;
      }
   }

   protected void renderContent(NVGRenderer var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var2;
      if (this.visibleEntries().isEmpty()) {
         var1.text(this.favouritesOnly ? "No favourites here" : "No matches", this.ps.x + 12.0F, var2 + 12.0F, 11.0F, this.theme().textDisabled());
      }

      float var8 = 198.0F;

      float var11;
      for(Iterator var9 = this.visibleEntries().iterator(); var9.hasNext(); var7 += var11 + 3.0F) {
         ModuleEntry var10 = (ModuleEntry)var9.next();
         var11 = var10.height(var1);
         var10.setBounds(this.ps.x + 6.0F, var7, var8);
         if (var7 + var11 >= var5 - 20.0F && var7 <= var6 + 20.0F) {
            float var12 = this.edgeFade(var7, var7 + var11, var5, var6);
            var10.render(var1, var3, var4, var12);
         }
      }

   }

   public boolean mouseClicked(float var1, float var2, int var3) {
      Iterator var4 = this.visibleEntries().iterator();

      ModuleEntry var5;
      do {
         if (!var4.hasNext()) {
            return false;
         }

         var5 = (ModuleEntry)var4.next();
      } while(!var5.mouseClicked(var1, var2, var3));

      return true;
   }

   public void mouseDragged(float var1, float var2) {
      Iterator var3 = this.visibleEntries().iterator();

      while(var3.hasNext()) {
         ModuleEntry var4 = (ModuleEntry)var3.next();
         var4.mouseDragged(var1, var2);
      }

   }

   public void mouseReleased() {
      Iterator var1 = this.visibleEntries().iterator();

      while(var1.hasNext()) {
         ModuleEntry var2 = (ModuleEntry)var1.next();
         var2.mouseReleased();
      }

   }

   public boolean keyPressed(int var1) {
      Iterator var2 = this.visibleEntries().iterator();

      ModuleEntry var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (ModuleEntry)var2.next();
      } while(!var3.keyPressed(var1));

      return true;
   }

   public boolean charTyped(int var1) {
      Iterator var2 = this.visibleEntries().iterator();

      ModuleEntry var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (ModuleEntry)var2.next();
      } while(!var3.charTyped(var1));

      return true;
   }

   public boolean isListening() {
      Iterator var1 = this.visibleEntries().iterator();

      ModuleEntry var2;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         var2 = (ModuleEntry)var1.next();
      } while(!var2.isListening());

      return true;
   }
}
