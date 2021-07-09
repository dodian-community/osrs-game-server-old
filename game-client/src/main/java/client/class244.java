package client;

public class class244 implements class188 {
   static final class244 field3146 = new class244("runescape", "RuneScape", 0);
   static final class244 field3141 = new class244("stellardawn", "Stellar Dawn", 1);
   static final class244 field3142 = new class244("game3", "Game 3", 2);
   static final class244 field3143 = new class244("game4", "Game 4", 3);
   static final class244 field3140 = new class244("game5", "Game 5", 4);
   public static final class244 field3145 = new class244("osscape", "RuneScape 2007", 5);
   final int field3147;
   public final String field3144;

   class244(String var1, String var2, int var3) {
      this.field3144 = var1;
      this.field3147 = var3;
   }

   public int vmethod5815(byte var1) {
      return this.field3147;
   }

   public static byte[] method4618(CharSequence var0, int var1) {
      int var2 = var0.length();
      byte[] var3 = new byte[var2];

      for(int var4 = 0; var4 < var2; var4++) {
         char var5 = var0.charAt(var4);
         if(var5 > 0 && var5 < 128 || var5 >= 160 && var5 <= 255) {
            var3[var4] = (byte)var5;
         } else if(var5 == 8364) {
            var3[var4] = -128;
         } else if(var5 == 8218) {
            var3[var4] = -126;
         } else if(var5 == 402) {
            var3[var4] = -125;
         } else if(var5 == 8222) {
            var3[var4] = -124;
         } else if(var5 == 8230) {
            var3[var4] = -123;
         } else if(var5 == 8224) {
            var3[var4] = -122;
         } else if(var5 == 8225) {
            var3[var4] = -121;
         } else if(var5 == 710) {
            var3[var4] = -120;
         } else if(var5 == 8240) {
            var3[var4] = -119;
         } else if(var5 == 352) {
            var3[var4] = -118;
         } else if(var5 == 8249) {
            var3[var4] = -117;
         } else if(var5 == 338) {
            var3[var4] = -116;
         } else if(var5 == 381) {
            var3[var4] = -114;
         } else if(var5 == 8216) {
            var3[var4] = -111;
         } else if(var5 == 8217) {
            var3[var4] = -110;
         } else if(var5 == 8220) {
            var3[var4] = -109;
         } else if(var5 == 8221) {
            var3[var4] = -108;
         } else if(var5 == 8226) {
            var3[var4] = -107;
         } else if(var5 == 8211) {
            var3[var4] = -106;
         } else if(var5 == 8212) {
            var3[var4] = -105;
         } else if(var5 == 732) {
            var3[var4] = -104;
         } else if(var5 == 8482) {
            var3[var4] = -103;
         } else if(var5 == 353) {
            var3[var4] = -102;
         } else if(var5 == 8250) {
            var3[var4] = -101;
         } else if(var5 == 339) {
            var3[var4] = -100;
         } else if(var5 == 382) {
            var3[var4] = -98;
         } else if(var5 == 376) {
            var3[var4] = -97;
         } else {
            var3[var4] = 63;
         }
      }

      return var3;
   }
}
