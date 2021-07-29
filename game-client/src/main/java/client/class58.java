package client;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;

public class class58 extends class206 {
   static final int field530 = 512;
   static final int field538 = 1;
   public static final int field541 = 35;
   static final int field542 = 14;
   class289 field536;
   String field531;
   class289 field539;
   class291 field534;
   int field540;
   int field535;
   int field532;
   String field537;
   String field533;

   class58(int var1, String var2, String var3, String var4) {
      this.field539 = class289.field3633;
      this.field536 = class289.field3633;
      int var5 = ++class83.field1186 - 1;
      this.field540 = var5;
      this.field535 = GameClient.field591;
      this.field532 = var1;
      this.field531 = var2;
      this.method1044(-2077717645);
      this.field537 = var3;
      this.field533 = var4;
   }

   void method1041(int var1) {
      class289 var10001;
      if(class181.field2332.field970.method5329(this.field534, -478572570)) {
         if(var1 != -1665152249) {
            return;
         }

         var10001 = class289.field3631;
      } else {
         var10001 = class289.field3634;
      }

      this.field539 = var10001;
   }

   void method1061(int var1) {
      this.field536 = class181.field2332.field975.method5329(this.field534, -1073305772) ? class289.field3631 : class289.field3634;
   }

   void method1070(int var1, String var2, String var3, String var4) {
      int var6 = ++class83.field1186 - 1;
      this.field540 = var6;
      this.field535 = GameClient.field591;
      this.field532 = var1;
      this.field531 = var2;
      this.method1044(-35699467);
      this.field537 = var3;
      this.field533 = var4;
   }

   final void method1044(int var1) {
      if(this.field531 != null) {
         this.field534 = new class291(class139.method3138(this.field531, 497607232), class36.field306);
      } else {
         this.field534 = null;
      }

   }

   void method1042(int var1) {
      this.field536 = class289.field3633;
   }

   void method1048(int var1) {
      this.field539 = class289.field3633;
   }

   final boolean method1040(int var1) {
      if(this.field539 == class289.field3633) {
         this.method1041(-1665152249);
      }

      return this.field539 == class289.field3631;
   }

   final boolean method1043(int var1) {
      if(this.field536 == class289.field3633) {
         this.method1061(-2118903561);
      }

      return this.field536 == class289.field3631;
   }

   public static class298 method1058(class247 var0, class247 var1, int var2, int var3, int var4) {
      if(!class306.method5660(var0, var2, var3, 820291581)) {
         return null;
      } else {
         byte[] var6 = var1.method4625(var2, var3, -103754325);
         class298 var5;
         if(var6 == null) {
            var5 = null;
         } else {
            class298 var7 = new class298(var6, class7.field45, class225.field2562, class319.field3800, class319.field3799, class172.field2260, class319.field3801);
            class7.field45 = null;
            class225.field2562 = null;
            class319.field3800 = null;
            class319.field3799 = null;
            class172.field2260 = null;
            class319.field3801 = null;
            var5 = var7;
         }

         return var5;
      }
   }

   public static void method1069(class247 var0, int var1) {
      class259.field3283 = var0;
   }

   static void method1053(String var0, boolean var1, String var2, boolean var3, byte var4) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var6) {
               ;
            }
         }

         if(class45.field379.startsWith("win") && !var3) {
            class128.method3071(var0, 0, 1930463682);
            return;
         }

         if(class45.field379.startsWith("mac")) {
            if(var4 != 15) {
               return;
            }

            class13.method112(var0, 1, var2, (short)-4835);
            return;
         }

         class128.method3071(var0, 2, 465368312);
      } else {
         class128.method3071(var0, 3, -1563749679);
      }

   }

   static final void method1068(class63 var0, int var1, byte var2) {
      class238.method4594(var0.field931, var0.field881, var1, 925699917);
   }
}
