package client;

public final class class298 extends class299 {
   public class298(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }

   public class298(byte[] var1) {
      super(var1);
   }

   final void vmethod5536(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var3 * Rasterizer2D.field3761 + var2;
      int var8 = Rasterizer2D.field3761 - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var3 < Rasterizer2D.field3763) {
         var11 = Rasterizer2D.field3763 - var3;
         var5 -= var11;
         var3 = Rasterizer2D.field3763;
         var10 += var11 * var4;
         var7 += var11 * Rasterizer2D.field3761;
      }

      if(var3 + var5 > Rasterizer2D.field3764) {
         var5 -= var3 + var5 - Rasterizer2D.field3764;
      }

      if(var2 < Rasterizer2D.field3765) {
         var11 = Rasterizer2D.field3765 - var2;
         var4 -= var11;
         var2 = Rasterizer2D.field3765;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var2 + var4 > Rasterizer2D.field3760) {
         var11 = var2 + var4 - Rasterizer2D.field3760;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var4 > 0 && var5 > 0) {
         class299.method5556(Rasterizer2D.field3766, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }

   final void vmethod5542(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var3 * Rasterizer2D.field3761 + var2;
      int var9 = Rasterizer2D.field3761 - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if(var3 < Rasterizer2D.field3763) {
         var12 = Rasterizer2D.field3763 - var3;
         var5 -= var12;
         var3 = Rasterizer2D.field3763;
         var11 += var12 * var4;
         var8 += var12 * Rasterizer2D.field3761;
      }

      if(var3 + var5 > Rasterizer2D.field3764) {
         var5 -= var3 + var5 - Rasterizer2D.field3764;
      }

      if(var2 < Rasterizer2D.field3765) {
         var12 = Rasterizer2D.field3765 - var2;
         var4 -= var12;
         var2 = Rasterizer2D.field3765;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if(var2 + var4 > Rasterizer2D.field3760) {
         var12 = var2 + var4 - Rasterizer2D.field3760;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if(var4 > 0 && var5 > 0) {
         class299.method5585(Rasterizer2D.field3766, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }
}
