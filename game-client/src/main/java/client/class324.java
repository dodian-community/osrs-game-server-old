package client;

import java.util.Random;

public class class324 extends class204 {
   static final int field3888 = 5;
   static final int field3890 = 2;
   static final int field3893 = 1;
   static final int field3899 = 3;
   static final int field3903 = 6;
   String field3905;
   int field3911;
   int[] field3915 = new int[3];
   String field3914;
   boolean field3892;
   String field3907;
   int field3895;
   int field3896;
   String field3908;
   int field3897;
   String field3913;
   int field3898;
   String field3894;
   int field3900;
   boolean field3891;
   int field3901;
   int field3902;
   int field3906;
   int field3904;
   int field3910;
   int field3909;
   int field3889;
   int field3912;
   int field3916;

   public class324(boolean var1) {
      if(var1) {
         if(class75.field1065.startsWith("win")) {
            this.field3911 = 1;
         } else if(class75.field1065.startsWith("mac")) {
            this.field3911 = 2;
         } else if(class75.field1065.startsWith("linux")) {
            this.field3911 = 3;
         } else {
            this.field3911 = 4;
         }

         String var2;
         try {
            var2 = System.getProperty("os.arch").toLowerCase();
         } catch (Exception var13) {
            var2 = "";
         }

         String var3;
         try {
            var3 = System.getProperty("os.version").toLowerCase();
         } catch (Exception var12) {
            var3 = "";
         }

         String var4 = "Unknown";
         String var5 = "1.1";

         try {
            var4 = System.getProperty("java.vendor");
            var5 = System.getProperty("java.version");
         } catch (Exception var11) {
            ;
         }

         if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
            this.field3892 = false;
         } else {
            this.field3892 = true;
         }

         if(this.field3911 == 1) {
            if(var3.indexOf("4.0") != -1) {
               this.field3895 = 1;
            } else if(var3.indexOf("4.1") != -1) {
               this.field3895 = 2;
            } else if(var3.indexOf("4.9") != -1) {
               this.field3895 = 3;
            } else if(var3.indexOf("5.0") != -1) {
               this.field3895 = 4;
            } else if(var3.indexOf("5.1") != -1) {
               this.field3895 = 5;
            } else if(var3.indexOf("5.2") != -1) {
               this.field3895 = 8;
            } else if(var3.indexOf("6.0") != -1) {
               this.field3895 = 6;
            } else if(var3.indexOf("6.1") != -1) {
               this.field3895 = 7;
            } else if(var3.indexOf("6.2") != -1) {
               this.field3895 = 9;
            } else if(var3.indexOf("6.3") != -1) {
               this.field3895 = 10;
            } else if(var3.indexOf("10.0") != -1) {
               this.field3895 = 11;
            }
         } else if(this.field3911 == 2) {
            if(var3.indexOf("10.4") != -1) {
               this.field3895 = 20;
            } else if(var3.indexOf("10.5") != -1) {
               this.field3895 = 21;
            } else if(var3.indexOf("10.6") != -1) {
               this.field3895 = 22;
            } else if(var3.indexOf("10.7") != -1) {
               this.field3895 = 23;
            } else if(var3.indexOf("10.8") != -1) {
               this.field3895 = 24;
            } else if(var3.indexOf("10.9") != -1) {
               this.field3895 = 25;
            } else if(var3.indexOf("10.10") != -1) {
               this.field3895 = 26;
            } else if(var3.indexOf("10.11") != -1) {
               this.field3895 = 27;
            }
         }

         if(var4.toLowerCase().indexOf("sun") != -1) {
            this.field3896 = 1;
         } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
            this.field3896 = 2;
         } else if(var4.toLowerCase().indexOf("apple") != -1) {
            this.field3896 = 3;
         } else if(var4.toLowerCase().indexOf("oracle") != -1) {
            this.field3896 = 5;
         } else {
            this.field3896 = 4;
         }

         int var9 = 2;
         int var7 = 0;

         char var8;
         try {
            while(var9 < var5.length()) {
               var8 = var5.charAt(var9);
               if(var8 < 48 || var8 > 57) {
                  break;
               }

               var7 = var7 * 10 + (var8 - 48);
               ++var9;
            }
         } catch (Exception var16) {
            ;
         }

         this.field3897 = var7;
         var9 = var5.indexOf(46, 2) + 1;
         var7 = 0;

         try {
            while(var9 < var5.length()) {
               var8 = var5.charAt(var9);
               if(var8 < 48 || var8 > 57) {
                  break;
               }

               var7 = var7 * 10 + (var8 - 48);
               ++var9;
            }
         } catch (Exception var15) {
            ;
         }

         this.field3898 = var7;
         var9 = var5.indexOf(95, 4) + 1;
         var7 = 0;

         try {
            while(var9 < var5.length()) {
               var8 = var5.charAt(var9);
               if(var8 < 48 || var8 > 57) {
                  break;
               }

               var7 = var7 * 10 + (var8 - 48);
               ++var9;
            }
         } catch (Exception var14) {
            ;
         }

         this.field3900 = var7;
         this.field3891 = false;
         Runtime.getRuntime();
         this.field3901 = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
         if(this.field3897 > 3) {
            this.field3902 = Runtime.getRuntime().availableProcessors();
         } else {
            this.field3902 = 0;
         }

         this.field3906 = 0;
      }

      if(this.field3905 == null) {
         this.field3905 = "";
      }

      if(this.field3914 == null) {
         this.field3914 = "";
      }

      if(this.field3907 == null) {
         this.field3907 = "";
      }

      if(this.field3908 == null) {
         this.field3908 = "";
      }

      if(this.field3913 == null) {
         this.field3913 = "";
      }

      if(this.field3894 == null) {
         this.field3894 = "";
      }

      this.method6211(-5446469);
   }

   void method6211(int var1) {
      if(this.field3905.length() > 40) {
         if(var1 != -5446469) {
            return;
         }

         this.field3905 = this.field3905.substring(0, 40);
      }

      if(this.field3914.length() > 40) {
         this.field3914 = this.field3914.substring(0, 40);
      }

      if(this.field3907.length() > 10) {
         this.field3907 = this.field3907.substring(0, 10);
      }

      if(this.field3908.length() > 10) {
         this.field3908 = this.field3908.substring(0, 10);
      }

   }

   public int method6215(int var1) {
      byte var2 = 38;
      String var5 = this.field3905;
      int var4 = var5.length() + 2;
      int var21 = var4 + var2;
      String var8 = this.field3914;
      int var7 = var8.length() + 2;
      var21 += var7;
      String var11 = this.field3907;
      int var10 = var11.length() + 2;
      var21 += var10;
      String var14 = this.field3908;
      int var13 = var14.length() + 2;
      var21 += var13;
      String var17 = this.field3913;
      int var16 = var17.length() + 2;
      var21 += var16;
      String var20 = this.field3894;
      int var19 = var20.length() + 2;
      var21 += var19;
      return var21;
   }

   public void method6217(Stream var1, short var2) {
      var1.writeByte(6);
      var1.writeByte(this.field3911);
      var1.writeByte(this.field3892 ? 1 : 0);
      var1.writeByte(this.field3895);
      var1.writeByte(this.field3896);
      var1.writeByte(this.field3897);
      var1.writeByte(this.field3898);
      var1.writeByte(this.field3900);
      var1.writeByte(this.field3891 ? 1 : 0);
      var1.writeShort(this.field3901);
      var1.writeByte(this.field3902);
      var1.method3534(this.field3906, -2089748922);
      var1.writeShort(this.field3904);
      var1.method3540(this.field3905, -1348251192);
      var1.method3540(this.field3914, -1837914226);
      var1.method3540(this.field3907, -831875429);
      var1.method3540(this.field3908, -1164937550);
      var1.writeByte(this.field3910);
      var1.writeShort(this.field3909);
      var1.method3540(this.field3913, -783658014);
      var1.method3540(this.field3894, -1970717175);
      var1.writeByte(this.field3889);
      var1.writeByte(this.field3912);

      for(int var3 = 0; var3 < this.field3915.length; var3++) {
         var1.writeInt(this.field3915[var3]);
      }

      var1.writeInt(this.field3916);
   }
}
