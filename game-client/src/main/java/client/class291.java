package client;

public class class291 implements Comparable {
   static final int field3641 = 23;
   public static final int field3643 = 2;
   String field3644;
   String field3642;

   public class291(String var1, class322 var2) {
      this.field3644 = var1;
      String var4;
      if(var1 == null) {
         var4 = null;
      } else {
         int var5 = 0;

         int var6;
         boolean var7;
         char var8;
         for(var6 = var1.length(); var5 < var6; var5++) {
            var8 = var1.charAt(var5);
            var7 = var8 == 160 || var8 == 32 || var8 == 95 || var8 == 45;
            if(!var7) {
               break;
            }
         }

         while(var6 > var5) {
            var8 = var1.charAt(var6 - 1);
            var7 = var8 == 160 || var8 == 32 || var8 == 95 || var8 == 45;
            if(!var7) {
               break;
            }

            --var6;
         }

         int var17 = var6 - var5;
         if(var17 >= 1 && var17 <= class8.method84(var2, (byte)28)) {
            StringBuilder var15 = new StringBuilder(var17);

            for(int var9 = var5; var9 < var6; var9++) {
               char var10 = var1.charAt(var9);
               boolean var11;
               if(Character.isISOControl(var10)) {
                  var11 = false;
               } else if(class161.method3362(var10, 1286925984)) {
                  var11 = true;
               } else {
                  char[] var16 = class302.field3719;
                  int var13 = 0;

                  label79:
                  while(true) {
                     char var14;
                     if(var13 >= var16.length) {
                        var16 = class302.field3717;

                        for(var13 = 0; var13 < var16.length; var13++) {
                           var14 = var16[var13];
                           if(var14 == var10) {
                              var11 = true;
                              break label79;
                           }
                        }

                        var11 = false;
                        break;
                     }

                     var14 = var16[var13];
                     if(var14 == var10) {
                        var11 = true;
                        break;
                     }

                     ++var13;
                  }
               }

               if(var11) {
                  char var12 = class250.method4770(var10, -365895890);
                  if(var12 != 0) {
                     var15.append(var12);
                  }
               }
            }

            if(var15.length() == 0) {
               var4 = null;
            } else {
               var4 = var15.toString();
            }
         } else {
            var4 = null;
         }
      }

      this.field3642 = var4;
   }

   public int method5435(class291 var1, int var2) {
      return this.field3642 == null ? (var1.field3642 == null ? 0 : 1) : (var1.field3642 == null ? -1 : this.field3642.compareTo(var1.field3642));
   }

   public String method5447(byte var1) {
      return this.field3644;
   }

   public boolean method5441(int var1) {
      return this.field3642 != null;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class291) {
         class291 var2 = (class291)var1;
         return this.field3642 == null ? var2.field3642 == null : (var2.field3642 == null ? false : (this.hashCode() != var2.hashCode() ? false : this.field3642.equals(var2.field3642)));
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.field3642 == null ? 0 : this.field3642.hashCode();
   }

   public String toString() {
      return this.method5447((byte)-39);
   }

   public int compareTo(Object var1) {
      return this.method5435((class291)var1, 915724174);
   }

   static char method5450(char var0, byte var1) {
      return var0 != 181 && var0 != 131 ? Character.toTitleCase(var0) : var0;
   }
}
