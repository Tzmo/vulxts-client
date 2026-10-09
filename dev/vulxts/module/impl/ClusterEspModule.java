package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.render.ClusterEspRenderer;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.SliderSetting;

public class ClusterEspModule extends Module {
   public final SliderSetting minimumBlocks = (SliderSetting)this.addSetting(new SliderSetting("Minimum Matches", "Minimum matching cluster-light positions required in one chunk", 4.0, 1.0, 32.0, 1.0));
   public final ColorSetting color = (ColorSetting)this.addSetting(new ColorSetting("Cluster Color", "Color used for fully grown cluster markers and tracers", -4895489));
   public final SliderSetting fillAlpha = (SliderSetting)this.addSetting(new SliderSetting("Fill Alpha", "Opacity inside cluster boxes", 45.0, 0.0, 255.0, 1.0));
   public final SliderSetting outlineAlpha = (SliderSetting)this.addSetting(new SliderSetting("Outline Alpha", "Opacity of cluster outlines", 220.0, 0.0, 255.0, 1.0));
   public final BooleanSetting tracers = (BooleanSetting)this.addSetting(new BooleanSetting("Tracers", "Draw a tracer to each cluster center", true));

   public ClusterEspModule() {
      super("Cluster ESP", "Highlights only fully grown amethyst clusters", Category.RENDER);
   }

   public void onTick() {
      ClusterEspRenderer.update(this);
   }

   protected void onDisable() {
      ClusterEspRenderer.clear();
   }
}
