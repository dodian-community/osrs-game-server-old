package client;

import java.util.Iterator;

public class class203 implements Iterable {
   class204 field2420;
   class204 field2419 = new class204();

   public class203() {
      this.field2419.field2422 = this.field2419;
      this.field2419.field2423 = this.field2419;
   }

   class204 method4034(class204 var1) {
      class204 var2;
      if(var1 == null) {
         var2 = this.field2419.field2422;
      } else {
         var2 = var1;
      }

      if(var2 == this.field2419) {
         this.field2420 = null;
         return null;
      } else {
         this.field2420 = var2.field2422;
         return var2;
      }
   }

   public void method4030() {
      while(this.field2419.field2422 != this.field2419) {
         this.field2419.field2422.unlink();
      }

   }

   public boolean method4043() {
      return this.field2419.field2422 == this.field2419;
   }

   public class204 method4048() {
      return this.method4034((class204)null);
   }

   public void method4031(class204 var1) {
      if(var1.field2423 != null) {
         var1.unlink();
      }

      var1.field2423 = this.field2419.field2423;
      var1.field2422 = this.field2419;
      var1.field2423.field2422 = var1;
      var1.field2422.field2423 = var1;
   }

   public class204 method4033() {
      class204 var1 = this.field2420;
      if(var1 == this.field2419) {
         this.field2420 = null;
         return null;
      } else {
         this.field2420 = var1.field2422;
         return var1;
      }
   }

   public void method4038(class204 var1) {
      if(var1.field2423 != null) {
         var1.unlink();
      }

      var1.field2423 = this.field2419;
      var1.field2422 = this.field2419.field2422;
      var1.field2423.field2422 = var1;
      var1.field2422.field2423 = var1;
   }

   public Iterator iterator() {
      return new class199(this);
   }

   public static void method4036(class204 var0, class204 var1) {
      if(var0.field2423 != null) {
         var0.unlink();
      }

      var0.field2423 = var1;
      var0.field2422 = var1.field2422;
      var0.field2423.field2422 = var0;
      var0.field2422.field2423 = var0;
   }
}
