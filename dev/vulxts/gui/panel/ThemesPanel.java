package dev.vulxts.gui.panel;

import dev.vulxts.VulxtsClient;
import dev.vulxts.gui.ClickGuiState;
import dev.vulxts.gui.widget.BooleanWidget;
import dev.vulxts.gui.widget.ColorWidget;
import dev.vulxts.gui.widget.SettingWidget;
import dev.vulxts.gui.widget.SliderWidget;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.Setting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.theme.SoundSettings;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ThemesPanel extends Panel {
   private static final float ROW_H = 26.0F;
   private static final float ADD_ROW_H = 28.0F;
   private static final float SECTION_H = 24.0F;
   private final ColorWidget accentWidget;
   private final ColorSetting accentProxy;
   private final List soundWidgets = new ArrayList();
   private static final int STARTUP_FIRST_WIDGET = 5;
   private int hoveredRow = -1;
   private float lastStartY = Float.MIN_VALUE;

   public ThemesPanel(final ThemeManager themes, ClickGuiState state) {
      super(themes, state.panel(Deobf.decrypt(")5&Mm\u0085\u0080ÉËġ")));
      this.accentProxy = new ColorSetting(this, Deobf.decrypt("7\t1@f\u009c"), Deobf.decrypt("5\u001f!Qg\u0085ÅÎüěľŞĠƭƢǆǧȈȴȊɐʏʣ˟˅"), themes.current().accent()) {
         public void set(Integer value) {
            super.set(value);
            Theme current = themes.current();
            if (current.isCustom()) {
               current.setAccent(value | -16777216);
            }

         }
      };
      this.accentWidget = new ColorWidget(themes, this.accentProxy);
      SoundSettings sounds = VulxtsClient.sounds();
      if (sounds != null) {
         Iterator var4 = sounds.all().iterator();

         while(var4.hasNext()) {
            Setting setting = (Setting)var4.next();
            if (setting instanceof SliderSetting) {
               SliderSetting slider = (SliderSetting)setting;
               this.soundWidgets.add(new SliderWidget(themes, slider));
            } else if (setting instanceof BooleanSetting) {
               BooleanSetting bool = (BooleanSetting)setting;
               this.soundWidgets.add(new BooleanWidget(themes, bool));
            }
         }
      }

   }

   protected String title() {
      return Deobf.decrypt("\"\u00027Hm\u009b");
   }

   protected float contentHeight(NVGRenderer vg) {
      float h = 12.0F + (float)this.themes.getThemes().size() * 26.0F + 28.0F;
      if (this.themes.current().isCustom()) {
         h += this.accentWidget.height(vg) + 6.0F;
      }

      h += 48.0F;

      SettingWidget widget;
      for(Iterator var3 = this.soundWidgets.iterator(); var3.hasNext(); h += widget.height(vg) + 3.0F) {
         widget = (SettingWidget)var3.next();
      }

      return h;
   }

   protected void renderContent(NVGRenderer vg, float startY, float mx, float my, float viewTop, float viewBottom) {
      this.lastStartY = startY;
      Theme active = this.themes.current();
      float rowY = startY;
      int rowIndex = 0;
      int newHoveredRow = -1;

      float wFade;
      for(Iterator var11 = this.themes.getThemes().iterator(); var11.hasNext(); rowY += 26.0F) {
         Theme theme = (Theme)var11.next();
         float fade = this.edgeFade(rowY, rowY + 26.0F, viewTop, viewBottom);
         vg.save();
         vg.alpha(fade);
         boolean selected = theme == active;
         boolean hovered = my >= rowY && my <= rowY + 26.0F && mx >= this.ps.x + 6.0F && mx <= this.ps.x + 210.0F - 6.0F;
         if (hovered) {
            newHoveredRow = rowIndex;
         }

         ++rowIndex;
         if (selected || hovered) {
            vg.rect(this.ps.x + 6.0F, rowY, 198.0F, 26.0F, 7.0F, Colors.withAlpha(this.theme().accent(), selected ? 0.16F : 0.08F));
         }

         wFade = rowY + 13.0F;
         vg.circle(this.ps.x + 20.0F, wFade, 6.0F, theme.accent());
         if (selected) {
            vg.rectOutline(this.ps.x + 20.0F - 9.0F, wFade - 9.0F, 18.0F, 18.0F, 9.0F, 1.5F, this.theme().accentBright());
         }

         vg.text(theme.getName(), this.ps.x + 36.0F, wFade, 13.5F, selected ? this.theme().textPrimary() : this.theme().textMuted());
         if (theme.isCustom()) {
            vg.cross(this.ps.x + 210.0F - 28.0F, wFade - 6.0F, 12.0F, 1.6F, this.theme().textDisabled());
         }

         vg.restore();
      }

      if (active.isCustom()) {
         this.accentWidget.setBounds(this.ps.x + 14.0F, rowY + 3.0F, 182.0F);
         this.accentWidget.render(vg, mx, my);
         rowY += this.accentWidget.height(vg) + 6.0F;
      }

      float fade = this.edgeFade(rowY, rowY + 28.0F, viewTop, viewBottom);
      vg.save();
      vg.alpha(fade);
      boolean hovered = my >= rowY && my <= rowY + 28.0F - 4.0F && mx >= this.ps.x + 6.0F && mx <= this.ps.x + 210.0F - 6.0F;
      vg.rect(this.ps.x + 6.0F, rowY, 198.0F, 24.0F, 7.0F, Colors.withAlpha(this.theme().accent(), hovered ? 0.22F : 0.12F));
      String label = Deobf.decrypt("]Jrdl\u008cÅùáčħŔŭ");
      vg.text(label, this.ps.x + (210.0F - vg.textWidth(label, 13.0F)) / 2.0F, rowY + 12.0F, 13.0F, hovered ? this.theme().accentBright() : this.theme().textPrimary());
      vg.restore();
      if (hovered) {
         newHoveredRow = 999;
      }

      rowY += 28.0F;
      rowY = this.sectionHeader(vg, Deobf.decrypt("%\u0005'Kl\u009b"), rowY, viewTop, viewBottom);

      for(int i = 0; i < this.soundWidgets.size(); ++i) {
         if (i == 5) {
            rowY = this.sectionHeader(vg, Deobf.decrypt("%\u001e3W|\u009d\u0095\u009aÇđĦŕŤ"), rowY, viewTop, viewBottom);
         }

         SettingWidget widget = (SettingWidget)this.soundWidgets.get(i);
         widget.setBounds(this.ps.x + 14.0F, rowY, 182.0F);
         wFade = this.edgeFade(rowY, rowY + widget.height(vg), viewTop, viewBottom);
         vg.save();
         vg.alpha(wFade);
         widget.render(vg, mx, my);
         vg.restore();
         rowY += widget.height(vg) + 3.0F;
      }

      if (newHoveredRow != this.hoveredRow && newHoveredRow != -1) {
         UiSounds.hover();
      }

      this.hoveredRow = newHoveredRow;
   }

   private float sectionHeader(NVGRenderer vg, String title, float rowY, float viewTop, float viewBottom) {
      float fade = this.edgeFade(rowY, rowY + 24.0F, viewTop, viewBottom);
      vg.save();
      vg.alpha(fade);
      float cy = rowY + 12.0F + 3.0F;
      vg.textGradient(title.toUpperCase(Locale.ROOT), this.ps.x + 14.0F, cy, 12.0F, this.theme().accentBright(), this.theme().accent());
      float lineX = this.ps.x + 14.0F + vg.textWidth(title.toUpperCase(Locale.ROOT), 12.0F) + 8.0F;
      vg.rect(lineX, cy - 0.5F, Math.max(0.0F, this.ps.x + 210.0F - 14.0F - lineX), 1.0F, 0.5F, Colors.withAlpha(this.theme().accent(), 0.3F));
      vg.restore();
      return rowY + 24.0F;
   }

   public boolean mouseClicked(float mx, float my, int button) {
      if (this.accentWidget.mouseClicked(mx, my, button)) {
         return true;
      } else {
         Iterator var4 = this.soundWidgets.iterator();

         while(var4.hasNext()) {
            SettingWidget widget = (SettingWidget)var4.next();
            if (widget.mouseClicked(mx, my, button)) {
               return true;
            }
         }

         if (button != 0) {
            return false;
         } else {
            float rowY = this.firstRowY();
            if (rowY == Float.MIN_VALUE) {
               return false;
            } else {
               for(Iterator var8 = this.themes.getThemes().iterator(); var8.hasNext(); rowY += 26.0F) {
                  Theme theme = (Theme)var8.next();
                  if (my >= rowY && my <= rowY + 26.0F && mx >= this.ps.x + 6.0F && mx <= this.ps.x + 210.0F - 6.0F) {
                     if (theme.isCustom() && mx >= this.ps.x + 210.0F - 34.0F) {
                        this.themes.removeCustom(theme);
                     } else {
                        this.themes.select(theme);
                        if (theme.isCustom()) {
                           this.accentProxy.set(theme.accent());
                        }
                     }

                     return true;
                  }
               }

               if (this.themes.current().isCustom()) {
                  rowY += this.accentWidget.height((NVGRenderer)null) + 6.0F;
               }

               if (my >= rowY && my <= rowY + 28.0F - 4.0F && mx >= this.ps.x + 6.0F && mx <= this.ps.x + 210.0F - 6.0F) {
                  Theme custom = this.themes.addCustom(this.themes.current().accent());
                  this.themes.select(custom);
                  this.accentProxy.set(custom.accent());
                  return true;
               } else {
                  return false;
               }
            }
         }
      }
   }

   private float firstRowY() {
      return this.lastStartY;
   }

   public void mouseDragged(float mx, float my) {
      this.accentWidget.mouseDragged(mx, my);
      Iterator var3 = this.soundWidgets.iterator();

      while(var3.hasNext()) {
         SettingWidget widget = (SettingWidget)var3.next();
         widget.mouseDragged(mx, my);
      }

   }

   public void mouseReleased() {
      this.accentWidget.mouseReleased();
      Iterator var1 = this.soundWidgets.iterator();

      while(var1.hasNext()) {
         SettingWidget widget = (SettingWidget)var1.next();
         widget.mouseReleased();
      }

   }

   public boolean keyPressed(int keyCode) {
      return this.accentWidget.keyPressed(keyCode);
   }

   public boolean isListening() {
      return this.accentWidget.isListening();
   }
}
