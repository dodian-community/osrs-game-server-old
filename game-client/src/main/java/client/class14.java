package client;

import java.io.IOException;

public class class14 implements class31 {
   static class293 field94;
   static int field104;
   static final int field92 = 0;
   int field100;
   int field93;
   int field99;
   int field90;
   int field101;
   int field95;
   int field91;
   int field96;
   int field97;
   int field89;
   int field103;
   int field105;
   int field102;
   int field98;

   public boolean vmethod637(int var1, int var2, int var3) {
      return var1 >= (this.field93 << 6) + (this.field99 << 3) && var1 <= (this.field93 << 6) + (this.field101 << 3) + 7 && var2 >= (this.field96 << 6) + (this.field89 << 3) && var2 <= (this.field96 << 6) + (this.field103 << 3) + 7;
   }

   public boolean vmethod636(int var1, int var2, int var3, int var4) {
      return var1 >= this.field100 && var1 < this.field90 + this.field100 ? var2 >= (this.field91 << 6) + (this.field95 << 3) && var2 <= (this.field91 << 6) + (this.field97 << 3) + 7 && var3 >= (this.field102 << 6) + (this.field105 << 3) && var3 <= (this.field102 << 6) + (this.field98 << 3) + 7 : false;
   }

   public void vmethod635(class20 var1, byte var2) {
      if(var1.field166 > this.field93) {
         var1.field166 = this.field93;
      }

      if(var1.field167 < this.field93) {
         if(var2 >= 3) {
            return;
         }

         var1.field167 = this.field93;
      }

      if(var1.field168 > this.field96) {
         var1.field168 = this.field96;
      }

      if(var1.field162 < this.field96) {
         var1.field162 = this.field96;
      }

   }

   public class226 vmethod659(int var1, int var2, int var3) {
      if(!this.vmethod637(var1, var2, -658565537)) {
         return null;
      } else {
         int var4 = this.field91 * 64 - this.field93 * 64 + (this.field95 * 8 - this.field99 * 8) + var1;
         int var5 = this.field102 * 64 - this.field96 * 64 + var2 + (this.field105 * 8 - this.field89 * 8);
         return new class226(this.field100, var4, var5);
      }
   }

   public int[] vmethod638(int var1, int var2, int var3, byte var4) {
      if(!this.vmethod636(var1, var2, var3, 2051921401)) {
         return null;
      } else {
         int[] var5 = new int[]{this.field93 * 64 - this.field91 * 64 + var2 + (this.field99 * 8 - this.field95 * 8), var3 + (this.field96 * 64 - this.field102 * 64) + (this.field89 * 8 - this.field105 * 8)};
         return var5;
      }
   }

   public void vmethod639(Stream var1, byte var2) {
      this.field100 = var1.readUByte();
      this.field90 = var1.readUByte();
      this.field91 = var1.readUShort();
      this.field95 = var1.readUByte();
      this.field97 = var1.readUByte();
      this.field102 = var1.readUShort();
      this.field105 = var1.readUByte();
      this.field98 = var1.readUByte();
      this.field93 = var1.readUShort();
      this.field99 = var1.readUByte();
      this.field101 = var1.readUByte();
      this.field96 = var1.readUShort();
      this.field89 = var1.readUByte();
      this.field103 = var1.readUByte();
      this.method121((byte)87);
   }

   void method121(byte var1) {
   }

   public static class267 method123(int var0, byte var1) {
      class267 var2 = (class267)class267.field3349.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class267.field3367.method4625(32, var0, 1619301329);
         var2 = new class267();
         if(var3 != null) {
            var2.method4990(new Stream(var3), (byte)-40);
         }

         class267.field3349.method3983(var2, (long)var0);
         return var2;
      }
   }

   static final void method137(boolean var0, byte var1) {
      class54.method1017(2127669212);
      ++GameClient.field626.field1224;
      if(GameClient.field626.field1224 < 50 && !var0) {
         if(var1 == 16) {
            ;
         }
      } else {
         GameClient.field626.field1224 = 0;
         if(!GameClient.field756 && GameClient.field626.method1983(-1017581564) != null) {
            class172 var2 = class26.method433(OutgoingPacket.field2211, GameClient.field626.field1218, -1084426622);
            GameClient.field626.method1980(var2, (byte)1);

            try {
               GameClient.field626.method1979((byte)123);
            } catch (IOException var4) {
               GameClient.field756 = true;
            }
         }

      }
   }

   static int method139(int var0, class84 var1, boolean var2, int var3) {
      if(var0 == 5000) {
         class69.field999[++class69.field1003 - 1] = GameClient.field630;
         return 1;
      } else if(var0 == 5001) {
         class69.field1003 -= 3;
         GameClient.field630 = class69.field999[class69.field1003];
         class143.field1899 = PacketBuffer.method3847(class69.field999[class69.field1003 + 1], (short)255);
         if(class143.field1899 == null) {
            class143.field1899 = class307.field3734;
         }

         GameClient.field795 = class69.field999[class69.field1003 + 2];
         class172 var23 = class26.method433(OutgoingPacket.field2192, GameClient.field626.field1218, 1812516180);
         var23.field2257.writeByte(GameClient.field630);
         var23.field2257.writeByte(class143.field1899.field3735);
         var23.field2257.writeByte(GameClient.field795);
         GameClient.field626.method1980(var23, (byte)1);
         return 1;
      } else {
         String var4;
         int var5;
         int var6;
         if(var0 == 5002) {
            var4 = class69.field1001[--class55.field497];
            class69.field1003 -= 2;
            var5 = class69.field999[class69.field1003];
            var6 = class69.field999[class69.field1003 + 1];
            class172 var16 = class26.method433(OutgoingPacket.field2185, GameClient.field626.field1218, 2099858081);
            var16.field2257.writeByte(class316.method5820(var4, (short)256) + 2);
            var16.field2257.writeString(var4, 1653501348);
            var16.field2257.writeByte(var5 - 1);
            var16.field2257.writeByte(var6);
            GameClient.field626.method1980(var16, (byte)1);
            return 1;
         } else {
            int var11;
            if(var0 == 5003) {
               class69.field1003 -= 2;
               var11 = class69.field999[class69.field1003];
               var5 = class69.field999[class69.field1003 + 1];
               class86 var7 = (class86)class83.field1180.get(Integer.valueOf(var11));
               class58 var18 = var7.method1965(var5, (byte)78);
               if(var18 != null) {
                  class69.field999[++class69.field1003 - 1] = var18.field540;
                  class69.field999[++class69.field1003 - 1] = var18.field535;
                  class69.field1001[++class55.field497 - 1] = var18.field531 != null ? var18.field531 : "";
                  class69.field1001[++class55.field497 - 1] = var18.field537 != null ? var18.field537 : "";
                  class69.field1001[++class55.field497 - 1] = var18.field533 != null ? var18.field533 : "";
                  class69.field999[++class69.field1003 - 1] = var18.method1040(1033770680) ? 1 : (var18.method1043(1678594295) ? 2 : 0);
               } else {
                  class69.field999[++class69.field1003 - 1] = -1;
                  class69.field999[++class69.field1003 - 1] = 0;
                  class69.field1001[++class55.field497 - 1] = "";
                  class69.field1001[++class55.field497 - 1] = "";
                  class69.field1001[++class55.field497 - 1] = "";
                  class69.field999[++class69.field1003 - 1] = 0;
               }

               return 1;
            } else if(var0 == 5004) {
               var11 = class69.field999[--class69.field1003];
               class58 var20 = class61.method1130(var11, (byte)44);
               if(var20 != null) {
                  class69.field999[++class69.field1003 - 1] = var20.field532;
                  class69.field999[++class69.field1003 - 1] = var20.field535;
                  class69.field1001[++class55.field497 - 1] = var20.field531 != null ? var20.field531 : "";
                  class69.field1001[++class55.field497 - 1] = var20.field537 != null ? var20.field537 : "";
                  class69.field1001[++class55.field497 - 1] = var20.field533 != null ? var20.field533 : "";
                  class69.field999[++class69.field1003 - 1] = var20.method1040(136628574) ? 1 : (var20.method1043(1678594295) ? 2 : 0);
               } else {
                  class69.field999[++class69.field1003 - 1] = -1;
                  class69.field999[++class69.field1003 - 1] = 0;
                  class69.field1001[++class55.field497 - 1] = "";
                  class69.field1001[++class55.field497 - 1] = "";
                  class69.field1001[++class55.field497 - 1] = "";
                  class69.field999[++class69.field1003 - 1] = 0;
               }

               return 1;
            } else if(var0 == 5005) {
               if(class143.field1899 == null) {
                  class69.field999[++class69.field1003 - 1] = -1;
               } else {
                  class69.field999[++class69.field1003 - 1] = class143.field1899.field3735;
               }

               return 1;
            } else if(var0 == 5008) {
               var4 = class69.field1001[--class55.field497];
               var5 = class69.field999[--class69.field1003];
               String var17 = var4.toLowerCase();
               byte var22 = 0;
               if(var17.startsWith("yellow:")) {
                  var22 = 0;
                  var4 = var4.substring("yellow:".length());
               } else if(var17.startsWith("red:")) {
                  var22 = 1;
                  var4 = var4.substring("red:".length());
               } else if(var17.startsWith("green:")) {
                  var22 = 2;
                  var4 = var4.substring("green:".length());
               } else if(var17.startsWith("cyan:")) {
                  var22 = 3;
                  var4 = var4.substring("cyan:".length());
               } else if(var17.startsWith("purple:")) {
                  var22 = 4;
                  var4 = var4.substring("purple:".length());
               } else if(var17.startsWith("white:")) {
                  var22 = 5;
                  var4 = var4.substring("white:".length());
               } else if(var17.startsWith("flash1:")) {
                  var22 = 6;
                  var4 = var4.substring("flash1:".length());
               } else if(var17.startsWith("flash2:")) {
                  var22 = 7;
                  var4 = var4.substring("flash2:".length());
               } else if(var17.startsWith("flash3:")) {
                  var22 = 8;
                  var4 = var4.substring("flash3:".length());
               } else if(var17.startsWith("glow1:")) {
                  var22 = 9;
                  var4 = var4.substring("glow1:".length());
               } else if(var17.startsWith("glow2:")) {
                  var22 = 10;
                  var4 = var4.substring("glow2:".length());
               } else if(var17.startsWith("glow3:")) {
                  var22 = 11;
                  var4 = var4.substring("glow3:".length());
               } else if(GameClient.field827 != 0) {
                  if(var17.startsWith("yellow:")) {
                     var22 = 0;
                     var4 = var4.substring("yellow:".length());
                  } else if(var17.startsWith("red:")) {
                     var22 = 1;
                     var4 = var4.substring("red:".length());
                  } else if(var17.startsWith("green:")) {
                     var22 = 2;
                     var4 = var4.substring("green:".length());
                  } else if(var17.startsWith("cyan:")) {
                     var22 = 3;
                     var4 = var4.substring("cyan:".length());
                  } else if(var17.startsWith("purple:")) {
                     var22 = 4;
                     var4 = var4.substring("purple:".length());
                  } else if(var17.startsWith("white:")) {
                     var22 = 5;
                     var4 = var4.substring("white:".length());
                  } else if(var17.startsWith("flash1:")) {
                     var22 = 6;
                     var4 = var4.substring("flash1:".length());
                  } else if(var17.startsWith("flash2:")) {
                     var22 = 7;
                     var4 = var4.substring("flash2:".length());
                  } else if(var17.startsWith("flash3:")) {
                     var22 = 8;
                     var4 = var4.substring("flash3:".length());
                  } else if(var17.startsWith("glow1:")) {
                     var22 = 9;
                     var4 = var4.substring("glow1:".length());
                  } else if(var17.startsWith("glow2:")) {
                     var22 = 10;
                     var4 = var4.substring("glow2:".length());
                  } else if(var17.startsWith("glow3:")) {
                     var22 = 11;
                     var4 = var4.substring("glow3:".length());
                  }
               }

               var17 = var4.toLowerCase();
               byte var8 = 0;
               if(var17.startsWith("wave:")) {
                  var8 = 1;
                  var4 = var4.substring("wave:".length());
               } else if(var17.startsWith("wave2:")) {
                  var8 = 2;
                  var4 = var4.substring("wave2:".length());
               } else if(var17.startsWith("shake:")) {
                  var8 = 3;
                  var4 = var4.substring("shake:".length());
               } else if(var17.startsWith("scroll:")) {
                  var8 = 4;
                  var4 = var4.substring("scroll:".length());
               } else if(var17.startsWith("slide:")) {
                  var8 = 5;
                  var4 = var4.substring("slide:".length());
               } else if(GameClient.field827 != 0) {
                  if(var17.startsWith("wave:")) {
                     var8 = 1;
                     var4 = var4.substring("wave:".length());
                  } else if(var17.startsWith("wave2:")) {
                     var8 = 2;
                     var4 = var4.substring("wave2:".length());
                  } else if(var17.startsWith("shake:")) {
                     var8 = 3;
                     var4 = var4.substring("shake:".length());
                  } else if(var17.startsWith("scroll:")) {
                     var8 = 4;
                     var4 = var4.substring("scroll:".length());
                  } else if(var17.startsWith("slide:")) {
                     var8 = 5;
                     var4 = var4.substring("slide:".length());
                  }
               }

               class172 var9 = class26.method433(OutgoingPacket.field2179, GameClient.field626.field1218, -1290420);
               var9.field2257.writeByte(0);
               int var10 = var9.field2257.field2339;
               var9.field2257.writeByte(var5);
               var9.field2257.writeByte(var22);
               var9.field2257.writeByte(var8);
               PacketBuffer.method3840(var9.field2257, var4, (byte)100);
               var9.field2257.method3545(var9.field2257.field2339 - var10);
               GameClient.field626.method1980(var9, (byte)1);
               return 1;
            } else {
               int var14;
               if(var0 == 5009) {
                  class55.field497 -= 2;
                  var4 = class69.field1001[class55.field497];
                  String var19 = class69.field1001[class55.field497 + 1];
                  class172 var12 = class26.method433(OutgoingPacket.field2154, GameClient.field626.field1218, 890553511);
                  var12.field2257.writeShort(0);
                  var14 = var12.field2257.field2339;
                  var12.field2257.writeString(var4, 474728098);
                  PacketBuffer.method3840(var12.field2257, var19, (byte)100);
                  var12.field2257.method3614(var12.field2257.field2339 - var14, -1030510523);
                  GameClient.field626.method1980(var12, (byte)1);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class69.field999[++class69.field1003 - 1] = GameClient.field795;
                     return 1;
                  } else {
                     int[] var13;
                     if(var0 == 5017) {
                        var11 = class69.field999[--class69.field1003];
                        var13 = class69.field999;
                        var6 = ++class69.field1003 - 1;
                        class86 var21 = (class86)class83.field1180.get(Integer.valueOf(var11));
                        if(var21 == null) {
                           var14 = 0;
                        } else {
                           var14 = var21.method1976(8454016);
                        }

                        var13[var6] = var14;
                        return 1;
                     } else if(var0 == 5018) {
                        var11 = class69.field999[--class69.field1003];
                        class69.field999[++class69.field1003 - 1] = class66.method1621(var11, 1297107509);
                        return 1;
                     } else if(var0 == 5019) {
                        var11 = class69.field999[--class69.field1003];
                        var13 = class69.field999;
                        var6 = ++class69.field1003 - 1;
                        class58 var15 = (class58)class83.field1181.method3945((long)var11);
                        if(var15 == null) {
                           var14 = -1;
                        } else if(var15.field2427 == class83.field1184.field2445) {
                           var14 = -1;
                        } else {
                           var14 = ((class58)var15.field2427).field540;
                        }

                        var13[var6] = var14;
                        return 1;
                     } else if(var0 == 5020) {
                        var4 = class69.field1001[--class55.field497];
                        ScriptInvocation.method1031(var4, (byte)54);
                        return 1;
                     } else if(var0 == 5021) {
                        GameClient.field796 = class69.field1001[--class55.field497].toLowerCase().trim();
                        return 1;
                     } else if(var0 == 5022) {
                        class69.field1001[++class55.field497 - 1] = GameClient.field796;
                        return 1;
                     } else {
                        return 2;
                     }
                  }
               } else {
                  if(class138.field1876 != null && class138.field1876.field552 != null) {
                     var4 = class138.field1876.field552.method5447((byte)-24);
                  } else {
                     var4 = "";
                  }

                  class69.field1001[++class55.field497 - 1] = var4;
                  return 1;
               }
            }
         }
      }
   }
}
