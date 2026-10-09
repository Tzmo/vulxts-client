package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import java.util.Iterator;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2588;
import net.minecraft.class_310;
import net.minecraft.class_5250;
import net.minecraft.class_7417;
import net.minecraft.class_8828;

public class FakeRolesModule extends Module {
   public static final String ROLE_NONE = "None";
   public static final String ROLE_SRMOD = "SR.MOD";
   public static final String ROLE_MEDIA = "MEDIA";
   public static final String ROLE_SRADMIN = "SR.ADMIN";
   private static final int GRAY = 8355711;
   private static final int GREEN = 5635925;
   private static final int PINK = 16733695;
   private static final int RED = 16733269;
   private static final int WHITE = 16777215;
   public final ModeSetting role = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("$\u0005>@"), Deobf.decrypt("!\u0002;F`È\u0083ÛÿěųŉšƢƪƅǶȇȧȊɇʏ˯ˇ˒̐ͥ̓\u0378\u0381ϺϓϡϏГХЕѱҒӭӾӫԗԵԝճ֔փמ"), Deobf.decrypt("8\u0005<@"), new String[]{Deobf.decrypt("8\u0005<@"), Deobf.decrypt("%8|hG¬"), Deobf.decrypt(";/\u0016lI"), Deobf.decrypt("%8|dL¥¬ô")}));
   public final BooleanSetting nametag = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("8\u000b?@|\u0089\u0082"), Deobf.decrypt("%\u0002=R(\u009c\u008dß´ĊĲŜĠƣƯƅǻȉȵɘȓʆʣ˟˖̅;͝ͶϏδϔϾυЉађоӜӾӵӠՂԷ\u0558կֆցו֣"), true));
   public final BooleanSetting tabList = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u000b0\u0005D\u0081\u0096Î"), Deobf.decrypt("%\u0002=R(\u009c\u008dß´ĊĲŜĠƮƤǃǭȔȥȊɊʏʺ˂ʗ̟Ͷ͞ʹϏγϛγϔЕдЕѮҘҬӾӡԐէՑմֆ֛֢֚أؓ٘ٳ"), true));
   public final BooleanSetting chat = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u00023Q"), Deobf.decrypt("%\u0002=R(\u009c\u008dß´ĊĲŜĠƮƤǃǭȔȥȊɊʏʺ˂ʗ̟Ͷ͞ʹϏγϛγσЕасоҙҨӴӷԃԠ\u0558ծ"), true));

   public FakeRolesModule() {
      super(Deobf.decrypt("0\u000b9@Z\u0087\u0089ßç"), Deobf.decrypt("0\u000b9@(³¶èºĳĜſŝǬǮƅǙȫȅɮɺʡʒʐʘ͑͌̓͠ρΛϱϞϩгЌЕѬҕңӬҤԖԦ՚Խ֚ր֛׳ؘ؇وٺړګۊڿܜܷݶݥ"), Category.MISC);
   }

   public boolean isActive() {
      class_310 mc = class_310.method_1551();
      return this.isEnabled() && !this.role.is(Deobf.decrypt("8\u0005<@")) && mc.field_1724 != null;
   }

   private String selfName() {
      class_310 mc = class_310.method_1551();
      return mc.field_1724 == null ? null : mc.field_1724.method_7334().name();
   }

   private boolean isSelf(String exactName) {
      String me = this.selfName();
      return me != null && !me.isEmpty() && me.equals(exactName);
   }

   private int roleColor() {
      int var10000;
      switch ((String)this.role.get()) {
         case "SR.MOD":
            var10000 = 5635925;
            break;
         case "MEDIA":
            var10000 = 16733695;
            break;
         case "SR.ADMIN":
            var10000 = 16733269;
            break;
         default:
            var10000 = 16777215;
      }

      return var10000;
   }

   private class_2583 bracketStyle() {
      return class_2583.field_24360.method_36139(8355711).method_10982(false);
   }

   private class_2583 tagStyle() {
      return class_2583.field_24360.method_36139(this.roleColor()).method_10982(true);
   }

   private class_2583 nameStyle() {
      class_2583 var10000;
      switch ((String)this.role.get()) {
         case "SR.MOD":
            var10000 = class_2583.field_24360.method_36139(5635925).method_10982(true);
            break;
         case "SR.ADMIN":
            var10000 = class_2583.field_24360.method_36139(16733269).method_10982(true);
            break;
         case "MEDIA":
            var10000 = class_2583.field_24360.method_36139(16777215).method_10982(false);
            break;
         default:
            var10000 = class_2583.field_24360;
      }

      return var10000;
   }

   public class_2561 tagComponent() {
      return class_2561.method_43473().method_10852(class_2561.method_43470(Deobf.decrypt("-")).method_10862(this.bracketStyle())).method_10852(class_2561.method_43470((String)this.role.get()).method_10862(this.tagStyle())).method_10852(class_2561.method_43470(Deobf.decrypt("+J")).method_10862(this.bracketStyle()));
   }

   public class_2561 buildPrefixedDisplayName(String name) {
      return this.isActive() && name != null ? class_2561.method_43473().method_10852(this.tagComponent()).method_10852(class_2561.method_43470(name).method_10862(this.nameStyle())) : null;
   }

   public class_2561 decorateNametag(class_2561 tag) {
      return this.isActive() && (Boolean)this.nametag.get() ? this.modifyText(tag) : tag;
   }

   public class_2561 decorateTab(class_2561 display, String realName) {
      if (this.isActive() && (Boolean)this.tabList.get()) {
         class_2561 prefixed = this.isSelf(realName) ? this.buildPrefixedDisplayName(realName) : null;
         return prefixed != null ? prefixed : display;
      } else {
         return display;
      }
   }

   public class_2561 decorateChat(class_2561 input) {
      return this.isActive() && (Boolean)this.chat.get() ? this.modifyText(input) : input;
   }

   private class_2561 modifyText(class_2561 input) {
      if (input == null) {
         return null;
      } else {
         String me = this.selfName();
         return me != null && !me.isBlank() && input.getString().contains(me) ? this.splice(input, me, new boolean[]{false}) : input;
      }
   }

   private class_2561 splice(class_2561 c, String name, boolean[] done) {
      class_7417 contents = c.method_10851();
      class_5250 result;
      int i;
      if (!done[0] && contents instanceof class_8828 ptc) {
         String text = ptc.comp_737();
         int idx = text.indexOf(name);
         if (idx >= 0) {
            done[0] = true;
            result = class_2561.method_43473();
            if (idx > 0) {
               result.method_10852(class_2561.method_43470(text.substring(0, idx)).method_10862(c.method_10866()));
            }

            result.method_10852(this.buildPrefixedDisplayName(name));
            i = idx + name.length();
            if (i < text.length()) {
               result.method_10852(class_2561.method_43470(text.substring(i)).method_10862(c.method_10866()));
            }
         } else {
            result = class_5250.method_43477(contents).method_10862(c.method_10866());
         }
      } else if (!done[0] && contents instanceof class_2588 tc) {
         Object[] args = tc.method_11023();
         Object[] out = new Object[args.length];

         for(i = 0; i < args.length; ++i) {
            Object arg = args[i];
            if (arg instanceof class_2561 ac) {
               out[i] = this.splice(ac, name, done);
            } else {
               if (!done[0] && arg instanceof String s) {
                  if (s.contains(name)) {
                     done[0] = true;
                     int idx = s.indexOf(name);
                     class_5250 split = class_2561.method_43473();
                     if (idx > 0) {
                        split.method_10852(class_2561.method_43470(s.substring(0, idx)));
                     }

                     split.method_10852(this.buildPrefixedDisplayName(name));
                     int end = idx + name.length();
                     if (end < s.length()) {
                        split.method_10852(class_2561.method_43470(s.substring(end)));
                     }

                     out[i] = split;
                     continue;
                  }
               }

               out[i] = arg;
            }
         }

         result = class_5250.method_43477(new class_2588(tc.method_11022(), tc.method_48323(), out)).method_10862(c.method_10866());
      } else {
         result = class_5250.method_43477(contents).method_10862(c.method_10866());
      }

      Iterator var17 = c.method_10855().iterator();

      while(var17.hasNext()) {
         class_2561 sibling = (class_2561)var17.next();
         result.method_10852(this.splice(sibling, name, done));
      }

      return result;
   }
}
