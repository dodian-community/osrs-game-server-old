package client;

import java.util.Iterator;

public final class class197 implements Iterable {
   int field2398;
   int field2396 = 0;
   class204[] field2397;
   class204 field2399;
   class204 field2400;

   public class197(int var1) {
      this.field2398 = var1;
      this.field2397 = new class204[var1];

      for(int var2 = 0; var2 < var1; var2++) {
         class204 var3 = this.field2397[var2] = new class204();
         var3.field2422 = var3;
         var3.field2423 = var3;
      }

   }

   public class204 method3945(long var1) {
      class204 var3 = this.field2397[(int)(var1 & (long)(this.field2398 - 1))];

      for(this.field2400 = var3.field2422; var3 != this.field2400; this.field2400 = this.field2400.field2422) {
         if(this.field2400.field2421 == var1) {
            class204 var4 = this.field2400;
            this.field2400 = this.field2400.field2422;
            return var4;
         }
      }

      this.field2400 = null;
      return null;
   }

   public class204 method3947() {
      class204 var1;
      if(this.field2396 > 0 && this.field2397[this.field2396 - 1] != this.field2399) {
         var1 = this.field2399;
         this.field2399 = var1.field2422;
         return var1;
      } else {
         do {
            if(this.field2396 >= this.field2398) {
               return null;
            }

            var1 = this.field2397[this.field2396++].field2422;
         } while(var1 == this.field2397[this.field2396 - 1]);

         this.field2399 = var1.field2422;
         return var1;
      }
   }

   public void method3951() {
      for(int var1 = 0; var1 < this.field2398; var1++) {
         class204 var2 = this.field2397[var1];

         while(true) {
            class204 var3 = var2.field2422;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2400 = null;
      this.field2399 = null;
   }

   public Iterator iterator() {
      return new class210(this);
   }

   public void method3944(class204 var1, long var2) {
      if(var1.field2423 != null) {
         var1.unlink();
      }

      class204 var4 = this.field2397[(int)(var2 & (long)(this.field2398 - 1))];
      var1.field2423 = var4.field2423;
      var1.field2422 = var4;
      var1.field2423.field2422 = var1;
      var1.field2422.field2423 = var1;
      var1.field2421 = var2;
   }

   public class204 method3955() {
      this.field2396 = 0;
      return this.method3947();
   }
}
