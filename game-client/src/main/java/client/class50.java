package client;

public final class class50 {
   static int[][][] field459 = new int[4][105][105];
   static byte[][][] field443 = new byte[4][104][104];
   static int field442 = 99;
   static final int[] field450 = new int[]{1, 2, 4, 8};
   static final int[] field451 = new int[]{16, 32, 64, 128};
   static final int[] field452 = new int[]{1, 0, -1, 0};
   static final int[] field453 = new int[]{0, -1, 0, 1};
   static final int[] field458 = new int[]{1, -1, -1, 1};
   static final int[] field449 = new int[]{-1, -1, 1, 1};
   static int field457 = (int)(Math.random() * 17.0D) - 8;
   static int field455 = (int)(Math.random() * 33.0D) - 16;
   static int field456;
   static class249 field461;
   static byte[][][] field445;
   static byte[][][] field446;
   static byte[][][] field447;
   static int[][] field448;
   static int[] field454;
   static final int field444 = 100;
   static final int field460 = 1024;

   static void method991(int var0, byte var1) {
      GameClient.field791 = 0L;
      if(var0 >= 2) {
         if(var1 >= 4) {
            return;
         }

         GameClient.field792 = true;
      } else {
         GameClient.field792 = false;
      }

      int var2 = GameClient.field792 ? 2 : 1;
      if(var2 == 1) {
         Stream.client.method906(765, 503, 349970276);
      } else {
         Stream.client.method906(7680, 2160, 1529400794);
      }

      if(GameClient.field589 >= 25) {
         class172 var3 = class26.method433(OutgoingPacket.field2215, GameClient.field626.field1218, -1221349687);
         PacketBuffer var4 = var3.field2257;
         int var5 = GameClient.field792 ? 2 : 1;
         var4.writeByte(var5);
         var3.field2257.writeShort(class82.field1179);
         var3.field2257.writeShort(class243.field3138);
         GameClient.field626.method1980(var3, (byte)1);
      }

   }

   public static final void method993(String var0, String var1, int var2, int var3, int var4, int var5, int var6) {
      class243.method4612(var0, var1, var2, var3, var4, var5, false, (byte)-15);
   }

   static void method965(int var0, int var1, byte var2) {
      if(GameClient.field811 != 0 && var0 != -1) {
         class63.method1554(class61.field576, var0, 0, GameClient.field811, false, (short)-8725);
         GameClient.field813 = true;
      }

   }
}
