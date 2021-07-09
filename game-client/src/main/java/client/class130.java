package client;

public class class130 extends class206 {
   public static class247 field1801;
   static String[] field1800;
   static final int field1798 = 19136824;
   static final int field1799 = 17;
   class117[] field1802;

   public class130(class247 var1, class247 var2, int var3, boolean var4) {
      class205 var5 = new class205();
      int var6 = var1.getFileCount(var3);
      this.field1802 = new class117[var6];
      int[] var7 = var1.method4668(var3, -842581677);

      for(int var8 = 0; var8 < var7.length; var8++) {
         byte[] var9 = var1.method4625(var3, var7[var8], 461309229);
         class124 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class124 var12 = (class124)var5.method4098(); var12 != null; var12 = (class124)var5.method4079()) {
            if(var11 == var12.field1704) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method4676(0, var11, -1954439522);
            } else {
               var13 = var2.method4676(var11, 0, -885147864);
            }

            var10 = new class124(var11, var13);
            var5.method4073(var10);
         }

         this.field1802[var7[var8]] = new class117(var9, var10);
      }

   }

   public boolean method3075(int var1, int var2) {
      return this.field1802[var1].field1552;
   }

   static void method3077(int var0, byte var1) {
      for(class211 var2 = (class211) GameClient.interfaceSettings.method4018(); var2 != null; var2 = (class211) GameClient.interfaceSettings.method4019()) {
         if((long)var0 == (var2.field2421 >> 48 & 65535L)) {
            var2.unlink();
         }
      }

   }

   public static class253 method3074(int var0, int var1) {
      class253 var2 = (class253)class253.field3228.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class253.field3226.method4625(5, var0, 563894549);
         var2 = new class253();
         if(var3 != null) {
            var2.method4799(new Stream(var3), 884121490);
         }

         class253.field3228.method3983(var2, (long)var0);
         return var2;
      }
   }
}
