package client;

import java.awt.*;
import java.awt.image.PixelGrabber;

public final class Sprite extends Rasterizer2D {
   static final int field3786 = 12;
   static final int field3789 = 4;
   static final int field3794 = 15;
   static final int field3795 = 8;
   static final int field3797 = 4095;
   public int maxWidth;
   public int offsetX;
   public int height;
   public int[] pixels;
   public int width;
   public int maxHeight;
   int offsetY;

   public Sprite(int[] var1, int var2, int var3) {
      this.pixels = var1;
      this.width = this.maxWidth = var2;
      this.height = this.maxHeight = var3;
      this.offsetY = 0;
      this.offsetX = 0;
   }

   public Sprite(int var1, int var2) {
      this(new int[var2 * var1], var1, var2);
   }

   public Sprite(byte[] pictureData, Component component) {
      try {
         Image image = Toolkit.getDefaultToolkit().createImage(pictureData);
         MediaTracker tracker = new MediaTracker(component);
         tracker.addImage(image, 0);
         tracker.waitForAll();
         width = image.getWidth(component);
         height = image.getHeight(component);
         maxWidth = width;
         maxHeight = height;
         offsetX = 0;
         offsetY = 0;
         pixels = new int[width * height];
         PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, width, height, pixels, 0, width);
         pixelGrabber.grabPixels();

         for (int i = 0; i < pixels.length; i++) {
            if ((pixels[i] & 0xFFFFFF) == 0xFF00FF) {
               pixels[i] = 0;
            }
         }
      } catch (InterruptedException var6) {
         ;
      }

   }

   Sprite() {
   }

   public void method5851(int var1, int var2) {
      var1 += this.offsetX;
      var2 += this.offsetY;
      int var3 = var1 + var2 * Rasterizer2D.field3761;
      int var4 = 0;
      int var5 = this.height;
      int var6 = this.width;
      int var7 = Rasterizer2D.field3761 - var6;
      int var8 = 0;
      int var9;
      if(var2 < Rasterizer2D.field3763) {
         var9 = Rasterizer2D.field3763 - var2;
         var5 -= var9;
         var2 = Rasterizer2D.field3763;
         var4 += var9 * var6;
         var3 += var9 * Rasterizer2D.field3761;
      }

      if(var5 + var2 > Rasterizer2D.field3764) {
         var5 -= var5 + var2 - Rasterizer2D.field3764;
      }

      if(var1 < Rasterizer2D.field3765) {
         var9 = Rasterizer2D.field3765 - var1;
         var6 -= var9;
         var1 = Rasterizer2D.field3765;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 + var1 > Rasterizer2D.field3760) {
         var9 = var6 + var1 - Rasterizer2D.field3760;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method5859(Rasterizer2D.field3766, this.pixels, 0, var4, var3, var6, var5, var7, var8);
      }
   }

   void method5871(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var6 != 0) {
         var1 -= this.offsetX << 4;
         var2 -= this.offsetY << 4;
         double var7 = (double)(var5 & 65535) * 9.587379924285257E-5D;
         int var9 = (int)Math.floor(Math.sin(var7) * (double)var6 + 0.5D);
         int var10 = (int)Math.floor(Math.cos(var7) * (double)var6 + 0.5D);
         int var11 = var10 * -var1 + -var2 * var9;
         int var12 = -var2 * var10 + var9 * -(-var1);
         int var13 = var10 * ((this.width << 4) - var1) + -var2 * var9;
         int var14 = var9 * -((this.width << 4) - var1) + -var2 * var10;
         int var15 = ((this.height << 4) - var2) * var9 + var10 * -var1;
         int var16 = ((this.height << 4) - var2) * var10 + var9 * -(-var1);
         int var17 = ((this.height << 4) - var2) * var9 + var10 * ((this.width << 4) - var1);
         int var18 = ((this.height << 4) - var2) * var10 + var9 * -((this.width << 4) - var1);
         int var19;
         int var20;
         if(var11 < var13) {
            var19 = var11;
            var20 = var13;
         } else {
            var19 = var13;
            var20 = var11;
         }

         if(var15 < var19) {
            var19 = var15;
         }

         if(var17 < var19) {
            var19 = var17;
         }

         if(var15 > var20) {
            var20 = var15;
         }

         if(var17 > var20) {
            var20 = var17;
         }

         int var21;
         int var22;
         if(var12 < var14) {
            var21 = var12;
            var22 = var14;
         } else {
            var21 = var14;
            var22 = var12;
         }

         if(var16 < var21) {
            var21 = var16;
         }

         if(var18 < var21) {
            var21 = var18;
         }

         if(var16 > var22) {
            var22 = var16;
         }

         if(var18 > var22) {
            var22 = var18;
         }

         var19 >>= 12;
         var20 = var20 + 4095 >> 12;
         var21 >>= 12;
         var22 = var22 + 4095 >> 12;
         var19 += var3;
         var20 += var3;
         var21 += var4;
         var22 += var4;
         var19 >>= 4;
         var20 = var20 + 15 >> 4;
         var21 >>= 4;
         var22 = var22 + 15 >> 4;
         if(var19 < Rasterizer2D.field3765) {
            var19 = Rasterizer2D.field3765;
         }

         if(var20 > Rasterizer2D.field3760) {
            var20 = Rasterizer2D.field3760;
         }

         if(var21 < Rasterizer2D.field3763) {
            var21 = Rasterizer2D.field3763;
         }

         if(var22 > Rasterizer2D.field3764) {
            var22 = Rasterizer2D.field3764;
         }

         var20 = var19 - var20;
         if(var20 < 0) {
            var22 = var21 - var22;
            if(var22 < 0) {
               int var23 = var19 + var21 * Rasterizer2D.field3761;
               double var24 = 1.6777216E7D / (double)var6;
               int var26 = (int)Math.floor(Math.sin(var7) * var24 + 0.5D);
               int var27 = (int)Math.floor(Math.cos(var7) * var24 + 0.5D);
               int var28 = (var19 << 4) + 8 - var3;
               int var29 = (var21 << 4) + 8 - var4;
               int var30 = (var1 << 8) - (var29 * var26 >> 4);
               int var31 = (var29 * var27 >> 4) + (var2 << 8);
               int var32;
               int var33;
               int var34;
               int var35;
               int var36;
               int var37;
               int var38;
               if(var27 == 0) {
                  if(var26 == 0) {
                     for(var33 = var22; var33 < 0; var23 += Rasterizer2D.field3761) {
                        var34 = var23;
                        var35 = var30;
                        var36 = var31;
                        var37 = var20;
                        if(var30 >= 0 && var31 >= 0 && var30 - (this.width << 12) < 0 && var31 - (this.height << 12) < 0) {
                           for(; var37 < 0; var37++) {
                              var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.width];
                              if(var38 != 0) {
                                 Rasterizer2D.field3766[var34++] = var38;
                              } else {
                                 ++var34;
                              }
                           }
                        }

                        ++var33;
                     }
                  } else if(var26 < 0) {
                     for(var33 = var22; var33 < 0; var23 += Rasterizer2D.field3761) {
                        var34 = var23;
                        var35 = var30;
                        var36 = (var28 * var26 >> 4) + var31;
                        var37 = var20;
                        if(var30 >= 0 && var30 - (this.width << 12) < 0) {
                           if((var32 = var36 - (this.height << 12)) >= 0) {
                              var32 = (var26 - var32) / var26;
                              var37 = var20 + var32;
                              var36 += var26 * var32;
                              var34 = var23 + var32;
                           }

                           if((var32 = (var36 - var26) / var26) > var37) {
                              var37 = var32;
                           }

                           while(var37 < 0) {
                              var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.width];
                              if(var38 != 0) {
                                 Rasterizer2D.field3766[var34++] = var38;
                              } else {
                                 ++var34;
                              }

                              var36 += var26;
                              ++var37;
                           }
                        }

                        ++var33;
                        var30 -= var26;
                     }
                  } else {
                     for(var33 = var22; var33 < 0; var23 += Rasterizer2D.field3761) {
                        var34 = var23;
                        var35 = var30;
                        var36 = (var28 * var26 >> 4) + var31;
                        var37 = var20;
                        if(var30 >= 0 && var30 - (this.width << 12) < 0) {
                           if(var36 < 0) {
                              var32 = (var26 - 1 - var36) / var26;
                              var37 = var20 + var32;
                              var36 += var26 * var32;
                              var34 = var23 + var32;
                           }

                           if((var32 = (var36 + 1 - (this.height << 12) - var26) / var26) > var37) {
                              var37 = var32;
                           }

                           while(var37 < 0) {
                              var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.width];
                              if(var38 != 0) {
                                 Rasterizer2D.field3766[var34++] = var38;
                              } else {
                                 ++var34;
                              }

                              var36 += var26;
                              ++var37;
                           }
                        }

                        ++var33;
                        var30 -= var26;
                     }
                  }
               } else if(var27 < 0) {
                  if(var26 == 0) {
                     for(var33 = var22; var33 < 0; var23 += Rasterizer2D.field3761) {
                        var34 = var23;
                        var35 = (var28 * var27 >> 4) + var30;
                        var36 = var31;
                        var37 = var20;
                        if(var31 >= 0 && var31 - (this.height << 12) < 0) {
                           if((var32 = var35 - (this.width << 12)) >= 0) {
                              var32 = (var27 - var32) / var27;
                              var37 = var20 + var32;
                              var35 += var27 * var32;
                              var34 = var23 + var32;
                           }

                           if((var32 = (var35 - var27) / var27) > var37) {
                              var37 = var32;
                           }

                           while(var37 < 0) {
                              var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.width];
                              if(var38 != 0) {
                                 Rasterizer2D.field3766[var34++] = var38;
                              } else {
                                 ++var34;
                              }

                              var35 += var27;
                              ++var37;
                           }
                        }

                        ++var33;
                        var31 += var27;
                     }
                  } else if(var26 < 0) {
                     for(var33 = var22; var33 < 0; var23 += Rasterizer2D.field3761) {
                        var34 = var23;
                        var35 = (var28 * var27 >> 4) + var30;
                        var36 = (var28 * var26 >> 4) + var31;
                        var37 = var20;
                        if((var32 = var35 - (this.width << 12)) >= 0) {
                           var32 = (var27 - var32) / var27;
                           var37 = var20 + var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 = var23 + var32;
                        }

                        if((var32 = (var35 - var27) / var27) > var37) {
                           var37 = var32;
                        }

                        if((var32 = var36 - (this.height << 12)) >= 0) {
                           var32 = (var26 - var32) / var26;
                           var37 += var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 += var32;
                        }

                        if((var32 = (var36 - var26) / var26) > var37) {
                           var37 = var32;
                        }

                        while(var37 < 0) {
                           var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.width];
                           if(var38 != 0) {
                              Rasterizer2D.field3766[var34++] = var38;
                           } else {
                              ++var34;
                           }

                           var35 += var27;
                           var36 += var26;
                           ++var37;
                        }

                        ++var33;
                        var30 -= var26;
                        var31 += var27;
                     }
                  } else {
                     for(var33 = var22; var33 < 0; var23 += Rasterizer2D.field3761) {
                        var34 = var23;
                        var35 = (var28 * var27 >> 4) + var30;
                        var36 = (var28 * var26 >> 4) + var31;
                        var37 = var20;
                        if((var32 = var35 - (this.width << 12)) >= 0) {
                           var32 = (var27 - var32) / var27;
                           var37 = var20 + var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 = var23 + var32;
                        }

                        if((var32 = (var35 - var27) / var27) > var37) {
                           var37 = var32;
                        }

                        if(var36 < 0) {
                           var32 = (var26 - 1 - var36) / var26;
                           var37 += var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 += var32;
                        }

                        if((var32 = (var36 + 1 - (this.height << 12) - var26) / var26) > var37) {
                           var37 = var32;
                        }

                        while(var37 < 0) {
                           var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.width];
                           if(var38 != 0) {
                              Rasterizer2D.field3766[var34++] = var38;
                           } else {
                              ++var34;
                           }

                           var35 += var27;
                           var36 += var26;
                           ++var37;
                        }

                        ++var33;
                        var30 -= var26;
                        var31 += var27;
                     }
                  }
               } else if(var26 == 0) {
                  for(var33 = var22; var33 < 0; var23 += Rasterizer2D.field3761) {
                     var34 = var23;
                     var35 = (var28 * var27 >> 4) + var30;
                     var36 = var31;
                     var37 = var20;
                     if(var31 >= 0 && var31 - (this.height << 12) < 0) {
                        if(var35 < 0) {
                           var32 = (var27 - 1 - var35) / var27;
                           var37 = var20 + var32;
                           var35 += var27 * var32;
                           var34 = var23 + var32;
                        }

                        if((var32 = (var35 + 1 - (this.width << 12) - var27) / var27) > var37) {
                           var37 = var32;
                        }

                        while(var37 < 0) {
                           var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.width];
                           if(var38 != 0) {
                              Rasterizer2D.field3766[var34++] = var38;
                           } else {
                              ++var34;
                           }

                           var35 += var27;
                           ++var37;
                        }
                     }

                     ++var33;
                     var31 += var27;
                  }
               } else if(var26 < 0) {
                  for(var33 = var22; var33 < 0; var23 += Rasterizer2D.field3761) {
                     var34 = var23;
                     var35 = (var28 * var27 >> 4) + var30;
                     var36 = (var28 * var26 >> 4) + var31;
                     var37 = var20;
                     if(var35 < 0) {
                        var32 = (var27 - 1 - var35) / var27;
                        var37 = var20 + var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 = var23 + var32;
                     }

                     if((var32 = (var35 + 1 - (this.width << 12) - var27) / var27) > var37) {
                        var37 = var32;
                     }

                     if((var32 = var36 - (this.height << 12)) >= 0) {
                        var32 = (var26 - var32) / var26;
                        var37 += var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 += var32;
                     }

                     if((var32 = (var36 - var26) / var26) > var37) {
                        var37 = var32;
                     }

                     while(var37 < 0) {
                        var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.width];
                        if(var38 != 0) {
                           Rasterizer2D.field3766[var34++] = var38;
                        } else {
                           ++var34;
                        }

                        var35 += var27;
                        var36 += var26;
                        ++var37;
                     }

                     ++var33;
                     var30 -= var26;
                     var31 += var27;
                  }
               } else {
                  for(var33 = var22; var33 < 0; var23 += Rasterizer2D.field3761) {
                     var34 = var23;
                     var35 = (var28 * var27 >> 4) + var30;
                     var36 = (var28 * var26 >> 4) + var31;
                     var37 = var20;
                     if(var35 < 0) {
                        var32 = (var27 - 1 - var35) / var27;
                        var37 = var20 + var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 = var23 + var32;
                     }

                     if((var32 = (var35 + 1 - (this.width << 12) - var27) / var27) > var37) {
                        var37 = var32;
                     }

                     if(var36 < 0) {
                        var32 = (var26 - 1 - var36) / var26;
                        var37 += var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 += var32;
                     }

                     if((var32 = (var36 + 1 - (this.height << 12) - var26) / var26) > var37) {
                        var37 = var32;
                     }

                     while(var37 < 0) {
                        var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.width];
                        if(var38 != 0) {
                           Rasterizer2D.field3766[var34++] = var38;
                        } else {
                           ++var34;
                        }

                        var35 += var27;
                        var36 += var26;
                        ++var37;
                     }

                     ++var33;
                     var30 -= var26;
                     var31 += var27;
                  }
               }

            }
         }
      }
   }

   public void method5853(int var1, int var2, int var3, int var4) {
      if(var3 > 0 && var4 > 0) {
         int var5 = this.width;
         int var6 = this.height;
         int var7 = 0;
         int var8 = 0;
         int var9 = this.maxWidth;
         int var10 = this.maxHeight;
         int var11 = (var9 << 16) / var3;
         int var12 = (var10 << 16) / var4;
         int var13;
         if(this.offsetX > 0) {
            var13 = (var11 + (this.offsetX << 16) - 1) / var11;
            var1 += var13;
            var7 += var13 * var11 - (this.offsetX << 16);
         }

         if(this.offsetY > 0) {
            var13 = (var12 + (this.offsetY << 16) - 1) / var12;
            var2 += var13;
            var8 += var13 * var12 - (this.offsetY << 16);
         }

         if(var5 < var9) {
            var3 = (var11 + ((var5 << 16) - var7) - 1) / var11;
         }

         if(var6 < var10) {
            var4 = (var12 + ((var6 << 16) - var8) - 1) / var12;
         }

         var13 = var1 + var2 * Rasterizer2D.field3761;
         int var14 = Rasterizer2D.field3761 - var3;
         if(var2 + var4 > Rasterizer2D.field3764) {
            var4 -= var2 + var4 - Rasterizer2D.field3764;
         }

         int var15;
         if(var2 < Rasterizer2D.field3763) {
            var15 = Rasterizer2D.field3763 - var2;
            var4 -= var15;
            var13 += var15 * Rasterizer2D.field3761;
            var8 += var12 * var15;
         }

         if(var3 + var1 > Rasterizer2D.field3760) {
            var15 = var3 + var1 - Rasterizer2D.field3760;
            var3 -= var15;
            var14 += var15;
         }

         if(var1 < Rasterizer2D.field3765) {
            var15 = Rasterizer2D.field3765 - var1;
            var3 -= var15;
            var13 += var15;
            var7 += var11 * var15;
            var14 += var15;
         }

         method5854(Rasterizer2D.field3766, this.pixels, 0, var7, var8, var13, var14, var3, var4, var11, var12, var5);
      }
   }

   public void method5872(int var1, int var2, int var3, int var4) {
      if(var3 <= this.maxWidth && var4 <= this.maxHeight) {
         int var5 = var3 * this.offsetX / this.maxWidth + var1;
         int var6 = (var3 * (this.offsetX + this.width) + this.maxWidth - 1) / this.maxWidth + var1;
         int var7 = var2 + var4 * this.offsetY / this.maxHeight;
         int var8 = var2 + (this.maxHeight + (this.offsetY + this.height) * var4 - 1) / this.maxHeight;
         if(var5 < Rasterizer2D.field3765) {
            var5 = Rasterizer2D.field3765;
         }

         if(var6 > Rasterizer2D.field3760) {
            var6 = Rasterizer2D.field3760;
         }

         if(var7 < Rasterizer2D.field3763) {
            var7 = Rasterizer2D.field3763;
         }

         if(var8 > Rasterizer2D.field3764) {
            var8 = Rasterizer2D.field3764;
         }

         if(var5 < var6 && var7 < var8) {
            int var9 = var5 + var7 * Rasterizer2D.field3761;
            int var10 = Rasterizer2D.field3761 - (var6 - var5);
            if(var9 < Rasterizer2D.field3766.length) {
               for(int var11 = var7; var11 < var8; var11++) {
                  for(int var12 = var5; var12 < var6; var12++) {
                     int var13 = var12 - var1 << 4;
                     int var14 = var11 - var2 << 4;
                     int var15 = var13 * this.maxWidth / var3 - (this.offsetX << 4);
                     int var16 = (var13 + 16) * this.maxWidth / var3 - (this.offsetX << 4);
                     int var17 = var14 * this.maxHeight / var4 - (this.offsetY << 4);
                     int var18 = (var14 + 16) * this.maxHeight / var4 - (this.offsetY << 4);
                     int var19 = (var16 - var15) * (var18 - var17) >> 1;
                     if(var19 != 0) {
                        if(var15 < 0) {
                           var15 = 0;
                        }

                        if(var16 >= this.width << 4) {
                           var16 = this.width << 4;
                        }

                        if(var17 < 0) {
                           var17 = 0;
                        }

                        if(var18 >= this.height << 4) {
                           var18 = this.height << 4;
                        }

                        --var16;
                        --var18;
                        int var20 = 16 - (var15 & 15);
                        int var21 = (var16 & 15) + 1;
                        int var22 = 16 - (var17 & 15);
                        int var23 = (var18 & 15) + 1;
                        var15 >>= 4;
                        var16 >>= 4;
                        var17 >>= 4;
                        var18 >>= 4;
                        int var24 = 0;
                        int var25 = 0;
                        int var26 = 0;
                        int var27 = 0;

                        int var28;
                        for(var28 = var17; var28 <= var18; var28++) {
                           int var29 = 16;
                           if(var28 == var17) {
                              var29 = var22;
                           }

                           if(var28 == var18) {
                              var29 = var23;
                           }

                           for(int var30 = var15; var30 <= var16; var30++) {
                              int var31 = this.pixels[var30 + var28 * this.width];
                              if(var31 != 0) {
                                 int var32;
                                 if(var30 == var15) {
                                    var32 = var29 * var20;
                                 } else if(var30 == var16) {
                                    var32 = var29 * var21;
                                 } else {
                                    var32 = var29 << 4;
                                 }

                                 var27 += var32;
                                 var24 += var32 * (var31 >> 16 & 255);
                                 var25 += var32 * (var31 >> 8 & 255);
                                 var26 += (var31 & 255) * var32;
                              }
                           }
                        }

                        if(var27 >= var19) {
                           var28 = var26 / var27 + (var24 / var27 << 16) + (var25 / var27 << 8);
                           if(var28 == 0) {
                              var28 = 1;
                           }

                           Rasterizer2D.field3766[var9] = var28;
                        }

                        ++var9;
                     }
                  }

                  var9 += var10;
               }

            }
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   public void method5849(int var1, int var2) {
      var1 += this.offsetX;
      var2 += this.offsetY;
      int var3 = var1 + var2 * Rasterizer2D.field3761;
      int var4 = 0;
      int var5 = this.height;
      int var6 = this.width;
      int var7 = Rasterizer2D.field3761 - var6;
      int var8 = 0;
      int var9;
      if(var2 < Rasterizer2D.field3763) {
         var9 = Rasterizer2D.field3763 - var2;
         var5 -= var9;
         var2 = Rasterizer2D.field3763;
         var4 += var9 * var6;
         var3 += var9 * Rasterizer2D.field3761;
      }

      if(var5 + var2 > Rasterizer2D.field3764) {
         var5 -= var5 + var2 - Rasterizer2D.field3764;
      }

      if(var1 < Rasterizer2D.field3765) {
         var9 = Rasterizer2D.field3765 - var1;
         var6 -= var9;
         var1 = Rasterizer2D.field3765;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 + var1 > Rasterizer2D.field3760) {
         var9 = var6 + var1 - Rasterizer2D.field3760;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method5926(Rasterizer2D.field3766, this.pixels, var4, var3, var6, var5, var7, var8);
      }
   }

   public void method5850() {
      Rasterizer2D.method5718(this.pixels, this.width, this.height);
   }

   public Sprite method5852() {
      Sprite var1 = new Sprite(this.maxWidth, this.maxHeight);

      for(int var2 = 0; var2 < this.height; var2++) {
         for(int var3 = 0; var3 < this.width; var3++) {
            var1.pixels[var3 + (var2 + this.offsetY) * this.maxWidth + this.offsetX] = this.pixels[var3 + var2 * this.width];
         }
      }

      return var1;
   }

   public void method5842() {
      int[] var1 = new int[this.width * this.height];
      int var2 = 0;

      for(int var3 = this.height - 1; var3 >= 0; --var3) {
         for(int var4 = 0; var4 < this.width; var4++) {
            var1[var2++] = this.pixels[var4 + var3 * this.width];
         }
      }

      this.pixels = var1;
      this.offsetY = this.maxHeight - this.height - this.offsetY;
   }

   public void method5934() {
      int[] var1 = new int[this.width * this.height];
      int var2 = 0;

      for(int var3 = 0; var3 < this.height; var3++) {
         for(int var4 = this.width - 1; var4 >= 0; --var4) {
            var1[var2++] = this.pixels[var4 + var3 * this.width];
         }
      }

      this.pixels = var1;
      this.offsetX = this.maxWidth - this.width - this.offsetX;
   }

   public void method5844(int var1) {
      if(this.width != this.maxWidth || this.height != this.maxHeight) {
         int var2 = var1;
         if(var1 > this.offsetX) {
            var2 = this.offsetX;
         }

         int var3 = var1;
         if(var1 + this.offsetX + this.width > this.maxWidth) {
            var3 = this.maxWidth - this.offsetX - this.width;
         }

         int var4 = var1;
         if(var1 > this.offsetY) {
            var4 = this.offsetY;
         }

         int var5 = var1;
         if(var1 + this.offsetY + this.height > this.maxHeight) {
            var5 = this.maxHeight - this.offsetY - this.height;
         }

         int var6 = var2 + var3 + this.width;
         int var7 = var4 + var5 + this.height;
         int[] var8 = new int[var6 * var7];

         for(int var9 = 0; var9 < this.height; var9++) {
            for(int var10 = 0; var10 < this.width; var10++) {
               var8[var6 * (var9 + var4) + var10 + var2] = this.pixels[var10 + var9 * this.width];
            }
         }

         this.pixels = var8;
         this.width = var6;
         this.height = var7;
         this.offsetX -= var2;
         this.offsetY -= var4;
      }
   }

   public void method5847(int var1) {
      int[] var2 = new int[this.width * this.height];
      int var3 = 0;

      for(int var4 = 0; var4 < this.height; var4++) {
         for(int var5 = 0; var5 < this.width; var5++) {
            int var6 = this.pixels[var3];
            if(var6 == 0) {
               if(var5 > 0 && this.pixels[var3 - 1] != 0) {
                  var6 = var1;
               } else if(var4 > 0 && this.pixels[var3 - this.width] != 0) {
                  var6 = var1;
               } else if(var5 < this.width - 1 && this.pixels[var3 + 1] != 0) {
                  var6 = var1;
               } else if(var4 < this.height - 1 && this.pixels[var3 + this.width] != 0) {
                  var6 = var1;
               }
            }

            var2[var3++] = var6;
         }
      }

      this.pixels = var2;
   }

   public void method5904(int var1, int var2, int var3, int var4, int var5) {
      if(var3 > 0 && var4 > 0) {
         int var6 = this.width;
         int var7 = this.height;
         int var8 = 0;
         int var9 = 0;
         int var10 = this.maxWidth;
         int var11 = this.maxHeight;
         int var12 = (var10 << 16) / var3;
         int var13 = (var11 << 16) / var4;
         int var14;
         if(this.offsetX > 0) {
            var14 = (var12 + (this.offsetX << 16) - 1) / var12;
            var1 += var14;
            var8 += var14 * var12 - (this.offsetX << 16);
         }

         if(this.offsetY > 0) {
            var14 = (var13 + (this.offsetY << 16) - 1) / var13;
            var2 += var14;
            var9 += var14 * var13 - (this.offsetY << 16);
         }

         if(var6 < var10) {
            var3 = (var12 + ((var6 << 16) - var8) - 1) / var12;
         }

         if(var7 < var11) {
            var4 = (var13 + ((var7 << 16) - var9) - 1) / var13;
         }

         var14 = var1 + var2 * Rasterizer2D.field3761;
         int var15 = Rasterizer2D.field3761 - var3;
         if(var2 + var4 > Rasterizer2D.field3764) {
            var4 -= var2 + var4 - Rasterizer2D.field3764;
         }

         int var16;
         if(var2 < Rasterizer2D.field3763) {
            var16 = Rasterizer2D.field3763 - var2;
            var4 -= var16;
            var14 += var16 * Rasterizer2D.field3761;
            var9 += var13 * var16;
         }

         if(var3 + var1 > Rasterizer2D.field3760) {
            var16 = var3 + var1 - Rasterizer2D.field3760;
            var3 -= var16;
            var15 += var16;
         }

         if(var1 < Rasterizer2D.field3765) {
            var16 = Rasterizer2D.field3765 - var1;
            var3 -= var16;
            var14 += var16;
            var8 += var12 * var16;
            var15 += var16;
         }

         if(var5 == 256) {
            method5933(0, 0, 0, var8, this.pixels, Rasterizer2D.field3766, 0, 0, -var4, var9, var14, var15, var3, var12, var13, var6);
         } else {
            method5913(0, 0, 0, var8, this.pixels, Rasterizer2D.field3766, 0, 0, -var4, var9, var14, var15, var3, var12, var13, var6, var5);
         }

      }
   }

   public void method5861(int var1, int var2, int var3) {
      var1 += this.offsetX;
      var2 += this.offsetY;
      int var4 = var1 + var2 * Rasterizer2D.field3761;
      int var5 = 0;
      int var6 = this.height;
      int var7 = this.width;
      int var8 = Rasterizer2D.field3761 - var7;
      int var9 = 0;
      int var10;
      if(var2 < Rasterizer2D.field3763) {
         var10 = Rasterizer2D.field3763 - var2;
         var6 -= var10;
         var2 = Rasterizer2D.field3763;
         var5 += var10 * var7;
         var4 += var10 * Rasterizer2D.field3761;
      }

      if(var6 + var2 > Rasterizer2D.field3764) {
         var6 -= var6 + var2 - Rasterizer2D.field3764;
      }

      if(var1 < Rasterizer2D.field3765) {
         var10 = Rasterizer2D.field3765 - var1;
         var7 -= var10;
         var1 = Rasterizer2D.field3765;
         var5 += var10;
         var4 += var10;
         var9 += var10;
         var8 += var10;
      }

      if(var7 + var1 > Rasterizer2D.field3760) {
         var10 = var7 + var1 - Rasterizer2D.field3760;
         var7 -= var10;
         var9 += var10;
         var8 += var10;
      }

      if(var7 > 0 && var6 > 0) {
         if(var3 == 256) {
            method5862(0, 0, 0, Rasterizer2D.field3766, this.pixels, var5, 0, var4, 0, var7, var6, var8, var9);
         } else {
            method5917(0, 0, 0, Rasterizer2D.field3766, this.pixels, var5, 0, var4, 0, var7, var6, var8, var9, var3);
         }

      }
   }

   public void method5848(int var1) {
      for(int var2 = this.height - 1; var2 > 0; --var2) {
         int var3 = var2 * this.width;

         for(int var4 = this.width - 1; var4 > 0; --var4) {
            if(this.pixels[var4 + var3] == 0 && this.pixels[var4 + var3 - 1 - this.width] != 0) {
               this.pixels[var4 + var3] = var1;
            }
         }
      }

   }

   public void method5845(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int[] var9, int[] var10) {
      try {
         int var11 = -var3 / 2;
         int var12 = -var4 / 2;
         int var13 = (int)(Math.sin((double)var7 / 326.11D) * 65536.0D);
         int var14 = (int)(Math.cos((double)var7 / 326.11D) * 65536.0D);
         var13 = var13 * var8 >> 8;
         var14 = var14 * var8 >> 8;
         int var15 = var12 * var13 + var11 * var14 + (var5 << 16);
         int var16 = var12 * var14 - var11 * var13 + (var6 << 16);
         int var17 = var1 + var2 * Rasterizer2D.field3761;

         for(var2 = 0; var2 < var4; var2++) {
            int var18 = var9[var2];
            int var19 = var17 + var18;
            int var20 = var15 + var14 * var18;
            int var21 = var16 - var13 * var18;

            for(var1 = -var10[var2]; var1 < 0; var1++) {
               Rasterizer2D.field3766[var19++] = this.pixels[this.width * (var21 >> 16) + (var20 >> 16)];
               var20 += var14;
               var21 -= var13;
            }

            var15 += var13;
            var16 += var14;
            var17 += Rasterizer2D.field3761;
         }
      } catch (Exception var23) {
         ;
      }

   }

   public void method5856(int var1, int var2, int var3, int var4, int var5) {
      if(var3 > 0 && var4 > 0) {
         int var6 = this.width;
         int var7 = this.height;
         int var8 = 0;
         int var9 = 0;
         int var10 = this.maxWidth;
         int var11 = this.maxHeight;
         int var12 = (var10 << 16) / var3;
         int var13 = (var11 << 16) / var4;
         int var14;
         if(this.offsetX > 0) {
            var14 = (var12 + (this.offsetX << 16) - 1) / var12;
            var1 += var14;
            var8 += var14 * var12 - (this.offsetX << 16);
         }

         if(this.offsetY > 0) {
            var14 = (var13 + (this.offsetY << 16) - 1) / var13;
            var2 += var14;
            var9 += var14 * var13 - (this.offsetY << 16);
         }

         if(var6 < var10) {
            var3 = (var12 + ((var6 << 16) - var8) - 1) / var12;
         }

         if(var7 < var11) {
            var4 = (var13 + ((var7 << 16) - var9) - 1) / var13;
         }

         var14 = var1 + var2 * Rasterizer2D.field3761;
         int var15 = Rasterizer2D.field3761 - var3;
         if(var2 + var4 > Rasterizer2D.field3764) {
            var4 -= var2 + var4 - Rasterizer2D.field3764;
         }

         int var16;
         if(var2 < Rasterizer2D.field3763) {
            var16 = Rasterizer2D.field3763 - var2;
            var4 -= var16;
            var14 += var16 * Rasterizer2D.field3761;
            var9 += var13 * var16;
         }

         if(var3 + var1 > Rasterizer2D.field3760) {
            var16 = var3 + var1 - Rasterizer2D.field3760;
            var3 -= var16;
            var15 += var16;
         }

         if(var1 < Rasterizer2D.field3765) {
            var16 = Rasterizer2D.field3765 - var1;
            var3 -= var16;
            var14 += var16;
            var8 += var12 * var16;
            var15 += var16;
         }

         method5860(Rasterizer2D.field3766, this.pixels, 0, var8, var9, var14, var15, var3, var4, var12, var13, var6, var5);
      }
   }

   public void method5870(int var1, int var2, int var3, int var4) {
      this.method5871(this.maxWidth << 3, this.maxHeight << 3, var1 << 4, var2 << 4, var3, var4);
   }

   public void method5857(int var1, int var2, int var3) {
      var1 += this.offsetX;
      var2 += this.offsetY;
      int var4 = var1 + var2 * Rasterizer2D.field3761;
      int var5 = 0;
      int var6 = this.height;
      int var7 = this.width;
      int var8 = Rasterizer2D.field3761 - var7;
      int var9 = 0;
      int var10;
      if(var2 < Rasterizer2D.field3763) {
         var10 = Rasterizer2D.field3763 - var2;
         var6 -= var10;
         var2 = Rasterizer2D.field3763;
         var5 += var10 * var7;
         var4 += var10 * Rasterizer2D.field3761;
      }

      if(var6 + var2 > Rasterizer2D.field3764) {
         var6 -= var6 + var2 - Rasterizer2D.field3764;
      }

      if(var1 < Rasterizer2D.field3765) {
         var10 = Rasterizer2D.field3765 - var1;
         var7 -= var10;
         var1 = Rasterizer2D.field3765;
         var5 += var10;
         var4 += var10;
         var9 += var10;
         var8 += var10;
      }

      if(var7 + var1 > Rasterizer2D.field3760) {
         var10 = var7 + var1 - Rasterizer2D.field3760;
         var7 -= var10;
         var9 += var10;
         var8 += var10;
      }

      if(var7 > 0 && var6 > 0) {
         method5846(Rasterizer2D.field3766, this.pixels, 0, var5, var4, var7, var6, var8, var9, var3);
      }
   }

   public void method5843() {
      if(this.width != this.maxWidth || this.height != this.maxHeight) {
         int[] var1 = new int[this.maxWidth * this.maxHeight];

         for(int var2 = 0; var2 < this.height; var2++) {
            for(int var3 = 0; var3 < this.width; var3++) {
               var1[var3 + (var2 + this.offsetY) * this.maxWidth + this.offsetX] = this.pixels[var3 + var2 * this.width];
            }
         }

         this.pixels = var1;
         this.width = this.maxWidth;
         this.height = this.maxHeight;
         this.offsetX = 0;
         this.offsetY = 0;
      }
   }

   public void method5855(int var1, int var2, int var3, int var4) {
      if(var3 == 256) {
         this.method5851(var1, var2);
      } else {
         var1 += this.offsetX;
         var2 += this.offsetY;
         int var5 = var1 + var2 * Rasterizer2D.field3761;
         int var6 = 0;
         int var7 = this.height;
         int var8 = this.width;
         int var9 = Rasterizer2D.field3761 - var8;
         int var10 = 0;
         int var11;
         if(var2 < Rasterizer2D.field3763) {
            var11 = Rasterizer2D.field3763 - var2;
            var7 -= var11;
            var2 = Rasterizer2D.field3763;
            var6 += var11 * var8;
            var5 += var11 * Rasterizer2D.field3761;
         }

         if(var7 + var2 > Rasterizer2D.field3764) {
            var7 -= var7 + var2 - Rasterizer2D.field3764;
         }

         if(var1 < Rasterizer2D.field3765) {
            var11 = Rasterizer2D.field3765 - var1;
            var8 -= var11;
            var1 = Rasterizer2D.field3765;
            var6 += var11;
            var5 += var11;
            var10 += var11;
            var9 += var11;
         }

         if(var8 + var1 > Rasterizer2D.field3760) {
            var11 = var8 + var1 - Rasterizer2D.field3760;
            var8 -= var11;
            var10 += var11;
            var9 += var11;
         }

         if(var8 > 0 && var7 > 0) {
            method5897(Rasterizer2D.field3766, this.pixels, 0, var6, var5, var8, var7, var9, var10, var3, var4);
         }
      }
   }

   public void method5867(int var1, int var2, int var3, int var4, int var5, int var6, int[] var7, int[] var8) {
      int var9 = var2 < 0 ? -var2 : 0;
      int var10 = var2 + this.height <= var6 ? this.height : var6 - var2;
      int var11 = var1 < 0 ? -var1 : 0;
      int var10000;
      if(this.width + var1 <= var5) {
         var10000 = this.width;
      } else {
         var10000 = var5 - var1;
      }

      int var13 = var3 + var11 + (var9 + var2 + var4) * Rasterizer2D.field3761 + var1;
      int var14 = var9 + var2;

      for(int var15 = var9; var15 < var10; var15++) {
         int var16 = var7[var14];
         int var17 = var8[var14++];
         int var18 = var13;
         int var19;
         if(var1 < var16) {
            var19 = var16 - var1;
            var18 = var13 + (var19 - var11);
         } else {
            var19 = var11;
         }

         int var12;
         if(this.width + var1 <= var16 + var17) {
            var12 = this.width;
         } else {
            var12 = var16 + var17 - var1;
         }

         for(int var20 = var19; var20 < var12; var20++) {
            int var21 = this.pixels[var20 + var15 * this.width];
            if(var21 != 0) {
               Rasterizer2D.field3766[var18++] = var21;
            } else {
               ++var18;
            }
         }

         var13 += Rasterizer2D.field3761;
      }

   }

   public void method5865(int var1, int var2, int var3, int var4, int var5, int var6, double var7, int var9) {
      try {
         int var10 = -var3 / 2;
         int var11 = -var4 / 2;
         int var12 = (int)(Math.sin(var7) * 65536.0D);
         int var13 = (int)(Math.cos(var7) * 65536.0D);
         var12 = var12 * var9 >> 8;
         var13 = var13 * var9 >> 8;
         int var14 = var11 * var12 + var10 * var13 + (var5 << 16);
         int var15 = var11 * var13 - var10 * var12 + (var6 << 16);
         int var16 = var1 + var2 * Rasterizer2D.field3761;

         for(var2 = 0; var2 < var4; var2++) {
            int var17 = var16;
            int var18 = var14;
            int var19 = var15;

            for(var1 = -var3; var1 < 0; var1++) {
               int var20 = this.pixels[this.width * (var19 >> 16) + (var18 >> 16)];
               if(var20 != 0) {
                  Rasterizer2D.field3766[var17++] = var20;
               } else {
                  ++var17;
               }

               var18 += var13;
               var19 -= var12;
            }

            var14 += var12;
            var15 += var13;
            var16 += Rasterizer2D.field3761;
         }
      } catch (Exception var22) {
         ;
      }

   }

   public Sprite method5840() {
      Sprite var1 = new Sprite(this.width, this.height);
      var1.maxWidth = this.maxWidth;
      var1.maxHeight = this.maxHeight;
      var1.offsetX = this.maxWidth - this.width - this.offsetX;
      var1.offsetY = this.offsetY;

      for(int var2 = 0; var2 < this.height; var2++) {
         for(int var3 = 0; var3 < this.width; var3++) {
            var1.pixels[var3 + var2 * this.width] = this.pixels[var2 * this.width + this.width - 1 - var3];
         }
      }

      return var1;
   }

   static void method5926(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = -var5; var8 < 0; var8++) {
         int var9;
         for(var9 = var3 + var4 - 3; var3 < var9; var0[var3++] = var1[var2++]) {
            var0[var3++] = var1[var2++];
            var0[var3++] = var1[var2++];
            var0[var3++] = var1[var2++];
         }

         for(var9 += 3; var3 < var9; var0[var3++] = var1[var2++]) {
            ;
         }

         var3 += var6;
         var2 += var7;
      }

   }

   static void method5846(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      int var10 = 256 - var9;

      for(int var11 = -var6; var11 < 0; var11++) {
         for(int var12 = -var5; var12 < 0; var12++) {
            var2 = var1[var3++];
            if(var2 != 0) {
               int var13 = var0[var4];
               var0[var4++] = ((var13 & 16711935) * var10 + var9 * (var2 & 16711935) & -16711936) + ((var2 & 65280) * var9 + var10 * (var13 & 65280) & 16711680) >> 8;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   static void method5859(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = -(var5 >> 2);
      var5 = -(var5 & 3);

      for(int var10 = -var6; var10 < 0; var10++) {
         int var11;
         for(var11 = var9; var11 < 0; var11++) {
            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         for(var11 = var5; var11 < 0; var11++) {
            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   static void method5862(int var0, int var1, int var2, int[] var3, int[] var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      for(var8 = -var10; var8 < 0; var8++) {
         for(var6 = -var9; var6 < 0; var6++) {
            var0 = var4[var5++];
            if(var0 != 0) {
               var1 = var3[var7];
               var2 = var0 + var1;
               var0 = (var0 & 16711935) + (var1 & 16711935);
               var1 = (var0 & 16777472) + (var2 - var0 & 65536);
               var3[var7++] = var2 - var1 | var1 - (var1 >>> 8);
            } else {
               ++var7;
            }
         }

         var7 += var11;
         var5 += var12;
      }

   }

   static void method5897(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      int var11 = 256 - var9;
      int var12 = (var10 & 16711935) * var11 & -16711936;
      int var13 = (var10 & 65280) * var11 & 16711680;
      var10 = (var12 | var13) >>> 8;

      for(int var14 = -var6; var14 < 0; var14++) {
         for(int var15 = -var5; var15 < 0; var15++) {
            var2 = var1[var3++];
            if(var2 != 0) {
               var12 = var9 * (var2 & 16711935) & -16711936;
               var13 = (var2 & 65280) * var9 & 16711680;
               var0[var4++] = var10 + ((var12 | var13) >>> 8);
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   static void method5917(int var0, int var1, int var2, int[] var3, int[] var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      for(var8 = -var10; var8 < 0; var8++) {
         for(var6 = -var9; var6 < 0; var6++) {
            var0 = var4[var5++];
            if(var0 != 0) {
               var1 = var13 * (var0 & 16711935);
               var0 = (var1 & -16711936) + (var13 * var0 - var1 & 16711680) >>> 8;
               var1 = var3[var7];
               var2 = var0 + var1;
               var0 = (var0 & 16711935) + (var1 & 16711935);
               var1 = (var0 & 16777472) + (var2 - var0 & 65536);
               var3[var7++] = var2 - var1 | var1 - (var1 >>> 8);
            } else {
               ++var7;
            }
         }

         var7 += var11;
         var5 += var12;
      }

   }

   static void method5860(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      int var13 = 256 - var12;
      int var14 = var3;

      for(int var15 = -var8; var15 < 0; var15++) {
         int var16 = var11 * (var4 >> 16);

         for(int var17 = -var7; var17 < 0; var17++) {
            var2 = var1[(var3 >> 16) + var16];
            if(var2 != 0) {
               int var18 = var0[var5];
               var0[var5++] = ((var2 & 65280) * var12 + var13 * (var18 & 65280) & 16711680) + ((var18 & 16711935) * var13 + var12 * (var2 & 16711935) & -16711936) >> 8;
            } else {
               ++var5;
            }

            var3 += var9;
         }

         var4 += var10;
         var3 = var14;
         var5 += var6;
      }

   }

   static void method5854(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      int var12 = var3;

      for(int var13 = -var8; var13 < 0; var13++) {
         int var14 = var11 * (var4 >> 16);

         for(int var15 = -var7; var15 < 0; var15++) {
            var2 = var1[(var3 >> 16) + var14];
            if(var2 != 0) {
               var0[var5++] = var2;
            } else {
               ++var5;
            }

            var3 += var9;
         }

         var4 += var10;
         var3 = var12;
         var5 += var6;
      }

   }

   static void method5933(int var0, int var1, int var2, int var3, int[] var4, int[] var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15) {
      for(int var16 = var3; var8 < 0; var8++) {
         var7 = var15 * (var9 >> 16);

         for(var6 = -var12; var6 < 0; var6++) {
            var0 = var4[(var3 >> 16) + var7];
            if(var0 != 0) {
               var1 = var5[var10];
               var2 = var0 + var1;
               var0 = (var0 & 16711935) + (var1 & 16711935);
               var1 = (var0 & 16777472) + (var2 - var0 & 65536);
               var5[var10++] = var2 - var1 | var1 - (var1 >>> 8);
            } else {
               ++var10;
            }

            var3 += var13;
         }

         var9 += var14;
         var3 = var16;
         var10 += var11;
      }

   }

   static void method5913(int var0, int var1, int var2, int var3, int[] var4, int[] var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16) {
      for(int var17 = var3; var8 < 0; var8++) {
         var7 = var15 * (var9 >> 16);

         for(var6 = -var12; var6 < 0; var6++) {
            var0 = var4[(var3 >> 16) + var7];
            if(var0 != 0) {
               var1 = (var0 & 16711935) * var16;
               var0 = (var1 & -16711936) + (var0 * var16 - var1 & 16711680) >>> 8;
               var1 = var5[var10];
               var2 = var0 + var1;
               var0 = (var0 & 16711935) + (var1 & 16711935);
               var1 = (var0 & 16777472) + (var2 - var0 & 65536);
               var5[var10++] = var2 - var1 | var1 - (var1 >>> 8);
            } else {
               ++var10;
            }

            var3 += var13;
         }

         var9 += var14;
         var3 = var17;
         var10 += var11;
      }

   }
}
