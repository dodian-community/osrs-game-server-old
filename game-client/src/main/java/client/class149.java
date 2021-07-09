package client;

public class class149 extends class160 {
   long field1918 = System.nanoTime();

   public int vmethod3331(int var1, int var2, int var3) {
      long var4 = 1000000L * (long)var2;
      long var6 = this.field1918 - System.nanoTime();
      if(var6 < var4) {
         var6 = var4;
      }

      class63.method1539(var6 / 1000000L);
      long var8 = System.nanoTime();

      int var10;
      for(var10 = 0; var10 < 10 && (var10 < 1 || this.field1918 < var8); this.field1918 += 1000000L * (long)var1) {
         ++var10;
      }

      if(this.field1918 < var8) {
         this.field1918 = var8;
      }

      return var10;
   }

   public void vmethod3330(int var1) {
      this.field1918 = System.nanoTime();
   }
}
