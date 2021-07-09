package client;

public class class139 extends class283 {
   static class247 field1877;
   public static final int field1878 = 256;
   static final int field1879 = 127;
   static final int field1880 = 103;
   final boolean field1881;

   public class139(boolean var1) {
      this.field1881 = var1;
   }

   int method3139(class287 var1, class287 var2, byte var3) {
      if(GameClient.field581 == var1.field3628) {
         if(var2.field3628 != GameClient.field581) {
            return this.field1881 ? -1 : 1;
         }
      } else if(var2.field3628 == GameClient.field581) {
         return this.field1881 ? 1 : -1;
      }

      return this.method5308(var1, var2, -366074461);
   }

   public int compare(Object var1, Object var2) {
      return this.method3139((class287)var1, (class287)var2, (byte)58);
   }

   static String method3138(String var0, int var1) {
      Icon[] var2 = class20.getIcons();

      for(int var3 = 0; var3 < var2.length; var3++) {
         Icon var4 = var2[var3];
         if(var4.field3128 != -1) {
            int var7 = var4.field3128;
            String var6 = "<img=" + var7 + ">";
            if(var0.startsWith(var6)) {
               var0 = var0.substring(6 + Integer.toString(var4.field3128).length());
               break;
            }
         }
      }

      return var0;
   }

   static int method3143(int var0, int var1, int var2) {
      class53 var3 = (class53)class53.field474.get((long)var0);
      if(var3 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var4 = 0;

         for(int var5 = 0; var5 < var3.field473.length; var5++) {
            if(var3.field477[var5] == var1) {
               var4 += var3.field473[var5];
            }
         }

         return var4;
      }
   }

   static int method3145(char var0, int var1, byte var2) {
      int var3 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var3 = (var0 << 4) + 1;
      }

      return var3;
   }
}
