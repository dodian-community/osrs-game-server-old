package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;

public class class135 implements Runnable {
   static ScheduledExecutorService field1855;
   static int field1856;
   static class249 field1852;
   static final int field1857 = 34;
   volatile boolean field1853;
   Queue field1858 = new LinkedList();
   final Thread field1854 = new Thread(this);

   public class135() {
      this.field1854.setPriority(1);
      this.field1854.start();
   }

   public void method3106(int var1) {
      this.field1853 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field1854.join();
      } catch (InterruptedException var5) {
         ;
      }

   }

   public class136 method3109(URL var1, int var2) {
      class136 var3 = new class136(var1);
      synchronized(this) {
         this.field1858.add(var3);
         this.notify();
         return var3;
      }
   }

   public void run() {
      while(!this.field1853) {
         try {
            class136 var1;
            synchronized(this) {
               var1 = (class136)this.field1858.poll();
               if(var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var13) {
                     ;
                  }
                  continue;
               }
            }

            DataInputStream var2 = null;
            URLConnection var3 = null;

            try {
               var3 = var1.field1867.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var7 = var3.getContentLength();
               if(var7 >= 0) {
                  byte[] var5 = new byte[var7];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.field1861 = var5;
               }

               var1.field1859 = true;
            } catch (IOException var14) {
               var1.field1859 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            class5.method65((String)null, var17, (byte)76);
         }
      }

   }

   static void method3114(int var0, int var1) {
      if(var0 != -1) {
         if(class261.method4931(var0, (byte)-45)) {
            Widget[] var2 = Widget.LOADED[var0];

            for(int var3 = 0; var3 < var2.length; var3++) {
               Widget var4 = var2[var3];
               if(var4.cs2Triggers != null) {
                  ScriptInvocation var5 = new ScriptInvocation();
                  var5.field506 = var4;
                  var5.parameters = var4.cs2Triggers;
                  class309.method5674(var5, 5000000, 437852642);
               }
            }

         }
      }
   }

   static final String method3113(int var0, int var1, int var2) {
      int var3 = var1 - var0;
      return var3 < -9 ? class6.method71(16711680) : (var3 < -6 ? class6.method71(16723968) : (var3 < -3 ? class6.method71(16740352) : (var3 < 0 ? class6.method71(16756736) : (var3 > 9 ? class6.method71(65280) : (var3 > 6 ? class6.method71(4259584) : (var3 > 3 ? class6.method71(8453888) : (var3 > 0 ? class6.method71(12648192) : class6.method71(16776960))))))));
   }
}
