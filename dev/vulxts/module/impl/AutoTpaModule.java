package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.settings.StringSetting;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_310;

public class AutoTpaModule extends Module {
   public final ModeSetting mode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt(";\u00056@"), Deobf.decrypt("!\u0002;F`È\u0097ßåċĶňŴǬƵǊƢȕȥɄɗˎ"), Deobf.decrypt("\":\u0013"), new String[]{Deobf.decrypt("\":\u0013"), Deobf.decrypt("\":\u0013mm\u009a\u0080")}));
   public final StringSetting target = (StringSetting)this.addSetting(new StringSetting(Deobf.decrypt("\"\u000b Bm\u009c"), Deobf.decrypt("&\u00063\\m\u009aÅÎûŞĠŞŮƨǡǑǪȃɠɘɖʑʺ˕˄̷͇̅;ρ"), Deobf.decrypt(""), 32, Deobf.decrypt("%\u001e7Sm")));
   public final SliderSetting delay = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("2\u000f>Dq"), Deobf.decrypt("\"\u0003?@(\u008a\u0080ÎãěĶŕĠƾƤǔǷȃȳɞɀˀ⋛ʐ˛̞͖ͣ͠ϏγφγφМТсѻ҆ӣ"), 2000.0, 250.0, 10000.0, 50.0, Deobf.decrypt("\u001b\u0019")));
   public final SliderSetting humanize = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(">\u001f?Df\u0081\u009fß"), Deobf.decrypt("$\u000b<Ag\u0085Å\u0091»œųňŷƥƯǂƢȉȮȊɖʁʬ˘ʗ̕Ͳ͟ͰΖϺφϼ\u0380ЉйѐоҀҤӪӭԌԠԝմֆր֜\u05feؚٗؓؼڕڤہۻݞݶݹݯޚߥ߉ߘߡࠧ\u086fࡆࡦ\u0884ࢳ\u08c2ࣟटऽऄऍৗড\u0984\u09bb\u0a0eਲਖ਼\u0a37"), 25.0, 0.0, 60.0, 5.0, Deobf.decrypt("S")));
   public final BooleanSetting notify = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("8\u0005&Ln\u0091"), Deobf.decrypt("%\u0002=R(\u0089ÅÔûĊĺŝũƯƠǑǫȉȮȊɖʁʬ˘ʗ̅;͞ʹϏλΕϡυЌФѐѭҀӭӮӷՂԴ\u0558ճց׀"), false));
   private long nextSendAtMs = -1L;
   private String lastSent;

   public AutoTpaModule() {
      super(Deobf.decrypt("7\u001f&J\\¸¤"), Deobf.decrypt("%\u001a3H{È±êÕŞġŞűƹƤǖǶȕɠɋɇˀʮʐ˃͔̐ͥʹΛϺϚϽ\u0380МѱѝѫҙҬөӭԘԢՙԽցևז\u05ef\u0605ٜ"), Category.MISC);
   }

   protected void onEnable() {
      if (((String)this.target.get()).trim().isEmpty()) {
         VulxtsClient.notifications().pushInfo(Deobf.decrypt("7\u001f&J\\¸¤\u009a#ŞĠŞŴǬƠƅǖȇȲɍɖʔ˯˖˞͇̃ͤ"));
      }

      this.lastSent = null;
      this.nextSendAtMs = 0L;
   }

   protected void onDisable() {
      this.nextSendAtMs = -1L;
   }

   public void onTick() {
      if (this.nextSendAtMs >= 0L) {
         class_310 mc = class_310.method_1551();
         if (mc.field_1724 != null && mc.field_1724.field_3944 != null && System.currentTimeMillis() >= this.nextSendAtMs) {
            String name = ((String)this.target.get()).trim();
            if (name.isEmpty()) {
               this.nextSendAtMs = this.scheduleNext();
            } else {
               String var10000 = this.mode.is(Deobf.decrypt("\":\u0013mm\u009a\u0080")) ? Deobf.decrypt("\u0002\u001a3Mm\u009a\u0080\u009a") : Deobf.decrypt("\u0002\u001a3\u0005");
               String cmd = var10000 + name;
               mc.field_1724.field_3944.method_45730(cmd);
               this.lastSent = cmd;
               if ((Boolean)this.notify.get()) {
                  VulxtsClient.notifications().pushInfo("AutoTPA · /" + cmd);
               }

               this.nextSendAtMs = this.scheduleNext();
            }
         }
      }

   }

   public String lastSent() {
      return this.lastSent;
   }

   private long scheduleNext() {
      double base = (Double)this.delay.get();
      double j = (Double)this.humanize.get() / 100.0;
      double factor = j <= 0.0 ? 1.0 : 1.0 + (ThreadLocalRandom.current().nextDouble() * 2.0 - 1.0) * j;
      long wait = Math.max(0L, Math.round(base * factor));
      return System.currentTimeMillis() + wait;
   }
}
