package client;

import java.lang.ref.SoftReference;

public class class207 extends class212 {
   SoftReference field2429;

   class207(Object var1, int var2) {
      super(var2);
      this.field2429 = new SoftReference(var1);
   }

   boolean vmethod4136() {
      return true;
   }

   Object vmethod4137() {
      return this.field2429.get();
   }
}
