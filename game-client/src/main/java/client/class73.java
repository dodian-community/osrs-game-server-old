package client;

import java.math.BigInteger;

public class class73 {
   static final BigInteger field1039 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   static final BigInteger field1044 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   static final String field1040 = "services";
   static final int field1041 = 6;
   static final int field1042 = 1000;
   static final int field1043 = 8;
   static final int field1045 = 2;
   static final int field1046 = 4;
   static final int field1047 = 765;
   static final String field1048 = "m=accountappeal/login.ws";
   static final String field1049 = "passwordchoice.ws";

   static int method1799(int var0, class84 var1, boolean var2, int var3) {
      int var4;
      if(var0 == 4200) {
         var4 = class69.field999[--class69.field1003];
         class69.field1001[++class55.field497 - 1] = ItemDef.loadItemDef(var4).name;
         return 1;
      } else {
         int var5;
         ItemDef var18;
         if(var0 == 4201) {
            class69.field1003 -= 2;
            var4 = class69.field999[class69.field1003];
            var5 = class69.field999[class69.field1003 + 1];
            var18 = ItemDef.loadItemDef(var4);
            if(var5 >= 1 && var5 <= 5 && var18.options[var5 - 1] != null) {
               class69.field1001[++class55.field497 - 1] = var18.options[var5 - 1];
            } else {
               class69.field1001[++class55.field497 - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class69.field1003 -= 2;
            var4 = class69.field999[class69.field1003];
            var5 = class69.field999[class69.field1003 + 1];
            var18 = ItemDef.loadItemDef(var4);
            if(var5 >= 1 && var5 <= 5 && var18.interfaceOptions[var5 - 1] != null) {
               class69.field1001[++class55.field497 - 1] = var18.interfaceOptions[var5 - 1];
            } else {
               class69.field1001[++class55.field497 - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var4 = class69.field999[--class69.field1003];
            class69.field999[++class69.field1003 - 1] = ItemDef.loadItemDef(var4).cost;
            return 1;
         } else if(var0 == 4204) {
            var4 = class69.field999[--class69.field1003];
            class69.field999[++class69.field1003 - 1] = ItemDef.loadItemDef(var4).stackable == 1 ? 1 : 0;
            return 1;
         } else {
            ItemDef var14;
            if(var0 == 4205) {
               var4 = class69.field999[--class69.field1003];
               var14 = ItemDef.loadItemDef(var4);
               if(var14.notedTemplate == -1 && var14.notedID >= 0) {
                  class69.field999[++class69.field1003 - 1] = var14.notedID;
               } else {
                  class69.field999[++class69.field1003 - 1] = var4;
               }

               return 1;
            } else if(var0 == 4206) {
               var4 = class69.field999[--class69.field1003];
               var14 = ItemDef.loadItemDef(var4);
               if(var14.notedTemplate >= 0 && var14.notedID >= 0) {
                  class69.field999[++class69.field1003 - 1] = var14.notedID;
               } else {
                  class69.field999[++class69.field1003 - 1] = var4;
               }

               return 1;
            } else if(var0 == 4207) {
               var4 = class69.field999[--class69.field1003];
               class69.field999[++class69.field1003 - 1] = ItemDef.loadItemDef(var4).members ? 1 : 0;
               return 1;
            } else if(var0 == 4208) {
               var4 = class69.field999[--class69.field1003];
               var14 = ItemDef.loadItemDef(var4);
               if(var14.int638 == -1 && var14.int641 >= 0) {
                  class69.field999[++class69.field1003 - 1] = var14.int641;
               } else {
                  class69.field999[++class69.field1003 - 1] = var4;
               }

               return 1;
            } else if(var0 == 4209) {
               var4 = class69.field999[--class69.field1003];
               var14 = ItemDef.loadItemDef(var4);
               if(var14.int638 >= 0 && var14.int641 >= 0) {
                  class69.field999[++class69.field1003 - 1] = var14.int641;
               } else {
                  class69.field999[++class69.field1003 - 1] = var4;
               }

               return 1;
            } else if(var0 == 4210) {
               String var15 = class69.field1001[--class55.field497];
               var5 = class69.field999[--class69.field1003];
               boolean var7 = var5 == 1;
               String var6 = var15.toLowerCase();
               short[] var8 = new short[16];
               int var9 = 0;
               int var10 = 0;

               while(true) {
                  if(var10 >= class86.field1212) {
                     class27.field231 = var8;
                     class55.field495 = 0;
                     class126.field1778 = var9;
                     String[] var16 = new String[class126.field1778];

                     for(int var17 = 0; var17 < class126.field1778; var17++) {
                        var16[var17] = ItemDef.loadItemDef(var8[var17]).name;
                     }

                     class133.method3100(var16, class27.field231, (byte)4);
                     break;
                  }

                  ItemDef var11 = ItemDef.loadItemDef(var10);
                  if((!var7 || var11.bool67) && var11.notedTemplate == -1 && var11.name.toLowerCase().indexOf(var6) != -1) {
                     if(var9 >= 250) {
                        class126.field1778 = -1;
                        class27.field231 = null;
                        break;
                     }

                     if(var9 >= var8.length) {
                        short[] var12 = new short[var8.length * 2];

                        for(int var13 = 0; var13 < var9; var13++) {
                           var12[var13] = var8[var13];
                        }

                        var8 = var12;
                     }

                     var8[var9++] = (short)var10;
                  }

                  ++var10;
               }

               class69.field999[++class69.field1003 - 1] = class126.field1778;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  class55.field495 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class27.field231 != null && class55.field495 < class126.field1778) {
                  class69.field999[++class69.field1003 - 1] = class27.field231[++class55.field495 - 1] & 65535;
               } else {
                  class69.field999[++class69.field1003 - 1] = -1;
               }

               return 1;
            }
         }
      }
   }
}
