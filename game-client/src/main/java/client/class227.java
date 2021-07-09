package client;

public class class227 {
   static final int[] field2579 = new int[]{8, 11, 4, 6, 9, 7, 10};
   public static short[][] field2572;
   static class200 field2580 = new class200(260);
   public static short[] field2575;
   public static short[][] field2578;
   public static short[] field2577;
   static final int field2581 = 0;
   public int field2569;
   int[] field2576;
   long field2573;
   public boolean field2571;
   int[] field2570;
   long field2574;

   public void method4462(int[] var1, int[] var2, boolean var3, int var4, int var5) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var6 = 0; var6 < 7; var6++) {
            for(int var7 = 0; var7 < class260.field3294; var7++) {
               class260 var8 = class2.method23(var7, -241404147);
               if(var8 != null) {
                  if(var5 <= -1859664019) {
                     return;
                  }

                  if(!var8.field3295) {
                     byte var10000;
                     if(var3) {
                        if(var5 <= -1859664019) {
                           return;
                        }

                        var10000 = 7;
                     } else {
                        var10000 = 0;
                     }

                     if(var10000 + var6 == var8.field3293) {
                        if(var5 <= -1859664019) {
                           return;
                        }

                        var1[field2579[var6]] = var7 + 256;
                        break;
                     }
                  }
               }
            }
         }
      }

      this.field2570 = var1;
      this.field2576 = var2;
      this.field2571 = var3;
      this.field2569 = var4;
      this.method4467(1868947460);
   }

   void method4467(int var1) {
      long var2 = this.field2573;
      int var4 = this.field2570[5];
      int var5 = this.field2570[9];
      this.field2570[5] = var5;
      this.field2570[9] = var4;
      this.field2573 = 0L;

      int var6;
      for(var6 = 0; var6 < 12; var6++) {
         this.field2573 <<= 4;
         if(this.field2570[var6] >= 256) {
            this.field2573 += (long)(this.field2570[var6] - 256);
         }
      }

      if(this.field2570[0] >= 256) {
         if(var1 <= -3099750) {
            return;
         }

         this.field2573 += (long)(this.field2570[0] - 256 >> 4);
      }

      if(this.field2570[1] >= 256) {
         this.field2573 += (long)(this.field2570[1] - 256 >> 8);
      }

      for(var6 = 0; var6 < 5; var6++) {
         this.field2573 <<= 3;
         this.field2573 += (long)this.field2576[var6];
      }

      this.field2573 <<= 1;
      this.field2573 += (long)(this.field2571 ? 1 : 0);
      this.field2570[5] = var4;
      this.field2570[9] = var5;
      if(var2 != 0L && this.field2573 != var2) {
         field2580.method3982(var2);
      }

   }

   public class119 method4468(class273 var1, int var2, class273 var3, int var4, int var5) {
      if(this.field2569 != -1) {
         return class270.loadNpcDef(this.field2569).method5162(var1, var2, var3, var4, -639258306);
      } else {
         long var6 = this.field2573;
         int[] var8 = this.field2570;
         if(var1 != null && (var1.field3548 >= 0 || var1.field3549 >= 0)) {
            var8 = new int[12];

            for(int var16 = 0; var16 < 12; var16++) {
               var8[var16] = this.field2570[var16];
            }

            if(var1.field3548 >= 0) {
               var6 += (long)(var1.field3548 - this.field2570[5] << 40);
               var8[5] = var1.field3548;
            }

            if(var1.field3549 >= 0) {
               var6 += (long)(var1.field3549 - this.field2570[3] << 48);
               var8[3] = var1.field3549;
            }
         }

         class119 var9 = (class119)field2580.method3989(var6);
         if(var9 == null) {
            boolean var10 = false;

            int var12;
            for(int var11 = 0; var11 < 12; var11++) {
               var12 = var8[var11];
               if(var12 >= 256 && var12 < 512 && !class2.method23(var12 - 256, 1337907930).method4896((byte)2)) {
                  var10 = true;
               }

               if(var12 >= 512 && !ItemDef.loadItemDef(var12 - 512).method5095(this.field2571, 311009005)) {
                  var10 = true;
               }
            }

            if(var10) {
               if(this.field2574 != -1L) {
                  var9 = (class119)field2580.method3989(this.field2574);
               }

               if(var9 == null) {
                  return null;
               }
            }

            if(var9 == null) {
               class113[] var17 = new class113[12];
               var12 = 0;

               int var14;
               for(int var13 = 0; var13 < 12; var13++) {
                  var14 = var8[var13];
                  class113 var15;
                  if(var14 >= 256 && var14 < 512) {
                     var15 = class2.method23(var14 - 256, -663837342).method4897(1023847556);
                     if(var15 != null) {
                        var17[var12++] = var15;
                     }
                  }

                  if(var14 >= 512) {
                     var15 = ItemDef.loadItemDef(var14 - 512).method5128(this.field2571, (byte)17);
                     if(var15 != null) {
                        var17[var12++] = var15;
                     }
                  }
               }

               class113 var19 = new class113(var17, var12);

               for(var14 = 0; var14 < 5; var14++) {
                  if(this.field2576[var14] < field2572[var14].length) {
                     var19.method2581(field2575[var14], field2572[var14][this.field2576[var14]]);
                  }

                  if(this.field2576[var14] < field2578[var14].length) {
                     var19.method2581(field2577[var14], field2578[var14][this.field2576[var14]]);
                  }
               }

               var9 = var19.method2589(64, 850, -30, -50, -30);
               field2580.method3983(var9, var6);
               this.field2574 = var6;
            }
         }

         if(var1 == null && var3 == null) {
            return var9;
         } else {
            class119 var18;
            if(var1 != null && var3 != null) {
               var18 = var1.method5221(var9, var2, var3, var4, 1488793247);
            } else if(var1 != null) {
               var18 = var1.method5215(var9, var2, -1433585529);
            } else {
               var18 = var3.method5215(var9, var4, -1433585529);
            }

            return var18;
         }
      }
   }

   class113 method4469(int var1) {
      if(this.field2569 != -1) {
         return class270.loadNpcDef(this.field2569).method5158((byte)-63);
      } else {
         boolean var2 = false;

         int var4;
         for(int var3 = 0; var3 < 12; var3++) {
            var4 = this.field2570[var3];
            if(var4 >= 256 && var4 < 512 && !class2.method23(var4 - 256, 270661717).method4905(2062826807)) {
               var2 = true;
            }

            if(var4 >= 512 && !ItemDef.loadItemDef(var4 - 512).method5097(this.field2571, 584238703)) {
               var2 = true;
            }
         }

         if(var2) {
            return null;
         } else {
            class113[] var8 = new class113[12];
            var4 = 0;

            int var6;
            for(int var5 = 0; var5 < 12; var5++) {
               var6 = this.field2570[var5];
               class113 var7;
               if(var6 >= 256 && var6 < 512) {
                  var7 = class2.method23(var6 - 256, 585659898).method4899(1278198342);
                  if(var7 != null) {
                     var8[var4++] = var7;
                  }
               }

               if(var6 >= 512) {
                  var7 = ItemDef.loadItemDef(var6 - 512).method5098(this.field2571, -2143681754);
                  if(var7 != null) {
                     var8[var4++] = var7;
                  }
               }
            }

            class113 var9 = new class113(var8, var4);

            for(var6 = 0; var6 < 5; var6++) {
               if(this.field2576[var6] < field2572[var6].length) {
                  var9.method2581(field2575[var6], field2572[var6][this.field2576[var6]]);
               }

               if(this.field2576[var6] < field2578[var6].length) {
                  var9.method2581(field2577[var6], field2578[var6][this.field2576[var6]]);
               }
            }

            return var9;
         }
      }
   }

   public int method4483(int var1) {
      return this.field2569 == -1 ? (this.field2570[0] << 15) + this.field2570[1] + (this.field2570[11] << 5) + (this.field2570[8] << 10) + (this.field2576[0] << 25) + (this.field2576[4] << 20) : 305419896 + class270.loadNpcDef(this.field2569).field3510;
   }

   public void method4478(int var1, boolean var2, int var3) {
      if(var1 != 1 || !this.field2571) {
         int var4 = this.field2570[field2579[var1]];
         if(var4 != 0) {
            var4 -= 256;

            while(true) {
               if(!var2) {
                  --var4;
                  if(var4 < 0) {
                     var4 = class260.field3294 - 1;
                  }
               } else {
                  ++var4;
                  if(var4 >= class260.field3294) {
                     var4 = 0;
                  }
               }

               class260 var5 = class2.method23(var4, 1149542047);
               if(var5 != null) {
                  if(var3 != -1617344099) {
                     return;
                  }

                  if(!var5.field3295 && var1 + (this.field2571 ? 7 : 0) == var5.field3293) {
                     this.field2570[field2579[var1]] = var4 + 256;
                     this.method4467(511596801);
                     return;
                  }
               }
            }
         }
      }
   }

   public void method4493(int var1, boolean var2, byte var3) {
      int var4 = this.field2576[var1];
      boolean var5;
      if(!var2) {
         while(true) {
            --var4;
            if(var4 < 0) {
               if(var3 <= 30) {
                  return;
               }

               var4 = field2572[var1].length - 1;
            }

            if(var1 == 4 && var4 >= 8) {
               var5 = false;
            } else {
               var5 = true;
            }

            if(var5) {
               if(var3 <= 30) {
                  return;
               }
               break;
            }
         }
      } else {
         do {
            ++var4;
            if(var4 >= field2572[var1].length) {
               var4 = 0;
            }

            if(var1 == 4 && var4 >= 8) {
               var5 = false;
            } else {
               var5 = true;
            }
         } while(!var5);
      }

      this.field2576[var1] = var4;
      this.method4467(132088200);
   }

   public void method4465(boolean var1, int var2) {
      if(this.field2571 == var1) {
         if(var2 == -75355904) {
            ;
         }
      } else {
         this.method4462((int[])null, this.field2576, var1, -1, 77184843);
      }
   }

   public void method4466(Stream var1, byte var2) {
      byte var10001;
      if(this.field2571) {
         if(var2 >= 2) {
            return;
         }

         var10001 = 1;
      } else {
         var10001 = 0;
      }

      var1.writeByte(var10001);

      int var3;
      for(var3 = 0; var3 < 7; var3++) {
         int var4 = this.field2570[field2579[var3]];
         if(var4 == 0) {
            var1.writeByte(-1);
         } else {
            var1.writeByte(var4 - 256);
         }
      }

      for(var3 = 0; var3 < 5; var3++) {
         if(var2 >= 2) {
            return;
         }

         var1.writeByte(this.field2576[var3]);
      }

   }
}
