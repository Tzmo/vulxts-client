package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import java.util.Random;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1743;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_239.class_240;

public class TriggerbotModule extends Module {
   public final SliderSetting minDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(";\u0003<\u0005L\u008d\u0089Ûí"), Deobf.decrypt(""), 9.0, 0.0, 20.0, 1.0));
   public final SliderSetting maxDelay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(";\u000b*\u0005L\u008d\u0089Ûí"), Deobf.decrypt(""), 11.0, 0.0, 20.0, 1.0));
   public final BooleanSetting onlyItem = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("9\u0004>\\(¡\u0091ßù"), Deobf.decrypt(""), false));
   public final ModeSetting itemFilter = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("?\u001e7H(®\u008cÖàěġ"), Deobf.decrypt(""), Deobf.decrypt("%\u001d=Wl"), new String[]{Deobf.decrypt("%\u001d=Wl"), Deobf.decrypt("7\u00127"), Deobf.decrypt(">\u000b<A")}));
   public final BooleanSetting onlyCrit = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("9\u0004>\\(«\u0097Óà"), Deobf.decrypt(""), false));
   public final BooleanSetting checkShield = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u00027FcÈ¶ÒýěĿş"), Deobf.decrypt(""), false));
   private final Random random = new Random();
   private int tickCounter;
   private int currentDelay = 10;

   public TriggerbotModule() {
      super(Deobf.decrypt("\"\u0018;Bo\u008d\u0097ØûĊ"), Deobf.decrypt("7\u001f&J%\u0089\u0091ÎõĝĸňĠƩƯǑǫȒȩɏɀˀʠ˞ʗ̒ͥ͜͢ΜβϔϺϒ"), Category.COMBAT);
   }

   protected void onEnable() {
      this.tickCounter = 0;
      this.randomizeDelay();
   }

   protected void onDisable() {
      this.tickCounter = 0;
   }

   public void onTick() {
      class_310 client = class_310.method_1551();
      if (client.field_1724 != null && client.field_1761 != null && client.field_1755 == null) {
         if (client.field_1765 != null && client.field_1765.method_17783() == class_240.field_1331) {
            class_1297 target = ((class_3966)client.field_1765).method_17782();
            if (target instanceof class_1309 && target != client.field_1724) {
               if ((Boolean)this.onlyItem.get()) {
                  if (this.itemFilter.is(Deobf.decrypt("%\u001d=Wl")) && !this.isSword(client.field_1724.method_6047().method_7909())) {
                     return;
                  }

                  if (this.itemFilter.is(Deobf.decrypt("7\u00127")) && !(client.field_1724.method_6047().method_7909() instanceof class_1743)) {
                     return;
                  }

                  if (this.itemFilter.is(Deobf.decrypt(">\u000b<A")) && !client.field_1724.method_6047().method_7960()) {
                     return;
                  }
               }

               if (!(Boolean)this.onlyCrit.get() || !client.field_1724.method_24828() && !(client.field_1724.field_6017 <= 0.0)) {
                  if ((Boolean)this.checkShield.get() && target instanceof class_1657) {
                     class_1657 targetPlayer = (class_1657)target;
                     if (targetPlayer.method_6039()) {
                        return;
                     }
                  }

                  if (!(client.field_1724.method_7261(0.5F) < 1.0F)) {
                     ++this.tickCounter;
                     if (this.tickCounter >= this.currentDelay) {
                        client.field_1761.method_2918(client.field_1724, target);
                        client.field_1724.method_6104(class_1268.field_5808);
                        this.tickCounter = 0;
                        this.randomizeDelay();
                     }
                  }
               }
            }
         } else {
            this.tickCounter = 0;
         }
      }

   }

   private boolean isSword(class_1792 item) {
      return item == class_1802.field_8091 || item == class_1802.field_8528 || item == class_1802.field_8371 || item == class_1802.field_8845 || item == class_1802.field_8802 || item == class_1802.field_22022;
   }

   private void randomizeDelay() {
      int min = this.minDelay.getInt();
      int max = this.maxDelay.getInt();
      if (max < min) {
         max = min;
      }

      this.currentDelay = min + (max > min ? this.random.nextInt(max - min + 1) : 0);
   }
}
