package client;

public class ScriptInvocation extends class204 {
   static final int field510 = 8;
   static final int field516 = 104;
   static final int field518 = 8;
   static final int field519 = 19136800;
   static final int field520 = 50;
   public static final int field521 = 8;
   int field515 = 76;
   Object[] parameters;
   Widget field506;
   int field511;
   int field508;
   Widget field507;
   int field514;
   String field504;
   int field517;
   int field509;
   boolean field505;
   int field513;

   public void method1024(Object[] var1, byte var2) {
      this.parameters = var1;
   }

   public void method1025(int var1, int var2) {
      this.field515 = var1;
   }

   static void method1030(boolean var0, int var1) {
      class78.field1103 = "";
      class78.field1112 = "Enter your username/email & password.";
      class78.field1105 = "";
      class78.field1081 = 2;
      if(var0) {
         class78.field1086 = "";
      }

      if(class78.typedUsername == null || class78.typedUsername.length() <= 0) {
         if(class10.field61.field959 != null) {
            class78.typedUsername = class10.field61.field959;
            class78.field1108 = true;
         } else {
            class78.field1108 = false;
         }
      }

      if ((class78.typedUsername == null || class78.typedUsername.isEmpty()) && (Custom.rememberedUsername != null && !Custom.rememberedUsername.isEmpty())) {
         class78.typedUsername = Custom.rememberedUsername;
      }

      class34.method586(1079339167);
   }

   static final void method1031(String cmd, byte var1) {
      if(cmd.equalsIgnoreCase("toggleroof")) {
         class10.field61.field960 = !class10.field61.field960;
         class54.method1018(-1243055213);
         if(class10.field61.field960) {
            class143.method3172(99, "", "Roofs are now all hidden");
         } else {
            class143.method3172(99, "", "Roofs will only be removed selectively");
         }
      }

      if (cmd.startsWith("drag")) {
         String[] split = cmd.split(" ");
         int x = -1;

         try {
            x = Integer.parseInt(split[1]);
         } catch (Exception e) {
         }

         if (x < 0 || x > 50) {
            class143.method3172(99, "", "You need to specify the of pixels to drag, between 1 and 50.");
            class143.method3172(99, "", "Example being ::drag 5 (gives the OSRS drag distance).");
         } else {
            Custom.DRAG_THRESHOLD = x;
            Custom.writeDrag();
            class143.method3172(99, "", "Item dragging threshold set to " + x + ".");
         }
         return;
      }
      if (cmd.startsWith("currentdrag") || cmd.startsWith("mydrag")) {
         class143.method3172(99, "", "Your drag value is currently set to " + Custom.DRAG_THRESHOLD + ".");
         return;
      }

      if(cmd.equalsIgnoreCase("displayfps")) {
         boolean var10000;
         if(!GameClient.field597) {
            if(var1 == 8) {
               return;
            }

            var10000 = true;
         } else {
            var10000 = false;
         }

         GameClient.field597 = var10000;
      }

      if(cmd.equalsIgnoreCase("renderself")) {
         GameClient.field699 = !GameClient.field699;
      }

      if(cmd.equalsIgnoreCase("mouseovertext")) {
         if(var1 == 8) {
            return;
         }

         GameClient.field728 = !GameClient.field728;
      }

      if(GameClient.field747 >= 2) {
         if(var1 == 8) {
            return;
         }

         if(cmd.equalsIgnoreCase("showcoord")) {
            class53.field476.field3839 = !class53.field476.field3839;
         }

         if(cmd.equalsIgnoreCase("fpson")) {
            GameClient.field597 = true;
         }

         if(cmd.equalsIgnoreCase("fpsoff")) {
            GameClient.field597 = false;
         }

         if(cmd.equalsIgnoreCase("gc")) {
            if(var1 == 8) {
               return;
            }

            System.gc();
         }

         if(cmd.equalsIgnoreCase("clientdrop")) {
            class30.method516(-330580575);
         }
      }

      class172 var2 = class26.method433(OutgoingPacket.field2187, GameClient.field626.field1218, 1535459233);
      var2.field2257.writeByte(cmd.length() + 1);
      var2.field2257.writeString(cmd, 1527366920);
      GameClient.field626.method1980(var2);
   }

   static final void method1027(Widget var0, ItemDef var1, int var2, int var3, boolean var4, int var5) {
      String[] var6 = var1.interfaceOptions;
      byte var7 = -1;
      String var8 = null;
      if(var6 != null && var6[var3] != null) {
         if(var3 == 0) {
            var7 = 33;
         } else if(var3 == 1) {
            var7 = 34;
         } else if(var3 == 2) {
            var7 = 35;
         } else if(var3 == 3) {
            var7 = 36;
         } else {
            var7 = 37;
         }

         var8 = var6[var3];
      } else if(var3 == 4) {
         var7 = 37;
         var8 = "Drop";
      }

      if(var7 != -1 && var8 != null) {
         class243.method4612(var8, class6.method71(16748608) + var1.name, var7, var1.field3431, var2, var0.interfaceHash, var4, (byte)0);
      }

   }
}
