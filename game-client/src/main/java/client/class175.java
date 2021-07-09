package client;

import java.util.zip.Inflater;

public class class175 {
   static boolean[] field2271;
   static class249 field2270;
   static final int field2269 = 5;
   static final int field2272 = 2;
   Inflater field2268;

   class175(int var1, int var2, int var3) {
   }

   public class175() {
      this(-1, 1000000, 1000000);
   }

   public void method3483(Stream var1, byte[] var2, int var3) {
      if(var1.field2338[var1.field2339] == 31 && var1.field2338[var1.field2339 + 1] == -117) {
         if(this.field2268 == null) {
            this.field2268 = new Inflater(true);
         }

         try {
            this.field2268.setInput(var1.field2338, var1.field2339 + 10, var1.field2338.length - (var1.field2339 + 8 + 10));
            this.field2268.inflate(var2);
         } catch (Exception var5) {
            this.field2268.reset();
            //throw new RuntimeException("");
         }

         this.field2268.reset();
      } else {
         //throw new RuntimeException("");
      }
   }

   public static class257 method3485(int var0, int var1) {
      class257 var2 = (class257)class257.field3260.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class257.field3264.method4625(15, var0, 1257746275);
         var2 = new class257();
         if(var3 != null) {
            var2.method4852(new Stream(var3), (byte)75);
         }

         class257.field3260.method3983(var2, (long)var0);
         return var2;
      }
   }

   static void method3487(Stream var0, int var1, int var2) {
      byte[] var3 = var0.field2338;
      if(GameClient.field620 == null) {
         GameClient.field620 = new byte[24];
      }

      class193.method3873(var3, var1, GameClient.field620, 0, 24);
      class146.method3190(var0, var1, (byte)0);
   }
}
