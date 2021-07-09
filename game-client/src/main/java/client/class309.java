package client;

import java.util.Comparator;

public class class309 implements Comparator {
   public static int field3740;
   final boolean field3741;

   public class309(boolean var1) {
      this.field3741 = var1;
   }

   int method5670(class282 var1, class282 var2, int var3) {
      return this.field3741 ? var1.method5287(-623000689).method5435(var2.method5287(1031495815), -1034544518) : var2.method5287(-779224997).method5435(var1.method5287(-1702457714), 295483331);
   }

   public int compare(Object var1, Object var2) {
      return this.method5670((class282)var1, (class282)var2, 870668832);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   static synchronized void method5671(byte[] var0, int var1) {
      if(var0.length == 100 && class183.field2344 < 1000) {
         class183.field2340[++class183.field2344 - 1] = var0;
      } else {
         if(var0.length == 5000) {
            if(var1 != 1705135152) {
               return;
            }

            if(class183.field2346 < 250) {
               if(var1 != 1705135152) {
                  return;
               }

               class183.field2343[++class183.field2346 - 1] = var0;
               return;
            }
         }

         if(var0.length == 30000 && class183.field2342 < 50) {
            class183.field2345[++class183.field2342 - 1] = var0;
         } else {
            if(class183.field2341 != null) {
               for(int var2 = 0; var2 < class183.field2348.length; var2++) {
                  if(var0.length == class183.field2348[var2] && class183.field2347[var2] < class183.field2341[var2].length) {
                     class183.field2341[var2][class183.field2347[var2]++] = var0;
                     return;
                  }
               }
            }

         }
      }
   }

   static void method5674(ScriptInvocation var0, int var1, int var2) {
      Object[] var3;
      boolean var10000;
      label535: {
         var3 = var0.parameters;
         int var6 = var0.field515;
         if(var6 != 10 && var6 != 11 && var6 != 12) {
            if(var2 == 2095177075) {
               return;
            }

            if(var6 != 13 && var6 != 14 && var6 != 15 && var6 != 16 && var6 != 17) {
               var10000 = false;
               break label535;
            }
         }

         var10000 = true;
      }

      boolean var5 = var10000;
      class84 var4;
      int var10;
      int var11;
      int var12;
      int var14;
      int var19;
      if(var5) {
         class312.field3750 = (class36)var3[0];
         class255 var7 = class255.field3246[class312.field3750.field307];
         int var9 = var0.field515;
         var10 = var7.field3238;
         var11 = var7.field3240;
         var12 = class17.method170(var10, var9, 1107039015);
         class84 var13 = class134.method3104(var12, var9, (byte)-10);
         class84 var8;
         if(var13 != null) {
            var8 = var13;
         } else {
            var14 = var9 + (var11 + 40000 << 8);
            var13 = class134.method3104(var14, var9, (byte)40);
            if(var13 != null) {
               var8 = var13;
            } else {
               var8 = null;
            }
         }

         var4 = var8;
      } else {
         var19 = ((Integer)var3[0]).intValue();
         var4 = class133.method3099(var19, -1297454162);
      }

      if(var4 == null) {
         if(var2 != 2095177075) {
            ;
         }
      } else {
         class69.field1003 = 0;
         class55.field497 = 0;
         var19 = -1;
         int[] var30 = var4.field1189;
         int[] var20 = var4.field1196;
         byte var31 = -1;
         class69.field1008 = 0;

         int var21;
         try {
            class69.field1005 = new int[var4.field1192];
            var11 = 0;
            class130.field1800 = new String[var4.field1193];
            var12 = 0;

            String var22;
            for(var21 = 1; var21 < var3.length; var21++) {
               if(var2 == 2095177075) {
                  return;
               }

               if(var3[var21] instanceof Integer) {
                  if(var2 == 2095177075) {
                     return;
                  }

                  var14 = ((Integer)var3[var21]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field511;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field508;
                  }

                  if(var14 == -2147483645) {
                     if(var2 == 2095177075) {
                        return;
                     }

                     var14 = var0.field506 != null ? var0.field506.interfaceHash : -1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field517;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field506 != null ? var0.field506.childId : -1;
                  }

                  if(var14 == -2147483642) {
                     var14 = var0.field507 != null ? var0.field507.interfaceHash : -1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field507 != null ? var0.field507.childId : -1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field509;
                  }

                  if(var14 == -2147483639) {
                     if(var2 == 2095177075) {
                        return;
                     }

                     var14 = var0.field513;
                  }

                  class69.field1005[var11++] = var14;
               } else if(var3[var21] instanceof String) {
                  var22 = (String)var3[var21];
                  if(var22.equals("event_opbase")) {
                     if(var2 == 2095177075) {
                        return;
                     }

                     var22 = var0.field504;
                  }

                  class130.field1800[var12++] = var22;
               }
            }

            var21 = 0;
            class69.field1009 = var0.field514;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label357:
                                                                                       while(true) {
                                                                                          ++var21;
                                                                                          if(var21 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var19;
                                                                                          var10 = var30[var19];
                                                                                          int var24;
                                                                                          if(var10 < 100) {
                                                                                             if(var10 != 0) {
                                                                                                if(var10 != 1) {
                                                                                                   if(var10 != 2) {
                                                                                                      if(var10 != 3) {
                                                                                                         if(var10 != 6) {
                                                                                                            if(var10 != 7) {
                                                                                                               if(var10 != 8) {
                                                                                                                  if(var10 != 9) {
                                                                                                                     if(var10 != 10) {
                                                                                                                        if(var10 != 21) {
                                                                                                                           if(var10 != 25) {
                                                                                                                              if(var10 != 27) {
                                                                                                                                 if(var10 != 31) {
                                                                                                                                    if(var10 != 32) {
                                                                                                                                       if(var10 != 33) {
                                                                                                                                          if(var10 != 34) {
                                                                                                                                             if(var10 != 35) {
                                                                                                                                                if(var10 != 36) {
                                                                                                                                                   if(var10 != 37) {
                                                                                                                                                      if(var10 != 38) {
                                                                                                                                                         if(var10 != 39) {
                                                                                                                                                            int var18;
                                                                                                                                                            if(var10 != 40) {
                                                                                                                                                               if(var10 != 42) {
                                                                                                                                                                  if(var10 != 43) {
                                                                                                                                                                     if(var10 == 44) {
                                                                                                                                                                        var14 = var20[var19] >> 16;
                                                                                                                                                                        var24 = var20[var19] & 65535;
                                                                                                                                                                        int var25 = class69.field999[--class69.field1003];
                                                                                                                                                                        if(var25 >= 0 && var25 <= 5000) {
                                                                                                                                                                           class69.field1000[var14] = var25;
                                                                                                                                                                           byte var26 = -1;
                                                                                                                                                                           if(var24 == 105) {
                                                                                                                                                                              if(var2 == 2095177075) {
                                                                                                                                                                                 return;
                                                                                                                                                                              }

                                                                                                                                                                              var26 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var18 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var18 >= var25) {
                                                                                                                                                                                 continue label357;
                                                                                                                                                                              }

                                                                                                                                                                              class69.field1002[var14][var18] = var26;
                                                                                                                                                                              ++var18;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var10 == 45) {
                                                                                                                                                                        var14 = var20[var19];
                                                                                                                                                                        var24 = class69.field999[--class69.field1003];
                                                                                                                                                                        if(var24 < 0 || var24 >= class69.field1000[var14]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class69.field999[++class69.field1003 - 1] = class69.field1002[var14][var24];
                                                                                                                                                                     } else if(var10 == 46) {
                                                                                                                                                                        var14 = var20[var19];
                                                                                                                                                                        class69.field1003 -= 2;
                                                                                                                                                                        var24 = class69.field999[class69.field1003];
                                                                                                                                                                        if(var24 >= 0) {
                                                                                                                                                                           if(var2 == 2095177075) {
                                                                                                                                                                              return;
                                                                                                                                                                           }

                                                                                                                                                                           if(var24 < class69.field1000[var14]) {
                                                                                                                                                                              class69.field1002[var14][var24] = class69.field999[class69.field1003 + 1];
                                                                                                                                                                              continue;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var10 == 47) {
                                                                                                                                                                        var22 = class22.field185.method1890(var20[var19], -2060094389);
                                                                                                                                                                        if(var22 == null) {
                                                                                                                                                                           var22 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class69.field1001[++class55.field497 - 1] = var22;
                                                                                                                                                                     } else if(var10 == 48) {
                                                                                                                                                                        class22.field185.method1889(var20[var19], class69.field1001[--class55.field497], 541625191);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var10 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class197 var36 = var4.field1194[var20[var19]];
                                                                                                                                                                        class211 var33 = (class211)var36.method3945((long)class69.field999[--class69.field1003]);
                                                                                                                                                                        if(var33 != null) {
                                                                                                                                                                           var19 += var33.field2438;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     if(var2 == 2095177075) {
                                                                                                                                                                        return;
                                                                                                                                                                     }

                                                                                                                                                                     class22.field185.method1903(var20[var19], class69.field999[--class69.field1003], -1213879855);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class69.field999[++class69.field1003 - 1] = class22.field185.method1897(var20[var19], (byte)82);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               if(var2 == 2095177075) {
                                                                                                                                                                  return;
                                                                                                                                                               }

                                                                                                                                                               var14 = var20[var19];
                                                                                                                                                               class84 var32 = class133.method3099(var14, -1237061696);
                                                                                                                                                               int[] var16 = new int[var32.field1192];
                                                                                                                                                               String[] var17 = new String[var32.field1193];

                                                                                                                                                               for(var18 = 0; var18 < var32.field1188; var18++) {
                                                                                                                                                                  if(var2 == 2095177075) {
                                                                                                                                                                     return;
                                                                                                                                                                  }

                                                                                                                                                                  var16[var18] = class69.field999[var18 + (class69.field1003 - var32.field1188)];
                                                                                                                                                               }

                                                                                                                                                               for(var18 = 0; var18 < var32.field1195; var18++) {
                                                                                                                                                                  if(var2 == 2095177075) {
                                                                                                                                                                     return;
                                                                                                                                                                  }

                                                                                                                                                                  var17[var18] = class69.field1001[var18 + (class55.field497 - var32.field1195)];
                                                                                                                                                               }

                                                                                                                                                               class69.field1003 -= var32.field1188;
                                                                                                                                                               class55.field497 -= var32.field1195;
                                                                                                                                                               class51 var23 = new class51();
                                                                                                                                                               var23.field466 = var4;
                                                                                                                                                               var23.field463 = var19;
                                                                                                                                                               var23.field462 = class69.field1005;
                                                                                                                                                               var23.field465 = class130.field1800;
                                                                                                                                                               class69.field1006[++class69.field1008 - 1] = var23;
                                                                                                                                                               var4 = var32;
                                                                                                                                                               var30 = var32.field1189;
                                                                                                                                                               var20 = var32.field1196;
                                                                                                                                                               var19 = -1;
                                                                                                                                                               class69.field1005 = var16;
                                                                                                                                                               class130.field1800 = var17;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class55.field497;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         if(var2 == 2095177075) {
                                                                                                                                                            return;
                                                                                                                                                         }

                                                                                                                                                         --class69.field1003;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var14 = var20[var19];
                                                                                                                                                      class55.field497 -= var14;
                                                                                                                                                      String var15 = class251.method4794(class69.field1001, class55.field497, var14, -1980014136);
                                                                                                                                                      class69.field1001[++class55.field497 - 1] = var15;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class130.field1800[var20[var19]] = class69.field1001[--class55.field497];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class69.field1001[++class55.field497 - 1] = class130.field1800[var20[var19]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class69.field1005[var20[var19]] = class69.field999[--class69.field1003];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class69.field999[++class69.field1003 - 1] = class69.field1005[var20[var19]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class69.field1003 -= 2;
                                                                                                                                       if(class69.field999[class69.field1003] >= class69.field999[class69.field1003 + 1]) {
                                                                                                                                          if(var2 == 2095177075) {
                                                                                                                                             return;
                                                                                                                                          }

                                                                                                                                          var19 += var20[var19];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class69.field1003 -= 2;
                                                                                                                                    if(class69.field999[class69.field1003] <= class69.field999[class69.field1003 + 1]) {
                                                                                                                                       var19 += var20[var19];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var14 = var20[var19];
                                                                                                                                 class67.method1685(var14, class69.field999[--class69.field1003], 1734020068);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var14 = var20[var19];
                                                                                                                              class69.field999[++class69.field1003 - 1] = class163.method3389(var14, -397804509);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class69.field1008 == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           class51 var35 = class69.field1006[--class69.field1008];
                                                                                                                           var4 = var35.field466;
                                                                                                                           var30 = var4.field1189;
                                                                                                                           var20 = var4.field1196;
                                                                                                                           var19 = var35.field463;
                                                                                                                           class69.field1005 = var35.field462;
                                                                                                                           class130.field1800 = var35.field465;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class69.field1003 -= 2;
                                                                                                                        if(class69.field999[class69.field1003] > class69.field999[class69.field1003 + 1]) {
                                                                                                                           var19 += var20[var19];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class69.field1003 -= 2;
                                                                                                                     if(class69.field999[class69.field1003] < class69.field999[class69.field1003 + 1]) {
                                                                                                                        if(var2 == 2095177075) {
                                                                                                                           return;
                                                                                                                        }

                                                                                                                        var19 += var20[var19];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class69.field1003 -= 2;
                                                                                                                  if(class69.field999[class69.field1003] == class69.field999[class69.field1003 + 1]) {
                                                                                                                     var19 += var20[var19];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class69.field1003 -= 2;
                                                                                                               if(class69.field999[class69.field1003] != class69.field999[class69.field1003 + 1]) {
                                                                                                                  var19 += var20[var19];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var19 += var20[var19];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class69.field1001[++class55.field497 - 1] = var4.field1191[var19];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var14 = var20[var19];
                                                                                                      class225.field2558[var14] = class69.field999[--class69.field1003];
                                                                                                      GameClient.updateForSetting(var14);
                                                                                                   }
                                                                                                } else {
                                                                                                   var14 = var20[var19];
                                                                                                   class69.field999[++class69.field1003 - 1] = class225.field2558[var14];
                                                                                                }
                                                                                             } else {
                                                                                                class69.field999[++class69.field1003 - 1] = var20[var19];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var34;
                                                                                             if(var4.field1196[var19] == 1) {
                                                                                                var34 = true;
                                                                                             } else {
                                                                                                var34 = false;
                                                                                             }

                                                                                             var24 = class191.method3866(var10, var4, var34);
                                                                                             switch(var24) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
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
                     }
                  }
               }
            }
         } catch (Exception var29) {
            StringBuilder var28 = new StringBuilder(30);
            var28.append("").append(var4.field2421).append(" ");

            for(var21 = class69.field1008 - 1; var21 >= 0; --var21) {
               var28.append("").append(class69.field1006[var21].field466.field2421).append(" ");
            }

            var28.append("").append(var31);
            class5.method65(var28.toString(), var29, (byte)106);
         }
      }
   }
}
