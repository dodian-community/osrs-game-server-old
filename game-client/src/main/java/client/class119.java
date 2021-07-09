package client;

public class class119 extends class127 {
   static boolean[] field1626 = new boolean[4700];
   static int[] field1625 = new int[1600];
   static int[] field1594;
   static class119 field1579 = new class119();
   static byte[] field1580 = new byte[1];
   static class119 field1641 = new class119();
   static int field1635;
   static byte[] field1578 = new byte[1];
   static int[] field1642;
   static int field1636;
   static int field1637;
   static int[] field1623 = new int[4700];
   static boolean[] field1616 = new boolean[4700];
   static int[] field1638 = new int[12];
   static int[] field1631 = new int[12];
   static int[][] field1592 = new int[1600][512];
   static int[] field1582 = new int[4700];
   static int[] field1619 = new int[4700];
   static int[] field1632 = new int[10];
   static int[] field1589 = new int[4700];
   static int[] field1590 = new int[4700];
   static int[] field1577 = new int[4700];
   static int[] field1630 = new int[10];
   static int[][] field1640 = new int[12][2000];
   static int[] field1598;
   static int[] field1634 = new int[10];
   static int[] field1608 = new int[2000];
   static int[] field1595 = new int[2000];
   static int[] field1643;
   static boolean field1612 = true;
   static final int field1609 = 3500;
   static final int field1622 = 4700;
   static final int field1624 = 1600;
   static final int field1627 = 50;
   static final int field1639 = 5;
   static final int field1644 = 20;
   int field1607;
   int field1614 = -1;
   int field1633;
   int[][] field1601;
   int field1581 = 0;
   int[] field1586;
   int field1606;
   int field1585 = 0;
   int[] field1646;
   int[] field1584;
   int[] field1587;
   int[][] field1602;
   byte field1596 = 0;
   int field1628;
   int[] field1588;
   int field1597 = 0;
   int[] field1583;
   byte[] field1645;
   byte[] field1593;
   int[] field1591;
   int[] field1615;
   int field1605;
   public boolean field1603 = false;
   int[] field1620;
   int field1610;
   int field1613 = -1;
   int field1618;
   int field1629 = -1;
   short[] field1604;
   int field1611;
   byte[] field1617;
   int[] field1621;
   int[] field1599;
   int[] field1600;

   static {
      field1594 = class122.field1681;
      field1642 = class122.field1693;
      field1643 = class122.field1675;
      field1598 = class122.field1691;
   }

   class119() {
   }

   public class119(class119[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1581 = 0;
      this.field1585 = 0;
      this.field1597 = 0;
      this.field1596 = -1;

      int var7;
      class119 var8;
      for(var7 = 0; var7 < var2; var7++) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1581 += var8.field1581;
            this.field1585 += var8.field1585;
            this.field1597 += var8.field1597;
            if(var8.field1645 != null) {
               var3 = true;
            } else {
               if(this.field1596 == -1) {
                  this.field1596 = var8.field1596;
               }

               if(this.field1596 != var8.field1596) {
                  var3 = true;
               }
            }

            var4 |= var8.field1593 != null;
            var5 |= var8.field1604 != null;
            var6 |= var8.field1617 != null;
         }
      }

      this.field1646 = new int[this.field1581];
      this.field1583 = new int[this.field1581];
      this.field1584 = new int[this.field1581];
      this.field1586 = new int[this.field1585];
      this.field1587 = new int[this.field1585];
      this.field1588 = new int[this.field1585];
      this.field1615 = new int[this.field1585];
      this.field1620 = new int[this.field1585];
      this.field1591 = new int[this.field1585];
      if(var3) {
         this.field1645 = new byte[this.field1585];
      }

      if(var4) {
         this.field1593 = new byte[this.field1585];
      }

      if(var5) {
         this.field1604 = new short[this.field1585];
      }

      if(var6) {
         this.field1617 = new byte[this.field1585];
      }

      if(this.field1597 > 0) {
         this.field1621 = new int[this.field1597];
         this.field1599 = new int[this.field1597];
         this.field1600 = new int[this.field1597];
      }

      this.field1581 = 0;
      this.field1585 = 0;
      this.field1597 = 0;

      for(var7 = 0; var7 < var2; var7++) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1585; var9++) {
               this.field1586[this.field1585] = this.field1581 + var8.field1586[var9];
               this.field1587[this.field1585] = this.field1581 + var8.field1587[var9];
               this.field1588[this.field1585] = this.field1581 + var8.field1588[var9];
               this.field1615[this.field1585] = var8.field1615[var9];
               this.field1620[this.field1585] = var8.field1620[var9];
               this.field1591[this.field1585] = var8.field1591[var9];
               if(var3) {
                  if(var8.field1645 != null) {
                     this.field1645[this.field1585] = var8.field1645[var9];
                  } else {
                     this.field1645[this.field1585] = var8.field1596;
                  }
               }

               if(var4 && var8.field1593 != null) {
                  this.field1593[this.field1585] = var8.field1593[var9];
               }

               if(var5) {
                  if(var8.field1604 != null) {
                     this.field1604[this.field1585] = var8.field1604[var9];
                  } else {
                     this.field1604[this.field1585] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1617 != null && var8.field1617[var9] != -1) {
                     this.field1617[this.field1585] = (byte)(this.field1597 + var8.field1617[var9]);
                  } else {
                     this.field1617[this.field1585] = -1;
                  }
               }

               ++this.field1585;
            }

            for(var9 = 0; var9 < var8.field1597; var9++) {
               this.field1621[this.field1597] = this.field1581 + var8.field1621[var9];
               this.field1599[this.field1597] = this.field1581 + var8.field1599[var9];
               this.field1600[this.field1597] = this.field1581 + var8.field1600[var9];
               ++this.field1597;
            }

            for(var9 = 0; var9 < var8.field1581; var9++) {
               this.field1646[this.field1581] = var8.field1646[var9];
               this.field1583[this.field1581] = var8.field1583[var9];
               this.field1584[this.field1581] = var8.field1584[var9];
               ++this.field1581;
            }
         }
      }

   }

   public void method2670() {
      if(this.field1633 != 1) {
         this.field1633 = 1;
         super.field1781 = 0;
         this.field1628 = 0;
         this.field1606 = 0;

         for(int var1 = 0; var1 < this.field1581; var1++) {
            int var2 = this.field1646[var1];
            int var3 = this.field1583[var1];
            int var4 = this.field1584[var1];
            if(-var3 > super.field1781) {
               super.field1781 = -var3;
            }

            if(var3 > this.field1628) {
               this.field1628 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1606) {
               this.field1606 = var5;
            }
         }

         this.field1606 = (int)(Math.sqrt((double)this.field1606) + 0.99D);
         this.field1618 = (int)(Math.sqrt((double)(this.field1606 * this.field1606 + super.field1781 * super.field1781)) + 0.99D);
         this.field1607 = this.field1618 + (int)(Math.sqrt((double)(this.field1606 * this.field1606 + this.field1628 * this.field1628)) + 0.99D);
      }
   }

   public void method2724(class130 var1, int var2) {
      if(this.field1601 != null) {
         if(var2 != -1) {
            class117 var3 = var1.field1802[var2];
            class124 var4 = var3.field1546;
            field1635 = 0;
            field1636 = 0;
            field1637 = 0;

            for(int var5 = 0; var5 < var3.field1547; var5++) {
               int var6 = var3.field1548[var5];
               this.method2676(var4.field1706[var6], var4.field1707[var6], var3.field1549[var5], var3.field1542[var5], var3.field1550[var5]);
            }

            this.method2673();
         }
      }
   }

   void method2673() {
      this.field1633 = 0;
      this.field1614 = -1;
   }

   final void method2687(int var1) {
      int var2 = class122.field1687;
      int var3 = class122.field1689;
      int var4 = 0;
      int var5 = this.field1586[var1];
      int var6 = this.field1587[var1];
      int var7 = this.field1588[var1];
      int var8 = field1623[var5];
      int var9 = field1623[var6];
      int var10 = field1623[var7];
      if(this.field1593 == null) {
         class122.field1671 = 0;
      } else {
         class122.field1671 = this.field1593[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1632[var4] = field1582[var5];
         field1630[var4] = field1619[var5];
         field1634[var4++] = this.field1615[var1];
      } else {
         var11 = field1589[var5];
         var12 = field1577[var5];
         var13 = this.field1615[var1];
         if(var10 >= 50) {
            var14 = field1598[var10 - var8] * (50 - var8);
            field1632[var4] = var2 + class122.field1678 * (var11 + ((field1589[var7] - var11) * var14 >> 16)) / 50;
            field1630[var4] = var3 + class122.field1678 * (var12 + ((field1577[var7] - var12) * var14 >> 16)) / 50;
            field1634[var4++] = var13 + ((this.field1591[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1598[var9 - var8] * (50 - var8);
            field1632[var4] = var2 + class122.field1678 * (var11 + ((field1589[var6] - var11) * var14 >> 16)) / 50;
            field1630[var4] = var3 + class122.field1678 * (var12 + ((field1577[var6] - var12) * var14 >> 16)) / 50;
            field1634[var4++] = var13 + ((this.field1620[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1632[var4] = field1582[var6];
         field1630[var4] = field1619[var6];
         field1634[var4++] = this.field1620[var1];
      } else {
         var11 = field1589[var6];
         var12 = field1577[var6];
         var13 = this.field1620[var1];
         if(var8 >= 50) {
            var14 = field1598[var8 - var9] * (50 - var9);
            field1632[var4] = var2 + class122.field1678 * (var11 + ((field1589[var5] - var11) * var14 >> 16)) / 50;
            field1630[var4] = var3 + class122.field1678 * (var12 + ((field1577[var5] - var12) * var14 >> 16)) / 50;
            field1634[var4++] = var13 + ((this.field1615[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1598[var10 - var9] * (50 - var9);
            field1632[var4] = var2 + class122.field1678 * (var11 + ((field1589[var7] - var11) * var14 >> 16)) / 50;
            field1630[var4] = var3 + class122.field1678 * (var12 + ((field1577[var7] - var12) * var14 >> 16)) / 50;
            field1634[var4++] = var13 + ((this.field1591[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1632[var4] = field1582[var7];
         field1630[var4] = field1619[var7];
         field1634[var4++] = this.field1591[var1];
      } else {
         var11 = field1589[var7];
         var12 = field1577[var7];
         var13 = this.field1591[var1];
         if(var9 >= 50) {
            var14 = field1598[var9 - var10] * (50 - var10);
            field1632[var4] = var2 + class122.field1678 * (var11 + ((field1589[var6] - var11) * var14 >> 16)) / 50;
            field1630[var4] = var3 + class122.field1678 * (var12 + ((field1577[var6] - var12) * var14 >> 16)) / 50;
            field1634[var4++] = var13 + ((this.field1620[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1598[var8 - var10] * (50 - var10);
            field1632[var4] = var2 + class122.field1678 * (var11 + ((field1589[var5] - var11) * var14 >> 16)) / 50;
            field1630[var4] = var3 + class122.field1678 * (var12 + ((field1577[var5] - var12) * var14 >> 16)) / 50;
            field1634[var4++] = var13 + ((this.field1615[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1632[0];
      var12 = field1632[1];
      var13 = field1632[2];
      var14 = field1630[0];
      int var15 = field1630[1];
      int var16 = field1630[2];
      class122.field1677 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class122.field1688 || var12 > class122.field1688 || var13 > class122.field1688) {
            class122.field1677 = true;
         }

         if(this.field1604 != null && this.field1604[var1] != -1) {
            if(this.field1617 != null && this.field1617[var1] != -1) {
               var20 = this.field1617[var1] & 255;
               var17 = this.field1621[var20];
               var18 = this.field1599[var20];
               var19 = this.field1600[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1591[var1] == -1) {
               class122.method2804(var14, var15, var16, var11, var12, var13, this.field1615[var1], this.field1615[var1], this.field1615[var1], field1589[var17], field1589[var18], field1589[var19], field1577[var17], field1577[var18], field1577[var19], field1623[var17], field1623[var18], field1623[var19], this.field1604[var1]);
            } else {
               class122.method2804(var14, var15, var16, var11, var12, var13, field1634[0], field1634[1], field1634[2], field1589[var17], field1589[var18], field1589[var19], field1577[var17], field1577[var18], field1577[var19], field1623[var17], field1623[var18], field1623[var19], this.field1604[var1]);
            }
         } else if(this.field1591[var1] == -1) {
            class122.method2796(var14, var15, var16, var11, var12, var13, field1643[this.field1615[var1]]);
         } else {
            class122.method2794(var14, var15, var16, var11, var12, var13, field1634[0], field1634[1], field1634[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class122.field1688 || var12 > class122.field1688 || var13 > class122.field1688 || field1632[3] < 0 || field1632[3] > class122.field1688) {
            class122.field1677 = true;
         }

         if(this.field1604 != null && this.field1604[var1] != -1) {
            if(this.field1617 != null && this.field1617[var1] != -1) {
               var20 = this.field1617[var1] & 255;
               var17 = this.field1621[var20];
               var18 = this.field1599[var20];
               var19 = this.field1600[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1604[var1];
            if(this.field1591[var1] == -1) {
               class122.method2804(var14, var15, var16, var11, var12, var13, this.field1615[var1], this.field1615[var1], this.field1615[var1], field1589[var17], field1589[var18], field1589[var19], field1577[var17], field1577[var18], field1577[var19], field1623[var17], field1623[var18], field1623[var19], var21);
               class122.method2804(var14, var16, field1630[3], var11, var13, field1632[3], this.field1615[var1], this.field1615[var1], this.field1615[var1], field1589[var17], field1589[var18], field1589[var19], field1577[var17], field1577[var18], field1577[var19], field1623[var17], field1623[var18], field1623[var19], var21);
            } else {
               class122.method2804(var14, var15, var16, var11, var12, var13, field1634[0], field1634[1], field1634[2], field1589[var17], field1589[var18], field1589[var19], field1577[var17], field1577[var18], field1577[var19], field1623[var17], field1623[var18], field1623[var19], var21);
               class122.method2804(var14, var16, field1630[3], var11, var13, field1632[3], field1634[0], field1634[2], field1634[3], field1589[var17], field1589[var18], field1589[var19], field1577[var17], field1577[var18], field1577[var19], field1623[var17], field1623[var18], field1623[var19], var21);
            }
         } else if(this.field1591[var1] == -1) {
            var17 = field1643[this.field1615[var1]];
            class122.method2796(var14, var15, var16, var11, var12, var13, var17);
            class122.method2796(var14, var16, field1630[3], var11, var13, field1632[3], var17);
         } else {
            class122.method2794(var14, var15, var16, var11, var12, var13, field1634[0], field1634[1], field1634[2]);
            class122.method2794(var14, var16, field1630[3], var11, var13, field1632[3], field1634[0], field1634[2], field1634[3]);
         }
      }

   }

   class119 method2741(boolean var1, class119 var2, byte[] var3) {
      var2.field1581 = this.field1581;
      var2.field1585 = this.field1585;
      var2.field1597 = this.field1597;
      if(var2.field1646 == null || var2.field1646.length < this.field1581) {
         var2.field1646 = new int[this.field1581 + 100];
         var2.field1583 = new int[this.field1581 + 100];
         var2.field1584 = new int[this.field1581 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1581; var4++) {
         var2.field1646[var4] = this.field1646[var4];
         var2.field1583[var4] = this.field1583[var4];
         var2.field1584[var4] = this.field1584[var4];
      }

      if(var1) {
         var2.field1593 = this.field1593;
      } else {
         var2.field1593 = var3;
         if(this.field1593 == null) {
            for(var4 = 0; var4 < this.field1585; var4++) {
               var2.field1593[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1585; var4++) {
               var2.field1593[var4] = this.field1593[var4];
            }
         }
      }

      var2.field1586 = this.field1586;
      var2.field1587 = this.field1587;
      var2.field1588 = this.field1588;
      var2.field1615 = this.field1615;
      var2.field1620 = this.field1620;
      var2.field1591 = this.field1591;
      var2.field1645 = this.field1645;
      var2.field1617 = this.field1617;
      var2.field1604 = this.field1604;
      var2.field1596 = this.field1596;
      var2.field1621 = this.field1621;
      var2.field1599 = this.field1599;
      var2.field1600 = this.field1600;
      var2.field1601 = this.field1601;
      var2.field1602 = this.field1602;
      var2.field1603 = this.field1603;
      var2.method2673();
      return var2;
   }

   void method2669(int var1) {
      if(this.field1614 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1642[var1];
         int var9 = field1594[var1];

         for(int var10 = 0; var10 < this.field1581; var10++) {
            int var11 = class122.method2803(this.field1646[var10], this.field1584[var10], var8, var9);
            int var12 = this.field1583[var10];
            int var13 = class122.method2828(this.field1646[var10], this.field1584[var10], var8, var9);
            if(var11 < var2) {
               var2 = var11;
            }

            if(var11 > var5) {
               var5 = var11;
            }

            if(var12 < var3) {
               var3 = var12;
            }

            if(var12 > var6) {
               var6 = var12;
            }

            if(var13 < var4) {
               var4 = var13;
            }

            if(var13 > var7) {
               var7 = var13;
            }
         }

         this.field1605 = (var5 + var2) / 2;
         this.field1610 = (var6 + var3) / 2;
         this.field1611 = (var7 + var4) / 2;
         this.field1614 = (var5 - var2 + 1) / 2;
         this.field1613 = (var6 - var3 + 1) / 2;
         this.field1629 = (var7 - var4 + 1) / 2;
         if(this.field1614 < 32) {
            this.field1614 = 32;
         }

         if(this.field1629 < 32) {
            this.field1629 = 32;
         }

         if(this.field1603) {
            this.field1614 += 8;
            this.field1629 += 8;
         }

      }
   }

   public class119 method2666(boolean var1) {
      if(!var1 && field1578.length < this.field1585) {
         field1578 = new byte[this.field1585 + 100];
      }

      return this.method2741(var1, field1641, field1578);
   }

   void method2671() {
      if(this.field1633 != 2) {
         this.field1633 = 2;
         this.field1606 = 0;

         for(int var1 = 0; var1 < this.field1581; var1++) {
            int var2 = this.field1646[var1];
            int var3 = this.field1583[var1];
            int var4 = this.field1584[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1606) {
               this.field1606 = var5;
            }
         }

         this.field1606 = (int)(Math.sqrt((double)this.field1606) + 0.99D);
         this.field1618 = this.field1606;
         this.field1607 = this.field1606 + this.field1606;
      }
   }

   public class119 method2667(boolean var1) {
      if(!var1 && field1580.length < this.field1585) {
         field1580 = new byte[this.field1585 + 100];
      }

      return this.method2741(var1, field1579, field1580);
   }

   public void method2680(int var1) {
      int var2 = field1594[var1];
      int var3 = field1642[var1];

      for(int var4 = 0; var4 < this.field1581; var4++) {
         int var5 = var3 * this.field1583[var4] - var2 * this.field1584[var4] >> 16;
         this.field1584[var4] = var2 * this.field1583[var4] + var3 * this.field1584[var4] >> 16;
         this.field1583[var4] = var5;
      }

      this.method2673();
   }

   public class119 method2665(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2670();
      int var7 = var2 - this.field1606;
      int var8 = var2 + this.field1606;
      int var9 = var4 - this.field1606;
      int var10 = var4 + this.field1606;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
            return this;
         } else {
            class119 var11;
            if(var5) {
               var11 = new class119();
               var11.field1581 = this.field1581;
               var11.field1585 = this.field1585;
               var11.field1597 = this.field1597;
               var11.field1646 = this.field1646;
               var11.field1584 = this.field1584;
               var11.field1586 = this.field1586;
               var11.field1587 = this.field1587;
               var11.field1588 = this.field1588;
               var11.field1615 = this.field1615;
               var11.field1620 = this.field1620;
               var11.field1591 = this.field1591;
               var11.field1645 = this.field1645;
               var11.field1593 = this.field1593;
               var11.field1617 = this.field1617;
               var11.field1604 = this.field1604;
               var11.field1596 = this.field1596;
               var11.field1621 = this.field1621;
               var11.field1599 = this.field1599;
               var11.field1600 = this.field1600;
               var11.field1601 = this.field1601;
               var11.field1602 = this.field1602;
               var11.field1603 = this.field1603;
               var11.field1583 = new int[var11.field1581];
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
               for(var12 = 0; var12 < var11.field1581; var12++) {
                  var13 = var2 + this.field1646[var12];
                  var14 = var4 + this.field1584[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1583[var12] = var21 + this.field1583[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1581; var12++) {
                  var13 = (-this.field1583[var12] << 16) / super.field1781;
                  if(var13 < var6) {
                     var14 = var2 + this.field1646[var12];
                     var15 = var4 + this.field1584[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1583[var12] = (var6 - var13) * (var22 - var3) / var6 + this.field1583[var12];
                  }
               }
            }

            var11.method2673();
            return var11;
         }
      } else {
         return this;
      }
   }

   void vmethod3063(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
      field1625[0] = -1;
      if(this.field1633 != 1) {
         this.method2670();
      }

      this.method2669(var1);
      int var11 = var5 * var8 - var4 * var6 >> 16;
      int var12 = var2 * var7 + var3 * var11 >> 16;
      int var13 = var3 * this.field1606 >> 16;
      int var14 = var12 + var13;
      if(var14 > 50 && var12 < 3500) {
         int var15 = var8 * var4 + var5 * var6 >> 16;
         int var16 = (var15 - this.field1606) * class122.field1678;
         if(var16 / var14 < class122.field1684) {
            int var17 = (var15 + this.field1606) * class122.field1678;
            if(var17 / var14 > class122.field1683) {
               int var18 = var3 * var7 - var11 * var2 >> 16;
               int var19 = var2 * this.field1606 >> 16;
               int var20 = (var18 + var19) * class122.field1678;
               if(var20 / var14 > class122.field1685) {
                  int var21 = (var3 * super.field1781 >> 16) + var19;
                  int var22 = (var18 - var21) * class122.field1678;
                  if(var22 / var14 < class122.field1686) {
                     int var23 = var13 + (var2 * super.field1781 >> 16);
                     boolean var24 = false;
                     boolean var25 = false;
                     if(var12 - var23 <= 50) {
                        var25 = true;
                     }

                     boolean var26 = var25 || this.field1597 > 0;
                     int var27 = class81.method1884(-1864987128);
                     int var28 = class120.field1649;
                     boolean var30 = class165.method3437(-2015697461);
                     boolean var32 = var9 != 0L;
                     boolean var33;
                     if(var32) {
                        var33 = (int)(var9 >>> 16 & 1L) == 1;
                        var32 = !var33;
                     }

                     var33 = false;
                     int var37;
                     int var38;
                     int var39;
                     int var40;
                     int var41;
                     int var42;
                     int var46;
                     int var52;
                     if(var32 && var30) {
                        boolean var34 = false;
                        if(field1612) {
                           boolean var35;
                           if(!class165.method3437(-2005690810)) {
                              var35 = false;
                           } else {
                              class4.method56(-106852228);
                              var37 = this.field1605 + var6;
                              var38 = var7 + this.field1610;
                              var39 = var8 + this.field1611;
                              var40 = this.field1614;
                              var41 = this.field1613;
                              var42 = this.field1629;
                              int var43 = class120.field1657 - var37;
                              int var44 = class120.field1659 - var38;
                              int var45 = class177.field2283 - var39;
                              if(Math.abs(var43) > var40 + class98.field1335) {
                                 var35 = false;
                              } else if(Math.abs(var44) > var41 + class120.field1655) {
                                 var35 = false;
                              } else if(Math.abs(var45) > var42 + class312.field3757) {
                                 var35 = false;
                              } else if(Math.abs(var45 * class120.field1651 - var44 * class120.field1654) > var42 * class120.field1655 + var41 * class312.field3757) {
                                 var35 = false;
                              } else if(Math.abs(var43 * class120.field1654 - var45 * class303.field3721) > var42 * class98.field1335 + var40 * class312.field3757) {
                                 var35 = false;
                              } else if(Math.abs(var44 * class303.field3721 - var43 * class120.field1651) > var40 * class120.field1655 + var41 * class98.field1335) {
                                 var35 = false;
                              } else {
                                 var35 = true;
                              }
                           }

                           var34 = var35;
                        } else {
                           var52 = var12 - var13;
                           if(var52 <= 50) {
                              var52 = 50;
                           }

                           if(var15 > 0) {
                              var16 /= var14;
                              var17 /= var52;
                           } else {
                              var17 /= var14;
                              var16 /= var52;
                           }

                           if(var18 > 0) {
                              var22 /= var14;
                              var20 /= var52;
                           } else {
                              var20 /= var14;
                              var22 /= var52;
                           }

                           var46 = var27 - class122.field1687;
                           var37 = var28 - class122.field1689;
                           if(var46 > var16 && var46 < var17 && var37 > var22 && var37 < var20) {
                              var34 = true;
                           }
                        }

                        if(var34) {
                           if(this.field1603) {
                              class120.field1647[++class120.field1656 - 1] = var9;
                           } else {
                              var33 = true;
                           }
                        }
                     }

                     int var51 = class122.field1687;
                     var52 = class122.field1689;
                     var46 = 0;
                     var37 = 0;
                     if(var1 != 0) {
                        var46 = field1594[var1];
                        var37 = field1642[var1];
                     }

                     for(var38 = 0; var38 < this.field1581; var38++) {
                        var39 = this.field1646[var38];
                        var40 = this.field1583[var38];
                        var41 = this.field1584[var38];
                        if(var1 != 0) {
                           var42 = var41 * var46 + var39 * var37 >> 16;
                           var41 = var41 * var37 - var39 * var46 >> 16;
                           var39 = var42;
                        }

                        var39 += var6;
                        var40 += var7;
                        var41 += var8;
                        var42 = var41 * var4 + var5 * var39 >> 16;
                        var41 = var5 * var41 - var39 * var4 >> 16;
                        var39 = var42;
                        var42 = var3 * var40 - var41 * var2 >> 16;
                        var41 = var40 * var2 + var3 * var41 >> 16;
                        field1590[var38] = var41 - var12;
                        if(var41 >= 50) {
                           field1582[var38] = var39 * class122.field1678 / var41 + var51;
                           field1619[var38] = var42 * class122.field1678 / var41 + var52;
                        } else {
                           field1582[var38] = -5000;
                           var24 = true;
                        }

                        if(var26) {
                           field1589[var38] = var39;
                           field1577[var38] = var42;
                           field1623[var38] = var41;
                        }
                     }

                     try {
                        this.method2685(var24, var33, this.field1603, var9);
                     } catch (Exception var50) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   public void method2679() {
      for(int var1 = 0; var1 < this.field1581; var1++) {
         int var2 = this.field1584[var1];
         this.field1584[var1] = this.field1646[var1];
         this.field1646[var1] = -var2;
      }

      this.method2673();
   }

   public void method2681(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1581; var4++) {
         this.field1646[var4] = this.field1646[var4] * var1 / 128;
         this.field1583[var4] = var2 * this.field1583[var4] / 128;
         this.field1584[var4] = var3 * this.field1584[var4] / 128;
      }

      this.method2673();
   }

   public void method2678() {
      for(int var1 = 0; var1 < this.field1581; var1++) {
         this.field1646[var1] = -this.field1646[var1];
         this.field1584[var1] = -this.field1584[var1];
      }

      this.method2673();
   }

   public void method2677() {
      for(int var1 = 0; var1 < this.field1581; var1++) {
         int var2 = this.field1646[var1];
         this.field1646[var1] = this.field1584[var1];
         this.field1584[var1] = -var2;
      }

      this.method2673();
   }

   final void method2686(int var1) {
      if(field1626[var1]) {
         this.method2687(var1);
      } else {
         int var2 = this.field1586[var1];
         int var3 = this.field1587[var1];
         int var4 = this.field1588[var1];
         class122.field1677 = field1616[var1];
         if(this.field1593 == null) {
            class122.field1671 = 0;
         } else {
            class122.field1671 = this.field1593[var1] & 255;
         }

         if(this.field1604 != null && this.field1604[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1617 != null && this.field1617[var1] != -1) {
               int var8 = this.field1617[var1] & 255;
               var5 = this.field1621[var8];
               var6 = this.field1599[var8];
               var7 = this.field1600[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1591[var1] == -1) {
               class122.method2804(field1619[var2], field1619[var3], field1619[var4], field1582[var2], field1582[var3], field1582[var4], this.field1615[var1], this.field1615[var1], this.field1615[var1], field1589[var5], field1589[var6], field1589[var7], field1577[var5], field1577[var6], field1577[var7], field1623[var5], field1623[var6], field1623[var7], this.field1604[var1]);
            } else {
               class122.method2804(field1619[var2], field1619[var3], field1619[var4], field1582[var2], field1582[var3], field1582[var4], this.field1615[var1], this.field1620[var1], this.field1591[var1], field1589[var5], field1589[var6], field1589[var7], field1577[var5], field1577[var6], field1577[var7], field1623[var5], field1623[var6], field1623[var7], this.field1604[var1]);
            }
         } else if(this.field1591[var1] == -1) {
            class122.method2796(field1619[var2], field1619[var3], field1619[var4], field1582[var2], field1582[var3], field1582[var4], field1643[this.field1615[var1]]);
         } else {
            class122.method2794(field1619[var2], field1619[var3], field1619[var4], field1582[var2], field1582[var3], field1582[var4], this.field1615[var1], this.field1620[var1], this.field1591[var1]);
         }

      }
   }

   public void method2745(class130 var1, int var2, class130 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class117 var6 = var1.field1802[var2];
            class117 var7 = var3.field1802[var4];
            class124 var8 = var6.field1546;
            field1635 = 0;
            field1636 = 0;
            field1637 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1547; var11++) {
               for(var12 = var6.field1548[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1706[var12] == 0) {
                  this.method2676(var8.field1706[var12], var8.field1707[var12], var6.field1549[var11], var6.field1542[var11], var6.field1550[var11]);
               }
            }

            field1635 = 0;
            field1636 = 0;
            field1637 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1547; var11++) {
               for(var12 = var7.field1548[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1706[var12] == 0) {
                  this.method2676(var8.field1706[var12], var8.field1707[var12], var7.field1549[var11], var7.field1542[var11], var7.field1550[var11]);
               }
            }

            this.method2673();
         } else {
            this.method2724(var1, var2);
         }
      }
   }

   void method2676(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1635 = 0;
         field1636 = 0;
         field1637 = 0;

         for(var8 = 0; var8 < var6; var8++) {
            int var9 = var2[var8];
            if(var9 < this.field1601.length) {
               int[] var10 = this.field1601[var9];

               for(var11 = 0; var11 < var10.length; var11++) {
                  var12 = var10[var11];
                  field1635 += this.field1646[var12];
                  field1636 += this.field1583[var12];
                  field1637 += this.field1584[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1635 = var3 + field1635 / var7;
            field1636 = var4 + field1636 / var7;
            field1637 = var5 + field1637 / var7;
         } else {
            field1635 = var3;
            field1636 = var4;
            field1637 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; var7++) {
               var8 = var2[var7];
               if(var8 < this.field1601.length) {
                  var18 = this.field1601[var8];

                  for(var19 = 0; var19 < var18.length; var19++) {
                     var11 = var18[var19];
                     this.field1646[var11] += var3;
                     this.field1583[var11] += var4;
                     this.field1584[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; var7++) {
               var8 = var2[var7];
               if(var8 < this.field1601.length) {
                  var18 = this.field1601[var8];

                  for(var19 = 0; var19 < var18.length; var19++) {
                     var11 = var18[var19];
                     this.field1646[var11] -= field1635;
                     this.field1583[var11] -= field1636;
                     this.field1584[var11] -= field1637;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1594[var14];
                        var16 = field1642[var14];
                        var17 = var15 * this.field1583[var11] + var16 * this.field1646[var11] >> 16;
                        this.field1583[var11] = var16 * this.field1583[var11] - var15 * this.field1646[var11] >> 16;
                        this.field1646[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1594[var12];
                        var16 = field1642[var12];
                        var17 = var16 * this.field1583[var11] - var15 * this.field1584[var11] >> 16;
                        this.field1584[var11] = var15 * this.field1583[var11] + var16 * this.field1584[var11] >> 16;
                        this.field1583[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1594[var13];
                        var16 = field1642[var13];
                        var17 = var15 * this.field1584[var11] + var16 * this.field1646[var11] >> 16;
                        this.field1584[var11] = var16 * this.field1584[var11] - var15 * this.field1646[var11] >> 16;
                        this.field1646[var11] = var17;
                     }

                     this.field1646[var11] += field1635;
                     this.field1583[var11] += field1636;
                     this.field1584[var11] += field1637;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; var7++) {
               var8 = var2[var7];
               if(var8 < this.field1601.length) {
                  var18 = this.field1601[var8];

                  for(var19 = 0; var19 < var18.length; var19++) {
                     var11 = var18[var19];
                     this.field1646[var11] -= field1635;
                     this.field1583[var11] -= field1636;
                     this.field1584[var11] -= field1637;
                     this.field1646[var11] = var3 * this.field1646[var11] / 128;
                     this.field1583[var11] = var4 * this.field1583[var11] / 128;
                     this.field1584[var11] = var5 * this.field1584[var11] / 128;
                     this.field1646[var11] += field1635;
                     this.field1583[var11] += field1636;
                     this.field1584[var11] += field1637;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1602 != null && this.field1593 != null) {
               for(var7 = 0; var7 < var6; var7++) {
                  var8 = var2[var7];
                  if(var8 < this.field1602.length) {
                     var18 = this.field1602[var8];

                     for(var19 = 0; var19 < var18.length; var19++) {
                        var11 = var18[var19];
                        var12 = (this.field1593[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1593[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   final void method2685(boolean var1, boolean var2, boolean var3, long var4) {
      if(this.field1607 < 1600) {
         int var6;
         for(var6 = 0; var6 < this.field1607; var6++) {
            field1625[var6] = 0;
         }

         var6 = var3 ? 20 : 5;

         int var7;
         int var8;
         int var10;
         int var11;
         int var12;
         int var13;
         int var15;
         int var16;
         int var18;
         int var27;
         for(var7 = 0; var7 < this.field1585; var7++) {
            if(this.field1591[var7] != -2) {
               var8 = this.field1586[var7];
               var27 = this.field1587[var7];
               var10 = this.field1588[var7];
               var11 = field1582[var8];
               var12 = field1582[var27];
               var13 = field1582[var10];
               int var28;
               if(!var1 || var11 != -5000 && var12 != -5000 && var13 != -5000) {
                  if(var2 && class228.method4494(field1619[var8], field1619[var27], field1619[var10], var11, var12, var13, var6, -861297609)) {
                     class120.field1647[++class120.field1656 - 1] = var4;
                     var2 = false;
                  }

                  if((var11 - var12) * (field1619[var10] - field1619[var27]) - (var13 - var12) * (field1619[var8] - field1619[var27]) > 0) {
                     field1626[var7] = false;
                     if(var11 >= 0 && var12 >= 0 && var13 >= 0 && var11 <= class122.field1688 && var12 <= class122.field1688 && var13 <= class122.field1688) {
                        field1616[var7] = false;
                     } else {
                        field1616[var7] = true;
                     }

                     var28 = (field1590[var8] + field1590[var27] + field1590[var10]) / 3 + this.field1618;
                     field1592[var28][field1625[var28]++] = var7;
                  }
               } else {
                  var28 = field1589[var8];
                  var15 = field1589[var27];
                  var16 = field1589[var10];
                  int var17 = field1577[var8];
                  var18 = field1577[var27];
                  int var19 = field1577[var10];
                  int var20 = field1623[var8];
                  int var21 = field1623[var27];
                  int var22 = field1623[var10];
                  var28 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  var20 -= var21;
                  var22 -= var21;
                  int var23 = var17 * var22 - var20 * var19;
                  int var24 = var20 * var16 - var28 * var22;
                  int var25 = var28 * var19 - var17 * var16;
                  if(var15 * var23 + var18 * var24 + var21 * var25 > 0) {
                     field1626[var7] = true;
                     int var26 = (field1590[var8] + field1590[var27] + field1590[var10]) / 3 + this.field1618;
                     field1592[var26][field1625[var26]++] = var7;
                  }
               }
            }
         }

         int[] var9;
         if(this.field1645 == null) {
            for(var7 = this.field1607 - 1; var7 >= 0; --var7) {
               var8 = field1625[var7];
               if(var8 > 0) {
                  var9 = field1592[var7];

                  for(var10 = 0; var10 < var8; var10++) {
                     this.method2686(var9[var10]);
                  }
               }
            }

         } else {
            for(var7 = 0; var7 < 12; var7++) {
               field1638[var7] = 0;
               field1631[var7] = 0;
            }

            for(var7 = this.field1607 - 1; var7 >= 0; --var7) {
               var8 = field1625[var7];
               if(var8 > 0) {
                  var9 = field1592[var7];

                  for(var10 = 0; var10 < var8; var10++) {
                     var11 = var9[var10];
                     byte var32 = this.field1645[var11];
                     var13 = field1638[var32]++;
                     field1640[var32][var13] = var11;
                     if(var32 < 10) {
                        field1631[var32] += var7;
                     } else if(var32 == 10) {
                        field1608[var13] = var7;
                     } else {
                        field1595[var13] = var7;
                     }
                  }
               }
            }

            var7 = 0;
            if(field1638[1] > 0 || field1638[2] > 0) {
               var7 = (field1631[1] + field1631[2]) / (field1638[1] + field1638[2]);
            }

            var8 = 0;
            if(field1638[3] > 0 || field1638[4] > 0) {
               var8 = (field1631[3] + field1631[4]) / (field1638[3] + field1638[4]);
            }

            var27 = 0;
            if(field1638[6] > 0 || field1638[8] > 0) {
               var27 = (field1631[8] + field1631[6]) / (field1638[8] + field1638[6]);
            }

            var11 = 0;
            var12 = field1638[10];
            int[] var29 = field1640[10];
            int[] var30 = field1608;
            if(var11 == var12) {
               var11 = 0;
               var12 = field1638[11];
               var29 = field1640[11];
               var30 = field1595;
            }

            if(var11 < var12) {
               var10 = var30[var11];
            } else {
               var10 = -1000;
            }

            for(var15 = 0; var15 < 10; var15++) {
               while(var15 == 0 && var10 > var7) {
                  this.method2686(var29[var11++]);
                  if(var11 == var12 && var29 != field1640[11]) {
                     var11 = 0;
                     var12 = field1638[11];
                     var29 = field1640[11];
                     var30 = field1595;
                  }

                  if(var11 < var12) {
                     var10 = var30[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               while(var15 == 3 && var10 > var8) {
                  this.method2686(var29[var11++]);
                  if(var11 == var12 && var29 != field1640[11]) {
                     var11 = 0;
                     var12 = field1638[11];
                     var29 = field1640[11];
                     var30 = field1595;
                  }

                  if(var11 < var12) {
                     var10 = var30[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               while(var15 == 5 && var10 > var27) {
                  this.method2686(var29[var11++]);
                  if(var11 == var12 && var29 != field1640[11]) {
                     var11 = 0;
                     var12 = field1638[11];
                     var29 = field1640[11];
                     var30 = field1595;
                  }

                  if(var11 < var12) {
                     var10 = var30[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               var16 = field1638[var15];
               int[] var31 = field1640[var15];

               for(var18 = 0; var18 < var16; var18++) {
                  this.method2686(var31[var18]);
               }
            }

            while(var10 != -1000) {
               this.method2686(var29[var11++]);
               if(var11 == var12 && var29 != field1640[11]) {
                  var11 = 0;
                  var29 = field1640[11];
                  var12 = field1638[11];
                  var30 = field1595;
               }

               if(var11 < var12) {
                  var10 = var30[var11];
               } else {
                  var10 = -1000;
               }
            }

         }
      }
   }

   public void method2718(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1581; var4++) {
         this.field1646[var4] += var1;
         this.field1583[var4] += var2;
         this.field1584[var4] += var3;
      }

      this.method2673();
   }

   public final void method2682(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1625[0] = -1;
      if(this.field1633 != 2 && this.field1633 != 1) {
         this.method2671();
      }

      int var8 = class122.field1687;
      int var9 = class122.field1689;
      int var10 = field1594[var1];
      int var11 = field1642[var1];
      int var12 = field1594[var2];
      int var13 = field1642[var2];
      int var14 = field1594[var3];
      int var15 = field1642[var3];
      int var16 = field1594[var4];
      int var17 = field1642[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1581; var19++) {
         int var20 = this.field1646[var19];
         int var21 = this.field1583[var19];
         int var22 = this.field1584[var19];
         int var23;
         if(var3 != 0) {
            var23 = var21 * var14 + var20 * var15 >> 16;
            var21 = var21 * var15 - var20 * var14 >> 16;
            var20 = var23;
         }

         if(var1 != 0) {
            var23 = var21 * var11 - var22 * var10 >> 16;
            var22 = var21 * var10 + var22 * var11 >> 16;
            var21 = var23;
         }

         if(var2 != 0) {
            var23 = var22 * var12 + var20 * var13 >> 16;
            var22 = var22 * var13 - var20 * var12 >> 16;
            var20 = var23;
         }

         var20 += var5;
         var21 += var6;
         var22 += var7;
         var23 = var21 * var17 - var22 * var16 >> 16;
         var22 = var21 * var16 + var22 * var17 >> 16;
         field1590[var19] = var22 - var18;
         field1582[var19] = var20 * class122.field1678 / var22 + var8;
         field1619[var19] = var23 * class122.field1678 / var22 + var9;
         if(this.field1597 > 0) {
            field1589[var19] = var20;
            field1577[var19] = var23;
            field1623[var19] = var22;
         }
      }

      try {
         this.method2685(false, false, false, 0L);
      } catch (Exception var25) {
         ;
      }

   }

   public final void method2710(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1625[0] = -1;
      if(this.field1633 != 2 && this.field1633 != 1) {
         this.method2671();
      }

      int var9 = class122.field1687;
      int var10 = class122.field1689;
      int var11 = field1594[var1];
      int var12 = field1642[var1];
      int var13 = field1594[var2];
      int var14 = field1642[var2];
      int var15 = field1594[var3];
      int var16 = field1642[var3];
      int var17 = field1594[var4];
      int var18 = field1642[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1581; var20++) {
         int var21 = this.field1646[var20];
         int var22 = this.field1583[var20];
         int var23 = this.field1584[var20];
         int var24;
         if(var3 != 0) {
            var24 = var22 * var15 + var21 * var16 >> 16;
            var22 = var22 * var16 - var21 * var15 >> 16;
            var21 = var24;
         }

         if(var1 != 0) {
            var24 = var22 * var12 - var23 * var11 >> 16;
            var23 = var22 * var11 + var23 * var12 >> 16;
            var22 = var24;
         }

         if(var2 != 0) {
            var24 = var23 * var13 + var21 * var14 >> 16;
            var23 = var23 * var14 - var21 * var13 >> 16;
            var21 = var24;
         }

         var21 += var5;
         var22 += var6;
         var23 += var7;
         var24 = var22 * var18 - var23 * var17 >> 16;
         var23 = var22 * var17 + var23 * var18 >> 16;
         field1590[var20] = var23 - var19;
         field1582[var20] = var9 + var21 * class122.field1678 / var8;
         field1619[var20] = var10 + var24 * class122.field1678 / var8;
         if(this.field1597 > 0) {
            field1589[var20] = var21;
            field1577[var20] = var24;
            field1623[var20] = var23;
         }
      }

      try {
         this.method2685(false, false, false, 0L);
      } catch (Exception var26) {
         ;
      }

   }

   public int method2672() {
      this.method2670();
      return this.field1606;
   }
}
