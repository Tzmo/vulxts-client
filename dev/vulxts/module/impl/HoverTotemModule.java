package dev.vulxts.module.impl;

import dev.vulxts.mixin.AbstractContainerScreenAccessor;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.util.InventoryHelper;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;

public class HoverTotemModule extends Module {
   public final SliderSetting tickDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("\"\u00031N(¬\u0080Öõć"), Deobf.decrypt(""), 0.0, 0.0, 20.0, 1.0));
   public final BooleanSetting hotbarTotem = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u0005&Gi\u009aÅîûĊĶŖ"), Deobf.decrypt(""), true));
   public final SliderSetting hotbarSlot = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(">\u0005&Gi\u009aÅéøđħ"), Deobf.decrypt(""), 1.0, 1.0, 9.0, 1.0));
   public final BooleanSetting autoSwitchToTotem = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u001f&J(»\u0092ÓàĝĻěŔƣǡǱǭȒȥɇ"), Deobf.decrypt(""), false));
   private int tickCounter;

   public HoverTotemModule() {
      super(Deobf.decrypt(">\u0005$@zÈ±Õàěľ"), Deobf.decrypt("3\u001b'LxÈ\u0091ÕàěľěŷƤƤǋƢȎȯɜɖʒʦ˞ː͑\u0378ͅʹΝϺϚϽυѝићоҝңӱӡԌԳՒկ\u058c"), Category.COMBAT);
   }

   protected void onEnable() {
      this.tickCounter = 0;
   }

   protected void onDisable() {
      this.tickCounter = 0;
   }

   public void onTick() {
      class_310 client = class_310.method_1551();
      if (client.field_1724 != null && client.field_1761 != null) {
         if ((Boolean)this.autoSwitchToTotem.get() && (Boolean)this.hotbarTotem.get()) {
            int slot = this.hotbarSlot.getInt() - 1;
            if (client.field_1724.method_31548().method_5438(slot).method_31574(class_1802.field_8288)) {
               InventoryHelper.swap(slot);
            }
         }

         class_437 var3 = client.field_1755;
         if (var3 instanceof class_465) {
            class_465 handledScreen = (class_465)var3;
            ++this.tickCounter;
            if (this.tickCounter >= this.tickDelay.getInt()) {
               this.tickCounter = 0;
               class_1735 focusedSlot = this.getFocusedSlot(handledScreen);
               if (focusedSlot != null && focusedSlot.method_7681() && focusedSlot.method_7677().method_31574(class_1802.field_8288)) {
                  int slotId = focusedSlot.field_7874;
                  client.field_1761.method_2906(handledScreen.method_17577().field_7763, slotId, 0, class_1713.field_7790, client.field_1724);
                  client.field_1761.method_2906(handledScreen.method_17577().field_7763, 45, 0, class_1713.field_7790, client.field_1724);
                  client.field_1761.method_2906(handledScreen.method_17577().field_7763, slotId, 0, class_1713.field_7790, client.field_1724);
               }
            }
         }
      }

   }

   private class_1735 getFocusedSlot(class_465 screen) {
      return ((AbstractContainerScreenAccessor)screen).getHoveredSlot();
   }
}
