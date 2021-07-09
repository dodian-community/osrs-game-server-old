package client;

public class class282 implements Comparable {
   static final int field3612 = 25;
   class291 field3611;
   class291 field3610;

   public int vmethod5453(class282 var1, byte var2) {
      return this.field3610.method5435(var1.field3610, 597763889);
   }

   public class291 method5287(int var1) {
      return this.field3610;
   }

   void method5290(class291 var1, class291 var2, int var3) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.field3610 = var1;
         this.field3611 = var2;
      }
   }

   public String method5288(byte var1) {
      return this.field3610 == null ? "" : this.field3610.method5447((byte)-61);
   }

   public String method5289(byte var1) {
      return this.field3611 == null ? "" : this.field3611.method5447((byte)0);
   }

   public int compareTo(Object var1) {
      return this.vmethod5453((class282)var1, (byte)97);
   }
}
