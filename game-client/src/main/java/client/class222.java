package client;

import java.io.IOException;

public class class222 extends class105 {
   class88 field2544 = new class88();
   class218 field2545;
   class205 field2543 = new class205();

   class222(class218 var1) {
      this.field2545 = var1;
   }

   protected void vmethod4385(int[] var1, int var2, int var3) {
      this.field2544.vmethod4385(var1, var2, var3);

      for(class219 var6 = (class219)this.field2543.method4098(); var6 != null; var6 = (class219)this.field2543.method4079()) {
         if(!this.field2545.method4230(var6, 170135381)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2513) {
                  this.method4387(var6, var1, var4, var5, var4 + var5, (byte)-29);
                  var6.field2513 -= var5;
                  break;
               }

               this.method4387(var6, var1, var4, var6.field2513, var4 + var5, (byte)-60);
               var4 += var6.field2513;
               var5 -= var6.field2513;
            } while(!this.field2545.method4231(var6, var1, var4, var5, -896686451));
         }
      }

   }

   protected void vmethod4386(int var1) {
      this.field2544.vmethod4386(var1);

      for(class219 var3 = (class219)this.field2543.method4098(); var3 != null; var3 = (class219)this.field2543.method4079()) {
         if(!this.field2545.method4230(var3, 724893779)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2513) {
                  this.method4388(var3, var2, -1660256078);
                  var3.field2513 -= var2;
                  break;
               }

               this.method4388(var3, var3.field2513, -1604012040);
               var2 -= var3.field2513;
            } while(!this.field2545.method4231(var3, (int[])null, 0, var2, -549826874));
         }
      }

   }

   protected class105 vmethod4389() {
      class219 var1;
      do {
         var1 = (class219)this.field2543.method4079();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2512 == null);

      return var1.field2512;
   }

   void method4388(class219 var1, int var2, int var3) {
      if((this.field2545.field2478[var1.field2500] & 4) != 0 && var1.field2508 < 0) {
         int var4 = this.field2545.field2483[var1.field2500] / class95.field1300;
         int var5 = (var4 + 1048575 - var1.field2514) / var4;
         var1.field2514 = var4 * var2 + var1.field2514 & 1048575;
         if(var5 <= var2) {
            if(this.field2545.field2471[var1.field2500] == 0) {
               var1.field2512 = class103.method2256(var1.field2496, var1.field2512.method2351(), var1.field2512.method2262(), var1.field2512.method2263());
            } else {
               var1.field2512 = class103.method2256(var1.field2496, var1.field2512.method2351(), 0, var1.field2512.method2263());
               this.field2545.method4208(var1, var1.field2517.field2534[var1.field2502] < 0, 1940134269);
            }

            if(var1.field2517.field2534[var1.field2502] < 0) {
               var1.field2512.method2258(-1);
            }

            var2 = var1.field2514 / var4;
         }
      }

      var1.field2512.vmethod4386(var2);
   }

   void method4387(class219 var1, int[] var2, int var3, int var4, int var5, byte var6) {
      if((this.field2545.field2478[var1.field2500] & 4) != 0 && var1.field2508 < 0) {
         int var7 = this.field2545.field2483[var1.field2500] / class95.field1300;

         while(true) {
            int var8 = (var7 + 1048575 - var1.field2514) / var7;
            if(var8 > var4) {
               var1.field2514 += var4 * var7;
               break;
            }

            var1.field2512.vmethod4385(var2, var3, var8);
            var3 += var8;
            var4 -= var8;
            var1.field2514 += var7 * var8 - 1048576;
            int var9 = class95.field1300 / 100;
            int var10 = 262144 / var7;
            if(var10 < var9) {
               var9 = var10;
            }

            class103 var11 = var1.field2512;
            if(this.field2545.field2471[var1.field2500] == 0) {
               var1.field2512 = class103.method2256(var1.field2496, var11.method2351(), var11.method2262(), var11.method2263());
            } else {
               var1.field2512 = class103.method2256(var1.field2496, var11.method2351(), 0, var11.method2263());
               this.field2545.method4208(var1, var1.field2517.field2534[var1.field2502] < 0, 2128286841);
               var1.field2512.method2408(var9, var11.method2262());
            }

            if(var1.field2517.field2534[var1.field2502] < 0) {
               var1.field2512.method2258(-1);
            }

            var11.method2269(var9);
            var11.vmethod4385(var2, var3, var5 - var3);
            if(var11.method2273()) {
               this.field2544.method2032(var11);
            }
         }
      }

      var1.field2512.vmethod4385(var2, var3, var4);
   }

   protected class105 vmethod4382() {
      class219 var1 = (class219)this.field2543.method4098();
      return (class105)(var1 == null ? null : (var1.field2512 != null ? var1.field2512 : this.vmethod4389()));
   }

   protected int vmethod4395() {
      return 0;
   }

   public static void method4410(boolean var0, int var1) {
      if(class250.field3200 != null) {
         try {
            Stream var2 = new Stream(4);
            var2.writeByte(var0 ? 2 : 3);
            var2.method3534(0, -2014469866);
            class250.field3200.vmethod3347(var2.field2338, 0, 4, (byte)-112);
         } catch (IOException var5) {
            try {
               class250.field3200.vmethod3346(1775992211);
            } catch (Exception var4) {
               ;
            }

            ++class250.field3215;
            class250.field3200 = null;
         }

      }
   }
}
