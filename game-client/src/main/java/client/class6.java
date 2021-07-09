package client;

import java.util.Comparator;

final class class6 implements Comparator {
   static int field39;
   public static int field37;
   static final int field36 = 5;
   static final int field38 = -306674912;

   int method66(class2 var1, class2 var2, int var3) {
      return var1.method16(1845946507).compareTo(var2.method16(1867825088));
   }

   public int compare(Object var1, Object var2) {
      return this.method66((class2)var1, (class2)var2, -1297295614);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   static int method69(int var0, int var1, int var2) {
      class272 var3 = class1.method15(var0, (byte)-58);
      if(var3 == null) {
         return var1;
      } else if(var3.field3528 >= 0) {
         return var3.field3528 | -16777216;
      } else {
         int var4;
         int var5;
         byte var6;
         int var8;
         if(var3.field3526 >= 0) {
            var5 = class122.field1667.vmethod3092(var3.field3526, 2017103535);
            var6 = 96;
            if(var5 == -2) {
               var4 = 12345678;
            } else if(var5 == -1) {
               if(var6 < 0) {
                  var6 = 0;
               } else if(var6 > 127) {
                  var6 = 127;
               }

               var8 = 127 - var6;
               var4 = var8;
            } else {
               var8 = var6 * (var5 & 127) / 128;
               if(var8 < 2) {
                  var8 = 2;
               } else if(var8 > 126) {
                  var8 = 126;
               }

               var4 = var8 + (var5 & 65408);
            }

            return class122.field1675[var4] | -16777216;
         } else if(var3.field3533 == 16711935) {
            return var1;
         } else {
            var4 = class260.method4908(var3.field3525, var3.field3530, var3.field3531, -30984690);
            var6 = 96;
            if(var4 == -2) {
               var5 = 12345678;
            } else if(var4 == -1) {
               if(var6 < 0) {
                  var6 = 0;
               } else if(var6 > 127) {
                  var6 = 127;
               }

               var8 = 127 - var6;
               var5 = var8;
            } else {
               var8 = var6 * (var4 & 127) / 128;
               if(var8 < 2) {
                  var8 = 2;
               } else if(var8 > 126) {
                  var8 = 126;
               }

               var5 = var8 + (var4 & 65408);
            }

            return class122.field1675[var5] | -16777216;
         }
      }
   }

   static String method71(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   static void method73(PacketBuffer var0, int var1, int var2) {
      boolean var10000;
      if(var0.readBits(1) == 1) {
         if(var2 <= -5435097) {
            return;
         }

         var10000 = true;
      } else {
         var10000 = false;
      }

      boolean var3 = var10000;
      if(var3) {
         class81.field1166[++class81.field1165 - 1] = var1;
      }

      int var4 = var0.readBits(2);
      Player var5 = GameClient.field610[var1];
      if(var4 == 0) {
         if(var3) {
            var5.field571 = false;
         } else if(GameClient.field628 == var1) {
            throw new RuntimeException();
         } else {
            class81.field1162[var1] = (var5.field567 << 28) + (class62.baseX + var5.field922[0] >> 13 << 14) + (GameClient.baseY + var5.field872[0] >> 13);
            if(var5.field920 != -1) {
               class81.field1163[var1] = var5.field920;
            } else {
               class81.field1163[var1] = var5.field926;
            }

            class81.field1164[var1] = var5.field897;
            GameClient.field610[var1] = null;
            if(var0.readBits(1) != 0) {
               class240.method4601(var0, var1, 894901822);
            }

         }
      } else {
         int var6;
         int var7;
         int var8;
         if(var4 == 1) {
            var6 = var0.readBits(3);
            var7 = var5.field922[0];
            var8 = var5.field872[0];
            if(var6 == 0) {
               if(var2 <= -5435097) {
                  return;
               }

               --var7;
               --var8;
            } else if(var6 == 1) {
               --var8;
            } else if(var6 == 2) {
               ++var7;
               --var8;
            } else if(var6 == 3) {
               --var7;
            } else if(var6 == 4) {
               ++var7;
            } else if(var6 == 5) {
               --var7;
               ++var8;
            } else if(var6 == 6) {
               if(var2 <= -5435097) {
                  return;
               }

               ++var8;
            } else if(var6 == 7) {
               ++var7;
               ++var8;
            }

            label369: {
               if(GameClient.field628 == var1) {
                  if(var5.field931 < 1536 || var5.field881 < 1536) {
                     break label369;
                  }

                  if(var2 <= -5435097) {
                     return;
                  }

                  if(var5.field931 >= 11776 || var5.field881 >= 11776) {
                     break label369;
                  }
               }

               if(var3) {
                  var5.field571 = true;
                  var5.field572 = var7;
                  var5.field573 = var8;
               } else {
                  var5.field571 = false;
                  var5.method1106(var7, var8, class81.field1153[var1], -1440413395);
               }

               return;
            }

            var5.method1103(var7, var8, 1740968643);
            var5.field571 = false;
         } else if(var4 == 2) {
            var6 = var0.readBits(4);
            var7 = var5.field922[0];
            var8 = var5.field872[0];
            if(var6 == 0) {
               if(var2 <= -5435097) {
                  return;
               }

               var7 -= 2;
               var8 -= 2;
            } else if(var6 == 1) {
               --var7;
               var8 -= 2;
            } else if(var6 == 2) {
               var8 -= 2;
            } else if(var6 == 3) {
               ++var7;
               var8 -= 2;
            } else if(var6 == 4) {
               var7 += 2;
               var8 -= 2;
            } else if(var6 == 5) {
               var7 -= 2;
               --var8;
            } else if(var6 == 6) {
               var7 += 2;
               --var8;
            } else if(var6 == 7) {
               var7 -= 2;
            } else if(var6 == 8) {
               var7 += 2;
            } else if(var6 == 9) {
               var7 -= 2;
               ++var8;
            } else if(var6 == 10) {
               var7 += 2;
               ++var8;
            } else if(var6 == 11) {
               if(var2 <= -5435097) {
                  return;
               }

               var7 -= 2;
               var8 += 2;
            } else if(var6 == 12) {
               if(var2 <= -5435097) {
                  return;
               }

               --var7;
               var8 += 2;
            } else if(var6 == 13) {
               var8 += 2;
            } else if(var6 == 14) {
               ++var7;
               var8 += 2;
            } else if(var6 == 15) {
               var7 += 2;
               var8 += 2;
            }

            label371: {
               if(GameClient.field628 == var1) {
                  if(var5.field931 < 1536 || var5.field881 < 1536 || var5.field931 >= 11776) {
                     break label371;
                  }

                  if(var2 <= -5435097) {
                     return;
                  }

                  if(var5.field881 >= 11776) {
                     break label371;
                  }
               }

               if(var3) {
                  if(var2 <= -5435097) {
                     return;
                  }

                  var5.field571 = true;
                  var5.field572 = var7;
                  var5.field573 = var8;
               } else {
                  var5.field571 = false;
                  var5.method1106(var7, var8, class81.field1153[var1], -1440413395);
               }

               return;
            }

            var5.method1103(var7, var8, 2009698616);
            var5.field571 = false;
         } else {
            var6 = var0.readBits(1);
            int var9;
            int var10;
            int var11;
            int var12;
            if(var6 == 0) {
               var7 = var0.readBits(12);
               var8 = var7 >> 10;
               var9 = var7 >> 5 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var7 & 31;
               if(var10 > 15) {
                  var10 -= 32;
               }

               label321: {
                  label320: {
                     var11 = var9 + var5.field922[0];
                     var12 = var10 + var5.field872[0];
                     if(GameClient.field628 == var1) {
                        if(var5.field931 < 1536 || var5.field881 < 1536 || var5.field931 >= 11776) {
                           break label320;
                        }

                        if(var2 <= -5435097) {
                           return;
                        }

                        if(var5.field881 >= 11776) {
                           break label320;
                        }
                     }

                     if(var3) {
                        if(var2 <= -5435097) {
                           return;
                        }

                        var5.field571 = true;
                        var5.field572 = var11;
                        var5.field573 = var12;
                     } else {
                        var5.field571 = false;
                        var5.method1106(var11, var12, class81.field1153[var1], -1440413395);
                     }
                     break label321;
                  }

                  var5.method1103(var11, var12, -2047838538);
                  var5.field571 = false;
               }

               var5.field567 = (byte)(var8 + var5.field567 & 3);
               if(GameClient.field628 == var1) {
                  if(var2 <= -5435097) {
                     return;
                  }

                  class13.field82 = var5.field567;
               }

            } else {
               label341: {
                  label340: {
                     var7 = var0.readBits(30);
                     var8 = var7 >> 28;
                     var9 = var7 >> 14 & 16383;
                     var10 = var7 & 16383;
                     var11 = (var9 + class62.baseX + var5.field922[0] & 16383) - class62.baseX;
                     var12 = (var10 + GameClient.baseY + var5.field872[0] & 16383) - GameClient.baseY;
                     if(GameClient.field628 == var1) {
                        if(var5.field931 < 1536) {
                           break label340;
                        }

                        if(var2 <= -5435097) {
                           return;
                        }

                        if(var5.field881 < 1536 || var5.field931 >= 11776) {
                           break label340;
                        }

                        if(var2 <= -5435097) {
                           return;
                        }

                        if(var5.field881 >= 11776) {
                           break label340;
                        }
                     }

                     if(var3) {
                        if(var2 <= -5435097) {
                           return;
                        }

                        var5.field571 = true;
                        var5.field572 = var11;
                        var5.field573 = var12;
                     } else {
                        var5.field571 = false;
                        var5.method1106(var11, var12, class81.field1153[var1], -1440413395);
                     }
                     break label341;
                  }

                  var5.method1103(var11, var12, -1344916432);
                  var5.field571 = false;
               }

               var5.field567 = (byte)(var8 + var5.field567 & 3);
               if(GameClient.field628 == var1) {
                  class13.field82 = var5.field567;
               }

            }
         }
      }
   }

   static void method75(int var0) {
      for(class68 var1 = (class68)class68.field985.method4098(); var1 != null; var1 = (class68)class68.field985.method4079()) {
         if(var0 == -874246990) {
            return;
         }

         if(var1.field994 != null) {
            var1.method1688((byte)-10);
         }
      }

   }

   static int method74(int var0, class84 var1, boolean var2, int var3) {
      if(var0 == 5306) {
         int[] var4 = class69.field999;
         int var5 = ++class69.field1003 - 1;
         int var6 = GameClient.field792 ? 2 : 1;
         var4[var5] = var6;
         return 1;
      } else {
         int var7;
         if(var0 == 5307) {
            var7 = class69.field999[--class69.field1003];
            if(var7 == 1 || var7 == 2) {
               class50.method991(var7, (byte)-89);
            }

            return 1;
         } else if(var0 == 5308) {
            class69.field999[++class69.field1003 - 1] = class10.field61.field957;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var7 = class69.field999[--class69.field1003];
            if(var7 == 1 || var7 == 2) {
               class10.field61.field957 = var7;
               class54.method1018(247890781);
            }

            return 1;
         }
      }
   }
}
