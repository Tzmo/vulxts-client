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
import net.minecraft.class_1309;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_239.class_240;

public class MaceBomberModule extends Module {
   public final SliderSetting height = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(">\u000f;B`\u009c"), Deobf.decrypt(";\u0003<Le\u009d\u0088\u009aòğĿŗĠƨƨǖǶȇȮɉɖˀʭ˕ˑ̞͖̱ͥΆήΕϠύМТѝѻ҇"), 8.0, 3.0, 30.0, 1.0, Deobf.decrypt("\u001b")));
   public final ModeSetting mode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt(";\u00056@"), Deobf.decrypt("2\u0003$@(\u009b\u0091Ãøě"), Deobf.decrypt("2\u0003 @k\u009c"), new String[]{Deobf.decrypt("2\u0003 @k\u009c"), Deobf.decrypt("%\u001a;Wi\u0084"), Deobf.decrypt("2\u000f>Dq\u008d\u0081")}));
   public final BooleanSetting autoMace = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u001f&J(¥\u0084Ùñ"), Deobf.decrypt("%\u001d3U(\u009c\u008a\u009aõŞľŚţƩǡǌǬɆȹɅɆʒ˯˘˘̅͵͒ͣϏθϐϵϏЏдЕѭҙҬӴӬԋԩ՚"), true));
   public final BooleanSetting switchBack = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u001d;Qk\u0080Åøõĝĸ"), Deobf.decrypt("$\u000f&Pz\u0086ÅÎûŞħœťǬƱǗǧȐȩɅɆʓ˯˃˛̞ͣ̓ͰΉήϐϡ\u0380Љйѐо҇ҠӦӷԊ"), false));
   private int spiralDir = 1;
   private int spiralTimer;
   private int cooldown;
   private int returnSlot = -1;
   private boolean strafing;

   public MaceBomberModule() {
      super(Deobf.decrypt(";\u000b1@(ª\u008a×öěġ"), Deobf.decrypt("\"\u0003?@{È\u0084\u009aòċĿŗŹǡƢǍǣȔȧɏɗˀʢˑ˔̷̔̀ͼΎΩϝγϏГѱсѶґӭӰӥԛէՙղւր"), Category.COMBAT);
   }

   protected void onDisable() {
      this.releaseStrafe();
      this.cooldown = 0;
      this.returnSlot = -1;
   }

   public void onTick() {
      class_310 client = class_310.method_1551();
      if (client.field_1724 != null && client.field_1761 != null && client.field_1755 == null) {
         if (this.cooldown > 0) {
            --this.cooldown;
         }

         if (client.field_1724.method_24828()) {
            this.releaseStrafe();
            this.cooldown = 0;
            this.returnSlot = -1;
         } else {
            class_1309 target = this.crosshairTarget(client);
            if (target == null) {
               this.releaseStrafe();
            } else {
               if (this.mode.is(Deobf.decrypt("%\u001a;Wi\u0084"))) {
                  this.spiral(client);
               } else {
                  this.releaseStrafe();
               }

               if (this.cooldown <= 0 && !(client.field_1724.field_6017 < (double)this.height.getFloat()) && (!this.mode.is(Deobf.decrypt("2\u000f>Dq\u008d\u0081")) || !(client.field_1724.method_18798().field_1351 > -0.5))) {
                  if (!client.field_1724.method_6047().method_31574(class_1802.field_49814)) {
                     if (!(Boolean)this.autoMace.get()) {
                        return;
                     }

                     if (this.returnSlot < 0) {
                        this.returnSlot = client.field_1724.method_31548().method_67532();
                     }

                     if (!InventoryHelper.swapToItem(class_1802.field_49814)) {
                        return;
                     }
                  }

                  if (!(client.field_1724.method_7261(0.5F) < 1.0F)) {
                     client.field_1761.method_2918(client.field_1724, target);
                     client.field_1724.method_6104(class_1268.field_5808);
                     this.cooldown = 6;
                     if ((Boolean)this.switchBack.get() && this.returnSlot >= 0) {
                        InventoryHelper.swap(this.returnSlot);
                     }

                     this.returnSlot = -1;
                  }
               }
            }
         }
      } else {
         this.releaseStrafe();
      }

   }

   private class_1309 crosshairTarget(class_310 client) {
      if (client.field_1765 != null && client.field_1765.method_17783() == class_240.field_1331) {
         class_1297 var3 = ((class_3966)client.field_1765).method_17782();
         if (!(var3 instanceof class_1309)) {
            return null;
         } else {
            class_1309 living = (class_1309)var3;
            return living != client.field_1724 && living.method_5805() ? living : null;
         }
      } else {
         return null;
      }
   }

   private void spiral(class_310 client) {
      if (--this.spiralTimer <= 0) {
         this.spiralDir = -this.spiralDir;
         this.spiralTimer = 6 + client.field_1724.field_6012 % 7;
      }

      client.field_1690.field_1913.method_23481(this.spiralDir < 0);
      client.field_1690.field_1849.method_23481(this.spiralDir > 0);
      this.strafing = true;
   }

   private void releaseStrafe() {
      if (this.strafing) {
         class_310 client = class_310.method_1551();
         if (client.field_1690 != null) {
            client.field_1690.field_1913.method_23481(false);
            client.field_1690.field_1849.method_23481(false);
         }

         this.strafing = false;
      }

   }
}
