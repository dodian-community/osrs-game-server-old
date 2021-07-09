package client;

public class class254 extends class206 {
   public static class200 field3231 = new class200(64);
   public static int field3232;
   static final int field3233 = 24;
   public int field3230 = 0;

   void method4810(Stream var1, int var2, byte var3) {
      if(var2 == 5) {
         if(var3 >= 1) {
            return;
         }

         this.field3230 = var1.readUShort();
      }

   }

   void method4809(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            if(var2 <= -1224593430) {
               return;
            }

            return;
         }

         this.method4810(var1, var3, (byte)-13);
      }
   }
}
