package client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class class23 {
   static class201 field189 = new class201(256, 256);
   static class201 field188 = new class201(37748736, 256);
   static final class226 field193 = new class226();
   static final int field190 = 37748736;
   static final int field200 = 36;
   static final int field201 = 42;
   static final int field202 = 87;
   List field196;
   LinkedList field195;
   HashMap field199;
   int field191;
   class10 field197;
   int field187;
   int field192;
   final HashMap field198;
   int field194;

   class23(int var1, int var2, int var3, HashMap var4) {
      this.field191 = var1;
      this.field192 = var2;
      this.field195 = new LinkedList();
      this.field196 = new LinkedList();
      this.field199 = new HashMap();
      this.field194 = var3 | -16777216;
      this.field198 = var4;
   }

   void method304(int var1, int var2, class16 var3, byte var4) {
      for(int var5 = 0; var5 < var3.field121; var5++) {
         class19[] var6 = var3.field126[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class19[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; var8++) {
               class19 var9 = var7[var8];
               if(class129.method3073(var9.field155, 1923991029)) {
                  ObjectDef var10 = class110.getObjectDef(var9.field158);
                  int var10000;
                  if(var10.int696 != 0) {
                     if(var4 == 1) {
                        return;
                     }

                     var10000 = -3407872;
                  } else {
                     var10000 = -3355444;
                  }

                  int var11 = var10000;
                  if(var9.field155 == class233.field2773.field2777) {
                     if(var4 == 1) {
                        return;
                     }

                     this.method321(var1, var2, var9.field157, var11, (byte)-37);
                  }

                  if(var9.field155 == class233.field2755.field2777) {
                     this.method321(var1, var2, var9.field157, -3355444, (byte)-60);
                     this.method321(var1, var2, var9.field157 + 1, var11, (byte)4);
                  }

                  if(var9.field155 == class233.field2757.field2777) {
                     if(var9.field157 == 0) {
                        Rasterizer2D.method5736(this.field187 * var1, this.field187 * (63 - var2), 1, var11);
                     }

                     if(var9.field157 == 1) {
                        Rasterizer2D.method5736(this.field187 * var1 + this.field187 - 1, this.field187 * (63 - var2), 1, var11);
                     }

                     if(var9.field157 == 2) {
                        if(var4 == 1) {
                           return;
                        }

                        Rasterizer2D.method5736(this.field187 * var1 + this.field187 - 1, this.field187 * (63 - var2) + this.field187 - 1, 1, var11);
                     }

                     if(var9.field157 == 3) {
                        Rasterizer2D.method5736(this.field187 * var1, this.field187 * (63 - var2) + this.field187 - 1, 1, var11);
                     }
                  }

                  if(var9.field155 == class233.field2758.field2777) {
                     int var12 = var9.field157 % 2;
                     int var13;
                     if(var12 == 0) {
                        for(var13 = 0; var13 < this.field187; var13++) {
                           Rasterizer2D.method5736(var13 + this.field187 * var1, (64 - var2) * this.field187 - 1 - var13, 1, var11);
                        }
                     } else {
                        for(var13 = 0; var13 < this.field187; var13++) {
                           Rasterizer2D.method5736(var13 + this.field187 * var1, var13 + this.field187 * (63 - var2), 1, var11);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   void method380(int var1, int var2, HashSet var3, int var4, byte var5) {
      float var6 = (float)var4 / 64.0F;
      float var7 = var6 / 2.0F;
      Iterator var8 = this.field199.entrySet().iterator();

      while(var8.hasNext()) {
         Entry var9 = (Entry)var8.next();
         class226 var10 = (class226)var9.getKey();
         int var11 = (int)((float)var10.field2564 * var6 + (float)var1 - var7);
         int var12 = (int)((float)(var2 + var4) - (float)var10.field2565 * var6 - var7);
         class28 var13 = (class28)var9.getValue();
         if(var13 != null) {
            if(var5 == 3) {
               return;
            }

            var13.field235 = var11;
            var13.field245 = var12;
            class255 var14 = class255.field3246[var13.field240];
            if(!var3.contains(Integer.valueOf(var14.method4821((byte)-51)))) {
               this.method308(var13, var11, var12, var6, -1276060102);
            }
         }
      }

   }

   void method406(int var1, int var2, class16 var3, PaletteSprite[] var4, int var5) {
      for(int var6 = 0; var6 < var3.field121; var6++) {
         class19[] var7 = var3.field126[var6][var1][var2];
         if(var7 != null && var7.length != 0) {
            class19[] var8 = var7;

            for(int var9 = 0; var9 < var8.length; var9++) {
               class19 var10 = var8[var9];
               if(!class152.method3247(var10.field155, (byte)-105)) {
                  int var12 = var10.field155;
                  boolean var11 = var12 == class233.field2776.field2777;
                  if(!var11) {
                     continue;
                  }
               }

               ObjectDef var13 = class110.getObjectDef(var10.field158);
               if(var13.int701 != -1) {
                  if(var5 != -1488997280) {
                     return;
                  }

                  if(var13.int701 != 46 && var13.int701 != 52) {
                     var4[var13.int701].method5825(this.field187 * var1, this.field187 * (63 - var2), this.field187 * 2, this.field187 * 2);
                  } else {
                     var4[var13.int701].method5825(this.field187 * var1, this.field187 * (63 - var2), this.field187 * 2 + 1, this.field187 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   class22 method318(class255 var1, int var2) {
      if(var1.field3241 != null && this.field198 != null && this.field198.get(class12.field70) != null) {
         class12 var3 = class12.method101(var1.field3243, (byte)-15);
         if(var3 == null) {
            return null;
         } else {
            class298 var4 = (class298)this.field198.get(var3);
            if(var4 == null) {
               return null;
            } else {
               int var5 = var4.method5520(var1.field3241, 1000000);
               String[] var6 = new String[var5];
               var4.method5518(var1.field3241, (int[])null, var6);
               int var7 = var6.length * var4.field3695 / 2;
               int var8 = 0;
               String[] var9 = var6;

               for(int var10 = 0; var10 < var9.length; var10++) {
                  String var11 = var9[var10];
                  int var12 = var4.method5517(var11);
                  if(var12 > var8) {
                     var8 = var12;
                  }
               }

               return new class22(var1.field3241, var8, var7, var3);
            }
         }
      } else {
         return null;
      }
   }

   void method317(class255 var1, int var2, int var3, int var4) {
      Sprite var5 = var1.method4815(false, (byte)-1);
      if(var5 != null) {
         int var6 = this.method288(var5, var1.field3252, 624399097);
         int var7 = this.method284(var5, var1.field3253, 105388050);
         var5.method5851(var6 + var2, var3 + var7);
      }

   }

   void method320(int var1, int var2, class16 var3, class35 var4, class21 var5, int var6) {
      int var7 = var3.field125[0][var1][var2] - 1;
      int var8 = var3.field123[0][var1][var2] - 1;
      if(var7 == -1 && var8 == -1) {
         Rasterizer2D.method5763(this.field187 * var1, this.field187 * (63 - var2), this.field187, this.field187, this.field194);
      }

      int var9 = 16711935;
      if(var8 != -1) {
         var9 = class6.method69(var8, this.field194, -1575797810);
      }

      if(var8 > -1) {
         if(var6 <= -682093580) {
            return;
         }

         if(var3.field124[0][var1][var2] == 0) {
            if(var6 <= -682093580) {
               return;
            }

            Rasterizer2D.method5763(this.field187 * var1, this.field187 * (63 - var2), this.field187, this.field187, var9);
            return;
         }
      }

      int var10 = this.method302(var1, var2, var3, var5, -2041354337);
      if(var8 == -1) {
         Rasterizer2D.method5763(this.field187 * var1, this.field187 * (63 - var2), this.field187, this.field187, var10);
      } else {
         var4.method606(this.field187 * var1, this.field187 * (63 - var2), var10, var9, this.field187, this.field187, var3.field124[0][var1][var2], var3.field116[0][var1][var2], 600681554);
      }
   }

   void method337(int var1, int var2, HashSet var3, int var4, byte var5) {
      float var6 = (float)var4 / 64.0F;
      Iterator var7 = this.field196.iterator();

      while(var7.hasNext()) {
         class28 var8 = (class28)var7.next();
         int var9 = var8.field236.field2564 % 64;
         int var10 = var8.field236.field2565 % 64;
         var8.field235 = (int)((float)var1 + var6 * (float)var9);
         var8.field245 = (int)(var6 * (float)(63 - var10) + (float)var2);
         if(!var3.contains(Integer.valueOf(var8.field240))) {
            this.method308(var8, var8.field235, var8.field245, var6, -1165909421);
         }
      }

   }

   int method288(Sprite var1, class270 var2, int var3) {
      switch(var2.field3482) {
      case 0:
         return -var1.width / 2;
      case 1:
         return 0;
      default:
         return -var1.width;
      }
   }

   void method295(int var1, int var2, class16 var3, class35 var4, PaletteSprite[] var5, int var6) {
      this.method304(var1, var2, var3, (byte)-83);
      this.method406(var1, var2, var3, var5, -1488997280);
   }

   class21 method298(class23[] var1, byte var2) {
      class32 var3 = new class32(64, 64);
      if(this.field197 != null) {
         this.method300(0, 0, 64, 64, this.field197, var3, 1938287225);
      } else {
         Iterator var4 = this.field195.iterator();

         while(var4.hasNext()) {
            class34 var5 = (class34)var4.next();
            this.method300(var5.method565(976188500) * 8, var5.method563(658572970) * 8, 8, 8, var5, var3, 1418982848);
         }
      }

      this.method299(var1, var3, 1463076234);
      class21 var6 = new class21();
      var6.method265(var3, (byte)-31);
      return var6;
   }

   void method309(HashSet var1, int var2, int var3, int var4) {
      Iterator var5 = this.field196.iterator();

      while(var5.hasNext()) {
         class28 var6 = (class28)var5.next();
         class255 var7 = class255.field3246[var6.field240];
         if(var7 != null && var1.contains(Integer.valueOf(var7.method4821((byte)-89)))) {
            this.method307(var7, var6.field235, var6.field245, var2, var3, 112631536);
         }
      }

   }

   int method322(int var1, int var2, int var3) {
      if(this.field197 != null) {
         return this.field197.method153(var1, var2, (byte)1);
      } else {
         if(!this.field195.isEmpty()) {
            Iterator var4 = this.field195.iterator();

            while(var4.hasNext()) {
               class34 var5 = (class34)var4.next();
               if(var5.method562(var1, var2, -1697676286)) {
                  return var5.method153(var1, var2, (byte)1);
               }
            }
         }

         return -1;
      }
   }

   void method289(List var1, byte var2) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class13 var4 = (class13)var3.next();
         if(var4.field88.field2564 >> 6 == this.field191 && var4.field88.field2565 >> 6 == this.field192) {
            if(var2 == 0) {
               return;
            }

            class28 var5 = new class28(var4.field83, var4.field88, var4.field88, this.method306(var4.field83, 1836375512));
            this.field196.add(var5);
         }
      }

   }

   void method294(int var1, int var2, int var3, int var4, class16 var5, int var6) {
      for(int var7 = var1; var7 < var3 + var1; var7++) {
         label55:
         for(int var8 = var2; var8 < var2 + var4; var8++) {
            class226 var9 = new class226(0, var7, var8);

            for(int var10 = 0; var10 < var5.field121; var10++) {
               class19[] var11 = var5.field126[var10][var7][var8];
               if(var11 != null && var11.length != 0) {
                  class19[] var12 = var11;

                  for(int var13 = 0; var13 < var12.length; var13++) {
                     class19 var14 = var12[var13];
                     class255 var15 = this.method348(var14.field158, 764273111);
                     if(var15 != null) {
                        class226 var16 = new class226(var10, this.field191 * 64 + var7, this.field192 * 64 + var8);
                        class226 var17 = null;
                        if(this.field197 != null) {
                           var17 = new class226(this.field197.field120 + var10, var7 + this.field197.field127 * 64, var8 + this.field197.field117 * 64);
                        } else {
                           class34 var18 = (class34)var5;
                           var17 = new class226(var10 + var18.field120, var7 + var18.field127 * 64 + var18.method584((byte)1) * 8, var18.field117 * 64 + var8 + var18.method564((short)-552) * 8);
                        }

                        class28 var19 = new class28(var15.field3238, var17, var16, this.method318(var15, 1728647620));
                        this.field199.put(var9, var19);
                        continue label55;
                     }
                  }
               }
            }
         }
      }

   }

   void method300(int var1, int var2, int var3, int var4, class16 var5, class32 var6, int var7) {
      for(int var8 = var1; var8 < var3 + var1; var8++) {
         for(int var9 = var2; var9 < var2 + var4; var9++) {
            int var10 = var5.field125[0][var8][var9] - 1;
            if(var10 != -1) {
               class259 var11 = class49.method953(var10, 1734818880);
               var6.method541(var8, var9, 5, var11, (short)11065);
            }
         }
      }

   }

   void method313(int var1, int var2, class16 var3, int var4) {
      field193.method4436(0, var1, var2, -2113986105);

      for(int var5 = 0; var5 < var3.field121; var5++) {
         class19[] var6 = var3.field126[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class19[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; var8++) {
               class19 var9 = var7[var8];
               class255 var10 = this.method348(var9.field158, 1700198943);
               if(var10 != null) {
                  if(var4 == -356503511) {
                     return;
                  }

                  class28 var11 = (class28)this.field199.get(field193);
                  if(var11 != null) {
                     if(var11.field240 != var10.field3238) {
                        if(var4 == -356503511) {
                           return;
                        }

                        class28 var17 = new class28(var10.field3238, var11.field243, var11.field236, this.method318(var10, 1714512879));
                        this.field199.put(new class226(field193), var17);
                        var11 = var17;
                     }

                     int var16 = var11.field243.field2567 - var11.field236.field2567;
                     var11.field236.field2567 = var5;
                     var11.field243.field2567 = var16 + var5;
                     return;
                  }

                  class226 var12 = new class226(var5, this.field191 * 64 + var1, this.field192 * 64 + var2);
                  class226 var13 = null;
                  if(this.field197 != null) {
                     if(var4 == -356503511) {
                        return;
                     }

                     var13 = new class226(this.field197.field120 + var5, this.field197.field127 * 64 + var1, var2 + this.field197.field117 * 64);
                  } else {
                     Iterator var14 = this.field195.iterator();

                     while(var14.hasNext()) {
                        class34 var15 = (class34)var14.next();
                        if(var15.method562(var1, var2, -1697676286)) {
                           var13 = new class226(var5 + var15.field120, var1 + var15.field127 * 64 + var15.method584((byte)1) * 8, var2 + var15.field117 * 64 + var15.method564((short)-24072) * 8);
                           break;
                        }
                     }
                  }

                  if(var13 != null) {
                     var11 = new class28(var10.field3238, var13, var12, this.method318(var10, 1964819018));
                     this.field199.put(new class226(field193), var11);
                     return;
                  }
               }
            }
         }
      }

      this.field199.remove(field193);
   }

   void method362(class28 var1, class255 var2, int var3, int var4, float var5, byte var6) {
      if(var1.field246 == null) {
         if(var6 == 1) {
            ;
         }
      } else if(var1.field246.field181.method103(var5, (byte)-53)) {
         class298 var7 = (class298)this.field198.get(var1.field246.field181);
         var7.method5526(var1.field246.field186, var3 - var1.field246.field184 / 2, var4, var1.field246.field184, var1.field246.field182, -16777216 | var2.field3242, 0, 1, 0, var7.field3695 / 2);
      }
   }

   void method296(int var1, int var2, class16 var3, class35 var4, int var5) {
      for(int var6 = 1; var6 < var3.field121; var6++) {
         int var7 = var3.field123[var6][var1][var2] - 1;
         if(var7 > -1) {
            int var8 = class6.method69(var7, this.field194, -1857192473);
            if(var3.field124[var6][var1][var2] == 0) {
               Rasterizer2D.method5763(this.field187 * var1, this.field187 * (63 - var2), this.field187, this.field187, var8);
            } else {
               var4.method606(this.field187 * var1, this.field187 * (63 - var2), 0, var8, this.field187, this.field187, var3.field124[var6][var1][var2], var3.field116[var6][var1][var2], 600681554);
            }
         }
      }

   }

   int method284(Sprite var1, class252 var2, int var3) {
      switch(var2.field3223) {
      case 1:
         return -var1.height / 2;
      case 2:
         return 0;
      default:
         return -var1.height;
      }
   }

   void method299(class23[] var1, class32 var2, int var3) {
      class240[] var4 = class9.method85(-1993711199);
      class240[] var5 = var4;

      for(int var6 = 0; var6 < var5.length; var6++) {
         class240 var7 = var5[var6];
         if(var1[var7.vmethod5815((byte)105)] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3104) {
            case 0:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 1:
               var12 = 59;
               var10 = 5;
               break;
            case 2:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 3:
               var9 = 59;
               var11 = 5;
               break;
            case 4:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 5:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 6:
               var13 = 59;
               var11 = 5;
               break;
            case 7:
               var8 = 59;
               var10 = 5;
            }

            this.method301(var12, var13, var8, var9, var10, var11, var1[var7.vmethod5815((byte)82)], var2, 2106846136);
         }
      }

   }

   class21 method297(int var1, int var2, class23[] var3, int var4) {
      class21 var5 = (class21)field189.method3997(class43.method716(var1, var2, 0, -158432539));
      class21 var6 = var5;
      if(var5 == null) {
         var6 = this.method298(var3, (byte)6);
         class12.method104(var6, var1, var2, -442042913);
      }

      return var6;
   }

   class255 method348(int var1, int var2) {
      ObjectDef var3 = class110.getObjectDef(var1);
      if(var3.intArray116 != null) {
         var3 = var3.method5056();
         if(var3 == null) {
            return null;
         }
      }

      return var3.int700 != -1 ? class255.field3246[var3.int700] : null;
   }

   void method307(class255 var1, int var2, int var3, int var4, int var5, int var6) {
      Sprite var7 = var1.method4815(false, (byte)-38);
      if(var7 != null) {
         var7.method5851(var2 - var7.width / 2, var3 - var7.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5784(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5784(var2, var3, 7, 16777215, 256);
         }

      }
   }

   List method356(byte var1) {
      LinkedList var2 = new LinkedList();
      var2.addAll(this.field196);
      var2.addAll(this.field199.values());
      return var2;
   }

   int method302(int var1, int var2, class16 var3, class21 var4, int var5) {
      return var3.field125[0][var1][var2] == 0 ? this.field194 : var4.method272(var1, var2, (byte)9);
   }

   class22 method306(int var1, int var2) {
      class255 var3 = class255.field3246[var1];
      return this.method318(var3, 2036473145);
   }

   void method293(class35 var1, class23[] var2, PaletteSprite[] var3, class21 var4, int var5) {
      int var6;
      int var7;
      for(var6 = 0; var6 < 64; var6++) {
         for(var7 = 0; var7 < 64; var7++) {
            this.method320(var6, var7, this.field197, var1, var4, 126232194);
            this.method296(var6, var7, this.field197, var1, 1017441024);
         }
      }

      for(var6 = 0; var6 < 64; var6++) {
         for(var7 = 0; var7 < 64; var7++) {
            this.method295(var6, var7, this.field197, var1, var3, 1267553766);
         }
      }

   }

   void method373(class35 var1, PaletteSprite[] var2, class21 var3, byte var4) {
      Iterator var5 = this.field195.iterator();

      class34 var6;
      int var7;
      int var8;
      while(var5.hasNext()) {
         var6 = (class34)var5.next();

         for(var7 = var6.method565(1617660704) * 8; var7 < var6.method565(1730529787) * 8 + 8; var7++) {
            if(var4 >= 2) {
               return;
            }

            for(var8 = var6.method563(-1212151809) * 8; var8 < var6.method563(-935281018) * 8 + 8; var8++) {
               this.method320(var7, var8, var6, var1, var3, 1224867549);
               this.method296(var7, var8, var6, var1, 1017441024);
            }
         }
      }

      var5 = this.field195.iterator();

      while(var5.hasNext()) {
         var6 = (class34)var5.next();

         for(var7 = var6.method565(1985147803) * 8; var7 < var6.method565(628720670) * 8 + 8; var7++) {
            for(var8 = var6.method563(323991061) * 8; var8 < var6.method563(16166260) * 8 + 8; var8++) {
               this.method295(var7, var8, var6, var1, var2, -1799308317);
            }
         }
      }

   }

   void method308(class28 var1, int var2, int var3, float var4, int var5) {
      class255 var6 = class255.field3246[var1.field240];
      this.method317(var6, var2, var3, -1923264171);
      this.method362(var1, var6, var2, var3, var4, (byte)1);
   }

   void method340(byte var1) {
      if(this.field197 != null) {
         for(int var2 = 0; var2 < 64; var2++) {
            for(int var3 = 0; var3 < 64; var3++) {
               this.method313(var2, var3, this.field197, 602031848);
            }
         }
      } else {
         Iterator var6 = this.field195.iterator();

         while(var6.hasNext()) {
            class34 var7 = (class34)var6.next();

            for(int var4 = var7.method565(1833382628) * 8; var4 < var7.method565(1585937487) * 8 + 8; var4++) {
               for(int var5 = var7.method563(-1265116374) * 8; var5 < var7.method563(-1354048323) * 8 + 8; var5++) {
                  this.method313(var4, var5, var7, -2108038909);
               }
            }
         }
      }

   }

   void method311(HashSet var1, int var2, int var3, int var4) {
      Iterator var5 = this.field199.values().iterator();

      while(var5.hasNext()) {
         if(var4 <= -377441337) {
            return;
         }

         class28 var6 = (class28)var5.next();
         if(var1.contains(Integer.valueOf(var6.field240))) {
            class255 var7 = class255.field3246[var6.field240];
            this.method307(var7, var6.field235, var6.field245, var2, var3, 112631536);
         }
      }

      this.method309(var1, var2, var3, 1896087870);
   }

   void method301(int var1, int var2, int var3, int var4, int var5, int var6, class23 var7, class32 var8, int var9) {
      for(int var10 = 0; var10 < var5; var10++) {
         if(var9 != 2106846136) {
            return;
         }

         for(int var11 = 0; var11 < var6; var11++) {
            int var12 = var7.method322(var10 + var1, var11 + var2, 1433133625);
            if(var12 != -1) {
               class259 var13 = class49.method953(var12, 543990595);
               var8.method541(var3 + var10, var11 + var4, 5, var13, (short)5713);
            }
         }
      }

   }

   void method321(int var1, int var2, int var3, int var4, byte var5) {
      var3 %= 4;
      if(var3 == 0) {
         if(var5 >= 59) {
            return;
         }

         Rasterizer2D.method5738(this.field187 * var1, this.field187 * (63 - var2), this.field187, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5736(this.field187 * var1, this.field187 * (63 - var2), this.field187, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5738(this.field187 * var1 + this.field187 - 1, this.field187 * (63 - var2), this.field187, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5736(this.field187 * var1, this.field187 * (63 - var2) + this.field187 - 1, this.field187, var4);
      }

   }

   void method382(int var1, int var2, int var3, HashSet var4, int var5) {
      if(var4 == null) {
         if(var5 == -978729421) {
            return;
         }

         var4 = new HashSet();
      }

      this.method380(var1, var2, var4, var3, (byte)-22);
      this.method337(var1, var2, var4, var3, (byte)-39);
   }

   List method319(int var1, int var2, int var3, int var4, int var5, int var6) {
      LinkedList var7 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var8 = this.field199.values().iterator();

            class28 var9;
            while(var8.hasNext()) {
               var9 = (class28)var8.next();
               if(var9.method464(var4, var5, -2020334736)) {
                  var7.add(var9);
               }
            }

            var8 = this.field196.iterator();

            while(var8.hasNext()) {
               var9 = (class28)var8.next();
               if(var9.method464(var4, var5, -1429120239)) {
                  var7.add(var9);
               }
            }

            return var7;
         } else {
            return var7;
         }
      } else {
         return var7;
      }
   }

   void method290(int var1, class35 var2, class23[] var3, PaletteSprite[] var4, int var5) {
      this.field187 = var1;
      if(this.field197 == null) {
         if(var5 <= 2097572835) {
            return;
         }

         if(this.field195.isEmpty()) {
            if(var5 <= 2097572835) {
               return;
            }

            return;
         }
      }

      int var7 = this.field191;
      int var8 = this.field192;
      Sprite var6 = (Sprite)field188.method3997(class43.method716(var7, var8, var1, -1030997020));
      if(var6 != null) {
         if(var5 > 2097572835) {
            ;
         }
      } else {
         class21 var9 = this.method297(this.field191, this.field192, var3, -1376488982);
         Sprite var10 = new Sprite(this.field187 * 64, this.field187 * 64);
         var10.method5850();
         if(this.field197 != null) {
            this.method293(var2, var3, var4, var9, -488045984);
         } else {
            this.method373(var2, var4, var9, (byte)-48);
         }

         class172.method3458(var10, this.field191, this.field192, this.field187, -1222974971);
      }
   }

   void method314(int var1, int var2, int var3, short var4) {
      int var6 = this.field191;
      int var7 = this.field192;
      int var8 = this.field187;
      Sprite var5 = (Sprite)field188.method3997(class43.method716(var6, var7, var8, -1234398165));
      if(var5 != null) {
         if(var3 == this.field187 * 64) {
            var5.method5849(var1, var2);
         } else {
            var5.method5872(var1, var2, var3, var3);
         }

      }
   }

   void method400(class10 var1, List var2, int var3) {
      this.field199.clear();
      this.field197 = var1;
      this.method294(0, 0, 64, 64, this.field197, -2114654135);
      this.method289(var2, (byte)-86);
   }

   void method287(HashSet var1, List var2, byte var3) {
      this.field199.clear();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         class34 var5 = (class34)var4.next();
         if(var5.method149(-231958659) == this.field191 && var5.method168((byte)-29) == this.field192) {
            this.field195.add(var5);
            this.method294(var5.method565(421563863) * 8, var5.method563(-2136604695) * 8, 8, 8, var5, -1457555663);
         }
      }

      this.method289(var2, (byte)-10);
   }

   public static int method421(CharSequence var0, int var1, int var2, byte[] var3, int var4, int var5) {
      int var6 = var2 - var1;

      for(int var7 = 0; var7 < var6; var7++) {
         char var8 = var0.charAt(var7 + var1);
         if(var8 > 0 && var8 < 128 || var8 >= 160 && var8 <= 255) {
            var3[var7 + var4] = (byte)var8;
         } else if(var8 == 8364) {
            var3[var7 + var4] = -128;
         } else if(var8 == 8218) {
            var3[var7 + var4] = -126;
         } else if(var8 == 402) {
            var3[var7 + var4] = -125;
         } else if(var8 == 8222) {
            var3[var7 + var4] = -124;
         } else if(var8 == 8230) {
            var3[var7 + var4] = -123;
         } else if(var8 == 8224) {
            var3[var7 + var4] = -122;
         } else if(var8 == 8225) {
            var3[var7 + var4] = -121;
         } else if(var8 == 710) {
            var3[var7 + var4] = -120;
         } else if(var8 == 8240) {
            var3[var7 + var4] = -119;
         } else if(var8 == 352) {
            var3[var7 + var4] = -118;
         } else if(var8 == 8249) {
            var3[var7 + var4] = -117;
         } else if(var8 == 338) {
            var3[var7 + var4] = -116;
         } else if(var8 == 381) {
            var3[var7 + var4] = -114;
         } else if(var8 == 8216) {
            var3[var7 + var4] = -111;
         } else if(var8 == 8217) {
            var3[var7 + var4] = -110;
         } else if(var8 == 8220) {
            var3[var7 + var4] = -109;
         } else if(var8 == 8221) {
            var3[var7 + var4] = -108;
         } else if(var8 == 8226) {
            var3[var7 + var4] = -107;
         } else if(var8 == 8211) {
            var3[var7 + var4] = -106;
         } else if(var8 == 8212) {
            var3[var7 + var4] = -105;
         } else if(var8 == 732) {
            var3[var7 + var4] = -104;
         } else if(var8 == 8482) {
            var3[var7 + var4] = -103;
         } else if(var8 == 353) {
            var3[var7 + var4] = -102;
         } else if(var8 == 8250) {
            var3[var7 + var4] = -101;
         } else if(var8 == 339) {
            var3[var7 + var4] = -100;
         } else if(var8 == 382) {
            var3[var7 + var4] = -98;
         } else if(var8 == 376) {
            var3[var7 + var4] = -97;
         } else {
            var3[var7 + var4] = 63;
         }
      }

      return var6;
   }

   public static class316[] method423(byte var0) {
      return new class316[]{class316.field3771, class316.field3775, class316.field3774, class316.field3772, class316.field3773};
   }

   public static void method422(int var0, class247 var1, String var2, String var3, int var4, boolean var5, int var6) {
      int var7 = var1.method4642(var2, -856808937);
      int var8 = var1.method4643(var7, var3, -981702486);
      class65.method1602(var0, var1, var7, var8, var4, var5, (byte)125);
   }
}
