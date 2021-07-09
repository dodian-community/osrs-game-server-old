package client;

public class class233 implements class188 {
   public static final class233 field2773 = new class233(0, 0);
   static final class233 field2775 = new class233(1, 0);
   public static final class233 field2755 = new class233(2, 0);
   static final class233 field2759 = new class233(10, 2);
   static final class233 field2764 = new class233(11, 2);
   public static final class233 field2757 = new class233(3, 0);
   public static final class233 field2758 = new class233(9, 2);
   public static final class233 field2776 = new class233(22, 3);
   static final class233 field2754 = new class233(4, 1);
   static final class233 field2770 = new class233(5, 1);
   static final class233 field2761 = new class233(6, 1);
   static final class233 field2762 = new class233(7, 1);
   static final class233 field2763 = new class233(8, 1);
   static final class233 field2760 = new class233(12, 2);
   static final class233 field2765 = new class233(13, 2);
   static final class233 field2766 = new class233(14, 2);
   static final class233 field2767 = new class233(15, 2);
   static final class233 field2768 = new class233(16, 2);
   static final class233 field2769 = new class233(17, 2);
   static final class233 field2774 = new class233(18, 2);
   static final class233 field2771 = new class233(19, 2);
   static final class233 field2772 = new class233(20, 2);
   static final class233 field2756 = new class233(21, 2);
   static final int field2778 = 86;
   public final int field2777;

   class233(int var1, int var2) {
      this.field2777 = var1;
   }

   public int vmethod5815(byte var1) {
      return this.field2777;
   }

   public static PaletteSprite method4589(class247 var0, int var1, int var2) {
      byte[] var4 = var0.method4689(var1, -752592139);
      boolean var3;
      if(var4 == null) {
         var3 = false;
      } else {
         ObjectDef.method5084(var4, (byte)26);
         var3 = true;
      }

      return !var3 ? null : class305.method5658(1318219257);
   }

   static final void method4588(String var0, byte var1) {
      StringBuilder var10000 = (new StringBuilder()).append(var0);
      Object var10001 = null;
      String var2 = var10000.append(" is already on your friend list").toString();
      class143.method3172(30, "", var2);
   }
}
