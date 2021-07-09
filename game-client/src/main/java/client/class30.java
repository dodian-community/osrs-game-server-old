package client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class class30 {
	static final int field263 = 7;
	static final int field275 = 58;
	static final int field277 = 41;
	public static final int field280 = 64;
	boolean field264 = false;
	Sprite field266;
	boolean field272 = false;
	HashMap field267;
	class23[][] field268;
	int field273;
	public int field276 = 0;
	int field278;
	HashMap field269 = new HashMap();
	PaletteSprite[] field279;
	final HashMap field271;
	class33 field265;
	int field274;
	int field270;

	public class30(PaletteSprite[] var1, HashMap var2) {
		this.field279 = var1;
		this.field271 = var2;
	}

	void method505(byte var1) {
		if (this.field267 == null) {
			this.field267 = new HashMap();
		}

		this.field267.clear();

		for (int var2 = 0; var2 < this.field268.length; var2++) {
			for (int var3 = 0; var3 < this.field268[var2].length; var3++) {
				if (var1 <= 0) {
					return;
				}

				List var4 = this.field268[var2][var3].method356((byte) 23);
				Iterator var5 = var4.iterator();

				while (var5.hasNext()) {
					if (var1 <= 0) {
						return;
					}

					class28 var6 = (class28) var5.next();
					if (!this.field267.containsKey(Integer.valueOf(var6.field240))) {
						if (var1 <= 0) {
							return;
						}

						LinkedList var7 = new LinkedList();
						var7.add(var6);
						this.field267.put(Integer.valueOf(var6.field240), var7);
					} else {
						List var8 = (List) this.field267.get(Integer.valueOf(var6.field240));
						var8.add(var6);
					}
				}
			}
		}

	}

	class17 method518(int var1, int var2, int var3, int var4, short var5) {
		class17 var6 = new class17(this);
		int var7 = this.field273 + var1;
		int var8 = var2 + this.field278;
		int var9 = var3 + this.field273;
		int var10 = var4 + this.field278;
		int var11 = var7 / 64;
		int var12 = var8 / 64;
		int var13 = var9 / 64;
		int var14 = var10 / 64;
		var6.field131 = var13 - var11 + 1;
		var6.field133 = var14 - var12 + 1;
		var6.field132 = var11 - this.field265.method258(1176139709);
		var6.field134 = var12 - this.field265.method247(1635586480);
		if (var6.field132 < 0) {
			var6.field131 += var6.field132;
			var6.field132 = 0;
		}

		if (var6.field132 > this.field268.length - var6.field131) {
			var6.field131 = this.field268.length - var6.field132;
		}

		if (var6.field134 < 0) {
			var6.field133 += var6.field134;
			var6.field134 = 0;
		}

		if (var6.field134 > this.field268[0].length - var6.field133) {
			var6.field133 = this.field268[0].length - var6.field134;
		}

		var6.field131 = Math.min(var6.field131, this.field268.length);
		var6.field133 = Math.min(var6.field133, this.field268[0].length);
		return var6;
	}

	float method492(int var1, int var2, int var3) {
		float var4 = (float) var1 / (float) var2;
		if (var4 > 8.0F) {
			return 8.0F;
		} else if (var4 < 1.0F) {
			return 1.0F;
		} else {
			int var5 = Math.round(var4);
			return Math.abs((float) var5 - var4) < 0.05F ? (float) var5 : var4;
		}
	}

	public boolean method513(int var1) {
		return this.field272;
	}

	public HashMap method489(byte var1) {
		this.method505((byte) 126);
		return this.field267;
	}

	public void method486(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7, int var8) {
		if (this.field266 != null) {
			this.field266.method5853(var1, var2, var3, var4);
			if (var6 > 0) {
				if (var6 % var7 < var7 / 2) {
					if (this.field267 == null) {
						if (var8 <= 1959700419) {
							return;
						}

						this.method505((byte) 21);
					}

					Iterator var9 = var5.iterator();

					while (true) {
						List var11;
						do {
							if (!var9.hasNext()) {
								return;
							}

							int var10 = ((Integer) var9.next()).intValue();
							var11 = (List) this.field267.get(Integer.valueOf(var10));
						} while (var11 == null);

						Iterator var12 = var11.iterator();

						while (var12.hasNext()) {
							class28 var13 = (class28) var12.next();
							int var14 = var3 * (var13.field236.field2564 - this.field273) / this.field274;
							int var15 = var4 - (var13.field236.field2565 - this.field278) * var4 / this.field270;
							Rasterizer2D.method5784(var14 + var1, var15 + var2, 2, 16776960, 256);
						}
					}
				}

				if (var8 <= 1959700419) {
					return;
				}
			}

		}
	}

	public void method490(class247 var1, String var2, boolean var3, byte var4) {
		if (this.field264) {
			if (var4 == 2) {
				;
			}
		} else {
			this.field272 = false;
			this.field264 = true;
			System.nanoTime();
			int var5 = var1.method4642(class29.field252.field255, -1611714600);
			int var6 = var1.method4643(var5, var2, -981702486);
			Stream var7 = new Stream(var1.method4684(class29.field252.field255, var2, 222409025));
			Stream var8 = new Stream(var1.method4684(class29.field251.field255, var2, 222409025));
			Stream var9 = new Stream(var1.method4684(var2, class29.field262.field255, 222409025));
			System.nanoTime();
			System.nanoTime();
			this.field265 = new class33();

			try {
				this.field265.method550(var7, var9, var8, var6, var3, (byte) -46);
			} catch (IllegalStateException var21) {
				return;
			}

			this.field265.method217(-1739238392);
			this.field265.method218(233978289);
			this.field265.method219((byte) -81);
			this.field273 = this.field265.method258(1646004263) * 64;
			this.field278 = this.field265.method247(964242028) * 64;
			this.field274 = (this.field265.method214(-847859884) - this.field265.method258(164190187) + 1) * 64;
			this.field270 = (this.field265.method249(90833897) - this.field265.method247(1289192364) + 1) * 64;
			int var18 = this.field265.method214(-853178698) - this.field265.method258(1807714075) + 1;
			int var11 = this.field265.method249(-942254353) - this.field265.method247(1848978253) + 1;
			System.nanoTime();
			System.nanoTime();
			class23.field188.method4006();
			class23.field189.method4006();
			this.field268 = new class23[var18][var11];
			Iterator var12 = this.field265.field292.iterator();

			while (var12.hasNext()) {
				if (var4 != 2) {
					return;
				}

				class10 var13 = (class10) var12.next();
				int var14 = var13.field127;
				int var15 = var13.field117;
				int var16 = var14 - this.field265.method258(176348281);
				int var17 = var15 - this.field265.method247(169162322);
				this.field268[var16][var17] = new class23(var14, var15, this.field265.method211((byte) 93), this.field271);
				this.field268[var16][var17].method400(var13, this.field265.field290, -463048404);
			}

			for (int var19 = 0; var19 < var18; var19++) {
				for (int var20 = 0; var20 < var11; var20++) {
					if (this.field268[var19][var20] == null) {
						this.field268[var19][var20] = new class23(this.field265.method258(968442899) + var19, this.field265.method247(-306312645) + var20, this.field265.method211((byte) 118), this.field271);
						this.field268[var19][var20].method287(this.field265.field291, this.field265.field290, (byte) 89);
					}
				}
			}

			System.nanoTime();
			System.nanoTime();
			if (var1.method4644(class29.field257.field255, var2, (byte) 69)) {
				byte[] var22 = var1.method4684(class29.field257.field255, var2, 222409025);
				this.field266 = class284.method5324(var22, -1244396241);
			}

			System.nanoTime();
			var1.method4702((byte) 59);
			var1.method4640(-2070293854);
			this.field272 = true;
		}
	}

	public List method487(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
		LinkedList var12 = new LinkedList();
		if (!this.field272) {
			return var12;
		} else {
			class17 var13 = this.method518(var1, var2, var3, var4, (short) 1596);
			float var14 = this.method492(var7, var3 - var1, -168004314);
			int var15 = (int) (64.0F * var14);
			int var16 = this.field273 + var1;
			int var17 = var2 + this.field278;

			for (int var18 = var13.field132; var18 < var13.field132 + var13.field131; var18++) {
				for (int var19 = var13.field134; var19 < var13.field134 + var13.field133; var19++) {
					List var20 = this.field268[var18][var19].method319(var5 + var15 * (this.field268[var18][var19].field191 * 64 - var16) / 64, var8 + var6 - var15 * (this.field268[var18][var19].field192 * 64 - var17 + 64) / 64, var15, var9, var10, -1031458872);
					if (!var20.isEmpty()) {
						var12.addAll(var20);
					}
				}
			}

			return var12;
		}
	}

	public final void method482(byte var1) {
		this.field267 = null;
	}

	void method485(int var1, int var2, class23[] var3, int var4) {
		boolean var5 = var1 <= 0;
		boolean var6 = var1 >= this.field268.length - 1;
		boolean var7 = var2 <= 0;
		boolean var8 = var2 >= this.field268[0].length - 1;
		if (var8) {
			var3[class240.field3101.vmethod5815((byte) 46)] = null;
		} else {
			var3[class240.field3101.vmethod5815((byte) 113)] = this.field268[var1][var2 + 1];
		}

		int var10001;
		class23 var10002;
		label100:
		{
			var10001 = class240.field3107.vmethod5815((byte) 45);
			if (!var8) {
				if (var4 == -1824094824) {
					return;
				}

				if (!var6) {
					var10002 = this.field268[var1 + 1][var2 + 1];
					break label100;
				}
			}

			var10002 = null;
		}

		label88:
		{
			var3[var10001] = var10002;
			var3[class240.field3103.vmethod5815((byte) 91)] = !var8 && !var5 ? this.field268[var1 - 1][var2 + 1] : null;
			var3[class240.field3097.vmethod5815((byte) 67)] = var6 ? null : this.field268[var1 + 1][var2];
			var3[class240.field3102.vmethod5815((byte) 98)] = var5 ? null : this.field268[var1 - 1][var2];
			var3[class240.field3100.vmethod5815((byte) 97)] = var7 ? null : this.field268[var1][var2 - 1];
			var10001 = class240.field3099.vmethod5815((byte) 35);
			if (!var7) {
				if (var4 == -1824094824) {
					return;
				}

				if (!var6) {
					var10002 = this.field268[var1 + 1][var2 - 1];
					break label88;
				}
			}

			var10002 = null;
		}

		label82:
		{
			var3[var10001] = var10002;
			var10001 = class240.field3098.vmethod5815((byte) 112);
			if (!var7) {
				if (!var5) {
					var10002 = this.field268[var1 - 1][var2 - 1];
					break label82;
				}

				if (var4 == -1824094824) {
					return;
				}
			}

			var10002 = null;
		}

		var3[var10001] = var10002;
	}

	public final void method483(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, byte var9) {
		int[] var10 = Rasterizer2D.field3766;
		int var11 = Rasterizer2D.field3761;
		int var12 = Rasterizer2D.field3762;
		int[] var13 = new int[4];
		Rasterizer2D.method5722(var13);
		class17 var14 = this.method518(var1, var2, var3, var4, (short) 80);
		float var15 = this.method492(var7 - var5, var3 - var1, 1001406942);
		int var16 = (int) Math.ceil((double) var15);
		this.field276 = var16;
		if (!this.field269.containsKey(Integer.valueOf(var16))) {
			class35 var17 = new class35(var16);
			var17.method592(1956759512);
			this.field269.put(Integer.valueOf(var16), var17);
		}

		class23[] var23 = new class23[8];

		int var18;
		int var19;
		for (var18 = var14.field132; var18 < var14.field132 + var14.field131; var18++) {
			for (var19 = var14.field134; var19 < var14.field134 + var14.field133; var19++) {
				this.method485(var18, var19, var23, 1440038510);
				this.field268[var18][var19].method290(var16, (class35) this.field269.get(Integer.valueOf(var16)), var23, this.field279, 2109575831);
			}
		}

		Rasterizer2D.method5718(var10, var11, var12);
		Rasterizer2D.method5723(var13);
		var18 = (int) (64.0F * var15);
		var19 = this.field273 + var1;
		int var20 = var2 + this.field278;

		for (int var21 = var14.field132; var21 < var14.field131 + var14.field132; var21++) {
			for (int var22 = var14.field134; var22 < var14.field133 + var14.field134; var22++) {
				this.field268[var21][var22].method314(var5 + var18 * (this.field268[var21][var22].field191 * 64 - var19) / 64, var8 - var18 * (this.field268[var21][var22].field192 * 64 - var20 + 64) / 64, var18, (short) -4430);
			}
		}

	}

	public final void method491(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13, int var14) {
		class17 var15 = this.method518(var1, var2, var3, var4, (short) -2238);
		float var16 = this.method492(var7 - var5, var3 - var1, -606690245);
		int var17 = (int) (var16 * 64.0F);
		int var18 = this.field273 + var1;
		int var19 = var2 + this.field278;

		int var20;
		int var21;
		for (var20 = var15.field132; var20 < var15.field132 + var15.field131; var20++) {
			for (var21 = var15.field134; var21 < var15.field134 + var15.field133; var21++) {
				if (var13) {
					this.field268[var20][var21].method340((byte) 3);
				}

				this.field268[var20][var21].method382(var5 + var17 * (this.field268[var20][var21].field191 * 64 - var18) / 64, var8 - var17 * (this.field268[var20][var21].field192 * 64 - var19 + 64) / 64, var17, var9, 1346650712);
			}
		}

		if (var10 != null && var11 > 0) {
			for (var20 = var15.field132; var20 < var15.field132 + var15.field131; var20++) {
				for (var21 = var15.field134; var21 < var15.field133 + var15.field134; var21++) {
					this.field268[var20][var21].method311(var10, var11, var12, 476011751);
				}
			}
		}

	}

	static final void method516(int var0) {
		if (GameClient.field627 > 0) {
			class97.method2213(1818249317);
		} else {
			GameClient.field804.method5262((byte) -92);
			class48.method947(40, -639022917);
			class62.field869 = GameClient.field626.method1983(1579058525);
			GameClient.field626.method1984((byte) 1);
		}
	}

	static void method484(byte var0) {
		GameClient.field626.method1978((byte) -94);
		GameClient.field626.field1219.field2339 = 0;
		GameClient.field626.packetType = null;
		GameClient.field626.field1215 = null;
		GameClient.field626.field1226 = null;
		GameClient.field626.field1227 = null;
		GameClient.field626.field1225 = 0;
		GameClient.field626.field1228 = 0;
		GameClient.field598 = 0;
		GameClient.field771 = 0;
		GameClient.field716 = false;
		GameClient.field810 = 0;
		GameClient.field808 = 0;

		int var1;
		for (var1 = 0; var1 < 2048; var1++) {
			GameClient.field610[var1] = null;
		}

		class138.field1876 = null;

		for (var1 = 0; var1 < GameClient.field843.length; var1++) {
			Npc var2 = GameClient.field843[var1];
			if (var2 != null) {
				var2.field897 = -1;
				var2.field898 = false;
			}
		}

		class53.field474 = new class202(32);
		class48.method947(30, -144622138);

		for (var1 = 0; var1 < 100; var1++) {
			GameClient.staticBoolArray6[var1] = true;
		}

		class172 var4 = class26.method433(OutgoingPacket.field2215, GameClient.field626.field1218, 1069639834);
		PacketBuffer var5 = var4.field2257;
		int var3 = GameClient.field792 ? 2 : 1;
		var5.writeByte(var3);
		var4.field2257.writeShort(class82.field1179);
		var4.field2257.writeShort(class243.field3138);
		GameClient.field626.method1980(var4, (byte) 1);
	}

	static final void method500(boolean var0, PacketBuffer buffer, int var2) {
		while (true) {
			if (buffer.method3825(GameClient.field626.field1225, 16711935) >= 27) {
				int var3 = buffer.readBits(15);
				if (var3 != 32767) {
					boolean var4 = false;
					if (GameClient.field843[var3] == null) {
						GameClient.field843[var3] = new Npc();
						var4 = true;
					}

					Npc var5 = GameClient.field843[var3];
					GameClient.field639[++GameClient.field622 - 1] = var3;
					var5.field914 = GameClient.field591;
					int var6;
					if (var0) {
						if (var2 == 604912619) {
							return;
						}

						var6 = buffer.readBits(8);
						if (var6 > 127) {
							if (var2 == 604912619) {
								return;
							}

							var6 -= 256;
						}
					} else {
						var6 = buffer.readBits(5);
						if (var6 > 15) {
							var6 -= 32;
						}
					}

					int var7 = GameClient.field706[buffer.readBits(3)];
					if (var4) {
						if (var2 == 604912619) {
							return;
						}

						var5.field905 = var7;
						var5.field926 = var7;
					}

					int var8 = buffer.readBits(1);
					int var9;
					if (var0) {
						var9 = buffer.readBits(8);
						if (var9 > 127) {
							var9 -= 256;
						}
					} else {
						var9 = buffer.readBits(5);
						if (var9 > 15) {
							var9 -= 32;
						}
					}

					var5.definition = class270.loadNpcDef(buffer.readBits(14));
					System.out.printf("Add npc '%s' at index %d on tile %d, %d (relative)%n", var5.definition.name, var3, var6, var9);
					int var10 = buffer.readBits(1);
					if (var10 == 1) {
						GameClient.field666[++GameClient.field624 - 1] = var3;
					}

					var5.field874 = var5.definition.size;
					var5.field924 = var5.definition.turnValue;
					if (var5.field924 == 0) {
						if (var2 == 604912619) {
							return;
						}

						var5.field905 = 0;
					}

					var5.field899 = var5.definition.walkAnimation;
					var5.field880 = var5.definition.turn180Animation;
					var5.field870 = var5.definition.turn90CWAnimation;
					var5.field882 = var5.definition.turn90CCAnimation;
					var5.field893 = var5.definition.idleAnimation;
					var5.field877 = var5.definition.op15;
					var5.field878 = var5.definition.op16;
					var5.method1788(class138.field1876.field922[0] + var6, class138.field1876.field872[0] + var9, var8 == 1, 1896882090);
					continue;
				}
			}

			buffer.endBitMode();
			return;
		}
	}

	static final int method519(int var0, int var1, int var2) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}
}
