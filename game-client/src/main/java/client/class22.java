package client;

import java.io.File;
import java.io.IOException;

public class class22 {
   static class82 field185;
   static class249 field183;
   String field186;
   class12 field181;
   int field184;
   int field182;

   class22(String var1, int var2, int var3, class12 var4) {
      this.field186 = var1;
      this.field184 = var2;
      this.field182 = var3;
      this.field181 = var4;
   }

   public static class110 method283(String var0, String var1, boolean var2, int var3) {
      File var4 = new File(class155.field1966, "osspreferences" + var0 + ".dat");
      if(var4.exists()) {
         try {
            class110 var11 = new class110(var4, "rw", 10000L);
            return var11;
         } catch (IOException var10) {
            ;
         }
      }

      String var5 = "";
      if(class141.field1885 == 33) {
         var5 = "_rc";
      } else if(class141.field1885 == 34) {
         var5 = "_wip";
      }

      File var6 = new File(class18.userhomeDirectory, "osscape_" + var1 + "_preferences" + var0 + var5 + ".dat");
      class110 var7;
      if(!var2 && var6.exists()) {
         try {
            var7 = new class110(var6, "rw", 10000L);
            return var7;
         } catch (IOException var9) {
            ;
         }
      }

      try {
         var7 = new class110(var4, "rw", 10000L);
         return var7;
      } catch (IOException var8) {
         throw new RuntimeException();
      }
   }

   static void method280(class249 var0, int var1, int var2, int var3, byte var4, boolean var5, int var6) {
      long var7 = (long)((var1 << 16) + var2);
      class246 var9 = (class246)class250.field3212.get(var7);
      if(var9 != null) {
         if(var6 == -1235545078) {
            ;
         }
      } else {
         var9 = (class246)class250.field3199.get(var7);
         if(var9 == null) {
            var9 = (class246)class250.field3204.get(var7);
            if(var9 != null) {
               if(var6 == -1235545078) {
                  if(var5) {
                     var9.method4101();
                     class250.field3212.method4016(var9, var7);
                     --class250.field3205;
                     ++class250.field3211;
                  }

               }
            } else {
               if(!var5) {
                  var9 = (class246)class250.field3206.get(var7);
                  if(var9 != null) {
                     return;
                  }
               }

               var9 = new class246();
               var9.field3155 = var0;
               var9.field3156 = var3;
               var9.field3157 = var4;
               if(var5) {
                  class250.field3212.method4016(var9, var7);
                  ++class250.field3211;
               } else {
                  class250.field3202.method3910(var9);
                  class250.field3204.method4016(var9, var7);
                  ++class250.field3205;
               }

            }
         }
      }
   }

   static void method281(Widget var0, int var1, int var2, int var3) {
      if(var0.xAlignment == 0) {
         var0.field2618 = var0.x;
      } else if(var0.xAlignment == 1) {
         if(var3 != -1127848526) {
            return;
         }

         var0.field2618 = var0.x + (var1 - var0.int472) / 2;
      } else if(var0.xAlignment == 2) {
         if(var3 != -1127848526) {
            return;
         }

         var0.field2618 = var1 - var0.int472 - var0.x;
      } else if(var0.xAlignment == 3) {
         var0.field2618 = var0.x * var1 >> 14;
      } else if(var0.xAlignment == 4) {
         var0.field2618 = (var1 - var0.int472) / 2 + (var0.x * var1 >> 14);
      } else {
         var0.field2618 = var1 - var0.int472 - (var0.x * var1 >> 14);
      }

      if(var0.yAlignment == 0) {
         var0.int447 = var0.y;
      } else if(var0.yAlignment == 1) {
         var0.int447 = (var2 - var0.int466) / 2 + var0.y;
      } else if(var0.yAlignment == 2) {
         var0.int447 = var2 - var0.int466 - var0.y;
      } else if(var0.yAlignment == 3) {
         var0.int447 = var2 * var0.y >> 14;
      } else if(var0.yAlignment == 4) {
         var0.int447 = (var2 - var0.int466) / 2 + (var2 * var0.y >> 14);
      } else {
         var0.int447 = var2 - var0.int466 - (var2 * var0.y >> 14);
      }

   }

   static void method282(class65[] var0, int var1, int var2, int[] var3, int[] var4, int var5) {
      if(var1 < var2) {
         int var6 = var1 - 1;
         int var7 = var2 + 1;
         int var8 = (var2 + var1) / 2;
         class65 var9 = var0[var8];
         var0[var8] = var0[var1];
         var0[var1] = var9;

         while(var6 < var7) {
            boolean var10 = true;

            int var11;
            int var12;
            int var13;
            do {
               --var7;

               for(var11 = 0; var11 < 4; var11++) {
                  if(var3[var11] == 2) {
                     var12 = var0[var7].field943;
                     var13 = var9.field943;
                  } else if(var3[var11] == 1) {
                     var12 = var0[var7].field955;
                     var13 = var9.field955;
                     if(var12 == -1) {
                        if(var5 >= 2077901199) {
                           return;
                        }

                        if(var4[var11] == 1) {
                           if(var5 >= 2077901199) {
                              return;
                           }

                           var12 = 2001;
                        }
                     }

                     if(var13 == -1) {
                        if(var5 >= 2077901199) {
                           return;
                        }

                        if(var4[var11] == 1) {
                           var13 = 2001;
                        }
                     }
                  } else if(var3[var11] == 3) {
                     var12 = var0[var7].method1589((byte)99) ? 1 : 0;
                     var13 = var9.method1589((byte)50) ? 1 : 0;
                  } else {
                     var12 = var0[var7].field947;
                     var13 = var9.field947;
                  }

                  if(var12 != var13) {
                     if((var4[var11] != 1 || var12 <= var13) && (var4[var11] != 0 || var12 >= var13)) {
                        var10 = false;
                     }
                     break;
                  }

                  if(var11 == 3) {
                     var10 = false;
                  }
               }
            } while(var10);

            var10 = true;

            do {
               ++var6;

               for(var11 = 0; var11 < 4; var11++) {
                  if(var3[var11] == 2) {
                     var12 = var0[var6].field943;
                     var13 = var9.field943;
                  } else if(var3[var11] == 1) {
                     if(var5 >= 2077901199) {
                        return;
                     }

                     var12 = var0[var6].field955;
                     var13 = var9.field955;
                     if(var12 == -1) {
                        if(var5 >= 2077901199) {
                           return;
                        }

                        if(var4[var11] == 1) {
                           var12 = 2001;
                        }
                     }

                     if(var13 == -1 && var4[var11] == 1) {
                        var13 = 2001;
                     }
                  } else if(var3[var11] == 3) {
                     var12 = var0[var6].method1589((byte)71) ? 1 : 0;
                     var13 = var9.method1589((byte)85) ? 1 : 0;
                  } else {
                     var12 = var0[var6].field947;
                     var13 = var9.field947;
                  }

                  if(var13 != var12) {
                     if(var4[var11] == 1) {
                        if(var5 >= 2077901199) {
                           return;
                        }

                        if(var12 < var13) {
                           break;
                        }
                     }

                     if(var4[var11] == 0) {
                        if(var5 >= 2077901199) {
                           return;
                        }

                        if(var12 > var13) {
                           break;
                        }
                     }

                     var10 = false;
                     break;
                  }

                  if(var11 == 3) {
                     var10 = false;
                  }
               }
            } while(var10);

            if(var6 < var7) {
               class65 var14 = var0[var6];
               var0[var6] = var0[var7];
               var0[var7] = var14;
            }
         }

         method282(var0, var1, var7, var3, var4, -1632931905);
         method282(var0, var7 + 1, var2, var3, var4, 1910851898);
      }

   }
}
