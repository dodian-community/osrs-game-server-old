package client;

public final class class134 {
   static final int field1836 = -2;
   static final int field1851 = 256;
   int field1842;
   int field1843;
   public long field1848 = 0L;
   int field1849 = 0;
   int field1840;
   int field1850;
   int field1841;
   int field1838;
   int field1839;
   int field1837;
   public class127 field1844;
   int field1845;
   int field1847;
   int field1846;

   static final void method3103(int var0) {
      boolean var1 = false;

      while(!var1) {
         var1 = true;

         for(int var2 = 0; var2 < GameClient.field771 - 1; var2++) {
            if(GameClient.field720[var2] < 1000 && GameClient.field720[var2 + 1] > 1000) {
               String var3 = GameClient.field740[var2];
               GameClient.field740[var2] = GameClient.field740[var2 + 1];
               GameClient.field740[var2 + 1] = var3;
               String var4 = GameClient.field735[var2];
               GameClient.field735[var2] = GameClient.field735[var2 + 1];
               GameClient.field735[var2 + 1] = var4;
               int var5 = GameClient.field720[var2];
               GameClient.field720[var2] = GameClient.field720[var2 + 1];
               GameClient.field720[var2 + 1] = var5;
               var5 = GameClient.field718[var2];
               GameClient.field718[var2] = GameClient.field718[var2 + 1];
               GameClient.field718[var2 + 1] = var5;
               var5 = GameClient.field851[var2];
               GameClient.field851[var2] = GameClient.field851[var2 + 1];
               GameClient.field851[var2 + 1] = var5;
               var5 = GameClient.field794[var2];
               GameClient.field794[var2] = GameClient.field794[var2 + 1];
               GameClient.field794[var2 + 1] = var5;
               boolean var6 = GameClient.field590[var2];
               GameClient.field590[var2] = GameClient.field590[var2 + 1];
               GameClient.field590[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

   }

   static void method3102(Player var0, int var1, int var2, int var3) {
      if(var0.field903 == var1 && var1 != -1) {
         int var4 = class3.method25(var1, -1245321424).field3553;
         if(var4 == 1) {
            if(var3 >= -1222343493) {
               return;
            }

            var0.field904 = 0;
            var0.field901 = 0;
            var0.field906 = var2;
            var0.field907 = 0;
         }

         if(var4 == 2) {
            var0.field907 = 0;
         }
      } else if(var1 == -1 || var0.field903 == -1 || class3.method25(var1, -1028009546).field3547 >= class3.method25(var0.field903, 584598579).field3547) {
         var0.field903 = var1;
         var0.field904 = 0;
         var0.field901 = 0;
         var0.field906 = var2;
         var0.field907 = 0;
         var0.field930 = var0.field909;
      }

   }

   static class84 method3104(int var0, int var1, byte var2) {
      class84 var3 = (class84)class84.field1190.method3989((long)(var0 << 16));
      if(var3 != null) {
         return var3;
      } else {
         String var4 = String.valueOf(var0);
         int var5 = GameClient.field854.method4642(var4, -178076858);
         if(var5 == -1) {
            return null;
         } else {
            byte[] var6 = GameClient.field854.method4689(var5, -841928892);
            if(var6 != null) {
               if(var6.length <= 1) {
                  return null;
               }

               var3 = class10.method97(var6, -2110987509);
               if(var3 != null) {
                  class84.field1190.method3983(var3, (long)(var0 << 16));
                  return var3;
               }
            }

            return null;
         }
      }
   }
}
