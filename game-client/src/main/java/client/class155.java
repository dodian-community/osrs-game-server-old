package client;

import java.io.File;

public class class155 {
   public static class109 field1968 = null;
   static File field1966;
   public static class109 field1969 = null;
   public static class109 field1970 = null;
   static String[] field1965;
   static File field1964;
   static final int field1962 = 1048576000;
   static final int field1963 = 1048576;
   static final String field1967 = "main_file_cache.idx";
   static final String field1971 = "rw";

   public static int method3269(CharSequence var0, CharSequence var1, int var2, int var3) {
      int var4 = var0.length();
      int var5 = var1.length();
      int var6 = 0;
      int var7 = 0;
      byte var8 = 0;
      byte var9 = 0;

      while(var6 - var8 < var4 || var7 - var9 < var5) {
         if(var6 - var8 >= var4) {
            return -1;
         }

         if(var7 - var9 >= var5) {
            return 1;
         }

         char var10;
         if(var8 != 0) {
            var10 = (char)var8;
            boolean var15 = false;
         } else {
            var10 = var0.charAt(var6++);
         }

         char var11;
         if(var9 != 0) {
            var11 = (char)var9;
            boolean var16 = false;
         } else {
            var11 = var1.charAt(var7++);
         }

         byte var12;
         if(var10 == 198) {
            var12 = 69;
         } else if(var10 == 230) {
            var12 = 101;
         } else if(var10 == 223) {
            var12 = 115;
         } else if(var10 == 338) {
            var12 = 69;
         } else if(var10 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         byte var13;
         if(var11 == 198) {
            var13 = 69;
         } else if(var11 == 230) {
            var13 = 101;
         } else if(var11 == 223) {
            var13 = 115;
         } else if(var11 == 338) {
            var13 = 69;
         } else if(var11 == 339) {
            var13 = 101;
         } else {
            var13 = 0;
         }

         var9 = var13;
         var10 = class17.method169(var10, var2, 2067503426);
         var11 = class17.method169(var11, var2, 579627496);
         if(var10 != var11 && Character.toUpperCase(var10) != Character.toUpperCase(var11)) {
            var10 = Character.toLowerCase(var10);
            var11 = Character.toLowerCase(var11);
            if(var11 != var10) {
               return class139.method3145(var10, var2, (byte)116) - class139.method3145(var11, var2, (byte)123);
            }
         }
      }

      int var17 = Math.min(var4, var5);

      int var18;
      char var21;
      for(var18 = 0; var18 < var17; var18++) {
         char var19 = var0.charAt(var18);
         var21 = var1.charAt(var18);
         if(var21 != var19 && Character.toUpperCase(var19) != Character.toUpperCase(var21)) {
            var19 = Character.toLowerCase(var19);
            var21 = Character.toLowerCase(var21);
            if(var21 != var19) {
               return class139.method3145(var19, var2, (byte)125) - class139.method3145(var21, var2, (byte)124);
            }
         }
      }

      var18 = var4 - var5;
      if(var18 != 0) {
         return var18;
      } else {
         for(int var20 = 0; var20 < var17; var20++) {
            var21 = var0.charAt(var20);
            char var14 = var1.charAt(var20);
            if(var21 != var14) {
               return class139.method3145(var21, var2, (byte)36) - class139.method3145(var14, var2, (byte)87);
            }
         }

         return 0;
      }
   }

   static void method3275(int var0, int var1, int var2, int var3, int var4) {
      Widget var5 = class146.method3191(var0, var1, -1512394607);
      if(var5 != null && var5.objectArray14 != null) {
         ScriptInvocation var6 = new ScriptInvocation();
         var6.field506 = var5;
         var6.parameters = var5.objectArray14;
         class68.method1696(var6);
      }

      GameClient.field737 = var3;
      GameClient.field785 = true;
      class40.field361 = var0;
      GameClient.field736 = var1;
      class63.field932 = var2;
      GameClient.requestRedraw(var5);
   }
}
