package client;

public class class53 extends class204 {
   static class202 field474 = new class202(32);
   static class321 field476;
   static PaletteSprite field472;
   static final int field475 = 39;
   int[] field477 = new int[]{-1};
   int[] field473 = new int[]{0};

   static final void method1012(int var0) {
      for(int var1 = 0; var1 < class81.field1167; var1++) {
         Player var2 = GameClient.field610[class81.field1159[var1]];
         var2.method1084(-540228134);
      }

      class37.method640((byte)-81);
      if(class14.field94 != null) {
         class14.field94.method5467((byte)-54);
      }

   }

   static class249 method1009(int var0, boolean var1, boolean var2, boolean var3, byte var4) {
      class162 var5 = null;
      if(class155.field1969 != null) {
         var5 = new class162(var0, class155.field1969, class76.field1068[var0], 1000000);
      }

      return new class249(var5, class34.field302, var0, var1, var2, var3);
   }
}
