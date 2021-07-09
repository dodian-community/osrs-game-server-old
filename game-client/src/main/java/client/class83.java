package client;

import java.util.HashMap;
import java.util.Map;

public class class83 {
   static int field1186 = 0;
   static final Map field1180 = new HashMap();
   static final class197 field1181 = new class197(1024);
   static final class215 field1184 = new class215();
   static final int field1182 = 32;
   public static final int field1183 = 35;
   static final int field1185 = 91;
   static final int field1187 = 8;

   static final void method1940(int var0) {
      int var1 = class48.field435;
      int var2 = class0.field1;
      int var3 = class135.field1856;
      int var4 = class151.field1933;
      int var5 = 6116423;
      Rasterizer2D.method5763(var1, var2, var3, var4, var5);
      Rasterizer2D.method5763(var1 + 1, var2 + 1, var3 - 2, 16, 0);
      Rasterizer2D.method5734(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
      class293.field3660.method5522("Choose Option", var1 + 3, var2 + 14, var5, -1);
      int var6 = class48.field425;
      int var7 = class48.field426 * 673804999;

      int var8;
      int var9;
      int var10;
      for(var8 = 0; var8 < GameClient.field771; var8++) {
         var9 = var2 + (GameClient.field771 - 1 - var8) * 15 + 31;
         var10 = 16777215;
         if(var6 > var1 && var6 < var3 + var1) {
            if(var0 <= 875717645) {
               return;
            }

            if(var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }
         }

         class293.field3660.method5522(class18.method176(var8, 1591082216), var1 + 3, var9, var10, 0);
      }

      var8 = class48.field435;
      var9 = class0.field1;
      var10 = class135.field1856;
      int var11 = class151.field1933;

      for(int var12 = 0; var12 < GameClient.field603; var12++) {
         if(GameClient.field641[var12] + GameClient.field786[var12] > var8 && GameClient.field786[var12] < var8 + var10 && GameClient.field789[var12] + GameClient.field787[var12] > var9 && GameClient.field787[var12] < var9 + var11) {
            GameClient.field788[var12] = true;
         }
      }

   }

   static final void method1933(String var0, boolean var1, int var2) {
      if(GameClient.field677) {
         byte var3 = 4;
         int var4 = var3 + 6;
         int var5 = var3 + 6;
         int var6 = class63.field933.method5519(var0, 250);
         int var7 = class63.field933.method5520(var0, 250) * 13;
         Rasterizer2D.method5763(var4 - var3, var5 - var3, var3 + var6 + var3, var3 + var3 + var7, 0);
         Rasterizer2D.method5734(var4 - var3, var5 - var3, var3 + var6 + var3, var7 + var3 + var3, 16777215);
         class63.field933.method5526(var0, var4, var5, var6, var7, 16777215, -1, 1, 1, 0);
         class48.method948(var4 - var3, var5 - var3, var3 + var6 + var3, var3 + var3 + var7, 1368654361);
         if(var1) {
            class163.field2014.vmethod5809(0, 0, -1986786716);
         } else {
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;
            int var11 = var7;

            for(int var12 = 0; var12 < GameClient.field603; var12++) {
               if(GameClient.field641[var12] + GameClient.field786[var12] > var8 && GameClient.field786[var12] < var8 + var10 && GameClient.field789[var12] + GameClient.field787[var12] > var9 && GameClient.field787[var12] < var11 + var9) {
                  GameClient.field788[var12] = true;
               }
            }
         }

      }
   }

   static final void method1923(Widget[] var0, int var1, int var2) {
      for(int var3 = 0; var3 < var0.length; var3++) {
         Widget var4 = var0[var3];
         if(var4 == null) {
            if(var2 <= -1143153222) {
               return;
            }
         } else {
            if(var4.widgetType == 0) {
               if(var4.children != null) {
                  method1923(var4.children, var1, 655983779);
               }

               class55 var5 = (class55) GameClient.field741.get((long)var4.interfaceHash);
               if(var5 != null) {
                  if(var2 <= -1143153222) {
                     return;
                  }

                  int var6 = var5.field501;
                  if(class261.method4931(var6, (byte)19)) {
                     method1923(Widget.LOADED[var6], var1, 1053089610);
                  }
               }
            }

            ScriptInvocation var7;
            if(var1 == 0 && var4.field2654 != null) {
               if(var2 <= -1143153222) {
                  return;
               }

               var7 = new ScriptInvocation();
               var7.field506 = var4;
               var7.parameters = var4.field2654;
               class68.method1696(var7);
            }

            if(var1 == 1 && var4.field2714 != null) {
               if(var4.childId >= 0) {
                  if(var2 <= -1143153222) {
                     return;
                  }

                  Widget var8 = Widget.getLoaded(var4.interfaceHash);
                  if(var8 == null || var8.children == null || var4.childId >= var8.children.length) {
                     continue;
                  }

                  if(var2 <= -1143153222) {
                     return;
                  }

                  if(var4 != var8.children[var4.childId]) {
                     if(var2 <= -1143153222) {
                        return;
                     }
                     continue;
                  }
               }

               var7 = new ScriptInvocation();
               var7.field506 = var4;
               var7.parameters = var4.field2714;
               class68.method1696(var7);
            }
         }
      }

   }
}
