package net.dodian.runescape.fs;

public final class ShapedSquare { // Class20
	
	static int[] anIntArray251 = new int[6];
	static int[] anIntArray252 = new int[6];
	static int[] anIntArray257 = new int[6];
	static int[] anIntArray254 = new int[6];
	static int[] anIntArray240 = new int[6];
	static int[][] anIntArrayArray241 = new int[][]{{1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}};
	static int[][] anIntArrayArray243 = new int[][]{{0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3}, {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3}, {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4}, {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4}, {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3}, {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3}, {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5}, {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5}, {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3}, {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3}, {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}};
	boolean aBool246 = true;
	int tileShape;
	int tileShapeRotation;
	int tileForeground;
	int tileBackground;
	int[] anIntArray256;
	int[] anIntArray237;
	int[] anIntArray238;
	int[] anIntArray242;
	int[] anIntArray253;
	int[] anIntArray248;
	int[] anIntArray239;
	int[] anIntArray244;
	int[] anIntArray255;
	int[] anIntArray245;
	
	ShapedSquare(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19) {
		if (var6 != var7 || var6 != var8 || var6 != var9) {
			aBool246 = false;
		}
		
		tileShape = var1;
		tileShapeRotation = var2;
		tileForeground = var18;
		tileBackground = var19;
		short var22 = 128;
		int var23 = var22 / 2;
		int var24 = var22 / 4;
		int var25 = var22 * 3 / 4;
		int[] var36 = anIntArrayArray241[var1];
		int var27 = var36.length;
		anIntArray256 = new int[var27];
		anIntArray237 = new int[var27];
		anIntArray238 = new int[var27];
		int[] var37 = new int[var27];
		int[] var30 = new int[var27];
		int var34 = var4 * var22;
		int var31 = var5 * var22;
		
		int var20;
		int var21;
		int var29;
		int var32;
		int var33;
		int var35;
		for (int var28 = 0; var28 < var27; var28++) {
			var21 = var36[var28];
			if ((var21 & 1) == 0 && var21 <= 8) {
				var21 = (var21 - var2 - var2 - 1 & 7) + 1;
			}
			
			if (var21 > 8 && var21 <= 12) {
				var21 = (var21 - 9 - var2 & 3) + 9;
			}
			
			if (var21 > 12 && var21 <= 16) {
				var21 = (var21 - 13 - var2 & 3) + 13;
			}
			
			if (var21 == 1) {
				var35 = var34;
				var33 = var31;
				var29 = var6;
				var20 = var10;
				var32 = var14;
			} else if (var21 == 2) {
				var35 = var34 + var23;
				var33 = var31;
				var29 = var6 + var7 >> 1;
				var20 = var10 + var11 >> 1;
				var32 = var14 + var15 >> 1;
			} else if (var21 == 3) {
				var35 = var34 + var22;
				var33 = var31;
				var29 = var7;
				var20 = var11;
				var32 = var15;
			} else if (var21 == 4) {
				var35 = var34 + var22;
				var33 = var31 + var23;
				var29 = var7 + var8 >> 1;
				var20 = var11 + var12 >> 1;
				var32 = var15 + var16 >> 1;
			} else if (var21 == 5) {
				var35 = var34 + var22;
				var33 = var31 + var22;
				var29 = var8;
				var20 = var12;
				var32 = var16;
			} else if (var21 == 6) {
				var35 = var34 + var23;
				var33 = var31 + var22;
				var29 = var8 + var9 >> 1;
				var20 = var12 + var13 >> 1;
				var32 = var16 + var17 >> 1;
			} else if (var21 == 7) {
				var35 = var34;
				var33 = var31 + var22;
				var29 = var9;
				var20 = var13;
				var32 = var17;
			} else if (var21 == 8) {
				var35 = var34;
				var33 = var31 + var23;
				var29 = var9 + var6 >> 1;
				var20 = var13 + var10 >> 1;
				var32 = var17 + var14 >> 1;
			} else if (var21 == 9) {
				var35 = var34 + var23;
				var33 = var31 + var24;
				var29 = var6 + var7 >> 1;
				var20 = var10 + var11 >> 1;
				var32 = var14 + var15 >> 1;
			} else if (var21 == 10) {
				var35 = var34 + var25;
				var33 = var31 + var23;
				var29 = var7 + var8 >> 1;
				var20 = var11 + var12 >> 1;
				var32 = var15 + var16 >> 1;
			} else if (var21 == 11) {
				var35 = var34 + var23;
				var33 = var31 + var25;
				var29 = var8 + var9 >> 1;
				var20 = var12 + var13 >> 1;
				var32 = var16 + var17 >> 1;
			} else if (var21 == 12) {
				var35 = var34 + var24;
				var33 = var31 + var23;
				var29 = var9 + var6 >> 1;
				var20 = var13 + var10 >> 1;
				var32 = var17 + var14 >> 1;
			} else if (var21 == 13) {
				var35 = var34 + var24;
				var33 = var31 + var24;
				var29 = var6;
				var20 = var10;
				var32 = var14;
			} else if (var21 == 14) {
				var35 = var34 + var25;
				var33 = var31 + var24;
				var29 = var7;
				var20 = var11;
				var32 = var15;
			} else if (var21 == 15) {
				var35 = var34 + var25;
				var33 = var31 + var25;
				var29 = var8;
				var20 = var12;
				var32 = var16;
			} else {
				var35 = var34 + var24;
				var33 = var31 + var25;
				var29 = var9;
				var20 = var13;
				var32 = var17;
			}
			
			anIntArray256[var28] = var35;
			anIntArray237[var28] = var29;
			anIntArray238[var28] = var33;
			var37[var28] = var20;
			var30[var28] = var32;
		}
		
		int[] var38 = anIntArrayArray243[var1];
		var21 = var38.length / 4;
		anIntArray242 = new int[var21];
		anIntArray253 = new int[var21];
		anIntArray248 = new int[var21];
		anIntArray239 = new int[var21];
		anIntArray244 = new int[var21];
		anIntArray255 = new int[var21];
		if (var3 != -1) {
			anIntArray245 = new int[var21];
		}
		
		var35 = 0;
		
		for (var33 = 0; var33 < var21; var33++) {
			var29 = var38[var35];
			var20 = var38[var35 + 1];
			var32 = var38[var35 + 2];
			int var26 = var38[var35 + 3];
			var35 += 4;
			if (var20 < 4) {
				var20 = var20 - var2 & 3;
			}
			
			if (var32 < 4) {
				var32 = var32 - var2 & 3;
			}
			
			if (var26 < 4) {
				var26 = var26 - var2 & 3;
			}
			
			anIntArray242[var33] = var20;
			anIntArray253[var33] = var32;
			anIntArray248[var33] = var26;
			if (var29 == 0) {
				anIntArray239[var33] = var37[var20];
				anIntArray244[var33] = var37[var32];
				anIntArray255[var33] = var37[var26];
				if (anIntArray245 != null) {
					anIntArray245[var33] = -1;
				}
			} else {
				anIntArray239[var33] = var30[var20];
				anIntArray244[var33] = var30[var32];
				anIntArray255[var33] = var30[var26];
				if (anIntArray245 != null) {
					anIntArray245[var33] = var3;
				}
			}
		}
		
		var33 = var6;
		var29 = var7;
		if (var7 < var6) {
			var33 = var7;
		}
		
		if (var7 > var7) {
			var29 = var7;
		}
		
		if (var8 < var33) {
			var33 = var8;
		}
		
		if (var8 > var29) {
			var29 = var8;
		}
		
		if (var9 < var33) {
			var33 = var9;
		}
		
		if (var9 > var29) {
			var29 = var9;
		}
		
		var33 /= 14;
		var29 /= 14;
	}
	
}
