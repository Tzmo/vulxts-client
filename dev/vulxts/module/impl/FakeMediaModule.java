package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.StringSetting;
import net.minecraft.class_11719;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2960;
import net.minecraft.class_5250;

public final class FakeMediaModule extends Module {
   public final BooleanSetting mediaBadge = (BooleanSetting)this.addSetting(new BooleanSetting("Media Badge", "Show the media badge beside your own nametag.", true));
   public final BooleanSetting bluePlus = (BooleanSetting)this.addSetting(new BooleanSetting("Blue Plus", "Show the blue plus beside your own nametag.", false));
   public final StringSetting displayName = (StringSetting)this.addSetting(new StringSetting("Display Name", "Optional local display name. Leave blank to use your Minecraft name.", "", 32, "Minecraft name"));

   public FakeMediaModule() {
      super("Fake Media", "Adds local media styling to your own nametag.", Category.MISC);
   }

   public boolean hasVisibleBadge() {
      return this.isEnabled() && ((Boolean)this.mediaBadge.get() || (Boolean)this.bluePlus.get());
   }

   public class_2561 decorate(class_2561 var1) {
      if (this.hasVisibleBadge() && var1 != null) {
         String var2 = ((String)this.displayName.get()).trim();
         class_2561 var3 = var2.isEmpty() ? var1 : class_2561.method_43470(var2);
         class_5250 var4 = class_2561.method_43473();
         if ((Boolean)this.bluePlus.get()) {
            var4.method_10852(icon("\ue002"));
         }

         if ((Boolean)this.mediaBadge.get()) {
            var4.method_10852(icon("\ue001"));
         }

         return var4.method_10852(((class_2561)var3).method_27661());
      } else {
         return var1;
      }
   }

   private static class_2561 icon(String var0) {
      return class_2561.method_43470(var0).method_10862(class_2583.field_24360.method_27704(new class_11719.class_11721(class_2960.method_60655("fake_media", "default"))));
   }
}
