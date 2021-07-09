package client;

public final class class79 extends class127 {
   static final int field1145 = 19136896;
   static final int field1146 = 2;
   int field1120;
   boolean field1133 = false;
   int field1122;
   int field1127;
   double field1144;
   double field1131;
   int field1143 = 0;
   int field1130;
   int field1134 = 0;
   int field1141;
   double field1125;
   double field1136;
   int field1132;
   int field1121;
   double field1137;
   double field1139;
   double field1138;
   int field1124;
   int field1126;
   double field1129;
   int field1128;
   int field1135;
   int field1140;
   int field1123;
   class273 field1142;

   class79(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field1120 = var1;
      this.field1121 = var2;
      this.field1122 = var3;
      this.field1130 = var4;
      this.field1124 = var5;
      this.field1126 = var6;
      this.field1127 = var7;
      this.field1128 = var8;
      this.field1132 = var9;
      this.field1135 = var10;
      this.field1123 = var11;
      this.field1133 = false;
      int var12 = class57.method1035(this.field1120, -1849734490).field3271;
      if(var12 != -1) {
         this.field1142 = class3.method25(var12, 686790310);
      } else {
         this.field1142 = null;
      }

   }

   protected final class119 vmethod3067(int var1) {
      class258 var2 = class57.method1035(this.field1120, -2126019037);
      class119 var3 = var2.method4866(this.field1143, -1102070643);
      if(var3 == null) {
         return null;
      } else {
         var3.method2680(this.field1141);
         return var3;
      }
   }

   final void method1850(int var1, int var2) {
      this.field1133 = true;
      this.field1144 += this.field1131 * (double)var1;
      this.field1125 += this.field1136 * (double)var1;
      this.field1137 += (double)var1 * 0.5D * this.field1139 * (double)var1 + (double)var1 * this.field1138;
      this.field1138 += this.field1139 * (double)var1;
      this.field1140 = (int)(Math.atan2(this.field1131, this.field1136) * 325.949D) + 1024 & 2047;
      this.field1141 = (int)(Math.atan2(this.field1138, this.field1129) * 325.949D) & 2047;
      if(this.field1142 != null) {
         this.field1134 += var1;

         while(true) {
            do {
               do {
                  if(this.field1134 <= this.field1142.field3541[this.field1143]) {
                     return;
                  }

                  this.field1134 -= this.field1142.field3541[this.field1143];
                  ++this.field1143;
               } while(this.field1143 < this.field1142.field3540.length);

               this.field1143 -= this.field1142.field3544;
               if(this.field1143 < 0) {
                  break;
               }

               if(var2 >= 730012985) {
                  return;
               }
            } while(this.field1143 < this.field1142.field3540.length);

            this.field1143 = 0;
         }
      }
   }

   final void method1849(int var1, int var2, int var3, int var4, int var5) {
      double var6;
      if(!this.field1133) {
         var6 = (double)(var1 - this.field1122);
         double var8 = (double)(var2 - this.field1130);
         double var10 = Math.sqrt(var8 * var8 + var6 * var6);
         this.field1144 = (double)this.field1122 + (double)this.field1132 * var6 / var10;
         this.field1125 = (double)this.field1132 * var8 / var10 + (double)this.field1130;
         this.field1137 = (double)this.field1124;
      }

      var6 = (double)(this.field1127 + 1 - var4);
      this.field1131 = ((double)var1 - this.field1144) / var6;
      this.field1136 = ((double)var2 - this.field1125) / var6;
      this.field1129 = Math.sqrt(this.field1131 * this.field1131 + this.field1136 * this.field1136);
      if(!this.field1133) {
         this.field1138 = -this.field1129 * Math.tan(0.02454369D * (double)this.field1128);
      }

      this.field1139 = ((double)var3 - this.field1137 - var6 * this.field1138) * 2.0D / (var6 * var6);
   }
}
