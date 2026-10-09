package dev.vulxts.license.dev.vulxts.license.LicenseGuardVM;

public class LuI {
   public final Object[] iwiYoC;
   public final Object[] nROo;
   public final long[] rxm;
   public final int[] uIc;
   public final int[] Fxnj;
   public int Xyz;
   public int uZb;
   public int shPVzSZ;
   public int soF;
   public int JNWcTAA;
   public Object Mdiyh;
   public boolean hZbgVWo;
   public int[] kwgmoT;
   public int[] cJWjeNH;
   public Object kcq;

   public LuI(int var1, int var2) {
      this.iwiYoC = new Object[var1];
      this.nROo = new Object[var2];
      this.rxm = new long[var2];
      this.uIc = new int[var2];
      this.Fxnj = new int[var2];
      this.uZb = 0;
      this.shPVzSZ = 0;
      this.soF = -1;
   }

   public void oxULe(Object var1) {
      this.kmPUKuU(var1, 1);
   }

   public void kmPUKuU(Object var1, int var2) {
      this.nROo[this.JNWcTAA] = var1;
      this.uIc[this.JNWcTAA] = 0;
      this.Fxnj[this.JNWcTAA] = var2;
      ++this.JNWcTAA;
   }

   public void hiJEV(int var1) {
      this.nROo[this.JNWcTAA] = null;
      this.rxm[this.JNWcTAA] = (long)var1;
      this.uIc[this.JNWcTAA] = 1;
      this.Fxnj[this.JNWcTAA] = 1;
      ++this.JNWcTAA;
   }

   public void Kgw(long var1) {
      this.nROo[this.JNWcTAA] = null;
      this.rxm[this.JNWcTAA] = var1;
      this.uIc[this.JNWcTAA] = 2;
      this.Fxnj[this.JNWcTAA] = 2;
      ++this.JNWcTAA;
   }

   public void KeFslSF(float var1) {
      this.nROo[this.JNWcTAA] = null;
      this.rxm[this.JNWcTAA] = (long)Float.floatToRawIntBits(var1);
      this.uIc[this.JNWcTAA] = 3;
      this.Fxnj[this.JNWcTAA] = 1;
      ++this.JNWcTAA;
   }

   public void UtYAnW(double var1) {
      this.nROo[this.JNWcTAA] = null;
      this.rxm[this.JNWcTAA] = Double.doubleToRawLongBits(var1);
      this.uIc[this.JNWcTAA] = 4;
      this.Fxnj[this.JNWcTAA] = 2;
      ++this.JNWcTAA;
   }

   public Object vmeHn() {
      int var1 = this.JNWcTAA - 1;
      int var3 = this.uIc[var1];
      this.uIc[var1] = 0;
      this.Fxnj[var1] = 0;
      Object var5 = this.nROo[var1];
      this.nROo[var1] = null;
      if (var3 == 1) {
         return (int)this.rxm[var1];
      } else if (var3 == 2) {
         return this.rxm[var1];
      } else if (var3 == 3) {
         return Float.intBitsToFloat((int)this.rxm[var1]);
      } else {
         return var3 == 4 ? Double.longBitsToDouble(this.rxm[var1]) : var5;
      }
   }

   public int gPFDeVf() {
      int var1 = this.JNWcTAA - 1;
      int var3 = this.uIc[var1];
      this.uIc[var1] = 0;
      this.Fxnj[var1] = 0;
      if (var3 == 1) {
         return (int)this.rxm[var1];
      } else {
         Object var5 = this.nROo[var1];
         if (var5 instanceof Boolean) {
            return ((Boolean)var5 instanceof Boolean ? (Boolean)((Boolean)var5) : ((Boolean)var5 instanceof Character ? (Character)((Boolean)var5) : ((Number)((Boolean)var5)).intValue())) == 1 ? 1 : 0;
         } else if (var5 instanceof Character) {
            return var5 instanceof Boolean ? (Boolean)var5 : (var5 instanceof Character ? (Character)var5 : ((Number)var5).intValue());
         } else {
            return ((Number)var5).intValue();
         }
      }
   }

   public long tChB() {
      int var1 = this.JNWcTAA - 1;
      int var3 = this.uIc[var1];
      this.uIc[var1] = 0;
      this.Fxnj[var1] = 0;
      if (var3 == 2) {
         return this.rxm[var1];
      } else {
         Object var5 = this.nROo[var1];
         this.nROo[var1] = null;
         return ((Number)var5).longValue();
      }
   }

   public float fVhlIR() {
      // $FF: Couldn't be decompiled
   }

   public double bQkhz() {
      // $FF: Couldn't be decompiled
   }

   public int rsgf() {
      return this.Fxnj[this.JNWcTAA - 1];
   }

   public void XXAcoz(Object var1, Object var2) {
      int var3;
      for(var3 = 0; var3 < this.iwiYoC.length; ++var3) {
         if (this.iwiYoC[var3] == var1) {
            this.iwiYoC[var3] = var2;
         }
      }

      for(var3 = 0; var3 < this.JNWcTAA; ++var3) {
         if (this.nROo[var3] == var1) {
            this.nROo[var3] = var2;
         }
      }

   }
}
