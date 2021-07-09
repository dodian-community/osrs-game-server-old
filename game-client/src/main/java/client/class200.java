package client;

public final class class200 {
   int field2407;
   class202 field2408;
   class194 field2405 = new class194();
   class206 field2409 = new class206();
   int field2406;

   public class200(int var1) {
      this.field2406 = var1;
      this.field2407 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field2408 = new class202(var2);
   }

   public class206 method3989(long var1) {
      class206 var3 = (class206)this.field2408.get(var1);
      if(var3 != null) {
         this.field2405.method3910(var3);
      }

      return var3;
   }

   public void method3983(class206 var1, long var2) {
      if(this.field2407 == 0) {
         class206 var4 = this.field2405.method3922();
         var4.unlink();
         var4.method4101();
         if(var4 == this.field2409) {
            var4 = this.field2405.method3922();
            var4.unlink();
            var4.method4101();
         }
      } else {
         --this.field2407;
      }

      this.field2408.method4016(var1, var2);
      this.field2405.method3910(var1);
   }

   public void method3984() {
      this.field2405.method3912();
      this.field2408.method4017();
      this.field2409 = new class206();
      this.field2407 = this.field2406;
   }

   public void method3982(long var1) {
      class206 var3 = (class206)this.field2408.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method4101();
         ++this.field2407;
      }

   }
}
