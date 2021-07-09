package client;

public class class97 implements Runnable {
   static class249 field1329;
   static final int field1325 = 3;
   static final int field1326 = 56;
   static final int field1328 = 19136782;
   volatile class95[] field1327 = new class95[2];

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; var1++) {
            class95 var2 = this.field1327[var1];
            if(var2 != null) {
               var2.method2144(947574541);
            }
         }
      } catch (Exception var4) {
         class5.method65((String)null, var4, (byte)95);
      }

   }

   static final void method2213(int var0) {
      GameClient.field626.method1982((short)-29590);
      class54.method1020(2135811490);
      class28.field248.method2903();

      for(int var1 = 0; var1 < 4; var1++) {
         GameClient.field642[var1].method3392((byte)111);
      }

      System.gc();
      class26.method427(2, -1251521603);
      GameClient.field812 = -1;
      GameClient.field813 = false;

      for(class68 var2 = (class68)class68.field985.method4098(); var2 != null; var2 = (class68)class68.field985.method4079()) {
         if(var2.field993 != null) {
            class36.field310.method2009(var2.field993);
            var2.field993 = null;
         }

         if(var2.field980 != null) {
            class36.field310.method2009(var2.field980);
            var2.field980 = null;
         }
      }

      class68.field985.method4072();
      class48.method947(10, -1205292876);
   }

   public static byte[] method2211(Object var0, boolean var1, byte var2) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var4 = (byte[])((byte[])var0);
         return var1 ? class59.method1075(var4, (byte)16) : var4;
      } else if(var0 instanceof class186) {
         class186 var3 = (class186)var0;
         return var3.vmethod3789((byte)-44);
      } else {
         throw new IllegalArgumentException();
      }
   }

   static void method2215(int var0) {
      if(class21.field175 != null) {
         GameClient.field650 = GameClient.field591;
         class21.field175.method4774(641561299);

         for(int var1 = 0; var1 < GameClient.field610.length; var1++) {
            if(GameClient.field610[var1] != null) {
               class21.field175.method4773((GameClient.field610[var1].field931 >> 7) + class62.baseX, (GameClient.field610[var1].field881 >> 7) + GameClient.baseY, -1087608107);
            }
         }
      }

   }

   public static boolean method2214(int var0, int var1, int var2) {
      return (var0 >> var1 + 1 & 1) != 0;
   }
}
