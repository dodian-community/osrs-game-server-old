package client;

public class class59 extends class166 {
   static class249 field543;
   static final int field544 = 8;

   protected boolean vmethod3440(int var1, int var2, int var3, class164 var4, byte var5) {
      return var2 == super.field2043 && var3 == super.field2048;
   }

   static void method1077(int var0) {
      GameClient.field771 = 0;
      GameClient.field716 = false;
      GameClient.field735[0] = "Cancel";
      GameClient.field740[0] = "";
      GameClient.field720[0] = 1006;
      GameClient.field590[0] = false;
      GameClient.field771 = 1;
   }

   static byte[] method1075(byte[] var0, byte var1) {
      int var2 = var0.length;
      byte[] var3 = new byte[var2];
      System.arraycopy(var0, 0, var3, 0, var2);
      return var3;
   }

   static void method1079(int var0) {
      if(class78.field1101) {
         class78.field1083 = null;
         class78.field1084 = null;
         class78.field1111 = null;
         class78.titleImage = null;
         class78.titleImageRight = null;
         class78.logo = null;
         class124.field1708 = null;
         class235.field2783 = null;
         class78.field1089 = null;
         class166.field2047 = null;
         class13.field85 = null;
         class126.field1779 = null;
         class28.field237 = null;
         class232.field2752 = null;
         class64.field936 = null;
         class185.field2364 = null;
         class11.field69 = null;
         class77.field1077 = null;
         class186.field2367 = null;
         class81.field1169 = null;
         class40.field357 = null;
         class76.field1073 = null;
         class26.method427(2, 758911181);
         class222.method4410(true, 171142550);
         class78.field1101 = false;
      }
   }

   static String method1076(int var0) {
      return class10.field61.field962 ? class265.method4976(class78.typedUsername, (short)28003) : class78.typedUsername;
   }

   static final void method1080(class63 var0, int var1, int var2) {
      if(var0.field917 > GameClient.field591) {
         int var3 = var0.field917 - GameClient.field591;
         int var4 = var0.field913 * 128 + var0.field874 * 64;
         int var5 = var0.field915 * 128 + var0.field874 * 64;
         var0.field931 += (var4 - var0.field931) / var3;
         var0.field881 += (var5 - var0.field881) / var3;
         var0.field923 = 0;
         var0.field926 = var0.field919;
      } else if(var0.field918 >= GameClient.field591) {
         Item.method1865(var0, (byte)-41);
      } else {
         class35.method609(var0, (byte)-96);
      }

      label60: {
         if(var0.field931 >= 128 && var0.field881 >= 128 && var0.field931 < 13184) {
            if(var2 <= -101317535) {
               return;
            }

            if(var0.field881 < 13184) {
               break label60;
            }

            if(var2 <= -101317535) {
               return;
            }
         }

         var0.field903 = -1;
         var0.field891 = -1;
         var0.field917 = 0;
         var0.field918 = 0;
         var0.field931 = var0.field922[0] * 128 + var0.field874 * 64;
         var0.field881 = var0.field872[0] * 128 + var0.field874 * 64;
         var0.method1540(2028787845);
      }

      if(class138.field1876 == var0) {
         label50: {
            if(var0.field931 >= 1536 && var0.field881 >= 1536) {
               if(var2 <= -101317535) {
                  return;
               }

               if(var0.field931 < 11776) {
                  if(var2 <= -101317535) {
                     return;
                  }

                  if(var0.field881 < 11776) {
                     break label50;
                  }
               }
            }

            var0.field903 = -1;
            var0.field891 = -1;
            var0.field917 = 0;
            var0.field918 = 0;
            var0.field931 = var0.field922[0] * 128 + var0.field874 * 64;
            var0.field881 = var0.field872[0] * 128 + var0.field874 * 64;
            var0.method1540(2028787845);
         }
      }

      class3.method26(var0, -1623829882);
      class295.method5502(var0, 1542414635);
   }

   static void method1078(short var0) {
      if(class4.method36(1218832541)) {
         class78.field1107 = true;
      }

   }
}
