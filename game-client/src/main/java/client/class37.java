package client;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;

public class class37 implements class31 {
   static class249 field326;
   static int[][][] field325;
   static final int field327 = 2160;
   int field318;
   int field315;
   int field316;
   int field324;
   int field319;
   int field321;
   int field320;
   int field323;
   int field317;
   int field322;

   public boolean vmethod637(int var1, int var2, int var3) {
      return var1 >= (this.field315 << 6) + (this.field316 << 3) && var1 <= (this.field315 << 6) + (this.field316 << 3) + 7 && var2 >= (this.field320 << 6) + (this.field323 << 3) && var2 <= (this.field320 << 6) + (this.field323 << 3) + 7;
   }

   public boolean vmethod636(int var1, int var2, int var3, int var4) {
      return var1 >= this.field318 && var1 < this.field318 + this.field324 ? var2 >= (this.field319 << 6) + (this.field321 << 3) && var2 <= (this.field319 << 6) + (this.field321 << 3) + 7 && var3 >= (this.field317 << 6) + (this.field322 << 3) && var3 <= (this.field317 << 6) + (this.field322 << 3) + 7 : false;
   }

   public void vmethod635(class20 var1, byte var2) {
      if(var1.field166 > this.field315) {
         var1.field166 = this.field315;
      }

      if(var1.field167 < this.field315) {
         var1.field167 = this.field315;
      }

      if(var1.field168 > this.field320) {
         var1.field168 = this.field320;
      }

      if(var1.field162 < this.field320) {
         var1.field162 = this.field320;
      }

   }

   public class226 vmethod659(int var1, int var2, int var3) {
      if(!this.vmethod637(var1, var2, -658565537)) {
         return null;
      } else {
         int var4 = this.field319 * 64 - this.field315 * 64 + (this.field321 * 8 - this.field316 * 8) + var1;
         int var5 = this.field317 * 64 - this.field320 * 64 + var2 + (this.field322 * 8 - this.field323 * 8);
         return new class226(this.field318, var4, var5);
      }
   }

   public int[] vmethod638(int var1, int var2, int var3, byte var4) {
      if(!this.vmethod636(var1, var2, var3, 2010491999)) {
         return null;
      } else {
         int[] var5 = new int[]{this.field315 * 64 - this.field319 * 64 + var2 + (this.field316 * 8 - this.field321 * 8), var3 + (this.field320 * 64 - this.field317 * 64) + (this.field323 * 8 - this.field322 * 8)};
         return var5;
      }
   }

   public void vmethod639(Stream var1, byte var2) {
      this.field318 = var1.readUByte();
      this.field324 = var1.readUByte();
      this.field319 = var1.readUShort();
      this.field321 = var1.readUByte();
      this.field317 = var1.readUShort();
      this.field322 = var1.readUByte();
      this.field315 = var1.readUShort();
      this.field316 = var1.readUByte();
      this.field320 = var1.readUShort();
      this.field323 = var1.readUByte();
      this.method641((byte)-49);
   }

   void method641(byte var1) {
   }

   static void method640(byte var0) {
      Iterator var1 = class83.field1181.iterator();

      while(var1.hasNext()) {
         class58 var2 = (class58)var1.next();
         var2.method1048(-1016035319);
      }

   }

   static final void decodeGpiInit(PacketBuffer buffer) {
      buffer.startBitMode();
      int var2 = GameClient.field628;
      Player var3 = class138.field1876 = GameClient.field610[var2] = new Player();
      var3.field574 = var2;
      int var4 = buffer.readBits(30);
      byte var5 = (byte)(var4 >> 28);
      int var6 = var4 >> 14 & 16383;
      int var7 = var4 & 16383;
      var3.field922[0] = var6 - class62.baseX;
      var3.field931 = (var3.field922[0] << 7) + (var3.method1088((byte)-77) << 6);
      var3.field872[0] = var7 - GameClient.baseY;
      var3.field881 = (var3.field872[0] << 7) + (var3.method1088((byte)24) << 6);
      var3.field567 = var5;
      class13.field82 = var5;
      if(class81.field1157[var2] != null) {
         var3.decodeLooks(class81.field1157[var2], 833204307);
      }

      class81.field1167 = 0;
      class81.field1159[++class81.field1167 - 1] = var2;
      class81.field1156[var2] = 0;
      class81.field1160 = 0;

      for(int var8 = 1; var8 < 2048; var8++) {
         if(var8 != var2) {
            int var9 = buffer.readBits(18);
            int var10 = var9 >> 16;
            int var11 = var9 >> 8 & 597;
            int var12 = var9 & 597;
            class81.field1162[var8] = (var11 << 14) + var12 + (var10 << 28);
            class81.field1163[var8] = 0;
            class81.field1164[var8] = -1;
            class81.field1161[++class81.field1160 - 1] = var8;
            class81.field1156[var8] = 0;
         }
      }

      buffer.endBitMode();
   }

   protected static int method661(int var0) {
      int var1 = 0;
      if(class121.field1660 == null || !class121.field1660.isValid()) {
         try {
            Iterator var2 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var2.hasNext()) {
               GarbageCollectorMXBean var3 = (GarbageCollectorMXBean)var2.next();
               if(var3.isValid()) {
                  class121.field1660 = var3;
                  GameShell.field416 = -1L;
                  GameShell.field415 = -1L;
               }
            }
         } catch (Throwable var12) {
            ;
         }
      }

      if(class121.field1660 != null) {
         long var10 = Stream.method3547(604838575);
         long var4 = class121.field1660.getCollectionTime();
         if(GameShell.field415 != -1L) {
            long var6 = var4 - GameShell.field415;
            long var8 = var10 - GameShell.field416;
            if(var8 != 0L) {
               var1 = (int)(100L * var6 / var8);
            }
         }

         GameShell.field415 = var4;
         GameShell.field416 = var10;
      }

      return var1;
   }

   public static int method662(long var0) {
      return (int)(var0 >>> 0 & 127L);
   }

   public static int method652(int var0) {
      return ++class48.field417 - 1;
   }
}
