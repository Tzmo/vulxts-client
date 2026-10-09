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

public final class pCn {
   private static final List gvpXgT;
   private static final Map uCrw;
   private static final Map dIDWlsO;
   private static final Map giha;
   private static final Map ewh;

   private pCn() {
   }

   private static void EIE(CGKwNP var0, LuI var1, int[] var2, Object[] var3, int var4, int var5, int var6) {
      int var51 = 0;
      long var7;
      int var9;
      int var24;
      int var28;
      int var160;
      int var161;
      int var162;
      int var163;
      int var164;
      int var165;
      int var166;
      int var167;
      int var168;
      int var169;
      float var171;
      float var172;
      int var45;
      int var173;
      int var46;
      Object var174;
      Object var47;
      switch (var5) {
         case 0:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -5308668);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1421464851, -726475191);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -912977992:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var173 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var173 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)(var173 + var5);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 56927444:
                  var5 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.iwiYoC[var5] = var47;
                  return;
               case 769372126:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)Array.getLength(var47);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 1:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -557476058);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -285794017, -170281365);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -86652758:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 3) {
                     var171 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var171 = (Float)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 3) {
                     var172 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var172 = (Float)var47;
                  }

                  byte var175;
                  if (!Float.isNaN(var172) && !Float.isNaN(var171)) {
                     if (var172 > var171) {
                        var175 = 1;
                     } else if (var172 == var171) {
                        var175 = 0;
                     } else {
                        var175 = -1;
                     }
                  } else {
                     var175 = -1;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var175;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 19284234:
                  var28 = var1.Fxnj[var1.JNWcTAA - 1];
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.nROo[var1.JNWcTAA] = var47;
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = var28;
                  ++var1.JNWcTAA;
                  var1.nROo[var1.JNWcTAA] = var47;
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = var28;
                  ++var1.JNWcTAA;
                  return;
               case 602502747:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  if (var47 == null) {
                     var1.Xyz = var9;
                  }

                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 2:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -498774584);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1819174470, -916886395);
               var165 = ~(~var162 ^ var164);
            }

            switch (var165) {
               case -845661265:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)0;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -269700354:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var173 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var173 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)(var173 & var5);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 885893216:
                  int var10000 = var1.Fxnj[var1.JNWcTAA - 1];
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     Integer var176 = (int)var1.rxm[var45];
                     return;
                  } else if (var46 == 2) {
                     Long var177 = var1.rxm[var45];
                     return;
                  } else {
                     if (var46 == 3) {
                        Float var178 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        Double var179 = Double.longBitsToDouble(var1.rxm[var45]);
                        return;
                     }

                     return;
                  }
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 3:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 101383101);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1826916248, 756472560);
               var165 = var162 ^ var164;
            }

            switch (var165) {
               case -930620582:
                  var5 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var5;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 182838580:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  throw (Throwable)var47;
               case 1903122132:
                  var28 = var1.Fxnj[var1.JNWcTAA - 1];
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var174 = var47;
                  if (var28 == 2) {
                     var1.nROo[var1.JNWcTAA] = var47;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var47;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                  } else {
                     int var29 = var1.Fxnj[var1.JNWcTAA - 1];
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var1.nROo[var1.JNWcTAA] = var47;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var29;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var174;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var47;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var29;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var174;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                  }

                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 4:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -799583754);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1737736521, -78942021);
               var165 = var162 ^ 1737736521 ^ var164 ^ 1737736521;
            }

            switch (var165) {
               case -1695841253:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  if (var5 > 0) {
                     var1.Xyz = var9;
                  }

                  return;
               case -907668241:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var7 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var7 = (Long)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var24 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var24 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  ((long[])var47)[var24] = var7;
                  return;
               case 1831451864:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var1.Xyz = var9;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 5:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -1876645301);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 2120220074, -1153922298);
               var165 = ~(~var162 ^ var164);
            }

            switch (var165) {
               case -1063837091:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  if (var5 != 0) {
                     var1.Xyz = var9;
                  }

                  return;
               case 1775712775:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = Double.doubleToRawLongBits(1.0);
                  var1.uIc[var1.JNWcTAA] = 4;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               case 2124999679:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.Mdiyh = var47;
                  var1.hZbgVWo = true;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 6:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -424004928);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -1780820661, -844754035);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -1782510485:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  if (var5 == 0) {
                     var1.Xyz = var9;
                  }

                  return;
               case 760310764:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.Mdiyh = var47;
                  var1.hZbgVWo = true;
                  return;
               case 1083009913:
                  var5 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var174 = var3[var5];
                  var174 = Rdnre(var0, var174, var1, var6, var4);
                  if (!(var174 instanceof Long) && !(var174 instanceof Double)) {
                     var1.nROo[var1.JNWcTAA] = var174;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = 1;
                     ++var1.JNWcTAA;
                  } else {
                     var1.nROo[var1.JNWcTAA] = var174;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = 2;
                     ++var1.JNWcTAA;
                  }

                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 7:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 890226531);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -1722398232, 504620590);
               var165 = var162 ^ var164;
            }

            switch (var165) {
               case -1528378862:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var173 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var173 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var24 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var24 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  ((int[])var47)[var24] = var173;
                  return;
               case 1734100237:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 3) {
                     var171 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var171 = (Float)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 3) {
                     var172 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var172 = (Float)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)Float.floatToRawIntBits(var172 % var171);
                  var1.uIc[var1.JNWcTAA] = 3;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 2012632781:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  long var170;
                  if (var46 == 2) {
                     var170 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var170 = (Long)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var7 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var7 = (Long)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = var7 / var170;
                  var1.uIc[var1.JNWcTAA] = 2;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
      }
   }

   private static void xYhwNY(CGKwNP var0, LuI var1, int[] var2, Object[] var3, int var4, int var5, int var6) {
      int var49 = var6;
      int var51 = 0;
      int var9;
      String var15;
      MethodType var17;
      Object[] var18;
      int var19;
      Object var21;
      int var160;
      String var32;
      int var161;
      String var33;
      int var162;
      String var34;
      int var163;
      Object var35;
      int var164;
      int var165;
      int var166;
      int var167;
      int var168;
      int var169;
      long var170;
      int var171;
      int var45;
      float var173;
      int var46;
      Object var47;
      switch (var5) {
         case 0:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 526537462);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 787562932, 880702395);
               var165 = var162 ^ var164;
            }

            switch (var165) {
               case -697664612:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var32 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var33 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var34 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var35 = jUTl(var32, var33, var34, false, var47);
                  if (var34.charAt(0) != 'J' && var34.charAt(0) != 'D') {
                     var1.nROo[var1.JNWcTAA] = var35;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = 1;
                     ++var1.JNWcTAA;
                  } else {
                     var1.nROo[var1.JNWcTAA] = var35;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = 2;
                     ++var1.JNWcTAA;
                  }

                  return;
               case -411438723:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 3) {
                     var173 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var173 = (Float)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)Float.floatToRawIntBits(-var173);
                  var1.uIc[var1.JNWcTAA] = 3;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 809888778:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var15 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var17 = zmc(PBWDZK(var0, var1, var3, var9, var6, var4));
                  NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var18 = new Object[var17.parameterCount()];

                  for(var19 = var18.length - 1; var19 >= 0; --var19) {
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var18[var19] = var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var21 = NBehLta(var15, var17, var18);
                  var1.XXAcoz(var47, var21);
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 1:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -778923374);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 419199287, -91311137);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -1925265286:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)4;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -1019876976:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var170 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var170 = (Long)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = Double.doubleToRawLongBits((double)var170);
                  var1.uIc[var1.JNWcTAA] = 4;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               case 838363104:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 3) {
                     var173 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var173 = (Float)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  float var172;
                  if (var46 == 3) {
                     var172 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var172 = (Float)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)Float.floatToRawIntBits(var172 % var173);
                  var1.uIc[var1.JNWcTAA] = 3;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 2:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -1473006136);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -56367322, -2094033787);
               var165 = ~(~var162 ^ var164);
            }

            switch (var165) {
               case -806548340:
                  var5 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var1.nROo[var1.JNWcTAA] = var1.iwiYoC[var5];
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 428988300:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  int var10;
                  if (var46 == 1) {
                     var10 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var10 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  int var12 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;

                  for(int var13 = 0; var13 < var12; ++var13) {
                     int var11 = NSPBg(var0, var1, var49, var51, var4);
                     ++var51;
                     int var14 = NSPBg(var0, var1, var49, var51, var4);
                     ++var51;
                     if (var10 == var11) {
                        var9 = var14;
                     }
                  }

                  var1.Xyz = var9;
                  return;
               case 1173469411:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  if (var5 != 0) {
                     var1.Xyz = var9;
                  }

                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 3:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -1599867836);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -804935599, -1950362359);
               var165 = var162 ^ -804935599 ^ var164 ^ -804935599;
            }

            switch (var165) {
               case 124087395:
                  int var28 = var1.Fxnj[var1.JNWcTAA - 1];
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  Object var24 = var47;
                  int var29 = var1.Fxnj[var1.JNWcTAA - 1];
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  Object var25 = var47;
                  if (var29 == 2) {
                     var1.nROo[var1.JNWcTAA] = var24;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var47;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var29;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var24;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                  } else {
                     int var30 = var1.Fxnj[var1.JNWcTAA - 1];
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var1.nROo[var1.JNWcTAA] = var24;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var47;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var30;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var25;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var29;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var24;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                  }

                  return;
               case 332928127:
                  int var36 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  Class var37 = qpQMh(PBWDZK(var0, var1, var3, var36, var6, var4));
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = Array.newInstance(var37, var5);
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 573776148:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  if (var5 <= 0) {
                     var1.Xyz = var9;
                  }

                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 4:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -1125155602);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -2090071982, -1745658461);
               var165 = ~(~var162 ^ var164);
            }

            switch (var165) {
               case -1507925157:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = 1L;
                  var1.uIc[var1.JNWcTAA] = 2;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               case -1250924973:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)5;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 1076734173:
                  var5 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.iwiYoC[var5] = var47;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 5:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 533904300);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -1565081374, 885955297);
               var165 = ~(~var162 ^ var164);
            }

            switch (var165) {
               case -1036513848:
                  var5 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var5;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 171010032:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var171 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var171 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)(var171 >> var5);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 2051000722:
                  var5 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var1.nROo[var1.JNWcTAA] = var1.iwiYoC[var5];
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 6:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -895245326);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -1493067202, -507542849);
               var165 = ~(~var162 ^ var164);
            }

            switch (var165) {
               case -1670546274:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var171 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var171 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)(var171 ^ var5);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -1438131034:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var171 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var171 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)(var171 >>> var5);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -178085851:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var15 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  String var16 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var17 = zmc(PBWDZK(var0, var1, var3, var9, var6, var4));
                  NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var18 = new Object[var17.parameterCount()];

                  for(var19 = var18.length - 1; var19 >= 0; --var19) {
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var18[var19] = var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var21 = OJb(var15, var16, var17, false, var47, var18);
                  Class var48 = var17.returnType();
                  if (var48 != Void.TYPE) {
                     if (var48 != Long.TYPE && var48 != Double.TYPE) {
                        var1.nROo[var1.JNWcTAA] = var21;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = 1;
                        ++var1.JNWcTAA;
                     } else {
                        var1.nROo[var1.JNWcTAA] = var21;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = 2;
                        ++var1.JNWcTAA;
                     }

                     return;
                  }

                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 7:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -136794060);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -259402505, -591097479);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -1160713478:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var170 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var170 = (Long)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  long var7;
                  if (var46 == 2) {
                     var7 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var7 = (Long)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = var7 - var170;
                  var1.uIc[var1.JNWcTAA] = 2;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               case 751532845:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var5;
                  var1.uIc[var1.JNWcTAA] = 2;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               case 1527932868:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var32 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var33 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var34 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  Object var23 = null;
                  var35 = jUTl(var32, var33, var34, true, var23);
                  if (var34.charAt(0) != 'J' && var34.charAt(0) != 'D') {
                     var1.nROo[var1.JNWcTAA] = var35;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = 1;
                     ++var1.JNWcTAA;
                  } else {
                     var1.nROo[var1.JNWcTAA] = var35;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = 2;
                     ++var1.JNWcTAA;
                  }

                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
      }
   }

   private static void kSDCxmi(CGKwNP var0, LuI var1, int[] var2, Object[] var3, int var4, int var5, int var6) {
      int var51 = 0;
      int var9;
      int var24;
      Object var25;
      int var28;
      int var29;
      int var30;
      int var160;
      int var161;
      int var162;
      int var163;
      int var164;
      int var165;
      int var166;
      int var167;
      int var168;
      int var169;
      int var45;
      int var46;
      double var174;
      Object var47;
      Object var175;
      switch (var5) {
         case 0:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 1796679856);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1370818160, 1074465277);
               var165 = var162 ^ var164;
            }

            switch (var165) {
               case -1803084183:
                  int var36 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  Class var37 = qpQMh(PBWDZK(var0, var1, var3, var36, var6, var4));
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = Array.newInstance(var37, var5);
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 353217248:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 4) {
                     var174 = Double.longBitsToDouble(var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var174 = (Double)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  double var173;
                  if (var46 == 4) {
                     var173 = Double.longBitsToDouble(var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var173 = (Double)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = Double.doubleToRawLongBits(var173 - var174);
                  var1.uIc[var1.JNWcTAA] = 4;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               case 1049272120:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  throw (Throwable)var47;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 1:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 1829962754);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 16981555, 1175397711);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -1464956800:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)4;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -562797467:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)2;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 1065288122:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  if (var5 == 0) {
                     var1.Xyz = var9;
                  }

                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 2:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 495378030);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 833403499, 916127523);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -1436440252:
                  var28 = var1.Fxnj[var1.JNWcTAA - 1];
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var175 = var47;
                  if (var28 == 2) {
                     var29 = var1.Fxnj[var1.JNWcTAA - 1];
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var1.nROo[var1.JNWcTAA] = var175;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var47;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var29;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var175;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                  } else {
                     var29 = var1.Fxnj[var1.JNWcTAA - 1];
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var25 = var47;
                     var30 = var1.Fxnj[var1.JNWcTAA - 1];
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var1.nROo[var1.JNWcTAA] = var25;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var29;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var175;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var47;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var30;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var25;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var29;
                     ++var1.JNWcTAA;
                     var1.nROo[var1.JNWcTAA] = var175;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = var28;
                     ++var1.JNWcTAA;
                  }

                  return;
               case -314319966:
                  var5 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var175 = var3[var5];
                  var175 = Rdnre(var0, var175, var1, var6, var4);
                  if (!(var175 instanceof Long) && !(var175 instanceof Double)) {
                     var1.nROo[var1.JNWcTAA] = var175;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = 1;
                     ++var1.JNWcTAA;
                  } else {
                     var1.nROo[var1.JNWcTAA] = var175;
                     var1.uIc[var1.JNWcTAA] = 0;
                     var1.Fxnj[var1.JNWcTAA] = 2;
                     ++var1.JNWcTAA;
                  }

                  return;
               case 1551311407:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 4) {
                     var174 = Double.longBitsToDouble(var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var174 = (Double)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)Float.floatToRawIntBits((float)var174);
                  var1.uIc[var1.JNWcTAA] = 3;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 3:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 1802356206);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1666932863, 1081205923);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -1633348806:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  if (var47 == null) {
                     var1.Xyz = var9;
                  }

                  return;
               case -1533015586:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  String var15 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  String var16 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  MethodType var17 = zmc(PBWDZK(var0, var1, var3, var9, var6, var4));
                  NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  Object[] var18 = new Object[var17.parameterCount()];

                  for(int var19 = var18.length - 1; var19 >= 0; --var19) {
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var18[var19] = var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  Object var21 = OJb(var15, var16, var17, false, var47, var18);
                  Class var48 = var17.returnType();
                  if (var48 != Void.TYPE) {
                     if (var48 != Long.TYPE && var48 != Double.TYPE) {
                        var1.nROo[var1.JNWcTAA] = var21;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = 1;
                        ++var1.JNWcTAA;
                     } else {
                        var1.nROo[var1.JNWcTAA] = var21;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = 2;
                        ++var1.JNWcTAA;
                     }

                     return;
                  }

                  return;
               case -375502951:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)Float.floatToRawIntBits((float)var5);
                  var1.uIc[var1.JNWcTAA] = 3;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 4:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -974351434);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1522844324, -286215429);
               var165 = var162 ^ var164;
            }

            switch (var165) {
               case -1944428589:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  if (var5 < 0) {
                     var1.Xyz = var9;
                  }

                  return;
               case -167214570:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)1;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 1982906032:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  float var171;
                  if (var46 == 3) {
                     var171 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var171 = (Float)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var171;
                  var1.uIc[var1.JNWcTAA] = 2;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 5:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 1239917272);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -948974820, 1660650389);
               var165 = var162 ^ var164;
            }

            switch (var165) {
               case 269963330:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)2;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 388021474:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  if (var47 == null) {
                     var1.Xyz = var9;
                  }

                  return;
               case 1201625752:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)(-var5);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 6:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -859214358);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -895996640, -405451609);
               var165 = var162 ^ var164;
            }

            switch (var165) {
               case -2112217728:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)2;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -1360532970:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  Class var22 = qpQMh(PBWDZK(var0, var1, var3, var9, var6, var4));
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.nROo[var1.JNWcTAA] = var22.cast(var47);
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -269850767:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var24 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var24 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  if (var47 instanceof boolean[]) {
                     var1.nROo[var1.JNWcTAA] = null;
                     var1.rxm[var1.JNWcTAA] = (long)((boolean[])var47)[var24];
                     var1.uIc[var1.JNWcTAA] = 1;
                     var1.Fxnj[var1.JNWcTAA] = 1;
                     ++var1.JNWcTAA;
                  } else {
                     var1.nROo[var1.JNWcTAA] = null;
                     var1.rxm[var1.JNWcTAA] = (long)((byte[])var47)[var24];
                     var1.uIc[var1.JNWcTAA] = 1;
                     var1.Fxnj[var1.JNWcTAA] = 1;
                     ++var1.JNWcTAA;
                  }

                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 7:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 1398429039);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1492322937, 2017883170);
               var165 = var162 ^ 1492322937 ^ var164 ^ 1492322937;
            }

            switch (var165) {
               case -1115351968:
                  var28 = var1.Fxnj[var1.JNWcTAA - 1];
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var175 = var47;
                  if (var28 == 2) {
                     var29 = var1.Fxnj[var1.JNWcTAA - 1];
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var25 = var47;
                     if (var29 == 2) {
                        var1.nROo[var1.JNWcTAA] = var175;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var28;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var47;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var29;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var175;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var28;
                        ++var1.JNWcTAA;
                     } else {
                        var30 = var1.Fxnj[var1.JNWcTAA - 1];
                        var45 = var1.JNWcTAA - 1;
                        var1.JNWcTAA = var45;
                        var46 = var1.uIc[var45];
                        var1.uIc[var45] = 0;
                        var1.Fxnj[var45] = 0;
                        var47 = var1.nROo[var45];
                        var1.nROo[var45] = null;
                        if (var46 == 1) {
                           var47 = (int)var1.rxm[var45];
                        } else if (var46 == 2) {
                           var47 = var1.rxm[var45];
                        } else if (var46 == 3) {
                           var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                        } else if (var46 == 4) {
                           var47 = Double.longBitsToDouble(var1.rxm[var45]);
                        }

                        var1.nROo[var1.JNWcTAA] = var175;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var28;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var47;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var30;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var25;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var29;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var175;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var28;
                        ++var1.JNWcTAA;
                     }

                     return;
                  } else {
                     var29 = var1.Fxnj[var1.JNWcTAA - 1];
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var25 = var47;
                     var30 = var1.Fxnj[var1.JNWcTAA - 1];
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     Object var26 = var47;
                     if (var30 == 2) {
                        var1.nROo[var1.JNWcTAA] = var25;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var29;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var175;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var28;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var47;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var30;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var25;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var29;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var175;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var28;
                        ++var1.JNWcTAA;
                     } else {
                        int var31 = var1.Fxnj[var1.JNWcTAA - 1];
                        var45 = var1.JNWcTAA - 1;
                        var1.JNWcTAA = var45;
                        var46 = var1.uIc[var45];
                        var1.uIc[var45] = 0;
                        var1.Fxnj[var45] = 0;
                        var47 = var1.nROo[var45];
                        var1.nROo[var45] = null;
                        if (var46 == 1) {
                           var47 = (int)var1.rxm[var45];
                        } else if (var46 == 2) {
                           var47 = var1.rxm[var45];
                        } else if (var46 == 3) {
                           var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                        } else if (var46 == 4) {
                           var47 = Double.longBitsToDouble(var1.rxm[var45]);
                        }

                        var1.nROo[var1.JNWcTAA] = var25;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var29;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var175;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var28;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var47;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var31;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var26;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var30;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var25;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var29;
                        ++var1.JNWcTAA;
                        var1.nROo[var1.JNWcTAA] = var175;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = var28;
                        ++var1.JNWcTAA;
                     }

                     return;
                  }
               case 972176688:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  Object var172 = var47;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var24 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var24 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  ((Object[])var47)[var24] = var172;
                  return;
               case 1444214762:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  long var170;
                  if (var46 == 2) {
                     var170 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var170 = (Long)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  long var7;
                  if (var46 == 2) {
                     var7 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var7 = (Long)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = var7 % var170;
                  var1.uIc[var1.JNWcTAA] = 2;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
      }
   }

   private static void dDHJnj(CGKwNP var0, LuI var1, int[] var2, Object[] var3, int var4, int var5, int var6) {
      int var51 = 0;
      int var9;
      String var15;
      String var16;
      MethodType var17;
      Object[] var18;
      int var19;
      Object var21;
      int var24;
      int var160;
      int var161;
      int var162;
      int var163;
      int var164;
      int var36;
      int var165;
      Class var37;
      int var166;
      int var167;
      int var168;
      int var169;
      int var171;
      int var45;
      long var173;
      int var46;
      long var174;
      Object var47;
      byte var175;
      Class var48;
      switch (var5) {
         case 0:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 1907198895);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 2125387075, 1521593058);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -1597203289:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  Object[] var22 = new Object[]{var3[var9]};
                  var1.nROo[var1.JNWcTAA] = var22;
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 811099681:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var5;
                  var1.uIc[var1.JNWcTAA] = 2;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               case 1920520372:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var174 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var174 = (Long)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var173 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var173 = (Long)var47;
                  }

                  if (var173 > var174) {
                     var175 = 1;
                  } else if (var173 == var174) {
                     var175 = 0;
                  } else {
                     var175 = -1;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var175;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 1:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 1060355305);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -388214986, 338664868);
               var165 = ~(~var162 ^ var164);
            }

            switch (var165) {
               case 333592049:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)Float.floatToRawIntBits(1.0F);
                  var1.uIc[var1.JNWcTAA] = 3;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 674464606:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var15 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var16 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var17 = zmc(PBWDZK(var0, var1, var3, var9, var6, var4));
                  NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var18 = new Object[var17.parameterCount()];

                  for(var19 = var18.length - 1; var19 >= 0; --var19) {
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var18[var19] = var47;
                  }

                  Object var20 = null;
                  var21 = OJb(var15, var16, var17, true, var20, var18);
                  var48 = var17.returnType();
                  if (var48 != Void.TYPE) {
                     if (var48 != Long.TYPE && var48 != Double.TYPE) {
                        var1.nROo[var1.JNWcTAA] = var21;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = 1;
                        ++var1.JNWcTAA;
                     } else {
                        var1.nROo[var1.JNWcTAA] = var21;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = 2;
                        ++var1.JNWcTAA;
                     }

                     return;
                  }

                  return;
               case 1649800336:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var24 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var24 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)Float.floatToRawIntBits(((float[])var47)[var24]);
                  var1.uIc[var1.JNWcTAA] = 3;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 2:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 148370297);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 111970898, 600560180);
               var165 = ~(~var162 ^ var164);
            }

            switch (var165) {
               case -1722236889:
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)3;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -1682020943:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var5;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -938034261:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var174 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var174 = (Long)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var173 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var173 = (Long)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = var173 & var174;
                  var1.uIc[var1.JNWcTAA] = 2;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 3:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 1552191401);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1891557290, 2006494948);
               var165 = ~(~var162 ^ var164);
            }

            switch (var165) {
               case -1842497099:
                  var36 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  switch (var36) {
                     case 4:
                        var37 = Boolean.TYPE;
                        break;
                     case 5:
                        var37 = Character.TYPE;
                        break;
                     case 6:
                        var37 = Float.TYPE;
                        break;
                     case 7:
                        var37 = Double.TYPE;
                        break;
                     case 8:
                        var37 = Byte.TYPE;
                        break;
                     case 9:
                        var37 = Short.TYPE;
                        break;
                     case 10:
                        var37 = Integer.TYPE;
                        break;
                     case 11:
                        var37 = Long.TYPE;
                        break;
                     default:
                        throw new IllegalArgumentException("Unknown NEWARRAY atype");
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = Array.newInstance(var37, var5);
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 222823575:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var174 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var174 = (Long)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 2) {
                     var173 = var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var173 = (Long)var47;
                  }

                  if (var173 > var174) {
                     var175 = 1;
                  } else if (var173 == var174) {
                     var175 = 0;
                  } else {
                     var175 = -1;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var175;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 1405734352:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var24 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var24 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)((char[])var47)[var24];
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 4:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, -1693922378);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 178059173, -1340806405);
               var165 = var162 ^ 178059173 ^ var164 ^ 178059173;
            }

            switch (var165) {
               case -1614969736:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var15 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var16 = PBWDZK(var0, var1, var3, var9, var6, var4);
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var17 = zmc(PBWDZK(var0, var1, var3, var9, var6, var4));
                  NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var18 = new Object[var17.parameterCount()];

                  for(var19 = var18.length - 1; var19 >= 0; --var19) {
                     var45 = var1.JNWcTAA - 1;
                     var1.JNWcTAA = var45;
                     var46 = var1.uIc[var45];
                     var1.uIc[var45] = 0;
                     var1.Fxnj[var45] = 0;
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     if (var46 == 1) {
                        var47 = (int)var1.rxm[var45];
                     } else if (var46 == 2) {
                        var47 = var1.rxm[var45];
                     } else if (var46 == 3) {
                        var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                     } else if (var46 == 4) {
                        var47 = Double.longBitsToDouble(var1.rxm[var45]);
                     }

                     var18[var19] = var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var21 = OJb(var15, var16, var17, false, var47, var18);
                  var48 = var17.returnType();
                  if (var48 != Void.TYPE) {
                     if (var48 != Long.TYPE && var48 != Double.TYPE) {
                        var1.nROo[var1.JNWcTAA] = var21;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = 1;
                        ++var1.JNWcTAA;
                     } else {
                        var1.nROo[var1.JNWcTAA] = var21;
                        var1.uIc[var1.JNWcTAA] = 0;
                        var1.Fxnj[var1.JNWcTAA] = 2;
                        ++var1.JNWcTAA;
                     }

                     return;
                  }

                  return;
               case 277012785:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var171 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var171 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)(var171 & var5);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 445350383:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  float var172;
                  if (var46 == 3) {
                     var172 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var172 = (Float)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)((int)var172);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 5:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 349430421);
               var164 = IqOZ(var163 ^ var4, var1.uZb, 1726302283, 1070580696);
               var165 = ~(var162 ^ ~var164);
            }

            switch (var165) {
               case -1263666728:
                  var9 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  if (var5 > 0) {
                     var1.Xyz = var9;
                  }

                  return;
               case -864621053:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  var47 = var1.nROo[var45];
                  var1.nROo[var45] = null;
                  if (var46 == 1) {
                     var47 = (int)var1.rxm[var45];
                  } else if (var46 == 2) {
                     var47 = var1.rxm[var45];
                  } else if (var46 == 3) {
                     var47 = Float.intBitsToFloat((int)var1.rxm[var45]);
                  } else if (var46 == 4) {
                     var47 = Double.longBitsToDouble(var1.rxm[var45]);
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)Array.getLength(var47);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case 770734270:
                  var5 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)var5;
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         case 6:
            var160 = var0.ndiOsc();
            var166 = var0.ndiOsc();
            var167 = var0.BnUpXiS()[var6 * 9 + 3];
            var161 = var167;
            if (var166 != 0) {
               var161 = var167 ^ IqOZ(var166 ^ var1.uZb, var6, 3, -888546777);
            }

            var168 = var0.ndiOsc();
            var169 = var0.BnUpXiS()[var6 * 9 + 5];
            var162 = var169;
            if (var168 != 0) {
               var162 = ~(~var169 ^ IqOZ(var168 ^ var1.uZb, var6, 5, -888546777));
            }

            var165 = var162;
            if ((var0.ZNZQ() & 16) != 0) {
               var163 = IqOZ(var160 ^ var1.uZb, var161, var6, 1043418903);
               var164 = IqOZ(var163 ^ var4, var1.uZb, -1476975335, 355298906);
               var165 = var162 ^ -1476975335 ^ var164 ^ -1476975335;
            }

            switch (var165) {
               case -1826896337:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var171 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var171 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = (long)(var171 + var5);
                  var1.uIc[var1.JNWcTAA] = 1;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -1437441445:
                  var36 = NSPBg(var0, var1, var6, var51, var4);
                  ++var51;
                  var37 = qpQMh(PBWDZK(var0, var1, var3, var36, var6, var4));
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  if (var46 == 1) {
                     var5 = (int)var1.rxm[var45];
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var5 = var47 instanceof Boolean ? (Boolean)var47 : (var47 instanceof Character ? (Character)var47 : ((Number)var47).intValue());
                  }

                  var1.nROo[var1.JNWcTAA] = Array.newInstance(var37, var5);
                  var1.uIc[var1.JNWcTAA] = 0;
                  var1.Fxnj[var1.JNWcTAA] = 1;
                  ++var1.JNWcTAA;
                  return;
               case -578926857:
                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  double var170;
                  if (var46 == 4) {
                     var170 = Double.longBitsToDouble(var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var170 = (Double)var47;
                  }

                  var45 = var1.JNWcTAA - 1;
                  var1.JNWcTAA = var45;
                  var46 = var1.uIc[var45];
                  var1.uIc[var45] = 0;
                  var1.Fxnj[var45] = 0;
                  double var7;
                  if (var46 == 4) {
                     var7 = Double.longBitsToDouble(var1.rxm[var45]);
                  } else {
                     var47 = var1.nROo[var45];
                     var1.nROo[var45] = null;
                     var7 = (Double)var47;
                  }

                  var1.nROo[var1.JNWcTAA] = null;
                  var1.rxm[var1.JNWcTAA] = Double.doubleToRawLongBits(var7 / var170);
                  var1.uIc[var1.JNWcTAA] = 4;
                  var1.Fxnj[var1.JNWcTAA] = 2;
                  ++var1.JNWcTAA;
                  return;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }
         default:
            throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
      }
   }

   static {
      Object[] var0 = new Object[]{AiJTr.QYseN};
      gvpXgT = Arrays.asList(var0);
      uCrw = (Map)(new ConcurrentHashMap());
      dIDWlsO = (Map)(new ConcurrentHashMap());
      giha = (Map)(new ConcurrentHashMap());
      ewh = Collections.synchronizedMap((Map)(new WeakHashMap()));
   }

   public static Object execute(int var0, Object var1, Object... var2) {
      return execute(var0, var1, var2, 100294800);
   }

   public static Object execute(int var0, Object var1, Object[] var2, int var3) {
      CGKwNP var4 = mmq(var0);
      LuI var5 = new LuI(var4.qMyMAD(), var4.xQoMJt());
      var5.shPVzSZ = var3 ^ 100294800;
      byte var6;
      if (var1 != null) {
         var5.iwiYoC[0] = var1;
         var6 = 1;
      } else {
         var6 = 0;
      }

      System.arraycopy(var2, 0, var5.iwiYoC, var6, var2.length);
      zYb(var4, var5, var5.Xyz);
      Rgk(var4, var5);
      if (!var5.hZbgVWo) {
         throw new IllegalStateException("Unknown VM pc " + var5.Xyz);
      } else {
         return var5.Mdiyh;
      }
   }

   public static Object execute(int[] var0, Object var1, Object... var2) {
      return execute(var0, var1, var2, 100294800);
   }

   public static Object execute(int[] var0, Object var1, Object[] var2, int var3) {
      CGKwNP var4 = mmq(var0[0]);
      LuI var6 = new LuI(var4.qMyMAD(), var4.xQoMJt());
      var6.shPVzSZ = var3 ^ 100294800;
      byte var7;
      if (var1 != null) {
         var6.iwiYoC[0] = var1;
         var7 = 1;
      } else {
         var7 = 0;
      }

      System.arraycopy(var2, 0, var6.iwiYoC, var7, var2.length);
      zYb(var4, var6, var6.Xyz);

      while(!var6.hZbgVWo) {
         CGKwNP var9 = null;

         for(int var8 = 0; var8 < var0.length; ++var8) {
            CGKwNP var5 = mmq(var0[var8]);
            if (otbof(var5, var6, var6.Xyz) != -1) {
               var9 = var5;
               break;
            }
         }

         if (var9 == null) {
            throw new IllegalStateException("Unknown VM pc " + var6.Xyz);
         }

         Rgk(var9, var6);
      }

      return var6.Mdiyh;
   }

   private static int WMMfiqF(CGKwNP var0, LuI var1, int[] var2, Object[] var3, int var4) {
      int[] var41 = var0.TzUxFoN();
      int var60 = 0;

      while(!var1.hZbgVWo) {
         int var42 = var1.Xyz;
         int var49 = -1;
         byte var86 = 0;

         try {
            var49 = otbof(var0, var1, var42);
            if (var49 == -1) {
               return 1;
            }

            boolean var51 = false;
            var4 = uoNMM(var0, var1, var49);
            int var84 = lmzMzY(var0, var1, var49);
            var1.Xyz = var84;
            kLSFHxn(var0, var1, var49);
            int var52 = var4;
            if ((var0.ZNZQ() & 8) != 0) {
               var52 = UGL(var4);
            }

            switch (var52) {
               case -2051092610:
                  kSDCxmi(var0, var1, var2, var3, var4, 6, var49);
                  break;
               case -2035844657:
                  dDHJnj(var0, var1, var2, var3, var4, 1, var49);
                  break;
               case -1939291250:
                  xYhwNY(var0, var1, var2, var3, var4, 5, var49);
                  break;
               case -1869266029:
                  xYhwNY(var0, var1, var2, var3, var4, 2, var49);
                  break;
               case -1792354138:
                  EIE(var0, var1, var2, var3, var4, 0, var49);
                  break;
               case -1666939861:
                  EIE(var0, var1, var2, var3, var4, 1, var49);
                  break;
               case -1605241898:
                  kSDCxmi(var0, var1, var2, var3, var4, 2, var49);
                  break;
               case -1601400948:
                  xYhwNY(var0, var1, var2, var3, var4, 4, var49);
                  break;
               case -1423936081:
                  EIE(var0, var1, var2, var3, var4, 2, var49);
                  break;
               case -1351003926:
                  kSDCxmi(var0, var1, var2, var3, var4, 7, var49);
                  break;
               case -1325259849:
                  EIE(var0, var1, var2, var3, var4, 3, var49);
                  break;
               case -1323784131:
                  EIE(var0, var1, var2, var3, var4, 2, var49);
                  break;
               case -1241299769:
                  EIE(var0, var1, var2, var3, var4, 6, var49);
                  break;
               case -1223833071:
                  EIE(var0, var1, var2, var3, var4, 4, var49);
                  break;
               case -1183769396:
                  kSDCxmi(var0, var1, var2, var3, var4, 1, var49);
                  break;
               case -1180196096:
                  EIE(var0, var1, var2, var3, var4, 5, var49);
                  break;
               case -1145302435:
                  EIE(var0, var1, var2, var3, var4, 6, var49);
                  break;
               case -1122044860:
                  EIE(var0, var1, var2, var3, var4, 7, var49);
                  break;
               case -1115901071:
                  xYhwNY(var0, var1, var2, var3, var4, 0, var49);
                  break;
               case -1020038176:
                  kSDCxmi(var0, var1, var2, var3, var4, 0, var49);
                  break;
               case -999734743:
                  xYhwNY(var0, var1, var2, var3, var4, 7, var49);
                  break;
               case -951883181:
                  kSDCxmi(var0, var1, var2, var3, var4, 3, var49);
                  break;
               case -767148873:
                  xYhwNY(var0, var1, var2, var3, var4, 1, var49);
                  break;
               case -684591107:
                  dDHJnj(var0, var1, var2, var3, var4, 2, var49);
                  break;
               case -654578552:
                  kSDCxmi(var0, var1, var2, var3, var4, 4, var49);
                  break;
               case -547807148:
                  xYhwNY(var0, var1, var2, var3, var4, 2, var49);
                  break;
               case -540188390:
                  xYhwNY(var0, var1, var2, var3, var4, 1, var49);
                  break;
               case -535472947:
                  EIE(var0, var1, var2, var3, var4, 1, var49);
                  break;
               case -506590419:
                  dDHJnj(var0, var1, var2, var3, var4, 5, var49);
                  break;
               case -465580278:
                  xYhwNY(var0, var1, var2, var3, var4, 3, var49);
                  break;
               case -278602785:
                  EIE(var0, var1, var2, var3, var4, 4, var49);
                  break;
               case -238407110:
                  xYhwNY(var0, var1, var2, var3, var4, 0, var49);
                  break;
               case -65530532:
                  xYhwNY(var0, var1, var2, var3, var4, 4, var49);
                  break;
               case 3193186:
                  xYhwNY(var0, var1, var2, var3, var4, 5, var49);
                  break;
               case 78300169:
                  EIE(var0, var1, var2, var3, var4, 5, var49);
                  break;
               case 149627261:
                  xYhwNY(var0, var1, var2, var3, var4, 6, var49);
                  break;
               case 194919087:
                  dDHJnj(var0, var1, var2, var3, var4, 6, var49);
                  break;
               case 273278221:
                  xYhwNY(var0, var1, var2, var3, var4, 7, var49);
                  break;
               case 368070573:
                  kSDCxmi(var0, var1, var2, var3, var4, 0, var49);
                  break;
               case 647408387:
                  kSDCxmi(var0, var1, var2, var3, var4, 1, var49);
                  break;
               case 652322830:
                  kSDCxmi(var0, var1, var2, var3, var4, 2, var49);
                  break;
               case 720431129:
                  kSDCxmi(var0, var1, var2, var3, var4, 3, var49);
                  break;
               case 807571977:
                  kSDCxmi(var0, var1, var2, var3, var4, 4, var49);
                  break;
               case 847233063:
                  xYhwNY(var0, var1, var2, var3, var4, 3, var49);
                  break;
               case 965931083:
                  kSDCxmi(var0, var1, var2, var3, var4, 5, var49);
                  break;
               case 1128319425:
                  kSDCxmi(var0, var1, var2, var3, var4, 5, var49);
                  break;
               case 1129413492:
                  EIE(var0, var1, var2, var3, var4, 7, var49);
                  break;
               case 1191355117:
                  xYhwNY(var0, var1, var2, var3, var4, 6, var49);
                  break;
               case 1316441931:
                  kSDCxmi(var0, var1, var2, var3, var4, 6, var49);
                  break;
               case 1346799670:
                  kSDCxmi(var0, var1, var2, var3, var4, 7, var49);
                  break;
               case 1350524361:
                  dDHJnj(var0, var1, var2, var3, var4, 0, var49);
                  break;
               case 1391582644:
                  EIE(var0, var1, var2, var3, var4, 3, var49);
                  break;
               case 1544231655:
                  dDHJnj(var0, var1, var2, var3, var4, 1, var49);
                  break;
               case 1555624284:
                  dDHJnj(var0, var1, var2, var3, var4, 0, var49);
                  break;
               case 1586616615:
                  dDHJnj(var0, var1, var2, var3, var4, 2, var49);
                  break;
               case 1673166850:
                  dDHJnj(var0, var1, var2, var3, var4, 3, var49);
                  break;
               case 1683265628:
                  dDHJnj(var0, var1, var2, var3, var4, 4, var49);
                  break;
               case 1695521221:
                  dDHJnj(var0, var1, var2, var3, var4, 5, var49);
                  break;
               case 1705918167:
                  EIE(var0, var1, var2, var3, var4, 0, var49);
                  break;
               case 1850865433:
                  dDHJnj(var0, var1, var2, var3, var4, 6, var49);
                  break;
               case 1883530887:
                  dDHJnj(var0, var1, var2, var3, var4, 4, var49);
                  break;
               case 2003261663:
                  dDHJnj(var0, var1, var2, var3, var4, 3, var49);
                  break;
               default:
                  throw new IllegalStateException("Unknown VM opcode " + Integer.toHexString(var4) + " at pc " + (var1.Xyz - 1));
            }

            if (!var1.hZbgVWo) {
               zYb(var0, var1, var1.Xyz);
            }
         } catch (Throwable var85) {
            int var44 = lZxSxXr(var85, var41, var42, var49, var86, var0, var1, var3);
            if (var44 == -1) {
               throw BMDtS(var85);
            }

            var1.JNWcTAA = 0;
            var1.oxULe(var85);
            var1.Xyz = var44;
            zYb(var0, var1, var44);
         }

         if (var1.hZbgVWo) {
            return 1;
         }

         ++var60;
         if (var60 >= 32) {
            return 0;
         }
      }

      return 1;
   }

   private static void Rgk(CGKwNP var0, LuI var1) {
      int[] var2 = var0.lhJh();
      Object[] var3 = var0.oAcpU();

      for(int var4 = 0; var4 == 0; var4 = WMMfiqF(var0, var1, var2, var3, 0)) {
      }

   }

   private static int otbof(CGKwNP var0, LuI var1, int var2) {
      int var4 = var1.soF;
      int var3 = NbvjVr(var0, var4, var2);
      if (var3 != -1) {
         return var3;
      } else {
         int var5 = var0.DKP().length / 4;

         for(var4 = 0; var4 < var5; ++var4) {
            var3 = NbvjVr(var0, var4, var2);
            if (var3 != -1) {
               var1.soF = var4;
               var1.uZb = nBo(var0, var3);
               return var3;
            }
         }

         return -1;
      }
   }

   private static int uoNMM(CGKwNP var0, LuI var1, int var2) {
      int var3 = var0.ndiOsc();
      int var4 = var1.uZb;
      int var5 = MSdS(var0, var2, 3, var4);
      int var6 = var0.lhJh()[var2];
      if (var3 != 0 && (var0.ZNZQ() & 1) != 0) {
         var6 ^= IqOZ(var3 ^ var4, var5, var2, -2129237019);
      }

      int var7 = var0.vum()[var6];
      if (var3 != 0 && (var0.ZNZQ() & 1) != 0) {
         var7 ^= IqOZ(var3, var6, 625330154, 0);
      }

      return var7;
   }

   private static int lmzMzY(CGKwNP var0, LuI var1, int var2) {
      return MSdS(var0, var2, 8, var1.uZb);
   }

   private static int kLSFHxn(CGKwNP var0, LuI var1, int var2) {
      return MSdS(var0, var2, 4, var1.uZb);
   }

   private static int NSPBg(CGKwNP var0, LuI var1, int var2, int var3, int var4) {
      int var5 = var0.ndiOsc();
      int var6 = var1.uZb;
      int var7 = MSdS(var0, var2, 3, var6);
      int var8 = MSdS(var0, var2, 0, var6);
      int var9 = MSdS(var0, var2, 6, var6);
      if (var3 >= var9) {
         throw new IllegalStateException("Operand out of range " + var3);
      } else {
         int var10 = var8 + var3;
         int var12 = var0.GTAEa()[var10];
         if (var5 != 0 && (var0.ZNZQ() & 2) != 0) {
            var12 ^= IqOZ(var5 ^ var6 ^ var4, var7, var3, 1546576827 ^ var10);
         }

         if (var5 != 0 && (var0.ZNZQ() & 4) != 0) {
            int var11 = MSdS(var0, var2, 1, var6);
            if ((var11 & 1 << var3) != 0) {
               var12 ^= IqOZ(var5 ^ var6 ^ var4, var7, var3, 740139459);
            }
         }

         return var12;
      }
   }

   private static int IqOZ(int var0, int var1, int var2, int var3) {
      int var4 = var0 ^ 967577364;
      var4 ^= var1 + -1758267423 + (var4 << 6) + (var4 >>> 2);
      var4 ^= var2 + -2050728836 + (var4 << 6) + (var4 >>> 2);
      var4 ^= var3 + -1467091683 + (var4 << 6) + (var4 >>> 2);
      var4 ^= var4 >>> 16;
      var4 *= 414792525;
      var4 ^= var4 >>> 15;
      var4 *= 745949939;
      var4 ^= var4 >>> 16;
      return var4;
   }

   private static int MSdS(CGKwNP var0, int var1, int var2, int var3) {
      int var4 = var0.ndiOsc();
      if (var2 == 2) {
         return nBo(var0, var1);
      } else {
         int var5 = var0.BnUpXiS()[var1 * 9 + var2];
         return var4 == 0 ? var5 : var5 ^ IqOZ(var4 ^ var3, var1, var2, -888546777);
      }
   }

   private static int rwEXCXA(CGKwNP var0, int var1, int var2) {
      int var3 = var0.ndiOsc();
      int var4 = var0.DKP()[var1 * 4 + var2];
      return var3 == 0 ? var4 : var4 ^ IqOZ(var3, var1, var2, -1617555210);
   }

   private static int nBo(CGKwNP var0, int var1) {
      int var2 = var0.ndiOsc();
      int var3 = var0.BnUpXiS()[var1 * 9 + 2];
      if (var2 == 0) {
         return var3;
      } else {
         int var4 = var0.DKP().length / 4;

         for(int var5 = 0; var5 < var4; ++var5) {
            int var6 = rwEXCXA(var0, var5, 2);
            int var7 = rwEXCXA(var0, var5, 3);
            if (var1 >= var6 && var1 < var6 + var7) {
               int var9 = 0;

               for(int var8 = var6; var8 <= var1; ++var8) {
                  var3 = var0.BnUpXiS()[var8 * 9 + 2];
                  if (var8 == var6) {
                     var9 = var3 ^ IqOZ(var2, var8, -196974032, 0);
                  } else {
                     var9 = var3 ^ IqOZ(var2 ^ var9, var8, var5, -196974032);
                  }
               }

               return var9;
            }
         }

         return 0;
      }
   }

   private static int NbvjVr(CGKwNP var0, int var1, int var2) {
      int var3 = var0.DKP().length / 4;
      if (var1 >= 0 && var1 < var3) {
         int var4 = rwEXCXA(var0, var1, 2);
         int var5 = rwEXCXA(var0, var1, 3);
         int var9 = var0.ndiOsc();
         int var8 = 0;

         for(int var6 = 0; var6 < var5; ++var6) {
            int var7 = var4 + var6;
            int var10 = var0.BnUpXiS()[var7 * 9 + 2];
            if (var9 == 0) {
               var8 = var10;
            } else if (var6 == 0) {
               var8 = var10 ^ IqOZ(var9, var7, -196974032, 0);
            } else {
               var8 = var10 ^ IqOZ(var9 ^ var8, var7, var1, -196974032);
            }

            if (MSdS(var0, var7, 3, var8) == var2) {
               return var7;
            }

            if (MSdS(var0, var7, 4, var8) == var2) {
               return var7;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private static void zYb(CGKwNP var0, LuI var1, int var2) {
      int var3 = otbof(var0, var1, var2);
      if (var3 == -1) {
         var1.uZb = 0;
         var1.soF = -1;
      } else {
         int var4 = nBo(var0, var3);
         var4 ^= var1.shPVzSZ;
         int var5 = MSdS(var0, var3, 7, var4);
         var1.uZb = var4;
         var1.soF = var5;
      }
   }

   private static int UGL(int var0) {
      return IqOZ(64818821, var0, -2129237019, 0);
   }

   private static CGKwNP mmq(int var0) {
      var0 ^= Teh.IIciQL();
      CGKwNP var1 = null;
      Iterator var2 = gvpXgT.iterator();

      while(var2.hasNext()) {
         CGKwNP var3 = ((gHfNqnL)var2.next()).Csrs(var0);
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

   private static String PBWDZK(CGKwNP var0, LuI var1, Object[] var2, int var3, int var4, int var5) {
      return (String)Rdnre(var0, var2[var3], var1, var4, var5);
   }

   private static MethodType zmc(String var0) {
      MethodType var1 = (MethodType)giha.get(var0);
      if (var1 != null) {
         return var1;
      } else {
         var1 = MethodType.fromMethodDescriptorString(var0, pCn.class.getClassLoader());
         giha.put(var0, var1);
         return var1;
      }
   }

   private static Object Rdnre(CGKwNP var0, Object var1, LuI var2, int var3, int var4) {
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

         int var6 = var0.ndiOsc();
         int var7 = var2.uZb;
         int var8 = MSdS(var0, var3, 3, var7);
         int var9 = var2.soF;
         int var10 = IqOZ(var6 ^ var7, var8, var9, 740139459);
         int var12 = IqOZ(var10, var3, var4, -1316993527);
         int var11 = IqOZ(var7 ^ -1341124750, var6, var4, var8);
         int var13 = IqOZ(var11, var9, var3, 625330154);
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
                  if (var16[2] == IqOZ(var12 ^ var17, var13, var18, 723263821) && var16[3] == IqOZ(var13 ^ var18, var12, var17, -1617555210)) {
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
            int var25 = IqOZ(var12 ^ var17, var13, var14, 740139459) ^ Integer.rotateLeft(IqOZ(var13 ^ var18, var12, var14, -1341124750), var17 + var14 & 31);
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

      ClassLoader var23 = pCn.class.getClassLoader();
      if (var2.iwiYoC.length > 0) {
         Object var24 = var2.iwiYoC[0];
         if (var24 != null) {
            var23 = var24.getClass().getClassLoader();
         }
      }

      if (var22.length() == 0) {
         throw new IllegalStateException("Invalid encoded VM type constant");
      } else {
         return var22.charAt(0) == '(' ? MethodType.fromMethodDescriptorString(var22, var23) : DnATm(var22, var23);
      }
   }

   private static int lZxSxXr(Throwable var0, int[] var1, int var2, int var3, int var4, CGKwNP var5, LuI var6, Object[] var7) {
      int var8 = var5.ndiOsc();

      for(int var9 = 0; var9 < var1.length; var9 += 4) {
         int var10 = var9 / 4;
         int var11 = var1[var9];
         int var12 = var1[var9 + 1];
         int var13 = var1[var9 + 2];
         int var14 = var1[var9 + 3];
         if (var8 != 0) {
            var11 ^= IqOZ(var8, var10, 0, 723263821);
            var12 ^= IqOZ(var8, var10, 1, 723263821);
            var13 ^= IqOZ(var8, var10, 2, 723263821);
            var14 ^= IqOZ(var8, var10, 3, 723263821);
         }

         if (var2 >= var11 && var2 < var12) {
            if (var14 < 0) {
               return var13;
            }

            if (qpQMh(PBWDZK(var5, var6, var7, var14, var3, var4)).isInstance(var0)) {
               return var13;
            }
         }
      }

      return -1;
   }

   private static Object jUTl(String var0, String var1, String var2, boolean var3, Object var4) {
      try {
         return MWzNxE(var0, var1, var2, var3, false).invokeExact(var4);
      } catch (Throwable var6) {
         throw BMDtS(var6);
      }
   }

   private static void FARn(String var0, String var1, String var2, boolean var3, Object var4, Object var5) {
      try {
         var5 = XrZ(var5, qpQMh(var2));
         if (var3) {
            Class var6 = qpQMh(var0);
            Field var7 = PacHNP(var6, var1);
            if (Modifier.isFinal(var7.getModifiers())) {
               var7.setAccessible(true);
               HMOvF(var7, var5);
               return;
            }
         }

         MWzNxE(var0, var1, var2, var3, true).invokeExact(var4, var5);
      } catch (Throwable var9) {
         throw BMDtS(var9);
      }
   }

   private static MethodHandle MWzNxE(String var0, String var1, String var2, boolean var3, boolean var4) {
      String var5 = var0 + "." + var1 + ":" + var2 + ":" + var3 + ":" + var4;
      MethodHandle var6 = (MethodHandle)uCrw.get(var5);
      if (var6 != null) {
         return var6;
      } else {
         try {
            Class var7 = qpQMh(var0);
            Class var8 = qpQMh(var2);
            Field var9 = PacHNP(var7, var1);
            var9.setAccessible(true);
            if (var9.getType() != var8) {
               throw new NoSuchFieldException(var7.getName() + "." + var1);
            } else if (Modifier.isStatic(var9.getModifiers()) != var3) {
               throw new NoSuchFieldException(var7.getName() + "." + var1);
            } else {
               MethodHandle var10 = IeiVHhc(var9, var3, var4);
               uCrw.put(var5, var10);
               return var10;
            }
         } catch (ReflectiveOperationException var12) {
            throw new IllegalStateException((Throwable)var12);
         }
      }
   }

   private static MethodHandle IeiVHhc(Field var0, boolean var1, boolean var2) throws IllegalAccessException {
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

   private static Unsafe CYEG() {
      try {
         Field var0 = Unsafe.class.getDeclaredField("theUnsafe");
         var0.setAccessible(true);
         return (Unsafe)var0.get((Object)null);
      } catch (ReflectiveOperationException var2) {
         throw new IllegalStateException((Throwable)var2);
      }
   }

   private static void HMOvF(Field var0, Object var1) {
      Unsafe var2 = CYEG();
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

   private static Field PacHNP(Class var0, String var1) throws NoSuchFieldException {
      try {
         return var0.getDeclaredField(var1);
      } catch (NoSuchFieldException var10) {
         Class[] var2 = var0.getInterfaces();
         int var3 = 0;

         while(var3 < var2.length) {
            try {
               return PacHNP(var2[var3], var1);
            } catch (NoSuchFieldException var9) {
               ++var3;
            }
         }

         Class var5 = var0.getSuperclass();
         if (var5 != null) {
            return PacHNP(var5, var1);
         } else {
            throw new NoSuchFieldException(var1);
         }
      }
   }

   private static Method gxxyUkE(Class var0, String var1, Class[] var2, Class var3) throws NoSuchMethodException {
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
            return gxxyUkE(var6[var7], var1, var2, var3);
         } catch (NoSuchMethodException var14) {
            ++var7;
         }
      }

      Class var9 = var0.getSuperclass();
      if (var9 != null) {
         return gxxyUkE(var9, var1, var2, var3);
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

   private static Object OJb(String var0, String var1, MethodType var2, boolean var3, Object var4, Object[] var5) {
      if (!var3 && var1.equals("clone") && var2.parameterCount() == 0 && var4.getClass().isArray()) {
         return AkG(var4);
      } else if (!var3 && var0.equals("java/lang/invoke/MethodHandle") && (var1.equals("invoke") || var1.equals("invokeExact"))) {
         for(int var12 = 0; var12 < var5.length; ++var12) {
            var5[var12] = XrZ(var5[var12], var2.parameterType(var12));
         }

         try {
            return ((MethodHandle)var4).asType(var2).asSpreader(Object[].class, var2.parameterCount()).asType(MethodType.methodType(Object.class, Object[].class)).invokeExact(var5);
         } catch (Throwable var29) {
            throw BMDtS(var29);
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
               var5[var18] = XrZ(var5[var18], var2.parameterType(var18));
            }

            var7 = ((VarHandle)var4).toMethodHandle(var11).asType(var2).asFixedArity().asSpreader(Object[].class, var2.parameterCount());

            try {
               return var7.asType(MethodType.methodType(Object.class, Object[].class)).invokeExact(var5);
            } catch (Throwable var30) {
               throw BMDtS(var30);
            }
         } else {
            String var6 = var0 + "." + var1 + var2 + ":" + var3;
            var7 = (MethodHandle)dIDWlsO.get(var6);
            if (var7 == null) {
               Class var8 = null;
               Throwable var9 = null;

               Method var10;
               try {
                  var8 = qpQMh(var0);
                  var10 = gxxyUkE(var8, var1, var2.parameterArray(), var2.returnType());
                  var10.setAccessible(true);
                  if (var10.getReturnType() != var2.returnType()) {
                     throw new NoSuchMethodException(var8.getName() + "." + var1 + var2);
                  }

                  if (Modifier.isStatic(var10.getModifiers()) != var3) {
                     throw new NoSuchMethodException(var8.getName() + "." + var1 + var2);
                  }

                  var7 = sVkn(var10, var3, var2.parameterCount());
                  dIDWlsO.put(var6, var7);
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

                     var7 = sVkn(var10, var3, var2.parameterCount());
                     dIDWlsO.put(var6, var7);
                  } catch (ReflectiveOperationException var32) {
                     var9 = (Throwable)var32;
                  }
               }

               if (var7 == null) {
                  if (var9 == null || !var9.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
                     throw new IllegalStateException(var9);
                  }

                  var7 = qaXZ(var8, var1, var2, var3);
                  dIDWlsO.put(var6, var7);
               }
            }

            for(int var26 = 0; var26 < var5.length; ++var26) {
               var5[var26] = XrZ(var5[var26], var2.parameterType(var26));
            }

            try {
               return var7.invokeExact(var4, var5);
            } catch (Throwable var31) {
               throw BMDtS(var31);
            }
         }
      }
   }

   private static Object NBehLta(String var0, MethodType var1, Object[] var2) {
      String var3 = "<init>:" + var0 + var1;
      MethodHandle var4 = (MethodHandle)dIDWlsO.get(var3);
      if (var4 == null) {
         try {
            Class var5 = qpQMh(var0);
            Constructor var6 = var5.getDeclaredConstructor(var1.parameterArray());
            var6.setAccessible(true);
            var4 = eay(var6, var1.parameterCount());
            dIDWlsO.put(var3, var4);
         } catch (Throwable var13) {
            throw BMDtS(var13);
         }
      }

      for(int var9 = 0; var9 < var2.length; ++var9) {
         var2[var9] = XrZ(var2[var9], var1.parameterType(var9));
      }

      try {
         return var4.invokeExact((Object)null, var2);
      } catch (Throwable var12) {
         throw BMDtS(var12);
      }
   }

   private static MethodHandle sVkn(Method var0, boolean var1, int var2) throws IllegalAccessException {
      MethodHandle var3 = MethodHandles.lookup().unreflect(var0).asFixedArity().asSpreader(Object[].class, var2);
      if (var1) {
         Class[] var4 = new Class[]{Object.class};
         var3 = MethodHandles.dropArguments(var3, 0, var4);
      }

      Class[] var6 = new Class[]{Object[].class};
      return var3.asType(MethodType.methodType(Object.class, Object.class, var6));
   }

   private static MethodHandle qaXZ(Class var0, String var1, MethodType var2, boolean var3) throws IllegalAccessException, NoSuchMethodException {
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

   private static MethodHandle eay(Constructor var0, int var1) throws IllegalAccessException {
      MethodHandle var2 = MethodHandles.lookup().unreflectConstructor(var0).asFixedArity().asSpreader(Object[].class, var1);
      Class[] var3 = new Class[]{Object.class};
      var2 = MethodHandles.dropArguments(var2, 0, var3);
      Class[] var5 = new Class[]{Object[].class};
      return var2.asType(MethodType.methodType(Object.class, Object.class, var5));
   }

   private static Object XrZ(Object var0, Class var1) {
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

   private static Object AkG(Object var0) {
      int var1 = Array.getLength(var0);
      Object var2 = Array.newInstance(var0.getClass().getComponentType(), var1);
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   private static Class qpQMh(String var0) {
      return DnATm(var0, pCn.class.getClassLoader());
   }

   private static Class DnATm(String var0, ClassLoader var1) {
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
            return Class.forName(var2, false, pCn.class.getClassLoader());
         } catch (ClassNotFoundException var6) {
            throw new IllegalStateException((Throwable)var7);
         }
      }
   }

   private static synchronized ReentrantLock kon(Object var0) {
      if (var0 == null) {
         throw new NullPointerException();
      } else {
         ReentrantLock var1 = (ReentrantLock)ewh.get(var0);
         if (var1 == null) {
            var1 = new ReentrantLock();
            ewh.put(var0, var1);
         }

         return var1;
      }
   }

   private static void DmvmB(Object var0) {
      kon(var0).lock();
   }

   private static void sBfM(Object var0) {
      kon(var0).unlock();
   }

   private static RuntimeException BMDtS(Throwable var0) {
      throw var0;
   }
}
