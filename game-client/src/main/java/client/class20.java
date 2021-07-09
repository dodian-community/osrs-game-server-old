package client;

import java.util.Iterator;
import java.util.LinkedList;

public class class20 {
   static int field172;
   static final int field169 = 26;
   String field171;
   int field163 = -1;
   int field170 = -1;
   boolean field173 = false;
   String field161;
   int field164 = -1;
   class226 field165 = null;
   LinkedList field160;
   int field167 = 0;
   int field162 = 0;
   int field166 = Integer.MAX_VALUE;
   int field168 = Integer.MAX_VALUE;

   public void method200(Stream var1, int var2, int var3) {
      this.field170 = var2;
      this.field161 = var1.readString();
      this.field171 = var1.readString();
      this.field165 = new class226(var1.readInt());
      this.field163 = var1.readInt();
      var1.readUByte();
      this.field173 = var1.readUByte() == 1;
      this.field164 = var1.readUByte();
      int var4 = var1.readUByte();
      this.field160 = new LinkedList();

      for(int var5 = 0; var5 < var4; var5++) {
         this.field160.add(this.method201(var1, 2074726298));
      }

      this.method206(1897199586);
   }

   public String method209(int var1) {
      return this.field161;
   }

   public boolean method203(int var1, int var2, int var3) {
      int var4 = var1 / 64;
      int var5 = var2 / 64;
      if(var4 >= this.field166 && var4 <= this.field167) {
         if(var5 >= this.field168 && var5 <= this.field162) {
            Iterator var6 = this.field160.iterator();

            class31 var7;
            do {
               if(!var6.hasNext()) {
                  return false;
               }

               var7 = (class31)var6.next();
            } while(!var7.vmethod637(var1, var2, -658565537));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public int[] method213(int var1, int var2, int var3, byte var4) {
      Iterator var5 = this.field160.iterator();

      class31 var6;
      do {
         if(!var5.hasNext()) {
            return null;
         }

         var6 = (class31)var5.next();
      } while(!var6.vmethod636(var1, var2, var3, 2090621319));

      return var6.vmethod638(var1, var2, var3, (byte)56);
   }

   public int method207(byte var1) {
      return this.field170;
   }

   public int method258(int var1) {
      return this.field166;
   }

   public int method247(int var1) {
      return this.field168;
   }

   public boolean method202(int var1, int var2, int var3, byte var4) {
      Iterator var5 = this.field160.iterator();

      class31 var6;
      do {
         if(!var5.hasNext()) {
            return false;
         }

         var6 = (class31)var5.next();
      } while(!var6.vmethod636(var1, var2, var3, 2108356431));

      return true;
   }

   public class226 method205(int var1, int var2, int var3) {
      Iterator var4 = this.field160.iterator();

      class31 var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (class31)var4.next();
      } while(!var5.vmethod637(var1, var2, -658565537));

      return var5.vmethod659(var1, var2, 2128900046);
   }

   public int method218(int var1) {
      return this.field165.field2567;
   }

   public int method217(int var1) {
      return this.field165.field2564;
   }

   public int method219(byte var1) {
      return this.field165.field2565;
   }

   public int method212(byte var1) {
      return this.field164;
   }

   void method206(int var1) {
      Iterator var2 = this.field160.iterator();

      while(var2.hasNext()) {
         class31 var3 = (class31)var2.next();
         var3.vmethod635(this, (byte)-105);
      }

   }

   class31 method201(Stream var1, int var2) {
      int var3 = var1.readUByte();
      class15 var4 = (class15)class76.method1803(class15.method145(-1961233435), var3, (byte)0);
      Object var5 = null;
      switch(var4.field110) {
      case 0:
         var5 = new class14();
         break;
      case 1:
         var5 = new class37();
         break;
      case 2:
         var5 = new class18();
         break;
      case 3:
         var5 = new class27();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((class31)var5).vmethod639(var1, (byte)-40);
      return (class31)var5;
   }

   public boolean method208(byte var1) {
      return this.field173;
   }

   public int method214(int var1) {
      return this.field167;
   }

   public int method249(int var1) {
      return this.field162;
   }

   int method211(byte var1) {
      return this.field163;
   }

   public String method210(int var1) {
      return this.field171;
   }

   public class226 method256(int var1) {
      return new class226(this.field165);
   }

   public static Icon[] getIcons() {
      return new Icon[]{Icon.NONE, Icon.MODERATOR, Icon.ADMIN, Icon.aIcon_910, Icon.aIcon_912, Icon.DMM_1,
              Icon.DMM_2, Icon.DMM_3, Icon.DMM_4, Icon.DMM_5, Icon.YOUTUBER, Icon.HELPER, Icon.HITBOX,
              Icon.PVP_IRONMAN, Icon.HARDCORE_IRONMAN, Icon.DONATOR_1, Icon.DONATOR_2, Icon.DONATOR_3,
              Icon.DONATOR_4, Icon.DONATOR_5, Icon.DONATOR_6, Icon.DONATOR_7, Icon.SENIOR_MOD};
   }

   static final void method261(class55 var0, boolean var1, int var2) {
      int var3 = var0.field501;
      int var4 = (int)var0.field2421;
      var0.unlink();
      if(var1) {
         class66.method1622(var3, -179570605);
      }

      class130.method3077(var3, (byte)0);
      Widget var5 = Widget.getLoaded(var4);
      if(var5 != null) {
         GameClient.requestRedraw(var5);
      }

      class170.method3448(605801008);
      if(GameClient.field683 != -1) {
         if(var2 <= 1442925840) {
            return;
         }

         int var6 = GameClient.field683;
         if(class261.method4931(var6, (byte)-31)) {
            class83.method1923(Widget.LOADED[var6], 1, -158846915);
         }
      }

   }

   public static long method262(int var0, int var1) {
      return class120.field1647[var0];
   }

   static boolean method260(int var0) {
      return (GameClient.field658 & 4) != 0;
   }
}
