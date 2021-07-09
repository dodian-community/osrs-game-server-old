package client;

public class class228 {
   public static final short[] field2582 = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};
   public static final short[][] field2583 = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127, (short)-31821}};
   public static final short[] field2586 = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
   public static final short[][] field2585 = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};
   static final int field2584 = 2;

   static final boolean method4494(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = class120.field1649 + var6;
      if(var8 < var0 && var8 < var1 && var8 < var2) {
         return false;
      } else {
         var8 = class120.field1649 - var6;
         if(var8 > var0 && var8 > var1 && var8 > var2) {
            return false;
         } else {
            var8 = class120.field1648 + var6;
            if(var8 < var3 && var8 < var4 && var8 < var5) {
               return false;
            } else {
               var8 = class120.field1648 - var6;
               return var8 <= var3 || var8 <= var4 || var8 <= var5;
            }
         }
      }
   }

   static int method4495(int var0, class84 var1, boolean var2, int var3) {
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = Widget.getLoaded(class69.field999[--class69.field1003]);
      } else {
         var4 = var2 ? class276.field3561 : class260.field3301;
      }

      String var5 = class69.field1001[--class55.field497];
      int[] var6 = null;
      if(var5.length() > 0 && var5.charAt(var5.length() - 1) == 89) {
         int var7 = class69.field999[--class69.field1003];
         if(var7 > 0) {
            for(var6 = new int[var7]; var7-- > 0; var6[var7] = class69.field999[--class69.field1003]) {
               ;
            }
         }

         var5 = var5.substring(0, var5.length() - 1);
      }

      Object[] var9 = new Object[var5.length() + 1];

      int var8;
      for(var8 = var9.length - 1; var8 >= 1; --var8) {
         if(var5.charAt(var8 - 1) == 115) {
            var9[var8] = class69.field1001[--class55.field497];
         } else {
            var9[var8] = new Integer(class69.field999[--class69.field1003]);
         }
      }

      var8 = class69.field999[--class69.field1003];
      if(var8 != -1) {
         var9[0] = new Integer(var8);
      } else {
         var9 = null;
      }

      if(var0 == 1400) {
         var4.objectArray7 = var9;
      } else if(var0 == 1401) {
         var4.objectArray9 = var9;
      } else if(var0 == 1402) {
         var4.objectArray5 = var9;
      } else if(var0 == 1403) {
         var4.mouseEnteredScript = var9;
      } else if(var0 == 1404) {
         var4.mouseLeftScript = var9;
      } else if(var0 == 1405) {
         var4.objectArray30 = var9;
      } else if(var0 == 1406) {
         var4.objectArray15 = var9;
      } else if(var0 == 1407) {
         var4.onConfigTrigger = var9;
         var4.mouseWheelTrigger = var6;
      } else if(var0 == 1408) {
         var4.objectArray17 = var9;
      } else if(var0 == 1409) {
         var4.onClickListener = var9;
      } else if(var0 == 1410) {
         var4.objectArray13 = var9;
      } else if(var0 == 1411) {
         var4.objectArray8 = var9;
      } else if(var0 == 1412) {
         var4.objectArray11 = var9;
      } else if(var0 == 1414) {
         var4.onItemUpdateTrigger = var9;
         var4.configChangeTriggers = var6;
      } else if(var0 == 1415) {
         var4.onSkillUpdateTrigger = var9;
         var4.itemUpdateTriggers = var6;
      } else if(var0 == 1416) {
         var4.objectArray14 = var9;
      } else if(var0 == 1417) {
         var4.objectArray19 = var9;
      } else if(var0 == 1418) {
         var4.field2708 = var9;
      } else if(var0 == 1419) {
         var4.field2637 = var9;
      } else if(var0 == 1420) {
         var4.field2718 = var9;
      } else if(var0 == 1421) {
         var4.field2711 = var9;
      } else if(var0 == 1422) {
         var4.field2712 = var9;
      } else if(var0 == 1423) {
         var4.field2654 = var9;
      } else if(var0 == 1424) {
         var4.field2714 = var9;
      } else if(var0 == 1425) {
         var4.field2716 = var9;
      } else if(var0 == 1426) {
         var4.field2693 = var9;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var4.field2715 = var9;
      }

      var4.field2686 = true;
      return 1;
   }
}
