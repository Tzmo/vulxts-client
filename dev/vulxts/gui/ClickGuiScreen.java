package dev.vulxts.gui;

import dev.vulxts.VulxtsClient;
import dev.vulxts.gui.config.ConfigPanel;
import dev.vulxts.gui.panel.CategoryPanel;
import dev.vulxts.gui.panel.Panel;
import dev.vulxts.gui.panel.ThemesPanel;
import dev.vulxts.gui.picker.BlockGridModel;
import dev.vulxts.gui.picker.IconListGridModel;
import dev.vulxts.module.Category;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.module.Modules;
import dev.vulxts.module.impl.BlockEspModule;
import dev.vulxts.render.BlurHook;
import dev.vulxts.render.NvgDrawable;
import dev.vulxts.render.OverlayRenderer;
import dev.vulxts.render.anim.Animation;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.settings.BlockListSetting;
import dev.vulxts.settings.IconListSetting;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;

public class ClickGuiScreen extends class_437 implements NvgDrawable {
   private static final ClickGuiState STATE = new ClickGuiState();
   private final List panels;
   private final Animation openAnim;
   private boolean closing;
   private final ConfigPanel configPanel;
   private static final float FIDGET_W = 118.0F;
   private static final float FIDGET_H = 28.0F;
   private boolean fidgetHovered;
   private static final float SEARCH_W = 280.0F;
   private static final float SEARCH_H = 32.0F;
   private final StringBuilder search;
   private boolean searchFocused;
   private boolean favouritesOnly;
   private Panel dragging;
   private float dragOffsetX;
   private float dragOffsetY;
   private float pressX;
   private float pressY;
   private boolean dragMoved;
   private Panel pressedContentPanel;
   private final class_437 parent;

   public ClickGuiScreen() {
      this((class_437)null);
   }

   public ClickGuiScreen(class_437 var1) {
      super(class_2561.method_43470("Vulxts Client"));
      this.panels = new ArrayList();
      this.openAnim = new Animation(180.0F, 0.0F);
      this.configPanel = new ConfigPanel();
      this.search = new StringBuilder();
      this.parent = var1;
      STATE.ensureDefaultLayout(OverlayRenderer.uiWidth(), OverlayRenderer.uiHeight());
      ModuleManager var2 = VulxtsClient.modules();
      ThemeManager var3 = VulxtsClient.themes();
      Category[] var4 = Category.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Category var7 = var4[var6];
         this.panels.add(new CategoryPanel(var7, var2, var3, STATE));
      }

      this.panels.add(new ThemesPanel(var3, STATE));
      this.openAnim.setTarget(1.0F);
   }

   public void method_49589() {
      super.method_49589();
      UiSounds.guiOpen();
   }

   public static ClickGuiState state() {
      return STATE;
   }

   private Modules.ClickGuiModule guiModule() {
      return VulxtsClient.modules().clickGui;
   }

   public boolean method_25421() {
      return false;
   }

   public void method_25419() {
      if (!this.closing) {
         this.closing = true;
         this.openAnim.setTarget(0.0F);
         UiSounds.guiClose();
      }

   }

   public void method_25432() {
      BlurHook.clear();
      VulxtsClient.config().save();
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      int var5 = (int)(112.0F * this.openAnim.value());
      var1.method_25294(0, 0, this.field_22789, this.field_22790, var5 << 24 | 330001);
      this.finishCloseIfDone();
   }

   public void method_25393() {
      this.finishCloseIfDone();
   }

   private void finishCloseIfDone() {
      if (this.closing && this.openAnim.isDone()) {
         this.field_22787.method_1507(this.parent);
      }

   }

   public void method_25420(class_332 var1, int var2, int var3, float var4) {
      if (this.field_22787.field_1687 == null) {
         this.method_57728(var1, var4);
      }

      if ((Boolean)this.guiModule().blur.get()) {
         BlurHook.set(this.guiModule().blurStrength.getFloat() * this.openAnim.value());
         var1.method_71278();
      } else {
         BlurHook.clear();
      }

   }

   public void renderNvg(NVGRenderer var1, float var2, float var3, float var4, float var5) {
      var1.setFontMode((String)this.guiModule().font.get());
      if (var1.hasFont()) {
         float var6 = this.openAnim.value();
         if (!(var6 <= 0.002F) || !this.closing) {
            var1.save();
            var1.alpha(var6);
            float var7 = 1.0F;
            var1.translate(var4 / 2.0F, var5 / 2.0F);
            var1.scale(var7);
            var1.translate(-var4 / 2.0F, -var5 / 2.0F);
            this.renderBackdrop(var1, var4, var5, var6);
            String var8 = this.search.toString();
            Iterator var9 = this.panels.iterator();

            while(var9.hasNext()) {
               Panel var10 = (Panel)var9.next();
               if (var10 instanceof CategoryPanel) {
                  CategoryPanel var11 = (CategoryPanel)var10;
                  var11.setFilter(var8);
                  var11.setFavouritesOnly(this.favouritesOnly);
               }
            }

            for(int var12 = this.panels.size() - 1; var12 >= 0; --var12) {
               ((Panel)this.panels.get(var12)).render(var1, var2, var3, var4, var5);
            }

            this.renderSearchBar(var1, var4);
            this.renderFidget(var1, var2, var3, var4, var5);
            float var13 = var4 / 2.0F + 12.0F;
            float var14 = fidgetY(var5);
            Theme var15 = VulxtsClient.themes().current();
            var1.rect(var13, var14, 118.0F, 28.0F, 2.0F, var15.headerTop());
            var1.rectOutline(var13, var14, 118.0F, 28.0F, 2.0F, 1.0F, this.favouritesOnly ? var15.accent() : -12433590);
            var1.rect(var13 + 10.0F, var14, 26.0F, 2.0F, 1.0F, this.favouritesOnly ? var15.accentBright() : var15.accent());
            var1.text(this.favouritesOnly ? "Favourites: ON" : "Favourites", var13 + 12.0F, var14 + 14.0F, 12.0F, this.favouritesOnly ? var15.accentBright() : var15.textMuted());
            this.configPanel.render(var1, var2, var3, var4, var5);
            var1.restore();
         }
      }

   }

   private void renderFidget(NVGRenderer var1, float var2, float var3, float var4, float var5) {
      Theme var7 = VulxtsClient.themes().current();
      float var8 = fidgetX(var4);
      float var9 = fidgetY(var5);
      boolean var10 = var2 >= var8 && var2 <= var8 + 118.0F && var3 >= var9 && var3 <= var9 + 28.0F;
      boolean var6 = var10 || this.configPanel.isOpen();
      if (var6 != this.fidgetHovered) {
         this.fidgetHovered = var6;
         if (var6) {
            UiSounds.hover();
         }
      }

      var1.rect(var8, var9, 118.0F, 28.0F, 2.0F, var7.headerTop());
      var1.rectOutline(var8, var9, 118.0F, 28.0F, 2.0F, 1.0F, Colors.withAlpha(var6 ? var7.accentBright() : var7.accent(), var6 ? 0.85F : 0.38F));
      var1.rect(var8 + 10.0F, var9, 26.0F, 2.0F, 1.0F, var6 ? var7.accentBright() : var7.accent());
      float var12 = var8 + 18.0F;
      float var13 = var9 + 14.0F;
      var1.circleOutline(var12, var13, 5.0F, 1.4F, var6 ? var7.accentBright() : var7.textMuted());
      var1.circle(var12, var13, 1.8F, var6 ? var7.accentBright() : var7.textMuted());
      var1.text("CONFIG", var8 + 34.0F, var9 + 14.0F, 12.5F, var6 ? var7.textPrimary() : var7.textMuted());
   }

   private static float fidgetX(float var0) {
      return var0 / 2.0F - 130.0F;
   }

   private static float fidgetY(float var0) {
      return var0 - 28.0F - 14.0F;
   }

   private boolean fidgetHit(float var1, float var2) {
      float var3 = fidgetX(OverlayRenderer.uiWidth());
      float var4 = fidgetY(OverlayRenderer.uiHeight());
      return var1 >= var3 && var1 <= var3 + 118.0F && var2 >= var4 && var2 <= var4 + 28.0F;
   }

   private void renderSearchBar(NVGRenderer var1, float var2) {
      Theme var3 = VulxtsClient.themes().current();
      float var4 = (var2 - 280.0F) / 2.0F;
      float var5 = 19.0F;
      var1.rect(var4, var5, 280.0F, 32.0F, 2.0F, var3.headerTop());
      var1.rectOutline(var4, var5, 280.0F, 32.0F, 2.0F, 1.0F, Colors.withAlpha(this.searchFocused ? var3.accentBright() : var3.accent(), this.searchFocused ? 0.85F : 0.35F));
      var1.rect(var4 + 12.0F, var5, 36.0F, 2.0F, 1.0F, this.searchFocused ? var3.accentBright() : var3.accent());
      float var6 = var4 + 16.0F;
      float var7 = var5 + 16.0F;
      var1.circleOutline(var6, var7 - 1.5F, 4.5F, 1.6F, var3.textMuted());
      var1.line(var6 + 3.4F, var7 + 2.2F, var6 + 6.5F, var7 + 5.4F, 1.6F, var3.textMuted());
      float var8 = var4 + 30.0F;
      if (this.search.isEmpty() && !this.searchFocused) {
         var1.text("Search modules...", var8, var7, 12.0F, var3.textMuted());
      } else {
         float var9 = var1.text(this.search.toString(), var8, var7, 13.0F, var3.textPrimary());
         if (this.searchFocused && System.nanoTime() / 400000000L % 2L == 0L) {
            var1.rect(var8 + var9 + 2.0F, var7 - 7.0F, 1.5F, 14.0F, 0.75F, var3.accentBright());
         }
      }

      if (!this.search.isEmpty()) {
         var1.cross(var4 + 280.0F - 26.0F, var7 - 6.0F, 12.0F, 1.6F, var3.textMuted());
      }

   }

   private void renderBackdrop(NVGRenderer var1, float var2, float var3, float var4) {
      Theme var5 = VulxtsClient.themes().current();
      var1.rect(0.0F, 0.0F, var2, var3, 0.0F, Colors.withAlpha(-15724013, 0.6F * var4));
      var1.rect(0.0F, 0.0F, var2, 64.0F, 0.0F, -266855651);
      var1.line(0.0F, 64.0F, var2, 64.0F, 1.0F, -13091520);
      if (var2 > 550.0F) {
         var1.text("VULXTS", 20.0F, 27.0F, 17.0F, var5.textPrimary());
         var1.text("CLIENT", 20.0F, 44.0F, 10.0F, var5.accent());
      }

      if (var2 > 780.0F) {
         var1.text("Left click: toggle  /  Right click: settings  /  Star: favourite", 18.0F, var3 - 54.0F, 10.0F, var5.textMuted());
      }

   }

   public void openSearch(String var1) {
      this.search.setLength(0);
      this.search.append(var1);
      this.searchFocused = true;
   }

   public ConfigPanel configPanel() {
      return this.configPanel;
   }

   private boolean searchBarHit(float var1, float var2) {
      float var3 = (OverlayRenderer.uiWidth() - 280.0F) / 2.0F;
      return var1 >= var3 && var1 <= var3 + 280.0F && var2 >= 19.0F && var2 <= 51.0F;
   }

   private float uiX(double var1) {
      return OverlayRenderer.guiToUi(var1);
   }

   private float uiY(double var1) {
      return OverlayRenderer.guiToUi(var1);
   }

   public boolean method_25402(class_11909 var1, boolean var2) {
      float var3 = this.uiX(var1.comp_4798());
      float var4 = this.uiY(var1.comp_4799());
      NVGRenderer var5 = NVGRenderer.get();
      float var6 = OverlayRenderer.uiHeight();
      if (this.configPanel.isOpen()) {
         this.configPanel.mouseClicked(var3, var4, var1.method_74245());
         return true;
      } else {
         float var7 = OverlayRenderer.uiWidth() / 2.0F + 12.0F;
         float var8 = fidgetY(var6);
         if (var1.method_74245() == 0 && var3 >= var7 && var3 <= var7 + 118.0F && var4 >= var8 && var4 <= var8 + 28.0F) {
            this.favouritesOnly = !this.favouritesOnly;
            UiSounds.select();
            return true;
         } else if (this.fidgetHit(var3, var4)) {
            this.configPanel.open();
            UiSounds.guiOpen();
            return true;
         } else if (!this.searchBarHit(var3, var4)) {
            this.searchFocused = false;
            Iterator var11 = this.panels.iterator();

            Panel var10;
            do {
               if (!var11.hasNext()) {
                  return true;
               }

               var10 = (Panel)var11.next();
               if (var10.headerHit(var3, var4)) {
                  this.bringToFront(var10);
                  if (var1.method_74245() == 0) {
                     this.dragging = var10;
                     this.dragOffsetX = var3 - var10.x();
                     this.dragOffsetY = var4 - var10.y();
                     this.pressX = var3;
                     this.pressY = var4;
                     this.dragMoved = false;
                  } else {
                     var10.toggleCollapsed();
                     UiSounds.panelCollapse();
                  }

                  return true;
               }
            } while(!var10.bodyHit(var5, var3, var4, var6));

            this.bringToFront(var10);
            this.pressedContentPanel = var10;
            var10.mouseClicked(var3, var4, var1.method_74245());
            return true;
         } else {
            float var9 = (OverlayRenderer.uiWidth() + 280.0F) / 2.0F - 26.0F;
            if (!this.search.isEmpty() && var3 >= var9 - 4.0F && var3 <= var9 + 16.0F) {
               this.search.setLength(0);
            } else {
               this.searchFocused = true;
            }

            UiSounds.select();
            return true;
         }
      }
   }

   public boolean method_25403(class_11909 var1, double var2, double var4) {
      if (this.configPanel.isOpen()) {
         return true;
      } else {
         float var6 = this.uiX(var1.comp_4798());
         float var7 = this.uiY(var1.comp_4799());
         if (this.dragging != null) {
            if (Math.abs(var6 - this.pressX) + Math.abs(var7 - this.pressY) > 3.0F) {
               this.dragMoved = true;
            }

            if (this.dragMoved) {
               this.dragging.moveTo(var6 - this.dragOffsetX, var7 - this.dragOffsetY);
            }

            return true;
         } else if (this.pressedContentPanel != null) {
            this.pressedContentPanel.mouseDragged(var6, var7);
            return true;
         } else {
            return true;
         }
      }
   }

   public boolean method_25406(class_11909 var1) {
      if (this.configPanel.isOpen()) {
         return true;
      } else if (this.dragging == null) {
         if (this.pressedContentPanel != null) {
            this.pressedContentPanel.mouseReleased();
            this.pressedContentPanel = null;
         }

         return true;
      } else {
         if (!this.dragMoved && var1.method_74245() == 0) {
            this.dragging.toggleCollapsed();
            UiSounds.panelCollapse();
         } else if (this.dragMoved) {
            STATE.markCustomized();
         }

         this.dragging = null;
         return true;
      }
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      if (this.configPanel.isOpen()) {
         return true;
      } else {
         float var9 = this.uiX(var1);
         float var10 = this.uiY(var3);
         NVGRenderer var11 = NVGRenderer.get();
         float var12 = OverlayRenderer.uiHeight();
         Iterator var13 = this.panels.iterator();

         Panel var14;
         do {
            if (!var13.hasNext()) {
               return true;
            }

            var14 = (Panel)var13.next();
         } while(!var14.bodyHit(var11, var9, var10, var12) && !var14.headerHit(var9, var10));

         var14.onScroll(var7);
         return true;
      }
   }

   public boolean method_25404(class_11908 var1) {
      if (this.configPanel.isOpen()) {
         this.configPanel.keyPressed(var1.comp_4795());
         return true;
      } else {
         Iterator var2 = this.panels.iterator();

         Panel var3;
         do {
            if (!var2.hasNext()) {
               if (this.searchFocused) {
                  switch (var1.comp_4795()) {
                     case 256:
                        this.search.setLength(0);
                        this.searchFocused = false;
                        break;
                     case 257:
                     case 335:
                        this.searchFocused = false;
                        break;
                     case 259:
                        if (!this.search.isEmpty()) {
                           this.search.deleteCharAt(this.search.length() - 1);
                        }
                  }

                  return true;
               }

               if (!var1.method_74231() && !this.guiModule().getKeybind().matches(var1.comp_4795())) {
                  return super.method_25404(var1);
               }

               this.method_25419();
               return true;
            }

            var3 = (Panel)var2.next();
         } while(!var3.isListening());

         var3.keyPressed(var1.comp_4795());
         return true;
      }
   }

   public boolean method_25400(class_11905 var1) {
      if (this.configPanel.isOpen()) {
         this.configPanel.charTyped(var1.comp_4793());
         return true;
      } else {
         Iterator var2 = this.panels.iterator();

         Panel var3;
         do {
            if (!var2.hasNext()) {
               if (this.searchFocused && var1.method_74227()) {
                  if (this.search.length() < 32) {
                     this.search.append(var1.method_74226());
                  }

                  return true;
               }

               return super.method_25400(var1);
            }

            var3 = (Panel)var2.next();
         } while(!var3.isListening());

         var3.charTyped(var1.comp_4793());
         return true;
      }
   }

   private void bringToFront(Panel var1) {
      if (this.panels.remove(var1)) {
         this.panels.addFirst(var1);
      }

   }

   public void openBlockPicker(BlockListSetting var1) {
      BlockGridModel var2 = new BlockGridModel(var1, () -> {
         BlockEspModule var0 = VulxtsClient.modules().blockEsp;
         return var0 != null ? (Integer)var0.lineColor.get() : -16711736;
      }, "Vulxts Client");
      this.field_22787.method_1507(new IconPickerScreen(this, var2, VulxtsClient.themes()));
   }

   public void openIconPicker(IconListSetting var1) {
      IconListGridModel var2 = new IconListGridModel(var1);
      this.field_22787.method_1507(new IconPickerScreen(this, var2, VulxtsClient.themes()));
   }
}
