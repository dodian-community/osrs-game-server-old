package client;

import java.util.Iterator;

public class class199 implements Iterator {
   class204 field2403;
   class204 field2402 = null;
   class203 field2404;

   class199(class203 var1) {
      this.field2404 = var1;
      this.field2403 = this.field2404.field2419.field2422;
      this.field2402 = null;
   }

   public Object next() {
      class204 var1 = this.field2403;
      if(var1 == this.field2404.field2419) {
         var1 = null;
         this.field2403 = null;
      } else {
         this.field2403 = var1.field2422;
      }

      this.field2402 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2404.field2419 != this.field2403;
   }

   public void remove() {
      if(this.field2402 == null) {
         throw new IllegalStateException();
      } else {
         this.field2402.unlink();
         this.field2402 = null;
      }
   }
}
