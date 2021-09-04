package client;

import java.io.IOException;

public class class87 {
   static final int field1221 = 49;
   class157 field1214;
   class203 field1223 = new class203();
   PacketBuffer field1219 = new PacketBuffer(40000);
   int field1216 = 0;
   Stream field1217 = new Stream(5000);
   IncomingPacket packetType = null;
   boolean field1222 = true;
   int field1225 = 0;
   IncomingPacket field1226;
   IncomingPacket field1227;
   public Isaac field1218;
   int field1228 = 0;
   int field1224 = 0;
   IncomingPacket field1215;

   class157 method1983(int var1) {
      return this.field1214;
   }

   void method1982(short var1) {
      if(this.field1214 != null) {
         this.field1214.vmethod3346(1775992211);
         this.field1214 = null;
      }

   }

   final void method1978(byte var1) {
      this.field1223.method4030();
      this.field1216 = 0;
   }

   void method1984(byte var1) {
      this.field1214 = null;
   }

   public final void method1980(class172 var1) {
      this.field1223.method4031(var1);
      var1.field2255 = var1.field2257.field2339;
      var1.field2257.field2339 = 0;
      this.field1216 += var1.field2255;
   }

   final void method1979(byte var1) throws IOException {
      if(this.field1214 != null && this.field1216 > 0) {
         this.field1217.field2339 = 0;

         while(true) {
            class172 var2 = (class172)this.field1223.method4048();
            if(var2 == null || var2.field2255 > this.field1217.field2338.length - this.field1217.field2339) {
               this.field1214.vmethod3347(this.field1217.field2338, 0, this.field1217.field2339, (byte)-15);
               this.field1224 = 0;
               break;
            }

            this.field1217.writeBytes(var2.field2257.field2338, 0, var2.field2255);
            this.field1216 -= var2.field2255;
            var2.unlink();
            var2.field2257.method3531(-1167762605);
            var2.method3460(1433475815);
         }
      }

   }

   void method1997(class157 var1, int var2) {
      this.field1214 = var1;
   }

   static final void method2005(boolean var0, int var1) {
      if(var0) {
         GameClient.field619 = class78.field1104 ? class146.field1910 : class146.field1905;
      } else {
         GameClient.field619 = class10.field61.field963.containsKey(Integer.valueOf(class3.method35(class78.typedUsername, 347954066))) ? class146.field1908 : class146.field1907;
      }

   }

   static void method1994(class247 var0, class247 var1, boolean var2, int var3, int var4) {
      if(class78.field1101) {
         if(var3 == 4) {
            class78.field1081 = 4;
         }

      } else {
         class78.field1081 = var3;
         Rasterizer2D.method5724();

         Custom.Icons.loadExtras(GameShell.INSTANCE.canvas);

         //byte[] var5 = var0.method4684("title.jpg", "", 222409025);
         //class78.titleImage = class284.method5324(var5, 105126678);
         //class78.titleImageRight = class78.titleImage.method5840();

         if((GameClient.field632 & 536870912) != 0) {
            class78.logo = class221.method4374(var1, "logo_deadman_mode", "", -291024557);
         } else {
            class78.logo = class221.method4374(var1, "logo", "", 712458035);
         }

         class78.field1083 = class221.method4374(var1, "titlebox", "", 1386222037);
         class78.field1084 = class221.method4374(var1, "titlebutton", "", 675732519);
         class78.field1111 = class13.method113(var1, "runes", "", -937341300);
         class124.field1708 = class13.method113(var1, "title_mute", "", 672731181);
         class235.field2783 = class221.method4374(var1, "options_radio_buttons,0", "", 544205164);
         class102.field1352 = class221.method4374(var1, "options_radio_buttons,4", "", -869768030);
         class78.field1089 = class221.method4374(var1, "options_radio_buttons,2", "", 990403260);
         class53.field472 = class221.method4374(var1, "options_radio_buttons,6", "", -696645900);
         class67.field978 = class235.field2783.width1;
         class66.field966 = class235.field2783.height1;
         class64.field936 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; var6++) {
            class64.field936[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; var6++) {
            class64.field936[var6 + 64] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; var6++) {
            if(var4 <= 814600686) {
               return;
            }

            class64.field936[var6 + 128] = var6 * 4 + 16776960;
         }

         for(var6 = 0; var6 < 64; var6++) {
            class64.field936[var6 + 192] = 16777215;
         }

         class185.field2364 = new int[256];

         for(var6 = 0; var6 < 64; var6++) {
            class185.field2364[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; var6++) {
            class185.field2364[var6 + 64] = var6 * 4 + 65280;
         }

         for(var6 = 0; var6 < 64; var6++) {
            if(var4 <= 814600686) {
               return;
            }

            class185.field2364[var6 + 128] = var6 * 262144 + 65535;
         }

         for(var6 = 0; var6 < 64; var6++) {
            class185.field2364[var6 + 192] = 16777215;
         }

         class11.field69 = new int[256];

         for(var6 = 0; var6 < 64; var6++) {
            class11.field69[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; var6++) {
            class11.field69[var6 + 64] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; var6++) {
            if(var4 <= 814600686) {
               return;
            }

            class11.field69[var6 + 128] = var6 * 1024 + 16711935;
         }

         for(var6 = 0; var6 < 64; var6++) {
            class11.field69[var6 + 192] = 16777215;
         }

         class77.field1077 = new int[256];
         class186.field2367 = new int[32768];
         class81.field1169 = new int[32768];
         class67.method1682((PaletteSprite)null, (byte)-60);
         class40.field357 = new int[32768];
         class76.field1073 = new int[32768];
         if(var2) {
            class78.typedUsername = "";
            class78.field1086 = "";
         }

         class14.field104 = 0;
         class28.field238 = "";
         class78.field1104 = true;
         class78.field1107 = false;
         if(!class10.field61.field958) {
            class23.method422(2, Item.field1147, "scape main", "", 255, false, -469912607);
         } else {
            class26.method427(2, -1481626830);
         }

         class222.method4410(false, 1173939929);
         class78.field1101 = true;
         class78.field1082 = (class82.field1179 - 765) / 2;
         class78.field1090 = class78.field1082 + 202;
         class78.field1091 = class78.field1090 + 180;
         class78.titleImage.method5849(class78.field1082, 0);
         class78.titleImageRight.method5849(class78.field1082 + 382, 0);
         //class78.logo.method5829(class78.field1082 + 382 - class78.logo.width1 / 2, 18);
      }
   }
}
