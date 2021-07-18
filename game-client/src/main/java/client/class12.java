package client;

public class class12 {
   public static final class12 field70 = new class12("SMALL", 0, 0, 4);
   public static final class12 field71 = new class12("MEDIUM", 2, 1, 2);
   public static final class12 field72 = new class12("LARGE", 1, 2, 0);
   static final int field74 = 32768;
   static final int field77 = 38;
   static final int field78 = 37;
   static final int field80 = 14;
   public static final int field81 = 1012;
   final int field76;
   final String field73;
   final int field79;
   final int field75;

   class12(String var1, int var2, int var3, int var4) {
      this.field73 = var1;
      this.field79 = var2;
      this.field75 = var3;
      this.field76 = var4;
   }

   boolean method103(float var1, byte var2) {
      return var1 >= (float)this.field76;
   }

   static void method104(class21 var0, int var1, int var2, int var3) {
      class23.field189.method4007(var0, class43.method716(var1, var2, 0, -884021515));
   }

   static class12 method101(int var0, byte var1) {
      class12[] var2 = new class12[]{field72, field70, field71};
      class12[] var3 = var2;

      for(int var4 = 0; var4 < var3.length; var4++) {
         class12 var5 = var3[var4];
         if(var0 == var5.field75) {
            return var5;
         }
      }

      return null;
   }

   static final int method108(int var0) {
      if(class10.field61.field960) {
         return class13.field82;
      } else {
         int var1 = 3;
         if(class7.field41 < 310) {
            int var2;
            int var3;
            if(GameClient.field655 == 1) {
               var2 = class109.field1428 >> 7;
               var3 = class2.field23 >> 7;
            } else {
               var2 = class138.field1876.field931 >> 7;
               var3 = class138.field1876.field881 >> 7;
            }

            int var4 = class109.field1431 >> 7;
            int var5 = class226.field2563 >> 7;
            if(var4 < 0 || var5 < 0 || var4 >= 104 || var5 >= 104) {
               return class13.field82;
            }

            if(var2 < 0 || var3 < 0 || var2 >= 104 || var3 >= 104) {
               return class13.field82;
            }

            if((class50.field443[class13.field82][var4][var5] & 4) != 0) {
               var1 = class13.field82;
            }

            int var6;
            if(var2 > var4) {
               var6 = var2 - var4;
            } else {
               var6 = var4 - var2;
            }

            int var7;
            if(var3 > var5) {
               var7 = var3 - var5;
            } else {
               var7 = var5 - var3;
            }

            int var8;
            int var9;
            if(var6 > var7) {
               var8 = var7 * 65536 / var6;
               var9 = 32768;

               while(var4 != var2) {
                  if(var4 < var2) {
                     ++var4;
                  } else if(var4 > var2) {
                     --var4;
                  }

                  if((class50.field443[class13.field82][var4][var5] & 4) != 0) {
                     var1 = class13.field82;
                  }

                  var9 += var8;
                  if(var9 >= 65536) {
                     var9 -= 65536;
                     if(var5 < var3) {
                        ++var5;
                     } else if(var5 > var3) {
                        --var5;
                     }

                     if((class50.field443[class13.field82][var4][var5] & 4) != 0) {
                        var1 = class13.field82;
                     }
                  }
               }
            } else if(var7 > 0) {
               var8 = var6 * 65536 / var7;
               var9 = 32768;

               while(var3 != var5) {
                  if(var5 < var3) {
                     ++var5;
                  } else if(var5 > var3) {
                     --var5;
                  }

                  if((class50.field443[class13.field82][var4][var5] & 4) != 0) {
                     var1 = class13.field82;
                  }

                  var9 += var8;
                  if(var9 >= 65536) {
                     var9 -= 65536;
                     if(var4 < var2) {
                        ++var4;
                     } else if(var4 > var2) {
                        --var4;
                     }

                     if((class50.field443[class13.field82][var4][var5] & 4) != 0) {
                        var1 = class13.field82;
                     }
                  }
               }
            }
         }

         if(class138.field1876.field931 >= 0 && class138.field1876.field881 >= 0 && class138.field1876.field931 < 13312 && class138.field1876.field881 < 13312) {
            if((class50.field443[class13.field82][class138.field1876.field931 >> 7][class138.field1876.field881 >> 7] & 4) != 0) {
               var1 = class13.field82;
            }

            return var1;
         } else {
            return class13.field82;
         }
      }
   }

   static final void method102(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      for(int var9 = 0; var9 < var0.length; var9++) {
         Widget var10 = var0[var9];
         if(var10 != null && (!var10.decodeCs2 || var10.widgetType == 0 || var10.field2686 || class24.method425(var10, (byte)-62) != 0 || var10 == GameClient.field752 || var10.interactType == 1338) && var10.parentHash == var1) {
            if(var10.decodeCs2 && class81.method1885(var10, (byte)-10)) {
               if(var8 == 1667341178) {
                  return;
               }
            } else {
               int var11 = var10.field2618 + var6;
               int var12 = var7 + var10.int447;
               int var13;
               int var14;
               int var15;
               int var16;
               int var17;
               int var18;
               int var43;
               if(var10.widgetType == 2) {
                  var13 = var2;
                  var14 = var3;
                  var15 = var4;
                  var16 = var5;
               } else {
                  int var10000;
                  if(var10.widgetType == 9) {
                     if(var8 == 1667341178) {
                        return;
                     }

                     var17 = var11;
                     var18 = var12;
                     int var19 = var11 + var10.int472;
                     var43 = var12 + var10.int466;
                     if(var19 < var11) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        var17 = var19;
                        var19 = var11;
                     }

                     if(var43 < var12) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        var18 = var43;
                        var43 = var12;
                     }

                     ++var19;
                     ++var43;
                     var13 = var17 > var2 ? var17 : var2;
                     var14 = var18 > var3 ? var18 : var3;
                     if(var19 < var4) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        var10000 = var19;
                     } else {
                        var10000 = var4;
                     }

                     var15 = var10000;
                     if(var43 < var5) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        var10000 = var43;
                     } else {
                        var10000 = var5;
                     }

                     var16 = var10000;
                  } else {
                     var17 = var11 + var10.int472;
                     var18 = var12 + var10.int466;
                     var13 = var11 > var2 ? var11 : var2;
                     var14 = var12 > var3 ? var12 : var3;
                     var15 = var17 < var4 ? var17 : var4;
                     if(var18 < var5) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        var10000 = var18;
                     } else {
                        var10000 = var5;
                     }

                     var16 = var10000;
                  }
               }

               if(var10 == GameClient.field583) {
                  GameClient.field772 = true;
                  GameClient.field696 = var11;
                  GameClient.field760 = var12;
               }

               if(var10.decodeCs2) {
                  if(var8 == 1667341178) {
                     return;
                  }

                  if(var13 >= var15 || var14 >= var16) {
                     continue;
                  }
               }

               var17 = class48.field425;
               var18 = class48.field426 * 673804999;
               if(class48.field431 != 0) {
                  if(var8 == 1667341178) {
                     return;
                  }

                  var17 = class48.field432;
                  var18 = class48.field428;
               }

               boolean var73;
               label1791: {
                  if(var17 >= var13) {
                     if(var8 == 1667341178) {
                        return;
                     }

                     if(var18 >= var14 && var17 < var15 && var18 < var16) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        var73 = true;
                        break label1791;
                     }
                  }

                  var73 = false;
               }

               boolean var57 = var73;
               int var24;
               int var25;
               int var26;
               int var29;
               int var60;
               if(var10.interactType == 1337) {
                  if(!GameClient.field625 && !GameClient.field716) {
                     if(var8 == 1667341178) {
                        return;
                     }

                     if(var57) {
                        if(GameClient.field733 == 0 && !GameClient.field785) {
                           class50.method993("Walk here", "", 23, 0, var17 - var13, var18 - var14, -1119730379);
                        }

                        long var20 = -1L;
                        long var22 = -1L;
                        var24 = 0;

                        while(true) {
                           var26 = class120.field1656;
                           if(var24 >= var26) {
                              if(var20 != -1L) {
                                 var24 = class37.method662(var20);
                                 var25 = class109.method2484(var20);
                                 Player var40 = GameClient.field610[GameClient.field707];
                                 class221.method4371(var40, GameClient.field707, var24, var25, -1709674854);
                              }
                              break;
                           }

                           long var50 = class20.method262(var24, -1525705371);
                           if(var50 != var22) {
                              label1874: {
                                 var22 = var50;
                                 var29 = class3.method32(var24, (byte)-32);
                                 var60 = class27.method435(var24, (byte)60);
                                 long var33 = class120.field1647[var24];
                                 int var32 = (int)(var33 >>> 14 & 3L);
                                 int var52 = Item.method1864(var24, 916064134);
                                 if(var32 == 2 && class28.field248.method2902(class13.field82, var29, var60, var50) >= 0) {
                                    if(var8 == 1667341178) {
                                       return;
                                    }

                                    ObjectDef var34 = class110.getObjectDef(var52);
                                    if(var34.intArray116 != null) {
                                       var34 = var34.method5056();
                                    }

                                    if(var34 == null) {
                                       if(var8 == 1667341178) {
                                          return;
                                       }
                                       break label1874;
                                    }

                                    if(GameClient.field733 == 1) {
                                       if(var8 == 1667341178) {
                                          return;
                                       }

                                       class50.method993("Use", GameClient.field734 + " " + "->" + " " + class6.method71(65535) + var34.name, 1, var52, var29, var60, 958081);
                                    } else if(GameClient.field785) {
                                       if((class63.field932 & 4) == 4) {
                                          class50.method993(GameClient.field612, GameClient.field739 + " " + "->" + " " + class6.method71(65535) + var34.name, 2, var52, var29, var60, -1448600391);
                                       }
                                    } else {
                                       String[] var35 = var34.options;
                                       if(var35 != null) {
                                          if(var8 == 1667341178) {
                                             return;
                                          }

                                          for(int var36 = 4; var36 >= 0; --var36) {
                                             if(var35[var36] != null) {
                                                short var37 = 0;
                                                if(var36 == 0) {
                                                   var37 = 3;
                                                }

                                                if(var36 == 1) {
                                                   var37 = 4;
                                                }

                                                if(var36 == 2) {
                                                   var37 = 5;
                                                }

                                                if(var36 == 3) {
                                                   var37 = 6;
                                                }

                                                if(var36 == 4) {
                                                   var37 = 1001;
                                                }

                                                class50.method993(var35[var36], class6.method71(65535) + var34.name, var37, var52, var29, var60, 238630117);
                                             }
                                          }
                                       }

                                       class50.method993("Examine", class6.method71(65535) + var34.name, 1002, var34.field3376, var29, var60, 749514812);
                                    }
                                 }

                                 Player var38;
                                 int var53;
                                 Npc npc2;
                                 int var65;
                                 int[] var71;
                                 if(var32 == 1) {
                                    Npc npc = GameClient.field843[var52];
                                    if(npc == null) {
                                       if(var8 == 1667341178) {
                                          return;
                                       }
                                       break label1874;
                                    }

                                    if(npc.definition.size == 1 && (npc.field931 & 127) == 64 && (npc.field881 & 127) == 64) {
                                       for(var53 = 0; var53 < GameClient.field622; var53++) {
                                          npc2 = GameClient.field843[GameClient.field639[var53]];
                                          if(npc2 != null && npc != npc2 && npc2.definition.size == 1 && npc2.field931 == npc.field931 && npc.field881 == npc2.field881) {
                                             class28.method474(npc2.definition, npc2, GameClient.field639[var53], var29, var60);
                                          }
                                       }

                                       var53 = class81.field1167;
                                       var71 = class81.field1159;

                                       for(var65 = 0; var65 < var53; var65++) {
                                          var38 = GameClient.field610[var71[var65]];
                                          if(var38 != null && var38.field931 == npc.field931 && var38.field881 == npc.field881) {
                                             if(var8 == 1667341178) {
                                                return;
                                             }

                                             class221.method4371(var38, var71[var65], var29, var60, 1484605782);
                                          }
                                       }
                                    }

                                    class28.method474(npc.definition, npc, var52, var29, var60);
                                 }

                                 if(var32 == 0) {
                                    Player var62 = GameClient.field610[var52];
                                    if(var62 == null) {
                                       if(var8 == 1667341178) {
                                          return;
                                       }
                                       break label1874;
                                    }

                                    if((var62.field931 & 127) == 64 && (var62.field881 & 127) == 64) {
                                       for(var53 = 0; var53 < GameClient.field622; var53++) {
                                          npc2 = GameClient.field843[GameClient.field639[var53]];
                                          if(npc2 != null && npc2.definition.size == 1 && var62.field931 == npc2.field931 && npc2.field881 == var62.field881) {
                                             class28.method474(npc2.definition, npc2, GameClient.field639[var53], var29, var60);
                                          }
                                       }

                                       var53 = class81.field1167;
                                       var71 = class81.field1159;

                                       for(var65 = 0; var65 < var53; var65++) {
                                          var38 = GameClient.field610[var71[var65]];
                                          if(var38 != null && var38 != var62 && var62.field931 == var38.field931 && var38.field881 == var62.field881) {
                                             if(var8 == 1667341178) {
                                                return;
                                             }

                                             class221.method4371(var38, var71[var65], var29, var60, -1608622776);
                                          }
                                       }
                                    }

                                    if(var52 != GameClient.field707) {
                                       class221.method4371(var62, var52, var29, var60, 2073501500);
                                    } else {
                                       var20 = var50;
                                    }
                                 }

                                 if(var32 == 3) {
                                    class205 var64 = GameClient.field708[class13.field82][var29][var60];
                                    if(var64 != null) {
                                       for(Item var63 = (Item)var64.method4083(); var63 != null; var63 = (Item)var64.method4093()) {
                                          ItemDef var72 = ItemDef.loadItemDef(var63.id);
                                          if(GameClient.field733 == 1) {
                                             class50.method993("Use", GameClient.field734 + " " + "->" + " " + class6.method71(16748608) + var72.name, 16, var63.id, var29, var60, -2061994694);
                                          } else if(GameClient.field785) {
                                             if((class63.field932 & 1) == 1) {
                                                class50.method993(GameClient.field612, GameClient.field739 + " " + "->" + " " + class6.method71(16748608) + var72.name, 17, var63.id, var29, var60, -23719847);
                                             }
                                          } else {
                                             String[] var55 = var72.options;

                                             for(int var56 = 4; var56 >= 0; --var56) {
                                                if(var55 != null) {
                                                   if(var8 == 1667341178) {
                                                      return;
                                                   }

                                                   if(var55[var56] != null) {
                                                      byte var39 = 0;
                                                      if(var56 == 0) {
                                                         var39 = 18;
                                                      }

                                                      if(var56 == 1) {
                                                         var39 = 19;
                                                      }

                                                      if(var56 == 2) {
                                                         var39 = 20;
                                                      }

                                                      if(var56 == 3) {
                                                         var39 = 21;
                                                      }

                                                      if(var56 == 4) {
                                                         if(var8 == 1667341178) {
                                                            return;
                                                         }

                                                         var39 = 22;
                                                      }

                                                      class50.method993(var55[var56], class6.method71(16748608) + var72.name, var39, var63.id, var29, var60, 92607779);
                                                      continue;
                                                   }
                                                }

                                                if(var56 == 2) {
                                                   class50.method993("Take", class6.method71(16748608) + var72.name, 20, var63.id, var29, var60, 390589634);
                                                }
                                             }

                                             class50.method993("Examine", class6.method71(16748608) + var72.name, 1004, var63.id, var29, var60, 300490845);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           ++var24;
                        }
                     }
                  }
               } else if(var10.interactType == 1338) {
                  class36.method632(var10, var11, var12, -201841471);
               } else {
                  if(var10.interactType == 1400) {
                     if(var8 == 1667341178) {
                        return;
                     }

                     class53.field476.method6003(class48.field425, class48.field426 * 673804999, var57, var11, var12, var10.int472, var10.int466, -767391754);
                  }

                  int var21;
                  int var23;
                  int var44;
                  boolean var68;
                  if(!GameClient.field716 && var57) {
                     if(var10.interactType == 1400) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        class53.field476.method6158(var11, var12, var10.int472, var10.int466, var17, var18, -766143801);
                     } else {
                        var43 = var17 - var11;
                        var21 = var18 - var12;
                        if(var10.field2709 == 1) {
                           if(var8 == 1667341178) {
                              return;
                           }

                           class50.method993(var10.field2723, "", 24, 0, 0, var10.interfaceHash, -419230286);
                        }

                        String var45;
                        if(var10.field2709 == 2 && !GameClient.field785) {
                           var45 = class151.method3239(var10, -2016324060);
                           if(var45 != null) {
                              class50.method993(var45, class6.method71(65280) + var10.field2722, 25, 0, -1, var10.interfaceHash, 600974616);
                           }
                        }

                        if(var10.field2709 == 3) {
                           class50.method993("Close", "", 26, 0, 0, var10.interfaceHash, -1104627662);
                        }

                        if(var10.field2709 == 4) {
                           class50.method993(var10.field2723, "", 28, 0, 0, var10.interfaceHash, -1310868884);
                        }

                        if(var10.field2709 == 5) {
                           class50.method993(var10.field2723, "", 29, 0, 0, var10.interfaceHash, 123972216);
                        }

                        if(var10.field2709 == 6 && GameClient.field744 == null) {
                           class50.method993(var10.field2723, "", 30, 0, -1, var10.interfaceHash, -350698298);
                        }

                        if(var10.widgetType == 2) {
                           var44 = 0;

                           for(var23 = 0; var23 < var10.int466; var23++) {
                              if(var8 == 1667341178) {
                                 return;
                              }

                              for(var24 = 0; var24 < var10.int472; var24++) {
                                 if(var8 == 1667341178) {
                                    return;
                                 }

                                 var25 = var24 * (var10.field2672 + 32);
                                 var26 = var23 * (var10.field2673 + 32);
                                 if(var44 < 20) {
                                    var25 += var10.field2685[var44];
                                    var26 += var10.field2738[var44];
                                 }

                                 if(var43 >= var25 && var21 >= var26 && var43 < var25 + 32 && var21 < var26 + 32) {
                                    GameClient.field691 = var44;
                                    class132.field1819 = var10;
                                    if(var10.field2724[var44] > 0) {
                                       label1895: {
                                          ItemDef var27 = ItemDef.loadItemDef(var10.field2724[var44] - 1);
                                          if(GameClient.field733 == 1) {
                                             if(var8 == 1667341178) {
                                                return;
                                             }

                                             if(class145.method3188(class24.method425(var10, (byte)-11), 1075370368)) {
                                                if(var10.interfaceHash != class187.field2372 || var44 != class13.field84) {
                                                   class50.method993("Use", GameClient.field734 + " " + "->" + " " + class6.method71(16748608) + var27.name, 31, var27.field3431, var44, var10.interfaceHash, -1157314575);
                                                }
                                                break label1895;
                                             }
                                          }

                                          if(GameClient.field785 && class145.method3188(class24.method425(var10, (byte)-37), 763302428)) {
                                             if((class63.field932 & 16) == 16) {
                                                class50.method993(GameClient.field612, GameClient.field739 + " " + "->" + " " + class6.method71(16748608) + var27.name, 32, var27.field3431, var44, var10.interfaceHash, -1688309936);
                                             }
                                          } else {
                                             String[] var28 = var27.interfaceOptions;
                                             var29 = -1;
                                             if(GameClient.field726) {
                                                boolean var30 = GameClient.field727 || PacketBuilder.field341[81];
                                                if(var30) {
                                                   var29 = var27.method5101(1322817925);
                                                }
                                             }

                                             if(class145.method3188(class24.method425(var10, (byte)-21), -963200521)) {
                                                for(var60 = 4; var60 >= 3; --var60) {
                                                   if(var8 == 1667341178) {
                                                      return;
                                                   }

                                                   if(var29 != var60) {
                                                      ScriptInvocation.method1027(var10, var27, var44, var60, false, -2096518256);
                                                   }
                                                }
                                             }

                                             if(class148.method3197(class24.method425(var10, (byte)-24), -2017324363)) {
                                                if(var8 == 1667341178) {
                                                   return;
                                                }

                                                class50.method993("Use", class6.method71(16748608) + var27.name, 38, var27.field3431, var44, var10.interfaceHash, 393487832);
                                             }

                                             if(class145.method3188(class24.method425(var10, (byte)-76), 1086985237)) {
                                                for(var60 = 2; var60 >= 0; --var60) {
                                                   if(var8 == 1667341178) {
                                                      return;
                                                   }

                                                   if(var60 == var29) {
                                                      if(var8 == 1667341178) {
                                                         return;
                                                      }
                                                   } else {
                                                      ScriptInvocation.method1027(var10, var27, var44, var60, false, -678380505);
                                                   }
                                                }

                                                if(var29 >= 0) {
                                                   ScriptInvocation.method1027(var10, var27, var44, var29, true, 1005524612);
                                                }
                                             }

                                             var28 = var10.field2677;
                                             if(var28 != null) {
                                                for(var60 = 4; var60 >= 0; --var60) {
                                                   if(var28[var60] != null) {
                                                      if(var8 == 1667341178) {
                                                         return;
                                                      }

                                                      byte var31 = 0;
                                                      if(var60 == 0) {
                                                         if(var8 == 1667341178) {
                                                            return;
                                                         }

                                                         var31 = 39;
                                                      }

                                                      if(var60 == 1) {
                                                         var31 = 40;
                                                      }

                                                      if(var60 == 2) {
                                                         var31 = 41;
                                                      }

                                                      if(var60 == 3) {
                                                         var31 = 42;
                                                      }

                                                      if(var60 == 4) {
                                                         var31 = 43;
                                                      }

                                                      class50.method993(var28[var60], class6.method71(16748608) + var27.name, var31, var27.field3431, var44, var10.interfaceHash, 46415526);
                                                   }
                                                }
                                             }

                                             class50.method993("Examine", class6.method71(16748608) + var27.name, 1005, var27.field3431, var44, var10.interfaceHash, -191839999);
                                          }
                                       }
                                    }
                                 }

                                 ++var44;
                              }
                           }
                        }

                        if(var10.decodeCs2) {
                           if(GameClient.field785) {
                              if(var8 == 1667341178) {
                                 return;
                              }

                              var23 = class24.method425(var10, (byte)0);
                              var68 = (var23 >> 21 & 1) != 0;
                              if(var68) {
                                 if(var8 == 1667341178) {
                                    return;
                                 }

                                 if((class63.field932 & 32) == 32) {
                                    class50.method993(GameClient.field612, GameClient.field739 + " " + "->" + " " + var10.string29, 58, 0, var10.childId, var10.interfaceHash, -405533202);
                                 }
                              }
                           } else {
                              for(var44 = 9; var44 >= 5; --var44) {
                                 String var47 = class112.method2565(var10, var44, 878774611);
                                 if(var47 != null) {
                                    class50.method993(var47, var10.string29, 1007, var44 + 1, var10.childId, var10.interfaceHash, -1717814369);
                                 }
                              }

                              var45 = class151.method3239(var10, -1954142270);
                              if(var45 != null) {
                                 class50.method993(var45, var10.string29, 25, 0, var10.childId, var10.interfaceHash, 578321308);
                              }

                              for(var23 = 4; var23 >= 0; --var23) {
                                 String var48 = class112.method2565(var10, var23, 1061418289);
                                 if(var48 != null) {
                                    class50.method993(var48, var10.string29, 57, var23 + 1, var10.childId, var10.interfaceHash, 841060613);
                                 }
                              }

                              var24 = class24.method425(var10, (byte)-74);
                              boolean var59 = (var24 & 1) != 0;
                              if(var59) {
                                 if(var8 == 1667341178) {
                                    return;
                                 }

                                 class50.method993("Continue", "", 30, 0, var10.childId, var10.interfaceHash, -143755570);
                              }
                           }
                        }
                     }
                  }

                  if(var10.widgetType == 0) {
                     if(var8 == 1667341178) {
                        return;
                     }

                     if(!var10.decodeCs2) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        if(class81.method1885(var10, (byte)-82) && var10 != class143.field1897) {
                           if(var8 == 1667341178) {
                              return;
                           }
                           continue;
                        }
                     }

                     method102(var0, var10.interfaceHash, var13, var14, var15, var16, var11 - var10.field2626, var12 - var10.scrollY, -976243362);
                     if(var10.children != null) {
                        method102(var10.children, var10.interfaceHash, var13, var14, var15, var16, var11 - var10.field2626, var12 - var10.scrollY, -1661413802);
                     }

                     class55 var41 = (class55) GameClient.field741.get((long)var10.interfaceHash);
                     if(var41 != null) {
                        if(var41.field494 == 0 && class48.field425 >= var13 && class48.field426 * 673804999 >= var14 && class48.field425 < var15) {
                           if(var8 == 1667341178) {
                              return;
                           }

                           if(class48.field426 * 673804999 < var16 && !GameClient.field716) {
                              for(ScriptInvocation var42 = (ScriptInvocation) GameClient.field638.method4098(); var42 != null; var42 = (ScriptInvocation) GameClient.field638.method4079()) {
                                 if(var42.field505) {
                                    var42.unlink();
                                    var42.field506.field2731 = false;
                                 }
                              }

                              if(class6.field39 == 0) {
                                 GameClient.field583 = null;
                                 GameClient.field752 = null;
                              }

                              if(!GameClient.field716) {
                                 class59.method1077(-670001179);
                              }
                           }
                        }

                        var21 = var41.field501;
                        if(class261.method4931(var21, (byte)-21)) {
                           method102(Widget.LOADED[var21], -1, var13, var14, var15, var16, var11, var12, 2106724986);
                        }
                     }
                  }

                  if(var10.decodeCs2) {
                     ScriptInvocation var66;
                     if(!var10.bool40) {
                        if(var10.field2740 && class48.field425 >= var13) {
                           if(var8 == 1667341178) {
                              return;
                           }

                           if(class48.field426 * 673804999 >= var14 && class48.field425 < var15 && class48.field426 * 673804999 < var16) {
                              for(var66 = (ScriptInvocation) GameClient.field638.method4098(); var66 != null; var66 = (ScriptInvocation) GameClient.field638.method4079()) {
                                 if(var66.field505 && var66.field506.objectArray19 == var66.parameters) {
                                    var66.unlink();
                                 }
                              }
                           }
                        }
                     } else if(class48.field425 >= var13 && class48.field426 * 673804999 >= var14) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        if(class48.field425 < var15 && class48.field426 * 673804999 < var16) {
                           for(var66 = (ScriptInvocation) GameClient.field638.method4098(); var66 != null; var66 = (ScriptInvocation) GameClient.field638.method4079()) {
                              if(var66.field505) {
                                 var66.unlink();
                                 var66.field506.field2731 = false;
                              }
                           }

                           if(class6.field39 == 0) {
                              GameClient.field583 = null;
                              GameClient.field752 = null;
                           }

                           if(!GameClient.field716) {
                              class59.method1077(-2081168912);
                           }
                        }
                     }

                     label1621: {
                        if(class48.field425 >= var13) {
                           if(var8 == 1667341178) {
                              return;
                           }

                           if(class48.field426 * 673804999 >= var14 && class48.field425 < var15 && class48.field426 * 673804999 < var16) {
                              var57 = true;
                              break label1621;
                           }
                        }

                        var57 = false;
                     }

                     boolean var67 = false;
                     if((class48.field419 == 1 || !class253.field3229 && class48.field419 == 4) && var57) {
                        var67 = true;
                     }

                     boolean var58 = false;
                     if((class48.field431 == 1 || !class253.field3229 && class48.field431 == 4) && class48.field432 >= var13) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        if(class48.field428 >= var14 && class48.field432 < var15) {
                           if(var8 == 1667341178) {
                              return;
                           }

                           if(class48.field428 < var16) {
                              var58 = true;
                           }
                        }
                     }

                     if(var58) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        OutgoingPacket.method3447(var10, class48.field432 - var11, class48.field428 - var12, (byte)0);
                     }

                     if(var10.interactType == 1400) {
                        class53.field476.method6174(var17, var18, var57 & var67, var57 & var58, (byte)110);
                     }

                     if(GameClient.field583 != null) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        if(var10 != GameClient.field583 && var57) {
                           var23 = class24.method425(var10, (byte)-26);
                           var68 = (var23 >> 20 & 1) != 0;
                           if(var68) {
                              GameClient.field755 = var10;
                           }
                        }
                     }

                     if(var10 == GameClient.field752) {
                        GameClient.field601 = true;
                        GameClient.field757 = var11;
                        GameClient.field758 = var12;
                     }

                     if(var10.field2686) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        ScriptInvocation var69;
                        if(var57 && GameClient.field695 != 0) {
                           if(var8 == 1667341178) {
                              return;
                           }

                           if(var10.objectArray19 != null) {
                              var69 = new ScriptInvocation();
                              var69.field505 = true;
                              var69.field506 = var10;
                              var69.field508 = GameClient.field695;
                              var69.parameters = var10.objectArray19;
                              GameClient.field638.method4073(var69);
                           }
                        }

                        if(GameClient.field583 != null || class276.field3559 != null || GameClient.field716) {
                           var58 = false;
                           var67 = false;
                           var57 = false;
                        }

                        if(!var10.field2674 && var58) {
                           var10.field2674 = true;
                           if(var10.objectArray7 != null) {
                              var69 = new ScriptInvocation();
                              var69.field505 = true;
                              var69.field506 = var10;
                              var69.field511 = class48.field432 - var11;
                              var69.field508 = class48.field428 - var12;
                              var69.parameters = var10.objectArray7;
                              GameClient.field638.method4073(var69);
                           }
                        }

                        if(var10.field2674 && var67 && var10.objectArray8 != null) {
                           var69 = new ScriptInvocation();
                           var69.field505 = true;
                           var69.field506 = var10;
                           var69.field511 = class48.field425 - var11;
                           var69.field508 = class48.field426 * 673804999 - var12;
                           var69.parameters = var10.objectArray8;
                           GameClient.field638.method4073(var69);
                        }

                        if(var10.field2674 && !var67) {
                           var10.field2674 = false;
                           if(var10.objectArray5 != null) {
                              if(var8 == 1667341178) {
                                 return;
                              }

                              var69 = new ScriptInvocation();
                              var69.field505 = true;
                              var69.field506 = var10;
                              var69.field511 = class48.field425 - var11;
                              var69.field508 = class48.field426 * 673804999 - var12;
                              var69.parameters = var10.objectArray5;
                              GameClient.field779.method4073(var69);
                           }
                        }

                        if(var67 && var10.objectArray9 != null) {
                           var69 = new ScriptInvocation();
                           var69.field505 = true;
                           var69.field506 = var10;
                           var69.field511 = class48.field425 - var11;
                           var69.field508 = class48.field426 * 673804999 - var12;
                           var69.parameters = var10.objectArray9;
                           GameClient.field638.method4073(var69);
                        }

                        if(!var10.field2731 && var57) {
                           var10.field2731 = true;
                           if(var10.mouseEnteredScript != null) {
                              var69 = new ScriptInvocation();
                              var69.field505 = true;
                              var69.field506 = var10;
                              var69.field511 = class48.field425 - var11;
                              var69.field508 = class48.field426 * 673804999 - var12;
                              var69.parameters = var10.mouseEnteredScript;
                              GameClient.field638.method4073(var69);
                           }
                        }

                        if(var10.field2731 && var57 && var10.objectArray11 != null) {
                           var69 = new ScriptInvocation();
                           var69.field505 = true;
                           var69.field506 = var10;
                           var69.field511 = class48.field425 - var11;
                           var69.field508 = class48.field426 * 673804999 - var12;
                           var69.parameters = var10.objectArray11;
                           GameClient.field638.method4073(var69);
                        }

                        if(var10.field2731 && !var57) {
                           var10.field2731 = false;
                           if(var10.mouseLeftScript != null) {
                              if(var8 == 1667341178) {
                                 return;
                              }

                              var69 = new ScriptInvocation();
                              var69.field505 = true;
                              var69.field506 = var10;
                              var69.field511 = class48.field425 - var11;
                              var69.field508 = class48.field426 * 673804999 - var12;
                              var69.parameters = var10.mouseLeftScript;
                              GameClient.field779.method4073(var69);
                           }
                        }

                        if(var10.objectArray17 != null) {
                           var69 = new ScriptInvocation();
                           var69.field506 = var10;
                           var69.parameters = var10.objectArray17;
                           GameClient.field778.method4073(var69);
                        }

                        ScriptInvocation var46;
                        if(var10.onConfigTrigger != null && GameClient.staticInt244 > var10.field2683) {
                           label1571: {
                              if(var10.mouseWheelTrigger != null) {
                                 if(GameClient.staticInt244 - var10.field2683 <= 32) {
                                    var44 = var10.field2683;

                                    while(true) {
                                       if(var44 >= GameClient.staticInt244) {
                                          break label1571;
                                       }

                                       var23 = GameClient.staticIntArray105[var44 & 31];

                                       for(var24 = 0; var24 < var10.mouseWheelTrigger.length; var24++) {
                                          if(var23 == var10.mouseWheelTrigger[var24]) {
                                             if(var8 == 1667341178) {
                                                return;
                                             }

                                             var46 = new ScriptInvocation();
                                             var46.field506 = var10;
                                             var46.parameters = var10.onConfigTrigger;
                                             GameClient.field638.method4073(var46);
                                             break label1571;
                                          }
                                       }

                                       ++var44;
                                    }
                                 }

                                 if(var8 == 1667341178) {
                                    return;
                                 }
                              }

                              var69 = new ScriptInvocation();
                              var69.field506 = var10;
                              var69.parameters = var10.onConfigTrigger;
                              GameClient.field638.method4073(var69);
                           }

                           var10.field2683 = GameClient.staticInt244;
                        }

                        if(var10.onItemUpdateTrigger != null && GameClient.field767 > var10.field2735) {
                           if(var10.configChangeTriggers != null && GameClient.field767 - var10.field2735 <= 32) {
                              label1541:
                              for(var44 = var10.field2735; var44 < GameClient.field767; var44++) {
                                 if(var8 == 1667341178) {
                                    return;
                                 }

                                 var23 = GameClient.field766[var44 & 31];

                                 for(var24 = 0; var24 < var10.configChangeTriggers.length; var24++) {
                                    if(var8 == 1667341178) {
                                       return;
                                    }

                                    if(var23 == var10.configChangeTriggers[var24]) {
                                       var46 = new ScriptInvocation();
                                       var46.field506 = var10;
                                       var46.parameters = var10.onItemUpdateTrigger;
                                       GameClient.field638.method4073(var46);
                                       break label1541;
                                    }
                                 }
                              }
                           } else {
                              var69 = new ScriptInvocation();
                              var69.field506 = var10;
                              var69.parameters = var10.onItemUpdateTrigger;
                              GameClient.field638.method4073(var69);
                           }

                           var10.field2735 = GameClient.field767;
                        }

                        if(var10.onSkillUpdateTrigger != null && GameClient.field769 > var10.field2702) {
                           if(var10.itemUpdateTriggers != null && GameClient.field769 - var10.field2702 <= 32) {
                              label1516:
                              for(var44 = var10.field2702; var44 < GameClient.field769; var44++) {
                                 if(var8 == 1667341178) {
                                    return;
                                 }

                                 var23 = GameClient.field690[var44 & 31];

                                 for(var24 = 0; var24 < var10.itemUpdateTriggers.length; var24++) {
                                    if(var8 == 1667341178) {
                                       return;
                                    }

                                    if(var23 == var10.itemUpdateTriggers[var24]) {
                                       var46 = new ScriptInvocation();
                                       var46.field506 = var10;
                                       var46.parameters = var10.onSkillUpdateTrigger;
                                       GameClient.field638.method4073(var46);
                                       break label1516;
                                    }
                                 }
                              }
                           } else {
                              var69 = new ScriptInvocation();
                              var69.field506 = var10;
                              var69.parameters = var10.onSkillUpdateTrigger;
                              GameClient.field638.method4073(var69);
                           }

                           var10.field2702 = GameClient.field769;
                        }

                        if(GameClient.field770 > var10.field2697 && var10.field2708 != null) {
                           var69 = new ScriptInvocation();
                           var69.field506 = var10;
                           var69.parameters = var10.field2708;
                           GameClient.field638.method4073(var69);
                        }

                        if(GameClient.field647 > var10.field2697 && var10.field2718 != null) {
                           if(var8 == 1667341178) {
                              return;
                           }

                           var69 = new ScriptInvocation();
                           var69.field506 = var10;
                           var69.parameters = var10.field2718;
                           GameClient.field638.method4073(var69);
                        }

                        if(GameClient.field828 > var10.field2697 && var10.field2711 != null) {
                           var69 = new ScriptInvocation();
                           var69.field506 = var10;
                           var69.parameters = var10.field2711;
                           GameClient.field638.method4073(var69);
                        }

                        if(GameClient.field793 > var10.field2697 && var10.field2716 != null) {
                           var69 = new ScriptInvocation();
                           var69.field506 = var10;
                           var69.parameters = var10.field2716;
                           GameClient.field638.method4073(var69);
                        }

                        if(GameClient.field774 > var10.field2697 && var10.field2693 != null) {
                           var69 = new ScriptInvocation();
                           var69.field506 = var10;
                           var69.parameters = var10.field2693;
                           GameClient.field638.method4073(var69);
                        }

                        if(GameClient.field775 > var10.field2697 && var10.field2712 != null) {
                           var69 = new ScriptInvocation();
                           var69.field506 = var10;
                           var69.parameters = var10.field2712;
                           GameClient.field638.method4073(var69);
                        }

                        var10.field2697 = GameClient.field801;
                        if(var10.field2637 != null) {
                           for(var44 = 0; var44 < GameClient.field799; var44++) {
                              if(var8 == 1667341178) {
                                 return;
                              }

                              ScriptInvocation var70 = new ScriptInvocation();
                              var70.field506 = var10;
                              var70.field509 = GameClient.field773[var44];
                              var70.field513 = GameClient.field800[var44];
                              var70.parameters = var10.field2637;
                              GameClient.field638.method4073(var70);
                           }
                        }
                     }
                  }

                  if(!var10.decodeCs2) {
                     if(var8 == 1667341178) {
                        return;
                     }

                     if(GameClient.field583 == null && class276.field3559 == null) {
                        if(var8 == 1667341178) {
                           return;
                        }

                        if(!GameClient.field716) {
                           label1482: {
                              if(var10.field2713 < 0) {
                                 if(var10.field2632 == 0) {
                                    break label1482;
                                 }

                                 if(var8 == 1667341178) {
                                    return;
                                 }
                              }

                              if(class48.field425 >= var13) {
                                 if(var8 == 1667341178) {
                                    return;
                                 }

                                 if(class48.field426 * 673804999 >= var14 && class48.field425 < var15) {
                                    if(var8 == 1667341178) {
                                       return;
                                    }

                                    if(class48.field426 * 673804999 < var16) {
                                       if(var10.field2713 >= 0) {
                                          class143.field1897 = var0[var10.field2713];
                                       } else {
                                          class143.field1897 = var10;
                                       }
                                    }
                                 }
                              }
                           }

                           if(var10.widgetType == 8 && class48.field425 >= var13) {
                              if(var8 == 1667341178) {
                                 return;
                              }

                              if(class48.field426 * 673804999 >= var14 && class48.field425 < var15 && class48.field426 * 673804999 < var16) {
                                 class141.field1888 = var10;
                              }
                           }

                           if(var10.scrollHeight > var10.int466) {
                              var43 = var11 + var10.int472;
                              var21 = var10.int466;
                              var44 = var10.scrollHeight;
                              var23 = class48.field425;
                              var24 = class48.field426 * 673804999;
                              if(GameClient.field746) {
                                 if(var8 == 1667341178) {
                                    return;
                                 }

                                 GameClient.field660 = 32;
                              } else {
                                 GameClient.field660 = 0;
                              }

                              label1859: {
                                 GameClient.field746 = false;
                                 if(class48.field419 != 1) {
                                    if(class253.field3229) {
                                       break label1859;
                                    }

                                    if(var8 == 1667341178) {
                                       return;
                                    }

                                    if(class48.field419 != 4) {
                                       break label1859;
                                    }
                                 }

                                 if(var23 >= var43 && var23 < var43 + 16) {
                                    if(var8 == 1667341178) {
                                       return;
                                    }

                                    if(var24 >= var12 && var24 < var12 + 16) {
                                       var10.scrollY -= 4;
                                       GameClient.requestRedraw(var10);
                                       break label1859;
                                    }
                                 }

                                 if(var23 >= var43 && var23 < var43 + 16 && var24 >= var12 + var21 - 16 && var24 < var12 + var21) {
                                    var10.scrollY += 4;
                                    GameClient.requestRedraw(var10);
                                 } else if(var23 >= var43 - GameClient.field660 && var23 < var43 + GameClient.field660 + 16 && var24 >= var12 + 16 && var24 < var12 + var21 - 16) {
                                    if(var8 == 1667341178) {
                                       return;
                                    }

                                    var25 = var21 * (var21 - 32) / var44;
                                    if(var25 < 8) {
                                       var25 = 8;
                                    }

                                    var26 = var24 - var12 - 16 - var25 / 2;
                                    int var49 = var21 - 32 - var25;
                                    var10.scrollY = var26 * (var44 - var21) / var49;
                                    GameClient.requestRedraw(var10);
                                    GameClient.field746 = true;
                                 }
                              }

                              if(GameClient.field695 != 0) {
                                 var25 = var10.int472;
                                 if(var23 >= var43 - var25 && var24 >= var12 && var23 < var43 + 16 && var24 <= var21 + var12) {
                                    var10.scrollY += GameClient.field695 * 45;
                                    GameClient.requestRedraw(var10);
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

   static final void method110(String var0, int var1) {
      if(!var0.equals("")) {
         class172 var2 = class26.method433(OutgoingPacket.field2153, GameClient.field626.field1218, 1008001859);
         var2.field2257.writeByte(class316.method5820(var0, (short)256));
         var2.field2257.writeString(var0, 1199940995);
         GameClient.field626.method1980(var2);
      }
   }
}
