package client;

public final class class62 extends class204 {
   static class157 field869;
   static int baseX;
   public static final int field867 = 3;
   int field855 = 0;
   int field860 = -1;
   int field861;
   int field862;
   int field857;
   int field864;
   int field858;
   int field863;
   int field856;
   int field859;
   int field866;
   int field865;

   public static class172 method1536(int var0) {
      class172 var1;
      if(class172.field2258 == 0) {
         var1 = new class172();
      } else {
         var1 = class172.field2256[--class172.field2258];
      }

      var1.field2254 = null;
      var1.field2253 = 0;
      var1.field2257 = new PacketBuffer(5000);
      return var1;
   }

   static final void method1538(Player var0, int var1, int var2, byte var3, byte var4) {
      int var5 = var0.field922[0];
      int var6 = var0.field872[0];
      int var7 = var0.method1088((byte)-34);
      if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7) {
         if(var6 < 104 - var7) {
            if(var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
               int var10 = var0.method1088((byte)20);
               GameClient.field849.field2043 = var1;
               GameClient.field849.field2048 = var2;
               GameClient.field849.field2042 = 1;
               GameClient.field849.field2045 = 1;
               class59 var11 = GameClient.field849;
               int var12 = class112.method2566(var5, var6, var10, var11, GameClient.field642[var0.field567], true, GameClient.field850, GameClient.field596, 190310969);
               if(var12 < 1) {
                  return;
               }

               for(int var13 = 0; var13 < var12 - 1; var13++) {
                  var0.method1105(GameClient.field850[var13], GameClient.field596[var13], var3, (byte)12);
               }

               return;
            }

            return;
         }

         if(var4 >= 3) {
            return;
         }
      }

   }

   static final void method1537(int var0, int var1, boolean var2, int var3) {
      if(!var2 || var0 != class27.field224 || class34.field301 != var1) {
         class27.field224 = var0;
         class34.field301 = var1;
         class48.method947(25, -1809974461);
         class83.method1933("Loading - please wait.", true, 1078012147);
         int var4 = baseX;
         int var5 = GameClient.baseY;
         baseX = (var0 - 6) * 8;
         GameClient.baseY = (var1 - 6) * 8;
         int var6 = baseX - var4;
         int var7 = GameClient.baseY - var5;
         var4 = baseX;
         var5 = GameClient.baseY;

         int var8;
         int var10;
         for(var8 = 0; var8 < 32768; var8++) {
            Npc var9 = GameClient.field843[var8];
            if(var9 != null) {
               for(var10 = 0; var10 < 10; var10++) {
                  if(var3 <= -309539803) {
                     return;
                  }

                  var9.field922[var10] -= var6;
                  var9.field872[var10] -= var7;
               }

               var9.field931 -= var6 * 128;
               var9.field881 -= var7 * 128;
            }
         }

         for(var8 = 0; var8 < 2048; var8++) {
            Player var22 = GameClient.field610[var8];
            if(var22 != null) {
               for(var10 = 0; var10 < 10; var10++) {
                  var22.field922[var10] -= var6;
                  var22.field872[var10] -= var7;
               }

               var22.field931 -= var6 * 128;
               var22.field881 -= var7 * 128;
            }
         }

         byte var21 = 0;
         byte var19 = 104;
         byte var23 = 1;
         if(var6 < 0) {
            var21 = 103;
            var19 = -1;
            var23 = -1;
         }

         byte var11 = 0;
         byte var12 = 104;
         byte var13 = 1;
         if(var7 < 0) {
            var11 = 103;
            var12 = -1;
            var13 = -1;
         }

         int var15;
         for(int var14 = var21; var19 != var14; var14 += var23) {
            for(var15 = var11; var15 != var12; var15 += var13) {
               int var16 = var6 + var14;
               int var17 = var15 + var7;

               for(int var18 = 0; var18 < 4; var18++) {
                  if(var16 >= 0 && var17 >= 0) {
                     if(var3 <= -309539803) {
                        return;
                     }

                     if(var16 < 104 && var17 < 104) {
                        if(var3 <= -309539803) {
                           return;
                        }

                        GameClient.field708[var18][var14][var15] = GameClient.field708[var18][var16][var17];
                        continue;
                     }
                  }

                  GameClient.field708[var18][var14][var15] = null;
               }
            }
         }

         for(class62 var20 = (class62) GameClient.field714.method4098(); var20 != null; var20 = (class62) GameClient.field714.method4079()) {
            if(var3 <= -309539803) {
               return;
            }

            var20.field857 -= var6;
            var20.field858 -= var7;
            if(var20.field857 < 0 || var20.field858 < 0 || var20.field857 >= 104 || var20.field858 >= 104) {
               var20.unlink();
            }
         }

         if(GameClient.field808 != 0) {
            if(var3 <= -309539803) {
               return;
            }

            GameClient.field808 -= var6;
            GameClient.field809 -= var7;
         }

         GameClient.field656 = 0;
         GameClient.field822 = false;
         class109.field1431 -= var6 << 7;
         class226.field2563 -= var7 << 7;
         class109.field1428 -= var6 << 7;
         class2.field23 -= var7 << 7;
         GameClient.field651 = -1;
         GameClient.field711.method4072();
         GameClient.field710.method4072();

         for(var15 = 0; var15 < 4; var15++) {
            GameClient.field642[var15].method3392((byte)113);
         }

      }
   }
}
