package client;

public class class295 {
   public static final class295 field3673 = new class295("VERDANA11", "verdana_11pt_regular");
   public static final class295 field3678 = new class295("PLAIN11", "p11_full");
   public static final class295 field3670 = new class295("VERDANA13", "verdana_13pt_regular");
   public static final class295 field3669 = new class295("VERDANA15", "verdana_15pt_regular");
   public static final class295 field3672 = new class295("PLAIN12", "p12_full");
   public static final class295 field3668 = new class295("BOLD12", "b12_full");
   static int[] field3676;
   static final int field3667 = 0;
   public static final int field3674 = 84;
   static final int field3675 = 5;
   static final int field3677 = 100;
   final String field3671;
   String field3666;

   class295(String var1, String var2) {
      this.field3671 = var1;
      this.field3666 = var2;
   }

   static void method5501(int var0) {
      for(class55 var1 = (class55) GameClient.field741.method4018(); var1 != null; var1 = (class55) GameClient.field741.method4019()) {
         int var2 = var1.field501;
         if(class261.method4931(var2, (byte)-2)) {
            boolean var3 = true;
            Widget[] var4 = Widget.LOADED[var2];

            int var5;
            for(var5 = 0; var5 < var4.length; var5++) {
               if(var4[var5] != null) {
                  var3 = var4[var5].decodeCs2;
                  break;
               }
            }

            if(!var3) {
               var5 = (int)var1.field2421;
               Widget var6 = Widget.getLoaded(var5);
               if(var6 != null) {
                  GameClient.requestRedraw(var6);
               }
            }
         }
      }

   }

   public static class295[] method5498(byte var0) {
      return new class295[]{field3673, field3668, field3678, field3672, field3670, field3669};
   }

   static final void method5502(class63 var0, int var1) {
      var0.field873 = false;
      class273 var2;
      if(var0.field900 != -1) {
         var2 = class3.method25(var0.field900, 758042271);
         if(var2 != null && var2.field3540 != null) {
            ++var0.field902;
            if(var0.field908 < var2.field3540.length && var0.field902 > var2.field3541[var0.field908]) {
               var0.field902 = 1;
               ++var0.field908;
               class173.method3471(var2, var0.field908, var0.field931, var0.field881, 1672351117);
            }

            if(var0.field908 >= var2.field3540.length) {
               var0.field902 = 0;
               var0.field908 = 0;
               class173.method3471(var2, var0.field908, var0.field931, var0.field881, 1287421629);
            }
         } else {
            var0.field900 = -1;
         }
      }

      if(var0.field891 != -1 && GameClient.field591 >= var0.field911) {
         if(var0.field876 < 0) {
            var0.field876 = 0;
         }

         int var4 = class57.method1035(var0.field891, -1295663391).field3271;
         if(var4 != -1) {
            label142: {
               class273 var3 = class3.method25(var4, -334909972);
               if(var3 != null) {
                  if(var1 <= 1198129307) {
                     return;
                  }

                  if(var3.field3540 != null) {
                     ++var0.field910;
                     if(var0.field876 < var3.field3540.length && var0.field910 > var3.field3541[var0.field876]) {
                        var0.field910 = 1;
                        ++var0.field876;
                        class173.method3471(var3, var0.field876, var0.field931, var0.field881, 1468043952);
                     }

                     if(var0.field876 >= var3.field3540.length) {
                        if(var1 <= 1198129307) {
                           return;
                        }

                        if(var0.field876 < 0 || var0.field876 >= var3.field3540.length) {
                           var0.field891 = -1;
                        }
                     }
                     break label142;
                  }
               }

               var0.field891 = -1;
            }
         } else {
            var0.field891 = -1;
         }
      }

      if(var0.field903 != -1 && var0.field906 <= 1) {
         var2 = class3.method25(var0.field903, 52558864);
         if(var2.field3551 == 1 && var0.field930 > 0 && var0.field917 <= GameClient.field591 && var0.field918 < GameClient.field591) {
            var0.field906 = 1;
            return;
         }
      }

      if(var0.field903 != -1 && var0.field906 == 0) {
         if(var1 <= 1198129307) {
            return;
         }

         var2 = class3.method25(var0.field903, 1075716047);
         if(var2 != null && var2.field3540 != null) {
            if(var1 <= 1198129307) {
               return;
            }

            ++var0.field901;
            if(var0.field904 < var2.field3540.length && var0.field901 > var2.field3541[var0.field904]) {
               var0.field901 = 1;
               ++var0.field904;
               class173.method3471(var2, var0.field904, var0.field931, var0.field881, 1177573353);
            }

            if(var0.field904 >= var2.field3540.length) {
               var0.field904 -= var2.field3544;
               ++var0.field907;
               if(var0.field907 >= var2.field3550) {
                  var0.field903 = -1;
               } else if(var0.field904 >= 0 && var0.field904 < var2.field3540.length) {
                  class173.method3471(var2, var0.field904, var0.field931, var0.field881, 1748003804);
               } else {
                  var0.field903 = -1;
               }
            }

            var0.field873 = var2.field3546;
         } else {
            var0.field903 = -1;
         }
      }

      if(var0.field906 > 0) {
         --var0.field906;
      }

   }
}
