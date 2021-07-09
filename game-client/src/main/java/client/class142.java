package client;

public class class142 extends class283 {
   public static final int field1889 = 12;
   static final int field1891 = 7;
   final boolean field1890;

   public class142(boolean var1) {
      this.field1890 = var1;
   }

   int method3164(class287 var1, class287 var2, int var3) {
      if(var1.field3628 != 0) {
         if(var2.field3628 == 0) {
            return this.field1890 ? -1 : 1;
         }
      } else if(var2.field3628 != 0) {
         return this.field1890 ? 1 : -1;
      }

      return this.method5308(var1, var2, -366074461);
   }

   public int compare(Object var1, Object var2) {
      return this.method3164((class287)var1, (class287)var2, -879071974);
   }

   static String method3161(String var0, boolean var1, byte var2) {
      String var3 = var1 ? "https://" : "http://";
      if(GameClient.field777 == 1) {
         var0 = var0 + "-wtrc";
      } else if(GameClient.field777 == 2) {
         var0 = var0 + "-wtqa";
      } else if(GameClient.field777 == 3) {
         var0 = var0 + "-wtwip";
      } else if(GameClient.field777 == 5) {
         var0 = var0 + "-wti";
      } else if(GameClient.field777 == 4) {
         var0 = "local";
      }

      String var4 = "";
      if(class163.field2013 != null) {
         var4 = "/p=" + class163.field2013;
      }

      String var5 = "runescape.com";
      return var3 + var0 + "." + var5 + "/l=" + GameClient.field827 + "/a=" + class124.field1709 + var4 + "/";
   }
}
