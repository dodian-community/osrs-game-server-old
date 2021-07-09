package client;

public class class262 {
   static final int field3319 = 3;

   static final void method4939(int var0, int var1, int var2, int var3, int var4, int var5, int var6, class125 var7, class164 var8, short var9) {
      ObjectDef var10 = class110.getObjectDef(var4);
      int var11;
      int var12;
      if(var5 != 1 && var5 != 3) {
         var11 = var10.int693;
         var12 = var10.int688;
      } else {
         var11 = var10.int688;
         var12 = var10.int693;
      }

      int var13;
      int var14;
      if(var11 + var2 <= 104) {
         var13 = (var11 >> 1) + var2;
         var14 = var2 + (var11 + 1 >> 1);
      } else {
         var13 = var2;
         var14 = var2 + 1;
      }

      int var15;
      int var16;
      if(var3 + var12 <= 104) {
         var15 = var3 + (var12 >> 1);
         var16 = var3 + (var12 + 1 >> 1);
      } else {
         var15 = var3;
         var16 = var3 + 1;
      }

      int[][] var17 = class50.field459[var1];
      int var18 = var17[var13][var16] + var17[var13][var15] + var17[var14][var15] + var17[var14][var16] >> 2;
      int var19 = (var2 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + (var12 << 6);
      long var21 = class76.method1804(var2, var3, 2, var10.int696 == 0, var4, 1736607490);
      int var23 = (var5 << 6) + var6;
      if(var10.int706 == 1) {
         var23 += 256;
      }

      Object var24;
      if(var6 == 22) {
         if(var9 > 128) {
            if(var10.int697 == -1 && var10.intArray116 == null) {
               var24 = var10.method5031(22, var5, var17, var19, var18, var20, (byte)33);
            } else {
               var24 = new class85(var4, 22, var5, var1, var2, var3, var10.int697, true, (class127)null);
            }

            var7.method3009(var0, var2, var3, var18, (class127)var24, var21, var23);
            if(var10.clipType == 1) {
               var8.method3410(var2, var3, (byte)90);
            }

         }
      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var10.int697 == -1 && var10.intArray116 == null) {
               var24 = var10.method5031(var6, var5, var17, var19, var18, var20, (byte)77);
            } else {
               var24 = new class85(var4, var6, var5, var1, var2, var3, var10.int697, true, (class127)null);
            }

            var7.method2882(var0, var2, var3, var18, 1, 1, (class127)var24, 0, var21, var23);
            if(var10.clipType != 0) {
               var8.method3394(var2, var3, var11, var12, var10.isUnwalkable, (byte)53);
            }

         } else if(var6 == 0) {
            if(var10.int697 == -1 && var10.intArray116 == null) {
               var24 = var10.method5031(0, var5, var17, var19, var18, var20, (byte)28);
            } else {
               var24 = new class85(var4, 0, var5, var1, var2, var3, var10.int697, true, (class127)null);
            }

            var7.method2927(var0, var2, var3, var18, (class127)var24, (class127)null, class50.field450[var5], 0, var21, var23);
            if(var10.clipType != 0) {
               var8.method3393(var2, var3, var6, var5, var10.isUnwalkable, 1523088627);
            }

         } else if(var6 == 1) {
            if(var10.int697 == -1 && var10.intArray116 == null) {
               if(var9 <= 128) {
                  return;
               }

               var24 = var10.method5031(1, var5, var17, var19, var18, var20, (byte)-51);
            } else {
               var24 = new class85(var4, 1, var5, var1, var2, var3, var10.int697, true, (class127)null);
            }

            var7.method2927(var0, var2, var3, var18, (class127)var24, (class127)null, class50.field451[var5], 0, var21, var23);
            if(var10.clipType != 0) {
               var8.method3393(var2, var3, var6, var5, var10.isUnwalkable, 1674180388);
            }

         } else {
            int var30;
            if(var6 == 2) {
               var30 = var5 + 1 & 3;
               Object var25;
               Object var26;
               if(var10.int697 == -1 && var10.intArray116 == null) {
                  var25 = var10.method5031(2, var5 + 4, var17, var19, var18, var20, (byte)28);
                  var26 = var10.method5031(2, var30, var17, var19, var18, var20, (byte)45);
               } else {
                  var25 = new class85(var4, 2, var5 + 4, var1, var2, var3, var10.int697, true, (class127)null);
                  var26 = new class85(var4, 2, var30, var1, var2, var3, var10.int697, true, (class127)null);
               }

               var7.method2927(var0, var2, var3, var18, (class127)var25, (class127)var26, class50.field450[var5], class50.field450[var30], var21, var23);
               if(var10.clipType != 0) {
                  var8.method3393(var2, var3, var6, var5, var10.isUnwalkable, 1870045328);
               }

            } else if(var6 == 3) {
               if(var9 > 128) {
                  if(var10.int697 == -1 && var10.intArray116 == null) {
                     var24 = var10.method5031(3, var5, var17, var19, var18, var20, (byte)-83);
                  } else {
                     var24 = new class85(var4, 3, var5, var1, var2, var3, var10.int697, true, (class127)null);
                  }

                  var7.method2927(var0, var2, var3, var18, (class127)var24, (class127)null, class50.field451[var5], 0, var21, var23);
                  if(var10.clipType != 0) {
                     var8.method3393(var2, var3, var6, var5, var10.isUnwalkable, 1695091731);
                  }

               }
            } else if(var6 == 9) {
               if(var10.int697 == -1 && var10.intArray116 == null) {
                  if(var9 <= 128) {
                     return;
                  }

                  var24 = var10.method5031(var6, var5, var17, var19, var18, var20, (byte)-13);
               } else {
                  var24 = new class85(var4, var6, var5, var1, var2, var3, var10.int697, true, (class127)null);
               }

               var7.method2882(var0, var2, var3, var18, 1, 1, (class127)var24, 0, var21, var23);
               if(var10.clipType != 0) {
                  var8.method3394(var2, var3, var11, var12, var10.isUnwalkable, (byte)36);
               }

            } else if(var6 == 4) {
               if(var10.int697 == -1 && var10.intArray116 == null) {
                  var24 = var10.method5031(4, var5, var17, var19, var18, var20, (byte)26);
               } else {
                  var24 = new class85(var4, 4, var5, var1, var2, var3, var10.int697, true, (class127)null);
               }

               var7.method2881(var0, var2, var3, var18, (class127)var24, (class127)null, class50.field450[var5], 0, 0, 0, var21, var23);
            } else {
               Object var27;
               long var31;
               if(var6 == 5) {
                  var30 = 16;
                  var31 = var7.method2898(var0, var2, var3);
                  if(var31 != 0L) {
                     if(var9 <= 128) {
                        return;
                     }

                     var30 = class110.getObjectDef(class39.method673(var31)).int698;
                  }

                  if(var10.int697 == -1 && var10.intArray116 == null) {
                     var27 = var10.method5031(4, var5, var17, var19, var18, var20, (byte)29);
                  } else {
                     var27 = new class85(var4, 4, var5, var1, var2, var3, var10.int697, true, (class127)null);
                  }

                  var7.method2881(var0, var2, var3, var18, (class127)var27, (class127)null, class50.field450[var5], 0, var30 * class50.field452[var5], var30 * class50.field453[var5], var21, var23);
               } else if(var6 == 6) {
                  var30 = 8;
                  var31 = var7.method2898(var0, var2, var3);
                  if(var31 != 0L) {
                     var30 = class110.getObjectDef(class39.method673(var31)).int698 / 2;
                  }

                  if(var10.int697 == -1 && var10.intArray116 == null) {
                     if(var9 <= 128) {
                        return;
                     }

                     var27 = var10.method5031(4, var5 + 4, var17, var19, var18, var20, (byte)-17);
                  } else {
                     var27 = new class85(var4, 4, var5 + 4, var1, var2, var3, var10.int697, true, (class127)null);
                  }

                  var7.method2881(var0, var2, var3, var18, (class127)var27, (class127)null, 256, var5, var30 * class50.field458[var5], var30 * class50.field449[var5], var21, var23);
               } else if(var6 == 7) {
                  int var33 = var5 + 2 & 3;
                  if(var10.int697 == -1 && var10.intArray116 == null) {
                     var24 = var10.method5031(4, var33 + 4, var17, var19, var18, var20, (byte)105);
                  } else {
                     var24 = new class85(var4, 4, var33 + 4, var1, var2, var3, var10.int697, true, (class127)null);
                  }

                  var7.method2881(var0, var2, var3, var18, (class127)var24, (class127)null, 256, var33, 0, 0, var21, var23);
               } else if(var6 == 8) {
                  if(var9 > 128) {
                     var30 = 8;
                     var31 = var7.method2898(var0, var2, var3);
                     if(var31 != 0L) {
                        var30 = class110.getObjectDef(class39.method673(var31)).int698 / 2;
                     }

                     Object var28;
                     label308: {
                        int var29 = var5 + 2 & 3;
                        if(var10.int697 == -1) {
                           if(var9 <= 128) {
                              return;
                           }

                           if(var10.intArray116 == null) {
                              var27 = var10.method5031(4, var5 + 4, var17, var19, var18, var20, (byte)-18);
                              var28 = var10.method5031(4, var29 + 4, var17, var19, var18, var20, (byte)-48);
                              break label308;
                           }
                        }

                        var27 = new class85(var4, 4, var5 + 4, var1, var2, var3, var10.int697, true, (class127)null);
                        var28 = new class85(var4, 4, var29 + 4, var1, var2, var3, var10.int697, true, (class127)null);
                     }

                     var7.method2881(var0, var2, var3, var18, (class127)var27, (class127)var28, 256, var5, var30 * class50.field458[var5], var30 * class50.field449[var5], var21, var23);
                  }
               }
            }
         }
      } else {
         if(var10.int697 == -1 && var10.intArray116 == null) {
            var24 = var10.method5031(10, var5, var17, var19, var18, var20, (byte)-11);
         } else {
            var24 = new class85(var4, 10, var5, var1, var2, var3, var10.int697, true, (class127)null);
         }

         if(var24 != null) {
            var7.method2882(var0, var2, var3, var18, var11, var12, (class127)var24, var6 == 11 ? 256 : 0, var21, var23);
         }

         if(var10.clipType != 0) {
            var8.method3394(var2, var3, var11, var12, var10.isUnwalkable, (byte)84);
         }

      }
   }
}
