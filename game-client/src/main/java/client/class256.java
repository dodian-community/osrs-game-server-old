package client;

public class class256 extends class206 {
   static class200 field3257 = new class200(64);
   static class247 field3258;
   public boolean field3256 = false;

   void method4839(Stream var1, int var2, int var3) {
      if(var2 == 2) {
         if(var3 >= -168169281) {
            return;
         }

         this.field3256 = true;
      }

   }

   void method4848(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4839(var1, var3, -1677882054);
      }
   }
}
