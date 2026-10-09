package dev.vulxts.render;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import net.minecraft.class_2818;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public final class IncrementalScan {
   private final int chunksPerTick;
   private final int blockBudgetPerTick;
   private final int idleTicks;
   private volatile List published = List.of();
   private List building = new ArrayList();
   private int cursor;
   private int[] order = new int[0];
   private int orderRadius = -1;
   private int sweepPcx = Integer.MIN_VALUE;
   private int sweepPcz = Integer.MIN_VALUE;
   private class_638 sweepLevel;
   private int cooldown;
   private boolean dirty;

   public IncrementalScan(int var1, int var2, int var3) {
      this.chunksPerTick = var1;
      this.blockBudgetPerTick = var2;
      this.idleTicks = var3;
   }

   public List get() {
      return this.published;
   }

   public void markDirty() {
      this.dirty = true;
   }

   public void clear() {
      this.published = List.of();
      this.building = new ArrayList();
      this.cursor = 0;
      this.cooldown = 0;
      this.dirty = false;
      this.sweepPcz = Integer.MIN_VALUE;
      this.sweepPcx = Integer.MIN_VALUE;
      this.sweepLevel = null;
   }

   public void tick(int var1, ChunkScanner var2) {
      class_310 var3 = class_310.method_1551();
      class_638 var4 = var3.field_1687;
      class_746 var5 = var3.field_1724;
      if (var4 != null && var5 != null) {
         if (this.sweepLevel != var4) {
            this.published = List.of();
            this.building = new ArrayList();
            this.cursor = 0;
            this.cooldown = 0;
            this.dirty = true;
            this.sweepPcx = Integer.MIN_VALUE;
            this.sweepPcz = Integer.MIN_VALUE;
            this.sweepLevel = var4;
         }

         if (this.orderRadius != var1) {
            this.ensureOrder(var1);
            this.dirty = true;
         }

         int var6 = var5.method_31476().field_9181;
         int var7 = var5.method_31476().field_9180;
         if (this.sweepPcx != Integer.MIN_VALUE && Math.max(Math.abs(var6 - this.sweepPcx), Math.abs(var7 - this.sweepPcz)) >= 2) {
            this.dirty = true;
         }

         if (this.cursor == 0) {
            if (!this.dirty && this.cooldown > 0) {
               --this.cooldown;
               return;
            }

            this.sweepPcx = var6;
            this.sweepPcz = var7;
            this.building = new ArrayList();
            this.dirty = false;
         } else if (this.dirty) {
            this.sweepPcx = var6;
            this.sweepPcz = var7;
            this.cursor = 0;
            this.building = new ArrayList();
            this.dirty = false;
         }

         int var8 = this.order.length;
         int var9 = 0;

         for(int var10 = 0; this.cursor < var8 && var9 < this.chunksPerTick && var10 < this.blockBudgetPerTick; ++var9) {
            int var11 = this.order[this.cursor];
            short var12 = (short)(var11 >> 16);
            short var13 = (short)(var11 & '\uffff');
            class_2818 var14 = var4.method_2935().method_12126(this.sweepPcx + var12, this.sweepPcz + var13, false);
            if (var14 != null) {
               var10 += var2.scan(var14, this.building);
            }

            ++this.cursor;
         }

         if (this.cursor >= var8) {
            this.published = List.copyOf(this.building);
            this.building = new ArrayList();
            this.cursor = 0;
            this.cooldown = this.idleTicks;
         } else if (!this.building.isEmpty()) {
            LinkedHashSet var15 = new LinkedHashSet(this.published);
            var15.addAll(this.building);
            this.published = List.copyOf(var15);
         }
      }

   }

   private void ensureOrder(int var1) {
      if (this.orderRadius != var1) {
         int var2 = 2 * var1 + 1;
         Integer[] var3 = new Integer[var2 * var2];
         int var4 = 0;

         int var8;
         for(int var5 = -var1; var5 <= var1; ++var5) {
            for(var8 = -var1; var8 <= var1; ++var8) {
               var3[var4++] = (var5 & '\uffff') << 16 | var8 & '\uffff';
            }
         }

         Arrays.sort(var3, (var0, var1x) -> {
            short var2x = (short)(var0 >> 16);
            short var3x = (short)(var0 & '\uffff');
            short var4x = (short)(var1x >> 16);
            short var5x = (short)(var1x & '\uffff');
            return Integer.compare(var2x * var2x + var3x * var3x, var4x * var4x + var5x * var5x);
         });
         int[] var7 = new int[var3.length];

         for(var8 = 0; var8 < var3.length; ++var8) {
            var7[var8] = var3[var8];
         }

         this.order = var7;
         this.orderRadius = var1;
      }

   }

   public interface ChunkScanner {
      int scan(class_2818 var1, List var2);
   }
}
