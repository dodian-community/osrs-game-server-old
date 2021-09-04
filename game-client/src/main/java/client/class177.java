package client;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class class177 {
   public static class223 field2285;
   public static class247 field2284;
   static int field2283;
   public static final int field2281 = 33;
   static final int field2282 = 262144;

   static {
      new HashMap();
   }

   static final void method3513(int var0) {
      class125.field1760 = false;
      GameClient.field585 = false;
   }

   public static void method3509(String var0, String var1, int var2, int var3, byte var4) throws IOException {
      class148.field1913 = var3;
      class141.field1885 = var2;

      try {
         class229.field2587 = System.getProperty("os.name");
      } catch (Exception var14) {
         class229.field2587 = "Unknown";
      }

      class75.field1065 = class229.field2587.toLowerCase();

      try {
         class18.userhomeDirectory = System.getProperty("user.home");
         if(class18.userhomeDirectory != null) {
            if(var4 <= 16) {
               return;
            }

            class18.userhomeDirectory = class18.userhomeDirectory + "/";
         }
      } catch (Exception var13) {
         ;
      }

      try {
         if(class75.field1065.startsWith("win")) {
            if(class18.userhomeDirectory == null) {
               class18.userhomeDirectory = System.getenv("USERPROFILE");
            }
         } else if(class18.userhomeDirectory == null) {
            if(var4 <= 16) {
               return;
            }

            class18.userhomeDirectory = System.getenv("HOME");
         }

         if(class18.userhomeDirectory != null) {
            class18.userhomeDirectory = class18.userhomeDirectory + "/";
         }
      } catch (Exception var12) {
         ;
      }

      if(class18.userhomeDirectory == null) {
         class18.userhomeDirectory = "~/";
      }

      class155.field1965 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class18.userhomeDirectory, "/tmp/", ""};
      class8.field52 = new String[]{".jagex_cache_" + class141.field1885, ".file_store_" + class141.field1885};
      int var10 = 0;

      label102:
      while(true) {
         if(var10 < 4) {
            if(var4 <= 16) {
               return;
            }

            class155.field1966 = class65.method1583(var0, var1, var10, (short)-8731);
            if(!class155.field1966.exists()) {
               class155.field1966.mkdirs();
            }

            File[] var6 = class155.field1966.listFiles();
            if(var6 != null) {
               File[] var7 = var6;

               for(int var8 = 0; var8 < var7.length; var8++) {
                  File var9 = var7[var8];
                  if(!class70.method1766(var9, false, 307061840)) {
                     ++var10;
                     continue label102;
                  }
               }
            }
         }

         File var5 = class155.field1966;
         class158.field1974 = var5;
         if(!class158.field1974.exists()) {
            throw new RuntimeException("");
         }

         class158.field1979 = true;
         class29.method476(1545308790);
         class155.field1969 = new class109(new class110(class151.method3238("main_file_cache.dat2", 512337969), "rw", 1048576000L), 5200, 0);
         class155.field1970 = new class109(new class110(class151.method3238("main_file_cache.idx255", -441729638), "rw", 1048576L), 6000, 0);
         class76.field1068 = new class109[class148.field1913];

         for(int var11 = 0; var11 < class148.field1913; var11++) {
            class76.field1068[var11] = new class109(new class110(class151.method3238("main_file_cache.idx" + var11, 1136295965), "rw", 1048576L), 6000, 0);
         }

         return;
      }
   }

   static final void method3512(PacketBuffer var0, int var1) {
      int var2 = 0;
      var0.startBitMode();

      int var3;
      int var4;
      int var5;
      for(var3 = 0; var3 < class81.field1167; var3++) {
         var4 = class81.field1159[var3];
         if((class81.field1156[var4] & 1) == 0) {
            if(var2 > 0) {
               if(var1 >= -911058598) {
                  return;
               }

               --var2;
               class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
            } else {
               var5 = var0.readBits(1);
               if(var5 == 0) {
                  if(var1 >= -911058598) {
                     return;
                  }

                  var2 = IncomingPacket.method3445(var0, (byte)-47);
                  class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
               } else {
                  class6.method73(var0, var4, 392289778);
               }
            }
         }
      }

      var0.endBitMode();
      if(var2 != 0) {
         if(var1 < -911058598) {
            throw new RuntimeException();
         }
      } else {
         var0.startBitMode();

         for(var3 = 0; var3 < class81.field1167; var3++) {
            var4 = class81.field1159[var3];
            if((class81.field1156[var4] & 1) != 0) {
               if(var1 >= -911058598) {
                  return;
               }

               if(var2 > 0) {
                  --var2;
                  class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
               } else {
                  var5 = var0.readBits(1);
                  if(var5 == 0) {
                     var2 = IncomingPacket.method3445(var0, (byte)-4);
                     class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
                  } else {
                     class6.method73(var0, var4, 521605957);
                  }
               }
            }
         }

         var0.endBitMode();
         if(var2 != 0) {
            if(var1 < -911058598) {
               throw new RuntimeException();
            }
         } else {
            var0.startBitMode();

            for(var3 = 0; var3 < class81.field1160; var3++) {
               var4 = class81.field1161[var3];
               if((class81.field1156[var4] & 1) != 0) {
                  if(var2 > 0) {
                     --var2;
                     class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
                  } else {
                     var5 = var0.readBits(1);
                     if(var5 == 0) {
                        var2 = IncomingPacket.method3445(var0, (byte)-83);
                        class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
                     } else if(class240.method4601(var0, var4, -641567256)) {
                        class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
                     }
                  }
               }
            }

            var0.endBitMode();
            if(var2 != 0) {
               throw new RuntimeException();
            } else {
               var0.startBitMode();

               for(var3 = 0; var3 < class81.field1160; var3++) {
                  var4 = class81.field1161[var3];
                  if((class81.field1156[var4] & 1) == 0) {
                     if(var2 > 0) {
                        --var2;
                        class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
                     } else {
                        var5 = var0.readBits(1);
                        if(var5 == 0) {
                           var2 = IncomingPacket.method3445(var0, (byte)-20);
                           class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
                        } else if(class240.method4601(var0, var4, 1432728068)) {
                           if(var1 >= -911058598) {
                              return;
                           }

                           class81.field1156[var4] = (byte)(class81.field1156[var4] | 2);
                        }
                     }
                  }
               }

               var0.endBitMode();
               if(var2 != 0) {
                  throw new RuntimeException();
               } else {
                  class81.field1167 = 0;
                  class81.field1160 = 0;

                  for(var3 = 1; var3 < 2048; var3++) {
                     if(var1 >= -911058598) {
                        return;
                     }

                     class81.field1156[var3] = (byte)(class81.field1156[var3] >> 1);
                     Player var6 = GameClient.field610[var3];
                     if(var6 != null) {
                        class81.field1159[++class81.field1167 - 1] = var3;
                     } else {
                        class81.field1161[++class81.field1160 - 1] = var3;
                     }
                  }

               }
            }
         }
      }
   }

   static final void method3510(int var0, int var1, int var2, int var3, int var4) {
      for(int var5 = var1; var5 <= var3 + var1; var5++) {
         for(int var6 = var0; var6 <= var0 + var2; var6++) {
            if(var6 >= 0 && var6 < 104 && var5 >= 0) {
               if(var4 != 885632790) {
                  return;
               }

               if(var5 < 104) {
                  class50.field447[0][var6][var5] = 127;
                  if(var0 == var6 && var6 > 0) {
                     class50.field459[0][var6][var5] = class50.field459[0][var6 - 1][var5];
                  }

                  if(var6 == var0 + var2 && var6 < 103) {
                     if(var4 != 885632790) {
                        return;
                     }

                     class50.field459[0][var6][var5] = class50.field459[0][var6 + 1][var5];
                  }

                  if(var5 == var1) {
                     if(var4 != 885632790) {
                        return;
                     }

                     if(var5 > 0) {
                        class50.field459[0][var6][var5] = class50.field459[0][var6][var5 - 1];
                     }
                  }

                  if(var3 + var1 == var5 && var5 < 103) {
                     class50.field459[0][var6][var5] = class50.field459[0][var6][var5 + 1];
                  }
               }
            }
         }
      }

   }

   static void method3507(int var0, int var1) {
      class53 var2 = (class53)class53.field474.get((long)var0);
      if(var2 != null) {
         var2.unlink();
      }
   }

   static final void method3508(String var0, int var1) {
      if(class14.field94 != null) {
         class172 var2 = class26.method433(OutgoingPacket.field2174, GameClient.field626.field1218, 832294667);
         var2.field2257.writeByte(class316.method5820(var0, (short)256));
         var2.field2257.writeString(var0, 452157445);
         GameClient.field626.method1980(var2);
      }
   }
}
