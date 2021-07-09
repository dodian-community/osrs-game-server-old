package client;

public final class class176 {
   static class181 field2280 = new class181();
   static final int field2273 = 0;
   static final int field2274 = 16;
   static final int field2275 = 23;
   static final int field2276 = 6;
   static final int field2277 = 4096;
   static final int field2278 = 1;
   static final int field2279 = 50;

   public static int method3489(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      class181 var5 = field2280;
      synchronized(field2280) {
         field2280.field2294 = var2;
         field2280.field2326 = var4;
         field2280.field2305 = var0;
         field2280.field2313 = 0;
         field2280.field2310 = var1;
         field2280.field2316 = 0;
         field2280.field2309 = 0;
         field2280.field2302 = 0;
         field2280.field2295 = 0;
         method3491(field2280);
         var1 -= field2280.field2310;
         field2280.field2294 = null;
         field2280.field2305 = null;
         return var1;
      }
   }

   static void method3491(class181 var0) {
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = false;
      boolean var11 = false;
      boolean var12 = false;
      boolean var13 = false;
      boolean var14 = false;
      boolean var15 = false;
      boolean var16 = false;
      boolean var17 = false;
      boolean var18 = false;
      boolean var19 = false;
      boolean var20 = false;
      boolean var21 = false;
      int var22 = 0;
      int[] var23 = null;
      int[] var24 = null;
      int[] var25 = null;
      var0.field2311 = 1;
      if(class25.field215 == null) {
         class25.field215 = new int[var0.field2311 * 100000];
      }

      boolean var26 = true;

      while(true) {
         while(var26) {
            byte var1 = method3492(var0);
            if(var1 == 23) {
               return;
            }

            var1 = method3492(var0);
            var1 = method3492(var0);
            var1 = method3492(var0);
            var1 = method3492(var0);
            var1 = method3492(var0);
            var1 = method3492(var0);
            var1 = method3492(var0);
            var1 = method3492(var0);
            var1 = method3492(var0);
            var1 = method3493(var0);
            if(var1 != 0) {
               ;
            }

            var0.field2312 = 0;
            var1 = method3492(var0);
            var0.field2312 = var0.field2312 << 8 | var1 & 255;
            var1 = method3492(var0);
            var0.field2312 = var0.field2312 << 8 | var1 & 255;
            var1 = method3492(var0);
            var0.field2312 = var0.field2312 << 8 | var1 & 255;

            int var36;
            for(var36 = 0; var36 < 16; var36++) {
               var1 = method3493(var0);
               if(var1 == 1) {
                  var0.field2296[var36] = true;
               } else {
                  var0.field2296[var36] = false;
               }
            }

            for(var36 = 0; var36 < 256; var36++) {
               var0.field2319[var36] = false;
            }

            int var37;
            for(var36 = 0; var36 < 16; var36++) {
               if(var0.field2296[var36]) {
                  for(var37 = 0; var37 < 16; var37++) {
                     var1 = method3493(var0);
                     if(var1 == 1) {
                        var0.field2319[var37 + var36 * 16] = true;
                     }
                  }
               }
            }

            method3494(var0);
            int var39 = var0.field2318 + 2;
            int var40 = method3490(3, var0);
            int var41 = method3490(15, var0);

            for(var36 = 0; var36 < var41; var36++) {
               var37 = 0;

               while(true) {
                  var1 = method3493(var0);
                  if(var1 == 0) {
                     var0.field2328[var36] = (byte)var37;
                     break;
                  }

                  ++var37;
               }
            }

            byte[] var27 = new byte[6];

            byte var29;
            for(var29 = 0; var29 < var40; var27[var29] = var29++) {
               ;
            }

            for(var36 = 0; var36 < var41; var36++) {
               var29 = var0.field2328[var36];

               byte var28;
               for(var28 = var27[var29]; var29 > 0; --var29) {
                  var27[var29] = var27[var29 - 1];
               }

               var27[0] = var28;
               var0.field2324[var36] = var28;
            }

            int var38;
            for(var38 = 0; var38 < var40; var38++) {
               int var50 = method3490(5, var0);

               for(var36 = 0; var36 < var39; var36++) {
                  while(true) {
                     var1 = method3493(var0);
                     if(var1 == 0) {
                        var0.field2303[var38][var36] = (byte)var50;
                        break;
                     }

                     var1 = method3493(var0);
                     if(var1 == 0) {
                        ++var50;
                     } else {
                        --var50;
                     }
                  }
               }
            }

            for(var38 = 0; var38 < var40; var38++) {
               byte var2 = 32;
               byte var3 = 0;

               for(var36 = 0; var36 < var39; var36++) {
                  if(var0.field2303[var38][var36] > var3) {
                     var3 = var0.field2303[var38][var36];
                  }

                  if(var0.field2303[var38][var36] < var2) {
                     var2 = var0.field2303[var38][var36];
                  }
               }

               method3495(var0.field2301[var38], var0.field2297[var38], var0.field2329[var38], var0.field2303[var38], var2, var3, var39);
               var0.field2330[var38] = var2;
            }

            int var42 = var0.field2318 + 1;
            int var43 = -1;
            byte var44 = 0;

            for(var36 = 0; var36 <= 255; var36++) {
               var0.field2315[var36] = 0;
            }

            int var56 = 4095;

            int var35;
            int var55;
            for(var35 = 15; var35 >= 0; --var35) {
               for(var55 = 15; var55 >= 0; --var55) {
                  var0.field2322[var56] = (byte)(var55 + var35 * 16);
                  --var56;
               }

               var0.field2323[var35] = var56 + 1;
            }

            int var47 = 0;
            byte var54;
            if(var44 == 0) {
               ++var43;
               var44 = 50;
               var54 = var0.field2324[var43];
               var22 = var0.field2330[var54];
               var23 = var0.field2301[var54];
               var25 = var0.field2329[var54];
               var24 = var0.field2297[var54];
            }

            int var45 = var44 - 1;
            int var51 = var22;

            int var52;
            byte var53;
            for(var52 = method3490(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
               ++var51;
               var53 = method3493(var0);
            }

            int var46 = var25[var52 - var24[var51]];

            while(true) {
               while(var46 != var42) {
                  if(var46 != 0 && var46 != 1) {
                     int var33 = var46 - 1;
                     int var30;
                     if(var33 < 16) {
                        var30 = var0.field2323[0];

                        for(var1 = var0.field2322[var30 + var33]; var33 > 3; var33 -= 4) {
                           int var34 = var30 + var33;
                           var0.field2322[var34] = var0.field2322[var34 - 1];
                           var0.field2322[var34 - 1] = var0.field2322[var34 - 2];
                           var0.field2322[var34 - 2] = var0.field2322[var34 - 3];
                           var0.field2322[var34 - 3] = var0.field2322[var34 - 4];
                        }

                        while(var33 > 0) {
                           var0.field2322[var30 + var33] = var0.field2322[var30 + var33 - 1];
                           --var33;
                        }

                        var0.field2322[var30] = var1;
                     } else {
                        int var31 = var33 / 16;
                        int var32 = var33 % 16;
                        var30 = var0.field2323[var31] + var32;

                        for(var1 = var0.field2322[var30]; var30 > var0.field2323[var31]; --var30) {
                           var0.field2322[var30] = var0.field2322[var30 - 1];
                        }

                        ++var0.field2323[var31];

                        while(var31 > 0) {
                           --var0.field2323[var31];
                           var0.field2322[var0.field2323[var31]] = var0.field2322[var0.field2323[var31 - 1] + 16 - 1];
                           --var31;
                        }

                        --var0.field2323[0];
                        var0.field2322[var0.field2323[0]] = var1;
                        if(var0.field2323[0] == 0) {
                           var56 = 4095;

                           for(var35 = 15; var35 >= 0; --var35) {
                              for(var55 = 15; var55 >= 0; --var55) {
                                 var0.field2322[var56] = var0.field2322[var0.field2323[var35] + var55];
                                 --var56;
                              }

                              var0.field2323[var35] = var56 + 1;
                           }
                        }
                     }

                     ++var0.field2315[var0.field2321[var1 & 255] & 255];
                     class25.field215[var47] = var0.field2321[var1 & 255] & 255;
                     ++var47;
                     if(var45 == 0) {
                        ++var43;
                        var45 = 50;
                        var54 = var0.field2324[var43];
                        var22 = var0.field2330[var54];
                        var23 = var0.field2301[var54];
                        var25 = var0.field2329[var54];
                        var24 = var0.field2297[var54];
                     }

                     --var45;
                     var51 = var22;

                     for(var52 = method3490(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                        ++var51;
                        var53 = method3493(var0);
                     }

                     var46 = var25[var52 - var24[var51]];
                  } else {
                     int var48 = -1;
                     int var49 = 1;

                     do {
                        if(var46 == 0) {
                           var48 += var49;
                        } else if(var46 == 1) {
                           var48 += var49 * 2;
                        }

                        var49 *= 2;
                        if(var45 == 0) {
                           ++var43;
                           var45 = 50;
                           var54 = var0.field2324[var43];
                           var22 = var0.field2330[var54];
                           var23 = var0.field2301[var54];
                           var25 = var0.field2329[var54];
                           var24 = var0.field2297[var54];
                        }

                        --var45;
                        var51 = var22;

                        for(var52 = method3490(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                           ++var51;
                           var53 = method3493(var0);
                        }

                        var46 = var25[var52 - var24[var51]];
                     } while(var46 == 0 || var46 == 1);

                     ++var48;
                     var1 = var0.field2321[var0.field2322[var0.field2323[0]] & 255];

                     for(var0.field2315[var1 & 255] += var48; var48 > 0; --var48) {
                        class25.field215[var47] = var1 & 255;
                        ++var47;
                     }
                  }
               }

               var0.field2308 = 0;
               var0.field2307 = 0;
               var0.field2317[0] = 0;

               for(var36 = 1; var36 <= 256; var36++) {
                  var0.field2317[var36] = var0.field2315[var36 - 1];
               }

               for(var36 = 1; var36 <= 256; var36++) {
                  var0.field2317[var36] += var0.field2317[var36 - 1];
               }

               for(var36 = 0; var36 < var47; var36++) {
                  var1 = (byte)(class25.field215[var36] & 255);
                  class25.field215[var0.field2317[var1 & 255]] |= var36 << 8;
                  ++var0.field2317[var1 & 255];
               }

               var0.field2304 = class25.field215[var0.field2312] >> 8;
               var0.field2325 = 0;
               var0.field2304 = class25.field215[var0.field2304];
               var0.field2314 = (byte)(var0.field2304 & 255);
               var0.field2304 >>= 8;
               ++var0.field2325;
               var0.field2331 = var47;
               method3500(var0);
               if(var0.field2331 + 1 == var0.field2325 && var0.field2308 == 0) {
                  var26 = true;
                  break;
               }

               var26 = false;
               break;
            }
         }

         return;
      }
   }

   static byte method3492(class181 var0) {
      return (byte)method3490(8, var0);
   }

   static int method3490(int var0, class181 var1) {
      while(var1.field2316 < var0) {
         var1.field2309 = var1.field2309 << 8 | var1.field2294[var1.field2326] & 255;
         var1.field2316 += 8;
         ++var1.field2326;
         ++var1.field2302;
         if(var1.field2302 == 0) {
            ;
         }
      }

      int var3 = var1.field2309 >> var1.field2316 - var0 & (1 << var0) - 1;
      var1.field2316 -= var0;
      return var3;
   }

   static byte method3493(class181 var0) {
      return (byte)method3490(1, var0);
   }

   static void method3494(class181 var0) {
      var0.field2318 = 0;

      for(int var1 = 0; var1 < 256; var1++) {
         if(var0.field2319[var1]) {
            var0.field2321[var0.field2318] = (byte)var1;
            ++var0.field2318;
         }
      }

   }

   static void method3495(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
      int var7 = 0;

      int var8;
      for(var8 = var4; var8 <= var5; var8++) {
         for(int var9 = 0; var9 < var6; var9++) {
            if(var8 == var3[var9]) {
               var2[var7] = var9;
               ++var7;
            }
         }
      }

      for(var8 = 0; var8 < 23; var8++) {
         var1[var8] = 0;
      }

      for(var8 = 0; var8 < var6; var8++) {
         ++var1[var3[var8] + 1];
      }

      for(var8 = 1; var8 < 23; var8++) {
         var1[var8] += var1[var8 - 1];
      }

      for(var8 = 0; var8 < 23; var8++) {
         var0[var8] = 0;
      }

      int var10 = 0;

      for(var8 = var4; var8 <= var5; var8++) {
         var10 += var1[var8 + 1] - var1[var8];
         var0[var8] = var10 - 1;
         var10 <<= 1;
      }

      for(var8 = var4 + 1; var8 <= var5; var8++) {
         var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
      }

   }

   static void method3500(class181 var0) {
      byte var2 = var0.field2307;
      int var3 = var0.field2308;
      int var4 = var0.field2325;
      int var5 = var0.field2314;
      int[] var6 = class25.field215;
      int var7 = var0.field2304;
      byte[] var8 = var0.field2305;
      int var9 = var0.field2313;
      int var10 = var0.field2310;
      int var12 = var0.field2331 + 1;

      label65:
      while(true) {
         if(var3 > 0) {
            while(true) {
               if(var10 == 0) {
                  break label65;
               }

               if(var3 == 1) {
                  if(var10 == 0) {
                     var3 = 1;
                     break label65;
                  }

                  var8[var9] = var2;
                  ++var9;
                  --var10;
                  break;
               }

               var8[var9] = var2;
               --var3;
               ++var9;
               --var10;
            }
         }

         boolean var14 = true;

         byte var1;
         while(var14) {
            var14 = false;
            if(var4 == var12) {
               var3 = 0;
               break label65;
            }

            var2 = (byte)var5;
            var7 = var6[var7];
            var1 = (byte)(var7 & 255);
            var7 >>= 8;
            ++var4;
            if(var1 != var5) {
               var5 = var1;
               if(var10 == 0) {
                  var3 = 1;
                  break label65;
               }

               var8[var9] = var2;
               ++var9;
               --var10;
               var14 = true;
            } else if(var4 == var12) {
               if(var10 == 0) {
                  var3 = 1;
                  break label65;
               }

               var8[var9] = var2;
               ++var9;
               --var10;
               var14 = true;
            }
         }

         var3 = 2;
         var7 = var6[var7];
         var1 = (byte)(var7 & 255);
         var7 >>= 8;
         ++var4;
         if(var4 != var12) {
            if(var1 != var5) {
               var5 = var1;
            } else {
               var3 = 3;
               var7 = var6[var7];
               var1 = (byte)(var7 & 255);
               var7 >>= 8;
               ++var4;
               if(var4 != var12) {
                  if(var1 != var5) {
                     var5 = var1;
                  } else {
                     var7 = var6[var7];
                     var1 = (byte)(var7 & 255);
                     var7 >>= 8;
                     ++var4;
                     var3 = (var1 & 255) + 4;
                     var7 = var6[var7];
                     var5 = (byte)(var7 & 255);
                     var7 >>= 8;
                     ++var4;
                  }
               }
            }
         }
      }

      int var13 = var0.field2295;
      var0.field2295 += var10 - var10;
      if(var0.field2295 < var13) {
         ;
      }

      var0.field2307 = var2;
      var0.field2308 = var3;
      var0.field2325 = var4;
      var0.field2314 = var5;
      class25.field215 = var6;
      var0.field2304 = var7;
      var0.field2305 = var8;
      var0.field2313 = var9;
      var0.field2310 = var10;
   }
}
