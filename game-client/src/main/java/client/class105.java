package client;

public abstract class class105 extends class204 {
   volatile boolean field1385 = true;
   class108 field1383;
   class105 field1382;
   int field1384;

   protected abstract void vmethod4385(int[] var1, int var2, int var3);

   protected abstract void vmethod4386(int var1);

   final void method2439(int[] var1, int var2, int var3) {
      if(this.field1385) {
         this.vmethod4385(var1, var2, var3);
      } else {
         this.vmethod4386(var3);
      }

   }

   protected abstract class105 vmethod4389();

   protected abstract class105 vmethod4382();

   int vmethod2435() {
      return 255;
   }

   protected abstract int vmethod4395();
}
