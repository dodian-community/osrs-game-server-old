package client;

import javax.imageio.ImageIO;

public class class43 {
   protected static class160 field368;
   static Sprite[] field369;
   protected static final int field370 = 32;
   static final int field371 = -3407872;

   static {
      ImageIO.setUseCache(false);
   }

   static long method716(int var0, int var1, int var2, int var3) {
      return (long)(var2 << 16 | var0 << 8 | var1);
   }

   static final boolean method713(int var0, byte var1) {
      if(var0 < 0) {
         return false;
      } else {
         int var2 = GameClient.field720[var0];
         if(var2 >= 2000) {
            var2 -= 2000;
         }

         return var2 == 1007;
      }
   }

   public static class160 method712(int var0) {
      try {
         return new class149();
      } catch (Throwable var2) {
         return new class150();
      }
   }

   public static void method715(int var0) {
      class272.field3524.method3984();
   }

   static final void method714(int var0, int var1, int var2, int var3, boolean var4, int var5) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var6 = var3 - 334;
      if(var6 < 0) {
         var6 = 0;
      } else if(var6 > 100) {
         var6 = 100;
      }

      int var7 = (GameClient.field829 - GameClient.field802) * var6 / 100 + GameClient.field802;
      int var8 = var3 * var7 * 512 / (var2 * 334);
      int var9;
      int var10;
      short var16;
      if(var8 < GameClient.field834) {
         var16 = GameClient.field834;
         var7 = var16 * var2 * 334 / (var3 * 512);
         if(var7 > GameClient.field833) {
            var7 = GameClient.field833;
            var9 = var3 * var7 * 512 / (var16 * 334);
            var10 = (var2 - var9) / 2;
            if(var4) {
               if(var5 != 2123332164) {
                  return;
               }

               Rasterizer2D.method5719();
               Rasterizer2D.method5763(var0, var1, var10, var3, -16777216);
               Rasterizer2D.method5763(var0 + var2 - var10, var1, var10, var3, -16777216);
            }

            var0 += var10;
            var2 -= var10 * 2;
         }
      } else if(var8 > GameClient.field835) {
         var16 = GameClient.field835;
         var7 = var16 * var2 * 334 / (var3 * 512);
         if(var7 < GameClient.field832) {
            var7 = GameClient.field832;
            var9 = var16 * var2 * 334 / (var7 * 512);
            var10 = (var3 - var9) / 2;
            if(var4) {
               Rasterizer2D.method5719();
               Rasterizer2D.method5763(var0, var1, var2, var10, -16777216);
               Rasterizer2D.method5763(var0, var3 + var1 - var10, var2, var10, -16777216);
            }

            var1 += var10;
            var3 -= var10 * 2;
         }
      }

      var9 = (GameClient.field831 - GameClient.field848) * var6 / 100 + GameClient.field848;
      GameClient.field840 = var3 * var7 * var9 / 85504 << 1;
      if(var2 != GameClient.field838 || var3 != GameClient.field662) {
         int[] var15 = new int[9];

         for(int var11 = 0; var11 < 9; var11++) {
            int var12 = var11 * 32 + 15 + 128;
            int var13 = var12 * 3 + 600;
            int var14 = class122.field1681[var12];
            var15[var11] = var13 * var14 >> 16;
         }

         class125.method2893(var15, 500, 800, var2, var3);
      }

      GameClient.field762 = var0;
      GameClient.field837 = var1;
      GameClient.field838 = var2;
      GameClient.field662 = var3;
   }
}
