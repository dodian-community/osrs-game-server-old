package client;

import java.text.DecimalFormat;

public class class78 {
   static int field1082 = 0;
   static int field1090;
   static int[] field1093;
   static int field1088;
   static String field1103;
   static int field1094;
   static String field1112;
   static int field1095;
   static int field1081;
   static String field1105;
   static int field1096;
   static int field1097;
   static int field1114;
   static int field1099;
   static String field1100;
   static String field1098;
   static String typedUsername;
   static boolean field1107;
   static String field1086;
   static boolean field1108;
   static boolean field1110;
   static boolean field1115;
   static boolean field1104;
   static int field1102;
   static int field1091;
   static int field1116;
   static Sprite titleImage;
   static long field1109;
   static Sprite titleImageRight;
   static long field1118;
   static PaletteSprite logo;
   static PaletteSprite field1083;
   static PaletteSprite field1084;
   static PaletteSprite[] field1111;
   static PaletteSprite field1089;
   static boolean field1101;
   static final int field1119 = 32;

   static {
      field1090 = field1082 + 202;
      field1093 = new int[256];
      field1088 = 0;
      field1094 = 0;
      field1095 = 0;
      field1096 = 0;
      field1097 = 0;
      field1114 = 0;
      field1099 = 10;
      field1100 = "";
      field1081 = 0;
      field1098 = "";
      field1103 = "";
      field1112 = "";
      field1105 = "";
      typedUsername = "";
      field1086 = "";
      field1108 = false;
      field1110 = false;
      field1115 = false;
      field1104 = true;
      field1102 = 0;
      field1107 = false;
      field1116 = -1;
      new DecimalFormat("##0.00");
      new class148();
      field1109 = -1L;
      field1118 = -1L;
   }

   public static String method1831(byte[] var0, int var1, int var2, int var3) {
      char[] var4 = new char[var2];
      int var5 = 0;

      for(int var6 = 0; var6 < var2; var6++) {
         int var7 = var0[var6 + var1] & 255;
         if(var7 != 0) {
            if(var7 >= 128 && var7 < 160) {
               char var8 = class301.field3714[var7 - 128];
               if(var8 == 0) {
                  var8 = 63;
               }

               var7 = var8;
            }

            var4[var5++] = (char)var7;
         }
      }

      return new String(var4, 0, var5);
   }
}
