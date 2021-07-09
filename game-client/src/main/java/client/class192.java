package client;

import java.util.Calendar;
import java.util.TimeZone;

public class class192 {
   public static final String[][] field2392 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   public static final String[] field2390 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   public static Calendar field2389;
   public static boolean field2391;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2389 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   public static void method3871(int var0) {
      class227.field2580.method3984();
   }
}
