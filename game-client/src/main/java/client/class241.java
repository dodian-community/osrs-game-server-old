package client;

public final class class241 {
   public static final int field3108 = 3;
   public static final int field3109 = 1;
   public static final int field3110 = 4;
   public static final int field3111 = 5;
   public static final int field3112 = 6;
   public static final int field3113 = 8;
   public static final int field3114 = 11;
   public static final int field3115 = 15;
   public static final int field3116 = 19;
   static final int field3117 = 2048;

   public static class264 method4603(int var0, short var1) {
      class264 var2 = (class264)class264.field3328.method3989((long)var0);
      if(var2 != null) {
         return var2;
      } else {
         byte[] var3 = class264.field3327.method4625(11, var0, 640573504);
         var2 = new class264();
         if(var3 != null) {
            var2.method4948(new Stream(var3), (byte)-16);
         }

         var2.method4954((byte)99);
         class264.field3328.method3983(var2, (long)var0);
         return var2;
      }
   }

   static final void method4602(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, byte var9) {
      class62 var10 = null;

      for(class62 var11 = (class62) GameClient.field714.method4098(); var11 != null; var11 = (class62) GameClient.field714.method4079()) {
         if(var0 == var11.field861 && var11.field857 == var1 && var2 == var11.field858 && var3 == var11.field856) {
            if(var9 >= 3) {
               return;
            }

            var10 = var11;
            break;
         }
      }

      if(var10 == null) {
         var10 = new class62();
         var10.field861 = var0;
         var10.field856 = var3;
         var10.field857 = var1;
         var10.field858 = var2;
         class74.method1800(var10, (byte)40);
         GameClient.field714.method4073(var10);
      }

      var10.field862 = var4;
      var10.field864 = var5;
      var10.field863 = var6;
      var10.field855 = var7;
      var10.field860 = var8;
   }
}
