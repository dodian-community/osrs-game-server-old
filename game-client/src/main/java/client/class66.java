package client;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class class66 {
   static int field964 = 6;
   static int field966;
   static final int field956 = 10;
   static final int field961 = 1007;
   static final int field965 = 4;
   static final int field967 = 2;
   static final int field968 = 54;
   public static final int field969 = 56;
   int field957 = 1;
   String field959 = null;
   boolean field960;
   boolean field962 = false;
   LinkedHashMap field963 = new LinkedHashMap();
   boolean field958;

   class66() {
      this.method1613(true, 1739738727);
   }

   class66(Stream var1) {
      if(var1 != null && var1.field2338 != null) {
         int var2 = var1.readUByte();
         if(var2 >= 0 && var2 <= field964) {
            if(var1.readUByte() == 1) {
               this.field960 = true;
            }

            if(var2 > 1) {
               this.field958 = var1.readUByte() == 1;
            }

            if(var2 > 3) {
               this.field957 = var1.readUByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUByte();

               for(int var4 = 0; var4 < var3; var4++) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.field963.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.field959 = var1.method3752((byte)-38);
            }

            if(var2 > 5) {
               this.field962 = var1.readBoolean();
            }
         } else {
            this.method1613(true, -519437393);
         }
      } else {
         this.method1613(true, 1967681561);
      }

   }

   void method1613(boolean var1, int var2) {
   }

   Stream method1609(int var1) {
      Stream var2 = new Stream(100);
      var2.writeByte(field964);
      var2.writeByte(this.field960 ? 1 : 0);
      var2.writeByte(this.field958 ? 1 : 0);
      var2.writeByte(this.field957);
      var2.writeByte(this.field963.size());
      Iterator var3 = this.field963.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         var2.writeInt(((Integer)var4.getKey()).intValue());
         var2.writeInt(((Integer)var4.getValue()).intValue());
      }

      var2.writeString(this.field959 != null ? this.field959 : "", -1052096417);
      var2.method3766(this.field962, 873639132);
      return var2;
   }

   public static void method1622(int var0, int var1) {
      if(var0 != -1) {
         if(class175.field2271[var0]) {
            Widget.staticJs5Index11.method4639(var0, (byte)38);
            if(Widget.LOADED[var0] != null) {
               boolean var2 = true;

               for(int var3 = 0; var3 < Widget.LOADED[var0].length; var3++) {
                  if(Widget.LOADED[var0][var3] != null) {
                     if(Widget.LOADED[var0][var3].widgetType != 2) {
                        if(var1 != -179570605) {
                           return;
                        }

                        Widget.LOADED[var0][var3] = null;
                     } else {
                        var2 = false;
                     }
                  }
               }

               if(var2) {
                  Widget.LOADED[var0] = null;
               }

               class175.field2271[var0] = false;
            }
         }
      }
   }

   static int method1621(int var0, int var1) {
      class58 var2 = (class58)class83.field1181.method3945((long)var0);
      return var2 == null ? -1 : (var2.field2426 == class83.field1184.field2445 ? -1 : ((class58)var2.field2426).field540);
   }
}
