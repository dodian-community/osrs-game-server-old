package client;

public final class Isaac {
	static final int field2378 = 8;
	static final int field2379 = 256;
	static final int field2380 = 1020;
	public static final int field2383 = 51;
	int field2381;
	int field2385;
	int field2382;
	int[] field2386 = new int[256];
	int[] field2384 = new int[256];
	int field2387;

	public Isaac(int[] var1) {
		for (int var2 = 0; var2 < var1.length; var2++) {
			this.field2384[var2] = var1[var2];
		}

		this.method3861(-322691741);
	}

	final void method3852(int var1) {
		int var10001 = this.field2385;
		int var10002 = this.field2382 + 1;
		++this.field2382;
		this.field2385 = var10001 + var10002;

		for (int var2 = 0; var2 < 256; var2++) {
			int var3 = this.field2386[var2];
			if ((var2 & 2) == 0) {
				if ((var2 & 1) == 0) {
					this.field2387 ^= this.field2387 << 13;
				} else {
					this.field2387 ^= this.field2387 >>> 6;
				}
			} else if ((var2 & 1) == 0) {
				this.field2387 ^= this.field2387 << 2;
			} else {
				this.field2387 ^= this.field2387 >>> 16;
			}

			this.field2387 += this.field2386[128 + var2 & 255];
			int var4;
			this.field2386[var2] = var4 = this.field2386[(var3 & 1020) >> 2] + this.field2385 + this.field2387;
			this.field2384[var2] = this.field2385 = this.field2386[(var4 >> 8 & 1020) >> 2] + var3;
		}

	}

	final int method3853() {
		if (Loader.local) return 0;

		if (this.field2381 == 0) {
			this.method3852(-562093193);
			this.field2381 = 256;
		}

		return this.field2384[this.field2381 - 1];
	}

	final void method3861(int var1) {
		int var10 = -1640531527;
		int var9 = -1640531527;
		int var8 = -1640531527;
		int var7 = -1640531527;
		int var6 = -1640531527;
		int var5 = -1640531527;
		int var4 = -1640531527;
		int var3 = -1640531527;

		int var2;
		for (var2 = 0; var2 < 4; var2++) {
			var3 ^= var4 << 11;
			var6 += var3;
			var4 += var5;
			var4 ^= var5 >>> 2;
			var7 += var4;
			var5 += var6;
			var5 ^= var6 << 8;
			var8 += var5;
			var6 += var7;
			var6 ^= var7 >>> 16;
			var9 += var6;
			var7 += var8;
			var7 ^= var8 << 10;
			var10 += var7;
			var8 += var9;
			var8 ^= var9 >>> 4;
			var3 += var8;
			var9 += var10;
			var9 ^= var10 << 8;
			var4 += var9;
			var10 += var3;
			var10 ^= var3 >>> 9;
			var5 += var10;
			var3 += var4;
		}

		for (var2 = 0; var2 < 256; var2 += 8) {
			var3 += this.field2384[var2];
			var4 += this.field2384[var2 + 1];
			var5 += this.field2384[var2 + 2];
			var6 += this.field2384[var2 + 3];
			var7 += this.field2384[var2 + 4];
			var8 += this.field2384[var2 + 5];
			var9 += this.field2384[var2 + 6];
			var10 += this.field2384[var2 + 7];
			var3 ^= var4 << 11;
			var6 += var3;
			var4 += var5;
			var4 ^= var5 >>> 2;
			var7 += var4;
			var5 += var6;
			var5 ^= var6 << 8;
			var8 += var5;
			var6 += var7;
			var6 ^= var7 >>> 16;
			var9 += var6;
			var7 += var8;
			var7 ^= var8 << 10;
			var10 += var7;
			var8 += var9;
			var8 ^= var9 >>> 4;
			var3 += var8;
			var9 += var10;
			var9 ^= var10 << 8;
			var4 += var9;
			var10 += var3;
			var10 ^= var3 >>> 9;
			var5 += var10;
			var3 += var4;
			this.field2386[var2] = var3;
			this.field2386[var2 + 1] = var4;
			this.field2386[var2 + 2] = var5;
			this.field2386[var2 + 3] = var6;
			this.field2386[var2 + 4] = var7;
			this.field2386[var2 + 5] = var8;
			this.field2386[var2 + 6] = var9;
			this.field2386[var2 + 7] = var10;
		}

		for (var2 = 0; var2 < 256; var2 += 8) {
			var3 += this.field2386[var2];
			var4 += this.field2386[var2 + 1];
			var5 += this.field2386[var2 + 2];
			var6 += this.field2386[var2 + 3];
			var7 += this.field2386[var2 + 4];
			var8 += this.field2386[var2 + 5];
			var9 += this.field2386[var2 + 6];
			var10 += this.field2386[var2 + 7];
			var3 ^= var4 << 11;
			var6 += var3;
			var4 += var5;
			var4 ^= var5 >>> 2;
			var7 += var4;
			var5 += var6;
			var5 ^= var6 << 8;
			var8 += var5;
			var6 += var7;
			var6 ^= var7 >>> 16;
			var9 += var6;
			var7 += var8;
			var7 ^= var8 << 10;
			var10 += var7;
			var8 += var9;
			var8 ^= var9 >>> 4;
			var3 += var8;
			var9 += var10;
			var9 ^= var10 << 8;
			var4 += var9;
			var10 += var3;
			var10 ^= var3 >>> 9;
			var5 += var10;
			var3 += var4;
			this.field2386[var2] = var3;
			this.field2386[var2 + 1] = var4;
			this.field2386[var2 + 2] = var5;
			this.field2386[var2 + 3] = var6;
			this.field2386[var2 + 4] = var7;
			this.field2386[var2 + 5] = var8;
			this.field2386[var2 + 6] = var9;
			this.field2386[var2 + 7] = var10;
		}

		this.method3852(-1834597748);
		this.field2381 = 256;
	}

	final int method3850() {
		if (Loader.local) return 0;

		if (--this.field2381 + 1 == 0) {
			this.method3852(-544469787);
			this.field2381 = 255;
		}

		return this.field2384[this.field2381];
	}

	public static int method3865(int var0, short var1) {
		return var0 >> 17 & 7;
	}
}
