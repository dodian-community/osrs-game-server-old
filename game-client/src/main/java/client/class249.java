package client;

import java.util.zip.CRC32;

public class class249 extends class247 {
   static CRC32 field3189 = new CRC32();
   static int field3192;
   class162 field3186;
   class162 field3195;
   int field3190;
   volatile boolean field3188 = false;
   volatile boolean[] field3185;
   int field3187;
   int field3193;
   int field3194 = -1;
   boolean field3191 = false;

   public class249(class162 var1, class162 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3195 = var1;
      this.field3186 = var2;
      this.field3187 = var3;
      this.field3191 = var6;
      int var8 = this.field3187;
      if(class185.field2359 != null) {
         class185.field2359.field2339 = var8 * 8 + 5;
         int var9 = class185.field2359.readInt();
         int var10 = class185.field2359.readInt();
         this.method4723(var9, var10, 473001662);
      } else {
         class22.method280((class249)null, 255, 255, 0, (byte)0, true, -1235545078);
         class250.field3201[var8] = this;
      }

   }

   void vmethod4722(int var1, byte var2) {
      if(this.field3195 != null && this.field3185 != null && this.field3185[var1]) {
         class162 var3 = this.field3195;
         byte[] var5 = null;
         class205 var6 = class248.field3182;
         synchronized(class248.field3182) {
            for(class245 var7 = (class245)class248.field3182.method4098(); var7 != null; var7 = (class245)class248.field3182.method4079()) {
               if((long)var1 == var7.field2421 && var3 == var7.field3151) {
                  if(var2 <= 4) {
                     return;
                  }

                  if(var7.field3150 == 0) {
                     var5 = var7.field3149;
                     break;
                  }
               }
            }
         }

         if(var5 != null) {
            this.method4746(var3, var1, var5, true, (byte)-58);
         } else {
            byte[] var10 = var3.method3372(var1, 1864779903);
            this.method4746(var3, var1, var10, true, (byte)5);
         }
      } else {
         class22.method280(this, this.field3187, var1, super.field3164[var1], (byte)2, true, -1235545078);
      }

   }

   public boolean method4734(int var1, int var2) {
      return this.method4668(var1, -814741586) != null;
   }

   int vmethod4727(int var1, byte var2) {
      if(super.field3165[var1] != null) {
         return 100;
      } else if(this.field3185[var1]) {
         return 100;
      } else {
         int var4 = this.field3187;
         long var5 = (long)((var4 << 16) + var1);
         int var3;
         if(class250.field3208 != null && var5 == class250.field3208.field2421) {
            var3 = class301.field3713.field2339 * 99 / (class301.field3713.field2338.length - class250.field3208.field3157) + 1;
         } else {
            var3 = 0;
         }

         return var3;
      }
   }

   void method4726(int var1) {
      this.field3185 = new boolean[super.field3165.length];

      int var2;
      for(var2 = 0; var2 < this.field3185.length; var2++) {
         this.field3185[var2] = false;
      }

      if(this.field3195 == null) {
         this.field3188 = true;
      } else {
         this.field3194 = -1;

         for(var2 = 0; var2 < this.field3185.length; var2++) {
            if(super.field3166[var2] > 0) {
               class162 var3 = this.field3195;
               class245 var5 = new class245();
               var5.field3150 = 1;
               var5.field2421 = (long)var2;
               var5.field3151 = var3;
               var5.field3152 = this;
               class205 var6 = class248.field3182;
               synchronized(class248.field3182) {
                  class248.field3182.method4073(var5);
               }

               PacketBuffer.method3848((short)14835);
               this.field3194 = var2;
            }
         }

         if(this.field3194 == -1) {
            if(var1 <= -352122290) {
               return;
            }

            this.field3188 = true;
         }

      }
   }

   void vmethod4721(int var1, byte var2) {
      class54.method1021(this.field3187, var1, 1976820406);
   }

   public boolean method4725(int var1, int var2) {
      return this.field3185[var1];
   }

   void method4746(class162 var1, int var2, byte[] var3, boolean var4, byte var5) {
      label112: {
         int var6;
         if(var1 == this.field3186) {
            if(var5 == 1) {
               return;
            }

            if(this.field3188) {
               if(var5 == 1) {
                  return;
               }

               throw new RuntimeException();
            }

            if(var3 == null) {
               class22.method280(this, 255, this.field3187, this.field3190, (byte)0, true, -1235545078);
               return;
            }

            field3189.reset();
            field3189.update(var3, 0, var3.length);
            var6 = (int)field3189.getValue();
            if(var6 != this.field3190) {
               class22.method280(this, 255, this.field3187, this.field3190, (byte)0, true, -1235545078);
               return;
            }

            Stream var10 = new Stream(GameShell.method912(var3, -1083003215));
            int var8 = var10.readUByte();
            if(var8 != 5 && var8 != 6) {
               throw new RuntimeException(var8 + "," + this.field3187 + "," + var2);
            }

            int var9 = 0;
            if(var8 >= 6) {
               var9 = var10.readInt();
            }

            if(var9 != this.field3193) {
               class22.method280(this, 255, this.field3187, this.field3190, (byte)0, true, -1235545078);
               return;
            }

            this.method4622(var3, (byte)94);
            this.method4726(1227820659);
         } else {
            if(!var4 && var2 == this.field3194) {
               this.field3188 = true;
            }

            if(var3 == null || var3.length <= 2) {
               this.field3185[var2] = false;
               if(!this.field3191) {
                  if(!var4) {
                     return;
                  }

                  if(var5 == 1) {
                     return;
                  }
               }

               class22.method280(this, this.field3187, var2, super.field3164[var2], (byte)2, var4, -1235545078);
               return;
            }

            field3189.reset();
            field3189.update(var3, 0, var3.length - 2);
            var6 = (int)field3189.getValue();
            int var7 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if(var6 != super.field3164[var2]) {
               break label112;
            }

            if(var7 != super.field3162[var2]) {
               if(var5 == 1) {
                  return;
               }
               break label112;
            }

            this.field3185[var2] = true;
            if(var4) {
               if(var5 == 1) {
                  return;
               }

               super.field3165[var2] = class159.method3324(var3, false, -2132602433);
            }
         }

         return;
      }

      this.field3185[var2] = false;
      if(this.field3191 || var4) {
         class22.method280(this, this.field3187, var2, super.field3164[var2], (byte)2, var4, -1235545078);
      }

   }

   public void method4723(int var1, int var2, int var3) {
      this.field3190 = var1;
      this.field3193 = var2;
      if(this.field3186 != null) {
         int var4 = this.field3187;
         class162 var5 = this.field3186;
         byte[] var7 = null;
         class205 var8 = class248.field3182;
         synchronized(class248.field3182) {
            for(class245 var9 = (class245)class248.field3182.method4098(); var9 != null; var9 = (class245)class248.field3182.method4079()) {
               if(var3 >= 1134687596) {
                  return;
               }

               if((long)var4 == var9.field2421 && var5 == var9.field3151 && var9.field3150 == 0) {
                  var7 = var9.field3149;
                  break;
               }
            }
         }

         if(var7 != null) {
            this.method4746(var5, var4, var7, true, (byte)-31);
         } else {
            byte[] var12 = var5.method3372(var4, 1704148460);
            this.method4746(var5, var4, var12, true, (byte)-4);
         }
      } else {
         class22.method280(this, 255, this.field3187, this.field3190, (byte)0, true, -1235545078);
      }

   }

   public int method4720(byte var1) {
      if(this.field3188) {
         return 100;
      } else if(super.field3165 != null) {
         return 99;
      } else {
         int var3 = this.field3187;
         long var4 = (long)(var3 + 16711680);
         int var2;
         if(class250.field3208 != null && var4 == class250.field3208.field2421) {
            var2 = class301.field3713.field2339 * 99 / (class301.field3713.field2338.length - class250.field3208.field3157) + 1;
         } else {
            var2 = 0;
         }

         int var6 = var2;
         if(var2 >= 100) {
            var6 = 99;
         }

         return var6;
      }
   }

   public void method4729(int var1, byte[] var2, boolean var3, boolean var4, int var5) {
      if(var3) {
         if(this.field3188) {
            if(var5 == 1887824785) {
               return;
            }

            throw new RuntimeException();
         }

         if(this.field3186 != null) {
            int var6 = this.field3187;
            class162 var7 = this.field3186;
            class245 var8 = new class245();
            var8.field3150 = 0;
            var8.field2421 = (long)var6;
            var8.field3149 = var2;
            var8.field3151 = var7;
            class205 var9 = class248.field3182;
            synchronized(class248.field3182) {
               class248.field3182.method4073(var8);
            }

            PacketBuffer.method3848((short)24564);
         }

         this.method4622(var2, (byte)65);
         this.method4726(-160763890);
      } else {
         var2[var2.length - 2] = (byte)(super.field3162[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field3162[var1];
         if(this.field3195 != null) {
            if(var5 == 1887824785) {
               return;
            }

            class162 var12 = this.field3195;
            class245 var15 = new class245();
            var15.field3150 = 0;
            var15.field2421 = (long)var1;
            var15.field3149 = var2;
            var15.field3151 = var12;
            class205 var16 = class248.field3182;
            synchronized(class248.field3182) {
               class248.field3182.method4073(var15);
            }

            PacketBuffer.method3848((short)18751);
            this.field3185[var1] = true;
         }

         if(var4) {
            super.field3165[var1] = class159.method3324(var2, false, -826976613);
         }
      }

   }

   public int method4755(int var1) {
      int var2 = 0;
      int var3 = 0;

      int var4;
      for(var4 = 0; var4 < super.field3165.length; var4++) {
         if(super.field3166[var4] > 0) {
            var2 += 100;
            var3 += this.vmethod4727(var4, (byte)35);
         }
      }

      if(var2 == 0) {
         return 100;
      } else {
         var4 = var3 * 100 / var2;
         return var4;
      }
   }
}
