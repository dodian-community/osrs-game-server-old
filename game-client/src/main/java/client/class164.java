package client;

public class class164 {
   static final int field2017 = 8;
   static final int field2018 = 19136911;
   static final int field2019 = 4096;
   static final int field2020 = 256;
   static final int field2021 = 28;
   static final int field2022 = 16384;
   static final int field2023 = 32768;
   static final int field2024 = 32;
   static final int field2028 = 16;
   public static final int field2031 = 0;
   static final int field2032 = 4;
   int field2027;
   int field2025 = 0;
   public int[][] field2029;
   int field2030;
   int field2026 = 0;

   public class164(int var1, int var2) {
      this.field2027 = var1;
      this.field2030 = var2;
      this.field2029 = new int[this.field2027][this.field2030];
      this.method3392((byte)62);
   }

   void method3400(int var1, int var2, int var3, int var4) {
      this.field2029[var1][var2] &= ~var3;
   }

   void method3397(int var1, int var2, int var3, short var4) {
      if (var1 >= 0 && var2 >= 0 && var1 < field2029.length && var2 <= field2029[var1].length)
         this.field2029[var1][var2] |= var3;
   }

   public void method3392(byte var1) {
      for(int var2 = 0; var2 < this.field2027; var2++) {
         for(int var3 = 0; var3 < this.field2030; var3++) {
            if(var2 != 0 && var3 != 0 && var2 < this.field2027 - 5 && var3 < this.field2030 - 5) {
               this.field2029[var2][var3] = 16777216;
            } else {
               this.field2029[var2][var3] = 16777215;
            }
         }
      }

   }

   public void method3391(int var1, int var2, int var3, int var4, boolean var5, int var6) {
      var1 -= this.field2025;
      var2 -= this.field2026;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method3400(var1, var2, 128, 2133692895);
            this.method3400(var1 - 1, var2, 8, 2033628388);
         }

         if(var4 == 1) {
            this.method3400(var1, var2, 2, 1801962100);
            this.method3400(var1, var2 + 1, 32, 2005470417);
         }

         if(var4 == 2) {
            if(var6 != -30475067) {
               return;
            }

            this.method3400(var1, var2, 8, 1816698770);
            this.method3400(var1 + 1, var2, 128, 1926931496);
         }

         if(var4 == 3) {
            this.method3400(var1, var2, 32, 1944856612);
            this.method3400(var1, var2 - 1, 2, 1960284203);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            if(var6 != -30475067) {
               return;
            }

            this.method3400(var1, var2, 1, 2111300794);
            this.method3400(var1 - 1, var2 + 1, 16, 2120571552);
         }

         if(var4 == 1) {
            this.method3400(var1, var2, 4, 2130412451);
            this.method3400(var1 + 1, var2 + 1, 64, 1881967006);
         }

         if(var4 == 2) {
            this.method3400(var1, var2, 16, 1807848401);
            this.method3400(var1 + 1, var2 - 1, 1, 2057386248);
         }

         if(var4 == 3) {
            this.method3400(var1, var2, 64, 2134939885);
            this.method3400(var1 - 1, var2 - 1, 4, 1931714137);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method3400(var1, var2, 130, 1950911889);
            this.method3400(var1 - 1, var2, 8, 2100422460);
            this.method3400(var1, var2 + 1, 32, 2084312974);
         }

         if(var4 == 1) {
            this.method3400(var1, var2, 10, 1803207255);
            this.method3400(var1, var2 + 1, 32, 2126153943);
            this.method3400(var1 + 1, var2, 128, 2099880609);
         }

         if(var4 == 2) {
            this.method3400(var1, var2, 40, 2082400273);
            this.method3400(var1 + 1, var2, 128, 2135553961);
            this.method3400(var1, var2 - 1, 2, 2055534739);
         }

         if(var4 == 3) {
            this.method3400(var1, var2, 160, 2110608140);
            this.method3400(var1, var2 - 1, 2, 2038311020);
            this.method3400(var1 - 1, var2, 8, 1894992731);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method3400(var1, var2, 65536, 1839466395);
               this.method3400(var1 - 1, var2, 4096, 2094536430);
            }

            if(var4 == 1) {
               this.method3400(var1, var2, 1024, 2093632018);
               this.method3400(var1, var2 + 1, 16384, 2109924010);
            }

            if(var4 == 2) {
               this.method3400(var1, var2, 4096, 1820691560);
               this.method3400(var1 + 1, var2, 65536, 2062694823);
            }

            if(var4 == 3) {
               if(var6 != -30475067) {
                  return;
               }

               this.method3400(var1, var2, 16384, 1868346145);
               this.method3400(var1, var2 - 1, 1024, 1973375343);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method3400(var1, var2, 512, 1862974731);
               this.method3400(var1 - 1, var2 + 1, 8192, 2077718574);
            }

            if(var4 == 1) {
               this.method3400(var1, var2, 2048, 1843123268);
               this.method3400(var1 + 1, var2 + 1, 32768, 2025914173);
            }

            if(var4 == 2) {
               this.method3400(var1, var2, 8192, 1955938829);
               this.method3400(var1 + 1, var2 - 1, 512, 1851869682);
            }

            if(var4 == 3) {
               this.method3400(var1, var2, 32768, 1802830983);
               this.method3400(var1 - 1, var2 - 1, 2048, 1840319487);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               if(var6 != -30475067) {
                  return;
               }

               this.method3400(var1, var2, 66560, 2127555634);
               this.method3400(var1 - 1, var2, 4096, 1991287706);
               this.method3400(var1, var2 + 1, 16384, 1926305078);
            }

            if(var4 == 1) {
               this.method3400(var1, var2, 5120, 1944759410);
               this.method3400(var1, var2 + 1, 16384, 2131903300);
               this.method3400(var1 + 1, var2, 65536, 1829153261);
            }

            if(var4 == 2) {
               this.method3400(var1, var2, 20480, 2005104533);
               this.method3400(var1 + 1, var2, 65536, 1972266309);
               this.method3400(var1, var2 - 1, 1024, 1972506834);
            }

            if(var4 == 3) {
               this.method3400(var1, var2, 81920, 2033780799);
               this.method3400(var1, var2 - 1, 1024, 1839808231);
               this.method3400(var1 - 1, var2, 4096, 1917600200);
            }
         }
      }

   }

   public void method3401(int var1, int var2, int var3) {
      var1 -= this.field2025;
      var2 -= this.field2026;
      this.field2029[var1][var2] &= -262145;
   }

   public void method3399(int var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
      int var8 = 256;
      if(var6) {
         var8 += 131072;
      }

      int var9;
      label58: {
         var1 -= this.field2025;
         var2 -= this.field2026;
         if(var5 != 1) {
            if(var7 <= 1578684136) {
               return;
            }

            if(var5 != 3) {
               break label58;
            }

            if(var7 <= 1578684136) {
               return;
            }
         }

         var9 = var3;
         var3 = var4;
         var4 = var9;
      }

      for(var9 = var1; var9 < var3 + var1; var9++) {
         if(var9 >= 0 && var9 < this.field2027) {
            for(int var10 = var2; var10 < var2 + var4; var10++) {
               if(var10 >= 0) {
                  if(var7 <= 1578684136) {
                     return;
                  }

                  if(var10 < this.field2030) {
                     this.method3400(var9, var10, var8, 1982211216);
                  }
               }
            }
         }
      }

   }

   public void method3410(int var1, int var2, byte var3) {
      var1 -= this.field2025;
      var2 -= this.field2026;
      this.field2029[var1][var2] |= 262144;
   }

   public void method3394(int var1, int var2, int var3, int var4, boolean var5, byte var6) {
      int var7 = 256;
      if(var5) {
         if(var6 <= 5) {
            return;
         }

         var7 += 131072;
      }

      var1 -= this.field2025;
      var2 -= this.field2026;

      for(int var8 = var1; var8 < var3 + var1; var8++) {
         if(var8 >= 0 && var8 < this.field2027) {
            for(int var9 = var2; var9 < var2 + var4; var9++) {
               if(var9 >= 0) {
                  if(var6 <= 5) {
                     return;
                  }

                  if(var9 < this.field2030) {
                     this.method3397(var8, var9, var7, (short)23621);
                  }
               }
            }
         }
      }

   }

   public void method3395(int var1, int var2, int var3) {
      var1 -= this.field2025;
      var2 -= this.field2026;
      this.field2029[var1][var2] |= 2097152;
   }

   public void method3393(int var1, int var2, int var3, int var4, boolean var5, int var6) {
      var1 -= this.field2025;
      var2 -= this.field2026;
      if(var3 == 0) {
         if(var6 <= 1233471634) {
            return;
         }

         if(var4 == 0) {
            this.method3397(var1, var2, 128, (short)9215);
            this.method3397(var1 - 1, var2, 8, (short)10660);
         }

         if(var4 == 1) {
            this.method3397(var1, var2, 2, (short)-10265);
            this.method3397(var1, var2 + 1, 32, (short)-5743);
         }

         if(var4 == 2) {
            this.method3397(var1, var2, 8, (short)568);
            this.method3397(var1 + 1, var2, 128, (short)1994);
         }

         if(var4 == 3) {
            this.method3397(var1, var2, 32, (short)4376);
            this.method3397(var1, var2 - 1, 2, (short)-18066);
         }
      }

      label195: {
         if(var3 != 1) {
            if(var6 <= 1233471634) {
               return;
            }

            if(var3 != 3) {
               break label195;
            }
         }

         if(var4 == 0) {
            this.method3397(var1, var2, 1, (short)-13574);
            this.method3397(var1 - 1, var2 + 1, 16, (short)-12538);
         }

         if(var4 == 1) {
            if(var6 <= 1233471634) {
               return;
            }

            this.method3397(var1, var2, 4, (short)-2792);
            this.method3397(var1 + 1, var2 + 1, 64, (short)16276);
         }

         if(var4 == 2) {
            this.method3397(var1, var2, 16, (short)8947);
            this.method3397(var1 + 1, var2 - 1, 1, (short)4891);
         }

         if(var4 == 3) {
            this.method3397(var1, var2, 64, (short)650);
            this.method3397(var1 - 1, var2 - 1, 4, (short)-2144);
         }
      }

      if(var3 == 2) {
         if(var6 <= 1233471634) {
            return;
         }

         if(var4 == 0) {
            this.method3397(var1, var2, 130, (short)-24616);
            this.method3397(var1 - 1, var2, 8, (short)2995);
            this.method3397(var1, var2 + 1, 32, (short)14628);
         }

         if(var4 == 1) {
            if(var6 <= 1233471634) {
               return;
            }

            this.method3397(var1, var2, 10, (short)8421);
            this.method3397(var1, var2 + 1, 32, (short)2696);
            this.method3397(var1 + 1, var2, 128, (short)10013);
         }

         if(var4 == 2) {
            this.method3397(var1, var2, 40, (short)-2763);
            this.method3397(var1 + 1, var2, 128, (short)8816);
            this.method3397(var1, var2 - 1, 2, (short)-4656);
         }

         if(var4 == 3) {
            if(var6 <= 1233471634) {
               return;
            }

            this.method3397(var1, var2, 160, (short)-8783);
            this.method3397(var1, var2 - 1, 2, (short)20231);
            this.method3397(var1 - 1, var2, 8, (short)-22250);
         }
      }

      if(var5) {
         if(var6 <= 1233471634) {
            return;
         }

         if(var3 == 0) {
            if(var4 == 0) {
               this.method3397(var1, var2, 65536, (short)396);
               this.method3397(var1 - 1, var2, 4096, (short)-9131);
            }

            if(var4 == 1) {
               this.method3397(var1, var2, 1024, (short)-23409);
               this.method3397(var1, var2 + 1, 16384, (short)20609);
            }

            if(var4 == 2) {
               if(var6 <= 1233471634) {
                  return;
               }

               this.method3397(var1, var2, 4096, (short)5922);
               this.method3397(var1 + 1, var2, 65536, (short)-18172);
            }

            if(var4 == 3) {
               this.method3397(var1, var2, 16384, (short)-10073);
               this.method3397(var1, var2 - 1, 1024, (short)5318);
            }
         }

         label199: {
            if(var3 != 1) {
               if(var3 != 3) {
                  break label199;
               }

               if(var6 <= 1233471634) {
                  return;
               }
            }

            if(var4 == 0) {
               this.method3397(var1, var2, 512, (short)-7878);
               this.method3397(var1 - 1, var2 + 1, 8192, (short)-24165);
            }

            if(var4 == 1) {
               this.method3397(var1, var2, 2048, (short)-10104);
               this.method3397(var1 + 1, var2 + 1, 32768, (short)22330);
            }

            if(var4 == 2) {
               if(var6 <= 1233471634) {
                  return;
               }

               this.method3397(var1, var2, 8192, (short)17852);
               this.method3397(var1 + 1, var2 - 1, 512, (short)21007);
            }

            if(var4 == 3) {
               this.method3397(var1, var2, 32768, (short)7339);
               this.method3397(var1 - 1, var2 - 1, 2048, (short)-4576);
            }
         }

         if(var3 == 2) {
            if(var6 <= 1233471634) {
               return;
            }

            if(var4 == 0) {
               this.method3397(var1, var2, 66560, (short)-8771);
               this.method3397(var1 - 1, var2, 4096, (short)7228);
               this.method3397(var1, var2 + 1, 16384, (short)-24683);
            }

            if(var4 == 1) {
               this.method3397(var1, var2, 5120, (short)978);
               this.method3397(var1, var2 + 1, 16384, (short)-9102);
               this.method3397(var1 + 1, var2, 65536, (short)-6025);
            }

            if(var4 == 2) {
               if(var6 <= 1233471634) {
                  return;
               }

               this.method3397(var1, var2, 20480, (short)10732);
               this.method3397(var1 + 1, var2, 65536, (short)-2242);
               this.method3397(var1, var2 - 1, 1024, (short)19208);
            }

            if(var4 == 3) {
               this.method3397(var1, var2, 81920, (short)-11539);
               this.method3397(var1, var2 - 1, 1024, (short)-10178);
               this.method3397(var1 - 1, var2, 4096, (short)-1016);
            }
         }
      }

   }
}
