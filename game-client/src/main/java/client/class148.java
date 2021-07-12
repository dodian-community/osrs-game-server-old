package client;

public class class148 implements class147 {
   public static int field1913;
   static final int field1912 = 51;
   public static final int field1914 = 40000;
   static final int field1915 = 18;
   static final int field1916 = 5;
   static final int field1917 = 6;

   public static boolean method3196() {
      try {
         if(class217.field2460 == 2) {
            if(class177.field2285 == null) {
               class177.field2285 = class223.method4415(class138.field1871, class217.field2461, class217.field2462);
               if(class177.field2285 == null) {
                  return false;
               }
            }

            if(Item.field1149 == null) {
               Item.field1149 = new class98(class217.field2458, class217.field2464);
            }

            if(class217.field2459.method4198(class177.field2285, class177.field2284, Item.field1149, 22050, 1013201658)) {
               class217.field2459.method4199(-2111468279);
               class217.field2459.method4236(class309.field3740, 1345911683);
               class217.field2459.method4267(class177.field2285, class217.field2463, 1233433858);
               class217.field2460 = 0;
               class177.field2285 = null;
               Item.field1149 = null;
               class138.field1871 = null;
               return true;
            }
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class217.field2459.method4202((byte)67);
         class217.field2460 = 0;
         class177.field2285 = null;
         Item.field1149 = null;
         class138.field1871 = null;
      }

      return false;
   }

   static void method3198() {
      if(class138.field1876.field931 >> 7 == GameClient.field808 && class138.field1876.field881 >> 7 == GameClient.field809) {
         GameClient.field808 = 0;
      }

   }

   static void method3195(int var0, int var1) {
      int[] var3 = new int[4];
      int[] var4 = new int[4];
      var3[0] = var0;
      var4[0] = var1;
      int var5 = 1;

      for(int var6 = 0; var6 < 4; var6++) {
         if(class65.field946[var6] != var0) {
            var3[var5] = class65.field946[var6];
            var4[var5] = class65.field939[var6];
            ++var5;
         }
      }

      class65.field946 = var3;
      class65.field939 = var4;
      class22.method282(class65.field949, 0, class65.field949.length - 1, class65.field946, class65.field939, 1515419045);
   }

   public static boolean method3197(int var0, int var1) {
      return (var0 >> 31 & 1) != 0;
   }
}
