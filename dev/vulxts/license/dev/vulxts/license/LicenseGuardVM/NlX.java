package dev.vulxts.license.dev.vulxts.license.LicenseGuardVM;

public class NlX {
   public int[] reY;
   public Object nhomg;
   public final Object[] tDShno;
   public final Object[] WPY;
   public final long[] OKuX;
   public final int[] nXw;
   public final int[] pzML;
   public int XGrBNgx;
   public int aCEjMat;
   public int YnOLXV;
   public int fuvXvU;
   public int wwLICq;
   public Object OChj;
   public boolean flCWlBt;
   public int[] vhrhpqO;

   public NlX(int var1, int var2) {
      this.tDShno = new Object[var1];
      this.WPY = new Object[var2];
      this.OKuX = new long[var2];
      this.nXw = new int[var2];
      this.pzML = new int[var2];
      this.aCEjMat = 0;
      this.YnOLXV = 0;
      this.fuvXvU = -1;
   }

   public void wNcq(Object var1) {
      this.SMrxwE(var1, 1);
   }

   public void SMrxwE(Object var1, int var2) {
      this.WPY[this.wwLICq] = var1;
      this.nXw[this.wwLICq] = 0;
      this.pzML[this.wwLICq] = var2;
      ++this.wwLICq;
   }

   public void jpkpH(int var1) {
      this.WPY[this.wwLICq] = null;
      this.OKuX[this.wwLICq] = (long)var1;
      this.nXw[this.wwLICq] = 1;
      this.pzML[this.wwLICq] = 1;
      ++this.wwLICq;
   }

   public void tTm(long var1) {
      this.WPY[this.wwLICq] = null;
      this.OKuX[this.wwLICq] = var1;
      this.nXw[this.wwLICq] = 2;
      this.pzML[this.wwLICq] = 2;
      ++this.wwLICq;
   }

   public void rSjkFCx(float var1) {
      this.WPY[this.wwLICq] = null;
      this.OKuX[this.wwLICq] = (long)Float.floatToRawIntBits(var1);
      this.nXw[this.wwLICq] = 3;
      this.pzML[this.wwLICq] = 1;
      ++this.wwLICq;
   }

   public void BAbHGl(double var1) {
      this.WPY[this.wwLICq] = null;
      this.OKuX[this.wwLICq] = Double.doubleToRawLongBits(var1);
      this.nXw[this.wwLICq] = 4;
      this.pzML[this.wwLICq] = 2;
      ++this.wwLICq;
   }

   public Object auPAkP() {
      int var1 = this.wwLICq - 1;
      int var3 = this.nXw[var1];
      this.nXw[var1] = 0;
      this.pzML[var1] = 0;
      Object var5 = this.WPY[var1];
      this.WPY[var1] = null;
      if (var3 == 1) {
         return (int)this.OKuX[var1];
      } else if (var3 == 2) {
         return this.OKuX[var1];
      } else if (var3 == 3) {
         return Float.intBitsToFloat((int)this.OKuX[var1]);
      } else {
         return var3 == 4 ? Double.longBitsToDouble(this.OKuX[var1]) : var5;
      }
   }

   public int TbGo() {
      int var1 = this.wwLICq - 1;
      int var3 = this.nXw[var1];
      this.nXw[var1] = 0;
      this.pzML[var1] = 0;
      if (var3 == 1) {
         return (int)this.OKuX[var1];
      } else {
         Object var5 = this.WPY[var1];
         if (var5 instanceof Boolean) {
            return ((Boolean)var5 instanceof Boolean ? (Boolean)((Boolean)var5) : ((Boolean)var5 instanceof Character ? (Character)((Boolean)var5) : ((Number)((Boolean)var5)).intValue())) == 1 ? 1 : 0;
         } else if (var5 instanceof Character) {
            return var5 instanceof Boolean ? (Boolean)var5 : (var5 instanceof Character ? (Character)var5 : ((Number)var5).intValue());
         } else {
            return ((Number)var5).intValue();
         }
      }
   }

   public long TnT() {
      int var1 = this.wwLICq - 1;
      int var3 = this.nXw[var1];
      this.nXw[var1] = 0;
      this.pzML[var1] = 0;
      if (var3 == 2) {
         return this.OKuX[var1];
      } else {
         Object var5 = this.WPY[var1];
         this.WPY[var1] = null;
         return ((Number)var5).longValue();
      }
   }

   public float Qgvvs() {
      // $FF: Couldn't be decompiled
   }

   public double hikQW() {
      // $FF: Couldn't be decompiled
   }

   public int wJvviZ() {
      return this.pzML[this.wwLICq - 1];
   }

   public void QvZwT(Object var1, Object var2) {
      int var3;
      for(var3 = 0; var3 < this.tDShno.length; ++var3) {
         if (this.tDShno[var3] == var1) {
            this.tDShno[var3] = var2;
         }
      }

      for(var3 = 0; var3 < this.wwLICq; ++var3) {
         if (this.WPY[var3] == var1) {
            this.WPY[var3] = var2;
         }
      }

   }
}
