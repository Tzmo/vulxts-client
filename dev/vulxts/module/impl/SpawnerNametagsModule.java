package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.settings.ColorSetting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2636;
import net.minecraft.class_2818;
import net.minecraft.class_310;
import net.minecraft.class_3417;

public final class SpawnerNametagsModule extends Module {
   public final ColorSetting color = (ColorSetting)this.addSetting(new ColorSetting("Color", "Spawner beam color", -44976));
   private final CopyOnWriteArrayList spawners = new CopyOnWriteArrayList();
   private final Set known = ConcurrentHashMap.newKeySet();
   private long lastSoundAt;
   private int ticks;

   public SpawnerNametagsModule() {
      super("Spawner Notifier", "Finds loaded mob spawners and marks them with a beam", Category.RENDER);
   }

   protected void onEnable() {
      this.spawners.clear();
      this.known.clear();
      this.ticks = 0;
   }

   protected void onDisable() {
      this.spawners.clear();
      this.known.clear();
   }

   public void onTick() {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1687 != null && var1.field_1724 != null && ++this.ticks % 40 == 0) {
         this.ticks = 0;
         class_1923 var2 = var1.field_1724.method_31476();
         int var3 = Math.min(8, (Integer)var1.field_1690.method_42503().method_41753());
         ArrayList var4 = new ArrayList();

         for(int var5 = -var3; var5 <= var3; ++var5) {
            for(int var6 = -var3; var6 <= var3; ++var6) {
               class_2818 var7 = var1.field_1687.method_2935().method_12126(var2.field_9181 + var5, var2.field_9180 + var6, false);
               if (var7 != null) {
                  Iterator var8 = var7.method_12214().values().iterator();

                  while(var8.hasNext()) {
                     class_2586 var9 = (class_2586)var8.next();
                     if (var9 instanceof class_2636) {
                        class_2338 var10 = var9.method_11016();
                        class_2338 var11 = new class_2338(var10.method_10263(), var10.method_10264(), var10.method_10260());
                        var4.add(var11);
                        if (this.known.add(var11)) {
                           this.announce(var1, var11);
                        }
                     }
                  }
               }
            }
         }

         this.known.retainAll(new HashSet(var4));
         this.spawners.clear();
         this.spawners.addAll(var4);
      }
   }

   private void announce(class_310 var1, class_2338 var2) {
      long var3 = System.currentTimeMillis();
      if (var3 - this.lastSoundAt > 5000L) {
         this.lastSoundAt = var3;
         var1.field_1724.method_5783(class_3417.field_14627, 1.0F, 1.2F);
      }

      int var10000 = var2.method_10263();
      String var5 = "§a[SpawnerNotifier] §fSpawner found at §e" + var10000 + ", " + var2.method_10264() + ", " + var2.method_10260();

      for(int var6 = 0; var6 < 4; ++var6) {
         var1.field_1705.method_1743().method_1812(class_2561.method_43470(var5));
      }

   }

   public List visiblePositions() {
      return List.copyOf(this.spawners);
   }

   public void markDirty() {
   }

   public void markChunkDirty(int var1, int var2) {
   }

   public void clear() {
      this.spawners.clear();
      this.known.clear();
      this.ticks = 0;
   }
}
