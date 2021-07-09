package client;

public class class264 extends class206 {
   public static class200 field3328 = new class200(64);
   public static class247 field3327;
   public static final int field3329 = 2;
   char field3331;
   boolean field3332 = true;
   public int field3330;
   public String field3333;

   void method4950(Stream var1, int var2, byte var3) {
      if(var2 == 1) {
         byte var5 = var1.readByte();
         int var6 = var5 & 255;
         if(var6 == 0) {
            if(var3 == 1) {
               return;
            }

            throw new IllegalArgumentException("");
         }

         if(var6 >= 128 && var6 < 160) {
            if(var3 == 1) {
               return;
            }

            char var7 = class301.field3714[var6 - 128];
            if(var7 == 0) {
               var7 = 63;
            }

            var6 = var7;
         }

         char var4 = (char)var6;
         this.field3331 = var4;
      } else if(var2 == 2) {
         this.field3330 = var1.readInt();
      } else if(var2 == 4) {
         this.field3332 = false;
      } else if(var2 == 5) {
         this.field3333 = var1.readString();
      }

   }

   public boolean method4951(int var1) {
      return this.field3331 == 115;
   }

   void method4954(byte var1) {
   }

   void method4948(Stream var1, byte var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4950(var1, var3, (byte)-29);
      }
   }
}
