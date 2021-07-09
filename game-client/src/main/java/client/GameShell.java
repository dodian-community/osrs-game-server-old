package client;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Iterator;

public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
   static volatile boolean field390 = true;
   static GameShell INSTANCE = null;
   static boolean field389 = false;
   static int field387 = 0;
   static long field388 = 0L;
   static int field391 = 20;
   protected static long[] field404 = new long[32];
   static int field385 = 1;
   protected static class154 field392;
   protected static long[] field394 = new long[32];
   protected static int field393 = 0;
   static int field413 = 500;
   static long field415 = -1L;
   static long field416 = -1L;
   Clipboard field412;
   final EventQueue field399;
   boolean field408 = false;
   int field400;
   class38 field407;
   boolean field401 = false;
   int field398 = 0;
   Frame field403;
   Canvas canvas;
   int field411 = 0;
   int field414;
   protected int field396;
   volatile boolean field406 = true;
   int field395;
   protected int field397;
   int field402;
   volatile long field410 = 0L;
   volatile boolean field409 = false;

   protected GameShell() {
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field399 = var1;
      class40 var2 = new class40();
      class95.field1297 = var2;
   }

   protected final boolean method774(int var1) {
      return true;
   }

   public final void destroy() {
      if(this == INSTANCE && !field389) {
         field388 = Stream.method3547(604838575);
         class63.method1539(5000L);
         this.method785(-199508735);
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == INSTANCE && !field389) {
         this.field406 = true;
         if(Stream.method3547(604838575) - this.field410 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class82.field1179 && var2.height >= class243.field3138) {
               this.field409 = true;
            }
         }

      }
   }

   class310 method800(byte var1) {
      Container var2 = this.method799(-1784994762);
      int var3 = Math.max(var2.getWidth(), this.field395);
      int var4 = Math.max(var2.getHeight(), this.field402);
      if(this.field403 != null) {
         Insets var5 = this.field403.getInsets();
         var3 -= var5.left + var5.right;
         var4 -= var5.top + var5.bottom;
      }

      return new class310(var3, var4);
   }

   Container method799(int var1) {
      return this.field403 != null ? this.field403 : this;
   }

   protected void method788(String var1, int var2) {
      if(!this.field401) {
         this.field401 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var4) {
            ;
         }

      }
   }

   final void method784(byte var1) {
      this.field408 = true;
   }

   final synchronized void method779(int var1) {
      Container var2 = this.method799(-1235194173);
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var2.remove(this.canvas);
      }

      class82.field1179 = Math.max(var2.getWidth(), this.field395);
      class243.field3138 = Math.max(var2.getHeight(), this.field402);
      Insets var3;
      if(this.field403 != null) {
         var3 = this.field403.getInsets();
         class82.field1179 -= var3.right + var3.left;
         class243.field3138 -= var3.bottom + var3.top;
      }

      this.canvas = new GameCanvas(this);
      var2.add(this.canvas);
      this.canvas.setSize(class82.field1179, class243.field3138);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var2 == this.field403) {
         var3 = this.field403.getInsets();
         this.canvas.setLocation(var3.left + this.field398, var3.top + this.field411);
      } else {
         this.canvas.setLocation(this.field398, this.field411);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field406 = true;
      if(class163.field2014 != null && class82.field1179 == class163.field2014.field3767 && class243.field3138 == class163.field2014.field3769) {
         if(var1 >= -1479626977) {
            return;
         }

         ((class46)class163.field2014).method751(this.canvas, (byte)-102);
         class163.field2014.vmethod5809(0, 0, -1986786716);
      } else {
         class163.field2014 = new class46(class82.field1179, class243.field3138, this.canvas);
      }

      this.field409 = false;
      this.field410 = Stream.method3547(604838575);
   }

   final synchronized void method785(int var1) {
      if(!field389) {
         field389 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var6) {
            ;
         }

         try {
            this.vmethod1187(-2060326728);
         } catch (Exception var5) {
            ;
         }

         if(this.field403 != null) {
            try {
               System.exit(0);
            } catch (Throwable var4) {
               ;
            }
         }

         if(field392 != null) {
            if(var1 != -199508735) {
               return;
            }

            try {
               field392.method3256(417031791);
            } catch (Exception var3) {
               ;
            }
         }

         this.vmethod1132(-1676093665);
      }
   }

   protected abstract void vmethod1187(int var1);

   final void method854(int var1) {
      Container var2 = this.method799(-1264075102);
      if(var2 != null) {
         class310 var3 = this.method800((byte)20);
         this.field396 = Math.max(var3.field3747, this.field395);
         this.field397 = Math.max(var3.field3745, this.field402);
         if(this.field396 <= 0) {
            this.field396 = 1;
         }

         if(this.field397 <= 0) {
            this.field397 = 1;
         }

         class82.field1179 = Math.min(this.field396, this.field400);
         class243.field3138 = Math.min(this.field397, this.field414);
         this.field398 = (this.field396 - class82.field1179) / 2;
         this.field411 = 0;
         this.canvas.setSize(class82.field1179, class243.field3138);
         class163.field2014 = new class46(class82.field1179, class243.field3138, this.canvas);
         if(var2 == this.field403) {
            Insets var4 = this.field403.getInsets();
            this.canvas.setLocation(this.field398 + var4.left, var4.top + this.field411);
         } else {
            this.canvas.setLocation(this.field398, this.field411);
         }

         this.field406 = true;
         this.vmethod1144(-2141234055);
      }
   }

   protected abstract void vmethod1505(int var1);

   protected abstract void vmethod1132(int var1);

   protected final void method842(byte var1) {
      class71.field1028 = null;
      class154.field1961 = null;
      class29.field256 = null;
   }

   void method782(int var1) {
      Container var2 = this.method799(-1275598291);
      long var3 = Stream.method3547(604838575);
      long var5 = field394[class257.field3259];
      field394[class257.field3259] = var3;
      class257.field3259 = class257.field3259 + 1 & 31;
      if(var5 != 0L && var3 > var5) {
         int var7 = (int)(var3 - var5);
         field393 = ((var7 >> 1) + 32000) / var7;
      }

      if(++field413 - 1 > 50) {
         field413 -= 50;
         this.field406 = true;
         this.canvas.setSize(class82.field1179, class243.field3138);
         this.canvas.setVisible(true);
         if(var2 == this.field403) {
            Insets var8 = this.field403.getInsets();
            this.canvas.setLocation(this.field398 + var8.left, this.field411 + var8.top);
         } else {
            this.canvas.setLocation(this.field398, this.field411);
         }
      }

      if(this.field409) {
         this.method777((byte)1);
      }

      this.method783(-460416978);
      this.vmethod1137(this.field406, (byte)0);
      if(this.field406) {
         this.method776(-1970135042);
      }

      this.field406 = false;
   }

   protected abstract void vmethod1136(int var1);

   protected final void method796(int var1, String var2, boolean var3, int var4) {
      try {
         Graphics var5 = this.canvas.getGraphics();
         if(class154.field1961 == null) {
            class154.field1961 = new Font("Helvetica", 1, 13);
            class29.field256 = this.canvas.getFontMetrics(class154.field1961);
         }

         if(var3) {
            if(var4 != 490645637) {
               return;
            }

            var5.setColor(Color.black);
            var5.fillRect(0, 0, class82.field1179, class243.field3138);
         }

         Color var6 = new Color(140, 17, 17);

         try {
            if(class71.field1028 == null) {
               class71.field1028 = this.canvas.createImage(304, 34);
            }

            Graphics var7 = class71.field1028.getGraphics();
            var7.setColor(var6);
            var7.drawRect(0, 0, 303, 33);
            var7.fillRect(2, 2, var1 * 3, 30);
            var7.setColor(Color.black);
            var7.drawRect(1, 1, 301, 31);
            var7.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var7.setFont(class154.field1961);
            var7.setColor(Color.white);
            var7.drawString(var2, (304 - class29.field256.stringWidth(var2)) / 2, 22);
            var5.drawImage(class71.field1028, class82.field1179 / 2 - 152, class243.field3138 / 2 - 18, (ImageObserver)null);
         } catch (Exception var10) {
            int var8 = class82.field1179 / 2 - 152;
            int var9 = class243.field3138 / 2 - 18;
            var5.setColor(var6);
            var5.drawRect(var8, var9, 303, 33);
            var5.fillRect(var8 + 2, var9 + 2, var1 * 3, 30);
            var5.setColor(Color.black);
            var5.drawRect(var8 + 1, var9 + 1, 301, 31);
            var5.fillRect(var8 + var1 * 3 + 2, var9 + 2, 300 - var1 * 3, 30);
            var5.setFont(class154.field1961);
            var5.setColor(Color.white);
            var5.drawString(var2, var8 + (304 - class29.field256.stringWidth(var2)) / 2, var9 + 22);
         }
      } catch (Exception var11) {
         this.canvas.repaint();
      }

   }

   void method781(int var1) {
      long var2 = Stream.method3547(604838575);
      long var4 = field404[class20.field172];
      field404[class20.field172] = var2;
      class20.field172 = class20.field172 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         ;
      }

      synchronized(this) {
         class18.field146 = field390;
      }

      this.vmethod1136(1052023991);
   }

   final void method768(Object var1, byte var2) {
      if(this.field399 != null) {
         for(int var3 = 0; var3 < 50 && this.field399.peekEvent() != null; var3++) {
            class63.method1539(1L);
         }

         if(var1 != null) {
            this.field399.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   protected final void method772(byte var1) {
      if(class154.field1960.toLowerCase().indexOf("microsoft") != -1) {
         if(var1 != 0) {
            return;
         }

         class39.field334[186] = 57;
         class39.field334[187] = 27;
         class39.field334[188] = 71;
         class39.field334[189] = 26;
         class39.field334[190] = 72;
         class39.field334[191] = 73;
         class39.field334[192] = 58;
         class39.field334[219] = 42;
         class39.field334[220] = 74;
         class39.field334[221] = 43;
         class39.field334[222] = 59;
         class39.field334[223] = 28;
      } else {
         class39.field334[44] = 71;
         class39.field334[45] = 26;
         class39.field334[46] = 72;
         class39.field334[47] = 73;
         class39.field334[59] = 57;
         class39.field334[61] = 27;
         class39.field334[91] = 42;
         class39.field334[92] = 74;
         class39.field334[93] = 43;
         class39.field334[192] = 28;
         class39.field334[222] = 58;
         class39.field334[520] = 59;
      }

      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(class39.field337);
      var2.addFocusListener(class39.field337);
   }

   protected final void method791(int var1) {
      Canvas var2 = this.canvas;
      var2.addMouseListener(class48.field429);
      var2.addMouseMotionListener(class48.field429);
      var2.addFocusListener(class48.field429);
   }

   protected class156 method769(byte var1) {
      if(this.field407 == null) {
         this.field407 = new class38();
         this.field407.method665(this.canvas, 1305046280);
      }

      return this.field407;
   }

   protected final void method778(int var1, int var2, int var3, int var4) {
      try {
         if(INSTANCE != null) {
            if(var4 == 1695486519) {
               return;
            }

            ++field387;
            if(field387 >= 3) {
               this.method788("alreadyloaded", 1327956818);
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         INSTANCE = this;
         class82.field1179 = var1;
         class243.field3138 = var2;
         GameCanvas.field362 = var3;
         class152.field1938 = this;
         if(field392 == null) {
            field392 = new class154();
         }

         field392.method3249(this, 1, 1672602296);
      } catch (Exception var6) {
         class5.method65((String)null, var6, (byte)85);
         this.method788("crash", 1327956818);
      }

   }

   protected void method770(int var1) {
      this.field412 = this.getToolkit().getSystemClipboard();
   }

   protected final void method906(int var1, int var2, int var3) {
      if(this.field400 != var1 || var2 != this.field414) {
         this.method784((byte)1);
      }

      this.field400 = var1;
      this.field414 = var2;
   }

   protected abstract void vmethod1144(int var1);

   final void method777(byte var1) {
      Canvas var2 = this.canvas;
      var2.removeKeyListener(class39.field337);
      var2.removeFocusListener(class39.field337);
      class39.field329 = -1;
      Canvas var3 = this.canvas;
      var3.removeMouseListener(class48.field429);
      var3.removeMouseMotionListener(class48.field429);
      var3.removeFocusListener(class48.field429);
      class48.field424 = 0;
      if(this.field407 != null) {
         this.field407.method668(this.canvas, 1338502209);
      }

      this.method779(-1503322792);
      Canvas var4 = this.canvas;
      var4.setFocusTraversalKeysEnabled(false);
      var4.addKeyListener(class39.field337);
      var4.addFocusListener(class39.field337);
      Canvas var5 = this.canvas;
      var5.addMouseListener(class48.field429);
      var5.addMouseMotionListener(class48.field429);
      var5.addFocusListener(class48.field429);
      if(this.field407 != null) {
         this.field407.method665(this.canvas, 1403563861);
      }

      this.method784((byte)1);
   }

   final void method783(int var1) {
      class310 var2 = this.method800((byte)20);
      if(var2.field3747 == this.field396 && this.field397 == var2.field3745) {
         if(var1 >= -363051911) {
            return;
         }

         if(!this.field408) {
            return;
         }
      }

      this.method854(1629251833);
      this.field408 = false;
   }

   protected abstract void vmethod1137(boolean var1, byte var2);

   void method776(int var1) {
      int var2 = this.field398;
      int var3 = this.field411;
      int var4 = this.field396 - class82.field1179 - var2;
      int var5 = this.field397 - class243.field3138 - var3;
      if(var2 <= 0) {
         if(var1 >= -1661993339) {
            return;
         }

         if(var4 <= 0 && var3 <= 0) {
            if(var1 >= -1661993339) {
               return;
            }

            if(var5 <= 0) {
               return;
            }
         }
      }

      try {
         Container var6 = this.method799(-1662272382);
         int var7 = 0;
         int var8 = 0;
         if(var6 == this.field403) {
            Insets var9 = this.field403.getInsets();
            var7 = var9.left;
            var8 = var9.top;
         }

         Graphics var11 = var6.getGraphics();
         var11.setColor(Color.black);
         if(var2 > 0) {
            var11.fillRect(var7, var8, var2, this.field397);
         }

         if(var3 > 0) {
            var11.fillRect(var7, var8, this.field396, var3);
         }

         if(var4 > 0) {
            var11.fillRect(var7 + this.field396 - var4, var8, var4, this.field397);
         }

         if(var5 > 0) {
            var11.fillRect(var7, var8 + this.field397 - var5, this.field396, var5);
         }
      } catch (Exception var10) {
         ;
      }

   }

   protected void method771(String var1, short var2) {
      this.field412.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   protected final boolean method801(int var1) {
      return this.field403 != null;
   }

   public void run() {
      try {
         if(class154.field1960 != null) {
            String var1 = class154.field1960.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class154.field1954;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method788("wrongjava", 1327956818);
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length(); var3++) {
                     char var5 = var2.charAt(var3);
                     boolean var4 = var5 >= 48 && var5 <= 57;
                     if(!var4) {
                        break;
                     }
                  }

                  String var6 = var2.substring(6, var3);
                  if(class102.method2249(var6, (byte)1)) {
                     int var9 = class68.method1693(var6, 10, true);
                     if(var9 < 10) {
                        this.method788("wrongjava", 1327956818);
                        return;
                     }
                  }
               }

               field385 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method779(-1647866935);
         this.vmethod1505(-1300111147);
         class43.field368 = class43.method712(1681202713);

         while(field388 == 0L || Stream.method3547(604838575) < field388) {
            class8.field48 = class43.field368.vmethod3331(field391, field385, 2142370282);

            for(int var7 = 0; var7 < class8.field48; var7++) {
               this.method781(2136042033);
            }

            this.method782(243481673);
            this.method768(this.canvas, (byte)-2);
         }
      } catch (Exception var8) {
         class5.method65((String)null, var8, (byte)53);
         this.method788("crash", 1327956818);
      }

      this.method785(-199508735);
   }

   public final void start() {
      if(this == INSTANCE && !field389) {
         field388 = 0L;
      }
   }

   public final void stop() {
      if(this == INSTANCE && !field389) {
         field388 = Stream.method3547(604838575) + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      field390 = true;
      this.field406 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field390 = false;
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public abstract void init();

   static final byte[] method912(byte[] var0, int var1) {
      Stream var2 = new Stream(var0);
      int var3 = var2.readUByte();
      int var4 = var2.readInt();
      if(var4 < 0 || class247.field3176 != 0 && var4 > class247.field3176) {
         throw new RuntimeException();
      } else if(var3 == 0) {
         byte[] var5 = new byte[var4];
         var2.method3539(var5, 0, var4);
         return var5;
      } else {
         int var7 = var2.readInt();
         if (var7 > 10000000) {
            System.out.println("XTEA crash intercepted.");
            return new byte[100];
         }
         if(var7 >= 0 && (class247.field3176 == 0 || var7 <= class247.field3176)) {
            byte[] var6 = new byte[var7];
            if(var3 == 1) {
               class176.method3489(var6, var7, var0, var4, 9);
            } else {
               class247.field3172.method3483(var2, var6, 641933971);
            }

            return var6;
         } else {
           // throw new RuntimeException();
            return new byte[100];
         }
      }
   }

   static void method910(int var0) {
      Iterator var1 = class83.field1181.iterator();

      while(var1.hasNext()) {
         class58 var2 = (class58)var1.next();
         var2.method1042(725816073);
      }

   }

   public static class157 method911(Socket var0, int var1, int var2, byte var3) throws IOException {
      return new class159(var0, var1, var2);
   }

   public static final void method913(int var0, int var1, byte var2) {
      class120.field1648 = var0;
      class120.field1649 = var1;
      class120.field1650 = true;
      class120.field1656 = 0;
      class120.field1652 = false;
   }

   static int method909(int var0, class84 var1, boolean var2, byte var3) {
      int var4 = -1;
      Widget var5;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class69.field999[--class69.field1003];
         var5 = Widget.getLoaded(var4);
      } else {
         var5 = var2 ? class276.field3561 : class260.field3301;
      }

      if(var0 == 1000) {
         class69.field1003 -= 4;
         var5.x = class69.field999[class69.field1003];
         var5.y = class69.field999[class69.field1003 + 1];
         var5.xAlignment = class69.field999[class69.field1003 + 2];
         var5.yAlignment = class69.field999[class69.field1003 + 3];
         GameClient.requestRedraw(var5);
         Stream.client.method506(var5);
         if(var4 != -1 && var5.widgetType == 0) {
            class163.method3388(Widget.LOADED[var4 >> 16], var5, false, 629354069);
         }

         return 1;
      } else if(var0 == 1001) {
         class69.field1003 -= 4;
         var5.width = class69.field999[class69.field1003];
         var5.height = class69.field999[class69.field1003 + 1];
         var5.widthAlignment = class69.field999[class69.field1003 + 2];
         var5.heightAlignment = class69.field999[class69.field1003 + 3];
         GameClient.requestRedraw(var5);
         Stream.client.method506(var5);
         if(var4 != -1 && var5.widgetType == 0) {
            class163.method3388(Widget.LOADED[var4 >> 16], var5, false, 1094398214);
         }

         return 1;
      } else if(var0 == 1003) {
         --class69.field1003;
         boolean var6 = class69.field999[class69.field1003] == 1;
         if(var6 != var5.hidden) {
            var5.hidden = var6;
            GameClient.requestRedraw(var5);
         }

         return 1;
      } else if(var0 == 1005) {
         --class69.field1003;
         var5.bool40 = class69.field999[class69.field1003] == 1;
         return 1;
      } else if(var0 == 1006) {
         --class69.field1003;
         var5.field2740 = class69.field999[class69.field1003] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   static int method914(int var0, class84 var1, boolean var2, int var3) {
      Widget var4 = var2 ? class276.field3561 : class260.field3301;
      if(var0 == 1800) {
         class69.field999[++class69.field1003 - 1] = class154.method3252(class24.method425(var4, (byte)-77), (byte)38);
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var4.string29 == null) {
               class69.field1001[++class55.field497 - 1] = "";
            } else {
               class69.field1001[++class55.field497 - 1] = var4.string29;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var5 = class69.field999[--class69.field1003];
         --var5;
         if(var4.regularOptions != null && var5 < var4.regularOptions.length && var4.regularOptions[var5] != null) {
            class69.field1001[++class55.field497 - 1] = var4.regularOptions[var5];
         } else {
            class69.field1001[++class55.field497 - 1] = "";
         }

         return 1;
      }
   }
}
