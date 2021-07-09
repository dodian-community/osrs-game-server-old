package client;

public class class102 {
   static PaletteSprite field1352;
   static final int field1347 = 73;
   static final int field1348 = 6;
   static final int field1349 = 7;
   static final int field1353 = 24;
   static final int field1354 = 14;
   int[][] field1351;
   int field1350;
   int field1346;

   public class102(int var1, int var2) {
      if(var2 != var1) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1346 = var1;
         this.field1350 = var2;
         this.field1351 = new int[var1][14];

         for(int var7 = 0; var7 < var1; var7++) {
            int[] var8 = this.field1351[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
            int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(7.0D + var9);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; var11++) {
               double var15 = ((double)var11 - var9) * 3.141592653589793D;
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var11 - var9));
               var8[var11] = (int)Math.floor(var17 * 65536.0D + 0.5D);
            }
         }

      }
   }

   byte[] method2239(byte[] var1, int var2) {
      if(this.field1351 != null) {
         int var3 = (int)((long)this.field1350 * (long)var1.length / (long)this.field1346) + 14;
         int[] var4 = new int[var3];
         int var5 = 0;
         int var6 = 0;

         int var7;
         for(var7 = 0; var7 < var1.length; var7++) {
            byte var8 = var1[var7];
            int[] var9 = this.field1351[var6];

            int var10;
            for(var10 = 0; var10 < 14; var10++) {
               var4[var5 + var10] += var8 * var9[var10];
            }

            var6 += this.field1350;
            var10 = var6 / this.field1346;
            var5 += var10;
            var6 -= var10 * this.field1346;
         }

         var1 = new byte[var3];

         for(var7 = 0; var7 < var3; var7++) {
            int var11 = var4[var7] + 32768 >> 16;
            if(var11 < -128) {
               var1[var7] = -128;
            } else if(var11 > 127) {
               var1[var7] = 127;
            } else {
               var1[var7] = (byte)var11;
            }
         }
      }

      return var1;
   }

   int method2240(int var1, int var2) {
      if(this.field1351 != null) {
         var1 = (int)((long)var1 * (long)this.field1350 / (long)this.field1346);
      }

      return var1;
   }

   int method2241(int var1, int var2) {
      if(this.field1351 != null) {
         var1 = (int)((long)this.field1350 * (long)var1 / (long)this.field1346) + 6;
      }

      return var1;
   }

   public static boolean method2249(CharSequence var0, byte var1) {
      boolean var3 = false;
      boolean var4 = false;
      int var5 = 0;
      int var6 = var0.length();
      int var7 = 0;

      boolean var2;
      while(true) {
         if(var7 >= var6) {
            var2 = var4;
            break;
         }

         label86: {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  break label86;
               }

               if(var8 == 43) {
                  break label86;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  var2 = false;
                  break;
               }

               var10 = var8 - 87;
            }

            if(var10 >= 10) {
               var2 = false;
               break;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * 10 + var10;
            if(var5 != var9 / 10) {
               var2 = false;
               break;
            }

            var5 = var9;
            var4 = true;
         }

         ++var7;
      }

      return var2;
   }

   static int method2238(int instruction, class84 var1, boolean var2) {
      int var5 = -1;
      Widget widget_4;
      if(instruction >= 2000) {
         instruction -= 1000;
         var5 = class69.field999[--class69.field1003];
         widget_4 = Widget.getLoaded(var5);
      } else {
         widget_4 = var2 ? class276.field3561 : class260.field3301;
      }

      if(instruction == 1100) {
         class69.field1003 -= 2;
         widget_4.field2626 = class69.field999[class69.field1003];
         if(widget_4.field2626 > widget_4.scrollWidth - widget_4.int472) {
            widget_4.field2626 = widget_4.scrollWidth - widget_4.int472;
         }

         if(widget_4.field2626 < 0) {
            widget_4.field2626 = 0;
         }

         widget_4.scrollY = class69.field999[class69.field1003 + 1];
         if(widget_4.scrollY > widget_4.scrollHeight - widget_4.int466) {
            widget_4.scrollY = widget_4.scrollHeight - widget_4.int466;
         }

         if(widget_4.scrollY < 0) {
            widget_4.scrollY = 0;
         }

         GameClient.requestRedraw(widget_4);
         return 1;
      } else if(instruction == 1101) {
         widget_4.color = class69.field999[--class69.field1003];
         GameClient.requestRedraw(widget_4);
         return 1;
      } else if(instruction == 1102) {
         --class69.field1003;
         widget_4.filled = class69.field999[class69.field1003] == 1;
         GameClient.requestRedraw(widget_4);
         return 1;
      } else if(instruction == 1103) {
         widget_4.alpha = class69.field999[--class69.field1003];
         GameClient.requestRedraw(widget_4);
         return 1;
      } else if(instruction == 1104) {
         widget_4.int461 = class69.field999[--class69.field1003];
         GameClient.requestRedraw(widget_4);
         return 1;
      } else if(instruction == 1105) {
         widget_4.spriteId = class69.field999[--class69.field1003];
         GameClient.requestRedraw(widget_4);
         return 1;
      } else if(instruction == 1106) {
         widget_4.int436 = class69.field999[--class69.field1003];
         GameClient.requestRedraw(widget_4);
         return 1;
      } else if(instruction == 1107) {
         --class69.field1003;
         widget_4.bool42 = class69.field999[class69.field1003] == 1;
         GameClient.requestRedraw(widget_4);
         return 1;
      } else if(instruction == 1108) {
         widget_4.mediaType = 1;
         widget_4.mediaID = class69.field999[--class69.field1003];
         GameClient.requestRedraw(widget_4);
         return 1;
      } else if(instruction == 1109) {
         class69.field1003 -= 6;
         widget_4.int457 = class69.field999[class69.field1003];
         widget_4.int474 = class69.field999[class69.field1003 + 1];
         widget_4.rotationX = class69.field999[class69.field1003 + 2];
         widget_4.rotationY = class69.field999[class69.field1003 + 3];
         widget_4.int477 = class69.field999[class69.field1003 + 4];
         widget_4.zoom = class69.field999[class69.field1003 + 5];
         GameClient.requestRedraw(widget_4);
         return 1;
      } else {
         int var9;
         if(instruction == 1110) {
            var9 = class69.field999[--class69.field1003];
            if(var9 != widget_4.animation) {
               widget_4.animation = var9;
               widget_4.field2728 = 0;
               widget_4.field2613 = 0;
               GameClient.requestRedraw(widget_4);
            }

            return 1;
         } else if(instruction == 1111) {
            --class69.field1003;
            widget_4.bool45 = class69.field999[class69.field1003] == 1;
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1112) {
            String string = class69.field1001[--class55.field497];
            if(!string.equals(widget_4.componentString)) {
               widget_4.componentString = string;
               GameClient.requestRedraw(widget_4);
            }

            Custom.Cs2.parseInst1112(0, string, widget_4);
            return 1;
         } else if(instruction == 1113) {
            widget_4.fontId = class69.field999[--class69.field1003];
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1114) {
            class69.field1003 -= 3;
            widget_4.fontHorizontalAlignment = class69.field999[class69.field1003];
            widget_4.fontVerticalAlignment = class69.field999[class69.field1003 + 1];
            widget_4.lineHeight = class69.field999[class69.field1003 + 2];
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1115) {
            --class69.field1003;
            widget_4.fontShadow = class69.field999[class69.field1003] == 1;
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1116) {
            widget_4.outline = class69.field999[--class69.field1003];
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1117) {
            widget_4.shadow = class69.field999[--class69.field1003];
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1118) {
            --class69.field1003;
            widget_4.flipHorizontal = class69.field999[class69.field1003] == 1;
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1119) {
            --class69.field1003;
            widget_4.flipVertical = class69.field999[class69.field1003] == 1;
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1120) {
            class69.field1003 -= 2;
            widget_4.scrollWidth = class69.field999[class69.field1003];
            widget_4.scrollHeight = class69.field999[class69.field1003 + 1];
            ShopInterface.e(widget_4);
            GameClient.requestRedraw(widget_4);
            if(var5 != -1 && widget_4.widgetType == 0) {
               class163.method3388(Widget.LOADED[var5 >> 16], widget_4, false, 1417968993);
            }

            return 1;
         } else if(instruction == 1121) {
            class82.method1921(widget_4.interfaceHash, widget_4.childId, (byte)-101);
            GameClient.field744 = widget_4;
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1122) {
            widget_4.field2641 = class69.field999[--class69.field1003];
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1123) {
            widget_4.field2631 = class69.field999[--class69.field1003];
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1124) {
            widget_4.field2608 = class69.field999[--class69.field1003];
            GameClient.requestRedraw(widget_4);
            return 1;
         } else if(instruction == 1125) {
            var9 = class69.field999[--class69.field1003];
            class316 var7 = (class316)class76.method1803(class23.method423((byte)-13), var9, (byte)0);
            if(var7 != null) {
               widget_4.field2701 = var7;
               GameClient.requestRedraw(widget_4);
            }

            return 1;
         } else {
            boolean var6;
            if(instruction == 1126) {
               --class69.field1003;
               var6 = class69.field999[class69.field1003] == 1;
               widget_4.bool41 = var6;
               return 1;
            } else if(instruction == 1127) {
               --class69.field1003;
               var6 = class69.field999[class69.field1003] == 1;
               widget_4.field2726 = var6;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }

   static final int method2248(int var0, int var1, int var2) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
