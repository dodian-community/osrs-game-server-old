package client;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class class161 extends class157 implements Runnable {
   static Sprite[] field1997;
   static final int field1991 = 33;
   int field1993 = 0;
   boolean field1990 = false;
   int field1992 = 0;
   boolean field1998 = false;
   InputStream field1988;
   byte[] field1994;
   class153 field1987;
   final int field1995;
   OutputStream field1986;
   class154 field1989;
   Socket field1985;
   final int field1996;

   public class161(Socket var1, class154 var2, int var3) throws IOException {
      this.field1989 = var2;
      this.field1985 = var1;
      this.field1995 = var3;
      this.field1996 = var3 - 100;
      this.field1985.setSoTimeout(30000);
      this.field1985.setTcpNoDelay(true);
      this.field1985.setReceiveBufferSize(65536);
      this.field1985.setSendBufferSize(65536);
      this.field1988 = this.field1985.getInputStream();
      this.field1986 = this.field1985.getOutputStream();
   }

   void method3352(byte[] var1, int var2, int var3, int var4) throws IOException {
      if(!this.field1990) {
         if(this.field1998) {
            this.field1998 = false;
            throw new IOException();
         } else {
            if(this.field1994 == null) {
               this.field1994 = new byte[this.field1995];
            }

            synchronized(this) {
               for(int var6 = 0; var6 < var3; var6++) {
                  this.field1994[this.field1993] = var1[var6 + var2];
                  this.field1993 = (this.field1993 + 1) % this.field1995;
                  if((this.field1996 + this.field1992) % this.field1995 == this.field1993) {
                     throw new IOException();
                  }
               }

               if(this.field1987 == null) {
                  this.field1987 = this.field1989.method3249(this, 3, 2135715597);
               }

               this.notifyAll();
            }
         }
      }
   }

   public void vmethod3346(int var1) {
      if(this.field1990) {
         if(var1 == 1775992211) {
            ;
         }
      } else {
         synchronized(this) {
            this.field1990 = true;
            this.notifyAll();
         }

         if(this.field1987 != null) {
            while(this.field1987.field1946 == 0) {
               class63.method1539(1L);
            }

            if(this.field1987.field1946 == 1) {
               try {
                  ((Thread)this.field1987.field1944).join();
               } catch (InterruptedException var4) {
                  ;
               }
            }
         }

         this.field1987 = null;
      }
   }

   public boolean vmethod3350(int var1, byte var2) throws IOException {
      return this.field1990 ? false : this.field1988.available() >= var1;
   }

   public int vmethod3351(byte[] var1, int var2, int var3, int var4) throws IOException {
      if(this.field1990) {
         return 0;
      } else {
         int var5;
         int var6;
         for(var5 = var3; var3 > 0; var3 -= var6) {
            var6 = this.field1988.read(var1, var2, var3);
            if(var6 <= 0) {
               throw new EOFException();
            }

            var2 += var6;
         }

         return var5;
      }
   }

   public void vmethod3347(byte[] var1, int var2, int var3, byte var4) throws IOException {
      this.method3352(var1, var2, var3, -436228985);
   }

   public int vmethod3349(int var1) throws IOException {
      return this.field1990 ? 0 : this.field1988.available();
   }

   public int vmethod3353(int var1) throws IOException {
      return this.field1990 ? 0 : this.field1988.read();
   }

   public void run() {
      try {
         while(true) {
            int var1;
            int var2;
            label85: {
               synchronized(this) {
                  label86: {
                     if(this.field1993 == this.field1992) {
                        if(this.field1990) {
                           break label86;
                        }

                        try {
                           this.wait();
                        } catch (InterruptedException var10) {
                           ;
                        }
                     }

                     var2 = this.field1992;
                     if(this.field1993 >= this.field1992) {
                        var1 = this.field1993 - this.field1992;
                     } else {
                        var1 = this.field1995 - this.field1992;
                     }
                     break label85;
                  }
               }

               try {
                  if(this.field1988 != null) {
                     this.field1988.close();
                  }

                  if(this.field1986 != null) {
                     this.field1986.close();
                  }

                  if(this.field1985 != null) {
                     this.field1985.close();
                  }
               } catch (IOException var7) {
                  ;
               }

               this.field1994 = null;
               break;
            }

            if(var1 > 0) {
               try {
                  this.field1986.write(this.field1994, var2, var1);
               } catch (IOException var9) {
                  this.field1998 = true;
               }

               this.field1992 = (var1 + this.field1992) % this.field1995;

               try {
                  if(this.field1993 == this.field1992) {
                     this.field1986.flush();
                  }
               } catch (IOException var8) {
                  this.field1998 = true;
               }
            }
         }
      } catch (Exception var12) {
         class5.method65((String)null, var12, (byte)83);
      }

   }

   protected void finalize() {
      this.vmethod3346(1775992211);
   }

   public static boolean method3362(char var0, int var1) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
