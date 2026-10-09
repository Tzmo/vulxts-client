package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.KeybindSetting;
import dev.vulxts.settings.ModeSetting;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_239.class_240;

public class CoordSnapperModule extends Module {
   public final ModeSetting format = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("0\u0005 Hi\u009c"), Deobf.decrypt("5\u0006;Uj\u0087\u0084ÈðŞĵŔŲơƠǑƬ"), Deobf.decrypt(".J\u000b\u0005R"), new String[]{Deobf.decrypt(".J\u000b\u0005R"), Deobf.decrypt("<9\u001dk"), Deobf.decrypt("5\u0005?Hi\u0086\u0081")}));
   public final ModeSetting target = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("\"\u000b Bm\u009c"), Deobf.decrypt("!\u0002;F`È\u0086ÕûČķŒŮƭƵǀǱɆȴɅȓʃʠˀˎ͟"), Deobf.decrypt(":\u0005=Nm\u008cÈÛàŞđŗůƯƪ"), new String[]{Deobf.decrypt(":\u0005=Nm\u008cÈÛàŞđŗůƯƪ"), Deobf.decrypt("&\u00063\\m\u009a")}));
   public final KeybindSetting copyKey = (KeybindSetting)this.addSetting(new KeybindSetting(Deobf.decrypt("5\u0005\"\\(£\u0080Ã"), Deobf.decrypt("&\u00187V{È\u0091Õ´ĝļŋŹǬƵǍǧɆȣɅɜʒʫ˙˙͖̐ͣ͢ρ"), -1));
   public final BooleanSetting notify = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("8\u0005&Ln\u0091"), Deobf.decrypt("%\u0002=R(\u0089ÅÙûĐĵŒŲơƠǑǫȉȮȊɄʈʪ˞ʗ̒\u0378̓\u0378ΊξΛ"), true));
   private String lastCopied = Deobf.decrypt("");

   public CoordSnapperModule() {
      super(Deobf.decrypt("5\u0005=Wl»\u008bÛäĎĶŉ"), Deobf.decrypt("5\u0005\"Lm\u009bÅÖûđĸŞŤǡƠǑƢȅȯɅɁʄʦ˞˖̅Ͳ̱̀Θγρϻ\u0380ВпѐоҟҨӾҪ"), Category.MISC);
   }

   public String lastCopied() {
      return this.lastCopied;
   }

   public boolean onKeyPress(int keyCode) {
      if (!this.copyKey.matches(keyCode)) {
         return false;
      } else {
         this.snap();
         return true;
      }
   }

   private void snap() {
      class_310 mc = class_310.method_1551();
      if (mc.field_1724 != null) {
         class_2338 pos = this.resolvePos(mc);
         if (pos == null) {
            if ((Boolean)this.notify.get()) {
               VulxtsClient.notifications().pushInfo(Deobf.decrypt("5\u0005=Wl»\u008bÛäĎĶŉĠŻǡǋǭɆȢɆɜʃʤʐ˞̷̟ͅ\u0378Ίέ"));
            }
         } else {
            String var10000;
            switch ((String)this.format.get()) {
               case "JSON":
                  var10000 = "{\"x\": " + pos.method_10263() + ", \"y\": " + pos.method_10264() + ", \"z\": " + pos.method_10260() + "}";
                  break;
               case "Command":
                  var10000 = "/tp " + pos.method_10263() + " " + pos.method_10264() + " " + pos.method_10260();
                  break;
               default:
                  var10000 = pos.method_10263() + " " + pos.method_10264() + " " + pos.method_10260();
            }

            String text = var10000;
            mc.field_1774.method_1455(text);
            this.lastCopied = text;
            if ((Boolean)this.notify.get()) {
               VulxtsClient.notifications().pushInfo("Copied · " + text);
            }
         }
      }

   }

   private class_2338 resolvePos(class_310 mc) {
      if (this.target.is(Deobf.decrypt("&\u00063\\m\u009a"))) {
         return mc.field_1724.method_24515();
      } else {
         class_239 hit = mc.field_1765;
         class_2338 var10000;
         if (hit instanceof class_3965) {
            class_3965 block = (class_3965)hit;
            if (hit.method_17783() == class_240.field_1332) {
               var10000 = block.method_17777();
               return var10000;
            }
         }

         var10000 = null;
         return var10000;
      }
   }
}
