package client;

public class class11 {
   static int field68;
   static int[] field69;
   static final int field64 = 2;
   static final int field65 = 1;
   static final int field66 = 3;
   static final int field67 = 0;

   static void method98(Player var0, boolean var1, int var2) {
      if(var0 != null && var0.vmethod1786((byte)5) && !var0.hidden) {
         label81: {
            label80: {
               var0.field560 = false;
               if(GameClient.field585) {
                  if(var2 >= 477409192) {
                     return;
                  }

                  if(class81.field1167 > 50) {
                     break label80;
                  }
               }

               if(class81.field1167 <= 200) {
                  break label81;
               }
            }

            if(var1 && var0.field893 == var0.field900) {
               var0.field560 = true;
            }
         }

         int var3 = var0.field931 >> 7;
         int var4 = var0.field881 >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var2 >= 477409192) {
               return;
            }

            long var5 = class76.method1804(0, 0, 0, false, var0.field574, 1942133853);
            if(var0.field563 != null) {
               if(var2 >= 477409192) {
                  return;
               }

               if(GameClient.field591 >= var0.field545 && GameClient.field591 < var0.field555) {
                  var0.field560 = false;
                  var0.field562 = class27.method460(var0.field931, var0.field881, class13.field82, -771189830);
                  var0.field889 = GameClient.field591;
                  class28.field248.method3010(class13.field82, var0.field931, var0.field881, var0.field562, 60, var0, var0.field905, var5, var0.field559, var0.field547, var0.field565, var0.field553);
                  return;
               }
            }

            if((var0.field931 & 127) == 64 && (var0.field881 & 127) == 64) {
               if(GameClient.field761[var3][var4] == GameClient.field687) {
                  if(var2 >= 477409192) {
                     return;
                  }

                  return;
               }

               GameClient.field761[var3][var4] = GameClient.field687;
            }

            var0.field562 = class27.method460(var0.field931, var0.field881, class13.field82, 1019769393);
            var0.field889 = GameClient.field591;
            class28.field248.method2883(class13.field82, var0.field931, var0.field881, var0.field562, 60, var0, var0.field905, var5, var0.field873);
         }
      }

   }

   static int method99(int var0) {
      return 11;
   }

   public static void method100(class247 var0, class247 var1, class247 var2, class247 var3, short var4) {
      Widget.staticJs5Index11 = var0;
      Widget.field2642 = var1;
      class154.field1956 = var2;
      Widget.field2598 = var3;
      Widget.LOADED = new Widget[Widget.staticJs5Index11.method4637(252467795) + 500][];
      class175.field2271 = new boolean[Widget.staticJs5Index11.method4637(105248180)];
   }
}
