package client;

import java.util.Comparator;

public class class61 implements Comparator {
   static class102 field577;
   static class249 field576;
   static final int field578 = 34;
   boolean field575;

   int method1123(class2 var1, class2 var2, byte var3) {
      if(var2.field19 == var1.field19) {
         return 0;
      } else {
         if(this.field575) {
            if(GameClient.field581 == var1.field19) {
               return -1;
            }

            if(var2.field19 == GameClient.field581) {
               return 1;
            }
         }

         return var1.field19 < var2.field19 ? -1 : 1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1123((class2)var1, (class2)var2, (byte)-86);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   static void method1129(class65 var0, byte var1) {
      if(var0.method1589((byte)73) != GameClient.field668) {
         GameClient.field668 = var0.method1589((byte)59);
         boolean var2 = var0.method1589((byte)123);
         if(var2 != ItemDef.field3426) {
            class57.method1036((byte)-113);
            ItemDef.field3426 = var2;
         }
      }

      class54.gameHost = var0.field950;
      GameClient.field581 = var0.field947;
      GameClient.field632 = var0.field948;
      class26.field223 = GameClient.field777 == 0 ? 43594 : var0.field947 + 40000;
      class68.field996 = GameClient.field777 == 0 ? 443 : var0.field947 + 50000;
      class290.field3636 = class26.field223;
   }

   static int method1126(int var0, class84 var1, boolean var2, int var3) {
      Widget var4 = Widget.getLoaded(class69.field999[--class69.field1003]);
      if(var0 == 2800) {
         class69.field999[++class69.field1003 - 1] = class154.method3252(class24.method425(var4, (byte)-67), (byte)35);
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var4.string29 == null) {
               class69.field1001[++class55.field497 - 1] = "";
            } else {
               class69.field1001[++class55.field497 - 1] = var4.string29;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var5 = class69.field999[--class69.field1003];
         --var5;
         if(var4.regularOptions != null && var5 < var4.regularOptions.length && var4.regularOptions[var5] != null) {
            class69.field1001[++class55.field497 - 1] = var4.regularOptions[var5];
         } else {
            class69.field1001[++class55.field497 - 1] = "";
         }

         return 1;
      }
   }

   static class58 method1130(int var0, byte var1) {
      return (class58)class83.field1181.method3945((long)var0);
   }
}
