package client;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class class39 implements KeyListener, FocusListener {
   public static class39 field337 = new class39();
   public static int field329 = 0;
   static int[] field334 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   public static boolean[] field341 = new boolean[112];
   public static int[] field343 = new int[128];
   public static int field344 = 0;
   public static int field351 = 0;
   public static int field350 = 0;
   static char[] field346 = new char[128];
   static int[] field348 = new int[128];
   public static int[] field338 = new int[128];
   public static int field349 = 0;
   public static volatile int field353 = 0;
   public static int field352 = 0;
   public static char field342;
   public static final int field330 = 13;
   static final int field331 = 1;
   public static final int field332 = 49;
   static final int field333 = 6;
   static final int field335 = 10;
   static final int field336 = 7;
   static final int field339 = 53;
   static final int field340 = 102;
   static final int field345 = 40;
   static final int field347 = 23;
   static final int field354 = 2;
   static final int field355 = 1024;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(field337 != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field334.length) {
            var2 = field334[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field329 >= 0 && var2 >= 0) {
            field343[field329] = var2;
            field329 = field329 + 1 & 127;
            if(field344 == field329) {
               field329 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field351 + 1 & 127;
            if(var3 != field350) {
               field348[field351] = var2;
               field346[field351] = 0;
               field351 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(field337 != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field334.length) {
            var2 = field334[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field329 >= 0 && var2 >= 0) {
            field343[field329] = ~var2;
            field329 = field329 + 1 & 127;
            if(field329 == field344) {
               field329 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(field337 != null) {
         field329 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final void keyTyped(KeyEvent var1) {
      if(field337 != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != 65535 && class293.method5496(var2, (byte)-34)) {
            int var3 = field351 + 1 & 127;
            if(var3 != field350) {
               field348[field351] = -1;
               field346[field351] = var2;
               field351 = var3;
            }
         }
      }

      var1.consume();
   }

   static final class197 method691(Stream var0, class197 var1, int var2) {
      int var3 = var0.readUByte();
      int var4;
      if(var1 == null) {
         var4 = class146.method3193(var3, (byte)-64);
         var1 = new class197(var4);
      }

      for(var4 = 0; var4 < var3; var4++) {
         boolean var5 = var0.readUByte() == 1;
         int var6 = var0.readMedium();
         Object var7;
         if(var5) {
            var7 = new class195(var0.readString());
         } else {
            var7 = new class211(var0.readInt());
         }

         var1.method3944((class204)var7, (long)var6);
      }

      return var1;
   }

   static final void method692(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7, byte var8) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      class172 var9;
      if(var2 == 31) {
         var9 = class26.method433(OutgoingPacket.field2196, GameClient.field626.field1218, 1273785885);
         var9.field2257.writeIntLE(class187.field2372);
         var9.field2257.writeShortLE(var0);
         var9.field2257.writeShortLE(class297.field3683);
         var9.field2257.writeIntV2(var1);
         var9.field2257.writeShort(class13.field84);
         var9.field2257.writeShortLE(var3);
         GameClient.field626.method1980(var9, (byte)1);
         GameClient.field686 = 0;
         class240.field3096 = Widget.getLoaded(var1);
         GameClient.field582 = var0;
      }

      class172 var10;
      Npc var14;
      if(var2 == 8) {
         if(var8 <= 1) {
            return;
         }

         var14 = GameClient.field843[var3];
         if(var14 != null) {
            if(var8 <= 1) {
               return;
            }

            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var10 = class26.method433(OutgoingPacket.field2204, GameClient.field626.field1218, -145677120);
            var10.field2257.writeInt(class40.field361);
            var10.field2257.writeShortA(GameClient.field736);
            var10.field2257.writeShortLE(var3);
            var10.field2257.writeByte(field341[82] ? 1 : 0);
            GameClient.field626.method1980(var10, (byte)1);
         }
      }

      Player var15;
      if(var2 == 51) {
         var15 = GameClient.field610[var3];
         if(var15 != null) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var10 = class26.method433(OutgoingPacket.field2178, GameClient.field626.field1218, -331317774);
            var10.field2257.writeLEShortA(var3);
            var10.field2257.writeByteN(field341[82] ? 1 : 0);
            GameClient.field626.method1980(var10, (byte)1);
         }
      }

      if(var2 == 36) {
         var9 = class26.method433(OutgoingPacket.field2191, GameClient.field626.field1218, -1019084502);
         var9.field2257.writeLEShortA(var3);
         var9.field2257.writeShortA(var0);
         var9.field2257.writeIntV1(var1);
         GameClient.field626.method1980(var9, (byte)1);
         GameClient.field686 = 0;
         class240.field3096 = Widget.getLoaded(var1);
         GameClient.field582 = var0;
      }

      Widget var17;
      if(var2 == 38) {
         class34.method585(995963221);
         var17 = Widget.getLoaded(var1);
         GameClient.field733 = 1;
         class13.field84 = var0;
         class187.field2372 = var1;
         class297.field3683 = var3;
         GameClient.requestRedraw(var17);
         GameClient.field734 = class6.method71(16748608) + ItemDef.loadItemDef(var3).name + class6.method71(16777215);
         if(GameClient.field734 == null) {
            if(var8 <= 1) {
               return;
            }

            GameClient.field734 = "null";
         }

      } else {
         if(var2 == 44) {
            if(var8 <= 1) {
               return;
            }

            var15 = GameClient.field610[var3];
            if(var15 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2206, GameClient.field626.field1218, 1672307737);
               var10.field2257.writeByte(field341[82] ? 1 : 0);
               var10.field2257.writeShort(var3);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 42) {
            var9 = class26.method433(OutgoingPacket.field2200, GameClient.field626.field1218, 1719147012);
            var9.field2257.writeLEShortA(var3);
            var9.field2257.writeIntV2(var1);
            var9.field2257.writeShort(var0);
            GameClient.field626.method1980(var9, (byte)1);
            GameClient.field686 = 0;
            class240.field3096 = Widget.getLoaded(var1);
            GameClient.field582 = var0;
         }

         if(var2 == 20) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2161, GameClient.field626.field1218, -415091868);
            var9.field2257.writeShort(var0 + class62.baseX);
            var9.field2257.writeShortA(var3);
            var9.field2257.writeShortLE(GameClient.baseY + var1);
            var9.field2257.writeByteN(field341[82] ? 1 : 0);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 1004) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            var9 = class26.method433(OutgoingPacket.field2182, GameClient.field626.field1218, 854321838);
            var9.field2257.writeShortA(var3);
            GameClient.field626.method1980(var9, (byte)1);
         }

         label1015: {
            if(var2 != 1008) {
               if(var8 <= 1) {
                  return;
               }

               if(var2 != 1009) {
                  if(var8 <= 1) {
                     return;
                  }

                  if(var2 != 1010) {
                     if(var8 <= 1) {
                        return;
                     }

                     if(var2 != 1011 && var2 != 1012) {
                        break label1015;
                     }
                  }
               }
            }

            class53.field476.method6008(var2, var3, new class226(var0), new class226(var1), (byte)14);
         }

         if(var2 == 26) {
            var9 = class26.method433(OutgoingPacket.field2195, GameClient.field626.field1218, 735152931);
            GameClient.field626.method1980(var9, (byte)1);

            for(class55 var16 = (class55) GameClient.field741.method4018(); var16 != null; var16 = (class55) GameClient.field741.method4019()) {
               if(var16.field494 == 0 || var16.field494 == 3) {
                  class20.method261(var16, true, 1449461438);
               }
            }

            if(GameClient.field744 != null) {
               if(var8 <= 1) {
                  return;
               }

               GameClient.requestRedraw(GameClient.field744);
               GameClient.field744 = null;
            }
         }

         if(var2 == 14) {
            var15 = GameClient.field610[var3];
            if(var15 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2189, GameClient.field626.field1218, -25247773);
               var10.field2257.writeLEShortA(class13.field84);
               var10.field2257.writeShortLE(class297.field3683);
               var10.field2257.writeIntV1(class187.field2372);
               var10.field2257.writeByteS(field341[82] ? 1 : 0);
               var10.field2257.writeShort(var3);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 39) {
            var9 = class26.method433(OutgoingPacket.field2171, GameClient.field626.field1218, -1402230494);
            var9.field2257.writeIntV2(var1);
            var9.field2257.writeShortA(var3);
            var9.field2257.writeLEShortA(var0);
            GameClient.field626.method1980(var9, (byte)1);
            GameClient.field686 = 0;
            class240.field3096 = Widget.getLoaded(var1);
            GameClient.field582 = var0;
         }

         if(var2 == 43) {
            var9 = class26.method433(OutgoingPacket.field2140, GameClient.field626.field1218, 1740675046);
            var9.field2257.writeShortA(var3);
            var9.field2257.writeInt(var1);
            var9.field2257.writeShortLE(var0);
            GameClient.field626.method1980(var9, (byte)1);
            GameClient.field686 = 0;
            class240.field3096 = Widget.getLoaded(var1);
            GameClient.field582 = var0;
         }

         class172 var11;
         if(var2 == 24) {
            var17 = Widget.getLoaded(var1);
            boolean var12 = true;
            if(var17.interactType > 0) {
               if(var8 <= 1) {
                  return;
               }

               var12 = class25.method426(var17, 2065048163);
            }

            if(var12) {
               var11 = class26.method433(OutgoingPacket.field2230, GameClient.field626.field1218, 1245280501);
               var11.field2257.writeInt(var1);
               GameClient.field626.method1980(var11, (byte)1);
            }
         }

         PacketBuffer var10000;
         byte var10001;
         if(var2 == 13) {
            var14 = GameClient.field843[var3];
            if(var14 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2208, GameClient.field626.field1218, 2019097486);
               var10.field2257.writeShortA(var3);
               var10000 = var10.field2257;
               if(field341[82]) {
                  if(var8 <= 1) {
                     return;
                  }

                  var10001 = 1;
               } else {
                  var10001 = 0;
               }

               var10000.writeByteN(var10001);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 11) {
            if(var8 <= 1) {
               return;
            }

            var14 = GameClient.field843[var3];
            if(var14 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2198, GameClient.field626.field1218, -1118578544);
               var10.field2257.writeByteA(field341[82] ? 1 : 0);
               var10.field2257.writeLEShortA(var3);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 48) {
            var15 = GameClient.field610[var3];
            if(var15 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2217, GameClient.field626.field1218, -1008430450);
               var10.field2257.writeByteS(field341[82] ? 1 : 0);
               var10.field2257.writeLEShortA(var3);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 1001) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2139, GameClient.field626.field1218, 53575193);
            var9.field2257.writeShortLE(GameClient.baseY + var1);
            var9.field2257.writeLEShortA(var3);
            var9.field2257.writeShortA(var0 + class62.baseX);
            var9.field2257.writeByte(field341[82] ? 1 : 0);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 15) {
            var15 = GameClient.field610[var3];
            if(var15 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2212, GameClient.field626.field1218, -998293543);
               var10.field2257.writeIntLE(class40.field361);
               var10.field2257.writeShortLE(var3);
               var10.field2257.writeShortA(GameClient.field736);
               var10.field2257.writeByteA(field341[82] ? 1 : 0);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 57 || var2 == 1007) {
            var17 = class146.method3191(var1, var0, -1708513832);
            if(var17 != null) {
               class45.method747(var3, var1, var0, var17.itemId, var5, (byte)66);
            }
         }

         if(var2 == 45) {
            var15 = GameClient.field610[var3];
            if(var15 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2181, GameClient.field626.field1218, -257532310);
               var10.field2257.writeByteS(field341[82] ? 1 : 0);
               var10.field2257.writeShort(var3);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 18) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2210, GameClient.field626.field1218, -1455702423);
            var9.field2257.writeLEShortA(GameClient.baseY + var1);
            var9.field2257.writeByteN(field341[82] ? 1 : 0);
            var9.field2257.writeShortA(var0 + class62.baseX);
            var9.field2257.writeShort(var3);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 58) {
            if(var8 <= 1) {
               return;
            }

            var17 = class146.method3191(var1, var0, -1439219128);
            if(var17 != null) {
               var10 = class26.method433(OutgoingPacket.field2159, GameClient.field626.field1218, -295636173);
               var10.field2257.writeIntV1(class40.field361);
               var10.field2257.writeLEShortA(GameClient.field737);
               var10.field2257.writeIntV1(var1);
               var10.field2257.writeShortLE(var17.itemId);
               var10.field2257.writeShort(var0);
               var10.field2257.writeShort(GameClient.field736);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 47) {
            var15 = GameClient.field610[var3];
            if(var15 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2220, GameClient.field626.field1218, 893432680);
               var10.field2257.writeLEShortA(var3);
               var10.field2257.writeByte(field341[82] ? 1 : 0);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 3) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2186, GameClient.field626.field1218, 668699125);
            var9.field2257.writeShort(GameClient.baseY + var1);
            var9.field2257.writeShortA(var0 + class62.baseX);
            var9.field2257.writeShort(var3);
            var10000 = var9.field2257;
            if(field341[82]) {
               if(var8 <= 1) {
                  return;
               }

               var10001 = 1;
            } else {
               var10001 = 0;
            }

            var10000.writeByte(var10001);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 1) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2199, GameClient.field626.field1218, -558722148);
            var9.field2257.writeLEShortA(class297.field3683);
            var10000 = var9.field2257;
            if(field341[82]) {
               if(var8 <= 1) {
                  return;
               }

               var10001 = 1;
            } else {
               var10001 = 0;
            }

            var10000.writeByte(var10001);
            var9.field2257.writeIntV1(class187.field2372);
            var9.field2257.writeShortLE(var0 + class62.baseX);
            var9.field2257.writeShort(GameClient.baseY + var1);
            var9.field2257.writeShortA(var3);
            var9.field2257.writeShort(class13.field84);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 22) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2147, GameClient.field626.field1218, -184629718);
            var9.field2257.writeShortLE(var3);
            var9.field2257.writeShortLE(var0 + class62.baseX);
            var9.field2257.writeShort(GameClient.baseY + var1);
            var9.field2257.writeByteS(field341[82] ? 1 : 0);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 19) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2214, GameClient.field626.field1218, -869794406);
            var9.field2257.writeShortLE(var3);
            var9.field2257.writeShortA(var0 + class62.baseX);
            var9.field2257.writeShortLE(GameClient.baseY + var1);
            var9.field2257.writeByteS(field341[82] ? 1 : 0);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 1005) {
            if(var8 <= 1) {
               return;
            }

            var17 = Widget.getLoaded(var1);
            if(var17 != null && var17.field2725[var0] >= 100000) {
               class143.method3172(27, "", var17.field2725[var0] + " x " + ItemDef.loadItemDef(var3).name);
            } else {
               var10 = class26.method433(OutgoingPacket.field2182, GameClient.field626.field1218, 1494320101);
               var10.field2257.writeShortA(var3);
               GameClient.field626.method1980(var10, (byte)1);
            }

            GameClient.field686 = 0;
            class240.field3096 = Widget.getLoaded(var1);
            GameClient.field582 = var0;
         }

         if(var2 == 9) {
            var14 = GameClient.field843[var3];
            if(var14 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2207, GameClient.field626.field1218, -787977119);
               var10.field2257.writeShortA(var3);
               var10.field2257.writeByteN(field341[82] ? 1 : 0);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 2) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2172, GameClient.field626.field1218, -134760984);
            var9.field2257.writeByte(field341[82] ? 1 : 0);
            var9.field2257.writeIntV2(class40.field361);
            var9.field2257.writeLEShortA(GameClient.baseY + var1);
            var9.field2257.writeLEShortA(GameClient.field736);
            var9.field2257.writeShortA(var0 + class62.baseX);
            var9.field2257.writeLEShortA(var3);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 46) {
            if(var8 <= 1) {
               return;
            }

            var15 = GameClient.field610[var3];
            if(var15 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2137, GameClient.field626.field1218, 1280683884);
               var10.field2257.writeByteA(field341[82] ? 1 : 0);
               var10.field2257.writeShortA(var3);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 50) {
            var15 = GameClient.field610[var3];
            if(var15 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2222, GameClient.field626.field1218, 1011374637);
               var10.field2257.writeShortLE(var3);
               var10.field2257.writeByteA(field341[82] ? 1 : 0);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 30 && GameClient.field744 == null) {
            class82.method1921(var1, var0, (byte)-3);
            GameClient.field744 = class146.method3191(var1, var0, -1875928825);
            GameClient.requestRedraw(GameClient.field744);
         }

         if(var2 == 23) {
            if(GameClient.field716) {
               if(var8 <= 1) {
                  return;
               }

               class28.field248.method2974();
            } else {
               class28.field248.method2909(class13.field82, var0, var1, true);
            }
         }

         int var13;
         Widget var18;
         if(var2 == 29) {
            var9 = class26.method433(OutgoingPacket.field2230, GameClient.field626.field1218, 276721816);
            var9.field2257.writeInt(var1);
            GameClient.field626.method1980(var9, (byte)1);
            var18 = Widget.getLoaded(var1);
            if(var18.field2659 != null && var18.field2659[0][0] == 5) {
               var13 = var18.field2659[0][1];
               if(class225.field2558[var13] != var18.field2720[0]) {
                  if(var8 <= 1) {
                     return;
                  }

                  class225.field2558[var13] = var18.field2720[0];
                  GameClient.updateForSetting(var13);
               }
            }
         }

         if(var2 == 35) {
            var9 = class26.method433(OutgoingPacket.field2166, GameClient.field626.field1218, 632516859);
            var9.field2257.writeShortLE(var0);
            var9.field2257.writeIntV1(var1);
            var9.field2257.writeShortLE(var3);
            GameClient.field626.method1980(var9, (byte)1);
            GameClient.field686 = 0;
            class240.field3096 = Widget.getLoaded(var1);
            GameClient.field582 = var0;
         }

         if(var2 == 16) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2234, GameClient.field626.field1218, 1794086888);
            var9.field2257.writeLEShortA(var3);
            var9.field2257.writeByte(field341[82] ? 1 : 0);
            var9.field2257.writeShortA(class297.field3683);
            var9.field2257.writeShortA(var0 + class62.baseX);
            var9.field2257.writeShort(GameClient.baseY + var1);
            var9.field2257.writeInt(class187.field2372);
            var9.field2257.writeShort(class13.field84);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 1003) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            var14 = GameClient.field843[var3];
            if(var14 != null) {
               if(var8 <= 1) {
                  return;
               }

               NpcDef var19 = var14.definition;
               if(var19.intArray106 != null) {
                  var19 = var19.method5189(206634196);
               }

               if(var19 != null) {
                  if(var8 <= 1) {
                     return;
                  }

                  var11 = class26.method433(OutgoingPacket.field2146, GameClient.field626.field1218, 680946872);
                  var11.field2257.writeShortLE(var19.field3510);
                  GameClient.field626.method1980(var11, (byte)1);
               }
            }
         }

         if(var2 == 6) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2232, GameClient.field626.field1218, -1314345255);
            var9.field2257.writeShortA(var3);
            var9.field2257.writeByteN(field341[82] ? 1 : 0);
            var9.field2257.writeLEShortA(var0 + class62.baseX);
            var9.field2257.writeShortLE(GameClient.baseY + var1);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 12) {
            var14 = GameClient.field843[var3];
            if(var14 != null) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var10 = class26.method433(OutgoingPacket.field2229, GameClient.field626.field1218, -988914743);
               var10.field2257.writeByteA(field341[82] ? 1 : 0);
               var10.field2257.writeShortLE(var3);
               GameClient.field626.method1980(var10, (byte)1);
            }
         }

         if(var2 == 17) {
            GameClient.field681 = var6;
            GameClient.field682 = var7;
            GameClient.field684 = 2;
            GameClient.field803 = 0;
            GameClient.field808 = var0;
            GameClient.field809 = var1;
            var9 = class26.method433(OutgoingPacket.field2143, GameClient.field626.field1218, -793121181);
            var9.field2257.writeShortA(var3);
            var9.field2257.writeShortLE(var0 + class62.baseX);
            var9.field2257.writeShortA(GameClient.field736);
            var9.field2257.writeLEShortA(GameClient.baseY + var1);
            var9.field2257.writeIntV1(class40.field361);
            var9.field2257.writeByte(field341[82] ? 1 : 0);
            GameClient.field626.method1980(var9, (byte)1);
         }

         if(var2 == 25) {
            var17 = class146.method3191(var1, var0, -1454794015);
            if(var17 != null) {
               class34.method585(995963221);
               class155.method3275(var1, var0, class154.method3252(class24.method425(var17, (byte)-50), (byte)-19), var17.itemId, -927006489);
               GameClient.field733 = 0;
               GameClient.field612 = class151.method3239(var17, -1847169886);
               if(GameClient.field612 == null) {
                  GameClient.field612 = "Null";
               }

               if(var17.decodeCs2) {
                  GameClient.field739 = var17.string29 + class6.method71(16777215);
               } else {
                  GameClient.field739 = class6.method71(65280) + var17.field2722 + class6.method71(16777215);
               }
            }

         } else {
            if(var2 == 33) {
               var9 = class26.method433(OutgoingPacket.field2175, GameClient.field626.field1218, 817387714);
               var9.field2257.writeLEShortA(var0);
               var9.field2257.writeShortA(var3);
               var9.field2257.writeInt(var1);
               GameClient.field626.method1980(var9, (byte)1);
               GameClient.field686 = 0;
               class240.field3096 = Widget.getLoaded(var1);
               GameClient.field582 = var0;
            }

            if(var2 == 37) {
               if(var8 <= 1) {
                  return;
               }

               var9 = class26.method433(OutgoingPacket.field2197, GameClient.field626.field1218, -184402781);
               var9.field2257.writeIntV1(var1);
               var9.field2257.writeShortLE(var0);
               var9.field2257.writeShortA(var3);
               GameClient.field626.method1980(var9, (byte)1);
               GameClient.field686 = 0;
               class240.field3096 = Widget.getLoaded(var1);
               GameClient.field582 = var0;
            }

            if(var2 == 40) {
               var9 = class26.method433(OutgoingPacket.field2151, GameClient.field626.field1218, 446950036);
               var9.field2257.writeInt(var1);
               var9.field2257.writeShortLE(var3);
               var9.field2257.writeShortLE(var0);
               GameClient.field626.method1980(var9, (byte)1);
               GameClient.field686 = 0;
               class240.field3096 = Widget.getLoaded(var1);
               GameClient.field582 = var0;
            }

            if(var2 == 34) {
               var9 = class26.method433(OutgoingPacket.field2193, GameClient.field626.field1218, -828844836);
               var9.field2257.writeShort(var0);
               var9.field2257.writeShortLE(var3);
               var9.field2257.writeIntLE(var1);
               GameClient.field626.method1980(var9, (byte)1);
               GameClient.field686 = 0;
               class240.field3096 = Widget.getLoaded(var1);
               GameClient.field582 = var0;
            }

            if(var2 == 21) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var9 = class26.method433(OutgoingPacket.field2205, GameClient.field626.field1218, -99763418);
               var9.field2257.writeShortA(GameClient.baseY + var1);
               var9.field2257.writeShortA(var3);
               var9.field2257.writeShortLE(var0 + class62.baseX);
               var10000 = var9.field2257;
               if(field341[82]) {
                  if(var8 <= 1) {
                     return;
                  }

                  var10001 = 1;
               } else {
                  var10001 = 0;
               }

               var10000.writeByteA(var10001);
               GameClient.field626.method1980(var9, (byte)1);
            }

            if(var2 == 10) {
               var14 = GameClient.field843[var3];
               if(var14 != null) {
                  GameClient.field681 = var6;
                  GameClient.field682 = var7;
                  GameClient.field684 = 2;
                  GameClient.field803 = 0;
                  GameClient.field808 = var0;
                  GameClient.field809 = var1;
                  var10 = class26.method433(OutgoingPacket.field2223, GameClient.field626.field1218, -246168845);
                  var10.field2257.writeLEShortA(var3);
                  var10.field2257.writeByteS(field341[82] ? 1 : 0);
                  GameClient.field626.method1980(var10, (byte)1);
               }
            }

            if(var2 == 4) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var9 = class26.method433(OutgoingPacket.field2169, GameClient.field626.field1218, 1662513582);
               var9.field2257.writeShortLE(var0 + class62.baseX);
               var9.field2257.writeShort(GameClient.baseY + var1);
               var10000 = var9.field2257;
               if(field341[82]) {
                  if(var8 <= 1) {
                     return;
                  }

                  var10001 = 1;
               } else {
                  var10001 = 0;
               }

               var10000.writeByteA(var10001);
               var9.field2257.writeLEShortA(var3);
               GameClient.field626.method1980(var9, (byte)1);
            }

            if(var2 == 41) {
               var9 = class26.method433(OutgoingPacket.field2202, GameClient.field626.field1218, -147374426);
               var9.field2257.writeShortLE(var3);
               var9.field2257.writeShortLE(var0);
               var9.field2257.writeIntLE(var1);
               GameClient.field626.method1980(var9, (byte)1);
               GameClient.field686 = 0;
               class240.field3096 = Widget.getLoaded(var1);
               GameClient.field582 = var0;
            }

            if(var2 == 49) {
               var15 = GameClient.field610[var3];
               if(var15 != null) {
                  GameClient.field681 = var6;
                  GameClient.field682 = var7;
                  GameClient.field684 = 2;
                  GameClient.field803 = 0;
                  GameClient.field808 = var0;
                  GameClient.field809 = var1;
                  var10 = class26.method433(OutgoingPacket.field2163, GameClient.field626.field1218, -1117139340);
                  var10000 = var10.field2257;
                  if(field341[82]) {
                     if(var8 <= 1) {
                        return;
                     }

                     var10001 = 1;
                  } else {
                     var10001 = 0;
                  }

                  var10000.writeByteN(var10001);
                  var10.field2257.writeLEShortA(var3);
                  GameClient.field626.method1980(var10, (byte)1);
               }
            }

            if(var2 == 7) {
               var14 = GameClient.field843[var3];
               if(var14 != null) {
                  if(var8 <= 1) {
                     return;
                  }

                  GameClient.field681 = var6;
                  GameClient.field682 = var7;
                  GameClient.field684 = 2;
                  GameClient.field803 = 0;
                  GameClient.field808 = var0;
                  GameClient.field809 = var1;
                  var10 = class26.method433(OutgoingPacket.field2184, GameClient.field626.field1218, -992126928);
                  var10.field2257.writeShort(class13.field84);
                  var10000 = var10.field2257;
                  if(field341[82]) {
                     if(var8 <= 1) {
                        return;
                     }

                     var10001 = 1;
                  } else {
                     var10001 = 0;
                  }

                  var10000.writeByteS(var10001);
                  var10.field2257.writeShortLE(var3);
                  var10.field2257.writeShortA(class297.field3683);
                  var10.field2257.writeIntV2(class187.field2372);
                  GameClient.field626.method1980(var10, (byte)1);
               }
            }

            if(var2 == 28) {
               var9 = class26.method433(OutgoingPacket.field2230, GameClient.field626.field1218, -216475713);
               var9.field2257.writeInt(var1);
               GameClient.field626.method1980(var9, (byte)1);
               var18 = Widget.getLoaded(var1);
               if(var18.field2659 != null && var18.field2659[0][0] == 5) {
                  var13 = var18.field2659[0][1];
                  class225.field2558[var13] = 1 - class225.field2558[var13];
                  GameClient.updateForSetting(var13);
               }
            }

            if(var2 == 1002) {
               if(var8 <= 1) {
                  return;
               }

               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               var9 = class26.method433(OutgoingPacket.field2162, GameClient.field626.field1218, -911590338);
               var9.field2257.writeShort(var3);
               GameClient.field626.method1980(var9, (byte)1);
            }

            if(var2 == 32) {
               var9 = class26.method433(OutgoingPacket.field2165, GameClient.field626.field1218, 1365645399);
               var9.field2257.writeIntV1(class40.field361);
               var9.field2257.writeShort(GameClient.field736);
               var9.field2257.writeIntV2(var1);
               var9.field2257.writeLEShortA(var0);
               var9.field2257.writeShortA(var3);
               GameClient.field626.method1980(var9, (byte)1);
               GameClient.field686 = 0;
               class240.field3096 = Widget.getLoaded(var1);
               GameClient.field582 = var0;
            }

            if(var2 == 5) {
               GameClient.field681 = var6;
               GameClient.field682 = var7;
               GameClient.field684 = 2;
               GameClient.field803 = 0;
               GameClient.field808 = var0;
               GameClient.field809 = var1;
               var9 = class26.method433(OutgoingPacket.field2216, GameClient.field626.field1218, -739755069);
               var9.field2257.writeLEShortA(GameClient.baseY + var1);
               var9.field2257.writeLEShortA(var0 + class62.baseX);
               var9.field2257.writeLEShortA(var3);
               var9.field2257.writeByteN(field341[82] ? 1 : 0);
               GameClient.field626.method1980(var9, (byte)1);
            }

            if(GameClient.field733 != 0) {
               if(var8 <= 1) {
                  return;
               }

               GameClient.field733 = 0;
               GameClient.requestRedraw(Widget.getLoaded(class187.field2372));
            }

            if(GameClient.field785) {
               class34.method585(995963221);
            }

            if(class240.field3096 != null) {
               if(var8 <= 1) {
                  return;
               }

               if(GameClient.field686 == 0) {
                  GameClient.requestRedraw(class240.field3096);
               }
            }

         }
      }
   }

   public static int method673(long var0) {
      return (int)(var0 >>> 17 & 4294967295L);
   }
}
