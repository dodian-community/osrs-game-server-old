package client;

public class class144 extends class283 {
   public static final int field1901 = 100;
   final boolean field1902;

   public class144(boolean var1) {
      this.field1902 = var1;
   }

   int method3175(class287 var1, class287 var2, byte var3) {
      return var2.field3629 != var1.field3629 ? (this.field1902 ? var1.field3629 - var2.field3629 : var2.field3629 - var1.field3629) : this.method5308(var1, var2, -366074461);
   }

   public int compare(Object var1, Object var2) {
      return this.method3175((class287)var1, (class287)var2, (byte)66);
   }

   public static void method3181(class247 var0, class247 var1, byte var2) {
      class261.field3304 = var0;
      class261.field3314 = var1;
   }
}
