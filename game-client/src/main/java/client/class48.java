package client;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class class48 implements MouseListener, MouseMotionListener, FocusListener {
   public static class48 field429 = new class48();
   public static volatile int field424 = 0;
   static volatile int field417 = 0;
   public static volatile int field422 = -1;
   public static volatile int field420 = 0;
   public static int field431 = 0;
   public static volatile int field423 = -1;
   public static int field425 = 0;
   public static volatile int field434 = 0;
   static int field435;
   public static int field426 = 0;
   public static int field419 = 0;
   public static int field432 = 0;
   public static int field428 = 0;
   public static volatile int field421 = 0;
   public static volatile long field430 = 0L;
   public static long field433 = 0L;
   static final int field418 = 2;
   static final int field427 = 1;
   static final int field436 = 25;

   final int method916(MouseEvent var1, int var2) {
      int var3 = var1.getButton();
      return !var1.isAltDown() && var3 != 2 ? (!var1.isMetaDown() && var3 != 3 ? 1 : 2) : 4;
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(field429 != null) {
         field417 = 0;
         field420 = var1.getX();
         field434 = var1.getY();
         field430 = Stream.method3547(604838575);
         field421 = this.method916(var1, -1838071369);
         if(field421 != 0) {
            field424 = field421;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(field429 != null) {
         field417 = 0;
         field424 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(field429 != null) {
         field417 = 0;
         field422 = var1.getX();
         field423 = var1.getY();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(field429 != null) {
         field417 = 0;
         field422 = var1.getX();
         field423 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(field429 != null) {
         field417 = 0;
         field422 = var1.getX();
         field423 = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(field429 != null) {
         field424 = 0;
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(field429 != null) {
         field417 = 0;
         field422 = -1;
         field423 = -1;
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   static void method947(int var0, int var1) {
      if(var0 != GameClient.field589) {
         if(GameClient.field589 == 0) {
            Stream.client.method842((byte)-82);
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            GameClient.field615 = 0;
            GameClient.field616 = 0;
            GameClient.field617 = 0;
            GameClient.field804.method5246(var0, -2082197473);
            if(var0 != 20) {
               class87.method2005(false, 515441646);
            }
         }

         if(var0 != 20 && var0 != 40 && class62.field869 != null) {
            class62.field869.vmethod3346(1775992211);
            class62.field869 = null;
         }

         if(GameClient.field589 == 25) {
            GameClient.field751 = 0;
            GameClient.field633 = 0;
            GameClient.field634 = 1;
            GameClient.field635 = 0;
            GameClient.field636 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class87.method1994(class22.field183, class175.field2270, true, GameClient.field589 == 11 ? 4 : 0, 1008052413);
            } else if(var0 == 11) {
               class87.method1994(class22.field183, class175.field2270, false, 4, 1386028858);
            } else {
               class59.method1079(46558014);
            }
         } else {
            class87.method1994(class22.field183, class175.field2270, true, 0, 1336777365);
         }

         GameClient.field589 = var0;
      }
   }

   static final void method948(int var0, int var1, int var2, int var3, int var4) {
      for(int var5 = 0; var5 < GameClient.field603; var5++) {
         if(GameClient.field786[var5] + GameClient.field641[var5] > var0 && GameClient.field786[var5] < var0 + var2 && GameClient.field787[var5] + GameClient.field789[var5] > var1) {
            if(var4 <= -2074675394) {
               return;
            }

            if(GameClient.field787[var5] < var3 + var1) {
               if(var4 <= -2074675394) {
                  return;
               }

               GameClient.staticBoolArray6[var5] = true;
            }
         }
      }

   }

   static boolean method943(byte var0) {
      return (GameClient.field658 & 2) != 0;
   }
}
