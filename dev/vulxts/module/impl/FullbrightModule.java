package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.SliderSetting;

public class FullbrightModule extends Module {
   public final SliderSetting gamma = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("1\u000b?Hi"), Deobf.decrypt("4\u0018;B`\u009c\u008bßçčųřůƣƲǑ"), 12.0, 1.0, 15.0, 1.0));

   public FullbrightModule() {
      super(Deobf.decrypt("0\u001f>IJ\u009a\u008cÝüĊ"), Deobf.decrypt(";\u000b*Le\u009d\u0088\u009aöČĺŜŨƸƯǀǱȕɠɏɅʅʽˉˀ̙Ͳ́ʹ"), Category.RENDER);
   }
}
