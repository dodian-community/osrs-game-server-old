package client;

import java.io.IOException;

public class class36 {
   static class322 field306;
   static class88 field310;
   static class249 field312;
   static Sprite[] field314;
   static final int field309 = 43;
   static final int field313 = 17;
   public int field307;
   public class226 field311;
   public class226 field308;

   public class36(int var1, class226 var2, class226 var3) {
      this.field307 = var1;
      this.field311 = var2;
      this.field308 = var3;
   }

   public static void method633(class157 var0, boolean var1, int var2) {
      if(class250.field3200 != null) {
         try {
            class250.field3200.vmethod3346(1775992211);
         } catch (Exception var7) {
            ;
         }

         class250.field3200 = null;
      }

      class250.field3200 = var0;
      class222.method4410(var1, 1679554365);
      class250.field3209.field2339 = 0;
      class250.field3208 = null;
      class301.field3713 = null;
      class250.field3210 = 0;

      while(true) {
         class246 var3 = (class246)class250.field3199.method4018();
         if(var3 == null) {
            while(true) {
               var3 = (class246)class250.field3206.method4018();
               if(var3 == null) {
                  if(var2 >= -1725421241) {
                     return;
                  } else {
                     if(class250.field3213 != 0) {
                        try {
                           Stream var8 = new Stream(4);
                           var8.writeByte(4);
                           var8.writeByte(class250.field3213);
                           var8.writeShort(0);
                           class250.field3200.vmethod3347(var8.field2338, 0, 4, (byte)-72);
                        } catch (IOException var6) {
                           try {
                              class250.field3200.vmethod3346(1775992211);
                           } catch (Exception var5) {
                              ;
                           }

                           ++class250.field3215;
                           class250.field3200 = null;
                        }
                     }

                     class250.field3197 = 0;
                     class250.field3203 = Stream.method3547(604838575);
                     return;
                  }
               }

               class250.field3202.method3908(var3);
               class250.field3204.method4016(var3, var3.field2421);
               ++class250.field3205;
               --class250.field3207;
            }
         }

         class250.field3212.method4016(var3, var3.field2421);
         ++class250.field3211;
         --class250.field3198;
      }
   }

   static final void method632(Widget var0, int var1, int var2, int var3) {
      if(GameClient.field810 != 0 && GameClient.field810 != 3) {
         if(var3 == -201841471) {
            ;
         }
      } else {
         if(class48.field431 != 1) {
            if(class253.field3229 || class48.field431 != 4) {
               return;
            }

            if(var3 != -201841471) {
               return;
            }
         }

         class224 var4 = var0.method4517(true, -957474508);
         if(var4 != null) {
            int var5 = class48.field432 - var1;
            int var6 = class48.field428 - var2;
            if(var4.method4423(var5, var6, (byte)1)) {
               var5 -= var4.field2553 / 2;
               var6 -= var4.field2549 / 2;
               int var7 = GameClient.field717 & 2047;
               int var8 = class122.field1681[var7];
               int var9 = class122.field1693[var7];
               int var10 = var6 * var8 + var5 * var9 >> 11;
               int var11 = var9 * var6 - var5 * var8 >> 11;
               int var12 = var10 + class138.field1876.field931 >> 7;
               int var13 = class138.field1876.field881 - var11 >> 7;
               class172 var14 = class26.method433(OutgoingPacket.field2135, GameClient.field626.field1218, 644694866);
               var14.field2257.writeByte(18);
               var14.field2257.writeShort(var12 + class62.baseX);
               PacketBuffer var10000 = var14.field2257;
               int var10001;
               if(class39.field341[82]) {
                  if(var3 != -201841471) {
                     return;
                  }

                  var10001 = class39.field341[81] ? 2 : 1;
               } else {
                  var10001 = 0;
               }

               var10000.writeByteN(var10001);
               var14.field2257.writeShortLE(var13 + GameClient.baseY);
               var14.field2257.writeByte(var5);
               var14.field2257.writeByte(var6);
               var14.field2257.writeShort(GameClient.field717);
               var14.field2257.writeByte(57);
               var14.field2257.writeByte(0);
               var14.field2257.writeByte(0);
               var14.field2257.writeByte(89);
               var14.field2257.writeShort(class138.field1876.field931);
               var14.field2257.writeShort(class138.field1876.field881);
               var14.field2257.writeByte(63);
               GameClient.field626.method1980(var14, (byte)1);
               GameClient.field808 = var12;
               GameClient.field809 = var13;
            }

         }
      }
   }
}
