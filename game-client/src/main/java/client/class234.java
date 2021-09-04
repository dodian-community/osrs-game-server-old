package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class class234 {
   public static final boolean[] field2780 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   public static int[] field2779 = new int[99];
   public static final int field2781 = 25;
   static final int field2782 = 9;

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; var1++) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2779[var1] = var0 / 4;
      }

   }

   static void method4590(int var0) {
      class78.typedUsername = class78.typedUsername.trim();
      if(class78.typedUsername.length() == 0) {
         if(var0 > 1032301680) {
            class2.method22("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.", (byte)127);
         }
      } else {
         long var2 = GameClient.method1535(-1512027623);
         byte var1;
         if(var2 == 0L) {
            var1 = 5;
         } else {
            String var5 = class78.typedUsername;
            Random var6 = new Random();
            Stream var7 = new Stream(128);
            Stream var8 = new Stream(128);
            int[] var9 = new int[]{var6.nextInt(), var6.nextInt(), (int)(var2 >> 32), (int)var2};
            var7.writeByte(10);

            int var10;
            for(var10 = 0; var10 < 4; var10++) {
               var7.writeInt(var6.nextInt());
            }

            var7.writeInt(var9[0]);
            var7.writeInt(var9[1]);
            var7.method3659(var2);
            var7.method3659(0L);

            for(var10 = 0; var10 < 4; var10++) {
               var7.writeInt(var6.nextInt());
            }

            var7.method3571(class73.field1039, class73.field1044);
            var8.writeByte(10);

            for(var10 = 0; var10 < 3; var10++) {
               var8.writeInt(var6.nextInt());
            }

            var8.method3659(var6.nextLong());
            var8.method3584(var6.nextLong());
            if(GameClient.field620 != null) {
               var8.writeBytes(GameClient.field620, 0, GameClient.field620.length);
            } else {
               byte[] var11 = new byte[24];

               try {
                  class155.field1968.method2476(0L);
                  class155.field1968.method2478(var11, 1096866328);

                  int var12;
                  for(var12 = 0; var12 < 24 && var11[var12] == 0; var12++) {
                     ;
                  }

                  if(var12 >= 24) {
                     if(var0 <= 1032301680) {
                        return;
                     }

                     throw new IOException();
                  }
               } catch (Exception var32) {
                  for(int var13 = 0; var13 < 24; var13++) {
                     var11[var13] = -1;
                  }
               }

               var8.writeBytes(var11, 0, var11.length);
            }

            var8.method3659(var6.nextLong());
            var8.method3571(class73.field1039, class73.field1044);
            var10 = class316.method5820(var5, (short)256);
            if(var10 % 8 != 0) {
               if(var0 <= 1032301680) {
                  return;
               }

               var10 += 8 - var10 % 8;
            }

            Stream var33 = new Stream(var10);
            var33.writeString(var5, -1071864511);
            var33.field2339 = var10;
            var33.method3567(var9, 1224350853);
            Stream var23 = new Stream(var8.field2339 + var7.field2339 + var33.field2339 + 5);
            var23.writeByte(2);
            var23.writeByte(var7.field2339);
            var23.writeBytes(var7.field2338, 0, var7.field2339);
            var23.writeByte(var8.field2339);
            var23.writeBytes(var8.field2338, 0, var8.field2339);
            var23.writeShort(var33.field2339);
            var23.writeBytes(var33.field2338, 0, var33.field2339);
            byte[] var14 = var23.field2338;
            int var16 = var14.length;
            StringBuilder var17 = new StringBuilder();

            int var20;
            for(int var18 = 0; var18 < var16 + 0; var18 += 3) {
               int var19 = var14[var18] & 255;
               var17.append(class304.field3722[var19 >>> 2]);
               if(var18 < var16 - 1) {
                  var20 = var14[var18 + 1] & 255;
                  var17.append(class304.field3722[(var19 & 3) << 4 | var20 >>> 4]);
                  if(var18 < var16 - 2) {
                     int var21 = var14[var18 + 2] & 255;
                     var17.append(class304.field3722[(var20 & 15) << 2 | var21 >>> 6]).append(class304.field3722[var21 & 63]);
                  } else {
                     var17.append(class304.field3722[(var20 & 15) << 2]).append("=");
                  }
               } else {
                  var17.append(class304.field3722[(var19 & 3) << 4]).append("==");
               }
            }

            String var15 = var17.toString();
            var15 = var15;

            byte var4;
            try {
               URL var26 = new URL(class142.method3161("services", false, (byte)20) + "m=accountappeal/login.ws");
               URLConnection var34 = var26.openConnection();
               var34.setDoInput(true);
               var34.setDoOutput(true);
               var34.setConnectTimeout(5000);
               OutputStreamWriter var27 = new OutputStreamWriter(var34.getOutputStream());
               var27.write("data2=" + class304.method5634(var15, (short)-7958) + "&dest=" + class304.method5634("passwordchoice.ws", (short)-23165));
               var27.flush();
               InputStream var28 = var34.getInputStream();
               var23 = new Stream(new byte[1000]);

               while(true) {
                  var20 = var28.read(var23.field2338, var23.field2339, 1000 - var23.field2339);
                  if(var20 == -1) {
                     var27.close();
                     var28.close();
                     String var29 = new String(var23.field2338);
                     if(var29.startsWith("OFFLINE")) {
                        var4 = 4;
                     } else if(var29.startsWith("WRONG")) {
                        var4 = 7;
                     } else if(var29.startsWith("RELOAD")) {
                        var4 = 3;
                     } else if(var29.startsWith("Not permitted for social network accounts.")) {
                        var4 = 6;
                     } else {
                        var23.method3553(var9, 2094043910);

                        while(var23.field2339 > 0) {
                           if(var0 <= 1032301680) {
                              return;
                           }

                           if(var23.field2338[var23.field2339 - 1] != 0) {
                              break;
                           }

                           --var23.field2339;
                        }

                        var29 = new String(var23.field2338, 0, var23.field2339);
                        boolean var35;
                        if(var29 == null) {
                           var35 = false;
                        } else {
                           label149: {
                              try {
                                 new URL(var29);
                              } catch (MalformedURLException var30) {
                                 var35 = false;
                                 break label149;
                              }

                              var35 = true;
                           }
                        }

                        if(var35) {
                           class270.method5156(var29, true, false, -619535149);
                           var4 = 2;
                        } else {
                           var4 = 5;
                        }
                     }
                     break;
                  }

                  var23.field2339 += var20;
                  if(var23.field2339 >= 1000) {
                     var4 = 5;
                     break;
                  }
               }
            } catch (Throwable var31) {
               var31.printStackTrace();
               var4 = 5;
            }

            var1 = var4;
         }

         switch(var1) {
         case 2:
            class2.method22(class237.field3049, class237.field3050, class237.field3072, (byte)127);
            class78.field1081 = 6;
            break;
         case 3:
            class2.method22("", "Error connecting to server.", "", (byte)127);
            break;
         case 4:
            class2.method22("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.", (byte)127);
            break;
         case 5:
            class2.method22("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.", (byte)127);
            break;
         case 6:
            class2.method22("", "Error connecting to server.", "", (byte)127);
            break;
         case 7:
            class2.method22("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.", (byte)127);
         }

      }
   }
}
