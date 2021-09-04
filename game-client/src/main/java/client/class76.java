package client;

import java.math.BigInteger;

public class class76 {
	static final BigInteger field1071 = new BigInteger("10001", 16);
	static BigInteger RSA_MOD = new BigInteger("97e13ef453eef11c2e2b108891d256c90098b9da343c760762cdc2ccb5b9cc01552ee1f17fef7e9ad45cce00f378db17ae8f17c43fa4bdab098e5022b17175b147560d10c86658c7a471514e0bdce6c95f1b0ba8ceb5322e09b64b6bb30b1f88d2a879f88b871b4519717800df32d7f3e55f492af08025ab7ccd747491e82fe5", 16);
	public static class109[] field1068;
	static int[] field1073;
	public static final int field1070 = 14;
	static final int field1072 = 100;

	static {
		if (Loader.local)
			RSA_MOD = new BigInteger("bb30dd41ab0a60b3e2072a06ebeb7a88d538d33a8be8f2046059aadab0111dc3b369d1fc044431d29e614fa02ddf18603b0727eca2941d3b2b4e21f148f831e45eaa05a994255fc3b4524356709577461ea109b5272e462dd8cf622060e46a97c29efea014eedaac599e6a706d3945a3e03d623eb55c3de64a69145f61f1567d", 16);
	}

	public static class188 method1803(class188[] var0, int var1, byte var2) {
		class188[] var3 = var0;

		for (int var4 = 0; var4 < var3.length; var4++) {
			class188 var5 = var3[var4];
			if (var1 == var5.vmethod5815((byte) 59)) {
				return var5;
			}
		}

		return null;
	}

	public static long method1804(int var0, int var1, int var2, boolean var3, int var4, int var5) {
		long var6 = (long) ((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long) var4 & 4294967295L) << 17;
		if (var3) {
			var6 |= 65536L;
		}

		return var6;
	}
}
