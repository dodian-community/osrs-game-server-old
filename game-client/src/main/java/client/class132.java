package client;

public final class class132 {
   static Widget field1819;
   static Widget[] field1814;
   int field1806;
   int field1809;
   int field1822;
   int field1813;
   int field1817;
   int field1807;
   int field1811;
   int field1818;
   int field1805;
   int field1815;
   int field1812;
   int field1821;
   int field1803;
   int field1816;
   int field1808;
   int field1810;
   int field1820;
   int field1804;

   static final boolean method3097(Widget var0, int var1) {
      if(var0.field2719 == null) {
         return false;
      } else {
         for(int var2 = 0; var2 < var0.field2719.length; var2++) {
            int var3 = class137.method3119(var0, var2, 1207234398);
            int var4 = var0.field2720[var2];
            if(var0.field2719[var2] == 2) {
               if(var3 >= var4) {
                  return false;
               }
            } else if(var0.field2719[var2] == 3) {
               if(var3 <= var4) {
                  return false;
               }
            } else if(var0.field2719[var2] == 4) {
               if(var4 == var3) {
                  return false;
               }
            } else if(var3 != var4) {
               return false;
            }
         }

         return true;
      }
   }

   static void method3096(int var0, int var1) {
      GameClient.field655 = var0;
   }
}
