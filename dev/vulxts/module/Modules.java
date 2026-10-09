package dev.vulxts.module;

import dev.vulxts.render.SusChunkRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.Setting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.suschunk.SusChunkScanner;
import java.util.Objects;

public final class Modules {
   private Modules() {
   }

   public static class SusChunkFinderModule extends Module {
      public final SliderSetting sensitivity = (SliderSetting)this.addSetting((new SliderSetting(Deobf.decrypt("%\u000f<Va\u009c\u008cÌýĊĪ"), Deobf.decrypt(">\u00035Mm\u009aÅ\u0087´čħŉũƯƵǀǰɜɠɇɜʒʪʐˀ̔;͔\u0379ΛοϑγυЋиёѻҚҮӢҤԀԢ՛ղև\u058b֛\u05ebْٗؑدڒڷڄ۹ܞܷݼݳ"), 3.0, 1.0, 15.0, 1.0)).withLabel((var0) -> {
         return (int)var0 + " (" + SusChunkScanner.thresholdForSensitivity((int)var0) + ")";
      }));
      public final BooleanSetting amethyst = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u00077Q`\u0091\u0096Î"), Deobf.decrypt(">\u00036Am\u0086ÅÝæđĤŕĠƯƭǐǱȒȥɘɀˀʹ˙˖͖͑ͤͣΙοχγςБоіѵӔҡӮӣԊԳԝԨו◺֛\u05fe؟ؚؗةڈڮۋ۱ܕܳݨݴߎ\u07bbߌߖߤࠣࠣ"), true));
      public final BooleanSetting kelp = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("=\u000f>U"), Deobf.decrypt("0\u001f>IqÈ\u0082ÈûĉĽěįǬƴǋǷȕȵɋɟʌʶʐ˃̐ͻ̱͟΄οϙϣ\u0380ОољѫҙңӴ"), true));
      public final BooleanSetting bamboo = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("4\u000b?Gg\u0087"), Deobf.decrypt("0\u001f>IqÈ\u0082ÈûĉĽėĠơƠǝƯȎȥɃɔʈʻʐ˕̐ͺ͑;\u0380"), true));
      public final BooleanSetting berries = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("4\u000f Wa\u008d\u0096"), Deobf.decrypt("%\u001d7@|È\u0087ßæČĪěŢƹƲǍǧȕɠɋɇˀʢˑˏ͑Ͱ́;ΘήϝγϓЉађѻ"), true));
      public final BooleanSetting vines = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(" \u0003<@{"), Deobf.decrypt(" \u0003<@{È\u0082ÈûĉĽěŦƭƳƅǦȉȷɄȓʆʽ˟˚͑ͣ͛ʹΆΨΕϠϕЍСњѬҀ"), true));
      public final BooleanSetting dripstone = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("2\u0018;U{\u009c\u008aÔñ"), Deobf.decrypt("2\u0018;U{\u009c\u008aÔñŞĠŋũƧƤǖƢȊȯɄɔʅʽʐ˃̙Ͷ̱͝\u0381λρϦϒМнЕѹґңӢӶԃԳՔղ֛"), true));
      public final SliderSetting scanSpeed = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\t3K(»\u0095ßñĚ"), Deobf.decrypt("5\u0002'Kc\u009bÅÉ÷ğĽŕťƨǡǕǧȔɠɞɚʃʤ"), 10.0, 2.0, 24.0, 1.0));
      public final SliderSetting renderY = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("$\u000f<Am\u009aÅã"), Deobf.decrypt(">\u000f;B`\u009cÅÎüěųŝŬƭƵƅǡȎȵɄɘˀʧ˙ː̙ͻ͚Ͷ·ήφγϒИпёѻ҆ӭӦӰ"), 100.0, -64.0, 320.0, 1.0));
      public final SliderSetting fillOpacity = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("0\u0003>I(§\u0095Û÷ėħł"), Deobf.decrypt("0\u0003>I(\u0087\u0095Û÷ėħłĠƣƧƅǶȎȥȊɐʈʺ˞˜͑ͦ͆Ͱ\u038bΩ"), 90.0, 0.0, 255.0, 1.0));
      public final BooleanSetting outline = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("9\u001f&Ia\u0086\u0080"), Deobf.decrypt("5\u0018;VxÈ\u0087ÕæĚĶŉĠƭƭǊǬȁɠɞɛʅ˯˓˟̄\u0379̱͘Ίξϒ϶ϓ"), true));
      public final SliderSetting outlineOpacity = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("9\u001f&Ia\u0086\u0080\u009aÛĎĲŘũƸƸ"), Deobf.decrypt("4\u0005 Am\u009aÅÕäğİŒŴƵ"), 200.0, 0.0, 255.0, 1.0));
      public final BooleanSetting smartMode = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u00073W|È¨Õðě"), Deobf.decrypt(";\u000f BmÈ\u008bßõČıłĠƪƭǄǥȕɠɃɝʔʠʐˍ̞\u0379͖͢ϏέϜϧψѝаЕѽґңӳӶԍԮՙԽ֘֏\u05c9סؒ\u0600"), true));
      public final SliderSetting mergeRadius = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(";\u000f BmÈ·ÛðėĦň"), Deobf.decrypt("0\u00063B{È\u0092ÓàĖĺŕĠƸƩǌǱɆȭɋɝʙ˯˓˟̄\u0379͘͢ϏηϐϡχИѱќѰҀҢҧӫԌԢԝէ֚րמ"), 3.0, 1.0, 8.0, 1.0, Deobf.decrypt("V\t:")));
      public final BooleanSetting centroidMarker = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u000f<Qz\u0087\u008cÞ´ĳĲŉūƩƳ"), Deobf.decrypt(";\u000b N(\u008d\u0084ÙüŞĩŔŮƩǦǖƢȑȥɃɔʈʻ˕˓͑ʹ͖ͿΛΨϐγ⎴ѝХѝѻӔҡӮӯԇԫՄԽ֗֏\u05c8\u05efٗ\u0601يصڈ"), true));
      public final BooleanSetting showOnRadar = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u0002=R(\u0087\u008b\u009aÆğķŚŲ"), Deobf.decrypt("&\u001f>VmÈ\u0096ÏçŞĩŔŮƩƲƅǭȈɠɞɛʅ˯ˢ˖̕Ͷ̪́Ϗμϔϡ\u0380Їоћѻ҇ӭӤӨԃԪՍԽցց֛\u05fe؟ؚؗؿژڻہ"), true));
      public final ModeSetting notifications = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("8\u0005&Ln\u0081\u0086Ûàėļŕų"), Deobf.decrypt("7\u0004<J}\u0086\u0086ß´ěĲŘŨǬƯǀǵɆȺɅɝʅ˯˟˙̒Ͳ̟̱Θγρϻ\u0380ОоњѬҐҾҧӥԌԣԝչ֜֝\u05cf\u05ebؙٟؑ"), Deobf.decrypt("\"\u00053V|"), new String[]{Deobf.decrypt("\"\u00053V|"), Deobf.decrypt("5\u00023Q"), Deobf.decrypt("9\f4")}));
      public final SusChunkScanner scanner = new SusChunkScanner(this);

      public SusChunkFinderModule() {
         super(Deobf.decrypt("%\u001f!f`\u009d\u008bÑÒėĽşťƾ"), Deobf.decrypt("0\u0003<A{È\u0089ÕúęžŗůƭƥǀǦɆȣɂɆʎʤ˃ʗ⍥̷͑ͰΜοφγ⎴ѝЧќѿӔҬӪӡԖԯՄծց\u05ceחףَؚؐٺۚۼۃۭܝܡݯݨ"), Category.RENDER);
         SliderSetting var10000 = this.outlineOpacity;
         BooleanSetting var10001 = this.outline;
         Objects.requireNonNull(var10001);
         var10000.visibleWhen(var10001::get);
      }

      public void onTick() {
         this.scanner.tick();
      }

      protected void onDisable() {
         this.scanner.clear();
         SusChunkRenderer.reset();
      }
   }

   public static class SpotifyModule extends Module {
      public final ModeSetting source = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("%\u0005'Wk\u008d"), Deobf.decrypt("7\u001f&J(\u009d\u0096ßçŞħœťǬƳǀǣȊɠɹɃʏʻ˙ˑ̷̈̀ʹΜΩϜϼώѝѹѢѷҚҩӨӳԑծԆԽֱ\u058bזץٗ\u0601ْصڋگڄ۬ܓܻݫݬދߨ߁ߐ\u07feࠣ"), Deobf.decrypt("7\u001f&J"), new String[]{Deobf.decrypt("7\u001f&J"), Deobf.decrypt("2\u000f?J")}));
      public final BooleanSetting controls = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u0005<Qz\u0087\u0089É"), Deobf.decrypt("%\u0002=R(\u0098\u0097ßâŞżěŰƠƠǜƢɉɠɄɖʘʻʐ˕͇̄ͣ;\u0381Ω"), true));
      public final BooleanSetting volume = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(" \u0005>Pe\u008d"), Deobf.decrypt("%\u0002=R(\u0089ÅÉøėķŞŲǬƧǊǰɆȓɚɜʔʦ˖ˎ͖ͤ̓ͰΟΪΕϥϏБФјѻӔӥӐӭԌԣՒժֆׇ"), true));
      public final BooleanSetting hideWhenIdle = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u00036@(¿\u008dßúŞĚşŬƩ"), Deobf.decrypt(">\u00036@(\u009c\u008dß´ĝĲŉŤǬƶǍǧȈɠɄɜʔʧ˙˙̷̖̓ͽΎΣφ"), true));

      public SpotifyModule() {
         super(Deobf.decrypt("%\u001a=Qa\u008e\u009còÁĺ"), Deobf.decrypt("8\u0005%\u0005x\u0084\u0084ÃýĐĴě℔ǬƲǎǫȖɠɋɝʄ˯˃˒̔ͼ̓ͷΝεϘγϔЕдЕіҡ҉"), Category.CLIENT);
         this.setEnabled(true);
      }
   }

   public static class Placeholder extends Module {
      public Placeholder(String name, String description, Category category, Setting... settings) {
         super(name, description, category);
         Setting[] var5 = settings;
         int var6 = settings.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Setting setting = var5[var7];
            this.addSetting(setting);
         }

      }
   }

   public static class HudModule extends Module {
      public final BooleanSetting watermark = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("!\u000b&@z\u0085\u0084Èÿ"), Deobf.decrypt("\"\u00027\u0005^\u009d\u0089ÂàčųřšƨƦǀ"), true));
      public final BooleanSetting arrayList = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u0018 Dq¤\u008cÉà"), Deobf.decrypt("3\u00043Gd\u008d\u0081\u009aùđķŎŬƩƲƅǮȏȳɞ"), true));
      public final BooleanSetting fps = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("0:\u0001"), Deobf.decrypt("0\u00183Hm\u009a\u0084ÎñŞġŞšƨƮǐǶ"), true));
      public final BooleanSetting ping = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("&\u0003<B"), Deobf.decrypt(":\u000b&@f\u008b\u009c\u009aæěĲşůƹƵ"), false));
      public final BooleanSetting coordinates = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u0005=Wl\u0081\u008bÛàěĠ"), Deobf.decrypt("4\u0006=FcÈ\u0095ÕçėħŒůƢǡǗǧȇȤɅɆʔ"), true));
      public final BooleanSetting direction = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("2\u0003 @k\u009c\u008cÕú"), Deobf.decrypt("0\u000b1Lf\u008fÅÈñğķŔŵƸ"), true));
      public final BooleanSetting tps = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\":\u0001"), Deobf.decrypt("%\u000f Sm\u009aÅÎýĝĸěŲƭƵǀƢȃȳɞɚʍʮ˄˒"), false));
      public final BooleanSetting cps = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5:\u0001"), Deobf.decrypt("5\u0006;Fc\u009bÅÊñČųňťƯƮǋǦ"), false));
      public final BooleanSetting armor = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u0018?Jz"), Deobf.decrypt("3\u001b'Lx\u0098\u0080Þ´ğġŖůƾǡƎƢȂȵɘɒʂʦ˜˞̅ͮ"), false));
      public final BooleanSetting potions = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("&\u0005&Lg\u0086\u0096"), Deobf.decrypt("7\t&L~\u008dÅßòĘĶŘŴƿǡǒǫȒȨȊɇʉʢ˕˅̂"), false));
      public final BooleanSetting keystrokes = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("=\u000f+V|\u009a\u008aÑñč"), Deobf.decrypt("!+\u0001a(ÃÅ×ûċĠŞĠǧǡǖǲȇȣɏȓʄʦ˃ˇ̝Ͷ͊"), false));
      public final BooleanSetting radar = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("$\u000b6Dz"), Deobf.decrypt("5\u0003 F}\u0084\u0084È´ĎĿŚŹƩƳƅǰȇȤɋɁ"), true));
      public final BooleanSetting themeSync = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(":\u0003!Q(¼\u008dßùěųŨŹƢƢ"), Deobf.decrypt("7\u0018 Dq¤\u008cÉàŞĵŔŬƠƮǒǱɆȴɂɖˀʻ˘˒̜Ͳ̓Ͳ\u0380ζϚϡ"), true));
      public final ColorSetting listColor = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt(":\u0003!Q(«\u008aÖûČ"), Deobf.decrypt("7\u0018 Dq¤\u008cÉàŞİŔŬƣƳƅǵȎȥɄȓʴʧ˕˚̷̔ͨ͠\u0381ιΕϺϓѝоѓѸ"), -49508));
      public final SliderSetting radarRange = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("$\u000b6DzÈ·ÛúęĶ"), Deobf.decrypt("%\t3K(\u009a\u0084ÞýċĠěũƢǡǇǮȉȣɁɀ"), 48.0, 16.0, 128.0, 4.0, Deobf.decrypt("\u001b")));
      public final BooleanSetting radarHeads = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("$\u000b6DzÈ\u00adßõĚĠ"), Deobf.decrypt("%\u0001;K(\u008e\u0084ÙñčųŒŮƿƵǀǣȂɠɅɕˀʫ˟˃̂"), true));
      public final BooleanSetting notifications = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("8\u0005&Ln\u0081\u0086Ûàėļŕų"), Deobf.decrypt("\"\u00027Hm\u008cÅÎûğĠŏųǬƶǍǧȈɠɇɜʄʺ˜˒̷͇̂;Ένϙ϶\u0380ћѱсѶґӭӰӡԃԳՕոև\u05ceטעؖ\u061cٝؿڏ"), true));
      public final SliderSetting notifyDuration = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("8\u0005&Ln\u0091ÅþáČĲŏũƣƯ"), Deobf.decrypt(">\u0005%\u0005d\u0087\u008bÝ´ğųŏůƭƲǑƢȊȩɄɔʅʽ˃ʗ̓Ͳ͕;ΝοΕϵρЙићѹӔҢӲӰ"), 2.5, 1.0, 6.0, 0.5, Deobf.decrypt("\u0005")));

      public HudModule() {
         super(Deobf.decrypt(">?\u0016"), Deobf.decrypt("7\u0006>\u0005@½¡\u009añĒĶŖťƢƵǖƢ≲ɠɇɜʖʪʐʑ͖͑ͥ͢ΆΠϐγϖДаЕѽҜҬӳҤՊԓԔ"), Category.CLIENT);
         this.setEnabled(true);
         SliderSetting var10000 = this.notifyDuration;
         BooleanSetting var10001 = this.notifications;
         Objects.requireNonNull(var10001);
         var10000.visibleWhen(var10001::get);
      }
   }

   public static class ClickGuiModule extends Module {
      public final BooleanSetting blur = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("4\u0006'W"), Deobf.decrypt("1\u000b'V{\u0081\u0084Ô¹ĜĿŎŲǬƵǍǧɆȷɅɁʌʫʐ˕̔Ϳ͚Ϳ\u038bϺρϻυѝЖѠї"), true));
      public final SliderSetting blurStrength = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("4\u0006'W(»\u0091ÈñĐĴŏŨ"), Deobf.decrypt(">\u0005%\u0005{\u009c\u0097ÕúęųŏŨƩǡǇǣȅȫɍɁʏʺ˞˓͑͵ͤ͟ΝϺϜϠ"), 6.0, 1.0, 10.0, 1.0));
      public final ModeSetting font = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("0\u0005<Q"), Deobf.decrypt("1?\u001b\u0005n\u0087\u008bÎ´ŖċŎůƢƦƅǖȲȆȊɜʒ˯ˆ˖̟;͟ͽΎϷφϧϙБдМ"), Deobf.decrypt(".\u001f=Ko"), new String[]{Deobf.decrypt(".\u001f=Ko"), Deobf.decrypt(" \u000b<Ld\u0084\u0084")}));

      public ClickGuiModule() {
         super("Vulxts Client", "Opens the Vulxts Client control centre.", Category.CLIENT);
         this.getKeybind().set(344);
      }
   }

   public static class BlockOutlineModule extends Module {
      public final ColorSetting color = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("5\u0005>Jz"), Deobf.decrypt("9\u001f&Ia\u0086\u0080\u009a÷đĿŔŲ"), -49508));
      public final BooleanSetting rainbow = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("$\u000b;Kj\u0087\u0092"), Deobf.decrypt("5\u00131ImÈ\u0091ÒñŞļŎŴƠƨǋǧɆȴɂɁʏʺ˗˟͑ͣ͛ʹϏΨϔϺώПот"), false));
      public final SliderSetting glow = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("1\u0006=R"), Deobf.decrypt("9\u001f&@zÈ\u0082ÖûĉųŒŮƸƤǋǱȏȴɓ"), 60.0, 0.0, 100.0, 5.0, Deobf.decrypt("S")));
      public final SliderSetting thickness = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("\"\u0002;Fc\u0086\u0080Éç"), Deobf.decrypt("5\u0005 @(\u0084\u008cÔñŞĤŒŤƸƩ"), 2.5, 1.0, 6.0, 0.5, Deobf.decrypt("\u0006\u0012")));
      public final SliderSetting fillOpacity = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("0\u0003>I"), Deobf.decrypt("\"\u00183K{\u0098\u0084ÈñĐħěŦƥƭǉƢȏȮəɚʄʪʐ˃̙Ͳ̓ͳ\u0383εϖϸ"), 12.0, 0.0, 60.0, 2.0, Deobf.decrypt("S")));
      public final ModeSetting animation = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("7\u0004;Hi\u009c\u008cÕú"), Deobf.decrypt("9\u001f&Ia\u0086\u0080\u009aõĐĺŖšƸƨǊǬɆȳɞɊʌʪ"), Deobf.decrypt("&\u001f>Vm"), new String[]{Deobf.decrypt("&\u001f>Vm"), Deobf.decrypt("1\u00183Aa\u008d\u008bÎ´ĸĿŔŷ"), Deobf.decrypt("%\u001e3Qa\u008b")}));

      public BlockOutlineModule() {
         super(Deobf.decrypt("5\u001f!Qg\u0085§ÖûĝĸŴŵƸƭǌǬȃ"), Deobf.decrypt("1\u0006=Ra\u0086\u0082\u009aõĐĺŖšƸƤǁƢȉȵɞɟʉʡ˕ʗ̞\u0379̓ͥ·οΕϧρЏжѐѪґҩҧӦԎԨ՞ն"), Category.VISUALS);
         this.setEnabled(true);
      }
   }
}
