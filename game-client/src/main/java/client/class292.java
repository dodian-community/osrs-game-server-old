package client;

public class class292 extends class287 {
   static final int field3645 = 50;
   static final int field3646 = 10;
   static final int field3647 = 64;
   static final int field3649 = 2000;
   boolean field3648;
   boolean field3650;

   int method5452(class292 var1, int var2) {
      return super.field3628 == GameClient.field581 && GameClient.field581 != var1.field3628 ? -1 : (GameClient.field581 == var1.field3628 && super.field3628 != GameClient.field581 ? 1 : (super.field3628 != 0 && var1.field3628 == 0 ? -1 : (var1.field3628 != 0 && super.field3628 == 0 ? 1 : (this.field3648 && !var1.field3648 ? -1 : (!this.field3648 && var1.field3648 ? 1 : (this.field3650 && !var1.field3650 ? -1 : (!this.field3650 && var1.field3650 ? 1 : (super.field3628 != 0 ? super.field3627 - var1.field3627 : var1.field3627 - super.field3627))))))));
   }

   public int vmethod5453(class282 var1, byte var2) {
      return this.method5452((class292)var1, -1480802268);
   }

   public int compareTo(Object var1) {
      return this.method5452((class292)var1, 1391171788);
   }
}
