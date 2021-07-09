package client;

public class class27 implements class31 {
   static int field230;
   static class324 field228;
   static int field224;
   static short[] field231;
   static final int field232 = 8192;
   int field226;
   int field233;
   int field229;
   int field225;
   int field234;
   int field227;

   public boolean vmethod637(int var1, int var2, int var3) {
      return var1 >> 6 == this.field233 && var2 >> 6 == this.field229;
   }

   public boolean vmethod636(int var1, int var2, int var3, int var4) {
      return var1 >= this.field226 && var1 < this.field226 + this.field225 ? var2 >> 6 == this.field234 && var3 >> 6 == this.field227 : false;
   }

   public void vmethod635(class20 var1, byte var2) {
      if(var1.field166 > this.field233) {
         var1.field166 = this.field233;
      }

      if(var1.field167 < this.field233) {
         var1.field167 = this.field233;
      }

      if(var1.field168 > this.field229) {
         var1.field168 = this.field229;
      }

      if(var1.field162 < this.field229) {
         var1.field162 = this.field229;
      }

   }

   public class226 vmethod659(int var1, int var2, int var3) {
      if(!this.vmethod637(var1, var2, -658565537)) {
         return null;
      } else {
         int var4 = this.field234 * 64 - this.field233 * 64 + var1;
         int var5 = this.field227 * 64 - this.field229 * 64 + var2;
         return new class226(this.field226, var4, var5);
      }
   }

   public int[] vmethod638(int var1, int var2, int var3, byte var4) {
      if(!this.vmethod636(var1, var2, var3, 1813669271)) {
         return null;
      } else {
         int[] var5 = new int[]{this.field233 * 64 - this.field234 * 64 + var2, var3 + (this.field229 * 64 - this.field227 * 64)};
         return var5;
      }
   }

   void method442(byte var1) {
   }

   public void vmethod639(Stream var1, byte var2) {
      this.field226 = var1.readUByte();
      this.field225 = var1.readUByte();
      this.field234 = var1.readUShort();
      this.field227 = var1.readUShort();
      this.field233 = var1.readUShort();
      this.field229 = var1.readUShort();
      this.method442((byte)23);
   }

   static final int method460(int var0, int var1, int var2, int var3) {
      int var4 = var0 >> 7;
      int var5 = var1 >> 7;
      if(var4 >= 0 && var5 >= 0 && var4 <= 103 && var5 <= 103) {
         int var6 = var2;
         if(var2 < 3 && (class50.field443[1][var4][var5] & 2) == 2) {
            var6 = var2 + 1;
         }

         int var7 = var0 & 127;
         int var8 = var1 & 127;
         int var9 = (128 - var7) * class50.field459[var6][var4][var5] + var7 * class50.field459[var6][var4 + 1][var5] >> 7;
         int var10 = var7 * class50.field459[var6][var4 + 1][var5 + 1] + class50.field459[var6][var4][var5 + 1] * (128 - var7) >> 7;
         return var10 * var8 + var9 * (128 - var8) >> 7;
      } else {
         return 0;
      }
   }

   public static int method435(int var0, byte var1) {
      return class109.method2484(class120.field1647[var0]);
   }
}
