package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.KeybindSetting;
import dev.vulxts.settings.SliderSetting;
import net.minecraft.class_10192;
import net.minecraft.class_1304;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_9334;
import org.lwjgl.glfw.GLFW;

public class ElytraSwapModule extends Module {
   public final KeybindSetting activateKey = (KeybindSetting)this.addSetting(new KeybindSetting(Deobf.decrypt("7\t&L~\u0089\u0091ß´ĵĶł"), Deobf.decrypt(""), 71));
   public final SliderSetting swapDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001d3U(¬\u0080Öõć"), Deobf.decrypt(""), 0.0, 0.0, 20.0, 1.0));
   public final BooleanSetting switchBack = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u001d;Qk\u0080Åøõĝĸ"), Deobf.decrypt(""), true));
   public final SliderSetting switchDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001d;Qk\u0080ÅþñĒĲł"), Deobf.decrypt(""), 0.0, 0.0, 20.0, 1.0));
   public final BooleanSetting moveToSlot = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(";\u0005$@(¼\u008a\u009aÇĒļŏ"), Deobf.decrypt(""), true));
   public final SliderSetting elytraSlot = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("3\u0006+Qz\u0089Åéøđħ"), Deobf.decrypt(""), 9.0, 1.0, 9.0, 1.0));
   private boolean keyWasDown;
   private boolean swappedToElytra;
   private int tickCounter;
   private boolean waitingForSwap;
   private boolean waitingForSwitchBack;

   public ElytraSwapModule() {
      super(Deobf.decrypt("3\u0006+Qz\u0089Åéãğģ"), Deobf.decrypt("%\u001d3U(\u008a\u0080ÎãěĶŕĠƉƭǜǶȔȡȊɒʎʫʐ˴̙Ͳ̀ͥΟζϔϧυѝЦќѪҜӭӦҤԉԢՄտ֜րן"), Category.COMBAT);
   }

   protected void onEnable() {
      this.resetState();
   }

   protected void onDisable() {
      this.resetState();
   }

   public void onTick() {
      class_310 client = class_310.method_1551();
      if (client.field_1724 != null && client.field_1761 != null) {
         if (this.waitingForSwap) {
            ++this.tickCounter;
            if (this.tickCounter >= this.swapDelay.getInt()) {
               this.performSwap(client);
               this.waitingForSwap = false;
               if ((Boolean)this.switchBack.get()) {
                  this.waitingForSwitchBack = true;
                  this.tickCounter = 0;
               }
            }
         } else if (this.waitingForSwitchBack) {
            ++this.tickCounter;
            if (this.tickCounter >= this.switchDelay.getInt()) {
               this.performSwap(client);
               this.waitingForSwitchBack = false;
            }
         } else {
            int key = (Integer)this.activateKey.get();
            if (key != -1) {
               long handle = client.method_22683().method_4490();
               boolean pressed = key <= 7 ? GLFW.glfwGetMouseButton(handle, key) == 1 : GLFW.glfwGetKey(handle, key) == 1;
               if (pressed && !this.keyWasDown) {
                  this.waitingForSwap = true;
                  this.tickCounter = 0;
               }

               this.keyWasDown = pressed;
            }
         }
      }

   }

   private void performSwap(class_310 client) {
      class_1799 chestSlot = client.field_1724.method_6118(class_1304.field_6174);
      boolean wearingElytra = chestSlot.method_31574(class_1802.field_8833);
      int targetSlot = -1;
      int i;
      class_1799 stack;
      if (wearingElytra) {
         for(i = 0; i < 36; ++i) {
            stack = client.field_1724.method_31548().method_5438(i);
            class_10192 equippable = (class_10192)stack.method_58694(class_9334.field_54196);
            if (equippable != null && equippable.comp_3174() == class_1304.field_6174 && !stack.method_31574(class_1802.field_8833)) {
               targetSlot = i;
               break;
            }
         }
      } else {
         if ((Boolean)this.moveToSlot.get()) {
            i = this.elytraSlot.getInt() - 1;
            stack = client.field_1724.method_31548().method_5438(i);
            if (stack.method_31574(class_1802.field_8833)) {
               targetSlot = i;
            }
         }

         if (targetSlot == -1) {
            for(i = 0; i < 36; ++i) {
               if (client.field_1724.method_31548().method_5438(i).method_31574(class_1802.field_8833)) {
                  targetSlot = i;
                  break;
               }
            }
         }
      }

      if (targetSlot != -1) {
         i = targetSlot < 9 ? targetSlot + 36 : targetSlot;
         int armorScreenSlot = 6;
         client.field_1761.method_2906(client.field_1724.field_7512.field_7763, i, 0, class_1713.field_7790, client.field_1724);
         client.field_1761.method_2906(client.field_1724.field_7512.field_7763, armorScreenSlot, 0, class_1713.field_7790, client.field_1724);
         client.field_1761.method_2906(client.field_1724.field_7512.field_7763, i, 0, class_1713.field_7790, client.field_1724);
         this.swappedToElytra = !wearingElytra;
      }

   }

   private void resetState() {
      this.keyWasDown = false;
      this.swappedToElytra = false;
      this.tickCounter = 0;
      this.waitingForSwap = false;
      this.waitingForSwitchBack = false;
   }
}
