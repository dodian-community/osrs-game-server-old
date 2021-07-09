package client;

public class class86 {
   public static int field1212;
   static final int field1208 = 1;
   static final int field1211 = 50;
   static final int field1213 = 100;
   class58[] field1209 = new class58[100];
   int field1210;

   class58 method1964(int var1, String var2, String var3, String var4, byte var5) {
      class58 var6 = this.field1209[99];

      for(int var7 = this.field1210; var7 > 0; --var7) {
         if(var7 != 100) {
            this.field1209[var7] = this.field1209[var7 - 1];
         }
      }

      if(var6 == null) {
         var6 = new class58(var1, var2, var4, var3);
      } else {
         var6.unlink();
         var6.method4101();
         var6.method1070(var1, var2, var4, var3, (byte)27);
      }

      this.field1209[0] = var6;
      if(this.field1210 < 100) {
         ++this.field1210;
      }

      return var6;
   }

   class58 method1965(int var1, byte var2) {
      return var1 >= 0 && var1 < this.field1210 ? this.field1209[var1] : null;
   }

   int method1976(int var1) {
      return this.field1210;
   }

   public static int method1970(int var0, int var1, int var2, int var3, int var4, int var5, byte var6) {
      if((var5 & 1) == 1) {
         int var7 = var3;
         var3 = var4;
         var4 = var7;
      }

      var2 &= 3;
      return var2 == 0 ? var1 : (var2 == 1 ? 7 - var0 - (var3 - 1) : (var2 == 2 ? 7 - var1 - (var4 - 1) : var0));
   }
}
