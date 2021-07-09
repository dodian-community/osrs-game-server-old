package client;

import java.awt.Image;

public class class71 extends class204 {
   static Image field1028;
   static final int field1024 = 68;
   static final int field1027 = 4;
   public static final int field1029 = 12;
   static final int field1030 = 1;
   public static final int field1031 = 536870912;
   class203 field1026 = new class203();
   class261 field1025;

   class71(class261 var1) {
      this.field1025 = var1;
   }

   void method1772(int var1, int var2, int var3, int var4, int var5) {
      class64 var6 = null;
      int var7 = 0;

      for(class64 var8 = (class64)this.field1026.method4048(); var8 != null; var8 = (class64)this.field1026.method4033()) {
         if(var5 == -820723530) {
            return;
         }

         ++var7;
         if(var8.field934 == var1) {
            var8.method1559(var1, var2, var3, var4, -2116871828);
            return;
         }

         if(var8.field934 <= var1) {
            if(var5 == -820723530) {
               return;
            }

            var6 = var8;
         }
      }

      if(var6 == null) {
         if(var7 < 4) {
            this.field1026.method4038(new class64(var1, var2, var3, var4));
         }

      } else {
         class203.method4036(new class64(var1, var2, var3, var4), var6);
         if(var7 >= 4) {
            this.field1026.method4048().unlink();
         }

      }
   }

   class64 method1773(int var1, int var2) {
      class64 var3 = (class64)this.field1026.method4048();
      if(var3 != null && var3.field934 <= var1) {
         for(class64 var4 = (class64)this.field1026.method4033(); var4 != null && var4.field934 <= var1; var4 = (class64)this.field1026.method4033()) {
            var3.unlink();
            var3 = var4;
         }

         if(this.field1025.field3313 + var3.field934 + var3.field937 > var1) {
            return var3;
         } else {
            var3.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   boolean method1774(byte var1) {
      return this.field1026.method4043();
   }

   static Sprite method1781(int var0) {
      Sprite var1 = new Sprite();
      var1.maxWidth = class305.field3729;
      var1.maxHeight = class319.field3798;
      var1.offsetX = class7.field45[0];
      var1.offsetY = class225.field2562[0];
      var1.width = class319.field3800[0];
      var1.height = class319.field3799[0];
      int var2 = var1.height * var1.width;
      byte[] var3 = class319.field3801[0];
      var1.pixels = new int[var2];

      for(int var4 = 0; var4 < var2; var4++) {
         var1.pixels[var4] = class172.field2260[var3[var4] & 255];
      }

      class7.field45 = null;
      class225.field2562 = null;
      class319.field3800 = null;
      class319.field3799 = null;
      class172.field2260 = null;
      class319.field3801 = null;
      return var1;
   }
}
