package client;

public class class25 {
   static final class25 field209 = new class25(1);
   static final class25 field212 = new class25(0);
   static int[] field215;
   static PaletteSprite[] field214;
   public static final int field210 = 128;
   static final int field213 = 3;
   final int field211;

   class25(int var1) {
      this.field211 = var1;
   }

   static final boolean method426(Widget var0, int var1) {
      int var2 = var0.interactType;
      if(var2 == 205) {
         GameClient.field627 = 250;
         return true;
      } else {
         int var3;
         int var4;
         if(var2 >= 300 && var2 <= 313) {
            var3 = (var2 - 300) / 2;
            var4 = var2 & 1;
            GameClient.field841.method4478(var3, var4 == 1, -1617344099);
         }

         if(var2 >= 314 && var2 <= 323) {
            var3 = (var2 - 314) / 2;
            var4 = var2 & 1;
            GameClient.field841.method4493(var3, var4 == 1, (byte)43);
         }

         if(var2 == 324) {
            GameClient.field841.method4465(false, -75355904);
         }

         if(var2 == 325) {
            GameClient.field841.method4465(true, -75355904);
         }

         if(var2 == 326) {
            class172 var5 = class26.method433(OutgoingPacket.field2173, GameClient.field626.field1218, -970266424);
            GameClient.field841.method4466(var5.field2257, (byte)-121);
            GameClient.field626.method1980(var5);
            return true;
         } else {
            return false;
         }
      }
   }
}
