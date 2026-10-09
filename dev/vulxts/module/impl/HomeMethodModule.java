package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.KeybindSetting;
import dev.vulxts.settings.SliderSetting;
import java.util.ArrayDeque;
import java.util.Queue;
import net.minecraft.class_1923;
import net.minecraft.class_310;
import net.minecraft.class_746;

public final class HomeMethodModule extends Module {
   public final KeybindSetting trigger = (KeybindSetting)this.addSetting(new KeybindSetting("Trigger", "Runs the home sequence while the module is enabled.", -1));
   public final BooleanSetting requireChunkFinder = (BooleanSetting)this.addSetting(new BooleanSetting("Require Chunk Finder", "Only starts automatically while rising over a Chunk Finder result.", true));
   public final SliderSetting digY = (SliderSetting)this.addSetting(new SliderSetting("Dig Y", "Y level that starts the home 2, RTP and return sequence.", -2.0, -64.0, 64.0, 1.0));
   private final Queue commands = new ArrayDeque();
   private boolean homeOneArmed;
   private boolean depthSequenceQueued;
   private boolean risingLatch;

   public HomeMethodModule() {
      super("Auto Home Method", "Fly over a result, save home 1, dig down, then run the return sequence.", Category.MISC);
   }

   protected void onEnable() {
      this.resetSequence();
   }

   protected void onDisable() {
      this.resetSequence();
   }

   public boolean onKeyPress(int var1) {
      if (!this.trigger.matches(var1)) {
         return false;
      } else {
         this.startFlyOverSequence();
         return true;
      }
   }

   public void onTick() {
      class_310 var1 = class_310.method_1551();
      class_746 var2 = var1.field_1724;
      if (var2 != null && var1.field_1687 != null) {
         this.drainCommands(var1);
         boolean var3 = !var2.method_6128() && !var2.method_31549().field_7479 && !var2.method_24828() && var2.method_18798().field_1351 > 0.05;
         if (var3 && !this.risingLatch && !this.homeOneArmed && this.commands.isEmpty() && this.allowedChunk(var2)) {
            this.startFlyOverSequence();
         }

         this.risingLatch = var3;
         if (this.homeOneArmed && !this.depthSequenceQueued && var2.method_23318() <= (double)this.digY.getInt()) {
            this.queueDepthSequence();
         }

      }
   }

   private boolean allowedChunk(class_746 var1) {
      if (!(Boolean)this.requireChunkFinder.get()) {
         return true;
      } else {
         ChunkFinderModule var2 = VulxtsClient.modules().chunkFinder;
         if (var2 != null && var2.isEnabled()) {
            class_1923 var3 = var1.method_31476();
            return var2.isFlagged(var3.field_9181, var3.field_9180);
         } else {
            return false;
         }
      }
   }

   private void startFlyOverSequence() {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1724 != null && var1.field_1687 != null) {
         this.commands.clear();
         long var2 = System.currentTimeMillis();
         this.commands.offer(new QueuedCommand(var2, "delhome 1"));
         this.commands.offer(new QueuedCommand(var2 + 350L, "sethome 1"));
         this.homeOneArmed = true;
         this.depthSequenceQueued = var1.field_1724.method_23318() <= (double)this.digY.getInt();
         if (this.depthSequenceQueued) {
            this.queueDepthCommands(var2 + 700L);
         }

         if (VulxtsClient.notifications() != null) {
            VulxtsClient.notifications().pushInfo("Auto Home Method · home 1 queued, dig to Y " + this.digY.getInt());
         }

      }
   }

   private void queueDepthSequence() {
      this.depthSequenceQueued = true;
      this.queueDepthCommands(System.currentTimeMillis());
      if (VulxtsClient.notifications() != null) {
         VulxtsClient.notifications().pushInfo("Auto Home Method · dig depth reached, return queued");
      }

   }

   private void queueDepthCommands(long var1) {
      this.commands.offer(new QueuedCommand(var1, "delhome 2"));
      this.commands.offer(new QueuedCommand(var1 + 350L, "sethome 2"));
      this.commands.offer(new QueuedCommand(var1 + 850L, "rtp"));
      this.commands.offer(new QueuedCommand(var1 + 2100L, "home 2"));
      this.commands.offer(new QueuedCommand(var1 + 3200L, "home 1"));
   }

   private void drainCommands(class_310 var1) {
      long var2 = System.currentTimeMillis();

      while(!this.commands.isEmpty() && ((QueuedCommand)this.commands.peek()).atMillis() <= var2) {
         QueuedCommand var4 = (QueuedCommand)this.commands.poll();
         if (var1.method_1562() != null) {
            var1.method_1562().method_45730(var4.command());
         }

         if ("home 1".equals(var4.command())) {
            this.homeOneArmed = false;
         }
      }

   }

   private void resetSequence() {
      this.commands.clear();
      this.homeOneArmed = false;
      this.depthSequenceQueued = false;
      this.risingLatch = false;
   }

   private static record QueuedCommand(long atMillis, String command) {
      private QueuedCommand(long atMillis, String command) {
         this.atMillis = atMillis;
         this.command = command;
      }

      public long atMillis() {
         return this.atMillis;
      }

      public String command() {
         return this.command;
      }
   }
}
