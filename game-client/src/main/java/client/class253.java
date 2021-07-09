package client;

public class class253 extends class206 {
   static class200 field3228 = new class200(64);
   static boolean field3229;
   static class247 field3226;
   public int field3227 = 0;

   void method4805(Stream var1, int var2, int var3) {
      if(var2 == 2) {
         this.field3227 = var1.readUShort();
      }

   }

   void method4799(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4805(var1, var3, 646065158);
      }
   }

   static final void method4808(int var0, int var1, int var2) {
      class205 var3 = GameClient.field708[class13.field82][var0][var1];
      if(var3 == null) {
         if(var2 > 841271773) {
            class28.field248.method2877(class13.field82, var0, var1);
         }
      } else {
         long var4 = -99999999L;
         Item var6 = null;

         Item var7;
         for(var7 = (Item)var3.method4098(); var7 != null; var7 = (Item)var3.method4079()) {
            ItemDef var8 = ItemDef.loadItemDef(var7.id);
            long var9 = (long)var8.cost;
            if(var8.stackable == 1) {
               var9 *= (long)(var7.amt + 1);
            }

            if(var9 > var4) {
               var4 = var9;
               var6 = var7;
            }
         }

         if(var6 == null) {
            class28.field248.method2877(class13.field82, var0, var1);
         } else {
            var3.method4074(var6);
            Item var13 = null;
            Item var12 = null;

            for(var7 = (Item)var3.method4098(); var7 != null; var7 = (Item)var3.method4079()) {
               if(var7.id != var6.id) {
                  if(var2 <= 841271773) {
                     return;
                  }

                  if(var13 == null) {
                     if(var2 <= 841271773) {
                        return;
                     }

                     var13 = var7;
                  }

                  if(var13.id != var7.id && var12 == null) {
                     var12 = var7;
                  }
               }
            }

            long var10 = class76.method1804(var0, var1, 3, false, 0, 1575329310);
            class28.field248.method2879(class13.field82, var0, var1, class27.method460(var0 * 128 + 64, var1 * 128 + 64, class13.field82, 50268488), var6, var10, var13, var12);
         }
      }
   }
}
