package client;

public class class26 {
   static class57 field220;
   static int field223;
   static String field219;
   static final int field216 = 96;
   static final int field217 = 16711935;
   public static final int field218 = 5;
   static final int field221 = 12;
   static final int field222 = 32;

   public static class172 method433(OutgoingPacket var0, Isaac var1, int var2) {
      class172 var3;
      if(class172.field2258 == 0) {
         var3 = new class172();
      } else {
         var3 = class172.field2256[--class172.field2258];
      }

      var3.field2254 = var0;
      var3.field2253 = var0.field2177;
      if(var3.field2253 == -1) {
         var3.field2257 = new PacketBuffer(260);
      } else if(var3.field2253 == -2) {
         var3.field2257 = new PacketBuffer(10000);
      } else if(var3.field2253 <= 18) {
         var3.field2257 = new PacketBuffer(20);
      } else if(var3.field2253 <= 98) {
         var3.field2257 = new PacketBuffer(100);
      } else {
         var3.field2257 = new PacketBuffer(260);
      }

      var3.field2257.method3838(var1, (byte)-62);
      var3.field2257.method3819(var3.field2254.field2233, (byte)-123);
      var3.field2255 = 0;
      return var3;
   }

   public static void method427(int var0, int var1) {
      class217.field2460 = 1;
      class138.field1871 = null;
      class217.field2461 = -1;
      class217.field2462 = -1;
      class309.field3740 = 0;
      class217.field2463 = false;
      class6.field37 = var0;
   }

   static int method428(class65 var0, class65 var1, int var2, boolean var3, byte var4) {
      if(var2 == 1) {
         int var5 = var0.field955;
         int var6 = var1.field955;
         if(!var3) {
            if(var5 == -1) {
               var5 = 2001;
            }

            if(var6 == -1) {
               var6 = 2001;
            }
         }

         return var5 - var6;
      } else {
         return var2 == 2 ? var0.field952 - var1.field952 : (var2 == 3 ? (var0.field951.equals("-") ? (var1.field951.equals("-") ? 0 : (var3 ? -1 : 1)) : (var1.field951.equals("-") ? (var3 ? 1 : -1) : var0.field951.compareTo(var1.field951))) : (var2 == 4 ? (var0.method1569(-648432612) ? (var1.method1569(-648432612) ? 0 : 1) : (var1.method1569(-648432612) ? -1 : 0)) : (var2 == 5 ? (var0.method1567(-2036146048) ? (var1.method1567(-1842826056) ? 0 : 1) : (var1.method1567(251722456) ? -1 : 0)) : (var2 == 6 ? (var0.method1568((byte)125) ? (var1.method1568((byte)5) ? 0 : 1) : (var1.method1568((byte)96) ? -1 : 0)) : (var2 == 7 ? (var0.method1589((byte)101) ? (var1.method1589((byte)102) ? 0 : 1) : (var1.method1589((byte)66) ? -1 : 0)) : var0.field947 - var1.field947)))));
      }
   }
}
