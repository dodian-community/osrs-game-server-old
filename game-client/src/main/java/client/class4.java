package client;

import java.net.URL;

public class class4 {
   static final int field34 = 70;
   static final long field35 = 4294967295L;
   byte field31;
   public int field30;
   public int field33;
   public int field29;
   public int field32;
   public int field28;

   public class4() {
   }

   public class4(Stream var1, boolean var2) {
      this.field31 = var1.readByte();
      this.field29 = var1.readUShort();
      this.field30 = var1.readInt();
      this.field33 = var1.readInt();
      this.field32 = var1.readInt();
      this.field28 = var1.readInt();
      if(var2) {
         this.method37(class65.method1601(var1, -2140267805), -1618640242);
      }

   }

   void method44(int var1, int var2) {
      this.field31 &= -8;
      this.field31 = (byte)(this.field31 | var1 & 7);
   }

   void method40(int var1, int var2) {
      this.field31 &= -9;
      if(var1 == 1) {
         if(var2 != 74851290) {
            return;
         }

         this.field31 = (byte)(this.field31 | 8);
      }

   }

   void method37(Integer var1, int var2) {
   }

   public int method39(byte var1) {
      return (this.field31 & 8) == 8 ? 1 : 0;
   }

   public int method38(int var1) {
      return this.field31 & 7;
   }

   static final void method56(int var0) {
      if(!class120.field1652) {
         int var1 = class125.field1759;
         int var2 = class125.field1737;
         int var3 = class125.field1740;
         int var4 = class125.field1771;
         byte var5 = 50;
         short var6 = 3500;
         int var7 = (class120.field1648 - class122.field1687) * var5 / class122.field1678;
         int var8 = (class120.field1649 - class122.field1689) * var5 / class122.field1678;
         int var9 = (class120.field1648 - class122.field1687) * var6 / class122.field1678;
         int var10 = (class120.field1649 - class122.field1689) * var6 / class122.field1678;
         int var11 = class122.method2807(var8, var5, var2, var1);
         int var12 = class122.method2790(var8, var5, var2, var1);
         var8 = var11;
         var11 = class122.method2807(var10, var6, var2, var1);
         int var13 = class122.method2790(var10, var6, var2, var1);
         var10 = var11;
         var11 = class122.method2805(var7, var12, var4, var3);
         var12 = class122.method2806(var7, var12, var4, var3);
         var7 = var11;
         var11 = class122.method2805(var9, var13, var4, var3);
         var13 = class122.method2806(var9, var13, var4, var3);
         class120.field1657 = (var11 + var7) / 2;
         class120.field1659 = (var10 + var8) / 2;
         class177.field2283 = (var13 + var12) / 2;
         class303.field3721 = (var11 - var7) / 2;
         class120.field1651 = (var10 - var8) / 2;
         class120.field1654 = (var13 - var12) / 2;
         class98.field1335 = Math.abs(class303.field3721);
         class120.field1655 = Math.abs(class120.field1651);
         class312.field3757 = Math.abs(class120.field1654);
      }
   }

   static boolean method36(int var0) {
      try {
         if(class49.field439 == null) {
            class49.field439 = class28.field249.method3109(new URL(class26.field219), 790678851);
         } else if(class49.field439.method3117((short)3647)) {
            byte[] var1 = class49.field439.method3116(228107899);
            Stream var2 = new Stream(var1);
            var2.readInt();
            class65.field945 = var2.readUShort();
            class65.field949 = new class65[class65.field945];

            class65 var4;
            for(int var3 = 0; var3 < class65.field945; var4.field943 = var3++) {
               var4 = class65.field949[var3] = new class65();
               var4.field947 = var2.readUShort();
               var4.field948 = var2.readInt();
               var4.field950 = var2.readString();
               var4.field951 = var2.readString();
               var4.field952 = var2.readUByte();
               var4.field955 = var2.readShort();
            }

            class22.method282(class65.field949, 0, class65.field949.length - 1, class65.field946, class65.field939, 848779256);
            class49.field439 = null;
            return true;
         }
      } catch (Exception var5) {
         var5.printStackTrace();
         class49.field439 = null;
      }

      return false;
   }
}
