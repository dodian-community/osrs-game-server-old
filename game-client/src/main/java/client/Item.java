package client;

import java.io.IOException;

public final class Item extends class127 {
   public static class98 field1149;
   static class249 field1147;
   static final int field1150 = 0;
   public static final int field1152 = 13;
   int id;
   int amt;

   public Item() {
      
   }

   public Item(int id, int amt) {
      this.id = id;
      this.amt = amt;
   }

   protected final class119 vmethod3067(int var1) {
      return ItemDef.loadItemDef(this.id).method5093(this.amt, -792052432);
   }

   static class66 method1859(short var0) {
      class110 var1 = null;
      class66 var2 = new class66();

      try {
         var1 = class22.method283("", class112.field1455.field3144, false, 1914569734);
         byte[] var3 = new byte[(int)var1.method2509(-1046460358)];

         int var5;
         for(int var4 = 0; var4 < var3.length; var4 += var5) {
            var5 = var1.method2510(var3, var4, var3.length - var4, -210430337);
            if(var5 == -1) {
               throw new IOException();
            }
         }

         var2 = new class66(new Stream(var3));
      } catch (Exception var7) {
         ;
      }

      try {
         if(var1 != null) {
            var1.method2507(746943081);
         }
      } catch (Exception var6) {
         ;
      }

      return var2;
   }

   public static void method1866(int var0, int var1) {
      class48.field417 = var0;
   }

   static final void method1865(class63 var0, byte var1) {
      label25: {
         if(var0.field918 != GameClient.field591 && var0.field903 != -1 && var0.field906 == 0) {
            if(var1 >= 1) {
               return;
            }

            if(var0.field901 + 1 <= class3.method25(var0.field903, 400789230).field3541[var0.field904]) {
               break label25;
            }

            if(var1 >= 1) {
               return;
            }
         }

         int var2 = var0.field918 - var0.field917;
         int var3 = GameClient.field591 - var0.field917;
         int var4 = var0.field913 * 128 + var0.field874 * 64;
         int var5 = var0.field915 * 128 + var0.field874 * 64;
         int var6 = var0.field916 * 128 + var0.field874 * 64;
         int var7 = var0.field929 * 128 + var0.field874 * 64;
         var0.field931 = (var3 * var6 + var4 * (var2 - var3)) / var2;
         var0.field881 = (var3 * var7 + var5 * (var2 - var3)) / var2;
      }

      var0.field923 = 0;
      var0.field926 = var0.field919;
      var0.field905 = var0.field926;
   }

   public static int method1864(int var0, int var1) {
      return class39.method673(class120.field1647[var0]);
   }
}
