package client;

public class class273 extends class206 {
   public static class200 field3539 = new class200(100);
   public static class200 field3552 = new class200(64);
   public static class247 field3536;
   public static class247 field3537;
   public static class247 field3538;
   public int field3551 = -1;
   public int[] field3540;
   int[] field3545;
   public int field3535 = -1;
   public int field3544 = -1;
   public int[] field3541;
   public boolean field3546 = false;
   public int field3548 = -1;
   public int field3547 = 5;
   public int field3549 = -1;
   int[] field3542;
   public int field3550 = 99;
   public int field3553 = 2;
   public int[] field3543;

   void method5213(Stream var1, int var2, byte var3) {
      int var4;
      int var5;
      if(var2 == 1) {
         var4 = var1.readUShort();
         this.field3541 = new int[var4];

         for(var5 = 0; var5 < var4; var5++) {
            this.field3541[var5] = var1.readUShort();
         }

         this.field3540 = new int[var4];

         for(var5 = 0; var5 < var4; var5++) {
            this.field3540[var5] = var1.readUShort();
         }

         for(var5 = 0; var5 < var4; var5++) {
            this.field3540[var5] += var1.readUShort() << 16;
         }
      } else if(var2 == 2) {
         this.field3544 = var1.readUShort();
      } else if(var2 == 3) {
         var4 = var1.readUByte();
         this.field3545 = new int[var4 + 1];

         for(var5 = 0; var5 < var4; var5++) {
            this.field3545[var5] = var1.readUByte();
         }

         this.field3545[var4] = 9999999;
      } else if(var2 == 4) {
         this.field3546 = true;
      } else if(var2 == 5) {
         this.field3547 = var1.readUByte();
      } else if(var2 == 6) {
         this.field3548 = var1.readUShort();
      } else if(var2 == 7) {
         this.field3549 = var1.readUShort();
      } else if(var2 == 8) {
         this.field3550 = var1.readUByte();
      } else if(var2 == 9) {
         if(var3 <= 0) {
            return;
         }

         this.field3551 = var1.readUByte();
      } else if(var2 == 10) {
         this.field3535 = var1.readUByte();
      } else if(var2 == 11) {
         this.field3553 = var1.readUByte();
      } else if(var2 == 12) {
         if(var3 <= 0) {
            return;
         }

         var4 = var1.readUByte();
         this.field3542 = new int[var4];

         for(var5 = 0; var5 < var4; var5++) {
            this.field3542[var5] = var1.readUShort();
         }

         for(var5 = 0; var5 < var4; var5++) {
            this.field3542[var5] += var1.readUShort() << 16;
         }
      } else if(var2 == 13) {
         var4 = var1.readUByte();
         this.field3543 = new int[var4];

         for(var5 = 0; var5 < var4; var5++) {
            this.field3543[var5] = var1.readMedium();
         }
      }

   }

   public class119 method5215(class119 var1, int var2, int var3) {
      var2 = this.field3540[var2];
      class130 var4 = class19.method198(var2 >> 16, -838426399);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2666(true);
      } else {
         class119 var5 = var1.method2666(!var4.method3075(var2, -1291923033));
         var5.method2724(var4, var2);
         return var5;
      }
   }

   public class119 method5221(class119 var1, int var2, class273 var3, int var4, int var5) {
      var2 = this.field3540[var2];
      class130 var6 = class19.method198(var2 >> 16, -838426399);
      var2 &= 65535;
      if(var6 == null) {
         return var3.method5215(var1, var4, -1433585529);
      } else {
         var4 = var3.field3540[var4];
         class130 var7 = class19.method198(var4 >> 16, -838426399);
         var4 &= 65535;
         class119 var8;
         if(var7 == null) {
            var8 = var1.method2666(!var6.method3075(var2, 1439746475));
            var8.method2724(var6, var2);
            return var8;
         } else {
            var8 = var1.method2666(!var6.method3075(var2, 761471264) & !var7.method3075(var4, -74674144));
            var8.method2745(var6, var2, var7, var4, this.field3545);
            return var8;
         }
      }
   }

   class119 method5216(class119 var1, int var2, int var3, int var4) {
      var2 = this.field3540[var2];
      class130 var5 = class19.method198(var2 >> 16, -838426399);
      var2 &= 65535;
      if(var5 == null) {
         return var1.method2666(true);
      } else {
         class119 var6 = var1.method2666(!var5.method3075(var2, 769346872));
         var3 &= 3;
         if(var3 == 1) {
            var6.method2679();
         } else if(var3 == 2) {
            var6.method2678();
         } else if(var3 == 3) {
            var6.method2677();
         }

         var6.method2724(var5, var2);
         if(var3 == 1) {
            var6.method2677();
         } else if(var3 == 2) {
            var6.method2678();
         } else if(var3 == 3) {
            var6.method2679();
         }

         return var6;
      }
   }

   class119 method5217(class119 var1, int var2, byte var3) {
      var2 = this.field3540[var2];
      class130 var4 = class19.method198(var2 >> 16, -838426399);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2667(true);
      } else {
         class119 var5 = var1.method2667(!var4.method3075(var2, 1047814951));
         var5.method2724(var4, var2);
         return var5;
      }
   }

   public class119 method5219(class119 var1, int var2, int var3) {
      int var4 = this.field3540[var2];
      class130 var5 = class19.method198(var4 >> 16, -838426399);
      var4 &= 65535;
      if(var5 == null) {
         return var1.method2666(true);
      } else {
         class130 var6 = null;
         int var7 = 0;
         if(this.field3542 != null && var2 < this.field3542.length) {
            var7 = this.field3542[var2];
            var6 = class19.method198(var7 >> 16, -838426399);
            var7 &= 65535;
         }

         class119 var8;
         if(var6 != null && var7 != 65535) {
            var8 = var1.method2666(!var5.method3075(var4, 2052007030) & !var6.method3075(var7, 1468324273));
            var8.method2724(var5, var4);
            var8.method2724(var6, var7);
            return var8;
         } else {
            var8 = var1.method2666(!var5.method3075(var4, 1907861946));
            var8.method2724(var5, var4);
            return var8;
         }
      }
   }

   void method5220(int var1) {
      if(this.field3551 == -1) {
         if(this.field3545 != null) {
            if(var1 != -1055944735) {
               return;
            }

            this.field3551 = 2;
         } else {
            this.field3551 = 0;
         }
      }

      if(this.field3535 == -1) {
         if(this.field3545 != null) {
            this.field3535 = 2;
         } else {
            this.field3535 = 0;
         }
      }

   }

   void method5212(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method5213(var1, var3, (byte)39);
      }
   }

   static void method5227(class298 var0, class298 var1, class298 var2, boolean var3, int var4) {
      if(var3) {
         class78.field1082 = (class82.field1179 - 765) / 2;
         class78.field1090 = class78.field1082 + 202;
         class78.field1091 = class78.field1090 + 180;
      }

      byte var5;
      int var6;
      int var8;
      int var9;
      int var12;
      int var13;
      int var30;
      int var32;
      int var36;
      int var38;
      int var40;
      if(class78.field1107) {
         if(class166.field2047 == null) {
            class166.field2047 = class21.method279(class175.field2270, "sl_back", "", 563152578);
         }

         if(class13.field85 == null) {
            class13.field85 = class13.method113(class175.field2270, "sl_flags", "", 1362514382);
         }

         if(class126.field1779 == null) {
            if(var4 == 722171039) {
               return;
            }

            class126.field1779 = class13.method113(class175.field2270, "sl_arrows", "", -519610096);
         }

         if(class28.field237 == null) {
            if(var4 == 722171039) {
               return;
            }

            class28.field237 = class13.method113(class175.field2270, "sl_stars", "", 1509627437);
         }

         Rasterizer2D.method5763(class78.field1082, 23, 765, 480, 0);
         Rasterizer2D.method5748(class78.field1082, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method5748(class78.field1082 + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawStr("Select a world", class78.field1082 + 62, 15, 0, -1);
         if(class28.field237 != null) {
            if(var4 == 722171039) {
               return;
            }

            class28.field237[1].method5829(class78.field1082 + 140, 1);
            var1.method5522("Members only world", class78.field1082 + 152, 10, 16777215, -1);
            class28.field237[0].method5829(class78.field1082 + 140, 12);
            var1.method5522("Free world", class78.field1082 + 152, 21, 16777215, -1);
         }

         if(class126.field1779 != null) {
            var30 = class78.field1082 + 280;
            if(class65.field946[0] == 0 && class65.field939[0] == 0) {
               class126.field1779[2].method5829(var30, 4);
            } else {
               class126.field1779[0].method5829(var30, 4);
            }

            label622: {
               if(class65.field946[0] == 0) {
                  if(var4 == 722171039) {
                     return;
                  }

                  if(class65.field939[0] == 1) {
                     class126.field1779[3].method5829(var30 + 15, 4);
                     break label622;
                  }
               }

               class126.field1779[1].method5829(var30 + 15, 4);
            }

            label616: {
               var0.method5522("World", var30 + 32, 17, 16777215, -1);
               var6 = class78.field1082 + 390;
               if(class65.field946[0] == 1) {
                  if(var4 == 722171039) {
                     return;
                  }

                  if(class65.field939[0] == 0) {
                     class126.field1779[2].method5829(var6, 4);
                     break label616;
                  }
               }

               class126.field1779[0].method5829(var6, 4);
            }

            if(class65.field946[0] == 1 && class65.field939[0] == 1) {
               class126.field1779[3].method5829(var6 + 15, 4);
            } else {
               class126.field1779[1].method5829(var6 + 15, 4);
            }

            var0.method5522("Players", var6 + 32, 17, 16777215, -1);
            var32 = class78.field1082 + 500;
            if(class65.field946[0] == 2 && class65.field939[0] == 0) {
               if(var4 == 722171039) {
                  return;
               }

               class126.field1779[2].method5829(var32, 4);
            } else {
               class126.field1779[0].method5829(var32, 4);
            }

            if(class65.field946[0] == 2 && class65.field939[0] == 1) {
               class126.field1779[3].method5829(var32 + 15, 4);
            } else {
               class126.field1779[1].method5829(var32 + 15, 4);
            }

            var0.method5522("Location", var32 + 32, 17, 16777215, -1);
            var8 = class78.field1082 + 610;
            if(class65.field946[0] == 3 && class65.field939[0] == 0) {
               if(var4 == 722171039) {
                  return;
               }

               class126.field1779[2].method5829(var8, 4);
            } else {
               class126.field1779[0].method5829(var8, 4);
            }

            if(class65.field946[0] == 3 && class65.field939[0] == 1) {
               class126.field1779[3].method5829(var8 + 15, 4);
            } else {
               class126.field1779[1].method5829(var8 + 15, 4);
            }

            var0.method5522("Type", var8 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method5763(class78.field1082 + 708, 4, 50, 16, 0);
         var1.drawStr("Cancel", class78.field1082 + 708 + 25, 16, 16777215, -1);
         class78.field1116 = -1;
         if(class166.field2047 != null) {
            var5 = 88;
            byte var39 = 19;
            var32 = 765 / (var5 + 1);
            var8 = 480 / (var39 + 1);

            while(true) {
               var9 = var8;
               var36 = var32;
               if(var8 * (var32 - 1) >= class65.field945) {
                  --var32;
               }

               if(var32 * (var8 - 1) >= class65.field945) {
                  --var8;
               }

               if(var32 * (var8 - 1) >= class65.field945) {
                  if(var4 == 722171039) {
                     return;
                  }

                  --var8;
               }

               if(var9 == var8 && var32 == var36) {
                  var9 = (765 - var5 * var32) / (var32 + 1);
                  if(var9 > 5) {
                     if(var4 == 722171039) {
                        return;
                     }

                     var9 = 5;
                  }

                  var36 = (480 - var39 * var8) / (var8 + 1);
                  if(var36 > 5) {
                     var36 = 5;
                  }

                  var38 = (765 - var5 * var32 - var9 * (var32 - 1)) / 2;
                  var12 = (480 - var8 * var39 - var36 * (var8 - 1)) / 2;
                  var13 = var12 + 23;
                  var40 = var38 + class78.field1082;
                  int var41 = 0;
                  boolean var42 = false;

                  int var43;
                  for(var43 = 0; var43 < class65.field945; var43++) {
                     if(var4 == 722171039) {
                        return;
                     }

                     class65 var18 = class65.field949[var43];
                     boolean var19 = true;
                     String var20 = Integer.toString(var18.field955);
                     if(var18.field955 == -1) {
                        var20 = "OFF";
                        var19 = false;
                     } else if(var18.field955 > 1980) {
                        var20 = "FULL";
                        var19 = false;
                     }

                     int var22 = 0;
                     byte var21;
                     if(var18.method1577(753404361)) {
                        if(var18.method1589((byte)66)) {
                           var21 = 7;
                        } else {
                           var21 = 6;
                        }
                     } else if(var18.method1570(185165272)) {
                        if(var4 == 722171039) {
                           return;
                        }

                        var22 = 16711680;
                        if(var18.method1589((byte)42)) {
                           var21 = 5;
                        } else {
                           var21 = 4;
                        }
                     } else if(var18.method1568((byte)83)) {
                        if(var18.method1589((byte)67)) {
                           var21 = 3;
                        } else {
                           var21 = 2;
                        }
                     } else if(var18.method1589((byte)86)) {
                        var21 = 1;
                     } else {
                        var21 = 0;
                     }

                     label572: {
                        if(class48.field425 >= var40 && class48.field426 * 673804999 >= var13 && class48.field425 < var40 + var5 && class48.field426 * 673804999 < var39 + var13) {
                           if(var4 == 722171039) {
                              return;
                           }

                           if(var19) {
                              class78.field1116 = var43;
                              class166.field2047[var21].method5855(var40, var13, 128, 16777215);
                              var42 = true;
                              break label572;
                           }
                        }

                        class166.field2047[var21].method5849(var40, var13);
                     }

                     if(class13.field85 != null) {
                        class13.field85[(var18.method1589((byte)98) ? 8 : 0) + var18.field952].method5829(var40 + 29, var13);
                     }

                     var0.drawStr(Integer.toString(var18.field947), var40 + 15, var39 / 2 + var13 + 5, var22, -1);
                     var1.drawStr(var20, var40 + 60, var39 / 2 + var13 + 5, 268435455, -1);
                     var13 = var13 + var39 + var36;
                     ++var41;
                     if(var41 >= var8) {
                        var13 = var12 + 23;
                        var40 = var40 + var5 + var9;
                        var41 = 0;
                     }
                  }

                  if(var42) {
                     var43 = var1.method5517(class65.field949[class78.field1116].field951) + 6;
                     int var27 = var1.field3695 + 8;
                     Rasterizer2D.method5763(class48.field425 - var43 / 2, class48.field426 * 673804999 + 20 + 5, var43, var27, 16777120);
                     Rasterizer2D.method5734(class48.field425 - var43 / 2, class48.field426 * 673804999 + 20 + 5, var43, var27, 0);
                     var1.drawStr(class65.field949[class78.field1116].field951, class48.field425, class48.field426 * 673804999 + var1.field3695 + 20 + 5 + 4, 0, -1);
                  }
                  break;
               }
            }
         }

         class163.field2014.vmethod5809(0, 0, -1986786716);
      } else {
         if(var3) {
            class78.titleImage.method5849(class78.field1082, 0);
            class78.titleImageRight.method5849(class78.field1082 + 382, 0);
            //class78.logo.method5829(class78.field1082 + 382 - class78.logo.width1 / 2, 18);
         }

         if(GameClient.field589 == 0 || GameClient.field589 == 5) {
            var5 = 20;
            var0.drawStr("RuneScape is loading - please wait...", class78.field1090 + 180, 245 - var5, 16777215, -1);
            var6 = 253 - var5;
            Rasterizer2D.method5734(class78.field1090 + 180 - 152, var6, 304, 34, 9179409);
            Rasterizer2D.method5734(class78.field1090 + 180 - 151, var6 + 1, 302, 32, 0);
            Rasterizer2D.method5763(class78.field1090 + 180 - 150, var6 + 2, class78.field1099 * 3, 30, 9179409);
            Rasterizer2D.method5763(class78.field1099 * 3 + (class78.field1090 + 180 - 150), var6 + 2, 300 - class78.field1099 * 3, 30, 0);
            var0.drawStr(class78.field1100, class78.field1090 + 180, 276 - var5, 16777215, -1);
         }

         String var23;
         short var29;
         short var31;
         if(GameClient.field589 == 20) {
            if(var4 == 722171039) {
               return;
            }

            class78.field1083.method5829(class78.field1090 + 180 - class78.field1083.width1 / 2, 271 - class78.field1083.height1 / 2);
            var29 = 201;
            var0.drawStr(class78.field1103, class78.field1090 + 180, var29, 16776960, 0);
            var30 = var29 + 15;
            var0.drawStr(class78.field1112, class78.field1090 + 180, var30, 16776960, 0);
            var30 += 15;
            var0.drawStr(class78.field1105, class78.field1090 + 180, var30, 16776960, 0);
            var30 += 15;
            var30 += 7;
            if(class78.field1081 != 4) {
               var0.method5522("Login: ", class78.field1090 + 180 - 110, var30, 16777215, 0);
               var31 = 200;

               for(var23 = class59.method1076(249825908); var0.method5517(var23) > var31; var23 = var23.substring(0, var23.length() - 1)) {
                  ;
               }

               var0.method5522(class299.method5521(var23), class78.field1090 + 180 - 70, var30, 16777215, 0);
               var30 += 15;
               var0.method5522("Password: " + class265.method4976(class78.field1086, (short)-15504), class78.field1090 + 180 - 108, var30, 16777215, 0);
               var30 += 15;
            }
         }

         label730: {
            if(GameClient.field589 != 10) {
               if(var4 == 722171039) {
                  return;
               }

               if(GameClient.field589 != 11) {
                  break label730;
               }

               if(var4 == 722171039) {
                  return;
               }
            }

            class78.field1083.method5829(class78.field1090, 171);
            short var7;
            if(class78.field1081 == 0) {
               if(var4 == 722171039) {
                  return;
               }

               var29 = 251;
               var0.drawStr("Welcome to RuneScape", class78.field1090 + 180, var29, 16776960, 0);
               var30 = var29 + 30;
               var6 = class78.field1090 + 180 - 80;
               var7 = 291;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var0.method5526("New User", var6 - 73, var7 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var6 = class78.field1090 + 180 + 80;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var0.method5526("Existing User", var6 - 73, var7 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class78.field1081 == 1) {
               var0.drawStr(class78.field1098, class78.field1090 + 180, 201, 16776960, 0);
               var29 = 236;
               var0.drawStr(class78.field1103, class78.field1090 + 180, var29, 16777215, 0);
               var30 = var29 + 15;
               var0.drawStr(class78.field1112, class78.field1090 + 180, var30, 16777215, 0);
               var30 += 15;
               var0.drawStr(class78.field1105, class78.field1090 + 180, var30, 16777215, 0);
               var30 += 15;
               var6 = class78.field1090 + 180 - 80;
               var7 = 321;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var0.drawStr("Continue", var6, var7 + 5, 16777215, 0);
               var6 = class78.field1090 + 180 + 80;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var0.drawStr("Cancel", var6, var7 + 5, 16777215, 0);
            } else if(class78.field1081 == 2) {
               if(var4 == 722171039) {
                  return;
               }

               var29 = 201;
               var0.drawStr(class78.field1103, class78.field1091, var29, 16776960, 0);
               var30 = var29 + 15;
               var0.drawStr(class78.field1112, class78.field1091, var30, 16776960, 0);
               var30 += 15;
               var0.drawStr(class78.field1105, class78.field1091, var30, 16776960, 0);
               var30 += 15;
               var30 += 7;
               var0.method5522("Login: ", class78.field1091 - 110, var30, 16777215, 0);
               var31 = 200;

               for(var23 = class59.method1076(72370527); var0.method5517(var23) > var31; var23 = var23.substring(1)) {
                  ;
               }

               var0.method5522(class299.method5521(var23) + (class78.field1102 == 0 & GameClient.field591 % 40 < 20 ? class6.method71(16776960) + "|" : ""), class78.field1091 - 70, var30, 16777215, 0);
               var30 += 15;
               StringBuilder var10001 = (new StringBuilder()).append("Password: ").append(class265.method4976(class78.field1086, (short)12688));
               boolean var10002 = class78.field1102 == 1;
               boolean var10003;
               if(GameClient.field591 % 40 < 20) {
                  if(var4 == 722171039) {
                     return;
                  }

                  var10003 = true;
               } else {
                  var10003 = false;
               }

               var0.method5522(var10001.append(var10002 & var10003 ? class6.method71(16776960) + "|" : "").toString(), class78.field1091 - 108, var30, 16777215, 0);
               var30 += 15;
               var29 = 277;
               var8 = class78.field1091 + -117;
               boolean var10 = class78.field1108;
               boolean var11 = class78.field1110;
               PaletteSprite var10000;
               if(var10) {
                  if(var4 == 722171039) {
                     return;
                  }

                  if(var11) {
                     if(var4 == 722171039) {
                        return;
                     }

                     var10000 = class53.field472;
                  } else {
                     var10000 = class78.field1089;
                  }
               } else {
                  var10000 = var11 ? class102.field1352 : class235.field2783;
               }

               PaletteSprite var24 = var10000;
               var24.method5829(var8, var29);
               var8 = var8 + var24.width1 + 5;
               var1.method5522("Remember username", var8, var29 + 13, 16776960, 0);
               var8 = class78.field1091 + 24;
               boolean var14 = class10.field61.field962;
               boolean var15 = class78.field1115;
               PaletteSprite var26 = var14 ? (var15 ? class53.field472 : class78.field1089) : (var15 ? class102.field1352 : class235.field2783);
               var26.method5829(var8, var29);
               var8 = var8 + var26.width1 + 5;
               var1.method5522("Hide username", var8, var29 + 13, 16776960, 0);
               var30 = var29 + 15;
               int var16 = class78.field1091 - 80;
               short var17 = 321;
               class78.field1084.method5829(var16 - 73, var17 - 20);
               var0.drawStr("Login", var16, var17 + 5, 16777215, 0);
               var16 = class78.field1091 + 80;
               class78.field1084.method5829(var16 - 73, var17 - 20);
               var0.drawStr("Cancel", var16, var17 + 5, 16777215, 0);
               var29 = 357;
               var1.drawStr("Forgotten your password? <col=ffffff>Click here.", class78.field1091, var29, 16776960, 0);
            } else if(class78.field1081 == 3) {
               var29 = 201;
               var0.drawStr("Invalid username or password.", class78.field1090 + 180, var29, 16776960, 0);
               var30 = var29 + 20;
               var1.drawStr("For accounts created after 24th November 2010, please use your", class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var1.drawStr("email address to login. Otherwise please login with your username.", class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var6 = class78.field1090 + 180;
               var7 = 276;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var2.drawStr("Try again", var6, var7 + 5, 16777215, 0);
               var6 = class78.field1090 + 180;
               var7 = 326;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var2.drawStr("Forgotten password?", var6, var7 + 5, 16777215, 0);
            } else if(class78.field1081 == 4) {
               if(var4 == 722171039) {
                  return;
               }

               var0.drawStr("Authenticator", class78.field1090 + 180, 201, 16776960, 0);
               var29 = 236;
               var0.drawStr(class78.field1103, class78.field1090 + 180, var29, 16777215, 0);
               var30 = var29 + 15;
               var0.drawStr(class78.field1112, class78.field1090 + 180, var30, 16777215, 0);
               var30 += 15;
               var0.drawStr(class78.field1105, class78.field1090 + 180, var30, 16777215, 0);
               var30 += 15;
               var0.method5522("PIN: " + class265.method4976(class28.field238, (short)7988) + (GameClient.field591 % 40 < 20 ? class6.method71(16776960) + "|" : ""), class78.field1090 + 180 - 108, var30, 16777215, 0);
               var30 -= 8;
               var0.method5522("Trust this computer", class78.field1090 + 180 - 9, var30, 16776960, 0);
               var30 += 15;
               var0.method5522("for 30 days: ", class78.field1090 + 180 - 9, var30, 16776960, 0);
               var6 = class78.field1090 + 180 - 9 + var0.method5517("for 30 days: ") + 15;
               var32 = var30 - var0.field3695;
               PaletteSprite var28;
               if(class78.field1104) {
                  if(var4 == 722171039) {
                     return;
                  }

                  var28 = class78.field1089;
               } else {
                  var28 = class235.field2783;
               }

               var28.method5829(var6, var32);
               var30 += 15;
               var9 = class78.field1090 + 180 - 80;
               short var35 = 321;
               class78.field1084.method5829(var9 - 73, var35 - 20);
               var0.drawStr("Continue", var9, var35 + 5, 16777215, 0);
               var9 = class78.field1090 + 180 + 80;
               class78.field1084.method5829(var9 - 73, var35 - 20);
               var0.drawStr("Cancel", var9, var35 + 5, 16777215, 0);
               var1.drawStr("<u=ff>Can\'t Log In?</u>", class78.field1090 + 180, var35 + 36, 255, 0);
            } else if(class78.field1081 == 5) {
               var0.drawStr("Forgotten your password?", class78.field1090 + 180, 201, 16776960, 0);
               var29 = 221;
               var2.drawStr(class78.field1103, class78.field1090 + 180, var29, 16776960, 0);
               var30 = var29 + 15;
               var2.drawStr(class78.field1112, class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var2.drawStr(class78.field1105, class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var30 += 14;
               var0.method5522("Username/email: ", class78.field1090 + 180 - 145, var30, 16777215, 0);
               var31 = 174;

               for(var23 = class59.method1076(-49215179); var0.method5517(var23) > var31; var23 = var23.substring(1)) {
                  ;
               }

               var0.method5522(class299.method5521(var23) + (GameClient.field591 % 40 < 20 ? class6.method71(16776960) + "|" : ""), class78.field1090 + 180 - 34, var30, 16777215, 0);
               var30 += 15;
               var8 = class78.field1090 + 180 - 80;
               short var33 = 321;
               class78.field1084.method5829(var8 - 73, var33 - 20);
               var0.drawStr("Recover", var8, var33 + 5, 16777215, 0);
               var8 = class78.field1090 + 180 + 80;
               class78.field1084.method5829(var8 - 73, var33 - 20);
               var0.drawStr("Back", var8, var33 + 5, 16777215, 0);
            } else if(class78.field1081 == 6) {
               if(var4 == 722171039) {
                  return;
               }

               var29 = 201;
               var0.drawStr(class78.field1103, class78.field1090 + 180, var29, 16776960, 0);
               var30 = var29 + 15;
               var0.drawStr(class78.field1112, class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var0.drawStr(class78.field1105, class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var6 = class78.field1090 + 180;
               var7 = 321;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var0.drawStr("Back", var6, var7 + 5, 16777215, 0);
            } else if(class78.field1081 == 7) {
               var29 = 216;
               var0.drawStr("Your date of birth isn\'t set.", class78.field1090 + 180, var29, 16776960, 0);
               var30 = var29 + 15;
               var2.drawStr("Please verify your account status by", class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var2.drawStr("setting your date of birth.", class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var6 = class78.field1090 + 180 - 80;
               var7 = 321;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var0.drawStr("Set Date of Birth", var6, var7 + 5, 16777215, 0);
               var6 = class78.field1090 + 180 + 80;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var0.drawStr("Back", var6, var7 + 5, 16777215, 0);
            } else if(class78.field1081 == 8) {
               var29 = 216;
               var0.drawStr("Sorry, but your account is not eligible to play.", class78.field1090 + 180, var29, 16776960, 0);
               var30 = var29 + 15;
               var2.drawStr("For more information, please take a look at", class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var2.drawStr("our privacy policy.", class78.field1090 + 180, var30, 16776960, 0);
               var30 += 15;
               var6 = class78.field1090 + 180 - 80;
               var7 = 321;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var0.drawStr("Privacy Policy", var6, var7 + 5, 16777215, 0);
               var6 = class78.field1090 + 180 + 80;
               class78.field1084.method5829(var6 - 73, var7 - 20);
               var0.drawStr("Back", var6, var7 + 5, 16777215, 0);
            }
         }

         if(class78.field1097 > 0 && false) { // Runes
            var30 = class78.field1097;
            var31 = 256;
            class78.field1095 += var30 * 128;
            if(class78.field1095 > class186.field2367.length) {
               class78.field1095 -= class186.field2367.length;
               var32 = (int)(Math.random() * 12.0D);
               class67.method1682(class78.field1111[var32], (byte)-7);
            }

            var32 = 0;
            var8 = var30 * 128;
            var9 = (var31 - var30) * 128;

            for(var36 = 0; var36 < var9; var36++) {
               var38 = class40.field357[var8 + var32] - class186.field2367[var32 + class78.field1095 & class186.field2367.length - 1] * var30 / 6;
               if(var38 < 0) {
                  var38 = 0;
               }

               class40.field357[var32++] = var38;
            }

            for(var36 = var31 - var30; var36 < var31; var36++) {
               var38 = var36 * 128;

               for(var12 = 0; var12 < 128; var12++) {
                  var13 = (int)(Math.random() * 100.0D);
                  if(var13 < 50 && var12 > 10) {
                     if(var4 == 722171039) {
                        return;
                     }

                     if(var12 < 118) {
                        class40.field357[var12 + var38] = 255;
                        continue;
                     }
                  }

                  class40.field357[var38 + var12] = 0;
               }
            }

            if(class78.field1088 > 0) {
               class78.field1088 -= var30 * 4;
            }

            if(class78.field1094 > 0) {
               if(var4 == 722171039) {
                  return;
               }

               class78.field1094 -= var30 * 4;
            }

            if(class78.field1088 == 0 && class78.field1094 == 0) {
               var36 = (int)(Math.random() * (double)(2000 / var30));
               if(var36 == 0) {
                  if(var4 == 722171039) {
                     return;
                  }

                  class78.field1088 = 1024;
               }

               if(var36 == 1) {
                  class78.field1094 = 1024;
               }
            }

            for(var36 = 0; var36 < var31 - var30; var36++) {
               class78.field1093[var36] = class78.field1093[var30 + var36];
            }

            for(var36 = var31 - var30; var36 < var31; var36++) {
               class78.field1093[var36] = (int)(Math.sin((double)class78.field1114 / 14.0D) * 16.0D + Math.sin((double)class78.field1114 / 15.0D) * 14.0D + Math.sin((double)class78.field1114 / 16.0D) * 12.0D);
               ++class78.field1114;
            }

            class78.field1096 += var30;
            var36 = (var30 + (GameClient.field591 & 1)) / 2;
            if(var36 > 0) {
               for(var38 = 0; var38 < class78.field1096 * 100; var38++) {
                  if(var4 == 722171039) {
                     return;
                  }

                  var12 = (int)(Math.random() * 124.0D) + 2;
                  var13 = (int)(Math.random() * 128.0D) + 128;
                  class40.field357[var12 + (var13 << 7)] = 192;
               }

               class78.field1096 = 0;
               var38 = 0;

               label659:
               while(true) {
                  if(var38 >= var31) {
                     var38 = 0;

                     while(true) {
                        if(var38 >= 128) {
                           break label659;
                        }

                        var12 = 0;

                        for(var13 = -var36; var13 < var31; var13++) {
                           var40 = var13 * 128;
                           if(var13 + var36 < var31) {
                              var12 += class76.field1073[var36 * 128 + var40 + var38];
                           }

                           if(var13 - (var36 + 1) >= 0) {
                              var12 -= class76.field1073[var40 + var38 - (var36 + 1) * 128];
                           }

                           if(var13 >= 0) {
                              class40.field357[var40 + var38] = var12 / (var36 * 2 + 1);
                           }
                        }

                        ++var38;
                     }
                  }

                  var12 = 0;
                  var13 = var38 * 128;

                  for(var40 = -var36; var40 < 128; var40++) {
                     if(var4 == 722171039) {
                        return;
                     }

                     if(var36 + var40 < 128) {
                        var12 += class40.field357[var40 + var13 + var36];
                     }

                     if(var40 - (var36 + 1) >= 0) {
                        var12 -= class40.field357[var13 + var40 - (var36 + 1)];
                     }

                     if(var40 >= 0) {
                        class76.field1073[var40 + var13] = var12 / (var36 * 2 + 1);
                     }
                  }

                  ++var38;
               }
            }

            class78.field1097 = 0;
         }

         class133.method3098((byte)30);
         PaletteSprite[] var44 = class124.field1708;
         byte var46;
         if(class10.field61.field958) {
            if(var4 == 722171039) {
               return;
            }

            var46 = 1;
         } else {
            var46 = 0;
         }

         var44[var46].method5829(class78.field1082 + 765 - 40, 463);
         if(GameClient.field589 > 5 && GameClient.field827 == 0) {
            if(class232.field2752 != null) {
               var30 = class78.field1082 + 5;
               var31 = 463;
               byte var37 = 100;
               byte var34 = 35;
               class232.field2752.method5829(var30, var31);
               var0.drawStr("World" + " " + GameClient.field581, var37 / 2 + var30, var34 / 2 + var31 - 2, 16777215, 0);
               if(class49.field439 != null) {
                  var1.drawStr("Loading...", var37 / 2 + var30, var34 / 2 + var31 + 12, 16777215, 0);
               } else {
                  var1.drawStr("Click to switch", var37 / 2 + var30, var34 / 2 + var31 + 12, 16777215, 0);
               }
            } else {
               class232.field2752 = class221.method4374(class175.field2270, "sl_button", "", 1835582979);
            }
         }

      }
   }
}
