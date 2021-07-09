package client;

import java.nio.ByteBuffer;

public class class180 extends class186 {
   ByteBuffer field2293;

   void vmethod3792(byte[] var1, int var2) {
      this.field2293 = ByteBuffer.allocateDirect(var1.length);
      this.field2293.position(0);
      this.field2293.put(var1);
   }

   byte[] vmethod3789(byte var1) {
      byte[] var2 = new byte[this.field2293.capacity()];
      this.field2293.position(0);
      this.field2293.get(var2);
      return var2;
   }
}
