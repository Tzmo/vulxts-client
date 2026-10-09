package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.util.InventoryHelper;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1743;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_239.class_240;

public class ShieldBreakerModule extends Module {
   public final BooleanSetting switchBack = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u001d;Qk\u0080Åøõĝĸ"), Deobf.decrypt(""), true));
   public final ModeSetting axePriority = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("7\u00127\u0005X\u009a\u008cÕæėħł"), Deobf.decrypt(""), Deobf.decrypt("4\u000f!Q"), new String[]{Deobf.decrypt("4\u000f!Q"), Deobf.decrypt("8\u000f3Wm\u009b\u0091")}));
   public final SliderSetting switchDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001d;Qk\u0080ÅþñĒĲł"), Deobf.decrypt(""), 150.0, 0.0, 500.0, 10.0));
   private int previousSlot = -1;
   private int tickCounter;
   private boolean waitingToSwapBack;

   public ShieldBreakerModule() {
      super(Deobf.decrypt("%\u0002;@d\u008cÅøæěĲŐťƾ"), Deobf.decrypt("7\u001f&J%\u009b\u0092ÓàĝĻěŴƣǡǄǺȃɠɝɛʅʡʐ˃͔̐ͥʹΛϺϜϠ\u0380ПнњѽҟҤөӣ"), Category.COMBAT);
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
         int axeSlot;
         if (this.waitingToSwapBack) {
            ++this.tickCounter;
            axeSlot = Math.max(1, this.switchDelay.getInt() / 50);
            if (this.tickCounter >= axeSlot) {
               InventoryHelper.swap(this.previousSlot);
               this.resetState();
            }
         } else if (client.field_1765 != null && client.field_1765.method_17783() == class_240.field_1331) {
            class_1297 var4 = ((class_3966)client.field_1765).method_17782();
            if (var4 instanceof class_1657) {
               class_1657 targetPlayer = (class_1657)var4;
               if (targetPlayer.method_6039() && !(client.field_1724.method_6047().method_7909() instanceof class_1743)) {
                  axeSlot = this.findAxeSlot(client);
                  if (axeSlot != -1) {
                     this.previousSlot = client.field_1724.method_31548().method_67532();
                     InventoryHelper.swap(axeSlot);
                     client.field_1761.method_2918(client.field_1724, targetPlayer);
                     client.field_1724.method_6104(class_1268.field_5808);
                     if ((Boolean)this.switchBack.get()) {
                        this.waitingToSwapBack = true;
                        this.tickCounter = 0;
                     } else {
                        this.previousSlot = -1;
                     }
                  }
               }
            }
         }
      }

   }

   private int findAxeSlot(class_310 client) {
      int bestSlot;
      if (this.axePriority.is(Deobf.decrypt("8\u000f3Wm\u009b\u0091"))) {
         for(bestSlot = 0; bestSlot < 9; ++bestSlot) {
            if (client.field_1724.method_31548().method_5438(bestSlot).method_7909() instanceof class_1743) {
               return bestSlot;
            }
         }

         return -1;
      } else {
         bestSlot = -1;
         float bestDamage = -1.0F;

         for(int i = 0; i < 9; ++i) {
            class_1799 stack = client.field_1724.method_31548().method_5438(i);
            if (stack.method_7909() instanceof class_1743) {
               float damage = this.getAxeTier(stack);
               if (damage > bestDamage) {
                  bestDamage = damage;
                  bestSlot = i;
               }
            }
         }

         return bestSlot;
      }
   }

   private float getAxeTier(class_1799 stack) {
      if (stack.method_31574(class_1802.field_22025)) {
         return 5.0F;
      } else if (stack.method_31574(class_1802.field_8556)) {
         return 4.0F;
      } else if (stack.method_31574(class_1802.field_8475)) {
         return 3.0F;
      } else if (stack.method_31574(class_1802.field_8825)) {
         return 2.0F;
      } else if (stack.method_31574(class_1802.field_8062)) {
         return 1.0F;
      } else {
         return stack.method_31574(class_1802.field_8406) ? 0.0F : -1.0F;
      }
   }

   private void resetState() {
      this.previousSlot = -1;
      this.tickCounter = 0;
      this.waitingToSwapBack = false;
   }
}
