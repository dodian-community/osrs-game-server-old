package client;

import java.util.LinkedList;

public abstract class class16 {
   static final int field122 = 47;
   static final int field128 = 360;
   static final int field129 = 27;
   int field118;
   int field119;
   short[][][] field125;
   int field121;
   short[][][] field123;
   class19[][][][] field126;
   int field120;
   byte[][][] field124;
   int field127;
   int field117;
   byte[][][] field116;

   class16() {
      new LinkedList();
   }

   int method153(int var1, int var2, byte var3) {
      return var1 >= 0 && var2 >= 0 ? (var1 < 64 && var2 < 64 ? this.field125[0][var1][var2] - 1 : -1) : -1;
   }

   void method152(int var1, int var2, Stream var3, int var4, int var5) {
      int var6 = ((var4 & 24) >> 3) + 1;
      boolean var7 = (var4 & 2) != 0;
      boolean var8 = (var4 & 4) != 0;
      this.field125[0][var1][var2] = (short)var3.readUByte();
      int var9;
      int var10;
      int var12;
      if(var7) {
         if(var5 == -1158743607) {
            return;
         }

         var9 = var3.readUByte();

         for(var10 = 0; var10 < var9; var10++) {
            if(var5 == -1158743607) {
               return;
            }

            int var11 = var3.readUByte();
            if(var11 != 0) {
               this.field123[var10][var1][var2] = (short)var11;
               var12 = var3.readUByte();
               this.field124[var10][var1][var2] = (byte)(var12 >> 2);
               this.field116[var10][var1][var2] = (byte)(var12 & 3);
            }
         }
      }

      if(var8) {
         for(var9 = 0; var9 < var6; var9++) {
            var10 = var3.readUByte();
            if(var10 == 0) {
               if(var5 == -1158743607) {
                  return;
               }
            } else {
               class19[] var15 = this.field126[var9][var1][var2] = new class19[var10];

               for(var12 = 0; var12 < var10; var12++) {
                  int var13 = var3.method3546();
                  int var14 = var3.readUByte();
                  var15[var12] = new class19(var13, var14 >> 2, var14 & 3);
               }
            }
         }
      }

   }

   void method167(int var1, int var2, Stream var3, int var4, byte var5) {
      boolean var6 = (var4 & 2) != 0;
      if(var6) {
         this.field123[0][var1][var2] = (short)var3.readUByte();
      }

      this.field125[0][var1][var2] = (short)var3.readUByte();
   }

   int method149(int var1) {
      return this.field118;
   }

   int method168(byte var1) {
      return this.field119;
   }

   void method150(int var1, int var2, Stream var3, int var4) {
      int var5 = var3.readUByte();
      if(var5 != 0) {
         if((var5 & 1) != 0) {
            this.method167(var1, var2, var3, var5, (byte)33);
         } else {
            this.method152(var1, var2, var3, var5, 1447711600);
         }

      }
   }

   static final void method158(int var0, int var1, int var2, int var3, int var4) {
      if(GameClient.field621) {
         if(var4 <= -1722741940) {
            return;
         }

         if(GameClient.field684 == 1) {
            class161.field1997[GameClient.field803 / 100].method5851(GameClient.field681 - 8, GameClient.field682 - 8);
         }

         if(GameClient.field684 == 2) {
            class161.field1997[GameClient.field803 / 100 + 4].method5851(GameClient.field681 - 8, GameClient.field682 - 8);
         }
      }

      GameClient.field694 = 0;
      int var5 = (class138.field1876.field931 >> 7) + class62.baseX;
      int var6 = (class138.field1876.field881 >> 7) + GameClient.baseY;
      if(var5 >= 3053 && var5 <= 3156 && var6 >= 3056 && var6 <= 3136) {
         if(var4 <= -1722741940) {
            return;
         }

         GameClient.field694 = 1;
      }

      if(var5 >= 3072) {
         if(var4 <= -1722741940) {
            return;
         }

         if(var5 <= 3118 && var6 >= 9492 && var6 <= 9535) {
            GameClient.field694 = 1;
         }
      }

      if(GameClient.field694 == 1 && var5 >= 3139) {
         if(var4 <= -1722741940) {
            return;
         }

         if(var5 <= 3199) {
            if(var4 <= -1722741940) {
               return;
            }

            if(var6 >= 3008 && var6 <= 3062) {
               GameClient.field694 = 0;
            }
         }
      }

   }
}
