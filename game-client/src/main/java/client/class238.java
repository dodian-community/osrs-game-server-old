package client;

public class class238 {
   public static final int field3083 = 260;
   public static final byte field3084 = 2;
   public static final byte field3085 = -1;
   public static final byte field3086 = 1;
   static final int field3087 = 1006;

   static final void method4594(int var0, int var1, int var2, int var3) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var4 = class27.method460(var0, var1, class13.field82, -1909450747) - var2;
         var0 -= class109.field1431;
         var4 -= class123.field1702;
         var1 -= class226.field2563;
         int var5 = class122.field1681[class7.field41];
         int var6 = class122.field1693[class7.field41];
         int var7 = class122.field1681[class85.field1201];
         int var8 = class122.field1693[class85.field1201];
         int var9 = var7 * var1 + var0 * var8 >> 16;
         var1 = var8 * var1 - var0 * var7 >> 16;
         var0 = var9;
         var9 = var6 * var4 - var5 * var1 >> 16;
         var1 = var4 * var5 + var6 * var1 >> 16;
         if(var1 >= 50) {
            GameClient.field679 = var0 * GameClient.field840 / var1 + GameClient.field838 / 2;
            GameClient.field680 = var9 * GameClient.field840 / var1 + GameClient.field662 / 2;
         } else {
            GameClient.field679 = -1;
            GameClient.field680 = -1;
         }

      } else {
         GameClient.field679 = -1;
         GameClient.field680 = -1;
      }
   }
}
