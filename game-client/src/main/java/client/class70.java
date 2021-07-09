package client;

import java.io.File;
import java.io.RandomAccessFile;

public final class class70 extends class127 {
   static long field1013;
   public static final int field1022 = 16;
   int field1023;
   boolean field1021 = false;
   int field1020 = 0;
   int field1019 = 0;
   class273 field1018;
   int field1014;
   int field1015;
   int field1016;
   int field1017;
   int field1012;

   class70(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1023 = var1;
      this.field1014 = var2;
      this.field1015 = var3;
      this.field1016 = var4;
      this.field1017 = var5;
      this.field1012 = var7 + var6;
      int var8 = class57.method1035(this.field1023, -1735565269).field3271;
      if(var8 != -1) {
         this.field1021 = false;
         this.field1018 = class3.method25(var8, 1621883270);
      } else {
         this.field1021 = true;
      }

   }

   protected final class119 vmethod3067(int var1) {
      class258 var2 = class57.method1035(this.field1023, -1792183782);
      class119 var3;
      if(!this.field1021) {
         var3 = var2.method4866(this.field1019, -1083786622);
      } else {
         var3 = var2.method4866(-1, -201148550);
      }

      return var3 == null ? null : var3;
   }

   final void method1771(int var1, byte var2) {
      if(this.field1021) {
         if(var2 < 0) {
            ;
         }
      } else {
         this.field1020 += var1;

         while(this.field1020 > this.field1018.field3541[this.field1019]) {
            this.field1020 -= this.field1018.field3541[this.field1019];
            ++this.field1019;
            if(this.field1019 >= this.field1018.field3540.length) {
               this.field1021 = true;
               break;
            }
         }

      }
   }

   static boolean method1766(File var0, boolean var1, int var2) {
      try {
         RandomAccessFile var3 = new RandomAccessFile(var0, "rw");
         int var4 = var3.read();
         var3.seek(0L);
         var3.write(var4);
         var3.seek(0L);
         var3.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var5) {
         return false;
      }
   }

   static int method1768(int var0, class84 var1, boolean var2, byte var3) {
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = Widget.getLoaded(class69.field999[--class69.field1003]);
      } else {
         var4 = var2 ? class276.field3561 : class260.field3301;
      }

      GameClient.requestRedraw(var4);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var4.mediaType = 2;
            var4.mediaID = class69.field999[--class69.field1003];
            return 1;
         } else if(var0 == 1202) {
            var4.mediaType = 3;
            var4.mediaID = class138.field1876.field546.method4483(253544675);
            return 1;
         } else {
            return 2;
         }
      } else {
         class69.field1003 -= 2;
         int var5 = class69.field999[class69.field1003];
         int var6 = class69.field999[class69.field1003 + 1];
         var4.itemId = var5;
         var4.field2727 = var6;
         ItemDef var7 = ItemDef.loadItemDef(var5);
         ShopInterface.updateItem(var4);
         var4.rotationX = var7.xan2d;
         var4.rotationY = var7.yan2d;
         var4.int477 = var7.zan2d;
         var4.int457 = var7.xof2d;
         var4.int474 = var7.yof2d;
         var4.zoom = var7.zoom2d;
         if(var0 == 1205) {
            var4.field2664 = 0;
         } else if(var0 == 1212 | var7.stackable == 1) {
            var4.field2664 = 1;
         } else {
            var4.field2664 = 2;
         }

         if(var4.int464 > 0) {
            var4.zoom = var4.zoom * 32 / var4.int464;
         } else if(var4.width > 0) {
            var4.zoom = var4.zoom * 32 / var4.width;
         }

         return 1;
      }
   }
}
