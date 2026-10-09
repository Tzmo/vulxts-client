package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.mixin.ClientInputAccessor;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;
import net.minecraft.class_10185;
import net.minecraft.class_1923;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_5498;
import net.minecraft.class_631;
import net.minecraft.class_746;

public class FreecamModule extends Module {
   private static FreecamModule instance;
   private static final double SCROLL_SPEED_STEP = 0.1;
   public final SliderSetting speed = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001a7@l"), Deobf.decrypt("5\u000b?@z\u0089ÅÜøćųňŰƩƤǁ"), 1.0, 0.1, 50.0, 0.1, Deobf.decrypt("\u000e")));
   public final SliderSetting verticalMultiplier = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(" \u000f Qa\u008b\u0084Ö´čģŞťƨ"), Deobf.decrypt("#\u001a}Ag\u009f\u008b\u009açĎĶŞŤǬƬǐǮȒȩɚɟʉʪ˂"), 1.0, 0.2, 5.0, 0.05, Deobf.decrypt("\u000e")));
   public final BooleanSetting smoothing = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0007=J|\u0080\u008cÔó"), Deobf.decrypt("3\u000b!@(\u008b\u0084×ñČĲěŭƣƷǀǯȃȮɞ"), true));
   public final BooleanSetting showPlayerModel = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0002=R(\u0087\u0092Ô´ĜļşŹ"), Deobf.decrypt("$\u000f<Am\u009aÅÃûċġěŢƣƥǜƢȑȨɃɟʅ˯˔˒̅Ͷ͐\u0379Ίξ"), true));
   public final BooleanSetting showHands = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0002=R(\u0080\u0084Ôðč"), Deobf.decrypt("=\u000f7U(\u008e\u008cÈçĊžŋťƾƲǊǬɆȨɋɝʄʼʐˁ̘͚ͤͳ\u0383ο"), true));
   public final SliderSetting lookSensitivity = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(":\u0005=N(»\u0080ÔçėħŒŶƥƵǜ"), Deobf.decrypt("5\u000b?@z\u0089ÅÖûđĸěųƩƯǖǫȒȩɜɚʔʶ"), 0.5, 0.1, 2.0, 0.05));
   public final SliderSetting freecamChunkDistance = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("5\u0002'KcÈ\u0081ÓçĊĲŕţƩ"), Deobf.decrypt("5\u0002'Kc\u009bÅÎûŞĿŔšƨǡǄǰȉȵɄɗˀʻ˘˒͑ʹ͒ͼΊΨϔ"), 12.0, 2.0, 32.0, 1.0));
   private double currentX;
   private double currentY;
   private double currentZ;
   private double prevX;
   private double prevY;
   private double prevZ;
   private float currentYaw;
   private float currentPitch;
   private float prevYaw;
   private float prevPitch;
   private double savedX;
   private double savedY;
   private double savedZ;
   private float savedYaw;
   private float savedPitch;
   private boolean savedAbilitiesFlying;
   private boolean savedSmartCull;
   private class_5498 perspectiveBeforeFreecam;
   private boolean switchedPerspectiveForBody;
   private class_1923 lastSyncedCamChunk;
   private int lastSyncedLoadDistance = Integer.MIN_VALUE;
   private boolean activationPending;
   private boolean active = false;
   private boolean latchedForward;
   private boolean latchedBack;
   private boolean latchedLeft;
   private boolean latchedRight;
   private boolean latchedJump;
   private boolean latchedSneak;
   private boolean latchedSprint;

   public FreecamModule() {
      super(Deobf.decrypt("0\u00187@k\u0089\u0088"), Deobf.decrypt("2\u000f&Dk\u0080\u0080Þ´ĝĲŖťƾƠƅƪȱȁɹɷˀ˲ʐˑ̝ͮ̿̚ϏΘϚϷϙѝвєѰӔҦӢӡԒէՊռ֙օגפؐىؚطڕڲۍ۱ܕݶݮݳދ\u07bbޅ߃߯ࠣࠣࠏࡩ\u0899ࢻ\u089e"), Category.MISC);
      instance = this;
   }

   public static FreecamModule get() {
      return instance;
   }

   public boolean adjustSpeedFromScroll(double var1) {
      if (this.isActive() && var1 != 0.0) {
         this.speed.set(scrolledSpeed((Double)this.speed.get(), var1));
         return true;
      } else {
         return false;
      }
   }

   static double scrolledSpeed(double var0, double var2) {
      return var2 == 0.0 ? var0 : var0 + Math.copySign(0.1, var2);
   }

   protected void onEnable() {
      this.clearMovementLatches();
      class_310 var1 = class_310.method_1551();
      if (var1.field_1724 != null) {
         this.captureMovementLatches(var1);
      }

      this.activationPending = true;
      this.active = false;
   }

   protected void onDisable() {
      class_310 var1 = class_310.method_1551();
      this.clearMovementLatches();
      this.activationPending = false;
      this.active = false;
      if (this.switchedPerspectiveForBody) {
         var1.field_1690.method_31043(this.perspectiveBeforeFreecam);
         this.switchedPerspectiveForBody = false;
      }

      this.restoreViewOnlyClientState(var1);
      this.restoreVanillaChunkLoading(var1);
      if (var1.field_1724 != null) {
         var1.field_1724.method_31549().field_7479 = this.savedAbilitiesFlying;
      }

   }

   public void tryCompleteActivation(class_310 var1) {
      if (this.isEnabled() && this.activationPending && var1.field_1724 != null && var1.field_1687 != null) {
         this.savedX = var1.field_1724.method_23317();
         this.savedY = var1.field_1724.method_23318();
         this.savedZ = var1.field_1724.method_23321();
         this.savedYaw = var1.field_1724.method_36454();
         this.savedPitch = var1.field_1724.method_36455();
         this.currentX = this.prevX = this.savedX;
         this.currentY = this.prevY = this.savedY + (double)var1.field_1724.method_5751();
         this.currentZ = this.prevZ = this.savedZ;
         this.currentYaw = this.prevYaw = this.savedYaw;
         this.currentPitch = this.prevPitch = this.savedPitch;
         this.savedAbilitiesFlying = var1.field_1724.method_31549().field_7479;
         this.switchedPerspectiveForBody = false;
         if ((Boolean)this.showPlayerModel.get()) {
            this.perspectiveBeforeFreecam = var1.field_1690.method_31044();
            if (this.perspectiveBeforeFreecam.method_31034()) {
               var1.field_1690.method_31043(class_5498.field_26665);
               this.switchedPerspectiveForBody = true;
            }
         }

         this.activationPending = false;
         this.active = true;
         this.lastSyncedCamChunk = null;
         this.lastSyncedLoadDistance = Integer.MIN_VALUE;
         this.applyViewOnlyClientState(var1);
         this.syncFreecamChunkLoading(var1);
         reapplyBodyInput(var1);
      }

   }

   private void captureMovementLatches(class_310 var1) {
      class_315 var2 = var1.field_1690;
      class_746 var3 = var1.field_1724;
      class_10185 var4 = var3 != null ? var3.field_3913.field_54155 : class_10185.field_54098;
      this.latchedForward = var2.field_1894.method_1434() || var4.comp_3159();
      this.latchedBack = var2.field_1881.method_1434() || var4.comp_3160();
      this.latchedLeft = var2.field_1913.method_1434() || var4.comp_3161();
      this.latchedRight = var2.field_1849.method_1434() || var4.comp_3162();
      this.latchedJump = var2.field_1903.method_1434() || var4.comp_3163();
      this.latchedSneak = var2.field_1832.method_1434() || var4.comp_3164() || var3 != null && var3.method_5715();
      this.latchedSprint = var2.field_1867.method_1434() || var4.comp_3165();
      this.mergeLatchFromAutoWalk();
   }

   private void mergeLatchFromAutoWalk() {
      AutoWalkModule var1 = VulxtsClient.modules() != null ? VulxtsClient.modules().autoWalk : null;
      if (var1 != null && var1.isEnabled()) {
         this.latchedForward = true;
      }

   }

   private void clearMovementLatches() {
      this.latchedRight = false;
      this.latchedLeft = false;
      this.latchedBack = false;
      this.latchedForward = false;
      this.latchedSprint = false;
      this.latchedSneak = false;
      this.latchedJump = false;
   }

   public void onTick() {
      class_310 var1 = class_310.method_1551();
      if (this.isEnabled()) {
         this.tryCompleteActivation(var1);
         if (this.active && var1.field_1724 != null) {
            this.prevX = this.currentX;
            this.prevY = this.currentY;
            this.prevZ = this.currentZ;
            this.prevYaw = this.currentYaw;
            this.prevPitch = this.currentPitch;
            float var2 = this.speed.getFloat();
            float var3 = this.verticalMultiplier.getFloat();
            float var4 = (Boolean)this.smoothing.get() ? 0.5F : 1.0F;
            class_315 var5 = var1.field_1690;
            double var6 = 0.0;
            double var8 = 0.0;
            double var10 = 0.0;
            if (var5.field_1894.method_1434()) {
               ++var6;
            }

            if (var5.field_1881.method_1434()) {
               --var6;
            }

            if (var5.field_1913.method_1434()) {
               ++var8;
            }

            if (var5.field_1849.method_1434()) {
               --var8;
            }

            if (var5.field_1903.method_1434()) {
               ++var10;
            }

            if (var5.field_1832.method_1434()) {
               --var10;
            }

            class_746 var12 = var1.field_1724;
            if (var12.method_31549().field_7477) {
               var12.method_31549().field_7479 = false;
            }

            double var13 = Math.toRadians((double)this.currentYaw);
            double var15 = -Math.sin(var13) * var6 * (double)var2 + Math.cos(var13) * var8 * (double)var2;
            double var17 = Math.cos(var13) * var6 * (double)var2 + Math.sin(var13) * var8 * (double)var2;
            double var19 = var10 * (double)var2 * (double)var3;
            this.currentX += var15 * (double)var4;
            this.currentY += var19 * (double)var4;
            this.currentZ += var17 * (double)var4;
            this.syncFreecamChunkLoading(var1);
         }
      }

   }

   public static void reapplyBodyInput(class_310 var0) {
      FreecamModule var1 = instance;
      if (var1 != null && var1.isActive() && var0.field_1724 != null) {
         class_746 var2 = var0.field_1724;
         boolean var3 = var1.latchedForward;
         boolean var4 = var1.latchedBack;
         boolean var5 = var1.latchedLeft;
         boolean var6 = var1.latchedRight;
         boolean var7 = var1.latchedJump;
         boolean var8 = var1.latchedSneak;
         boolean var9 = var1.latchedSprint;
         var2.field_3913.field_54155 = new class_10185(var3, var4, var5, var6, var7, var8, var9);
         float var10 = (var5 ? 1.0F : 0.0F) - (var6 ? 1.0F : 0.0F);
         float var11 = (var3 ? 1.0F : 0.0F) - (var4 ? 1.0F : 0.0F);
         class_241 var12 = (new class_241(var10, var11)).method_35581();
         ((ClientInputAccessor)var2.field_3913).vulxtsclient$setMoveVector(var12);
         var2.method_5660(var8);
      }

   }

   public boolean hasLatchedLocomotion() {
      return this.latchedForward || this.latchedBack || this.latchedLeft || this.latchedRight || this.latchedJump || this.latchedSneak;
   }

   private void syncFreecamChunkLoading(class_310 var1) {
      if (this.active && var1.field_1687 != null && var1.field_1724 != null) {
         class_631 var2 = var1.field_1687.method_2935();
         class_1923 var3 = var1.field_1724.method_31476();
         int var4 = Math.min(32, Math.max(2, Math.round(this.freecamChunkDistance.getFloat())));
         int var5 = Math.min(32, Math.max(var4, var1.field_1690.method_38521()));
         if (var5 != this.lastSyncedLoadDistance) {
            var2.method_20180(var5);
            this.lastSyncedLoadDistance = var5;
         }

         if (this.lastSyncedCamChunk == null || var3.field_9181 != this.lastSyncedCamChunk.field_9181 || var3.field_9180 != this.lastSyncedCamChunk.field_9180) {
            var2.method_20317(var3.field_9181, var3.field_9180);
            this.lastSyncedCamChunk = var3;
            if (var1.field_1769 != null) {
               var1.field_1769.method_3292();
            }
         }
      }

   }

   private void restoreVanillaChunkLoading(class_310 var1) {
      this.lastSyncedCamChunk = null;
      this.lastSyncedLoadDistance = Integer.MIN_VALUE;
      if (var1.field_1687 != null) {
         class_631 var2 = var1.field_1687.method_2935();
         if (var1.field_1724 != null) {
            class_1923 var3 = var1.field_1724.method_31476();
            var2.method_20317(var3.field_9181, var3.field_9180);
         }

         var2.method_20180(var1.field_1690.method_38521());
         if (var1.field_1769 != null) {
            var1.field_1769.method_3292();
         }
      }

   }

   private void applyViewOnlyClientState(class_310 var1) {
      this.savedSmartCull = var1.field_1730;
      var1.field_1730 = false;
   }

   private void restoreViewOnlyClientState(class_310 var1) {
      var1.field_1730 = this.savedSmartCull;
      if (var1.field_1761 != null) {
         var1.field_1761.method_2925();
      }

   }

   public boolean isActive() {
      return this.isEnabled() && this.active;
   }

   public boolean isShowPlayerModel() {
      return (Boolean)this.showPlayerModel.get();
   }

   public boolean isShowHands() {
      return (Boolean)this.showHands.get();
   }

   public boolean renderHands() {
      return !this.isActive() || this.isShowHands();
   }

   public boolean wasHoldingSneak() {
      return this.latchedSneak;
   }

   public double getInterpolatedX(float var1) {
      return class_3532.method_16436((double)var1, this.prevX, this.currentX);
   }

   public double getInterpolatedY(float var1) {
      return class_3532.method_16436((double)var1, this.prevY, this.currentY);
   }

   public double getInterpolatedZ(float var1) {
      return class_3532.method_16436((double)var1, this.prevZ, this.currentZ);
   }

   public float getInterpolatedYaw(float var1) {
      return class_3532.method_16439(var1, this.prevYaw, this.currentYaw);
   }

   public float getInterpolatedPitch(float var1) {
      return class_3532.method_16439(var1, this.prevPitch, this.currentPitch);
   }

   public class_243 getInterpolatedPos(float var1) {
      return new class_243(this.getInterpolatedX(var1), this.getInterpolatedY(var1), this.getInterpolatedZ(var1));
   }

   public void setRotation(float var1, float var2) {
      this.currentYaw = var1;
      this.currentPitch = class_3532.method_15363(var2, -90.0F, 90.0F);
   }

   public float getCurrentYaw() {
      return this.currentYaw;
   }

   public float getCurrentPitch() {
      return this.currentPitch;
   }

   public float getLookSensitivity() {
      return this.lookSensitivity.getFloat();
   }
}
