package client;

public class class120 {
   public static boolean field1650 = false;
   static int field1648 = 0;
   static int field1649 = 0;
   static boolean field1652 = false;
   public static int field1656 = 0;
   public static long[] field1647 = new long[1000];
   static int field1657;
   static int field1659;
   static int field1655;
   static int field1651;
   static int field1654;
   static final int field1653 = 127;
   static final int field1658 = 0;

   static void method2781(int var0, int var1, int var2, boolean var3, int var4, boolean var5, byte var6) {
      if(var0 < var1) {
         int var7 = (var0 + var1) / 2;
         int var8 = var0;
         class65 var9 = class65.field949[var7];
         class65.field949[var7] = class65.field949[var1];
         class65.field949[var1] = var9;

         for(int var10 = var0; var10 < var1; var10++) {
            if(class109.method2503(class65.field949[var10], var9, var2, var3, var4, var5, 623148827) <= 0) {
               class65 var11 = class65.field949[var10];
               class65.field949[var10] = class65.field949[var8];
               class65.field949[var8++] = var11;
            }
         }

         class65.field949[var1] = class65.field949[var8];
         class65.field949[var8] = var9;
         method2781(var0, var8 - 1, var2, var3, var4, var5, (byte)40);
         method2781(var8 + 1, var1, var2, var3, var4, var5, (byte)40);
      }

   }
}
