package client;

public class class96 {
   int field1320;
   int field1324;
   int field1316 = 2;
   int field1317;
   int field1321;
   int[] field1323 = new int[2];
   int[] field1319 = new int[2];
   int field1315;
   int field1322;
   int field1314;
   int field1318;

   class96() {
      this.field1323[0] = 0;
      this.field1323[1] = 65535;
      this.field1319[0] = 0;
      this.field1319[1] = 65535;
   }

   final void method2199(Stream var1) {
      this.field1317 = var1.readUByte();
      this.field1314 = var1.readInt();
      this.field1318 = var1.readInt();
      this.method2197(var1);
   }

   final void method2198() {
      this.field1320 = 0;
      this.field1321 = 0;
      this.field1322 = 0;
      this.field1315 = 0;
      this.field1324 = 0;
   }

   final void method2197(Stream var1) {
      this.field1316 = var1.readUByte();
      this.field1323 = new int[this.field1316];
      this.field1319 = new int[this.field1316];

      for(int var2 = 0; var2 < this.field1316; var2++) {
         this.field1323[var2] = var1.readUShort();
         this.field1319[var2] = var1.readUShort();
      }

   }

   final int method2206(int var1) {
      if(this.field1324 >= this.field1320) {
         this.field1315 = this.field1319[this.field1321++] << 15;
         if(this.field1321 >= this.field1316) {
            this.field1321 = this.field1316 - 1;
         }

         this.field1320 = (int)((double)this.field1323[this.field1321] / 65536.0D * (double)var1);
         if(this.field1320 > this.field1324) {
            this.field1322 = ((this.field1319[this.field1321] << 15) - this.field1315) / (this.field1320 - this.field1324);
         }
      }

      this.field1315 += this.field1322;
      ++this.field1324;
      return this.field1315 - this.field1322 >> 15;
   }
}
