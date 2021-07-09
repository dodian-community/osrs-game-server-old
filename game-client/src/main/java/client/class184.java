package client;

public class class184 {
   static long field2351;
   static long field2350;
   public static final int field2352 = 4;
   static final int field2353 = 2340;

   static void method3785(int var0, int var1, int var2) {
      int var3 = class293.field3660.method5517("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < GameClient.field771; var4++) {
         if(var2 != 805819777) {
            return;
         }

         var5 = class293.field3660.method5517(class18.method176(var4, 1753314249));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = GameClient.field771 * 15 + 22;
      var5 = var0 - var3 / 2;
      if(var3 + var5 > class82.field1179) {
         if(var2 != 805819777) {
            return;
         }

         var5 = class82.field1179 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var1;
      if(var1 + var4 > class243.field3138) {
         if(var2 != 805819777) {
            return;
         }

         var6 = class243.field3138 - var4;
      }

      if(var6 < 0) {
         if(var2 != 805819777) {
            return;
         }

         var6 = 0;
      }

      class48.field435 = var5;
      class0.field1 = var6;
      class135.field1856 = var3;
      class151.field1933 = GameClient.field771 * 15 + 22;
   }
}
