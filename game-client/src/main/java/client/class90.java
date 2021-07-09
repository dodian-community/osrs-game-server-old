package client;

public class class90 {
   float[][] field1237;
   int field1233;
   int[] field1238;
   int[] field1236;
   int field1235;
   int[] field1234;

   class90() {
      class92.method2108(24);
      this.field1235 = class92.method2108(16);
      this.field1233 = class92.method2108(24);
      this.field1236 = new int[this.field1233];
      boolean var1 = class92.method2093() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class92.method2108(5) + 1; var2 < this.field1233; var3++) {
            int var4 = class92.method2108(class143.method3173(this.field1233 - var2, -993381230));

            for(var5 = 0; var5 < var4; var5++) {
               this.field1236[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class92.method2093() != 0;

         for(var3 = 0; var3 < this.field1233; var3++) {
            if(var14 && class92.method2093() == 0) {
               this.field1236[var3] = 0;
            } else {
               this.field1236[var3] = class92.method2108(5) + 1;
            }
         }
      }

      this.method2053();
      var2 = class92.method2108(4);
      if(var2 > 0) {
         float var15 = class92.method2106(class92.method2108(32));
         float var16 = class92.method2106(class92.method2108(32));
         var5 = class92.method2108(4) + 1;
         boolean var6 = class92.method2093() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method2056(this.field1233, this.field1235);
         } else {
            var7 = this.field1233 * this.field1235;
         }

         this.field1234 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; var8++) {
            this.field1234[var8] = class92.method2108(var5);
         }

         this.field1237 = new float[this.field1233][this.field1235];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1233; var8++) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1235; var11++) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1234[var12] * var16 + var15 + var9;
                  this.field1237[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1233; var8++) {
               var9 = 0.0F;
               var10 = var8 * this.field1235;

               for(var11 = 0; var11 < this.field1235; var11++) {
                  float var17 = (float)this.field1234[var10] * var16 + var15 + var9;
                  this.field1237[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   int method2055() {
      int var1;
      for(var1 = 0; this.field1238[var1] >= 0; var1 = class92.method2093() != 0 ? this.field1238[var1] : var1 + 1) {
         ;
      }

      return ~this.field1238[var1];
   }

   float[] method2062() {
      return this.field1237[this.method2055()];
   }

   void method2053() {
      int[] var1 = new int[this.field1233];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1233; var3++) {
         var4 = this.field1236[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var2[var4];
            var1[var3] = var6;
            int var9;
            if((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var9 = var2[var8];
                  if(var9 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var9 & var10) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var9 | var10;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; var8++) {
               var9 = var2[var8];
               if(var9 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      this.field1238 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.field1233; var3++) {
         var4 = this.field1236[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; var7++) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1238[var6] == 0) {
                     this.field1238[var6] = var11;
                  }

                  var6 = this.field1238[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1238.length) {
                  int[] var12 = new int[this.field1238.length * 2];

                  for(var10 = 0; var10 < this.field1238.length; var10++) {
                     var12[var10] = this.field1238[var10];
                  }

                  this.field1238 = var12;
               }

               var8 >>>= 1;
            }

            this.field1238[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   static int method2056(int var0, int var1) {
      int var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1;

      while(true) {
         int var4 = var2;
         int var5 = var1;

         int var6;
         for(var6 = 1; var5 > 1; var5 >>= 1) {
            if((var5 & 1) != 0) {
               var6 *= var4;
            }

            var4 *= var4;
         }

         int var3;
         if(var5 == 1) {
            var3 = var6 * var4;
         } else {
            var3 = var6;
         }

         if(var3 <= var0) {
            return var2;
         }

         --var2;
      }
   }
}
