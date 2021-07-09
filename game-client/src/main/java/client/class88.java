package client;

public class class88 extends class105 {
   class205 field1229 = new class205();
   class205 field1230 = new class205();
   int field1232 = -1;
   int field1231 = 0;

   void method2042(int[] var1, int var2, int var3) {
      for(class105 var4 = (class105)this.field1229.method4098(); var4 != null; var4 = (class105)this.field1229.method4079()) {
         var4.method2439(var1, var2, var3);
      }

   }

   void method2025(int var1) {
      for(class105 var2 = (class105)this.field1229.method4098(); var2 != null; var2 = (class105)this.field1229.method4079()) {
         var2.vmethod4386(var1);
      }

   }

   public final synchronized void vmethod4385(int[] var1, int var2, int var3) {
      do {
         if(this.field1232 < 0) {
            this.method2042(var1, var2, var3);
            return;
         }

         if(var3 + this.field1231 < this.field1232) {
            this.field1231 += var3;
            this.method2042(var1, var2, var3);
            return;
         }

         int var4 = this.field1232 - this.field1231;
         this.method2042(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1231 += var4;
         this.method2010();
         class100 var5 = (class100)this.field1230.method4098();
         synchronized(var5) {
            int var7 = var5.method2232(this);
            if(var7 < 0) {
               var5.field1338 = 0;
               this.method2008(var5);
            } else {
               var5.field1338 = var7;
               this.method2011(var5.field2422, var5);
            }
         }
      } while(var3 != 0);

   }

   public final synchronized void vmethod4386(int var1) {
      do {
         if(this.field1232 < 0) {
            this.method2025(var1);
            return;
         }

         if(this.field1231 + var1 < this.field1232) {
            this.field1231 += var1;
            this.method2025(var1);
            return;
         }

         int var2 = this.field1232 - this.field1231;
         this.method2025(var2);
         var1 -= var2;
         this.field1231 += var2;
         this.method2010();
         class100 var3 = (class100)this.field1230.method4098();
         synchronized(var3) {
            int var5 = var3.method2232(this);
            if(var5 < 0) {
               var3.field1338 = 0;
               this.method2008(var3);
            } else {
               var3.field1338 = var5;
               this.method2011(var3.field2422, var3);
            }
         }
      } while(var1 != 0);

   }

   protected class105 vmethod4389() {
      return (class105)this.field1229.method4079();
   }

   void method2010() {
      if(this.field1231 > 0) {
         for(class100 var1 = (class100)this.field1230.method4098(); var1 != null; var1 = (class100)this.field1230.method4079()) {
            var1.field1338 -= this.field1231;
         }

         this.field1232 -= this.field1231;
         this.field1231 = 0;
      }

   }

   public final synchronized void method2032(class105 var1) {
      this.field1229.method4074(var1);
   }

   protected class105 vmethod4382() {
      return (class105)this.field1229.method4098();
   }

   public final synchronized void method2009(class105 var1) {
      var1.unlink();
   }

   void method2008(class100 var1) {
      var1.unlink();
      var1.method2231();
      class204 var2 = this.field1230.field2425.field2422;
      if(var2 == this.field1230.field2425) {
         this.field1232 = -1;
      } else {
         this.field1232 = ((class100)var2).field1338;
      }

   }

   void method2011(class204 var1, class100 var2) {
      while(this.field1230.field2425 != var1 && ((class100)var1).field1338 <= var2.field1338) {
         var1 = var1.field2422;
      }

      class205.method4075(var2, var1);
      this.field1232 = ((class100)this.field1230.field2425.field2422).field1338;
   }

   protected int vmethod4395() {
      return 0;
   }
}
