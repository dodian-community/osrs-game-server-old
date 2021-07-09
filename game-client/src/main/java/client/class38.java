package client;

import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class class38 implements class156, MouseWheelListener {
   int field328 = 0;

   void method665(Component var1, int var2) {
      var1.addMouseWheelListener(this);
   }

   void method668(Component var1, int var2) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized int vmethod3278(int var1) {
      int var2 = this.field328;
      this.field328 = 0;
      return var2;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field328 += var1.getWheelRotation();
   }
}
