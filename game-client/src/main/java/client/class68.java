package client;

public final class class68 extends class204 {
   static class205 field985 = new class205();
   static int field996;
   static final int field995 = 19137016;
   int field987;
   ObjectDef field994;
   int field991;
   int field989;
   int field982;
   int[] field986;
   class103 field993;
   int field984;
   int field988;
   int field992;
   int field983;
   int field981;
   class103 field980;
   int field990;

   void method1688(byte var1) {
      int var2 = this.field987;
      ObjectDef var3 = this.field994.method5056();
      if(var3 != null) {
         this.field987 = var3.int709;
         this.field991 = var3.int710 * 128;
         this.field989 = var3.int711;
         this.field982 = var3.int712;
         this.field986 = var3.intArray114;
      } else {
         this.field987 = -1;
         this.field991 = 0;
         this.field989 = 0;
         this.field982 = 0;
         this.field986 = null;
      }

      if(var2 != this.field987 && this.field993 != null) {
         class36.field310.method2009(this.field993);
         this.field993 = null;
      }

   }

   public static int method1693(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var4 = false;
         boolean var5 = false;
         int var6 = 0;
         int var7 = var0.length();

         for(int var8 = 0; var8 < var7; var8++) {
            char var9 = var0.charAt(var8);
            if(var8 == 0) {
               if(var9 == 45) {
                  var4 = true;
                  continue;
               }

               if(var9 == 43 && var2) {
                  continue;
               }
            }

            int var11;
            if(var9 >= 48 && var9 <= 57) {
               var11 = var9 - 48;
            } else if(var9 >= 65 && var9 <= 90) {
               var11 = var9 - 55;
            } else {
               if(var9 < 97 || var9 > 122) {
                  throw new NumberFormatException();
               }

               var11 = var9 - 87;
            }

            if(var11 >= var1) {
               throw new NumberFormatException();
            }

            if(var4) {
               var11 = -var11;
            }

            int var10 = var11 + var6 * var1;
            if(var10 / var1 != var6) {
               throw new NumberFormatException();
            }

            var6 = var10;
            var5 = true;
         }

         if(!var5) {
            throw new NumberFormatException();
         } else {
            return var6;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   public static void method1696(ScriptInvocation var0) {
      class309.method5674(var0, 500000, 1199859581);
   }

   public static void method1698(int var0) {
      Widget.field2599.method3984();
      Widget.field2600.method3984();
      Widget.field2601.method3984();
      Widget.field2602.method3984();
   }

   public static final void method1697(int var0, boolean var1, int var2, int var3) {
      if(var0 >= 8000 && var0 <= 48000) {
         class95.field1300 = var0;
         class95.field1295 = var1;
         class27.field230 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
