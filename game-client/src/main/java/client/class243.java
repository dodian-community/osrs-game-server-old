package client;

public class class243 {
   public static int field3138;
   static final class243 field3131 = new class243("LIVE", 0);
   static final class243 field3132 = new class243("BUILDLIVE", 3);
   static final class243 field3136 = new class243("RC", 1);
   static final class243 field3134 = new class243("WIP", 2);
   static PaletteSprite[] field3139;
   static int[] field3137;
   public final String field3135;
   final int field3133;

   class243(String var1, int var2) {
      this.field3135 = var1;
      this.field3133 = var2;
   }

   static final void method4612(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6, byte var7) {
      if(!GameClient.field716) {
         if(GameClient.field771 < 500) {
            GameClient.field735[GameClient.field771] = var0;
            GameClient.field740[GameClient.field771] = var1;
            GameClient.field720[GameClient.field771] = var2;
            GameClient.field794[GameClient.field771] = var3;
            GameClient.field718[GameClient.field771] = var4;
            GameClient.field851[GameClient.field771] = var5;
            GameClient.field590[GameClient.field771] = var6;
            ++GameClient.field771;
         }

      }
   }
}
