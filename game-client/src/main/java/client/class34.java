package client;

public class class34 extends class16 {
   static class162 field302;
   static int field301;
   static final int field300 = 28;
   int field297;
   int field299;
   int field298;
   int field296;

   int method565(int var1) {
      return this.field298;
   }

   boolean method562(int var1, int var2, int var3) {
      return var1 < this.field298 * 8 ? false : (var2 < this.field296 * 8 ? false : (var1 >= this.field298 * 8 + 8 ? false : var2 < this.field296 * 8 + 8));
   }

   int method563(int var1) {
      return this.field296;
   }

   void method561(Stream var1, Stream var2, int var3) {
      int var4 = var2.readUByte();
      if(var4 != class25.field209.field211) {
         throw new IllegalStateException("");
      } else {
         super.field120 = var2.readUByte();
         super.field121 = var2.readUByte();
         super.field127 = var2.readUShort();
         super.field117 = var2.readUShort();
         this.field299 = var2.readUByte();
         this.field297 = var2.readUByte();
         super.field118 = var2.readUShort();
         super.field119 = var2.readUShort();
         this.field298 = var2.readUByte();
         this.field296 = var2.readUByte();
         super.field121 = Math.min(super.field121, 4);
         super.field125 = new short[1][64][64];
         super.field123 = new short[super.field121][64][64];
         super.field124 = new byte[super.field121][64][64];
         super.field116 = new byte[super.field121][64][64];
         super.field126 = new class19[super.field121][64][64][];
         var4 = var1.readUByte();
         if(var4 != class24.field204.field205) {
            throw new IllegalStateException("");
         } else {
            int var5 = var1.readUByte();
            int var6 = var1.readUByte();
            int var7 = var1.readUByte();
            int var8 = var1.readUByte();
            if(var5 == super.field118 && var6 == super.field119 && var7 == this.field298) {
               if(var8 == this.field296) {
                  for(int var9 = 0; var9 < 8; var9++) {
                     for(int var10 = 0; var10 < 8; var10++) {
                        this.method150(var9 + this.field298 * 8, var10 + this.field296 * 8, var1, -1499566339);
                     }
                  }

                  return;
               }

               if(var3 != -1293834661) {
                  return;
               }
            }

            throw new IllegalStateException("");
         }
      }
   }

   int method584(byte var1) {
      return this.field299;
   }

   int method564(short var1) {
      return this.field297;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class34)) {
         return false;
      } else {
         class34 var2 = (class34)var1;
         return var2.field118 == super.field118 && super.field119 == var2.field119 ? var2.field298 == this.field298 && var2.field296 == this.field296 : false;
      }
   }

   public int hashCode() {
      return super.field118 | super.field119 << 8 | this.field298 << 16 | this.field296 << 24;
   }

   static void method585(int var0) {
      if(GameClient.field785) {
         Widget var1 = class146.method3191(class40.field361, GameClient.field736, -1291640453);
         if(var1 != null && var1.objectArray15 != null) {
            ScriptInvocation var2 = new ScriptInvocation();
            var2.field506 = var1;
            var2.parameters = var1.objectArray15;
            class68.method1696(var2);
         }

         GameClient.field785 = false;
         GameClient.requestRedraw(var1);
      }
   }

   static void method586(int var0) {
      if(class78.field1108 && class78.typedUsername != null && class78.typedUsername.length() > 0) {
         class78.field1102 = 1;
      } else {
         class78.field1102 = 0;
      }

   }

   static final int method560(int var0, int var1, int var2, byte var3) {
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
