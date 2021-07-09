package client;

public class class226 {
   static int mapBaseZ;
   static int field2563;
   static final int field2566 = 5;
   public int field2567;
   public int field2564;
   public int field2565;

   public class226(class226 var1) {
      this.field2567 = var1.field2567;
      this.field2564 = var1.field2564;
      this.field2565 = var1.field2565;
   }

   public class226(int var1, int var2, int var3) {
      this.field2567 = var1;
      this.field2564 = var2;
      this.field2565 = var3;
   }

   public class226() {
      this.field2567 = -1;
   }

   public class226(int var1) {
      if(var1 == -1) {
         this.field2567 = -1;
      } else {
         this.field2567 = var1 >> 28 & 3;
         this.field2564 = var1 >> 14 & 16383;
         this.field2565 = var1 & 16383;
      }

   }

   String method4441(String var1, int var2) {
      return this.field2567 + var1 + (this.field2564 >> 6) + var1 + (this.field2565 >> 6) + var1 + (this.field2564 & 63) + var1 + (this.field2565 & 63);
   }

   public int method4437(int var1) {
      return this.field2567 << 28 | this.field2564 << 14 | this.field2565;
   }

   public void method4436(int var1, int var2, int var3, int var4) {
      this.field2567 = var1;
      this.field2564 = var2;
      this.field2565 = var3;
   }

   boolean method4439(class226 var1, int var2) {
      return this.field2567 != var1.field2567 ? false : (this.field2564 != var1.field2564 ? false : this.field2565 == var1.field2565);
   }

   public int hashCode() {
      return this.method4437(1904396734);
   }

   public String toString() {
      return this.method4441(",", -1171766630);
   }

   public boolean equals(Object var1) {
      return this == var1 ? true : (!(var1 instanceof class226) ? false : this.method4439((class226)var1, -1097701365));
   }
}
