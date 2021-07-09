package client;

public class class24 {
   static final class24 field208 = new class24(0);
   static final class24 field204 = new class24(1);
   static class249 field207;
   static int field203;
   static final int field206 = 26;
   final int field205;

   class24(int var1) {
      this.field205 = var1;
   }

   static int method425(Widget var0, byte var1) {
      class211 var2 = (class211) GameClient.interfaceSettings.get((long)var0.childId + ((long)var0.interfaceHash << 32));
      return var2 != null ? var2.field2438 : var0.defaultSettings;
   }

   static final void method424(boolean var0, int var1) {
      for(int var2 = 0; var2 < GameClient.field622; var2++) {
         Npc var3 = GameClient.field843[GameClient.field639[var2]];
         if(var3 != null) {
            if(var1 != -1818336157) {
               return;
            }

            if(var3.vmethod1786((byte)5)) {
               if(var1 != -1818336157) {
                  return;
               }

               if(var3.definition.bool58 == var0 && var3.definition.method5165()) {
                  int var4 = var3.field931 >> 7;
                  int var5 = var3.field881 >> 7;
                  if(var4 >= 0) {
                     if(var1 != -1818336157) {
                        return;
                     }

                     if(var4 < 104 && var5 >= 0 && var5 < 104) {
                        if(var1 != -1818336157) {
                           return;
                        }

                        if(var3.field874 == 1) {
                           if(var1 != -1818336157) {
                              return;
                           }

                           if((var3.field931 & 127) == 64 && (var3.field881 & 127) == 64) {
                              if(GameClient.field761[var4][var5] == GameClient.field687) {
                                 if(var1 != -1818336157) {
                                    return;
                                 }
                                 continue;
                              }

                              GameClient.field761[var4][var5] = GameClient.field687;
                           }
                        }

                        long var6 = class76.method1804(0, 0, 1, !var3.definition.bool61, GameClient.field639[var2], 1718101746);
                        var3.field889 = GameClient.field591;
                        class28.field248.method2883(class13.field82, var3.field931, var3.field881, class27.method460(var3.field874 * 64 - 64 + var3.field931, var3.field874 * 64 - 64 + var3.field881, class13.field82, -454316361), var3.field874 * 64 - 64 + 60, var3, var3.field905, var6, var3.field873);
                     }
                  }
               }
            }
         }
      }

   }
}
