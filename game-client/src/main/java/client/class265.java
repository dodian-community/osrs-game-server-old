package client;

public class class265 extends class206 {
   public static class200 field3334 = new class200(64);
   class197 field3335;

   void method4967(Stream var1, int var2, byte var3) {
      if(var2 == 249) {
         this.field3335 = PacketBuilder.method691(var1, this.field3335);
      }

   }

   public int method4962(int var1, int var2, int var3) {
      return class67.method1668(this.field3335, var1, var2, (short)-22304);
   }

   public String method4963(int var1, String var2, int var3) {
      return class17.method171(this.field3335, var1, var2, (short)255);
   }

   public void method4961(short var1) {
   }

   public void method4960(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4967(var1, var3, (byte)49);
      }
   }

   public static String method4976(CharSequence var0, short var1) {
      int var3 = var0.length();
      char[] var4 = new char[var3];

      for(int var5 = 0; var5 < var3; var5++) {
         var4[var5] = 42;
      }

      String var2 = new String(var4);
      return var2;
   }
}
