package client;

public class class185 {
   static final int[] field2361 = new int[2048];
   static final int[] field2362 = new int[2048];
   public static Stream field2359;
   static int[] field2364;
   public static final int field2354 = 1536;
   public static final int field2355 = 1280;
   public static final int field2356 = 256;
   public static final int field2357 = 512;
   public static final int field2358 = 768;
   public static final int field2360 = 65536;
   static final int field2363 = 2048;

   static {
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; var2++) {
         field2361[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
         field2362[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
      }

   }

   public static void method3787(short var0) {
      if(class48.field429 != null) {
         if(var0 <= 11776) {
            return;
         }

         class48 var1 = class48.field429;
         synchronized(class48.field429) {
            class48.field429 = null;
         }
      }

   }

   public static int method3786(boolean var0, boolean var1, int var2) {
      int var3 = 0;
      if(var0) {
         var3 = var3 + class250.field3198 + class250.field3211;
      }

      if(var1) {
         var3 = var3 + class250.field3205 + class250.field3207;
      }

      return var3;
   }
}
