package dev.vulxts.suschunk;

import dev.vulxts.VulxtsClient;
import dev.vulxts.rt.Deobf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.LongConsumer;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_4076;
import net.minecraft.class_6606;

public final class ServerLightCache {
   public static final int SCAN_Y_MIN = -64;
   public static final int SCAN_Y_MAX = 96;
   private static final boolean DEBUG_LOG = Boolean.getBoolean(Deobf.decrypt("\u0000\u001f>]|\u009bËÉáčŽşťƮƴǂ"));
   private static final int TARGET_MIN_SECTION = class_4076.method_18675(-64);
   private static final int TARGET_MAX_SECTION = class_4076.method_18675(96);
   private static final ServerLightCache INSTANCE = new ServerLightCache();
   private final ConcurrentHashMap sections = new ConcurrentHashMap();
   private final ConcurrentHashMap light5Cells = new ConcurrentHashMap();
   private final Set dirtyChunks = ConcurrentHashMap.newKeySet();
   private final List dirtyListeners = new CopyOnWriteArrayList();

   private ServerLightCache() {
   }

   public static ServerLightCache get() {
      return INSTANCE;
   }

   public void clear() {
      this.sections.clear();
      this.light5Cells.clear();
      this.dirtyChunks.clear();
   }

   public boolean consumeDirty(int var1, int var2) {
      return this.dirtyChunks.remove(class_1923.method_8331(var1, var2));
   }

   public void addDirtyListener(LongConsumer var1) {
      this.dirtyListeners.add(var1);
   }

   public void markDirty(int var1, int var2) {
      long var3 = class_1923.method_8331(var1, var2);
      this.dirtyChunks.add(var3);
      Iterator var5 = this.dirtyListeners.iterator();

      while(var5.hasNext()) {
         LongConsumer var6 = (LongConsumer)var5.next();
         var6.accept(var3);
      }

   }

   public void ingest(int var1, int var2, class_6606 var3, class_1937 var4) {
      if (var4 != null) {
         int var5 = var4.method_32891() - 1;
         BitSet var6 = var3.method_38608();
         BitSet var7 = var3.method_38609();
         List var8 = var3.method_38610();
         int var9 = 0;
         boolean var10 = false;

         int var17;
         for(var17 = var6.nextSetBit(0); var17 >= 0; var17 = var6.nextSetBit(var17 + 1)) {
            byte[] var12 = var9 < var8.size() ? (byte[])var8.get(var9) : null;
            ++var9;
            int var13 = var5 + var17;
            if (var12 != null && var12.length == 2048 && var13 >= TARGET_MIN_SECTION && var13 <= TARGET_MAX_SECTION) {
               long var14 = class_4076.method_18685(var1, var13, var2);
               this.sections.put(var14, (byte[])var12.clone());
               int var16 = this.cacheLight5(var14, var12);
               if (DEBUG_LOG && var16 > 0) {
                  VulxtsClient.LOGGER.info(Deobf.decrypt("-\u0019'V%\u0084\u008cÝüĊĎěųƩƢǑǫȉȮȊțʛʲʜˌ̻͈̌ͬφϠΕϨϝѝнќѹҜҹҪұՂԷՒծ֚֜גץؙ\u0601"), new Object[]{var1, var13, var2, var16});
               }

               var10 = true;
            }
         }

         for(var17 = var7.nextSetBit(0); var17 >= 0; var17 = var7.nextSetBit(var17 + 1)) {
            int var18 = var5 + var17;
            if (var18 >= TARGET_MIN_SECTION && var18 <= TARGET_MAX_SECTION) {
               long var19 = class_4076.method_18685(var1, var18, var2);
               this.light5Cells.remove(var19);
               if (this.sections.remove(var19) != null) {
                  var10 = true;
               }
            }
         }

         if (var10) {
            this.markDirty(var1, var2);
         }
      }

   }

   public int serverBlockLight(int var1, int var2, int var3) {
      if (var2 >= -64 && var2 <= 96) {
         byte[] var4 = (byte[])this.sections.get(class_4076.method_18685(class_4076.method_18675(var1), class_4076.method_18675(var2), class_4076.method_18675(var3)));
         if (var4 == null) {
            return -1;
         } else {
            int var5 = (var2 & 15) << 8 | (var3 & 15) << 4 | var1 & 15;
            int var6 = var4[var5 >> 1] & 255;
            return (var5 & 1) == 0 ? var6 & 15 : var6 >> 4 & 15;
         }
      } else {
         return -1;
      }
   }

   public boolean isServerLight5(int var1, int var2, int var3) {
      return this.serverBlockLight(var1, var2, var3) == 5;
   }

   private int cacheLight5(long var1, byte[] var3) {
      short[] var4 = null;
      int var5 = 0;

      for(int var6 = 0; var6 < 4096; ++var6) {
         int var8 = var3[var6 >> 1] & 255;
         int var7 = (var6 & 1) == 0 ? var8 & 15 : var8 >> 4 & 15;
         if (var7 == 5) {
            if (var4 == null) {
               var4 = new short[16];
            } else if (var5 == var4.length) {
               var4 = Arrays.copyOf(var4, var4.length * 2);
            }

            var4[var5++] = (short)var6;
         }
      }

      if (var5 == 0) {
         this.light5Cells.remove(var1);
      } else {
         this.light5Cells.put(var1, Arrays.copyOf(var4, var5));
      }

      return var5;
   }

   public List light5Positions(int var1, int var2) {
      ArrayList var3 = null;
      int var4 = var1 << 4;
      int var5 = var2 << 4;

      for(int var6 = TARGET_MIN_SECTION; var6 <= TARGET_MAX_SECTION; ++var6) {
         short[] var7 = (short[])this.light5Cells.get(class_4076.method_18685(var1, var6, var2));
         if (var7 != null) {
            int var8 = var6 << 4;
            short[] var9 = var7;
            int var10 = var7.length;

            for(int var11 = 0; var11 < var10; ++var11) {
               short var12 = var9[var11];
               int var13 = var12 & '\uffff';
               int var14 = var8 + (var13 >> 8);
               if (var14 >= -64 && var14 <= 96) {
                  if (var3 == null) {
                     var3 = new ArrayList();
                  }

                  var3.add(new class_2338(var4 + (var13 & 15), var14, var5 + (var13 >> 4 & 15)));
               }
            }
         }
      }

      return (List)(var3 == null ? List.of() : var3);
   }

   public void injectForTest(int var1, int var2, int var3, int var4) {
      int var5 = class_4076.method_18675(var1);
      int var6 = class_4076.method_18675(var3);
      long var7 = class_4076.method_18685(var5, class_4076.method_18675(var2), var6);
      byte[] var9 = (byte[])this.sections.computeIfAbsent(var7, (var0) -> {
         return new byte[2048];
      });
      int var10 = (var2 & 15) << 8 | (var3 & 15) << 4 | var1 & 15;
      int var11 = var10 >> 1;
      int var12 = (var10 & 1) * 4;
      var9[var11] = (byte)(var9[var11] & ~(15 << var12) | (var4 & 15) << var12);
      this.cacheLight5(var7, var9);
      this.markDirty(var5, var6);
   }

   public boolean hasChunk(int var1, int var2) {
      for(int var3 = TARGET_MIN_SECTION; var3 <= TARGET_MAX_SECTION; ++var3) {
         if (this.sections.containsKey(class_4076.method_18685(var1, var3, var2))) {
            return true;
         }
      }

      return false;
   }
}
