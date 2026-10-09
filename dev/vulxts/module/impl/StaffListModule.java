package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.staff.StaffTracker;
import java.util.List;

public class StaffListModule extends Module {
   public final BooleanSetting showRank = new BooleanSetting("Show Rank", "", false);
   public final BooleanSetting showPing = new BooleanSetting("Show Ping", "", false);
   public final SliderSetting maxRows = new SliderSetting("Max Rows", "", 6.0, 6.0, 6.0, 1.0);
   public final StaffTracker tracker = new StaffTracker(this);

   public StaffListModule() {
      super("StaffList", "Automatically lists online players with the confirmed green star badge.", Category.MISC);
   }

   protected void onEnable() {
      this.tracker.reset();
   }

   protected void onDisable() {
      this.tracker.clear();
   }

   public void onTick() {
      this.tracker.tick();
   }

   public List staff() {
      return this.tracker.current();
   }
}
