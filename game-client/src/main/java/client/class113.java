package client;

public class class113 extends class127 {
   static int[] field1497;
   static int[] field1494 = new int[10000];
   static int[] field1495;
   static int[] field1475 = new int[10000];
   static int field1474 = 0;
   boolean field1488 = false;
   int[] field1479;
   int[] field1460;
   class121[] field1496;
   int field1461 = 0;
   short[] field1472;
   int field1463 = 0;
   int field1480;
   int[] field1478;
   int[] field1490;
   int[] field1462;
   short[] field1471;
   byte[] field1467;
   class121[] field1485;
   int field1492;
   int field1489;
   class129[] field1483;
   int[] field1477;
   int[][] field1481;
   int field1493;
   byte field1473 = 0;
   int[][] field1482;
   int[] field1466;
   int field1498;
   int field1484;
   int[] field1465;
   public short field1486;
   byte[] field1470;
   public short field1487;
   byte[] field1469;
   byte[] field1459;
   byte[] field1468;
   short[] field1476;
   short[] field1491;
   short[] field1464;

   static {
      field1497 = class122.field1681;
      field1495 = class122.field1693;
   }

   class113() {
   }

   public class113(class113[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1461 = 0;
      this.field1463 = 0;
      this.field1484 = 0;
      this.field1473 = -1;

      int var9;
      class113 var10;
      for(var9 = 0; var9 < var2; var9++) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1461 += var10.field1461;
            this.field1463 += var10.field1463;
            this.field1484 += var10.field1484;
            if(var10.field1468 != null) {
               var4 = true;
            } else {
               if(this.field1473 == -1) {
                  this.field1473 = var10.field1473;
               }

               if(this.field1473 != var10.field1473) {
                  var4 = true;
               }
            }

            var3 |= var10.field1467 != null;
            var5 |= var10.field1469 != null;
            var6 |= var10.field1478 != null;
            var7 |= var10.field1472 != null;
            var8 |= var10.field1470 != null;
         }
      }

      this.field1460 = new int[this.field1461];
      this.field1490 = new int[this.field1461];
      this.field1462 = new int[this.field1461];
      this.field1479 = new int[this.field1461];
      this.field1477 = new int[this.field1463];
      this.field1465 = new int[this.field1463];
      this.field1466 = new int[this.field1463];
      if(var3) {
         this.field1467 = new byte[this.field1463];
      }

      if(var4) {
         this.field1468 = new byte[this.field1463];
      }

      if(var5) {
         this.field1469 = new byte[this.field1463];
      }

      if(var6) {
         this.field1478 = new int[this.field1463];
      }

      if(var7) {
         this.field1472 = new short[this.field1463];
      }

      if(var8) {
         this.field1470 = new byte[this.field1463];
      }

      this.field1471 = new short[this.field1463];
      if(this.field1484 > 0) {
         this.field1459 = new byte[this.field1484];
         this.field1476 = new short[this.field1484];
         this.field1491 = new short[this.field1484];
         this.field1464 = new short[this.field1484];
      }

      this.field1461 = 0;
      this.field1463 = 0;
      this.field1484 = 0;

      for(var9 = 0; var9 < var2; var9++) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1463; var11++) {
               if(var3 && var10.field1467 != null) {
                  this.field1467[this.field1463] = var10.field1467[var11];
               }

               if(var4) {
                  if(var10.field1468 != null) {
                     this.field1468[this.field1463] = var10.field1468[var11];
                  } else {
                     this.field1468[this.field1463] = var10.field1473;
                  }
               }

               if(var5 && var10.field1469 != null) {
                  this.field1469[this.field1463] = var10.field1469[var11];
               }

               if(var6 && var10.field1478 != null) {
                  this.field1478[this.field1463] = var10.field1478[var11];
               }

               if(var7) {
                  if(var10.field1472 != null) {
                     this.field1472[this.field1463] = var10.field1472[var11];
                  } else {
                     this.field1472[this.field1463] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1470 != null && var10.field1470[var11] != -1) {
                     this.field1470[this.field1463] = (byte)(this.field1484 + var10.field1470[var11]);
                  } else {
                     this.field1470[this.field1463] = -1;
                  }
               }

               this.field1471[this.field1463] = var10.field1471[var11];
               this.field1477[this.field1463] = this.method2572(var10, var10.field1477[var11]);
               this.field1465[this.field1463] = this.method2572(var10, var10.field1465[var11]);
               this.field1466[this.field1463] = this.method2572(var10, var10.field1466[var11]);
               ++this.field1463;
            }

            for(var11 = 0; var11 < var10.field1484; var11++) {
               byte var12 = this.field1459[this.field1484] = var10.field1459[var11];
               if(var12 == 0) {
                  this.field1476[this.field1484] = (short)this.method2572(var10, var10.field1476[var11]);
                  this.field1491[this.field1484] = (short)this.method2572(var10, var10.field1491[var11]);
                  this.field1464[this.field1484] = (short)this.method2572(var10, var10.field1464[var11]);
               }

               ++this.field1484;
            }
         }
      }

   }

   class113(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2632(var1);
      } else {
         this.method2570(var1);
      }

   }

   public class113(class113 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1461 = var1.field1461;
      this.field1463 = var1.field1463;
      this.field1484 = var1.field1484;
      int var6;
      if(var2) {
         this.field1460 = var1.field1460;
         this.field1490 = var1.field1490;
         this.field1462 = var1.field1462;
      } else {
         this.field1460 = new int[this.field1461];
         this.field1490 = new int[this.field1461];
         this.field1462 = new int[this.field1461];

         for(var6 = 0; var6 < this.field1461; var6++) {
            this.field1460[var6] = var1.field1460[var6];
            this.field1490[var6] = var1.field1490[var6];
            this.field1462[var6] = var1.field1462[var6];
         }
      }

      if(var3) {
         this.field1471 = var1.field1471;
      } else {
         this.field1471 = new short[this.field1463];

         for(var6 = 0; var6 < this.field1463; var6++) {
            this.field1471[var6] = var1.field1471[var6];
         }
      }

      if(!var4 && var1.field1472 != null) {
         this.field1472 = new short[this.field1463];

         for(var6 = 0; var6 < this.field1463; var6++) {
            this.field1472[var6] = var1.field1472[var6];
         }
      } else {
         this.field1472 = var1.field1472;
      }

      if(var5) {
         this.field1469 = var1.field1469;
      } else {
         this.field1469 = new byte[this.field1463];
         if(var1.field1469 == null) {
            for(var6 = 0; var6 < this.field1463; var6++) {
               this.field1469[var6] = 0;
            }
         } else {
            for(var6 = 0; var6 < this.field1463; var6++) {
               this.field1469[var6] = var1.field1469[var6];
            }
         }
      }

      this.field1477 = var1.field1477;
      this.field1465 = var1.field1465;
      this.field1466 = var1.field1466;
      this.field1467 = var1.field1467;
      this.field1468 = var1.field1468;
      this.field1470 = var1.field1470;
      this.field1473 = var1.field1473;
      this.field1459 = var1.field1459;
      this.field1476 = var1.field1476;
      this.field1491 = var1.field1491;
      this.field1464 = var1.field1464;
      this.field1479 = var1.field1479;
      this.field1478 = var1.field1478;
      this.field1481 = var1.field1481;
      this.field1482 = var1.field1482;
      this.field1496 = var1.field1496;
      this.field1483 = var1.field1483;
      this.field1485 = var1.field1485;
      this.field1486 = var1.field1486;
      this.field1487 = var1.field1487;
   }

   void method2627() {
      if(!this.field1488) {
         super.field1781 = 0;
         this.field1489 = 0;
         this.field1480 = 999999;
         this.field1492 = -999999;
         this.field1498 = -99999;
         this.field1493 = 99999;

         for(int var1 = 0; var1 < this.field1461; var1++) {
            int var2 = this.field1460[var1];
            int var3 = this.field1490[var1];
            int var4 = this.field1462[var1];
            if(var2 < this.field1480) {
               this.field1480 = var2;
            }

            if(var2 > this.field1492) {
               this.field1492 = var2;
            }

            if(var4 < this.field1493) {
               this.field1493 = var4;
            }

            if(var4 > this.field1498) {
               this.field1498 = var4;
            }

            if(-var3 > super.field1781) {
               super.field1781 = -var3;
            }

            if(var3 > this.field1489) {
               this.field1489 = var3;
            }
         }

         this.field1488 = true;
      }
   }

   public void method2585() {
      if(this.field1496 == null) {
         this.field1496 = new class121[this.field1461];

         int var1;
         for(var1 = 0; var1 < this.field1461; var1++) {
            this.field1496[var1] = new class121();
         }

         for(var1 = 0; var1 < this.field1463; var1++) {
            int var2 = this.field1477[var1];
            int var3 = this.field1465[var1];
            int var4 = this.field1466[var1];
            int var5 = this.field1460[var3] - this.field1460[var2];
            int var6 = this.field1490[var3] - this.field1490[var2];
            int var7 = this.field1462[var3] - this.field1462[var2];
            int var8 = this.field1460[var4] - this.field1460[var2];
            int var9 = this.field1490[var4] - this.field1490[var2];
            int var10 = this.field1462[var4] - this.field1462[var2];
            int var11 = var6 * var10 - var9 * var7;
            int var12 = var7 * var8 - var10 * var5;

            int var13;
            for(var13 = var5 * var9 - var8 * var6; var11 > 8192 || var12 > 8192 || var13 > 8192 || var11 < -8192 || var12 < -8192 || var13 < -8192; var13 >>= 1) {
               var11 >>= 1;
               var12 >>= 1;
            }

            int var14 = (int)Math.sqrt((double)(var11 * var11 + var12 * var12 + var13 * var13));
            if(var14 <= 0) {
               var14 = 1;
            }

            var11 = var11 * 256 / var14;
            var12 = var12 * 256 / var14;
            var13 = var13 * 256 / var14;
            byte var15;
            if(this.field1467 == null) {
               var15 = 0;
            } else {
               var15 = this.field1467[var1];
            }

            if(var15 == 0) {
               class121 var16 = this.field1496[var2];
               var16.field1665 += var11;
               var16.field1661 += var12;
               var16.field1662 += var13;
               ++var16.field1666;
               var16 = this.field1496[var3];
               var16.field1665 += var11;
               var16.field1661 += var12;
               var16.field1662 += var13;
               ++var16.field1666;
               var16 = this.field1496[var4];
               var16.field1665 += var11;
               var16.field1661 += var12;
               var16.field1662 += var13;
               ++var16.field1666;
            } else if(var15 == 1) {
               if(this.field1483 == null) {
                  this.field1483 = new class129[this.field1463];
               }

               class129 var17 = this.field1483[var1] = new class129();
               var17.field1793 = var11;
               var17.field1794 = var12;
               var17.field1795 = var13;
            }
         }

      }
   }

   void method2586() {
      this.field1496 = null;
      this.field1485 = null;
      this.field1483 = null;
      this.field1488 = false;
   }

   public class113 method2650() {
      class113 var1 = new class113();
      if(this.field1467 != null) {
         var1.field1467 = new byte[this.field1463];

         for(int var2 = 0; var2 < this.field1463; var2++) {
            var1.field1467[var2] = this.field1467[var2];
         }
      }

      var1.field1461 = this.field1461;
      var1.field1463 = this.field1463;
      var1.field1484 = this.field1484;
      var1.field1460 = this.field1460;
      var1.field1490 = this.field1490;
      var1.field1462 = this.field1462;
      var1.field1477 = this.field1477;
      var1.field1465 = this.field1465;
      var1.field1466 = this.field1466;
      var1.field1468 = this.field1468;
      var1.field1469 = this.field1469;
      var1.field1470 = this.field1470;
      var1.field1471 = this.field1471;
      var1.field1472 = this.field1472;
      var1.field1473 = this.field1473;
      var1.field1459 = this.field1459;
      var1.field1476 = this.field1476;
      var1.field1491 = this.field1491;
      var1.field1464 = this.field1464;
      var1.field1479 = this.field1479;
      var1.field1478 = this.field1478;
      var1.field1481 = this.field1481;
      var1.field1482 = this.field1482;
      var1.field1496 = this.field1496;
      var1.field1483 = this.field1483;
      var1.field1486 = this.field1486;
      var1.field1487 = this.field1487;
      return var1;
   }

   public void method2581(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1463; var3++) {
         if(this.field1471[var3] == var1) {
            this.field1471[var3] = var2;
         }
      }

   }

   public void method2592(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1461; var4++) {
         this.field1460[var4] = this.field1460[var4] * var1 / 128;
         this.field1490[var4] = var2 * this.field1490[var4] / 128;
         this.field1462[var4] = var3 * this.field1462[var4] / 128;
      }

      this.method2586();
   }

   void method2570(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      Stream var4 = new Stream(var1);
      Stream var5 = new Stream(var1);
      Stream var6 = new Stream(var1);
      Stream var7 = new Stream(var1);
      Stream var8 = new Stream(var1);
      var4.field2339 = var1.length - 18;
      int var9 = var4.readUShort();
      int var10 = var4.readUShort();
      int var11 = var4.readUByte();
      int var12 = var4.readUByte();
      int var13 = var4.readUByte();
      int var14 = var4.readUByte();
      int var15 = var4.readUByte();
      int var16 = var4.readUByte();
      int var17 = var4.readUShort();
      int var18 = var4.readUShort();
      int var19 = var4.readUShort();
      int var20 = var4.readUShort();
      byte var21 = 0;
      int var45 = var21 + var9;
      int var23 = var45;
      var45 += var10;
      int var24 = var45;
      if(var13 == 255) {
         var45 += var10;
      }

      int var25 = var45;
      if(var15 == 1) {
         var45 += var10;
      }

      int var26 = var45;
      if(var12 == 1) {
         var45 += var10;
      }

      int var27 = var45;
      if(var16 == 1) {
         var45 += var9;
      }

      int var28 = var45;
      if(var14 == 1) {
         var45 += var10;
      }

      int var29 = var45;
      var45 += var20;
      int var30 = var45;
      var45 += var10 * 2;
      int var31 = var45;
      var45 += var11 * 6;
      int var32 = var45;
      var45 += var17;
      int var33 = var45;
      var45 += var18;
      int var10000 = var45 + var19;
      this.field1461 = var9;
      this.field1463 = var10;
      this.field1484 = var11;
      this.field1460 = new int[var9];
      this.field1490 = new int[var9];
      this.field1462 = new int[var9];
      this.field1477 = new int[var10];
      this.field1465 = new int[var10];
      this.field1466 = new int[var10];
      if(var11 > 0) {
         this.field1459 = new byte[var11];
         this.field1476 = new short[var11];
         this.field1491 = new short[var11];
         this.field1464 = new short[var11];
      }

      if(var16 == 1) {
         this.field1479 = new int[var9];
      }

      if(var12 == 1) {
         this.field1467 = new byte[var10];
         this.field1470 = new byte[var10];
         this.field1472 = new short[var10];
      }

      if(var13 == 255) {
         this.field1468 = new byte[var10];
      } else {
         this.field1473 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1469 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1478 = new int[var10];
      }

      this.field1471 = new short[var10];
      var4.field2339 = var21;
      var5.field2339 = var32;
      var6.field2339 = var33;
      var7.field2339 = var45;
      var8.field2339 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; var38++) {
         var39 = var4.readUByte();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method3561();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method3561();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method3561();
         }

         this.field1460[var38] = var35 + var40;
         this.field1490[var38] = var36 + var41;
         this.field1462[var38] = var37 + var42;
         var35 = this.field1460[var38];
         var36 = this.field1490[var38];
         var37 = this.field1462[var38];
         if(var16 == 1) {
            this.field1479[var38] = var8.readUByte();
         }
      }

      var4.field2339 = var30;
      var5.field2339 = var26;
      var6.field2339 = var24;
      var7.field2339 = var28;
      var8.field2339 = var25;

      for(var38 = 0; var38 < var10; var38++) {
         this.field1471[var38] = (short)var4.readUShort();
         if(var12 == 1) {
            var39 = var5.readUByte();
            if((var39 & 1) == 1) {
               this.field1467[var38] = 1;
               var2 = true;
            } else {
               this.field1467[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1470[var38] = (byte)(var39 >> 2);
               this.field1472[var38] = this.field1471[var38];
               this.field1471[var38] = 127;
               if(this.field1472[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1470[var38] = -1;
               this.field1472[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1468[var38] = var6.readByte();
         }

         if(var14 == 1) {
            this.field1469[var38] = var7.readByte();
         }

         if(var15 == 1) {
            this.field1478[var38] = var8.readUByte();
         }
      }

      var4.field2339 = var29;
      var5.field2339 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; var42++) {
         var43 = var5.readUByte();
         if(var43 == 1) {
            var38 = var4.method3561() + var41;
            var39 = var4.method3561() + var38;
            var40 = var4.method3561() + var39;
            var41 = var40;
            this.field1477[var42] = var38;
            this.field1465[var42] = var39;
            this.field1466[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method3561() + var41;
            var41 = var40;
            this.field1477[var42] = var38;
            this.field1465[var42] = var39;
            this.field1466[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method3561() + var41;
            var41 = var40;
            this.field1477[var42] = var38;
            this.field1465[var42] = var39;
            this.field1466[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method3561() + var41;
            var41 = var40;
            this.field1477[var42] = var38;
            this.field1465[var42] = var44;
            this.field1466[var42] = var40;
         }
      }

      var4.field2339 = var31;

      for(var42 = 0; var42 < var11; var42++) {
         this.field1459[var42] = 0;
         this.field1476[var42] = (short)var4.readUShort();
         this.field1491[var42] = (short)var4.readUShort();
         this.field1464[var42] = (short)var4.readUShort();
      }

      if(this.field1470 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; var43++) {
            var44 = this.field1470[var43] & 255;
            if(var44 != 255) {
               if(this.field1477[var43] == (this.field1476[var44] & 65535) && this.field1465[var43] == (this.field1491[var44] & 65535) && this.field1466[var43] == (this.field1464[var44] & 65535)) {
                  this.field1470[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1470 = null;
         }
      }

      if(!var3) {
         this.field1472 = null;
      }

      if(!var2) {
         this.field1467 = null;
      }

   }

   public void method2582(short var1, short var2) {
      if(this.field1472 != null) {
         for(int var3 = 0; var3 < this.field1463; var3++) {
            if(this.field1472[var3] == var1) {
               this.field1472[var3] = var2;
            }
         }

      }
   }

   public final class119 method2589(int var1, int var2, int var3, int var4, int var5) {
      this.method2585();
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3 + var4 * var4));
      int var7 = var6 * var2 >> 8;
      class119 var8 = new class119();
      var8.field1615 = new int[this.field1463];
      var8.field1620 = new int[this.field1463];
      var8.field1591 = new int[this.field1463];
      if(this.field1484 > 0 && this.field1470 != null) {
         int[] var9 = new int[this.field1484];

         int var10;
         for(var10 = 0; var10 < this.field1463; var10++) {
            if(this.field1470[var10] != -1) {
               ++var9[this.field1470[var10] & 255];
            }
         }

         var8.field1597 = 0;

         for(var10 = 0; var10 < this.field1484; var10++) {
            if(var9[var10] > 0 && this.field1459[var10] == 0) {
               ++var8.field1597;
            }
         }

         var8.field1621 = new int[var8.field1597];
         var8.field1599 = new int[var8.field1597];
         var8.field1600 = new int[var8.field1597];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1484; var11++) {
            if(var9[var11] > 0 && this.field1459[var11] == 0) {
               var8.field1621[var10] = this.field1476[var11] & 65535;
               var8.field1599[var10] = this.field1491[var11] & 65535;
               var8.field1600[var10] = this.field1464[var11] & 65535;
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1617 = new byte[this.field1463];

         for(var11 = 0; var11 < this.field1463; var11++) {
            if(this.field1470[var11] != -1) {
               var8.field1617[var11] = (byte)var9[this.field1470[var11] & 255];
            } else {
               var8.field1617[var11] = -1;
            }
         }
      }

      for(int var16 = 0; var16 < this.field1463; var16++) {
         byte var17;
         if(this.field1467 == null) {
            var17 = 0;
         } else {
            var17 = this.field1467[var16];
         }

         byte var18;
         if(this.field1469 == null) {
            var18 = 0;
         } else {
            var18 = this.field1469[var16];
         }

         short var12;
         if(this.field1472 == null) {
            var12 = -1;
         } else {
            var12 = this.field1472[var16];
         }

         if(var18 == -2) {
            var17 = 3;
         }

         if(var18 == -1) {
            var17 = 2;
         }

         class121 var13;
         int var14;
         class129 var19;
         if(var12 == -1) {
            if(var17 != 0) {
               if(var17 == 1) {
                  var19 = this.field1483[var16];
                  var14 = (var4 * var19.field1794 + var5 * var19.field1795 + var3 * var19.field1793) / (var7 / 2 + var7) + var1;
                  var8.field1615[var16] = method2590(this.field1471[var16] & 65535, var14);
                  var8.field1591[var16] = -1;
               } else if(var17 == 3) {
                  var8.field1615[var16] = 128;
                  var8.field1591[var16] = -1;
               } else {
                  var8.field1591[var16] = -2;
               }
            } else {
               int var15 = this.field1471[var16] & 65535;
               if(this.field1485 != null && this.field1485[this.field1477[var16]] != null) {
                  var13 = this.field1485[this.field1477[var16]];
               } else {
                  var13 = this.field1496[this.field1477[var16]];
               }

               var14 = (var4 * var13.field1661 + var5 * var13.field1662 + var3 * var13.field1665) / (var7 * var13.field1666) + var1;
               var8.field1615[var16] = method2590(var15, var14);
               if(this.field1485 != null && this.field1485[this.field1465[var16]] != null) {
                  var13 = this.field1485[this.field1465[var16]];
               } else {
                  var13 = this.field1496[this.field1465[var16]];
               }

               var14 = (var4 * var13.field1661 + var5 * var13.field1662 + var3 * var13.field1665) / (var7 * var13.field1666) + var1;
               var8.field1620[var16] = method2590(var15, var14);
               if(this.field1485 != null && this.field1485[this.field1466[var16]] != null) {
                  var13 = this.field1485[this.field1466[var16]];
               } else {
                  var13 = this.field1496[this.field1466[var16]];
               }

               var14 = (var4 * var13.field1661 + var5 * var13.field1662 + var3 * var13.field1665) / (var7 * var13.field1666) + var1;
               var8.field1591[var16] = method2590(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1483[var16];
               var14 = (var4 * var19.field1794 + var5 * var19.field1795 + var3 * var19.field1793) / (var7 / 2 + var7) + var1;
               var8.field1615[var16] = method2591(var14);
               var8.field1591[var16] = -1;
            } else {
               var8.field1591[var16] = -2;
            }
         } else {
            if(this.field1485 != null && this.field1485[this.field1477[var16]] != null) {
               var13 = this.field1485[this.field1477[var16]];
            } else {
               var13 = this.field1496[this.field1477[var16]];
            }

            var14 = (var4 * var13.field1661 + var5 * var13.field1662 + var3 * var13.field1665) / (var7 * var13.field1666) + var1;
            var8.field1615[var16] = method2591(var14);
            if(this.field1485 != null && this.field1485[this.field1465[var16]] != null) {
               var13 = this.field1485[this.field1465[var16]];
            } else {
               var13 = this.field1496[this.field1465[var16]];
            }

            var14 = (var4 * var13.field1661 + var5 * var13.field1662 + var3 * var13.field1665) / (var7 * var13.field1666) + var1;
            var8.field1620[var16] = method2591(var14);
            if(this.field1485 != null && this.field1485[this.field1466[var16]] != null) {
               var13 = this.field1485[this.field1466[var16]];
            } else {
               var13 = this.field1496[this.field1466[var16]];
            }

            var14 = (var4 * var13.field1661 + var5 * var13.field1662 + var3 * var13.field1665) / (var7 * var13.field1666) + var1;
            var8.field1591[var16] = method2591(var14);
         }
      }

      this.method2575();
      var8.field1581 = this.field1461;
      var8.field1646 = this.field1460;
      var8.field1583 = this.field1490;
      var8.field1584 = this.field1462;
      var8.field1585 = this.field1463;
      var8.field1586 = this.field1477;
      var8.field1587 = this.field1465;
      var8.field1588 = this.field1466;
      var8.field1645 = this.field1468;
      var8.field1593 = this.field1469;
      var8.field1596 = this.field1473;
      var8.field1601 = this.field1481;
      var8.field1602 = this.field1482;
      var8.field1604 = this.field1472;
      return var8;
   }

   void method2632(byte[] var1) {
      Stream var2 = new Stream(var1);
      Stream var3 = new Stream(var1);
      Stream var4 = new Stream(var1);
      Stream var5 = new Stream(var1);
      Stream var6 = new Stream(var1);
      Stream var7 = new Stream(var1);
      Stream var8 = new Stream(var1);
      var2.field2339 = var1.length - 23;
      int var9 = var2.readUShort();
      int var10 = var2.readUShort();
      int var11 = var2.readUByte();
      int var12 = var2.readUByte();
      int var13 = var2.readUByte();
      int var14 = var2.readUByte();
      int var15 = var2.readUByte();
      int var16 = var2.readUByte();
      int var17 = var2.readUByte();
      int var18 = var2.readUShort();
      int var19 = var2.readUShort();
      int var20 = var2.readUShort();
      int var21 = var2.readUShort();
      int var22 = var2.readUShort();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1459 = new byte[var11];
         var2.field2339 = 0;

         for(var26 = 0; var26 < var11; var26++) {
            byte var27 = this.field1459[var26] = var2.readByte();
            if(var27 == 0) {
               ++var23;
            }

            if(var27 >= 1 && var27 <= 3) {
               ++var24;
            }

            if(var27 == 2) {
               ++var25;
            }
         }
      }

      var26 = var11 + var9;
      int var28 = var26;
      if(var12 == 1) {
         var26 += var10;
      }

      int var29 = var26;
      var26 += var10;
      int var30 = var26;
      if(var13 == 255) {
         var26 += var10;
      }

      int var31 = var26;
      if(var15 == 1) {
         var26 += var10;
      }

      int var32 = var26;
      if(var17 == 1) {
         var26 += var9;
      }

      int var33 = var26;
      if(var14 == 1) {
         var26 += var10;
      }

      int var34 = var26;
      var26 += var21;
      int var35 = var26;
      if(var16 == 1) {
         var26 += var10 * 2;
      }

      int var36 = var26;
      var26 += var22;
      int var37 = var26;
      var26 += var10 * 2;
      int var38 = var26;
      var26 += var18;
      int var39 = var26;
      var26 += var19;
      int var40 = var26;
      var26 += var20;
      int var41 = var26;
      var26 += var23 * 6;
      int var42 = var26;
      var26 += var24 * 6;
      int var43 = var26;
      var26 += var24 * 6;
      int var44 = var26;
      var26 += var24 * 2;
      int var45 = var26;
      var26 += var24;
      int var46 = var26;
      var26 += var24 * 2 + var25 * 2;
      this.field1461 = var9;
      this.field1463 = var10;
      this.field1484 = var11;
      this.field1460 = new int[var9];
      this.field1490 = new int[var9];
      this.field1462 = new int[var9];
      this.field1477 = new int[var10];
      this.field1465 = new int[var10];
      this.field1466 = new int[var10];
      if(var17 == 1) {
         this.field1479 = new int[var9];
      }

      if(var12 == 1) {
         this.field1467 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1468 = new byte[var10];
      } else {
         this.field1473 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1469 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1478 = new int[var10];
      }

      if(var16 == 1) {
         this.field1472 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1470 = new byte[var10];
      }

      this.field1471 = new short[var10];
      if(var11 > 0) {
         this.field1476 = new short[var11];
         this.field1491 = new short[var11];
         this.field1464 = new short[var11];
      }

      var2.field2339 = var11;
      var3.field2339 = var38;
      var4.field2339 = var39;
      var5.field2339 = var40;
      var6.field2339 = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; var51++) {
         var52 = var2.readUByte();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method3561();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method3561();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method3561();
         }

         this.field1460[var51] = var48 + var53;
         this.field1490[var51] = var49 + var54;
         this.field1462[var51] = var50 + var55;
         var48 = this.field1460[var51];
         var49 = this.field1490[var51];
         var50 = this.field1462[var51];
         if(var17 == 1) {
            this.field1479[var51] = var6.readUByte();
         }
      }

      var2.field2339 = var37;
      var3.field2339 = var28;
      var4.field2339 = var30;
      var5.field2339 = var33;
      var6.field2339 = var31;
      var7.field2339 = var35;
      var8.field2339 = var36;

      for(var51 = 0; var51 < var10; var51++) {
         this.field1471[var51] = (short)var2.readUShort();
         if(var12 == 1) {
            this.field1467[var51] = var3.readByte();
         }

         if(var13 == 255) {
            this.field1468[var51] = var4.readByte();
         }

         if(var14 == 1) {
            this.field1469[var51] = var5.readByte();
         }

         if(var15 == 1) {
            this.field1478[var51] = var6.readUByte();
         }

         if(var16 == 1) {
            this.field1472[var51] = (short)(var7.readUShort() - 1);
         }

         if(this.field1470 != null && this.field1472[var51] != -1) {
            this.field1470[var51] = (byte)(var8.readUByte() - 1);
         }
      }

      var2.field2339 = var34;
      var3.field2339 = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; var55++) {
         var56 = var3.readUByte();
         if(var56 == 1) {
            var51 = var2.method3561() + var54;
            var52 = var2.method3561() + var51;
            var53 = var2.method3561() + var52;
            var54 = var53;
            this.field1477[var55] = var51;
            this.field1465[var55] = var52;
            this.field1466[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method3561() + var54;
            var54 = var53;
            this.field1477[var55] = var51;
            this.field1465[var55] = var52;
            this.field1466[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method3561() + var54;
            var54 = var53;
            this.field1477[var55] = var51;
            this.field1465[var55] = var52;
            this.field1466[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method3561() + var54;
            var54 = var53;
            this.field1477[var55] = var51;
            this.field1465[var55] = var57;
            this.field1466[var55] = var53;
         }
      }

      var2.field2339 = var41;
      var3.field2339 = var42;
      var4.field2339 = var43;
      var5.field2339 = var44;
      var6.field2339 = var45;
      var7.field2339 = var46;

      for(var55 = 0; var55 < var11; var55++) {
         var56 = this.field1459[var55] & 255;
         if(var56 == 0) {
            this.field1476[var55] = (short)var2.readUShort();
            this.field1491[var55] = (short)var2.readUShort();
            this.field1464[var55] = (short)var2.readUShort();
         }
      }

      var2.field2339 = var26;
      var55 = var2.readUByte();
      if(var55 != 0) {
         new class126();
         var2.readUShort();
         var2.readUShort();
         var2.readUShort();
         var2.readInt();
      }

   }

   public class113 method2567(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2627();
      int var7 = var2 + this.field1480;
      int var8 = var2 + this.field1492;
      int var9 = var4 + this.field1493;
      int var10 = var4 + this.field1498;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
            return this;
         } else {
            class113 var11;
            if(var5) {
               var11 = new class113();
               var11.field1461 = this.field1461;
               var11.field1463 = this.field1463;
               var11.field1484 = this.field1484;
               var11.field1460 = this.field1460;
               var11.field1462 = this.field1462;
               var11.field1477 = this.field1477;
               var11.field1465 = this.field1465;
               var11.field1466 = this.field1466;
               var11.field1467 = this.field1467;
               var11.field1468 = this.field1468;
               var11.field1469 = this.field1469;
               var11.field1470 = this.field1470;
               var11.field1471 = this.field1471;
               var11.field1472 = this.field1472;
               var11.field1473 = this.field1473;
               var11.field1459 = this.field1459;
               var11.field1476 = this.field1476;
               var11.field1491 = this.field1491;
               var11.field1464 = this.field1464;
               var11.field1479 = this.field1479;
               var11.field1478 = this.field1478;
               var11.field1481 = this.field1481;
               var11.field1482 = this.field1482;
               var11.field1486 = this.field1486;
               var11.field1487 = this.field1487;
               var11.field1490 = new int[var11.field1461];
            } else {
               var11 = this;
            }

            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            if(var6 == 0) {
               for(var12 = 0; var12 < var11.field1461; var12++) {
                  var13 = var2 + this.field1460[var12];
                  var14 = var4 + this.field1462[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1490[var12] = var21 + this.field1490[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1461; var12++) {
                  var13 = (-this.field1490[var12] << 16) / super.field1781;
                  if(var13 < var6) {
                     var14 = var2 + this.field1460[var12];
                     var15 = var4 + this.field1462[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1490[var12] = (var6 - var13) * (var22 - var3) / var6 + this.field1490[var12];
                  }
               }
            }

            var11.method2586();
            return var11;
         }
      } else {
         return this;
      }
   }

   public void method2580(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1461; var4++) {
         this.field1460[var4] += var1;
         this.field1490[var4] += var2;
         this.field1462[var4] += var3;
      }

      this.method2586();
   }

   void method2575() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1479 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1461; var3++) {
            var4 = this.field1479[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1481 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; var3++) {
            this.field1481[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1461; this.field1481[var4][var1[var4]++] = var3++) {
            var4 = this.field1479[var3];
         }

         this.field1479 = null;
      }

      if(this.field1478 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1463; var3++) {
            var4 = this.field1478[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1482 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; var3++) {
            this.field1482[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1463; this.field1482[var4][var1[var4]++] = var3++) {
            var4 = this.field1478[var3];
         }

         this.field1478 = null;
      }

   }

   public void method2583() {
      int var1;
      for(var1 = 0; var1 < this.field1461; var1++) {
         this.field1462[var1] = -this.field1462[var1];
      }

      for(var1 = 0; var1 < this.field1463; var1++) {
         int var2 = this.field1477[var1];
         this.field1477[var1] = this.field1466[var1];
         this.field1466[var1] = var2;
      }

      this.method2586();
   }

   public void method2653(int var1) {
      int var2 = field1497[var1];
      int var3 = field1495[var1];

      for(int var4 = 0; var4 < this.field1461; var4++) {
         int var5 = var2 * this.field1462[var4] + var3 * this.field1460[var4] >> 16;
         this.field1462[var4] = var3 * this.field1462[var4] - var2 * this.field1460[var4] >> 16;
         this.field1460[var4] = var5;
      }

      this.method2586();
   }

   public void method2576() {
      for(int var1 = 0; var1 < this.field1461; var1++) {
         int var2 = this.field1460[var1];
         this.field1460[var1] = this.field1462[var1];
         this.field1462[var1] = -var2;
      }

      this.method2586();
   }

   public void method2573() {
      for(int var1 = 0; var1 < this.field1461; var1++) {
         this.field1460[var1] = -this.field1460[var1];
         this.field1462[var1] = -this.field1462[var1];
      }

      this.method2586();
   }

   public void method2578() {
      for(int var1 = 0; var1 < this.field1461; var1++) {
         int var2 = this.field1462[var1];
         this.field1462[var1] = this.field1460[var1];
         this.field1460[var1] = -var2;
      }

      this.method2586();
   }

   final int method2572(class113 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1460[var2];
      int var5 = var1.field1490[var2];
      int var6 = var1.field1462[var2];

      for(int var7 = 0; var7 < this.field1461; var7++) {
         if(var4 == this.field1460[var7] && var5 == this.field1490[var7] && var6 == this.field1462[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1460[this.field1461] = var4;
         this.field1490[this.field1461] = var5;
         this.field1462[this.field1461] = var6;
         if(var1.field1479 != null) {
            this.field1479[this.field1461] = var1.field1479[var2];
         }

         var3 = this.field1461++;
      }

      return var3;
   }

   public static class113 method2568(class247 var0, int var1, int var2) {
      byte[] var3 = var0.method4625(var1, var2, 762129378);
      return var3 == null ? null : new class113(var3);
   }

   static void method2588(class113 var0, class113 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2627();
      var0.method2585();
      var1.method2627();
      var1.method2585();
      ++field1474;
      int var6 = 0;
      int[] var7 = var1.field1460;
      int var8 = var1.field1461;

      int var9;
      for(var9 = 0; var9 < var0.field1461; var9++) {
         class121 var10 = var0.field1496[var9];
         if(var10.field1666 != 0) {
            int var11 = var0.field1490[var9] - var3;
            if(var11 <= var1.field1489) {
               int var12 = var0.field1460[var9] - var2;
               if(var12 >= var1.field1480 && var12 <= var1.field1492) {
                  int var13 = var0.field1462[var9] - var4;
                  if(var13 >= var1.field1493 && var13 <= var1.field1498) {
                     for(int var14 = 0; var14 < var8; var14++) {
                        class121 var15 = var1.field1496[var14];
                        if(var12 == var7[var14] && var13 == var1.field1462[var14] && var11 == var1.field1490[var14] && var15.field1666 != 0) {
                           if(var0.field1485 == null) {
                              var0.field1485 = new class121[var0.field1461];
                           }

                           if(var1.field1485 == null) {
                              var1.field1485 = new class121[var8];
                           }

                           class121 var16 = var0.field1485[var9];
                           if(var16 == null) {
                              var16 = var0.field1485[var9] = new class121(var10);
                           }

                           class121 var17 = var1.field1485[var14];
                           if(var17 == null) {
                              var17 = var1.field1485[var14] = new class121(var15);
                           }

                           var16.field1665 += var15.field1665;
                           var16.field1661 += var15.field1661;
                           var16.field1662 += var15.field1662;
                           var16.field1666 += var15.field1666;
                           var17.field1665 += var10.field1665;
                           var17.field1661 += var10.field1661;
                           var17.field1662 += var10.field1662;
                           var17.field1666 += var10.field1666;
                           ++var6;
                           field1494[var9] = field1474;
                           field1475[var14] = field1474;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1463; var9++) {
            if(field1494[var0.field1477[var9]] == field1474 && field1494[var0.field1465[var9]] == field1474 && field1494[var0.field1466[var9]] == field1474) {
               if(var0.field1467 == null) {
                  var0.field1467 = new byte[var0.field1463];
               }

               var0.field1467[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1463; var9++) {
            if(field1474 == field1475[var1.field1477[var9]] && field1474 == field1475[var1.field1465[var9]] && field1474 == field1475[var1.field1466[var9]]) {
               if(var1.field1467 == null) {
                  var1.field1467 = new byte[var1.field1463];
               }

               var1.field1467[var9] = 2;
            }
         }

      }
   }

   static final int method2591(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   static final int method2590(int var0, int var1) {
      var1 = (var0 & 127) * var1 >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 65408) + var1;
   }
}
