package client;

public class class258 extends class206 {
   public static class200 field3265 = new class200(30);
   public static class200 field3267 = new class200(64);
   public static class247 field3279;
   public static class247 field3272;
   int field3280;
   public int field3271 = -1;
   int field3268;
   int field3276 = 128;
   int field3277 = 128;
   int field3278 = 0;
   int field3273 = 0;
   int field3269 = 0;
   short[] field3266;
   short[] field3274;
   short[] field3275;
   short[] field3270;

   void method4865(Stream var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3268 = var1.readUShort();
      } else if(var2 == 2) {
         this.field3271 = var1.readUShort();
      } else if(var2 == 4) {
         this.field3276 = var1.readUShort();
      } else if(var2 == 5) {
         this.field3277 = var1.readUShort();
      } else if(var2 == 6) {
         this.field3278 = var1.readUShort();
      } else if(var2 == 7) {
         this.field3273 = var1.readUByte();
      } else if(var2 == 8) {
         if(var3 != 269273917) {
            return;
         }

         this.field3269 = var1.readUByte();
      } else {
         int var4;
         int var5;
         if(var2 == 40) {
            if(var3 != 269273917) {
               return;
            }

            var4 = var1.readUByte();
            this.field3266 = new short[var4];
            this.field3270 = new short[var4];

            for(var5 = 0; var5 < var4; var5++) {
               this.field3266[var5] = (short)var1.readUShort();
               this.field3270[var5] = (short)var1.readUShort();
            }
         } else if(var2 == 41) {
            var4 = var1.readUByte();
            this.field3274 = new short[var4];
            this.field3275 = new short[var4];

            for(var5 = 0; var5 < var4; var5++) {
               this.field3274[var5] = (short)var1.readUShort();
               this.field3275[var5] = (short)var1.readUShort();
            }
         }
      }

   }

   public final class119 method4866(int var1, int var2) {
      class119 var3 = (class119)field3265.method3989((long)this.field3280);
      if(var3 == null) {
         class113 var4 = class113.method2568(field3279, this.field3268, 0);
         if(var4 == null) {
            return null;
         }

         int var5;
         if(this.field3266 != null) {
            for(var5 = 0; var5 < this.field3266.length; var5++) {
               var4.method2581(this.field3266[var5], this.field3270[var5]);
            }
         }

         if(this.field3274 != null) {
            for(var5 = 0; var5 < this.field3274.length; var5++) {
               var4.method2582(this.field3274[var5], this.field3275[var5]);
            }
         }

         var3 = var4.method2589(this.field3273 + 64, this.field3269 + 850, -30, -50, -30);
         field3265.method3983(var3, (long)this.field3280);
      }

      class119 var6;
      if(this.field3271 != -1 && var1 != -1) {
         var6 = class3.method25(this.field3271, -1950684669).method5217(var3, var1, (byte)43);
      } else {
         var6 = var3.method2667(true);
      }

      if(this.field3276 != 128 || this.field3277 != 128) {
         var6.method2681(this.field3276, this.field3277, this.field3276);
      }

      if(this.field3278 != 0) {
         if(this.field3278 == 90) {
            var6.method2677();
         }

         if(this.field3278 == 180) {
            var6.method2677();
            var6.method2677();
         }

         if(this.field3278 == 270) {
            var6.method2677();
            var6.method2677();
            var6.method2677();
         }
      }

      return var6;
   }

   void method4864(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4865(var1, var3, 269273917);
      }
   }
}
