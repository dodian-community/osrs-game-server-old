package client;

public class class172 extends class204 {
   static class172[] field2256 = new class172[300];
   static int field2258 = 0;
   static int[] field2260;
   public static final int field2259 = 512;
   public PacketBuffer field2257;
   public int field2255;
   OutgoingPacket field2254;
   int field2253;

   public void method3460(int var1) {
      if(field2258 < field2256.length) {
         field2256[++field2258 - 1] = this;
      }
   }

   public static String method3457(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class303.field3720[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   static void method3458(Sprite var0, int var1, int var2, int var3, int var4) {
      class23.field188.method3998(var0, class43.method716(var1, var2, var3, -1703080901), var0.pixels.length * 4);
   }

   static void method3456(byte var0) {
      class83.field1180.clear();
      class83.field1181.method3951();
      class83.field1184.method4168();
      class83.field1186 = 0;
   }
}
