package client;

public class class261 extends class206 {
   public static class200 field3305 = new class200(64);
   public static class200 field3306 = new class200(64);
   public static class247 field3304;
   static class247 field3314;
   static final int field3303 = 30;
   static final int field3309 = 70;
   int field3315 = -1;
   int field3316 = -1;
   public int field3310 = 255;
   public int field3312 = -1;
   public int field3307 = 255;
   public int field3313 = 70;
   public int field3308 = 1;
   public int field3317;
   public int field3311 = 30;
   public int field3318 = 0;

   void method4916(Stream var1, int var2, int var3) {
      if(var2 == 1) {
         var1.readUShort();
      } else if(var2 == 2) {
         this.field3310 = var1.readUByte();
      } else if(var2 == 3) {
         this.field3307 = var1.readUByte();
      } else if(var2 == 4) {
         this.field3312 = 0;
      } else if(var2 == 5) {
         this.field3313 = var1.readUShort();
      } else if(var2 == 6) {
         var1.readUByte();
      } else if(var2 == 7) {
         if(var3 >= -1705647021) {
            return;
         }

         this.field3315 = var1.method3546();
      } else if(var2 == 8) {
         this.field3316 = var1.method3546();
      } else if(var2 == 11) {
         if(var3 >= -1705647021) {
            return;
         }

         this.field3312 = var1.readUShort();
      } else if(var2 == 14) {
         this.field3311 = var1.readUByte();
      } else if(var2 == 15) {
         this.field3318 = var1.readUByte();
      }

   }

   public void method4915(Stream var1, int var2) {
      while(true) {
         int var3 = var1.readUByte();
         if(var3 == 0) {
            return;
         }

         this.method4916(var1, var3, -2130142641);
      }
   }

   public Sprite method4918(int var1) {
      if(this.field3316 < 0) {
         return null;
      } else {
         Sprite var2 = (Sprite)field3306.method3989((long)this.field3316);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class229.method4499(field3314, this.field3316, 0, -287038584);
            if(var2 != null) {
               field3306.method3983(var2, (long)this.field3316);
            }

            return var2;
         }
      }
   }

   public Sprite method4917(int var1) {
      if(this.field3315 < 0) {
         return null;
      } else {
         Sprite var2 = (Sprite)field3306.method3989((long)this.field3315);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class229.method4499(field3314, this.field3315, 0, -1756693683);
            if(var2 != null) {
               field3306.method3983(var2, (long)this.field3315);
            }

            return var2;
         }
      }
   }

   public static boolean method4931(int parentId, byte var1) {
      if(class175.field2271[parentId]) {
         return true;
      } else if(!Widget.staticJs5Index11.method4707(parentId, (byte)-35)) {
         return false;
      } else {
         int var2 = Widget.staticJs5Index11.getFileCount(parentId);
         if(var2 == 0) {
            class175.field2271[parentId] = true;
            return true;
         } else {
            if(Widget.LOADED[parentId] == null) {
               Widget.LOADED[parentId] = new Widget[var2];
            }

            for(int childId = 0; childId < var2; childId++) {
               if(Widget.LOADED[parentId][childId] == null) {
                  byte[] var4 = Widget.staticJs5Index11.method4625(parentId, childId, 2003147432);
                  if(var4 != null) {
                     Widget.LOADED[parentId][childId] = new Widget();
                     Widget.LOADED[parentId][childId].interfaceHash = childId + (parentId << 16);
                     if(var4[0] == -1) {
                        Widget.LOADED[parentId][childId].unpackNew(new Stream(var4));
                     } else {
                        Widget.LOADED[parentId][childId].method4549(new Stream(var4), -2129366715);
                     }
                     InterfaceEdits.childLoaded(Widget.LOADED[parentId][childId]);
                  }
               }
            }

            if (parentId == 596) {
               Widget[] inter = Widget.LOADED[parentId];

               for (int i =0 ; i < inter.length;i++) {
                  if (i == 4) {
                     continue;
                  }
                  inter[i].alpha = 100;
               }

               inter[4].fontHorizontalAlignment = 1;
               inter[1].width = 200;
               inter[2].width = 200;
               inter[4].fontId = 495;
               inter[8].fontId = 495;
            }

            class175.field2271[parentId] = true;
            return true;
         }
      }
   }
}
