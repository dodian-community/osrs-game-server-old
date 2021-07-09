package client;

public class class64 extends class204 {
   static int[] field936;
   int field934;
   int field935;
   int field938;
   int field937;

   class64(int var1, int var2, int var3, int var4) {
      this.field934 = var1;
      this.field935 = var2;
      this.field938 = var3;
      this.field937 = var4;
   }

   void method1559(int var1, int var2, int var3, int var4, int var5) {
      this.field934 = var1;
      this.field935 = var2;
      this.field938 = var3;
      this.field937 = var4;
   }

   static void method1563(Widget var0, int var1, int var2, boolean var3, int var4) {
      int var5 = var0.int472;
      int var6 = var0.int466;
      if(var0.widthAlignment == 0) {
         var0.int472 = var0.width;
      } else if(var0.widthAlignment == 1) {
         var0.int472 = var1 - var0.width;
      } else if(var0.widthAlignment == 2) {
         var0.int472 = var0.width * var1 >> 14;
      }

      if(var0.heightAlignment == 0) {
         var0.int466 = var0.height;
      } else if(var0.heightAlignment == 1) {
         var0.int466 = var2 - var0.height;
      } else if(var0.heightAlignment == 2) {
         var0.int466 = var2 * var0.height >> 14;
      }

      if(var0.widthAlignment == 4) {
         var0.int472 = var0.int466 * var0.field2622 / var0.field2623;
      }

      if(var0.heightAlignment == 4) {
         if(var4 == 879198266) {
            return;
         }

         var0.int466 = var0.field2623 * var0.int472 / var0.field2622;
      }

      if(var0.interactType == 1337) {
         GameClient.field784 = var0;
      }

      if(var3) {
         if(var4 == 879198266) {
            return;
         }

         if(var0.field2715 != null) {
            if(var5 == var0.int472) {
               if(var6 == var0.int466) {
                  return;
               }

               if(var4 == 879198266) {
                  return;
               }
            }

            ScriptInvocation var7 = new ScriptInvocation();
            var7.field506 = var0;
            var7.parameters = var0.field2715;
            GameClient.field638.method4073(var7);
         }
      }

   }

   static void method1560(byte var0) {
      class224.field2554 = new int[2000];
      int var1 = 0;
      int var2 = 240;

      int var4;
      for(byte var3 = 12; var1 < 16; var2 -= var3) {
         var4 = class143.method3167((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)(0.075F + (float)var1 * 0.425F / 16.0F));
         class224.field2554[var1] = var4;
         ++var1;
      }

      var2 = 48;

      for(int var6 = var2 / 6; var1 < class224.field2554.length; var2 -= var6) {
         var4 = var1 * 2;

         for(int var5 = class143.method3167((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < class224.field2554.length; var1++) {
            class224.field2554[var1] = var5;
         }
      }

   }

   static int method1558(int var0, class84 var1, boolean var2, byte var3) {
      int var4;
      if(var0 == 6600) {
         var4 = class13.field82;
         int var14 = (class138.field1876.field931 >> 7) + class62.baseX;
         int var6 = (class138.field1876.field881 >> 7) + GameClient.baseY;
         class18.method196(-948375195).method6011(var4, var14, var6, true, -1742033741);
         return 1;
      } else {
         class20 var16;
         if(var0 == 6601) {
            var4 = class69.field999[--class69.field1003];
            String var21 = "";
            var16 = class18.method196(851435447).method6029(var4, -1585158345);
            if(var16 != null) {
               var21 = var16.method210(-1948906738);
            }

            class69.field1001[++class55.field497 - 1] = var21;
            return 1;
         } else if(var0 == 6602) {
            var4 = class69.field999[--class69.field1003];
            class18.method196(-616211435).method6012(var4, 914816910);
            return 1;
         } else if(var0 == 6603) {
            class69.field999[++class69.field1003 - 1] = class18.method196(-1451047097).method6026(1802681801);
            return 1;
         } else if(var0 == 6604) {
            var4 = class69.field999[--class69.field1003];
            class18.method196(-1836622118).method6023(var4, (short)-26743);
            return 1;
         } else if(var0 == 6605) {
            class69.field999[++class69.field1003 - 1] = class18.method196(2121774911).method6096(1729229911) ? 1 : 0;
            return 1;
         } else {
            class226 var20;
            if(var0 == 6606) {
               var20 = new class226(class69.field999[--class69.field1003]);
               class18.method196(-791952177).method6054(var20.field2564, var20.field2565, (byte)-123);
               return 1;
            } else if(var0 == 6607) {
               var20 = new class226(class69.field999[--class69.field1003]);
               class18.method196(-456454414).method6031(var20.field2564, var20.field2565, (byte)65);
               return 1;
            } else if(var0 == 6608) {
               var20 = new class226(class69.field999[--class69.field1003]);
               class18.method196(-55775886).method6046(var20.field2567, var20.field2564, var20.field2565, 469904059);
               return 1;
            } else if(var0 == 6609) {
               var20 = new class226(class69.field999[--class69.field1003]);
               class18.method196(31915298).method6033(var20.field2567, var20.field2564, var20.field2565, (byte)96);
               return 1;
            } else if(var0 == 6610) {
               class69.field999[++class69.field1003 - 1] = class18.method196(-1357279749).method6002(1656428330);
               class69.field999[++class69.field1003 - 1] = class18.method196(1392896461).method6035(1934425663);
               return 1;
            } else {
               class20 var18;
               if(var0 == 6611) {
                  var4 = class69.field999[--class69.field1003];
                  var18 = class18.method196(42219427).method6029(var4, -1883031836);
                  if(var18 == null) {
                     class69.field999[++class69.field1003 - 1] = 0;
                  } else {
                     class69.field999[++class69.field1003 - 1] = var18.method256(-1421911827).method4437(1942535969);
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var4 = class69.field999[--class69.field1003];
                  var18 = class18.method196(-1594905347).method6029(var4, 1517634927);
                  if(var18 == null) {
                     class69.field999[++class69.field1003 - 1] = 0;
                     class69.field999[++class69.field1003 - 1] = 0;
                  } else {
                     class69.field999[++class69.field1003 - 1] = (var18.method214(-2125416250) - var18.method258(76487241) + 1) * 64;
                     class69.field999[++class69.field1003 - 1] = (var18.method249(255269420) - var18.method247(689798512) + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var4 = class69.field999[--class69.field1003];
                  var18 = class18.method196(-1113394439).method6029(var4, -336571404);
                  if(var18 == null) {
                     class69.field999[++class69.field1003 - 1] = 0;
                     class69.field999[++class69.field1003 - 1] = 0;
                     class69.field999[++class69.field1003 - 1] = 0;
                     class69.field999[++class69.field1003 - 1] = 0;
                  } else {
                     class69.field999[++class69.field1003 - 1] = var18.method258(1385071556) * 64;
                     class69.field999[++class69.field1003 - 1] = var18.method247(72325038) * 64;
                     class69.field999[++class69.field1003 - 1] = var18.method214(-331547917) * 64 + 64 - 1;
                     class69.field999[++class69.field1003 - 1] = var18.method249(-1887053866) * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var4 = class69.field999[--class69.field1003];
                  var18 = class18.method196(-2103352678).method6029(var4, 1407472893);
                  if(var18 == null) {
                     class69.field999[++class69.field1003 - 1] = -1;
                  } else {
                     class69.field999[++class69.field1003 - 1] = var18.method212((byte)124);
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var20 = class18.method196(646660146).method6001(1824829427);
                  if(var20 == null) {
                     class69.field999[++class69.field1003 - 1] = -1;
                     class69.field999[++class69.field1003 - 1] = -1;
                  } else {
                     class69.field999[++class69.field1003 - 1] = var20.field2564;
                     class69.field999[++class69.field1003 - 1] = var20.field2565;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class69.field999[++class69.field1003 - 1] = class18.method196(1775020856).method6153(-1089700319);
                  return 1;
               } else if(var0 == 6617) {
                  var20 = new class226(class69.field999[--class69.field1003]);
                  var18 = class18.method196(-1452553095).method6014((byte)7);
                  if(var18 == null) {
                     class69.field999[++class69.field1003 - 1] = -1;
                     class69.field999[++class69.field1003 - 1] = -1;
                     return 1;
                  } else {
                     int[] var19 = var18.method213(var20.field2567, var20.field2564, var20.field2565, (byte)-4);
                     if(var19 == null) {
                        class69.field999[++class69.field1003 - 1] = -1;
                        class69.field999[++class69.field1003 - 1] = -1;
                     } else {
                        class69.field999[++class69.field1003 - 1] = var19[0];
                        class69.field999[++class69.field1003 - 1] = var19[1];
                     }

                     return 1;
                  }
               } else {
                  class226 var12;
                  if(var0 == 6618) {
                     var20 = new class226(class69.field999[--class69.field1003]);
                     var18 = class18.method196(-2078791189).method6014((byte)7);
                     if(var18 == null) {
                        class69.field999[++class69.field1003 - 1] = -1;
                        class69.field999[++class69.field1003 - 1] = -1;
                        return 1;
                     } else {
                        var12 = var18.method205(var20.field2564, var20.field2565, -2056689977);
                        if(var12 == null) {
                           class69.field999[++class69.field1003 - 1] = -1;
                        } else {
                           class69.field999[++class69.field1003 - 1] = var12.method4437(1947705579);
                        }

                        return 1;
                     }
                  } else {
                     int var7;
                     int var8;
                     int var9;
                     class226 var10;
                     class226 var17;
                     if(var0 == 6619) {
                        class69.field1003 -= 2;
                        var4 = class69.field999[class69.field1003];
                        var17 = new class226(class69.field999[class69.field1003 + 1]);
                        var16 = class18.method196(787098680).method6029(var4, 1450961529);
                        var7 = class138.field1876.field567;
                        var8 = (class138.field1876.field931 >> 7) + class62.baseX;
                        var9 = (class138.field1876.field881 >> 7) + GameClient.baseY;
                        var10 = new class226(var7, var8, var9);
                        class18.method196(-287830256).method6073(var16, var10, var17, false, (byte)64);
                        return 1;
                     } else if(var0 == 6620) {
                        class69.field1003 -= 2;
                        var4 = class69.field999[class69.field1003];
                        var17 = new class226(class69.field999[class69.field1003 + 1]);
                        var16 = class18.method196(-700454282).method6029(var4, -1957979131);
                        var7 = class138.field1876.field567;
                        var8 = (class138.field1876.field931 >> 7) + class62.baseX;
                        var9 = (class138.field1876.field881 >> 7) + GameClient.baseY;
                        var10 = new class226(var7, var8, var9);
                        class18.method196(764575779).method6073(var16, var10, var17, true, (byte)-123);
                        return 1;
                     } else if(var0 == 6621) {
                        class69.field1003 -= 2;
                        var4 = class69.field999[class69.field1003];
                        var17 = new class226(class69.field999[class69.field1003 + 1]);
                        var16 = class18.method196(-342409957).method6029(var4, -1161957462);
                        if(var16 == null) {
                           class69.field999[++class69.field1003 - 1] = 0;
                           return 1;
                        } else {
                           class69.field999[++class69.field1003 - 1] = var16.method202(var17.field2567, var17.field2564, var17.field2565, (byte)8) ? 1 : 0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class69.field999[++class69.field1003 - 1] = class18.method196(-1290752882).method6142((byte)49);
                        class69.field999[++class69.field1003 - 1] = class18.method196(-656626110).method6038(-1074547942);
                        return 1;
                     } else if(var0 == 6623) {
                        var20 = new class226(class69.field999[--class69.field1003]);
                        var18 = class18.method196(-1778753674).method6116(var20.field2567, var20.field2564, var20.field2565, (short)-31690);
                        if(var18 == null) {
                           class69.field999[++class69.field1003 - 1] = -1;
                        } else {
                           class69.field999[++class69.field1003 - 1] = var18.method207((byte)-31);
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        class18.method196(994052752).method6089(class69.field999[--class69.field1003], (byte)-27);
                        return 1;
                     } else if(var0 == 6625) {
                        class18.method196(168222350).method6040((byte)-95);
                        return 1;
                     } else if(var0 == 6626) {
                        class18.method196(1324606585).method6041(class69.field999[--class69.field1003], (byte)-85);
                        return 1;
                     } else if(var0 == 6627) {
                        class18.method196(-1968511515).method6042((byte)0);
                        return 1;
                     } else {
                        boolean var15;
                        if(var0 == 6628) {
                           --class69.field1003;
                           var15 = class69.field999[class69.field1003] == 1;
                           class18.method196(-362808162).method6034(var15, 1525183262);
                           return 1;
                        } else if(var0 == 6629) {
                           var4 = class69.field999[--class69.field1003];
                           class18.method196(953716921).method6106(var4, -2131592771);
                           return 1;
                        } else if(var0 == 6630) {
                           var4 = class69.field999[--class69.field1003];
                           class18.method196(-17834228).method6152(var4, 778543526);
                           return 1;
                        } else if(var0 == 6631) {
                           class18.method196(-1900734).method6114((byte)120);
                           return 1;
                        } else if(var0 == 6632) {
                           --class69.field1003;
                           var15 = class69.field999[class69.field1003] == 1;
                           class18.method196(216794524).method6047(var15, -1268087883);
                           return 1;
                        } else {
                           boolean var5;
                           if(var0 == 6633) {
                              class69.field1003 -= 2;
                              var4 = class69.field999[class69.field1003];
                              var5 = class69.field999[class69.field1003 + 1] == 1;
                              class18.method196(-1293645431).method6048(var4, var5, (byte)64);
                              return 1;
                           } else if(var0 == 6634) {
                              class69.field1003 -= 2;
                              var4 = class69.field999[class69.field1003];
                              var5 = class69.field999[class69.field1003 + 1] == 1;
                              class18.method196(2120273720).method6049(var4, var5, 2092620528);
                              return 1;
                           } else if(var0 == 6635) {
                              class69.field999[++class69.field1003 - 1] = class18.method196(1495486257).method6050(432395832) ? 1 : 0;
                              return 1;
                           } else if(var0 == 6636) {
                              var4 = class69.field999[--class69.field1003];
                              class69.field999[++class69.field1003 - 1] = class18.method196(402365488).method6051(var4, (byte)21) ? 1 : 0;
                              return 1;
                           } else if(var0 == 6637) {
                              var4 = class69.field999[--class69.field1003];
                              class69.field999[++class69.field1003 - 1] = class18.method196(-102960053).method6052(var4, 1955762729) ? 1 : 0;
                              return 1;
                           } else if(var0 == 6638) {
                              class69.field1003 -= 2;
                              var4 = class69.field999[class69.field1003];
                              var17 = new class226(class69.field999[class69.field1003 + 1]);
                              var12 = class18.method196(-1829019766).method6100(var4, var17, 1593225606);
                              if(var12 == null) {
                                 class69.field999[++class69.field1003 - 1] = -1;
                              } else {
                                 class69.field999[++class69.field1003 - 1] = var12.method4437(2010194281);
                              }

                              return 1;
                           } else {
                              class28 var13;
                              if(var0 == 6639) {
                                 var13 = class18.method196(-476095709).method6146((short)32070);
                                 if(var13 == null) {
                                    class69.field999[++class69.field1003 - 1] = -1;
                                    class69.field999[++class69.field1003 - 1] = -1;
                                 } else {
                                    class69.field999[++class69.field1003 - 1] = var13.field240;
                                    class69.field999[++class69.field1003 - 1] = var13.field236.method4437(1876129321);
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var13 = class18.method196(1171715409).method6186((byte)-46);
                                 if(var13 == null) {
                                    class69.field999[++class69.field1003 - 1] = -1;
                                    class69.field999[++class69.field1003 - 1] = -1;
                                 } else {
                                    class69.field999[++class69.field1003 - 1] = var13.field240;
                                    class69.field999[++class69.field1003 - 1] = var13.field236.method4437(2046576712);
                                 }

                                 return 1;
                              } else {
                                 class255 var11;
                                 if(var0 == 6693) {
                                    var4 = class69.field999[--class69.field1003];
                                    var11 = class255.field3246[var4];
                                    if(var11.field3241 == null) {
                                       class69.field1001[++class55.field497 - 1] = "";
                                    } else {
                                       class69.field1001[++class55.field497 - 1] = var11.field3241;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var4 = class69.field999[--class69.field1003];
                                    var11 = class255.field3246[var4];
                                    class69.field999[++class69.field1003 - 1] = var11.field3243;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var4 = class69.field999[--class69.field1003];
                                    var11 = class255.field3246[var4];
                                    if(var11 == null) {
                                       class69.field999[++class69.field1003 - 1] = -1;
                                    } else {
                                       class69.field999[++class69.field1003 - 1] = var11.field3240;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var4 = class69.field999[--class69.field1003];
                                    var11 = class255.field3246[var4];
                                    if(var11 == null) {
                                       class69.field999[++class69.field1003 - 1] = -1;
                                    } else {
                                       class69.field999[++class69.field1003 - 1] = var11.field3239;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class69.field999[++class69.field1003 - 1] = class312.field3750.field307;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class69.field999[++class69.field1003 - 1] = class312.field3750.field311.method4437(2084786481);
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class69.field999[++class69.field1003 - 1] = class312.field3750.field308.method4437(1970050828);
                                    return 1;
                                 } else {
                                    return 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
