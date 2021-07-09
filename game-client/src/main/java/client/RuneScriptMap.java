package client;

public class RuneScriptMap extends class206 {
   static class200 field3342 = new class200(64);
   static class243 field3346;
   public static class247 field3338;
   public int csMapValueCount = 0;
   public String csMapStringIdentifier = "null";
   public char field3336;
   public char field3337;
   public int field3341;
   public int[] csMapKeysValues;
   public String[] csMapStringValues;
   public int[] csMapIntValues;

   void method4979(Stream var1, int var2, byte var3) {
      if(var2 == 1) {
         this.field3336 = (char)var1.readUByte();
      } else if(var2 == 2) {
         this.field3337 = (char)var1.readUByte();
      } else if(var2 == 3) {
         if(var3 != 1) {
            return;
         }

         this.csMapStringIdentifier = var1.readString();
      } else if(var2 == 4) {
         this.field3341 = var1.readInt();
      } else {
         int var4;
         if(var2 == 5) {
            this.csMapValueCount = var1.readUShort();
            this.csMapKeysValues = new int[this.csMapValueCount];
            this.csMapStringValues = new String[this.csMapValueCount];

            for(var4 = 0; var4 < this.csMapValueCount; var4++) {
               this.csMapKeysValues[var4] = var1.readInt();
               this.csMapStringValues[var4] = var1.readString();
            }
         } else if(var2 == 6) {
            this.csMapValueCount = var1.readUShort();
            this.csMapKeysValues = new int[this.csMapValueCount];
            this.csMapIntValues = new int[this.csMapValueCount];

            for(var4 = 0; var4 < this.csMapValueCount; var4++) {
               this.csMapKeysValues[var4] = var1.readInt();
               this.csMapIntValues[var4] = var1.readInt();
            }
         }
      }

   }

   public int method4980(int var1) {
      return this.csMapValueCount;
   }

   void method4978(Stream var1, byte var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            if(var2 != 2) {
               return;
            }

            return;
         }

         this.method4979(var1, var3, (byte)1);
      }
   }

   public static double[] method4986(double var0, double var2, int var4, byte var5) {
      int var6 = var4 * 2 + 1;
      double[] var7 = new double[var6];
      int var8 = -var4;

      for(int var9 = 0; var8 <= var4; var9++) {
         double var16 = ((double)var8 - var0) / var2;
         double var14 = Math.exp(-var16 * var16 / 2.0D) / Math.sqrt(6.283185307179586D);
         double var12 = var14 / var2;
         var7[var9] = var12;
         ++var8;
      }

      return var7;
   }
}
