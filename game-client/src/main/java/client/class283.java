package client;

import java.util.Comparator;

public abstract class class283 implements Comparator {
   static final int field3614 = 2;
   Comparator field3613;

   protected final int method5308(class282 var1, class282 var2, int var3) {
      return this.field3613 == null ? 0 : this.field3613.compare(var1, var2);
   }

   final void method5307(Comparator var1, int var2) {
      if(this.field3613 == null) {
         this.field3613 = var1;
      } else if(this.field3613 instanceof class283) {
         ((class283)this.field3613).method5307(var1, 814932202);
      }

   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
