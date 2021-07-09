package client;

import java.util.Comparator;

public class class137 implements Comparator {
   static final int field1868 = 19136899;
   static final int field1869 = 4;
   final boolean field1870;

   public class137(boolean var1) {
      this.field1870 = var1;
   }

   int method3120(class287 var1, class287 var2, int var3) {
      return this.field1870 ? var1.field3627 - var2.field3627 : var2.field3627 - var1.field3627;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3120((class287)var1, (class287)var2, 2097631968);
   }

   static final int method3119(Widget var0, int var1, int var2) {
      if(var0.field2659 != null && var1 < var0.field2659.length) {
         try {
            int[] var3 = var0.field2659[var1];
            int var4 = 0;
            int var5 = 0;
            byte var6 = 0;

            while(true) {
               int var7 = var3[var5++];
               int var8 = 0;
               byte var9 = 0;
               if(var7 == 0) {
                  return var4;
               }

               if(var7 == 1) {
                  var8 = GameClient.field712[var3[var5++]];
               }

               if(var7 == 2) {
                  var8 = GameClient.field713[var3[var5++]];
               }

               if(var7 == 3) {
                  var8 = GameClient.field640[var3[var5++]];
               }

               int var10;
               Widget var11;
               int var12;
               int var13;
               if(var7 == 4) {
                  var10 = var3[var5++] << 16;
                  var10 += var3[var5++];
                  var11 = Widget.getLoaded(var10);
                  var12 = var3[var5++];
                  if(var12 != -1 && (!ItemDef.loadItemDef(var12).members || GameClient.field668)) {
                     for(var13 = 0; var13 < var11.field2724.length; var13++) {
                        if(var12 + 1 == var11.field2724[var13]) {
                           var8 += var11.field2725[var13];
                        }
                     }
                  }
               }

               if(var7 == 5) {
                  var8 = class225.field2558[var3[var5++]];
               }

               if(var7 == 6) {
                  var8 = class234.field2779[GameClient.field713[var3[var5++]] - 1];
               }

               if(var7 == 7) {
                  var8 = class225.field2558[var3[var5++]] * 100 / 46875;
               }

               if(var7 == 8) {
                  var8 = class138.field1876.field551;
               }

               if(var7 == 9) {
                  for(var10 = 0; var10 < 25; var10++) {
                     if(class234.field2780[var10]) {
                        var8 += GameClient.field713[var10];
                     }
                  }
               }

               if(var7 == 10) {
                  var10 = var3[var5++] << 16;
                  var10 += var3[var5++];
                  var11 = Widget.getLoaded(var10);
                  var12 = var3[var5++];
                  if(var12 != -1 && (!ItemDef.loadItemDef(var12).members || GameClient.field668)) {
                     for(var13 = 0; var13 < var11.field2724.length; var13++) {
                        if(var12 + 1 == var11.field2724[var13]) {
                           var8 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var7 == 11) {
                  var8 = GameClient.field745;
               }

               if(var7 == 12) {
                  var8 = GameClient.field782;
               }

               if(var7 == 13) {
                  var10 = class225.field2558[var3[var5++]];
                  int var14 = var3[var5++];
                  var8 = (var10 & 1 << var14) != 0 ? 1 : 0;
               }

               if(var7 == 14) {
                  var10 = var3[var5++];
                  var8 = class163.method3389(var10, -397804509);
               }

               if(var7 == 15) {
                  var9 = 1;
               }

               if(var7 == 16) {
                  var9 = 2;
               }

               if(var7 == 17) {
                  var9 = 3;
               }

               if(var7 == 18) {
                  var8 = (class138.field1876.field931 >> 7) + class62.baseX;
               }

               if(var7 == 19) {
                  var8 = (class138.field1876.field881 >> 7) + GameClient.baseY;
               }

               if(var7 == 20) {
                  var8 = var3[var5++];
               }

               if(var9 == 0) {
                  if(var6 == 0) {
                     var4 += var8;
                  }

                  if(var6 == 1) {
                     var4 -= var8;
                  }

                  if(var6 == 2 && var8 != 0) {
                     var4 /= var8;
                  }

                  if(var6 == 3) {
                     var4 *= var8;
                  }

                  var6 = 0;
               } else {
                  var6 = var9;
               }
            }
         } catch (Exception var15) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   public static Sprite method3127(class247 var0, String var1, String var2, int var3) {
      int var4 = var0.method4642(var1, -1619038582);
      int var5 = var0.method4643(var4, var2, -981702486);
      return class229.method4499(var0, var4, var5, -1568727836);
   }
}
