package client;

public class class204 {
   class204 field2423;
   public class204 field2422;
   public long field2421;

   public void unlink() {
      if(this.field2423 != null) {
         this.field2423.field2422 = this.field2422;
         this.field2422.field2423 = this.field2423;
         this.field2422 = null;
         this.field2423 = null;
      }
   }

   public boolean method4065() {
      return this.field2423 != null;
   }
}
