package client;

public final class class133 {
   static int field1834;
   static final int field1835 = 500;
   public long field1824 = 0L;
   int field1833 = 0;
   int field1830;
   int field1828;
   int field1825;
   int field1829;
   int field1832;
   public class127 field1823;
   public class127 field1831;
   int field1826;
   int field1827;

   static final void method3098(byte var0) {
      short var1 = 256;
      int var2;
      if(class78.field1088 > 0) {
         if(var0 != 30) {
            return;
         }

         for(var2 = 0; var2 < 256; var2++) {
            if(class78.field1088 > 768) {
               class77.field1077[var2] = class33.method558(class64.field936[var2], class185.field2364[var2], 1024 - class78.field1088, -2008842241);
            } else if(class78.field1088 > 256) {
               class77.field1077[var2] = class185.field2364[var2];
            } else {
               class77.field1077[var2] = class33.method558(class185.field2364[var2], class64.field936[var2], 256 - class78.field1088, -2008842241);
            }
         }
      } else if(class78.field1094 > 0) {
         for(var2 = 0; var2 < 256; var2++) {
            if(var0 != 30) {
               return;
            }

            if(class78.field1094 > 768) {
               class77.field1077[var2] = class33.method558(class64.field936[var2], class11.field69[var2], 1024 - class78.field1094, -2008842241);
            } else if(class78.field1094 > 256) {
               class77.field1077[var2] = class11.field69[var2];
            } else {
               class77.field1077[var2] = class33.method558(class11.field69[var2], class64.field936[var2], 256 - class78.field1094, -2008842241);
            }
         }
      } else {
         for(var2 = 0; var2 < 256; var2++) {
            class77.field1077[var2] = class64.field936[var2];
         }
      }

      Rasterizer2D.method5720(class78.field1082, 9, class78.field1082 + 128, var1 + 7);
      class78.titleImage.method5849(class78.field1082, 0);
      Rasterizer2D.method5719();
      var2 = 0;
      int var3 = class163.field2014.field3767 * 9 + class78.field1082;

      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      for(var4 = 1; var4 < var1 - 1; var4++) {
         if(var0 != 30) {
            return;
         }

         var5 = class78.field1093[var4] * (var1 - var4) / var1;
         var6 = var5 + 22;
         if(var6 < 0) {
            var6 = 0;
         }

         var2 += var6;

         for(var7 = var6; var7 < 128; var7++) {
            var8 = class40.field357[var2++];
            if(var8 != 0) {
               var9 = var8;
               var10 = 256 - var8;
               var8 = class77.field1077[var8];
               var11 = class163.field2014.field3768[var3];
               class163.field2014.field3768[var3++] = ((var8 & 16711935) * var9 + (var11 & 16711935) * var10 & -16711936) + (var9 * (var8 & 65280) + var10 * (var11 & 65280) & 16711680) >> 8;
            } else {
               ++var3;
            }
         }

         var3 += var6 + class163.field2014.field3767 - 128;
      }

      Rasterizer2D.method5720(class78.field1082 + 765 - 128, 9, class78.field1082 + 765, var1 + 7);
      class78.titleImageRight.method5849(class78.field1082 + 382, 0);
      Rasterizer2D.method5719();
      var2 = 0;
      var3 = class163.field2014.field3767 * 9 + class78.field1082 + 637 + 24;

      for(var4 = 1; var4 < var1 - 1; var4++) {
         var5 = class78.field1093[var4] * (var1 - var4) / var1;
         var6 = 103 - var5;
         var3 += var5;

         for(var7 = 0; var7 < var6; var7++) {
            var8 = class40.field357[var2++];
            if(var8 != 0) {
               var9 = var8;
               var10 = 256 - var8;
               var8 = class77.field1077[var8];
               var11 = class163.field2014.field3768[var3];
               class163.field2014.field3768[var3++] = ((var8 & 16711935) * var9 + (var11 & 16711935) * var10 & -16711936) + (var10 * (var11 & 65280) + var9 * (var8 & 65280) & 16711680) >> 8;
            } else {
               ++var3;
            }
         }

         var2 += 128 - var6;
         var3 += class163.field2014.field3767 - var6 - var5;
      }

   }

   static class84 method3099(int var0, int var1) {
      class84 var2 = (class84)class84.field1190.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = GameClient.field854.method4625(var0, 0, 1035018240);
         if(var3 == null) {
            return null;
         } else {
            var2 = class10.method97(var3, -2055825432);
            class84.field1190.method3983(var2, (long)var0);
            return var2;
         }
      }
   }

   public static void method3100(String[] var0, short[] var1, byte var2) {
      method3101(var0, var1, 0, var0.length - 1, -659552878);
   }

   static void method3101(String[] var0, short[] var1, int var2, int var3, int var4) {
      if(var2 < var3) {
         int var5 = (var3 + var2) / 2;
         int var6 = var2;
         String var7 = var0[var5];
         var0[var5] = var0[var3];
         var0[var3] = var7;
         short var8 = var1[var5];
         var1[var5] = var1[var3];
         var1[var3] = var8;

         for(int var9 = var2; var9 < var3; var9++) {
            if(var4 != -659552878) {
               return;
            }

            if(var7 == null || var0[var9] != null && var0[var9].compareTo(var7) < (var9 & 1)) {
               String var10 = var0[var9];
               var0[var9] = var0[var6];
               var0[var6] = var10;
               short var11 = var1[var9];
               var1[var9] = var1[var6];
               var1[var6++] = var11;
            }
         }

         var0[var3] = var0[var6];
         var0[var6] = var7;
         var1[var3] = var1[var6];
         var1[var6] = var8;
         method3101(var0, var1, var2, var6 - 1, -659552878);
         method3101(var0, var1, var6 + 1, var3, -659552878);
      }

   }
}
