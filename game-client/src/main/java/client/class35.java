package client;

public class class35 {
   static final int field305 = 105;
   byte[][][] field304;
   int field303;

   class35(int var1) {
      this.field303 = var1;
   }

   void method593(int var1) {
      byte[] var2 = new byte[this.field303 * this.field303];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field303; var4++) {
         if(var1 == 2134196196) {
            return;
         }

         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 <= var4) {
               if(var1 == 2134196196) {
                  return;
               }

               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[0][0] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 <= var4) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[0][1] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         if(var1 == 2134196196) {
            return;
         }

         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 >= var4) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[0][2] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var1 == 2134196196) {
               return;
            }

            if(var5 >= var4) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[0][3] = var2;
   }

   int method590(int var1, int var2, byte var3) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   void method625(int var1) {
      byte[] var2 = new byte[this.field303 * this.field303];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 <= var4 >> 1) {
               if(var1 <= 841154269) {
                  return;
               }

               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[1][0] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var3 >= 0 && var3 < var2.length) {
               if(var5 >= var4 << 1) {
                  var2[var3] = -1;
               }

               ++var3;
            } else {
               ++var3;
            }
         }
      }

      this.field304[1][1] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 <= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[1][2] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var1 <= 841154269) {
               return;
            }

            if(var5 >= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[1][3] = var2;
   }

   int method591(int var1, int var2) {
      return var1 != 9 && var1 != 10 ? (var1 == 11 ? 8 : var1) : 1;
   }

   void method607(byte var1) {
      byte[] var2 = new byte[this.field303 * this.field303];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 <= var4 >> 1) {
               if(var1 != 1) {
                  return;
               }

               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[2][0] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         if(var1 != 1) {
            return;
         }

         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 >= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[2][1] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var1 != 1) {
               return;
            }

            if(var5 <= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[2][2] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         if(var1 != 1) {
            return;
         }

         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 >= var4 << 1) {
               if(var1 != 1) {
                  return;
               }

               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[2][3] = var2;
   }

   void method596(int var1) {
      byte[] var2 = new byte[this.field303 * this.field303];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 >= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[3][0] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 <= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[3][1] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 >= var4 >> 1) {
               if(var1 != -1650929653) {
                  return;
               }

               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[3][2] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var1 != -1650929653) {
               return;
            }

            if(var5 <= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[3][3] = var2;
   }

   void method612(byte var1) {
      byte[] var2 = new byte[this.field303 * this.field303];
      int var3 = 0;

      int var4;
      int var5;
      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 >= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[4][0] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 <= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[4][1] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 >= var4 >> 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[4][2] = var2;
      var2 = new byte[this.field303 * this.field303];
      var3 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 <= var4 << 1) {
               var2[var3] = -1;
            }

            ++var3;
         }
      }

      this.field304[4][3] = var2;
   }

   void method598(int var1) {
      byte[] var2 = new byte[this.field303 * this.field303];
      boolean var3 = false;
      var2 = new byte[this.field303 * this.field303];
      int var6 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 <= this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[5][0] = var2;
      var2 = new byte[this.field303 * this.field303];
      var6 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var4 <= this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[5][1] = var2;
      var2 = new byte[this.field303 * this.field303];
      var6 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 >= this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[5][2] = var2;
      var2 = new byte[this.field303 * this.field303];
      var6 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var1 <= 1895069932) {
               return;
            }

            if(var4 >= this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[5][3] = var2;
   }

   void method629(int var1) {
      byte[] var2 = new byte[this.field303 * this.field303];
      boolean var3 = false;
      var2 = new byte[this.field303 * this.field303];
      int var6 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 <= var4 - this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[6][0] = var2;
      var2 = new byte[this.field303 * this.field303];
      var6 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 <= var4 - this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[6][1] = var2;
      var2 = new byte[this.field303 * this.field303];
      var6 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 <= var4 - this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[6][2] = var2;
      var2 = new byte[this.field303 * this.field303];
      var6 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         if(var1 >= -1234768039) {
            return;
         }

         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 <= var4 - this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[6][3] = var2;
   }

   void method595(int var1) {
      byte[] var2 = new byte[this.field303 * this.field303];
      boolean var3 = false;
      var2 = new byte[this.field303 * this.field303];
      int var6 = 0;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field303; var4++) {
         if(var1 == 1025348025) {
            return;
         }

         for(var5 = 0; var5 < this.field303; var5++) {
            if(var1 == 1025348025) {
               return;
            }

            if(var5 >= var4 - this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[7][0] = var2;
      var2 = new byte[this.field303 * this.field303];
      var6 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         for(var5 = 0; var5 < this.field303; var5++) {
            if(var5 >= var4 - this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[7][1] = var2;
      var2 = new byte[this.field303 * this.field303];
      var6 = 0;

      for(var4 = this.field303 - 1; var4 >= 0; --var4) {
         if(var1 == 1025348025) {
            return;
         }

         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 >= var4 - this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[7][2] = var2;
      var2 = new byte[this.field303 * this.field303];
      var6 = 0;

      for(var4 = 0; var4 < this.field303; var4++) {
         for(var5 = this.field303 - 1; var5 >= 0; --var5) {
            if(var5 >= var4 - this.field303 / 2) {
               var2[var6] = -1;
            }

            ++var6;
         }
      }

      this.field304[7][3] = var2;
   }

   void method592(int var1) {
      if(this.field304 == null) {
         this.field304 = new byte[8][4][];
         this.method593(-515491785);
         this.method625(2050739130);
         this.method607((byte)1);
         this.method596(-1650929653);
         this.method612((byte)1);
         this.method598(1963710771);
         this.method629(-2053571695);
         this.method595(335208223);
      }
   }

   void method606(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      if(var7 != 0 && this.field303 != 0 && this.field304 != null) {
         var8 = this.method590(var8, var7, (byte)103);
         var7 = this.method591(var7, -1021725892);
         Rasterizer2D.method5733(var1, var2, var5, var6, var3, var4, this.field304[var7 - 1][var8], this.field303, true);
      }
   }

   static final void method630(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, byte var8) {
      if(class261.method4931(var0, (byte)-10)) {
         class132.field1814 = null;
         class28.method467(Widget.LOADED[var0], -1, var1, var2, var3, var4, var5, var6, var7, 1699160696);
         if(class132.field1814 != null) {
            class28.method467(class132.field1814, -1412584499, var1, var2, var3, var4, class297.field3687, class1.field15, var7, 59013620);
            class132.field1814 = null;
         }

      } else {
         if(var7 != -1) {
            if(var8 != 46) {
               return;
            }

            GameClient.staticBoolArray6[var7] = true;
         } else {
            for(int var9 = 0; var9 < 100; var9++) {
               GameClient.staticBoolArray6[var9] = true;
            }
         }

      }
   }

   static final String method623(int var0, byte var1) {
      String var2 = Integer.toString(var0);

      for(int var3 = var2.length() - 3; var3 > 0; var3 -= 3) {
         var2 = var2.substring(0, var3) + "," + var2.substring(var3);
      }

      return var2.length() > 9 ? " " + class6.method71(65408) + var2.substring(0, var2.length() - 8) + "M" + " " + " (" + var2 + ")" + "</col>" : (var2.length() > 6 ? " " + class6.method71(16777215) + var2.substring(0, var2.length() - 4) + "K" + " " + " (" + var2 + ")" + "</col>" : " " + class6.method71(16776960) + var2 + "</col>");
   }

   static final void method609(class63 var0, byte var1) {
      var0.field900 = var0.field893;
      if(var0.field909 == 0) {
         var0.field923 = 0;
      } else {
         if(var0.field903 != -1 && var0.field906 == 0) {
            class273 var2 = class3.method25(var0.field903, -465940687);
            if(var0.field930 > 0 && var2.field3551 == 0) {
               ++var0.field923;
               return;
            }

            if(var0.field930 <= 0) {
               if(var1 == 7) {
                  return;
               }

               if(var2.field3535 == 0) {
                  ++var0.field923;
                  return;
               }
            }
         }

         int var11 = var0.field931;
         int var3 = var0.field881;
         int var4 = var0.field922[var0.field909 - 1] * 128 + var0.field874 * 64;
         int var5 = var0.field872[var0.field909 - 1] * 128 + var0.field874 * 64;
         if(var11 < var4) {
            if(var3 < var5) {
               var0.field926 = 1280;
            } else if(var3 > var5) {
               if(var1 == 7) {
                  return;
               }

               var0.field926 = 1792;
            } else {
               var0.field926 = 1536;
            }
         } else if(var11 > var4) {
            if(var1 == 7) {
               return;
            }

            if(var3 < var5) {
               var0.field926 = 768;
            } else if(var3 > var5) {
               var0.field926 = 256;
            } else {
               var0.field926 = 512;
            }
         } else if(var3 < var5) {
            var0.field926 = 1024;
         } else if(var3 > var5) {
            if(var1 == 7) {
               return;
            }

            var0.field926 = 0;
         }

         byte var6 = var0.field928[var0.field909 - 1];
         if(var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
            int var7 = var0.field926 - var0.field905 & 2047;
            if(var7 > 1024) {
               var7 -= 2048;
            }

            int var8 = var0.field880;
            if(var7 >= -256 && var7 <= 256) {
               var8 = var0.field899;
            } else if(var7 >= 256 && var7 < 768) {
               var8 = var0.field882;
            } else if(var7 >= -768 && var7 <= -256) {
               if(var1 == 7) {
                  return;
               }

               var8 = var0.field870;
            }

            if(var8 == -1) {
               var8 = var0.field899;
            }

            var0.field900 = var8;
            int var9 = 4;
            boolean var10 = true;
            if(var0 instanceof Npc) {
               var10 = ((Npc)var0).definition.bool62;
            }

            if(var10) {
               if(var1 == 7) {
                  return;
               }

               if(var0.field926 != var0.field905) {
                  if(var1 == 7) {
                     return;
                  }

                  if(var0.field897 == -1 && var0.field924 != 0) {
                     var9 = 2;
                  }
               }

               if(var0.field909 > 2) {
                  if(var1 == 7) {
                     return;
                  }

                  var9 = 6;
               }

               if(var0.field909 > 3) {
                  var9 = 8;
               }

               if(var0.field923 > 0 && var0.field909 > 1) {
                  if(var1 == 7) {
                     return;
                  }

                  var9 = 8;
                  --var0.field923;
               }
            } else {
               if(var0.field909 > 1) {
                  var9 = 6;
               }

               if(var0.field909 > 2) {
                  if(var1 == 7) {
                     return;
                  }

                  var9 = 8;
               }

               if(var0.field923 > 0 && var0.field909 > 1) {
                  var9 = 8;
                  --var0.field923;
               }
            }

            if(var6 == 2) {
               var9 <<= 1;
            }

            if(var9 >= 8 && var0.field899 == var0.field900) {
               if(var1 == 7) {
                  return;
               }

               if(var0.field883 != -1) {
                  if(var1 == 7) {
                     return;
                  }

                  var0.field900 = var0.field883;
               }
            }

            label292: {
               if(var11 == var4) {
                  if(var1 == 7) {
                     return;
                  }

                  if(var3 == var5) {
                     break label292;
                  }
               }

               if(var11 < var4) {
                  if(var1 == 7) {
                     return;
                  }

                  var0.field931 += var9;
                  if(var0.field931 > var4) {
                     if(var1 == 7) {
                        return;
                     }

                     var0.field931 = var4;
                  }
               } else if(var11 > var4) {
                  var0.field931 -= var9;
                  if(var0.field931 < var4) {
                     var0.field931 = var4;
                  }
               }

               if(var3 < var5) {
                  var0.field881 += var9;
                  if(var0.field881 > var5) {
                     var0.field881 = var5;
                  }
               } else if(var3 > var5) {
                  var0.field881 -= var9;
                  if(var0.field881 < var5) {
                     var0.field881 = var5;
                  }
               }
            }

            if(var4 == var0.field931) {
               if(var1 == 7) {
                  return;
               }

               if(var5 == var0.field881) {
                  if(var1 == 7) {
                     return;
                  }

                  --var0.field909;
                  if(var0.field930 > 0) {
                     if(var1 == 7) {
                        return;
                     }

                     --var0.field930;
                  }
               }
            }

         } else {
            var0.field931 = var4;
            var0.field881 = var5;
            --var0.field909;
            if(var0.field930 > 0) {
               --var0.field930;
            }

         }
      }
   }

   static final void method628(class63 var0, int var1, int var2, int var3, int var4, int var5, byte var6) {
      if(var0 != null && var0.vmethod1786((byte)5)) {
         if(var0 instanceof Npc) {
            NpcDef var7 = ((Npc)var0).definition;
            if(var7.intArray106 != null) {
               if(var6 <= 1) {
                  return;
               }

               var7 = var7.method5189(-409079919);
            }

            if(var7 == null) {
               return;
            }
         }

         int var76 = class81.field1167;
         int[] var8 = class81.field1159;
         byte var9 = 0;
         Player player;
         if(var1 < var76 && var0.field889 == GameClient.field591) {
            player = (Player)var0;
            boolean var10;
            if(GameClient.field658 == 0) {
               if(var6 <= 1) {
                  return;
               }

               var10 = false;
            } else {
               boolean var78;
               if(player == class138.field1876) {
                  var78 = (GameClient.field658 & 8) != 0;
                  var10 = var78;
               } else {
                  var78 = class20.method260(-2118827798);
                  if(!var78) {
                     boolean var79 = (GameClient.field658 & 1) != 0;
                     var78 = var79 && player.method1083(-750305454);
                  }

                  boolean var10000;
                  label909: {
                     if(!var78) {
                        if(var6 <= 1) {
                           return;
                        }

                        if(!class48.method943((byte)96) || !player.method1104(-2109127232)) {
                           var10000 = false;
                           break label909;
                        }
                     }

                     var10000 = true;
                  }

                  var10 = var10000;
               }
            }

            if(var10) {
               Player var12 = (Player)var0;
               if(var1 < var76) {
                  if(var6 <= 1) {
                     return;
                  }

                  class58.method1068(var0, var0.field925 + 15, (byte)-2);
                  class299 var13 = (class299) GameClient.field631.get(class295.field3672);
                  byte var14 = 9;
                  var13.drawStr(var12.field552.method5447((byte)-51), var2 + GameClient.field679, var3 + GameClient.field680 - var14, 16777215, 0);
                  var9 = 18;
               }
            }
         }

         int var88 = -2;
         int var16;
         int var23;
         int var24;
         if(!var0.field896.method4043()) {
            class58.method1068(var0, var0.field925 + 15, (byte)-9);

            for(class71 var89 = (class71)var0.field896.method4048(); var89 != null; var89 = (class71)var0.field896.method4033()) {
               class64 var90 = var89.method1773(GameClient.field591, 1625981633);
               if(var90 == null) {
                  if(var89.method1774((byte)44)) {
                     var89.unlink();
                  }
               } else {
                  class261 var92 = var89.field1025;
                  Sprite var77 = var92.method4918(879523324);
                  Sprite var15 = var92.method4917(-1987129787);
                  int var17 = 0;
                  if(var77 != null && var15 != null) {
                     if(var92.field3318 * 2 < var15.width) {
                        var17 = var92.field3318;
                     }

                     var16 = var15.width - var17 * 2;
                  } else {
                     var16 = var92.field3311;
                  }

                  int var18 = 255;
                  boolean var19 = true;
                  int var20 = GameClient.field591 - var90.field934;
                  int var21 = var16 * var90.field938 / var92.field3311;
                  int var22;
                  int var93;
                  if(var90.field937 > var20) {
                     int var98;
                     if(var92.field3308 == 0) {
                        if(var6 <= 1) {
                           return;
                        }

                        var98 = 0;
                     } else {
                        var98 = var92.field3308 * (var20 / var92.field3308);
                     }

                     var22 = var98;
                     var23 = var16 * var90.field935 / var92.field3311;
                     var93 = var22 * (var21 - var23) / var90.field937 + var23;
                  } else {
                     var93 = var21;
                     var22 = var92.field3313 + var90.field937 - var20;
                     if(var92.field3312 >= 0) {
                        if(var6 <= 1) {
                           return;
                        }

                        var18 = (var22 << 8) / (var92.field3313 - var92.field3312);
                     }
                  }

                  if(var90.field938 > 0 && var93 < 1) {
                     var93 = 1;
                  }

                  if(var77 != null) {
                     if(var6 <= 1) {
                        return;
                     }

                     if(var15 != null) {
                        if(var16 == var93) {
                           var93 += var17 * 2;
                        } else {
                           var93 += var17;
                        }

                        label832: {
                           var22 = var77.height;
                           var88 += var22;
                           var23 = var2 + GameClient.field679 - (var16 >> 1);
                           var24 = var3 + GameClient.field680 - var88;
                           var23 -= var17;
                           if(var18 >= 0) {
                              if(var6 <= 1) {
                                 return;
                              }

                              if(var18 < 255) {
                                 var77.method5857(var23, var24, var18);
                                 Rasterizer2D.method5790(var23, var24, var23 + var93, var24 + var22);
                                 var15.method5857(var23, var24, var18);
                                 break label832;
                              }
                           }

                           var77.method5851(var23, var24);
                           Rasterizer2D.method5790(var23, var24, var93 + var23, var22 + var24);
                           var15.method5851(var23, var24);
                        }

                        Rasterizer2D.method5720(var2, var3, var2 + var4, var3 + var5);
                        var88 += 2;
                        continue;
                     }
                  }

                  var88 += 5;
                  if(GameClient.field679 > -1) {
                     if(var6 <= 1) {
                        return;
                     }

                     var22 = var2 + GameClient.field679 - (var16 >> 1);
                     var23 = var3 + GameClient.field680 - var88;
                     Rasterizer2D.method5763(var22, var23, var93, 5, 65280);
                     Rasterizer2D.method5763(var22 + var93, var23, var16 - var93, 5, 16711680);
                  }

                  var88 += 2;
               }
            }
         }

         if(var88 == -2) {
            var88 += 7;
         }

         var88 += var9;
         if(var1 < var76) {
            if(var6 <= 1) {
               return;
            }

            player = (Player)var0;
            if(player.hidden) {
               return;
            }

            if(player.skullIcon != -1 || player.field548 != -1) {
               class58.method1068(var0, var0.field925 + 15, (byte)-39);
               if(GameClient.field679 > -1) {
                  if(player.skullIcon != -1) {
                     var88 += 25;
                     int skullIcon = player.skullIcon;
                     int skullIconIdx = !GameClient.killstreakSkullsEnabled && skullIcon >= 2 && skullIcon <= 7 ? 0 : skullIcon;
                     class150.field1919[skullIconIdx].method5851(var2 + GameClient.field679 - 12, var3 + GameClient.field680 - var88);
                  }

                  if(player.field548 != -1) {
                     var88 += 25;
                     class43.field369[player.field548].method5851(var2 + GameClient.field679 - 12, var3 + GameClient.field680 - var88);
                  }
               }
            }

            if(var1 >= 0 && GameClient.field599 == 10) {
               if(var6 <= 1) {
                  return;
               }

               if(var8[var1] == GameClient.field579) {
                  class58.method1068(var0, var0.field925 + 15, (byte)-113);
                  if(GameClient.field679 > -1) {
                     var88 += class150.field1926[1].height;
                     class150.field1926[1].method5851(var2 + GameClient.field679 - 12, var3 + GameClient.field680 - var88);
                  }
               }
            }
         } else {
            NpcDef var91 = ((Npc)var0).definition;
            if(var91.intArray106 != null) {
               var91 = var91.method5189(496385679);
            }

            if(var91.int585 >= 0 && var91.int585 < class43.field369.length) {
               class58.method1068(var0, var0.field925 + 15, (byte)-95);
               if(GameClient.field679 > -1) {
                  class43.field369[var91.int585].method5851(var2 + GameClient.field679 - 12, var3 + GameClient.field680 - 30);
               }
            }

            if(GameClient.field599 == 1 && GameClient.field639[var1 - var76] == GameClient.field600 && GameClient.field591 % 20 < 10) {
               class58.method1068(var0, var0.field925 + 15, (byte)-88);
               if(GameClient.field679 > -1) {
                  class150.field1926[0].method5851(var2 + GameClient.field679 - 12, var3 + GameClient.field680 - 28);
               }
            }
         }

         if(var0.field884 != null) {
            label809: {
               if(var1 < var76) {
                  if(var0.field886) {
                     break label809;
                  }

                  if(GameClient.field630 != 4) {
                     if(var0.field885) {
                        break label809;
                     }

                     if(var6 <= 1) {
                        return;
                     }

                     if(GameClient.field630 != 0) {
                        if(var6 <= 1) {
                           return;
                        }

                        if(GameClient.field630 != 3 && (GameClient.field630 != 1 || !((Player)var0).method1083(-1410932581))) {
                           break label809;
                        }
                     }
                  }
               }

               class58.method1068(var0, var0.field925, (byte)-74);
               if(GameClient.field679 > -1 && GameClient.field667 < GameClient.field648) {
                  GameClient.field672[GameClient.field667] = class293.field3660.method5517(var0.field884) / 2;
                  GameClient.field671[GameClient.field667] = class293.field3660.field3695;
                  GameClient.field669[GameClient.field667] = GameClient.field679;
                  GameClient.field670[GameClient.field667] = GameClient.field680;
                  GameClient.field673[GameClient.field667] = var0.field888;
                  GameClient.field674[GameClient.field667] = var0.field927;
                  GameClient.field675[GameClient.field667] = var0.field887;
                  GameClient.field721[GameClient.field667] = var0.field884;
                  ++GameClient.field667;
               }
            }
         }

         for(int var80 = 0; var80 < 4; var80++) {
            if(var6 <= 1) {
               return;
            }

            int var96 = var0.field895[var80];
            int var97 = var0.field912[var80];
            class267 var95 = null;
            int var81 = 0;
            if(var97 >= 0) {
               if(var96 <= GameClient.field591) {
                  continue;
               }

               var95 = class14.method123(var0.field912[var80], (byte)57);
               var81 = var95.field3355;
               if(var95 != null) {
                  if(var6 <= 1) {
                     return;
                  }

                  if(var95.field3366 != null) {
                     var95 = var95.method4995(-2027374457);
                     if(var95 == null) {
                        var0.field895[var80] = -1;
                        continue;
                     }
                  }
               }
            } else if(var96 < 0) {
               continue;
            }

            var16 = var0.field894[var80];
            class267 var82 = null;
            if(var16 >= 0) {
               var82 = class14.method123(var16, (byte)25);
               if(var82 != null && var82.field3366 != null) {
                  var82 = var82.method4995(-1562489008);
               }
            }

            if(var96 - var81 > GameClient.field591) {
               if(var6 <= 1) {
                  return;
               }
            } else if(var95 == null) {
               var0.field895[var80] = -1;
            } else {
               class58.method1068(var0, var0.field925 / 2, (byte)-14);
               if(GameClient.field679 > -1) {
                  if(var80 == 1) {
                     GameClient.field680 -= 20;
                  }

                  if(var80 == 2) {
                     GameClient.field679 -= 15;
                     GameClient.field680 -= 10;
                  }

                  if(var80 == 3) {
                     GameClient.field679 += 15;
                     GameClient.field680 -= 10;
                  }

                  Sprite var83 = null;
                  Sprite var84 = null;
                  Sprite var85 = null;
                  Sprite var86 = null;
                  var23 = 0;
                  var24 = 0;
                  int var25 = 0;
                  int var26 = 0;
                  int var27 = 0;
                  int var28 = 0;
                  int var29 = 0;
                  int var30 = 0;
                  Sprite var31 = null;
                  Sprite var32 = null;
                  Sprite var33 = null;
                  Sprite var34 = null;
                  int var35 = 0;
                  int var36 = 0;
                  int var37 = 0;
                  int var38 = 0;
                  int var39 = 0;
                  int var40 = 0;
                  int var41 = 0;
                  int var42 = 0;
                  int var43 = 0;
                  var83 = var95.method4994(2147112407);
                  int var44;
                  if(var83 != null) {
                     var23 = var83.width;
                     var44 = var83.height;
                     if(var44 > var43) {
                        var43 = var44;
                     }

                     var27 = var83.offsetX;
                  }

                  var84 = var95.method5000(1102937480);
                  if(var84 != null) {
                     var24 = var84.width;
                     var44 = var84.height;
                     if(var44 > var43) {
                        var43 = var44;
                     }

                     var28 = var84.offsetX;
                  }

                  var85 = var95.method4996((byte)96);
                  if(var85 != null) {
                     var25 = var85.width;
                     var44 = var85.height;
                     if(var44 > var43) {
                        var43 = var44;
                     }

                     var29 = var85.offsetX;
                  }

                  var86 = var95.method4997(720850716);
                  if(var86 != null) {
                     var26 = var86.width;
                     var44 = var86.height;
                     if(var44 > var43) {
                        var43 = var44;
                     }

                     var30 = var86.offsetX;
                  }

                  if(var82 != null) {
                     var31 = var82.method4994(2147112407);
                     if(var31 != null) {
                        var35 = var31.width;
                        var44 = var31.height;
                        if(var44 > var43) {
                           var43 = var44;
                        }

                        var39 = var31.offsetX;
                     }

                     var32 = var82.method5000(-349627453);
                     if(var32 != null) {
                        var36 = var32.width;
                        var44 = var32.height;
                        if(var44 > var43) {
                           if(var6 <= 1) {
                              return;
                           }

                           var43 = var44;
                        }

                        var40 = var32.offsetX;
                     }

                     var33 = var82.method4996((byte)101);
                     if(var33 != null) {
                        var37 = var33.width;
                        var44 = var33.height;
                        if(var44 > var43) {
                           var43 = var44;
                        }

                        var41 = var33.offsetX;
                     }

                     var34 = var82.method4997(798761310);
                     if(var34 != null) {
                        var38 = var34.width;
                        var44 = var34.height;
                        if(var44 > var43) {
                           if(var6 <= 1) {
                              return;
                           }

                           var43 = var44;
                        }

                        var42 = var34.offsetX;
                     }
                  }

                  class298 var87 = var95.method4998((byte)1);
                  if(var87 == null) {
                     var87 = class151.field1936;
                  }

                  class298 var45;
                  if(var82 != null) {
                     var45 = var82.method4998((byte)1);
                     if(var45 == null) {
                        var45 = class151.field1936;
                     }
                  } else {
                     var45 = class151.field1936;
                  }

                  String var46 = null;
                  String var47 = null;
                  boolean var48 = false;
                  int var49 = 0;
                  var46 = var95.method5014(var0.field892[var80], (byte)-99);
                  int var94 = var87.method5517(var46);
                  if(var82 != null) {
                     var47 = var82.method5014(var0.field921[var80], (byte)-36);
                     var49 = var45.method5517(var47);
                  }

                  int var50 = 0;
                  int var51 = 0;
                  if(var24 > 0) {
                     label770: {
                        if(var85 == null) {
                           if(var6 <= 1) {
                              return;
                           }

                           if(var86 == null) {
                              var50 = 1;
                              break label770;
                           }
                        }

                        var50 = var94 / var24 + 1;
                     }
                  }

                  if(var82 != null) {
                     if(var6 <= 1) {
                        return;
                     }

                     if(var36 > 0) {
                        if(var33 == null && var34 == null) {
                           var51 = 1;
                        } else {
                           var51 = var49 / var36 + 1;
                        }
                     }
                  }

                  int var52 = 0;
                  int var53 = var52;
                  if(var23 > 0) {
                     if(var6 <= 1) {
                        return;
                     }

                     var52 += var23;
                  }

                  var52 += 2;
                  int var54 = var52;
                  if(var25 > 0) {
                     var52 += var25;
                  }

                  int var55 = var52;
                  int var56 = var52;
                  int var57;
                  if(var24 > 0) {
                     var57 = var50 * var24;
                     var52 += var57;
                     var56 += (var57 - var94) / 2;
                  } else {
                     var52 += var94;
                  }

                  var57 = var52;
                  if(var26 > 0) {
                     var52 += var26;
                  }

                  int var58 = 0;
                  int var59 = 0;
                  int var60 = 0;
                  int var61 = 0;
                  int var62 = 0;
                  int var63;
                  if(var82 != null) {
                     var52 += 2;
                     var58 = var52;
                     if(var35 > 0) {
                        var52 += var35;
                     }

                     var52 += 2;
                     var59 = var52;
                     if(var37 > 0) {
                        var52 += var37;
                     }

                     var60 = var52;
                     var62 = var52;
                     if(var36 > 0) {
                        var63 = var51 * var36;
                        var52 += var63;
                        var62 += (var63 - var49) / 2;
                     } else {
                        var52 += var49;
                     }

                     var61 = var52;
                     if(var38 > 0) {
                        var52 += var38;
                     }
                  }

                  var63 = var0.field895[var80] - GameClient.field591;
                  int var64 = var95.field3365 - var63 * var95.field3365 / var95.field3355;
                  int var65 = var63 * var95.field3361 / var95.field3355 + -var95.field3361;
                  int var66 = var64 + (var2 + GameClient.field679 - (var52 >> 1));
                  int var67 = var65 + (var3 + GameClient.field680 - 12);
                  int var68 = var67;
                  int var69 = var67 + var43;
                  int var70 = var67 + var95.field3347 + 15;
                  int var71 = var70 - var87.field3696;
                  int var72 = var70 + var87.field3697;
                  if(var71 < var67) {
                     if(var6 <= 1) {
                        return;
                     }

                     var68 = var71;
                  }

                  if(var72 > var69) {
                     if(var6 <= 1) {
                        return;
                     }

                     var69 = var72;
                  }

                  int var73 = 0;
                  int var74;
                  int var75;
                  if(var82 != null) {
                     var73 = var67 + var82.field3347 + 15;
                     var74 = var73 - var45.field3696;
                     var75 = var73 + var45.field3697;
                     if(var74 < var68 && var6 <= 1) {
                        return;
                     }

                     if(var75 > var69 && var6 <= 1) {
                        return;
                     }
                  }

                  var74 = 255;
                  if(var95.field3354 >= 0) {
                     var74 = (var63 << 8) / (var95.field3355 - var95.field3354);
                  }

                  if(var74 >= 0 && var74 < 255) {
                     if(var83 != null) {
                        if(var6 <= 1) {
                           return;
                        }

                        var83.method5857(var66 + var53 - var27, var67, var74);
                     }

                     if(var85 != null) {
                        var85.method5857(var66 + var54 - var29, var67, var74);
                     }

                     if(var84 != null) {
                        for(var75 = 0; var75 < var50; var75++) {
                           var84.method5857(var24 * var75 + (var55 + var66 - var28), var67, var74);
                        }
                     }

                     if(var86 != null) {
                        var86.method5857(var57 + var66 - var30, var67, var74);
                     }

                     var87.method5523(var46, var66 + var56, var70, var95.field3364, 0, var74);
                     if(var82 != null) {
                        if(var31 != null) {
                           var31.method5857(var66 + var58 - var39, var67, var74);
                        }

                        if(var33 != null) {
                           var33.method5857(var59 + var66 - var41, var67, var74);
                        }

                        if(var32 != null) {
                           for(var75 = 0; var75 < var51; var75++) {
                              var32.method5857(var75 * var36 + (var60 + var66 - var40), var67, var74);
                           }
                        }

                        if(var34 != null) {
                           var34.method5857(var66 + var61 - var42, var67, var74);
                        }

                        var45.method5523(var47, var62 + var66, var73, var82.field3364, 0, var74);
                     }
                  } else {
                     if(var83 != null) {
                        if(var6 <= 1) {
                           return;
                        }

                        var83.method5851(var66 + var53 - var27, var67);
                     }

                     if(var85 != null) {
                        var85.method5851(var66 + var54 - var29, var67);
                     }

                     if(var84 != null) {
                        for(var75 = 0; var75 < var50; var75++) {
                           var84.method5851(var24 * var75 + (var66 + var55 - var28), var67);
                        }
                     }

                     if(var86 != null) {
                        var86.method5851(var66 + var57 - var30, var67);
                     }

                     var87.method5522(var46, var66 + var56, var70, var95.field3364 | -16777216, 0);
                     if(var82 != null) {
                        if(var31 != null) {
                           var31.method5851(var58 + var66 - var39, var67);
                        }

                        if(var33 != null) {
                           var33.method5851(var59 + var66 - var41, var67);
                        }

                        if(var32 != null) {
                           if(var6 <= 1) {
                              return;
                           }

                           for(var75 = 0; var75 < var51; var75++) {
                              var32.method5851(var75 * var36 + (var60 + var66 - var40), var67);
                           }
                        }

                        if(var34 != null) {
                           var34.method5851(var61 + var66 - var42, var67);
                        }

                        var45.method5522(var47, var66 + var62, var73, var82.field3364 | -16777216, 0);
                     }
                  }
               }
            }
         }

      }
   }
}
