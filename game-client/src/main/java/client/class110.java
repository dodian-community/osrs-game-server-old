package client;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;

public final class class110 {
   static final int field1434 = 131072;
   public static final int field1436 = 1024;
   static final int field1437 = 4;
   long field1432;
   RandomAccessFile field1435;
   long field1433;

   public class110(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field1435 = new RandomAccessFile(var1, var2);
      this.field1433 = var3;
      this.field1432 = 0L;
      int var5 = this.field1435.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field1435.seek(0L);
         this.field1435.write(var5);
      }

      this.field1435.seek(0L);
   }

   public final void method2508(boolean var1, byte var2) throws IOException {
      if(this.field1435 != null) {
         if(var1) {
            try {
               this.field1435.getFD().sync();
            } catch (SyncFailedException var4) {
               ;
            }
         }

         this.field1435.close();
         this.field1435 = null;
      }

   }

   public final long method2509(int var1) throws IOException {
      return this.field1435.length();
   }

   public final void method2507(int var1) throws IOException {
      this.method2508(false, (byte)122);
   }

   public final int method2510(byte[] var1, int var2, int var3, int var4) throws IOException {
      int var5 = this.field1435.read(var1, var2, var3);
      if(var5 > 0) {
         this.field1432 += (long)var5;
      }

      return var5;
   }

   final void method2514(long var1) throws IOException {
      this.field1435.seek(var1);
      this.field1432 = var1;
   }

   public final void method2506(byte[] var1, int var2, int var3, int var4) throws IOException {
      if((long)var3 + this.field1432 > this.field1433) {
         this.field1435.seek(1L + this.field1433);
         this.field1435.write(1);
         throw new EOFException();
      } else {
         this.field1435.write(var1, var2, var3);
         this.field1432 += (long)var3;
      }
   }

   protected void finalize() throws Throwable {
      if(this.field1435 != null) {
         System.out.println("");
         this.method2507(746943081);
      }

   }

   public static ObjectDef getObjectDef(int var0) {
      ObjectDef var2 = (ObjectDef) ObjectDef.field3371.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = ObjectDef.field3377.method4625(6, var0, 777838153);
         var2 = new ObjectDef();
         var2.field3376 = var0;
         if(var3 != null) {
            var2.method5026(new Stream(var3), -1600921045);
         }

         var2.method5025(936618965);
         if(var2.isSolid) {
            var2.clipType = 0;
            var2.isUnwalkable = false;
         }

         Custom.Objects.parseObjDef(var0, var2);

         ObjectDef.field3371.method3983(var2, (long)var0);
         return var2;
      }
   }

   static Class method2528(String var0, int var1) throws ClassNotFoundException {
      System.out.println("Resolve class: " + var0);
      return var0.equals("B") ? Byte.TYPE : (var0.equals("I") ? Integer.TYPE : (var0.equals("S") ? Short.TYPE : (var0.equals("J") ? Long.TYPE : (var0.equals("Z") ? Boolean.TYPE : (var0.equals("F") ? Float.TYPE : (var0.equals("D") ? Double.TYPE : (var0.equals("C") ? Character.TYPE : (var0.equals("void") ? Void.TYPE : Class.forName(var0)))))))));
   }

   static final int method2511(int var0, int var1, int var2) {
      int var3 = var0 + var1 * 57;
      var3 ^= var3 << 13;
      int var4 = (var3 * var3 * 15731 + 789221) * var3 + 1376312589 & Integer.MAX_VALUE;
      return var4 >> 19 & 255;
   }
}
