package client;

public class class19 {
   static int field152;
   static byte[][][] field159;
   static class1 field154;
   static final int field149 = 16384;
   public static final int field150 = 16777216;
   static final int field151 = 585;
   static final int field153 = 35;
   static final int field156 = 7;
   final int field158;
   final int field155;
   final int field157;

   class19(int var1, int var2, int var3) {
      this.field158 = var1;
      this.field155 = var2;
      this.field157 = var3;
   }

   static class130 method198(int var0, int var1) {
      class130 var2 = (class130)class273.field3539.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         class247 var4 = class273.field3536;
         class247 var5 = class273.field3537;
         boolean var6 = true;
         int[] var7 = var4.method4668(var0, 506151465);

         for(int var8 = 0; var8 < var7.length; var8++) {
            byte[] var9 = var4.method4676(var0, var7[var8], -322980430);
            if(var9 == null) {
               var6 = false;
            } else {
               int var10 = (var9[0] & 255) << 8 | var9[1] & 255;
               byte[] var11 = var5.method4676(var10, 0, -342443915);
               if(var11 == null) {
                  var6 = false;
               }
            }
         }

         class130 var3;
         if(!var6) {
            var3 = null;
         } else {
            try {
               var3 = new class130(var4, var5, var0, false);
            } catch (Exception var13) {
               var3 = null;
            }
         }

         if(var3 != null) {
            class273.field3539.method3983(var3, (long)var0);
         }

         return var3;
      }
   }

   public static void method197(int var0, int var1, int var2, boolean var3, int var4) {
      class172 var5 = class26.method433(OutgoingPacket.field2156, GameClient.field626.field1218, 587732299);
      var5.field2257.writeByteN(var2);
      PacketBuffer var10000 = var5.field2257;
      int var10001;
      if(var3) {
         if(var4 != -185686221) {
            return;
         }

         var10001 = GameClient.field853;
      } else {
         var10001 = 0;
      }

      var10000.writeIntV2(var10001);
      var5.field2257.writeShortA(var1);
      var5.field2257.writeLEShortA(var0);
      GameClient.field626.method1980(var5, (byte)1);
   }
}
