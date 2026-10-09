package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Modules;

public final class SpotifyHudModule extends Modules.SpotifyModule {
   public SpotifyHudModule() {
      this.setEnabled(false);
      this.volume.set(false);
      this.volume.visibleWhen(() -> {
         return false;
      });
   }

   public String getDescription() {
      return "Shows the Windows Spotify desktop song locally. No account or scripts required.";
   }

   protected void onEnable() {
      this.sync(true);
   }

   protected void onDisable() {
      this.sync(false);
   }

   public void onTick() {
      this.sync(!this.source.is("Demo"));
   }

   private void sync(boolean var1) {
      if (VulxtsClient.spotify() != null) {
         VulxtsClient.spotify().setEnabled(var1);
      }

   }
}
