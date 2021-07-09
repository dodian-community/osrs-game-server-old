package client;

public class class270 implements class188 {
	static final class270 field3484 = new class270(1, 0);
	static final class270 field3479 = new class270(0, 1);
	static final class270 field3481 = new class270(2, 2);
	public static final int field3480 = 3;
	public static final int field3485 = 16;
	public final int field3482;
	final int field3483;

	class270(int var1, int var2) {
		this.field3482 = var1;
		this.field3483 = var2;
	}

	public int vmethod5815(byte var1) {
		return this.field3483;
	}

	public static NpcDef loadNpcDef(int var0) {
		NpcDef var2 = (NpcDef) NpcDef.field3488.method3989((long) var0);
		if (var2 != null) {
			return var2;
		} else {
			byte[] var3 = NpcDef.field3490.method4625(9, var0, -229405864);
			var2 = new NpcDef();
			var2.field3510 = var0;
			if (var3 != null) {
				var2.readValues(new Stream(var3));
			}

			var2.method5159();
			Custom.Npcs.parseNpcDef(var0, var2);
			NpcDef.field3488.method3983(var2, (long) var0);
			return var2;
		}
	}

	public static void method5156(String var0, boolean var1, boolean var2, int var3) {
		class58.method1053(var0, var1, "openjs", var2, (byte) 15);
	}
}
