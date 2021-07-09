package client;

public class class248 implements Runnable {
   static class205 field3182 = new class205();
   static class205 field3180 = new class205();
   public static Object field3184 = new Object();
   public static int field3179 = 0;
   static Thread field3183;
   static final int field3181 = 40;

   public void run() {
      try {
         while(true) {
            class205 var2 = field3182;
            class245 var1;
            synchronized(field3182) {
               var1 = (class245)field3182.method4098();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3150 == 0) {
                  var1.field3151.method3371((int)var1.field2421, var1.field3149, var1.field3149.length, -1888723881);
                  var2 = field3182;
                  synchronized(field3182) {
                     var1.unlink();
                  }
               } else if(var1.field3150 == 1) {
                  var1.field3149 = var1.field3151.method3372((int)var1.field2421, 1936326418);
                  var2 = field3182;
                  synchronized(field3182) {
                     field3180.method4073(var1);
                  }
               }

               var14 = field3184;
               synchronized(field3184) {
                  if(field3179 <= 1) {
                     field3179 = 0;
                     field3184.notifyAll();
                     return;
                  }

                  field3179 = 600;
               }
            } else {
               class63.method1539(100L);
               var14 = field3184;
               synchronized(field3184) {
                  if(field3179 <= 1) {
                     field3179 = 0;
                     field3184.notifyAll();
                     return;
                  }

                  --field3179;
               }
            }
         }
      } catch (Exception var13) {
         class5.method65((String)null, var13, (byte)73);
      }
   }
}
