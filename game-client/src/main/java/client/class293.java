package client;

public class class293 extends class285 {
   static class298 field3660;
   static final int field3653 = 100;
   static final int field3659 = 1;
   static final int field3661 = 26;
   final class288 field3652;
   public String field3654 = null;
   final class322 field3656;
   public String field3655 = null;
   int field3658 = 1;
   public int field3657;
   public byte field3651;

   public class293(class322 var1, class288 var2) {
      super(100);
      this.field3656 = var1;
      this.field3652 = var2;
   }

   final void method5464(String var1, int var2) {
      long var6 = 0L;
      int var8 = var1.length();

      for(int var9 = 0; var9 < var8; var9++) {
         var6 *= 37L;
         char var10 = var1.charAt(var9);
         if(var10 >= 65 && var10 <= 90) {
            var6 += (long)(var10 + 1 - 65);
         } else if(var10 >= 97 && var10 <= 122) {
            var6 += (long)(var10 + 1 - 97);
         } else if(var10 >= 48) {
            if(var2 >= -466849375) {
               return;
            }

            if(var10 <= 57) {
               var6 += (long)(var10 + 27 - 48);
            }
         }

         if(var6 >= 177917621779460413L) {
            if(var2 >= -466849375) {
               return;
            }
            break;
         }
      }

      while(var6 % 37L == 0L && var6 != 0L) {
         var6 /= 37L;
      }

      String var11 = class172.method3457(var6);
      if(var11 == null) {
         var11 = "";
      }

      this.field3655 = var11;
   }

   class282 vmethod5461(int var1) {
      return new class281();
   }

   class282[] vmethod5462(int var1, int var2) {
      return new class281[var1];
   }

   final void method5477(String var1, int var2) {
      long var6 = 0L;
      int var8 = var1.length();

      for(int var9 = 0; var9 < var8; var9++) {
         var6 *= 37L;
         char var10 = var1.charAt(var9);
         if(var10 >= 65 && var10 <= 90) {
            var6 += (long)(var10 + 1 - 65);
         } else if(var10 >= 97 && var10 <= 122) {
            var6 += (long)(var10 + 1 - 97);
         } else if(var10 >= 48 && var10 <= 57) {
            var6 += (long)(var10 + 27 - 48);
         }

         if(var6 >= 177917621779460413L) {
            if(var2 <= 154103350) {
               return;
            }
            break;
         }
      }

      while(var6 % 37L == 0L && var6 != 0L) {
         var6 /= 37L;
      }

      String var11 = class172.method3457(var6);
      if(var11 == null) {
         var11 = "";
      }

      this.field3654 = var11;
   }

   public final void method5467(byte var1) {
      for(int var2 = 0; var2 < this.method5327(821008449); var2++) {
         ((class281)this.method5336(var2, (byte)36)).method5272(-255402165);
      }

   }

   public final void method5468(int var1) {
      for(int var2 = 0; var2 < this.method5327(821008449); var2++) {
         ((class281)this.method5336(var2, (byte)99)).method5273((byte)-47);
      }

   }

   final void method5482(class281 var1, int var2) {
      if(var1.method5287(1472147048).equals(this.field3652.vmethod5420(-1900287408))) {
         if(var2 >= -1243451969) {
            return;
         }

         this.field3657 = var1.field3629;
      }

   }

   public final void method5489(Stream var1, int var2) {
      class291 var3 = new class291(var1.readString(), this.field3656);
      int var4 = var1.readUShort();
      byte var5 = var1.readByte();
      boolean var6 = false;
      if(var5 == -128) {
         if(var2 != 345415230) {
            return;
         }

         var6 = true;
      }

      class281 var7;
      if(var6) {
         if(this.method5327(821008449) == 0) {
            return;
         }

         var7 = (class281)this.method5331(var3, 1189272141);
         if(var7 != null && var7.method5414(1524390251) == var4) {
            this.method5334(var7, -570676385);
         }
      } else {
         var1.readString();
         var7 = (class281)this.method5331(var3, -520899073);
         if(var7 == null) {
            if(this.method5327(821008449) > super.field3620) {
               return;
            }

            var7 = (class281)this.method5377(var3, 261191446);
         }

         int var10002 = this.field3658 + 1;
         ++this.field3658;
         var7.method5412(var4, var10002 - 1, -414916451);
         var7.field3629 = var5;
         this.method5482(var7, -1325604678);
      }

   }

   public final void method5463(Stream var1, int var2) {
      this.method5464(var1.readString(), -1517543240);
      long var3 = var1.readLong();
      long var6 = var3;
      String var5;
      int var8;
      if(var3 > 0L && var3 < 6582952005840035281L) {
         if(var3 % 37L == 0L) {
            var5 = null;
         } else {
            var8 = 0;

            for(long var9 = var3; var9 != 0L; var9 /= 37L) {
               ++var8;
            }

            StringBuilder var11 = new StringBuilder(var8);

            while(var6 != 0L) {
               long var12 = var6;
               var6 /= 37L;
               var11.append(class303.field3720[(int)(var12 - var6 * 37L)]);
            }

            var5 = var11.reverse().toString();
         }
      } else {
         var5 = null;
      }

      this.method5477(var5, 191342442);
      this.field3651 = var1.readByte();
      var8 = var1.readUByte();
      if(var8 != 255) {
         this.method5326(1666752471);

         for(int var14 = 0; var14 < var8; var14++) {
            if(var2 == 1316455249) {
               return;
            }

            class281 var10 = (class281)this.method5377(new class291(var1.readString(), this.field3656), 616084139);
            int var15 = var1.readUShort();
            int var10002 = this.field3658 + 1;
            ++this.field3658;
            var10.method5412(var15, var10002 - 1, 1006271527);
            var10.field3629 = var1.readByte();
            var1.readString();
            this.method5482(var10, -1531471767);
         }

      }
   }

   public static boolean method5496(char var0, byte var1) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var2 = class301.field3714;

            for(int var3 = 0; var3 < var2.length; var3++) {
               char var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
