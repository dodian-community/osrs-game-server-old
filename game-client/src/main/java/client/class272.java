package client;

public class class272 extends class206 {
   static class200 field3524 = new class200(64);
   static class247 field3529;
   public int field3528 = -1;
   public int field3533 = 0;
   public boolean field3523 = true;
   public int field3526 = -1;
   public int field3525;
   public int field3527;
   public int field3530;
   public int field3532;
   public int field3531;
   public int field3534;

   void method5191(Stream var1, int var2, int var3, int var4) {
      if(var2 == 1) {
         this.field3533 = var1.readMedium();
      } else if(var2 == 2) {
         this.field3526 = var1.readUByte();
      } else if(var2 == 5) {
         if(var4 >= 181352847) {
            return;
         }

         this.field3523 = false;
      } else if(var2 == 7) {
         this.field3528 = var1.readMedium();
      } else if(var2 == 8) {
         ;
      }

   }

   void method5192(int var1, int var2) {
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
         if(var2 <= 796241509) {
            return;
         }

         var11 = var7;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      double var17 = (var11 + var9) / 2.0D;
      if(var9 != var11) {
         if(var2 <= 796241509) {
            return;
         }

         if(var17 < 0.5D) {
            var15 = (var11 - var9) / (var11 + var9);
         }

         if(var17 >= 0.5D) {
            var15 = (var11 - var9) / (2.0D - var11 - var9);
         }

         if(var3 == var11) {
            if(var2 <= 796241509) {
               return;
            }

            var13 = (var5 - var7) / (var11 - var9);
         } else if(var11 == var5) {
            if(var2 <= 796241509) {
               return;
            }

            var13 = (var7 - var3) / (var11 - var9) + 2.0D;
         } else if(var7 == var11) {
            var13 = (var3 - var5) / (var11 - var9) + 4.0D;
         }
      }

      var13 /= 6.0D;
      this.field3525 = (int)(256.0D * var13);
      this.field3530 = (int)(256.0D * var15);
      this.field3531 = (int)(var17 * 256.0D);
      if(this.field3530 < 0) {
         this.field3530 = 0;
      } else if(this.field3530 > 255) {
         if(var2 <= 796241509) {
            return;
         }

         this.field3530 = 255;
      }

      if(this.field3531 < 0) {
         this.field3531 = 0;
      } else if(this.field3531 > 255) {
         this.field3531 = 255;
      }

   }

   void method5195(int var1) {
      if(this.field3528 != -1) {
         this.method5192(this.field3528, 1230983884);
         this.field3527 = this.field3525;
         this.field3532 = this.field3530;
         this.field3534 = this.field3531;
      }

      this.method5192(this.field3533, 2130677092);
   }

   void method5194(Stream var1, int var2, int var3) {
      while(true) {
         int var4 = var1.readUByte();
         if(var4 == 0) {
            if(var3 >= -1961233435) {
               return;
            }

            return;
         }

         this.method5191(var1, var4, var2, -1678244242);
      }
   }
}
