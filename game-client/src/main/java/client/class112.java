package client;

public final class class112 {
   static class244 field1455;
   static final int field1453 = 31;
   static final int field1457 = 55;
   public static final int field1458 = 9;
   class127 field1447;
   int field1448;
   int field1449;
   int field1450;
   long field1456;
   class127 field1451;
   class127 field1452;
   int field1454;

   static final void method2564(int var0, int var1) {
      if(var0 >= 0) {
         int var2 = GameClient.field718[var0];
         int var3 = GameClient.field851[var0];
         int var4 = GameClient.field720[var0];
         int var5 = GameClient.field794[var0];
         String var6 = GameClient.field735[var0];
         String var7 = GameClient.field740[var0];
         PacketBuilder.buildPacket(var2, var3, var4, var5, var7, class48.field432, class48.field428, (byte)44);
      }
   }

   public static int method2566(int var0, int var1, int var2, class166 var3, class164 var4, boolean var5, int[] var6, int[] var7, int var8) {
      int var10;
      for(int var9 = 0; var9 < 128; var9++) {
         for(var10 = 0; var10 < 128; var10++) {
            class165.field2035[var9][var10] = 0;
            class165.field2041[var9][var10] = 99999999;
         }
      }

      int var11;
      int var12;
      byte var14;
      int var15;
      int var16;
      int var18;
      int var20;
      int var21;
      int var22;
      boolean var29;
      int var31;
      int var32;
      int var34;
      if(var2 == 1) {
         var11 = var0;
         var12 = var1;
         byte var13 = 64;
         var14 = 64;
         var15 = var0 - var13;
         var16 = var1 - var14;
         class165.field2035[var13][var14] = 99;
         class165.field2041[var13][var14] = 0;
         byte var17 = 0;
         var18 = 0;
         class165.field2039[var17] = var0;
         var34 = var17 + 1;
         class165.field2038[var17] = var1;
         int[][] var19 = var4.field2029;

         boolean var30;
         while(true) {
            if(var34 == var18) {
               class19.field152 = var11;
               class165.field2037 = var12;
               var30 = false;
               break;
            }

            var11 = class165.field2039[var18];
            var12 = class165.field2038[var18];
            var18 = var18 + 1 & 4095;
            var31 = var11 - var15;
            var32 = var12 - var16;
            var20 = var11 - var4.field2025;
            var21 = var12 - var4.field2026;
            if(var3.vmethod3440(1, var11, var12, var4, (byte)27)) {
               class19.field152 = var11;
               class165.field2037 = var12;
               var30 = true;
               break;
            }

            var22 = class165.field2041[var31][var32] + 1;
            if(var31 > 0 && class165.field2035[var31 - 1][var32] == 0 && (var19[var20 - 1][var21] & 19136776) == 0) {
               class165.field2039[var34] = var11 - 1;
               class165.field2038[var34] = var12;
               var34 = var34 + 1 & 4095;
               class165.field2035[var31 - 1][var32] = 2;
               class165.field2041[var31 - 1][var32] = var22;
            }

            if(var31 < 127 && class165.field2035[var31 + 1][var32] == 0 && (var19[var20 + 1][var21] & 19136896) == 0) {
               class165.field2039[var34] = var11 + 1;
               class165.field2038[var34] = var12;
               var34 = var34 + 1 & 4095;
               class165.field2035[var31 + 1][var32] = 8;
               class165.field2041[var31 + 1][var32] = var22;
            }

            if(var32 > 0 && class165.field2035[var31][var32 - 1] == 0 && (var19[var20][var21 - 1] & 19136770) == 0) {
               class165.field2039[var34] = var11;
               class165.field2038[var34] = var12 - 1;
               var34 = var34 + 1 & 4095;
               class165.field2035[var31][var32 - 1] = 1;
               class165.field2041[var31][var32 - 1] = var22;
            }

            if(var32 < 127 && class165.field2035[var31][var32 + 1] == 0 && (var19[var20][var21 + 1] & 19136800) == 0) {
               class165.field2039[var34] = var11;
               class165.field2038[var34] = var12 + 1;
               var34 = var34 + 1 & 4095;
               class165.field2035[var31][var32 + 1] = 4;
               class165.field2041[var31][var32 + 1] = var22;
            }

            if(var31 > 0 && var32 > 0 && class165.field2035[var31 - 1][var32 - 1] == 0 && (var19[var20 - 1][var21 - 1] & 19136782) == 0 && (var19[var20 - 1][var21] & 19136776) == 0 && (var19[var20][var21 - 1] & 19136770) == 0) {
               class165.field2039[var34] = var11 - 1;
               class165.field2038[var34] = var12 - 1;
               var34 = var34 + 1 & 4095;
               class165.field2035[var31 - 1][var32 - 1] = 3;
               class165.field2041[var31 - 1][var32 - 1] = var22;
            }

            if(var31 < 127 && var32 > 0 && class165.field2035[var31 + 1][var32 - 1] == 0 && (var19[var20 + 1][var21 - 1] & 19136899) == 0 && (var19[var20 + 1][var21] & 19136896) == 0 && (var19[var20][var21 - 1] & 19136770) == 0) {
               class165.field2039[var34] = var11 + 1;
               class165.field2038[var34] = var12 - 1;
               var34 = var34 + 1 & 4095;
               class165.field2035[var31 + 1][var32 - 1] = 9;
               class165.field2041[var31 + 1][var32 - 1] = var22;
            }

            if(var31 > 0 && var32 < 127 && class165.field2035[var31 - 1][var32 + 1] == 0 && (var19[var20 - 1][var21 + 1] & 19136824) == 0 && (var19[var20 - 1][var21] & 19136776) == 0 && (var19[var20][var21 + 1] & 19136800) == 0) {
               class165.field2039[var34] = var11 - 1;
               class165.field2038[var34] = var12 + 1;
               var34 = var34 + 1 & 4095;
               class165.field2035[var31 - 1][var32 + 1] = 6;
               class165.field2041[var31 - 1][var32 + 1] = var22;
            }

            if(var31 < 127 && var32 < 127 && class165.field2035[var31 + 1][var32 + 1] == 0 && (var19[var20 + 1][var21 + 1] & 19136992) == 0 && (var19[var20 + 1][var21] & 19136896) == 0 && (var19[var20][var21 + 1] & 19136800) == 0) {
               class165.field2039[var34] = var11 + 1;
               class165.field2038[var34] = var12 + 1;
               var34 = var34 + 1 & 4095;
               class165.field2035[var31 + 1][var32 + 1] = 12;
               class165.field2041[var31 + 1][var32 + 1] = var22;
            }
         }

         var29 = var30;
      } else if(var2 == 2) {
         var29 = class40.method693(var0, var1, var3, var4, -1332801903);
      } else {
         var29 = class21.method273(var0, var1, var2, var3, var4, (byte)96);
      }

      var10 = var0 - 64;
      var11 = var1 - 64;
      var12 = class19.field152;
      var31 = class165.field2037;
      if(!var29) {
         if(!var5) {
            return -1;
         }

         var32 = Integer.MAX_VALUE;
         var15 = Integer.MAX_VALUE;
         byte var33 = 10;
         var34 = var3.field2043;
         var18 = var3.field2048;
         int var28 = var3.field2042;
         var20 = var3.field2045;

         for(var21 = var34 - var33; var21 <= var33 + var34; var21++) {
            for(var22 = var18 - var33; var22 <= var33 + var18; var22++) {
               int var23 = var21 - var10;
               int var24 = var22 - var11;
               if(var23 >= 0 && var24 >= 0 && var23 < 128 && var24 < 128 && class165.field2041[var23][var24] < 100) {
                  int var25 = 0;
                  if(var21 < var34) {
                     var25 = var34 - var21;
                  } else if(var21 > var28 + var34 - 1) {
                     var25 = var21 - (var28 + var34 - 1);
                  }

                  int var26 = 0;
                  if(var22 < var18) {
                     var26 = var18 - var22;
                  } else if(var22 > var18 + var20 - 1) {
                     var26 = var22 - (var18 + var20 - 1);
                  }

                  int var27 = var25 * var25 + var26 * var26;
                  if(var27 < var32 || var32 == var27 && class165.field2041[var23][var24] < var15) {
                     var32 = var27;
                     var15 = class165.field2041[var23][var24];
                     var12 = var21;
                     var31 = var22;
                  }
               }
            }
         }

         if(var32 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var12 && var31 == var1) {
         return 0;
      } else {
         var14 = 0;
         class165.field2039[var14] = var12;
         var32 = var14 + 1;
         class165.field2038[var14] = var31;

         for(var15 = var16 = class165.field2035[var12 - var10][var31 - var11]; var0 != var12 || var31 != var1; var15 = class165.field2035[var12 - var10][var31 - var11]) {
            if(var16 != var15) {
               var16 = var15;
               class165.field2039[var32] = var12;
               class165.field2038[var32++] = var31;
            }

            if((var15 & 2) != 0) {
               ++var12;
            } else if((var15 & 8) != 0) {
               --var12;
            }

            if((var15 & 1) != 0) {
               ++var31;
            } else if((var15 & 4) != 0) {
               --var31;
            }
         }

         var34 = 0;

         while(var32-- > 0) {
            var6[var34] = class165.field2039[var32];
            var7[var34++] = class165.field2038[var32];
            if(var34 >= var6.length) {
               break;
            }
         }

         return var34;
      }
   }

   static String method2565(Widget var0, int var1, int var2) {
      return !class97.method2214(class24.method425(var0, (byte)-2), var1, 1865447879) && var0.onClickListener == null ? null : (var0.regularOptions != null && var0.regularOptions.length > var1 && var0.regularOptions[var1] != null && var0.regularOptions[var1].trim().length() != 0 ? var0.regularOptions[var1] : null);
   }
}
