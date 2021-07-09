package client;

public class class55 extends class204 {
   static int field497;
   static int field495;
   static final int field498 = 4;
   public static final int field499 = 1;
   static final int field500 = 2;
   public static final int field502 = 1010;
   static final int field503 = 104;
   boolean field496 = false;
   int field501;
   int field494;

   static final void method1022(int var0, int var1, int var2, int var3, Sprite var4, class224 var5, byte var6) {
      if(var4 == null) {
         if(var6 > 1) {
            ;
         }
      } else {
         int var7 = GameClient.field717 & 2047;
         int var8 = var3 * var3 + var2 * var2;
         if(var8 <= 6400) {
            int var9 = class122.field1681[var7];
            int var10 = class122.field1693[var7];
            int var11 = var3 * var9 + var10 * var2 >> 16;
            int var12 = var3 * var10 - var9 * var2 >> 16;
            if(var8 > 2500) {
               var4.method5867(var11 + var5.field2553 / 2 - var4.maxWidth / 2, var5.field2549 / 2 - var12 - var4.maxHeight / 2, var0, var1, var5.field2553, var5.field2549, var5.field2551, var5.field2550);
            } else {
               var4.method5851(var0 + var11 + var5.field2553 / 2 - var4.maxWidth / 2, var5.field2549 / 2 + var1 - var12 - var4.maxHeight / 2);
            }

         }
      }
   }
}
