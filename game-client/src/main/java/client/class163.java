package client;

import java.io.IOException;
import java.io.OutputStream;

public class class163 implements Runnable {
   public static class315 field2014;
   static String field2013;
   public static int field2016;
   static final int field2007 = 16;
   boolean field2009;
   IOException field2011;
   int field2010 = 0;
   OutputStream field2006;
   Thread field2008;
   int field2005 = 0;
   int field2015;
   byte[] field2012;

   class163(OutputStream var1, int var2) {
      this.field2006 = var1;
      this.field2015 = var2 + 1;
      this.field2012 = new byte[this.field2015];
      this.field2008 = new Thread(this);
      this.field2008.setDaemon(true);
      this.field2008.start();
   }

   void method3383(byte[] var1, int var2, int var3, int var4) throws IOException {
      if(var3 >= 0) {
         if(var4 != 1100841407) {
            return;
         }

         if(var2 >= 0 && var3 + var2 <= var1.length) {
            synchronized(this) {
               if(this.field2011 != null) {
                  if(var4 != 1100841407) {
                     return;
                  }

                  throw new IOException(this.field2011.toString());
               }

               int var6;
               if(this.field2010 <= this.field2005) {
                  var6 = this.field2015 - this.field2005 + this.field2010 - 1;
               } else {
                  var6 = this.field2010 - this.field2005 - 1;
               }

               if(var6 < var3) {
                  throw new IOException("");
               }

               if(var3 + this.field2005 <= this.field2015) {
                  System.arraycopy(var1, var2, this.field2012, this.field2005, var3);
               } else {
                  int var7 = this.field2015 - this.field2005;
                  System.arraycopy(var1, var2, this.field2012, this.field2005, var7);
                  System.arraycopy(var1, var7 + var2, this.field2012, 0, var3 - var7);
               }

               this.field2005 = (var3 + this.field2005) % this.field2015;
               this.notifyAll();
               return;
            }
         }
      }

      throw new IOException();
   }

   void method3384(int var1) {
      synchronized(this) {
         this.field2009 = true;
         this.notifyAll();
      }

      try {
         this.field2008.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   boolean method3390(int var1) {
      if(this.field2009) {
         try {
            this.field2006.close();
            if(this.field2011 == null) {
               this.field2011 = new IOException("");
            }
         } catch (IOException var3) {
            if(this.field2011 == null) {
               this.field2011 = new IOException(var3);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2011 != null) {
                  return;
               }

               if(this.field2010 <= this.field2005) {
                  var1 = this.field2005 - this.field2010;
               } else {
                  var1 = this.field2015 - this.field2010 + this.field2005;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2006.flush();
               } catch (IOException var11) {
                  this.field2011 = var11;
                  return;
               }

               if(this.method3390(1097599728)) {
                  return;
               }

               try {
                  this.wait();
               } catch (InterruptedException var12) {
                  ;
               }
            }
         }

         try {
            if(var1 + this.field2010 <= this.field2015) {
               this.field2006.write(this.field2012, this.field2010, var1);
            } else {
               int var7 = this.field2015 - this.field2010;
               this.field2006.write(this.field2012, this.field2010, var7);
               this.field2006.write(this.field2012, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2011 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2010 = (var1 + this.field2010) % this.field2015;
         }
      } while(!this.method3390(1097599728));

   }

   public static int method3389(int var0, int var1) {
      class263 var3 = (class263)class263.field3321.method3989((long)var0);
      class263 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = class263.field3322.method4625(14, var0, -80027222);
         var3 = new class263();
         if(var8 != null) {
            var3.method4941(new Stream(var8), -1902884964);
         }

         class263.field3321.method3983(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.field3320;
      int var5 = var2.field3323;
      int var6 = var2.field3326;
      int var7 = class225.field2557[var6 - var5];
      return class225.field2558[var4] >> var5 & var7;
   }

   static void method3388(Widget[] var0, Widget var1, boolean var2, int var3) {
      int var10000;
      if(var1.scrollWidth != 0) {
         if(var3 <= -56478210) {
            return;
         }

         var10000 = var1.scrollWidth;
      } else {
         var10000 = var1.int472;
      }

      int var4 = var10000;
      int var5 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.int466;
      class304.method5635(var0, var1.interfaceHash, var4, var5, var2, (byte)-81);
      if(var1.children != null) {
         class304.method5635(var1.children, var1.interfaceHash, var4, var5, var2, (byte)-5);
      }

      class55 var6 = (class55) GameClient.field741.get((long)var1.interfaceHash);
      if(var6 != null) {
         if(var3 <= -56478210) {
            return;
         }

         class84.method1946(var6.field501, var4, var5, var2, (byte)26);
      }

      if(var1.interactType == 1337) {
         ;
      }

   }
}
