package client;

public class class124 extends class204 {
   static int field1709;
   static PaletteSprite[] field1708;
   public static final int field1710 = 10000;
   static final int field1711 = 202;
   int field1704;
   int field1705;
   int[] field1706;
   int[][] field1707;

   class124(int var1, byte[] var2) {
      this.field1704 = var1;
      Stream var3 = new Stream(var2);
      this.field1705 = var3.readUByte();
      this.field1706 = new int[this.field1705];
      this.field1707 = new int[this.field1705][];

      int var4;
      for(var4 = 0; var4 < this.field1705; var4++) {
         this.field1706[var4] = var3.readUByte();
      }

      for(var4 = 0; var4 < this.field1705; var4++) {
         this.field1707[var4] = new int[var3.readUByte()];
      }

      for(var4 = 0; var4 < this.field1705; var4++) {
         for(int var5 = 0; var5 < this.field1707[var4].length; var5++) {
            this.field1707[var4][var5] = var3.readUByte();
         }
      }

   }
}
