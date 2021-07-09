package client;

public class class52 {
   static final int field470 = 52;
   static final int field471 = 6;
   int field467 = 0;
   final int field468;
   final class249 field469;

   class52(class249 var1, String var2) {
      this.field469 = var1;
      this.field468 = var1.method4637(-1410403492);
   }

   boolean method1000(int var1) {
      this.field467 = 0;

      for(int var2 = 0; var2 < this.field468; var2++) {
         if(!this.field469.method4734(var2, 1526395619) || this.field469.method4725(var2, 270216094)) {
            ++this.field467;
         }
      }

      return this.field467 >= this.field468;
   }

   public static boolean method1002(char var0, int var1) {
      return var0 >= 32 && var0 <= 126 ? true : (var0 >= 160 && var0 <= 255 ? true : var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
