package client;

import java.util.HashMap;

public class class296 {
   class247 field3681;
   class247 field3679;
   HashMap field3680;

   public class296(class247 var1, class247 var2) {
      this.field3681 = var1;
      this.field3679 = var2;
      this.field3680 = new HashMap();
   }

   public HashMap method5504(class295[] var1, byte var2) {
      HashMap var3 = new HashMap();
      class295[] var4 = var1;

      for(int var5 = 0; var5 < var4.length; var5++) {
         class295 var6 = var4[var5];
         if(this.field3680.containsKey(var6)) {
            var3.put(var6, this.field3680.get(var6));
         } else {
            class247 var8 = this.field3681;
            class247 var9 = this.field3679;
            String var10 = var6.field3666;
            int var11 = var8.method4642(var10, 258440210);
            int var12 = var8.method4643(var11, "", -981702486);
            class298 var7 = class58.method1058(var8, var9, var11, var12, -2132588897);
            if(var7 != null) {
               this.field3680.put(var6, var7);
               var3.put(var6, var7);
            }
         }
      }

      return var3;
   }
}
