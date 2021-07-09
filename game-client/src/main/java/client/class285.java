package client;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public abstract class class285 {
   final int field3620;
   HashMap field3618;
   class282[] field3623;
   int field3619 = 0;
   Comparator field3621 = null;
   HashMap field3622;

   class285(int var1) {
      this.field3620 = var1;
      this.field3623 = this.vmethod5462(var1, 828432673);
      this.field3618 = new HashMap(var1 / 8);
      this.field3622 = new HashMap(var1 / 8);
   }

   public class282 method5330(class291 var1, int var2) {
      class282 var3 = this.method5331(var1, -959417897);
      return var3 != null ? var3 : this.method5390(var1, -2122724226);
   }

   class282 method5335(class291 var1, class291 var2, int var3) {
      if(this.method5331(var1, -842209666) != null) {
         throw new IllegalStateException();
      } else {
         class282 var4 = this.vmethod5461(2139940378);
         var4.method5290(var1, var2, 875264684);
         this.method5341(var4, 234221683);
         this.method5342(var4, -648694695);
         return var4;
      }
   }

   final int method5339(class282 var1, byte var2) {
      for(int var3 = 0; var3 < this.field3619; var3++) {
         if(this.field3623[var3] == var1) {
            return var3;
         }
      }

      return -1;
   }

   final void method5395(class282 var1, int var2) {
      if(this.field3618.remove(var1.field3610) == null) {
         if(var2 == -1961233435) {
            throw new IllegalStateException();
         }
      } else {
         if(var1.field3611 != null) {
            if(var2 != -1961233435) {
               return;
            }

            this.field3622.remove(var1.field3611);
         }

      }
   }

   class282 method5331(class291 var1, int var2) {
      return !var1.method5441(389939594) ? null : (class282)this.field3618.get(var1);
   }

   public int method5327(int var1) {
      return this.field3619;
   }

   public boolean method5328(int var1) {
      return this.field3620 == this.field3619;
   }

   public final void method5337(int var1) {
      if(this.field3621 == null) {
         Arrays.sort(this.field3623, 0, this.field3619);
      } else {
         Arrays.sort(this.field3623, 0, this.field3619, this.field3621);
      }

   }

   public boolean method5329(class291 var1, int var2) {
      return !var1.method5441(-633779444) ? false : (this.field3618.containsKey(var1) ? true : this.field3622.containsKey(var1));
   }

   class282 method5390(class291 var1, int var2) {
      return !var1.method5441(-277562920) ? null : (class282)this.field3622.get(var1);
   }

   abstract class282 vmethod5461(int var1);

   public void method5326(int var1) {
      this.field3619 = 0;
      Arrays.fill(this.field3623, (Object)null);
      this.field3618.clear();
      this.field3622.clear();
   }

   final void method5343(int var1, int var2) {
      --this.field3619;
      if(var1 < this.field3619) {
         System.arraycopy(this.field3623, var1 + 1, this.field3623, var1, this.field3619 - var1);
      }

   }

   final void method5334(class282 var1, int var2) {
      int var3 = this.method5339(var1, (byte)1);
      if(var3 != -1) {
         this.method5343(var3, -1797268727);
         this.method5395(var1, -1961233435);
      }
   }

   public final class282 method5336(int var1, byte var2) {
      if(var1 >= 0 && var1 < this.field3619) {
         return this.field3623[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException(var1);
      }
   }

   final void method5342(class282 var1, int var2) {
      this.field3618.put(var1.field3610, var1);
      if(var1.field3611 != null) {
         class282 var3 = (class282)this.field3622.put(var1.field3611, var1);
         if(var3 != null) {
            if(var2 >= 1545700545) {
               return;
            }

            if(var3 != var1) {
               if(var2 >= 1545700545) {
                  return;
               }

               var3.field3611 = null;
            }
         }
      }

   }

   abstract class282[] vmethod5462(int var1, int var2);

   public final boolean method5393(class291 var1, int var2) {
      class282 var3 = this.method5331(var1, 1932731951);
      if(var3 == null) {
         return false;
      } else {
         this.method5334(var3, -1566888864);
         return true;
      }
   }

   final void method5341(class282 var1, int var2) {
      class282[] var10000 = this.field3623;
      int var10001 = this.field3619 + 1;
      ++this.field3619;
      var10000[var10001 - 1] = var1;
   }

   class282 method5377(class291 var1, int var2) {
      return this.method5335(var1, (class291)null, 2099241553);
   }

   final void method5338(class282 var1, class291 var2, class291 var3, byte var4) {
      this.method5395(var1, -1961233435);
      var1.method5290(var2, var3, 224434676);
      this.method5342(var1, -914048201);
   }

   public final void method5346(short var1) {
      this.field3621 = null;
   }

   public final void method5347(Comparator var1, byte var2) {
      if(this.field3621 == null) {
         this.field3621 = var1;
      } else if(this.field3621 instanceof class283) {
         ((class283)this.field3621).method5307(var1, 726846986);
      }

   }
}
