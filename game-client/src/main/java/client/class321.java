package client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class class321 {
   static final class295 field3832;
   static final class295 field3824;
   static final class295 field3816;
   static final int field3812 = -1;
   static final int field3813 = 8;
   static final float field3814 = 30.0F;
   static final int field3815 = 3;
   static final int field3823 = -65536;
   PaletteSprite[] field3822;
   boolean field3841 = false;
   HashSet field3843 = new HashSet();
   int field3817 = -1;
   int field3857 = 3;
   HashSet field3853 = new HashSet();
   int field3835 = -1;
   int field3836 = -1;
   int field3840 = 50;
   boolean field3854 = false;
   HashSet field3856 = new HashSet();
   class247 field3828;
   HashMap field3834;
   HashSet field3842 = null;
   Iterator field3848;
   class320 field3850;
   int field3858 = -1;
   float field3867;
   Sprite field3865;
   int field3829;
   class20 field3825;
   class20 field3838;
   int field3847 = -1;
   int field3818 = -1;
   class226 field3863 = null;
   int field3830;
   float field3833;
   class30 field3827;
   HashMap field3821;
   int field3837 = -1;
   int field3855 = -1;
   class20 field3826;
   class298 field3820;
   int field3846 = -1;
   int field3819 = -1;
   HashSet field3844 = new HashSet();
   int field3845 = -1;
   int field3866;
   int field3831 = -1;
   int field3869 = -1;
   List field3860;
   int field3811 = -1;
   int field3868 = -1;
   boolean field3852 = true;
   HashSet field3862 = new HashSet();
   final int[] field3859 = new int[]{1008, 1009, 1010, 1011, 1012};
   int field3864;
   int field3851;
   int field3861 = 0;
   long field3849;
   public boolean field3839 = false;

   static {
      field3832 = class295.field3673;
      field3824 = class295.field3670;
      field3816 = class295.field3669;
   }

   public class20 method6116(int var1, int var2, int var3, short var4) {
      Iterator var5 = this.field3834.values().iterator();

      class20 var6;
      do {
         if(!var5.hasNext()) {
            return null;
         }

         var6 = (class20)var5.next();
      } while(!var6.method202(var1, var2, var3, (byte)8));

      return var6;
   }

   boolean method6175(int var1) {
      return this.field3858 != -1 && this.field3818 != -1;
   }

   float method6025(int var1, int var2) {
      return var1 == 25 ? 1.0F : (var1 == 37 ? 1.5F : (var1 == 50 ? 2.0F : (var1 == 75 ? 3.0F : (var1 == 100 ? 4.0F : 8.0F))));
   }

   public class20 method6029(int var1, int var2) {
      Iterator var3 = this.field3834.values().iterator();

      class20 var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (class20)var3.next();
      } while(var4.method207((byte)-125) != var1);

      return var4;
   }

   void method6016(class20 var1, int var2) {
      this.field3825 = var1;
      this.field3827 = new class30(this.field3822, this.field3821);
      this.field3850.method5995(this.field3825.method209(-105361223), -1415895752);
   }

   void method6015(class20 var1, byte var2) {
      if(this.field3825 == null || var1 != this.field3825) {
         this.method6016(var1, 1835547139);
         this.method6058(-1, -1, -1, (byte)1);
      }
   }

   public int method6002(int var1) {
      return this.field3825 == null ? -1 : this.field3829 + this.field3825.method258(824911099) * 64;
   }

   void method6006(int var1) {
      if(class21.field175 != null) {
         this.field3833 = this.field3867;
      } else {
         if(this.field3833 < this.field3867) {
            if(var1 != -1696035308) {
               return;
            }

            this.field3833 = Math.min(this.field3867, this.field3833 / 30.0F + this.field3833);
         }

         if(this.field3833 > this.field3867) {
            this.field3833 = Math.max(this.field3867, this.field3833 - this.field3833 / 30.0F);
         }

      }
   }

   void method6053(int var1) {
      this.field3856.clear();
      this.field3856.addAll(this.field3853);
      this.field3856.addAll(this.field3844);
   }

   void method6058(int var1, int var2, int var3, byte var4) {
      if(this.field3825 == null) {
         if(var4 == 1) {
            ;
         }
      } else {
         int[] var5 = this.field3825.method213(var1, var2, var3, (byte)-19);
         if(var5 == null) {
            var5 = this.field3825.method213(this.field3825.method218(825438900), this.field3825.method217(-1363563177), this.field3825.method219((byte)-108), (byte)44);
         }

         this.method6135(var5[0] - this.field3825.method258(-162318051) * 64, var5[1] - this.field3825.method247(308300610) * 64, true, -799848352);
         this.field3858 = -1;
         this.field3818 = -1;
         this.field3833 = this.method6025(this.field3825.method212((byte)57), -1588852449);
         this.field3867 = this.field3833;
         this.field3860 = null;
         this.field3848 = null;
         this.field3827.method482((byte)-109);
      }
   }

   public int method6142(byte var1) {
      return this.field3835;
   }

   public int method6035(int var1) {
      return this.field3825 == null ? -1 : this.field3830 + this.field3825.method247(536259415) * 64;
   }

   void method6101(int var1) {
      if(this.method6175(-1656260145)) {
         int var2 = this.field3858 - this.field3829;
         int var3 = this.field3818 - this.field3830;
         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         if(var3 != 0) {
            var3 /= Math.min(8, Math.abs(var3));
         }

         this.method6135(var2 + this.field3829, var3 + this.field3830, true, -2124270970);
         if(this.field3858 == this.field3829) {
            if(var1 >= 1219044407) {
               return;
            }

            if(this.field3818 == this.field3830) {
               this.field3858 = -1;
               this.field3818 = -1;
            }
         }

      }
   }

   final void method6009(int var1) {
      this.field3817 = -1;
      this.field3847 = -1;
      this.field3846 = -1;
      this.field3845 = -1;
   }

   public void method6031(int var1, int var2, byte var3) {
      if(this.field3825 != null) {
         this.method6135(var1 - this.field3825.method258(-137850063) * 64, var2 - this.field3825.method247(-318611784) * 64, true, -1863518880);
         this.field3858 = -1;
         this.field3818 = -1;
      }
   }

   public void method6054(int var1, int var2, byte var3) {
      if(this.field3825 != null && this.field3825.method203(var1, var2, 1006376583)) {
         this.field3858 = var1 - this.field3825.method258(280972279) * 64;
         this.field3818 = var2 - this.field3825.method247(-896996604) * 64;
      }
   }

   void method6036(int var1, int var2, boolean var3, long var4) {
      if(this.field3825 != null) {
         int var6 = (int)((float)this.field3829 + ((float)(var1 - this.field3837) - (float)this.method6142((byte)102) * this.field3833 / 2.0F) / this.field3833);
         int var7 = (int)((float)this.field3830 - ((float)(var2 - this.field3831) - (float)this.method6038(-871007097) * this.field3833 / 2.0F) / this.field3833);
         this.field3863 = this.field3825.method205(var6 + this.field3825.method258(802069238) * 64, var7 + this.field3825.method247(1766029106) * 64, -2056689977);
         if(this.field3863 != null && var3) {
            boolean var8 = GameClient.field747 >= 2;
            if(var8 && class39.field341[82] && class39.field341[81]) {
               class19.method197(this.field3863.field2564, this.field3863.field2565, this.field3863.field2567, false, -185686221);
            } else {
               boolean var9 = true;
               if(this.field3852) {
                  int var10 = var1 - this.field3864;
                  int var11 = var2 - this.field3851;
                  if(var4 - this.field3849 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
                     var9 = false;
                  }
               }

               if(var9) {
                  class172 var12 = class26.method433(OutgoingPacket.field2190, GameClient.field626.field1218, 857551476);
                  var12.field2257.writeIntV1(this.field3863.method4437(2113558337));
                  GameClient.field626.method1980(var12, (byte)1);
                  this.field3849 = 0L;
               }
            }
         }
      } else {
         this.field3863 = null;
      }

   }

   final void method6135(int var1, int var2, boolean var3, int var4) {
      this.field3829 = var1;
      this.field3830 = var2;
      Stream.method3547(604838575);
      if(var3) {
         this.method6009(-2094194839);
      }

   }

   public int method6038(int var1) {
      return this.field3836;
   }

   public class28 method6186(byte var1) {
      return this.field3848 == null ? null : (!this.field3848.hasNext() ? null : (class28)this.field3848.next());
   }

   boolean method6020(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return this.field3865 == null ? true : (this.field3865.width == var1 && this.field3865.height == var2 ? (this.field3827.field276 != this.field3866 ? true : (this.field3869 != GameClient.field650 ? true : (var3 <= 0 && var4 <= 0 ? var3 + var1 < var5 || var2 + var4 < var6 : true))) : true);
   }

   void method6024(int var1, int var2, int var3, int var4, int var5, byte var6) {
      byte var7 = 20;
      int var8 = var3 / 2 + var1;
      int var9 = var4 / 2 + var2 - 18 - var7;
      Rasterizer2D.method5763(var1, var2, var3, var4, -16777216);
      Rasterizer2D.method5734(var8 - 152, var9, 304, 34, -65536);
      Rasterizer2D.method5763(var8 - 150, var9 + 2, var5 * 3, 30, -65536);
      this.field3820.drawStr("Loading...", var8, var7 + var9, -1, -1);
   }

   void method6182(int var1, int var2, int var3, int var4, int var5, int var6, byte var7) {
      if(class21.field175 != null) {
         int var8 = 512 / (this.field3827.field276 * 2);
         int var9 = var3 + 512;
         int var10 = var4 + 512;
         float var11 = 1.0F;
         var9 = (int)((float)var9 / var11);
         var10 = (int)((float)var10 / var11);
         int var12 = this.method6002(1123365905) - var5 / 2 - var8;
         int var13 = this.method6035(1934425663) - var6 / 2 - var8;
         int var14 = var1 - (var8 + var12 - this.field3811) * this.field3827.field276;
         int var15 = var2 - this.field3827.field276 * (var8 - (var13 - this.field3868));
         if(this.method6020(var9, var10, var14, var15, var3, var4, -383028288)) {
            if(this.field3865 != null && this.field3865.width == var9 && this.field3865.height == var10) {
               Arrays.fill(this.field3865.pixels, 0);
            } else {
               this.field3865 = new Sprite(var9, var10);
            }

            this.field3811 = this.method6002(390757286) - var5 / 2 - var8;
            this.field3868 = this.method6035(1934425663) - var6 / 2 - var8;
            this.field3866 = this.field3827.field276;
            class21.field175.method4776(this.field3811, this.field3868, this.field3865, (float)this.field3866 / var11, 2066136906);
            this.field3869 = GameClient.field650;
            var14 = var1 - (var8 + var12 - this.field3811) * this.field3827.field276;
            var15 = var2 - this.field3827.field276 * (var8 - (var13 - this.field3868));
         }

         Rasterizer2D.method5727(var1, var2, var3, var4, 0, 128);
         if(var11 == 1.0F) {
            if(var7 <= 1) {
               return;
            }

            this.field3865.method5861(var14, var15, 192);
         } else {
            this.field3865.method5904(var14, var15, (int)((float)var9 * var11), (int)(var11 * (float)var10), 192);
         }
      }

   }

   public void method6018(int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = new int[4];
      Rasterizer2D.method5722(var7);
      Rasterizer2D.method5720(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method5763(var1, var2, var3, var4, -16777216);
      int var8 = this.field3850.method5988(-2104443590);
      if(var8 < 100) {
         this.method6024(var1, var2, var3, var4, var8, (byte)0);
      } else {
         if(!this.field3827.method513(-2090974664)) {
            this.field3827.method490(this.field3828, this.field3825.method209(950527592), GameClient.field668, (byte)2);
            if(!this.field3827.method513(-2146104930)) {
               return;
            }
         }

         if(this.field3842 != null) {
            ++this.field3819;
            if(this.field3819 % this.field3840 == 0) {
               this.field3819 = 0;
               ++this.field3855;
            }

            if(this.field3855 >= this.field3857 && !this.field3841) {
               this.field3842 = null;
            }
         }

         int var9 = (int)Math.ceil((double)((float)var3 / this.field3833));
         int var10 = (int)Math.ceil((double)((float)var4 / this.field3833));
         this.field3827.method483(this.field3829 - var9 / 2, this.field3830 - var10 / 2, var9 / 2 + this.field3829, var10 / 2 + this.field3830, var1, var2, var3 + var1, var2 + var4, (byte)-102);
         boolean var11;
         if(!this.field3854) {
            var11 = false;
            if(var5 - this.field3861 > 100) {
               if(var6 == 707694847) {
                  return;
               }

               this.field3861 = var5;
               var11 = true;
            }

            this.field3827.method491(this.field3829 - var9 / 2, this.field3830 - var10 / 2, var9 / 2 + this.field3829, var10 / 2 + this.field3830, var1, var2, var3 + var1, var2 + var4, this.field3856, this.field3842, this.field3819, this.field3840, var11, -1738532416);
         }

         this.method6182(var1, var2, var3, var4, var9, var10, (byte)41);
         boolean var10000;
         if(GameClient.field747 >= 2) {
            if(var6 == 707694847) {
               return;
            }

            var10000 = true;
         } else {
            var10000 = false;
         }

         var11 = var10000;
         if(var11 && this.field3839 && this.field3863 != null) {
            if(var6 == 707694847) {
               return;
            }

            this.field3820.method5522("Coord: " + this.field3863, Rasterizer2D.field3765 + 10, Rasterizer2D.field3763 + 20, 16776960, -1);
         }

         this.field3835 = var9;
         this.field3836 = var10;
         this.field3837 = var1;
         this.field3831 = var2;
         Rasterizer2D.method5723(var7);
      }
   }

   public void method6022(int var1, int var2, int var3, int var4, byte var5) {
      if(this.field3850.method5987(-2080111756)) {
         if(!this.field3827.method513(-2099909725)) {
            this.field3827.method490(this.field3828, this.field3825.method209(376692693), GameClient.field668, (byte)2);
            if(!this.field3827.method513(-2059423593)) {
               return;
            }
         }

         this.field3827.method486(var1, var2, var3, var4, this.field3842, this.field3819, this.field3840, 2097379080);
      }
   }

   public void method6013(int var1) {
      class0.method7(-1721619760);
   }

   public int method6094(byte var1) {
      return this.field3828.method4646(this.field3838.method209(1918435279), class29.field262.field255, -1926701525) ? 100 : this.field3828.method4687(this.field3838.method209(1693528849), 17959811);
   }

   public void method6000(class247 var1, class298 var2, HashMap var3, PaletteSprite[] var4, byte var5) {
      this.field3822 = var4;
      this.field3828 = var1;
      this.field3820 = var2;
      this.field3821 = new HashMap();
      this.field3821.put(class12.field70, var3.get(field3832));
      this.field3821.put(class12.field71, var3.get(field3824));
      this.field3821.put(class12.field72, var3.get(field3816));
      this.field3850 = new class320(var1);
      int var6 = this.field3828.method4642(class29.field252.field255, -1276951502);
      int[] var7 = this.field3828.method4668(var6, -1375938733);
      this.field3834 = new HashMap(var7.length);

      for(int var8 = 0; var8 < var7.length; var8++) {
         Stream var9 = new Stream(this.field3828.method4625(var6, var7[var8], 1108667122));
         class20 var10 = new class20();
         var10.method200(var9, var7[var8], 1965636190);
         this.field3834.put(var10.method209(210931606), var10);
         if(var10.method208((byte)-8)) {
            this.field3838 = var10;
         }
      }

      this.method6015(this.field3838, (byte)-118);
      this.field3826 = null;
   }

   public void method6011(int var1, int var2, int var3, boolean var4, int var5) {
      class20 var6 = this.method6116(var1, var2, var3, (short)-9559);
      if(var6 == null) {
         if(!var4) {
            return;
         }

         var6 = this.field3838;
      }

      boolean var7 = false;
      if(var6 != this.field3826 || var4) {
         this.field3826 = var6;
         this.method6015(var6, (byte)-118);
         var7 = true;
      }

      if(var7 || var4) {
         this.method6058(var1, var2, var3, (byte)1);
      }

   }

   public void method6027(int var1) {
      this.field3850.method5985((byte)30);
   }

   public void method6003(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8) {
      if(this.field3850.method5987(-2033116061)) {
         this.method6006(-1696035308);
         this.method6101(1083036855);
         if(var3) {
            int var9 = (int)Math.ceil((double)((float)var6 / this.field3833));
            int var10 = (int)Math.ceil((double)((float)var7 / this.field3833));
            List var11 = this.field3827.method487(this.field3829 - var9 / 2 - 1, this.field3830 - var10 / 2 - 1, var9 / 2 + this.field3829 + 1, var10 / 2 + this.field3830 + 1, var4, var5, var6, var7, var1, var2, -1764374656);
            HashSet var12 = new HashSet();

            Iterator var13;
            class28 var14;
            ScriptInvocation var15;
            class36 var16;
            for(var13 = var11.iterator(); var13.hasNext(); class68.method1696(var15)) {
               var14 = (class28)var13.next();
               var12.add(var14);
               var15 = new ScriptInvocation();
               var16 = new class36(var14.field240, var14.field243, var14.field236);
               var15.method1024(new Object[]{var16, Integer.valueOf(var1), Integer.valueOf(var2)}, (byte)-106);
               if(this.field3862.contains(var14)) {
                  var15.method1025(17, -529454320);
               } else {
                  var15.method1025(15, -1164341775);
               }
            }

            var13 = this.field3862.iterator();

            while(var13.hasNext()) {
               var14 = (class28)var13.next();
               if(!var12.contains(var14)) {
                  var15 = new ScriptInvocation();
                  var16 = new class36(var14.field240, var14.field243, var14.field236);
                  var15.method1024(new Object[]{var16, Integer.valueOf(var1), Integer.valueOf(var2)}, (byte)24);
                  var15.method1025(16, 1667651932);
                  class68.method1696(var15);
               }
            }

            this.field3862 = var12;
         }
      }
   }

   public void method6158(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(!this.field3850.method5987(-2121041108)) {
         if(var7 == -766143801) {
            ;
         }
      } else {
         int var8 = (int)Math.ceil((double)((float)var3 / this.field3833));
         int var9 = (int)Math.ceil((double)((float)var4 / this.field3833));
         List var10 = this.field3827.method487(this.field3829 - var8 / 2 - 1, this.field3830 - var9 / 2 - 1, var8 / 2 + this.field3829 + 1, var9 / 2 + this.field3830 + 1, var1, var2, var3, var4, var5, var6, -1803935577);
         if(!var10.isEmpty()) {
            Iterator var11 = var10.iterator();

            boolean var14;
            do {
               if(!var11.hasNext()) {
                  return;
               }

               if(var7 != -766143801) {
                  return;
               }

               class28 var12 = (class28)var11.next();
               class255 var13 = class255.field3246[var12.field240];
               var14 = false;

               for(int var15 = this.field3859.length - 1; var15 >= 0; --var15) {
                  if(var7 != -766143801) {
                     return;
                  }

                  if(var13.field3244[var15] != null) {
                     class50.method993(var13.field3244[var15], var13.field3255, this.field3859[var15], var12.field240, var12.field243.method4437(2077151196), var12.field236.method4437(2082702788), 688233518);
                     var14 = true;
                  }
               }
            } while(!var14);

         }
      }
   }

   public void method6008(int var1, int var2, class226 var3, class226 var4, byte var5) {
      ScriptInvocation var6 = new ScriptInvocation();
      class36 var7 = new class36(var2, var3, var4);
      var6.method1024(new Object[]{var7}, (byte)-34);
      switch(var1) {
      case 1008:
         var6.method1025(10, 1085002213);
         break;
      case 1009:
         var6.method1025(11, -1517514268);
         break;
      case 1010:
         var6.method1025(12, -194628232);
         break;
      case 1011:
         var6.method1025(13, -1319898016);
         break;
      case 1012:
         var6.method1025(14, 1260766684);
      }

      class68.method1696(var6);
   }

   public void method6174(int var1, int var2, boolean var3, boolean var4, byte var5) {
      long var6 = Stream.method3547(604838575);
      this.method6036(var1, var2, var4, var6);
      if(!this.method6175(-1688865495) && (var4 || var3)) {
         if(var4) {
            this.field3847 = var1;
            this.field3817 = var2;
            this.field3845 = this.field3829;
            this.field3846 = this.field3830;
         }

         if(this.field3845 != -1) {
            int var8 = var1 - this.field3847;
            int var9 = var2 - this.field3817;
            this.method6135(this.field3845 - (int)((float)var8 / this.field3867), (int)((float)var9 / this.field3867) + this.field3846, false, 1580354499);
         }
      } else {
         this.method6009(-1442758929);
      }

      if(var4) {
         this.field3849 = var6;
         this.field3864 = var1;
         this.field3851 = var2;
      }

   }

   public void method6012(int var1, int var2) {
      class20 var3 = this.method6029(var1, 957410346);
      if(var3 != null) {
         this.method6015(var3, (byte)-101);
      }

   }

   public int method6026(int var1) {
      return (double)this.field3867 == 1.0D ? 25 : ((double)this.field3867 == 1.5D ? 37 : ((double)this.field3867 == 2.0D ? 50 : ((double)this.field3867 == 3.0D ? 75 : ((double)this.field3867 == 4.0D ? 100 : 200))));
   }

   public void method6023(int var1, short var2) {
      this.field3867 = this.method6025(var1, -606410232);
   }

   public boolean method6096(int var1) {
      return this.field3850.method5987(-2127974217);
   }

   public class226 method6001(int var1) {
      return this.field3825 == null ? null : this.field3825.method205(this.method6002(-394552216), this.method6035(1934425663), -2056689977);
   }

   public void method6046(int var1, int var2, int var3, int var4) {
      if(this.field3825 != null) {
         int[] var5 = this.field3825.method213(var1, var2, var3, (byte)-11);
         if(var5 != null) {
            this.method6054(var5[0], var5[1], (byte)-75);
         }

      }
   }

   public void method6033(int var1, int var2, int var3, byte var4) {
      if(this.field3825 != null) {
         int[] var5 = this.field3825.method213(var1, var2, var3, (byte)29);
         if(var5 != null) {
            this.method6031(var5[0], var5[1], (byte)-26);
         }

      }
   }

   public int method6153(int var1) {
      return this.field3825 == null ? -1 : this.field3825.method207((byte)-113);
   }

   public void method6040(byte var1) {
      this.field3857 = 3;
   }

   public class20 method6014(byte var1) {
      return this.field3825;
   }

   public void method6042(byte var1) {
      this.field3840 = 50;
   }

   public void method6089(int var1, byte var2) {
      if(var1 >= 1) {
         if(var2 == 0) {
            return;
         }

         this.field3857 = var1;
      }

   }

   public void method6114(byte var1) {
      this.field3842 = null;
   }

   public void method6041(int var1, byte var2) {
      if(var1 >= 1) {
         this.field3840 = var1;
      }

   }

   public void method6106(int var1, int var2) {
      this.field3842 = new HashSet();
      this.field3842.add(Integer.valueOf(var1));
      this.field3855 = 0;
      this.field3819 = 0;
   }

   public void method6034(boolean var1, int var2) {
      this.field3841 = var1;
   }

   public void method6152(int var1, int var2) {
      this.field3842 = new HashSet();
      this.field3855 = 0;
      this.field3819 = 0;

      for(int var3 = 0; var3 < class255.field3246.length; var3++) {
         if(class255.field3246[var3] != null && class255.field3246[var3].field3240 == var1) {
            this.field3842.add(Integer.valueOf(class255.field3246[var3].field3238));
         }
      }

   }

   public class28 method6146(short var1) {
      if(!this.field3850.method5987(-1971602084)) {
         return null;
      } else if(!this.field3827.method513(-2126852723)) {
         return null;
      } else {
         HashMap var2 = this.field3827.method489((byte)-59);
         this.field3860 = new LinkedList();
         Iterator var3 = var2.values().iterator();

         while(var3.hasNext()) {
            List var4 = (List)var3.next();
            this.field3860.addAll(var4);
         }

         this.field3848 = this.field3860.iterator();
         return this.method6186((byte)-80);
      }
   }

   public void method6047(boolean var1, int var2) {
      this.field3854 = !var1;
   }

   public boolean method6050(int var1) {
      return !this.field3854;
   }

   public void method6048(int var1, boolean var2, byte var3) {
      if(!var2) {
         this.field3853.add(Integer.valueOf(var1));
      } else {
         this.field3853.remove(Integer.valueOf(var1));
      }

      this.method6053(-248986247);
   }

   public void method6049(int var1, boolean var2, int var3) {
      if(!var2) {
         this.field3843.add(Integer.valueOf(var1));
      } else {
         this.field3843.remove(Integer.valueOf(var1));
      }

      for(int var4 = 0; var4 < class255.field3246.length; var4++) {
         if(class255.field3246[var4] == null) {
            if(var3 == -22987687) {
               return;
            }
         } else if(class255.field3246[var4].field3240 == var1) {
            int var5 = class255.field3246[var4].field3238;
            if(!var2) {
               if(var3 == -22987687) {
                  return;
               }

               this.field3844.add(Integer.valueOf(var5));
            } else {
               this.field3844.remove(Integer.valueOf(var5));
            }
         }
      }

      this.method6053(-125010856);
   }

   public boolean method6051(int var1, byte var2) {
      return !this.field3853.contains(Integer.valueOf(var1));
   }

   public void method6073(class20 var1, class226 var2, class226 var3, boolean var4, byte var5) {
      if(var1 != null) {
         if(this.field3825 == null || var1 != this.field3825) {
            this.method6016(var1, 1838379957);
         }

         if(!var4 && this.field3825.method202(var2.field2567, var2.field2564, var2.field2565, (byte)8)) {
            this.method6058(var2.field2567, var2.field2564, var2.field2565, (byte)1);
         } else {
            this.method6058(var3.field2567, var3.field2564, var3.field2565, (byte)1);
         }

      }
   }

   public boolean method6052(int var1, int var2) {
      return !this.field3843.contains(Integer.valueOf(var1));
   }

   public class226 method6100(int var1, class226 var2, int var3) {
      if(!this.field3850.method5987(-2081017851)) {
         return null;
      } else if(!this.field3827.method513(-2083017856)) {
         return null;
      } else if(!this.field3825.method203(var2.field2564, var2.field2565, 1006376583)) {
         return null;
      } else {
         HashMap var4 = this.field3827.method489((byte)-63);
         List var5 = (List)var4.get(Integer.valueOf(var1));
         if(var5 != null && !var5.isEmpty()) {
            class28 var6 = null;
            int var7 = -1;
            Iterator var8 = var5.iterator();

            while(true) {
               class28 var9;
               int var12;
               do {
                  if(!var8.hasNext()) {
                     return var6.field236;
                  }

                  var9 = (class28)var8.next();
                  int var10 = var9.field236.field2564 - var2.field2564;
                  int var11 = var9.field236.field2565 - var2.field2565;
                  var12 = var10 * var10 + var11 * var11;
                  if(var12 == 0) {
                     return var9.field236;
                  }
               } while(var12 >= var7 && var6 != null);

               var6 = var9;
               var7 = var12;
            }
         } else {
            return null;
         }
      }
   }
}
