package client;

import java.util.Comparator;

public class class308 implements Comparator {
   static final int field3739 = 21;
   final boolean field3738;

   public class308(boolean var1) {
      this.field3738 = var1;
   }

   int method5664(class282 var1, class282 var2, byte var3) {
      return this.field3738 ? var1.vmethod5453(var2, (byte)97) : var2.vmethod5453(var1, (byte)97);
   }

   public int compare(Object var1, Object var2) {
      return this.method5664((class282)var1, (class282)var2, (byte)-98);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
