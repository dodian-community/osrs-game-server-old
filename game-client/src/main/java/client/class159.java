package client;

import java.io.IOException;
import java.net.Socket;

public class class159 extends class157 {
   static final int field1981 = 3;
   class163 field1983;
   class151 field1980;
   Socket field1982;

   class159(Socket var1, int var2, int var3) throws IOException {
      this.field1982 = var1;
      this.field1982.setSoTimeout(30000);
      this.field1982.setTcpNoDelay(true);
      this.field1982.setReceiveBufferSize(65536);
      this.field1982.setSendBufferSize(65536);
      this.field1980 = new class151(this.field1982.getInputStream(), var2);
      this.field1983 = new class163(this.field1982.getOutputStream(), var3);
   }

   public void vmethod3346(int var1) {
      this.field1983.method3384(-1681840837);

      try {
         this.field1982.close();
      } catch (IOException var3) {
         ;
      }

      this.field1980.method3215((byte)17);
   }

   public boolean vmethod3350(int var1, byte var2) throws IOException {
      return this.field1980.method3219(var1, -1623980181);
   }

   public int vmethod3351(byte[] var1, int var2, int var3, int var4) throws IOException {
      return this.field1980.method3224(var1, var2, var3, 2131824940);
   }

   public void vmethod3347(byte[] var1, int var2, int var3, byte var4) throws IOException {
      this.field1983.method3383(var1, var2, var3, 1100841407);
   }

   public int vmethod3349(int var1) throws IOException {
      return this.field1980.method3217(-200801409);
   }

   public int vmethod3353(int var1) throws IOException {
      return this.field1980.method3218(-1567970843);
   }

   protected void finalize() {
      this.vmethod3346(1775992211);
   }

   public static Object method3324(byte[] var0, boolean var1, int var2) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class186.field2365) {
            try {
               class180 var3 = new class180();
               var3.vmethod3792(var0, 339302128);
               return var3;
            } catch (Throwable var4) {
               class186.field2365 = true;
            }
         }

         return var1 ? class59.method1075(var0, (byte)16) : var0;
      }
   }
}
