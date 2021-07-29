package client;

public class class143 extends class283 {
   static Widget field1897;
   static int[] field1900;
   static class307 field1899;
   static final int field1892 = 256;
   static final int field1894 = 7;
   static final int field1895 = 128;
   static final int field1896 = 90;
   static final int field1898 = 64;
   final boolean field1893;

   public class143(boolean var1) {
      this.field1893 = var1;
   }

   int method3165(class287 var1, class287 var2, byte var3) {
      return var2.field3628 != var1.field3628 ? (this.field1893 ? var1.field3628 - var2.field3628 : var2.field3628 - var1.field3628) : this.method5308(var1, var2, -366074461);
   }

   public int compare(Object var1, Object var2) {
      return this.method3165((class287)var1, (class287)var2, (byte)3);
   }

   static void method3172(int messageTypeMaybe, String var1, String var2) {
      class173.method3472(messageTypeMaybe, var1, var2, null, -2103996728);
   }

   public static final int method3167(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(var2 != 0.0D) {
         double var12;
         if(var4 < 0.5D) {
            var12 = var4 * (var2 + 1.0D);
         } else {
            var12 = var4 + var2 - var2 * var4;
         }

         double var14 = 2.0D * var4 - var12;
         double var16 = var0 + 0.3333333333333333D;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(6.0D * var16 < 1.0D) {
            var6 = var14 + var16 * 6.0D * (var12 - var14);
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = var14 + 6.0D * (0.6666666666666666D - var16) * (var12 - var14);
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = var14 + var0 * 6.0D * (var12 - var14);
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = 6.0D * (0.6666666666666666D - var0) * (var12 - var14) + var14;
         } else {
            var8 = var14;
         }

         if(var20 * 6.0D < 1.0D) {
            var10 = (var12 - var14) * 6.0D * var20 + var14;
         } else if(2.0D * var20 < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = (var12 - var14) * (0.6666666666666666D - var20) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(var8 * 256.0D);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   public static int method3173(int var0, int var1) {
      int var2 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var2 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var2 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var2 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var2 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var2;
      }

      return var0 + var2;
   }
}
