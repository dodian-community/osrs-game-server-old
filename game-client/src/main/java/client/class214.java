package client;

import java.util.Iterator;

public class class214 implements Iterator {
   class206 field2441;
   class206 field2443 = null;
   class215 field2442;

   class214(class215 var1) {
      this.field2442 = var1;
      this.field2441 = this.field2442.field2445.field2426;
      this.field2443 = null;
   }

   public boolean hasNext() {
      return this.field2442.field2445 != this.field2441;
   }

   public Object next() {
      class206 var1 = this.field2441;
      if(var1 == this.field2442.field2445) {
         var1 = null;
         this.field2441 = null;
      } else {
         this.field2441 = var1.field2426;
      }

      this.field2443 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2443 == null) {
         throw new IllegalStateException();
      } else {
         this.field2443.method4101();
         this.field2443 = null;
      }
   }
}
