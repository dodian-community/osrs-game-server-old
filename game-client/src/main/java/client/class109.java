package client;

import java.io.EOFException;
import java.io.IOException;

public class class109 {
   static int field1431;
   static int field1428;
   public static final int field1419 = 80;
   static final int field1430 = 1005;
   long field1429;
   int field1421;
   long field1427;
   long field1420 = -1L;
   long field1424;
   long field1417 = -1L;
   class110 field1425;
   int field1426 = 0;
   byte[] field1423;
   byte[] field1418;
   long field1422;

   public class109(class110 var1, int var2, int var3) throws IOException {
      this.field1425 = var1;
      long var10002 = var1.method2509(-2025425464) * -7105080075085021825L;
      this.field1429 = (this.field1422 = var1.method2509(-2025425464)) * -7105080075085021825L;
      this.field1418 = new byte[var2];
      this.field1423 = new byte[var3];
      this.field1424 = 0L;
   }

   public void method2479(byte[] var1, int var2, int var3, int var4) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1420 != -1L && this.field1424 >= this.field1420) {
            if(var4 >= -1847355458) {
               return;
            }

            if(this.field1424 + (long)var3 <= (long)this.field1426 + this.field1420) {
               System.arraycopy(this.field1423, (int)(this.field1424 - this.field1420), var1, var2, var3);
               this.field1424 += (long)var3;
               return;
            }
         }

         long var5 = this.field1424;
         int var8 = var3;
         int var9;
         if(this.field1424 >= this.field1417 && this.field1424 < (long)this.field1421 + this.field1417) {
            var9 = (int)((long)this.field1421 - (this.field1424 - this.field1417));
            if(var9 > var3) {
               var9 = var3;
            }

            System.arraycopy(this.field1418, (int)(this.field1424 - this.field1417), var1, var2, var9);
            this.field1424 += (long)var9;
            var2 += var9;
            var3 -= var9;
         }

         if(var3 > this.field1418.length) {
            this.field1425.method2514(this.field1424);

            for(this.field1427 = this.field1424; var3 > 0; var3 -= var9) {
               var9 = this.field1425.method2510(var1, var2, var3, 940434747);
               if(var9 == -1) {
                  break;
               }

               this.field1427 += (long)var9;
               this.field1424 += (long)var9;
               var2 += var9;
            }
         } else if(var3 > 0) {
            this.method2480(-1728368269);
            var9 = var3;
            if(var3 > this.field1421) {
               var9 = this.field1421;
            }

            System.arraycopy(this.field1418, 0, var1, var2, var9);
            var2 += var9;
            var3 -= var9;
            this.field1424 += (long)var9;
         }

         if(this.field1420 != -1L) {
            if(var4 >= -1847355458) {
               return;
            }

            if(this.field1420 > this.field1424 && var3 > 0) {
               var9 = var2 + (int)(this.field1420 - this.field1424);
               if(var9 > var3 + var2) {
                  var9 = var3 + var2;
               }

               while(var2 < var9) {
                  if(var4 >= -1847355458) {
                     return;
                  }

                  var1[var2++] = 0;
                  --var3;
                  ++this.field1424;
               }
            }

            long var11;
            long var14;
            label123: {
               var14 = -1L;
               var11 = -1L;
               if(this.field1420 >= var5) {
                  if(var4 >= -1847355458) {
                     return;
                  }

                  if(this.field1420 < var5 + (long)var8) {
                     var14 = this.field1420;
                     break label123;
                  }
               }

               if(var5 >= this.field1420 && var5 < this.field1420 + (long)this.field1426) {
                  var14 = var5;
               }
            }

            if((long)this.field1426 + this.field1420 > var5 && this.field1420 + (long)this.field1426 <= var5 + (long)var8) {
               var11 = this.field1420 + (long)this.field1426;
            } else if((long)var8 + var5 > this.field1420 && var5 + (long)var8 <= (long)this.field1426 + this.field1420) {
               var11 = (long)var8 + var5;
            }

            if(var14 > -1L && var11 > var14) {
               int var13 = (int)(var11 - var14);
               System.arraycopy(this.field1423, (int)(var14 - this.field1420), var1, (int)(var14 - var5) + var2, var13);
               if(var11 > this.field1424) {
                  var3 = (int)((long)var3 - (var11 - this.field1424));
                  this.field1424 = var11;
               }
            }
         }
      } catch (IOException var17) {
         this.field1427 = -1L;
         throw var17;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   void method2482(byte var1) throws IOException {
      if(this.field1420 != -1L) {
         if(this.field1420 != this.field1427) {
            this.field1425.method2514(this.field1420);
            this.field1427 = this.field1420;
         }

         this.field1425.method2506(this.field1423, 0, this.field1426, -1476745926);
         this.field1427 += (long)(this.field1426 * 1776216003) * 2034614507L;
         if(this.field1427 > this.field1422) {
            if(var1 == 7) {
               return;
            }

            this.field1422 = this.field1427;
         }

         long var2 = -1L;
         long var4 = -1L;
         if(this.field1420 >= this.field1417 && this.field1420 < this.field1417 + (long)this.field1421) {
            if(var1 == 7) {
               return;
            }

            var2 = this.field1420;
         } else if(this.field1417 >= this.field1420 && this.field1417 < (long)this.field1426 + this.field1420) {
            if(var1 == 7) {
               return;
            }

            var2 = this.field1417;
         }

         if((long)this.field1426 + this.field1420 > this.field1417 && this.field1420 + (long)this.field1426 <= (long)this.field1421 + this.field1417) {
            var4 = (long)this.field1426 + this.field1420;
         } else if((long)this.field1421 + this.field1417 > this.field1420 && (long)this.field1421 + this.field1417 <= (long)this.field1426 + this.field1420) {
            var4 = (long)this.field1421 + this.field1417;
         }

         if(var2 > -1L && var4 > var2) {
            int var6 = (int)(var4 - var2);
            System.arraycopy(this.field1423, (int)(var2 - this.field1420), this.field1418, (int)(var2 - this.field1417), var6);
         }

         this.field1420 = -1L;
         this.field1426 = 0;
      }

   }

   public long method2486(int var1) {
      return this.field1429 * 2659913085887693439L;
   }

   public void method2476(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1424 = var1;
      }
   }

   public void method2481(byte[] var1, int var2, int var3, int var4) throws IOException {
      try {
         if((long)var3 + this.field1424 > this.field1429 * 2659913085887693439L) {
            this.field1429 = ((long)var3 + this.field1424) * -7105080075085021825L;
         }

         if(this.field1420 != -1L) {
            label120: {
               if(this.field1424 >= this.field1420) {
                  if(this.field1424 <= this.field1420 + (long)this.field1426) {
                     break label120;
                  }

                  if(var4 <= 496976428) {
                     return;
                  }
               }

               this.method2482((byte)16);
            }
         }

         if(this.field1420 != -1L && this.field1424 + (long)var3 > (long)this.field1423.length + this.field1420) {
            int var5 = (int)((long)this.field1423.length - (this.field1424 - this.field1420));
            System.arraycopy(var1, var2, this.field1423, (int)(this.field1424 - this.field1420), var5);
            this.field1424 += (long)var5;
            var2 += var5;
            var3 -= var5;
            this.field1426 = this.field1423.length;
            this.method2482((byte)66);
         }

         if(var3 > this.field1423.length) {
            if(var4 > 496976428) {
               if(this.field1427 != this.field1424) {
                  if(var4 <= 496976428) {
                     return;
                  }

                  this.field1425.method2514(this.field1424);
                  this.field1427 = this.field1424;
               }

               this.field1425.method2506(var1, var2, var3, -422778555);
               this.field1427 += (long)var3;
               if(this.field1427 > this.field1422) {
                  this.field1422 = this.field1427;
               }

               long var10 = -1L;
               long var7 = -1L;
               if(this.field1424 >= this.field1417 && this.field1424 < this.field1417 + (long)this.field1421) {
                  var10 = this.field1424;
               } else if(this.field1417 >= this.field1424) {
                  if(var4 <= 496976428) {
                     return;
                  }

                  if(this.field1417 < this.field1424 + (long)var3) {
                     var10 = this.field1417;
                  }
               }

               if((long)var3 + this.field1424 > this.field1417 && (long)var3 + this.field1424 <= (long)this.field1421 + this.field1417) {
                  var7 = (long)var3 + this.field1424;
               } else if((long)this.field1421 + this.field1417 > this.field1424) {
                  if(var4 <= 496976428) {
                     return;
                  }

                  if(this.field1417 + (long)this.field1421 <= this.field1424 + (long)var3) {
                     var7 = (long)this.field1421 + this.field1417;
                  }
               }

               if(var10 > -1L && var7 > var10) {
                  int var9 = (int)(var7 - var10);
                  System.arraycopy(var1, (int)(var10 + (long)var2 - this.field1424), this.field1418, (int)(var10 - this.field1417), var9);
               }

               this.field1424 += (long)var3;
            }
         } else if(var3 > 0) {
            if(this.field1420 == -1L) {
               if(var4 <= 496976428) {
                  return;
               }

               this.field1420 = this.field1424;
            }

            System.arraycopy(var1, var2, this.field1423, (int)(this.field1424 - this.field1420), var3);
            this.field1424 += (long)var3;
            if(this.field1424 - this.field1420 > (long)this.field1426) {
               this.field1426 = (int)(this.field1424 - this.field1420);
            }

         }
      } catch (IOException var13) {
         this.field1427 = -1L;
         throw var13;
      }
   }

   void method2480(int var1) throws IOException {
      this.field1421 = 0;
      if(this.field1427 != this.field1424) {
         if(var1 != -1728368269) {
            return;
         }

         this.field1425.method2514(this.field1424);
         this.field1427 = this.field1424;
      }

      int var2;
      for(this.field1417 = this.field1424; this.field1421 < this.field1418.length; this.field1421 += var2) {
         var2 = this.field1425.method2510(this.field1418, this.field1421, this.field1418.length - this.field1421, 1121128372);
         if(var2 == -1) {
            break;
         }

         this.field1427 += (long)var2;
      }

   }

   public void method2493(int var1) throws IOException {
      this.method2482((byte)-4);
      this.field1425.method2507(746943081);
   }

   public void method2478(byte[] var1, int var2) throws IOException {
      this.method2479(var1, 0, var1.length, -2056377255);
   }

   public static int method2484(long var0) {
      return (int)(var0 >>> 7 & 127L);
   }

   static int method2503(class65 var0, class65 var1, int var2, boolean var3, int var4, boolean var5, int var6) {
      int var7 = class26.method428(var0, var1, var2, var3, (byte)30);
      if(var7 != 0) {
         return var3 ? -var7 : var7;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var8 = class26.method428(var0, var1, var4, var5, (byte)45);
         return var5 ? -var8 : var8;
      }
   }
}
