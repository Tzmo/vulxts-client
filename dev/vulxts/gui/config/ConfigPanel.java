package dev.vulxts.gui.config;

import dev.vulxts.VulxtsClient;
import dev.vulxts.config.ConfigShareService;
import dev.vulxts.config.ConfigStore;
import dev.vulxts.render.anim.Animation;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.theme.Theme;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_310;

public class ConfigPanel {
   private static final float CARD_W = 600.0F;
   private static final float HEADER_H = 64.0F;
   private static final float FOOTER_H = 38.0F;
   private static final float ROW_H = 60.0F;
   private static final float ROW_GAP = 8.0F;
   private static final float PAD = 18.0F;
   private static final float BTN_INSET = 16.0F;
   private static final int DANGER = -45730;
   private static final int DANGER_BRIGHT = -37252;
   private final Animation openAnim = new Animation(160.0F, 0.0F);
   private boolean open;
   private float cardX;
   private float cardY;
   private float cardH;
   private final List hits = new ArrayList();
   private float closeX;
   private float closeY;
   private float closeSize;
   private int renamingSlot = -1;
   private final StringBuilder renameBuffer = new StringBuilder();
   private Confirm pendingConfirm;
   private float confirmOkX;
   private float confirmOkY;
   private float confirmOkW;
   private float confirmOkH;
   private float confirmCancelX;
   private float confirmCancelY;
   private float confirmCancelW;
   private float confirmCancelH;
   private float confirmCardX;
   private float confirmCardY;
   private float confirmCardW;
   private float confirmCardH;
   private volatile ShareCompletion shareCompletion;
   private boolean sharing;

   public boolean isOpen() {
      return this.open;
   }

   public void open() {
      this.open = true;
      this.openAnim.setTarget(1.0F);
   }

   public void close() {
      this.open = false;
      this.openAnim.setTarget(0.0F);
      this.cancelRename();
      this.pendingConfirm = null;
   }

   public boolean isListening() {
      return this.open && this.renamingSlot >= 0;
   }

   private ConfigStore store() {
      return VulxtsClient.configStore();
   }

   public void render(NVGRenderer var1, float var2, float var3, float var4, float var5) {
      this.consumeShareCompletion();
      float var6 = this.openAnim.value();
      if (!(var6 <= 0.002F) || this.open) {
         Theme var7 = VulxtsClient.themes().current();
         var1.rect(0.0F, 0.0F, var4, var5, 0.0F, Colors.withAlpha(-16579060, 0.78F * var6));
         var1.save();
         var1.alpha(var6);
         float var8 = 0.94F + 0.06F * var6;
         var1.translate(var4 / 2.0F, var5 / 2.0F);
         var1.scale(var8);
         var1.translate(-var4 / 2.0F, -var5 / 2.0F);
         ConfigStore var9 = this.store();
         this.cardH = 434.0F;
         this.cardX = (var4 - 600.0F) / 2.0F;
         this.cardY = (var5 - this.cardH) / 2.0F;
         var1.glow(this.cardX, this.cardY, 600.0F, this.cardH, 4.0F, 16.0F, Colors.withAlpha(var7.accent(), 0.12F));
         var1.rectVaryingGradient(this.cardX, this.cardY, 600.0F, this.cardH, 4.0F, 4.0F, 4.0F, 4.0F, var7.background(), var7.backgroundTo());
         var1.rectOutline(this.cardX, this.cardY, 600.0F, this.cardH, 4.0F, 1.2F, Colors.withAlpha(var7.accent(), 0.42F));
         var1.rect(this.cardX + 18.0F, this.cardY, 48.0F, 2.0F, 1.0F, var7.accentBright());
         this.renderHeader(var1, var7, var2, var3);
         this.hits.clear();
         float var10 = this.cardY + 64.0F;

         for(int var11 = 0; var11 < 5; ++var11) {
            this.renderSlot(var1, var7, var9.slot(var11), this.cardX + 18.0F, var10, 564.0F, var2, var3, var9.activeIndex() == var11);
            var10 += 68.0F;
         }

         this.renderFooter(var1, var7);
         if (this.pendingConfirm != null) {
            this.renderConfirm(var1, var7, var2, var3, var4, var5);
         }

         var1.restore();
      }

   }

   private void renderHeader(NVGRenderer var1, Theme var2, float var3, float var4) {
      float var6 = this.cardX + 18.0F;
      float var7 = this.cardY + 22.0F;
      var1.circleOutline(var6 + 8.0F, var7 + 6.0F, 7.0F, 1.8F, var2.accentBright());
      var1.circle(var6 + 8.0F, var7 + 6.0F, 2.2F, var2.accentBright());
      var1.text("CONFIGS", var6 + 28.0F, this.cardY + 26.0F, 17.0F, var2.textPrimary());
      var1.text("SAVE LOCALLY OR SHARE WITH A 6-CHARACTER CODE", var6 + 28.0F, this.cardY + 44.0F, 10.5F, var2.textMuted());
      this.closeSize = 16.0F;
      this.closeX = this.cardX + 600.0F - 18.0F - this.closeSize;
      this.closeY = this.cardY + 20.0F;
      boolean var5 = var3 >= this.closeX - 4.0F && var3 <= this.closeX + this.closeSize + 4.0F && var4 >= this.closeY - 4.0F && var4 <= this.closeY + this.closeSize + 4.0F;
      if (var5) {
         var1.rect(this.closeX - 5.0F, this.closeY - 5.0F, this.closeSize + 10.0F, this.closeSize + 10.0F, 6.0F, Colors.withAlpha(var2.accent(), 0.18F));
      }

      var1.cross(this.closeX, this.closeY, this.closeSize, 1.8F, var5 ? var2.accentBright() : var2.textMuted());
      var1.rect(this.cardX + 18.0F, this.cardY + 64.0F - 2.0F, 564.0F, 1.0F, 0.5F, Colors.withAlpha(var2.accent(), 0.2F));
   }

   private void renderSlot(NVGRenderer var1, Theme var2, ConfigStore.Slot var3, float var4, float var5, float var6, float var7, float var8, boolean var9) {
      boolean var10 = var7 >= var4 && var7 <= var4 + var6 && var8 >= var5 && var8 <= var5 + 60.0F;
      int var12 = var9 ? var2.moduleActiveFill() : Colors.withAlpha(-16777216, var10 ? 0.32F : 0.22F);
      var1.rect(var4, var5, var6, 60.0F, 5.0F, var12);
      var1.rectOutline(var4, var5, var6, 60.0F, 5.0F, 1.0F, Colors.withAlpha(var2.accent(), var9 ? 0.48F : (var10 ? 0.24F : 0.1F)));
      if (var9) {
         var1.rect(var4, var5 + 10.0F, 3.0F, 40.0F, 1.5F, var2.accentBright());
      }

      float var13 = var4 + 16.0F;
      float var14 = var5 + 30.0F;
      if (var9) {
         var1.circleGlow(var13, var14, 4.0F, 5.0F, var2.accent());
         var1.circle(var13, var14, 4.0F, var2.accentBright());
      } else if (var3.filled()) {
         var1.circle(var13, var14, 3.5F, var2.statusEnabled());
      } else {
         var1.circleOutline(var13, var14, 3.5F, 1.2F, var2.statusDisabled());
      }

      float var15 = var4 + 32.0F;
      if (this.renamingSlot == var3.index()) {
         this.renderRenameField(var1, var2, var15, var5 + 12.0F, 190.0F);
      } else {
         var1.textTruncated(var3.name(), var15, var5 + 22.0F, 15.0F, var2.textPrimary(), 200.0F);
         if (var9) {
            float var16 = var1.textWidth(var3.name(), 15.0F);
            this.drawTag(var1, var2, var15 + Math.min(var16, 200.0F) + 8.0F, var5 + 22.0F, Deobf.decrypt("7)\u0006l^\u00ad"));
         }
      }

      String var17 = this.renamingSlot == var3.index() ? Deobf.decrypt("3\u0004&@zÈ\u0091Õ´ĝļŕŦƥƳǈƢˑɠɯɀʃ˯˄˘͑ʹ͒ͿΌοϙ") : (var3.filled() ? "Saved · " + relativeTime(var3.savedAt()) : Deobf.decrypt("3\u0007\"QqÈ\u0096ÖûĊ"));
      var1.text(var17, var15, var5 + 40.0F, 11.5F, var2.textMuted());
      this.layoutButtons(var1, var2, var3, var4 + var6 - 16.0F, var5, var7, var8);
   }

   private void renderRenameField(NVGRenderer var1, Theme var2, float var3, float var4, float var5) {
      float var6 = 20.0F;
      var1.rect(var3, var4, var5, var6, var6 / 2.0F, Colors.withAlpha(-16777216, 0.5F));
      var1.rectOutline(var3, var4, var5, var6, var6 / 2.0F, 1.2F, Colors.withAlpha(var2.accentBright(), 0.9F));
      float var7 = var3 + 8.0F;
      float var8 = var4 + var6 / 2.0F;
      float var9 = var1.text(this.renameBuffer.toString(), var7, var8, 12.5F, var2.textPrimary());
      if (System.nanoTime() / 400000000L % 2L == 0L) {
         var1.rect(var7 + var9 + 1.5F, var8 - 6.0F, 1.4F, 12.0F, 0.7F, var2.accentBright());
      }

   }

   private void drawTag(NVGRenderer var1, Theme var2, float var3, float var4, String var5) {
      float var6 = var1.textWidth(var5, 9.5F);
      var1.rect(var3, var4 - 7.0F, var6 + 12.0F, 14.0F, 7.0F, Colors.withAlpha(var2.accent(), 0.22F));
      var1.text(var5, var3 + 6.0F, var4, 9.5F, var2.accentBright());
   }

   private void layoutButtons(NVGRenderer var1, Theme var2, ConfigStore.Slot var3, float var4, float var5, float var6, float var7) {
      ArrayList var8 = new ArrayList();

      record Spec(Action action, String label, boolean primary, boolean danger) {
         Spec(Action action, String label, boolean primary, boolean danger) {
            this.action = action;
            this.label = label;
            this.primary = primary;
            this.danger = danger;
         }

         public Action action() {
            return this.action;
         }

         public String label() {
            return this.label;
         }

         public boolean primary() {
            return this.primary;
         }

         public boolean danger() {
            return this.danger;
         }
      }

      if (var3.filled()) {
         var8.add(new Spec(ConfigPanel.Action.ACTIVATE, "Use", true, false));
         var8.add(new Spec(ConfigPanel.Action.SAVE, "Update", false, false));
         var8.add(new Spec(ConfigPanel.Action.EXPORT, "Copy code", false, false));
         var8.add(new Spec(ConfigPanel.Action.IMPORT, "Import code", false, false));
         var8.add(new Spec(ConfigPanel.Action.DELETE, "Delete", false, true));
      } else {
         var8.add(new Spec(ConfigPanel.Action.SAVE, "Save", true, false));
         var8.add(new Spec(ConfigPanel.Action.IMPORT, "Import code", false, false));
      }

      float var9 = 26.0F;
      float var10 = 11.0F;
      float var11 = 6.0F;
      float var12 = 12.0F;
      float var13 = 0.0F;
      float[] var14 = new float[var8.size()];

      for(int var15 = 0; var15 < var8.size(); ++var15) {
         var14[var15] = var1.textWidth(((Spec)var8.get(var15)).label(), var12) + var10 * 2.0F;
         var13 += var14[var15] + (var15 > 0 ? var11 : 0.0F);
      }

      float var21 = var4 - var13;
      float var16 = var5 + (60.0F - var9) / 2.0F;

      for(int var17 = 0; var17 < var8.size(); ++var17) {
         Spec var18 = (Spec)var8.get(var17);
         float var19 = var14[var17];
         boolean var20 = var6 >= var21 && var6 <= var21 + var19 && var7 >= var16 && var7 <= var16 + var9;
         this.drawButton(var1, var2, var21, var16, var19, var9, var18.label(), var12, var18.primary(), var20, var18.danger());
         this.hits.add(new Hit(var18.action(), var3.index(), var21, var16, var19, var9, var18.primary()));
         var21 += var19 + var11;
      }

   }

   private void drawButton(NVGRenderer var1, Theme var2, float var3, float var4, float var5, float var6, String var7, float var8, boolean var9, boolean var10, boolean var11) {
      int var13 = var11 ? -45730 : var2.accent();
      int var12 = var11 ? -37252 : var2.accentBright();
      int var15;
      if (var9) {
         var15 = var10 ? Colors.lighten(var12, 0.1F) : var12;
         var1.rectGradient(var3, var4, var5, var6, 4.0F, var15, var13, true);
         if (var10) {
            var1.glow(var3, var4, var5, var6, 4.0F, 5.0F, Colors.withAlpha(var13, 0.35F));
         }

         var1.text(var7, var3 + (var5 - var1.textWidth(var7, var8)) / 2.0F, var4 + var6 / 2.0F, var8, -15593706);
      } else {
         var1.rect(var3, var4, var5, var6, 4.0F, Colors.withAlpha(-1, var10 ? 0.12F : 0.06F));
         var1.rectOutline(var3, var4, var5, var6, 4.0F, 1.0F, Colors.withAlpha(var10 ? var12 : var13, var10 ? 0.7F : 0.28F));
         var15 = var11 ? Colors.withAlpha(var13, 0.85F) : var2.textMuted();
         var1.text(var7, var3 + (var5 - var1.textWidth(var7, var8)) / 2.0F, var4 + var6 / 2.0F, var8, var10 ? (var11 ? var12 : var2.textPrimary()) : var15);
      }

   }

   private void renderFooter(NVGRenderer var1, Theme var2) {
      float var3 = this.cardY + this.cardH - 19.0F;
      var1.text(this.sharing ? "CONTACTING CONFIG SERVICE..." : "SHARE CODES EXPIRE AFTER 30 DAYS", this.cardX + 18.0F, var3, 11.0F, var2.textMuted());
   }

   private void renderConfirm(NVGRenderer var1, Theme var2, float var3, float var4, float var5, float var6) {
      var1.rect(this.cardX, this.cardY, 600.0F, this.cardH, 18.0F, Colors.withAlpha(-16316918, 0.55F));
      this.confirmCardW = 380.0F;
      this.confirmCardH = 148.0F;
      this.confirmCardX = (var5 - this.confirmCardW) / 2.0F;
      this.confirmCardY = (var6 - this.confirmCardH) / 2.0F;
      boolean var7 = this.pendingConfirm.action() == ConfigPanel.Action.DELETE;
      var1.glow(this.confirmCardX, this.confirmCardY, this.confirmCardW, this.confirmCardH, 16.0F, 20.0F, Colors.withAlpha(-16777216, 0.5F));
      var1.rectVaryingGradient(this.confirmCardX, this.confirmCardY, this.confirmCardW, this.confirmCardH, 16.0F, 16.0F, 16.0F, 16.0F, var2.headerTop(), var2.background());
      var1.rectOutline(this.confirmCardX, this.confirmCardY, this.confirmCardW, this.confirmCardH, 16.0F, 1.2F, Colors.withAlpha(var7 ? -45730 : var2.accent(), 0.45F));
      var1.text(this.pendingConfirm.title(), this.confirmCardX + 22.0F, this.confirmCardY + 34.0F, 16.0F, var2.textPrimary());
      var1.text(this.pendingConfirm.body(), this.confirmCardX + 22.0F, this.confirmCardY + 58.0F, 12.0F, var2.textMuted());
      float var8 = 30.0F;
      float var9 = 10.0F;
      float var10 = this.confirmCardY + this.confirmCardH - var8 - 20.0F;
      this.confirmOkW = 118.0F;
      this.confirmCancelW = 92.0F;
      this.confirmOkH = var8;
      this.confirmCancelH = var8;
      this.confirmOkX = this.confirmCardX + this.confirmCardW - 22.0F - this.confirmOkW;
      this.confirmOkY = var10;
      this.confirmCancelX = this.confirmOkX - var9 - this.confirmCancelW;
      this.confirmCancelY = var10;
      boolean var11 = var3 >= this.confirmOkX && var3 <= this.confirmOkX + this.confirmOkW && var4 >= var10 && var4 <= var10 + var8;
      boolean var12 = var3 >= this.confirmCancelX && var3 <= this.confirmCancelX + this.confirmCancelW && var4 >= var10 && var4 <= var10 + var8;
      this.drawButton(var1, var2, this.confirmCancelX, this.confirmCancelY, this.confirmCancelW, this.confirmCancelH, Deobf.decrypt("5\u000b<Fm\u0084"), 12.5F, false, var12, false);
      this.drawButton(var1, var2, this.confirmOkX, this.confirmOkY, this.confirmOkW, this.confirmOkH, this.confirmLabel(), 12.5F, true, var11, var7);
   }

   private String confirmLabel() {
      String var10000;
      switch (this.pendingConfirm.action().ordinal()) {
         case 4:
            var10000 = Deobf.decrypt("?\u0007\"Jz\u009c");
            break;
         case 5:
            var10000 = Deobf.decrypt("2\u000f>@|\u008d");
            break;
         default:
            var10000 = Deobf.decrypt("9\u001c7W\u007f\u009a\u008cÎñ");
      }

      return var10000;
   }

   public boolean mouseClicked(float var1, float var2, int var3) {
      if (!this.open) {
         return false;
      } else {
         if (this.renamingSlot >= 0) {
            this.commitRename();
         }

         if (this.pendingConfirm != null) {
            if (this.hit(var1, var2, this.confirmOkX, this.confirmOkY, this.confirmOkW, this.confirmOkH)) {
               this.runConfirm();
            } else if (this.hit(var1, var2, this.confirmCancelX, this.confirmCancelY, this.confirmCancelW, this.confirmCancelH) || !this.hit(var1, var2, this.confirmCardX, this.confirmCardY, this.confirmCardW, this.confirmCardH)) {
               this.pendingConfirm = null;
               UiSounds.select();
            }

            return true;
         } else if (var1 >= this.closeX - 5.0F && var1 <= this.closeX + this.closeSize + 5.0F && var2 >= this.closeY - 5.0F && var2 <= this.closeY + this.closeSize + 5.0F) {
            this.close();
            UiSounds.guiClose();
            return true;
         } else {
            Iterator var4 = this.hits.iterator();

            while(var4.hasNext()) {
               Hit var5 = (Hit)var4.next();
               if (var5.contains(var1, var2)) {
                  this.dispatch(var5.action, var5.slot);
                  return true;
               }
            }

            if (var1 < this.cardX || var1 > this.cardX + 600.0F || var2 < this.cardY || var2 > this.cardY + this.cardH) {
               this.close();
               UiSounds.guiClose();
            }

            return true;
         }
      }
   }

   public boolean keyPressed(int var1) {
      if (!this.open) {
         return false;
      } else if (this.renamingSlot >= 0) {
         switch (var1) {
            case 256:
               this.cancelRename();
               break;
            case 257:
            case 335:
               this.commitRename();
               break;
            case 259:
               if (this.renameBuffer.length() > 0) {
                  this.renameBuffer.deleteCharAt(this.renameBuffer.length() - 1);
               }
         }

         return true;
      } else if (this.pendingConfirm != null) {
         switch (var1) {
            case 256:
               this.pendingConfirm = null;
               UiSounds.select();
               break;
            case 257:
            case 335:
               this.runConfirm();
         }

         return true;
      } else if (var1 == 256) {
         this.close();
         UiSounds.guiClose();
         return true;
      } else {
         return true;
      }
   }

   public boolean charTyped(int var1) {
      if (this.open && this.renamingSlot >= 0) {
         if (this.renameBuffer.length() >= 24) {
            return true;
         } else {
            char var2 = (char)var1;
            if (var2 >= ' ' && var2 < 127) {
               this.renameBuffer.append(var2);
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private void dispatch(Action var1, int var2) {
      if (this.sharing && (var1 == ConfigPanel.Action.EXPORT || var1 == ConfigPanel.Action.IMPORT)) {
         this.toast("Please wait for the current config request.");
      } else {
         ConfigStore var3 = this.store();
         switch (var1.ordinal()) {
            case 0:
               this.doActivate(var2);
               break;
            case 1:
               if (var3.slot(var2).filled()) {
                  this.pendingConfirm = new Confirm(ConfigPanel.Action.SAVE, var2, "Overwrite \"" + var3.slot(var2).name() + "\"?", "This replaces the config saved in slot " + (var2 + 1) + ".", (String)null);
                  UiSounds.select();
               } else {
                  this.doSave(var2);
               }
               break;
            case 2:
               this.beginRename(var2);
               break;
            case 3:
               this.doExport(var2);
               break;
            case 4:
               String var4 = this.readClipboard();
               if (var4 != null && !var4.isBlank()) {
                  var4 = var4.trim().toUpperCase();
                  if (!var4.matches("[A-Z0-9]{6}")) {
                     this.toast("Copy a six-character config code first.");
                     UiSounds.select();
                     return;
                  }

                  if (var3.slot(var2).filled()) {
                     this.pendingConfirm = new Confirm(ConfigPanel.Action.IMPORT, var2, "Replace \"" + var3.slot(var2).name() + "\"?", "This imports config code " + var4.trim().toUpperCase() + ".", var4);
                     UiSounds.select();
                  } else {
                     this.doImport(var2, var4);
                  }
                  break;
               }

               this.toast(Deobf.decrypt("8\u0005&Ma\u0086\u0082\u009aûĐųŏŨƩǡǆǮȏȰɈɜʁʽ˔ʗ̅\u0378̓\u0378\u0382ΪϚϡϔ"));
               UiSounds.select();
               return;
            case 5:
               this.pendingConfirm = new Confirm(ConfigPanel.Action.DELETE, var2, "Delete \"" + var3.slot(var2).name() + "\"?", "This permanently removes slot " + (var2 + 1) + ".", (String)null);
               UiSounds.select();
         }
      }

   }

   private void runConfirm() {
      Confirm var1 = this.pendingConfirm;
      this.pendingConfirm = null;
      if (var1 != null) {
         if (var1.action() == ConfigPanel.Action.SAVE) {
            this.doSave(var1.slot());
         } else if (var1.action() == ConfigPanel.Action.IMPORT) {
            this.doImport(var1.slot(), var1.payload());
         } else if (var1.action() == ConfigPanel.Action.DELETE) {
            this.doDelete(var1.slot());
         }
      }

   }

   private void doDelete(int var1) {
      String var2 = this.store().slot(var1).name();
      if (this.store().delete(var1)) {
         this.toast("Deleted \"" + var2 + "\"");
         UiSounds.select();
      } else {
         this.toast(Deobf.decrypt("5\u0005'Il\u0086ÂÎ´ĚĶŗťƸƤƅǶȎȥȊɐʏʡ˖˞̖"));
      }

   }

   private void doSave(int var1) {
      if (this.store().save(var1)) {
         String var10001 = this.store().slot(var1).name();
         this.toast("Saved to \"" + var10001 + "\"");
         UiSounds.toggle(true);
      } else {
         this.toast(Deobf.decrypt("5\u0005'Il\u0086ÂÎ´čĲōťǬƵǍǧɆȣɅɝʆʦ˗"));
      }

   }

   private void doActivate(int var1) {
      if (this.store().activate(var1)) {
         String var10001 = this.store().slot(var1).name();
         this.toast("Activated \"" + var10001 + "\"");
         UiSounds.toggle(true);
      } else {
         this.toast(Deobf.decrypt("\"\u00023Q(\u009b\u0089ÕàŞĺňĠƩƬǕǶȟ"));
      }

   }

   private void doExport(int var1) {
      String var2 = this.store().export(var1);
      if (var2 == null) {
         this.toast(Deobf.decrypt("\"\u00023Q(\u009b\u0089ÕàŞĺňĠƩƬǕǶȟ"));
      } else {
         this.sharing = true;
         this.toast("Creating config code...");
         ConfigShareService.export(var2).thenAccept((var2x) -> {
            this.shareCompletion = new ShareCompletion(true, var1, var2x);
         });
      }

   }

   private void doImport(int var1, String var2) {
      this.sharing = true;
      this.toast("Loading config code...");
      ConfigShareService.importCode(var2).thenAccept((var2x) -> {
         this.shareCompletion = new ShareCompletion(false, var1, var2x);
      });
   }

   private void consumeShareCompletion() {
      ShareCompletion var1 = this.shareCompletion;
      if (var1 != null) {
         this.shareCompletion = null;
         this.sharing = false;
         ConfigShareService.Result var2 = var1.result();
         if (!var2.ok()) {
            this.toast(var2.message());
            UiSounds.select();
         } else if (var1.exporting()) {
            this.setClipboard(var2.message());
            this.toast("Config code copied: " + var2.message());
            UiSounds.select();
         } else {
            ConfigStore.ImportResult var3 = this.store().importInto(var1.slot(), var2.config());
            this.toast(var3.message());
            UiSounds.toggle(var3.ok());
         }
      }

   }

   private void beginRename(int var1) {
      this.renamingSlot = var1;
      this.renameBuffer.setLength(0);
      this.renameBuffer.append(this.store().slot(var1).name());
      UiSounds.select();
   }

   private void commitRename() {
      if (this.renamingSlot >= 0) {
         this.store().rename(this.renamingSlot, this.renameBuffer.toString());
         this.renamingSlot = -1;
      }

   }

   private void cancelRename() {
      this.renamingSlot = -1;
   }

   private boolean hit(float var1, float var2, float var3, float var4, float var5, float var6) {
      return var1 >= var3 && var1 <= var3 + var5 && var2 >= var4 && var2 <= var4 + var6;
   }

   private void toast(String var1) {
      if (VulxtsClient.notifications() != null) {
         VulxtsClient.notifications().pushInfo(var1);
      }

   }

   private String readClipboard() {
      try {
         return class_310.method_1551().field_1774.method_1460();
      } catch (Exception var2) {
         return null;
      }
   }

   private void setClipboard(String var1) {
      try {
         class_310.method_1551().field_1774.method_1455(var1);
      } catch (Exception var3) {
      }

   }

   private static String relativeTime(long var0) {
      if (var0 <= 0L) {
         return Deobf.decrypt("\u001c\u001f!Q(\u0086\u008aÍ");
      } else {
         long var2 = System.currentTimeMillis() - var0;
         if (var2 < 60000L) {
            return Deobf.decrypt("\u001c\u001f!Q(\u0086\u008aÍ");
         } else {
            long var4 = var2 / 60000L;
            if (var4 < 60L) {
               return "" + var4 + "m ago";
            } else {
               long var6 = var4 / 60L;
               return var6 < 24L ? "" + var6 + "h ago" : var6 / 24L + "d ago";
            }
         }
      }
   }

   public void debugBeginRename(int var1) {
      this.open();
      this.beginRename(var1);
   }

   public void debugConfirmOverwrite(int var1) {
      this.open();
      this.pendingConfirm = new Confirm(ConfigPanel.Action.SAVE, var1, "Overwrite \"" + this.store().slot(var1).name() + "\"?", "This replaces the config saved in slot " + (var1 + 1) + ".", (String)null);
   }

   public void debugConfirmDelete(int var1) {
      this.open();
      this.pendingConfirm = new Confirm(ConfigPanel.Action.DELETE, var1, "Delete \"" + this.store().slot(var1).name() + "\"?", "This permanently removes slot " + (var1 + 1) + ".", (String)null);
   }

   private static record Confirm(Action action, int slot, String title, String body, String payload) {
      private Confirm(Action action, int slot, String title, String body, String payload) {
         this.action = action;
         this.slot = slot;
         this.title = title;
         this.body = body;
         this.payload = payload;
      }

      public Action action() {
         return this.action;
      }

      public int slot() {
         return this.slot;
      }

      public String title() {
         return this.title;
      }

      public String body() {
         return this.body;
      }

      public String payload() {
         return this.payload;
      }
   }

   private static enum Action {
      ACTIVATE,
      SAVE,
      RENAME,
      EXPORT,
      IMPORT,
      DELETE;

      // $FF: synthetic method
      private static Action[] $values() {
         return new Action[]{ACTIVATE, SAVE, RENAME, EXPORT, IMPORT, DELETE};
      }
   }

   private static final class Hit {
      final Action action;
      final int slot;
      final float x;
      final float y;
      final float w;
      final float h;
      final boolean primary;

      Hit(Action var1, int var2, float var3, float var4, float var5, float var6, boolean var7) {
         this.action = var1;
         this.slot = var2;
         this.x = var3;
         this.y = var4;
         this.w = var5;
         this.h = var6;
         this.primary = var7;
      }

      boolean contains(float var1, float var2) {
         return var1 >= this.x && var1 <= this.x + this.w && var2 >= this.y && var2 <= this.y + this.h;
      }
   }

   private static record ShareCompletion(boolean exporting, int slot, ConfigShareService.Result result) {
      private ShareCompletion(boolean exporting, int slot, ConfigShareService.Result result) {
         this.exporting = exporting;
         this.slot = slot;
         this.result = result;
      }

      public boolean exporting() {
         return this.exporting;
      }

      public int slot() {
         return this.slot;
      }

      public ConfigShareService.Result result() {
         return this.result;
      }
   }
}
