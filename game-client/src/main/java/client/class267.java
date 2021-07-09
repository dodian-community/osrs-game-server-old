package client;

public class class267 extends class206 {
   public static class200 field3351 = new class200(20);
   public static class200 field3349 = new class200(64);
   public static class200 field3356 = new class200(64);
   static class247 field3367;
   static class247 field3348;
   public static final int field3352 = 1;
   String field3363 = "";
   int field3362 = -1;
   int field3357 = -1;
   int field3358 = -1;
   int field3350 = -1;
   int field3359 = -1;
   int field3353 = -1;
   int field3368 = -1;
   public int field3364 = 16777215;
   public int field3360 = -1;
   public int field3355 = 70;
   public int[] field3366;
   public int field3365 = 0;
   public int field3354 = -1;
   public int field3361 = 0;
   public int field3347 = 0;

   void method4991(Stream var1, int var2, byte var3) {
      if(var2 == 1) {
         this.field3353 = var1.method3546();
      } else if(var2 == 2) {
         this.field3364 = var1.readMedium();
      } else if(var2 == 3) {
         this.field3358 = var1.method3546();
      } else if(var2 == 4) {
         this.field3350 = var1.method3546();
      } else if(var2 == 5) {
         this.field3357 = var1.method3546();
      } else if(var2 == 6) {
         this.field3359 = var1.method3546();
      } else if(var2 == 7) {
         this.field3365 = var1.readShort();
      } else if(var2 == 8) {
         if(var3 <= 16) {
            return;
         }

         this.field3363 = var1.method3558();
      } else if(var2 == 9) {
         this.field3355 = var1.readUShort();
      } else if(var2 == 10) {
         this.field3361 = var1.readShort();
      } else if(var2 == 11) {
         this.field3354 = 0;
      } else if(var2 == 12) {
         if(var3 <= 16) {
            return;
         }

         this.field3360 = var1.readUByte();
      } else if(var2 == 13) {
         this.field3347 = var1.readShort();
      } else if(var2 == 14) {
         this.field3354 = var1.readUShort();
      } else {
         if(var2 != 17) {
            if(var3 <= 16) {
               return;
            }

            if(var2 != 18) {
               return;
            }
         }

         this.field3362 = var1.readUShort();
         if(this.field3362 == 65535) {
            this.field3362 = -1;
         }

         this.field3368 = var1.readUShort();
         if(this.field3368 == 65535) {
            this.field3368 = -1;
         }

         int var4 = -1;
         if(var2 == 18) {
            var4 = var1.readUShort();
            if(var4 == 65535) {
               var4 = -1;
            }
         }

         int var5 = var1.readUByte();
         this.field3366 = new int[var5 + 2];

         for(int var6 = 0; var6 <= var5; var6++) {
            this.field3366[var6] = var1.readUShort();
            if(this.field3366[var6] == 65535) {
               this.field3366[var6] = -1;
            }
         }

         this.field3366[var5 + 1] = var4;
      }

   }

   void method4990(Stream var1, byte var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4991(var1, var3, (byte)67);
      }
   }

   public final class267 method4995(int var1) {
      int var2 = -1;
      if(this.field3362 != -1) {
         var2 = class163.method3389(this.field3362, -397804509);
      } else if(this.field3368 != -1) {
         var2 = class225.field2558[this.field3368];
      }

      int var3;
      if(var2 >= 0 && var2 < this.field3366.length - 1) {
         var3 = this.field3366[var2];
      } else {
         var3 = this.field3366[this.field3366.length - 1];
      }

      return var3 != -1 ? class14.method123(var3, (byte)0) : null;
   }

   public Sprite method4994(int var1) {
      if(this.field3358 < 0) {
         return null;
      } else {
         Sprite var2 = (Sprite)field3356.method3989((long)this.field3358);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class229.method4499(field3348, this.field3358, 0, -767439221);
            if(var2 != null) {
               field3356.method3983(var2, (long)this.field3358);
            }

            return var2;
         }
      }
   }

   public Sprite method5000(int var1) {
      if(this.field3357 < 0) {
         return null;
      } else {
         Sprite var2 = (Sprite)field3356.method3989((long)this.field3357);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class229.method4499(field3348, this.field3357, 0, -2050810966);
            if(var2 != null) {
               field3356.method3983(var2, (long)this.field3357);
            }

            return var2;
         }
      }
   }

   public Sprite method4996(byte var1) {
      if(this.field3350 < 0) {
         return null;
      } else {
         Sprite var2 = (Sprite)field3356.method3989((long)this.field3350);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class229.method4499(field3348, this.field3350, 0, -1223638051);
            if(var2 != null) {
               field3356.method3983(var2, (long)this.field3350);
            }

            return var2;
         }
      }
   }

   public Sprite method4997(int var1) {
      if(this.field3359 < 0) {
         return null;
      } else {
         Sprite var2 = (Sprite)field3356.method3989((long)this.field3359);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class229.method4499(field3348, this.field3359, 0, -2111276316);
            if(var2 != null) {
               field3356.method3983(var2, (long)this.field3359);
            }

            return var2;
         }
      }
   }

   public class298 method4998(byte var1) {
      if(this.field3353 == -1) {
         return null;
      } else {
         class298 var2 = (class298)field3351.method3989((long)this.field3353);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class58.method1058(field3348, class139.field1877, this.field3353, 0, -2132588897);
            if(var2 != null) {
               field3351.method3983(var2, (long)this.field3353);
            }

            return var2;
         }
      }
   }

   public String method5014(int var1, byte var2) {
      String var3 = this.field3363;

      while(true) {
         int var4 = var3.indexOf("%1");
         if(var4 < 0) {
            return var3;
         }

         String var5 = var3.substring(0, var4);
         String var6 = Integer.toString(var1);
         var3 = var5 + var6 + var3.substring(var4 + 2);
      }
   }
}
