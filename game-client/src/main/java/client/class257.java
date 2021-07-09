package client;

public class class257 extends class206 {
   static class200 field3260 = new class200(64);
   static int field3259;
   public static class247 field3264;
   static final int field3262 = 4;
   static final int field3263 = 128;
   public boolean field3261 = false;

   void method4854(Stream var1, int var2, short var3) {
      if(var2 == 2) {
         this.field3261 = true;
      }

   }

   void method4852(Stream var1, byte var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4854(var1, var3, (short)1000);
      }
   }

   public static void method4851(class247 var0, class247 var1, int var2) {
      class260.field3292 = var0;
      class260.field3290 = var1;
      class260.field3294 = class260.field3292.getFileCount(3);
   }
}
