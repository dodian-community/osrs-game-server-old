package client;

public class class32 {
   public static final int field284 = 14;
   static final int field288 = 11;
   static final int field289 = 89;
   int field282;
   int field287;
   int[][] field283;
   int[][] field285;
   int[][] field281;
   int[][] field286;

   class32(int var1, int var2) {
      this.field282 = var1;
      this.field287 = var2;
      this.field283 = new int[var1][var2];
      this.field281 = new int[var1][var2];
      this.field285 = new int[var1][var2];
      this.field286 = new int[var1][var2];
   }

   int method547(int var1, int var2, byte var3) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field282 && var2 < this.field287) {
         if(this.field285[var1][var2] == 0) {
            return 0;
         } else {
            int var4 = this.field283[var1][var2] / this.field286[var1][var2];
            int var5 = this.field281[var1][var2] / this.field286[var1][var2];
            int var6 = this.field285[var1][var2] / this.field286[var1][var2];
            return class143.method3167((double)var4 / 256.0D, (double)var5 / 256.0D, (double)var6 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   void method541(int var1, int var2, int var3, class259 var4, short var5) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field282 && var2 - var3 <= this.field287) {
               int var6 = Math.max(0, var1 - var3);
               int var7 = Math.min(this.field282, var3 + var1);
               int var8 = Math.max(0, var2 - var3);
               int var9 = Math.min(this.field287, var3 + var2);

               for(int var10 = var6; var10 < var7; var10++) {
                  for(int var11 = var8; var11 < var9; var11++) {
                     this.field283[var10][var11] += var4.field3284 * 256 / var4.field3281;
                     this.field281[var10][var11] += var4.field3287;
                     this.field285[var10][var11] += var4.field3286;
                     ++this.field286[var10][var11];
                  }
               }

            }
         }
      }
   }

   static void method548(class249 var0, String var1, int var2) {
      class52 var3 = new class52(var0, var1);
      GameClient.field781.add(var3);
   }

   static int method540(int var0, class84 var1, boolean var2, int var3) {
      int var4;
      int var5;
      if(var0 == 100) {
         class69.field1003 -= 3;
         var4 = class69.field999[class69.field1003];
         var5 = class69.field999[class69.field1003 + 1];
         int var6 = class69.field999[class69.field1003 + 2];
         if(var5 == 0) {
            throw new RuntimeException();
         } else {
            Widget var7 = Widget.getLoaded(var4);
            if(var7.children == null) {
               var7.children = new Widget[var6 + 1];
            }

            if(var7.children.length <= var6) {
               Widget[] var8 = new Widget[var6 + 1];

               for(int var9 = 0; var9 < var7.children.length; var9++) {
                  var8[var9] = var7.children[var9];
               }

               var7.children = var8;
            }

            if(var6 > 0 && var7.children[var6 - 1] == null) {
               throw new RuntimeException("" + (var6 - 1));
            } else {
               Widget var13 = new Widget();
               var13.widgetType = var5;
               var13.parentHash = var13.interfaceHash = var7.interfaceHash;
               var13.childId = var6;
               var13.decodeCs2 = true;
               var7.children[var6] = var13;
               if(var2) {
                  class276.field3561 = var13;
               } else {
                  class260.field3301 = var13;
               }

               GameClient.requestRedraw(var7);
               return 1;
            }
         }
      } else {
         Widget var10;
         if(var0 == 101) {
            var10 = var2 ? class276.field3561 : class260.field3301;
            Widget var11 = Widget.getLoaded(var10.interfaceHash);
            var11.children[var10.childId] = null;
            GameClient.requestRedraw(var11);
            return 1;
         } else if(var0 == 102) {
            var10 = Widget.getLoaded(class69.field999[--class69.field1003]);
            var10.children = null;
            GameClient.requestRedraw(var10);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var10 = Widget.getLoaded(class69.field999[--class69.field1003]);
               if(var10 != null) {
                  class69.field999[++class69.field1003 - 1] = 1;
                  if(var2) {
                     class276.field3561 = var10;
                  } else {
                     class260.field3301 = var10;
                  }
               } else {
                  class69.field999[++class69.field1003 - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class69.field1003 -= 2;
            var4 = class69.field999[class69.field1003];
            var5 = class69.field999[class69.field1003 + 1];
            Widget var12 = class146.method3191(var4, var5, -1360495014);
            if(var12 != null && var5 != -1) {
               class69.field999[++class69.field1003 - 1] = 1;
               if(var2) {
                  class276.field3561 = var12;
               } else {
                  class260.field3301 = var12;
               }
            } else {
               class69.field999[++class69.field1003 - 1] = 0;
            }

            return 1;
         }
      }
   }

   static final int method549(int var0, int var1, int var2, int var3) {
      int var4 = var0 / var2;
      int var5 = var0 & var2 - 1;
      int var6 = var1 / var2;
      int var7 = var1 & var2 - 1;
      int var8 = class186.method3805(var4, var6, 1067447403);
      int var9 = class186.method3805(var4 + 1, var6, 706349939);
      int var10 = class186.method3805(var4, var6 + 1, 603175583);
      int var11 = class186.method3805(var4 + 1, var6 + 1, 1070051428);
      int var12 = class123.method2870(var8, var9, var5, var2, -1588641951);
      int var13 = class123.method2870(var10, var11, var5, var2, -1588641951);
      return class123.method2870(var12, var13, var7, var2, -1588641951);
   }
}
