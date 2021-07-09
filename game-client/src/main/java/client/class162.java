package client;

import java.io.EOFException;
import java.io.IOException;

public final class class162 {
   static byte[] field2004 = new byte[520];
   public static final int field2003 = -1;
   class109 field2000 = null;
   class109 field2001 = null;
   int field1999 = 65000;
   int field2002;

   public class162(int var1, class109 var2, class109 var3, int var4) {
      this.field2002 = var1;
      this.field2000 = var2;
      this.field2001 = var3;
      this.field1999 = var4;
   }

   boolean method3375(int var1, byte[] var2, int var3, boolean var4, byte var5) {
      class109 var6 = this.field2000;
      synchronized(this.field2000) {
         try {
            int var7;
            boolean var10000;
            if(var4) {
               if(this.field2001.method2486(203262489) < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2001.method2476((long)(var1 * 6));
               this.field2001.method2479(field2004, 0, 6, -1944327190);
               var7 = (field2004[5] & 255) + ((field2004[3] & 255) << 16) + ((field2004[4] & 255) << 8);
               if(var7 <= 0 || (long)var7 > this.field2000.method2486(-1130755457) / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var7 = (int)((this.field2000.method2486(-1833514243) + 519L) / 520L);
               if(var7 == 0) {
                  var7 = 1;
               }
            }

            field2004[0] = (byte)(var3 >> 16);
            field2004[1] = (byte)(var3 >> 8);
            field2004[2] = (byte)var3;
            field2004[3] = (byte)(var7 >> 16);
            field2004[4] = (byte)(var7 >> 8);
            field2004[5] = (byte)var7;
            this.field2001.method2476((long)(var1 * 6));
            this.field2001.method2481(field2004, 0, 6, 1219631347);
            int var8 = 0;
            int var9 = 0;

            while(true) {
               if(var8 < var3) {
                  label144: {
                     int var10 = 0;
                     int var15;
                     if(var4) {
                        this.field2000.method2476((long)(var7 * 520));

                        try {
                           this.field2000.method2479(field2004, 0, 8, -1991549432);
                        } catch (EOFException var17) {
                           break label144;
                        }

                        var15 = (field2004[1] & 255) + ((field2004[0] & 255) << 8);
                        int var12 = (field2004[3] & 255) + ((field2004[2] & 255) << 8);
                        var10 = ((field2004[5] & 255) << 8) + ((field2004[4] & 255) << 16) + (field2004[6] & 255);
                        int var13 = field2004[7] & 255;
                        if(var15 != var1 || var9 != var12 || var13 != this.field2002) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var10 < 0 || (long)var10 > this.field2000.method2486(-1062504629) / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var10 == 0) {
                        var4 = false;
                        var10 = (int)((this.field2000.method2486(-1469024950) + 519L) / 520L);
                        if(var10 == 0) {
                           ++var10;
                        }

                        if(var10 == var7) {
                           ++var10;
                        }
                     }

                     if(var3 - var8 <= 512) {
                        var10 = 0;
                     }

                     field2004[0] = (byte)(var1 >> 8);
                     field2004[1] = (byte)var1;
                     field2004[2] = (byte)(var9 >> 8);
                     field2004[3] = (byte)var9;
                     field2004[4] = (byte)(var10 >> 16);
                     field2004[5] = (byte)(var10 >> 8);
                     field2004[6] = (byte)var10;
                     field2004[7] = (byte)this.field2002;
                     this.field2000.method2476((long)(var7 * 520));
                     this.field2000.method2481(field2004, 0, 8, 1058284044);
                     var15 = var3 - var8;
                     if(var15 > 512) {
                        var15 = 512;
                     }

                     this.field2000.method2481(var2, var8, var15, 917005669);
                     var8 += var15;
                     var7 = var10;
                     ++var9;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var18) {
            return false;
         }
      }
   }

   public boolean method3371(int var1, byte[] var2, int var3, int var4) {
      class109 var5 = this.field2000;
      synchronized(this.field2000) {
         if(var3 >= 0 && var3 <= this.field1999) {
            boolean var6 = this.method3375(var1, var2, var3, true, (byte)20);
            if(!var6) {
               var6 = this.method3375(var1, var2, var3, false, (byte)20);
            }

            return var6;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   public byte[] method3372(int var1, int var2) {
      class109 var3 = this.field2000;
      synchronized(this.field2000) {
         try {
            Object var10000;
            if(this.field2001.method2486(711180324) < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2001.method2476((long)(var1 * 6));
               this.field2001.method2479(field2004, 0, 6, -1873838718);
               int var4 = ((field2004[0] & 255) << 16) + (field2004[2] & 255) + ((field2004[1] & 255) << 8);
               int var5 = (field2004[5] & 255) + ((field2004[3] & 255) << 16) + ((field2004[4] & 255) << 8);
               if(var4 < 0 || var4 > this.field1999) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var5 <= 0 || (long)var5 > this.field2000.method2486(2134709146) / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var6 = new byte[var4];
                  int var7 = 0;
                  int var8 = 0;

                  while(var7 < var4) {
                     if(var5 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.field2000.method2476((long)(var5 * 520));
                     int var9 = var4 - var7;
                     if(var9 > 512) {
                        var9 = 512;
                     }

                     this.field2000.method2479(field2004, 0, var9 + 8, -2046041525);
                     int var10 = (field2004[1] & 255) + ((field2004[0] & 255) << 8);
                     int var11 = (field2004[3] & 255) + ((field2004[2] & 255) << 8);
                     int var12 = ((field2004[5] & 255) << 8) + ((field2004[4] & 255) << 16) + (field2004[6] & 255);
                     int var13 = field2004[7] & 255;
                     if(var10 == var1 && var8 == var11 && var13 == this.field2002) {
                        if(var12 >= 0 && (long)var12 <= this.field2000.method2486(-1836613622) / 520L) {
                           for(int var14 = 0; var14 < var9; var14++) {
                              var6[var7++] = field2004[var14 + 8];
                           }

                           var5 = var12;
                           ++var8;
                           continue;
                        }

                        var10000 = null;
                        return (byte[])var10000;
                     }

                     var10000 = null;
                     return (byte[])var10000;
                  }

                  byte[] var19 = var6;
                  return var19;
               }
            }
         } catch (IOException var17) {
            return null;
         }
      }
   }

   static void method3380(byte var0) {
      if(GameClient.field699) {
         if(var0 != 2) {
            return;
         }

         class11.method98(class138.field1876, false, -863688081);
      }

   }
}
