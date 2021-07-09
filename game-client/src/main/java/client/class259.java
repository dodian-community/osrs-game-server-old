package client;

public class class259 extends class206 {
   public static class200 field3282 = new class200(64);
   static class247 field3283;
   static final int field3285 = 1002;
   int field3288 = 0;
   public int field3287;
   public int field3286;
   public int field3281;
   public int field3284;

   void method4885(int var1, int var2) {
      double var3 = (double)(var1 >> 16 & 255) / 256.0D;
      double var5 = (double)(var1 >> 8 & 255) / 256.0D;
      double var7 = (double)(var1 & 255) / 256.0D;
      double var9 = var3;
      if(var5 < var3) {
         var9 = var5;
      }

      if(var7 < var9) {
         var9 = var7;
      }

      double var11 = var3;
      if(var5 > var3) {
         var11 = var5;
      }

      if(var7 > var11) {
         var11 = var7;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      double var17 = (var11 + var9) / 2.0D;
      if(var9 != var11) {
         if(var2 == 1708585715) {
            return;
         }

         if(var17 < 0.5D) {
            var15 = (var11 - var9) / (var11 + var9);
         }

         if(var17 >= 0.5D) {
            var15 = (var11 - var9) / (2.0D - var11 - var9);
         }

         if(var11 == var3) {
            if(var2 == 1708585715) {
               return;
            }

            var13 = (var5 - var7) / (var11 - var9);
         } else if(var11 == var5) {
            var13 = 2.0D + (var7 - var3) / (var11 - var9);
         } else if(var11 == var7) {
            var13 = (var3 - var5) / (var11 - var9) + 4.0D;
         }
      }

      var13 /= 6.0D;
      this.field3287 = (int)(var15 * 256.0D);
      this.field3286 = (int)(256.0D * var17);
      if(this.field3287 < 0) {
         this.field3287 = 0;
      } else if(this.field3287 > 255) {
         this.field3287 = 255;
      }

      if(this.field3286 < 0) {
         this.field3286 = 0;
      } else if(this.field3286 > 255) {
         this.field3286 = 255;
      }

      if(var17 > 0.5D) {
         this.field3281 = (int)(var15 * (1.0D - var17) * 512.0D);
      } else {
         this.field3281 = (int)(512.0D * var15 * var17);
      }

      if(this.field3281 < 1) {
         this.field3281 = 1;
      }

      this.field3284 = (int)(var13 * (double)this.field3281);
   }

   void method4881(Stream var1, int var2, int var3, byte var4) {
      if(var2 == 1) {
         this.field3288 = var1.readMedium();
      }

   }

   void method4875(int var1) {
      this.method4885(this.field3288, -82283989);
   }

   void method4880(Stream var1, int var2, int var3) {
      while(true) {
         int var4 = var1.readUByte();
         if(var4 == 0) {
            return;
         }

         this.method4881(var1, var4, var2, (byte)-45);
      }
   }
}
