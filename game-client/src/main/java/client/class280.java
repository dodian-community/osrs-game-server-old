package client;

public class class280 {
   static final int field3607 = 15;
   long field3601 = 0L;
   public boolean field3597 = false;
   long field3599 = -1L;
   long field3598 = -1L;
   int field3603 = 0;
   int field3605 = 0;
   long field3600 = 0L;
   long field3602 = 0L;
   int field3604 = 0;
   int field3606 = 0;

   public void method5247(int var1) {
      if(this.field3598 != -1L) {
         this.field3600 = Stream.method3547(604838575) - this.field3598;
         this.field3598 = -1L;
      }

      ++this.field3605;
      this.field3597 = true;
   }

   public void method5262(byte var1) {
      if(this.field3599 != -1L) {
         this.field3601 = Stream.method3547(604838575) - this.field3599;
         this.field3599 = -1L;
      }

   }

   public void method5244(byte var1) {
      this.field3599 = Stream.method3547(604838575);
   }

   public void method5246(int var1, int var2) {
      this.field3598 = Stream.method3547(604838575);
      this.field3604 = var1;
   }

   public void method5245(Stream var1, byte var2) {
      long var3 = this.field3601;
      var3 /= 10L;
      if(var3 < 0L) {
         var3 = 0L;
      } else if(var3 > 65535L) {
         var3 = 65535L;
      }

      var1.writeShort((int)var3);
      long var5 = this.field3600;
      var5 /= 10L;
      if(var5 < 0L) {
         var5 = 0L;
      } else if(var5 > 65535L) {
         var5 = 65535L;
      }

      var1.writeShort((int)var5);
      long var7 = this.field3602;
      var7 /= 10L;
      if(var7 < 0L) {
         var7 = 0L;
      } else if(var7 > 65535L) {
         var7 = 65535L;
      }

      var1.writeShort((int)var7);
      var1.writeShort(this.field3604);
      var1.writeShort(this.field3603);
      var1.writeShort(this.field3605);
      var1.writeShort(this.field3606);
   }

   public void method5248(int var1) {
      this.field3597 = false;
      this.field3603 = 0;
   }

   public void method5249(int var1) {
      this.method5247(-222960010);
   }
}
