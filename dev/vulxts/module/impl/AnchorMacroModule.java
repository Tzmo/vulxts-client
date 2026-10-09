package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.util.BlockHelper;
import dev.vulxts.util.InventoryHelper;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_239.class_240;
import org.lwjgl.glfw.GLFW;

public class AnchorMacroModule extends Module {
   public final SliderSetting switchDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001d;Qk\u0080ÅþñĒĲł"), Deobf.decrypt(""), 0.0, 0.0, 20.0, 1.0));
   public final SliderSetting glowstoneDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("1\u0006=R{\u009c\u008aÔñŞėŞŬƭƸ"), Deobf.decrypt(""), 0.0, 0.0, 20.0, 1.0));
   public final SliderSetting explodeDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("3\u0012\"Ig\u008c\u0080\u009aÐěĿŚŹ"), Deobf.decrypt(""), 0.0, 0.0, 20.0, 1.0));
   public final SliderSetting totemSlot = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("\"\u0005&@eÈ¶ÖûĊ"), Deobf.decrypt(""), 1.0, 1.0, 9.0, 1.0));
   public final BooleanSetting autoSwitchBack = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u001f&J(»\u0092ÓàĝĻěłƭƢǎ"), Deobf.decrypt(""), true));
   public final SliderSetting switchBackDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001d;Qk\u0080ÅøõĝĸěńƩƭǄǻ"), Deobf.decrypt(""), 2.0, 0.0, 20.0, 1.0));
   private int step;
   private int tickCounter;
   private class_2338 targetPos;
   private int previousSlot = -1;

   public AnchorMacroModule() {
      super(Deobf.decrypt("7\u00041Mg\u009aÅ÷õĝġŔ"), Deobf.decrypt("7\u001f&Je\u0089\u0091Ó÷ğĿŗŹǬƣǉǭȑȳȊɆʐ˯˂˒̂ͧ͒ͦ\u0381ϺϔϽσЕочѭ"), Category.COMBAT);
   }

   protected void onEnable() {
      this.resetState();
   }

   protected void onDisable() {
      this.resetState();
   }

   public void onTick() {
      class_310 client = class_310.method_1551();
      if (client.field_1724 != null && client.field_1761 != null && client.field_1687 != null) {
         if (this.step > 0) {
            this.processStep(client);
         } else {
            long handle = client.method_22683().method_4490();
            boolean rmb = GLFW.glfwGetMouseButton(handle, 1) == 1;
            if (rmb && client.field_1765 != null && client.field_1765.method_17783() == class_240.field_1332) {
               class_3965 hit = (class_3965)client.field_1765;
               class_2338 pos = hit.method_17777();
               if (BlockHelper.isBlockAt(pos, class_2246.field_23152)) {
                  this.targetPos = pos;
                  this.previousSlot = client.field_1724.method_31548().method_67532();
                  if (BlockHelper.isAnchorUncharged(pos)) {
                     this.step = 1;
                     this.tickCounter = 0;
                  } else if (BlockHelper.isAnchorCharged(pos)) {
                     this.step = 3;
                     this.tickCounter = 0;
                  }
               }
            }
         }
      }

   }

   private void processStep(class_310 client) {
      ++this.tickCounter;
      class_239 var4 = client.field_1765;
      class_3965 var10000;
      if (var4 instanceof class_3965 bhr) {
         var10000 = bhr;
      } else {
         var10000 = null;
      }

      class_3965 hit = var10000;
      switch (this.step) {
         case 1:
            if (this.tickCounter >= this.switchDelay.getInt()) {
               InventoryHelper.swapToItem(class_1802.field_8801);
               this.step = 2;
               this.tickCounter = 0;
            }
            break;
         case 2:
            if (this.tickCounter >= this.glowstoneDelay.getInt()) {
               if (hit != null && this.targetPos.equals(hit.method_17777())) {
                  BlockHelper.interactBlock(hit, true);
               }

               this.step = 3;
               this.tickCounter = 0;
            }
            break;
         case 3:
            if (this.tickCounter >= this.explodeDelay.getInt()) {
               InventoryHelper.swap(this.totemSlot.getInt() - 1);
               this.step = 4;
               this.tickCounter = 0;
            }
            break;
         case 4:
            if (this.tickCounter >= 1) {
               if (hit != null && this.targetPos.equals(hit.method_17777())) {
                  BlockHelper.interactBlock(hit, true);
               }

               if ((Boolean)this.autoSwitchBack.get() && this.previousSlot >= 0) {
                  this.step = 5;
                  this.tickCounter = 0;
               } else {
                  this.resetState();
               }
            }
            break;
         case 5:
            if (this.tickCounter >= this.switchBackDelay.getInt()) {
               InventoryHelper.swap(this.previousSlot);
               this.resetState();
            }
            break;
         default:
            this.resetState();
      }

   }

   private void resetState() {
      this.step = 0;
      this.tickCounter = 0;
      this.targetPos = null;
      this.previousSlot = -1;
   }
}
