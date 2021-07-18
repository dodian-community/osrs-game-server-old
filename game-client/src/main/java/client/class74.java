package client;

public class class74 {
   static final int field1058 = 100;

   static final void method1800(class62 var0, byte var1) {
      long var2 = 0L;
      int var4 = -1;
      int var5 = 0;
      int var6 = 0;
      if(var0.field856 == 0) {
         var2 = class28.field248.method2898(var0.field861, var0.field857, var0.field858);
      }

      if(var0.field856 == 1) {
         var2 = class28.field248.method2899(var0.field861, var0.field857, var0.field858);
      }

      if(var0.field856 == 2) {
         var2 = class28.field248.method2900(var0.field861, var0.field857, var0.field858);
      }

      if(var0.field856 == 3) {
         var2 = class28.field248.method2901(var0.field861, var0.field857, var0.field858);
      }

      if(var2 != 0L) {
         int var7 = class28.field248.method2902(var0.field861, var0.field857, var0.field858, var2);
         var4 = PacketBuilder.method673(var2);
         var5 = var7 & 31;
         var6 = var7 >> 6 & 3;
      }

      var0.field859 = var4;
      var0.field866 = var5;
      var0.field865 = var6;
   }
}
