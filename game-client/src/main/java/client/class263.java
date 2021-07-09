package client;

public class class263 extends class206 {
   public static class200 field3321 = new class200(64);
   public static class247 field3322;
   static int[] field3325;
   static final int field3324 = 1;
   public int field3320;
   public int field3323;
   public int field3326;

   void method4942(Stream var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3320 = var1.readUShort();
         this.field3323 = var1.readUByte();
         this.field3326 = var1.readUByte();
      }

   }

   public void method4941(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4942(var1, var3, 1481115001);
      }
   }
}
