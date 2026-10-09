package dev.vulxts.theme;

import com.google.gson.JsonObject;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.Setting;
import dev.vulxts.settings.SliderSetting;
import java.util.Iterator;
import java.util.List;

public class SoundSettings {
   public final SliderSetting masterVolume = new SliderSetting(Deobf.decrypt(";\u000b!Qm\u009aÅìûĒĦŖť"), Deobf.decrypt(" \u0005>Pe\u008dÅÜûČųŚŬƠǡǆǮȏȥɄɇˀʼ˟˂̟ͳ̀"), 60.0, 0.0, 100.0, 5.0, Deobf.decrypt("S"));
   public final BooleanSetting guiSounds = new BooleanSetting(Deobf.decrypt("1?\u001b\u0005G\u0098\u0080Ô»ĽĿŔųƩ"), Deobf.decrypt("!\u0002=J{\u0080ÅÍüěĽěŴƤƤƅǯȃȮɟȓʏʿ˕˙̷̂͒Ϳ\u038bϺϖϿϏЎдц"), true);
   public final BooleanSetting hoverSounds = new BooleanSetting(Deobf.decrypt(">\u0005$@z"), Deobf.decrypt("%\u00054Q(\u009c\u008cÙÿčųŌŨƩƯƅǪȉȶɏɁʉʡ˗ʗ̔ͻ͖ͼΊδρϠ"), true);
   public final BooleanSetting clickSounds = new BooleanSetting(Deobf.decrypt("5\u0006;Fc\u009bÅ\u009c´ĪļŜŧƠƤǖ"), Deobf.decrypt("&\u0005\"V(\u008e\u008aÈ´ĊļŜŧƠƤǖƮɆȳɆɚʄʪ˂˄͑Ͷ͝͵ϏαϐϪςДпёѭ"), true);
   public final BooleanSetting notificationSounds = new BooleanSetting(Deobf.decrypt("8\u0005&Ln\u0081\u0086Ûàėļŕų"), Deobf.decrypt("5\u0002;Hm\u009bÅÍýĊĻěŴƣƦǂǮȃɠɞɜʁʼ˄˄"), true);
   public final BooleanSetting startupVulxts = new BooleanSetting(Deobf.decrypt(" \u001f>]|\u009b"), Deobf.decrypt("%\u001e3W|\u009d\u0095\u009aàČĲŘūǬƢǄǬȂȩɎɒʔʪ"), true);
   public final BooleanSetting startupSad = new BooleanSetting(Deobf.decrypt(" \u001f>]|\u009bÅéõĚųŨůƢƦ"), Deobf.decrypt("%\u001e3W|\u009d\u0095\u009aàČĲŘūǬƢǄǬȂȩɎɒʔʪ"), false);
   public final BooleanSetting startupSong = new BooleanSetting(Deobf.decrypt(" \u001f>]|\u009bÅéûĐĴ"), Deobf.decrypt("%\u001e3W|\u009d\u0095\u009aàČĲŘūǬƢǄǬȂȩɎɒʔʪ"), false);
   public final BooleanSetting startupTiki = new BooleanSetting(Deobf.decrypt(" \u001f>]|\u009bÅîýĕĺěŐƤƮǋǩ"), Deobf.decrypt("%\u001e3W|\u009d\u0095\u009aàČĲŘūǬƢǄǬȂȩɎɒʔʪ"), false);
   private final List all;

   public SoundSettings() {
      this.all = List.of(this.masterVolume, this.guiSounds, this.hoverSounds, this.clickSounds, this.notificationSounds);
   }

   public List all() {
      return this.all;
   }

   public float volume() {
      return this.masterVolume.getFloat() / 100.0F;
   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      Iterator var2 = this.all.iterator();

      while(var2.hasNext()) {
         Setting var3 = (Setting)var2.next();
         var1.add(var3.getName(), var3.toJson());
      }

      return var1;
   }

   public void fromJson(JsonObject var1) {
      Iterator var2 = this.all.iterator();

      while(var2.hasNext()) {
         Setting var3 = (Setting)var2.next();
         if (var1.has(var3.getName())) {
            var3.fromJson(var1.get(var3.getName()));
         }
      }

   }
}
