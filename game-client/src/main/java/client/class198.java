package client;

public class class198 {
   int[] field2401;

   public class198(int[] var1) {
      int var2;
      for(var2 = 1; var2 <= (var1.length >> 1) + var1.length; var2 <<= 1) {
         ;
      }

      this.field2401 = new int[var2 + var2];

      int var3;
      for(var3 = 0; var3 < var2 + var2; var3++) {
         this.field2401[var3] = -1;
      }

      int var4;
      for(var3 = 0; var3 < var1.length; this.field2401[var4 + var4 + 1] = var3++) {
         for(var4 = var1[var3] & var2 - 1; this.field2401[var4 + var4 + 1] != -1; var4 = var4 + 1 & var2 - 1) {
            ;
         }

         this.field2401[var4 + var4] = var1[var3];
      }

   }

   public int method3967(int var1) {
      int var2 = (this.field2401.length >> 1) - 1;
      int var3 = var1 & var2;

      while(true) {
         int var4 = this.field2401[var3 + var3 + 1];
         if(var4 == -1) {
            return -1;
         }

         if(this.field2401[var3 + var3] == var1) {
            return var4;
         }

         var3 = var3 + 1 & var2;
      }
   }
}
