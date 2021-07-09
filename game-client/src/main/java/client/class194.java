package client;

public final class class194 {
   class206 field2393 = new class206();

   public class194() {
      this.field2393.field2426 = this.field2393;
      this.field2393.field2427 = this.field2393;
   }

   void method3912() {
      while(true) {
         class206 var1 = this.field2393.field2426;
         if(var1 == this.field2393) {
            return;
         }

         var1.method4101();
      }
   }

   class206 method3922() {
      class206 var1 = this.field2393.field2426;
      if(var1 == this.field2393) {
         return null;
      } else {
         var1.method4101();
         return var1;
      }
   }

   public void method3910(class206 var1) {
      if(var1.field2427 != null) {
         var1.method4101();
      }

      var1.field2427 = this.field2393.field2427;
      var1.field2426 = this.field2393;
      var1.field2427.field2426 = var1;
      var1.field2426.field2427 = var1;
   }

   public void method3908(class206 var1) {
      if(var1.field2427 != null) {
         var1.method4101();
      }

      var1.field2427 = this.field2393;
      var1.field2426 = this.field2393.field2426;
      var1.field2427.field2426 = var1;
      var1.field2426.field2427 = var1;
   }

   public class206 method3932() {
      class206 var1 = this.field2393.field2426;
      return var1 == this.field2393 ? null : var1;
   }

   static void method3909(class206 var0, class206 var1) {
      if(var0.field2427 != null) {
         var0.method4101();
      }

      var0.field2427 = var1;
      var0.field2426 = var1.field2426;
      var0.field2427.field2426 = var0;
      var0.field2426.field2427 = var0;
   }
}
