package client;

public class class104 {
   static float[][] field1370 = new float[2][8];
   static int[][] field1376 = new int[2][8];
   static float field1381;
   static int field1378;
   static final int field1371 = 4;
   static final float field1372 = 32.703197F;
   static final float field1375 = 100.0F;
   static final float field1380 = 8.0F;
   int[][][] field1377 = new int[2][2][4];
   int[][][] field1379 = new int[2][2][4];
   int[] field1374 = new int[2];
   int[] field1373 = new int[2];

   float method2420(int var1, int var2, float var3) {
      float var4 = (float)this.field1377[var1][0][var2] + var3 * (float)(this.field1377[var1][1][var2] - this.field1377[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   float method2422(int var1, int var2, float var3) {
      float var4 = (float)this.field1379[var1][0][var2] + var3 * (float)(this.field1379[var1][1][var2] - this.field1379[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method2421(var4);
   }

   int method2428(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1374[0] + (float)(this.field1374[1] - this.field1374[0]) * var2;
         var3 *= 0.0030517578F;
         field1381 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1378 = (int)(field1381 * 65536.0F);
      }

      if(this.field1373[var1] == 0) {
         return 0;
      } else {
         var3 = this.method2420(var1, 0, var2);
         field1370[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method2422(var1, 0, var2));
         field1370[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1373[var1]; var4++) {
            var3 = this.method2420(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method2422(var1, var4, var2));
            float var6 = var3 * var3;
            field1370[var1][var4 * 2 + 1] = field1370[var1][var4 * 2 - 1] * var6;
            field1370[var1][var4 * 2] = field1370[var1][var4 * 2 - 1] * var5 + field1370[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1370[var1][var7] += field1370[var1][var7 - 1] * var5 + field1370[var1][var7 - 2] * var6;
            }

            field1370[var1][1] += field1370[var1][0] * var5 + var6;
            field1370[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1373[0] * 2; var4++) {
               field1370[0][var4] *= field1381;
            }
         }

         for(var4 = 0; var4 < this.field1373[var1] * 2; var4++) {
            field1376[var1][var4] = (int)(field1370[var1][var4] * 65536.0F);
         }

         return this.field1373[var1] * 2;
      }
   }

   final void method2425(Stream var1, class96 var2) {
      int var3 = var1.readUByte();
      this.field1373[0] = var3 >> 4;
      this.field1373[1] = var3 & 15;
      if(var3 != 0) {
         this.field1374[0] = var1.readUShort();
         this.field1374[1] = var1.readUShort();
         int var4 = var1.readUByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; var5++) {
            for(var6 = 0; var6 < this.field1373[var5]; var6++) {
               this.field1379[var5][0][var6] = var1.readUShort();
               this.field1377[var5][0][var6] = var1.readUShort();
            }
         }

         for(var5 = 0; var5 < 2; var5++) {
            for(var6 = 0; var6 < this.field1373[var5]; var6++) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1379[var5][1][var6] = var1.readUShort();
                  this.field1377[var5][1][var6] = var1.readUShort();
               } else {
                  this.field1379[var5][1][var6] = this.field1379[var5][0][var6];
                  this.field1377[var5][1][var6] = this.field1377[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1374[1] != this.field1374[0]) {
            var2.method2197(var1);
         }
      } else {
         int[] var7 = this.field1374;
         this.field1374[1] = 0;
         var7[0] = 0;
      }

   }

   static float method2421(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
