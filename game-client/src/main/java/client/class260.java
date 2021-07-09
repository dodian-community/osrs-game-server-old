package client;

public class class260 extends class206 {
   public static int field3294;
   public static class200 field3291 = new class200(64);
   static class247 field3290;
   static class247 field3292;
   static Widget field3301;
   static final int field3300 = 2;
   int[] field3299;
   int[] field3289 = new int[]{-1, -1, -1, -1, -1};
   public int field3293 = -1;
   public boolean field3295 = false;
   short[] field3302;
   short[] field3297;
   short[] field3296;
   short[] field3298;

   void method4909(Stream var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3293 = var1.readUByte();
      } else {
         int var4;
         int var5;
         if(var2 == 2) {
            var4 = var1.readUByte();
            this.field3299 = new int[var4];

            for(var5 = 0; var5 < var4; var5++) {
               this.field3299[var5] = var1.readUShort();
            }
         } else if(var2 == 3) {
            this.field3295 = true;
         } else if(var2 == 40) {
            var4 = var1.readUByte();
            this.field3302 = new short[var4];
            this.field3296 = new short[var4];

            for(var5 = 0; var5 < var4; var5++) {
               this.field3302[var5] = (short)var1.readUShort();
               this.field3296[var5] = (short)var1.readUShort();
            }
         } else if(var2 == 41) {
            var4 = var1.readUByte();
            this.field3297 = new short[var4];
            this.field3298 = new short[var4];

            for(var5 = 0; var5 < var4; var5++) {
               this.field3297[var5] = (short)var1.readUShort();
               this.field3298[var5] = (short)var1.readUShort();
            }
         } else if(var2 >= 60) {
            if(var3 >= -1431899603) {
               return;
            }

            if(var2 < 70) {
               this.field3289[var2 - 60] = var1.readUShort();
            }
         }
      }

   }

   public boolean method4905(int var1) {
      boolean var2 = true;

      for(int var3 = 0; var3 < 5; var3++) {
         if(this.field3289[var3] != -1 && !field3290.method4696(this.field3289[var3], 0, (byte)1)) {
            var2 = false;
         }
      }

      return var2;
   }

   public class113 method4899(int var1) {
      class113[] var2 = new class113[5];
      int var3 = 0;

      for(int var4 = 0; var4 < 5; var4++) {
         if(this.field3289[var4] != -1) {
            var2[var3++] = class113.method2568(field3290, this.field3289[var4], 0);
         }
      }

      class113 var6 = new class113(var2, var3);
      int var5;
      if(this.field3302 != null) {
         for(var5 = 0; var5 < this.field3302.length; var5++) {
            var6.method2581(this.field3302[var5], this.field3296[var5]);
         }
      }

      if(this.field3297 != null) {
         for(var5 = 0; var5 < this.field3297.length; var5++) {
            var6.method2582(this.field3297[var5], this.field3298[var5]);
         }
      }

      return var6;
   }

   public boolean method4896(byte var1) {
      if(this.field3299 == null) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field3299.length; var3++) {
            if(!field3290.method4696(this.field3299[var3], 0, (byte)1)) {
               var2 = false;
            }
         }

         return var2;
      }
   }

   void method4894(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4909(var1, var3, -1740935180);
      }
   }

   public class113 method4897(int var1) {
      if(this.field3299 == null) {
         return null;
      } else {
         class113[] var2 = new class113[this.field3299.length];

         for(int var3 = 0; var3 < this.field3299.length; var3++) {
            var2[var3] = class113.method2568(field3290, this.field3299[var3], 0);
         }

         class113 var5;
         if(var2.length == 1) {
            var5 = var2[0];
         } else {
            var5 = new class113(var2, var2.length);
         }

         int var4;
         if(this.field3302 != null) {
            for(var4 = 0; var4 < this.field3302.length; var4++) {
               var5.method2581(this.field3302[var4], this.field3296[var4]);
            }
         }

         if(this.field3297 != null) {
            for(var4 = 0; var4 < this.field3297.length; var4++) {
               var5.method2582(this.field3297[var4], this.field3298[var4]);
            }
         }

         return var5;
      }
   }

   static int method4908(int var0, int var1, int var2, int var3) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var4 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var4;
   }
}
