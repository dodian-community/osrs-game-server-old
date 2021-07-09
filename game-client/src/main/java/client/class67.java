package client;

public class class67 {
   static int[][] field973;
   static int field978;
   static final int field971 = 1;
   static final int field972 = 2;
   static final int field977 = 0;
   static final int field979 = 21;
   int field976 = 0;
   public final class284 field975;
   public final class290 field970;
   final class322 field974;

   class67(class322 var1) {
      this.field974 = var1;
      this.field970 = new class290(var1);
      this.field975 = new class284(var1);
   }

   final boolean method1637(class291 var1, int var2) {
      class292 var3 = (class292)this.field970.method5330(var1, -1029474979);
      return var3 != null && var3.method5415((byte)-34);
   }

   final boolean method1632(int var1) {
      return this.field970.method5328(-546371351) || this.field970.method5327(821008449) >= 200 && GameClient.field698 != 1;
   }

   final boolean method1634(short var1) {
      return this.field975.method5328(-1908171622) || this.field975.method5327(821008449) >= 100 && GameClient.field698 != 1;
   }

   final boolean method1660(class291 var1, boolean var2, int var3) {
      return var1 == null ? false : (var1.equals(class138.field1876.field552) ? true : this.field970.method5423(var1, var2, 1240127676));
   }

   final boolean method1630(class291 var1, int var2) {
      return var1 == null ? false : this.field975.method5329(var1, -1323034650);
   }

   final void method1628(int var1) {
      this.field976 = 0;
      this.field970.method5326(1666752471);
      this.field975.method5326(1666752471);
   }

   final void method1625(int var1) {
      this.field976 = 1;
   }

   final void method1679(Stream var1, int var2, int var3) {
      this.field970.method5424(var1, var2, 1284102001);
      this.field976 = 2;
      class53.method1012(-1595845951);
   }

   boolean method1624(int var1) {
      return this.field976 == 2;
   }

   final void method1631(String var1, byte var2) {
      if(var1 != null) {
         class291 var3 = new class291(var1, this.field974);
         if(var3.method5441(-276257020)) {
            Object var10000;
            String var5;
            if(this.method1632(1546113149)) {
               if(var2 != 0) {
                  var10000 = null;
                  var5 = "Your friend list is full. Max of 200 for free users, and 400 for members";
                  class143.method3172(30, "", var5);
               }
            } else if(class138.field1876.field552.equals(var3)) {
               if(var2 != 0) {
                  var10000 = null;
                  var5 = "You can\'t add yourself to your own friend list";
                  class143.method3172(30, "", var5);
               }
            } else if(this.method1660(var3, false, -1961233435)) {
               class233.method4588(var1, (byte)-31);
            } else if(this.method1630(var3, 692404007)) {
               class51.method995(var1, -827181248);
            } else {
               class172 var4 = class26.method433(OutgoingPacket.field2194, GameClient.field626.field1218, 54120903);
               var4.field2257.writeByte(class316.method5820(var1, (short)256));
               var4.field2257.writeString(var1, 1376196598);
               GameClient.field626.method1980(var4, (byte)1);
            }
         }
      }
   }

   final void method1627(int var1) {
      for(class294 var2 = (class294)this.field970.field3639.method4111(); var2 != null; var2 = (class294)this.field970.field3639.method4114()) {
         if((long)var2.field3665 < Stream.method3547(604838575) / 1000L - 5L) {
            if(var2.field3664 > 0) {
               class143.method3172(5, "", var2.field3662 + " has logged in.");
            }

            if(var2.field3664 == 0) {
               class143.method3172(5, "", var2.field3662 + " has logged out.");
            }

            var2.method4121();
         }
      }

   }

   final void method1665(String var1, int var2) {
      if(var1 != null) {
         class291 var3 = new class291(var1, this.field974);
         if(!var3.method5441(396052465)) {
            if(var2 != -644722512) {
               ;
            }
         } else {
            if(this.field970.method5393(var3, -630765365)) {
               GameClient.field647 = GameClient.field801;
               class172 var4 = class26.method433(OutgoingPacket.field2203, GameClient.field626.field1218, -639070641);
               var4.field2257.writeByte(class316.method5820(var1, (short)256));
               var4.field2257.writeString(var1, 1795559003);
               GameClient.field626.method1980(var4, (byte)1);
            }

            class53.method1012(-840533249);
         }
      }
   }

   final void method1633(String var1, byte var2) {
      if(var1 != null) {
         class291 var3 = new class291(var1, this.field974);
         if(var3.method5441(-1623927239)) {
            if(this.method1634((short)128)) {
               class28.method475(1804250172);
            } else {
               StringBuilder var10000;
               String var5;
               if(class138.field1876.field552.equals(var3)) {
                  var10000 = null;
                  var5 = "You can\'t add yourself to your own ignore list";
                  class143.method3172(30, "", var5);
               } else if(this.method1630(var3, -1365831937)) {
                  class21.method271(var1, -1994445247);
               } else if(this.method1660(var3, false, -1961233435)) {
                  var10000 = new StringBuilder();
                  Object var10001 = null;
                  var10000 = var10000.append("Please remove ").append(var1);
                  var10001 = null;
                  var5 = var10000.append(" from your friend list first").toString();
                  class143.method3172(30, "", var5);
               } else {
                  class172 var4 = class26.method433(OutgoingPacket.field2221, GameClient.field626.field1218, -198595464);
                  var4.field2257.writeByte(class316.method5820(var1, (short)256));
                  var4.field2257.writeString(var1, 584337820);
                  GameClient.field626.method1980(var4, (byte)1);
               }
            }
         }
      }
   }

   final void method1636(String var1, int var2) {
      if(var1 != null) {
         class291 var3 = new class291(var1, this.field974);
         if(var3.method5441(-1799343910)) {
            if(this.field975.method5393(var3, -2109655831)) {
               if(var2 == -1613465741) {
                  return;
               }

               GameClient.field647 = GameClient.field801;
               class172 var4 = class26.method433(OutgoingPacket.field2157, GameClient.field626.field1218, -1474913465);
               var4.field2257.writeByte(class316.method5820(var1, (short)256));
               var4.field2257.writeString(var1, -1301289795);
               GameClient.field626.method1980(var4, (byte)1);
            }

            GameShell.method910(618669821);
            if(class14.field94 != null) {
               class14.field94.method5468(1839052709);
            }

         }
      }
   }

   static int method1668(class197 var0, int var1, int var2, short var3) {
      if(var0 == null) {
         return var2;
      } else {
         class211 var4 = (class211)var0.method3945((long)var1);
         return var4 == null ? var2 : var4.field2438;
      }
   }

   static void method1655(int var0) {
      int var1 = class81.field1167;
      int[] var2 = class81.field1159;

      for(int var3 = 0; var3 < var1; var3++) {
         if(var2[var3] != GameClient.field707) {
            if(var2[var3] == GameClient.field628) {
               if(var0 != 1786186478) {
                  return;
               }
            } else {
               class11.method98(GameClient.field610[var2[var3]], true, -1937218384);
            }
         }
      }

   }

   static final void method1682(PaletteSprite var0, byte var1) {
      short var2 = 256;

      int var3;
      for(var3 = 0; var3 < class186.field2367.length; var3++) {
         class186.field2367[var3] = 0;
      }

      int var4;
      for(var3 = 0; var3 < 5000; var3++) {
         var4 = (int)(Math.random() * 128.0D * (double)var2);
         class186.field2367[var4] = (int)(Math.random() * 256.0D);
      }

      int var5;
      int var6;
      for(var3 = 0; var3 < 20; var3++) {
         for(var4 = 1; var4 < var2 - 1; var4++) {
            for(var5 = 1; var5 < 127; var5++) {
               var6 = var5 + (var4 << 7);
               class81.field1169[var6] = (class186.field2367[var6 - 128] + class186.field2367[var6 + 1] + class186.field2367[var6 + 128] + class186.field2367[var6 - 1]) / 4;
            }
         }

         int[] var9 = class186.field2367;
         class186.field2367 = class81.field1169;
         class81.field1169 = var9;
      }

      if(var0 != null) {
         var3 = 0;

         for(var4 = 0; var4 < var0.height1; var4++) {
            for(var5 = 0; var5 < var0.width1; var5++) {
               if(var0.pixels[var3++] != 0) {
                  var6 = var5 + var0.offX + 16;
                  int var7 = var4 + var0.offY + 16;
                  int var8 = var6 + (var7 << 7);
                  class186.field2367[var8] = 0;
               }
            }
         }
      }

   }

   public static boolean method1683(long var0) {
      boolean var2 = var0 != 0L;
      if(var2) {
         boolean var3 = (int)(var0 >>> 16 & 1L) == 1;
         var2 = !var3;
      }

      return var2;
   }

   public static void method1685(int var0, int var1, int var2) {
      class263 var4 = (class263)class263.field3321.method3989((long)var0);
      class263 var3;
      if(var4 != null) {
         if(var2 <= 1002327458) {
            return;
         }

         var3 = var4;
      } else {
         byte[] var9 = class263.field3322.method4625(14, var0, 1960138263);
         var4 = new class263();
         if(var9 != null) {
            var4.method4941(new Stream(var9), 1638466830);
         }

         class263.field3321.method3983(var4, (long)var0);
         var3 = var4;
      }

      int var5 = var3.field3320;
      int var6 = var3.field3323;
      int var7 = var3.field3326;
      int var8 = class225.field2557[var7 - var6];
      if(var1 < 0 || var1 > var8) {
         var1 = 0;
      }

      var8 <<= var6;
      class225.field2558[var5] = class225.field2558[var5] & ~var8 | var1 << var6 & var8;
   }
}
