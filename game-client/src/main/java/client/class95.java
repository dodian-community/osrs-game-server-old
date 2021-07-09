package client;

public class class95 {
   public static int field1300;
   protected static boolean field1295;
   public static class89 field1297;
   static final int field1296 = 10;
   class105[] field1309 = new class105[8];
   protected int[] field1299;
   class105 field1311;
   boolean field1310 = true;
   int field1313 = 0;
   int field1302;
   int field1298 = 32;
   class105[] field1312 = new class105[8];
   long field1294 = 0L;
   long field1305 = Stream.method3547(604838575);
   int field1304 = 0;
   int field1308 = 0;
   int field1307 = 0;
   int field1303;
   long field1301 = 0L;
   int field1306;

   protected void vmethod2156(int var1) throws Exception {
   }

   protected void vmethod2155(int var1) {
   }

   public final synchronized void method2144(int var1) {
      if(this.field1299 != null) {
         long var2 = Stream.method3547(604838575);

         try {
            if(this.field1294 != 0L) {
               if(var2 < this.field1294) {
                  return;
               }

               this.vmethod2163(this.field1302, (short)255);
               this.field1294 = 0L;
               this.field1310 = true;
            }

            int var4 = this.vmethod2153((byte)83);
            if(this.field1308 - var4 > this.field1304) {
               this.field1304 = this.field1308 - var4;
            }

            int var5 = this.field1303 + this.field1306;
            if(var5 + 256 > 16384) {
               var5 = 16128;
            }

            if(var5 + 256 > this.field1302) {
               if(var1 <= 740402205) {
                  return;
               }

               this.field1302 += 1024;
               if(this.field1302 > 16384) {
                  this.field1302 = 16384;
               }

               this.vmethod2155(-546840358);
               this.vmethod2163(this.field1302, (short)255);
               var4 = 0;
               this.field1310 = true;
               if(var5 + 256 > this.field1302) {
                  var5 = this.field1302 - 256;
                  this.field1306 = var5 - this.field1303;
               }
            }

            while(var4 < var5) {
               if(var1 <= 740402205) {
                  return;
               }

               this.method2149(this.field1299, 256);
               this.vmethod2154();
               var4 += 256;
            }

            if(var2 > this.field1301) {
               if(!this.field1310) {
                  if(this.field1304 == 0 && this.field1307 == 0) {
                     this.vmethod2155(-986811350);
                     this.field1294 = var2 + 2000L;
                     return;
                  }

                  this.field1306 = Math.min(this.field1307, this.field1304);
                  this.field1307 = this.field1304;
               } else {
                  this.field1310 = false;
               }

               this.field1304 = 0;
               this.field1301 = var2 + 2000L;
            }

            this.field1308 = var4;
         } catch (Exception var8) {
            this.vmethod2155(-1323448603);
            this.field1294 = 2000L + var2;
         }

         try {
            if(var2 > 500000L + this.field1305) {
               var2 = this.field1305;
            }

            while(var2 > 5000L + this.field1305) {
               this.method2188(256, (byte)52);
               this.field1305 += (long)(256000 / field1300);
            }
         } catch (Exception var7) {
            this.field1305 = var2;
         }

      }
   }

   protected int vmethod2153(byte var1) throws Exception {
      return this.field1302;
   }

   protected void vmethod2163(int var1, short var2) throws Exception {
   }

   public final void method2145(int var1) {
      this.field1310 = true;
   }

   public final synchronized void method2146(int var1) {
      this.field1310 = true;

      try {
         this.vmethod2156(-2047206903);
      } catch (Exception var3) {
         this.vmethod2155(-607021835);
         this.field1294 = Stream.method3547(604838575) + 2000L;
      }

   }

   final void method2188(int var1, byte var2) {
      this.field1313 -= var1;
      if(this.field1313 < 0) {
         this.field1313 = 0;
      }

      if(this.field1311 != null) {
         this.field1311.vmethod4386(var1);
      }

   }

   public final synchronized void method2147(int var1) {
      if(class69.field1010 != null) {
         boolean var2 = true;

         for(int var3 = 0; var3 < 2; var3++) {
            if(this == class69.field1010.field1327[var3]) {
               class69.field1010.field1327[var3] = null;
            }

            if(class69.field1010.field1327[var3] != null) {
               var2 = false;
            }
         }

         if(var2) {
            class135.field1855.shutdownNow();
            class135.field1855 = null;
            class69.field1010 = null;
         }
      }

      this.vmethod2155(-455505252);
      this.field1299 = null;
   }

   final void method2184(class105 var1, int var2, int var3) {
      int var4 = var2 >> 5;
      class105 var5 = this.field1309[var4];
      if(var5 == null) {
         this.field1312[var4] = var1;
      } else {
         var5.field1382 = var1;
      }

      this.field1309[var4] = var1;
      var1.field1384 = var2;
   }

   final void method2149(int[] var1, int var2) {
      int var3 = var2;
      if(field1295) {
         var3 = var2 << 1;
      }

      class193.method3895(var1, 0, var3);
      this.field1313 -= var2;
      if(this.field1311 != null && this.field1313 <= 0) {
         this.field1313 += field1300 >> 4;
         class84.method1956(this.field1311, 2023211616);
         this.method2184(this.field1311, this.field1311.vmethod2435(), 465802976);
         int var4 = 0;
         int var5 = 255;

         int var6;
         class105 var10;
         label104:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class105 var11 = this.field1312[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class108 var12 = var11.field1383;
                        if(var12 != null && var12.field1416 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1382;
                        } else {
                           var11.field1385 = true;
                           int var13 = var11.vmethod4395();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1416 += var13;
                           }

                           if(var4 >= this.field1298) {
                              break label104;
                           }

                           class105 var14 = var11.vmethod4382();
                           if(var14 != null) {
                              for(int var15 = var11.field1384; var14 != null; var14 = var11.vmethod4389()) {
                                 this.method2184(var14, var15 * var14.vmethod2435() >> 8, 1437619430);
                              }
                           }

                           class105 var18 = var11.field1382;
                           var11.field1382 = null;
                           if(var10 == null) {
                              this.field1312[var7] = var18;
                           } else {
                              var10.field1382 = var18;
                           }

                           if(var18 == null) {
                              this.field1309[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; var6++) {
            class105 var16 = this.field1312[var6];
            class105[] var17 = this.field1312;
            this.field1309[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1382;
               var16.field1382 = null;
            }
         }
      }

      if(this.field1313 < 0) {
         this.field1313 = 0;
      }

      if(this.field1311 != null) {
         this.field1311.vmethod4385(var1, 0, var2);
      }

      this.field1305 = Stream.method3547(604838575);
   }

   protected void vmethod2154() throws Exception {
   }

   public final synchronized void method2143(class105 var1, int var2) {
      this.field1311 = var1;
   }

   protected void vmethod2176(int var1) throws Exception {
   }

   public static class152 method2195(Throwable var0, String var1) {
      class152 var2;
      if(var0 instanceof class152) {
         var2 = (class152)var0;
         var2.field1941 = var2.field1941 + ' ' + var1;
      } else {
         var2 = new class152(var0, var1);
      }

      return var2;
   }
}
