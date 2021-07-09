package client;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class class17 {
   public static final int field130 = 85;
   static final int field135 = 46;
   // $FF: synthetic field
   final class30 this$0;
   int field132;
   int field131;
   int field134;
   int field133;

   class17(class30 var1) {
      this.this$0 = var1;
   }

   static String method171(class197 var0, int var1, String var2, short var3) {
      if(var0 == null) {
         return var2;
      } else {
         class195 var4 = (class195)var0.method3945((long)var1);
         return var4 == null ? var2 : (String)var4.field2394;
      }
   }

   public static void method172(Stream var0, int var1, int var2) {
      class312 var3 = new class312();
      var3.field3749 = var0.readUByte();
      var3.field3758 = var0.readInt();
      var3.field3748 = new int[var3.field3749];
      var3.field3751 = new int[var3.field3749];
      var3.field3752 = new Field[var3.field3749];
      var3.field3753 = new int[var3.field3749];
      var3.field3754 = new Method[var3.field3749];
      var3.field3755 = new byte[var3.field3749][][];

      for(int var4 = 0; var4 < var3.field3749; var4++) {
         try {
            int var5 = var0.readUByte();
            String var6;
            String var7;
            int var8;
            if(var5 != 0 && var5 != 1) {
               if(var2 == 569914478) {
                  return;
               }

               if(var5 != 2) {
                  if(var5 != 3) {
                     if(var5 != 4) {
                        continue;
                     }

                     if(var2 == 569914478) {
                        return;
                     }
                  }

                  var6 = var0.readString();
                  var7 = var0.readString();
                  var8 = var0.readUByte();
                  String[] var9 = new String[var8];

                  for(int var10 = 0; var10 < var8; var10++) {
                     if(var2 == 569914478) {
                        return;
                     }

                     var9[var10] = var0.readString();
                  }

                  String var21 = var0.readString();
                  byte[][] var11 = new byte[var8][];
                  int var13;
                  if(var5 == 3) {
                     for(int var12 = 0; var12 < var8; var12++) {
                        var13 = var0.readInt();
                        var11[var12] = new byte[var13];
                        var0.method3539(var11[var12], 0, var13);
                     }
                  }

                  var3.field3748[var4] = var5;
                  Class[] var22 = new Class[var8];

                  for(var13 = 0; var13 < var8; var13++) {
                     if(var2 == 569914478) {
                        return;
                     }

                     var22[var13] = class110.method2528(var9[var13], -283426484);
                  }

                  Class var23 = class110.method2528(var21, -646158438);
                  if(class110.method2528(var6, -1972275872).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var14 = class110.method2528(var6, -618224823).getDeclaredMethods();
                  Method[] var15 = var14;

                  for(int var16 = 0; var16 < var15.length; var16++) {
                     Method var17 = var15[var16];
                     if(var17.getName().equals(var7)) {
                        Class[] var18 = var17.getParameterTypes();
                        if(var18.length == var22.length) {
                           boolean var19 = true;

                           for(int var20 = 0; var20 < var22.length; var20++) {
                              if(var18[var20] != var22[var20]) {
                                 var19 = false;
                                 break;
                              }
                           }

                           if(var19 && var23 == var17.getReturnType()) {
                              if(var2 == 569914478) {
                                 return;
                              }

                              var3.field3754[var4] = var17;
                           }
                        }
                     }
                  }

                  var3.field3755[var4] = var11;
                  continue;
               }
            }

            var6 = var0.readString();
            var7 = var0.readString();
            var8 = 0;
            if(var5 == 1) {
               var8 = var0.readInt();
            }

            var3.field3748[var4] = var5;
            var3.field3753[var4] = var8;
            if(class110.method2528(var6, 471719686).getClassLoader() == null) {
               throw new SecurityException();
            }

            var3.field3752[var4] = class110.method2528(var6, -227592906).getDeclaredField(var7);
         } catch (ClassNotFoundException var25) {
            var3.field3751[var4] = -1;
         } catch (SecurityException var26) {
            var3.field3751[var4] = -2;
         } catch (NullPointerException var27) {
            var3.field3751[var4] = -3;
         } catch (Exception var28) {
            var3.field3751[var4] = -4;
         } catch (Throwable var29) {
            var3.field3751[var4] = -5;
         }
      }

      class313.field3759.method4031(var3);
   }

   public static int method170(int var0, int var1, int var2) {
      return (var0 << 8) + var1;
   }

   static char method169(char var0, int var1, int var2) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338 ? 'O' : (var0 == 339 ? 'o' : (var0 == 376 ? 'Y' : var0));
   }
}
