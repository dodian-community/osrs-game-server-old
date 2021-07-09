package client;

public final class class181 {
   public static class67 field2332;
   static final int field2306 = 31;
   final int field2333 = 4096;
   final int field2320 = 16;
   final int field2327 = 258;
   final int field2300 = 6;
   final int field2298 = 50;
   final int field2299 = 18002;
   int field2326 = 0;
   int field2313 = 0;
   int[] field2315 = new int[256];
   int[] field2317 = new int[257];
   boolean[] field2319 = new boolean[256];
   boolean[] field2296 = new boolean[16];
   byte[] field2321 = new byte[256];
   byte[] field2322 = new byte[4096];
   int[] field2323 = new int[16];
   byte[] field2324 = new byte[18002];
   byte[] field2294;
   byte[] field2328 = new byte[18002];
   byte[][] field2303 = new byte[6][258];
   int[][] field2301 = new int[6][258];
   byte[] field2305;
   int[][] field2297 = new int[6][258];
   int[][] field2329 = new int[6][258];
   int[] field2330 = new int[6];
   int field2310;
   int field2316;
   int field2309;
   int field2302;
   int field2295;
   int field2311;
   int field2312;
   int field2318;
   int field2308;
   byte field2307;
   int field2304;
   int field2325;
   int field2314;
   int field2331;

   public static void method3529(class174 var0, short var1) {
      class300.field3712 = var0;
   }

   static void method3527(int var0) {
      if(GameClient.field663) {
         if(var0 <= -960665687) {
            return;
         }

         if(class138.field1876 != null) {
            int var1 = class138.field1876.field922[0];
            int var2 = class138.field1876.field872[0];
            if(var1 < 0 || var2 < 0) {
               return;
            }

            if(var0 <= -960665687) {
               return;
            }

            if(var1 >= 104) {
               return;
            }

            if(var2 >= 104) {
               if(var0 <= -960665687) {
                  return;
               }

               return;
            }

            class109.field1428 = class138.field1876.field931;
            int var3 = class27.method460(class138.field1876.field931, class138.field1876.field881, class13.field82, -1878603297) - GameClient.field644;
            if(var3 < ItemDef.field3478) {
               ItemDef.field3478 = var3;
            }

            class2.field23 = class138.field1876.field881;
            GameClient.field663 = false;
         }
      }

   }

   static int method3526(int var0, class84 var1, boolean var2, int var3) {
      int var4;
      if(var0 == 5504) {
         class69.field1003 -= 2;
         var4 = class69.field999[class69.field1003];
         int var5 = class69.field999[class69.field1003 + 1];
         if(!GameClient.field822) {
            GameClient.field649 = var4;
            GameClient.field717 = var5;
         }

         return 1;
      } else if(var0 == 5505) {
         class69.field999[++class69.field1003 - 1] = GameClient.field649;
         return 1;
      } else if(var0 == 5506) {
         class69.field999[++class69.field1003 - 1] = GameClient.field717;
         return 1;
      } else if(var0 == 5530) {
         var4 = class69.field999[--class69.field1003];
         if(var4 < 0) {
            var4 = 0;
         }

         GameClient.field644 = var4;
         return 1;
      } else if(var0 == 5531) {
         class69.field999[++class69.field1003 - 1] = GameClient.field644;
         return 1;
      } else {
         return 2;
      }
   }

   static void method3528(int var0, int var1, int var2, ObjectDef var3, int var4, int var5) {
      class68 var6;
      int var7;
      int var8;
      label26: {
         var6 = new class68();
         var6.field981 = var0;
         var6.field988 = var1 * 128;
         var6.field983 = var2 * 128;
         var7 = var3.int693;
         var8 = var3.int688;
         if(var4 != 1) {
            if(var4 != 3) {
               break label26;
            }

            if(var5 >= 1436835748) {
               return;
            }
         }

         var7 = var3.int688;
         var8 = var3.int693;
      }

      var6.field984 = (var7 + var1) * 128;
      var6.field992 = (var8 + var2) * 128;
      var6.field987 = var3.int709;
      var6.field991 = var3.int710 * 128;
      var6.field989 = var3.int711;
      var6.field982 = var3.int712;
      var6.field986 = var3.intArray114;
      if(var3.intArray116 != null) {
         var6.field994 = var3;
         var6.method1688((byte)-73);
      }

      class68.field985.method4073(var6);
      if(var6.field986 != null) {
         var6.field990 = var6.field989 + (int)(Math.random() * (double)(var6.field982 - var6.field989));
      }

   }
}
