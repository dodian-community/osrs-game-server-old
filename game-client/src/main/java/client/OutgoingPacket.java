package client;

import java.util.Arrays;

public class OutgoingPacket implements class167 {

   private static final int[] sizes = new int[256];
   public static final OutgoingPacket field2204 = new OutgoingPacket(0, 9);
   public static final OutgoingPacket field2136 = new OutgoingPacket(1, -1);
   public static final OutgoingPacket field2137 = new OutgoingPacket(2, 3);
   public static final OutgoingPacket field2168 = new OutgoingPacket(3, -1);
   public static final OutgoingPacket field2203 = new OutgoingPacket(68, -1);
   public static final OutgoingPacket field2157 = new OutgoingPacket(48, -1);
   public static final OutgoingPacket field2139 = new OutgoingPacket(4, 7);
   public static final OutgoingPacket field2194 = new OutgoingPacket(59, -1);
   public static final OutgoingPacket field2221 = new OutgoingPacket(86, -1);
   public static final OutgoingPacket field2225 = new OutgoingPacket(5, 2);
   public static final OutgoingPacket field2153 = new OutgoingPacket(6, -1);
   public static final OutgoingPacket field2145 = new OutgoingPacket(10, -1);
   public static final OutgoingPacket field2142 = new OutgoingPacket(7, 0);
   public static final OutgoingPacket field2201 = new OutgoingPacket(66, -1);
   public static final OutgoingPacket field2156 = new OutgoingPacket(8, 9);
   public static final OutgoingPacket field2228 = new OutgoingPacket(93, -1);
   public static final OutgoingPacket field2144 = new OutgoingPacket(9, 8);
   public static final OutgoingPacket field2196 = new OutgoingPacket(61, 16);
   public static final OutgoingPacket field2141 = new OutgoingPacket(11, 8);
   public static final OutgoingPacket field2190 = new OutgoingPacket(52, 4);
   public static final OutgoingPacket field2147 = new OutgoingPacket(12, 7);
   public static final OutgoingPacket field2188 = new OutgoingPacket(53, 6);
   public static final OutgoingPacket field2148 = new OutgoingPacket(13, 4);
   public static final OutgoingPacket field2151 = new OutgoingPacket(14, 8);
   public static final OutgoingPacket field2215 = new OutgoingPacket(80, 5);
   public static final OutgoingPacket field2150 = new OutgoingPacket(15, 4);
   public static final OutgoingPacket field2216 = new OutgoingPacket(16, 7);
   public static final OutgoingPacket field2152 = new OutgoingPacket(17, 0);
   public static final OutgoingPacket field2174 = new OutgoingPacket(18, -1);
   public static final OutgoingPacket field2154 = new OutgoingPacket(19, -2);
   public static final OutgoingPacket field2218 = new OutgoingPacket(83, -2);
   public static final OutgoingPacket field2155 = new OutgoingPacket(20, 8);
   public static final OutgoingPacket field2198 = new OutgoingPacket(21, 3);
   public static final OutgoingPacket field2138 = new OutgoingPacket(22, 8);
   public static final OutgoingPacket field2171 = new OutgoingPacket(23, 8);
   public static final OutgoingPacket field2164 = new OutgoingPacket(29, 16);
   public static final OutgoingPacket field2178 = new OutgoingPacket(89, 3);
   public static final OutgoingPacket field2210 = new OutgoingPacket(24, 7);
   public static final OutgoingPacket field2160 = new OutgoingPacket(25, 8);
   public static final OutgoingPacket field2227 = new OutgoingPacket(62, 1);
   public static final OutgoingPacket field2183 = new OutgoingPacket(50, 4);
   public static final OutgoingPacket field2161 = new OutgoingPacket(26, 7);
   public static final OutgoingPacket field2234 = new OutgoingPacket(27, 15);
   public static final OutgoingPacket field2163 = new OutgoingPacket(28, 3);
   public static final OutgoingPacket field2191 = new OutgoingPacket(56, 8);
   public static final OutgoingPacket field2146 = new OutgoingPacket(30, 2);
   public static final OutgoingPacket field2140 = new OutgoingPacket(31, 8);
   public static final OutgoingPacket field2211 = new OutgoingPacket(76, 0);
   public static final OutgoingPacket field2167 = new OutgoingPacket(32, -2);
   public static final OutgoingPacket field2182 = new OutgoingPacket(33, 2);
   public static final OutgoingPacket field2169 = new OutgoingPacket(34, 7);
   public static final OutgoingPacket field2170 = new OutgoingPacket(35, 9);
   public static final OutgoingPacket field2200 = new OutgoingPacket(65, 8);
   public static final OutgoingPacket field2186 = new OutgoingPacket(36, 7);
   public static final OutgoingPacket field2172 = new OutgoingPacket(37, 13);
   public static final OutgoingPacket field2173 = new OutgoingPacket(38, 13);
   public static final OutgoingPacket field2166 = new OutgoingPacket(39, 8);
   public static final OutgoingPacket field2206 = new OutgoingPacket(71, 3);
   public static final OutgoingPacket field2175 = new OutgoingPacket(40, 8);
   public static final OutgoingPacket field2176 = new OutgoingPacket(41, 10);
   public static final OutgoingPacket field2197 = new OutgoingPacket(42, 8);
   public static final OutgoingPacket field2184 = new OutgoingPacket(43, 11);
   public static final OutgoingPacket field2179 = new OutgoingPacket(44, -1);
   public static final OutgoingPacket field2180 = new OutgoingPacket(45, 8);
   public static final OutgoingPacket field2181 = new OutgoingPacket(46, 3);
   public static final OutgoingPacket field2232 = new OutgoingPacket(47, 7);
   public static final OutgoingPacket field2165 = new OutgoingPacket(49, 14);
   public static final OutgoingPacket field2205 = new OutgoingPacket(51, 7);
   public static final OutgoingPacket field2189 = new OutgoingPacket(54, 11);
   public static final OutgoingPacket field2143 = new OutgoingPacket(55, 13);
   public static final OutgoingPacket field2219 = new OutgoingPacket(84, -1);
   public static final OutgoingPacket field2192 = new OutgoingPacket(57, 3);
   public static final OutgoingPacket field2193 = new OutgoingPacket(58, 8);
   public static final OutgoingPacket field2195 = new OutgoingPacket(69, 0);
   public static final OutgoingPacket field2159 = new OutgoingPacket(60, 16);
   public static final OutgoingPacket field2135 = new OutgoingPacket(97, -1);
   public static final OutgoingPacket field2158 = new OutgoingPacket(92, 6);
   public static final OutgoingPacket field2209 = new OutgoingPacket(74, -1);
   public static final OutgoingPacket field2149 = new OutgoingPacket(63, 8);
   public static final OutgoingPacket field2199 = new OutgoingPacket(64, 15);
   public static final OutgoingPacket field2185 = new OutgoingPacket(75, -1);
   public static final OutgoingPacket field2202 = new OutgoingPacket(67, 8);
   public static final OutgoingPacket field2220 = new OutgoingPacket(85, 3);
   public static final OutgoingPacket field2222 = new OutgoingPacket(87, 3);
   public static final OutgoingPacket field2224 = new OutgoingPacket(70, 0);
   public static final OutgoingPacket field2187 = new OutgoingPacket(90, -1);
   public static final OutgoingPacket field2207 = new OutgoingPacket(72, 3);
   public static final OutgoingPacket field2208 = new OutgoingPacket(73, 3);
   public static final OutgoingPacket field2212 = new OutgoingPacket(77, 9);
   public static final OutgoingPacket field2213 = new OutgoingPacket(78, 8);
   public static final OutgoingPacket field2214 = new OutgoingPacket(79, 7);
   public static final OutgoingPacket field2162 = new OutgoingPacket(81, 2);
   public static final OutgoingPacket field2217 = new OutgoingPacket(82, 3);
   public static final OutgoingPacket field2230 = new OutgoingPacket(95, 4);
   public static final OutgoingPacket field2223 = new OutgoingPacket(88, 3);
   public static final OutgoingPacket field2226 = new OutgoingPacket(91, 8);
   public static final OutgoingPacket field2229 = new OutgoingPacket(94, 3);
   public static final OutgoingPacket field2231 = new OutgoingPacket(96, 8);
   final int field2233;
   final int field2177;

   OutgoingPacket(int var1, int var2) {
      this.field2233 = var1;
      this.field2177 = var2;
      sizes[var1] = var2;
      if (var1 == 96) {
         System.out.println(Arrays.toString(sizes));
      }
   }

   public static void method3446(int[] var0, int[] var1, int var2) {
      if(var0 != null) {
         if(var1 != null) {
            class183.field2348 = var0;
            class183.field2347 = new int[var0.length];
            class183.field2341 = new byte[var0.length][][];

            for(int var3 = 0; var3 < class183.field2348.length; var3++) {
               class183.field2341[var3] = new byte[var1[var3]][];
            }

            return;
         }

         if(var2 != 773113121) {
            return;
         }
      }

      class183.field2348 = null;
      class183.field2347 = null;
      class183.field2341 = null;
   }

   static final void method3447(Widget var0, int var1, int var2, byte var3) {
      if(GameClient.field583 == null && !GameClient.field716) {
         if(var0 != null) {
            if(var3 != 0) {
               return;
            }

            if(class21.method264(var0, -1594952261) != null) {
               GameClient.field583 = var0;
               GameClient.field752 = class21.method264(var0, 1043248575);
               GameClient.field753 = var1;
               GameClient.field749 = var2;
               class6.field39 = 0;
               GameClient.field763 = false;
               int var4 = GameClient.field771 - 1;
               if(var4 != -1) {
                  class229.field2588 = new class75();
                  class229.field2588.field1066 = GameClient.field718[var4];
                  class229.field2588.field1060 = GameClient.field851[var4];
                  class229.field2588.field1061 = GameClient.field720[var4];
                  class229.field2588.field1062 = GameClient.field794[var4];
                  class229.field2588.field1063 = GameClient.field735[var4];
               }

               return;
            }
         }

      }
   }
}
