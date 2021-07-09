package client;

import java.util.Random;

public abstract class class299 extends Rasterizer2D {
   static int field3700 = -1;
   static String[] field3710 = new String[100];
   static int field3691 = -1;
   static Random field3709 = new Random();
   static int field3706 = 256;
   static int field3702 = -1;
   static int field3704 = 0;
   static int field3692 = 0;
   static int field3708 = -1;
   static int field3701 = 0;
   static int field3705 = 0;
   public static PaletteSprite[] field3698;
   public int field3695 = 0;
   int[] field3703;
   byte[][] field3707 = new byte[256][];
   public int field3696;
   public int field3697;
   int[] field3693;
   int[] field3694;
   byte[] field3699;
   int[] field3689;
   int[] field3690;

   class299(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3693 = var2;
      this.field3694 = var3;
      this.field3689 = var4;
      this.field3690 = var5;
      this.method5540(var1);
      this.field3707 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; var10++) {
         if(this.field3694[var10] < var8 && this.field3690[var10] != 0) {
            var8 = this.field3694[var10];
         }

         if(this.field3694[var10] + this.field3690[var10] > var9) {
            var9 = this.field3694[var10] + this.field3690[var10];
         }
      }

      this.field3696 = this.field3695 - var8;
      this.field3697 = var9 - this.field3695;
   }

   class299(byte[] var1) {
      this.method5540(var1);
   }

   void method5531(int var1, int var2) {
      field3700 = -1;
      field3691 = -1;
      field3702 = var2;
      field3708 = var2;
      field3704 = var1;
      field3692 = var1;
      field3706 = 256;
      field3701 = 0;
      field3705 = 0;
   }

   public int method5517(String var1) {
      if(var1 == null) {
         return 0;
      } else {
         int var2 = -1;
         int var3 = -1;
         int var4 = 0;

         for(int var5 = 0; var5 < var1.length(); var5++) {
            char var6 = var1.charAt(var5);
            if(var6 == 60) {
               var2 = var5;
            } else {
               if(var6 == 62 && var2 != -1) {
                  String var7 = var1.substring(var2 + 1, var5);
                  var2 = -1;
                  if(var7.equals("lt")) {
                     var6 = 60;
                  } else {
                     if(!var7.equals("gt")) {
                        if(var7.startsWith("img=")) {
                           try {
                              String var9 = var7.substring(4);
                              int var8 = class68.method1693(var9, 10, true);
                              var4 += field3698[var8].width;
                              var3 = -1;
                           } catch (Exception var12) {
                              ;
                           }
                        }
                        continue;
                     }

                     var6 = 62;
                  }
               }

               if(var6 == 160) {
                  var6 = 32;
               }

               if(var2 == -1) {
                  var4 += this.field3703[(char)(class166.method3441(var6, 177794495) & 255)];
                  if(this.field3699 != null && var3 != -1) {
                     var4 += this.field3699[var6 + (var3 << 8)];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   public int method5518(String var1, int[] var2, String[] var3) {
      if(var1 == null) {
         return 0;
      } else {
         int var4 = 0;
         int var5 = 0;
         StringBuilder var6 = new StringBuilder(100);
         int var7 = -1;
         int var8 = 0;
         byte var9 = 0;
         int var10 = -1;
         char var11 = 0;
         int var12 = 0;
         int var13 = var1.length();

         for(int var14 = 0; var14 < var13; var14++) {
            char var15 = var1.charAt(var14);
            if(var15 == 60) {
               var10 = var14;
            } else {
               if(var15 == 62 && var10 != -1) {
                  String var16 = var1.substring(var10 + 1, var14);
                  var10 = -1;
                  var6.append('<');
                  var6.append(var16);
                  var6.append('>');
                  if(var16.equals("br")) {
                     var3[var12] = var6.toString().substring(var5, var6.length());
                     ++var12;
                     var5 = var6.length();
                     var4 = 0;
                     var7 = -1;
                     var11 = 0;
                  } else if(var16.equals("lt")) {
                     var4 += this.method5516('<');
                     if(this.field3699 != null && var11 != -1) {
                        var4 += this.field3699[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method5516('>');
                     if(this.field3699 != null && var11 != -1) {
                        var4 += this.field3699[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = class68.method1693(var18, 10, true);
                        var4 += field3698[var17].width;
                        var11 = 0;
                     } catch (Exception var22) {
                        ;
                     }
                  }

                  var15 = 0;
               }

               if(var10 == -1) {
                  if(var15 != 0) {
                     var6.append(var15);
                     var4 += this.method5516(var15);
                     if(this.field3699 != null && var11 != -1) {
                        var4 += this.field3699[var15 + (var11 << 8)];
                     }

                     var11 = var15;
                  }

                  if(var15 == 32) {
                     var7 = var6.length();
                     var8 = var4;
                     var9 = 1;
                  }

                  if(var2 != null && var4 > var2[var12 < var2.length ? var12 : var2.length - 1] && var7 >= 0) {
                     var3[var12] = var6.toString().substring(var5, var7 - var9);
                     ++var12;
                     var5 = var7;
                     var7 = -1;
                     var4 -= var8;
                     var11 = 0;
                  }

                  if(var15 == 45) {
                     var7 = var6.length();
                     var8 = var4;
                     var9 = 0;
                  }
               }
            }
         }

         String var21 = var6.toString();
         if(var21.length() > var5) {
            var3[var12++] = var21.substring(var5, var21.length());
         }

         return var12;
      }
   }

   void method5514(String var1, int var2, int var3) {
      var3 -= this.field3695;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); var6++) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class166.method3441(var1.charAt(var6), -1665972679) & 255);
            if(var7 == 60) {
               var4 = var6;
            } else {
               int var9;
               if(var7 == 62 && var4 != -1) {
                  String var8 = var1.substring(var4 + 1, var6);
                  var4 = -1;
                  if(var8.equals("lt")) {
                     var7 = 60;
                  } else {
                     if(!var8.equals("gt")) {
                        if(var8.startsWith("img=")) {
                           try {
                              String var10 = var8.substring(4);
                              var9 = class68.method1693(var10, 10, true);
                              PaletteSprite var12 = field3698[var9];
                              var12.method5829(var2, var3 + this.field3695 - var12.height);
                              var2 += var12.width;
                              var5 = -1;
                           } catch (Exception var16) {
                              ;
                           }
                        } else {
                           this.method5532(var8);
                        }
                        continue;
                     }

                     var7 = 62;
                  }
               }

               if(var7 == 160) {
                  var7 = 32;
               }

               if(var4 == -1) {
                  if(this.field3699 != null && var5 != -1) {
                     var2 += this.field3699[var7 + (var5 << 8)];
                  }

                  int var14 = this.field3689[var7];
                  var9 = this.field3690[var7];
                  if(var7 != 32) {
                     if(field3706 == 256) {
                        if(field3708 != -1) {
                           method5538(this.field3707[var7], var2 + this.field3693[var7] + 1, var3 + this.field3694[var7] + 1, var14, var9, field3708);
                        }

                        this.vmethod5536(this.field3707[var7], var2 + this.field3693[var7], var3 + this.field3694[var7], var14, var9, field3692);
                     } else {
                        if(field3708 != -1) {
                           method5583(this.field3707[var7], var2 + this.field3693[var7] + 1, var3 + this.field3694[var7] + 1, var14, var9, field3708, field3706);
                        }

                        this.vmethod5542(this.field3707[var7], var2 + this.field3693[var7], var3 + this.field3694[var7], var14, var9, field3692, field3706);
                     }
                  } else if(field3701 > 0) {
                     field3705 += field3701;
                     var2 += field3705 >> 8;
                     field3705 &= 255;
                  }

                  int var15 = this.field3703[var7];
                  if(field3700 != -1) {
                     Rasterizer2D.method5736(var2, var3 + (int)((double)this.field3695 * 0.7D), var15, field3700);
                  }

                  if(field3691 != -1) {
                     Rasterizer2D.method5736(var2, var3 + this.field3695 + 1, var15, field3691);
                  }

                  var2 += var15;
                  var5 = var7;
               }
            }
         }
      }

   }

   void method5540(byte[] var1) {
      this.field3703 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3703.length; var2++) {
            this.field3703[var2] = var1[var2] & 255;
         }

         this.field3695 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; var3++) {
            this.field3703[var3] = var1[var2++] & 255;
         }

         int[] var10 = new int[256];
         int[] var4 = new int[256];

         int var5;
         for(var5 = 0; var5 < 256; var5++) {
            var10[var5] = var1[var2++] & 255;
         }

         for(var5 = 0; var5 < 256; var5++) {
            var4[var5] = var1[var2++] & 255;
         }

         byte[][] var11 = new byte[256][];

         int var8;
         for(int var6 = 0; var6 < 256; var6++) {
            var11[var6] = new byte[var10[var6]];
            byte var7 = 0;

            for(var8 = 0; var8 < var11[var6].length; var8++) {
               var7 += var1[var2++];
               var11[var6][var8] = var7;
            }
         }

         byte[][] var12 = new byte[256][];

         int var13;
         for(var13 = 0; var13 < 256; var13++) {
            var12[var13] = new byte[var10[var13]];
            byte var14 = 0;

            for(int var9 = 0; var9 < var12[var13].length; var9++) {
               var14 += var1[var2++];
               var12[var13][var9] = var14;
            }
         }

         this.field3699 = new byte[65536];

         for(var13 = 0; var13 < 256; var13++) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; var8++) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3699[var8 + (var13 << 8)] = (byte)method5599(var11, var12, var4, this.field3703, var10, var13, var8);
                  }
               }
            }
         }

         this.field3695 = var4[32] + var10[32];
      }

   }

   void method5549(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3695;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); var9++) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class166.method3441(var1.charAt(var9), 1057948315) & 255);
            if(var10 == 60) {
               var6 = var9;
            } else {
               int var12;
               int var13;
               int var14;
               if(var10 == 62 && var6 != -1) {
                  String var11 = var1.substring(var6 + 1, var9);
                  var6 = -1;
                  if(var11.equals("lt")) {
                     var10 = 60;
                  } else {
                     if(!var11.equals("gt")) {
                        if(var11.startsWith("img=")) {
                           try {
                              if(var4 != null) {
                                 var12 = var4[var8];
                              } else {
                                 var12 = 0;
                              }

                              if(var5 != null) {
                                 var13 = var5[var8];
                              } else {
                                 var13 = 0;
                              }

                              ++var8;
                              String var15 = var11.substring(4);
                              var14 = class68.method1693(var15, 10, true);
                              PaletteSprite var17 = field3698[var14];
                              var17.method5829(var12 + var2, var13 + (var3 + this.field3695 - var17.height));
                              var2 += var17.width;
                              var7 = -1;
                           } catch (Exception var21) {
                              ;
                           }
                        } else {
                           this.method5532(var11);
                        }
                        continue;
                     }

                     var10 = 62;
                  }
               }

               if(var10 == 160) {
                  var10 = 32;
               }

               if(var6 == -1) {
                  if(this.field3699 != null && var7 != -1) {
                     var2 += this.field3699[var10 + (var7 << 8)];
                  }

                  int var19 = this.field3689[var10];
                  var12 = this.field3690[var10];
                  if(var4 != null) {
                     var13 = var4[var8];
                  } else {
                     var13 = 0;
                  }

                  if(var5 != null) {
                     var14 = var5[var8];
                  } else {
                     var14 = 0;
                  }

                  ++var8;
                  if(var10 != 32) {
                     if(field3706 == 256) {
                        if(field3708 != -1) {
                           method5538(this.field3707[var10], var13 + var2 + this.field3693[var10] + 1, var3 + var14 + this.field3694[var10] + 1, var19, var12, field3708);
                        }

                        this.vmethod5536(this.field3707[var10], var13 + var2 + this.field3693[var10], var3 + var14 + this.field3694[var10], var19, var12, field3692);
                     } else {
                        if(field3708 != -1) {
                           method5583(this.field3707[var10], var13 + var2 + this.field3693[var10] + 1, var3 + var14 + this.field3694[var10] + 1, var19, var12, field3708, field3706);
                        }

                        this.vmethod5542(this.field3707[var10], var13 + var2 + this.field3693[var10], var3 + var14 + this.field3694[var10], var19, var12, field3692, field3706);
                     }
                  } else if(field3701 > 0) {
                     field3705 += field3701;
                     var2 += field3705 >> 8;
                     field3705 &= 255;
                  }

                  int var20 = this.field3703[var10];
                  if(field3700 != -1) {
                     Rasterizer2D.method5736(var2, var3 + (int)((double)this.field3695 * 0.7D), var20, field3700);
                  }

                  if(field3691 != -1) {
                     Rasterizer2D.method5736(var2, var3 + this.field3695, var20, field3691);
                  }

                  var2 += var20;
                  var7 = var10;
               }
            }
         }
      }

   }

   int method5516(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3703[class166.method3441(var1, 1895206673) & 255];
   }

   public int method5520(String var1, int var2) {
      return this.method5518(var1, new int[]{var2}, field3710);
   }

   void method5532(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3692 = class138.method3137(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3692 = field3704;
         } else if(var1.startsWith("str=")) {
            field3700 = class138.method3137(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3700 = 8388608;
         } else if(var1.equals("/str")) {
            field3700 = -1;
         } else if(var1.startsWith("u=")) {
            field3691 = class138.method3137(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3691 = 0;
         } else if(var1.equals("/u")) {
            field3691 = -1;
         } else if(var1.startsWith("shad=")) {
            field3708 = class138.method3137(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3708 = 0;
         } else if(var1.equals("/shad")) {
            field3708 = field3702;
         } else if(var1.equals("br")) {
            this.method5531(field3704, field3702);
         }
      } catch (Exception var3) {
         ;
      }

   }

   public int method5526(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method5531(var6, var7);
         if(var10 == 0) {
            var10 = this.field3695;
         }

         int[] var11 = new int[]{var4};
         if(var5 < var10 + this.field3696 + this.field3697 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method5518(var1, var11, field3710);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3696;
         } else if(var9 == 1) {
            var13 = var3 + (var5 - this.field3696 - this.field3697 - var10 * (var12 - 1)) / 2 + this.field3696;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3697 - var10 * (var12 - 1);
         } else {
            var14 = (var5 - this.field3696 - this.field3697 - var10 * (var12 - 1)) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + var14 + this.field3696;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; var14++) {
            if(var8 == 0) {
               this.method5514(field3710[var14], var2, var13);
            } else if(var8 == 1) {
               this.method5514(field3710[var14], var2 + (var4 - this.method5517(field3710[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method5514(field3710[var14], var2 + var4 - this.method5517(field3710[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method5514(field3710[var14], var2, var13);
            } else {
               this.method5533(field3710[var14], var4);
               this.method5514(field3710[var14], var2, var13);
               field3701 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   void method5533(String var1, int var2) {
      int var3 = 0;
      boolean var4 = false;

      for(int var5 = 0; var5 < var1.length(); var5++) {
         char var6 = var1.charAt(var5);
         if(var6 == 60) {
            var4 = true;
         } else if(var6 == 62) {
            var4 = false;
         } else if(!var4 && var6 == 32) {
            ++var3;
         }
      }

      if(var3 > 0) {
         field3701 = (var2 - this.method5517(var1) << 8) / var3;
      }

   }

   abstract void vmethod5536(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   abstract void vmethod5542(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   public int method5519(String var1, int var2) {
      int var3 = this.method5518(var1, new int[]{var2}, field3710);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; var5++) {
         int var6 = this.method5517(field3710[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   public void method5530(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method5531(var4, var5);
         field3709.setSeed((long)var6);
         field3706 = 192 + (field3709.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); var9++) {
            var7[var9] = var8;
            if((field3709.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method5549(var1, var2, var3, var7, (int[])null);
      }
   }

   public void drawStr(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method5531(var4, var5);
         this.method5514(var1, var2 - this.method5517(var1) / 2, var3);
      }
   }

   public void method5522(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method5531(var4, var5);
         this.method5514(var1, var2, var3);
      }
   }

   public void method5524(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method5531(var4, var5);
         this.method5514(var1, var2 - this.method5517(var1), var3);
      }
   }

   public void method5609(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method5531(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); var8++) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method5549(var1, var2 - this.method5517(var1) / 2, var3, (int[])null, var7);
      }
   }

   public void method5575(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method5531(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); var9++) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method5549(var1, var2 - this.method5517(var1) / 2, var3, var7, var8);
      }
   }

   public void method5539(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method5531(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); var11++) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method5549(var1, var2 - this.method5517(var1) / 2, var3, (int[])null, var10);
      }
   }

   public void method5523(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method5531(var4, var5);
         field3706 = var6;
         this.method5514(var1, var2, var3);
      }
   }

   static int method5599(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
      int var7 = var2[var5];
      int var8 = var7 + var4[var5];
      int var9 = var2[var6];
      int var10 = var9 + var4[var6];
      int var11 = var7;
      if(var9 > var7) {
         var11 = var9;
      }

      int var12 = var8;
      if(var10 < var8) {
         var12 = var10;
      }

      int var13 = var3[var5];
      if(var3[var6] < var13) {
         var13 = var3[var6];
      }

      byte[] var14 = var1[var5];
      byte[] var15 = var0[var6];
      int var16 = var11 - var7;
      int var17 = var11 - var9;

      for(int var18 = var11; var18 < var12; var18++) {
         int var19 = var14[var16++] + var15[var17++];
         if(var19 < var13) {
            var13 = var19;
         }
      }

      return -var13;
   }

   static void method5538(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * Rasterizer2D.field3761;
      int var7 = Rasterizer2D.field3761 - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < Rasterizer2D.field3763) {
         var10 = Rasterizer2D.field3763 - var2;
         var4 -= var10;
         var2 = Rasterizer2D.field3763;
         var9 += var3 * var10;
         var6 += var10 * Rasterizer2D.field3761;
      }

      if(var2 + var4 > Rasterizer2D.field3764) {
         var4 -= var2 + var4 - Rasterizer2D.field3764;
      }

      if(var1 < Rasterizer2D.field3765) {
         var10 = Rasterizer2D.field3765 - var1;
         var3 -= var10;
         var1 = Rasterizer2D.field3765;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 + var1 > Rasterizer2D.field3760) {
         var10 = var3 + var1 - Rasterizer2D.field3760;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method5556(Rasterizer2D.field3766, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   static void method5556(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = -(var5 >> 2);
      var5 = -(var5 & 3);

      for(int var10 = -var6; var10 < 0; var10++) {
         int var11;
         for(var11 = var9; var11 < 0; var11++) {
            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         for(var11 = var5; var11 < 0; var11++) {
            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   static void method5585(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      var2 = ((var2 & 65280) * var9 & 16711680) + (var9 * (var2 & 16711935) & -16711936) >> 8;
      var9 = 256 - var9;

      for(int var10 = -var6; var10 < 0; var10++) {
         for(int var11 = -var5; var11 < 0; var11++) {
            if(var1[var3++] != 0) {
               int var12 = var0[var4];
               var0[var4++] = (((var12 & 65280) * var9 & 16711680) + ((var12 & 16711935) * var9 & -16711936) >> 8) + var2;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   static void method5583(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * Rasterizer2D.field3761;
      int var8 = Rasterizer2D.field3761 - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < Rasterizer2D.field3763) {
         var11 = Rasterizer2D.field3763 - var2;
         var4 -= var11;
         var2 = Rasterizer2D.field3763;
         var10 += var3 * var11;
         var7 += var11 * Rasterizer2D.field3761;
      }

      if(var2 + var4 > Rasterizer2D.field3764) {
         var4 -= var2 + var4 - Rasterizer2D.field3764;
      }

      if(var1 < Rasterizer2D.field3765) {
         var11 = Rasterizer2D.field3765 - var1;
         var3 -= var11;
         var1 = Rasterizer2D.field3765;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 + var1 > Rasterizer2D.field3760) {
         var11 = var3 + var1 - Rasterizer2D.field3760;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method5585(Rasterizer2D.field3766, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   public static String method5521(String var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; var3++) {
         char var4 = var0.charAt(var3);
         if(var4 == 60 || var4 == 62) {
            var2 += 3;
         }
      }

      StringBuilder var6 = new StringBuilder(var1 + var2);

      for(int var7 = 0; var7 < var1; var7++) {
         char var5 = var0.charAt(var7);
         if(var5 == 60) {
            var6.append("<lt>");
         } else if(var5 == 62) {
            var6.append("<gt>");
         } else {
            var6.append(var5);
         }
      }

      return var6.toString();
   }
}
