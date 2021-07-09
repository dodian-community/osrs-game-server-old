package client;

import java.util.Date;

public class class57 implements Runnable {
   static int mapBaseX;
   static final int field527 = 20;
   static final int field528 = -117;
   boolean field529 = true;
   Object field523 = new Object();
   int field522 = 0;
   int[] field525 = new int[500];
   int[] field526 = new int[500];

   public void run() {
      for(; this.field529; class63.method1539(50L)) {
         Object var1 = this.field523;
         synchronized(this.field523) {
            if(this.field522 < 500) {
               this.field525[this.field522] = class48.field425;
               this.field526[this.field522] = class48.field426 * 673804999;
               ++this.field522;
            }
         }
      }

   }

   public static class258 method1035(int var0, int var1) {
      class258 var2 = (class258)class258.field3267.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class258.field3272.method4625(13, var0, 933511582);
         var2 = new class258();
         var2.field3280 = var0;
         if(var3 != null) {
            var2.method4864(new Stream(var3), 713149858);
         }

         class258.field3267.method3983(var2, (long)var0);
         return var2;
      }
   }

   public static void method1036(byte var0) {
      ItemDef.field3461.method3984();
      ItemDef.field3428.method3984();
      ItemDef.field3429.method3984();
   }

   static int method1034(int var0, class84 var1, boolean var2, int var3) {
      String var4;
      int var5;
      if(var0 == 4100) {
         var4 = class69.field1001[--class55.field497];
         var5 = class69.field999[--class69.field1003];
         class69.field1001[++class55.field497 - 1] = var4 + var5;
         return 1;
      } else {
         String var28;
         if(var0 == 4101) {
            class55.field497 -= 2;
            var4 = class69.field1001[class55.field497];
            var28 = class69.field1001[class55.field497 + 1];
            class69.field1001[++class55.field497 - 1] = var4 + var28;
            return 1;
         } else {
            int var27;
            if(var0 == 4102) {
               var4 = class69.field1001[--class55.field497];
               var5 = class69.field999[--class69.field1003];
               String[] var6 = class69.field1001;
               var27 = ++class55.field497 - 1;
               String var9;
               if(var5 < 0) {
                  var9 = Integer.toString(var5);
               } else {
                  int var11 = var5;
                  String var10;
                  if(var5 < 0) {
                     var10 = Integer.toString(var5, 10);
                  } else {
                     int var12 = 2;

                     for(int var13 = var5 / 10; var13 != 0; var12++) {
                        var13 /= 10;
                     }

                     char[] var14 = new char[var12];
                     var14[0] = 43;

                     for(int var15 = var12 - 1; var15 > 0; --var15) {
                        int var16 = var11;
                        var11 /= 10;
                        int var17 = var16 - var11 * 10;
                        if(var17 >= 10) {
                           var14[var15] = (char)(var17 + 87);
                        } else {
                           var14[var15] = (char)(var17 + 48);
                        }
                     }

                     var10 = new String(var14);
                  }

                  var9 = var10;
               }

               var6[var27] = var4 + var9;
               return 1;
            } else if(var0 == 4103) {
               var4 = class69.field1001[--class55.field497];
               class69.field1001[++class55.field497 - 1] = var4.toLowerCase();
               return 1;
            } else {
               int var19;
               if(var0 == 4104) {
                  var19 = class69.field999[--class69.field1003];
                  long var20 = 86400000L * ((long)var19 + 11745L);
                  class69.field1007.setTime(new Date(var20));
                  var27 = class69.field1007.get(5);
                  int var30 = class69.field1007.get(2);
                  int var23 = class69.field1007.get(1);
                  class69.field1001[++class55.field497 - 1] = var27 + "-" + class69.field998[var30] + "-" + var23;
                  return 1;
               } else if(var0 == 4105) {
                  class55.field497 -= 2;
                  var4 = class69.field1001[class55.field497];
                  var28 = class69.field1001[class55.field497 + 1];
                  if(class138.field1876.field546 != null && class138.field1876.field546.field2571) {
                     class69.field1001[++class55.field497 - 1] = var28;
                  } else {
                     class69.field1001[++class55.field497 - 1] = var4;
                  }

                  return 1;
               } else if(var0 == 4106) {
                  var19 = class69.field999[--class69.field1003];
                  class69.field1001[++class55.field497 - 1] = Integer.toString(var19);
                  return 1;
               } else if(var0 == 4107) {
                  class55.field497 -= 2;
                  int[] var26 = class69.field999;
                  var5 = ++class69.field1003 - 1;
                  var27 = class155.method3269(class69.field1001[class55.field497], class69.field1001[class55.field497 + 1], GameClient.field827, 75346420);
                  byte var32;
                  if(var27 > 0) {
                     var32 = 1;
                  } else if(var27 < 0) {
                     var32 = -1;
                  } else {
                     var32 = 0;
                  }

                  var26[var5] = var32;
                  return 1;
               } else {
                  class298 var8;
                  int var24;
                  byte[] var25;
                  if(var0 == 4108) {
                     var4 = class69.field1001[--class55.field497];
                     class69.field1003 -= 2;
                     var5 = class69.field999[class69.field1003];
                     var24 = class69.field999[class69.field1003 + 1];
                     var25 = class50.field461.method4625(var24, 0, -7075967);
                     var8 = new class298(var25);
                     class69.field999[++class69.field1003 - 1] = var8.method5520(var4, var5);
                     return 1;
                  } else if(var0 == 4109) {
                     var4 = class69.field1001[--class55.field497];
                     class69.field1003 -= 2;
                     var5 = class69.field999[class69.field1003];
                     var24 = class69.field999[class69.field1003 + 1];
                     var25 = class50.field461.method4625(var24, 0, 2018278562);
                     var8 = new class298(var25);
                     class69.field999[++class69.field1003 - 1] = var8.method5519(var4, var5);
                     return 1;
                  } else if(var0 == 4110) {
                     class55.field497 -= 2;
                     var4 = class69.field1001[class55.field497];
                     var28 = class69.field1001[class55.field497 + 1];
                     --class69.field1003;
                     if(class69.field999[class69.field1003] == 1) {
                        class69.field1001[++class55.field497 - 1] = var4;
                     } else {
                        class69.field1001[++class55.field497 - 1] = var28;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var4 = class69.field1001[--class55.field497];
                     class69.field1001[++class55.field497 - 1] = class299.method5521(var4);
                     return 1;
                  } else if(var0 == 4112) {
                     var4 = class69.field1001[--class55.field497];
                     var5 = class69.field999[--class69.field1003];
                     class69.field1001[++class55.field497 - 1] = var4 + (char)var5;
                     return 1;
                  } else if(var0 == 4113) {
                     var19 = class69.field999[--class69.field1003];
                     class69.field999[++class69.field1003 - 1] = class52.method1002((char)var19, 1142628793) ? 1 : 0;
                     return 1;
                  } else if(var0 == 4114) {
                     var19 = class69.field999[--class69.field1003];
                     class69.field999[++class69.field1003 - 1] = class161.method3362((char)var19, -398482613) ? 1 : 0;
                     return 1;
                  } else {
                     boolean var7;
                     int[] var18;
                     char var22;
                     if(var0 == 4115) {
                        var19 = class69.field999[--class69.field1003];
                        var18 = class69.field999;
                        var24 = ++class69.field1003 - 1;
                        var22 = (char)var19;
                        var7 = var22 >= 65 && var22 <= 90 || var22 >= 97 && var22 <= 122;
                        var18[var24] = var7 ? 1 : 0;
                        return 1;
                     } else if(var0 != 4116) {
                        if(var0 == 4117) {
                           var4 = class69.field1001[--class55.field497];
                           if(var4 != null) {
                              class69.field999[++class69.field1003 - 1] = var4.length();
                           } else {
                              class69.field999[++class69.field1003 - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var4 = class69.field1001[--class55.field497];
                           class69.field1003 -= 2;
                           var5 = class69.field999[class69.field1003];
                           var24 = class69.field999[class69.field1003 + 1];
                           class69.field1001[++class55.field497 - 1] = var4.substring(var5, var24);
                           return 1;
                        } else if(var0 == 4119) {
                           var4 = class69.field1001[--class55.field497];
                           StringBuilder var29 = new StringBuilder(var4.length());
                           boolean var31 = false;

                           for(var27 = 0; var27 < var4.length(); var27++) {
                              var22 = var4.charAt(var27);
                              if(var22 == 60) {
                                 var31 = true;
                              } else if(var22 == 62) {
                                 var31 = false;
                              } else if(!var31) {
                                 var29.append(var22);
                              }
                           }

                           class69.field1001[++class55.field497 - 1] = var29.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var4 = class69.field1001[--class55.field497];
                           var5 = class69.field999[--class69.field1003];
                           class69.field999[++class69.field1003 - 1] = var4.indexOf(var5);
                           return 1;
                        } else if(var0 == 4121) {
                           class55.field497 -= 2;
                           var4 = class69.field1001[class55.field497];
                           var28 = class69.field1001[class55.field497 + 1];
                           var24 = class69.field999[--class69.field1003];
                           class69.field999[++class69.field1003 - 1] = var4.indexOf(var28, var24);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var19 = class69.field999[--class69.field1003];
                        var18 = class69.field999;
                        var24 = ++class69.field1003 - 1;
                        var22 = (char)var19;
                        var7 = var22 >= 48 && var22 <= 57;
                        var18[var24] = var7 ? 1 : 0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }
}
