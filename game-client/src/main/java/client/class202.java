package client;

public final class class202 {
   int field2414;
   class204[] field2415;
   int field2418 = 0;
   class204 field2417;
   class204 field2416;

   public class202(int var1) {
      this.field2414 = var1;
      this.field2415 = new class204[var1];

      for(int var2 = 0; var2 < var1; var2++) {
         class204 var3 = this.field2415[var2] = new class204();
         var3.field2422 = var3;
         var3.field2423 = var3;
      }

   }

   public class204 method4018() {
      this.field2418 = 0;
      return this.method4019();
   }

   public class204 get(long var1) {
      class204 var3 = this.field2415[(int)(var1 & (long)(this.field2414 - 1))];

      for(this.field2416 = var3.field2422; var3 != this.field2416; this.field2416 = this.field2416.field2422) {
         if(this.field2416.field2421 == var1) {
            class204 var4 = this.field2416;
            this.field2416 = this.field2416.field2422;
            return var4;
         }
      }

      this.field2416 = null;
      return null;
   }

   public class204 method4019() {
      class204 var1;
      if(this.field2418 > 0 && this.field2415[this.field2418 - 1] != this.field2417) {
         var1 = this.field2417;
         this.field2417 = var1.field2422;
         return var1;
      } else {
         do {
            if(this.field2418 >= this.field2414) {
               return null;
            }

            var1 = this.field2415[this.field2418++].field2422;
         } while(var1 == this.field2415[this.field2418 - 1]);

         this.field2417 = var1.field2422;
         return var1;
      }
   }

   void method4017() {
      for(int var1 = 0; var1 < this.field2414; var1++) {
         class204 var2 = this.field2415[var1];

         while(true) {
            class204 var3 = var2.field2422;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2416 = null;
      this.field2417 = null;
   }

   public void method4016(class204 var1, long var2) {
      if(var1.field2423 != null) {
         var1.unlink();
      }

      class204 var4 = this.field2415[(int)(var2 & (long)(this.field2414 - 1))];
      var1.field2423 = var4.field2423;
      var1.field2422 = var4;
      var1.field2423.field2422 = var1;
      var1.field2422.field2423 = var1;
      var1.field2421 = var2;
   }
}
