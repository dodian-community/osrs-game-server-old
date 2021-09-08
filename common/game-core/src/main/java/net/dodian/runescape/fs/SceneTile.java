package net.dodian.runescape.fs;

public final class SceneTile { // LinkedEntry_Sub12
	
	int anInt1794;
	ShapedSquare shapedSquare;
	Object aClass26_1800;
	int anInt1801;
	Object aClass38_1802;
	Object aClass19_1803;
	SceneTile aClass109_Sub12_1804;
	int anInt1806;
	boolean aBool1809;
	Object aClass21_1810;
	boolean aBool1811;
	int anInt1812;
	int anInt1813;
	net.dodian.runescape.fs.SolidSquare solidSquare;
	int anInt1815;
	boolean aBool1816;
	static final int anInt1817 = 91;
	public static final int anInt1818 = 145;
	Object[] aClass33Array1805 = new Object[5];
	int[] anIntArray1795 = new int[5];
	int anInt1807 = 0;
	int anInt1808;
	int anInt1797;
	int anInt1798;
	int anInt1796;
	
	SceneTile(int var1, int var2, int var3) {
		anInt1797 = (anInt1808 = var1);
		anInt1798 = var2;
		anInt1796 = var3;
	}
	
	public static int method1851(int var0, int var1) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}
	
}
