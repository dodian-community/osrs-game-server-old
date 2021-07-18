package client;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class class65 {
   static int field945 = 0;
   static int field944 = 0;
   static int[] field939 = new int[]{1, 1, 1, 1};
   static int[] field946 = new int[]{0, 1, 2, 3};
   static class65[] field949;
   static final int field940 = 1;
   static final int field941 = 0;
   static final int field942 = 2;
   static final int field953 = 22;
   public static final int field954 = 34;
   int field948;
   int field955;
   String field951;
   int field943;
   int field947;
   String field950;
   int field952;

   boolean method1577(int var1) {
      return (33554432 & this.field948) != 0;
   }

   boolean method1570(int var1) {
      return (536870912 & this.field948) != 0;
   }

   boolean method1589(byte var1) {
      return (1 & this.field948) != 0;
   }

   boolean method1568(byte var1) {
      return (4 & this.field948) != 0;
   }

   boolean method1569(int var1) {
      return (8 & this.field948) != 0;
   }

   boolean method1567(int var1) {
      return (2 & this.field948) != 0;
   }

   static Integer method1601(Stream var0, int var1) {
      int var2 = 0;
      boolean var3 = false;

      while(true) {
         int var4 = var0.readUByte();
         if(var4 == 255) {
            return var3 ? Integer.valueOf(var2) : null;
         }

         if(var4 != 0) {
            throw new IllegalStateException("");
         }

         while(true) {
            int var5 = var0.readUByte();
            if(var5 == 255) {
               break;
            }

            --var0.field2339;
            if(var0.readUShort() != 0) {
               throw new IllegalStateException("");
            }

            if(var3) {
               throw new IllegalStateException("");
            }

            var2 = var0.readInt();
            var3 = true;
         }
      }
   }

   static File method1583(String var0, String var1, int var2, short var3) {
      String var4 = var2 == 0 ? "" : "" + var2;
      class155.field1964 = new File(class18.userhomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var4 + ".dat");
      String var5 = null;
      String var6 = null;
      boolean var7 = false;
      Stream var9;
      File var24;
      if(class155.field1964.exists()) {
         try {
            class110 var8 = new class110(class155.field1964, "rw", 10000L);

            int var10;
            for(var9 = new Stream((int)var8.method2509(-1468056120)); var9.field2339 < var9.field2338.length; var9.field2339 += var10) {
               var10 = var8.method2510(var9.field2338, var9.field2339, var9.field2338.length - var9.field2339, -876077164);
               if(var10 == -1) {
                  throw new IOException();
               }
            }

            var9.field2339 = 0;
            var10 = var9.readUByte();
            if(var10 < 1 || var10 > 3) {
               throw new IOException("" + var10);
            }

            int var11 = 0;
            if(var10 > 1) {
               var11 = var9.readUByte();
            }

            if(var10 <= 2) {
               var5 = var9.method3558();
               if(var11 == 1) {
                  var6 = var9.method3558();
               }
            } else {
               var5 = var9.method3559(-1097930981);
               if(var11 == 1) {
                  var6 = var9.method3559(-1716935440);
               }
            }

            var8.method2507(746943081);
         } catch (IOException var22) {
            var22.printStackTrace();
         }

         if(var5 != null) {
            var24 = new File(var5);
            if(!var24.exists()) {
               var5 = null;
            }
         }

         if(var5 != null) {
            var24 = new File(var5, "test.dat");
            if(!class70.method1766(var24, true, -887667973)) {
               var5 = null;
            }
         }
      }

      if(var5 == null && var2 == 0) {
         label138:
         for(int var16 = 0; var16 < class8.field52.length; var16++) {
            for(int var17 = 0; var17 < class155.field1965.length; var17++) {
               File var18 = new File(class155.field1965[var17] + class8.field52[var16] + File.separatorChar + var0 + File.separatorChar);
               if(var18.exists() && class70.method1766(new File(var18, "test.dat"), true, 1327670694)) {
                  var5 = var18.toString();
                  var7 = true;
                  break label138;
               }
            }
         }
      }

      if(var5 == null) {
         var5 = class18.userhomeDirectory + File.separatorChar + "jagexcache" + var4 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var7 = true;
      }

      File var23;
      if(var6 != null) {
         var23 = new File(var6);
         var24 = new File(var5);

         try {
            File[] var25 = var23.listFiles();
            File[] var19 = var25;

            for(int var12 = 0; var12 < var19.length; var12++) {
               File var13 = var19[var12];
               File var14 = new File(var24, var13.getName());
               boolean var15 = var13.renameTo(var14);
               if(!var15) {
                  throw new IOException();
               }
            }
         } catch (Exception var21) {
            var21.printStackTrace();
         }

         var7 = true;
      }

      if(var7) {
         var23 = new File(var5);
         var9 = null;

         try {
            class110 var26 = new class110(class155.field1964, "rw", 10000L);
            Stream var27 = new Stream(500);
            var27.writeByte(3);
            var27.writeByte(var9 != null ? 1 : 0);
            var27.method3541(var23.getPath(), (byte)103);
            if(var9 != null) {
               var27.method3541("", (byte)88);
            }

            var26.method2506(var27.field2338, 0, var27.field2339, 2068014538);
            var26.method2507(746943081);
         } catch (IOException var20) {
            var20.printStackTrace();
         }
      }

      return new File(var5);
   }

   public static final class95 method1582(class154 var0, int var1, int var2, int var3) {
      if(class95.field1300 == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class95 var4 = class95.field1297.vmethod2052((byte)39);
            var4.field1299 = new int[(class95.field1295 ? 2 : 1) * 256];
            var4.field1303 = var2;
            var4.vmethod2176(-2015063069);
            var4.field1302 = (var2 & -1024) + 1024;
            if(var4.field1302 > 16384) {
               var4.field1302 = 16384;
            }

            var4.vmethod2163(var4.field1302, (short)255);
            if(class27.field230 > 0 && class69.field1010 == null) {
               class69.field1010 = new class97();
               class135.field1855 = Executors.newScheduledThreadPool(1);
               class135.field1855.scheduleAtFixedRate(class69.field1010, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class69.field1010 != null) {
               if(class69.field1010.field1327[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class69.field1010.field1327[var1] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class95();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   static final void method1603(Stream var0, int var1, int var2, int var3, int var4, int var5, int var6, short var7) {
      int var8;
      if(var2 >= 0) {
         if(var7 == 5000) {
            return;
         }

         if(var2 < 104 && var3 >= 0 && var3 < 104) {
            class50.field443[var1][var2][var3] = 0;

            while(true) {
               var8 = var0.readUByte();
               if(var8 == 0) {
                  if(var7 == 5000) {
                     return;
                  }

                  if(var1 == 0) {
                     int[] var9 = class50.field459[0][var2];
                     int var12 = var2 + var4 + 932731;
                     int var13 = var3 + var5 + 556238;
                     int var14 = class32.method549(45365 + var12, var13 + 91923, 4, -2015845683) - 128 + (class32.method549(10294 + var12, 37821 + var13, 2, -2015845683) - 128 >> 1) + (class32.method549(var12, var13, 1, -2015845683) - 128 >> 2);
                     var14 = (int)((double)var14 * 0.3D) + 35;
                     if(var14 < 10) {
                        var14 = 10;
                     } else if(var14 > 60) {
                        var14 = 60;
                     }

                     var9[var3] = -var14 * 8;
                  } else {
                     class50.field459[var1][var2][var3] = class50.field459[var1 - 1][var2][var3] - 240;
                  }

                  return;
               }

               if(var8 == 1) {
                  int var15 = var0.readUByte();
                  if(var15 == 1) {
                     var15 = 0;
                  }

                  if(var1 == 0) {
                     class50.field459[0][var2][var3] = -var15 * 8;
                  } else {
                     class50.field459[var1][var2][var3] = class50.field459[var1 - 1][var2][var3] - var15 * 8;
                  }

                  return;
               }

               if(var8 <= 49) {
                  class165.field2033[var1][var2][var3] = var0.readByte();
                  class50.field446[var1][var2][var3] = (byte)((var8 - 2) / 4);
                  class19.field159[var1][var2][var3] = (byte)(var8 - 2 + var6 & 3);
               } else if(var8 <= 81) {
                  if(var7 == 5000) {
                     return;
                  }

                  class50.field443[var1][var2][var3] = (byte)(var8 - 49);
               } else {
                  class50.field445[var1][var2][var3] = (byte)(var8 - 81);
               }
            }
         }
      }

      while(true) {
         var8 = var0.readUByte();
         if(var8 == 0) {
            break;
         }

         if(var8 == 1) {
            if(var7 == 5000) {
               return;
            }

            var0.readUByte();
            break;
         }

         if(var8 <= 49) {
            var0.readUByte();
         }
      }

   }

   static void method1604(int var0) {
      class172 var1 = class26.method433(OutgoingPacket.field2215, GameClient.field626.field1218, 236785843);
      PacketBuffer var2 = var1.field2257;
      int var3 = GameClient.field792 ? 2 : 1;
      var2.writeByte(var3);
      var1.field2257.writeShort(class82.field1179);
      var1.field2257.writeShort(class243.field3138);
      GameClient.field626.method1980(var1);
   }

   static int method1605(int var0, class84 var1, boolean var2, int var3) {
      Widget var4 = var2 ? class276.field3561 : class260.field3301;
      if(var0 == 1500) {
         class69.field999[++class69.field1003 - 1] = var4.field2618;
         return 1;
      } else if(var0 == 1501) {
         class69.field999[++class69.field1003 - 1] = var4.int447;
         return 1;
      } else if(var0 == 1502) {
         class69.field999[++class69.field1003 - 1] = var4.int472;
         return 1;
      } else if(var0 == 1503) {
         class69.field999[++class69.field1003 - 1] = var4.int466;
         return 1;
      } else if(var0 == 1504) {
         class69.field999[++class69.field1003 - 1] = var4.hidden ? 1 : 0;
         return 1;
      } else if(var0 == 1505) {
         class69.field999[++class69.field1003 - 1] = var4.parentHash;
         return 1;
      } else {
         return 2;
      }
   }

   public static void method1602(int var0, class247 var1, int var2, int var3, int var4, boolean var5, byte var6) {
      class217.field2460 = 1;
      class138.field1871 = var1;
      class217.field2461 = var2;
      class217.field2462 = var3;
      class309.field3740 = var4;
      class217.field2463 = var5;
      class6.field37 = var0;
   }
}
