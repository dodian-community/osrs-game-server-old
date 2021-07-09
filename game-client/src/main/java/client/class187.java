package client;

public class class187 {
   static int field2372;
   static final int field2371 = 9;

   public static int method3812(byte[] var0, int var1, int var2, int var3) {
      int var4 = -1;

      for(int var5 = var1; var5 < var2; var5++) {
         var4 = var4 >>> 8 ^ Stream.field2336[(var4 ^ var0[var5]) & 255];
      }

      var4 = ~var4;
      return var4;
   }
}
