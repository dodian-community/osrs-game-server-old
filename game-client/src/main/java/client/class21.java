package client;

public final class class21 {
   public static class251 field175;
   static class249 field179;
   static final int field174 = 2;
   public static final int field176 = 81;
   static final int field177 = 4096;
   static final int field180 = 88;
   final int[] field178 = new int[4096];

   final int method272(int var1, int var2, byte var3) {
      return this.field178[var1 * 64 + var2];
   }

   final void method265(class32 var1, byte var2) {
      for(int var3 = 0; var3 < 64; var3++) {
         for(int var4 = 0; var4 < 64; var4++) {
            this.field178[var3 * 64 + var4] = var1.method547(var3, var4, (byte)1) | -16777216;
         }
      }

   }

   static final void method270(int var0, int var1) {
      if(!class261.method4931(var0, (byte)75)) {
         if(var1 != 1295176232) {
            ;
         }
      } else {
         class245.method4620(Widget.LOADED[var0], -1, -2000374394);
      }
   }

   static final void method271(String var0, int var1) {
      StringBuilder var10000 = (new StringBuilder()).append(var0);
      Object var10001 = null;
      String var2 = var10000.append(" is already on your ignore list").toString();
      class143.method3172(30, "", var2);
   }

   public static class256 method275(int var0, int var1) {
      class256 var2 = (class256)class256.field3257.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class256.field3258.method4625(19, var0, 2144038113);
         var2 = new class256();
         if(var3 != null) {
            var2.method4848(new Stream(var3), 2142685495);
         }

         class256.field3257.method3983(var2, (long)var0);
         return var2;
      }
   }

   public static Sprite[] method279(class247 var0, String var1, String var2, int var3) {
      int var4 = var0.method4642(var1, -544751145);
      int var5 = var0.method4643(var4, var2, -981702486);
      Sprite[] var6;
      if(!class306.method5660(var0, var4, var5, -1104652703)) {
         var6 = null;
      } else {
         Sprite[] var8 = new Sprite[class319.field3802];

         for(int var9 = 0; var9 < class319.field3802; var9++) {
            Sprite var10 = var8[var9] = new Sprite();
            var10.maxWidth = class305.field3729;
            var10.maxHeight = class319.field3798;
            var10.offsetX = class7.field45[var9];
            var10.offsetY = class225.field2562[var9];
            var10.width = class319.field3800[var9];
            var10.height = class319.field3799[var9];
            int var11 = var10.height * var10.width;
            byte[] var12 = class319.field3801[var9];
            var10.pixels = new int[var11];

            for(int var13 = 0; var13 < var11; var13++) {
               var10.pixels[var13] = class172.field2260[var12[var13] & 255];
            }
         }

         class7.field45 = null;
         class225.field2562 = null;
         class319.field3800 = null;
         class319.field3799 = null;
         class172.field2260 = null;
         class319.field3801 = null;
         var6 = var8;
      }

      return var6;
   }

   static PaletteSprite[] method278(class247 var0, int var1, int var2, int var3) {
      return !class306.method5660(var0, var1, var2, -2078007692) ? null : class49.method950(2064294997);
   }

   static final boolean method273(int var0, int var1, int var2, class166 var3, class164 var4, byte var5) {
      int var6 = var0;
      int var7 = var1;
      byte var8 = 64;
      byte var9 = 64;
      int var10 = var0 - var8;
      int var11 = var1 - var9;
      class165.field2035[var8][var9] = 99;
      class165.field2041[var8][var9] = 0;
      byte var12 = 0;
      int var13 = 0;
      class165.field2039[var12] = var0;
      int var21 = var12 + 1;
      class165.field2038[var12] = var1;
      int[][] var14 = var4.field2029;

      while(true) {
         label313:
         while(true) {
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            do {
               do {
                  do {
                     label290:
                     do {
                        if(var13 == var21) {
                           class19.field152 = var6;
                           class165.field2037 = var7;
                           return false;
                        }

                        var6 = class165.field2039[var13];
                        var7 = class165.field2038[var13];
                        var13 = var13 + 1 & 4095;
                        var19 = var6 - var10;
                        var20 = var7 - var11;
                        var15 = var6 - var4.field2025;
                        var16 = var7 - var4.field2026;
                        if(var3.vmethod3440(var2, var6, var7, var4, (byte)-20)) {
                           class19.field152 = var6;
                           class165.field2037 = var7;
                           return true;
                        }

                        var17 = class165.field2041[var19][var20] + 1;
                        if(var19 > 0 && class165.field2035[var19 - 1][var20] == 0 && (var14[var15 - 1][var16] & 19136782) == 0 && (var14[var15 - 1][var16 + var2 - 1] & 19136824) == 0) {
                           var18 = 1;

                           while(true) {
                              if(var18 >= var2 - 1) {
                                 class165.field2039[var21] = var6 - 1;
                                 class165.field2038[var21] = var7;
                                 var21 = var21 + 1 & 4095;
                                 class165.field2035[var19 - 1][var20] = 2;
                                 class165.field2041[var19 - 1][var20] = var17;
                                 break;
                              }

                              if((var14[var15 - 1][var18 + var16] & 19136830) != 0) {
                                 break;
                              }

                              ++var18;
                           }
                        }

                        if(var19 < 128 - var2 && class165.field2035[var19 + 1][var20] == 0 && (var14[var15 + var2][var16] & 19136899) == 0 && (var14[var15 + var2][var16 + var2 - 1] & 19136992) == 0) {
                           var18 = 1;

                           while(true) {
                              if(var18 >= var2 - 1) {
                                 class165.field2039[var21] = var6 + 1;
                                 class165.field2038[var21] = var7;
                                 var21 = var21 + 1 & 4095;
                                 class165.field2035[var19 + 1][var20] = 8;
                                 class165.field2041[var19 + 1][var20] = var17;
                                 break;
                              }

                              if((var14[var15 + var2][var16 + var18] & 19136995) != 0) {
                                 break;
                              }

                              ++var18;
                           }
                        }

                        if(var20 > 0 && class165.field2035[var19][var20 - 1] == 0 && (var14[var15][var16 - 1] & 19136782) == 0 && (var14[var15 + var2 - 1][var16 - 1] & 19136899) == 0) {
                           var18 = 1;

                           while(true) {
                              if(var18 >= var2 - 1) {
                                 class165.field2039[var21] = var6;
                                 class165.field2038[var21] = var7 - 1;
                                 var21 = var21 + 1 & 4095;
                                 class165.field2035[var19][var20 - 1] = 1;
                                 class165.field2041[var19][var20 - 1] = var17;
                                 break;
                              }

                              if((var14[var15 + var18][var16 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var18;
                           }
                        }

                        if(var20 < 128 - var2 && class165.field2035[var19][var20 + 1] == 0 && (var14[var15][var16 + var2] & 19136824) == 0 && (var14[var15 + var2 - 1][var16 + var2] & 19136992) == 0) {
                           var18 = 1;

                           while(true) {
                              if(var18 >= var2 - 1) {
                                 class165.field2039[var21] = var6;
                                 class165.field2038[var21] = var7 + 1;
                                 var21 = var21 + 1 & 4095;
                                 class165.field2035[var19][var20 + 1] = 4;
                                 class165.field2041[var19][var20 + 1] = var17;
                                 break;
                              }

                              if((var14[var18 + var15][var16 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var18;
                           }
                        }

                        if(var19 > 0 && var20 > 0 && class165.field2035[var19 - 1][var20 - 1] == 0 && (var14[var15 - 1][var16 - 1] & 19136782) == 0) {
                           var18 = 1;

                           while(true) {
                              if(var18 >= var2) {
                                 class165.field2039[var21] = var6 - 1;
                                 class165.field2038[var21] = var7 - 1;
                                 var21 = var21 + 1 & 4095;
                                 class165.field2035[var19 - 1][var20 - 1] = 3;
                                 class165.field2041[var19 - 1][var20 - 1] = var17;
                                 break;
                              }

                              if((var14[var15 - 1][var18 + (var16 - 1)] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var18;
                           }
                        }

                        if(var19 < 128 - var2 && var20 > 0 && class165.field2035[var19 + 1][var20 - 1] == 0 && (var14[var15 + var2][var16 - 1] & 19136899) == 0) {
                           var18 = 1;

                           while(true) {
                              if(var18 >= var2) {
                                 class165.field2039[var21] = var6 + 1;
                                 class165.field2038[var21] = var7 - 1;
                                 var21 = var21 + 1 & 4095;
                                 class165.field2035[var19 + 1][var20 - 1] = 9;
                                 class165.field2041[var19 + 1][var20 - 1] = var17;
                                 break;
                              }

                              if((var14[var15 + var2][var18 + (var16 - 1)] & 19136995) != 0 || (var14[var15 + var18][var16 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var18;
                           }
                        }

                        if(var19 > 0 && var20 < 128 - var2 && class165.field2035[var19 - 1][var20 + 1] == 0 && (var14[var15 - 1][var16 + var2] & 19136824) == 0) {
                           for(var18 = 1; var18 < var2; var18++) {
                              if((var14[var15 - 1][var18 + var16] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 + var2] & 19137016) != 0) {
                                 continue label290;
                              }
                           }

                           class165.field2039[var21] = var6 - 1;
                           class165.field2038[var21] = var7 + 1;
                           var21 = var21 + 1 & 4095;
                           class165.field2035[var19 - 1][var20 + 1] = 6;
                           class165.field2041[var19 - 1][var20 + 1] = var17;
                        }
                     } while(var19 >= 128 - var2);
                  } while(var20 >= 128 - var2);
               } while(class165.field2035[var19 + 1][var20 + 1] != 0);
            } while((var14[var15 + var2][var16 + var2] & 19136992) != 0);

            for(var18 = 1; var18 < var2; var18++) {
               if((var14[var18 + var15][var16 + var2] & 19137016) != 0 || (var14[var15 + var2][var16 + var18] & 19136995) != 0) {
                  continue label313;
               }
            }

            class165.field2039[var21] = var6 + 1;
            class165.field2038[var21] = var7 + 1;
            var21 = var21 + 1 & 4095;
            class165.field2035[var19 + 1][var20 + 1] = 12;
            class165.field2041[var19 + 1][var20 + 1] = var17;
         }
      }
   }

   public static final Sprite method276(int var0, int var1, int var2, int var3, int var4, boolean var5, int var6) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var7 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0;
      Sprite var9;
      if(!var5) {
         var9 = (Sprite) ItemDef.field3429.method3989(var7);
         if(var9 != null) {
            return var9;
         }
      }

      ItemDef var10 = ItemDef.loadItemDef(var0);
      if(var1 > 1 && var10.countObj != null) {
         int var11 = -1;

         for(int var12 = 0; var12 < 10; var12++) {
            if(var1 >= var10.countCo[var12] && var10.countCo[var12] != 0) {
               var11 = var10.countObj[var12];
            }
         }

         if(var11 != -1) {
            var10 = ItemDef.loadItemDef(var11);
         }
      }

      class119 var22 = var10.method5093(1, -281078736);
      if(var22 == null) {
         return null;
      } else {
         Sprite var23 = null;
         if(var10.notedTemplate != -1) {
            var23 = method276(var10.notedID, 10, 1, 0, 0, true, 1462036944);
            if(var23 == null) {
               return null;
            }
         } else if(var10.op140 != -1) {
            var23 = method276(var10.int639, var1, var2, var3, 0, false, 1326050254);
            if(var23 == null) {
               return null;
            }
         } else if(var10.int638 != -1) {
            var23 = method276(var10.int641, var1, 0, 0, 0, false, 1729087377);
            if(var23 == null) {
               return null;
            }
         }

         int[] var13 = Rasterizer2D.field3766;
         int var14 = Rasterizer2D.field3761;
         int var15 = Rasterizer2D.field3762;
         int[] var16 = new int[4];
         Rasterizer2D.method5722(var16);
         var9 = new Sprite(36, 32);
         Rasterizer2D.method5718(var9.pixels, 36, 32);
         Rasterizer2D.method5724();
         class122.method2862();
         class122.method2827(16, 16);
         class122.field1670 = false;
         if(var10.int638 != -1) {
            var23.method5851(0, 0);
         }

         int var17 = var10.zoom2d;
         if(var5) {
            var17 = (int)(1.5D * (double)var17);
         } else if(var2 == 2) {
            var17 = (int)((double)var17 * 1.04D);
         }

         int var18 = var17 * class122.field1681[var10.xan2d] >> 16;
         int var19 = var17 * class122.field1693[var10.xan2d] >> 16;
         var22.method2670();
         var22.method2682(0, var10.yan2d, var10.zan2d, var10.xan2d, var10.xof2d, var22.field1781 / 2 + var18 + var10.yof2d, var19 + var10.yof2d);
         if(var10.op140 != -1) {
            var23.method5851(0, 0);
         }

         if(var2 >= 1) {
            var9.method5847(1);
         }

         if(var2 >= 2) {
            var9.method5847(16777215);
         }

         if(var3 != 0) {
            var9.method5848(var3);
         }

         Rasterizer2D.method5718(var9.pixels, 36, 32);
         if(var10.notedTemplate != -1) {
            var23.method5851(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var10.stackable == 1) {
            class298 var20 = ItemDef.field3466;
            String var21;
            if(var1 < 100000) {
               var21 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var21 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var21 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var20.method5522(var21, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemDef.field3429.method3983(var9, var7);
         }

         Rasterizer2D.method5718(var13, var14, var15);
         Rasterizer2D.method5723(var16);
         class122.method2862();
         class122.field1670 = true;
         return var9;
      }
   }

   public static void method277(class247 var0, int var1) {
      class272.field3529 = var0;
   }

   static int method274(int var0, class84 var1, boolean var2, int var3) {
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = Widget.getLoaded(class69.field999[--class69.field1003]);
      } else {
         var4 = var2 ? class276.field3561 : class260.field3301;
      }

      int var5;
      if(var0 == 1300) {
         var5 = class69.field999[--class69.field1003] - 1;
         if(var5 >= 0 && var5 <= 9) {
            String option = class69.field1001[--class55.field497];
            var4.method4512(var5, option);
            InterfaceEdits.optionSet(var4, var5, option);

            if (class69.field1001[class55.field497].equals("Buy 10")) {
               var4.regularOptions = new String[] {"Value", "Buy 1", "Buy 5", "Buy 10", "Buy 50", "Buy X"};
            } else if (class69.field1001[class55.field497].contains("Take")) {
               var4.regularOptions = new String[] {"Value", "Buy 1", "Buy 5", "Buy 10", "Buy 50", "Buy X"};
            }

            return 1;
         } else {
            --class55.field497;
            return 1;
         }
      } else if(var0 == 1301) {
         class69.field1003 -= 2;
         var5 = class69.field999[class69.field1003];
         int var6 = class69.field999[class69.field1003 + 1];
         var4.field2666 = class146.method3191(var5, var6, -1494207735);
         return 1;
      } else if(var0 == 1302) {
         --class69.field1003;
         var4.bool47 = class69.field999[class69.field1003] == 1;
         return 1;
      } else if(var0 == 1303) {
         var4.int489 = class69.field999[--class69.field1003];
         return 1;
      } else if(var0 == 1304) {
         var4.int490 = class69.field999[--class69.field1003];
         return 1;
      } else if(var0 == 1305) {
         var4.string29 = class69.field1001[--class55.field497];
         ShopInterface.updateItem(var4);
         return 1;
      } else if(var0 == 1306) {
         var4.selectedActionName = class69.field1001[--class55.field497];
         return 1;
      } else if(var0 == 1307) {
         var4.regularOptions = null;
         return 1;
      } else {
         return 2;
      }
   }

   static Widget method264(Widget var0, int var1) {
      Widget var3 = var0;
      int var4 = Isaac.method3865(class24.method425(var0, (byte)-1), (short)-10278);
      Widget var2;
      if(var4 == 0) {
         var2 = null;
      } else {
         int var5 = 0;

         while(true) {
            if(var5 >= var4) {
               var2 = var3;
               break;
            }

            var3 = Widget.getLoaded(var3.parentHash);
            if(var3 == null) {
               var2 = null;
               break;
            }

            ++var5;
         }
      }

      Widget var6 = var2;
      if(var2 == null) {
         var6 = var0.field2666;
      }

      return var6;
   }
}
