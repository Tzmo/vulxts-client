package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.SliderSetting;

public class SwingSpeedModule extends Module {
   public final SliderSetting speed = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("%\u001a7@l"), Deobf.decrypt("%\u001d;KoÈ\u0096ÊñěķěŭƹƭǑǫȖȬɃɖʒ˯ʘʋ̷̱̀̎ΜζϚϤυЏѾцѳқҢӳӬԇԵԔ"), 0.3, 0.1, 3.0, 0.1, Deobf.decrypt("\u000e")));

   public SwingSpeedModule() {
      super(Deobf.decrypt("%\u001d;Ko»\u0095ßñĚ"), Deobf.decrypt("7\u000e8P{\u009c\u0096\u009aüğĽşĠƿƶǌǬȁɠɋɝʉʢˑ˃̘\u0378̱͝ΜΪϐ϶τ"), Category.CLIENT);
   }

   public float multiplier() {
      return this.speed.getFloat();
   }
}
