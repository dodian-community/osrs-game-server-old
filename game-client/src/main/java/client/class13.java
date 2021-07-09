package client;

import java.net.URL;

public class class13 {
   static int field82;
   static PaletteSprite[] field85;
   static int field84;
   public static final int field86 = 64;
   static final int field87 = 101;
   int field83;
   class226 field88;

   class13(int var1, class226 var2) {
      this.field83 = var1;
      this.field88 = var2;
   }

   public static PaletteSprite[] method113(class247 var0, String var1, String var2, int var3) {
      int var4 = var0.method4642(var1, -943655085);
      int var5 = var0.method4643(var4, var2, -981702486);
      return class21.method278(var0, var4, var5, -711086556);
   }

   static boolean method112(String var0, int var1, String var2, short var3) {
      if(var1 == 0) {
         try {
            if(!class45.field379.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var5 = 0; var5 < var0.length(); var5++) {
                  if(var11.indexOf(var0.charAt(var5)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var4 = class41.method700(class45.field378, var2, new Object[]{(new URL(class45.field378.getCodeBase(), var0)).toString()}, 1204424801);
            return var4 != null;
         } catch (Throwable var7) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class45.field378.getAppletContext().showDocument(new URL(class45.field378.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class41.method702(class45.field378, "loggedout", -1855458099);
         } catch (Throwable var10) {
            ;
         }

         try {
            class45.field378.getAppletContext().showDocument(new URL(class45.field378.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var9) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   static int method111(int var0, class84 var1, boolean var2, short var3) {
      Widget var4 = Widget.getLoaded(class69.field999[--class69.field1003]);
      if(var0 == 2600) {
         class69.field999[++class69.field1003 - 1] = var4.field2626;
         return 1;
      } else if(var0 == 2601) {
         class69.field999[++class69.field1003 - 1] = var4.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class69.field1001[++class55.field497 - 1] = var4.componentString;
         return 1;
      } else if(var0 == 2603) {
         class69.field999[++class69.field1003 - 1] = var4.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class69.field999[++class69.field1003 - 1] = var4.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class69.field999[++class69.field1003 - 1] = var4.zoom;
         return 1;
      } else if(var0 == 2606) {
         class69.field999[++class69.field1003 - 1] = var4.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class69.field999[++class69.field1003 - 1] = var4.int477;
         return 1;
      } else if(var0 == 2608) {
         class69.field999[++class69.field1003 - 1] = var4.rotationY;
         return 1;
      } else if(var0 == 2609) {
         class69.field999[++class69.field1003 - 1] = var4.alpha;
         return 1;
      } else if(var0 == 2610) {
         class69.field999[++class69.field1003 - 1] = var4.field2608;
         return 1;
      } else if(var0 == 2611) {
         class69.field999[++class69.field1003 - 1] = var4.color;
         return 1;
      } else if(var0 == 2612) {
         class69.field999[++class69.field1003 - 1] = var4.field2631;
         return 1;
      } else if(var0 == 2613) {
         class69.field999[++class69.field1003 - 1] = var4.field2701.vmethod5815((byte)63);
         return 1;
      } else if(var0 == 2614) {
         class69.field999[++class69.field1003 - 1] = var4.field2726 ? 1 : 0;
         return 1;
      } else {
         return 2;
      }
   }
}
