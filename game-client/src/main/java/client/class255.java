package client;

public class class255 extends class206 {
   public static class255[] field3246;
   static class200 field3251 = new class200(256);
   public static class247 field3237;
   public static int field3236;
   int[] field3245;
   public final int field3238;
   public String field3241;
   int field3234 = -1;
   public int field3239 = -1;
   public class270 field3252;
   public int field3242;
   public int field3243 = 0;
   public class252 field3253;
   int field3247 = Integer.MAX_VALUE;
   public String[] field3244 = new String[5];
   public int field3240;
   int field3249 = Integer.MIN_VALUE;
   int field3235 = Integer.MAX_VALUE;
   public String field3255;
   int field3248 = Integer.MIN_VALUE;
   int[] field3250;
   byte[] field3254;

   public class255(int var1) {
      this.field3252 = class270.field3479;
      this.field3253 = class252.field3222;
      this.field3240 = -1;
      this.field3238 = var1;
   }

   public Sprite method4815(boolean var1, byte var2) {
      int var3 = var1 ? this.field3234 : this.field3239;
      return this.method4820(var3, -1422561199);
   }

   Sprite method4820(int var1, int var2) {
      if(var1 < 0) {
         return null;
      } else {
         Sprite var3 = (Sprite)field3251.method3989((long)var1);
         if(var3 != null) {
            return var3;
         } else {
            var3 = class229.method4499(field3237, var1, 0, -1587494103);
            if(var3 != null) {
               field3251.method3983(var3, (long)var1);
            }

            return var3;
         }
      }
   }

   void method4817(Stream var1, int var2, short var3) {
      if(var2 == 1) {
         if(var3 != 4032) {
            return;
         }

         this.field3239 = var1.method3546();
      } else if(var2 == 2) {
         this.field3234 = var1.method3546();
      } else if(var2 == 3) {
         this.field3241 = var1.readString();
      } else if(var2 == 4) {
         this.field3242 = var1.readMedium();
      } else if(var2 == 5) {
         var1.readMedium();
      } else if(var2 == 6) {
         if(var3 != 4032) {
            return;
         }

         this.field3243 = var1.readUByte();
      } else {
         int var4;
         if(var2 == 7) {
            var4 = var1.readUByte();
            if((var4 & 1) == 0) {
               ;
            }

            if((var4 & 2) == 2 && var3 != 4032) {
               return;
            }
         } else if(var2 == 8) {
            var1.readUByte();
         } else if(var2 >= 10 && var2 <= 14) {
            this.field3244[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var4 = var1.readUByte();
            this.field3245 = new int[var4 * 2];

            int var5;
            for(var5 = 0; var5 < var4 * 2; var5++) {
               this.field3245[var5] = var1.readShort();
            }

            var1.readInt();
            var5 = var1.readUByte();
            this.field3250 = new int[var5];

            int var6;
            for(var6 = 0; var6 < this.field3250.length; var6++) {
               if(var3 != 4032) {
                  return;
               }

               this.field3250[var6] = var1.readInt();
            }

            this.field3254 = new byte[var4];

            for(var6 = 0; var6 < var4; var6++) {
               this.field3254[var6] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3255 = var1.readString();
            } else if(var2 == 18) {
               var1.method3546();
            } else if(var2 == 19) {
               if(var3 != 4032) {
                  return;
               }

               this.field3240 = var1.readUShort();
            } else if(var2 == 21) {
               var1.readInt();
            } else if(var2 == 22) {
               var1.readInt();
            } else if(var2 == 23) {
               var1.readUByte();
               var1.readUByte();
               var1.readUByte();
            } else if(var2 == 24) {
               var1.readShort();
               var1.readShort();
            } else if(var2 == 25) {
               var1.method3546();
            } else if(var2 == 28) {
               var1.readUByte();
            } else if(var2 == 29) {
               class270[] var7 = new class270[]{class270.field3479, class270.field3484, class270.field3481};
               this.field3252 = (class270)class76.method1803(var7, var1.readUByte(), (byte)0);
            } else if(var2 == 30) {
               class252[] var8 = new class252[]{class252.field3221, class252.field3222, class252.field3224};
               this.field3253 = (class252)class76.method1803(var8, var1.readUByte(), (byte)0);
            }
         }
      }

   }

   public int method4821(byte var1) {
      return this.field3238;
   }

   public void method4816(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            if(var2 != 248610403) {
               return;
            }

            return;
         }

         this.method4817(var1, var3, (short)4032);
      }
   }

   public void method4828(int var1) {
      if(this.field3245 != null) {
         if(var1 == -1059622656) {
            return;
         }

         for(int var2 = 0; var2 < this.field3245.length; var2 += 2) {
            if(var1 == -1059622656) {
               return;
            }

            if(this.field3245[var2] < this.field3247) {
               this.field3247 = this.field3245[var2];
            } else if(this.field3245[var2] > this.field3249) {
               this.field3249 = this.field3245[var2];
            }

            if(this.field3245[var2 + 1] < this.field3235) {
               this.field3235 = this.field3245[var2 + 1];
            } else if(this.field3245[var2 + 1] > this.field3248) {
               this.field3248 = this.field3245[var2 + 1];
            }
         }
      }

   }
}
