package client;

public class class51 {
   static final int field464 = 7680;
   int field463 = -1;
   class84 field466;
   int[] field462;
   String[] field465;

   public static class279[] method996(short var0) {
      return new class279[]{class279.field3596, class279.field3580, class279.field3582, class279.field3585, class279.field3593, class279.field3587, class279.field3583, class279.field3595, class279.field3592, class279.field3588, class279.field3586, class279.field3590, class279.field3594, class279.field3589, class279.field3581, class279.field3584};
   }

   static final void method995(String var0, int var1) {
      StringBuilder var10000 = new StringBuilder();
      Object var10001 = null;
      var10000 = var10000.append("Please remove ").append(var0);
      var10001 = null;
      String var2 = var10000.append(" from your ignore list first").toString();
      class143.method3172(30, "", var2);
   }

   static final void method997(int var0, int var1, int var2) {
      if(GameClient.field771 < 2 && GameClient.field733 == 0) {
         if(var2 == 1525650936) {
            return;
         }

         if(!GameClient.field785) {
            return;
         }
      }

      if(GameClient.field728) {
         int var3 = GameClient.field771 - 1;
         String var5;
         if(GameClient.field733 == 1 && GameClient.field771 < 2) {
            var5 = "Use" + " " + GameClient.field734 + " " + "->";
         } else {
            label53: {
               if(GameClient.field785) {
                  if(var2 == 1525650936) {
                     return;
                  }

                  if(GameClient.field771 < 2) {
                     var5 = GameClient.field612 + " " + GameClient.field739 + " " + "->";
                     break label53;
                  }
               }

               var5 = class18.method176(var3, 1298964684);
            }
         }

         if(GameClient.field771 > 2) {
            var5 = var5 + class6.method71(16777215) + " " + '/' + " " + (GameClient.field771 - 2) + " more options";
         }

         class293.field3660.method5530(var5, var0 + 4, var1 + 15, 16777215, 0, GameClient.field591 / 1000);
      }
   }

   static final void method994(boolean instance, PacketBuffer buffer, int var2) {
      GameClient.isInstanceMap = instance;
      int mapX;
      int mapZ;
      int var6;
      int var7;
      int var8;
      int var9;
      if(!GameClient.isInstanceMap) {
         mapX = buffer.readShortA();
         mapZ = buffer.readLEShortA();
         int numMaps = buffer.readUShort();
         class67.field973 = new int[numMaps][4];

         for(var6 = 0; var6 < numMaps; var6++) {
            for(var7 = 0; var7 < 4; var7++) {
               if(var2 == 16777215) {
                  return;
               }

               class67.field973[var6][var7] = buffer.readInt();
            }
         }

         class143.field1900 = new int[numMaps];
         class295.field3676 = new int[numMaps];
         class9.field56 = new int[numMaps];
         class171.field2252 = new byte[numMaps][];
         class29.field253 = new byte[numMaps][];
         boolean var17 = false;
         if((mapX / 8 == 48 || mapX / 8 == 49) && mapZ / 8 == 48) {
            var17 = true;
         }

         if(mapX / 8 == 48 && mapZ / 8 == 148) {
            var17 = true;
         }

         numMaps = 0;

         for(var7 = (mapX - 6) / 8; var7 <= (mapX + 6) / 8; var7++) {
            for(var8 = (mapZ - 6) / 8; var8 <= (mapZ + 6) / 8; var8++) {
               var9 = var8 + (var7 << 8);
               if(var17) {
                  if(var2 == 16777215) {
                     return;
                  }

                  if(var8 == 49 || var8 == 149 || var8 == 147 || var7 == 50 || var7 == 49 && var8 == 47) {
                     continue;
                  }
               }

               class143.field1900[numMaps] = var9;
               class295.field3676[numMaps] = class246.field3159.method4642("m" + var7 + "_" + var8, -1749135217);
               class9.field56[numMaps] = class246.field3159.method4642("l" + var7 + "_" + var8, -1386101203);
               ++numMaps;
            }
         }

         System.out.printf("Map at %d, %d\n", mapX, mapZ);
         class62.method1537(mapX, mapZ, true, -149430841);
      } else {
         mapX = buffer.readUShortLE();
         mapZ = buffer.readUShortLE();
         boolean var16 = buffer.readUByte() == 1;
         var6 = buffer.readUShort();
         buffer.startBitMode();

         int var10;
         for(var7 = 0; var7 < 4; var7++) {
            if(var2 == 16777215) {
               return;
            }

            for(var8 = 0; var8 < 13; var8++) {
               for(var9 = 0; var9 < 13; var9++) {
                  var10 = buffer.readBits(1);
                  if(var10 == 1) {
                     GameClient.field645[var7][var8][var9] = buffer.readBits(26);
                  } else {
                     GameClient.field645[var7][var8][var9] = -1;
                  }
               }
            }
         }

         buffer.endBitMode();
         class67.field973 = new int[var6][4];

         for(var7 = 0; var7 < var6; var7++) {
            for(var8 = 0; var8 < 4; var8++) {
               class67.field973[var7][var8] = buffer.readInt();
            }
         }

         class143.field1900 = new int[var6];
         class295.field3676 = new int[var6];
         class9.field56 = new int[var6];
         class171.field2252 = new byte[var6][];
         class29.field253 = new byte[var6][];
         var6 = 0;

         for(var7 = 0; var7 < 4; var7++) {
            if(var2 == 16777215) {
               return;
            }

            for(var8 = 0; var8 < 13; var8++) {
               for(var9 = 0; var9 < 13; var9++) {
                  var10 = GameClient.field645[var7][var8][var9];
                  if(var10 != -1) {
                     int var11 = var10 >> 14 & 1023;
                     int var12 = var10 >> 3 & 2047;
                     int var13 = (var11 / 8 << 8) + var12 / 8;

                     int var14;
                     for(var14 = 0; var14 < var6; var14++) {
                        if(var2 == 16777215) {
                           return;
                        }

                        if(class143.field1900[var14] == var13) {
                           var13 = -1;
                           break;
                        }
                     }

                     if(var13 != -1) {
                        class143.field1900[var6] = var13;
                        var14 = var13 >> 8 & 255;
                        int var15 = var13 & 255;
                        class295.field3676[var6] = class246.field3159.method4642("m" + var14 + "_" + var15, -144494316);
                        class9.field56[var6] = class246.field3159.method4642("l" + var14 + "_" + var15, 116831135);
                        ++var6;
                     }
                  }
               }
            }
         }

         class62.method1537(mapX, mapZ, !var16, 2006734088);
      }

   }

   public static String method998(String var0, byte var1) {
      int var2 = var0.length();
      char[] var3 = new char[var2];
      byte var4 = 2;

      for(int var5 = 0; var5 < var2; var5++) {
         char var6 = var0.charAt(var5);
         if(var4 == 0) {
            var6 = Character.toLowerCase(var6);
         } else if(var4 == 2 || Character.isUpperCase(var6)) {
            var6 = class291.method5450(var6, (byte)-41);
         }

         if(Character.isLetter(var6)) {
            var4 = 0;
         } else if(var6 != 46 && var6 != 63 && var6 != 33) {
            if(Character.isSpaceChar(var6)) {
               if(var4 != 2) {
                  var4 = 1;
               }
            } else {
               var4 = 1;
            }
         } else {
            var4 = 2;
         }

         var3[var5] = var6;
      }

      return new String(var3);
   }
}
