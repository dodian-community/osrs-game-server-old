package client;

public class class2 {
   static int field23;
   static final int field22 = 30;
   String field21;
   String field18;
   public final long field20;
   public final int field19;
   public final class4 field17;

   class2(Stream var1, byte var2, int var3) {
      this.field18 = var1.readString();
      this.field21 = var1.readString();
      this.field19 = var1.readUShort();
      this.field20 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field17 = new class4();
      this.field17.method44(2, -658609218);
      this.field17.method40(var2, 74851290);
      this.field17.field30 = var4;
      this.field17.field33 = var5;
      this.field17.field32 = 0;
      this.field17.field28 = 0;
      this.field17.field29 = var3;
   }

   public String method16(int var1) {
      return this.field18;
   }

   public String method18(int var1) {
      return this.field21;
   }

   public static class260 method23(int var0, int var1) {
      class260 var2 = (class260)class260.field3291.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class260.field3292.method4625(3, var0, 2062321154);
         var2 = new class260();
         if(var3 != null) {
            var2.method4894(new Stream(var3), -148271753);
         }

         class260.field3291.method3983(var2, (long)var0);
         return var2;
      }
   }

   static void method22(String var0, String var1, String var2, byte var3) {
      class78.field1103 = var0;
      class78.field1112 = var1;
      class78.field1105 = var2;
   }
}
