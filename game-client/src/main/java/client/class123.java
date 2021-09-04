package client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class class123 {
   static int field1702;
   static final int field1697 = 512;
   static final int field1701 = 21;
   boolean field1699 = true;
   int field1703;
   int field1695;
   int field1700;
   int field1696;
   int field1694;
   int field1698;

   class123(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1703 = var1;
      this.field1695 = var2;
      this.field1696 = var3;
      this.field1694 = var4;
      this.field1698 = var5;
      this.field1700 = var6;
      this.field1699 = var7;
   }

   public static void method2869(PacketBuffer var0, byte var1) {
      class312 var2 = (class312)class313.field3759.method4048();
      if(var2 != null) {
         int var3 = var0.field2339;
         var0.writeInt(var2.field3758);

         for(int var4 = 0; var4 < var2.field3749; var4++) {
            if(var2.field3751[var4] != 0) {
               var0.writeByte(var2.field3751[var4]);
            } else {
               try {
                  int var5 = var2.field3748[var4];
                  Field var6;
                  int var7;
                  if(var5 == 0) {
                     var6 = var2.field3752[var4];
                     var7 = var6.getInt((Object)null);
                     var0.writeByte(0);
                     var0.writeInt(var7);
                  } else if(var5 == 1) {
                     var6 = var2.field3752[var4];
                     var6.setInt((Object)null, var2.field3753[var4]);
                     var0.writeByte(0);
                  } else if(var5 == 2) {
                     var6 = var2.field3752[var4];
                     var7 = var6.getModifiers();
                     var0.writeByte(0);
                     var0.writeInt(var7);
                  }

                  Method var26;
                  if(var5 != 3) {
                     if(var5 == 4) {
                        if(var1 != 2) {
                           return;
                        }

                        var26 = var2.field3754[var4];
                        var7 = var26.getModifiers();
                        var0.writeByte(0);
                        var0.writeInt(var7);
                     }
                  } else {
                     var26 = var2.field3754[var4];
                     byte[][] var11 = var2.field3755[var4];
                     Object[] var8 = new Object[var11.length];

                     for(int var9 = 0; var9 < var11.length; var9++) {
                        if(var1 != 2) {
                           return;
                        }

                        ObjectInputStream var10 = new ObjectInputStream(new ByteArrayInputStream(var11[var9]));
                        var8[var9] = var10.readObject();
                     }

                     Object var12 = var26.invoke((Object)null, var8);
                     if(var12 == null) {
                        var0.writeByte(0);
                     } else if(var12 instanceof Number) {
                        var0.writeByte(1);
                        var0.method3659(((Number)var12).longValue());
                     } else if(var12 instanceof String) {
                        var0.writeByte(2);
                        var0.writeString((String)var12, 584189422);
                     } else {
                        var0.writeByte(4);
                     }
                  }
               } catch (ClassNotFoundException var14) {
                  var0.writeByte(-10);
               } catch (InvalidClassException var15) {
                  var0.writeByte(-11);
               } catch (StreamCorruptedException var16) {
                  var0.writeByte(-12);
               } catch (OptionalDataException var17) {
                  var0.writeByte(-13);
               } catch (IllegalAccessException var18) {
                  var0.writeByte(-14);
               } catch (IllegalArgumentException var19) {
                  var0.writeByte(-15);
               } catch (InvocationTargetException var20) {
                  var0.writeByte(-16);
               } catch (SecurityException var21) {
                  var0.writeByte(-17);
               } catch (IOException var22) {
                  var0.writeByte(-18);
               } catch (NullPointerException var23) {
                  var0.writeByte(-19);
               } catch (Exception var24) {
                  var0.writeByte(-20);
               } catch (Throwable var25) {
                  var0.writeByte(-21);
               }
            }
         }

         var0.method3572(var3, (byte)1);
         var2.unlink();
      }
   }

   static final int method2870(int var0, int var1, int var2, int var3, int var4) {
      int var5 = 65536 - class122.field1693[var2 * 1024 / var3] >> 1;
      return ((65536 - var5) * var0 >> 16) + (var5 * var1 >> 16);
   }
}
