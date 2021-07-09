package client;

public class class277 {
   public static final int field3565 = 2;
   public static final int field3566 = 32;
   public static final int field3567 = 2;
   public static final int field3568 = 64;
   public static final int field3569 = 2048;
   public static final int field3570 = 16;
   public static final int field3571 = 4;
   static final int field3572 = 1;

   public static int method5240(CharSequence var0, byte var1) {
      int var2 = var0.length();
      int var3 = 0;

      for(int var4 = 0; var4 < var2; var4++) {
         var3 = (var3 << 5) - var3 + class166.method3441(var0.charAt(var4), -510663383);
      }

      return var3;
   }
}
