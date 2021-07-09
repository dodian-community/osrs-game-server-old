package client;

public class class290 extends class285 {
   static int field3636;
   public static final int field3638 = 200;
   static final int field3640 = 400;
   public class208 field3639 = new class208();
   int field3637 = 1;
   final class322 field3635;

   public class290(class322 var1) {
      super(400);
      this.field3635 = var1;
   }

   public void method5424(Stream var1, int var2, int var3) {
      while(true) {
         if(var1.field2339 < var2) {
            boolean var4 = var1.readUByte() == 1;
            class291 var5 = new class291(var1.readString(), this.field3635);
            class291 var6 = new class291(var1.readString(), this.field3635);
            int var7 = var1.readUShort();
            int var8 = var1.readUByte();
            int var9 = var1.readUByte();
            boolean var10000;
            if((var9 & 2) != 0) {
               if(var3 != 1284102001) {
                  return;
               }

               var10000 = true;
            } else {
               var10000 = false;
            }

            boolean var10 = var10000;
            boolean var11 = (var9 & 1) != 0;
            if(var7 > 0) {
               var1.readString();
               var1.readUByte();
               var1.readInt();
            }

            var1.readString();
            if(var5 != null && var5.method5441(-482681863)) {
               class292 var12 = (class292)this.method5331(var5, 571626930);
               if(var4) {
                  class292 var13 = (class292)this.method5331(var6, -461187017);
                  if(var13 != null && var13 != var12) {
                     if(var12 != null) {
                        this.method5334(var13, -653978829);
                     } else {
                        var12 = var13;
                     }
                  }
               }

               if(var12 != null) {
                  this.method5338(var12, var5, var6, (byte)112);
                  if(var7 != var12.field3628) {
                     boolean var15 = true;

                     for(class294 var14 = (class294)this.field3639.method4111(); var14 != null; var14 = (class294)this.field3639.method4114()) {
                        if(var14.field3662.equals(var5)) {
                           if(var7 != 0 && var14.field3664 == 0) {
                              var14.method4121();
                              var15 = false;
                           } else if(var7 == 0) {
                              if(var3 != 1284102001) {
                                 return;
                              }

                              if(var14.field3664 != 0) {
                                 var14.method4121();
                                 var15 = false;
                              }
                           }
                        }
                     }

                     if(var15) {
                        if(var3 != 1284102001) {
                           return;
                        }

                        this.field3639.method4112(new class294(var5, var7));
                     }
                  }
               } else {
                  if(this.method5327(821008449) >= 400) {
                     continue;
                  }

                  if(var3 != 1284102001) {
                     return;
                  }

                  var12 = (class292)this.method5335(var5, var6, 2134912814);
               }

               if(var7 != var12.field3628) {
                  int var10001 = this.field3637 + 1;
                  ++this.field3637;
                  var12.field3627 = var10001 - 1;
                  if(var12.field3628 == -1 && var7 == 0) {
                     var12.field3627 = -(var12.field3627 * -1772374531) * -745943211;
                  }

                  var12.field3628 = var7;
               }

               var12.field3629 = var8;
               var12.field3648 = var10;
               var12.field3650 = var11;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method5337(-1855716237);
         return;
      }
   }

   class282 vmethod5461(int var1) {
      return new class292();
   }

   public boolean method5423(class291 var1, boolean var2, int var3) {
      class292 var4 = (class292)this.method5330(var1, -1029474979);
      return var4 == null ? false : !var2 || var4.field3628 != 0;
   }

   class282[] vmethod5462(int var1, int var2) {
      return new class292[var1];
   }
}
