package client;

public final class PacketBuffer extends Stream {
   static final int[] field2374 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   static final int field2376 = 4;
   static final int field2377 = 25;
   Isaac field2373;
   int field2375;

   public PacketBuffer(int var1) {
      super(var1);
   }

   public boolean method3821(int var1) {
      int var2 = super.field2338[super.field2339] - this.field2373.method3853() & 255;
      return var2 >= 128;
   }

   public void method3838(Isaac var1, byte var2) {
      this.field2373 = var1;
   }

   public void method3819(int var1, byte var2) {
      byte[] var10000 = super.field2338;
      int var10001 = super.field2339 + 1;
      ++super.field2339;
      var10000[var10001 - 1] = (byte)(var1 + this.field2373.method3850());
   }

   public int method3820(int var1) {
      byte[] var10000 = super.field2338;
      int var10001 = super.field2339 + 1;
      ++super.field2339;
      return var10000[var10001 - 1] - this.field2373.method3850() & 255;
   }

   public void startBitMode() {
      this.field2375 = super.field2339 * 8;
   }

   public void endBitMode() {
      super.field2339 = (this.field2375 + 7) / 8;
   }

   public int readBits(int var1) {
      int var3 = this.field2375 >> 3;
      int var4 = 8 - (this.field2375 & 7);
      int var5 = 0;

      for(this.field2375 += var1; var1 > var4; var4 = 8) {
         var5 += (super.field2338[var3++] & field2374[var4]) << var1 - var4;
         var1 -= var4;
      }

      if(var4 == var1) {
         var5 += super.field2338[var3] & field2374[var4];
      } else {
         var5 += super.field2338[var3] >> var4 - var1 & field2374[var1];
      }

      return var5;
   }

   public int method3825(int var1, int var2) {
      return var1 * 8 - this.field2375;
   }

   public int method3841(int var1) {
      byte[] var10000 = super.field2338;
      int var10001 = super.field2339 + 1;
      ++super.field2339;
      int var2 = var10000[var10001 - 1] - this.field2373.method3850() & 255;
      if(var2 < 128) {
         return var2;
      } else {
         int var3 = var2 - 128 << 8;
         byte[] var4 = super.field2338;
         int var10002 = super.field2339 + 1;
         ++super.field2339;
         return var3 + (var4[var10002 - 1] - this.field2373.method3850() & 255);
      }
   }

   public void method3836(int[] var1, int var2) {
      this.field2373 = new Isaac(var1);
   }

   static void method3848(short var0) {
      Object var1 = class248.field3184;
      synchronized(class248.field3184) {
         if(class248.field3179 == 0) {
            class248.field3183 = new Thread(new class248());
            class248.field3183.setDaemon(true);
            class248.field3183.start();
            class248.field3183.setPriority(5);
         }

         class248.field3179 = 600;
      }
   }

   public static class307 method3847(int var0, short var1) {
      class307[] var2 = new class307[]{class307.field3733, class307.field3732, class307.field3734};
      class307[] var3 = var2;

      for(int var4 = 0; var4 < var3.length; var4++) {
         class307 var5 = var3[var4];
         if(var0 == var5.field3735) {
            return var5;
         }
      }

      return null;
   }

   public static int method3840(Stream var0, String var1, byte var2) {
      int var3 = var0.field2339;
      byte[] var4 = class244.method4618(var1, -1251005186);
      var0.method3573(var4.length, -1027102667);
      var0.field2339 += class300.field3712.method3475(var4, 0, var4.length, var0.field2338, var0.field2339, -1994775044);
      return var0.field2339 - var3;
   }
}
