package client;

public class class92 extends class204 {
   static boolean field1260 = false;
   static byte[] field1266;
   static int field1250;
   static int field1262;
   static class90[] field1254;
   static int field1259;
   static int[] field1243;
   static int field1252;
   static float[] field1265;
   static boolean[] field1258;
   static class106[] field1257;
   static float[] field1247;
   static float[] field1251;
   static float[] field1269;
   static float[] field1270;
   static float[] field1268;
   static float[] field1271;
   static class94[] field1255;
   static int[] field1267;
   static int[] field1272;
   static class101[] field1273;
   byte[][] field1263;
   byte[] field1274;
   int field1264;
   int field1276;
   int field1244;
   float[] field1261;
   int field1245;
   int field1275;
   int field1246;
   int field1253;
   boolean field1248;
   boolean field1256;
   int field1249;

   class92(byte[] var1) {
      this.method2094(var1);
   }

   void method2094(byte[] var1) {
      Stream var2 = new Stream(var1);
      this.field1244 = var2.readInt();
      this.field1245 = var2.readInt();
      this.field1246 = var2.readInt();
      this.field1253 = var2.readInt();
      if(this.field1253 < 0) {
         this.field1253 = ~this.field1253;
         this.field1248 = true;
      }

      int var3 = var2.readInt();
      this.field1263 = new byte[var3][];

      for(int var4 = 0; var4 < var3; var4++) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method3539(var7, 0, var5);
         this.field1263[var4] = var7;
      }

   }

   class93 method2083(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1274 == null) {
            this.field1264 = 0;
            this.field1261 = new float[field1259];
            this.field1274 = new byte[this.field1245];
            this.field1275 = 0;
            this.field1276 = 0;
         }

         for(; this.field1276 < this.field1263.length; this.field1276++) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method2086(this.field1276);
            if(var2 != null) {
               int var3 = this.field1275;
               int var4 = var2.length;
               if(var4 > this.field1245 - var3) {
                  var4 = this.field1245 - var3;
               }

               for(int var5 = 0; var5 < var4; var5++) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1274[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1275;
               }

               this.field1275 = var3;
            }
         }

         this.field1261 = null;
         byte[] var7 = this.field1274;
         this.field1274 = null;
         return new class93(this.field1244, var7, this.field1246, this.field1253, this.field1248);
      }
   }

   float[] method2086(int var1) {
      method2081(this.field1263[var1], 0);
      method2093();
      int var2 = method2108(class143.method3173(field1243.length - 1, -329911544));
      boolean var3 = field1258[var2];
      int var4 = var3 ? field1259 : field1252;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method2093() != 0;
         var6 = method2093() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1252 >> 2);
         var9 = (field1252 >> 2) + (var4 >> 2);
         var10 = field1252 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1252 >> 2);
         var12 = (field1252 >> 2) + (var4 - (var4 >> 2));
         var13 = field1252 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class106 var14 = field1257[field1243[var2]];
      int var16 = var14.field1387;
      int var17 = var14.field1389[var16];
      boolean var15 = !field1255[var17].method2121();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1388; var17++) {
         class101 var18 = field1273[var14.field1386[var17]];
         float[] var19 = field1265;
         var18.method2234(var19, var4 >> 1, var45);
      }

      int var40;
      if(!var15) {
         var17 = var14.field1387;
         var40 = var14.field1389[var17];
         field1255[var40].method2141(field1265, var4 >> 1);
      }

      int var42;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; var17++) {
            field1265[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var40 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var43 = field1265;

         int var21;
         for(var21 = 0; var21 < var17; var21++) {
            var43[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; var21++) {
            var43[var21] = -var43[var4 - var21 - 1];
         }

         float[] var44 = var3 ? field1247 : field1251;
         float[] var22 = var3 ? field1270 : field1269;
         float[] var23 = var3 ? field1271 : field1268;
         int[] var24 = var3 ? field1267 : field1272;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var40; var25++) {
            var26 = var43[var25 * 4] - var43[var4 - var25 * 4 - 1];
            var27 = var43[var25 * 4 + 2] - var43[var4 - var25 * 4 - 3];
            var28 = var44[var25 * 2];
            var29 = var44[var25 * 2 + 1];
            var43[var4 - var25 * 4 - 1] = var26 * var28 - var27 * var29;
            var43[var4 - var25 * 4 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var42; var25++) {
            var26 = var43[var17 + var25 * 4 + 3];
            var27 = var43[var17 + var25 * 4 + 1];
            var28 = var43[var25 * 4 + 3];
            var29 = var43[var25 * 4 + 1];
            var43[var17 + var25 * 4 + 3] = var26 + var28;
            var43[var17 + var25 * 4 + 1] = var27 + var29;
            var30 = var44[var17 - 4 - var25 * 4];
            var31 = var44[var17 - 3 - var25 * 4];
            var43[var25 * 4 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var43[var25 * 4 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class143.method3173(var4 - 1, -678961511);

         int var47;
         int var48;
         int var49;
         int var50;
         for(var47 = 0; var47 < var25 - 3; var47++) {
            var48 = var4 >> var47 + 2;
            var49 = 8 << var47;

            for(var50 = 0; var50 < 2 << var47; var50++) {
               int var51 = var4 - var48 * var50 * 2;
               int var52 = var4 - var48 * (var50 * 2 + 1);

               for(int var32 = 0; var32 < var4 >> var47 + 4; var32++) {
                  int var33 = var32 * 4;
                  float var34 = var43[var51 - 1 - var33];
                  float var35 = var43[var51 - 3 - var33];
                  float var36 = var43[var52 - 1 - var33];
                  float var37 = var43[var52 - 3 - var33];
                  var43[var51 - 1 - var33] = var34 + var36;
                  var43[var51 - 3 - var33] = var35 + var37;
                  float var38 = var44[var32 * var49];
                  float var39 = var44[var32 * var49 + 1];
                  var43[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var43[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var42 - 1; var47++) {
            var48 = var24[var47];
            if(var47 < var48) {
               var49 = var47 * 8;
               var50 = var48 * 8;
               var30 = var43[var49 + 1];
               var43[var49 + 1] = var43[var50 + 1];
               var43[var50 + 1] = var30;
               var30 = var43[var49 + 3];
               var43[var49 + 3] = var43[var50 + 3];
               var43[var50 + 3] = var30;
               var30 = var43[var49 + 5];
               var43[var49 + 5] = var43[var50 + 5];
               var43[var50 + 5] = var30;
               var30 = var43[var49 + 7];
               var43[var49 + 7] = var43[var50 + 7];
               var43[var50 + 7] = var30;
            }
         }

         for(var47 = 0; var47 < var17; var47++) {
            var43[var47] = var43[var47 * 2 + 1];
         }

         for(var47 = 0; var47 < var42; var47++) {
            var43[var4 - 1 - var47 * 2] = var43[var47 * 4];
            var43[var4 - 2 - var47 * 2] = var43[var47 * 4 + 1];
            var43[var4 - var40 - 1 - var47 * 2] = var43[var47 * 4 + 2];
            var43[var4 - var40 - 2 - var47 * 2] = var43[var47 * 4 + 3];
         }

         for(var47 = 0; var47 < var42; var47++) {
            var27 = var23[var47 * 2];
            var28 = var23[var47 * 2 + 1];
            var29 = var43[var17 + var47 * 2];
            var30 = var43[var17 + var47 * 2 + 1];
            var31 = var43[var4 - 2 - var47 * 2];
            float var53 = var43[var4 - 1 - var47 * 2];
            float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
            var43[var17 + var47 * 2] = (var29 + var31 + var54) * 0.5F;
            var43[var4 - 2 - var47 * 2] = (var29 + var31 - var54) * 0.5F;
            var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
            var43[var17 + var47 * 2 + 1] = (var30 - var53 + var54) * 0.5F;
            var43[var4 - 1 - var47 * 2] = (-var30 + var53 + var54) * 0.5F;
         }

         for(var47 = 0; var47 < var40; var47++) {
            var43[var47] = var43[var17 + var47 * 2] * var22[var47 * 2] + var43[var17 + var47 * 2 + 1] * var22[var47 * 2 + 1];
            var43[var17 - 1 - var47] = var43[var17 + var47 * 2] * var22[var47 * 2 + 1] - var43[var17 + var47 * 2 + 1] * var22[var47 * 2];
         }

         for(var47 = 0; var47 < var40; var47++) {
            var43[var47 + (var4 - var40)] = -var43[var47];
         }

         for(var47 = 0; var47 < var40; var47++) {
            var43[var47] = var43[var40 + var47];
         }

         for(var47 = 0; var47 < var40; var47++) {
            var43[var40 + var47] = -var43[var40 - var47 - 1];
         }

         for(var47 = 0; var47 < var40; var47++) {
            var43[var17 + var47] = var43[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; var47++) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1265[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; var47++) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1265[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var41 = null;
      if(this.field1264 > 0) {
         var40 = var4 + this.field1264 >> 2;
         var41 = new float[var40];
         int var20;
         if(!this.field1256) {
            for(var42 = 0; var42 < this.field1249; var42++) {
               var20 = var42 + (this.field1264 >> 1);
               var41[var42] += this.field1261[var20];
            }
         }

         if(!var15) {
            for(var42 = var8; var42 < var4 >> 1; var42++) {
               var20 = var41.length - (var4 >> 1) + var42;
               var41[var20] += field1265[var42];
            }
         }
      }

      float[] var46 = this.field1261;
      this.field1261 = field1265;
      field1265 = var46;
      this.field1264 = var4;
      this.field1249 = var12 - (var4 >> 1);
      this.field1256 = var15;
      return var41;
   }

   static int method2093() {
      int var0 = field1266[field1250] >> field1262 & 1;
      ++field1262;
      field1250 += field1262 >> 3;
      field1262 &= 7;
      return var0;
   }

   static int method2108(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1262; var0 -= var3) {
         var3 = 8 - field1262;
         int var4 = (1 << var3) - 1;
         var1 += (field1266[field1250] >> field1262 & var4) << var2;
         field1262 = 0;
         ++field1250;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1266[field1250] >> field1262 & var3) << var2;
         field1262 += var0;
      }

      return var1;
   }

   static void method2081(byte[] var0, int var1) {
      field1266 = var0;
      field1250 = var1;
      field1262 = 0;
   }

   static boolean method2087(class247 var0) {
      if(!field1260) {
         byte[] var1 = var0.method4625(0, 0, 1127830486);
         if(var1 == null) {
            return false;
         }

         method2082(var1);
         field1260 = true;
      }

      return true;
   }

   static class92 method2088(class247 var0, int var1, int var2) {
      if(!method2087(var0)) {
         var0.method4696(var1, var2, (byte)1);
         return null;
      } else {
         byte[] var3 = var0.method4625(var1, var2, 170459843);
         return var3 == null ? null : new class92(var3);
      }
   }

   static void method2082(byte[] var0) {
      method2081(var0, 0);
      field1252 = 1 << method2108(4);
      field1259 = 1 << method2108(4);
      field1265 = new float[field1259];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; var1++) {
         var2 = var1 != 0 ? field1259 : field1252;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; var7++) {
            var6[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
            var6[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var18 = new float[var3];

         for(int var8 = 0; var8 < var4; var8++) {
            var18[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var18[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var19 = new float[var4];

         for(int var9 = 0; var9 < var5; var9++) {
            var19[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var19[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var20 = new int[var5];
         int var10 = class143.method3173(var5 - 1, -632911915);

         for(int var11 = 0; var11 < var5; var11++) {
            int var15 = var11;
            int var16 = var10;

            int var17;
            for(var17 = 0; var16 > 0; --var16) {
               var17 = var17 << 1 | var15 & 1;
               var15 >>>= 1;
            }

            var20[var11] = var17;
         }

         if(var1 != 0) {
            field1247 = var6;
            field1270 = var18;
            field1271 = var19;
            field1267 = var20;
         } else {
            field1251 = var6;
            field1269 = var18;
            field1268 = var19;
            field1272 = var20;
         }
      }

      var1 = method2108(8) + 1;
      field1254 = new class90[var1];

      for(var2 = 0; var2 < var1; var2++) {
         field1254[var2] = new class90();
      }

      var2 = method2108(6) + 1;

      for(var3 = 0; var3 < var2; var3++) {
         method2108(16);
      }

      var2 = method2108(6) + 1;
      field1255 = new class94[var2];

      for(var3 = 0; var3 < var2; var3++) {
         field1255[var3] = new class94();
      }

      var3 = method2108(6) + 1;
      field1273 = new class101[var3];

      for(var4 = 0; var4 < var3; var4++) {
         field1273[var4] = new class101();
      }

      var4 = method2108(6) + 1;
      field1257 = new class106[var4];

      for(var5 = 0; var5 < var4; var5++) {
         field1257[var5] = new class106();
      }

      var5 = method2108(6) + 1;
      field1258 = new boolean[var5];
      field1243 = new int[var5];

      for(int var21 = 0; var21 < var5; var21++) {
         field1258[var21] = method2093() != 0;
         method2108(16);
         method2108(16);
         field1243[var21] = method2108(8);
      }

   }

   static float method2106(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }
}
