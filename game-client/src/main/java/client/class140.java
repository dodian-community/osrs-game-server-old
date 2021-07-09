package client;

public class class140 extends class283 {
   static final int field1882 = 24;
   public static final int field1884 = 97;
   final boolean field1883;

   public class140(boolean var1) {
      this.field1883 = var1;
   }

   int method3147(class287 var1, class287 var2, int var3) {
      return GameClient.field581 == var1.field3628 && var2.field3628 == GameClient.field581 ? (this.field1883 ? var1.field3627 - var2.field3627 : var2.field3627 - var1.field3627) : this.method5308(var1, var2, -366074461);
   }

   public int compare(Object var1, Object var2) {
      return this.method3147((class287)var1, (class287)var2, -359404132);
   }

   public static boolean method3150(int var0, byte var1) {
      return (var0 >> 29 & 1) != 0;
   }
}
