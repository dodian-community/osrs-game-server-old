package client;

public final class class49 {
   static class136 field439;
   static final int field437 = 128;
   static final int field438 = 42;
   public static final int field440 = 13;
   static final int field441 = 3;

   public static class259 method953(int var0, int var1) {
      class259 var2 = (class259)class259.field3282.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class259.field3283.method4625(1, var0, 953370826);
         var2 = new class259();
         if(var3 != null) {
            var2.method4880(new Stream(var3), var0, 1570676740);
         }

         var2.method4875(-1291543523);
         class259.field3282.method3983(var2, (long)var0);
         return var2;
      }
   }

   static PaletteSprite[] method950(int var0) {
      PaletteSprite[] var1 = new PaletteSprite[class319.field3802];

      for(int var2 = 0; var2 < class319.field3802; var2++) {
         PaletteSprite var3 = var1[var2] = new PaletteSprite();
         var3.width = class305.field3729;
         var3.height = class319.field3798;
         var3.offX = class7.field45[var2];
         var3.offY = class225.field2562[var2];
         var3.width1 = class319.field3800[var2];
         var3.height1 = class319.field3799[var2];
         var3.palette = class172.field2260;
         var3.pixels = class319.field3801[var2];
      }

      class7.field45 = null;
      class225.field2562 = null;
      class319.field3800 = null;
      class319.field3799 = null;
      class172.field2260 = null;
      class319.field3801 = null;
      return var1;
   }

   static final void method951(int var0, int var1, int var2, int var3, int var4, int var5, byte var6) {
      int var7 = 2048 - var3 & 2047;
      int var8 = 2048 - var4 & 2047;
      int var9 = 0;
      int var10 = 0;
      int var11 = var5;
      int var12;
      int var13;
      int var14;
      if(var7 != 0) {
         var12 = class122.field1681[var7];
         var13 = class122.field1693[var7];
         var14 = var13 * var10 - var5 * var12 >> 16;
         var11 = var13 * var5 + var10 * var12 >> 16;
         var10 = var14;
      }

      if(var8 != 0) {
         if(var6 == 1) {
            return;
         }

         var12 = class122.field1681[var8];
         var13 = class122.field1693[var8];
         var14 = var9 * var13 + var12 * var11 >> 16;
         var11 = var11 * var13 - var9 * var12 >> 16;
         var9 = var14;
      }

      class109.field1431 = var0 - var9;
      class123.field1702 = var1 - var10;
      class226.field2563 = var2 - var11;
      class7.field41 = var3;
      class85.field1201 = var4;
      if(GameClient.field655 == 1) {
         if(var6 == 1) {
            return;
         }

         if(GameClient.field747 >= 2 && GameClient.field591 % 50 == 0 && (class109.field1428 >> 7 != class138.field1876.field931 >> 7 || class2.field23 >> 7 != class138.field1876.field881 >> 7)) {
            var12 = class138.field1876.field567;
            var13 = (class109.field1428 >> 7) + class62.baseX;
            var14 = (class2.field23 >> 7) + GameClient.baseY;
            class19.method197(var13, var14, var12, true, -185686221);
         }
      }

   }

   static void method952(byte var0) {
      class50.field445 = null;
      class165.field2033 = null;
      class50.field446 = null;
      class19.field159 = null;
      class37.field325 = null;
      class50.field447 = null;
      class50.field448 = null;
      class50.field454 = null;
      class305.field3725 = null;
      Npc.field1035 = null;
      class263.field3325 = null;
      class243.field3137 = null;
   }
}
