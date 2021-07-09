package client;

public abstract class class247 {
   static class175 field3172 = new class175();
   static int field3176 = 0;
   static final int field3177 = 1;
   public static final int field3178 = 1008;
   int[][] field3167;
   int[] field3161;
   Object[] field3165;
   Object[][] field3169;
   boolean field3174;
   class198[] field3173;
   class198 field3163;
   int[] field3162;
   int[] field3166;
   public int field3175;
   boolean field3170;
   int[] field3164;
   int field3171;
   int[] field3160;
   int[][] field3168;

   class247(boolean var1, boolean var2) {
      this.field3174 = var1;
      this.field3170 = var2;
   }

   public int[] method4668(int var1, int var2) {
      return this.field3167[var1];
   }

   public byte[] method4628(int var1, int var2, int[] var3, byte var4) {
      if(var1 >= 0 && var1 < this.field3169.length && this.field3169[var1] != null && var2 >= 0 && var2 < this.field3169[var1].length) {
         if(this.field3169[var1][var2] == null) {
            boolean var5 = this.method4693(var1, var3, (byte)123);
            if(!var5) {
               this.vmethod4722(var1, (byte)76);
               var5 = this.method4693(var1, var3, (byte)8);
               if(!var5) {
                  return null;
               }
            }
         }

         byte[] var6 = class97.method2211(this.field3169[var1][var2], false, (byte)0);
         if(this.field3170) {
            this.field3169[var1][var2] = null;
         }

         return var6;
      } else {
         return null;
      }
   }

   public int method4637(int var1) {
      return this.field3169.length;
   }

   public byte[] method4676(int var1, int var2, int var3) {
      if(var1 >= 0 && var1 < this.field3169.length && this.field3169[var1] != null && var2 >= 0 && var2 < this.field3169[var1].length) {
         if(this.field3169[var1][var2] == null) {
            boolean var4 = this.method4693(var1, (int[])null, (byte)7);
            if(!var4) {
               this.vmethod4722(var1, (byte)78);
               var4 = this.method4693(var1, (int[])null, (byte)90);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class97.method2211(this.field3169[var1][var2], false, (byte)0);
         return var5;
      } else {
         return null;
      }
   }

   public boolean method4696(int var1, int var2, byte var3) {
      if(var1 >= 0 && var1 < this.field3169.length && this.field3169[var1] != null && var2 >= 0 && var2 < this.field3169[var1].length) {
         if(this.field3169[var1][var2] != null) {
            return true;
         } else if(this.field3165[var1] != null) {
            return true;
         } else {
            this.vmethod4722(var1, (byte)69);
            return this.field3165[var1] != null;
         }
      } else {
         return false;
      }
   }

   public byte[] method4625(int var1, int var2, int var3) {
      return this.method4628(var1, var2, (int[])null, (byte)18);
   }

   void vmethod4722(int var1, byte var2) {
   }

   public byte[] method4626(int var1) {
      if(this.field3169.length == 1) {
         return this.method4676(0, var1, -1338925354);
      } else if(this.field3169[var1].length == 1) {
         return this.method4676(var1, 0, -1023650364);
      } else {
         throw new RuntimeException();
      }
   }

   public int getFileCount(int var1) {
      return this.field3169[var1].length;
   }

   int vmethod4727(int var1, byte var2) {
      return this.field3165[var1] != null ? 100 : 0;
   }

   void method4622(byte[] var1, byte var2) {
      int var4 = var1.length;
      int var3 = class187.method3812(var1, 0, var4, 988087011);
      this.field3175 = var3;
      Stream var5 = new Stream(GameShell.method912(var1, 1269164716));
      int var6 = var5.readUByte();
      if(var6 >= 5 && var6 <= 7) {
         if(var6 >= 6) {
            var5.readInt();
         }

         int var7 = var5.readUByte();
         if(var6 >= 7) {
            this.field3171 = var5.method3611();
         } else {
            this.field3171 = var5.readUShort();
         }

         int var8 = 0;
         int var9 = -1;
         this.field3161 = new int[this.field3171];
         int var10;
         if(var6 >= 7) {
            for(var10 = 0; var10 < this.field3171; var10++) {
               this.field3161[var10] = var8 += var5.method3611();
               if(this.field3161[var10] > var9) {
                  var9 = this.field3161[var10];
               }
            }
         } else {
            for(var10 = 0; var10 < this.field3171; var10++) {
               this.field3161[var10] = var8 += var5.readUShort();
               if(this.field3161[var10] > var9) {
                  var9 = this.field3161[var10];
               }
            }
         }

         this.field3164 = new int[var9 + 1];
         this.field3162 = new int[var9 + 1];
         this.field3166 = new int[var9 + 1];
         this.field3167 = new int[var9 + 1][];
         this.field3165 = new Object[var9 + 1];
         this.field3169 = new Object[var9 + 1][];
         if(var7 != 0) {
            this.field3160 = new int[var9 + 1];

            for(var10 = 0; var10 < this.field3171; var10++) {
               this.field3160[this.field3161[var10]] = var5.readInt();
            }

            this.field3163 = new class198(this.field3160);
         }

         for(var10 = 0; var10 < this.field3171; var10++) {
            this.field3164[this.field3161[var10]] = var5.readInt();
         }

         for(var10 = 0; var10 < this.field3171; var10++) {
            if(var2 == 20) {
               return;
            }

            this.field3162[this.field3161[var10]] = var5.readInt();
         }

         for(var10 = 0; var10 < this.field3171; var10++) {
            this.field3166[this.field3161[var10]] = var5.readUShort();
         }

         int var11;
         int var12;
         int var13;
         int var14;
         int var15;
         if(var6 >= 7) {
            for(var10 = 0; var10 < this.field3171; var10++) {
               var11 = this.field3161[var10];
               var12 = this.field3166[var11];
               var8 = 0;
               var13 = -1;
               this.field3167[var11] = new int[var12];

               for(var14 = 0; var14 < var12; var14++) {
                  if(var2 == 20) {
                     return;
                  }

                  var15 = this.field3167[var11][var14] = var8 += var5.method3611();
                  if(var15 > var13) {
                     var13 = var15;
                  }
               }

               this.field3169[var11] = new Object[var13 + 1];
            }
         } else {
            for(var10 = 0; var10 < this.field3171; var10++) {
               var11 = this.field3161[var10];
               var12 = this.field3166[var11];
               var8 = 0;
               var13 = -1;
               this.field3167[var11] = new int[var12];

               for(var14 = 0; var14 < var12; var14++) {
                  if(var2 == 20) {
                     return;
                  }

                  var15 = this.field3167[var11][var14] = var8 += var5.readUShort();
                  if(var15 > var13) {
                     if(var2 == 20) {
                        return;
                     }

                     var13 = var15;
                  }
               }

               this.field3169[var11] = new Object[var13 + 1];
            }
         }

         if(var7 != 0) {
            if(var2 == 20) {
               return;
            }

            this.field3168 = new int[var9 + 1][];
            this.field3173 = new class198[var9 + 1];

            for(var10 = 0; var10 < this.field3171; var10++) {
               var11 = this.field3161[var10];
               var12 = this.field3166[var11];
               this.field3168[var11] = new int[this.field3169[var11].length];

               for(var13 = 0; var13 < var12; var13++) {
                  if(var2 == 20) {
                     return;
                  }

                  this.field3168[var11][this.field3167[var11][var13]] = var5.readInt();
               }

               this.field3173[var11] = new class198(this.field3168[var11]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   public boolean method4646(String var1, String var2, int var3) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var4 = this.field3163.method3967(class277.method5240(var1, (byte)1));
      int var5 = this.field3173[var4].method3967(class277.method5240(var2, (byte)1));
      return this.method4696(var4, var5, (byte)1);
   }

   void vmethod4721(int var1, byte var2) {
   }

   public boolean method4707(int var1, byte var2) {
      if(this.field3165[var1] != null) {
         return true;
      } else {
         this.vmethod4722(var1, (byte)50);
         return this.field3165[var1] != null;
      }
   }

   public byte[] method4689(int var1, int var2) {
      if(this.field3169.length == 1) {
         return this.method4625(0, var1, 1663510936);
      } else if(this.field3169[var1].length == 1) {
         return this.method4625(var1, 0, 992754407);
      } else {
         throw new RuntimeException();
      }
   }

   public int method4642(String var1, int var2) {
      var1 = var1.toLowerCase();
      return this.field3163.method3967(class277.method5240(var1, (byte)1));
   }

   public boolean method4644(String var1, String var2, byte var3) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var4 = this.field3163.method3967(class277.method5240(var1, (byte)1));
      if(var4 < 0) {
         return false;
      } else {
         int var5 = this.field3173[var4].method3967(class277.method5240(var2, (byte)1));
         return var5 >= 0;
      }
   }

   public int method4643(int var1, String var2, int var3) {
      var2 = var2.toLowerCase();
      return this.field3173[var1].method3967(class277.method5240(var2, (byte)1));
   }

   public boolean method4627(int var1, byte var2) {
      if(this.field3169.length == 1) {
         return this.method4696(0, var1, (byte)1);
      } else if(this.field3169[var1].length == 1) {
         return this.method4696(var1, 0, (byte)1);
      } else {
         throw new RuntimeException();
      }
   }

   public int method4687(String var1, int var2) {
      var1 = var1.toLowerCase();
      int var3 = this.field3163.method3967(class277.method5240(var1, (byte)1));
      return this.vmethod4727(var3, (byte)-28);
   }

   boolean method4693(int var1, int[] var2, byte var3) {
      if(this.field3165[var1] == null) {
         return false;
      } else {
         int var4 = this.field3166[var1];
         int[] var5 = this.field3167[var1];
         Object[] var6 = this.field3169[var1];
         boolean var7 = true;

         for(int var8 = 0; var8 < var4; var8++) {
            if(var6[var5[var8]] == null) {
               var7 = false;
               break;
            }
         }

         if(var7) {
            return true;
         } else {
            byte[] var19;
            if(var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
               var19 = class97.method2211(this.field3165[var1], true, (byte)0);
               Stream var9 = new Stream(var19);
               var9.method3570(var2, 5, var9.field2338.length, -2112776432);
            } else {
               var19 = class97.method2211(this.field3165[var1], false, (byte)0);
            }

            byte[] var21 = GameShell.method912(var19, -935110065);
            if(this.field3174) {
               this.field3165[var1] = null;
            }

            if(var4 > 1) {
               int var10 = var21.length;
               --var10;
               int var11 = var21[var10] & 255;
               var10 -= var4 * var11 * 4;
               Stream var12 = new Stream(var21);
               int[] var13 = new int[var4];
               var12.field2339 = var10;

               int var15;
               int var16;
               for(int var14 = 0; var14 < var11; var14++) {
                  var15 = 0;

                  for(var16 = 0; var16 < var4; var16++) {
                     var15 += var12.readInt();
                     var13[var16] += var15;
                  }
               }

               byte[][] var20 = new byte[var4][];

               for(var15 = 0; var15 < var4; var15++) {
                  var20[var15] = new byte[var13[var15]];
                  var13[var15] = 0;
               }

               var12.field2339 = var10;
               var15 = 0;

               for(var16 = 0; var16 < var11; var16++) {
                  int var17 = 0;

                  for(int var18 = 0; var18 < var4; var18++) {
                     var17 += var12.readInt();
                     System.arraycopy(var21, var15, var20[var18], var13[var18], var17);
                     var13[var18] += var17;
                     var15 += var17;
                  }
               }

               for(var16 = 0; var16 < var4; var16++) {
                  if(!this.field3170) {
                     var6[var5[var16]] = class159.method3324(var20[var16], false, -2018322033);
                  } else {
                     var6[var5[var16]] = var20[var16];
                  }
               }
            } else if(!this.field3170) {
               var6[var5[0]] = class159.method3324(var21, false, -890097303);
            } else {
               var6[var5[0]] = var21;
            }

            return true;
         }
      }
   }

   public byte[] method4684(String var1, String var2, int var3) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var4 = this.field3163.method3967(class277.method5240(var1, (byte)1));
      int var5 = this.field3173[var4].method3967(class277.method5240(var2, (byte)1));
      return this.method4625(var4, var5, -297786163);
   }

   public boolean method4629(int var1) {
      boolean var2 = true;

      for(int var3 = 0; var3 < this.field3161.length; var3++) {
         int var4 = this.field3161[var3];
         if(this.field3165[var4] == null) {
            this.vmethod4722(var4, (byte)10);
            if(this.field3165[var4] == null) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public void method4702(byte var1) {
      for(int var2 = 0; var2 < this.field3165.length; var2++) {
         this.field3165[var2] = null;
      }

   }

   public void method4640(int var1) {
      for(int var2 = 0; var2 < this.field3169.length; var2++) {
         if(this.field3169[var2] != null) {
            if(var1 >= -2053632159) {
               return;
            }

            for(int var3 = 0; var3 < this.field3169[var2].length; var3++) {
               this.field3169[var2][var3] = null;
            }
         }
      }

   }

   public boolean method4704(String var1, int var2) {
      var1 = var1.toLowerCase();
      int var3 = this.field3163.method3967(class277.method5240(var1, (byte)1));
      return this.method4707(var3, (byte)14);
   }

   public void method4639(int var1, byte var2) {
      for(int var3 = 0; var3 < this.field3169[var1].length; var3++) {
         if(var2 == 2) {
            return;
         }

         this.field3169[var1][var3] = null;
      }

   }

   public void method4648(String var1, int var2) {
      var1 = var1.toLowerCase();
      int var3 = this.field3163.method3967(class277.method5240(var1, (byte)1));
      if(var3 >= 0) {
         this.vmethod4721(var3, (byte)-114);
      }
   }
}
