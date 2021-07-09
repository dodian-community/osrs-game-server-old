package client;

public class class304 {
   public static char[] field3722 = new char[64];
   static char[] field3723;
   static int[] field3724;

   static {
      int var0;
      for(var0 = 0; var0 < 26; var0++) {
         field3722[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; var0++) {
         field3722[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; var0++) {
         field3722[var0] = (char)(var0 + 48 - 52);
      }

      field3722[62] = 43;
      field3722[63] = 47;
      field3723 = new char[64];

      for(var0 = 0; var0 < 26; var0++) {
         field3723[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; var0++) {
         field3723[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; var0++) {
         field3723[var0] = (char)(var0 + 48 - 52);
      }

      field3723[62] = 42;
      field3723[63] = 45;
      field3724 = new int[128];

      for(var0 = 0; var0 < field3724.length; var0++) {
         field3724[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; var0++) {
         field3724[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; var0++) {
         field3724[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; var0++) {
         field3724[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3724;
      field3724[43] = 62;
      var2[42] = 62;
      int[] var1 = field3724;
      field3724[47] = 63;
      var1[45] = 63;
   }

   static void method5635(Widget[] var0, int var1, int var2, int var3, boolean var4, byte var5) {
      for(int var6 = 0; var6 < var0.length; var6++) {
         Widget var7 = var0[var6];
         if(var7 != null && var7.parentHash == var1) {
            class64.method1563(var7, var2, var3, var4, -1925351828);
            class22.method281(var7, var2, var3, -1127848526);
            if(var7.field2626 > var7.scrollWidth - var7.int472) {
               if(var5 >= 7) {
                  return;
               }

               var7.field2626 = var7.scrollWidth - var7.int472;
            }

            if(var7.field2626 < 0) {
               if(var5 >= 7) {
                  return;
               }

               var7.field2626 = 0;
            }

            if(var7.scrollY > var7.scrollHeight - var7.int466) {
               var7.scrollY = var7.scrollHeight - var7.int466;
            }

            if(var7.scrollY < 0) {
               var7.scrollY = 0;
            }

            if(var7.widgetType == 0) {
               if(var5 >= 7) {
                  return;
               }

               class163.method3388(var0, var7, var4, 552523381);
            }
         }
      }

   }

   public static String method5634(CharSequence var0, short var1) {
      int var2 = var0.length();
      StringBuilder var3 = new StringBuilder(var2);

      for(int var4 = 0; var4 < var2; var4++) {
         char var5 = var0.charAt(var4);
         if((var5 < 97 || var5 > 122) && (var5 < 65 || var5 > 90) && (var5 < 48 || var5 > 57) && var5 != 46 && var5 != 45 && var5 != 42 && var5 != 95) {
            if(var5 == 32) {
               var3.append('+');
            } else {
               byte var6 = class166.method3441(var5, -681685247);
               var3.append('%');
               int var7 = var6 >> 4 & 15;
               if(var7 >= 10) {
                  var3.append((char)(var7 + 55));
               } else {
                  var3.append((char)(var7 + 48));
               }

               var7 = var6 & 15;
               if(var7 >= 10) {
                  var3.append((char)(var7 + 55));
               } else {
                  var3.append((char)(var7 + 48));
               }
            }
         } else {
            var3.append(var5);
         }
      }

      return var3.toString();
   }
}
