package client;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class class284 extends class285 {
   public static final int field3616 = 100;
   static final int field3617 = 400;
   final class322 field3615;

   public class284(class322 var1) {
      super(400);
      this.field3615 = var1;
   }

   class282 vmethod5461(int var1) {
      return new class286();
   }

   class282[] vmethod5462(int var1, int var2) {
      return new class286[var1];
   }

   public void method5317(Stream var1, int var2, int var3) {
      while(true) {
         if(var1.field2339 < var2) {
            int var4 = var1.readUByte();
            boolean var5 = (var4 & 1) == 1;
            class291 var6 = new class291(var1.readString(), this.field3615);
            class291 var7 = new class291(var1.readString(), this.field3615);
            var1.readString();
            if(var6 != null) {
               if(var6.method5441(777472606)) {
                  class286 var8 = (class286)this.method5331(var6, -249972144);
                  if(var5) {
                     class286 var9 = (class286)this.method5331(var7, 1085308209);
                     if(var9 != null && var9 != var8) {
                        if(var8 != null) {
                           this.method5334(var9, -1396032216);
                        } else {
                           var8 = var9;
                        }
                     }
                  }

                  if(var8 != null) {
                     this.method5338(var8, var6, var7, (byte)15);
                     continue;
                  }

                  if(this.method5327(821008449) >= 400) {
                     continue;
                  }

                  if(var3 == 497255191) {
                     return;
                  }

                  int var10 = this.method5327(821008449);
                  var8 = (class286)this.method5335(var6, var7, 2051302762);
                  var8.field3624 = var10;
                  continue;
               }

               if(var3 == 497255191) {
                  return;
               }
            }

            throw new IllegalStateException();
         }

         return;
      }
   }

   public static final Sprite method5324(byte[] var0, int var1) {
      BufferedImage var2 = null;

      try {
         var2 = ImageIO.read(new ByteArrayInputStream(var0));
         int var3 = var2.getWidth();
         int var4 = var2.getHeight();
         int[] var5 = new int[var3 * var4];
         PixelGrabber var6 = new PixelGrabber(var2, 0, 0, var3, var4, var5, 0, var3);
         var6.grabPixels();
         return new Sprite(var5, var3, var4);
      } catch (IOException var8) {
         ;
      } catch (InterruptedException var9) {
         ;
      }

      return new Sprite(0, 0);
   }
}
