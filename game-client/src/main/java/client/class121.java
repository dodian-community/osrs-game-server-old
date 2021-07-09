package client;

import java.lang.management.GarbageCollectorMXBean;

public class class121 {
   static GarbageCollectorMXBean field1660;
   public static final int field1663 = 55;
   static final int field1664 = 25;
   int field1665;
   int field1661;
   int field1662;
   int field1666;

   class121() {
   }

   class121(class121 var1) {
      this.field1665 = var1.field1665;
      this.field1661 = var1.field1661;
      this.field1662 = var1.field1662;
      this.field1666 = var1.field1666;
   }

   static void method2782(int var0, byte var1) {
      class53 var2 = (class53)class53.field474.get((long)var0);
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.field477.length; var3++) {
            var2.field477[var3] = -1;
            var2.field473[var3] = 0;
         }

      }
   }

   static final void method2783(int var0, int var1, int var2, int var3, Sprite var4, class224 var5, int var6) {
      int var7 = var3 * var3 + var2 * var2;
      if(var7 > 4225) {
         if(var6 != 606939264) {
            return;
         }

         if(var7 < 90000) {
            if(var6 != 606939264) {
               return;
            }

            int var8 = GameClient.field717 & 2047;
            int var9 = class122.field1681[var8];
            int var10 = class122.field1693[var8];
            int var11 = var10 * var2 + var3 * var9 >> 16;
            int var12 = var3 * var10 - var9 * var2 >> 16;
            double var13 = Math.atan2((double)var11, (double)var12);
            int var15 = var5.field2553 / 2 - 25;
            int var16 = (int)(Math.sin(var13) * (double)var15);
            int var17 = (int)(Math.cos(var13) * (double)var15);
            byte var18 = 20;
            class136.field1862.method5865(var16 + (var0 + var5.field2553 / 2 - var18 / 2), var5.field2549 / 2 + var1 - var18 / 2 - var17 - 10, var18, var18, 15, 15, var13, 256);
            return;
         }
      }

      class55.method1022(var0, var1, var2, var3, var4, var5, (byte)52);
   }
}
