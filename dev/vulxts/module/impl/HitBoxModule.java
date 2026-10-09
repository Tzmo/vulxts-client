package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;

public class HitBoxModule extends Module {
   public final SliderSetting expand = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("3\u0012\"Df\u008c"), Deobf.decrypt("2\u0003!Dj\u0084\u0080Þ´ĈĠěŰƾƤǁǫȅȴɃɜʎ˯ˑ˙̅;͐\u0379ΊλρϠ\u0380⑩ѱўѻ҄ҹҧӢԍԵԝվ֚րםףْؐٙصڑڬۅ۫ܛܴݲݬއ\u07bcߜ"), 0.5, 0.0, 2.0, 0.05));
   public final BooleanSetting enableRender = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("3\u00043Gd\u008dÅèñĐķŞŲ"), Deobf.decrypt(""), true));

   public HitBoxModule() {
      super(Deobf.decrypt(">\u0003&gg\u0090"), Deobf.decrypt(">\u0003&Gg\u0090ÅßìĎĲŕŤƩƳƅƪȈȥɟɇʅʽ˕˓̷͋͆Ϳ\u038bορ϶σЉаїѲґӭҺҤԆԨ\u0558ծוրה\u05feٗ\u0605ٓؾڙڲڄ۬ܗܤݭݥޜߨߍߘ\u07feࠠࠠࡗ\u086d\u0883ࣿ"), Category.COMBAT);
   }

   public float getHitboxExpansion() {
      return this.isEnabled() ? this.expand.getFloat() : 0.0F;
   }

   public boolean shouldRender() {
      return this.isEnabled() && (Boolean)this.enableRender.get();
   }
}
