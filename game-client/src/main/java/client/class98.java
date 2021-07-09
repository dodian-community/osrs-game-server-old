package client;

public class class98 {
   static int field1335;
   static final int field1330 = 19136770;
   static final long field1336 = -3932672073523589310L;
   class247 field1331;
   class247 field1334;
   class202 field1333 = new class202(256);
   class202 field1332 = new class202(256);

   public class98(class247 var1, class247 var2) {
      this.field1334 = var1;
      this.field1331 = var2;
   }

   class93 method2218(int var1, int var2, int[] var3, int var4) {
      int var5 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var5 |= var1 << 16;
      long var6 = (long)var5 ^ 4294967296L;
      class93 var8 = (class93)this.field1333.get(var6);
      if(var8 != null) {
         return var8;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class92 var9 = (class92)this.field1332.get(var6);
         if(var9 == null) {
            var9 = class92.method2088(this.field1331, var1, var2);
            if(var9 == null) {
               return null;
            }

            this.field1332.method4016(var9, var6);
         }

         var8 = var9.method2083(var3);
         if(var8 == null) {
            return null;
         } else {
            var9.unlink();
            this.field1333.method4016(var8, var6);
            return var8;
         }
      }
   }

   class93 method2223(int var1, int var2, int[] var3, byte var4) {
      int var5 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var5 |= var1 << 16;
      long var6 = (long)var5;
      class93 var8 = (class93)this.field1333.get(var6);
      if(var8 != null) {
         return var8;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class91 var9 = class91.method2071(this.field1334, var1, var2);
         if(var9 == null) {
            return null;
         } else {
            var8 = var9.method2069();
            this.field1333.method4016(var8, var6);
            if(var3 != null) {
               var3[0] -= var8.field1278.length;
            }

            return var8;
         }
      }
   }

   public class93 method2216(int var1, int[] var2, int var3) {
      if(this.field1334.method4637(1945443124) == 1) {
         return this.method2223(0, var1, var2, (byte)0);
      } else if(this.field1334.getFileCount(var1) == 1) {
         return this.method2223(var1, 0, var2, (byte)0);
      } else {
         throw new RuntimeException();
      }
   }

   public class93 method2220(int var1, int[] var2, int var3) {
      if(this.field1331.method4637(1456423423) == 1) {
         return this.method2218(0, var1, var2, 70852076);
      } else if(this.field1331.getFileCount(var1) == 1) {
         return this.method2218(var1, 0, var2, 1480108114);
      } else {
         throw new RuntimeException();
      }
   }
}
