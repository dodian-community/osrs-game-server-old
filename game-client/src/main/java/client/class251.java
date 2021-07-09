package client;

import java.util.HashMap;

public class class251 {
   final HashMap field3220 = new HashMap();
   int field3217 = 0;
   int[] field3218 = new int[2048];
   int[] field3216 = new int[2048];
   class310 field3219 = new class310(0, 0);

   public class251() {
      class64.method1560((byte)66);
   }

   Sprite method4772(int var1, byte var2) {
      if(!this.field3220.containsKey(Integer.valueOf(var1))) {
         this.method4771(var1, 1389377337);
      }

      return (Sprite)this.field3220.get(Integer.valueOf(var1));
   }

   void method4771(int var1, int var2) {
      int var3 = var1 * 2 + 1;
      double[] var4 = RuneScriptMap.method4986(0.0D, (double)((float)var1 / 3.0F), var1, (byte)2);
      double var5 = var4[var1] * var4[var1];
      int[] var7 = new int[var3 * var3];
      boolean var8 = false;

      for(int var9 = 0; var9 < var3; var9++) {
         for(int var10 = 0; var10 < var3; var10++) {
            if(var2 != 1389377337) {
               return;
            }

            int var11 = var7[var10 + var9 * var3] = (int)(256.0D * (var4[var9] * var4[var10] / var5));
            if(!var8 && var11 > 0) {
               var8 = true;
            }
         }
      }

      Sprite var12 = new Sprite(var7, var3, var3);
      this.field3220.put(Integer.valueOf(var1), var12);
   }

   void method4790(Sprite var1, Sprite var2, class310 var3, byte var4) {
      if(var3.field3747 != 0 && var3.field3745 != 0) {
         int var5 = 0;
         int var6 = 0;
         if(var3.field3746 == 0) {
            var5 = var1.width - var3.field3747;
         }

         if(var3.field3743 == 0) {
            if(var4 >= 5) {
               return;
            }

            var6 = var1.height - var3.field3745;
         }

         int var7 = var5 + var6 * var1.width;
         int var8 = var3.field3746 + var2.width * var3.field3743;

         for(int var9 = 0; var9 < var3.field3745; var9++) {
            for(int var10 = 0; var10 < var3.field3747; var10++) {
               int var10001 = var8++;
               var2.pixels[var10001] += var1.pixels[var7++];
            }

            var7 += var1.width - var3.field3747;
            var8 += var2.width - var3.field3747;
         }

      }
   }

   public final void method4776(int var1, int var2, Sprite var3, float var4, int var5) {
      int var6 = (int)(var4 * 18.0F);
      Sprite var7 = this.method4772(var6, (byte)85);
      int var8 = var6 * 2 + 1;
      class310 var9 = new class310(0, 0, var3.width, var3.height);
      class310 var10 = new class310(0, 0);
      this.field3219.method5680(var8, var8, -2110430294);
      System.nanoTime();

      int var11;
      int var12;
      int var13;
      for(var11 = 0; var11 < this.field3217; var11++) {
         var12 = this.field3218[var11];
         var13 = this.field3216[var11];
         int var14 = (int)((float)(var12 - var1) * var4) - var6;
         int var15 = (int)((float)var3.height - var4 * (float)(var13 - var2)) - var6;
         this.field3219.method5679(var14, var15, 1155905697);
         this.field3219.method5681(var9, var10, 1253988141);
         this.method4790(var7, var3, var10, (byte)-68);
      }

      System.nanoTime();
      System.nanoTime();

      for(var11 = 0; var11 < var3.pixels.length; var11++) {
         if(var3.pixels[var11] == 0) {
            var3.pixels[var11] = -16777216;
         } else {
            var12 = (var3.pixels[var11] + 64 - 1) / 256;
            if(var12 <= 0) {
               var3.pixels[var11] = -16777216;
            } else {
               if(var12 > class224.field2554.length) {
                  var12 = class224.field2554.length;
               }

               var13 = class224.field2554[var12 - 1];
               var3.pixels[var11] = -16777216 | var13;
            }
         }
      }

      System.nanoTime();
   }

   public final void method4774(int var1) {
      this.field3217 = 0;
   }

   public final void method4773(int var1, int var2, int var3) {
      if(this.field3217 >= this.field3218.length) {
         if(var3 < -311775002) {
            ;
         }
      } else {
         this.field3218[this.field3217] = var1;
         this.field3216[this.field3217] = var2;
         ++this.field3217;
      }
   }

   public static String method4794(CharSequence[] var0, int var1, int var2, int var3) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var4 = var0[var1];
         return var4 == null ? "null" : var4.toString();
      } else {
         int var9 = var2 + var1;
         int var5 = 0;

         for(int var6 = var1; var6 < var9; var6++) {
            CharSequence var7 = var0[var6];
            if(var7 == null) {
               var5 += 4;
            } else {
               var5 += var7.length();
            }
         }

         StringBuilder var10 = new StringBuilder(var5);

         for(int var11 = var1; var11 < var9; var11++) {
            CharSequence var8 = var0[var11];
            if(var8 == null) {
               var10.append("null");
            } else {
               var10.append(var8);
            }
         }

         return var10.toString();
      }
   }
}
