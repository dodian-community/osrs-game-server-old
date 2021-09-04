package client;

import java.math.BigInteger;

public class Stream extends class204 {
   static int[] field2336 = new int[256];
   static long[] field2337;
   static GameClient client;
   public static final int field2335 = 91;
   public byte[] field2338;
   public int field2339;

   static {
      int var2;
      for(int var1 = 0; var1 < 256; var1++) {
         int var0 = var1;

         for(var2 = 0; var2 < 8; var2++) {
            if((var0 & 1) == 1) {
               var0 = var0 >>> 1 ^ -306674912;
            } else {
               var0 >>>= 1;
            }
         }

         field2336[var1] = var0;
      }

      field2337 = new long[256];

      for(var2 = 0; var2 < 256; var2++) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; var3++) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2337[var2] = var4;
      }

   }

   public Stream(int var1) {
      this.field2338 = class84.method1943(var1, -886650438);
      this.field2339 = 0;
   }

   public Stream(byte[] var1) {
      this.field2338 = var1;
      this.field2339 = 0;
   }

   public int readCompact() {
      int var2 = this.field2338[this.field2339] & 255;
      return var2 < 128 ? this.readUByte() : this.readUShort() - 32768;
   }

   public String readString() {
      int var2 = this.field2339;

      while(this.field2338[++this.field2339 - 1] != 0) {
         ;
      }

      int var3 = this.field2339 - var2 - 1;
      return var3 == 0 ? "" : class78.method1831(this.field2338, var2, var3, -1860581172);
   }

   public int readInt() {
      this.field2339 += 4;
      return ((this.field2338[this.field2339 - 3] & 255) << 16) + (this.field2338[this.field2339 - 1] & 255) + ((this.field2338[this.field2339 - 2] & 255) << 8) + ((this.field2338[this.field2339 - 4] & 255) << 24);
   }

   public void writeByte(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)var1;
   }

   public int readUByte() {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      return var10000[var10001 - 1] & 255;
   }

   public int method3546() {
      if(this.field2338[this.field2339] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var2 = this.readUShort();
         return var2 == 32767 ? -1 : var2;
      }
   }

   public int readMedium() {
      this.field2339 += 3;
      return ((this.field2338[this.field2339 - 3] & 255) << 16) + (this.field2338[this.field2339 - 1] & 255) + ((this.field2338[this.field2339 - 2] & 255) << 8);
   }

   public int method3566(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      byte var2 = var10000[var10001 - 1];

      int var3;
      for(var3 = 0; var2 < 0; var2 = var10000[var10001 - 1]) {
         var3 = (var3 | var2 & 127) << 7;
         var10000 = this.field2338;
         var10001 = this.field2339 + 1;
         ++this.field2339;
      }

      return var3 | var2;
   }

   public byte readByte() {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      return var10000[var10001 - 1];
   }

   public int readUShort() {
      this.field2339 += 2;
      return (this.field2338[this.field2339 - 1] & 255) + ((this.field2338[this.field2339 - 2] & 255) << 8);
   }

   public void method3539(byte[] var1, int var2, int var3) {
      for(int var5 = var2; var5 < var3 + var2; var5++) {
         byte[] var10002 = this.field2338;
         int var10003 = this.field2339 + 1;
         ++this.field2339;
         var1[var5] = var10002[var10003 - 1];
      }

   }

   public long readLong() {
      long var2 = (long)this.readInt() & 4294967295L;
      long var4 = (long)this.readInt() & 4294967295L;
      return (var2 << 32) + var4;
   }

   public void writeInt(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 24);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 16);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)var1;
   }

   public void writeShort(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)var1;
   }

   public int readShort() {
      this.field2339 += 2;
      int var2 = (this.field2338[this.field2339 - 1] & 255) + ((this.field2338[this.field2339 - 2] & 255) << 8);
      if(var2 > 32767) {
         var2 -= 65536;
      }

      return var2;
   }

   public String method3558() {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      byte var2 = var10000[var10001 - 1];
      if(var2 != 0) {
         throw new IllegalStateException("");
      } else {
         int var3 = this.field2339;

         while(this.field2338[++this.field2339 - 1] != 0) {
            ;
         }

         int var4 = this.field2339 - var3 - 1;
         return var4 == 0 ? "" : class78.method1831(this.field2338, var3, var4, -1849601215);
      }
   }

   public void method3688(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.writeByte(var1 >>> 28 | 128);
               }

               this.writeByte(var1 >>> 21 | 128);
            }

            this.writeByte(var1 >>> 14 | 128);
         }

         this.writeByte(var1 >>> 7 | 128);
      }

      this.writeByte(var1 & 127);
   }

   public void writeBytes(byte[] var1, int var2, int var3) {
      for(int var5 = var2; var5 < var3 + var2; var5++) {

         byte[] var10000 = this.field2338;
         int var10001 = this.field2339 + 1;
         ++this.field2339;
         var10000[var10001 - 1] = var1[var5];
      }

   }

   public int method3611() {
      return this.field2338[this.field2339] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUShort();
   }

   public void method3570(int[] var1, int var2, int var3, int var4) {
      int var5 = this.field2339;
      this.field2339 = var2;
      int var6 = (var3 - var2) / 8;

      for(int var7 = 0; var7 < var6; var7++) {
         if(var4 >= -2105176812) {
            return;
         }

         int var8 = this.readInt();
         int var9 = this.readInt();
         int var10 = -957401312;
         int var11 = -1640531527;

         for(int var12 = 32; var12-- > 0; var8 -= var9 + (var9 << 4 ^ var9 >>> 5) ^ var10 + var1[var10 & 3]) {
            var9 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var10 >>> 11 & 3] + var10;
            var10 -= var11;
         }

         this.field2339 -= 8;
         this.writeInt(var8);
         this.writeInt(var9);
      }

      this.field2339 = var5;
   }

   public void writeString(String var1, int var2) {
      int var3 = var1.indexOf(0);
      if(var3 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2339 += class23.method421(var1, 0, var1.length(), this.field2338, this.field2339, 488772559);
         byte[] var10000 = this.field2338;
         int var10001 = this.field2339 + 1;
         ++this.field2339;
         var10000[var10001 - 1] = 0;
      }
   }

   public void method3766(boolean var1, int var2) {
      byte var10001;
      if(var1) {
         if(var2 == -109641150) {
            return;
         }

         var10001 = 1;
      } else {
         var10001 = 0;
      }

      this.writeByte(var10001);
   }

   public void method3531(int var1) {
      if(this.field2338 != null) {
         class309.method5671(this.field2338, 1705135152);
      }

      this.field2338 = null;
   }

   public void method3534(int var1, int var2) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 16);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)var1;
   }

   public String method3752(byte var1) {
      if(this.field2338[this.field2339] == 0) {
         ++this.field2339;
         return null;
      } else {
         return this.readString();
      }
   }

   public boolean readBoolean() {
      return (this.readUByte() & 1) == 1;
   }

   public int method3561() {
      int var2 = this.field2338[this.field2339] & 255;
      return var2 < 128 ? this.readUByte() - 64 : this.readUShort() - 49152;
   }

   public void method3540(String var1, int var2) {
      int var3 = var1.indexOf(0);
      if(var3 >= 0) {
         if(var2 < -611546805) {
            throw new IllegalArgumentException("");
         }
      } else {
         byte[] var10000 = this.field2338;
         int var10001 = this.field2339 + 1;
         ++this.field2339;
         var10000[var10001 - 1] = 0;
         this.field2339 += class23.method421(var1, 0, var1.length(), this.field2338, this.field2339, 1884819376);
         var10000 = this.field2338;
         var10001 = this.field2339 + 1;
         ++this.field2339;
         var10000[var10001 - 1] = 0;
      }
   }

   public int readShortA() {
      this.field2339 += 2;
      return (this.field2338[this.field2339 - 1] - 128 & 255) + ((this.field2338[this.field2339 - 2] & 255) << 8);
   }

   public int readIntV2() {
      this.field2339 += 4;
      return ((this.field2338[this.field2339 - 1] & 255) << 8) + ((this.field2338[this.field2339 - 4] & 255) << 16) + (this.field2338[this.field2339 - 2] & 255) + ((this.field2338[this.field2339 - 3] & 255) << 24);
   }

   public void writeIntLE(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)var1;
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 16);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 24);
   }

   public int readIntV1() {
      this.field2339 += 4;
      return ((this.field2338[this.field2339 - 2] & 255) << 24) + ((this.field2338[this.field2339 - 4] & 255) << 8) + (this.field2338[this.field2339 - 3] & 255) + ((this.field2338[this.field2339 - 1] & 255) << 16);
   }

   public void method3545(int var1) {
      this.field2338[this.field2339 - var1 - 1] = (byte)var1;
   }

   public int readLEShortA() {
      this.field2339 += 2;
      return ((this.field2338[this.field2339 - 1] & 255) << 8) + (this.field2338[this.field2339 - 2] - 128 & 255);
   }

   public void writeShortLE(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)var1;
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
   }

   public void writeIntV1(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)var1;
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 24);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 16);
   }

   public int readUByteA() {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      return var10000[var10001 - 1] - 128 & 255;
   }

   public void writeIntV2(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 16);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 24);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)var1;
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
   }

   public void writeByteN(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(0 - var1);
   }

   public int readUShortLE() {
      this.field2339 += 2;
      return ((this.field2338[this.field2339 - 1] & 0xff) << 8) + (this.field2338[this.field2339 - 2] & 0xff);
   }

   public int readUByteN() {
      byte[] var10001 = this.field2338;
      int var10002 = this.field2339 + 1;
      ++this.field2339;
      return 0 - var10001[var10002 - 1] & 255;
   }

   public void writeShortA(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 + 128);
   }

   public void writeLEShortA(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 + 128);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
   }

   public int method3572(int var1, byte var2) {
      int var3 = class187.method3812(this.field2338, var1, this.field2339, 1613923408);
      this.writeInt(var3);
      return var3;
   }

   public void method3571(BigInteger var1, BigInteger var2) {
      if (Loader.local) {
         return;
      }

      int var4 = this.field2339;
      this.field2339 = 0;
      byte[] var5 = new byte[var4];
      this.method3539(var5, 0, var4);
      BigInteger var6 = new BigInteger(var5);
      BigInteger var7 = var6.modPow(var1, var2);
      byte[] var8 = var7.toByteArray();
      this.field2339 = 0;
      this.writeShort(var8.length);
      this.writeBytes(var8, 0, var8.length);
   }

   public byte readByteA() {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      return (byte)(var10000[var10001 - 1] - 128);
   }

   public void method3659(long var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 56));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 48));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 40));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 32));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 24));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 16));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 8));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)var1);
   }

   public int readUByteS() {
      int var10002 = this.field2339 + 1;
      ++this.field2339;
      return 128 - this.field2338[var10002 - 1] & 255;
   }

   public void method3614(int var1, int var2) {
      this.field2338[this.field2339 - var1 - 2] = (byte)(var1 >> 8);
      this.field2338[this.field2339 - var1 - 1] = (byte)var1;
   }

   public byte readByteS() {
      byte[] var10001 = this.field2338;
      int var10002 = this.field2339 + 1;
      ++this.field2339;
      return (byte)(128 - var10001[var10002 - 1]);
   }

   public int readIntLE() {
      this.field2339 += 4;
      return (this.field2338[this.field2339 - 4] & 255) + ((this.field2338[this.field2339 - 3] & 255) << 8) + ((this.field2338[this.field2339 - 2] & 255) << 16) + ((this.field2338[this.field2339 - 1] & 255) << 24);
   }

   public void method3731(int var1, int var2) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 8);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 >> 16);
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)var1;
   }

   public int readLEShortA(int var1) {
      this.field2339 += 2;
      int var2 = ((this.field2338[this.field2339 - 1] & 255) << 8) + (this.field2338[this.field2339 - 2] - 128 & 255);
      if(var2 > 32767) {
         var2 -= 65536;
      }

      return var2;
   }

   public boolean method3756(int var1) {
      this.field2339 -= 4;
      int var2 = class187.method3812(this.field2338, 0, this.field2339, 1018158812);
      int var3 = this.readInt();
      return var3 == var2;
   }

   public String method3559(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      byte var2 = var10000[var10001 - 1];
      if(var2 != 0) {
         throw new IllegalStateException("");
      } else {
         int var3 = this.method3566(-179794498);
         if(var3 + this.field2339 > this.field2338.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var5 = this.field2338;
            int var6 = this.field2339;
            char[] var7 = new char[var3];
            int var8 = 0;
            int var9 = var6;

            int var12;
            for(int var10 = var3 + var6; var9 < var10; var7[var8++] = (char)var12) {
               int var11 = var5[var9++] & 255;
               if(var11 < 128) {
                  if(var11 == 0) {
                     var12 = 65533;
                  } else {
                     var12 = var11;
                  }
               } else if(var11 < 192) {
                  var12 = 65533;
               } else if(var11 < 224) {
                  if(var9 < var10 && (var5[var9] & 192) == 128) {
                     var12 = (var11 & 31) << 6 | var5[var9++] & 63;
                     if(var12 < 128) {
                        var12 = 65533;
                     }
                  } else {
                     var12 = 65533;
                  }
               } else if(var11 < 240) {
                  if(var9 + 1 < var10 && (var5[var9] & 192) == 128 && (var5[var9 + 1] & 192) == 128) {
                     var12 = (var11 & 15) << 12 | (var5[var9++] & 63) << 6 | var5[var9++] & 63;
                     if(var12 < 2048) {
                        var12 = 65533;
                     }
                  } else {
                     var12 = 65533;
                  }
               } else if(var11 < 248) {
                  if(var9 + 2 < var10 && (var5[var9] & 192) == 128 && (var5[var9 + 1] & 192) == 128 && (var5[var9 + 2] & 192) == 128) {
                     var12 = (var11 & 7) << 18 | (var5[var9++] & 63) << 12 | (var5[var9++] & 63) << 6 | var5[var9++] & 63;
                     if(var12 >= 65536 && var12 <= 1114111) {
                        var12 = 65533;
                     } else {
                        var12 = 65533;
                     }
                  } else {
                     var12 = 65533;
                  }
               } else {
                  var12 = 65533;
               }
            }

            String var4 = new String(var7, 0, var8);
            this.field2339 += var3;
            return var4;
         }
      }
   }

   public int method3563(byte var1) {
      int var2 = 0;

      int var3;
      for(var3 = this.readCompact(); var3 == 32767; var3 = this.readCompact()) {
         var2 += 32767;
      }

      var2 += var3;
      return var2;
   }

   public void method3541(CharSequence var1, byte var2) {
      int var4 = var1.length();
      int var5 = 0;

      int var6;
      for(var6 = 0; var6 < var4; var6++) {
         char var7 = var1.charAt(var6);
         if(var7 <= 127) {
            ++var5;
         } else if(var7 <= 2047) {
            var5 += 2;
         } else {
            var5 += 3;
         }
      }

      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = 0;
      this.method3688(var5);
      var5 = this.field2339;
      byte[] var13 = this.field2338;
      int var8 = this.field2339;
      int var9 = var1.length();
      int var10 = var8;

      for(int var11 = 0; var11 < var9; var11++) {
         if(var2 == 1) {
            return;
         }

         char var12 = var1.charAt(var11);
         if(var12 <= 127) {
            var13[var10++] = (byte)var12;
         } else if(var12 <= 2047) {
            var13[var10++] = (byte)(192 | var12 >> 6);
            var13[var10++] = (byte)(128 | var12 & 63);
         } else {
            var13[var10++] = (byte)(224 | var12 >> 12);
            var13[var10++] = (byte)(128 | var12 >> 6 & 63);
            var13[var10++] = (byte)(128 | var12 & 63);
         }
      }

      var6 = var10 - var8;
      this.field2339 = var6 + var5;
   }

   public int readShortLE() {
      this.field2339 += 2;
      int var2 = ((this.field2338[this.field2339 - 1] & 255) << 8) + (this.field2338[this.field2339 - 2] & 255);
      if(var2 > 32767) {
         var2 -= 65536;
      }

      return var2;
   }

   public void method3543(int var1, int var2) {
      this.field2338[this.field2339 - var1 - 4] = (byte)(var1 >> 24);
      this.field2338[this.field2339 - var1 - 3] = (byte)(var1 >> 16);
      this.field2338[this.field2339 - var1 - 2] = (byte)(var1 >> 8);
      this.field2338[this.field2339 - var1 - 1] = (byte)var1;
   }

   public int method3591(int var1) {
      this.field2339 += 3;
      return ((this.field2338[this.field2339 - 1] & 255) << 8) + ((this.field2338[this.field2339 - 3] & 255) << 16) + (this.field2338[this.field2339 - 2] & 255);
   }

   public void writeByteA(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(var1 + 128);
   }

   public void method3584(long var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 40));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 32));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 24));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 16));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)(var1 >> 8));
      var10000 = this.field2338;
      var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)((int)var1);
   }

   public void method3569(int[] var1, int var2, int var3, byte var4) {
      int var5 = this.field2339;
      this.field2339 = var2;
      int var6 = (var3 - var2) / 8;

      for(int var7 = 0; var7 < var6; var7++) {
         int var8 = this.readInt();
         int var9 = this.readInt();
         int var10 = 0;
         int var11 = -1640531527;

         for(int var12 = 32; var12-- > 0; var9 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var10 >>> 11 & 3] + var10) {
            var8 += var9 + (var9 << 4 ^ var9 >>> 5) ^ var10 + var1[var10 & 3];
            var10 += var11;
         }

         this.field2339 -= 8;
         this.writeInt(var8);
         this.writeInt(var9);
      }

      this.field2339 = var5;
   }

   public void method3567(int[] var1, int var2) {
      int var3 = this.field2339 / 8;
      this.field2339 = 0;

      for(int var4 = 0; var4 < var3; var4++) {
         int var5 = this.readInt();
         int var6 = this.readInt();
         int var7 = 0;
         int var8 = -1640531527;

         for(int var9 = 32; var9-- > 0; var6 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var7 >>> 11 & 3] + var7) {
            if(var2 <= -1825918917) {
               return;
            }

            var5 += var6 + (var6 << 4 ^ var6 >>> 5) ^ var7 + var1[var7 & 3];
            var7 += var8;
         }

         this.field2339 -= 8;
         this.writeInt(var5);
         this.writeInt(var6);
      }

   }

   public void writeByteS(int var1) {
      byte[] var10000 = this.field2338;
      int var10001 = this.field2339 + 1;
      ++this.field2339;
      var10000[var10001 - 1] = (byte)(128 - var1);
   }

   public void method3573(int var1, int var2) {
      if(var1 >= 0 && var1 < 128) {
         this.writeByte(var1);
      } else if(var1 >= 0 && var1 < 32768) {
         if(var2 != -60590880) {
            this.writeShort(var1 + 32768);
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   public void method3553(int[] var1, int var2) {
      int var3 = this.field2339 / 8;
      this.field2339 = 0;

      for(int var4 = 0; var4 < var3; var4++) {
         int var5 = this.readInt();
         int var6 = this.readInt();
         int var7 = -957401312;
         int var8 = -1640531527;

         for(int var9 = 32; var9-- > 0; var5 -= var6 + (var6 << 4 ^ var6 >>> 5) ^ var7 + var1[var7 & 3]) {
            var6 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var7 >>> 11 & 3] + var7;
            var7 -= var8;
         }

         this.field2339 -= 8;
         this.writeInt(var5);
         this.writeInt(var6);
      }

   }

   public static synchronized long method3547(int var0) {
      long var1 = System.currentTimeMillis();
      if(var1 < class184.field2351) {
         class184.field2350 += class184.field2351 - var1;
      }

      class184.field2351 = var1;
      return var1 + class184.field2350;
   }

   public static RuneScriptMap loadRuneScriptMap(int var0) {
      RuneScriptMap var2 = (RuneScriptMap) RuneScriptMap.field3342.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = RuneScriptMap.field3338.method4625(8, var0, 508738388);
         var2 = new RuneScriptMap();
         if(var3 != null) {
            var2.method4978(new Stream(var3), (byte)2);
         }

         RuneScriptMap.field3342.method3983(var2, (long)var0);
         return var2;
      }
   }
}
