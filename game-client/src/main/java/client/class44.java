package client;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class class44 extends class95 {
   AudioFormat field373;
   int field372;
   SourceDataLine field374;
   byte[] field375;

   protected void vmethod2156(int var1) {
      this.field374.flush();
   }

   protected void vmethod2155(int var1) {
      if(this.field374 != null) {
         this.field374.close();
         this.field374 = null;
      }

   }

   protected int vmethod2153(byte var1) {
      return this.field372 - (this.field374.available() >> (class95.field1295 ? 2 : 1));
   }

   protected void vmethod2163(int var1, short var2) throws LineUnavailableException {
      try {
         Info var3 = new Info(SourceDataLine.class, this.field373, var1 << (class95.field1295 ? 2 : 1));
         this.field374 = (SourceDataLine)AudioSystem.getLine(var3);
         this.field374.open();
         this.field374.start();
         this.field372 = var1;
      } catch (LineUnavailableException var6) {
         int var5 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var5 = (var5 >>> 2 & 858993459) + (var5 & 858993459);
         var5 = (var5 >>> 4) + var5 & 252645135;
         var5 += var5 >>> 8;
         var5 += var5 >>> 16;
         int var4 = var5 & 255;
         if(var4 != 1) {
            this.vmethod2163(class146.method3193(var1, (byte)5), (short)255);
         } else {
            this.field374 = null;
            throw var6;
         }
      }
   }

   protected void vmethod2154() {
      int var1 = 256;
      if(class95.field1295) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; var2++) {
         int var3 = super.field1299[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field375[var2 * 2] = (byte)(var3 >> 8);
         this.field375[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field374.write(this.field375, 0, var1 << 1);
   }

   protected void vmethod2176(int var1) {
      this.field373 = new AudioFormat((float)class95.field1300, 16, class95.field1295 ? 2 : 1, true, false);
      this.field375 = new byte[256 << (class95.field1295 ? 2 : 1)];
   }
}
