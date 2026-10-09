package dev.vulxts.module.impl;

import dev.vulxts.VulxtsClient;
import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.notification.NotificationManager;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.SliderSetting;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1923;
import net.minecraft.class_2246;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_310;

public final class ChunkFinderModule extends Module {
   private static final int MIN_CHUNK_AGE_TICKS = 200;
   private static final int CHUNKS_PER_TICK = 8;
   public final SliderSetting mergeRadius = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(";\u000f BmÈ·ÛðėĦň"), Deobf.decrypt(">\u0003$@{È\u0092ÓàĖĺŕĠƸƩǌǱɆȭɋɝʙ˯˓˟̄\u0379͘͢ϏεϓγυМвѝоқҹӯӡԐէՐոև։מ֪\u0603\u061dؚصڒڹڄ۲ܛܲݿݬދߨ߃ߝ߫ࠥ"), 4.0, 1.0, 8.0, 1.0, Deobf.decrypt("V\t:")));
   private final Set beehiveChunks = ConcurrentHashMap.newKeySet();
   private final Set notifiedChunks = ConcurrentHashMap.newKeySet();
   private final Map firstLoadedTicks = new ConcurrentHashMap();
   private volatile Set displayChunks = Set.of();
   private int scanCursor;
   private int tickCounter;
   private boolean displayDirty;
   private int lastMergeRadius;

   public ChunkFinderModule() {
      super(Deobf.decrypt("5\u0002'KcÈ£ÓúĚĶŉ"), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàčųſůƢƴǑƢȵȍɺȓʃʧ˅˙ͤ̓ͥ̚·λργύМХіѶӔҬҧӶԃԵ\u0558Խւց\u05c9צْؓىسڛڲۅ۳ݒܡݴݲޚޠޅߒߢࠧࠬࡄࡡ\u089eࢱ\u089e"), Category.RENDER);
   }

   protected void onEnable() {
      this.clear();
   }

   protected void onDisable() {
      this.clear();
   }

   public void onTick() {
      class_310 var1 = class_310.method_1551();
      if (var1.field_1687 != null && var1.field_1724 != null) {
         ++this.tickCounter;
         int var2 = (Integer)var1.field_1690.method_42503().method_41753();
         class_1923 var3 = var1.field_1724.method_31476();
         int var4 = var2 * 2 + 1;
         int var5 = var4 * var4;
         if (var5 > 0) {
            for(int var6 = 0; var6 < 8; ++var6) {
               int var7 = this.scanCursor % var5;
               this.scanCursor = (this.scanCursor + 1) % var5;
               int var8 = var7 % var4 - var2;
               int var9 = var7 / var4 - var2;
               int var10 = var3.field_9181 + var8;
               int var11 = var3.field_9180 + var9;
               class_2818 var12 = var1.field_1687.method_2935().method_12126(var10, var11, false);
               if (var12 != null && !var12.method_12223()) {
                  long var13 = class_1923.method_8331(var10, var11);
                  this.firstLoadedTicks.putIfAbsent(var13, this.tickCounter);
                  boolean var15 = this.tickCounter - (Integer)this.firstLoadedTicks.get(var13) >= 200;
                  if (var15 && hasTargetSignal(var12)) {
                     if (this.beehiveChunks.add(var13)) {
                        this.displayDirty = true;
                     }

                     if (this.notifiedChunks.add(var13)) {
                        this.showToast(new class_1923(var10, var11));
                     }
                  } else if (this.beehiveChunks.remove(var13)) {
                     this.displayDirty = true;
                  }
               }
            }

            if (this.beehiveChunks.removeIf((var2x) -> {
               return outOfRange(var2x, var3, var2);
            })) {
               this.displayDirty = true;
            }

            this.firstLoadedTicks.keySet().removeIf((var2x) -> {
               return outOfRange(var2x, var3, var2);
            });
            if (this.displayDirty || this.mergeRadius.getInt() != this.lastMergeRadius) {
               this.rebuildDisplay();
            }
         }
      }

   }

   private void rebuildDisplay() {
      this.displayDirty = false;
      this.lastMergeRadius = this.mergeRadius.getInt();
      HashSet var1 = new HashSet(this.beehiveChunks);
      if (var1.size() < 2) {
         this.displayChunks = Set.copyOf(var1);
      } else {
         int var2 = Math.max(1, this.lastMergeRadius);
         HashSet var3 = new HashSet();
         HashSet var4 = new HashSet();
         Iterator var5 = var1.iterator();

         while(true) {
            long var6;
            do {
               if (!var5.hasNext()) {
                  this.displayChunks = Set.copyOf(var3);
                  return;
               }

               var6 = (Long)var5.next();
            } while(!var4.add(var6));

            ArrayList var8 = new ArrayList();
            ArrayDeque var9 = new ArrayDeque();
            var9.add(var6);

            while(!var9.isEmpty()) {
               long var10 = (Long)var9.poll();
               var8.add(var10);
               int var12 = class_1923.method_8325(var10);
               int var13 = class_1923.method_8332(var10);

               for(int var14 = -var2; var14 <= var2; ++var14) {
                  for(int var15 = -var2; var15 <= var2; ++var15) {
                     if (var14 != 0 || var15 != 0) {
                        long var16 = class_1923.method_8331(var12 + var14, var13 + var15);
                        if (var1.contains(var16) && var4.add(var16)) {
                           var9.add(var16);
                        }
                     }
                  }
               }
            }

            var3.add(var8.size() == 1 ? (Long)var8.get(0) : middleChunk(var8));
         }
      }
   }

   private static long middleChunk(List var0) {
      long var1 = 0L;
      long var3 = 0L;

      long var6;
      for(Iterator var5 = var0.iterator(); var5.hasNext(); var3 += (long)class_1923.method_8332(var6)) {
         var6 = (Long)var5.next();
         var1 += (long)class_1923.method_8325(var6);
      }

      int var8 = (int)Math.round((double)var1 / (double)var0.size());
      int var9 = (int)Math.round((double)var3 / (double)var0.size());
      return class_1923.method_8331(var8, var9);
   }

   private static boolean hasTargetSignal(class_2818 var0) {
      class_2826[] var1 = var0.method_12006();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_2826 var4 = var1[var3];
         if (var4 != null && !var4.method_38292() && var4.method_12265().method_19526(ChunkFinderModule::isFullHoney)) {
            for(int var5 = 0; var5 < 16; ++var5) {
               for(int var6 = 0; var6 < 16; ++var6) {
                  for(int var7 = 0; var7 < 16; ++var7) {
                     if (isFullHoney(var4.method_12254(var5, var7, var6))) {
                        return true;
                     }
                  }
               }
            }
         }
      }

      return false;
   }

   private static boolean isFullHoney(class_2680 var0) {
      return (var0.method_27852(class_2246.field_20422) || var0.method_27852(class_2246.field_20421)) && var0.method_28498(class_2741.field_20432) && (Integer)var0.method_11654(class_2741.field_20432) == 5;
   }

   private static boolean outOfRange(long var0, class_1923 var2, int var3) {
      return Math.abs(class_1923.method_8325(var0) - var2.field_9181) > var3 || Math.abs(class_1923.method_8332(var0) - var2.field_9180) > var3;
   }

   private void showToast(class_1923 var1) {
      if (VulxtsClient.notifications() != null) {
         NotificationManager var10000 = VulxtsClient.notifications();
         int var10001 = var1.method_33940();
         var10000.pushInfo("Chunk Finder · X " + var10001 + " Z " + var1.method_33942());
      }

   }

   public Set flaggedChunks() {
      return this.displayChunks;
   }

   public boolean isFlagged(int var1, int var2) {
      long var3 = class_1923.method_8331(var1, var2);
      return this.beehiveChunks.contains(var3) || this.displayChunks.contains(var3);
   }

   public void clear() {
      this.beehiveChunks.clear();
      this.notifiedChunks.clear();
      this.firstLoadedTicks.clear();
      this.displayChunks = Set.of();
      this.scanCursor = 0;
      this.tickCounter = 0;
      this.displayDirty = false;
      this.lastMergeRadius = this.mergeRadius.getInt();
   }
}
