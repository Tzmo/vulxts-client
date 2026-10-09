package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;

public class NameTagsModule extends Module {
   public final BooleanSetting players = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("&\u00063\\m\u009a\u0096"), Deobf.decrypt("\"\u000b5\u0005x\u0084\u0084ÃñČĠěŷƥƵǍƢȒȨɏɚʒ˯˹˰̿"), true));
   public final BooleanSetting self = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("%\u000f>C"), Deobf.decrypt("7\u0006!J(\u009c\u0084Ý´ćļŎŲǬƮǒǬɆȰɆɒʙʪ˂ʗ͙͵͖͢ΛϺϜϽ\u0380юУёо҄ҨӵӷԍԩԔ"), false));
   public final BooleanSetting items = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("?\u001e7H{"), Deobf.decrypt("\"\u000b5\u0005l\u009a\u008aÊäěķěũƸƤǈǱɆȯɄȓʔʧ˕ʗ̖ͥͤ͜\u0381ξ"), true));
   public final BooleanSetting hidePlayerTags = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u00036@(¸\u0089ÛíěġěŔƭƦǖ"), Deobf.decrypt("$\u000f?J~\u008dÅÎüěųōšƢƨǉǮȇɠɄɒʍʪ˄˖̷̖͜ͷϏερϻυЏѱхѲҕҴӢӶԑէ┩Խ֚րח׳ٗ؆ْؿۜڱۋۻ܇ܺݾܧޝߨߖߙߥ࠵࠼"), true));
   public final BooleanSetting hideOwnTag = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u00036@(§\u0092Ô´ĪĲŜ"), Deobf.decrypt("$\u000f?J~\u008dÅÃûċġěůƻƯƅǭȔȩɍɚʎʮ˜ʗ̟Ͷ͞ʹΛλϒγ⎴ѝоћѲҍӭӳӬԇէՐղ֑֛ח\u05efِ\u0601ؚ؉ڙڰۂڿ܆ܷݼܠޝޠߊ߆߹"), true));
   public final BooleanSetting hideOtherTags = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u00036@(§\u0091ÒñČųůšƫƲ"), Deobf.decrypt("7\u0006!J(\u009a\u0080×ûĈĶěŶƭƯǌǮȊȡȊɝʁʢ˕˃̐Ͱ̱̀\u0380μΕϾϏПТЙоҕҿӪӫԐէՎթ֔րן\u05f9ؚٗٔؼڎڽۉۺ܁"), false));
   public final BooleanSetting armor = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u0018?Jz"), Deobf.decrypt("%\u0002=R(\u0089ÅÊøğĪŞŲǫƲƅǧȗȵɃɃʐʪ˔ʗ̐ͥ͞;ΝϺϔϱϏЋдЕѪҜҨӮӶՂԳ՜պ"), true));
   public final BooleanSetting heldItem = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u000f>A(¡\u0091ßù"), Deobf.decrypt("%\u0002=R(\u009f\u008dÛàŞĲěŰƠƠǜǧȔɠɃɀˀʧ˟˛̕;͝ͶϏλϗϼϖИѱсѶґҤӵҤԖԦ՚"), true));
   public final BooleanSetting health = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u000f3I|\u0080"), Deobf.decrypt(">\u000f3I|\u0080ÅØõČųŎŮƨƤǗƢȖȬɋɊʅʽʐ˃̐Ͱ̀"), true));
   public final BooleanSetting distance = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("2\u0003!Qi\u0086\u0086ß"), Deobf.decrypt("7\u001a\"@f\u008cÅÎüěųşũƿƵǄǬȅȥȊɚʎ˯˒˛̞ʹ͘͢"), true));
   public final BooleanSetting itemAmount = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("?\u001e7H(©\u0088ÕáĐħ"), Deobf.decrypt("%\u0002=R(\u009c\u008dß´čħŚţƧǡǖǫȜȥȊɜʎ˯˙˃̔ͺ̓ͥΎνφ"), true));
   public final SliderSetting scale = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\t3Im"), Deobf.decrypt("\"\u000b5\u0005{\u0081\u009fß"), 1.0, 0.5, 2.0, 0.1, Deobf.decrypt("\u000e")));
   public final SliderSetting opacity = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("9\u001a3Fa\u009c\u009c"), Deobf.decrypt("\"\u000b5\u0005|\u009a\u0084ÔçĎĲŉťƢƢǜ"), 100.0, 10.0, 100.0, 5.0, Deobf.decrypt("S")));
   public final SliderSetting range = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("$\u000b<Bm"), Deobf.decrypt("9\u0004>\\(\u009c\u0084Ý´ĉĺŏŨƥƯƅǶȎȩəȓʄʦ˃˃̐\u0379͐ʹ"), 64.0, 8.0, 256.0, 4.0, Deobf.decrypt("\u001b")));

   public NameTagsModule() {
      super(Deobf.decrypt("8\u000b?@\\\u0089\u0082É"), Deobf.decrypt(">?\u0016\b{\u009c\u009cÖñĚųŕšơƤǑǣȁȳȊɕʏʽʐˇ̝Ͷ͊ʹΝΩΕε\u0380ДХѐѳ҇"), Category.MISC);
   }
}
