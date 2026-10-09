package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.settings.StringSetting;
import dev.vulxts.util.Amounts;
import java.util.Locale;
import java.util.Objects;
import net.minecraft.class_2561;
import net.minecraft.class_310;

public class FakeStatsModule extends Module {
   private static final int GRAY = 11184810;
   private static final int GREEN = 5635925;
   private static final String[] MONEY_KEYS = new String[]{Deobf.decrypt("\u001b\u0005<@q"), Deobf.decrypt("\u0014\u000b>Df\u008b\u0080"), Deobf.decrypt("\u0015\u0005;K{"), Deobf.decrypt("\u0015\u000b!M")};
   private static final String[] SHARD_KEYS = new String[]{Deobf.decrypt("\u0005\u00023Wl")};
   private static final String[] KILL_KEYS = new String[]{Deobf.decrypt("\u001d\u0003>I")};
   private static final String[] DEATH_KEYS = new String[]{Deobf.decrypt("\u0012\u000f3Q`")};
   private static final String[] PLAYTIME_KEYS = new String[]{Deobf.decrypt("\u0006\u00063\\|\u0081\u0088ß"), Deobf.decrypt("\u0006\u00063\\(\u009c\u008c×ñ"), Deobf.decrypt("\u0002\u0003?@(\u0098\u0089Ûíěķ"), Deobf.decrypt("\u0006\u00063\\m\u008c")};
   public final StringSetting money = (StringSetting)this.addSetting(new StringSetting(Deobf.decrypt(";\u0005<@q"), Deobf.decrypt("/\u0005'W(\u008e\u0084ÑñŞıŚŬƭƯǆǧɆɨțɞˌ˯ʆʀ̻̣̓̚ϚϪ΅ΣΐєѿЕщҝҿӢӠՂԳՒԽֳ֏א\u05efاؓكٴۜڞۈ۾ܜܻܽܽߎާ߃ߗޤ"), Deobf.decrypt("G\u0007"), 32, Deobf.decrypt("\u0013D5\u000b(Ù\u0088\u0096´ŌŦċū")));
   public final SliderSetting moneyLine = (SliderSetting)this.addSetting((new SliderSetting(Deobf.decrypt(";\u0005<@qÈ©Óúě"), Deobf.decrypt("!\u0002;F`È\u0096ÓðěıŚŲǬƭǌǬȃɠɃɀˀʢ˟˙̹̔ͮ̓ΌεπϽϔѝзчѱҙӭӳӬԇէՉղօׇ֪֕هْ؇ٺڝکې۰ݒܴݢܠހީ߈ߔޤ"), 1.0, 0.0, 15.0, 1.0)).withLabel(FakeStatsModule::lineLabel));
   public final StringSetting shards = (StringSetting)this.addSetting(new StringSetting(Deobf.decrypt("%\u00023Wl\u009b"), Deobf.decrypt("0\u000b9@(\u009b\u008dÛæĚųŘůƹƯǑƬɆȂɆɒʎʤʐʊ͑\u0378͕ͷρ"), Deobf.decrypt(""), 32, Deobf.decrypt("\u0013D5\u000b(ÑÉ\u0083\u00adŇ")));
   public final SliderSetting shardsLine = (SliderSetting)this.addSetting((new SliderSetting(Deobf.decrypt("%\u00023Wl\u009bÅöýĐĶ"), Deobf.decrypt("!\u0002;F`È\u0096ÓðěıŚŲǬƭǌǬȃɠɃɀˀʼ˘˖̃ͳ̀̿ϏϪΕή\u0380МФсѱӔүӾҤԌԦՐոכ"), 2.0, 0.0, 15.0, 1.0)).withLabel(FakeStatsModule::lineLabel));
   public final StringSetting kills = (StringSetting)this.addSetting(new StringSetting(Deobf.decrypt("=\u0003>I{"), Deobf.decrypt("0\u000b9@(\u0083\u008cÖøŞİŔŵƢƵƋƢȤȬɋɝʋ˯ʍʗ̞ͱ͕̿"), Deobf.decrypt(""), 32, Deobf.decrypt("\u0013D5\u000b(ÙÉ\u008a¤Ŏ")));
   public final SliderSetting killsLine = (SliderSetting)this.addSetting((new SliderSetting(Deobf.decrypt("=\u0003>I{È©Óúě"), Deobf.decrypt("!\u0002;F`È\u0096ÓðěıŚŲǬƭǌǬȃɠɃɀˀʤ˙˛̝̝̱ͤϟϺΈγρЈХњоҖҴҧӪԃԪ\u0558Գ"), 3.0, 0.0, 15.0, 1.0)).withLabel(FakeStatsModule::lineLabel));
   public final StringSetting deaths = (StringSetting)this.addSetting(new StringSetting(Deobf.decrypt("2\u000f3Q`\u009b"), Deobf.decrypt("0\u000b9@(\u008c\u0080ÛàĖųŘůƹƯǑƬɆȂɆɒʎʤʐʊ͑\u0378͕ͷρ"), Deobf.decrypt(""), 32, Deobf.decrypt("\u0013D5\u000b(Ø")));
   public final SliderSetting deathsLine = (SliderSetting)this.addSetting((new SliderSetting(Deobf.decrypt("2\u000f3Q`\u009bÅöýĐĶ"), Deobf.decrypt("!\u0002;F`È\u0096ÓðěıŚŲǬƭǌǬȃɠɃɀˀʫ˕˖̅Ϳ̀̿ϏϪΕή\u0380МФсѱӔүӾҤԌԦՐոכ"), 4.0, 0.0, 15.0, 1.0)).withLabel(FakeStatsModule::lineLabel));
   public final StringSetting playtime = (StringSetting)this.addSetting(new StringSetting(Deobf.decrypt("&\u00063\\|\u0081\u0088ß"), Deobf.decrypt("0\u000b9@(\u0098\u0089ÛíĊĺŖťǠǡǄǬȟɠɞɖʘʻʞʗ̳ͻ͒Ϳ΄ϺΈγϏЛзЛ"), Deobf.decrypt(""), 32, Deobf.decrypt("\u0013D5\u000b(ÛÓ\u008fðŞŢĉŨ")));
   public final SliderSetting playtimeLine = (SliderSetting)this.addSetting((new SliderSetting(Deobf.decrypt("&\u00063\\|\u0081\u0088ß´Ĳĺŕť"), Deobf.decrypt("!\u0002;F`È\u0096ÓðěıŚŲǬƭǌǬȃɠɃɀˀʿ˜˖͚̈ͣͼΊϴΕΣ\u0380рѱєѫҀҢҧӦԛէՓռ֘\u058b֕"), 5.0, 0.0, 15.0, 1.0)).withLabel(FakeStatsModule::lineLabel));
   public final BooleanSetting sidebar = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u00036@j\u0089\u0097"), Deobf.decrypt("$\u000f%Wa\u009c\u0080\u009aàĖĶěųƩƳǓǧȔɠəɐʏʽ˕˕̞Ͷ́͵Ϗϲϙ϶ρЙдчѼқҬӵӠՋէՒճו֚ד\u05efٗ\u0600ٓؽڔڨڊ"), true));
   public final BooleanSetting balanceCommand = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("4\u000b>Df\u008b\u0080\u009a×đľŖšƢƥ"), Deobf.decrypt("?\u0004&@z\u008b\u0080ÊàŞżřšƠǡƃƢɉȢɋɟʁʡ˓˒̱͑ͣ͜ΜβϚϤ\u0380ЄорѬӔҫӦӯԇէ՟ռ֙֏ושٜؒ"), true));
   public final BooleanSetting deductOnPay = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("2\u000f6Pk\u009cÅõúŞăŚŹ"), Deobf.decrypt("0\u000b9@X\u0089\u009c\u009açċıŏŲƭƢǑǱɆȷɂɒʔ˯ˉ˘̷̄̓ͰΖϺϓϡϏАѱѸѱҚҨӾҪ"), true));
   private String lastMoneyText;
   private double liveBalance;
   private int widthIndex;
   private int drawIndex;

   public FakeStatsModule() {
      super(Deobf.decrypt("0\u000b9@[\u009c\u0084Îç"), Deobf.decrypt("0\u000b9@(\u008a\u0084ÖõĐİŞĠǧǡǀǦȏȴɋɑʌʪʐ˛̔Ͷ͗ʹΝθϚϲϒЙѽЕѩҝҿӢӠՂԳՒԽֳ֏א\u05efاؓك"), Category.MISC);
      this.moneyLine.visibleWhen(() -> {
         return (Boolean)this.sidebar.get() && !((String)this.money.get()).isBlank();
      });
      this.shardsLine.visibleWhen(() -> {
         return (Boolean)this.sidebar.get() && !((String)this.shards.get()).isBlank();
      });
      this.killsLine.visibleWhen(() -> {
         return (Boolean)this.sidebar.get() && !((String)this.kills.get()).isBlank();
      });
      this.deathsLine.visibleWhen(() -> {
         return (Boolean)this.sidebar.get() && !((String)this.deaths.get()).isBlank();
      });
      this.playtimeLine.visibleWhen(() -> {
         return (Boolean)this.sidebar.get() && !((String)this.playtime.get()).isBlank();
      });
   }

   protected void onEnable() {
      this.lastMoneyText = null;
      this.syncFromSetting();
   }

   private static String lineLabel(double v) {
      return (int)v == 0 ? Deobf.decrypt("7\u001f&J") : "Line " + (int)v;
   }

   private void syncFromSetting() {
      String text = (String)this.money.get();
      if (!Objects.equals(text, this.lastMoneyText)) {
         this.lastMoneyText = text;
         double parsed = Amounts.parse(text);
         this.liveBalance = Double.isNaN(parsed) ? 0.0 : Math.max(0.0, parsed);
      }

   }

   public double getLiveBalance() {
      this.syncFromSetting();
      return this.liveBalance;
   }

   public void deduct(double amount) {
      this.syncFromSetting();
      this.liveBalance = Math.max(0.0, this.liveBalance - Math.max(0.0, amount));
   }

   public void beginSidebar() {
      this.widthIndex = 0;
      this.drawIndex = 0;
   }

   public class_2561 rewriteForWidth(class_2561 comp) {
      return this.rewriteLine(comp, true);
   }

   public class_2561 rewriteForDraw(class_2561 comp) {
      return this.rewriteLine(comp, false);
   }

   private class_2561 rewriteLine(class_2561 comp, boolean widthPass) {
      if (this.isEnabled() && (Boolean)this.sidebar.get()) {
         String text = stripCodes(comp.getString());
         if (text.isBlank()) {
            return comp;
         } else {
            int var10000;
            int var10002;
            if (widthPass) {
               var10002 = this.widthIndex;
               var10000 = var10002;
               this.widthIndex = var10002 + 1;
            } else {
               var10002 = this.drawIndex;
               var10000 = var10002;
               this.drawIndex = var10002 + 1;
            }

            int line = var10000;
            return this.applyOverride(line, text.toLowerCase(Locale.ROOT), comp);
         }
      } else {
         return comp;
      }
   }

   private class_2561 applyOverride(int line, String lower, class_2561 comp) {
      if (!((String)this.money.get()).isBlank() && matches(this.moneyLine, line, lower, MONEY_KEYS)) {
         return Amounts.replaceNumberStyled(comp, Amounts.shortForm(this.getLiveBalance()));
      } else if (!((String)this.shards.get()).isBlank() && matches(this.shardsLine, line, lower, SHARD_KEYS)) {
         return Amounts.replaceNumberStyled(comp, ((String)this.shards.get()).trim());
      } else if (!((String)this.kills.get()).isBlank() && matches(this.killsLine, line, lower, KILL_KEYS)) {
         return Amounts.replaceNumberStyled(comp, ((String)this.kills.get()).trim());
      } else if (!((String)this.deaths.get()).isBlank() && matches(this.deathsLine, line, lower, DEATH_KEYS)) {
         return Amounts.replaceNumberStyled(comp, ((String)this.deaths.get()).trim());
      } else {
         return !((String)this.playtime.get()).isBlank() && matches(this.playtimeLine, line, lower, PLAYTIME_KEYS) ? Amounts.replaceValueStyled(comp, ((String)this.playtime.get()).trim()) : comp;
      }
   }

   private static boolean matches(SliderSetting lineSetting, int line, String lower, String[] keys) {
      int configured = lineSetting.getInt();
      return configured > 0 ? line + 1 == configured : containsAny(lower, keys);
   }

   private static boolean containsAny(String haystack, String[] keys) {
      String[] var2 = keys;
      int var3 = keys.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String k = var2[var4];
         if (haystack.contains(k)) {
            return true;
         }
      }

      return false;
   }

   public boolean tryInterceptBalance(String command) {
      if (this.isEnabled() && (Boolean)this.balanceCommand.get()) {
         String[] parts = command.trim().split(Deobf.decrypt("*\u0019y"));
         if (parts.length == 0) {
            return false;
         } else {
            String name = parts[0];
            if (name.startsWith(Deobf.decrypt("Y"))) {
               name = name.substring(1);
            }

            if (!name.equalsIgnoreCase(Deobf.decrypt("\u0014\u000b>")) && !name.equalsIgnoreCase(Deobf.decrypt("\u0014\u000b>Df\u008b\u0080"))) {
               return false;
            } else {
               class_310 mc = class_310.method_1551();
               if (mc.field_1724 == null) {
                  return false;
               } else if (parts.length >= 2 && !parts[1].equalsIgnoreCase(mc.field_1724.method_7334().name())) {
                  return false;
               } else {
                  String amount = Amounts.shortForm(this.getLiveBalance());
                  class_2561 line = class_2561.method_43473().method_10852(class_2561.method_43470(Deobf.decrypt("/\u0005'\u0005`\u0089\u0093ß´")).method_54663(11184810)).method_10852(class_2561.method_43470(amount).method_54663(5635925));
                  mc.field_1724.method_7353(line, false);
                  mc.field_1724.method_7353(line, true);
                  return true;
               }
            }
         }
      } else {
         return false;
      }
   }

   private static String stripCodes(String s) {
      return s == null ? Deobf.decrypt("") : s.replaceAll(Deobf.decrypt("^U;\f¯³Õ\u0097\u00adĿžŽŋǡƎǷǟ"), Deobf.decrypt(""));
   }
}
