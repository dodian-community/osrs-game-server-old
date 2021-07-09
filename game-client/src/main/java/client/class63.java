package client;

public abstract class class63 extends class127 {
   static class95 field879;
   static class298 field933;
   static int field932;
   int field909 = 0;
   int field903 = -1;
   int[] field922 = new int[10];
   int[] field895 = new int[4];
   boolean field873 = false;
   int field920 = -1;
   int field930 = 0;
   int[] field872 = new int[10];
   int field923 = 0;
   int field900 = -1;
   int field906 = 0;
   class203 field896 = new class203();
   int field874 = 1;
   byte field890 = 0;
   int[] field892 = new int[4];
   int field893 = -1;
   int field904 = 0;
   int field877 = -1;
   int field908 = 0;
   byte[] field928 = new byte[10];
   int field878 = -1;
   int field899 = -1;
   int[] field912 = new int[4];
   int field880 = -1;
   int field925 = 200;
   int field931;
   int field870 = -1;
   int field891 = -1;
   int[] field894 = new int[4];
   int field882 = -1;
   int field876 = 0;
   int[] field921 = new int[4];
   int field883 = -1;
   int field881;
   String field884 = null;
   boolean field886 = false;
   int field887 = 100;
   int field888 = 0;
   int field927 = 0;
   int field871;
   int field926;
   int field897 = -1;
   boolean field898 = false;
   int field902 = 0;
   int field901 = 0;
   int field907 = 0;
   int field910 = 0;
   int field914 = 0;
   int field875 = 0;
   int field924 = 32;
   int field917;
   boolean field885;
   int field911;
   int field918;
   int field913;
   int field915;
   int field889;
   int field916;
   int field929;
   int field905;
   int field919;

   boolean vmethod1786(byte var1) {
      return false;
   }

   final void method1542(int var1, int var2, int var3, int var4, int var5, int var6, byte var7) {
      boolean var8 = true;
      boolean var9 = true;

      int var10;
      for(var10 = 0; var10 < 4; var10++) {
         if(this.field895[var10] > var5) {
            var8 = false;
         } else {
            var9 = false;
         }
      }

      var10 = -1;
      int var11 = -1;
      int var12 = 0;
      if(var1 >= 0) {
         if(var7 == 8) {
            return;
         }

         class267 var13 = class14.method123(var1, (byte)46);
         var11 = var13.field3360;
         var12 = var13.field3355;
      }

      int var15;
      if(var9) {
         if(var11 == -1) {
            return;
         }

         var10 = 0;
         var15 = 0;
         if(var11 == 0) {
            var15 = this.field895[0];
         } else if(var11 == 1) {
            var15 = this.field892[0];
         }

         for(int var14 = 1; var14 < 4; var14++) {
            if(var11 == 0) {
               if(this.field895[var14] < var15) {
                  var10 = var14;
                  var15 = this.field895[var14];
               }
            } else if(var11 == 1 && this.field892[var14] < var15) {
               var10 = var14;
               var15 = this.field892[var14];
            }
         }

         if(var11 == 1) {
            if(var7 == 8) {
               return;
            }

            if(var15 >= var2) {
               return;
            }
         }
      } else {
         if(var8) {
            if(var7 == 8) {
               return;
            }

            this.field890 = 0;
         }

         for(var15 = 0; var15 < 4; var15++) {
            byte var16 = this.field890;
            this.field890 = (byte)((this.field890 + 1) % 4);
            if(this.field895[var16] <= var5) {
               var10 = var16;
               break;
            }
         }
      }

      if(var10 >= 0) {
         this.field912[var10] = var1;
         this.field892[var10] = var2;
         this.field894[var10] = var3;
         this.field921[var10] = var4;
         this.field895[var10] = var5 + var12 + var6;
      }
   }

   final void method1557(int var1, int var2) {
      class261 var4 = (class261)class261.field3305.method3989((long)var1);
      class261 var3;
      if(var4 != null) {
         var3 = var4;
      } else {
         byte[] var5 = class261.field3304.method4625(33, var1, 1760625613);
         var4 = new class261();
         if(var5 != null) {
            if(var2 == -681966069) {
               return;
            }

            var4.method4915(new Stream(var5), -252686195);
         }

         class261.field3305.method3983(var4, (long)var1);
         var3 = var4;
      }

      var4 = var3;

      for(class71 var6 = (class71)this.field896.method4048(); var6 != null; var6 = (class71)this.field896.method4033()) {
         if(var4 == var6.field1025) {
            var6.unlink();
            return;
         }
      }

   }

   final void method1543(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class261 var9 = (class261)class261.field3305.method3989((long)var1);
      class261 var8;
      if(var9 != null) {
         var8 = var9;
      } else {
         byte[] var10 = class261.field3304.method4625(33, var1, 281503788);
         var9 = new class261();
         if(var10 != null) {
            var9.method4915(new Stream(var10), 2067333055);
         }

         class261.field3305.method3983(var9, (long)var1);
         var8 = var9;
      }

      var9 = var8;
      class71 var15 = null;
      class71 var11 = null;
      int var12 = var8.field3307;
      int var13 = 0;

      class71 var14;
      for(var14 = (class71)this.field896.method4048(); var14 != null; var14 = (class71)this.field896.method4033()) {
         if(var7 == -1114611190) {
            return;
         }

         ++var13;
         if(var14.field1025.field3317 == var9.field3317) {
            var14.method1772(var2 + var4, var5, var6, var3, 2106192110);
            return;
         }

         if(var14.field1025.field3310 <= var9.field3310) {
            var15 = var14;
         }

         if(var14.field1025.field3307 > var12) {
            var11 = var14;
            var12 = var14.field1025.field3307;
         }
      }

      if(var11 == null) {
         if(var7 == -1114611190) {
            return;
         }

         if(var13 >= 4) {
            return;
         }
      }

      var14 = new class71(var9);
      if(var15 == null) {
         this.field896.method4038(var14);
      } else {
         class203.method4036(var14, var15);
      }

      var14.method1772(var2 + var4, var5, var6, var3, -381098701);
      if(var13 >= 4) {
         var11.unlink();
      }

   }

   final void method1540(int var1) {
      this.field909 = 0;
      this.field930 = 0;
   }

   public static final void method1539(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   public static class254 method1549(int var0, int var1) {
      class254 var2 = (class254)class254.field3231.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class0.field2.method4625(16, var0, 427443969);
         var2 = new class254();
         if(var3 != null) {
            var2.method4809(new Stream(var3), 531410703);
         }

         class254.field3231.method3983(var2, (long)var0);
         return var2;
      }
   }

   public static void method1554(class247 var0, int var1, int var2, int var3, boolean var4, short var5) {
      class217.field2460 = 1;
      class138.field1871 = var0;
      class217.field2461 = var1;
      class217.field2462 = var2;
      class309.field3740 = var3;
      class217.field2463 = var4;
      class6.field37 = 10000;
   }
}
