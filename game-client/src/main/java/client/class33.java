package client;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class class33 extends class20 {
   static class156 field294;
   static final int field293 = 2;
   static final int field295 = 4;
   List field290;
   HashSet field292;
   HashSet field291;

   void method551(Stream var1, boolean var2, int var3) {
      this.field290 = new LinkedList();
      int var4 = var1.readUShort();

      for(int var5 = 0; var5 < var4; var5++) {
         if(var3 != -182782257) {
            return;
         }

         int var6 = var1.method3546();
         class226 var7 = new class226(var1.readInt());
         boolean var10000;
         if(var1.readUByte() == 1) {
            if(var3 != -182782257) {
               return;
            }

            var10000 = true;
         } else {
            var10000 = false;
         }

         boolean var8 = var10000;
         if(!var2) {
            if(var8) {
               continue;
            }

            if(var3 != -182782257) {
               return;
            }
         }

         this.field290.add(new class13(var6, var7));
      }

   }

   void method550(Stream var1, Stream var2, Stream var3, int var4, boolean var5, byte var6) {
      this.method200(var1, var4, 1113333872);
      int var7 = var3.readUShort();
      this.field292 = new HashSet(var7);

      int var8;
      for(var8 = 0; var8 < var7; var8++) {
         class10 var9 = new class10();

         try {
            var9.method95(var2, var3, -1858538420);
         } catch (IllegalStateException var14) {
            continue;
         }

         this.field292.add(var9);
      }

      var8 = var3.readUShort();
      this.field291 = new HashSet(var8);

      for(int var12 = 0; var12 < var8; var12++) {
         class34 var10 = new class34();

         try {
            var10.method561(var2, var3, -1293834661);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field291.add(var10);
      }

      this.method551(var2, var5, -182782257);
   }

   static void method559(int resp, int var1) {
      if(resp == -3) {
         class2.method22("Connection timed out.", "Please try using a different world.", "", (byte)127);
      } else if(resp == -2) {
         class2.method22("", "Error connecting to server.", "", (byte)127);
      } else if(resp == -1) {
         if(var1 <= 16776960) {
            return;
         }

         class2.method22("No response from server.", "Please try using a different world.", "", (byte)127);
      } else if(resp == 3) {
         class78.field1081 = 3;
      } else if(resp == 4) {
         if(var1 <= 16776960) {
            return;
         }

         class2.method22("Your account has been disabled.", "Please check your message-centre for details.", "", (byte)127);
      } else if(resp == 5) {
         if(var1 <= 16776960) {
            return;
         }

         class2.method22("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.", (byte)127);
      } else if(resp == 6) {
         class2.method22("RuneScape has been updated!", "Please reload this page.", "", (byte)127);
      } else if(resp == 7) {
         class2.method22("This world is full.", "Please use a different world.", "", (byte)127);
      } else if(resp == 8) {
         class2.method22("Unable to connect.", "Login server offline.", "", (byte)127);
      } else if(resp == 9) {
         class2.method22("Login limit exceeded.", "Too many connections from your address.", "", (byte)127);
      } else if(resp == 10) {
         class2.method22("Unable to connect.", "Account does not exist. Please make sure", "to log in with your username, not email!", (byte)127);
      } else if(resp == 11) {
         class2.method22("We suspect someone knows your password.", "Press \'change your password\' on front page.", "", (byte)127);
      } else if(resp == 12) {
         class2.method22("You need a members account to login to this world.", "Please subscribe, or use a different world.", "", (byte)127);
      } else if(resp == 13) {
         class2.method22("Could not complete login.", "Please try using a different world.", "", (byte)127);
      } else if(resp == 14) {
         class2.method22("The server is being updated.", "Please wait 1 minute and try again.", "", (byte)127);
      } else if(resp == 16) {
         class2.method22("Too many login attempts.", "Please wait a few minutes before trying again.", "", (byte)127);
      } else if(resp == 17) {
         class2.method22("You are standing in a members-only area.", "To play on this world move to a free area first", "", (byte)127);
      } else if(resp == 18) {
         class2.method22("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "", (byte)127);
      } else if(resp == 19) {
         class2.method22("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.", (byte)127);
      } else if(resp == 20) {
         class2.method22("Invalid loginserver requested.", "Please try using a different world.", "", (byte)127);
      } else if(resp == 22) {
         class2.method22("Malformed login packet.", "Please try again.", "", (byte)127);
      } else if(resp == 23) {
         class2.method22("No reply from loginserver.", "Please wait 1 minute and try again.", "", (byte)127);
      } else if(resp == 24) {
         class2.method22("Error loading your profile.", "Please contact customer support.", "", (byte)127);
      } else if(resp == 25) {
         class2.method22("Unexpected loginserver response.", "Please try using a different world.", "", (byte)127);
      } else if(resp == 26) {
         class2.method22("This computers address has been blocked", "as it was used to break our rules.", "", (byte)127);
      } else if(resp == 27) {
         if(var1 <= 16776960) {
            return;
         }

         class2.method22("", "Service unavailable.", "", (byte)127);
      } else if(resp == 31) {
         class2.method22("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.", (byte)127);
      } else if(resp == 32) {
         class2.method22("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.", (byte)127);
      } else if(resp == 37) {
         class2.method22("Your account is currently inaccessible.", "Please try again in a few minutes.", "", (byte)127);
      } else if(resp == 38) {
         if(var1 <= 16776960) {
            return;
         }

         class2.method22("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!", (byte)127);
      } else if(resp == 55) {
         class78.field1081 = 8;
      } else {
         if(resp == 56) {
            class2.method22("Enter the 6-digit code generated by your", "authenticator app.", "", (byte)127);
            class48.method947(11, -990695300);
            return;
         }

         if(resp == 57) {
            if(var1 <= 16776960) {
               return;
            }

            class2.method22("The code you entered was incorrect.", "Please try again.", "", (byte)127);
            class48.method947(11, -677497141);
            return;
         }

         if(resp == 61) {
            class78.field1081 = 7;
         } else {
            class2.method22("Unexpected server response", "Please try using a different world.", "", (byte)127);
         }
      }

      class48.method947(10, -276849611);
   }

   static final boolean method557(byte[] var0, int var1, int var2, int var3) {
      boolean var4 = true;
      Stream var5 = new Stream(var0);
      int var6 = -1;

      label71:
      while(true) {
         int var7 = var5.method3563((byte)11);
         if(var7 == 0) {
            return var4;
         }

         var6 += var7;
         int var8 = 0;
         boolean var9 = false;

         while(true) {
            int var10;
            while(!var9) {
               var10 = var5.readCompact();
               if(var10 == 0) {
                  continue label71;
               }

               var8 += var10 - 1;
               int var11 = var8 & 63;
               int var12 = var8 >> 6 & 63;
               int var13 = var5.readUByte() >> 2;
               int var14 = var12 + var1;
               int var15 = var11 + var2;
               if(var14 > 0 && var15 > 0 && var14 < 103 && var15 < 103) {
                  ObjectDef var16 = class110.getObjectDef(var6);
                  if(var13 != 22 || !GameClient.field585 || var16.int696 != 0 || var16.clipType == 1 || var16.bool73) {
                     if(!var16.method5051(-2013843189)) {
                        ++GameClient.field635;
                        var4 = false;
                     }

                     var9 = true;
                  }
               }
            }

            var10 = var5.readCompact();
            if(var10 == 0) {
               break;
            }

            var5.readUByte();
         }
      }
   }

   static final int method558(int var0, int var1, int var2, int var3) {
      int var4 = 256 - var2;
      return ((var1 & 65280) * var2 + (var0 & 65280) * var4 & 16711680) + ((var1 & 16711935) * var2 + var4 * (var0 & 16711935) & -16711936) >> 8;
   }
}
