package client;

public class class218 extends class105 {
   static final int field2477 = 1;
   static final int field2493 = 59;
   int[] field2482 = new int[16];
   int field2488;
   int field2466 = 256;
   int[] field2465 = new int[16];
   class202 field2481 = new class202(128);
   int[] field2484 = new int[16];
   int[] field2469 = new int[16];
   int[] field2472 = new int[16];
   class219[][] field2470 = new class219[16][128];
   int[] field2478 = new int[16];
   class220 field2486 = new class220();
   class222 field2492 = new class222(this);
   int[] field2468 = new int[16];
   int[] field2473 = new int[16];
   int field2489;
   int[] field2483 = new int[16];
   int[] field2467 = new int[16];
   long field2491;
   int[] field2471 = new int[16];
   int[] field2480 = new int[16];
   int field2474 = 1000000;
   boolean field2487;
   class219[][] field2485 = new class219[16][128];
   int[] field2476 = new int[16];
   long field2490;
   int[] field2475 = new int[16];
   int[] field2479 = new int[16];

   public class218() {
      this.method4216(1379656346);
   }

   void method4205(int var1, int var2, short var3) {
      this.field2484[var1] = var2;
      this.field2467[var1] = var2 & -128;
      this.method4206(var1, var2, (byte)75);
   }

   void method4209(int var1, int var2, int var3, int var4) {
      class219 var5 = this.field2470[var1][var2];
      if(var5 != null) {
         this.field2470[var1][var2] = null;
         if((this.field2478[var1] & 2) != 0) {
            if(var4 == -491896563) {
               return;
            }

            for(class219 var6 = (class219)this.field2492.field2543.method4098(); var6 != null; var6 = (class219)this.field2492.field2543.method4079()) {
               if(var6.field2500 == var5.field2500 && var6.field2508 < 0 && var5 != var6) {
                  var5.field2508 = 0;
                  break;
               }
            }
         } else {
            var5.field2508 = 0;
         }

      }
   }

   void method4213(int var1, byte var2) {
      for(class219 var3 = (class219)this.field2492.field2543.method4098(); var3 != null; var3 = (class219)this.field2492.field2543.method4079()) {
         if(var1 < 0 || var3.field2500 == var1) {
            if(var3.field2512 != null) {
               var3.field2512.method2269(class95.field1300 / 100);
               if(var3.field2512.method2273()) {
                  this.field2492.field2544.method2032(var3.field2512);
               }

               var3.method4322((byte)-10);
            }

            if(var3.field2508 < 0) {
               this.field2470[var3.field2500][var3.field2502] = null;
            }

            var3.unlink();
         }
      }

   }

   public synchronized void method4202(byte var1) {
      this.field2486.method4329();
      this.method4216(2143238650);
   }

   void method4241(int var1, int var2) {
      if(var1 >= 0) {
         this.field2468[var1] = 12800;
         this.field2469[var1] = 8192;
         this.field2473[var1] = 16383;
         this.field2465[var1] = 8192;
         this.field2475[var1] = 0;
         this.field2476[var1] = 8192;
         this.method4278(var1, -84179680);
         this.method4218(var1, (short)-16188);
         this.field2478[var1] = 0;
         this.field2479[var1] = 32767;
         this.field2480[var1] = 256;
         this.field2471[var1] = 0;
         this.method4309(var1, 8192, -2103498086);
      } else {
         for(var1 = 0; var1 < 16; var1++) {
            this.method4241(var1, 1809929257);
         }

      }
   }

   void method4210(int var1, int var2, int var3, int var4) {
   }

   void method4305(int var1, int var2, int var3, int var4) {
      this.method4209(var1, var2, 64, -2068611951);
      if((this.field2478[var1] & 2) != 0) {
         for(class219 var5 = (class219)this.field2492.field2543.method4083(); var5 != null; var5 = (class219)this.field2492.field2543.method4093()) {
            if(var5.field2500 == var1 && var5.field2508 < 0) {
               this.field2470[var1][var5.field2502] = null;
               this.field2470[var1][var2] = var5;
               int var6 = (var5.field2504 * var5.field2503 >> 12) + var5.field2516;
               var5.field2516 += var2 - var5.field2502 << 8;
               var5.field2503 = var6 - var5.field2516;
               var5.field2504 = 4096;
               var5.field2502 = var2;
               return;
            }
         }
      }

      class221 var10 = (class221)this.field2481.get((long)this.field2472[var1]);
      if(var10 == null) {
         if(var4 == 254280843) {
            ;
         }
      } else {
         class93 var9 = var10.field2533[var2];
         if(var9 != null) {
            class219 var7 = new class219();
            var7.field2500 = var1;
            var7.field2517 = var10;
            var7.field2496 = var9;
            var7.field2511 = var10.field2537[var2];
            var7.field2498 = var10.field2538[var2];
            var7.field2502 = var2;
            var7.field2507 = var3 * var3 * var10.field2532[var2] * var10.field2540 + 1024 >> 11;
            var7.field2501 = var10.field2536[var2] & 255;
            var7.field2516 = (var2 << 8) - (var10.field2534[var2] & 32767);
            var7.field2505 = 0;
            var7.field2506 = 0;
            var7.field2497 = 0;
            var7.field2508 = -1;
            var7.field2495 = 0;
            if(this.field2471[var1] == 0) {
               var7.field2512 = class103.method2256(var9, this.method4249(var7, 497644695), this.method4222(var7, 1057213260), this.method4286(var7, -224184680));
            } else {
               var7.field2512 = class103.method2256(var9, this.method4249(var7, 497644695), 0, this.method4286(var7, -1999361449));
               this.method4208(var7, var10.field2534[var2] < 0, 2058219149);
            }

            if(var10.field2534[var2] < 0) {
               var7.field2512.method2258(-1);
            }

            if(var7.field2498 >= 0) {
               class219 var8 = this.field2485[var1][var7.field2498];
               if(var8 != null && var8.field2508 < 0) {
                  this.field2470[var1][var8.field2502] = null;
                  var8.field2508 = 0;
               }

               this.field2485[var1][var7.field2498] = var7;
            }

            this.field2492.field2543.method4073(var7);
            this.field2470[var1][var2] = var7;
         }
      }
   }

   void method4216(int var1) {
      this.method4213(-1, (byte)70);
      this.method4241(-1, 1809929257);

      int var2;
      for(var2 = 0; var2 < 16; var2++) {
         this.field2472[var2] = this.field2484[var2];
      }

      for(var2 = 0; var2 < 16; var2++) {
         if(var1 <= -1336258627) {
            return;
         }

         this.field2467[var2] = this.field2484[var2] & -128;
      }

   }

   void method4206(int var1, int var2, byte var3) {
      if(var2 != this.field2472[var1]) {
         this.field2472[var1] = var2;

         for(int var4 = 0; var4 < 128; var4++) {
            this.field2485[var1][var4] = null;
         }
      }

   }

   protected synchronized void vmethod4385(int[] var1, int var2, int var3) {
      if(this.field2486.method4345()) {
         int var4 = this.field2486.field2519 * this.field2474 / class95.field1300;

         do {
            long var5 = this.field2490 + (long)var3 * (long)var4;
            if(this.field2491 - var5 >= 0L) {
               this.field2490 = var5;
               break;
            }

            int var7 = (int)((this.field2491 - this.field2490 + (long)var4 - 1L) / (long)var4);
            this.field2490 += (long)var4 * (long)var7;
            this.field2492.vmethod4385(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4277(-1502621602);
         } while(this.field2486.method4345());
      }

      this.field2492.vmethod4385(var1, var2, var3);
   }

   protected synchronized void vmethod4386(int var1) {
      if(this.field2486.method4345()) {
         int var2 = this.field2486.field2519 * this.field2474 / class95.field1300;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2490;
            if(this.field2491 - var3 >= 0L) {
               this.field2490 = var3;
               break;
            }

            int var5 = (int)((this.field2491 - this.field2490 + (long)var2 - 1L) / (long)var2);
            this.field2490 += (long)var5 * (long)var2;
            this.field2492.vmethod4386(var5);
            var1 -= var5;
            this.method4277(-1502621602);
         } while(this.field2486.method4345());
      }

      this.field2492.vmethod4386(var1);
   }

   void method4211(int var1, int var2, int var3) {
   }

   void method4212(int var1, int var2, short var3) {
      this.field2465[var1] = var2;
   }

   int method4249(class219 var1, int var2) {
      int var3 = (var1.field2503 * var1.field2504 >> 12) + var1.field2516;
      var3 += (this.field2465[var1.field2500] - 8192) * this.field2480[var1.field2500] >> 12;
      class216 var4 = var1.field2511;
      int var5;
      if(var4.field2452 > 0 && (var4.field2453 > 0 || this.field2475[var1.field2500] > 0)) {
         var5 = var4.field2453 << 2;
         int var6 = var4.field2454 << 1;
         if(var1.field2499 < var6) {
            var5 = var5 * var1.field2499 / var6;
         }

         var5 += this.field2475[var1.field2500] >> 7;
         double var7 = Math.sin(0.01227184630308513D * (double)(var1.field2509 & 511));
         var3 += (int)(var7 * (double)var5);
      }

      var5 = (int)((double)(var1.field2496.field1279 * 256) * Math.pow(2.0D, (double)var3 * 3.255208333333333E-4D) / (double)class95.field1300 + 0.5D);
      return var5 < 1 ? 1 : var5;
   }

   protected synchronized class105 vmethod4389() {
      return null;
   }

   synchronized boolean method4198(class223 var1, class247 var2, class98 var3, int var4, int var5) {
      var1.method4412();
      boolean var6 = true;
      int[] var7 = null;
      if(var4 > 0) {
         var7 = new int[]{var4};
      }

      for(class213 var8 = (class213)var1.field2547.method4018(); var8 != null; var8 = (class213)var1.field2547.method4019()) {
         int var9 = (int)var8.field2421;
         class221 var10 = (class221)this.field2481.get((long)var9);
         if(var10 == null) {
            byte[] var12 = var2.method4689(var9, -265893488);
            class221 var11;
            if(var12 == null) {
               var11 = null;
            } else {
               var11 = new class221(var12);
            }

            var10 = var11;
            if(var11 == null) {
               var6 = false;
               continue;
            }

            this.field2481.method4016(var11, (long)var9);
         }

         if(!var10.method4372(var3, var8.field2440, var7, (byte)19)) {
            var6 = false;
         }
      }

      if(var6) {
         var1.method4413();
      }

      return var6;
   }

   boolean method4230(class219 var1, int var2) {
      if(var1.field2512 == null) {
         if(var1.field2508 >= 0) {
            var1.unlink();
            if(var1.field2498 > 0 && var1 == this.field2485[var1.field2500][var1.field2498]) {
               this.field2485[var1.field2500][var1.field2498] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   void method4278(int var1, int var2) {
      if((this.field2478[var1] & 2) != 0) {
         for(class219 var3 = (class219)this.field2492.field2543.method4098(); var3 != null; var3 = (class219)this.field2492.field2543.method4079()) {
            if(var3.field2500 == var1 && this.field2470[var1][var3.field2502] == null && var3.field2508 < 0) {
               var3.field2508 = 0;
            }
         }
      }

   }

   public int method4288(int var1) {
      return this.field2466;
   }

   void method4218(int var1, short var2) {
      if((this.field2478[var1] & 4) != 0) {
         for(class219 var3 = (class219)this.field2492.field2543.method4098(); var3 != null; var3 = (class219)this.field2492.field2543.method4079()) {
            if(var3.field2500 == var1) {
               var3.field2514 = 0;
            }
         }
      }

   }

   public synchronized boolean method4203(int var1) {
      return this.field2486.method4345();
   }

   void method4219(int var1, int var2) {
      int var3 = var1 & 240;
      int var4;
      int var5;
      int var6;
      if(var3 == 128) {
         if(var2 == -1648204035) {
            var4 = var1 & 15;
            var5 = var1 >> 8 & 127;
            var6 = var1 >> 16 & 127;
            this.method4209(var4, var5, var6, -1229887011);
         }
      } else if(var3 == 144) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         var6 = var1 >> 16 & 127;
         if(var6 > 0) {
            this.method4305(var4, var5, var6, 254280843);
         } else {
            this.method4209(var4, var5, 64, 886120341);
         }

      } else if(var3 == 160) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         var6 = var1 >> 16 & 127;
         this.method4210(var4, var5, var6, -962421621);
      } else if(var3 == 176) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         var6 = var1 >> 16 & 127;
         if(var5 == 0) {
            this.field2467[var4] = (var6 << 14) + (this.field2467[var4] & -2080769);
         }

         if(var5 == 32) {
            this.field2467[var4] = (var6 << 7) + (this.field2467[var4] & -16257);
         }

         if(var5 == 1) {
            this.field2475[var4] = (var6 << 7) + (this.field2475[var4] & -16257);
         }

         if(var5 == 33) {
            this.field2475[var4] = var6 + (this.field2475[var4] & -128);
         }

         if(var5 == 5) {
            this.field2476[var4] = (var6 << 7) + (this.field2476[var4] & -16257);
         }

         if(var5 == 37) {
            this.field2476[var4] = var6 + (this.field2476[var4] & -128);
         }

         if(var5 == 7) {
            this.field2468[var4] = (var6 << 7) + (this.field2468[var4] & -16257);
         }

         if(var5 == 39) {
            if(var2 != -1648204035) {
               return;
            }

            this.field2468[var4] = var6 + (this.field2468[var4] & -128);
         }

         if(var5 == 10) {
            this.field2469[var4] = (var6 << 7) + (this.field2469[var4] & -16257);
         }

         if(var5 == 42) {
            this.field2469[var4] = var6 + (this.field2469[var4] & -128);
         }

         if(var5 == 11) {
            if(var2 != -1648204035) {
               return;
            }

            this.field2473[var4] = (var6 << 7) + (this.field2473[var4] & -16257);
         }

         if(var5 == 43) {
            this.field2473[var4] = var6 + (this.field2473[var4] & -128);
         }

         if(var5 == 64) {
            if(var6 >= 64) {
               this.field2478[var4] |= 1;
            } else {
               this.field2478[var4] &= -2;
            }
         }

         if(var5 == 65) {
            if(var6 >= 64) {
               this.field2478[var4] |= 2;
            } else {
               this.method4278(var4, 2089063771);
               this.field2478[var4] &= -3;
            }
         }

         if(var5 == 99) {
            this.field2479[var4] = (var6 << 7) + (this.field2479[var4] & 127);
         }

         if(var5 == 98) {
            this.field2479[var4] = (this.field2479[var4] & 16256) + var6;
         }

         if(var5 == 101) {
            this.field2479[var4] = (var6 << 7) + (this.field2479[var4] & 127) + 16384;
         }

         if(var5 == 100) {
            if(var2 != -1648204035) {
               return;
            }

            this.field2479[var4] = (this.field2479[var4] & 16256) + var6 + 16384;
         }

         if(var5 == 120) {
            this.method4213(var4, (byte)110);
         }

         if(var5 == 121) {
            this.method4241(var4, 1809929257);
         }

         if(var5 == 123) {
            this.method4215(var4, -2037469354);
         }

         int var7;
         if(var5 == 6) {
            var7 = this.field2479[var4];
            if(var7 == 16384) {
               if(var2 != -1648204035) {
                  return;
               }

               this.field2480[var4] = (var6 << 7) + (this.field2480[var4] & -16257);
            }
         }

         if(var5 == 38) {
            if(var2 != -1648204035) {
               return;
            }

            var7 = this.field2479[var4];
            if(var7 == 16384) {
               this.field2480[var4] = var6 + (this.field2480[var4] & -128);
            }
         }

         if(var5 == 16) {
            this.field2471[var4] = (var6 << 7) + (this.field2471[var4] & -16257);
         }

         if(var5 == 48) {
            this.field2471[var4] = var6 + (this.field2471[var4] & -128);
         }

         if(var5 == 81) {
            if(var2 != -1648204035) {
               return;
            }

            if(var6 >= 64) {
               if(var2 != -1648204035) {
                  return;
               }

               this.field2478[var4] |= 4;
            } else {
               this.method4218(var4, (short)-856);
               this.field2478[var4] &= -5;
            }
         }

         if(var5 == 17) {
            this.method4309(var4, (var6 << 7) + (this.field2482[var4] & -16257), -2106672840);
         }

         if(var5 == 49) {
            this.method4309(var4, var6 + (this.field2482[var4] & -128), -1989482282);
         }

      } else if(var3 == 192) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         this.method4206(var4, var5 + this.field2467[var4], (byte)90);
      } else if(var3 == 208) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         this.method4211(var4, var5, -1379201347);
      } else if(var3 == 224) {
         var4 = var1 & 15;
         var5 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4212(var4, var5, (short)-29508);
      } else {
         var3 = var1 & 255;
         if(var3 == 255) {
            this.method4216(608855451);
         }
      }
   }

   synchronized void method4199(int var1) {
      for(class221 var2 = (class221)this.field2481.method4018(); var2 != null; var2 = (class221)this.field2481.method4019()) {
         var2.method4373(1211152813);
      }

   }

   public synchronized void method4200(int var1) {
      for(class221 var2 = (class221)this.field2481.method4018(); var2 != null; var2 = (class221)this.field2481.method4019()) {
         var2.unlink();
      }

   }

   boolean method4231(class219 var1, int[] var2, int var3, int var4, int var5) {
      var1.field2513 = class95.field1300 / 100;
      if(var1.field2508 < 0 || var1.field2512 != null && !var1.field2512.method2272()) {
         int var6 = var1.field2504;
         if(var6 > 0) {
            var6 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2476[var1.field2500]) + 0.5D);
            if(var6 < 0) {
               var6 = 0;
            }

            var1.field2504 = var6;
         }

         var1.field2512.method2270(this.method4249(var1, 497644695));
         class216 var7 = var1.field2511;
         boolean var8 = false;
         ++var1.field2499;
         var1.field2509 += var7.field2452;
         double var9 = (double)((var1.field2502 - 60 << 8) + (var1.field2503 * var1.field2504 >> 12)) * 5.086263020833333E-6D;
         if(var7.field2448 > 0) {
            if(var7.field2451 > 0) {
               var1.field2505 += (int)(128.0D * Math.pow(2.0D, var9 * (double)var7.field2451) + 0.5D);
            } else {
               var1.field2505 += 128;
            }
         }

         if(var7.field2447 != null) {
            if(var7.field2450 > 0) {
               var1.field2506 += (int)(128.0D * Math.pow(2.0D, (double)var7.field2450 * var9) + 0.5D);
            } else {
               var1.field2506 += 128;
            }

            while(var1.field2497 < var7.field2447.length - 2 && var1.field2506 > (var7.field2447[var1.field2497 + 2] & 255) << 8) {
               var1.field2497 += 2;
            }

            if(var7.field2447.length - 2 == var1.field2497 && var7.field2447[var1.field2497 + 1] == 0) {
               var8 = true;
            }
         }

         if(var1.field2508 >= 0 && var7.field2449 != null && (this.field2478[var1.field2500] & 1) == 0 && (var1.field2498 < 0 || var1 != this.field2485[var1.field2500][var1.field2498])) {
            if(var7.field2446 > 0) {
               var1.field2508 += (int)(128.0D * Math.pow(2.0D, (double)var7.field2446 * var9) + 0.5D);
            } else {
               var1.field2508 += 128;
            }

            while(var1.field2495 < var7.field2449.length - 2 && var1.field2508 > (var7.field2449[var1.field2495 + 2] & 255) << 8) {
               var1.field2495 += 2;
            }

            if(var7.field2449.length - 2 == var1.field2495) {
               var8 = true;
            }
         }

         if(var8) {
            var1.field2512.method2269(var1.field2513);
            if(var2 != null) {
               var1.field2512.vmethod4385(var2, var3, var4);
            } else {
               var1.field2512.vmethod4386(var4);
            }

            if(var1.field2512.method2273()) {
               this.field2492.field2544.method2032(var1.field2512);
            }

            var1.method4322((byte)53);
            if(var1.field2508 >= 0) {
               var1.unlink();
               if(var1.field2498 > 0 && var1 == this.field2485[var1.field2500][var1.field2498]) {
                  this.field2485[var1.field2500][var1.field2498] = null;
               }
            }

            return true;
         } else {
            var1.field2512.method2268(var1.field2513, this.method4222(var1, 2064514172), this.method4286(var1, 1858181418));
            return false;
         }
      } else {
         var1.method4322((byte)-48);
         var1.unlink();
         if(var1.field2498 > 0 && var1 == this.field2485[var1.field2500][var1.field2498]) {
            this.field2485[var1.field2500][var1.field2498] = null;
         }

         return true;
      }
   }

   public synchronized void method4236(int var1, int var2) {
      this.field2466 = var1;
   }

   protected synchronized class105 vmethod4382() {
      return this.field2492;
   }

   void method4309(int var1, int var2, int var3) {
      this.field2482[var1] = var2;
      this.field2483[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   synchronized void method4267(class223 var1, boolean var2, int var3) {
      this.method4202((byte)82);
      this.field2486.method4328(var1.field2546);
      this.field2487 = var2;
      this.field2490 = 0L;
      int var4 = this.field2486.method4331();

      for(int var5 = 0; var5 < var4; var5++) {
         this.field2486.method4350(var5);
         this.field2486.method4335(var5);
         this.field2486.method4333(var5);
      }

      this.field2488 = this.field2486.method4339();
      this.field2489 = this.field2486.field2525[this.field2488];
      this.field2491 = this.field2486.method4338(this.field2489);
   }

   void method4277(int var1) {
      int var2 = this.field2488;
      int var3 = this.field2489;

      long var4;
      for(var4 = this.field2491; var3 == this.field2489; var4 = this.field2486.method4338(var3)) {
         while(var3 == this.field2486.field2525[var2]) {
            this.field2486.method4350(var2);
            int var6 = this.field2486.method4336(var2);
            if(var6 == 1) {
               this.field2486.method4334();
               this.field2486.method4333(var2);
               if(this.field2486.method4340()) {
                  if(!this.field2487 || var3 == 0) {
                     this.method4216(-118066860);
                     this.field2486.method4329();
                     return;
                  }

                  this.field2486.method4341(var4);
               }
               break;
            }

            if((var6 & 128) != 0) {
               if(var1 != -1502621602) {
                  return;
               }

               this.method4219(var6, -1648204035);
            }

            this.field2486.method4335(var2);
            this.field2486.method4333(var2);
         }

         var2 = this.field2486.method4339();
         var3 = this.field2486.field2525[var2];
      }

      this.field2488 = var2;
      this.field2489 = var3;
      this.field2491 = var4;
   }

   void method4208(class219 var1, boolean var2, int var3) {
      int var5;
      label22: {
         int var4 = var1.field2496.field1278.length;
         if(var2) {
            if(var3 <= 1613530061) {
               return;
            }

            if(var1.field2496.field1281) {
               int var6 = var4 + var4 - var1.field2496.field1277;
               var5 = (int)((long)var6 * (long)this.field2471[var1.field2500] >> 6);
               var4 <<= 8;
               if(var5 >= var4) {
                  if(var3 <= 1613530061) {
                     return;
                  }

                  var5 = var4 + var4 - 1 - var5;
                  var1.field2512.method2307(true);
               }
               break label22;
            }
         }

         var5 = (int)((long)var4 * (long)this.field2471[var1.field2500] >> 6);
      }

      var1.field2512.method2264(var5);
   }

   protected synchronized int vmethod4395() {
      return 0;
   }

   int method4222(class219 var1, int var2) {
      class216 var3 = var1.field2511;
      int var4 = this.field2473[var1.field2500] * this.field2468[var1.field2500] + 4096 >> 13;
      var4 = var4 * var4 + 16384 >> 15;
      var4 = var4 * var1.field2507 + 16384 >> 15;
      var4 = var4 * this.field2466 + 128 >> 8;
      if(var3.field2448 > 0) {
         var4 = (int)((double)var4 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field2505 * (double)var3.field2448) + 0.5D);
      }

      int var5;
      int var6;
      int var7;
      int var8;
      if(var3.field2447 != null) {
         var5 = var1.field2506;
         var6 = var3.field2447[var1.field2497 + 1];
         if(var1.field2497 < var3.field2447.length - 2) {
            var7 = (var3.field2447[var1.field2497] & 255) << 8;
            var8 = (var3.field2447[var1.field2497 + 2] & 255) << 8;
            var6 += (var5 - var7) * (var3.field2447[var1.field2497 + 3] - var6) / (var8 - var7);
         }

         var4 = var4 * var6 + 32 >> 6;
      }

      if(var1.field2508 > 0 && var3.field2449 != null) {
         var5 = var1.field2508;
         var6 = var3.field2449[var1.field2495 + 1];
         if(var1.field2495 < var3.field2449.length - 2) {
            var7 = (var3.field2449[var1.field2495] & 255) << 8;
            var8 = (var3.field2449[var1.field2495 + 2] & 255) << 8;
            var6 += (var5 - var7) * (var3.field2449[var1.field2495 + 3] - var6) / (var8 - var7);
         }

         var4 = var6 * var4 + 32 >> 6;
      }

      return var4;
   }

   int method4286(class219 var1, int var2) {
      int var3 = this.field2469[var1.field2500];
      return var3 < 8192 ? var3 * var1.field2501 + 32 >> 6 : 16384 - ((128 - var1.field2501) * (16384 - var3) + 32 >> 6);
   }

   void method4215(int var1, int var2) {
      for(class219 var3 = (class219)this.field2492.field2543.method4098(); var3 != null; var3 = (class219)this.field2492.field2543.method4079()) {
         if(var1 >= 0) {
            if(var3.field2500 != var1) {
               continue;
            }

            if(var2 == 65535) {
               return;
            }
         }

         if(var3.field2508 < 0) {
            this.field2470[var3.field2500][var3.field2502] = null;
            var3.field2508 = 0;
         }
      }

   }

   public synchronized void method4257(int var1, int var2, int var3) {
      this.method4205(var1, var2, (short)-9665);
   }
}
