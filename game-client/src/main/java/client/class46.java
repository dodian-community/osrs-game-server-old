package client;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class class46 extends class315 {
   Image field383;
   Component field384;

   class46(int var1, int var2, Component var3) {
      super.field3767 = var1;
      super.field3769 = var2;
      super.field3768 = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.field3768, super.field3768.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, 65280, 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field3767, super.field3769), var4, (Point)null);
      this.field383 = new BufferedImage(var5, var6, false, new Hashtable());
      this.method751(var3, (byte)-53);
      this.method5808((short)14976);
   }

   final void method755(Graphics var1, int var2, int var3, int var4, int var5, byte var6) {
      try {
         Shape var7 = var1.getClip();
         var1.clipRect(var2, var3, var4, var5);
         var1.drawImage(this.field383, 0, 0, this.field384);
         var1.setClip(var7);
      } catch (Exception var8) {
         this.field384.repaint();
      }

   }

   final void method754(Graphics var1, int var2, int var3, int var4) {
      try {
         var1.drawImage(this.field383, var2, var3, this.field384);
      } catch (Exception var6) {
         this.field384.repaint();
      }

   }

   final void method751(Component var1, byte var2) {
      this.field384 = var1;
   }

   public final void vmethod5809(int var1, int var2, int var3) {
      this.method754(this.field384.getGraphics(), var1, var2, 1968187025);
   }

   public final void vmethod5810(int var1, int var2, int var3, int var4, int var5) {
      this.method755(this.field384.getGraphics(), var1, var2, var3, var4, (byte)1);
   }
}
