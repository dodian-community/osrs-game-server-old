package client;

public class class220 {
   static final byte[] field2527 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   static final int field2518 = 2;
   static final int field2522 = 500000;
   static final int field2528 = 0;
   static final int field2529 = 1;
   static final int field2531 = 3;
   long field2526;
   int[] field2521;
   Stream field2530 = new Stream((byte[])null);
   int field2524;
   int[] field2520;
   int[] field2525;
   int[] field2523;
   int field2519;

   class220(byte[] var1) {
      this.method4328(var1);
   }

   class220() {
   }

   int method4327(int var1) {
      byte var2 = this.field2530.field2338[this.field2530.field2339];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2523[var1] = var5;
         ++this.field2530.field2339;
      } else {
         var5 = this.field2523[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4337(var1, var5);
      } else {
         int var3 = this.field2530.method3566(761175409);
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2530.field2338[this.field2530.field2339] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2530.field2339;
               this.field2523[var1] = var4;
               return this.method4337(var1, var4);
            }
         }

         this.field2530.field2339 += var3;
         return 0;
      }
   }

   void method4329() {
      this.field2530.field2338 = null;
      this.field2520 = null;
      this.field2521 = null;
      this.field2525 = null;
      this.field2523 = null;
   }

   boolean method4345() {
      return this.field2530.field2338 != null;
   }

   void method4328(byte[] var1) {
      this.field2530.field2338 = var1;
      this.field2530.field2339 = 10;
      int var2 = this.field2530.readUShort();
      this.field2519 = this.field2530.readUShort();
      this.field2524 = 500000;
      this.field2520 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2530.field2339 += var5) {
         int var4 = this.field2530.readInt();
         var5 = this.field2530.readInt();
         if(var4 == 1297379947) {
            this.field2520[var3] = this.field2530.field2339;
            ++var3;
         }
      }

      this.field2526 = 0L;
      this.field2521 = new int[var2];

      for(var3 = 0; var3 < var2; var3++) {
         this.field2521[var3] = this.field2520[var3];
      }

      this.field2525 = new int[var2];
      this.field2523 = new int[var2];
   }

   int method4339() {
      int var1 = this.field2521.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; var4++) {
         if(this.field2521[var4] >= 0 && this.field2525[var4] < var3) {
            var2 = var4;
            var3 = this.field2525[var4];
         }
      }

      return var2;
   }

   void method4350(int var1) {
      this.field2530.field2339 = this.field2521[var1];
   }

   int method4331() {
      return this.field2521.length;
   }

   int method4336(int var1) {
      int var2 = this.method4327(var1);
      return var2;
   }

   void method4335(int var1) {
      int var2 = this.field2530.method3566(448998940);
      this.field2525[var1] += var2;
   }

   int method4337(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2530.readUByte();
         var4 = this.field2530.method3566(-798060874);
         if(var7 == 47) {
            this.field2530.field2339 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2530.readMedium();
            var4 -= 3;
            int var6 = this.field2525[var1];
            this.field2526 += (long)var6 * (long)(this.field2524 - var5);
            this.field2524 = var5;
            this.field2530.field2339 += var4;
            return 2;
         } else {
            this.field2530.field2339 += var4;
            return 3;
         }
      } else {
         byte var3 = field2527[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2530.readUByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2530.readUByte() << 16;
         }

         return var4;
      }
   }

   void method4334() {
      this.field2530.field2339 = -1;
   }

   void method4333(int var1) {
      this.field2521[var1] = this.field2530.field2339;
   }

   boolean method4340() {
      int var1 = this.field2521.length;

      for(int var2 = 0; var2 < var1; var2++) {
         if(this.field2521[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   long method4338(int var1) {
      return this.field2526 + (long)var1 * (long)this.field2524;
   }

   void method4341(long var1) {
      this.field2526 = var1;
      int var3 = this.field2521.length;

      for(int var4 = 0; var4 < var3; var4++) {
         this.field2525[var4] = 0;
         this.field2523[var4] = 0;
         this.field2530.field2339 = this.field2520[var4];
         this.method4335(var4);
         this.field2521[var4] = this.field2530.field2339;
      }

   }
}
