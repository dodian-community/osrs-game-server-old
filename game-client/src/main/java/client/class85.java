package client;

public class class85 extends class127 {
   static int field1201;
   class273 field1202;
   int field1207;
   int field1199;
   int field1204;
   int field1200;
   int field1206;
   int field1205;
   int field1198;
   int field1203;

   class85(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class127 var9) {
      this.field1207 = var1;
      this.field1204 = var2;
      this.field1200 = var3;
      this.field1206 = var4;
      this.field1198 = var5;
      this.field1203 = var6;
      if(var7 != -1) {
         this.field1202 = class3.method25(var7, -1743757930);
         this.field1205 = 0;
         this.field1199 = GameClient.field591 - 1;
         if(this.field1202.field3553 == 0 && var9 != null && var9 instanceof class85) {
            class85 var10 = (class85)var9;
            if(this.field1202 == var10.field1202) {
               this.field1205 = var10.field1205;
               this.field1199 = var10.field1199;
               return;
            }
         }

         if(var8 && this.field1202.field3544 != -1) {
            this.field1205 = (int)(Math.random() * (double)this.field1202.field3540.length);
            this.field1199 -= (int)(Math.random() * (double)this.field1202.field3541[this.field1205]);
         }
      }

   }

   protected final class119 vmethod3067(int var1) {
      if(this.field1202 != null) {
         int var2 = GameClient.field591 - this.field1199;
         if(var2 > 100 && this.field1202.field3544 > 0) {
            var2 = 100;
         }

         label55: {
            do {
               do {
                  if(var2 <= this.field1202.field3541[this.field1205]) {
                     break label55;
                  }

                  var2 -= this.field1202.field3541[this.field1205];
                  ++this.field1205;
               } while(this.field1205 < this.field1202.field3540.length);

               this.field1205 -= this.field1202.field3544;
            } while(this.field1205 >= 0 && this.field1205 < this.field1202.field3540.length);

            this.field1202 = null;
         }

         this.field1199 = GameClient.field591 - var2;
      }

      ObjectDef var13 = class110.getObjectDef(this.field1207);
      if(var13.intArray116 != null) {
         var13 = var13.method5056();
      }

      if(var13 == null) {
         return null;
      } else {
         int var3;
         int var4;
         if(this.field1200 != 1 && this.field1200 != 3) {
            var3 = var13.int693;
            var4 = var13.int688;
         } else {
            var3 = var13.int688;
            var4 = var13.int693;
         }

         int var5 = (var3 >> 1) + this.field1198;
         int var6 = (var3 + 1 >> 1) + this.field1198;
         int var7 = (var4 >> 1) + this.field1203;
         int var8 = (var4 + 1 >> 1) + this.field1203;
         int[][] var9 = class50.field459[this.field1206];
         int var10 = var9[var6][var8] + var9[var5][var8] + var9[var6][var7] + var9[var5][var7] >> 2;
         int var11 = (this.field1198 << 7) + (var3 << 6);
         int var12 = (this.field1203 << 7) + (var4 << 6);
         return var13.method5032(this.field1204, this.field1200, var9, var11, var10, var12, this.field1202, this.field1205, 1680442057);
      }
   }

   static final void method1962(byte var0) {
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(GameClient.field655 == 0) {
         label303: {
            var1 = class138.field1876.field931;
            var2 = class138.field1876.field881;
            if(class109.field1428 - var1 >= -500) {
               if(var0 != 1) {
                  return;
               }

               if(class109.field1428 - var1 <= 500 && class2.field23 - var2 >= -500 && class2.field23 - var2 <= 500) {
                  break label303;
               }
            }

            class109.field1428 = var1;
            class2.field23 = var2;
         }

         if(var1 != class109.field1428) {
            class109.field1428 += (var1 - class109.field1428) / 16;
         }

         if(var2 != class2.field23) {
            class2.field23 += (var2 - class2.field23) / 16;
         }

         var3 = class109.field1428 >> 7;
         var4 = class2.field23 >> 7;
         var5 = class27.method460(class109.field1428, class2.field23, class13.field82, 555037408);
         var6 = 0;
         int var7;
         if(var3 > 3) {
            if(var0 != 1) {
               return;
            }

            if(var4 > 3 && var3 < 100 && var4 < 100) {
               for(var7 = var3 - 4; var7 <= var3 + 4; var7++) {
                  for(int var8 = var4 - 4; var8 <= var4 + 4; var8++) {
                     int var9 = class13.field82;
                     if(var9 < 3 && (class50.field443[1][var7][var8] & 2) == 2) {
                        if(var0 != 1) {
                           return;
                        }

                        ++var9;
                     }

                     int var10 = var5 - class50.field459[var9][var7][var8];
                     if(var10 > var6) {
                        var6 = var10;
                     }
                  }
               }
            }
         }

         var7 = var6 * 192;
         if(var7 > 98048) {
            var7 = 98048;
         }

         if(var7 < 32768) {
            if(var0 != 1) {
               return;
            }

            var7 = 32768;
         }

         if(var7 > GameClient.field738) {
            if(var0 != 1) {
               return;
            }

            GameClient.field738 += (var7 - GameClient.field738) / 24;
         } else if(var7 < GameClient.field738) {
            if(var0 != 1) {
               return;
            }

            GameClient.field738 += (var7 - GameClient.field738) / 80;
         }

         ItemDef.field3478 = class27.method460(class138.field1876.field931, class138.field1876.field881, class13.field82, -340236005) - GameClient.field644;
      } else if(GameClient.field655 == 1) {
         class181.method3527(799584462);
         short var11 = -1;
         if(class39.field341[33]) {
            var11 = 0;
         } else if(class39.field341[49]) {
            var11 = 1024;
         }

         if(class39.field341[48]) {
            if(var11 == 0) {
               var11 = 1792;
            } else if(var11 == 1024) {
               var11 = 1280;
            } else {
               var11 = 1536;
            }
         } else if(class39.field341[50]) {
            if(var11 == 0) {
               var11 = 256;
            } else if(var11 == 1024) {
               var11 = 768;
            } else {
               var11 = 512;
            }
         }

         byte var12 = 0;
         if(class39.field341[35]) {
            var12 = -1;
         } else if(class39.field341[51]) {
            var12 = 1;
         }

         label313: {
            var3 = 0;
            if(var11 < 0) {
               if(var12 == 0) {
                  break label313;
               }

               if(var0 != 1) {
                  return;
               }
            }

            var3 = class39.field341[81] ? GameClient.field661 : GameClient.field750;
            var3 *= 16;
            GameClient.field613 = var11;
            GameClient.field659 = var12;
         }

         if(GameClient.field657 < var3) {
            GameClient.field657 += var3 / 8;
            if(GameClient.field657 > var3) {
               GameClient.field657 = var3;
            }
         } else if(GameClient.field657 > var3) {
            GameClient.field657 = GameClient.field657 * 9 / 10;
         }

         if(GameClient.field657 > 0) {
            var4 = GameClient.field657 / 16;
            if(GameClient.field613 >= 0) {
               var1 = GameClient.field613 - field1201 & 2047;
               var5 = class122.field1681[var1];
               var6 = class122.field1693[var1];
               class109.field1428 += var5 * var4 / 65536;
               class2.field23 += var4 * var6 / 65536;
            }

            if(GameClient.field659 != 0) {
               ItemDef.field3478 += var4 * GameClient.field659;
               if(ItemDef.field3478 > 0) {
                  ItemDef.field3478 = 0;
               }
            }
         } else {
            GameClient.field613 = -1;
            GameClient.field659 = -1;
         }

         if(class39.field341[13]) {
            if(var0 != 1) {
               return;
            }

            GameClient.field626.method1980(class26.method433(OutgoingPacket.field2142, GameClient.field626.field1218, 2057583268), (byte)1);
            GameClient.field655 = 0;
         }
      }

      if(class48.field419 == 4 && class253.field3229) {
         int var10000;
         label258: {
            var1 = class48.field426 * 673804999 - GameClient.field654 * 673804999;
            GameClient.field652 = var1 * 2;
            if(var1 != -1) {
               if(var0 != 1) {
                  return;
               }

               if(var1 != 1) {
                  var10000 = (class48.field426 * 673804999 + GameClient.field654 * 673804999) / 2;
                  break label258;
               }
            }

            var10000 = class48.field426 * 673804999;
         }

         label252: {
            GameClient.field654 = var10000 * -1660309769;
            var2 = GameClient.field653 - class48.field425;
            GameClient.field608 = var2 * 2;
            if(var2 != -1) {
               if(var0 != 1) {
                  return;
               }

               if(var2 != 1) {
                  var10000 = (class48.field425 + GameClient.field653) / 2;
                  break label252;
               }
            }

            var10000 = class48.field425;
         }

         GameClient.field653 = var10000;
      } else {
         if(class39.field341[96]) {
            GameClient.field608 += (-24 - GameClient.field608) / 2;
         } else if(class39.field341[97]) {
            GameClient.field608 += (24 - GameClient.field608) / 2;
         } else {
            GameClient.field608 /= 2;
         }

         if(class39.field341[98]) {
            if(var0 != 1) {
               return;
            }

            GameClient.field652 += (12 - GameClient.field652) / 2;
         } else if(class39.field341[99]) {
            GameClient.field652 += (-12 - GameClient.field652) / 2;
         } else {
            GameClient.field652 /= 2;
         }

         GameClient.field654 = class48.field426;
         GameClient.field653 = class48.field425;
      }

      GameClient.field717 = GameClient.field608 / 2 + GameClient.field717 & 2047;
      GameClient.field649 += GameClient.field652 / 2;
      if(GameClient.field649 < 128) {
         if(var0 != 1) {
            return;
         }

         GameClient.field649 = 128;
      }

      if(GameClient.field649 > 383) {
         GameClient.field649 = 383;
      }

   }
}
