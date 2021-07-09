package client;

public class class208 {
   class209 field2431 = new class209();
   class209 field2430;

   public class208() {
      this.field2431.field2432 = this.field2431;
      this.field2431.field2433 = this.field2431;
   }

   public class209 method4111() {
      class209 var1 = this.field2431.field2432;
      if(var1 == this.field2431) {
         this.field2430 = null;
         return null;
      } else {
         this.field2430 = var1.field2432;
         return var1;
      }
   }

   public class209 method4114() {
      class209 var1 = this.field2430;
      if(var1 == this.field2431) {
         this.field2430 = null;
         return null;
      } else {
         this.field2430 = var1.field2432;
         return var1;
      }
   }

   public void method4112(class209 var1) {
      if(var1.field2433 != null) {
         var1.method4121();
      }

      var1.field2433 = this.field2431.field2433;
      var1.field2432 = this.field2431;
      var1.field2433.field2432 = var1;
      var1.field2432.field2433 = var1;
   }
}
