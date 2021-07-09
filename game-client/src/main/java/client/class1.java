package client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class class1 {
   public static Comparator field9 = new class7();
   public static Comparator field13;
   public static Comparator field11;
   public static Comparator field16;
   static int field15;
   static class296 field14;
   static final int field8 = 500;
   static final int field12 = 36;
   public final List field10;

   static {
      new class0();
      field13 = new class5();
      field11 = new class6();
      field16 = new class3();
   }

   public class1(Stream var1, boolean var2) {
      int var3 = var1.readUShort();
      boolean var4 = var1.readUByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUShort();
      this.field10 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; var7++) {
         this.field10.add(new class2(var1, var5, var3));
      }

   }

   public void method9(Comparator var1, boolean var2, byte var3) {
      if(var2) {
         Collections.sort(this.field10, var1);
      } else {
         Collections.sort(this.field10, Collections.reverseOrder(var1));
      }

   }

   public static class272 method15(int var0, byte var1) {
      class272 var2 = (class272)class272.field3524.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class272.field3529.method4625(4, var0, 580701408);
         var2 = new class272();
         if(var3 != null) {
            var2.method5194(new Stream(var3), var0, -2042165277);
         }

         var2.method5195(2121765043);
         class272.field3524.method3983(var2, (long)var0);
         return var2;
      }
   }

   static String method11(String var0, Widget var1, int var2) {
      if(var0.indexOf("%") != -1) {
         for(int var3 = 1; var3 <= 5; var3++) {
            while(true) {
               int var4 = var0.indexOf("%" + var3);
               if(var4 == -1) {
                  break;
               }

               String var5 = var0.substring(0, var4);
               int var7 = class137.method3119(var1, var3 - 1, 1752439985);
               String var6;
               if(var7 < 999999999) {
                  var6 = Integer.toString(var7);
               } else {
                  var6 = "*";
               }

               var0 = var5 + var6 + var0.substring(var4 + 2);
            }
         }
      }

      return var0;
   }

   public static final boolean method8(int var0) {
      class39 var1 = class39.field337;
      synchronized(class39.field337) {
         if(class39.field352 == class39.field350) {
            return false;
         } else {
            class163.field2016 = class39.field348[class39.field350];
            class39.field342 = class39.field346[class39.field350];
            class39.field350 = class39.field350 + 1 & 127;
            return true;
         }
      }
   }

   static final void method13(int var0) {
      GameClient.field828 = GameClient.field801;
      class54.field489 = true;
   }
}
