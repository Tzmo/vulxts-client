package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.KeybindSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.StringSetting;
import net.minecraft.class_310;
import net.minecraft.class_408;

public class ChatMacroModule extends Module {
   private static final int SLOTS = 3;
   public final ModeSetting slot = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("%\u0006=Q"), Deobf.decrypt(";\u000b1WgÈ\u0096ÖûĊųŏůǬƤǁǫȒɮ"), Deobf.decrypt("G"), new String[]{Deobf.decrypt("G"), Deobf.decrypt("D"), Deobf.decrypt("E")}));
   public final BooleanSetting sendInstantly = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u000f<A(¡\u008bÉàğĽŏŬƵ"), Deobf.decrypt("%\u0001;U(\u009c\u008dß´ĝĻŚŴǬƱǗǧȐȩɏɄˀʮ˞˓͖͑ͤͿ\u038bϺϜϾύИеќѿҀҨӫӽՌ"), true));
   private final StringSetting[] messages = new StringSetting[3];
   private final KeybindSetting[] keys = new KeybindSetting[3];

   public ChatMacroModule() {
      super(Deobf.decrypt("5\u00023QE\u0089\u0086Èû"), Deobf.decrypt("4\u0003<Ai\u008a\u0089ß´ĝĻŚŴǬƢǊǯȋȡɄɗˀʢˑ˔̃\u0378̀̿"), Category.CLIENT);

      for(int i = 0; i < 3; ++i) {
         String num = Integer.toString(i + 1);
         this.messages[i] = (StringSetting)this.addSetting(new StringSetting("Message " + num, "Message or /command for slot " + num, Deobf.decrypt(""), 256, Deobf.decrypt("Y\u00193\\(\u0080\u008c")));
         this.keys[i] = (KeybindSetting)this.addSetting(new KeybindSetting("Key " + num, "Key that runs slot " + num, -1));
         this.messages[i].visibleWhen(() -> {
            return this.slot.is(num);
         });
         this.keys[i].visibleWhen(() -> {
            return this.slot.is(num);
         });
      }

   }

   public boolean onKeyPress(int keyCode) {
      boolean handled = false;

      for(int i = 0; i < 3; ++i) {
         if (this.keys[i].matches(keyCode)) {
            this.run((String)this.messages[i].get());
            handled = true;
         }
      }

      return handled;
   }

   private void run(String message) {
      if (message != null && !message.isBlank()) {
         class_310 mc = class_310.method_1551();
         if (mc.field_1724 != null && mc.field_1724.field_3944 != null) {
            if (!(Boolean)this.sendInstantly.get()) {
               mc.method_1507(new class_408(message, false));
            } else if (message.startsWith(Deobf.decrypt("Y"))) {
               mc.field_1724.field_3944.method_45730(message.substring(1));
            } else {
               mc.field_1724.field_3944.method_45729(message);
            }
         }
      }

   }
}
