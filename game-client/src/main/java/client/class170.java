package client;

public class class170 implements class167 {
   public static final class170 field2237 = new class170(14, 0);
   static final class170 field2236 = new class170(15, 4);
   public static final class170 field2235 = new class170(16, -2);
   public static final class170 field2238 = new class170(18, -2);
   static final class170[] field2240 = new class170[32];
   public final int field2239;

   static {
      class170[] var0 = new class170[]{field2235, field2236, field2237, field2238};
      class170[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; var2++) {
         field2240[var1[var2].field2239] = var1[var2];
      }

   }

   class170(int var1, int var2) {
      this.field2239 = var1;
   }

   static final void method3449(int plane, int rotation, int localX, int localZ, int objId, int var5, int objType, byte var7) {
      if(ClientObj.isRemoved(objId, localX, localZ, plane, objType, rotation))
         return;

      if(localX >= 1 && localZ >= 1 && localX <= 102 && localZ <= 102) {
         if(GameClient.field585 && plane != class13.field82) {
            return;
         }

         long var8 = 0L;
         boolean var10 = true;
         boolean var11 = false;
         boolean var12 = false;
         if(rotation == 0) {
            if(var7 == 0) {
               return;
            }

            var8 = class28.field248.method2898(plane, localX, localZ);
         }

         if(rotation == 1) {
            var8 = class28.field248.method2899(plane, localX, localZ);
         }

         if(rotation == 2) {
            var8 = class28.field248.method2900(plane, localX, localZ);
         }

         if(rotation == 3) {
            var8 = class28.field248.method2901(plane, localX, localZ);
         }

         int var13;
         if(var8 != 0L) {
            if(var7 == 0) {
               return;
            }

            var13 = class28.field248.method2902(plane, localX, localZ, var8);
            int var15 = PacketBuilder.method673(var8);
            int var16 = var13 & 31;
            int var17 = var13 >> 6 & 3;
            ObjectDef var14;
            if(rotation == 0) {
               class28.field248.method2889(plane, localX, localZ);
               var14 = class110.getObjectDef(var15);
               if(var14.clipType != 0) {
                  GameClient.field642[plane].method3391(localX, localZ, var16, var17, var14.isUnwalkable, -30475067);
               }
            }

            if(rotation == 1) {
               class28.field248.method2890(plane, localX, localZ);
            }

            if(rotation == 2) {
               class28.field248.method2891(plane, localX, localZ);
               var14 = class110.getObjectDef(var15);
               if(localX + var14.int693 > 103 || localZ + var14.int693 > 103 || localX + var14.int688 > 103 || localZ + var14.int688 > 103) {
                  return;
               }

               if(var14.clipType != 0) {
                  GameClient.field642[plane].method3399(localX, localZ, var14.int693, var14.int688, var17, var14.isUnwalkable, 1761910676);
               }
            }

            if(rotation == 3) {
               class28.field248.method2971(plane, localX, localZ);
               var14 = class110.getObjectDef(var15);
               if(var14.clipType == 1) {
                  GameClient.field642[plane].method3401(localX, localZ, -1440413395);
               }
            }
         }

         if(objId >= 0) {
            if(var7 == 0) {
               return;
            }

            var13 = plane;
            if(plane < 3 && (class50.field443[1][localX][localZ] & 2) == 2) {
               var13 = plane + 1;
            }

            class262.method4939(plane, var13, localX, localZ, objId, var5, objType, class28.field248, GameClient.field642[plane], (short)5648);
         }
      }

   }

   static void method3448(int var0) {
      for(int var1 = 0; var1 < GameClient.field771; var1++) {
         if(var0 == 287586055) {
            return;
         }

         if(class173.method3470(GameClient.field720[var1], (byte)1)) {
            if(var1 < GameClient.field771 - 1) {
               for(int var2 = var1; var2 < GameClient.field771 - 1; var2++) {
                  GameClient.field735[var2] = GameClient.field735[var2 + 1];
                  GameClient.field740[var2] = GameClient.field740[var2 + 1];
                  GameClient.field720[var2] = GameClient.field720[var2 + 1];
                  GameClient.field794[var2] = GameClient.field794[var2 + 1];
                  GameClient.field718[var2] = GameClient.field718[var2 + 1];
                  GameClient.field851[var2] = GameClient.field851[var2 + 1];
                  GameClient.field590[var2] = GameClient.field590[var2 + 1];
               }
            }

            --var1;
            --GameClient.field771;
         }
      }

      class184.method3785(class135.field1856 / 2 + class48.field435, class0.field1, 805819777);
   }
}
