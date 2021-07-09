package client;

public abstract class class160 {
   static final int field1984 = 43;

   public abstract int vmethod3331(int var1, int var2, int var3);

   public abstract void vmethod3330(int var1);

   static final void method3338(int var0, int var1, int var2, int var3) {
      int var4;
      for(var4 = 0; var4 < 8; var4++) {
         for(int var5 = 0; var5 < 8; var5++) {
            class50.field459[var0][var4 + var1][var5 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var4 = 1; var4 < 8; var4++) {
            class50.field459[var0][var1][var4 + var2] = class50.field459[var0][var1 - 1][var4 + var2];
         }
      }

      if(var2 > 0) {
         if(var3 <= -1165539329) {
            return;
         }

         for(var4 = 1; var4 < 8; var4++) {
            class50.field459[var0][var4 + var1][var2] = class50.field459[var0][var4 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class50.field459[var0][var1 - 1][var2] != 0) {
         class50.field459[var0][var1][var2] = class50.field459[var0][var1 - 1][var2];
      } else if(var2 > 0 && class50.field459[var0][var1][var2 - 1] != 0) {
         class50.field459[var0][var1][var2] = class50.field459[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class50.field459[var0][var1 - 1][var2 - 1] != 0) {
         class50.field459[var0][var1][var2] = class50.field459[var0][var1 - 1][var2 - 1];
      }

   }

   public static void method3344(class247 var0, byte var1) {
      class253.field3226 = var0;
   }

   static int method3341(int var0, class84 var1, boolean var2, int var3) {
      Widget var4;
      if(var0 == 2700) {
         var4 = Widget.getLoaded(class69.field999[--class69.field1003]);
         class69.field999[++class69.field1003 - 1] = var4.itemId;
         return 1;
      } else if(var0 == 2701) {
         var4 = Widget.getLoaded(class69.field999[--class69.field1003]);
         if(var4.itemId != -1) {
            class69.field999[++class69.field1003 - 1] = var4.field2727;
         } else {
            class69.field999[++class69.field1003 - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var6 = class69.field999[--class69.field1003];
         class55 var5 = (class55) GameClient.field741.get((long)var6);
         if(var5 != null) {
            class69.field999[++class69.field1003 - 1] = 1;
         } else {
            class69.field999[++class69.field1003 - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class69.field999[++class69.field1003 - 1] = GameClient.field683;
         return 1;
      } else {
         return 2;
      }
   }

   static final void method3342(int var0) {
      for(class62 var1 = (class62) GameClient.field714.method4098(); var1 != null; var1 = (class62) GameClient.field714.method4079()) {
         if(var1.field860 == -1) {
            var1.field855 = 0;
            class74.method1800(var1, (byte)7);
         } else {
            var1.unlink();
         }
      }

   }
}
