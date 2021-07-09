package client;

public class NpcDef extends class206 {

   public static class200 field3489 = new class200(50);
   public static class200 field3488 = new class200(64);
   public static class247 field3487;
   public static class247 field3490;
   class197 iterableImpl1_2;
   int int588 = -1;
   public int[] intArray106;
   public String name = "null";
   int int589 = -1;
   int[] intArray105;
   public int field3510;
   int[] intArray104;
   public int size = 1;
   public int idleAnimation = -1;
   public int walkAnimation = -1;
   public int op15 = -1;
   public int op16 = -1;
   public String[] options = new String[5];
   int int584 = 128;
   short[] shortArray2;
   int int574 = 128;
   short[] shortArray4;
   public boolean bool59 = true;
   public int turn180Animation = -1;
   short[] shortArray3;
   short[] shortArray5;
   public int turn90CWAnimation = -1;
   public int combatLevel = -1;
   public boolean bool58 = false;
   public int turn90CCAnimation = -1;
   int int586 = 0;
   int int587 = 0;
   public int int585 = -1;
   public int turnValue = 32;
   public boolean bool61 = true;
   public boolean bool62 = true;
   public boolean bool60 = false;

   public final NpcDef method5189(int var1) {
      int var2 = -1;
      if(this.int588 != -1) {
         var2 = class163.method3389(this.int588, -397804509);
      } else if(this.int589 != -1) {
         var2 = class225.field2558[this.int589];
      }

      int var3;
      if(var2 >= 0 && var2 < this.intArray106.length - 1) {
         var3 = this.intArray106[var2];
      } else {
         var3 = this.intArray106[this.intArray106.length - 1];
      }

      return var3 != -1 ? class270.loadNpcDef(var3) : null;
   }

   void readValue(Stream var1, int var2) {
      int var4;
      int var5;
      if(var2 == 1) {
         var4 = var1.readUByte();
         this.intArray104 = new int[var4];

         for(var5 = 0; var5 < var4; var5++) {
            this.intArray104[var5] = var1.readUShort();
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 12) {
         this.size = var1.readUByte();
      } else if(var2 == 13) {
         this.idleAnimation = var1.readUShort();
      } else if(var2 == 14) {
         this.walkAnimation = var1.readUShort();
      } else if(var2 == 15) {
         this.op15 = var1.readUShort();
      } else if(var2 == 16) {
         this.op16 = var1.readUShort();
      } else if(var2 == 17) {
         this.walkAnimation = var1.readUShort();
         this.turn180Animation = var1.readUShort();
         this.turn90CWAnimation = var1.readUShort();
         this.turn90CCAnimation = var1.readUShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.options[var2 - 30] = var1.readString();
         if(this.options[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.options[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var4 = var1.readUByte();
         this.shortArray2 = new short[var4];
         this.shortArray3 = new short[var4];

         for(var5 = 0; var5 < var4; var5++) {
            this.shortArray2[var5] = (short)var1.readUShort();
            this.shortArray3[var5] = (short)var1.readUShort();
         }
      } else if(var2 == 41) {
         var4 = var1.readUByte();
         this.shortArray4 = new short[var4];
         this.shortArray5 = new short[var4];

         for(var5 = 0; var5 < var4; var5++) {
            this.shortArray4[var5] = (short)var1.readUShort();
            this.shortArray5[var5] = (short)var1.readUShort();
         }
      } else if(var2 == 60) {
         var4 = var1.readUByte();
         this.intArray105 = new int[var4];

         for(var5 = 0; var5 < var4; var5++) {
            this.intArray105[var5] = var1.readUShort();
         }
      } else if(var2 == 93) {
         this.bool59 = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUShort();
      } else if(var2 == 97) {
         this.int584 = var1.readUShort();
      } else if(var2 == 98) {
         this.int574 = var1.readUShort();
      } else if(var2 == 99) {
         this.bool58 = true;
      } else if(var2 == 100) {
         this.int586 = var1.readByte();
      } else if(var2 == 101) {
         this.int587 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.int585 = var1.readUShort();
      } else if(var2 == 103) {
         this.turnValue = var1.readUShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.bool61 = false;
         } else if(var2 == 109) {
            this.bool62 = false;
         } else if(var2 == 111) {
            this.bool60 = true;
         } else if(var2 == 249) {

            this.iterableImpl1_2 = class39.method691(var1, this.iterableImpl1_2, 123380361);
         }
      } else {
         this.int588 = var1.readUShort();
         if(this.int588 == 65535) {
            this.int588 = -1;
         }

         this.int589 = var1.readUShort();
         if(this.int589 == 65535) {
            this.int589 = -1;
         }

         var4 = -1;
         if(var2 == 118) {
            var4 = var1.readUShort();
            if(var4 == 65535) {
               var4 = -1;
            }
         }

         var5 = var1.readUByte();
         this.intArray106 = new int[var5 + 2];

         for(int var6 = 0; var6 <= var5; var6++) {
            this.intArray106[var6] = var1.readUShort();
            if(this.intArray106[var6] == 65535) {
               this.intArray106[var6] = -1;
            }
         }

         this.intArray106[var5 + 1] = var4;
      }
   }

   public final class113 method5158(byte var1) {
      if(this.intArray106 != null) {
         NpcDef var2 = this.method5189(389626273);
         return var2 == null ? null : var2.method5158((byte)-72);
      } else if(this.intArray105 == null) {
         return null;
      } else {
         boolean var6 = false;

         for(int var3 = 0; var3 < this.intArray105.length; var3++) {
            if(!field3487.method4696(this.intArray105[var3], 0, (byte)1)) {
               var6 = true;
            }
         }

         if(var6) {
            return null;
         } else {
            class113[] var7 = new class113[this.intArray105.length];

            for(int var4 = 0; var4 < this.intArray105.length; var4++) {
               var7[var4] = class113.method2568(field3487, this.intArray105[var4], 0);
            }

            class113 var8;
            if(var7.length == 1) {
               var8 = var7[0];
            } else {
               var8 = new class113(var7, var7.length);
            }

            int var5;
            if(this.shortArray2 != null) {
               for(var5 = 0; var5 < this.shortArray2.length; var5++) {
                  var8.method2581(this.shortArray2[var5], this.shortArray3[var5]);
               }
            }

            if(this.shortArray4 != null) {
               for(var5 = 0; var5 < this.shortArray4.length; var5++) {
                  var8.method2582(this.shortArray4[var5], this.shortArray5[var5]);
               }
            }

            return var8;
         }
      }
   }

   public final class119 method5162(class273 var1, int var2, class273 var3, int var4, int var5) {
      if(this.intArray106 != null) {
         NpcDef var13 = this.method5189(-1364980748);
         return var13 == null ? null : var13.method5162(var1, var2, var3, var4, -1886186491);
      } else {
         class119 var6 = (class119)field3489.method3989((long)this.field3510);
         if(var6 == null) {
            boolean var7 = false;

            for(int var8 = 0; var8 < this.intArray104.length; var8++) {
               if(!field3487.method4696(this.intArray104[var8], 0, (byte)1)) {
                  var7 = true;
               }
            }

            if(var7) {
               return null;
            }

            class113[] var9 = new class113[this.intArray104.length];

            int var10;
            for(var10 = 0; var10 < this.intArray104.length; var10++) {
               var9[var10] = class113.method2568(field3487, this.intArray104[var10], 0);
            }

            class113 var12;
            if(var9.length == 1) {
               var12 = var9[0];
            } else {
               var12 = new class113(var9, var9.length);
            }

            if(this.shortArray2 != null) {
               for(var10 = 0; var10 < this.shortArray2.length; var10++) {
                  var12.method2581(this.shortArray2[var10], this.shortArray3[var10]);
               }
            }

            if(this.shortArray4 != null) {
               for(var10 = 0; var10 < this.shortArray4.length; var10++) {
                  var12.method2582(this.shortArray4[var10], this.shortArray5[var10]);
               }
            }

            var6 = var12.method2589(this.int586 + 64, this.int587 + 850, -30, -50, -30);
            field3489.method3983(var6, (long)this.field3510);
         }

         class119 var11;
         if(var1 != null && var3 != null) {
            var11 = var1.method5221(var6, var2, var3, var4, -868457028);
         } else if(var1 != null) {
            var11 = var1.method5215(var6, var2, -1433585529);
         } else if(var3 != null) {
            var11 = var3.method5215(var6, var4, -1433585529);
         } else {
            var11 = var6.method2666(true);
         }

         if(this.int584 != 128 || this.int574 != 128) {
            var11.method2681(this.int584, this.int574, this.int584);
         }

         return var11;
      }
   }

   void method5159() {
   }

   void readValues(Stream var1) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.readValue(var1, var3);
      }
   }

   public boolean method5165() {
      if(this.intArray106 == null) {
         return true;
      } else {
         int var2 = -1;
         if(this.int588 != -1) {
            var2 = class163.method3389(this.int588, -397804509);
         } else if(this.int589 != -1) {
            var2 = class225.field2558[this.int589];
         }

         return var2 >= 0 && var2 < this.intArray106.length ? this.intArray106[var2] != -1 : this.intArray106[this.intArray106.length - 1] != -1;
      }
   }

   public int method5166(int var1, int var2, int var3) {
      return class67.method1668(this.iterableImpl1_2, var1, var2, (short)-17706);
   }

   public String method5167(int var1, String var2, byte var3) {
      return class17.method171(this.iterableImpl1_2, var1, var2, (short)255);
   }
}
