package client;

public class class101 {
   int field1342 = class92.method2108(8);
   int field1339 = class92.method2108(16);
   int field1344 = class92.method2108(24);
   int field1340 = class92.method2108(24);
   int field1341 = class92.method2108(24) + 1;
   int[] field1345;
   int field1343 = class92.method2108(6) + 1;

   class101() {
      int[] var1 = new int[this.field1343];

      int var2;
      for(var2 = 0; var2 < this.field1343; var2++) {
         int var3 = 0;
         int var4 = class92.method2108(3);
         boolean var5 = class92.method2093() != 0;
         if(var5) {
            var3 = class92.method2108(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1345 = new int[this.field1343 * 8];

      for(var2 = 0; var2 < this.field1343 * 8; var2++) {
         this.field1345[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0 ? class92.method2108(8) : -1;
      }

   }

   void method2234(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; var4++) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class92.field1254[this.field1342].field1235;
         int var5 = this.field1344 - this.field1340;
         int var6 = var5 / this.field1341;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; var8++) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class92.field1254[this.field1342].method2055();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1343;
                     }

                     var10 /= this.field1343;
                  }
               }

               for(var10 = 0; var10 < var4; var10++) {
                  var11 = var7[var9];
                  int var12 = this.field1345[var8 + var11 * 8];
                  if(var12 >= 0) {
                     int var13 = var9 * this.field1341 + this.field1340;
                     class90 var14 = class92.field1254[var12];
                     int var15;
                     if(this.field1339 == 0) {
                        var15 = this.field1341 / var14.field1235;

                        for(int var16 = 0; var16 < var15; var16++) {
                           float[] var17 = var14.method2062();

                           for(int var18 = 0; var18 < var14.field1235; var18++) {
                              var1[var13 + var16 + var18 * var15] += var17[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1341) {
                           float[] var19 = var14.method2062();

                           for(int var20 = 0; var20 < var14.field1235; var20++) {
                              var1[var13 + var15] += var19[var20];
                              ++var15;
                           }
                        }
                     }
                  }

                  ++var9;
                  if(var9 >= var6) {
                     break;
                  }
               }
            }
         }

      }
   }
}
