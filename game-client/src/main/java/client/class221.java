package client;

public class class221 extends class204 {
   static long field2535;
   public static final int field2541 = 33;
   static final int field2542 = 4;
   int[] field2539 = new int[128];
   class93[] field2533 = new class93[128];
   short[] field2534 = new short[128];
   byte[] field2532 = new byte[128];
   byte[] field2536 = new byte[128];
   class216[] field2537 = new class216[128];
   byte[] field2538 = new byte[128];
   int field2540;

   class221(byte[] var1) {
      Stream var2 = new Stream(var1);

      int var3;
      for(var3 = 0; var2.field2338[var3 + var2.field2339] != 0; var3++) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; var5++) {
         var4[var5] = var2.readByte();
      }

      ++var2.field2339;
      ++var3;
      var5 = var2.field2339;
      var2.field2339 += var3;

      int var6;
      for(var6 = 0; var2.field2338[var6 + var2.field2339] != 0; var6++) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; var8++) {
         var7[var8] = var2.readByte();
      }

      ++var2.field2339;
      ++var6;
      var8 = var2.field2339;
      var2.field2339 += var6;

      int var9;
      for(var9 = 0; var2.field2338[var9 + var2.field2339] != 0; var9++) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; var11++) {
         var10[var11] = var2.readByte();
      }

      ++var2.field2339;
      ++var9;
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; var14++) {
            int var15 = var2.readUByte();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var38[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class216[] var39 = new class216[var12];

      class216 var40;
      for(var14 = 0; var14 < var39.length; var14++) {
         var40 = var39[var14] = new class216();
         int var16 = var2.readUByte();
         if(var16 > 0) {
            var40.field2447 = new byte[var16 * 2];
         }

         var16 = var2.readUByte();
         if(var16 > 0) {
            var40.field2449 = new byte[var16 * 2 + 2];
            var40.field2449[1] = 64;
         }
      }

      var14 = var2.readUByte();
      byte[] var47 = var14 > 0 ? new byte[var14 * 2] : null;
      var14 = var2.readUByte();
      byte[] var41 = var14 > 0 ? new byte[var14 * 2] : null;

      int var17;
      for(var17 = 0; var2.field2338[var17 + var2.field2339] != 0; var17++) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; var19++) {
         var18[var19] = var2.readByte();
      }

      ++var2.field2339;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; var20++) {
         var19 += var2.readUByte();
         this.field2534[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; var20++) {
         var19 += var2.readUByte();
         this.field2534[var20] = (short)(this.field2534[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; var23++) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method3566(-591669561);
         }

         this.field2534[var23] = (short)(this.field2534[var23] + ((var22 - 1 & 2) << 14));
         this.field2539[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; var24++) {
         if(this.field2539[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field2338[var5++] - 1;
            }

            this.field2538[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; var25++) {
         if(this.field2539[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field2338[var8++] + 16 << 2;
            }

            this.field2536[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class216 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; var26++) {
         if(this.field2539[var26] != 0) {
            if(var20 == 0) {
               var42 = var39[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2537[var26] = var42;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; var27++) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field2539[var27] > 0) {
               var26 = var2.readUByte() + 1;
            }
         }

         this.field2532[var27] = (byte)var26;
         --var20;
      }

      this.field2540 = var2.readUByte() + 1;

      class216 var28;
      int var29;
      for(var27 = 0; var27 < var12; var27++) {
         var28 = var39[var27];
         if(var28.field2447 != null) {
            for(var29 = 1; var29 < var28.field2447.length; var29 += 2) {
               var28.field2447[var29] = var2.readByte();
            }
         }

         if(var28.field2449 != null) {
            for(var29 = 3; var29 < var28.field2449.length - 2; var29 += 2) {
               var28.field2449[var29] = var2.readByte();
            }
         }
      }

      if(var47 != null) {
         for(var27 = 1; var27 < var47.length; var27 += 2) {
            var47[var27] = var2.readByte();
         }
      }

      if(var41 != null) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; var27++) {
         var28 = var39[var27];
         if(var28.field2449 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2449.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUByte();
               var28.field2449[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; var27++) {
         var28 = var39[var27];
         if(var28.field2447 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2447.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUByte();
               var28.field2447[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var44;
      byte var46;
      if(var47 != null) {
         var19 = var2.readUByte();
         var47[0] = (byte)var19;

         for(var27 = 2; var27 < var47.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUByte();
            var47[var27] = (byte)var19;
         }

         var46 = var47[0];
         byte var43 = var47[1];

         for(var29 = 0; var29 < var46; var29++) {
            this.field2532[var29] = (byte)(var43 * this.field2532[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var47.length; var29 += 2) {
            var30 = var47[var29];
            byte var31 = var47[var29 + 1];
            var32 = var43 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; var33++) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field2532[var33] = (byte)(var34 * this.field2532[var33] + 32 >> 6);
               var32 += var31 - var43;
            }

            var46 = var30;
            var43 = var31;
         }

         for(var44 = var46; var44 < 128; var44++) {
            this.field2532[var44] = (byte)(var43 * this.field2532[var44] + 32 >> 6);
         }

         var40 = null;
      }

      if(var41 != null) {
         var19 = var2.readUByte();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUByte();
            var41[var27] = (byte)var19;
         }

         var46 = var41[0];
         int var49 = var41[1] << 1;

         for(var29 = 0; var29 < var46; var29++) {
            var44 = var49 + (this.field2536[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2536[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            var45 = var41[var29 + 1] << 1;
            var32 = var49 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; var33++) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               int var37 = var34 + (this.field2536[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2536[var33] = (byte)var37;
               var32 += var45 - var49;
            }

            var46 = var30;
            var49 = var45;
         }

         for(var44 = var46; var44 < 128; var44++) {
            var45 = var49 + (this.field2536[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2536[var44] = (byte)var45;
         }

         Object var48 = null;
      }

      for(var27 = 0; var27 < var12; var27++) {
         var39[var27].field2448 = var2.readUByte();
      }

      for(var27 = 0; var27 < var12; var27++) {
         var28 = var39[var27];
         if(var28.field2447 != null) {
            var28.field2450 = var2.readUByte();
         }

         if(var28.field2449 != null) {
            var28.field2446 = var2.readUByte();
         }

         if(var28.field2448 > 0) {
            var28.field2451 = var2.readUByte();
         }
      }

      for(var27 = 0; var27 < var12; var27++) {
         var39[var27].field2452 = var2.readUByte();
      }

      for(var27 = 0; var27 < var12; var27++) {
         var28 = var39[var27];
         if(var28.field2452 > 0) {
            var28.field2453 = var2.readUByte();
         }
      }

      for(var27 = 0; var27 < var12; var27++) {
         var28 = var39[var27];
         if(var28.field2453 > 0) {
            var28.field2454 = var2.readUByte();
         }
      }

   }

   void method4373(int var1) {
      this.field2539 = null;
   }

   boolean method4372(class98 var1, byte[] var2, int[] var3, byte var4) {
      boolean var5 = true;
      int var6 = 0;
      class93 var7 = null;

      for(int var8 = 0; var8 < 128; var8++) {
         if(var2 == null || var2[var8] != 0) {
            int var9 = this.field2539[var8];
            if(var9 != 0) {
               if(var6 != var9) {
                  var6 = var9--;
                  if((var9 & 1) == 0) {
                     var7 = var1.method2216(var9 >> 2, var3, 2090805346);
                  } else {
                     var7 = var1.method2220(var9 >> 2, var3, 1187754020);
                  }

                  if(var7 == null) {
                     var5 = false;
                  }
               }

               if(var7 != null) {
                  this.field2533[var8] = var7;
                  this.field2539[var8] = 0;
               }
            }
         }
      }

      return var5;
   }

   public static PaletteSprite method4374(class247 var0, String var1, String var2, int var3) {
      int var4 = var0.method4642(var1, -604863325);
      int var5 = var0.method4643(var4, var2, -981702486);
      PaletteSprite var6;
      if(!class306.method5660(var0, var4, var5, 430714634)) {
         var6 = null;
      } else {
         var6 = class305.method5658(1052310546);
      }

      return var6;
   }

   static final void method4371(Player var0, int var1, int var2, int var3, int var4) {
      if(class138.field1876 != var0) {
         if(GameClient.field771 < 400) {
            String var5;
            if(var0.field564 == 0) {
               var5 = var0.field550[0] + var0.field552 + var0.field550[1] + class135.method3113(var0.field551, class138.field1876.field551, -509659041) + " " + " (" + "level-" + var0.field551 + ")" + var0.field550[2];
            } else {
               var5 = var0.field550[0] + var0.field552 + var0.field550[1] + " " + " (" + "skill-" + var0.field564 + ")" + var0.field550[2];
            }

            int var6;
            if(GameClient.field733 == 1) {
               class50.method993("Use", GameClient.field734 + " " + "->" + " " + class6.method71(16777215) + var5, 14, var1, var2, var3, 390712613);
            } else if(GameClient.field785) {
               if((class63.field932 & 8) == 8) {
                  class50.method993(GameClient.field612, GameClient.field739 + " " + "->" + " " + class6.method71(16777215) + var5, 15, var1, var2, var3, 850101661);
               }
            } else {
               for(var6 = 7; var6 >= 0; --var6) {
                  if(GameClient.field704[var6] != null) {
                     short var7 = 0;
                     if(GameClient.field704[var6].equalsIgnoreCase("Attack")) {
                        if(GameClient.field607 == class77.field1074) {
                           continue;
                        }

                        if(GameClient.field607 == class77.field1075 || GameClient.field607 == class77.field1080 && var0.field551 > class138.field1876.field551) {
                           var7 = 2000;
                        }

                        if(class138.field1876.field568 != 0 && var0.field568 != 0) {
                           if(var0.field568 == class138.field1876.field568) {
                              if(var4 <= -1955034247) {
                                 return;
                              }

                              var7 = 2000;
                           } else {
                              var7 = 0;
                           }
                        }
                     } else if(GameClient.field709[var6]) {
                        if(var4 <= -1955034247) {
                           return;
                        }

                        var7 = 2000;
                     }

                     boolean var8 = false;
                     int var9 = GameClient.field703[var6] + var7;
                     class50.method993(GameClient.field704[var6], class6.method71(16777215) + var5, var9, var1, var2, var3, 255044548);
                  }
               }
            }

            for(var6 = 0; var6 < GameClient.field771; var6++) {
               if(GameClient.field720[var6] == 23) {
                  GameClient.field740[var6] = class6.method71(16777215) + var5;
                  break;
               }
            }

         }
      }
   }
}
