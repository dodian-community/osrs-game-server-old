package client;

public class class310 {
   static final int field3742 = 200;
   static final int field3744 = 7;
   public int field3746;
   public int field3743;
   public int field3747;
   public int field3745;

   public class310(int var1, int var2, int var3, int var4) {
      this.method5679(var1, var2, 1588913620);
      this.method5680(var3, var4, -997918539);
   }

   public class310(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   void method5682(class310 var1, class310 var2, byte var3) {
      var2.field3746 = this.field3746;
      var2.field3747 = this.field3747;
      if(this.field3746 < var1.field3746) {
         var2.field3747 -= var1.field3746 - this.field3746;
         var2.field3746 = var1.field3746;
      }

      if(var2.method5684((byte)-33) > var1.method5684((byte)-35)) {
         var2.field3747 -= var2.method5684((byte)-95) - var1.method5684((byte)-70);
      }

      if(var2.field3747 < 0) {
         var2.field3747 = 0;
      }

   }

   public void method5679(int var1, int var2, int var3) {
      this.field3746 = var1;
      this.field3743 = var2;
   }

   void method5683(class310 var1, class310 var2, int var3) {
      var2.field3743 = this.field3743;
      var2.field3745 = this.field3745;
      if(this.field3743 < var1.field3743) {
         if(var3 != -1807714345) {
            return;
         }

         var2.field3745 -= var1.field3743 - this.field3743;
         var2.field3743 = var1.field3743;
      }

      if(var2.method5685(1611748891) > var1.method5685(1225075735)) {
         var2.field3745 -= var2.method5685(1739091462) - var1.method5685(1820334341);
      }

      if(var2.field3745 < 0) {
         var2.field3745 = 0;
      }

   }

   public void method5680(int var1, int var2, int var3) {
      this.field3747 = var1;
      this.field3745 = var2;
   }

   int method5684(byte var1) {
      return this.field3746 + this.field3747;
   }

   int method5685(int var1) {
      return this.field3743 + this.field3745;
   }

   public void method5681(class310 var1, class310 var2, int var3) {
      this.method5682(var1, var2, (byte)-2);
      this.method5683(var1, var2, -1807714345);
   }

   public String toString() {
      return null;
   }

   public static void method5697(byte var0) {
      class313.field3759 = new class203();
   }
}
