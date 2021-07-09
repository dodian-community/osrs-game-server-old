package client;

public class class224 extends class206 {
   static int[] field2554;
   static class249 field2548;
   static int field2555;
   public static final int field2552 = 200;
   public final int[] field2551;
   public final int field2553;
   public final int field2549;
   public final int[] field2550;

   class224(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2553 = var1;
      this.field2549 = var2;
      this.field2550 = var3;
      this.field2551 = var4;
   }

   public boolean method4423(int var1, int var2, byte var3) {
      if(var2 >= 0 && var2 < this.field2551.length) {
         int var4 = this.field2551[var2];
         if(var1 >= var4 && var1 <= var4 + this.field2550[var2]) {
            return true;
         }
      }

      return false;
   }

   static int method4426(class247 var0, class247 var1, int var2) {
      int var3 = 0;
      if(var0.method4646("title.jpg", "", -1553329255)) {
         ++var3;
      }

      if(var1.method4646("logo", "", -628493355)) {
         ++var3;
      }

      if(var1.method4646("logo_deadman_mode", "", -1027426781)) {
         ++var3;
      }

      if(var1.method4646("titlebox", "", -1912272818)) {
         ++var3;
      }

      if(var1.method4646("titlebutton", "", -1390872212)) {
         ++var3;
      }

      if(var1.method4646("runes", "", -1617610476)) {
         ++var3;
      }

      if(var1.method4646("title_mute", "", -1416926576)) {
         ++var3;
      }

      if(var1.method4646("options_radio_buttons,0", "", -1965386311)) {
         ++var3;
      }

      if(var1.method4646("options_radio_buttons,2", "", -1147405127)) {
         ++var3;
      }

      if(var1.method4646("options_radio_buttons,4", "", -694387357)) {
         ++var3;
      }

      if(var1.method4646("options_radio_buttons,6", "", -879673348)) {
         ++var3;
      }

      var1.method4646("sl_back", "", -1933420243);
      var1.method4646("sl_flags", "", -1286232087);
      var1.method4646("sl_arrows", "", -1700813388);
      var1.method4646("sl_stars", "", -657810754);
      var1.method4646("sl_button", "", -1560343676);
      return var3;
   }

   static final void method4422(int var0, int var1, int var2, int var3, int var4, int var5) {
      long var6 = class28.field248.method2898(var0, var1, var2);
      int var8;
      int var9;
      int var10;
      int var11;
      int var15;
      int var26;
      if(var6 != 0L) {
         var8 = class28.field248.method2902(var0, var1, var2, var6);
         var9 = var8 >> 6 & 3;
         var10 = var8 & 31;
         var11 = var3;
         boolean var13 = var6 != 0L;
         if(var13) {
            boolean var14 = (int)(var6 >>> 16 & 1L) == 1;
            var13 = !var14;
         }

         if(var13) {
            var11 = var4;
         }

         int[] var20 = Npc.field1038.pixels;
         var26 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var15 = class39.method673(var6);
         ObjectDef var16 = class110.getObjectDef(var15);
         if(var16.int701 != -1) {
            PaletteSprite var17 = class25.field214[var16.int701];
            if(var17 != null) {
               int var18 = (var16.int693 * 4 - var17.width1) / 2;
               int var19 = (var16.int688 * 4 - var17.height1) / 2;
               var17.method5829(var18 + var1 * 4 + 48, var19 + (104 - var2 - var16.int688) * 4 + 48);
            }
         } else {
            if(var10 == 0 || var10 == 2) {
               if(var9 == 0) {
                  var20[var26] = var11;
                  var20[var26 + 512] = var11;
                  var20[var26 + 1024] = var11;
                  var20[var26 + 1536] = var11;
               } else if(var9 == 1) {
                  var20[var26] = var11;
                  var20[var26 + 1] = var11;
                  var20[var26 + 2] = var11;
                  var20[var26 + 3] = var11;
               } else if(var9 == 2) {
                  if(var5 <= -1797356295) {
                     return;
                  }

                  var20[var26 + 3] = var11;
                  var20[var26 + 512 + 3] = var11;
                  var20[var26 + 1024 + 3] = var11;
                  var20[var26 + 1536 + 3] = var11;
               } else if(var9 == 3) {
                  var20[var26 + 1536] = var11;
                  var20[var26 + 1536 + 1] = var11;
                  var20[var26 + 1536 + 2] = var11;
                  var20[var26 + 1536 + 3] = var11;
               }
            }

            if(var10 == 3) {
               if(var5 <= -1797356295) {
                  return;
               }

               if(var9 == 0) {
                  var20[var26] = var11;
               } else if(var9 == 1) {
                  if(var5 <= -1797356295) {
                     return;
                  }

                  var20[var26 + 3] = var11;
               } else if(var9 == 2) {
                  var20[var26 + 1536 + 3] = var11;
               } else if(var9 == 3) {
                  if(var5 <= -1797356295) {
                     return;
                  }

                  var20[var26 + 1536] = var11;
               }
            }

            if(var10 == 2) {
               if(var5 <= -1797356295) {
                  return;
               }

               if(var9 == 3) {
                  var20[var26] = var11;
                  var20[var26 + 512] = var11;
                  var20[var26 + 1024] = var11;
                  var20[var26 + 1536] = var11;
               } else if(var9 == 0) {
                  var20[var26] = var11;
                  var20[var26 + 1] = var11;
                  var20[var26 + 2] = var11;
                  var20[var26 + 3] = var11;
               } else if(var9 == 1) {
                  var20[var26 + 3] = var11;
                  var20[var26 + 512 + 3] = var11;
                  var20[var26 + 1024 + 3] = var11;
                  var20[var26 + 1536 + 3] = var11;
               } else if(var9 == 2) {
                  if(var5 <= -1797356295) {
                     return;
                  }

                  var20[var26 + 1536] = var11;
                  var20[var26 + 1536 + 1] = var11;
                  var20[var26 + 1536 + 2] = var11;
                  var20[var26 + 1536 + 3] = var11;
               }
            }
         }
      }

      var6 = class28.field248.method2900(var0, var1, var2);
      if(var6 != 0L) {
         if(var5 <= -1797356295) {
            return;
         }

         var8 = class28.field248.method2902(var0, var1, var2, var6);
         var9 = var8 >> 6 & 3;
         var10 = var8 & 31;
         var11 = class39.method673(var6);
         ObjectDef var21 = class110.getObjectDef(var11);
         if(var21.int701 != -1) {
            PaletteSprite var27 = class25.field214[var21.int701];
            if(var27 != null) {
               var26 = (var21.int693 * 4 - var27.width1) / 2;
               var15 = (var21.int688 * 4 - var27.height1) / 2;
               var27.method5829(var1 * 4 + var26 + 48, (104 - var2 - var21.int688) * 4 + var15 + 48);
            }
         } else if(var10 == 9) {
            label175: {
               int var25 = 15658734;
               if(class67.method1683(var6)) {
                  if(var5 <= -1797356295) {
                     return;
                  }

                  var25 = 15597568;
               }

               int[] var24 = Npc.field1038.pixels;
               var15 = var1 * 4 + (103 - var2) * 2048 + 24624;
               if(var9 != 0) {
                  if(var5 <= -1797356295) {
                     return;
                  }

                  if(var9 != 2) {
                     var24[var15] = var25;
                     var24[var15 + 1 + 512] = var25;
                     var24[var15 + 1024 + 2] = var25;
                     var24[var15 + 1536 + 3] = var25;
                     break label175;
                  }
               }

               var24[var15 + 1536] = var25;
               var24[var15 + 1 + 1024] = var25;
               var24[var15 + 512 + 2] = var25;
               var24[var15 + 3] = var25;
            }
         }
      }

      var6 = class28.field248.method2901(var0, var1, var2);
      if(var6 != 0L) {
         var8 = class39.method673(var6);
         ObjectDef var22 = class110.getObjectDef(var8);
         if(var22.int701 != -1) {
            PaletteSprite var23 = class25.field214[var22.int701];
            if(var23 != null) {
               var11 = (var22.int693 * 4 - var23.width1) / 2;
               int var12 = (var22.int688 * 4 - var23.height1) / 2;
               var23.method5829(var1 * 4 + var11 + 48, var12 + (104 - var2 - var22.int688) * 4 + 48);
            }
         }
      }

   }
}
