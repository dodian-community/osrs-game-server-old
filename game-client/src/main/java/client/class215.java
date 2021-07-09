package client;

import java.util.Iterator;

public class class215 implements Iterable {
   class206 field2444;
   public class206 field2445 = new class206();

   public class215() {
      this.field2445.field2426 = this.field2445;
      this.field2445.field2427 = this.field2445;
   }

   class206 method4160(class206 var1) {
      class206 var2;
      if(var1 == null) {
         var2 = this.field2445.field2426;
      } else {
         var2 = var1;
      }

      if(var2 == this.field2445) {
         this.field2444 = null;
         return null;
      } else {
         this.field2444 = var2.field2426;
         return var2;
      }
   }

   class206 method4177() {
      return this.method4160((class206)null);
   }

   public void method4168() {
      while(this.field2445.field2426 != this.field2445) {
         this.field2445.field2426.method4101();
      }

   }

   class206 method4156() {
      class206 var1 = this.field2445.field2426;
      if(var1 == this.field2445) {
         return null;
      } else {
         var1.method4101();
         return var1;
      }
   }

   class206 method4159() {
      class206 var1 = this.field2444;
      if(var1 == this.field2445) {
         this.field2444 = null;
         return null;
      } else {
         this.field2444 = var1.field2426;
         return var1;
      }
   }

   public void method4155(class206 var1) {
      if(var1.field2427 != null) {
         var1.method4101();
      }

      var1.field2427 = this.field2445.field2427;
      var1.field2426 = this.field2445;
      var1.field2427.field2426 = var1;
      var1.field2426.field2427 = var1;
   }

   public Iterator iterator() {
      return new class214(this);
   }
}
