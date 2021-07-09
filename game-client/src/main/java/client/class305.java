package client;

public final class class305 {
   static int field3729;
   static int[] field3725;
   static final int field3726 = 1;
   static final String field3727 = "main_file_cache.idx255";
   public static final int field3728 = 6;

   static PaletteSprite method5658(int var0) {
      PaletteSprite var1 = new PaletteSprite();
      var1.width = field3729;
      var1.height = class319.field3798;
      var1.offX = class7.field45[0];
      var1.offY = class225.field2562[0];
      var1.width1 = class319.field3800[0];
      var1.height1 = class319.field3799[0];
      var1.palette = class172.field2260;
      var1.pixels = class319.field3801[0];
      class7.field45 = null;
      class225.field2562 = null;
      class319.field3800 = null;
      class319.field3799 = null;
      class172.field2260 = null;
      class319.field3801 = null;
      return var1;
   }

   static int method5659(int var0, class84 var1, boolean var2, int var3) {
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = Widget.getLoaded(class69.field999[--class69.field1003]);
      } else {
         var4 = var2 ? class276.field3561 : class260.field3301;
      }

      if(var0 == 1927) {
         if(class69.field1009 >= 10) {
            throw new RuntimeException();
         } else if(var4.field2715 == null) {
            return 0;
         } else {
            ScriptInvocation var5 = new ScriptInvocation();
            var5.field506 = var4;
            var5.parameters = var4.field2715;
            var5.field514 = class69.field1009 + 1;
            GameClient.field638.method4073(var5);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
