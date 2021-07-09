package client;

public class class150 extends class160 {
   static Sprite[] field1919;
   static Sprite[] field1926;
   static int field1928;
   public static final int field1927 = 0;
   int field1920 = 256;
   int field1921 = 1;
   long[] field1922 = new long[10];
   int field1923 = 0;
   long field1925 = Stream.method3547(604838575);
   int field1924;

   class150() {
      for(int var1 = 0; var1 < 10; var1++) {
         this.field1922[var1] = this.field1925;
      }

   }

   public int vmethod3331(int var1, int var2, int var3) {
      int var4 = this.field1920;
      int var5 = this.field1921;
      this.field1920 = 300;
      this.field1921 = 1;
      this.field1925 = Stream.method3547(604838575);
      if(this.field1922[this.field1924] == 0L) {
         this.field1920 = var4;
         this.field1921 = var5;
      } else if(this.field1925 > this.field1922[this.field1924]) {
         this.field1920 = (int)((long)(var1 * 2560) / (this.field1925 - this.field1922[this.field1924]));
      }

      if(this.field1920 < 25) {
         this.field1920 = 25;
      }

      if(this.field1920 > 256) {
         this.field1920 = 256;
         this.field1921 = (int)((long)var1 - (this.field1925 - this.field1922[this.field1924]) / 10L);
      }

      if(this.field1921 > var1) {
         this.field1921 = var1;
      }

      this.field1922[this.field1924] = this.field1925;
      this.field1924 = (this.field1924 + 1) % 10;
      int var6;
      if(this.field1921 > 1) {
         for(var6 = 0; var6 < 10; var6++) {
            if(this.field1922[var6] != 0L) {
               this.field1922[var6] += (long)this.field1921;
            }
         }
      }

      if(this.field1921 < var2) {
         this.field1921 = var2;
      }

      class63.method1539((long)this.field1921);

      for(var6 = 0; this.field1923 < 256; this.field1923 += this.field1920) {
         ++var6;
      }

      this.field1923 &= 255;
      return var6;
   }

   public void vmethod3330(int var1) {
      for(int var2 = 0; var2 < 10; var2++) {
         this.field1922[var2] = 0L;
      }

   }
}
