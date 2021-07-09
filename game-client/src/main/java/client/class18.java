package client;

public class class18 implements class31 {
   static String userhomeDirectory;
   protected static boolean field146;
   public static final int field147 = 32;
   int field142;
   int field137;
   int field144;
   int field148;
   int field136;
   int field138;
   int field145;
   int field140;
   int field139;
   int field141;

   public boolean vmethod637(int var1, int var2, int var3) {
      return var1 >> 6 >= this.field142 && var1 >> 6 <= this.field144 && var2 >> 6 >= this.field136 && var2 >> 6 <= this.field145;
   }

   public boolean vmethod636(int var1, int var2, int var3, int var4) {
      return var1 >= this.field137 && var1 < this.field137 + this.field148 ? var2 >> 6 >= this.field138 && var2 >> 6 <= this.field140 && var3 >> 6 >= this.field139 && var3 >> 6 <= this.field141 : false;
   }

   public void vmethod635(class20 var1, byte var2) {
      if(var1.field166 > this.field142) {
         var1.field166 = this.field142;
      }

      if(var1.field167 < this.field144) {
         if(var2 >= 3) {
            return;
         }

         var1.field167 = this.field144;
      }

      if(var1.field168 > this.field136) {
         var1.field168 = this.field136;
      }

      if(var1.field162 < this.field145) {
         if(var2 >= 3) {
            return;
         }

         var1.field162 = this.field145;
      }

   }

   public class226 vmethod659(int var1, int var2, int var3) {
      if(!this.vmethod637(var1, var2, -658565537)) {
         return null;
      } else {
         int var4 = this.field138 * 64 - this.field142 * 64 + var1;
         int var5 = this.field139 * 64 - this.field136 * 64 + var2;
         return new class226(this.field137, var4, var5);
      }
   }

   public int[] vmethod638(int var1, int var2, int var3, byte var4) {
      if(!this.vmethod636(var1, var2, var3, 1954138517)) {
         return null;
      } else {
         int[] var5 = new int[]{this.field142 * 64 - this.field138 * 64 + var2, var3 + (this.field136 * 64 - this.field139 * 64)};
         return var5;
      }
   }

   public void vmethod639(Stream var1, byte var2) {
      this.field137 = var1.readUByte();
      this.field148 = var1.readUByte();
      this.field138 = var1.readUShort();
      this.field139 = var1.readUShort();
      this.field140 = var1.readUShort();
      this.field141 = var1.readUShort();
      this.field142 = var1.readUShort();
      this.field136 = var1.readUShort();
      this.field144 = var1.readUShort();
      this.field145 = var1.readUShort();
      this.method179((byte)-76);
   }

   void method179(byte var1) {
   }

   static String method176(int var0, int var1) {
      return var0 < 0 ? "" : (GameClient.field740[var0].length() > 0 ? GameClient.field735[var0] + " " + GameClient.field740[var0] : GameClient.field735[var0]);
   }

   static class321 method196(int var0) {
      return class53.field476;
   }
}
