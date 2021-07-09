package client;

public class class40 implements class89 {
   static int field361;
   static int[] field357;
   public static final int field356 = 1011;
   static final String field358 = ",";
   static final int field359 = 2048;
   public static final int field360 = 0;

   public class95 vmethod2052(byte var1) {
      return new class44();
   }

   static final boolean method693(int var0, int var1, class166 var2, class164 var3, int var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class165.field2035[var7][var8] = 99;
      class165.field2041[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class165.field2039[var11] = var0;
      byte var10001 = var11;
      int var19 = var11 + 1;
      class165.field2038[var10001] = var1;
      int[][] var13 = var3.field2029;

      while(var12 != var19) {
         var5 = class165.field2039[var12];
         var6 = class165.field2038[var12];
         var12 = var12 + 1 & 4095;
         int var17 = var5 - var9;
         int var18 = var6 - var10;
         int var14 = var5 - var3.field2025;
         int var15 = var6 - var3.field2026;
         if(var2.vmethod3440(2, var5, var6, var3, (byte)23)) {
            class19.field152 = var5;
            class165.field2037 = var6;
            return true;
         }

         int var16 = class165.field2041[var17][var18] + 1;
         if(var17 > 0 && class165.field2035[var17 - 1][var18] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + 1] & 19136824) == 0) {
            class165.field2039[var19] = var5 - 1;
            class165.field2038[var19] = var6;
            var19 = var19 + 1 & 4095;
            class165.field2035[var17 - 1][var18] = 2;
            class165.field2041[var17 - 1][var18] = var16;
         }

         if(var17 < 126 && class165.field2035[var17 + 1][var18] == 0 && (var13[var14 + 2][var15] & 19136899) == 0 && (var13[var14 + 2][var15 + 1] & 19136992) == 0) {
            class165.field2039[var19] = var5 + 1;
            class165.field2038[var19] = var6;
            var19 = var19 + 1 & 4095;
            class165.field2035[var17 + 1][var18] = 8;
            class165.field2041[var17 + 1][var18] = var16;
         }

         if(var18 > 0 && class165.field2035[var17][var18 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + 1][var15 - 1] & 19136899) == 0) {
            class165.field2039[var19] = var5;
            class165.field2038[var19] = var6 - 1;
            var19 = var19 + 1 & 4095;
            class165.field2035[var17][var18 - 1] = 1;
            class165.field2041[var17][var18 - 1] = var16;
         }

         if(var18 < 126 && class165.field2035[var17][var18 + 1] == 0 && (var13[var14][var15 + 2] & 19136824) == 0 && (var13[var14 + 1][var15 + 2] & 19136992) == 0) {
            class165.field2039[var19] = var5;
            class165.field2038[var19] = var6 + 1;
            var19 = var19 + 1 & 4095;
            class165.field2035[var17][var18 + 1] = 4;
            class165.field2041[var17][var18 + 1] = var16;
         }

         if(var17 > 0 && var18 > 0 && class165.field2035[var17 - 1][var18 - 1] == 0 && (var13[var14 - 1][var15] & 19136830) == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0 && (var13[var14][var15 - 1] & 19136911) == 0) {
            class165.field2039[var19] = var5 - 1;
            class165.field2038[var19] = var6 - 1;
            var19 = var19 + 1 & 4095;
            class165.field2035[var17 - 1][var18 - 1] = 3;
            class165.field2041[var17 - 1][var18 - 1] = var16;
         }

         if(var17 < 126 && var18 > 0 && class165.field2035[var17 + 1][var18 - 1] == 0 && (var13[var14 + 1][var15 - 1] & 19136911) == 0 && (var13[var14 + 2][var15 - 1] & 19136899) == 0 && (var13[var14 + 2][var15] & 19136995) == 0) {
            class165.field2039[var19] = var5 + 1;
            class165.field2038[var19] = var6 - 1;
            var19 = var19 + 1 & 4095;
            class165.field2035[var17 + 1][var18 - 1] = 9;
            class165.field2041[var17 + 1][var18 - 1] = var16;
         }

         if(var17 > 0 && var18 < 126 && class165.field2035[var17 - 1][var18 + 1] == 0 && (var13[var14 - 1][var15 + 1] & 19136830) == 0 && (var13[var14 - 1][var15 + 2] & 19136824) == 0 && (var13[var14][var15 + 2] & 19137016) == 0) {
            class165.field2039[var19] = var5 - 1;
            class165.field2038[var19] = var6 + 1;
            var19 = var19 + 1 & 4095;
            class165.field2035[var17 - 1][var18 + 1] = 6;
            class165.field2041[var17 - 1][var18 + 1] = var16;
         }

         if(var17 < 126 && var18 < 126 && class165.field2035[var17 + 1][var18 + 1] == 0 && (var13[var14 + 1][var15 + 2] & 19137016) == 0 && (var13[var14 + 2][var15 + 2] & 19136992) == 0 && (var13[var14 + 2][var15 + 1] & 19136995) == 0) {
            class165.field2039[var19] = var5 + 1;
            class165.field2038[var19] = var6 + 1;
            var19 = var19 + 1 & 4095;
            class165.field2035[var17 + 1][var18 + 1] = 12;
            class165.field2041[var17 + 1][var18 + 1] = var16;
         }
      }

      class19.field152 = var5;
      class165.field2037 = var6;
      return false;
   }

   static void method695(byte var0) {
      class50.field442 = 99;
      class50.field445 = new byte[4][104][104];
      class165.field2033 = new byte[4][104][104];
      class50.field446 = new byte[4][104][104];
      class19.field159 = new byte[4][104][104];
      class37.field325 = new int[4][105][105];
      class50.field447 = new byte[4][105][105];
      class50.field448 = new int[105][105];
      class50.field454 = new int[104];
      class305.field3725 = new int[104];
      Npc.field1035 = new int[104];
      class263.field3325 = new int[104];
      class243.field3137 = new int[104];
   }

   static boolean method696(byte var0) {
      return GameClient.field747 >= 2;
   }
}
