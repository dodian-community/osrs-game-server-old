package client;

public class class216 {
   public static final int field2455 = 200;
   static final int field2456 = 8;
   int field2452;
   int field2448;
   int field2453;
   byte[] field2447;
   int field2454;
   int field2451;
   byte[] field2449;
   int field2450;
   int field2446;

   static final void decodePlayerMasks(PacketBuffer buffer, int var1) {
      int var3 = buffer.field2339;
      class81.field1165 = 0;
      class177.method3512(buffer, -2137286029);

      for(int var4 = 0; var4 < class81.field1165; var4++) {
         int var5 = class81.field1166[var4];
         Player player = GameClient.field610[var5];

         int mask = buffer.readUByte();
         if((mask & 0x80) != 0) {
            mask += buffer.readUByte() << 8;
         }

         byte teleportMode = -1;
         if((mask & 0x200) != 0) { // Teleport mode
            teleportMode = buffer.readByteS();
         }

         if((mask & 0x8) != 0) { // Shout
            player.field884 = buffer.readString();
            if(player.field884.charAt(0) == 126) {
               player.field884 = player.field884.substring(1);
               class143.method3172(2, player.field552.method5447((byte)30), player.field884);
            } else if(player == class138.field1876) {

               class143.method3172(2, player.field552.method5447((byte)37), player.field884);
            }

            player.field885 = false;
            player.field888 = 0;
            player.field927 = 0;
            player.field887 = 150;
         }

         int var9;
         if((mask & 0x800) != 0) { // Graphic
            player.field891 = buffer.readLEShortA();
            var9 = buffer.readIntLE();
            player.field871 = var9 >> 16;
            player.field911 = (var9 & 65535) + GameClient.field591;
            player.field876 = 0;
            player.field910 = 0;
            if(player.field911 > GameClient.field591) {
               player.field876 = -1;
            }

            if(player.field891 == 65535) {

               player.field891 = -1;
            }
         }

         if((mask & 0x400) != 0) { // Prefix and suffix
            for(var9 = 0; var9 < 3; var9++) {
               player.field550[var9] = buffer.readString();
            }
         }

         int var10;
         if((mask & 0x20) != 0) { // Animation

            var9 = buffer.readLEShortA();
            if(var9 == 65535) {
               var9 = -1;
            }

            var10 = buffer.readUByteA();
            class134.method3102(player, var9, var10, -1928445443);
         }

         int var12;
         int var13;
         if((mask & 0x40) != 0) { // Public chat
            var9 = buffer.readUShortLE();
            Icon var22 = (Icon)class76.method1803(class20.getIcons(), buffer.readUByteA(), (byte)0);
            boolean var11 = buffer.readUByteN() == 1;
            var12 = buffer.readUByte();
            var13 = buffer.field2339;
            if(player.field552 != null && player.field546 != null) {
               boolean var14 = false;
               if(var22.field3127 && class181.field2332.method1630(player.field552, 750672366)) {
                  var14 = true;
               }

               if(!var14) {

                  if(GameClient.field694 == 0 && !player.hidden) {
                     class81.field1154.field2339 = 0;
                     buffer.method3539(class81.field1154.field2338, 0, var12);
                     class81.field1154.field2339 = 0;
                     Stream var16 = class81.field1154;

                     String var17;
                     int var18;
                     String var20;
                     try {
                        var18 = var16.readCompact();
                        if(var18 > 32767) {

                           var18 = 32767;
                        }

                        byte[] var19 = new byte[var18];
                        var16.field2339 += class300.field3712.method3480(var16.field2338, var16.field2339, var19, 0, var18, 689887723);
                        var20 = class78.method1831(var19, 0, var18, -1511842789);
                        var17 = var20;
                     } catch (Exception var28) {
                        var17 = "Cabbage";
                     }

                     boolean var10001;
                     label273: {
                        var17 = class299.method5521(class51.method998(var17, (byte)1));
                        player.field884 = var17.trim();
                        player.field888 = var9 >> 8;
                        player.field927 = var9 & 255;
                        player.field887 = 150;
                        player.field885 = var11;
                        if(player != class138.field1876 && var22.field3127 && "" != GameClient.field796) {

                           if(var17.toLowerCase().indexOf(GameClient.field796) == -1) {
                              var10001 = true;
                              break label273;
                           }
                        }

                        var10001 = false;
                     }

                     player.field886 = var10001;
                     if(var22.field3126) {

                        var18 = var11 ? 91 : 1;
                     } else {
                        var18 = var11 ? 90 : 2;
                     }

                     if(var22.field3128 != -1) {
                        int var21 = var22.field3128;
                        var20 = "<img=" + var21 + ">";
                        class143.method3172(var18, var20 + player.field552.method5447((byte)31), var17);
                     } else {
                        class143.method3172(var18, player.field552.method5447((byte)46), var17);
                     }
                  }
               }
            }

            buffer.field2339 = var12 + var13;
         }

         if((mask & 0x1000) != 0) { // Movement mode
            class81.field1153[var5] = buffer.readByteS();
         }

         if((mask & 1) != 0) { // Hits
            var9 = buffer.readUByteA();
            int var25;
            int var29;
            int var31;
            if(var9 > 0) {
               for(var10 = 0; var10 < var9; var10++) {
                  var12 = -1;
                  var13 = -1;
                  var31 = -1;
                  var29 = buffer.readCompact();
                  if(var29 == 32767) {
                     var29 = buffer.readCompact();
                     var13 = buffer.readCompact();
                     var12 = buffer.readCompact();
                     var31 = buffer.readCompact();
                  } else if(var29 != 32766) {
                     var13 = buffer.readCompact();
                  } else {
                     var29 = -1;
                  }

                  var25 = buffer.readCompact();
                  player.method1542(var29, var13, var12, var31, GameClient.field591, var25, (byte)77);
               }
            }

            var10 = buffer.readUByte();
            if(var10 > 0) {
               for(var29 = 0; var29 < var10; var29++) {
                  var12 = buffer.readCompact();
                  var13 = buffer.readCompact();
                  if(var13 != 32767) {
                     var31 = buffer.readCompact();
                     var25 = buffer.readUByteA();
                     int var26 = var13 > 0 ? buffer.readUByteN() : var25;
                     player.method1543(var12, GameClient.field591, var13, var31, var25, var26, -872169209);
                  } else {
                     player.method1557(var12, 631506734);
                  }
               }
            }
         }

         if((mask & 0x100) != 0) { // Force movement
            player.field913 = buffer.readByteA();
            player.field915 = buffer.readByteS();
            player.field916 = buffer.readByteA();
            player.field929 = buffer.readByteS();
            player.field917 = buffer.readUShort() + GameClient.field591;
            player.field918 = buffer.readLEShortA() + GameClient.field591;
            player.field919 = buffer.readLEShortA();
            if(player.field571) {
               player.field913 += player.field572;
               player.field915 += player.field573;
               player.field916 += player.field572;
               player.field929 += player.field573;
               player.field909 = 0;
            } else {
               player.field913 += player.field922[0];
               player.field915 += player.field872[0];
               player.field916 += player.field922[0];
               player.field929 += player.field872[0];
               player.field909 = 1;
            }

            player.field930 = 0;
         }

         if((mask & 0x10) != 0) { // Face entity
            player.field897 = buffer.readUShortLE();
            if(player.field897 == 65535) {

               player.field897 = -1;
            }
         }

         if((mask & 0x4) != 0) { // Looks
            var9 = buffer.readUByteA();
            byte[] var32 = new byte[var9];
            Stream var27 = new Stream(var32);
            buffer.method3539(var32, 0, var9);
            class81.field1157[var5] = var27;
            player.decodeLooks(var27, -1889365760);
         }

         if((mask & 0x2) != 0) { // Face tile
            player.field920 = buffer.readUShort();
            if(player.field909 == 0) {
               player.field926 = player.field920;
               player.field920 = -1;
            }
         }

         if(player.field571) {
            if(teleportMode == 127) {
               player.method1103(player.field572, player.field573, -2124327900);
            } else {
               byte var30;
               if(teleportMode != -1) {
                  var30 = teleportMode;
               } else {
                  var30 = class81.field1153[var5];
               }

               player.method1106(player.field572, player.field573, var30, -1440413395);
            }
         }
      }

      if(buffer.field2339 - var3 != var1) {
         throw new RuntimeException(buffer.field2339 - var3 + " " + var1);
      }
   }

   static final void method4178(int var0, int var1) {
      if(class261.method4931(var0, (byte)-29)) {
         Widget[] var2 = Widget.LOADED[var0];

         for(int var3 = 0; var3 < var2.length; var3++) {
            Widget var4 = var2[var3];
            if(var4 != null) {
               var4.field2728 = 0;
               var4.field2613 = 0;
            }
         }

      }
   }
}
