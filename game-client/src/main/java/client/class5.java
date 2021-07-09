package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Comparator;

final class class5 implements Comparator {
   int method58(class2 var1, class2 var2, byte var3) {
      return var1.field17.field30 < var2.field17.field30 ? -1 : (var2.field17.field30 == var1.field17.field30 ? 0 : 1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method58((class2)var1, (class2)var2, (byte)43);
   }

   public static void method65(String var0, Throwable var1, byte var2) {
      try {
         String var3 = "";
         if(var1 != null) {
            Throwable var5 = var1;
            String var6;
            if(var1 instanceof class152) {
               if(var2 <= 1) {
                  return;
               }

               class152 var7 = (class152)var1;
               var6 = var7.field1941 + " | ";
               var5 = var7.field1943;
            } else {
               var6 = "";
            }

            StringWriter var19 = new StringWriter();
            PrintWriter var8 = new PrintWriter(var19);
            var5.printStackTrace(var8);
            var8.close();
            String var9 = var19.toString();
            BufferedReader var10 = new BufferedReader(new StringReader(var9));
            String var11 = var10.readLine();

            while(true) {
               String var12 = var10.readLine();
               if(var12 == null) {
                  if(var2 <= 1) {
                     return;
                  }

                  var6 = var6 + "| " + var11;
                  var3 = var6;
                  break;
               }

               int var13 = var12.indexOf(40);
               int var14 = var12.indexOf(41, var13 + 1);
               if(var13 >= 0 && var14 >= 0) {
                  String var15 = var12.substring(var13 + 1, var14);
                  int var16 = var15.indexOf(".java:");
                  if(var16 >= 0) {
                     var15 = var15.substring(0, var16) + var15.substring(var16 + 5);
                     var6 = var6 + var15 + ' ';
                     continue;
                  }

                  var12 = var12.substring(0, var13);
               }

               var12 = var12.trim();
               var12 = var12.substring(var12.lastIndexOf(32) + 1);
               var12 = var12.substring(var12.lastIndexOf(9) + 1);
               var6 = var6 + var12 + ' ';
            }
         }

         if(var0 != null) {
            if(var1 != null) {
               var3 = var3 + " | ";
            }

            var3 = var3 + var0;
         }

         System.out.println("Error: " + var3);
         var3 = var3.replace(':', '.');
         var3 = var3.replace('@', '_');
         var3 = var3.replace('&', '_');
         var3 = var3.replace('#', '_');
         if(class152.field1938 == null) {
            return;
         }

         URL var4 = new URL(class152.field1938.getCodeBase(), "clienterror.ws?c=" + GameCanvas.field362 + "&u=" + class152.field1939 + "&v1=" + class154.field1960 + "&v2=" + class154.field1954 + "&ct=" + class152.field1940 + "&e=" + var3);
         DataInputStream var18 = new DataInputStream(var4.openStream());
         var18.read();
         var18.close();
      } catch (Exception var17) {
         ;
      }

   }

   static int method59(int var0, class84 var1, boolean var2, byte var3) {
      if(var0 == 6500) {
         class69.field999[++class69.field1003 - 1] = class4.method36(1218832541) ? 1 : 0;
         return 1;
      } else {
         class65 var4;
         if(var0 == 6501) {
            class65.field944 = 0;
            var4 = class236.method4592(1530358699);
            if(var4 != null) {
               class69.field999[++class69.field1003 - 1] = var4.field947;
               class69.field999[++class69.field1003 - 1] = var4.field948;
               class69.field1001[++class55.field497 - 1] = var4.field951;
               class69.field999[++class69.field1003 - 1] = var4.field952;
               class69.field999[++class69.field1003 - 1] = var4.field955;
               class69.field1001[++class55.field497 - 1] = var4.field950;
            } else {
               class69.field999[++class69.field1003 - 1] = -1;
               class69.field999[++class69.field1003 - 1] = 0;
               class69.field1001[++class55.field497 - 1] = "";
               class69.field999[++class69.field1003 - 1] = 0;
               class69.field999[++class69.field1003 - 1] = 0;
               class69.field1001[++class55.field497 - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var4 = class236.method4592(-494881098);
            if(var4 != null) {
               class69.field999[++class69.field1003 - 1] = var4.field947;
               class69.field999[++class69.field1003 - 1] = var4.field948;
               class69.field1001[++class55.field497 - 1] = var4.field951;
               class69.field999[++class69.field1003 - 1] = var4.field952;
               class69.field999[++class69.field1003 - 1] = var4.field955;
               class69.field1001[++class55.field497 - 1] = var4.field950;
            } else {
               class69.field999[++class69.field1003 - 1] = -1;
               class69.field999[++class69.field1003 - 1] = 0;
               class69.field1001[++class55.field497 - 1] = "";
               class69.field999[++class69.field1003 - 1] = 0;
               class69.field999[++class69.field1003 - 1] = 0;
               class69.field1001[++class55.field497 - 1] = "";
            }

            return 1;
         } else {
            class65 var5;
            int var6;
            int var12;
            if(var0 == 6506) {
               var12 = class69.field999[--class69.field1003];
               var5 = null;

               for(var6 = 0; var6 < class65.field945; var6++) {
                  if(var12 == class65.field949[var6].field947) {
                     var5 = class65.field949[var6];
                     break;
                  }
               }

               if(var5 != null) {
                  class69.field999[++class69.field1003 - 1] = var5.field947;
                  class69.field999[++class69.field1003 - 1] = var5.field948;
                  class69.field1001[++class55.field497 - 1] = var5.field951;
                  class69.field999[++class69.field1003 - 1] = var5.field952;
                  class69.field999[++class69.field1003 - 1] = var5.field955;
                  class69.field1001[++class55.field497 - 1] = var5.field950;
               } else {
                  class69.field999[++class69.field1003 - 1] = -1;
                  class69.field999[++class69.field1003 - 1] = 0;
                  class69.field1001[++class55.field497 - 1] = "";
                  class69.field999[++class69.field1003 - 1] = 0;
                  class69.field999[++class69.field1003 - 1] = 0;
                  class69.field1001[++class55.field497 - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class69.field1003 -= 4;
               var12 = class69.field999[class69.field1003];
               boolean var16 = class69.field999[class69.field1003 + 1] == 1;
               var6 = class69.field999[class69.field1003 + 2];
               boolean var7 = class69.field999[class69.field1003 + 3] == 1;
               if(class65.field949 != null) {
                  class120.method2781(0, class65.field949.length - 1, var12, var16, var6, var7, (byte)40);
               }

               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  --class69.field1003;
                  GameClient.field725 = class69.field999[class69.field1003] == 1;
                  return 1;
               } else {
                  int var13;
                  class264 var14;
                  if(var0 == 6513) {
                     class69.field1003 -= 2;
                     var12 = class69.field999[class69.field1003];
                     var13 = class69.field999[class69.field1003 + 1];
                     var14 = class241.method4603(var13, (short)-21845);
                     if(var14.method4951(1271827872)) {
                        class69.field1001[++class55.field497 - 1] = class270.loadNpcDef(var12).method5167(var13, var14.field3333, (byte)37);
                     } else {
                        class69.field999[++class69.field1003 - 1] = class270.loadNpcDef(var12).method5166(var13, var14.field3330, 33823014);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class69.field1003 -= 2;
                     var12 = class69.field999[class69.field1003];
                     var13 = class69.field999[class69.field1003 + 1];
                     var14 = class241.method4603(var13, (short)-21845);
                     if(var14.method4951(-2038517607)) {
                        class69.field1001[++class55.field497 - 1] = class110.getObjectDef(var12).method5036(var13, var14.field3333, -1578907603);
                     } else {
                        class69.field999[++class69.field1003 - 1] = class110.getObjectDef(var12).method5035(var13, var14.field3330, (byte)11);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class69.field1003 -= 2;
                     var12 = class69.field999[class69.field1003];
                     var13 = class69.field999[class69.field1003 + 1];
                     var14 = class241.method4603(var13, (short)-21845);
                     if(var14.method4951(249040882)) {
                        class69.field1001[++class55.field497 - 1] = ItemDef.loadItemDef(var12).method5121(var13, var14.field3333, 977767295);
                     } else {
                        class69.field999[++class69.field1003 - 1] = ItemDef.loadItemDef(var12).method5099(var13, var14.field3330, -1055028072);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class69.field1003 -= 2;
                     var12 = class69.field999[class69.field1003];
                     var13 = class69.field999[class69.field1003 + 1];
                     var14 = class241.method4603(var13, (short)-21845);
                     int var8;
                     class265 var9;
                     class265 var10;
                     byte[] var11;
                     if(var14.method4951(2135850036)) {
                        String[] var15 = class69.field1001;
                        var8 = ++class55.field497 - 1;
                        var10 = (class265)class265.field3334.method3989((long)var12);
                        if(var10 != null) {
                           var9 = var10;
                        } else {
                           var11 = class7.field42.method4625(34, var12, 2077872806);
                           var10 = new class265();
                           if(var11 != null) {
                              var10.method4960(new Stream(var11), -1049647297);
                           }

                           var10.method4961((short)-12113);
                           class265.field3334.method3983(var10, (long)var12);
                           var9 = var10;
                        }

                        var15[var8] = var9.method4963(var13, var14.field3333, 1321856430);
                     } else {
                        int[] var17 = class69.field999;
                        var8 = ++class69.field1003 - 1;
                        var10 = (class265)class265.field3334.method3989((long)var12);
                        if(var10 != null) {
                           var9 = var10;
                        } else {
                           var11 = class7.field42.method4625(34, var12, 1992754150);
                           var10 = new class265();
                           if(var11 != null) {
                              var10.method4960(new Stream(var11), -961675251);
                           }

                           var10.method4961((short)-28620);
                           class265.field3334.method3983(var10, (long)var12);
                           var9 = var10;
                        }

                        var17[var8] = var9.method4962(var13, var14.field3330, 1625397785);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class69.field999[++class69.field1003 - 1] = GameClient.field588 ? 1 : 0;
                     return 1;
                  } else if(var0 == 6520) {
                     return 1;
                  } else if(var0 == 6521) {
                     return 1;
                  } else if(var0 == 6522) {
                     --class55.field497;
                     --class69.field1003;
                     return 1;
                  } else if(var0 == 6523) {
                     --class55.field497;
                     --class69.field1003;
                     return 1;
                  } else if(var0 == 6524) {
                     class69.field999[++class69.field1003 - 1] = -1;
                     return 1;
                  } else if(var0 == 6525) {
                     class69.field999[++class69.field1003 - 1] = 1;
                     return 1;
                  } else if(var0 == 6526) {
                     class69.field999[++class69.field1003 - 1] = 1;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var12 = class69.field999[--class69.field1003];
               if(var12 >= 0 && var12 < class65.field945) {
                  var5 = class65.field949[var12];
                  class69.field999[++class69.field1003 - 1] = var5.field947;
                  class69.field999[++class69.field1003 - 1] = var5.field948;
                  class69.field1001[++class55.field497 - 1] = var5.field951;
                  class69.field999[++class69.field1003 - 1] = var5.field952;
                  class69.field999[++class69.field1003 - 1] = var5.field955;
                  class69.field1001[++class55.field497 - 1] = var5.field950;
               } else {
                  class69.field999[++class69.field1003 - 1] = -1;
                  class69.field999[++class69.field1003 - 1] = 0;
                  class69.field1001[++class55.field497 - 1] = "";
                  class69.field999[++class69.field1003 - 1] = 0;
                  class69.field999[++class69.field1003 - 1] = 0;
                  class69.field1001[++class55.field497 - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
