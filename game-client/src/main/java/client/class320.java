package client;

public class class320 {
   static final int field3804 = 25;
   static final int field3806 = 75;
   static final int field3808 = 50;
   static final int field3809 = 0;
   boolean field3810 = false;
   int field3803 = 0;
   class247 field3805;
   String field3807;

   class320(class247 var1) {
      this.field3805 = var1;
   }

   int method5985(byte var1) {
      if(this.field3803 < 25) {
         if(!this.field3805.method4646(class29.field251.field255, this.field3807, -1326875191)) {
            return this.field3803;
         }

         this.field3803 = 25;
      }

      if(this.field3803 == 25) {
         if(!this.field3805.method4646(this.field3807, class29.field262.field255, -1064243950)) {
            return 25 + this.field3805.method4687(this.field3807, 17959811) * 25 / 100;
         }

         this.field3803 = 50;
      }

      if(this.field3803 == 50) {
         if(this.field3805.method4644(class29.field257.field255, this.field3807, (byte)9) && !this.field3805.method4646(class29.field257.field255, this.field3807, -500533763)) {
            return 50;
         }

         this.field3803 = 75;
      }

      if(this.field3803 == 75) {
         if(!this.field3805.method4646(this.field3807, class29.field254.field255, -743302558)) {
            return 75;
         }

         this.field3803 = 100;
         this.field3810 = true;
      }

      return this.field3803;
   }

   boolean method5987(int var1) {
      return this.field3810;
   }

   void method5995(String var1, int var2) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 == this.field3807) {
            if(var2 != -1394439263) {
               ;
            }
         } else {
            this.field3807 = var1;
            this.field3803 = 0;
            this.field3810 = false;
            this.method5985((byte)80);
         }
      }
   }

   int method5988(int var1) {
      return this.field3803;
   }
}
