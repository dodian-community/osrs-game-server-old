package client;

public class class146 implements class188 {
   public static final class146 field1908 = new class146(3, 0);
   public static final class146 field1910 = new class146(1, 1);
   public static final class146 field1907 = new class146(2, 2);
   public static final class146 field1905 = new class146(0, 3);
   static final int field1911 = 383;
   final int field1906;
   public final int field1909;

   class146(int var1, int var2) {
      this.field1909 = var1;
      this.field1906 = var2;
   }

   public int vmethod5815(byte var1) {
      return this.field1906;
   }

   public static int method3193(int var0, byte var1) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   public static void method3190(Stream var0, int var1, byte var2) {
      if(class155.field1968 != null) {
         try {
            class155.field1968.method2476(0L);
            class155.field1968.method2481(var0.field2338, var1, 24, 752082708);
         } catch (Exception var4) {
            ;
         }
      }

   }

   public static Widget method3191(int var0, int var1, int var2) {
      Widget var3 = Widget.getLoaded(var0);
      return var1 == -1 ? var3 : (var3 != null && var3.children != null && var1 < var3.children.length ? var3.children[var1] : null);
   }
}
