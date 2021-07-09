package client;

import java.util.zip.CRC32;

public class class250 {
   public static int field3214 = 0;
   public static int field3197 = 0;
   static class202 field3204 = new class202(4096);
   public static int field3215 = 0;
   public static class202 field3212 = new class202(4096);
   public static class194 field3202 = new class194();
   public static int field3211 = 0;
   public static class246 field3208;
   public static class202 field3199 = new class202(32);
   public static long field3203;
   public static int field3198 = 0;
   public static class202 field3206 = new class202(4096);
   public static int field3205 = 0;
   public static class249[] field3201 = new class249[256];
   public static int field3207 = 0;
   public static class157 field3200;
   public static Stream field3209 = new Stream(8);
   public static int field3210 = 0;
   public static CRC32 field3196 = new CRC32();
   public static byte field3213 = 0;

   public static char method4770(char var0, int var1) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 376:
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   public static void method4766(class247 var0, class247 var1, class247 var2, int var3) {
      class267.field3367 = var0;
      class267.field3348 = var1;
      class139.field1877 = var2;
   }
}
