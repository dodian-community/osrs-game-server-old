package client;

public class class93 extends class108 {
   public byte[] field1278;
   public int field1279;
   public int field1277;
   public boolean field1281;
   int field1280;

   class93(int var1, byte[] var2, int var3, int var4) {
      this.field1279 = var1;
      this.field1278 = var2;
      this.field1277 = var3;
      this.field1280 = var4;
   }

   class93(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1279 = var1;
      this.field1278 = var2;
      this.field1277 = var3;
      this.field1280 = var4;
      this.field1281 = var5;
   }

   public class93 method2115(class102 var1) {
      this.field1278 = var1.method2239(this.field1278, 160754994);
      this.field1279 = var1.method2240(this.field1279, 715273606);
      if(this.field1277 == this.field1280) {
         this.field1277 = this.field1280 = var1.method2241(this.field1277, 149890453);
      } else {
         this.field1277 = var1.method2241(this.field1277, -1660716684);
         this.field1280 = var1.method2241(this.field1280, -1190618470);
         if(this.field1277 == this.field1280) {
            --this.field1277;
         }
      }

      return this;
   }
}
