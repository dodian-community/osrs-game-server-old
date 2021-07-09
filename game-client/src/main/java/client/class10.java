package client;

public class class10 extends class16 {
   static class66 field61;
   static final int field60 = 0;
   public static final int field62 = 1;
   static final int field63 = 1048576;

   void method95(Stream var1, Stream var2, int var3) {
      int var4 = var2.readUByte();
      if(var4 != class25.field212.field211) {
         throw new IllegalStateException("");
      } else {
         super.field120 = var2.readUByte();
         super.field121 = var2.readUByte();
         super.field127 = var2.readUShort();
         super.field117 = var2.readUShort();
         super.field118 = var2.readUShort();
         super.field119 = var2.readUShort();
         super.field121 = Math.min(super.field121, 4);
         super.field125 = new short[1][64][64];
         super.field123 = new short[super.field121][64][64];
         super.field124 = new byte[super.field121][64][64];
         super.field116 = new byte[super.field121][64][64];
         super.field126 = new class19[super.field121][64][64][];
         var4 = var1.readUByte();
         if(var4 != class24.field208.field205) {
            throw new IllegalStateException("");
         } else {
            int var5 = var1.readUByte();
            int var6 = var1.readUByte();
            if(var5 == super.field118) {
               if(var3 >= 856763491) {
                  return;
               }

               if(var6 == super.field119) {
                  for(int var7 = 0; var7 < 64; var7++) {
                     if(var3 >= 856763491) {
                        return;
                     }

                     for(int var8 = 0; var8 < 64; var8++) {
                        if(var3 >= 856763491) {
                           return;
                        }

                        this.method150(var7, var8, var1, -1870240303);
                     }
                  }

                  return;
               }

               if(var3 >= 856763491) {
                  return;
               }
            }

            throw new IllegalStateException("");
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class10)) {
         return false;
      } else {
         class10 var2 = (class10)var1;
         return super.field118 == var2.field118 && var2.field119 == super.field119;
      }
   }

   public int hashCode() {
      return super.field118 | super.field119 << 8;
   }

   static void method96(int var0, int var1, int var2, int var3, int var4) {
      class53 var5 = (class53)class53.field474.get((long)var0);
      if(var5 == null) {
         var5 = new class53();
         class53.field474.method4016(var5, (long)var0);
      }

      if(var5.field477.length <= var1) {
         if(var4 >= -1538714556) {
            return;
         }

         int[] var6 = new int[var1 + 1];
         int[] var7 = new int[var1 + 1];

         int var8;
         for(var8 = 0; var8 < var5.field477.length; var8++) {
            var6[var8] = var5.field477[var8];
            var7[var8] = var5.field473[var8];
         }

         for(var8 = var5.field477.length; var8 < var1; var8++) {
            var6[var8] = -1;
            var7[var8] = 0;
         }

         var5.field477 = var6;
         var5.field473 = var7;
      }

      var5.field477[var1] = var2;
      var5.field473[var1] = var3;
   }

   static boolean method92(int var0) {
      if(GameClient.field781 != null && GameClient.field606 < GameClient.field781.size()) {
         while(GameClient.field606 < GameClient.field781.size()) {
            class52 var1 = (class52) GameClient.field781.get(GameClient.field606);
            if(!var1.method1000(-1326289978)) {
               return false;
            }

            ++GameClient.field606;
         }

         return true;
      } else {
         return true;
      }
   }

   static class84 method97(byte[] var0, int var1) {
      class84 var2 = new class84();
      Stream var3 = new Stream(var0);
      var3.field2339 = var3.field2338.length - 2;
      int var4 = var3.readUShort();
      int var5 = var3.field2338.length - 2 - var4 - 12;
      var3.field2339 = var5;
      int var6 = var3.readInt();
      var2.field1192 = var3.readUShort();
      var2.field1193 = var3.readUShort();
      var2.field1188 = var3.readUShort();
      var2.field1195 = var3.readUShort();
      int var7 = var3.readUByte();
      int var8;
      int var9;
      if(var7 > 0) {
         var2.field1194 = var2.method1944(var7, -1761127859);

         for(var8 = 0; var8 < var7; var8++) {
            var9 = var3.readUShort();
            class197 var10 = new class197(var9 > 0 ? class146.method3193(var9, (byte)-52) : 1);
            var2.field1194[var8] = var10;

            while(var9-- > 0) {
               int var11 = var3.readInt();
               int var12 = var3.readInt();
               var10.method3944(new class211(var12), (long)var11);
            }
         }
      }

      var3.field2339 = 0;
      var3.method3752((byte)61);
      var2.field1189 = new int[var6];
      var2.field1196 = new int[var6];
      var2.field1191 = new String[var6];

      for(var8 = 0; var3.field2339 < var5; var2.field1189[var8++] = var9) {
         var9 = var3.readUShort();
         if(var9 == 3) {
            var2.field1191[var8] = var3.readString();
         } else if(var9 < 100 && var9 != 21 && var9 != 38 && var9 != 39) {
            var2.field1196[var8] = var3.readInt();
         } else {
            var2.field1196[var8] = var3.readUByte();
         }
      }

      return var2;
   }
}
