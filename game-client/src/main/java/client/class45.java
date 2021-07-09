package client;

import java.applet.Applet;

public class class45 {
   static Applet field378 = null;
   static String field379 = "";
   static final int field376 = 39;
   static final int field377 = 0;
   static final int field380 = 1;
   static final int field381 = 18;
   public static final int field382 = 512;

   static void method747(int var0, int var1, int var2, int var3, String var4, byte var5) {
      Widget var6 = class146.method3191(var1, var2, -955252721);
      if(var6 != null) {
         if(var6.onClickListener != null) {
            ScriptInvocation var7 = new ScriptInvocation();
            var7.field506 = var6;
            var7.field517 = var0;
            var7.field504 = var4;
            var7.parameters = var6.onClickListener;
            class68.method1696(var7);
         }

         boolean var12 = true;
         if(var6.interactType > 0) {
            var12 = class25.method426(var6, 625790618);
         }

         if(var12) {
            int var9 = class24.method425(var6, (byte)-92);
            int var10 = var0 - 1;
            boolean var8 = (var9 >> var10 + 1 & 1) != 0;
            if(var8) {
               class172 var11;
               if(var0 == 1) {
                  var11 = class26.method433(OutgoingPacket.field2149, GameClient.field626.field1218, 1639908385);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

               if(var0 == 2) {
                  var11 = class26.method433(OutgoingPacket.field2141, GameClient.field626.field1218, -1520841705);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

               if(var0 == 3) {
                  var11 = class26.method433(OutgoingPacket.field2155, GameClient.field626.field1218, -473296891);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

               if(var0 == 4) {
                  var11 = class26.method433(OutgoingPacket.field2144, GameClient.field626.field1218, -17841390);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

               if(var0 == 5) {
                  var11 = class26.method433(OutgoingPacket.field2213, GameClient.field626.field1218, 375689364);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

               if(var0 == 6) {
                  var11 = class26.method433(OutgoingPacket.field2231, GameClient.field626.field1218, 1444993311);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

               if(var0 == 7) {
                  var11 = class26.method433(OutgoingPacket.field2160, GameClient.field626.field1218, 1535387531);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

               if(var0 == 8) {
                  var11 = class26.method433(OutgoingPacket.field2226, GameClient.field626.field1218, -1297362570);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

               if(var0 == 9) {
                  var11 = class26.method433(OutgoingPacket.field2138, GameClient.field626.field1218, 2050921921);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

               if(var0 == 10) {
                  var11 = class26.method433(OutgoingPacket.field2180, GameClient.field626.field1218, -780609280);
                  var11.field2257.writeInt(var1);
                  var11.field2257.writeShort(var2);
                  var11.field2257.writeShort(var3);
                  GameClient.field626.method1980(var11, (byte)1);
               }

            }
         }
      }
   }
}
