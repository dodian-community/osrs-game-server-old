package client;

public class class173 {
   public static final int field2261 = 4096;
   static final int field2262 = 2;

   static void method3472(int var0, String var1, String var2, String var3, int var4) {
      class86 var5 = (class86)class83.field1180.get(var0);
      if(var5 == null) {
         if(var4 >= 1962086287) {
            return;
         }

         var5 = new class86();
         class83.field1180.put(var0, var5);
      }

      class58 var6 = var5.method1964(var0, var1, var2, var3, (byte)55);
      class83.field1181.method3944(var6, (long)var6.field540);
      class83.field1184.method4155(var6);
      GameClient.field770 = GameClient.field801;
   }

   static final void method3473(Widget var0, int var1, int var2, int var3, short var4) {
      class54.method1017(2107196590);
      class224 var5 = var0.method4517(false, -957474508);
      if(var5 == null) {
         if(var4 < 1024) {
            ;
         }
      } else {
         Rasterizer2D.method5720(var1, var2, var5.field2553 + var1, var2 + var5.field2549);
         if(GameClient.field810 != 2 && GameClient.field810 != 5) {
            if(var4 >= 1024) {
               return;
            }

            int var6 = GameClient.field717 & 2047;
            int var7 = class138.field1876.field931 / 32 + 48;
            int var8 = 464 - class138.field1876.field881 / 32;
            Npc.field1038.method5845(var1, var2, var5.field2553, var5.field2549, var7, var8, var6, 256, var5.field2551, var5.field2550);

            int var9;
            int var10;
            int var11;
            for(var9 = 0; var9 < GameClient.mapIconCount; var9++) {
               var10 = GameClient.mapIconTileX[var9] * 4 + 2 - class138.field1876.field931 / 32;
               var11 = GameClient.mapIconTileY[var9] * 4 + 2 - class138.field1876.field881 / 32;
               class55.method1022(var1, var2, var10, var11, GameClient.mapIconImages[var9], var5, (byte)103);
            }

            int var12;
            int var13;
            for(var9 = 0; var9 < 104; var9++) {
               if(var4 >= 1024) {
                  return;
               }

               for(var10 = 0; var10 < 104; var10++) {
                  class205 var16 = GameClient.field708[class13.field82][var9][var10];
                  if(var16 != null) {
                     var12 = var9 * 4 + 2 - class138.field1876.field931 / 32;
                     var13 = var10 * 4 + 2 - class138.field1876.field881 / 32;
                     class55.method1022(var1, var2, var12, var13, class36.field314[0], var5, (byte)35);
                  }
               }
            }

            for(var9 = 0; var9 < GameClient.field622; var9++) {
               Npc var17 = GameClient.field843[GameClient.field639[var9]];
               if(var17 != null && var17.vmethod1786((byte)5)) {
                  NpcDef var19 = var17.definition;
                  if(var19 != null) {
                     if(var4 >= 1024) {
                        return;
                     }

                     if(var19.intArray106 != null) {
                        var19 = var19.method5189();
                     }
                  }

                  if(var19 != null && var19.bool59 && var19.bool61) {
                     var12 = var17.field931 / 32 - class138.field1876.field931 / 32;
                     var13 = var17.field881 / 32 - class138.field1876.field881 / 32;
                     class55.method1022(var1, var2, var12, var13, class36.field314[1], var5, (byte)72);
                  }
               }
            }

            var9 = class81.field1167;
            int[] var20 = class81.field1159;

            for(var11 = 0; var11 < var9; var11++) {
               if(var4 >= 1024) {
                  return;
               }

               Player var18 = GameClient.field610[var20[var11]];
               if(var18 != null && var18.vmethod1786((byte)5) && !var18.hidden) {
                  if(var4 >= 1024) {
                     return;
                  }

                  if(var18 != class138.field1876) {
                     var13 = var18.field931 / 32 - class138.field1876.field931 / 32;
                     int var14 = var18.field881 / 32 - class138.field1876.field881 / 32;
                     boolean var15 = false;
                     if(class138.field1876.field568 != 0 && var18.field568 != 0 && var18.field568 == class138.field1876.field568) {
                        if(var4 >= 1024) {
                           return;
                        }

                        var15 = true;
                     }

                     if(var18.method1083(-514053088)) {
                        class55.method1022(var1, var2, var13, var14, class36.field314[3], var5, (byte)119);
                     } else if(var15) {
                        class55.method1022(var1, var2, var13, var14, class36.field314[4], var5, (byte)8);
                     } else if(var18.method1104(-1597718431)) {
                        class55.method1022(var1, var2, var13, var14, class36.field314[5], var5, (byte)74);
                     } else {
                        class55.method1022(var1, var2, var13, var14, class36.field314[2], var5, (byte)127);
                     }
                  }
               }
            }

            if(GameClient.field599 != 0 && GameClient.field591 % 20 < 10) {
               if(GameClient.field599 == 1 && GameClient.field600 >= 0 && GameClient.field600 < GameClient.field843.length) {
                  Npc var21 = GameClient.field843[GameClient.field600];
                  if(var21 != null) {
                     var12 = var21.field931 / 32 - class138.field1876.field931 / 32;
                     var13 = var21.field881 / 32 - class138.field1876.field881 / 32;
                     class121.method2783(var1, var2, var12, var13, class111.field1446[1], var5, 606939264);
                  }
               }

               if(GameClient.field599 == 2) {
                  var11 = GameClient.field602 * 4 - class62.baseX * 4 + 2 - class138.field1876.field931 / 32;
                  var12 = GameClient.field818 * 4 - GameClient.baseY * 4 + 2 - class138.field1876.field881 / 32;
                  class121.method2783(var1, var2, var11, var12, class111.field1446[1], var5, 606939264);
               }

               if(GameClient.field599 == 10 && GameClient.field579 >= 0 && GameClient.field579 < GameClient.field610.length) {
                  Player var22 = GameClient.field610[GameClient.field579];
                  if(var22 != null) {
                     var12 = var22.field931 / 32 - class138.field1876.field931 / 32;
                     var13 = var22.field881 / 32 - class138.field1876.field881 / 32;
                     class121.method2783(var1, var2, var12, var13, class111.field1446[1], var5, 606939264);
                  }
               }
            }

            if(GameClient.field808 != 0) {
               var11 = GameClient.field808 * 4 + 2 - class138.field1876.field931 / 32;
               var12 = GameClient.field809 * 4 + 2 - class138.field1876.field881 / 32;
               class55.method1022(var1, var2, var11, var12, class111.field1446[0], var5, (byte)11);
            }

            if(!class138.field1876.hidden) {
               Rasterizer2D.method5763(var5.field2553 / 2 + var1 - 1, var5.field2549 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5742(var1, var2, 0, var5.field2551, var5.field2550);
         }

         GameClient.field788[var3] = true;
      }
   }

   static void method3471(class273 var0, int var1, int var2, int var3, int var4) {
      if(GameClient.field656 < 50 && GameClient.field815 != 0) {
         if(var0.field3543 != null && var1 < var0.field3543.length) {
            int var5 = var0.field3543[var1];
            if(var5 == 0) {
               if(var4 > -811671669) {
                  ;
               }
            } else {
               int var6 = var5 >> 8;
               int var7 = var5 >> 4 & 7;
               int var8 = var5 & 15;
               GameClient.field817[GameClient.field656] = var6;
               GameClient.field676[GameClient.field656] = var7;
               GameClient.field819[GameClient.field656] = 0;
               GameClient.field719[GameClient.field656] = null;
               int var9 = (var2 - 64) / 128;
               int var10 = (var3 - 64) / 128;
               GameClient.field820[GameClient.field656] = var8 + (var10 << 8) + (var9 << 16);
               ++GameClient.field656;
            }
         }
      }
   }

   static int method3469(int var0, class84 var1, boolean var2, int var3) {
      if(var0 == 3300) {
         class69.field999[++class69.field1003 - 1] = GameClient.field591;
         return 1;
      } else {
         int var4;
         int var5;
         if(var0 == 3301) {
            class69.field1003 -= 2;
            var4 = class69.field999[class69.field1003];
            var5 = class69.field999[class69.field1003 + 1];
            class69.field999[++class69.field1003 - 1] = Widget.method4559(var4, var5, 1566108753);
            return 1;
         } else {
            int[] var6;
            int var7;
            int var8;
            class53 var9;
            if(var0 == 3302) {
               class69.field1003 -= 2;
               var4 = class69.field999[class69.field1003];
               var5 = class69.field999[class69.field1003 + 1];
               var6 = class69.field999;
               var7 = ++class69.field1003 - 1;
               var9 = (class53)class53.field474.get((long)var4);
               if(var9 == null) {
                  var8 = 0;
               } else if(var5 >= 0 && var5 < var9.field473.length) {
                  var8 = var9.field473[var5];
               } else {
                  var8 = 0;
               }

               var6[var7] = var8;
               return 1;
            } else if(var0 == 3303) {
               class69.field1003 -= 2;
               var4 = class69.field999[class69.field1003];
               var5 = class69.field999[class69.field1003 + 1];
               class69.field999[++class69.field1003 - 1] = class139.method3143(var4, var5, -1945605014);
               return 1;
            } else if(var0 == 3304) {
               var4 = class69.field999[--class69.field1003];
               class69.field999[++class69.field1003 - 1] = class130.method3074(var4, 1311567042).field3227;
               return 1;
            } else if(var0 == 3305) {
               var4 = class69.field999[--class69.field1003];
               class69.field999[++class69.field1003 - 1] = GameClient.field712[var4];
               return 1;
            } else if(var0 == 3306) {
               var4 = class69.field999[--class69.field1003];
               class69.field999[++class69.field1003 - 1] = GameClient.field713[var4];
               return 1;
            } else if(var0 == 3307) {
               var4 = class69.field999[--class69.field1003];
               class69.field999[++class69.field1003 - 1] = GameClient.field640[var4];
               return 1;
            } else {
               int var10;
               if(var0 == 3308) {
                  var4 = class13.field82;
                  var5 = (class138.field1876.field931 >> 7) + class62.baseX;
                  var10 = (class138.field1876.field881 >> 7) + GameClient.baseY;
                  class69.field999[++class69.field1003 - 1] = (var5 << 14) + var10 + (var4 << 28);
                  return 1;
               } else if(var0 == 3309) {
                  var4 = class69.field999[--class69.field1003];
                  class69.field999[++class69.field1003 - 1] = var4 >> 14 & 16383;
                  return 1;
               } else if(var0 == 3310) {
                  var4 = class69.field999[--class69.field1003];
                  class69.field999[++class69.field1003 - 1] = var4 >> 28;
                  return 1;
               } else if(var0 == 3311) {
                  var4 = class69.field999[--class69.field1003];
                  class69.field999[++class69.field1003 - 1] = var4 & 16383;
                  return 1;
               } else if(var0 == 3312) {
                  class69.field999[++class69.field1003 - 1] = GameClient.field668 ? 1 : 0;
                  return 1;
               } else if(var0 == 3313) {
                  class69.field1003 -= 2;
                  var4 = class69.field999[class69.field1003] + 32768;
                  var5 = class69.field999[class69.field1003 + 1];
                  class69.field999[++class69.field1003 - 1] = Widget.method4559(var4, var5, 1566108753);
                  return 1;
               } else if(var0 != 3314) {
                  if(var0 == 3315) {
                     class69.field1003 -= 2;
                     var4 = class69.field999[class69.field1003] + 32768;
                     var5 = class69.field999[class69.field1003 + 1];
                     class69.field999[++class69.field1003 - 1] = class139.method3143(var4, var5, -1945605014);
                     return 1;
                  } else if(var0 == 3316) {
                     if(GameClient.field747 >= 2) {
                        class69.field999[++class69.field1003 - 1] = GameClient.field747;
                     } else {
                        class69.field999[++class69.field1003 - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3317) {
                     class69.field999[++class69.field1003 - 1] = GameClient.field598;
                     return 1;
                  } else if(var0 == 3318) {
                     class69.field999[++class69.field1003 - 1] = GameClient.field581;
                     return 1;
                  } else if(var0 == 3321) {
                     class69.field999[++class69.field1003 - 1] = GameClient.field745;
                     return 1;
                  } else if(var0 == 3322) {
                     class69.field999[++class69.field1003 - 1] = GameClient.field782;
                     return 1;
                  } else if(var0 == 3323) {
                     if(GameClient.field776) {
                        class69.field999[++class69.field1003 - 1] = 1;
                     } else {
                        class69.field999[++class69.field1003 - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3324) {
                     class69.field999[++class69.field1003 - 1] = GameClient.field632;
                     return 1;
                  } else if(var0 == 3325) {
                     class69.field1003 -= 4;
                     var4 = class69.field999[class69.field1003];
                     var5 = class69.field999[class69.field1003 + 1];
                     var10 = class69.field999[class69.field1003 + 2];
                     var7 = class69.field999[class69.field1003 + 3];
                     var4 += var5 << 14;
                     var4 += var10 << 28;
                     var4 += var7;
                     class69.field999[++class69.field1003 - 1] = var4;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  class69.field1003 -= 2;
                  var4 = class69.field999[class69.field1003] + 32768;
                  var5 = class69.field999[class69.field1003 + 1];
                  var6 = class69.field999;
                  var7 = ++class69.field1003 - 1;
                  var9 = (class53)class53.field474.get((long)var4);
                  if(var9 == null) {
                     var8 = 0;
                  } else if(var5 >= 0 && var5 < var9.field473.length) {
                     var8 = var9.field473[var5];
                  } else {
                     var8 = 0;
                  }

                  var6[var7] = var8;
                  return 1;
               }
            }
         }
      }
   }

   static boolean method3470(int var0, byte var1) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
