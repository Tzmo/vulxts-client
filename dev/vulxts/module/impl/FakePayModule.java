package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.module.ModuleManager;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.StringSetting;
import dev.vulxts.util.Amounts;
import net.minecraft.class_1109;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_5250;

public class FakePayModule extends Module {
   private static final int WHITE = 16777215;
   private static final int RED = 16733525;
   public final StringSetting command = (StringSetting)this.addSetting(new StringSetting(Deobf.decrypt("5\u0005?Hi\u0086\u0081"), Deobf.decrypt("5\u0005?Hi\u0086\u0081\u009aúğľŞĠƸƮƅǪȏȪɋɐʋˣʐˀ̘ͣ͛;ΚήΕϧψИѱцѲҕҾӯҪ"), Deobf.decrypt("\u0006\u000b+"), 32, Deobf.decrypt("\u0006\u000b+")));
   public final ModeSetting feedback = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("0\u000f7Aj\u0089\u0086Ñ"), Deobf.decrypt("!\u00027WmÈ\u0091ÒñŞİŔŮƪƨǗǯȇȴɃɜʎ˯˃˟̞̀̿͠"), Deobf.decrypt("4\u0005&M"), new String[]{Deobf.decrypt("4\u0005&M"), Deobf.decrypt("7\t&Lg\u0086ÅøõČ"), Deobf.decrypt("5\u00023Q")}));
   public final StringSetting currency = (StringSetting)this.addSetting(new StringSetting(Deobf.decrypt("5\u001f Wm\u0086\u0086Ã"), Deobf.decrypt("%\u0013?Gg\u0084ÅØñĘļŉťǬƵǍǧɆȡɇɜʕʡ˄ʗ͙ʹ͜ͽ\u0380ΨϐϷΉѓ"), Deobf.decrypt("R"), 4, Deobf.decrypt("R")));
   public final ColorSetting currencyColor = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("5\u001f Wm\u0086\u0086Ã´Ľļŗůƾ"), Deobf.decrypt("5\u0005>JzÈ\u008aÜ´ĊĻŞĠƯƴǗǰȃȮɉɊˀʼˉ˚̓\u0378̱͟χΞϚϽϕЉЂѸюӔүӫӱԇէ՟դו֊מ\u05ecؖ؇ٖخە۲"), -16740609));
   public final BooleanSetting sounds = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0005'Kl\u009b"), Deobf.decrypt(":\u000f$@dÅ\u0090Ê´đĽěųƹƢǆǧȕȳȆȓʖʦ˜˛̐Ͱ͖ͣϏϽϛϼ·ѝЦѝѻҚӭӮӰՂԡ՜մ֙֝֕"), true));
   public final BooleanSetting checkBalance = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u00027FcÈ§ÛøğĽŘť"), Deobf.decrypt("!\u0003&M(®\u0084ÑñĭħŚŴƿǡǊǬɊɠɘɖʆʺ˃˒͑ͧ͒ͨΜϺόϼϕѝвєѰӓҹҧӥԄԡՒկ֑׀"), true));
   public final BooleanSetting selfGuard = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u000f>C%¸\u0084Ã´ĹĦŚŲƨ"), Deobf.decrypt("4\u0006=FcÈ\u0095ÛíėĽŜĠƵƮǐǰɆȯɝɝˀʡˑ˚̻̔̓ͽΆαϐγϔЕдЕѬґҬӫҤԁԨՐհ֔րן֤"), true));

   public FakePayModule() {
      super(Deobf.decrypt("0\u000b9@X\u0089\u009c"), Deobf.decrypt("0\u000b9@{È\u0084\u009a»ĎĲłĠƪƮǗƢȅȬɃɃʓ˯⊤ʗ̓ͻ͜Ͳ΄ΩΕϧψИѱчѻҕҡҧӧԍԪՐռ֛֊"), Category.MISC);
   }

   public boolean tryIntercept(String rawCommand) {
      if (this.isEnabled() && rawCommand != null) {
         String[] parts = rawCommand.trim().split(Deobf.decrypt("*\u0019y"));
         if (parts.length == 0) {
            return false;
         } else {
            String name = parts[0];
            if (name.startsWith(Deobf.decrypt("Y"))) {
               name = name.substring(1);
            }

            String target = ((String)this.command.get()).trim();
            if (!target.isEmpty() && name.equalsIgnoreCase(target)) {
               this.handle(parts);
               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private void handle(String[] parts) {
      class_310 mc = class_310.method_1551();
      if (mc.field_1724 != null) {
         if (parts.length < 3) {
            this.show(mc, class_2561.method_43470("Usage: /" + parts[0] + " <player> <amount>").method_54663(16733525));
            this.fail(mc);
         } else {
            String player = parts[1];
            double amount = Amounts.parse(parts[2]);
            if (!Double.isNaN(amount) && !(amount <= 0.0)) {
               if ((Boolean)this.selfGuard.get() && player.equalsIgnoreCase(mc.field_1724.method_7334().name())) {
                  this.show(mc, class_2561.method_43470(Deobf.decrypt("/\u0005'\u0005k\u0089\u008b\u009dàŞģŚŹǬƸǊǷȔȳɏɟʆˮ")).method_54663(16733525));
                  this.fail(mc);
               } else {
                  FakeStatsModule stats = this.stats();
                  boolean useStats = stats != null && stats.isEnabled() && (Boolean)stats.deductOnPay.get();
                  if (useStats && (Boolean)this.checkBalance.get() && stats.getLiveBalance() < amount) {
                     this.show(mc, class_2561.method_43470(Deobf.decrypt("/\u0005'\u0005l\u0087\u008b\u009dàŞĻŚŶƩǡǀǬȉȵɍɛˀʢ˟˙̔ͮ̒")).method_54663(16733525));
                     this.fail(mc);
                  } else {
                     if (useStats) {
                        stats.deduct(amount);
                     }

                     class_5250 line = class_2561.method_43473().method_10852(class_2561.method_43470("You paid " + player).method_54663(16777215));
                     String symbol = (String)this.currency.get();
                     if (!symbol.isEmpty()) {
                        line.method_10852(class_2561.method_43470(" " + symbol).method_54663((Integer)this.currencyColor.get() & 16777215)).method_10852(class_2561.method_43470(Amounts.shortForm(amount)).method_54663(16777215));
                     } else {
                        line.method_10852(class_2561.method_43470(" " + Amounts.shortForm(amount)).method_54663(16777215));
                     }

                     this.show(mc, line);
                     this.succeed(mc);
                  }
               }
            } else {
               this.show(mc, class_2561.method_43470("Invalid amount: " + parts[2]).method_54663(16733525));
               this.fail(mc);
            }
         }
      }

   }

   private void show(class_310 mc, class_2561 component) {
      if (mc.field_1724 != null) {
         String mode = (String)this.feedback.get();
         if (mode.equals(Deobf.decrypt("7\t&Lg\u0086ÅøõČ")) || mode.equals(Deobf.decrypt("4\u0005&M"))) {
            mc.field_1724.method_7353(component, true);
         }

         if (mode.equals(Deobf.decrypt("5\u00023Q")) || mode.equals(Deobf.decrypt("4\u0005&M"))) {
            mc.field_1724.method_7353(component, false);
         }
      }

   }

   private void succeed(class_310 mc) {
      if ((Boolean)this.sounds.get()) {
         this.play(mc, class_3417.field_14709, 1.0F);
      }

   }

   private void fail(class_310 mc) {
      if ((Boolean)this.sounds.get()) {
         this.play(mc, class_3417.field_15008, 1.0F);
      }

   }

   private void play(class_310 mc, class_3414 event, float pitch) {
      mc.method_1483().method_4873(class_1109.method_4757(event, pitch, 1.0F));
   }

   private FakeStatsModule stats() {
      ModuleManager modules = VulxtsClient.modules();
      return modules == null ? null : modules.fakeStats;
   }
}
