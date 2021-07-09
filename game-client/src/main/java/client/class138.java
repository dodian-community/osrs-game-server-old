package client;

public class class138 extends class283 {
   static Player field1876;
   public static class247 field1871;
   static final int field1873 = 67;
   public static final int field1874 = 1;
   public static final int field1875 = 99;
   final boolean field1872;

   public class138(boolean var1) {
      this.field1872 = var1;
   }

   int method3128(class287 var1, class287 var2, int var3) {
      return GameClient.field581 == var1.field3628 && var2.field3628 == GameClient.field581 ? (this.field1872 ? var1.method5287(-1680166277).method5435(var2.method5287(-507641084), 1199284504) : var2.method5287(1281601690).method5435(var1.method5287(-519009611), 1104372999)) : this.method5308(var1, var2, -366074461);
   }

   public int compare(Object var1, Object var2) {
      return this.method3128((class287)var1, (class287)var2, -1072609889);
   }

   public static int method3137(CharSequence var0, int var1) {
      return class68.method1693(var0, var1, true);
   }
}
