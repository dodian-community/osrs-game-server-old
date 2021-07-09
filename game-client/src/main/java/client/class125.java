package client;

public class class125 {
   public static boolean field1760 = true;
   static boolean field1749 = false;
   static int[] field1753;
   static int field1770;
   static int field1769;
   static class205 field1757;
   static int field1727 = 0;
   static int field1752 = 4;
   public static int field1772 = -1;
   static int field1726 = 0;
   static class132[] field1756;
   static int field1742;
   static class132[][] field1754;
   static boolean field1743 = false;
   static int field1765;
   static class134[] field1748 = new class134[100];
   static int field1744 = 0;
   static int field1736;
   static int field1745 = 0;
   static int field1759;
   static int field1746 = 0;
   static int field1733;
   static int field1737;
   public static int field1747 = -1;
   static int field1734;
   static int field1740;
   static int field1729;
   static int field1771;
   static boolean[][][][] field1712;
   static int field1730;
   static int field1731;
   static int field1732;
   static boolean[][] field1768;
   static final int[] field1758;
   static final int[] field1723;
   static final int[] field1766;
   static final int[] field1714;
   static final int[] field1762;
   static final int[] field1764;
   static final int[] field1767;
   static int field1755;
   static int field1761;
   static int field1773;
   static int field1774;
   static int field1717;
   static int field1735;
   static final int field1722 = 128;
   static final int field1724 = 25;
   static final int field1725 = 50;
   static final int field1739 = 64;
   static final int field1750 = 32;
   static final int field1751 = 128;
   int field1718 = 0;
   int field1719 = 0;
   int[][][] field1721;
   int field1738;
   int field1713;
   class118[][][] field1728;
   class134[] field1720 = new class134[5000];
   int field1715;
   int[][][] field1716;
   int[][] field1763 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
   int[][] field1741 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};

   static {
      field1753 = new int[field1752];
      field1754 = new class132[field1752][500];
      field1770 = 0;
      field1756 = new class132[500];
      field1757 = new class205();
      field1758 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      field1723 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      field1766 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      field1714 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      field1762 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      field1767 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      field1764 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      field1712 = new boolean[8][32][51][51];
   }

   public class125(int var1, int var2, int var3, int[][][] var4) {
      this.field1713 = var1;
      this.field1738 = var2;
      this.field1715 = var3;
      this.field1728 = new class118[var1][var2][var3];
      this.field1721 = new int[var1][var2 + 1][var3 + 1];
      this.field1716 = var4;
      this.method2903();
   }

   boolean method2871(int var1, int var2, int var3) {
      int var4 = this.field1721[var1][var2][var3];
      if(var4 == -field1765) {
         return false;
      } else if(var4 == field1765) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method2873(var5 + 1, this.field1716[var1][var2][var3], var6 + 1) && this.method2873(var5 + 128 - 1, this.field1716[var1][var2 + 1][var3], var6 + 1) && this.method2873(var5 + 128 - 1, this.field1716[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method2873(var5 + 1, this.field1716[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field1721[var1][var2][var3] = field1765;
            return true;
         } else {
            this.field1721[var1][var2][var3] = -field1765;
            return false;
         }
      }
   }

   boolean method2913(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class127 var9, int var10, boolean var11, long var12, int var14) {
      int var16;
      for(int var15 = var2; var15 < var2 + var4; var15++) {
         for(var16 = var3; var16 < var3 + var5; var16++) {
            if(var15 < 0 || var16 < 0 || var15 >= this.field1738 || var16 >= this.field1715) {
               return false;
            }

            class118 var17 = this.field1728[var1][var15][var16];
            if(var17 != null && var17.field1564 >= 5) {
               return false;
            }
         }
      }

      class134 var21 = new class134();
      var21.field1848 = var12;
      var21.field1849 = var14;
      var21.field1841 = var1;
      var21.field1838 = var6;
      var21.field1839 = var7;
      var21.field1837 = var8;
      var21.field1844 = var9;
      var21.field1845 = var10;
      var21.field1842 = var2;
      var21.field1840 = var3;
      var21.field1843 = var2 + var4 - 1;
      var21.field1850 = var3 + var5 - 1;

      for(var16 = var2; var16 < var2 + var4; var16++) {
         for(int var22 = var3; var22 < var3 + var5; var22++) {
            int var18 = 0;
            if(var16 > var2) {
               ++var18;
            }

            if(var16 < var2 + var4 - 1) {
               var18 += 4;
            }

            if(var22 > var3) {
               var18 += 8;
            }

            if(var22 < var3 + var5 - 1) {
               var18 += 2;
            }

            for(int var19 = var1; var19 >= 0; --var19) {
               if(this.field1728[var19][var16][var22] == null) {
                  this.field1728[var19][var16][var22] = new class118(var19, var16, var22);
               }
            }

            class118 var23 = this.field1728[var1][var16][var22];
            var23.field1562[var23.field1564] = var21;
            var23.field1557[var23.field1564] = var18;
            var23.field1566 |= var18;
            ++var23.field1564;
         }
      }

      if(var11) {
         this.field1720[this.field1719++] = var21;
      }

      return true;
   }

   void method2887(class134 var1) {
      for(int var2 = var1.field1842; var2 <= var1.field1843; var2++) {
         for(int var3 = var1.field1840; var3 <= var1.field1850; var3++) {
            class118 var4 = this.field1728[var1.field1841][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.field1564; var5++) {
                  if(var4.field1562[var5] == var1) {
                     --var4.field1564;

                     for(int var6 = var5; var6 < var4.field1564; var6++) {
                        var4.field1562[var6] = var4.field1562[var6 + 1];
                        var4.field1557[var6] = var4.field1557[var6 + 1];
                     }

                     var4.field1562[var4.field1564] = null;
                     break;
                  }
               }

               var4.field1566 = 0;

               for(var5 = 0; var5 < var4.field1564; var5++) {
                  var4.field1566 |= var4.field1557[var5];
               }
            }
         }
      }

   }

   public void method2909(int var1, int var2, int var3, boolean var4) {
      if(!method2911() || var4) {
         field1743 = true;
         field1749 = var4;
         field1744 = var1;
         field1745 = var2;
         field1746 = var3;
         field1772 = -1;
         field1747 = -1;
      }
   }

   boolean method2873(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field1770; var4++) {
         class132 var5 = field1756[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field1806 == 1) {
            var6 = var5.field1809 - var1;
            if(var6 > 0) {
               var7 = (var6 * var5.field1817 >> 8) + var5.field1822;
               var8 = (var6 * var5.field1818 >> 8) + var5.field1811;
               var9 = (var6 * var5.field1803 >> 8) + var5.field1812;
               var10 = (var6 * var5.field1810 >> 8) + var5.field1808;
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1806 == 2) {
            var6 = var1 - var5.field1809;
            if(var6 > 0) {
               var7 = (var6 * var5.field1817 >> 8) + var5.field1822;
               var8 = (var6 * var5.field1818 >> 8) + var5.field1811;
               var9 = (var6 * var5.field1803 >> 8) + var5.field1812;
               var10 = (var6 * var5.field1810 >> 8) + var5.field1808;
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1806 == 3) {
            var6 = var5.field1822 - var3;
            if(var6 > 0) {
               var7 = (var6 * var5.field1815 >> 8) + var5.field1809;
               var8 = (var6 * var5.field1816 >> 8) + var5.field1821;
               var9 = (var6 * var5.field1803 >> 8) + var5.field1812;
               var10 = (var6 * var5.field1810 >> 8) + var5.field1808;
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1806 == 4) {
            var6 = var3 - var5.field1822;
            if(var6 > 0) {
               var7 = (var6 * var5.field1815 >> 8) + var5.field1809;
               var8 = (var6 * var5.field1816 >> 8) + var5.field1821;
               var9 = (var6 * var5.field1803 >> 8) + var5.field1812;
               var10 = (var6 * var5.field1810 >> 8) + var5.field1808;
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1806 == 5) {
            var6 = var2 - var5.field1812;
            if(var6 > 0) {
               var7 = (var6 * var5.field1815 >> 8) + var5.field1809;
               var8 = (var6 * var5.field1816 >> 8) + var5.field1821;
               var9 = (var6 * var5.field1817 >> 8) + var5.field1822;
               var10 = (var6 * var5.field1818 >> 8) + var5.field1811;
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   void method2905(class113 var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; var12++) {
         if(var12 != this.field1713) {
            for(int var13 = var8; var13 <= var9; var13++) {
               if(var13 >= 0 && var13 < this.field1738) {
                  for(int var14 = var10; var14 <= var11; var14++) {
                     if(var14 >= 0 && var14 < this.field1715 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var3 != var13)) {
                        class118 var15 = this.field1728[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.field1716[var12][var13 + 1][var14] + this.field1716[var12][var13 + 1][var14 + 1] + this.field1716[var12][var13][var14] + this.field1716[var12][var13][var14 + 1]) / 4 - (this.field1716[var2][var3 + 1][var4] + this.field1716[var2][var3][var4] + this.field1716[var2][var3 + 1][var4 + 1] + this.field1716[var2][var3][var4 + 1]) / 4;
                           class128 var17 = var15.field1559;
                           if(var17 != null) {
                              class113 var23;
                              if(var17.field1787 instanceof class113) {
                                 var23 = (class113)var17.field1787;
                                 class113.method2588(var1, var23, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.field1788 instanceof class113) {
                                 var23 = (class113)var17.field1788;
                                 class113.method2588(var1, var23, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var18 = 0; var18 < var15.field1564; var18++) {
                              class134 var19 = var15.field1562[var18];
                              if(var19 != null && var19.field1844 instanceof class113) {
                                 class113 var20 = (class113)var19.field1844;
                                 int var21 = var19.field1843 - var19.field1842 + 1;
                                 int var22 = var19.field1850 - var19.field1840 + 1;
                                 class113.method2588(var1, var20, (var21 - var5) * 64 + (var19.field1842 - var3) * 128, var16, (var19.field1840 - var4) * 128 + (var22 - var6) * 64, var7);
                              }
                           }
                        }
                     }
                  }
               }
            }

            --var8;
            var7 = false;
         }
      }

   }

   boolean method3042(int var1, int var2, int var3, int var4) {
      if(!this.method2871(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.field1716[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > field1769) {
                  if(!this.method2873(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2873(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2873(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2873(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2873(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2873(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < field1742) {
                  if(!this.method2873(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2873(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2873(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method2873(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2873(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method2873(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < field1769) {
                  if(!this.method2873(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method2873(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2873(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method2873(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method2873(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method2873(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > field1742) {
                  if(!this.method2873(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method2873(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method2873(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method2873(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method2873(var5, var9, var6)) {
                  return false;
               }

               if(!this.method2873(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method2873(var5 + 64, var10, var6 + 64) ? false : (var4 == 16 ? this.method2873(var5, var9, var6 + 128) : (var4 == 32 ? this.method2873(var5 + 128, var9, var6 + 128) : (var4 == 64 ? this.method2873(var5 + 128, var9, var6) : (var4 == 128 ? this.method2873(var5, var9, var6) : true))));
      }
   }

   void method2940(class123 var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - field1769;
      int var11;
      int var12 = var11 = (var8 << 7) - field1742;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.field1716[var2][var7][var8] - field1736;
      int var18 = this.field1716[var2][var7 + 1][var8] - field1736;
      int var19 = this.field1716[var2][var7 + 1][var8 + 1] - field1736;
      int var20 = this.field1716[var2][var7][var8 + 1] - field1736;
      int var21 = var10 * var6 + var5 * var12 >> 16;
      var12 = var12 * var6 - var5 * var10 >> 16;
      var10 = var21;
      var21 = var17 * var4 - var3 * var12 >> 16;
      var12 = var3 * var17 + var12 * var4 >> 16;
      var17 = var21;
      if(var12 >= 50) {
         var21 = var14 * var6 + var5 * var11 >> 16;
         var11 = var11 * var6 - var5 * var14 >> 16;
         var14 = var21;
         var21 = var18 * var4 - var3 * var11 >> 16;
         var11 = var3 * var18 + var11 * var4 >> 16;
         var18 = var21;
         if(var11 >= 50) {
            var21 = var13 * var6 + var5 * var16 >> 16;
            var16 = var16 * var6 - var5 * var13 >> 16;
            var13 = var21;
            var21 = var19 * var4 - var3 * var16 >> 16;
            var16 = var3 * var19 + var16 * var4 >> 16;
            var19 = var21;
            if(var16 >= 50) {
               var21 = var9 * var6 + var5 * var15 >> 16;
               var15 = var15 * var6 - var5 * var9 >> 16;
               var9 = var21;
               var21 = var20 * var4 - var3 * var15 >> 16;
               var15 = var3 * var20 + var15 * var4 >> 16;
               if(var15 >= 50) {
                  int var22 = var10 * class122.field1678 / var12 + class122.field1687;
                  int var23 = var17 * class122.field1678 / var12 + class122.field1689;
                  int var24 = var14 * class122.field1678 / var11 + class122.field1687;
                  int var25 = var18 * class122.field1678 / var11 + class122.field1689;
                  int var26 = var13 * class122.field1678 / var16 + class122.field1687;
                  int var27 = var19 * class122.field1678 / var16 + class122.field1689;
                  int var28 = var9 * class122.field1678 / var15 + class122.field1687;
                  int var29 = var21 * class122.field1678 / var15 + class122.field1689;
                  class122.field1671 = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     class122.field1677 = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > class122.field1688 || var28 > class122.field1688 || var24 > class122.field1688) {
                        class122.field1677 = true;
                     }

                     if(field1743 && method2918(field1745, field1746, var27, var29, var25, var26, var28, var24)) {
                        field1772 = var7;
                        field1747 = var8;
                     }

                     if(var1.field1698 == -1) {
                        if(var1.field1696 != 12345678) {
                           class122.method2794(var27, var29, var25, var26, var28, var24, var1.field1696, var1.field1694, var1.field1695);
                        }
                     } else if(!field1760) {
                        if(var1.field1699) {
                           class122.method2800(var27, var29, var25, var26, var28, var24, var1.field1696, var1.field1694, var1.field1695, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field1698);
                        } else {
                           class122.method2800(var27, var29, var25, var26, var28, var24, var1.field1696, var1.field1694, var1.field1695, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.field1698);
                        }
                     } else {
                        var30 = class122.field1667.vmethod3092(var1.field1698, 2017103535);
                        class122.method2794(var27, var29, var25, var26, var28, var24, method2961(var30, var1.field1696), method2961(var30, var1.field1694), method2961(var30, var1.field1695));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     class122.field1677 = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > class122.field1688 || var24 > class122.field1688 || var28 > class122.field1688) {
                        class122.field1677 = true;
                     }

                     if(field1743 && method2918(field1745, field1746, var23, var25, var29, var22, var24, var28)) {
                        field1772 = var7;
                        field1747 = var8;
                     }

                     if(var1.field1698 == -1) {
                        if(var1.field1703 != 12345678) {
                           class122.method2794(var23, var25, var29, var22, var24, var28, var1.field1703, var1.field1695, var1.field1694);
                        }
                     } else if(!field1760) {
                        class122.method2800(var23, var25, var29, var22, var24, var28, var1.field1703, var1.field1695, var1.field1694, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field1698);
                     } else {
                        var30 = class122.field1667.vmethod3092(var1.field1698, 2017103535);
                        class122.method2794(var23, var25, var29, var22, var24, var28, method2961(var30, var1.field1703), method2961(var30, var1.field1695), method2961(var30, var1.field1694));
                     }
                  }

               }
            }
         }
      }
   }

   void method2916(class114 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.field1514.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; var9++) {
         var10 = var1.field1514[var9] - field1769;
         var11 = var1.field1513[var9] - field1736;
         var12 = var1.field1500[var9] - field1742;
         var13 = var12 * var4 + var5 * var10 >> 16;
         var12 = var5 * var12 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var3 * var11 - var12 * var2 >> 16;
         var12 = var11 * var2 + var3 * var12 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.field1508 != null) {
            class114.field1507[var9] = var10;
            class114.field1517[var9] = var13;
            class114.field1516[var9] = var12;
         }

         class114.field1504[var9] = var10 * class122.field1678 / var12 + class122.field1687;
         class114.field1515[var9] = var13 * class122.field1678 / var12 + class122.field1689;
      }

      class122.field1671 = 0;
      var8 = var1.field1505.length;

      for(var9 = 0; var9 < var8; var9++) {
         var10 = var1.field1505[var9];
         var11 = var1.field1501[var9];
         var12 = var1.field1499[var9];
         var13 = class114.field1504[var10];
         int var14 = class114.field1504[var11];
         int var15 = class114.field1504[var12];
         int var16 = class114.field1515[var10];
         int var17 = class114.field1515[var11];
         int var18 = class114.field1515[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            class122.field1677 = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > class122.field1688 || var14 > class122.field1688 || var15 > class122.field1688) {
               class122.field1677 = true;
            }

            if(field1743 && method2918(field1745, field1746, var16, var17, var18, var13, var14, var15)) {
               field1772 = var6;
               field1747 = var7;
            }

            if(var1.field1508 != null && var1.field1508[var9] != -1) {
               if(!field1760) {
                  if(var1.field1518) {
                     class122.method2800(var16, var17, var18, var13, var14, var15, var1.field1512[var9], var1.field1503[var9], var1.field1506[var9], class114.field1507[0], class114.field1507[1], class114.field1507[3], class114.field1517[0], class114.field1517[1], class114.field1517[3], class114.field1516[0], class114.field1516[1], class114.field1516[3], var1.field1508[var9]);
                  } else {
                     class122.method2800(var16, var17, var18, var13, var14, var15, var1.field1512[var9], var1.field1503[var9], var1.field1506[var9], class114.field1507[var10], class114.field1507[var11], class114.field1507[var12], class114.field1517[var10], class114.field1517[var11], class114.field1517[var12], class114.field1516[var10], class114.field1516[var11], class114.field1516[var12], var1.field1508[var9]);
                  }
               } else {
                  int var19 = class122.field1667.vmethod3092(var1.field1508[var9], 2017103535);
                  class122.method2794(var16, var17, var18, var13, var14, var15, method2961(var19, var1.field1512[var9]), method2961(var19, var1.field1503[var9]), method2961(var19, var1.field1506[var9]));
               }
            } else if(var1.field1512[var9] != 12345678) {
               class122.method2794(var16, var17, var18, var13, var14, var15, var1.field1512[var9], var1.field1503[var9], var1.field1506[var9]);
            }
         }
      }

   }

   void method2981(class113 var1, int var2, int var3, int var4) {
      class118 var5;
      class113 var6;
      if(var3 < this.field1738) {
         var5 = this.field1728[var2][var3 + 1][var4];
         if(var5 != null && var5.field1553 != null && var5.field1553.field1524 instanceof class113) {
            var6 = (class113)var5.field1553.field1524;
            class113.method2588(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.field1738) {
         var5 = this.field1728[var2][var3][var4 + 1];
         if(var5 != null && var5.field1553 != null && var5.field1553.field1524 instanceof class113) {
            var6 = (class113)var5.field1553.field1524;
            class113.method2588(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.field1738 && var4 < this.field1715) {
         var5 = this.field1728[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.field1553 != null && var5.field1553.field1524 instanceof class113) {
            var6 = (class113)var5.field1553.field1524;
            class113.method2588(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.field1738 && var4 > 0) {
         var5 = this.field1728[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.field1553 != null && var5.field1553.field1524 instanceof class113) {
            var6 = (class113)var5.field1553.field1524;
            class113.method2588(var1, var6, 128, 0, -128, true);
         }
      }

   }

   public void method2903() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.field1713; var1++) {
         for(var2 = 0; var2 < this.field1738; var2++) {
            for(int var3 = 0; var3 < this.field1715; var3++) {
               this.field1728[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < field1752; var1++) {
         for(var2 = 0; var2 < field1753[var1]; var2++) {
            field1754[var1][var2] = null;
         }

         field1753[var1] = 0;
      }

      for(var1 = 0; var1 < this.field1719; var1++) {
         this.field1720[var1] = null;
      }

      this.field1719 = 0;

      for(var1 = 0; var1 < field1748.length; var1++) {
         field1748[var1] = null;
      }

   }

   boolean method2885(int var1, int var2, int var3, int var4) {
      if(!this.method2871(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method2873(var5 + 1, this.field1716[var1][var2][var3] - var4, var6 + 1) && this.method2873(var5 + 128 - 1, this.field1716[var1][var2 + 1][var3] - var4, var6 + 1) && this.method2873(var5 + 128 - 1, this.field1716[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method2873(var5 + 1, this.field1716[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   boolean method2923(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var3 == var2 && var5 == var4) {
         if(!this.method2871(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method2873(var7 + 1, this.field1716[var1][var2][var4] - var6, var8 + 1) && this.method2873(var7 + 128 - 1, this.field1716[var1][var2 + 1][var4] - var6, var8 + 1) && this.method2873(var7 + 128 - 1, this.field1716[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method2873(var7 + 1, this.field1716[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; var7++) {
            for(var8 = var4; var8 <= var5; var8++) {
               if(this.field1721[var1][var7][var8] == -field1765) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.field1716[var1][var2][var4] - var6;
         if(!this.method2873(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method2873(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method2873(var7, var9, var11)) {
                  return false;
               } else if(!this.method2873(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   void method2919() {
      int var1 = field1753[field1727];
      class132[] var2 = field1754[field1727];
      field1770 = 0;

      for(int var3 = 0; var3 < var1; var3++) {
         class132 var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         int var9;
         boolean var13;
         if(var4.field1813 == 1) {
            var5 = var4.field1807 - field1733 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field1805 - field1734 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1820 - field1734 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               var13 = false;

               while(var6 <= var7) {
                  if(field1768[var5][var6++]) {
                     var13 = true;
                     break;
                  }
               }

               if(var13) {
                  var9 = field1769 - var4.field1809;
                  if(var9 > 32) {
                     var4.field1806 = 1;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field1806 = 2;
                     var9 = -var9;
                  }

                  var4.field1817 = (var4.field1822 - field1742 << 8) / var9;
                  var4.field1818 = (var4.field1811 - field1742 << 8) / var9;
                  var4.field1803 = (var4.field1812 - field1736 << 8) / var9;
                  var4.field1810 = (var4.field1808 - field1736 << 8) / var9;
                  field1756[field1770++] = var4;
               }
            }
         } else if(var4.field1813 == 2) {
            var5 = var4.field1805 - field1734 + 25;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.field1807 - field1733 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1804 - field1733 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               var13 = false;

               while(var6 <= var7) {
                  if(field1768[var6++][var5]) {
                     var13 = true;
                     break;
                  }
               }

               if(var13) {
                  var9 = field1742 - var4.field1822;
                  if(var9 > 32) {
                     var4.field1806 = 3;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field1806 = 4;
                     var9 = -var9;
                  }

                  var4.field1815 = (var4.field1809 - field1769 << 8) / var9;
                  var4.field1816 = (var4.field1821 - field1769 << 8) / var9;
                  var4.field1803 = (var4.field1812 - field1736 << 8) / var9;
                  var4.field1810 = (var4.field1808 - field1736 << 8) / var9;
                  field1756[field1770++] = var4;
               }
            }
         } else if(var4.field1813 == 4) {
            var5 = var4.field1812 - field1736;
            if(var5 > 128) {
               var6 = var4.field1805 - field1734 + 25;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.field1820 - field1734 + 25;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var8 = var4.field1807 - field1733 + 25;
                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var9 = var4.field1804 - field1733 + 25;
                  if(var9 > 50) {
                     var9 = 50;
                  }

                  boolean var10 = false;

                  label145:
                  for(int var11 = var8; var11 <= var9; var11++) {
                     for(int var12 = var6; var12 <= var7; var12++) {
                        if(field1768[var11][var12]) {
                           var10 = true;
                           break label145;
                        }
                     }
                  }

                  if(var10) {
                     var4.field1806 = 5;
                     var4.field1815 = (var4.field1809 - field1769 << 8) / var5;
                     var4.field1816 = (var4.field1821 - field1769 << 8) / var5;
                     var4.field1817 = (var4.field1822 - field1742 << 8) / var5;
                     var4.field1818 = (var4.field1811 - field1742 << 8) / var5;
                     field1756[field1770++] = var4;
                  }
               }
            }
         }
      }

   }

   public class128 method2894(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      return var4 == null ? null : var4.field1559;
   }

   public class133 method2895(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      return var4 == null ? null : var4.field1560;
   }

   void method2914(class118 var1, boolean var2) {
      field1757.method4073(var1);

      while(true) {
         class118 var3;
         int var4;
         int var5;
         int var6;
         int var7;
         class118[][] var8;
         class118 var9;
         int var11;
         int var14;
         int var15;
         int var16;
         int var24;
         int var25;
         do {
            do {
               do {
                  do {
                     do {
                        do {
                           while(true) {
                              class128 var10;
                              class134 var12;
                              int var17;
                              int var18;
                              boolean var20;
                              int var21;
                              class118 var36;
                              while(true) {
                                 do {
                                    var3 = (class118)field1757.method4076();
                                    if(var3 == null) {
                                       return;
                                    }
                                 } while(!var3.field1569);

                                 var4 = var3.field1554;
                                 var5 = var3.field1555;
                                 var6 = var3.field1573;
                                 var7 = var3.field1556;
                                 var8 = this.field1728[var6];
                                 if(!var3.field1568) {
                                    break;
                                 }

                                 if(var2) {
                                    if(var6 > 0) {
                                       var9 = this.field1728[var6 - 1][var4][var5];
                                       if(var9 != null && var9.field1569) {
                                          continue;
                                       }
                                    }

                                    if(var4 <= field1733 && var4 > field1729) {
                                       var9 = var8[var4 - 1][var5];
                                       if(var9 != null && var9.field1569 && (var9.field1568 || (var3.field1566 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var4 >= field1733 && var4 < field1730 - 1) {
                                       var9 = var8[var4 + 1][var5];
                                       if(var9 != null && var9.field1569 && (var9.field1568 || (var3.field1566 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 <= field1734 && var5 > field1731) {
                                       var9 = var8[var4][var5 - 1];
                                       if(var9 != null && var9.field1569 && (var9.field1568 || (var3.field1566 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if(var5 >= field1734 && var5 < field1732 - 1) {
                                       var9 = var8[var4][var5 + 1];
                                       if(var9 != null && var9.field1569 && (var9.field1568 || (var3.field1566 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    var2 = true;
                                 }

                                 var3.field1568 = false;
                                 if(var3.field1575 != null) {
                                    var9 = var3.field1575;
                                    if(var9.field1561 != null) {
                                       if(!this.method2871(0, var4, var5)) {
                                          this.method2940(var9.field1561, 0, field1759, field1737, field1740, field1771, var4, var5);
                                       }
                                    } else if(var9.field1558 != null && !this.method2871(0, var4, var5)) {
                                       this.method2916(var9.field1558, field1759, field1737, field1740, field1771, var4, var5);
                                    }

                                    var10 = var9.field1559;
                                    if(var10 != null) {
                                       var10.field1787.vmethod3063(0, field1759, field1737, field1740, field1771, var10.field1792 - field1769, var10.field1784 - field1736, var10.field1783 - field1742, var10.field1786);
                                    }

                                    for(var11 = 0; var11 < var9.field1564; var11++) {
                                       var12 = var9.field1562[var11];
                                       if(var12 != null) {
                                          var12.field1844.vmethod3063(var12.field1845, field1759, field1737, field1740, field1771, var12.field1838 - field1769, var12.field1837 - field1736, var12.field1839 - field1742, var12.field1848);
                                       }
                                    }
                                 }

                                 var20 = false;
                                 if(var3.field1561 != null) {
                                    if(!this.method2871(var7, var4, var5)) {
                                       var20 = true;
                                       if(var3.field1561.field1696 != 12345678 || field1743 && var6 <= field1744) {
                                          this.method2940(var3.field1561, var7, field1759, field1737, field1740, field1771, var4, var5);
                                       }
                                    }
                                 } else if(var3.field1558 != null && !this.method2871(var7, var4, var5)) {
                                    var20 = true;
                                    this.method2916(var3.field1558, field1759, field1737, field1740, field1771, var4, var5);
                                 }

                                 var21 = 0;
                                 var11 = 0;
                                 class128 var31 = var3.field1559;
                                 class133 var13 = var3.field1560;
                                 if(var31 != null || var13 != null) {
                                    if(var4 == field1733) {
                                       ++var21;
                                    } else if(field1733 < var4) {
                                       var21 += 2;
                                    }

                                    if(var5 == field1734) {
                                       var21 += 3;
                                    } else if(field1734 > var5) {
                                       var21 += 6;
                                    }

                                    var11 = field1758[var21];
                                    var3.field1565 = field1766[var21];
                                 }

                                 if(var31 != null) {
                                    if((var31.field1785 & field1723[var21]) != 0) {
                                       if(var31.field1785 == 16) {
                                          var3.field1571 = 3;
                                          var3.field1570 = field1714[var21];
                                          var3.field1574 = 3 - var3.field1570;
                                       } else if(var31.field1785 == 32) {
                                          var3.field1571 = 6;
                                          var3.field1570 = field1762[var21];
                                          var3.field1574 = 6 - var3.field1570;
                                       } else if(var31.field1785 == 64) {
                                          var3.field1571 = 12;
                                          var3.field1570 = field1767[var21];
                                          var3.field1574 = 12 - var3.field1570;
                                       } else {
                                          var3.field1571 = 9;
                                          var3.field1570 = field1764[var21];
                                          var3.field1574 = 9 - var3.field1570;
                                       }
                                    } else {
                                       var3.field1571 = 0;
                                    }

                                    if((var31.field1785 & var11) != 0 && !this.method3042(var7, var4, var5, var31.field1785)) {
                                       var31.field1787.vmethod3063(0, field1759, field1737, field1740, field1771, var31.field1792 - field1769, var31.field1784 - field1736, var31.field1783 - field1742, var31.field1786);
                                    }

                                    if((var31.field1789 & var11) != 0 && !this.method3042(var7, var4, var5, var31.field1789)) {
                                       var31.field1788.vmethod3063(0, field1759, field1737, field1740, field1771, var31.field1792 - field1769, var31.field1784 - field1736, var31.field1783 - field1742, var31.field1786);
                                    }
                                 }

                                 if(var13 != null && !this.method2885(var7, var4, var5, var13.field1823.field1781)) {
                                    if((var13.field1826 & var11) != 0) {
                                       var13.field1823.vmethod3063(0, field1759, field1737, field1740, field1771, var13.field1828 - field1769 + var13.field1830, var13.field1832 - field1736, var13.field1825 - field1742 + var13.field1829, var13.field1824);
                                    } else if(var13.field1826 == 256) {
                                       var14 = var13.field1828 - field1769;
                                       var15 = var13.field1832 - field1736;
                                       var16 = var13.field1825 - field1742;
                                       var17 = var13.field1827;
                                       if(var17 != 1 && var17 != 2) {
                                          var18 = var14;
                                       } else {
                                          var18 = -var14;
                                       }

                                       int var19;
                                       if(var17 != 2 && var17 != 3) {
                                          var19 = var16;
                                       } else {
                                          var19 = -var16;
                                       }

                                       if(var19 < var18) {
                                          var13.field1823.vmethod3063(0, field1759, field1737, field1740, field1771, var14 + var13.field1830, var15, var16 + var13.field1829, var13.field1824);
                                       } else if(var13.field1831 != null) {
                                          var13.field1831.vmethod3063(0, field1759, field1737, field1740, field1771, var14, var15, var16, var13.field1824);
                                       }
                                    }
                                 }

                                 if(var20) {
                                    class115 var22 = var3.field1553;
                                    if(var22 != null) {
                                       var22.field1524.vmethod3063(0, field1759, field1737, field1740, field1771, var22.field1523 - field1769, var22.field1525 - field1736, var22.field1521 - field1742, var22.field1526);
                                    }

                                    class112 var23 = var3.field1572;
                                    if(var23 != null && var23.field1454 == 0) {
                                       if(var23.field1451 != null) {
                                          var23.field1451.vmethod3063(0, field1759, field1737, field1740, field1771, var23.field1448 - field1769, var23.field1450 - field1736, var23.field1449 - field1742, var23.field1456);
                                       }

                                       if(var23.field1452 != null) {
                                          var23.field1452.vmethod3063(0, field1759, field1737, field1740, field1771, var23.field1448 - field1769, var23.field1450 - field1736, var23.field1449 - field1742, var23.field1456);
                                       }

                                       if(var23.field1447 != null) {
                                          var23.field1447.vmethod3063(0, field1759, field1737, field1740, field1771, var23.field1448 - field1769, var23.field1450 - field1736, var23.field1449 - field1742, var23.field1456);
                                       }
                                    }
                                 }

                                 var14 = var3.field1566;
                                 if(var14 != 0) {
                                    if(var4 < field1733 && (var14 & 4) != 0) {
                                       var36 = var8[var4 + 1][var5];
                                       if(var36 != null && var36.field1569) {
                                          field1757.method4073(var36);
                                       }
                                    }

                                    if(var5 < field1734 && (var14 & 2) != 0) {
                                       var36 = var8[var4][var5 + 1];
                                       if(var36 != null && var36.field1569) {
                                          field1757.method4073(var36);
                                       }
                                    }

                                    if(var4 > field1733 && (var14 & 1) != 0) {
                                       var36 = var8[var4 - 1][var5];
                                       if(var36 != null && var36.field1569) {
                                          field1757.method4073(var36);
                                       }
                                    }

                                    if(var5 > field1734 && (var14 & 8) != 0) {
                                       var36 = var8[var4][var5 - 1];
                                       if(var36 != null && var36.field1569) {
                                          field1757.method4073(var36);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if(var3.field1571 != 0) {
                                 var20 = true;

                                 for(var21 = 0; var21 < var3.field1564; var21++) {
                                    if(var3.field1562[var21].field1847 != field1765 && (var3.field1557[var21] & var3.field1571) == var3.field1570) {
                                       var20 = false;
                                       break;
                                    }
                                 }

                                 if(var20) {
                                    var10 = var3.field1559;
                                    if(!this.method3042(var7, var4, var5, var10.field1785)) {
                                       var10.field1787.vmethod3063(0, field1759, field1737, field1740, field1771, var10.field1792 - field1769, var10.field1784 - field1736, var10.field1783 - field1742, var10.field1786);
                                    }

                                    var3.field1571 = 0;
                                 }
                              }

                              if(!var3.field1563) {
                                 break;
                              }

                              try {
                                 int var34 = var3.field1564;
                                 var3.field1563 = false;
                                 var21 = 0;

                                 label563:
                                 for(var11 = 0; var11 < var34; var11++) {
                                    var12 = var3.field1562[var11];
                                    if(var12.field1847 != field1765) {
                                       for(var24 = var12.field1842; var24 <= var12.field1843; var24++) {
                                          for(var14 = var12.field1840; var14 <= var12.field1850; var14++) {
                                             var36 = var8[var24][var14];
                                             if(var36.field1568) {
                                                var3.field1563 = true;
                                                continue label563;
                                             }

                                             if(var36.field1571 != 0) {
                                                var16 = 0;
                                                if(var24 > var12.field1842) {
                                                   ++var16;
                                                }

                                                if(var24 < var12.field1843) {
                                                   var16 += 4;
                                                }

                                                if(var14 > var12.field1840) {
                                                   var16 += 8;
                                                }

                                                if(var14 < var12.field1850) {
                                                   var16 += 2;
                                                }

                                                if((var16 & var36.field1571) == var3.field1574) {
                                                   var3.field1563 = true;
                                                   continue label563;
                                                }
                                             }
                                          }
                                       }

                                       field1748[var21++] = var12;
                                       var24 = field1733 - var12.field1842;
                                       var14 = var12.field1843 - field1733;
                                       if(var14 > var24) {
                                          var24 = var14;
                                       }

                                       var15 = field1734 - var12.field1840;
                                       var16 = var12.field1850 - field1734;
                                       if(var16 > var15) {
                                          var12.field1846 = var24 + var16;
                                       } else {
                                          var12.field1846 = var24 + var15;
                                       }
                                    }
                                 }

                                 while(var21 > 0) {
                                    var11 = -50;
                                    var25 = -1;

                                    for(var24 = 0; var24 < var21; var24++) {
                                       class134 var35 = field1748[var24];
                                       if(var35.field1847 != field1765) {
                                          if(var35.field1846 > var11) {
                                             var11 = var35.field1846;
                                             var25 = var24;
                                          } else if(var11 == var35.field1846) {
                                             var15 = var35.field1838 - field1769;
                                             var16 = var35.field1839 - field1742;
                                             var17 = field1748[var25].field1838 - field1769;
                                             var18 = field1748[var25].field1839 - field1742;
                                             if(var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
                                                var25 = var24;
                                             }
                                          }
                                       }
                                    }

                                    if(var25 == -1) {
                                       break;
                                    }

                                    class134 var33 = field1748[var25];
                                    var33.field1847 = field1765;
                                    if(!this.method2923(var7, var33.field1842, var33.field1843, var33.field1840, var33.field1850, var33.field1844.field1781)) {
                                       var33.field1844.vmethod3063(var33.field1845, field1759, field1737, field1740, field1771, var33.field1838 - field1769, var33.field1837 - field1736, var33.field1839 - field1742, var33.field1848);
                                    }

                                    for(var14 = var33.field1842; var14 <= var33.field1843; var14++) {
                                       for(var15 = var33.field1840; var15 <= var33.field1850; var15++) {
                                          class118 var26 = var8[var14][var15];
                                          if(var26.field1571 != 0) {
                                             field1757.method4073(var26);
                                          } else if((var14 != var4 || var15 != var5) && var26.field1569) {
                                             field1757.method4073(var26);
                                          }
                                       }
                                    }
                                 }

                                 if(!var3.field1563) {
                                    break;
                                 }
                              } catch (Exception var28) {
                                 var3.field1563 = false;
                                 break;
                              }
                           }
                        } while(!var3.field1569);
                     } while(var3.field1571 != 0);

                     if(var4 > field1733 || var4 <= field1729) {
                        break;
                     }

                     var9 = var8[var4 - 1][var5];
                  } while(var9 != null && var9.field1569);

                  if(var4 < field1733 || var4 >= field1730 - 1) {
                     break;
                  }

                  var9 = var8[var4 + 1][var5];
               } while(var9 != null && var9.field1569);

               if(var5 > field1734 || var5 <= field1731) {
                  break;
               }

               var9 = var8[var4][var5 - 1];
            } while(var9 != null && var9.field1569);

            if(var5 < field1734 || var5 >= field1732 - 1) {
               break;
            }

            var9 = var8[var4][var5 + 1];
         } while(var9 != null && var9.field1569);

         var3.field1569 = false;
         --field1726;
         class112 var32 = var3.field1572;
         if(var32 != null && var32.field1454 != 0) {
            if(var32.field1451 != null) {
               var32.field1451.vmethod3063(0, field1759, field1737, field1740, field1771, var32.field1448 - field1769, var32.field1450 - field1736 - var32.field1454, var32.field1449 - field1742, var32.field1456);
            }

            if(var32.field1452 != null) {
               var32.field1452.vmethod3063(0, field1759, field1737, field1740, field1771, var32.field1448 - field1769, var32.field1450 - field1736 - var32.field1454, var32.field1449 - field1742, var32.field1456);
            }

            if(var32.field1447 != null) {
               var32.field1447.vmethod3063(0, field1759, field1737, field1740, field1771, var32.field1448 - field1769, var32.field1450 - field1736 - var32.field1454, var32.field1449 - field1742, var32.field1456);
            }
         }

         if(var3.field1565 != 0) {
            class133 var29 = var3.field1560;
            if(var29 != null && !this.method2885(var7, var4, var5, var29.field1823.field1781)) {
               if((var29.field1826 & var3.field1565) != 0) {
                  var29.field1823.vmethod3063(0, field1759, field1737, field1740, field1771, var29.field1828 - field1769 + var29.field1830, var29.field1832 - field1736, var29.field1825 - field1742 + var29.field1829, var29.field1824);
               } else if(var29.field1826 == 256) {
                  var11 = var29.field1828 - field1769;
                  var25 = var29.field1832 - field1736;
                  var24 = var29.field1825 - field1742;
                  var14 = var29.field1827;
                  if(var14 != 1 && var14 != 2) {
                     var15 = var11;
                  } else {
                     var15 = -var11;
                  }

                  if(var14 != 2 && var14 != 3) {
                     var16 = var24;
                  } else {
                     var16 = -var24;
                  }

                  if(var16 >= var15) {
                     var29.field1823.vmethod3063(0, field1759, field1737, field1740, field1771, var11 + var29.field1830, var25, var24 + var29.field1829, var29.field1824);
                  } else if(var29.field1831 != null) {
                     var29.field1831.vmethod3063(0, field1759, field1737, field1740, field1771, var11, var25, var24, var29.field1824);
                  }
               }
            }

            class128 var27 = var3.field1559;
            if(var27 != null) {
               if((var27.field1789 & var3.field1565) != 0 && !this.method3042(var7, var4, var5, var27.field1789)) {
                  var27.field1788.vmethod3063(0, field1759, field1737, field1740, field1771, var27.field1792 - field1769, var27.field1784 - field1736, var27.field1783 - field1742, var27.field1786);
               }

               if((var27.field1785 & var3.field1565) != 0 && !this.method3042(var7, var4, var5, var27.field1785)) {
                  var27.field1787.vmethod3063(0, field1759, field1737, field1740, field1771, var27.field1792 - field1769, var27.field1784 - field1736, var27.field1783 - field1742, var27.field1786);
               }
            }
         }

         class118 var30;
         if(var6 < this.field1713 - 1) {
            var30 = this.field1728[var6 + 1][var4][var5];
            if(var30 != null && var30.field1569) {
               field1757.method4073(var30);
            }
         }

         if(var4 < field1733) {
            var30 = var8[var4 + 1][var5];
            if(var30 != null && var30.field1569) {
               field1757.method4073(var30);
            }
         }

         if(var5 < field1734) {
            var30 = var8[var4][var5 + 1];
            if(var30 != null && var30.field1569) {
               field1757.method4073(var30);
            }
         }

         if(var4 > field1733) {
            var30 = var8[var4 - 1][var5];
            if(var30 != null && var30.field1569) {
               field1757.method4073(var30);
            }
         }

         if(var5 > field1734) {
            var30 = var8[var4][var5 - 1];
            if(var30 != null && var30.field1569) {
               field1757.method4073(var30);
            }
         }
      }
   }

   public class134 method2896(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.field1564; var5++) {
            class134 var6 = var4.field1562[var5];
            long var8 = var6.field1848;
            int var10 = (int)(var8 >>> 14 & 3L);
            boolean var7 = var10 == 2;
            if(var7 && var2 == var6.field1842 && var3 == var6.field1840) {
               return var6;
            }
         }

         return null;
      }
   }

   public class115 method2953(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      return var4 != null && var4.field1553 != null ? var4.field1553 : null;
   }

   public void method2906(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      class118 var7 = this.field1728[var4][var5][var6];
      if(var7 != null) {
         class123 var8 = var7.field1561;
         int var10;
         if(var8 != null) {
            int var9 = var8.field1700;
            if(var9 != 0) {
               for(var10 = 0; var10 < 4; var10++) {
                  var1[var2] = var9;
                  var1[var2 + 1] = var9;
                  var1[var2 + 2] = var9;
                  var1[var2 + 3] = var9;
                  var2 += var3;
               }

            }
         } else {
            class114 var18 = var7.field1558;
            if(var18 != null) {
               var10 = var18.field1510;
               int var11 = var18.field1511;
               int var12 = var18.field1509;
               int var13 = var18.field1502;
               int[] var14 = this.field1763[var10];
               int[] var15 = this.field1741[var11];
               int var16 = 0;
               int var17;
               if(var12 != 0) {
                  for(var17 = 0; var17 < 4; var17++) {
                     var1[var2] = var14[var15[var16++]] == 0 ? var12 : var13;
                     var1[var2 + 1] = var14[var15[var16++]] == 0 ? var12 : var13;
                     var1[var2 + 2] = var14[var15[var16++]] == 0 ? var12 : var13;
                     var1[var2 + 3] = var14[var15[var16++]] == 0 ? var12 : var13;
                     var2 += var3;
                  }
               } else {
                  for(var17 = 0; var17 < 4; var17++) {
                     if(var14[var15[var16++]] != 0) {
                        var1[var2] = var13;
                     }

                     if(var14[var15[var16++]] != 0) {
                        var1[var2 + 1] = var13;
                     }

                     if(var14[var15[var16++]] != 0) {
                        var1[var2 + 2] = var13;
                     }

                     if(var14[var15[var16++]] != 0) {
                        var1[var2 + 3] = var13;
                     }

                     var2 += var3;
                  }
               }

            }
         }
      }
   }

   public long method2898(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      return var4 != null && var4.field1559 != null ? var4.field1559.field1786 : 0L;
   }

   public long method2899(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      return var4 != null && var4.field1560 != null ? var4.field1560.field1824 : 0L;
   }

   public void method2877(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      if(var4 != null) {
         var4.field1572 = null;
      }
   }

   public long method2901(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      return var4 != null && var4.field1553 != null ? var4.field1553.field1526 : 0L;
   }

   public boolean method2883(int var1, int var2, int var3, int var4, int var5, class127 var6, int var7, long var8, boolean var10) {
      if(var6 == null) {
         return true;
      } else {
         int var11 = var2 - var5;
         int var12 = var3 - var5;
         int var13 = var5 + var2;
         int var14 = var3 + var5;
         if(var10) {
            if(var7 > 640 && var7 < 1408) {
               var14 += 128;
            }

            if(var7 > 1152 && var7 < 1920) {
               var13 += 128;
            }

            if(var7 > 1664 || var7 < 384) {
               var12 -= 128;
            }

            if(var7 > 128 && var7 < 896) {
               var11 -= 128;
            }
         }

         var11 /= 128;
         var12 /= 128;
         var13 /= 128;
         var14 /= 128;
         return this.method2913(var1, var11, var12, var13 - var11 + 1, var14 - var12 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   public long method2900(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      if(var4 == null) {
         return 0L;
      } else {
         for(int var5 = 0; var5 < var4.field1564; var5++) {
            class134 var6 = var4.field1562[var5];
            long var8 = var6.field1848;
            int var10 = (int)(var8 >>> 14 & 3L);
            boolean var7 = var10 == 2;
            if(var7 && var2 == var6.field1842 && var3 == var6.field1840) {
               return var6.field1848;
            }
         }

         return 0L;
      }
   }

   public int method2902(int var1, int var2, int var3, long var4) {
      class118 var6 = this.field1728[var1][var2][var3];
      if(var6 == null) {
         return -1;
      } else if(var6.field1559 != null && var6.field1559.field1786 == var4) {
         return var6.field1559.field1790 & 255;
      } else if(var6.field1560 != null && var6.field1560.field1824 == var4) {
         return var6.field1560.field1833 & 255;
      } else if(var6.field1553 != null && var6.field1553.field1526 == var4) {
         return var6.field1553.field1522 & 255;
      } else {
         for(int var7 = 0; var7 < var6.field1564; var7++) {
            if(var6.field1562[var7].field1848 == var4) {
               return var6.field1562[var7].field1849 & 255;
            }
         }

         return -1;
      }
   }

   public void method2879(int var1, int var2, int var3, int var4, class127 var5, long var6, class127 var8, class127 var9) {
      class112 var10 = new class112();
      var10.field1447 = var5;
      var10.field1448 = var2 * 128 + 64;
      var10.field1449 = var3 * 128 + 64;
      var10.field1450 = var4;
      var10.field1456 = var6;
      var10.field1451 = var8;
      var10.field1452 = var9;
      int var11 = 0;
      class118 var12 = this.field1728[var1][var2][var3];
      if(var12 != null) {
         for(int var13 = 0; var13 < var12.field1564; var13++) {
            if((var12.field1562[var13].field1849 & 256) == 256 && var12.field1562[var13].field1844 instanceof class119) {
               class119 var14 = (class119)var12.field1562[var13].field1844;
               var14.method2670();
               if(var14.field1781 > var11) {
                  var11 = var14.field1781;
               }
            }
         }
      }

      var10.field1454 = var11;
      if(this.field1728[var1][var2][var3] == null) {
         this.field1728[var1][var2][var3] = new class118(var1, var2, var3);
      }

      this.field1728[var1][var2][var3].field1572 = var10;
   }

   public void method2889(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      if(var4 != null) {
         var4.field1559 = null;
      }
   }

   public void method2890(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      if(var4 != null) {
         var4.field1560 = null;
      }
   }

   public void method2891(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.field1564; var5++) {
            class134 var6 = var4.field1562[var5];
            long var8 = var6.field1848;
            int var10 = (int)(var8 >>> 14 & 3L);
            boolean var7 = var10 == 2;
            if(var7 && var2 == var6.field1842 && var3 == var6.field1840) {
               this.method2887(var6);
               return;
            }
         }

      }
   }

   public boolean method3010(int var1, int var2, int var3, int var4, int var5, class127 var6, int var7, long var8, int var10, int var11, int var12, int var13) {
      return var6 == null ? true : this.method2913(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   public void method2971(int var1, int var2, int var3) {
      class118 var4 = this.field1728[var1][var2][var3];
      if(var4 != null) {
         var4.field1553 = null;
      }
   }

   public void method2912(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= this.field1738 * 128) {
         var1 = this.field1738 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= this.field1715 * 128) {
         var3 = this.field1715 * 128 - 1;
      }

      if(var4 < 128) {
         var4 = 128;
      } else if(var4 > 383) {
         var4 = 383;
      }

      ++field1765;
      field1759 = class122.field1681[var4];
      field1737 = class122.field1693[var4];
      field1740 = class122.field1681[var5];
      field1771 = class122.field1693[var5];
      field1768 = field1712[(var4 - 128) / 32][var5 / 64];
      field1769 = var1;
      field1736 = var2;
      field1742 = var3;
      field1733 = var1 / 128;
      field1734 = var3 / 128;
      field1727 = var6;
      field1729 = field1733 - 25;
      if(field1729 < 0) {
         field1729 = 0;
      }

      field1731 = field1734 - 25;
      if(field1731 < 0) {
         field1731 = 0;
      }

      field1730 = field1733 + 25;
      if(field1730 > this.field1738) {
         field1730 = this.field1738;
      }

      field1732 = field1734 + 25;
      if(field1732 > this.field1715) {
         field1732 = this.field1715;
      }

      this.method2919();
      field1726 = 0;

      int var7;
      class118[][] var8;
      int var9;
      int var10;
      for(var7 = this.field1718; var7 < this.field1713; var7++) {
         var8 = this.field1728[var7];

         for(var9 = field1729; var9 < field1730; var9++) {
            for(var10 = field1731; var10 < field1732; var10++) {
               class118 var11 = var8[var9][var10];
               if(var11 != null) {
                  if(var11.field1567 <= var6 && (field1768[var9 - field1733 + 25][var10 - field1734 + 25] || this.field1716[var7][var9][var10] - var2 >= 2000)) {
                     var11.field1568 = true;
                     var11.field1569 = true;
                     if(var11.field1564 > 0) {
                        var11.field1563 = true;
                     } else {
                        var11.field1563 = false;
                     }

                     ++field1726;
                  } else {
                     var11.field1568 = false;
                     var11.field1569 = false;
                     var11.field1571 = 0;
                  }
               }
            }
         }
      }

      int var12;
      int var13;
      int var14;
      class118 var15;
      int var16;
      for(var7 = this.field1718; var7 < this.field1713; var7++) {
         var8 = this.field1728[var7];

         for(var9 = -25; var9 <= 0; var9++) {
            var10 = var9 + field1733;
            var16 = field1733 - var9;
            if(var10 >= field1729 || var16 < field1730) {
               for(var12 = -25; var12 <= 0; var12++) {
                  var13 = var12 + field1734;
                  var14 = field1734 - var12;
                  if(var10 >= field1729) {
                     if(var13 >= field1731) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1568) {
                           this.method2914(var15, true);
                        }
                     }

                     if(var14 < field1732) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1568) {
                           this.method2914(var15, true);
                        }
                     }
                  }

                  if(var16 < field1730) {
                     if(var13 >= field1731) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1568) {
                           this.method2914(var15, true);
                        }
                     }

                     if(var14 < field1732) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1568) {
                           this.method2914(var15, true);
                        }
                     }
                  }

                  if(field1726 == 0) {
                     field1743 = false;
                     return;
                  }
               }
            }
         }
      }

      for(var7 = this.field1718; var7 < this.field1713; var7++) {
         var8 = this.field1728[var7];

         for(var9 = -25; var9 <= 0; var9++) {
            var10 = var9 + field1733;
            var16 = field1733 - var9;
            if(var10 >= field1729 || var16 < field1730) {
               for(var12 = -25; var12 <= 0; var12++) {
                  var13 = var12 + field1734;
                  var14 = field1734 - var12;
                  if(var10 >= field1729) {
                     if(var13 >= field1731) {
                        var15 = var8[var10][var13];
                        if(var15 != null && var15.field1568) {
                           this.method2914(var15, false);
                        }
                     }

                     if(var14 < field1732) {
                        var15 = var8[var10][var14];
                        if(var15 != null && var15.field1568) {
                           this.method2914(var15, false);
                        }
                     }
                  }

                  if(var16 < field1730) {
                     if(var13 >= field1731) {
                        var15 = var8[var16][var13];
                        if(var15 != null && var15.field1568) {
                           this.method2914(var15, false);
                        }
                     }

                     if(var14 < field1732) {
                        var15 = var8[var16][var14];
                        if(var15 != null && var15.field1568) {
                           this.method2914(var15, false);
                        }
                     }
                  }

                  if(field1726 == 0) {
                     field1743 = false;
                     return;
                  }
               }
            }
         }
      }

      field1743 = false;
   }

   public void method3009(int var1, int var2, int var3, int var4, class127 var5, long var6, int var8) {
      if(var5 != null) {
         class115 var9 = new class115();
         var9.field1524 = var5;
         var9.field1523 = var2 * 128 + 64;
         var9.field1521 = var3 * 128 + 64;
         var9.field1525 = var4;
         var9.field1526 = var6;
         var9.field1522 = var8;
         if(this.field1728[var1][var2][var3] == null) {
            this.field1728[var1][var2][var3] = new class118(var1, var2, var3);
         }

         this.field1728[var1][var2][var3].field1553 = var9;
      }
   }

   public void method3017() {
      for(int var1 = 0; var1 < this.field1719; var1++) {
         class134 var2 = this.field1720[var1];
         this.method2887(var2);
         this.field1720[var1] = null;
      }

      this.field1719 = 0;
   }

   public boolean method2882(int var1, int var2, int var3, int var4, int var5, int var6, class127 var7, int var8, long var9, int var11) {
      if(var7 == null) {
         return true;
      } else {
         int var12 = var5 * 64 + var2 * 128;
         int var13 = var6 * 64 + var3 * 128;
         return this.method2913(var1, var2, var3, var5, var6, var12, var13, var4, var7, var8, false, var9, var11);
      }
   }

   public void method2927(int var1, int var2, int var3, int var4, class127 var5, class127 var6, int var7, int var8, long var9, int var11) {
      if(var5 != null || var6 != null) {
         class128 var12 = new class128();
         var12.field1786 = var9;
         var12.field1790 = var11;
         var12.field1792 = var2 * 128 + 64;
         var12.field1783 = var3 * 128 + 64;
         var12.field1784 = var4;
         var12.field1787 = var5;
         var12.field1788 = var6;
         var12.field1785 = var7;
         var12.field1789 = var8;

         for(int var13 = var1; var13 >= 0; --var13) {
            if(this.field1728[var13][var2][var3] == null) {
               this.field1728[var13][var2][var3] = new class118(var13, var2, var3);
            }
         }

         this.field1728[var1][var2][var3].field1559 = var12;
      }
   }

   public void method2881(int var1, int var2, int var3, int var4, class127 var5, class127 var6, int var7, int var8, int var9, int var10, long var11, int var13) {
      if(var5 != null) {
         class133 var14 = new class133();
         var14.field1824 = var11;
         var14.field1833 = var13;
         var14.field1828 = var2 * 128 + 64;
         var14.field1825 = var3 * 128 + 64;
         var14.field1832 = var4;
         var14.field1823 = var5;
         var14.field1831 = var6;
         var14.field1826 = var7;
         var14.field1827 = var8;
         var14.field1830 = var9;
         var14.field1829 = var10;

         for(int var15 = var1; var15 >= 0; --var15) {
            if(this.field1728[var15][var2][var3] == null) {
               this.field1728[var15][var2][var3] = new class118(var15, var2, var3);
            }
         }

         this.field1728[var1][var2][var3].field1560 = var14;
      }
   }

   public void method3038(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1713; var4++) {
         for(int var5 = 0; var5 < this.field1738; var5++) {
            for(int var6 = 0; var6 < this.field1715; var6++) {
               class118 var7 = this.field1728[var4][var5][var6];
               if(var7 != null) {
                  class128 var8 = var7.field1559;
                  class113 var10;
                  if(var8 != null && var8.field1787 instanceof class113) {
                     class113 var9 = (class113)var8.field1787;
                     this.method2905(var9, var4, var5, var6, 1, 1);
                     if(var8.field1788 instanceof class113) {
                        var10 = (class113)var8.field1788;
                        this.method2905(var10, var4, var5, var6, 1, 1);
                        class113.method2588(var9, var10, 0, 0, 0, false);
                        var8.field1788 = var10.method2589(var10.field1486, var10.field1487, var1, var2, var3);
                     }

                     var8.field1787 = var9.method2589(var9.field1486, var9.field1487, var1, var2, var3);
                  }

                  for(int var12 = 0; var12 < var7.field1564; var12++) {
                     class134 var14 = var7.field1562[var12];
                     if(var14 != null && var14.field1844 instanceof class113) {
                        class113 var11 = (class113)var14.field1844;
                        this.method2905(var11, var4, var5, var6, var14.field1843 - var14.field1842 + 1, var14.field1850 - var14.field1840 + 1);
                        var14.field1844 = var11.method2589(var11.field1486, var11.field1487, var1, var2, var3);
                     }
                  }

                  class115 var13 = var7.field1553;
                  if(var13 != null && var13.field1524 instanceof class113) {
                     var10 = (class113)var13.field1524;
                     this.method2981(var10, var4, var5, var6);
                     var13.field1524 = var10.method2589(var10.field1486, var10.field1487, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   public void method3041(int var1, int var2) {
      class118 var3 = this.field1728[0][var1][var2];

      for(int var4 = 0; var4 < 3; var4++) {
         class118 var5 = this.field1728[var4][var1][var2] = this.field1728[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.field1573;

            for(int var6 = 0; var6 < var5.field1564; var6++) {
               class134 var7 = var5.field1562[var6];
               long var9 = var7.field1848;
               int var11 = (int)(var9 >>> 14 & 3L);
               boolean var8 = var11 == 2;
               if(var8 && var7.field1842 == var1 && var2 == var7.field1840) {
                  --var7.field1841;
               }
            }
         }
      }

      if(this.field1728[0][var1][var2] == null) {
         this.field1728[0][var1][var2] = new class118(0, var1, var2);
      }

      this.field1728[0][var1][var2].field1575 = var3;
      this.field1728[3][var1][var2] = null;
   }

   public void method2876(int var1, int var2, int var3, int var4) {
      class118 var5 = this.field1728[var1][var2][var3];
      if(var5 != null) {
         this.field1728[var1][var2][var3].field1567 = var4;
      }
   }

   public void method2904(int var1) {
      this.field1718 = var1;

      for(int var2 = 0; var2 < this.field1738; var2++) {
         for(int var3 = 0; var3 < this.field1715; var3++) {
            if(this.field1728[var1][var2][var3] == null) {
               this.field1728[var1][var2][var3] = new class118(var1, var2, var3);
            }
         }
      }

   }

   public void method3053(int var1, int var2, int var3, int var4) {
      class118 var5 = this.field1728[var1][var2][var3];
      if(var5 != null) {
         class133 var6 = var5.field1560;
         if(var6 != null) {
            var6.field1830 = var4 * var6.field1830 / 16;
            var6.field1829 = var4 * var6.field1829 / 16;
         }
      }
   }

   public void method3000(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      class123 var21;
      int var22;
      if(var4 == 0) {
         var21 = new class123(var11, var12, var13, var14, -1, var19, false);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.field1728[var22][var2][var3] == null) {
               this.field1728[var22][var2][var3] = new class118(var22, var2, var3);
            }
         }

         this.field1728[var1][var2][var3].field1561 = var21;
      } else if(var4 != 1) {
         class114 var23 = new class114(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.field1728[var22][var2][var3] == null) {
               this.field1728[var22][var2][var3] = new class118(var22, var2, var3);
            }
         }

         this.field1728[var1][var2][var3].field1558 = var23;
      } else {
         var21 = new class123(var15, var16, var17, var18, var6, var20, var8 == var7 && var7 == var9 && var10 == var7);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.field1728[var22][var2][var3] == null) {
               this.field1728[var22][var2][var3] = new class118(var22, var2, var3);
            }
         }

         this.field1728[var1][var2][var3].field1561 = var21;
      }
   }

   public void method2974() {
      field1749 = true;
   }

   public static boolean method2911() {
      return field1749 && field1772 != -1;
   }

   static boolean method2918(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 < var2 && var1 < var3 && var1 < var4) {
         return false;
      } else if(var1 > var2 && var1 > var3 && var1 > var4) {
         return false;
      } else if(var0 < var5 && var0 < var6 && var0 < var7) {
         return false;
      } else if(var0 > var5 && var0 > var6 && var0 > var7) {
         return false;
      } else {
         int var8 = (var1 - var2) * (var6 - var5) - (var0 - var5) * (var3 - var2);
         int var9 = (var7 - var6) * (var1 - var3) - (var0 - var6) * (var4 - var3);
         int var10 = (var5 - var7) * (var1 - var4) - (var2 - var4) * (var0 - var7);
         return var8 == 0 ? (var9 != 0 ? (var9 < 0 ? var10 <= 0 : var10 >= 0) : true) : (var8 < 0 ? var9 <= 0 && var10 <= 0 : var9 >= 0 && var10 >= 0);
      }
   }

   static final int method2961(int var0, int var1) {
      var1 = (var0 & 127) * var1 >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 65408) + var1;
   }

   public static void method2893(int[] var0, int var1, int var2, int var3, int var4) {
      field1755 = 0;
      field1761 = 0;
      field1773 = var3;
      field1774 = var4;
      field1717 = var3 / 2;
      field1735 = var4 / 2;
      boolean[][][][] var5 = new boolean[9][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      for(var6 = 128; var6 <= 384; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            field1759 = class122.field1681[var6];
            field1737 = class122.field1693[var6];
            field1740 = class122.field1681[var7];
            field1771 = class122.field1693[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var10 = -26; var10 <= 26; var10++) {
               for(var11 = -26; var11 <= 26; var11++) {
                  var12 = var10 * 128;
                  int var13 = var11 * 128;
                  boolean var14 = false;

                  for(int var15 = -var1; var15 <= var2; var15 += 128) {
                     if(method2908(var12, var0[var8] + var15, var13)) {
                        var14 = true;
                        break;
                     }
                  }

                  var5[var8][var9][var10 + 1 + 25][var11 + 1 + 25] = var14;
               }
            }
         }
      }

      for(var6 = 0; var6 < 8; var6++) {
         for(var7 = 0; var7 < 32; var7++) {
            for(var8 = -25; var8 < 25; var8++) {
               for(var9 = -25; var9 < 25; var9++) {
                  boolean var16 = false;

                  label76:
                  for(var11 = -1; var11 <= 1; var11++) {
                     for(var12 = -1; var12 <= 1; var12++) {
                        if(var5[var6][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                           var16 = true;
                           break label76;
                        }

                        if(var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                           var16 = true;
                           break label76;
                        }
                     }
                  }

                  field1712[var6][var7][var8 + 25][var9 + 25] = var16;
               }
            }
         }
      }

   }

   static boolean method2908(int var0, int var1, int var2) {
      int var3 = var0 * field1771 + var2 * field1740 >> 16;
      int var4 = var2 * field1771 - var0 * field1740 >> 16;
      int var5 = var4 * field1737 + field1759 * var1 >> 16;
      int var6 = field1737 * var1 - var4 * field1759 >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = var3 * 390 / var5 + field1717;
         int var8 = var6 * 390 / var5 + field1735;
         return var7 >= field1755 && var7 <= field1773 && var8 >= field1761 && var8 <= field1774;
      } else {
         return false;
      }
   }

   public static void method2972() {
      field1772 = -1;
      field1749 = false;
   }

   public static void method2997(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class132 var8 = new class132();
      var8.field1807 = var2 / 128;
      var8.field1804 = var3 / 128;
      var8.field1805 = var4 / 128;
      var8.field1820 = var5 / 128;
      var8.field1813 = var1;
      var8.field1809 = var2;
      var8.field1821 = var3;
      var8.field1822 = var4;
      var8.field1811 = var5;
      var8.field1812 = var6;
      var8.field1808 = var7;
      field1754[var0][field1753[var0]++] = var8;
   }
}
