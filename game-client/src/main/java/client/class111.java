package client;

public class class111 implements class131 {
   static Sprite[] field1446;
   public static final int field1445 = 20;
   int field1443 = 128;
   double field1442 = 1.0D;
   class116[] field1441;
   class205 field1444 = new class205();
   int field1439 = 0;
   int field1440;
   class247 field1438;

   public class111(class247 var1, class247 var2, int var3, double var4, int var6) {
      this.field1438 = var2;
      this.field1440 = var3;
      this.field1439 = this.field1440;
      this.field1442 = var4;
      this.field1443 = var6;
      int[] var7 = var1.method4668(0, 889237551);
      int var8 = var7.length;
      this.field1441 = new class116[var1.getFileCount(0)];

      for(int var9 = 0; var9 < var8; var9++) {
         Stream var10 = new Stream(var1.method4625(0, var7[var9], 850141327));
         this.field1441[var7[var9]] = new class116(var10);
      }

   }

   public void method2561(int var1) {
      for(int var2 = 0; var2 < this.field1441.length; var2++) {
         if(this.field1441[var2] != null) {
            this.field1441[var2].method2656();
         }
      }

      this.field1444 = new class205();
      this.field1439 = this.field1440;
   }

   public int vmethod3092(int var1, int var2) {
      return this.field1441[var1] != null ? this.field1441[var1].field1527 : 0;
   }

   public int[] vmethod3079(int var1, int var2) {
      class116 var3 = this.field1441[var1];
      if(var3 != null) {
         if(var3.field1539 != null) {
            this.field1444.method4074(var3);
            var3.field1540 = true;
            return var3.field1539;
         }

         boolean var4 = var3.method2661(this.field1442, this.field1443, this.field1438);
         if(var4) {
            if(this.field1439 == 0) {
               class116 var5 = (class116)this.field1444.method4080();
               var5.method2656();
            } else {
               --this.field1439;
            }

            this.field1444.method4074(var3);
            var3.field1540 = true;
            return var3.field1539;
         }
      }

      return null;
   }

   public boolean vmethod3082(int var1, int var2) {
      return this.field1443 == 64;
   }

   public boolean vmethod3081(int var1, byte var2) {
      return this.field1441[var1].field1530;
   }

   public int method2530(int var1) {
      int var2 = 0;
      int var3 = 0;
      class116[] var4 = this.field1441;

      for(int var5 = 0; var5 < var4.length; var5++) {
         class116 var6 = var4[var5];
         if(var6 != null && var6.field1533 != null) {
            var2 += var6.field1533.length;
            int[] var7 = var6.field1533;

            for(int var8 = 0; var8 < var7.length; var8++) {
               int var9 = var7[var8];
               if(this.field1438.method4627(var9, (byte)107)) {
                  ++var3;
               }
            }
         }
      }

      if(var2 == 0) {
         return 0;
      } else {
         return var3 * 100 / var2;
      }
   }

   public void method2544(double var1) {
      this.field1442 = var1;
      this.method2561(-770740340);
   }

   public void method2537(int var1, byte var2) {
      for(int var3 = 0; var3 < this.field1441.length; var3++) {
         class116 var4 = this.field1441[var3];
         if(var4 != null && var4.field1537 != 0) {
            if(var2 != 0) {
               return;
            }

            if(var4.field1540) {
               if(var2 != 0) {
                  return;
               }

               var4.method2657(var1);
               var4.field1540 = false;
            }
         }
      }

   }

   static void method2562(byte var0) {
      class81.field1167 = 0;

      for(int var1 = 0; var1 < 2048; var1++) {
         class81.field1157[var1] = null;
         class81.field1153[var1] = 1;
      }

   }

   static int method2531(int var0, class84 var1, boolean var2, byte var3) {
      if(var0 == 5630) {
         GameClient.field627 = 250;
         return 1;
      } else {
         return 2;
      }
   }
}
