package client;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;

public final class GameCanvas extends Canvas {
   public static int field362;
   Component field365;

   GameCanvas(Component var1) {
      this.field365 = var1;
   }

   public final void update(Graphics var1) {
      this.field365.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field365.paint(var1);
   }
}
