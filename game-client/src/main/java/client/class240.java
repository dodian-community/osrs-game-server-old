package client;

public class class240 implements class188 {
   public static final class240 field3102 = new class240(1, 6);
   public static final class240 field3101 = new class240(3, 0);
   public static final class240 field3103 = new class240(0, 7);
   public static final class240 field3099 = new class240(2, 3);
   public static final class240 field3107 = new class240(5, 1);
   public static final class240 field3097 = new class240(7, 2);
   public static final class240 field3098 = new class240(4, 5);
   public static final class240 field3100 = new class240(6, 4);
   static Widget field3096;
   static final int field3106 = 24;
   final int field3105;
   public final int field3104;

   class240(int var1, int var2) {
      this.field3104 = var1;
      this.field3105 = var2;
   }

   public int vmethod5815(byte var1) {
      return this.field3105;
   }

   static boolean method4601(PacketBuffer var0, int var1, int var2) {
      int var3 = var0.readBits(2);
      int var4;
      int var5;
      int var8;
      int var9;
      int var10;
      int var11;
      if(var3 == 0) {
         if(var0.readBits(1) != 0) {
            method4601(var0, var1, -1060183459);
         }

         var4 = var0.readBits(13);
         var5 = var0.readBits(13);
         boolean var13 = var0.readBits(1) == 1;
         if(var13) {
            class81.field1166[++class81.field1165 - 1] = var1;
         }

         if(GameClient.field610[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var7 = GameClient.field610[var1] = new Player();
            var7.field574 = var1;
            if(class81.field1157[var1] != null) {
               var7.decodeLooks(class81.field1157[var1], 1619811242);
            }

            var7.field926 = class81.field1163[var1];
            var7.field897 = class81.field1164[var1];
            var8 = class81.field1162[var1];
            var9 = var8 >> 28;
            var10 = var8 >> 14 & 255;
            var11 = var8 & 255;
            var7.field928[0] = class81.field1153[var1];
            var7.field567 = (byte)var9;
            var7.method1103((var10 << 13) + var4 - class62.baseX, (var11 << 13) + var5 - GameClient.baseY, 1433234046);
            var7.field571 = false;
            return true;
         }
      } else if(var3 == 1) {
         var4 = var0.readBits(2);
         var5 = class81.field1162[var1];
         class81.field1162[var1] = (var5 & 268435455) + (((var5 >> 28) + var4 & 3) << 28);
         return false;
      } else {
         int var6;
         int var12;
         if(var3 == 2) {
            var4 = var0.readBits(5);
            var5 = var4 >> 3;
            var6 = var4 & 7;
            var12 = class81.field1162[var1];
            var8 = (var12 >> 28) + var5 & 3;
            var9 = var12 >> 14 & 255;
            var10 = var12 & 255;
            if(var6 == 0) {
               --var9;
               --var10;
            }

            if(var6 == 1) {
               --var10;
            }

            if(var6 == 2) {
               ++var9;
               --var10;
            }

            if(var6 == 3) {
               --var9;
            }

            if(var6 == 4) {
               ++var9;
            }

            if(var6 == 5) {
               --var9;
               ++var10;
            }

            if(var6 == 6) {
               ++var10;
            }

            if(var6 == 7) {
               ++var9;
               ++var10;
            }

            class81.field1162[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         } else {
            var4 = var0.readBits(18);
            var5 = var4 >> 16;
            var6 = var4 >> 8 & 255;
            var12 = var4 & 255;
            var8 = class81.field1162[var1];
            var9 = (var8 >> 28) + var5 & 3;
            var10 = var6 + (var8 >> 14) & 255;
            var11 = var12 + var8 & 255;
            class81.field1162[var1] = (var10 << 14) + var11 + (var9 << 28);
            return false;
         }
      }
   }
}
