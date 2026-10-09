package dev.vulxts.license.dev.vulxts.license.LicenseGuardVM;

import BytecodeVM.Teh;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.lang.invoke.VarHandle.AccessMode;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

public final class MAvvyFT {
   private static final List kCfG;
   private static final Map zygGK;
   private static final Map eMy;
   private static final Map CgMJuY;
   private static final Map nmt;

   private MAvvyFT() {
   }

   static void wzTg(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 1578272046);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -399493713, -40452059);
         var165 = var162 ^ var164;
      }

      int var45;
      int var46;
      Object var47;
      switch (var165) {
         case -844252026:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)var5;
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case -605407213:
            int var120 = var1.iBb();
            int var121 = var2.aCEjMat;
            int var128 = var1.iBb();
            int var129 = var1.aUp()[var6 * 9 + 4];
            int var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            int var132 = var1.iBb();
            int var133 = var1.aUp()[var6 * 9 + 8];
            int var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            int var136 = var1.iBb();
            int var137 = var1.aUp()[var6 * 9 + 7];
            int var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            int var125 = var123 + var51;
            int var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               int var140 = var1.iBb();
               int var141 = var1.aUp()[var6 * 9 + 0];
               int var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)var127;
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 1748334080:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            float var170;
            if (var46 == 3) {
               var170 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Float)var47;
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            float var171;
            if (var46 == 3) {
               var171 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var171 = (Float)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)Float.floatToRawIntBits(var171 % var170);
            var2.nXw[var2.wwLICq] = 3;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void HbfI(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      boolean var51 = false;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 2084354986);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -341080369, -541524319);
         var165 = var162 ^ var164;
      }

      int var45;
      int var46;
      Object var47;
      switch (var165) {
         case -1239758642:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            Object var171 = var47;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.WPY[var2.wwLICq] = var171;
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            var2.WPY[var2.wwLICq] = var47;
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 113345061:
            int var28 = var2.pzML[var2.wwLICq - 1];
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.WPY[var2.wwLICq] = var47;
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = var28;
            ++var2.wwLICq;
            var2.WPY[var2.wwLICq] = var47;
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = var28;
            ++var2.wwLICq;
            break;
         case 1836735645:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var170;
            if (var46 == 4) {
               var170 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Double)var47;
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var172;
            if (var46 == 4) {
               var172 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var172 = (Double)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = Double.doubleToRawLongBits(var172 + var170);
            var2.nXw[var2.wwLICq] = 4;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void FfVGX(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 1261258297);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -676343165, -391576782);
         var165 = var162 ^ var164;
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -1238712399:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            long var170;
            if (var46 == 2) {
               var170 = var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Long)var47;
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            long var171;
            if (var46 == 2) {
               var171 = var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var171 = (Long)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = var171 ^ var170;
            var2.nXw[var2.wwLICq] = 2;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         case -1198492333:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.tDShno[var127] = var47;
            break;
         case 1760315294:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            Object[] var22 = new Object[]{var3[var127]};
            var2.WPY[var2.wwLICq] = var22;
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void dJejC(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      NlX var171 = var2;
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, -439057428);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -599128034, 1179698919);
         var165 = var162 ^ -599128034 ^ var164 ^ -599128034;
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -724722830:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var32 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var33 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var34 = WKRZ(var1, var2, var3, var127, var6, var4);
            Object var23 = null;
            Object var35 = KNV(var32, var33, var34, true, var23);
            if (var34.charAt(0) != 'J' && var34.charAt(0) != 'D') {
               var2.WPY[var2.wwLICq] = var35;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 1;
               ++var2.wwLICq;
            } else {
               var2.WPY[var2.wwLICq] = var35;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 2;
               ++var2.wwLICq;
            }
            break;
         case 399709746:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var172;
            if (var46 == 4) {
               var172 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var172 = (Double)var47;
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            int var24;
            if (var46 == 1) {
               var24 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var24 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            ((double[])var47)[var24] = var172;
            break;
         case 1653987505:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var15 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            MethodType var17 = iiGNaf(WKRZ(var1, var2, var3, var127, var6, var4));
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            Object[] var18 = new Object[var17.parameterCount()];

            for(int var19 = var18.length - 1; var19 >= 0; --var19) {
               var45 = var171.wwLICq - 1;
               var171.wwLICq = var45;
               var46 = var171.nXw[var45];
               var171.nXw[var45] = 0;
               var171.pzML[var45] = 0;
               var47 = var171.WPY[var45];
               var171.WPY[var45] = null;
               if (var46 == 1) {
                  var47 = (int)var171.OKuX[var45];
               } else if (var46 == 2) {
                  var47 = var171.OKuX[var45];
               } else if (var46 == 3) {
                  var47 = Float.intBitsToFloat((int)var171.OKuX[var45]);
               } else if (var46 == 4) {
                  var47 = Double.longBitsToDouble(var171.OKuX[var45]);
               }

               var18[var19] = var47;
            }

            var45 = var171.wwLICq - 1;
            var171.wwLICq = var45;
            var46 = var171.nXw[var45];
            var171.nXw[var45] = 0;
            var171.pzML[var45] = 0;
            var47 = var171.WPY[var45];
            var171.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var171.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var171.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var171.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var171.OKuX[var45]);
            }

            Object var21 = WIOys(var15, var17, var18);
            var171.QvZwT(var47, var21);
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void xdv(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      NlX var171 = var2;
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, -1427678125);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -1768173983, 157489496);
         var165 = ~(~var162 ^ var164);
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      Class var22;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -1967829656:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var22 = arOED(WKRZ(var1, var2, var3, var127, var6, var4));
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)var22.isInstance(var47);
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case -583825736:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var22 = arOED(WKRZ(var1, var2, var3, var127, var6, var4));
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.WPY[var2.wwLICq] = var22.cast(var47);
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 1666243374:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            String var15 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            String var16 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            MethodType var17 = iiGNaf(WKRZ(var1, var2, var3, var127, var6, var4));
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            Object[] var18 = new Object[var17.parameterCount()];

            for(int var19 = var18.length - 1; var19 >= 0; --var19) {
               var45 = var171.wwLICq - 1;
               var171.wwLICq = var45;
               var46 = var171.nXw[var45];
               var171.nXw[var45] = 0;
               var171.pzML[var45] = 0;
               var47 = var171.WPY[var45];
               var171.WPY[var45] = null;
               if (var46 == 1) {
                  var47 = (int)var171.OKuX[var45];
               } else if (var46 == 2) {
                  var47 = var171.OKuX[var45];
               } else if (var46 == 3) {
                  var47 = Float.intBitsToFloat((int)var171.OKuX[var45]);
               } else if (var46 == 4) {
                  var47 = Double.longBitsToDouble(var171.OKuX[var45]);
               }

               var18[var19] = var47;
            }

            var45 = var171.wwLICq - 1;
            var171.wwLICq = var45;
            var46 = var171.nXw[var45];
            var171.nXw[var45] = 0;
            var171.pzML[var45] = 0;
            var47 = var171.WPY[var45];
            var171.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var171.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var171.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var171.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var171.OKuX[var45]);
            }

            Object var21 = RhZCIyO(var15, var16, var17, false, var47, var18);
            Class var48 = var17.returnType();
            if (var48 != Void.TYPE) {
               if (var48 != Long.TYPE && var48 != Double.TYPE) {
                  var171.WPY[var171.wwLICq] = var21;
                  var171.nXw[var171.wwLICq] = 0;
                  var171.pzML[var171.wwLICq] = 1;
                  ++var171.wwLICq;
               } else {
                  var171.WPY[var171.wwLICq] = var21;
                  var171.nXw[var171.wwLICq] = 0;
                  var171.pzML[var171.wwLICq] = 2;
                  ++var171.wwLICq;
               }
            }
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void xkIQdDz(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 269043149);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, 801849455, -1282604858);
         var165 = var162 ^ var164;
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -2010239853:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            Object var24 = var3[var127];
            var24 = WLwi(var1, var24, var2, var6, var4);
            if (!(var24 instanceof Long) && !(var24 instanceof Double)) {
               var2.WPY[var2.wwLICq] = var24;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 1;
               ++var2.wwLICq;
            } else {
               var2.WPY[var2.wwLICq] = var24;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 2;
               ++var2.wwLICq;
            }
            break;
         case -1492393212:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            if (var5 != 0) {
               var2.XGrBNgx = var127;
            }
            break;
         case 531750646:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)var5;
            var2.nXw[var2.wwLICq] = 2;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void HKICp(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      NlX var171 = var2;
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, -430347328);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, 1809523690, 1172123339);
         var165 = var162 ^ 1809523690 ^ var164 ^ 1809523690;
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -1205116182:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            Object var23 = null;
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            String var32 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            String var33 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            String var34 = WKRZ(var1, var2, var3, var127, var6, var4);
            SVesFw(var32, var33, var34, true, var23, var47);
            break;
         case 11114686:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.tDShno[var127] = var47;
            break;
         case 652094929:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            String var15 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            String var16 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            MethodType var17 = iiGNaf(WKRZ(var1, var2, var3, var127, var6, var4));
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            Object[] var18 = new Object[var17.parameterCount()];

            for(int var19 = var18.length - 1; var19 >= 0; --var19) {
               var45 = var171.wwLICq - 1;
               var171.wwLICq = var45;
               var46 = var171.nXw[var45];
               var171.nXw[var45] = 0;
               var171.pzML[var45] = 0;
               var47 = var171.WPY[var45];
               var171.WPY[var45] = null;
               if (var46 == 1) {
                  var47 = (int)var171.OKuX[var45];
               } else if (var46 == 2) {
                  var47 = var171.OKuX[var45];
               } else if (var46 == 3) {
                  var47 = Float.intBitsToFloat((int)var171.OKuX[var45]);
               } else if (var46 == 4) {
                  var47 = Double.longBitsToDouble(var171.OKuX[var45]);
               }

               var18[var19] = var47;
            }

            var45 = var171.wwLICq - 1;
            var171.wwLICq = var45;
            var46 = var171.nXw[var45];
            var171.nXw[var45] = 0;
            var171.pzML[var45] = 0;
            var47 = var171.WPY[var45];
            var171.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var171.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var171.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var171.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var171.OKuX[var45]);
            }

            Object var21 = RhZCIyO(var15, var16, var17, false, var47, var18);
            Class var48 = var17.returnType();
            if (var48 != Void.TYPE) {
               if (var48 != Long.TYPE && var48 != Double.TYPE) {
                  var171.WPY[var171.wwLICq] = var21;
                  var171.nXw[var171.wwLICq] = 0;
                  var171.pzML[var171.wwLICq] = 1;
                  ++var171.wwLICq;
               } else {
                  var171.WPY[var171.wwLICq] = var21;
                  var171.nXw[var171.wwLICq] = 0;
                  var171.pzML[var171.wwLICq] = 2;
                  ++var171.wwLICq;
               }
            }
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void fqLZhKT(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 1069852654);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, 2095381877, -1673469211);
         var165 = ~(~var162 ^ var164);
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -709103560:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            if (var5 != 0) {
               var2.XGrBNgx = var127;
            }
            break;
         case -486786709:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)var5;
            var2.nXw[var2.wwLICq] = 2;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         case 690705561:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var2.WPY[var2.wwLICq] = var2.tDShno[var127];
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void DOuP(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 1721443823);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -241675721, -987799324);
         var165 = var162 ^ var164;
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -142907550:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var170;
            if (var46 == 4) {
               var170 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Double)var47;
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var171;
            if (var46 == 4) {
               var171 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var171 = (Double)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = Double.doubleToRawLongBits(var171 + var170);
            var2.nXw[var2.wwLICq] = 4;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         case 374298383:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = var127 ^ 625009042 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125) ^ 625009042;
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = var127 ^ 17829410 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284) ^ 17829410;
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            if (var5 == 0) {
               var2.XGrBNgx = var127;
            }
            break;
         case 831335097:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = var127 ^ 625009042 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125) ^ 625009042;
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = var127 ^ 17829410 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284) ^ 17829410;
               }
            }

            ++var51;
            Class var22 = arOED(WKRZ(var1, var2, var3, var127, var6, var4));
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)var22.isInstance(var47);
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void zlVu(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 1498449438);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -743674791, -86719723);
         var165 = ~(~var162 ^ var164);
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -1894347353:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = var127 ^ 551977378 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125) ^ 551977378;
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = var127 ^ 79064594 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284) ^ 79064594;
               }
            }

            ++var51;
            Class var22 = arOED(WKRZ(var1, var2, var3, var127, var6, var4));
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.WPY[var2.wwLICq] = var22.cast(var47);
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 405613525:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = var127 ^ 551977378 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125) ^ 551977378;
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = var127 ^ 79064594 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284) ^ 79064594;
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.tDShno[var127] = var47;
            break;
         case 1114827927:
            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)-1;
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void coaDaxD(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      boolean var51 = false;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 1817778);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, 1909373319, -1549796935);
         var165 = var162 ^ var164;
      }

      switch (var165) {
         case 725832035:
            var2.WPY[var2.wwLICq] = null;
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 1443274128:
            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)1;
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 1569922211:
            int var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            int var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var170;
            if (var46 == 4) {
               var170 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               Object var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Double)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)((int)var170);
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void ysvpGv(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, -1778331246);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -253162647, 897881241);
         var165 = ~(~var162 ^ var164);
      }

      switch (var165) {
         case -2025262619:
            int var120 = var1.iBb();
            int var121 = var2.aCEjMat;
            int var128 = var1.iBb();
            int var129 = var1.aUp()[var6 * 9 + 4];
            int var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            int var132 = var1.iBb();
            int var133 = var1.aUp()[var6 * 9 + 8];
            int var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            int var136 = var1.iBb();
            int var137 = var1.aUp()[var6 * 9 + 7];
            int var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            int var125 = var123 + var51;
            int var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            int var140;
            int var141;
            int var126;
            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var32 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var33 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var34 = WKRZ(var1, var2, var3, var127, var6, var4);
            Object var23 = null;
            Object var35 = KNV(var32, var33, var34, true, var23);
            if (var34.charAt(0) != 'J' && var34.charAt(0) != 'D') {
               var2.WPY[var2.wwLICq] = var35;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 1;
               ++var2.wwLICq;
            } else {
               var2.WPY[var2.wwLICq] = var35;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 2;
               ++var2.wwLICq;
            }
            break;
         case -1540757531:
            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)0;
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case -493282621:
            int var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            int var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var170;
            Object var47;
            if (var46 == 4) {
               var170 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Double)var47;
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            int var24;
            if (var46 == 1) {
               var24 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var24 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            ((double[])var47)[var24] = var170;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void XumzIiw(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, -1736836074);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -1777413141, 1006483741);
         var165 = var162 ^ var164;
      }

      int var45;
      int var46;
      Object var47;
      switch (var165) {
         case -1760524655:
            int var120 = var1.iBb();
            int var121 = var2.aCEjMat;
            int var128 = var1.iBb();
            int var129 = var1.aUp()[var6 * 9 + 4];
            int var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            int var132 = var1.iBb();
            int var133 = var1.aUp()[var6 * 9 + 8];
            int var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            int var136 = var1.iBb();
            int var137 = var1.aUp()[var6 * 9 + 7];
            int var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            int var125 = var123 + var51;
            int var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               int var140 = var1.iBb();
               int var141 = var1.aUp()[var6 * 9 + 0];
               int var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            if (var47 == null) {
               var2.XGrBNgx = var127;
            }
            break;
         case -1375362723:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)Array.getLength(var47);
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 959906221:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var7 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var7 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)(var7 >>> var5);
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void sIJC(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 58184574);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, 1285200964, -1594648971);
         var165 = ~(var162 ^ ~var164);
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -651207475:
            int var10000 = var2.pzML[var2.wwLICq - 1];
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               Integer var171 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               Long var172 = var2.OKuX[var45];
            } else if (var46 == 3) {
               Float var173 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               Double var174 = Double.longBitsToDouble(var2.OKuX[var45]);
            }
            break;
         case 709482207:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            Object var170 = var47;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            if (var47 != var170) {
               var2.XGrBNgx = var127;
            }
            break;
         case 1703263198:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            var2.XGrBNgx = var127;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void xMU(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 1068128016);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, 1742032919, -1674702309);
         var165 = var162 ^ var164;
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      Object var24;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case 384733897:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            if (var5 < 0) {
               var2.XGrBNgx = var127;
            }
            break;
         case 764717692:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var24 = var3[var127];
            var24 = WLwi(var1, var24, var2, var6, var4);
            if (!(var24 instanceof Long) && !(var24 instanceof Double)) {
               var2.WPY[var2.wwLICq] = var24;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 1;
               ++var2.wwLICq;
            } else {
               var2.WPY[var2.wwLICq] = var24;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 2;
               ++var2.wwLICq;
            }
            break;
         case 1608718901:
            int var28 = var2.pzML[var2.wwLICq - 1];
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var24 = var47;
            if (var28 == 2) {
               var2.WPY[var2.wwLICq] = var47;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = var28;
               ++var2.wwLICq;
               var2.WPY[var2.wwLICq] = var47;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = var28;
               ++var2.wwLICq;
            } else {
               int var29 = var2.pzML[var2.wwLICq - 1];
               var45 = var2.wwLICq - 1;
               var2.wwLICq = var45;
               var46 = var2.nXw[var45];
               var2.nXw[var45] = 0;
               var2.pzML[var45] = 0;
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               if (var46 == 1) {
                  var47 = (int)var2.OKuX[var45];
               } else if (var46 == 2) {
                  var47 = var2.OKuX[var45];
               } else if (var46 == 3) {
                  var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
               } else if (var46 == 4) {
                  var47 = Double.longBitsToDouble(var2.OKuX[var45]);
               }

               var2.WPY[var2.wwLICq] = var47;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = var29;
               ++var2.wwLICq;
               var2.WPY[var2.wwLICq] = var24;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = var28;
               ++var2.wwLICq;
               var2.WPY[var2.wwLICq] = var47;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = var29;
               ++var2.wwLICq;
               var2.WPY[var2.wwLICq] = var24;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = var28;
               ++var2.wwLICq;
            }
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void KzHh(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 1947412602);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -1478048721, -677941903);
         var165 = var162 ^ var164;
      }

      int var45;
      int var46;
      Object var47;
      switch (var165) {
         case -345133614:
            int var120 = var1.iBb();
            int var121 = var2.aCEjMat;
            int var128 = var1.iBb();
            int var129 = var1.aUp()[var6 * 9 + 4];
            int var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            int var132 = var1.iBb();
            int var133 = var1.aUp()[var6 * 9 + 8];
            int var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            int var136 = var1.iBb();
            int var137 = var1.aUp()[var6 * 9 + 7];
            int var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            int var125 = var123 + var51;
            int var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               int var140 = var1.iBb();
               int var141 = var1.aUp()[var6 * 9 + 0];
               int var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.tDShno[var127] = var47;
            break;
         case -317151287:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var170;
            if (var46 == 4) {
               var170 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Double)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)((int)var170);
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 38444440:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)var5;
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void fzS(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 382616161);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, 987369305, -1253439638);
         var165 = ~(~var162 ^ var164);
      }

      int var128;
      int var129;
      int var132;
      int var133;
      int var136;
      int var137;
      int var140;
      int var141;
      int var45;
      int var46;
      Object var47;
      int var120;
      int var121;
      int var122;
      int var123;
      int var124;
      int var125;
      int var126;
      int var127;
      switch (var165) {
         case -1420706121:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.tDShno[var127] = var47;
            break;
         case -379105497:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 1) {
               var5 = (int)var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)(-var5);
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 486048505:
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var32 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var33 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125);
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 ^= KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284);
               }
            }

            ++var51;
            String var34 = WKRZ(var1, var2, var3, var127, var6, var4);
            Object var23 = null;
            Object var35 = KNV(var32, var33, var34, true, var23);
            if (var34.charAt(0) != 'J' && var34.charAt(0) != 'D') {
               var2.WPY[var2.wwLICq] = var35;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 1;
               ++var2.wwLICq;
            } else {
               var2.WPY[var2.wwLICq] = var35;
               var2.nXw[var2.wwLICq] = 0;
               var2.pzML[var2.wwLICq] = 2;
               ++var2.wwLICq;
            }
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void yzHLevt(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      NlX var171 = var2;
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 288780250);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -1067163150, -1296946479);
         var165 = var162 ^ -1067163150 ^ var164 ^ -1067163150;
      }

      int var45;
      int var46;
      Object var47;
      switch (var165) {
         case -954499619:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var172;
            if (var46 == 4) {
               var172 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var172 = (Double)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)var172;
            var2.nXw[var2.wwLICq] = 2;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         case 217898185:
            int var120 = var1.iBb();
            int var121 = var2.aCEjMat;
            int var128 = var1.iBb();
            int var129 = var1.aUp()[var6 * 9 + 4];
            int var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            int var132 = var1.iBb();
            int var133 = var1.aUp()[var6 * 9 + 8];
            int var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            int var136 = var1.iBb();
            int var137 = var1.aUp()[var6 * 9 + 7];
            int var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            int var125 = var123 + var51;
            int var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = var127 ^ 1302039106 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125) ^ 1302039106;
            }

            int var140;
            int var141;
            int var126;
            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = var127 ^ 1774937586 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284) ^ 1774937586;
               }
            }

            ++var51;
            String var15 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = var127 ^ 1302039106 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125) ^ 1302039106;
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = var127 ^ 1774937586 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284) ^ 1774937586;
               }
            }

            ++var51;
            String var16 = WKRZ(var1, var2, var3, var127, var6, var4);
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = var127 ^ 1302039106 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125) ^ 1302039106;
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = var127 ^ 1774937586 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284) ^ 1774937586;
               }
            }

            ++var51;
            MethodType var17 = iiGNaf(WKRZ(var1, var2, var3, var127, var6, var4));
            var120 = var1.iBb();
            var121 = var2.aCEjMat;
            var128 = var1.iBb();
            var129 = var1.aUp()[var6 * 9 + 4];
            var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            var132 = var1.iBb();
            var133 = var1.aUp()[var6 * 9 + 8];
            var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            var136 = var1.iBb();
            var137 = var1.aUp()[var6 * 9 + 7];
            var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            var125 = var123 + var51;
            var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = var127 ^ 1302039106 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125) ^ 1302039106;
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               var140 = var1.iBb();
               var141 = var1.aUp()[var6 * 9 + 0];
               var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = var127 ^ 1774937586 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284) ^ 1774937586;
               }
            }

            ++var51;
            Object[] var18 = new Object[var17.parameterCount()];

            for(int var19 = var18.length - 1; var19 >= 0; --var19) {
               var45 = var171.wwLICq - 1;
               var171.wwLICq = var45;
               var46 = var171.nXw[var45];
               var171.nXw[var45] = 0;
               var171.pzML[var45] = 0;
               var47 = var171.WPY[var45];
               var171.WPY[var45] = null;
               if (var46 == 1) {
                  var47 = (int)var171.OKuX[var45];
               } else if (var46 == 2) {
                  var47 = var171.OKuX[var45];
               } else if (var46 == 3) {
                  var47 = Float.intBitsToFloat((int)var171.OKuX[var45]);
               } else if (var46 == 4) {
                  var47 = Double.longBitsToDouble(var171.OKuX[var45]);
               }

               var18[var19] = var47;
            }

            Object var20 = null;
            Object var21 = RhZCIyO(var15, var16, var17, true, var20, var18);
            Class var48 = var17.returnType();
            if (var48 != Void.TYPE) {
               if (var48 != Long.TYPE && var48 != Double.TYPE) {
                  var171.WPY[var171.wwLICq] = var21;
                  var171.nXw[var171.wwLICq] = 0;
                  var171.pzML[var171.wwLICq] = 1;
                  ++var171.wwLICq;
               } else {
                  var171.WPY[var171.wwLICq] = var21;
                  var171.nXw[var171.wwLICq] = 0;
                  var171.pzML[var171.wwLICq] = 2;
                  ++var171.wwLICq;
               }
            }
            break;
         case 611509596:
            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)2;
            var2.nXw[var2.wwLICq] = 1;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void sMbt(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      boolean var51 = false;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 1697503825);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, 3854914, -961962150);
         var165 = var162 ^ 3854914 ^ var164 ^ 3854914;
      }

      int var45;
      int var46;
      Object var47;
      switch (var165) {
         case -1104600887:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            throw (Throwable)var47;
         case -994577818:
            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = Double.doubleToRawLongBits(0.0);
            var2.nXw[var2.wwLICq] = 4;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         case 816036101:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            long var170;
            if (var46 == 2) {
               var170 = var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Long)var47;
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            long var171;
            if (var46 == 2) {
               var171 = var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var171 = (Long)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = var171 + var170;
            var2.nXw[var2.wwLICq] = 2;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void QfSeXhy(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      boolean var51 = false;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, -2007841363);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, 1632169980, 735477926);
         var165 = ~(var162 ^ ~var164);
      }

      long var170;
      long var171;
      int var45;
      int var46;
      Object var47;
      switch (var165) {
         case -887236385:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            var2.OChj = var47;
            var2.flCWlBt = true;
            return;
         case 927034738:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 2) {
               var170 = var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Long)var47;
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 2) {
               var171 = var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var171 = (Long)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = var171 + var170;
            var2.nXw[var2.wwLICq] = 2;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         case 1639855630:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 2) {
               var170 = var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Long)var47;
            }

            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            if (var46 == 2) {
               var171 = var2.OKuX[var45];
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var171 = (Long)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = var171 * var170;
            var2.nXw[var2.wwLICq] = 2;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void Fhnp(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, 209273038);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -115376809, -1342372411);
         var165 = var162 ^ var164;
      }

      int var45;
      int var46;
      Object var47;
      switch (var165) {
         case 869187290:
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            float var170;
            if (var46 == 3) {
               var170 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else {
               var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Float)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)Float.floatToRawIntBits(-var170);
            var2.nXw[var2.wwLICq] = 3;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 1512055355:
            int var120 = var1.iBb();
            int var121 = var2.aCEjMat;
            int var128 = var1.iBb();
            int var129 = var1.aUp()[var6 * 9 + 4];
            int var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            int var132 = var1.iBb();
            int var133 = var1.aUp()[var6 * 9 + 8];
            int var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            int var136 = var1.iBb();
            int var137 = var1.aUp()[var6 * 9 + 7];
            int var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            int var125 = var123 + var51;
            int var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               int var140 = var1.iBb();
               int var141 = var1.aUp()[var6 * 9 + 0];
               int var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(var127 ^ ~KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            var47 = var2.WPY[var45];
            var2.WPY[var45] = null;
            if (var46 == 1) {
               var47 = (int)var2.OKuX[var45];
            } else if (var46 == 2) {
               var47 = var2.OKuX[var45];
            } else if (var46 == 3) {
               var47 = Float.intBitsToFloat((int)var2.OKuX[var45]);
            } else if (var46 == 4) {
               var47 = Double.longBitsToDouble(var2.OKuX[var45]);
            }

            if (var47 == null) {
               var2.XGrBNgx = var127;
            }
            break;
         case 1693071933:
            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = 0L;
            var2.nXw[var2.wwLICq] = 2;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   static void YdV(int[] var0, hCsDGBM var1, NlX var2, Object[] var3, int var4, int var5, int var6, int var7, long var8, int var10, int var11, int var12) {
      int var51 = 0;
      int var160 = var1.iBb();
      int var166 = var1.iBb();
      int var167 = var1.aUp()[var6 * 9 + 4];
      int var161 = var167;
      if (var166 != 0) {
         var161 = var167 ^ -1243678802 ^ KWAgx(var166 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
      }

      int var168 = var1.iBb();
      int var169 = var1.aUp()[var6 * 9 + 3];
      int var162 = var169;
      if (var168 != 0) {
         var162 = ~(~var169 ^ KWAgx(var168 ^ var2.aCEjMat, var6, 3, -1243678806));
      }

      int var165 = var162;
      if ((var1.ZVDK() & 16) != 0) {
         int var163 = KWAgx(var160 ^ var2.aCEjMat, var161, var6, -982868150);
         int var164 = KWAgx(var163 ^ var4, var2.aCEjMat, -593017702, 1726929473);
         var165 = var162 ^ -593017702 ^ var164 ^ -593017702;
      }

      switch (var165) {
         case -1244479398:
            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = (long)Float.floatToRawIntBits(2.0F);
            var2.nXw[var2.wwLICq] = 3;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 144850793:
            int var120 = var1.iBb();
            int var121 = var2.aCEjMat;
            int var128 = var1.iBb();
            int var129 = var1.aUp()[var6 * 9 + 4];
            int var122 = var129;
            if (var128 != 0) {
               var122 = var129 ^ -1243678802 ^ KWAgx(var128 ^ var2.aCEjMat, var6, 4, -1243678806) ^ -1243678802;
            }

            int var132 = var1.iBb();
            int var133 = var1.aUp()[var6 * 9 + 8];
            int var123 = var133;
            if (var132 != 0) {
               var123 = var133 ^ -1243678814 ^ KWAgx(var132 ^ var2.aCEjMat, var6, 8, -1243678806) ^ -1243678814;
            }

            int var136 = var1.iBb();
            int var137 = var1.aUp()[var6 * 9 + 7];
            int var124 = var137;
            if (var136 != 0) {
               var124 = ~(~var137 ^ KWAgx(var136 ^ var2.aCEjMat, var6, 7, -1243678806));
            }

            if (var51 >= var124) {
               throw new IllegalStateException("Operand out of range " + var51);
            }

            int var125 = var123 + var51;
            int var127 = var1.YDYJrg()[var125];
            if (var120 != 0 && (var1.ZVDK() & 2) != 0) {
               var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1387345964 ^ var125));
            }

            if (var120 != 0 && (var1.ZVDK() & 4) != 0) {
               int var140 = var1.iBb();
               int var141 = var1.aUp()[var6 * 9 + 0];
               int var126 = var141;
               if (var140 != 0) {
                  var126 = var141 ^ -1243678806 ^ KWAgx(var140 ^ var2.aCEjMat, var6, 0, -1243678806) ^ -1243678806;
               }

               if ((var126 & 1 << var51) != 0) {
                  var127 = ~(~var127 ^ KWAgx(var120 ^ var121 ^ var4, var122, var51, -1994512284));
               }
            }

            ++var51;
            var2.WPY[var2.wwLICq] = var2.tDShno[var127];
            var2.nXw[var2.wwLICq] = 0;
            var2.pzML[var2.wwLICq] = 1;
            ++var2.wwLICq;
            break;
         case 1506107147:
            int var45 = var2.wwLICq - 1;
            var2.wwLICq = var45;
            int var46 = var2.nXw[var45];
            var2.nXw[var45] = 0;
            var2.pzML[var45] = 0;
            double var170;
            if (var46 == 4) {
               var170 = Double.longBitsToDouble(var2.OKuX[var45]);
            } else {
               Object var47 = var2.WPY[var45];
               var2.WPY[var45] = null;
               var170 = (Double)var47;
            }

            var2.WPY[var2.wwLICq] = null;
            var2.OKuX[var2.wwLICq] = Double.doubleToRawLongBits(-var170);
            var2.nXw[var2.wwLICq] = 4;
            var2.pzML[var2.wwLICq] = 2;
            ++var2.wwLICq;
            break;
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var2.XGrBNgx - 1));
      }

   }

   private static int anuy(hCsDGBM var0, NlX var1, int[] var2, Object[] var3, int var4, int var5) {
      int var6 = var4;
      if ((var0.ZVDK() & 8) != 0) {
         var6 = xqZF(var4);
      }

      var6 = KWAgx(-1551612662, var6, 1, -1853528220);
      switch (var6) {
         case -1978074588:
            ysvpGv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1946120722:
            coaDaxD(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1895667694:
            YdV(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1771889743:
            xkIQdDz(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1769389964:
            sMbt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1751525587:
            sIJC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1577146873:
            KzHh(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1517911436:
            coaDaxD(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1514078607:
            HbfI(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1284704709:
            fqLZhKT(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1252505770:
            QfSeXhy(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1000243656:
            zlVu(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -940281270:
            yzHLevt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -917710249:
            HKICp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -752604821:
            fzS(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -698842999:
            sIJC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -631595950:
            QfSeXhy(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -501437469:
            KzHh(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -391861391:
            xMU(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -244609168:
            FfVGX(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -195863121:
            DOuP(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -142634723:
            dJejC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -2005866:
            HKICp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 31492017:
            fzS(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 125912121:
            XumzIiw(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 145996188:
            DOuP(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 164949167:
            YdV(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 294864161:
            FfVGX(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 379319165:
            HbfI(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 582405237:
            XumzIiw(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 665079166:
            ysvpGv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 818512222:
            yzHLevt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 964900573:
            Fhnp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1172842129:
            wzTg(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1270083862:
            fqLZhKT(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1342892318:
            wzTg(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1391206892:
            xkIQdDz(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1400812511:
            xdv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1515189964:
            sMbt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1692974667:
            zlVu(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1758737860:
            xMU(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1769488024:
            Fhnp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1824841633:
            xdv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1980048494:
            dJejC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         default:
            return 0;
      }
   }

   private static int HEbbCR(hCsDGBM var0, NlX var1, int[] var2, Object[] var3, int var4, int var5) {
      int var6 = var4;
      if ((var0.ZVDK() & 8) != 0) {
         var6 = xqZF(var4);
      }

      var6 = KWAgx(-1551612663, var6, 2, -1853528220);
      switch (var6) {
         case -1952010457:
            dJejC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1737075271:
            coaDaxD(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1733887103:
            HKICp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1411772625:
            DOuP(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1185210468:
            FfVGX(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1091040463:
            fqLZhKT(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1080511908:
            QfSeXhy(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -921055159:
            sIJC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -893651248:
            ysvpGv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -743911278:
            FfVGX(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -326253097:
            zlVu(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -325111605:
            sMbt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -287723540:
            xkIQdDz(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -8408842:
            ysvpGv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 42803561:
            HbfI(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 70422593:
            xdv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 94033707:
            HbfI(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 174438481:
            HKICp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 380854313:
            sIJC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 394659165:
            fzS(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 540938821:
            KzHh(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 583580604:
            XumzIiw(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 597136701:
            YdV(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 634503089:
            Fhnp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 736420011:
            DOuP(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 740556458:
            Fhnp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 750523563:
            fqLZhKT(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 942680264:
            xkIQdDz(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 983258234:
            xMU(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1093597891:
            zlVu(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1135728145:
            wzTg(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1283116614:
            wzTg(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1546501787:
            QfSeXhy(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1566414083:
            XumzIiw(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1600219721:
            yzHLevt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1622236566:
            KzHh(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1622962607:
            xMU(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1652382335:
            yzHLevt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1698064229:
            coaDaxD(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1790927734:
            YdV(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1952129650:
            sMbt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 2019912474:
            fzS(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 2031106973:
            xdv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 2134668852:
            dJejC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         default:
            return 0;
      }
   }

   private static int ndgju(hCsDGBM var0, NlX var1, int[] var2, Object[] var3, int var4, int var5) {
      int var6 = var4;
      if ((var0.ZVDK() & 8) != 0) {
         var6 = xqZF(var4);
      }

      var6 = KWAgx(-1551612664, var6, 3, -1853528220);
      switch (var6) {
         case -2114122771:
            Fhnp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1854398547:
            DOuP(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1773092442:
            yzHLevt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1768324331:
            FfVGX(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1758980089:
            KzHh(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1677439348:
            dJejC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1428918336:
            zlVu(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1336380933:
            FfVGX(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -1227005488:
            QfSeXhy(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -999612951:
            ysvpGv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -715506109:
            YdV(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -695916766:
            xkIQdDz(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -617595462:
            yzHLevt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -477444933:
            HbfI(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -376240941:
            zlVu(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -343720344:
            HKICp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -322506131:
            fqLZhKT(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -304773096:
            xdv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -295933191:
            sMbt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -247282889:
            fzS(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -136013832:
            XumzIiw(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -115254736:
            xdv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -114576785:
            fqLZhKT(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case -12174967:
            coaDaxD(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 84509324:
            YdV(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 136853465:
            HKICp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 168641141:
            QfSeXhy(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 220469069:
            Fhnp(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 238054225:
            xMU(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 279349467:
            dJejC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 312451372:
            XumzIiw(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 325271711:
            wzTg(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 401641829:
            KzHh(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 451655840:
            sMbt(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 567238641:
            xMU(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 686816750:
            DOuP(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 793184695:
            sIJC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 841908251:
            coaDaxD(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 858853682:
            xkIQdDz(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1026527683:
            fzS(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1634735611:
            wzTg(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1812457087:
            ysvpGv(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1855525688:
            HbfI(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         case 1952366577:
            sIJC(var2, var0, var1, var3, var4, 0, var5, -1427972111, 8887737057906191620L, -1427972109, -1427972110, -1427972107);
            return 1;
         default:
            return 0;
      }
   }

   static {
      Object[] var0 = new Object[]{uEeKh.dRXwMX};
      kCfG = Arrays.asList(var0);
      zygGK = (Map)(new ConcurrentHashMap());
      eMy = (Map)(new ConcurrentHashMap());
      CgMJuY = (Map)(new ConcurrentHashMap());
      nmt = Collections.synchronizedMap((Map)(new WeakHashMap()));
   }

   public static Object execute(int var0, Object var1, Object... var2) {
      return execute(var0, var1, var2, 515839183);
   }

   public static Object execute(int var0, Object var1, Object[] var2, int var3) {
      hCsDGBM var4 = LHRNfEJ(var0);
      NlX var5 = new NlX(var4.hJKjKL(), var4.LfsAs());
      var5.YnOLXV = var3 ^ 515839183;
      byte var6;
      if (var1 != null) {
         var5.tDShno[0] = var1;
         var6 = 1;
      } else {
         var6 = 0;
      }

      System.arraycopy(var2, 0, var5.tDShno, var6, var2.length);
      BDHEf(var4, var5, var5.XGrBNgx);
      Qec(var4, var5);
      if (!var5.flCWlBt) {
         throw new IllegalStateException("Unknown VM pc " + var5.XGrBNgx);
      } else {
         return var5.OChj;
      }
   }

   public static Object execute(int[] var0, Object var1, Object... var2) {
      return execute(var0, var1, var2, 515839183);
   }

   public static Object execute(int[] var0, Object var1, Object[] var2, int var3) {
      hCsDGBM var4 = LHRNfEJ(var0[0]);
      NlX var6 = new NlX(var4.hJKjKL(), var4.LfsAs());
      var6.YnOLXV = var3 ^ 515839183;
      byte var7;
      if (var1 != null) {
         var6.tDShno[0] = var1;
         var7 = 1;
      } else {
         var7 = 0;
      }

      System.arraycopy(var2, 0, var6.tDShno, var7, var2.length);
      BDHEf(var4, var6, var6.XGrBNgx);

      while(!var6.flCWlBt) {
         hCsDGBM var9 = null;

         for(int var8 = 0; var8 < var0.length; ++var8) {
            hCsDGBM var5 = LHRNfEJ(var0[var8]);
            if (rUkOOS(var5, var6, var6.XGrBNgx) != -1) {
               var9 = var5;
               break;
            }
         }

         if (var9 == null) {
            throw new IllegalStateException("Unknown VM pc " + var6.XGrBNgx);
         }

         Qec(var9, var6);
      }

      return var6.OChj;
   }

   private static int UQh(hCsDGBM var0, NlX var1, int[] var2, Object[] var3, int var4, int var5, long var6, int var8, int var9, int var10) {
      int[] var41 = var0.XBG();
      int var60 = 0;

      while(!var1.flCWlBt) {
         int var42 = var1.XGrBNgx;
         int var49 = -1;
         byte var108 = 0;

         label81: {
            try {
               var49 = rUkOOS(var0, var1, var42);
               if (var49 == -1) {
                  return 1;
               }

               boolean var51 = false;
               int var90 = var0.iBb();
               int var91 = var0.aUp()[var49 * 9 + 2];
               int var84 = var91;
               if (var90 != 0) {
                  var84 = ~(var91 ^ ~KWAgx(var90 ^ var1.aCEjMat, var49, 2, -1243678806));
               }

               var1.XGrBNgx = var84;
               int var100 = var0.iBb();
               int var101 = var1.aCEjMat;
               int var105 = var0.iBb();
               int var106 = var0.aUp()[var49 * 9 + 4];
               int var102 = var106;
               if (var105 != 0) {
                  var102 = var106 ^ -1243678802 ^ KWAgx(var105 ^ var1.aCEjMat, var49, 4, -1243678806) ^ -1243678802;
               }

               int var103 = var0.sLiUi()[var49];
               if (var100 != 0 && (var0.ZVDK() & 1) != 0) {
                  var103 ^= KWAgx(var100 ^ var101, var102, var49, 2061990523);
               }

               int var104 = var0.gTHWdv()[var103];
               if (var100 != 0 && (var0.ZVDK() & 1) != 0) {
                  var104 = ~(~var104 ^ KWAgx(var100, var103, 1393627469, 0));
               }

               var4 = var104;
               int var94 = var0.iBb();
               int var95 = var0.aUp()[var49 * 9 + 6];
               if (var94 != 0) {
                  int var50 = ~(var95 ^ ~KWAgx(var94 ^ var1.aCEjMat, var49, 6, -1243678806));
               }

               int var53 = Math.floorMod(KWAgx(var1.aCEjMat, var49, var0.iBb(), -1551612661), 3);
               int var54;
               switch (var53) {
                  case 0:
                     var54 = anuy(var0, var1, var2, var3, var104, var49);
                     break;
                  case 1:
                     var54 = HEbbCR(var0, var1, var2, var3, var104, var49);
                     break;
                  case 2:
                     var54 = ndgju(var0, var1, var2, var3, var104, var49);
                     break;
                  default:
                     var54 = 0;
               }

               if (var54 != 0) {
                  if (!var1.flCWlBt) {
                     BDHEf(var0, var1, var1.XGrBNgx);
                  }
                  break label81;
               }
            } catch (Throwable var107) {
               int var44 = GZgJXi(var107, var41, var42, var49, var108, var0, var1, var3);
               if (var44 == -1) {
                  throw ghLEous(var107);
               }

               var1.wwLICq = 0;
               var1.wNcq(var107);
               var1.XGrBNgx = var44;
               BDHEf(var0, var1, var44);
               break label81;
            }

            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.XGrBNgx - 1));
         }

         if (var1.flCWlBt) {
            return 1;
         }

         ++var60;
         if (var60 >= 8) {
            return 0;
         }
      }

      return 1;
   }

   private static void Qec(hCsDGBM var0, NlX var1) {
      int[] var2 = var0.sLiUi();
      Object[] var3 = var0.GFoy();

      for(int var4 = 0; var4 == 0; var4 = UQh(var0, var1, var2, var3, 0, -1427972111, 4481809824080794092L, -1427972109, -1427972108, -1427972107)) {
      }

   }

   private static int rUkOOS(hCsDGBM var0, NlX var1, int var2) {
      int var4 = var1.fuvXvU;
      int var3 = mNEeH(var0, var4, var2);
      if (var3 != -1) {
         return var3;
      } else {
         int var5 = var0.UsRIS().length / 4;

         for(var4 = 0; var4 < var5; ++var4) {
            var3 = mNEeH(var0, var4, var2);
            if (var3 != -1) {
               var1.fuvXvU = var4;
               var1.aCEjMat = fcLQa(var0, var3);
               return var3;
            }
         }

         return -1;
      }
   }

   private static int KWAgx(int var0, int var1, int var2, int var3) {
      int var4 = var0 ^ 2118270707;
      var4 ^= var1 + 1975090922 + (var4 << 6) + (var4 >>> 2);
      var4 ^= var2 + 252916191 + (var4 << 6) + (var4 >>> 2);
      var4 ^= var3 + 1086117604 + (var4 << 6) + (var4 >>> 2);
      var4 ^= var4 >>> 16;
      var4 *= 1807575279;
      var4 ^= var4 >>> 15;
      var4 *= -2130885365;
      var4 ^= var4 >>> 16;
      return var4;
   }

   private static int jvyolK(hCsDGBM var0, int var1, int var2, int var3) {
      int var4 = var0.iBb();
      if (var2 == 1) {
         return fcLQa(var0, var1);
      } else {
         int var5 = var0.aUp()[var1 * 9 + var2];
         return var4 == 0 ? var5 : var5 ^ KWAgx(var4 ^ var3, var1, var2, -1243678806);
      }
   }

   private static int yeVATEL(hCsDGBM var0, int var1, int var2) {
      int var3 = var0.iBb();
      int var4 = var0.UsRIS()[var1 * 4 + var2];
      return var3 == 0 ? var4 : var4 ^ KWAgx(var3, var1, var2, 858422341);
   }

   private static int fcLQa(hCsDGBM var0, int var1) {
      int var2 = var0.iBb();
      int var3 = var0.aUp()[var1 * 9 + 1];
      if (var2 == 0) {
         return var3;
      } else {
         int var4 = var0.UsRIS().length / 4;

         for(int var5 = 0; var5 < var4; ++var5) {
            int var6 = yeVATEL(var0, var5, 2);
            int var7 = yeVATEL(var0, var5, 3);
            if (var1 >= var6 && var1 < var6 + var7) {
               int var9 = 0;

               for(int var8 = var6; var8 <= var1; ++var8) {
                  var3 = var0.aUp()[var8 * 9 + 1];
                  if (var8 == var6) {
                     var9 = var3 ^ KWAgx(var2, var8, 949396492, 0);
                  } else {
                     var9 = var3 ^ KWAgx(var2 ^ var9, var8, var5, 949396492);
                  }
               }

               return var9;
            }
         }

         return 0;
      }
   }

   private static int mNEeH(hCsDGBM var0, int var1, int var2) {
      int var3 = var0.UsRIS().length / 4;
      if (var1 >= 0 && var1 < var3) {
         int var4 = yeVATEL(var0, var1, 2);
         int var5 = yeVATEL(var0, var1, 3);
         int var9 = var0.iBb();
         int var8 = 0;

         for(int var6 = 0; var6 < var5; ++var6) {
            int var7 = var4 + var6;
            int var10 = var0.aUp()[var7 * 9 + 1];
            if (var9 == 0) {
               var8 = var10;
            } else if (var6 == 0) {
               var8 = var10 ^ KWAgx(var9, var7, 949396492, 0);
            } else {
               var8 = var10 ^ KWAgx(var9 ^ var8, var7, var1, 949396492);
            }

            if (jvyolK(var0, var7, 4, var8) == var2) {
               return var7;
            }

            if (jvyolK(var0, var7, 6, var8) == var2) {
               return var7;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private static void BDHEf(hCsDGBM var0, NlX var1, int var2) {
      int var3 = rUkOOS(var0, var1, var2);
      if (var3 == -1) {
         var1.aCEjMat = 0;
         var1.fuvXvU = -1;
      } else {
         int var4 = fcLQa(var0, var3);
         var4 ^= var1.YnOLXV;
         int var5 = jvyolK(var0, var3, 5, var4);
         var1.aCEjMat = var4;
         var1.fuvXvU = var5;
      }
   }

   private static int xqZF(int var0) {
      return KWAgx(-1853528220, var0, 2061990523, 0);
   }

   private static hCsDGBM LHRNfEJ(int var0) {
      var0 ^= Teh.IIciQL();
      hCsDGBM var1 = null;
      Iterator var2 = kCfG.iterator();

      while(var2.hasNext()) {
         hCsDGBM var3 = ((SXH)var2.next()).xnDoyay(var0);
         if (var3 != null) {
            if (var1 != null) {
               throw new IllegalStateException("Duplicate code id: " + var0);
            }

            var1 = var3;
         }
      }

      if (var1 == null) {
         throw new IllegalArgumentException("Unknown code id: " + var0);
      } else {
         return var1;
      }
   }

   private static String WKRZ(hCsDGBM var0, NlX var1, Object[] var2, int var3, int var4, int var5) {
      return (String)WLwi(var0, var2[var3], var1, var4, var5);
   }

   private static MethodType iiGNaf(String var0) {
      MethodType var1 = (MethodType)CgMJuY.get(var0);
      if (var1 != null) {
         return var1;
      } else {
         var1 = MethodType.fromMethodDescriptorString(var0, MAvvyFT.class.getClassLoader());
         CgMJuY.put(var0, var1);
         return var1;
      }
   }

   private static Object WLwi(hCsDGBM var0, Object var1, NlX var2, int var3, int var4) {
      String var22;
      if (var1 instanceof String[]) {
         String[] var26 = (String[])var1;
         if (var26.length != 1) {
            throw new IllegalStateException("Invalid VM type constant");
         }

         var22 = var26[0];
      } else {
         if (!(var1 instanceof int[][])) {
            return var1;
         }

         int[][] var5 = (int[][])var1;
         if (var5.length == 0) {
            throw new IllegalStateException("Invalid dynamic constant");
         }

         int var6 = var0.iBb();
         int var7 = var2.aCEjMat;
         int var8 = jvyolK(var0, var3, 4, var7);
         int var9 = var2.fuvXvU;
         int var10 = KWAgx(var6 ^ var7, var8, var9, -1994512284);
         int var12 = KWAgx(var10, var3, var4, -412483218);
         int var11 = KWAgx(var7 ^ -874125251, var6, var4, var8);
         int var13 = KWAgx(var11, var9, var3, 1393627469);
         int[] var15 = null;

         int var14;
         int var17;
         int var18;
         for(var14 = 0; var14 < var5.length; ++var14) {
            if (var15 == null) {
               int[] var16 = var5[var14];
               if (var16.length >= 5) {
                  var17 = var16[0];
                  var18 = var16[1];
                  if (var16[2] == KWAgx(var12 ^ var17, var13, var18, -1551612661) && var16[3] == KWAgx(var13 ^ var18, var12, var17, 858422341)) {
                     var15 = var16;
                  }
               }
            }
         }

         if (var15 == null) {
            throw new IllegalStateException("VM constant requested outside its execution state");
         }

         var17 = var15[0];
         var18 = var15[1];
         int[] var19 = new int[var15.length - 4];

         for(var14 = 0; var14 < var19.length; ++var14) {
            int var25 = KWAgx(var12 ^ var17, var13, var14, -1994512284) ^ Integer.rotateLeft(KWAgx(var13 ^ var18, var12, var14, -874125251), var17 + var14 & 31);
            var19[var14] = var15[var14 + 4] ^ var25;
         }

         int var20 = var19[0];
         if (var20 == 2) {
            return var19[1];
         }

         if (var20 == 3) {
            return (long)var19[1] << 32 | Integer.toUnsignedLong(var19[2]);
         }

         if (var20 == 4) {
            return Float.intBitsToFloat(var19[1]);
         }

         if (var20 == 5) {
            return Double.longBitsToDouble((long)var19[1] << 32 | Integer.toUnsignedLong(var19[2]));
         }

         if (var20 != 1 && var20 != 6) {
            throw new IllegalStateException("Unknown dynamic constant type");
         }

         char[] var21 = new char[var19.length - 1];

         for(var14 = 1; var14 < var19.length; ++var14) {
            var21[var14 - 1] = (char)var19[var14];
         }

         var22 = new String(var21);
         if (var20 == 1) {
            return var22;
         }
      }

      ClassLoader var23 = MAvvyFT.class.getClassLoader();
      if (var2.tDShno.length > 0) {
         Object var24 = var2.tDShno[0];
         if (var24 != null) {
            var23 = var24.getClass().getClassLoader();
         }
      }

      if (var22.length() == 0) {
         throw new IllegalStateException("Invalid encoded VM type constant");
      } else {
         return var22.charAt(0) == '(' ? MethodType.fromMethodDescriptorString(var22, var23) : CuPenoR(var22, var23);
      }
   }

   private static int GZgJXi(Throwable var0, int[] var1, int var2, int var3, int var4, hCsDGBM var5, NlX var6, Object[] var7) {
      int var8 = var5.iBb();

      for(int var9 = 0; var9 < var1.length; var9 += 4) {
         int var10 = var9 / 4;
         int var11 = var1[var9];
         int var12 = var1[var9 + 1];
         int var13 = var1[var9 + 2];
         int var14 = var1[var9 + 3];
         if (var8 != 0) {
            var11 ^= KWAgx(var8, var10, 0, -1551612661);
            var12 ^= KWAgx(var8, var10, 1, -1551612661);
            var13 ^= KWAgx(var8, var10, 2, -1551612661);
            var14 ^= KWAgx(var8, var10, 3, -1551612661);
         }

         if (var2 >= var11 && var2 < var12) {
            if (var14 < 0) {
               return var13;
            }

            if (arOED(WKRZ(var5, var6, var7, var14, var3, var4)).isInstance(var0)) {
               return var13;
            }
         }
      }

      return -1;
   }

   private static Object KNV(String var0, String var1, String var2, boolean var3, Object var4) {
      try {
         return UsNnNLx(var0, var1, var2, var3, false).invokeExact(var4);
      } catch (Throwable var6) {
         throw ghLEous(var6);
      }
   }

   private static void SVesFw(String var0, String var1, String var2, boolean var3, Object var4, Object var5) {
      try {
         var5 = TjCB(var5, arOED(var2));
         if (var3) {
            Class var6 = arOED(var0);
            Field var7 = LLm(var6, var1);
            if (Modifier.isFinal(var7.getModifiers())) {
               var7.setAccessible(true);
               pnrWo(var7, var5);
               return;
            }
         }

         UsNnNLx(var0, var1, var2, var3, true).invokeExact(var4, var5);
      } catch (Throwable var9) {
         throw ghLEous(var9);
      }
   }

   private static MethodHandle UsNnNLx(String var0, String var1, String var2, boolean var3, boolean var4) {
      String var5 = var0 + "." + var1 + ":" + var2 + ":" + var3 + ":" + var4;
      MethodHandle var6 = (MethodHandle)zygGK.get(var5);
      if (var6 != null) {
         return var6;
      } else {
         try {
            Class var7 = arOED(var0);
            Class var8 = arOED(var2);
            Field var9 = LLm(var7, var1);
            var9.setAccessible(true);
            if (var9.getType() != var8) {
               throw new NoSuchFieldException(var7.getName() + "." + var1);
            } else if (Modifier.isStatic(var9.getModifiers()) != var3) {
               throw new NoSuchFieldException(var7.getName() + "." + var1);
            } else {
               MethodHandle var10 = ElEyNx(var9, var3, var4);
               zygGK.put(var5, var10);
               return var10;
            }
         } catch (ReflectiveOperationException var12) {
            throw new IllegalStateException((Throwable)var12);
         }
      }
   }

   private static MethodHandle ElEyNx(Field var0, boolean var1, boolean var2) throws IllegalAccessException {
      MethodHandle var3;
      if (!var2) {
         var3 = MethodHandles.lookup().unreflectGetter(var0);
         if (var1) {
            Class[] var4 = new Class[]{Object.class};
            var3 = MethodHandles.dropArguments(var3, 0, var4);
         }

         return var3.asType(MethodType.methodType(Object.class, Object.class));
      } else {
         var3 = MethodHandles.lookup().unreflectSetter(var0);
         if (var1) {
            Class[] var6 = new Class[]{Object.class};
            var3 = MethodHandles.dropArguments(var3, 0, var6);
         }

         Class[] var8 = new Class[]{Object.class};
         return var3.asType(MethodType.methodType(Void.TYPE, Object.class, var8));
      }
   }

   private static Unsafe GRlcAX() {
      try {
         Field var0 = Unsafe.class.getDeclaredField("theUnsafe");
         var0.setAccessible(true);
         return (Unsafe)var0.get((Object)null);
      } catch (ReflectiveOperationException var2) {
         throw new IllegalStateException((Throwable)var2);
      }
   }

   private static void pnrWo(Field var0, Object var1) {
      Unsafe var2 = GRlcAX();
      Object var3 = var2.staticFieldBase(var0);
      long var4 = var2.staticFieldOffset(var0);
      Class var6 = var0.getType();
      if (var6 == Boolean.TYPE) {
         var2.putBoolean(var3, var4, (boolean)(var1 instanceof Boolean ? (Boolean)var1 : (var1 instanceof Character ? (Character)var1 : ((Number)var1).intValue())));
      } else if (var6 == Character.TYPE) {
         var2.putChar(var3, var4, (char)(var1 instanceof Boolean ? (Boolean)var1 : (var1 instanceof Character ? (Character)var1 : ((Number)var1).intValue())));
      } else if (var6 == Byte.TYPE) {
         var2.putByte(var3, var4, (byte)(var1 instanceof Boolean ? (Boolean)var1 : (var1 instanceof Character ? (Character)var1 : ((Number)var1).intValue())));
      } else if (var6 == Short.TYPE) {
         var2.putShort(var3, var4, (short)(var1 instanceof Boolean ? (Boolean)var1 : (var1 instanceof Character ? (Character)var1 : ((Number)var1).intValue())));
      } else if (var6 == Integer.TYPE) {
         var2.putInt(var3, var4, var1 instanceof Boolean ? (Boolean)var1 : (var1 instanceof Character ? (Character)var1 : ((Number)var1).intValue()));
      } else if (var6 == Long.TYPE) {
         var2.putLong(var3, var4, (Long)var1);
      } else if (var6 == Float.TYPE) {
         var2.putFloat(var3, var4, (Float)var1);
      } else if (var6 == Double.TYPE) {
         var2.putDouble(var3, var4, (Double)var1);
      } else {
         var2.putObject(var3, var4, var1);
      }
   }

   private static Field LLm(Class var0, String var1) throws NoSuchFieldException {
      try {
         return var0.getDeclaredField(var1);
      } catch (NoSuchFieldException var10) {
         Class[] var2 = var0.getInterfaces();
         int var3 = 0;

         while(var3 < var2.length) {
            try {
               return LLm(var2[var3], var1);
            } catch (NoSuchFieldException var9) {
               ++var3;
            }
         }

         Class var5 = var0.getSuperclass();
         if (var5 != null) {
            return LLm(var5, var1);
         } else {
            throw new NoSuchFieldException(var1);
         }
      }
   }

   private static Method RASbu(Class var0, String var1, Class[] var2, Class var3) throws NoSuchMethodException {
      Method[] var4 = var0.getDeclaredMethods();

      Method var5;
      int var7;
      for(var7 = 0; var7 < var4.length; ++var7) {
         var5 = var4[var7];
         if (var1.equals(var5.getName()) && var5.getReturnType() == var3 && Arrays.equals((Object[])var5.getParameterTypes(), (Object[])var2)) {
            return var5;
         }
      }

      Class[] var6 = var0.getInterfaces();
      var7 = 0;

      while(var7 < var6.length) {
         try {
            return RASbu(var6[var7], var1, var2, var3);
         } catch (NoSuchMethodException var14) {
            ++var7;
         }
      }

      Class var9 = var0.getSuperclass();
      if (var9 != null) {
         return RASbu(var9, var1, var2, var3);
      } else {
         if (var0.isInterface()) {
            try {
               var5 = Object.class.getMethod(var1, var2);
               if (var5.getReturnType() == var3) {
                  return var5;
               }
            } catch (NoSuchMethodException var13) {
            }
         }

         throw new NoSuchMethodException(var0.getName() + "." + var1);
      }
   }

   private static Object RhZCIyO(String var0, String var1, MethodType var2, boolean var3, Object var4, Object[] var5) {
      if (!var3 && var1.equals("clone") && var2.parameterCount() == 0 && var4.getClass().isArray()) {
         return FOvgm(var4);
      } else if (!var3 && var0.equals("java/lang/invoke/MethodHandle") && (var1.equals("invoke") || var1.equals("invokeExact"))) {
         for(int var12 = 0; var12 < var5.length; ++var12) {
            var5[var12] = TjCB(var5[var12], var2.parameterType(var12));
         }

         try {
            return ((MethodHandle)var4).asType(var2).asSpreader(Object[].class, var2.parameterCount()).asType(MethodType.methodType(Object.class, Object[].class)).invokeExact(var5);
         } catch (Throwable var29) {
            throw ghLEous(var29);
         }
      } else {
         VarHandle.AccessMode var11 = null;
         if (!var3 && var0.equals("java/lang/invoke/VarHandle")) {
            try {
               var11 = AccessMode.valueFromMethodName(var1);
            } catch (IllegalArgumentException var34) {
            }
         }

         MethodHandle var7;
         if (var11 != null) {
            for(int var18 = 0; var18 < var5.length; ++var18) {
               var5[var18] = TjCB(var5[var18], var2.parameterType(var18));
            }

            var7 = ((VarHandle)var4).toMethodHandle(var11).asType(var2).asFixedArity().asSpreader(Object[].class, var2.parameterCount());

            try {
               return var7.asType(MethodType.methodType(Object.class, Object[].class)).invokeExact(var5);
            } catch (Throwable var30) {
               throw ghLEous(var30);
            }
         } else {
            String var6 = var0 + "." + var1 + var2 + ":" + var3;
            var7 = (MethodHandle)eMy.get(var6);
            if (var7 == null) {
               Class var8 = null;
               Throwable var9 = null;

               Method var10;
               try {
                  var8 = arOED(var0);
                  var10 = RASbu(var8, var1, var2.parameterArray(), var2.returnType());
                  var10.setAccessible(true);
                  if (var10.getReturnType() != var2.returnType()) {
                     throw new NoSuchMethodException(var8.getName() + "." + var1 + var2);
                  }

                  if (Modifier.isStatic(var10.getModifiers()) != var3) {
                     throw new NoSuchMethodException(var8.getName() + "." + var1 + var2);
                  }

                  var7 = TszxeNP(var10, var3, var2.parameterCount());
                  eMy.put(var6, var7);
               } catch (Throwable var33) {
                  var9 = var33;
               }

               if (var7 == null && var9 instanceof NoSuchMethodException) {
                  try {
                     var10 = var8.getMethod(var1, var2.parameterArray());
                     var10.setAccessible(true);
                     if (var10.getReturnType() != var2.returnType()) {
                        throw new NoSuchMethodException(var8.getName() + "." + var1 + var2);
                     }

                     if (Modifier.isStatic(var10.getModifiers()) != var3) {
                        throw new NoSuchMethodException(var8.getName() + "." + var1 + var2);
                     }

                     var7 = TszxeNP(var10, var3, var2.parameterCount());
                     eMy.put(var6, var7);
                  } catch (ReflectiveOperationException var32) {
                     var9 = (Throwable)var32;
                  }
               }

               if (var7 == null) {
                  if (var9 == null || !var9.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
                     throw new IllegalStateException(var9);
                  }

                  var7 = UUIm(var8, var1, var2, var3);
                  eMy.put(var6, var7);
               }
            }

            for(int var26 = 0; var26 < var5.length; ++var26) {
               var5[var26] = TjCB(var5[var26], var2.parameterType(var26));
            }

            try {
               return var7.invokeExact(var4, var5);
            } catch (Throwable var31) {
               throw ghLEous(var31);
            }
         }
      }
   }

   private static Object WIOys(String var0, MethodType var1, Object[] var2) {
      String var3 = "<init>:" + var0 + var1;
      MethodHandle var4 = (MethodHandle)eMy.get(var3);
      if (var4 == null) {
         try {
            Class var5 = arOED(var0);
            Constructor var6 = var5.getDeclaredConstructor(var1.parameterArray());
            var6.setAccessible(true);
            var4 = FAeCNr(var6, var1.parameterCount());
            eMy.put(var3, var4);
         } catch (Throwable var13) {
            throw ghLEous(var13);
         }
      }

      for(int var9 = 0; var9 < var2.length; ++var9) {
         var2[var9] = TjCB(var2[var9], var1.parameterType(var9));
      }

      try {
         return var4.invokeExact((Object)null, var2);
      } catch (Throwable var12) {
         throw ghLEous(var12);
      }
   }

   private static MethodHandle TszxeNP(Method var0, boolean var1, int var2) throws IllegalAccessException {
      MethodHandle var3 = MethodHandles.lookup().unreflect(var0).asFixedArity().asSpreader(Object[].class, var2);
      if (var1) {
         Class[] var4 = new Class[]{Object.class};
         var3 = MethodHandles.dropArguments(var3, 0, var4);
      }

      Class[] var6 = new Class[]{Object[].class};
      return var3.asType(MethodType.methodType(Object.class, Object.class, var6));
   }

   private static MethodHandle UUIm(Class var0, String var1, MethodType var2, boolean var3) throws IllegalAccessException, NoSuchMethodException {
      MethodHandles.Lookup var4 = MethodHandles.privateLookupIn(var0, MethodHandles.lookup());
      MethodHandle var5;
      if (var3) {
         var5 = var4.findStatic(var0, var1, var2).asFixedArity().asSpreader(Object[].class, var2.parameterCount());
         Class[] var6 = new Class[]{Object.class};
         var5 = MethodHandles.dropArguments(var5, 0, var6);
         Class[] var8 = new Class[]{Object[].class};
         return var5.asType(MethodType.methodType(Object.class, Object.class, var8));
      } else {
         var5 = var4.findVirtual(var0, var1, var2).asFixedArity().asSpreader(Object[].class, var2.parameterCount());
         Class[] var10 = new Class[]{Object[].class};
         return var5.asType(MethodType.methodType(Object.class, Object.class, var10));
      }
   }

   private static MethodHandle FAeCNr(Constructor var0, int var1) throws IllegalAccessException {
      MethodHandle var2 = MethodHandles.lookup().unreflectConstructor(var0).asFixedArity().asSpreader(Object[].class, var1);
      Class[] var3 = new Class[]{Object.class};
      var2 = MethodHandles.dropArguments(var2, 0, var3);
      Class[] var5 = new Class[]{Object[].class};
      return var2.asType(MethodType.methodType(Object.class, Object.class, var5));
   }

   private static Object TjCB(Object var0, Class var1) {
      if (var1 == Boolean.TYPE) {
         return Boolean.valueOf((boolean)(var0 instanceof Boolean ? (Boolean)var0 : (var0 instanceof Character ? (Character)var0 : ((Number)var0).intValue())));
      } else if (var1 == Character.TYPE) {
         return Character.valueOf((char)(var0 instanceof Boolean ? (Boolean)var0 : (var0 instanceof Character ? (Character)var0 : ((Number)var0).intValue())));
      } else if (var1 == Byte.TYPE) {
         return Byte.valueOf((byte)(var0 instanceof Boolean ? (Boolean)var0 : (var0 instanceof Character ? (Character)var0 : ((Number)var0).intValue())));
      } else if (var1 == Short.TYPE) {
         return Short.valueOf((short)(var0 instanceof Boolean ? (Boolean)var0 : (var0 instanceof Character ? (Character)var0 : ((Number)var0).intValue())));
      } else if (var1 == Integer.TYPE) {
         return var0 instanceof Boolean ? (Boolean)var0 : (var0 instanceof Character ? (Character)var0 : ((Number)var0).intValue());
      } else if (var1 == Long.TYPE) {
         return ((Number)var0).longValue();
      } else if (var1 == Float.TYPE) {
         return ((Number)var0).floatValue();
      } else {
         return var1 == Double.TYPE ? ((Number)var0).doubleValue() : var0;
      }
   }

   private static Object FOvgm(Object var0) {
      int var1 = Array.getLength(var0);
      Object var2 = Array.newInstance(var0.getClass().getComponentType(), var1);
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   private static Class arOED(String var0) {
      return CuPenoR(var0, MAvvyFT.class.getClassLoader());
   }

   private static Class CuPenoR(String var0, ClassLoader var1) {
      if (var0.length() == 1) {
         switch (var0.charAt(0)) {
            case 'B':
               return Byte.TYPE;
            case 'C':
               return Character.TYPE;
            case 'D':
               return Double.TYPE;
            case 'F':
               return Float.TYPE;
            case 'I':
               return Integer.TYPE;
            case 'J':
               return Long.TYPE;
            case 'S':
               return Short.TYPE;
            case 'V':
               return Void.TYPE;
            case 'Z':
               return Boolean.TYPE;
         }
      }

      if (var0.startsWith("L") && var0.endsWith(";")) {
         var0 = var0.substring(1, var0.length() - 1);
      }

      String var2 = var0.replace('/', '.');

      try {
         return Class.forName(var2, false, var1);
      } catch (ClassNotFoundException var7) {
         try {
            return Class.forName(var2, false, MAvvyFT.class.getClassLoader());
         } catch (ClassNotFoundException var6) {
            throw new IllegalStateException((Throwable)var7);
         }
      }
   }

   private static synchronized ReentrantLock WWctkaa(Object var0) {
      if (var0 == null) {
         throw new NullPointerException();
      } else {
         ReentrantLock var1 = (ReentrantLock)nmt.get(var0);
         if (var1 == null) {
            var1 = new ReentrantLock();
            nmt.put(var0, var1);
         }

         return var1;
      }
   }

   private static void pOdy(Object var0) {
      WWctkaa(var0).lock();
   }

   private static void YiENKxC(Object var0) {
      WWctkaa(var0).unlock();
   }

   private static RuntimeException ghLEous(Throwable var0) {
      throw var0;
   }
}
