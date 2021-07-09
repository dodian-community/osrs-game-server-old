package client;

public final class Npc extends class63 {
   static Sprite field1038;
   static int field1033;
   static int[] field1035;
   public static final int field1032 = 10;
   static final int field1034 = 256;
   static final int field1036 = 65536;
   NpcDef definition;

   public int customCombatLevel = 0;

   protected final class119 vmethod3067(int var1) {
      if(this.definition == null) {
         return null;
      } else {
         class273 var2 = super.field903 != -1 && super.field906 == 0 ? class3.method25(super.field903, -746755337) : null;
         class273 var3 = super.field900 != -1 && (super.field900 != super.field893 || var2 == null) ? class3.method25(super.field900, -1898590923) : null;
         class119 var4 = this.definition.method5162(var2, super.field904, var3, super.field908, -218542104);
         if(var4 == null) {
            return null;
         } else {
            var4.method2670();
            super.field925 = var4.field1781;
            if(super.field891 != -1 && super.field876 != -1) {
               class119 var5 = class57.method1035(super.field891, -1855404238).method4866(super.field876, -1392481328);
               if(var5 != null) {
                  var5.method2718(0, -super.field871, 0);
                  class119[] var6 = new class119[]{var4, var5};
                  var4 = new class119(var6, 2);
               }
            }

            if(this.definition.size == 1) {
               var4.field1603 = true;
            }

            return var4;
         }
      }
   }

   final boolean vmethod1786(byte var1) {
      return this.definition != null;
   }

   final void method1794(int var1, byte var2, byte var3) {
      int var4 = super.field922[0];
      int var5 = super.field872[0];
      if(var1 == 0) {
         --var4;
         ++var5;
      }

      if(var1 == 1) {
         ++var5;
      }

      if(var1 == 2) {
         ++var4;
         ++var5;
      }

      if(var1 == 3) {
         --var4;
      }

      if(var1 == 4) {
         ++var4;
      }

      if(var1 == 5) {
         --var4;
         --var5;
      }

      if(var1 == 6) {
         if(var3 <= 6) {
            return;
         }

         --var5;
      }

      if(var1 == 7) {
         ++var4;
         --var5;
      }

      if(super.field903 != -1 && class3.method25(super.field903, -603130367).field3535 == 1) {
         if(var3 <= 6) {
            return;
         }

         super.field903 = -1;
      }

      if(super.field909 < 9) {
         ++super.field909;
      }

      for(int var6 = super.field909; var6 > 0; --var6) {
         super.field922[var6] = super.field922[var6 - 1];
         super.field872[var6] = super.field872[var6 - 1];
         super.field928[var6] = super.field928[var6 - 1];
      }

      super.field922[0] = var4;
      super.field872[0] = var5;
      super.field928[0] = var2;
   }

   final void method1788(int var1, int var2, boolean var3, int var4) {
      if(super.field903 != -1) {
         if(var4 == -1961233435) {
            return;
         }

         if(class3.method25(super.field903, 1587810342).field3535 == 1) {
            super.field903 = -1;
         }
      }

      if(!var3) {
         if(var4 == -1961233435) {
            return;
         }

         int var5 = var1 - super.field922[0];
         int var6 = var2 - super.field872[0];
         if(var5 >= -8 && var5 <= 8 && var6 >= -8 && var6 <= 8) {
            if(super.field909 < 9) {
               ++super.field909;
            }

            for(int var7 = super.field909; var7 > 0; --var7) {
               super.field922[var7] = super.field922[var7 - 1];
               super.field872[var7] = super.field872[var7 - 1];
               super.field928[var7] = super.field928[var7 - 1];
            }

            super.field922[0] = var1;
            super.field872[0] = var2;
            super.field928[0] = 1;
            return;
         }
      }

      super.field909 = 0;
      super.field930 = 0;
      super.field923 = 0;
      super.field922[0] = var1;
      super.field872[0] = var2;
      super.field931 = super.field874 * 64 + super.field922[0] * 128;
      super.field881 = super.field874 * 64 + super.field872[0] * 128;
   }
}
