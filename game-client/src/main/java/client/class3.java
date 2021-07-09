package client;

import java.util.Comparator;

final class class3 implements Comparator {
   public static final int field24 = 61;
   static final int field25 = 13;
   static final int field26 = 5;
   public static final int field27 = 32;

   int method24(class2 var1, class2 var2, int var3) {
      return var1.field17.field33 < var2.field17.field33 ? -1 : (var2.field17.field33 == var1.field17.field33 ? 0 : 1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method24((class2)var1, (class2)var2, 2100734637);
   }

   public static class273 method25(int var0, int var1) {
      class273 var2 = (class273)class273.field3552.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class273.field3538.method4625(12, var0, 1937111297);
         var2 = new class273();
         if(var3 != null) {
            var2.method5212(new Stream(var3), 243481336);
         }

         var2.method5220(-1055944735);
         class273.field3552.method3983(var2, (long)var0);
         return var2;
      }
   }

   public static void method34(int var0) {
      ObjectDef.field3371.method3984();
      ObjectDef.field3391.method3984();
      ObjectDef.field3370.method3984();
      ObjectDef.field3374.method3984();
   }

   public static int method35(CharSequence var0, int var1) {
      int var2 = var0.length();
      int var3 = 0;

      for(int var4 = 0; var4 < var2; var4++) {
         var3 = (var3 << 5) - var3 + var0.charAt(var4);
      }

      return var3;
   }

   static final void method26(class63 var0, int var1) {
      if(var0.field924 != 0) {
         if(var0.field897 != -1) {
            Object var2 = null;
            if(var0.field897 < 32768) {
               var2 = GameClient.field843[var0.field897];
            } else if(var0.field897 >= 32768) {
               var2 = GameClient.field610[var0.field897 - 32768];
            }

            if(var2 != null) {
               label124: {
                  int var3 = var0.field931 - ((class63)var2).field931;
                  int var4 = var0.field881 - ((class63)var2).field881;
                  if(var3 == 0) {
                     if(var1 >= 1261945265) {
                        return;
                     }

                     if(var4 == 0) {
                        break label124;
                     }
                  }

                  var0.field926 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field898) {
               var0.field897 = -1;
               var0.field898 = false;
            }
         }

         if(var0.field920 != -1 && (var0.field909 == 0 || var0.field923 > 0)) {
            var0.field926 = var0.field920;
            var0.field920 = -1;
         }

         int var5 = var0.field926 - var0.field905 & 2047;
         if(var5 == 0 && var0.field898) {
            var0.field897 = -1;
            var0.field898 = false;
         }

         if(var5 != 0) {
            ++var0.field875;
            boolean var7;
            if(var5 > 1024) {
               var0.field905 -= var0.field924;
               var7 = true;
               if(var5 < var0.field924 || var5 > 2048 - var0.field924) {
                  var0.field905 = var0.field926;
                  var7 = false;
               }

               if(var0.field893 == var0.field900 && (var0.field875 > 25 || var7)) {
                  if(var0.field877 != -1) {
                     var0.field900 = var0.field877;
                  } else {
                     var0.field900 = var0.field899;
                  }
               }
            } else {
               var0.field905 += var0.field924;
               var7 = true;
               if(var5 < var0.field924 || var5 > 2048 - var0.field924) {
                  var0.field905 = var0.field926;
                  var7 = false;
               }

               if(var0.field893 == var0.field900) {
                  if(var1 >= 1261945265) {
                     return;
                  }

                  if(var0.field875 > 25 || var7) {
                     if(var0.field878 != -1) {
                        var0.field900 = var0.field878;
                     } else {
                        var0.field900 = var0.field899;
                     }
                  }
               }
            }

            var0.field905 &= 2047;
         } else {
            var0.field875 = 0;
         }

      }
   }

   public static int method32(int var0, byte var1) {
      return class37.method662(class120.field1647[var0]);
   }
}
