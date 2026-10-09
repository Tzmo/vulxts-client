package dev.vulxts.module.impl;

import com.mojang.authlib.GameProfile;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.StringSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_2561;
import net.minecraft.class_2588;
import net.minecraft.class_310;
import net.minecraft.class_5250;
import net.minecraft.class_634;
import net.minecraft.class_640;
import net.minecraft.class_7417;
import net.minecraft.class_8828;

public class NameProtectModule extends Module {
   public final StringSetting ownName = (StringSetting)this.addSetting(new StringSetting(Deobf.decrypt("/\u0005'W(©\u0089Óõč"), Deobf.decrypt("!\u00023Q(\u0091\u008aÏæŞļŌŮǬƯǄǯȃɠɃɀˀʽ˕ˇ̝Ͷ͐ʹ\u038bϺςϺϔЕ"), Deobf.decrypt("/\u0005'"), 16, Deobf.decrypt("/\u0005'")));
   public final ModeSetting style = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("9\u001e:@z\u009b"), Deobf.decrypt(">\u0005%\u0005g\u009c\u008dßæŞģŗšƵƤǗǱɁɠɄɒʍʪ˃ʗ͖̱̐ͥΝουϿρОдё"), Deobf.decrypt("7\u0006;D{\u008d\u0096"), new String[]{Deobf.decrypt("7\u0006;D{\u008d\u0096"), Deobf.decrypt("4\u00063Kc"), Deobf.decrypt("&\u00063\\m\u009aÅ\u0099")}));
   public final BooleanSetting selfOnly = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u000f>C(§\u008bÖí"), Deobf.decrypt("9\u0004>\\(\u0080\u008cÞñŞĪŔŵƾǡǊǵȈɠɄɒʍʪʜʗ̝Ͳ͒ͧΊϺϚϧψИУцоҕҡӨӪԇ"), false));
   private static final int SEEN_CAP = 256;
   private final LinkedHashMap seen = new LinkedHashMap(16, 0.75F, true) {
      protected boolean removeEldestEntry(Map.Entry eldest) {
         return this.size() > 256;
      }
   };
   private String cacheSig = null;
   private Map cachedTargets = Map.of();
   private Pattern cachedPattern = null;
   private class_634 lastConnection = null;

   public NameProtectModule() {
      super(Deobf.decrypt("8\u000b?@X\u009a\u008aÎñĝħ"), Deobf.decrypt(">\u00036@{È\u0095ÖõćĶŉĠƢƠǈǧȕɠɃɝˀʬ˜˞́ͤ"), Category.MISC);
   }

   private String selfName() {
      class_310 mc = class_310.method_1551();
      return mc.field_1724 == null ? null : mc.field_1724.method_7334().name();
   }

   private boolean isSelf(String realName) {
      String self = this.selfName();
      return self != null && self.equalsIgnoreCase(realName);
   }

   public String styledFor(String realName) {
      if (!this.isSelf(realName)) {
         if (this.style.is(Deobf.decrypt("4\u00063Kc"))) {
            return Deobf.decrypt("");
         } else {
            return this.style.is(Deobf.decrypt("&\u00063\\m\u009aÅ\u0099")) ? "Player " + (Math.floorMod(realName.toLowerCase(Locale.ROOT).hashCode(), 99) + 1) : Deobf.decrypt("&\u00063\\m\u009a");
         }
      } else {
         String alias = (String)this.ownName.get();
         return alias != null && !alias.isBlank() ? alias : Deobf.decrypt("/\u0005'");
      }
   }

   private Map buildTargets() {
      Map map = new LinkedHashMap();
      class_310 mc = class_310.method_1551();
      class_634 connection = mc.method_1562();
      if (connection != this.lastConnection) {
         this.seen.clear();
         this.lastConnection = connection;
      }

      String self = this.selfName();
      if (self != null && !self.isEmpty()) {
         this.seen.put(self.toLowerCase(Locale.ROOT), self);
         map.put(self, this.styledFor(self));
      }

      boolean others = !(Boolean)this.selfOnly.get();
      Iterator var6;
      if (connection != null) {
         var6 = connection.method_2880().iterator();

         while(var6.hasNext()) {
            class_640 info = (class_640)var6.next();
            GameProfile profile = info.method_2966();
            String name = profile == null ? null : profile.name();
            if (name != null && !name.isEmpty()) {
               this.seen.put(name.toLowerCase(Locale.ROOT), name);
               if (others) {
                  map.putIfAbsent(name, this.styledFor(name));
               }
            }
         }
      }

      if (others) {
         var6 = (new ArrayList(this.seen.values())).iterator();

         while(var6.hasNext()) {
            String name = (String)var6.next();
            map.putIfAbsent(name, this.styledFor(name));
         }
      }

      map.entrySet().removeIf((e) -> {
         return ((String)e.getKey()).equalsIgnoreCase((String)e.getValue());
      });
      return map;
   }

   private void ensureCache() {
      class_310 mc = class_310.method_1551();
      int tick = mc.field_1724 == null ? -1 : mc.field_1724.field_6012;
      String sig = "" + tick + "|" + String.valueOf(this.selfOnly.get()) + "|" + (String)this.style.get() + "|" + (String)this.ownName.get();
      if (!sig.equals(this.cacheSig)) {
         this.cacheSig = sig;
         this.cachedTargets = this.buildTargets();
         this.cachedPattern = buildPattern(this.cachedTargets);
      }

   }

   private static Pattern buildPattern(Map targets) {
      if (targets.isEmpty()) {
         return null;
      } else {
         List names = new ArrayList(targets.keySet());
         names.sort((a, b) -> {
            return Integer.compare(b.length(), a.length());
         });
         StringBuilder sb = new StringBuilder(Deobf.decrypt("^U;\f ×Ù\u009bÏĿžššǡƻƕƯɟȟɷȚˈ"));

         for(int i = 0; i < names.size(); ++i) {
            if (i > 0) {
               sb.append('|');
            }

            sb.append(Pattern.quote((String)names.get(i)));
         }

         sb.append(Deobf.decrypt("_Bm\u0004S©ÈàõœĩċĭǵƞǸƫ"));
         return Pattern.compile(sb.toString());
      }
   }

   public String replacementForDisplay(String display) {
      if (display != null && !display.isEmpty()) {
         this.ensureCache();
         if (this.cachedPattern == null) {
            return null;
         } else {
            String replaced = this.replaceNames(display);
            return replaced.equals(display) ? null : replaced;
         }
      } else {
         return null;
      }
   }

   public class_2561 censorChat(class_2561 input) {
      if (input == null) {
         return null;
      } else {
         this.ensureCache();
         return this.cachedPattern == null ? input : this.rewrite(input);
      }
   }

   private class_2561 rewrite(class_2561 c) {
      class_7417 contents = c.method_10851();
      class_5250 result;
      if (contents instanceof class_8828 ptc) {
         result = class_5250.method_43477(class_8828.method_54232(this.replaceNames(ptc.comp_737())));
      } else if (contents instanceof class_2588 tc) {
         Object[] args = tc.method_11023();
         Object[] newArgs = new Object[args.length];

         for(int i = 0; i < args.length; ++i) {
            Object arg = args[i];
            if (arg instanceof class_2561 ac) {
               newArgs[i] = this.rewrite(ac);
            } else if (arg instanceof String s) {
               newArgs[i] = this.replaceNames(s);
            } else {
               newArgs[i] = arg;
            }
         }

         result = class_5250.method_43477(new class_2588(tc.method_11022(), tc.method_48323(), newArgs));
      } else {
         result = class_5250.method_43477(contents);
      }

      result.method_10862(c.method_10866());
      Iterator var12 = c.method_10855().iterator();

      while(var12.hasNext()) {
         class_2561 sibling = (class_2561)var12.next();
         result.method_10852(this.rewrite(sibling));
      }

      return result;
   }

   private String replaceNames(String text) {
      if (text != null && !text.isEmpty() && this.cachedPattern != null) {
         Matcher m = this.cachedPattern.matcher(text);
         if (!m.find()) {
            return text;
         } else {
            StringBuilder out = new StringBuilder(text.length());
            int last = 0;

            do {
               String matched = m.group(1);
               String alias = this.aliasFor(matched);
               out.append(text, last, m.start());
               out.append(alias != null ? alias : matched);
               last = m.end();
            } while(m.find());

            out.append(text, last, text.length());
            return out.toString();
         }
      } else {
         return text;
      }
   }

   private String aliasFor(String matched) {
      String direct = (String)this.cachedTargets.get(matched);
      if (direct != null) {
         return direct;
      } else {
         Iterator var3 = this.cachedTargets.entrySet().iterator();

         Map.Entry e;
         do {
            if (!var3.hasNext()) {
               return null;
            }

            e = (Map.Entry)var3.next();
         } while(!((String)e.getKey()).equalsIgnoreCase(matched));

         return (String)e.getValue();
      }
   }
}
