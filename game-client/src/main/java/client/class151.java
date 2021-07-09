package client;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class class151 implements Runnable {
   static int field1933;
   static class298 field1936;
   IOException field1935;
   int field1931 = 0;
   int field1929 = 0;
   int field1934;
   Thread field1930;
   byte[] field1932;
   InputStream field1937;

   class151(InputStream var1, int var2) {
      this.field1937 = var1;
      this.field1934 = var2 + 1;
      this.field1932 = new byte[this.field1934];
      this.field1930 = new Thread(this);
      this.field1930.setDaemon(true);
      this.field1930.start();
   }

   boolean method3219(int var1, int var2) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field1934) {
         synchronized(this) {
            int var4;
            if(this.field1931 <= this.field1929) {
               var4 = this.field1929 - this.field1931;
            } else {
               var4 = this.field1934 - this.field1931 + this.field1929;
            }

            if(var4 < var1) {
               if(this.field1935 != null) {
                  throw new IOException(this.field1935.toString());
               } else {
                  this.notifyAll();
                  return false;
               }
            } else {
               return true;
            }
         }
      } else {
         throw new IOException();
      }
   }

   int method3218(int var1) throws IOException {
      synchronized(this) {
         if(this.field1931 == this.field1929) {
            if(this.field1935 != null) {
               throw new IOException(this.field1935.toString());
            } else {
               return -1;
            }
         } else {
            int var3 = this.field1932[this.field1931] & 255;
            this.field1931 = (this.field1931 + 1) % this.field1934;
            this.notifyAll();
            return var3;
         }
      }
   }

   int method3217(int var1) throws IOException {
      synchronized(this) {
         int var3;
         if(this.field1931 <= this.field1929) {
            var3 = this.field1929 - this.field1931;
         } else {
            var3 = this.field1934 - this.field1931 + this.field1929;
         }

         if(var3 <= 0 && this.field1935 != null) {
            throw new IOException(this.field1935.toString());
         } else {
            this.notifyAll();
            return var3;
         }
      }
   }

   int method3224(byte[] var1, int var2, int var3, int var4) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var6;
            if(this.field1931 <= this.field1929) {
               var6 = this.field1929 - this.field1931;
            } else {
               var6 = this.field1934 - this.field1931 + this.field1929;
            }

            if(var3 > var6) {
               var3 = var6;
            }

            if(var3 == 0 && this.field1935 != null) {
               throw new IOException(this.field1935.toString());
            } else {
               if(var3 + this.field1931 <= this.field1934) {
                  System.arraycopy(this.field1932, this.field1931, var1, var2, var3);
               } else {
                  int var7 = this.field1934 - this.field1931;
                  System.arraycopy(this.field1932, this.field1931, var1, var2, var7);
                  System.arraycopy(this.field1932, 0, var1, var7 + var2, var3 - var7);
               }

               this.field1931 = (var3 + this.field1931) % this.field1934;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   void method3215(byte var1) {
      synchronized(this) {
         if(this.field1935 == null) {
            if(var1 <= 3) {
               return;
            }

            this.field1935 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field1930.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field1935 != null) {
                  return;
               }

               if(this.field1931 == 0) {
                  var1 = this.field1934 - this.field1929 - 1;
               } else if(this.field1931 <= this.field1929) {
                  var1 = this.field1934 - this.field1929;
               } else {
                  var1 = this.field1931 - this.field1929 - 1;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var10) {
                  ;
               }
            }
         }

         int var7;
         try {
            var7 = this.field1937.read(this.field1932, this.field1929, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field1935 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field1929 = (var7 + this.field1929) % this.field1934;
         }
      }
   }

   static File method3238(String var0, int var1) {
      if(!class158.field1979) {
         throw new RuntimeException("");
      } else {
         File var2 = (File)class158.field1975.get(var0);
         if(var2 != null) {
            return var2;
         } else {
            File var3 = new File(class158.field1974, var0);
            RandomAccessFile var4 = null;

            try {
               File var5 = new File(var3.getParent());
               if(!var5.exists()) {
                  throw new RuntimeException("");
               } else {
                  var4 = new RandomAccessFile(var3, "rw");
                  int var6 = var4.read();
                  var4.seek(0L);
                  var4.write(var6);
                  var4.seek(0L);
                  var4.close();
                  class158.field1975.put(var0, var3);
                  return var3;
               }
            } catch (Exception var9) {
               try {
                  if(var4 != null) {
                     var4.close();
                     var4 = null;
                  }
               } catch (Exception var8) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   static String method3239(Widget var0, int var1) {
      return class154.method3252(class24.method425(var0, (byte)-6), (byte)-80) == 0 ? null : (var0.selectedActionName != null && var0.selectedActionName.trim().length() != 0 ? var0.selectedActionName : null);
   }

   static int method3240(int var0, class84 var1, boolean var2, int var3) {
      if(var0 == 6200) {
         class69.field1003 -= 2;
         GameClient.field802 = (short)class69.field999[class69.field1003];
         if(GameClient.field802 <= 0) {
            GameClient.field802 = 256;
         }

         GameClient.field829 = (short)class69.field999[class69.field1003 + 1];
         if(GameClient.field829 <= 0) {
            GameClient.field829 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class69.field1003 -= 2;
         GameClient.field848 = (short)class69.field999[class69.field1003];
         if(GameClient.field848 <= 0) {
            GameClient.field848 = 256;
         }

         GameClient.field831 = (short)class69.field999[class69.field1003 + 1];
         if(GameClient.field831 <= 0) {
            GameClient.field831 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class69.field1003 -= 4;
         GameClient.field832 = (short)class69.field999[class69.field1003];
         if(GameClient.field832 <= 0) {
            GameClient.field832 = 1;
         }

         GameClient.field833 = (short)class69.field999[class69.field1003 + 1];
         if(GameClient.field833 <= 0) {
            GameClient.field833 = 32767;
         } else if(GameClient.field833 < GameClient.field832) {
            GameClient.field833 = GameClient.field832;
         }

         GameClient.field834 = (short)class69.field999[class69.field1003 + 2];
         if(GameClient.field834 <= 0) {
            GameClient.field834 = 1;
         }

         GameClient.field835 = (short)class69.field999[class69.field1003 + 3];
         if(GameClient.field835 <= 0) {
            GameClient.field835 = 32767;
         } else if(GameClient.field835 < GameClient.field834) {
            GameClient.field835 = GameClient.field834;
         }

         return 1;
      } else if(var0 == 6203) {
         if(GameClient.field784 != null) {
            class43.method714(0, 0, GameClient.field784.int472, GameClient.field784.int466, false, 2123332164);
            class69.field999[++class69.field1003 - 1] = GameClient.field838;
            class69.field999[++class69.field1003 - 1] = GameClient.field662;
         } else {
            class69.field999[++class69.field1003 - 1] = -1;
            class69.field999[++class69.field1003 - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class69.field999[++class69.field1003 - 1] = GameClient.field848;
         class69.field999[++class69.field1003 - 1] = GameClient.field831;
         return 1;
      } else if(var0 == 6205) {
         class69.field999[++class69.field1003 - 1] = GameClient.field802;
         class69.field999[++class69.field1003 - 1] = GameClient.field829;
         return 1;
      } else {
         return 2;
      }
   }
}
