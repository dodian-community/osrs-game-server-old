package client;

public class class183 {
   static int field2344 = 0;
   static int field2346 = 0;
   static int field2342 = 0;
   static byte[][] field2340 = new byte[1000][];
   static byte[][][] field2341;
   static int[] field2348;
   static byte[][] field2343 = new byte[250][];
   static byte[][] field2345 = new byte[50][];
   static int[] field2347;
   static final int field2349 = 2;

   static synchronized byte[] method3773(int var0, boolean var1, int var2) {
      byte[] var3;
      if((var0 == 100 || var0 < 100 && var1) && field2344 > 0) {
         var3 = field2340[--field2344];
         field2340[field2344] = null;
         return var3;
      } else if((var0 == 5000 || var0 < 5000 && var1) && field2346 > 0) {
         var3 = field2343[--field2346];
         field2343[field2346] = null;
         return var3;
      } else if((var0 == 30000 || var0 < 30000 && var1) && field2342 > 0) {
         var3 = field2345[--field2342];
         field2345[field2342] = null;
         return var3;
      } else {
         int var5;
         if(field2341 != null) {
            for(var5 = 0; var5 < field2348.length; var5++) {
               if((field2348[var5] == var0 || var0 < field2348[var5] && var1) && field2347[var5] > 0) {
                  byte[] var4 = field2341[var5][--field2347[var5]];
                  field2341[var5][field2347[var5]] = null;
                  return var4;
               }
            }
         }

         if(var1 && field2348 != null) {
            for(var5 = 0; var5 < field2348.length; var5++) {
               if(var0 <= field2348[var5] && field2347[var5] < field2341[var5].length) {
                  return new byte[field2348[var5]];
               }
            }
         }

         return new byte[var0];
      }
   }
}
