package client;

public final class Player extends class63 {
   static final int field549 = 3;
   static final int field561 = 4;
   class289 field554;
   class289 field569;
   class227 field546;
   class291 field552;
   int skullIcon = -1;
   int field548 = -1;
   boolean field560;
   String[] field550 = new String[3];
   int field551;
   int field564;
   int field568;
   int field545;
   int field555;
   boolean hidden;
   class119 field563;
   boolean field571;
   int field556;
   int field557;
   int field562;
   int field558;
   int field567;
   int field574;
   int field572;
   int field573;
   int field559;
   int field547;
   int field565;
   int field553;

   Player() {
      for(int var1 = 0; var1 < 3; var1++) {
         this.field550[var1] = "";
      }

      this.field551 = 0;
      this.field564 = 0;
      this.field545 = 0;
      this.field555 = 0;
      this.field560 = false;
      this.field568 = 0;
      this.hidden = false;
      this.field569 = class289.field3633;
      this.field554 = class289.field3633;
      this.field571 = false;
   }

   protected final class119 vmethod3067(int var1) {
      if(this.field546 == null) {
         return null;
      } else {
         class273 var2 = super.field903 != -1 && super.field906 == 0 ? class3.method25(super.field903, -1140525465) : null;
         class273 var3 = super.field900 == -1 || this.field560 || super.field900 == super.field893 && var2 != null ? null : class3.method25(super.field900, 647164638);
         class119 var4 = this.field546.method4468(var2, super.field904, var3, super.field908, 871274548);
         if(var4 == null) {
            return null;
         } else {
            var4.method2670();
            super.field925 = var4.field1781;
            class119 var5;
            class119[] var6;
            if(!this.field560 && super.field891 != -1 && super.field876 != -1) {
               var5 = class57.method1035(super.field891, -1649996310).method4866(super.field876, -226282486);
               if(var5 != null) {
                  var5.method2718(0, -super.field871, 0);
                  var6 = new class119[]{var4, var5};
                  var4 = new class119(var6, 2);
               }
            }

            if(!this.field560 && this.field563 != null) {
               if(GameClient.field591 >= this.field555) {
                  this.field563 = null;
               }

               if(GameClient.field591 >= this.field545 && GameClient.field591 < this.field555) {
                  var5 = this.field563;
                  var5.method2718(this.field556 - super.field931, this.field557 - this.field562, this.field558 - super.field881);
                  if(super.field926 == 512) {
                     var5.method2677();
                     var5.method2677();
                     var5.method2677();
                  } else if(super.field926 == 1024) {
                     var5.method2677();
                     var5.method2677();
                  } else if(super.field926 == 1536) {
                     var5.method2677();
                  }

                  var6 = new class119[]{var4, var5};
                  var4 = new class119(var6, 2);
                  if(super.field926 == 512) {
                     var5.method2677();
                  } else if(super.field926 == 1024) {
                     var5.method2677();
                     var5.method2677();
                  } else if(super.field926 == 1536) {
                     var5.method2677();
                     var5.method2677();
                     var5.method2677();
                  }

                  var5.method2718(super.field931 - this.field556, this.field562 - this.field557, super.field881 - this.field558);
               }
            }

            var4.field1603 = true;
            return var4;
         }
      }
   }

   void method1087(int var1) {
      this.field554 = class14.field94 != null && class14.field94.method5329(this.field552, -1926491631) ? class289.field3631 : class289.field3634;
   }

   void method1085(byte var1) {
      this.field569 = class181.field2332.method1637(this.field552, 1644898931) ? class289.field3631 : class289.field3634;
   }

   void method1103(int var1, int var2, int var3) {
      super.field909 = 0;
      super.field930 = 0;
      super.field923 = 0;
      super.field922[0] = var1;
      super.field872[0] = var2;
      int var4 = this.method1088((byte)-49);
      super.field931 = var4 * 64 + super.field922[0] * 128;
      super.field881 = var4 * 64 + super.field872[0] * 128;
   }

   int method1088(byte var1) {
      return this.field546 != null && this.field546.field2569 != -1 ? class270.loadNpcDef(this.field546.field2569).size : 1;
   }

   void method1084(int var1) {
      this.field569 = class289.field3633;
   }

   final void method1105(int var1, int var2, byte var3, byte var4) {
      if(super.field909 < 9) {
         if(var4 != 12) {
            return;
         }

         ++super.field909;
      }

      for(int var5 = super.field909; var5 > 0; --var5) {
         super.field922[var5] = super.field922[var5 - 1];
         super.field872[var5] = super.field872[var5 - 1];
         super.field928[var5] = super.field928[var5 - 1];
      }

      super.field922[0] = var1;
      super.field872[0] = var2;
      super.field928[0] = var3;
   }

   void method1086(int var1) {
      this.field554 = class289.field3633;
   }

   final boolean vmethod1786(byte var1) {
      return this.field546 != null;
   }

   final void decodeLooks(Stream buffer, int var2) {
      buffer.field2339 = 0;
      int var3 = buffer.readUByte();
      this.skullIcon = buffer.readByte();
      this.field548 = buffer.readByte();
      int var4 = -1;
      this.field568 = 0;
      int[] var5 = new int[12];

      int var7;
      int var8;
      for(int var6 = 0; var6 < 12; var6++) {
         var7 = buffer.readUByte();
         if(var7 == 0) {
            var5[var6] = 0;
         } else {
            var8 = buffer.readUByte();
            var5[var6] = var8 + (var7 << 8);
            if(var6 == 0 && var5[0] == 65535) {
               if(var2 >= 2092317556) {
                  return;
               }

               var4 = buffer.readUShort();
               break;
            }

            if(var5[var6] >= 512) {
               int var9 = ItemDef.loadItemDef(var5[var6] - 512).team;
               if(var9 != 0) {
                  this.field568 = var9;
               }
            }
         }
      }

      int[] var10 = new int[5];

      for(var7 = 0; var7 < 5; var7++) {
         label116: {
            var8 = buffer.readUByte();
            if(var8 >= 0) {
               if(var2 >= 2092317556) {
                  return;
               }

               if(var8 < class227.field2572[var7].length) {
                  break label116;
               }
            }

            var8 = 0;
         }

         var10[var7] = var8;
      }

      super.field893 = buffer.readUShort();
      if(super.field893 == 65535) {
         super.field893 = -1;
      }

      super.field877 = buffer.readUShort();
      if(super.field877 == 65535) {
         super.field877 = -1;
      }

      super.field878 = super.field877;
      super.field899 = buffer.readUShort();
      if(super.field899 == 65535) {
         if(var2 >= 2092317556) {
            return;
         }

         super.field899 = -1;
      }

      super.field880 = buffer.readUShort();
      if(super.field880 == 65535) {
         if(var2 >= 2092317556) {
            return;
         }

         super.field880 = -1;
      }

      super.field870 = buffer.readUShort();
      if(super.field870 == 65535) {
         super.field870 = -1;
      }

      super.field882 = buffer.readUShort();
      if(super.field882 == 65535) {
         super.field882 = -1;
      }

      super.field883 = buffer.readUShort();
      if(super.field883 == 65535) {
         super.field883 = -1;
      }

      this.field552 = new class291(buffer.readString(), class36.field306);
      this.method1084(-540228134);
      this.method1086(-487567692);
      if(this == class138.field1876) {
         if(var2 >= 2092317556) {
            return;
         }

         class152.field1939 = this.field552.method5447((byte)54);
      }

      this.field551 = buffer.readUByte();
      this.field564 = buffer.readUShort();
      this.hidden = buffer.readUByte() == 1;
      if(GameClient.field777 == 0 && GameClient.field747 >= 2) {
         this.hidden = false;
      }

      if(this.field546 == null) {
         this.field546 = new class227();
      }

      class227 var10000 = this.field546;
      boolean var10003;
      if(var3 == 1) {
         if(var2 >= 2092317556) {
            return;
         }

         var10003 = true;
      } else {
         var10003 = false;
      }

      var10000.method4462(var5, var10, var10003, var4, 1432053392);
   }

   final void method1106(int var1, int var2, byte var3, int var4) {
      if(super.field903 != -1 && class3.method25(super.field903, 1067097101).field3535 == 1) {
         super.field903 = -1;
      }

      super.field920 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field922[0] >= 0 && super.field922[0] < 104 && super.field872[0] >= 0) {
            if(super.field872[0] < 104) {
               if(var3 == 2) {
                  class62.method1538(this, var1, var2, (byte)2, (byte)-55);
               }

               this.method1105(var1, var2, var3, (byte)12);
               return;
            }

            if(var4 != -1440413395) {
               return;
            }
         }

         this.method1103(var1, var2, 1068528614);
      } else {
         this.method1103(var1, var2, -1880816972);
      }

   }

   boolean method1083(int var1) {
      if(this.field569 == class289.field3633) {
         this.method1085((byte)-35);
      }

      return this.field569 == class289.field3631;
   }

   boolean method1104(int var1) {
      if(this.field554 == class289.field3633) {
         this.method1087(1372893329);
      }

      return this.field554 == class289.field3631;
   }

   static void method1120(int var0, int var1, int var2) {
      class171.method3451(class229.field2588, var0, var1, -1489132269);
      class229.field2588 = null;
   }
}
