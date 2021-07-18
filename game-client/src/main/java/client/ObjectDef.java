package client;

public class ObjectDef extends class206 {

	public static boolean field3416 = false;
	static class200 field3371 = new class200(4096);
	public static class247 field3377;
	static class200 field3374 = new class200(30);
	static class200 field3370 = new class200(30);
	public static class200 field3391 = new class200(500);
	static class113[] field3375 = new class113[4];
	static class249 field3419;
	class197 iterableImpl1_4;
	int int707 = -1;
	public int int696 = -1;
	int[] models;
	int[] intArray117;
	public int[] intArray116;
	public int int709 = -1;
	int int708 = -1;
	public int int706 = -1;
	public String name = "null";
	public int field3376;
	public int[] intArray114;
	public int int700 = -1;
	public int int693 = 1;
	public int clipType = 2;
	boolean bool72 = false;
	public int int688 = 1;
	public boolean isUnwalkable = true;
	public int int710 = 0;
	public String[] options = new String[5];
	boolean bool71 = false;
	int int689 = -1;
	public int int711 = 0;
	public boolean bool68 = false;
	int int704 = 0;
	int int699 = 0;
	public int int712 = 0;
	boolean isSolid = false;
	public int int697 = -1;
	int int702 = 128;
	public int int698 = 16;
	int int703 = 128;
	int int705 = 0;
	public boolean bool69 = true;
	short[] recolorToFind;
	short[] shortArray21;
	int int692 = 128;
	short[] recolorToReplace;
	short[] shortArray18;
	public int int701 = -1;
	int int690 = 0;
	int int695 = 0;
	public boolean bool73 = false;

	public final ObjectDef method5056() {
		int var2 = -1;
		if (this.int707 != -1) {
			var2 = class163.method3389(this.int707, -397804509);
		} else if (this.int708 != -1) {
			var2 = class225.field2558[this.int708];
		}

		int var3;
		if (var2 >= 0 && var2 < this.intArray116.length - 1) {
			var3 = this.intArray116[var2];
		} else {
			var3 = this.intArray116[this.intArray116.length - 1];
		}

		return var3 != -1 ? class110.getObjectDef(var3) : null;
	}

	void method5070(Stream var1, int var2) {
		int var4;
		int var5;
		if (var2 == 1) {
			var4 = var1.readUByte();
			if (var4 > 0) {
				if (this.models != null && !field3416) {
					var1.field2339 += 3 * var4;
				} else {
					this.intArray117 = new int[var4];
					this.models = new int[var4];

					for (var5 = 0; var5 < var4; var5++) {
						this.models[var5] = var1.readUShort();
						this.intArray117[var5] = var1.readUByte();
					}
				}
			}
		} else if (var2 == 2) {
			this.name = var1.readString();
		} else if (var2 == 5) {
			var4 = var1.readUByte();
			if (var4 > 0) {

				if (this.models != null && !field3416) {
					var1.field2339 += 2 * var4;
				} else {
					this.intArray117 = null;
					this.models = new int[var4];

					for (var5 = 0; var5 < var4; var5++) {
						this.models[var5] = var1.readUShort();
					}
				}
			}
		} else if (var2 == 14) {
			this.int693 = var1.readUByte();
		} else if (var2 == 15) {
			this.int688 = var1.readUByte();
		} else if (var2 == 17) {
			this.clipType = 0;
			this.isUnwalkable = false;
		} else if (var2 == 18) {
			this.isUnwalkable = false;
		} else if (var2 == 19) {
			this.int696 = var1.readUByte();
		} else if (var2 == 21) {
			this.int689 = 0;
		} else if (var2 == 22) {
			this.bool71 = true;
		} else if (var2 == 23) {
			this.bool68 = true;
		} else if (var2 == 24) {
			this.int697 = var1.readUShort();
			if (this.int697 == 65535) {
				this.int697 = -1;
			}
		} else if (var2 == 27) {
			this.clipType = 1;
		} else if (var2 == 28) {
			this.int698 = var1.readUByte();
		} else if (var2 == 29) {
			this.int704 = var1.readByte();
		} else if (var2 == 39) {
			this.int699 = var1.readByte() * 25;
		} else if (var2 >= 30 && var2 < 35) {
			this.options[var2 - 30] = var1.readString();
			if (this.options[var2 - 30].equalsIgnoreCase("Hidden")) {

				this.options[var2 - 30] = null;
			}
		} else if (var2 == 40) {

			var4 = var1.readUByte();
			this.recolorToFind = new short[var4];
			this.recolorToReplace = new short[var4];

			for (var5 = 0; var5 < var4; var5++) {
				this.recolorToFind[var5] = (short) var1.readUShort();
				this.recolorToReplace[var5] = (short) var1.readUShort();
			}
		} else if (var2 == 41) {
			var4 = var1.readUByte();
			this.shortArray21 = new short[var4];
			this.shortArray18 = new short[var4];

			for (var5 = 0; var5 < var4; var5++) {
				this.shortArray21[var5] = (short) var1.readUShort();
				this.shortArray18[var5] = (short) var1.readUShort();
			}
		} else if (var2 == 62) {
			this.bool72 = true;
		} else if (var2 == 64) {
			this.bool69 = false;
		} else if (var2 == 65) {
			this.int702 = var1.readUShort();
		} else if (var2 == 66) {

			this.int703 = var1.readUShort();
		} else if (var2 == 67) {
			this.int692 = var1.readUShort();
		} else if (var2 == 68) {

			this.int701 = var1.readUShort();
		} else if (var2 == 69) {

			var1.readUByte();
		} else if (var2 == 70) {
			this.int705 = var1.readShort();
		} else if (var2 == 71) {
			this.int690 = var1.readShort();
		} else if (var2 == 72) {
			this.int695 = var1.readShort();
		} else if (var2 == 73) {
			this.bool73 = true;
		} else if (var2 == 74) {
			this.isSolid = true;
		} else if (var2 == 75) {
			this.int706 = var1.readUByte();
		} else if (var2 != 77 && var2 != 92) {
			if (var2 == 78) {
				this.int709 = var1.readUShort();
				this.int710 = var1.readUByte();
			} else if (var2 == 79) {
				this.int711 = var1.readUShort();
				this.int712 = var1.readUShort();
				this.int710 = var1.readUByte();
				var4 = var1.readUByte();
				this.intArray114 = new int[var4];

				for (var5 = 0; var5 < var4; var5++) {
					this.intArray114[var5] = var1.readUShort();
				}
			} else if (var2 == 81) {
				this.int689 = var1.readUByte() * 256;
			} else if (var2 == 82) {
				this.int700 = var1.readUShort();
			} else if (var2 == 249) {
				this.iterableImpl1_4 = PacketBuilder.method691(var1, this.iterableImpl1_4);
			}
		} else {
			this.int707 = var1.readUShort();
			if (this.int707 == 65535) {
				this.int707 = -1;
			}

			this.int708 = var1.readUShort();
			if (this.int708 == 65535) {

				this.int708 = -1;
			}

			var4 = -1;
			if (var2 == 92) {
				var4 = var1.readUShort();
				if (var4 == 65535) {

					var4 = -1;
				}
			}

			var5 = var1.readUByte();
			this.intArray116 = new int[var5 + 2];

			for (int var6 = 0; var6 <= var5; var6++) {
				this.intArray116[var6] = var1.readUShort();
				if (this.intArray116[var6] == 65535) {
					this.intArray116[var6] = -1;
				}
			}

			this.intArray116[var5 + 1] = var4;
		}

	}

	final class113 method5033(int var1, int var2, short var3) {
		class113 var4 = null;
		boolean var5;
		int var6;
		int var8;
		if (this.intArray117 == null) {
			if (var1 != 10) {
				return null;
			}

			if (this.models == null) {
				return null;
			}

			var5 = this.bool72;
			if (var1 == 2 && var2 > 3) {
				var5 = !var5;
			}

			var6 = this.models.length;

			for (int var7 = 0; var7 < var6; var7++) {
				var8 = this.models[var7];
				if (var5) {
					var8 += 65536;
				}

				var4 = (class113) field3391.method3989((long) var8);
				if (var4 == null) {
					var4 = class113.method2568(class130.field1801, var8 & 65535, 0);
					if (var4 == null) {
						return null;
					}

					if (var5) {
						var4.method2583();
					}

					field3391.method3983(var4, (long) var8);
				}

				if (var6 > 1) {
					field3375[var7] = var4;
				}
			}

			if (var6 > 1) {
				var4 = new class113(field3375, var6);
			}
		} else {
			int var10 = -1;

			for (var6 = 0; var6 < this.intArray117.length; var6++) {
				if (this.intArray117[var6] == var1) {
					var10 = var6;
					break;
				}
			}

			if (var10 == -1) {
				return null;
			}

			var6 = this.models[var10];
			boolean var11 = this.bool72 ^ var2 > 3;
			if (var11) {
				var6 += 65536;
			}

			var4 = (class113) field3391.method3989((long) var6);
			if (var4 == null) {
				var4 = class113.method2568(class130.field1801, var6 & 65535, 0);
				if (var4 == null) {
					return null;
				}

				if (var11) {
					var4.method2583();
				}

				field3391.method3983(var4, (long) var6);
			}
		}

		if (this.int702 == 128 && this.int703 == 128 && this.int692 == 128) {
			var5 = false;
		} else {
			var5 = true;
		}

		boolean var12;
		if (this.int705 == 0 && this.int690 == 0 && this.int695 == 0) {
			var12 = false;
		} else {
			var12 = true;
		}

		class113 var9 = new class113(var4, var2 == 0 && !var5 && !var12, this.recolorToFind == null, this.shortArray21 == null, true);
		if (var1 == 4 && var2 > 3) {
			var9.method2653(256);
			var9.method2580(45, 0, -45);
		}

		var2 &= 3;
		if (var2 == 1) {
			var9.method2576();
		} else if (var2 == 2) {
			var9.method2573();
		} else if (var2 == 3) {
			var9.method2578();
		}

		if (this.recolorToFind != null) {
			for (var8 = 0; var8 < this.recolorToFind.length; var8++) {
				var9.method2581(this.recolorToFind[var8], this.recolorToReplace[var8]);
			}
		}

		if (this.shortArray21 != null) {
			for (var8 = 0; var8 < this.shortArray21.length; var8++) {
				var9.method2582(this.shortArray21[var8], this.shortArray18[var8]);
			}
		}

		if (var5) {
			var9.method2592(this.int702, this.int703, this.int692);
		}

		if (var12) {
			var9.method2580(this.int705, this.int690, this.int695);
		}

		return var9;
	}

	void method5025(int var1) {
		if (this.int696 == -1) {
			this.int696 = 0;
			if (this.models != null) {
				label57:
				{
					if (this.intArray117 != null) {
						if (this.intArray117[0] != 10) {
							break label57;
						}

						if (var1 != 936618965) {
							return;
						}
					}

					this.int696 = 1;
				}
			}

			for (int var2 = 0; var2 < 5; var2++) {
				if (var1 != 936618965) {
					return;
				}

				if (this.options[var2] != null) {
					this.int696 = 1;
				}
			}
		}

		if (this.int706 == -1) {
			this.int706 = this.clipType != 0 ? 1 : 0;
		}

	}

	void method5026(Stream var1, int var2) {
		while (true) {
			int var3 = var1.readUByte();
			if (var3 == 0) {
				return;
			}

			this.method5070(var1, var3);
		}
	}

	public final class119 method5032(int var1, int var2, int[][] var3, int var4, int var5, int var6, class273 var7, int var8, int var9) {
		long var10;
		if (this.intArray117 == null) {
			var10 = (long) (var2 + (this.field3376 << 10));
		} else {
			var10 = (long) (var2 + (var1 << 3) + (this.field3376 << 10));
		}

		class119 var12 = (class119) field3374.method3989(var10);
		if (var12 == null) {
			class113 var13 = this.method5033(var1, var2, (short) 1337);
			if (var13 == null) {
				return null;
			}

			var12 = var13.method2589(this.int704 + 64, this.int699 + 768, -50, -10, -50);
			field3374.method3983(var12, var10);
		}

		if (var7 == null && this.int689 == -1) {
			return var12;
		} else {
			if (var7 != null) {
				var12 = var7.method5216(var12, var8, var2, 416381559);
			} else {
				var12 = var12.method2666(true);
			}

			if (this.int689 >= 0) {
				var12 = var12.method2665(var3, var4, var5, var6, false, this.int689);
			}

			return var12;
		}
	}

	public final boolean method5048(int var1, int var2) {
		if (this.intArray117 != null) {
			for (int var5 = 0; var5 < this.intArray117.length; var5++) {
				if (this.intArray117[var5] == var1) {
					return class130.field1801.method4696(this.models[var5] & 65535, 0, (byte) 1);
				}
			}

			return true;
		} else if (this.models == null) {
			return true;
		} else if (var1 != 10) {
			return true;
		} else {
			boolean var3 = true;

			for (int var4 = 0; var4 < this.models.length; var4++) {
				var3 &= class130.field1801.method4696(this.models[var4] & 65535, 0, (byte) 1);
			}

			return var3;
		}
	}

	public final class119 method5031(int var1, int var2, int[][] var3, int var4, int var5, int var6, byte var7) {
		long var8;
		if (this.intArray117 == null) {
			var8 = (long) (var2 + (this.field3376 << 10));
		} else {
			var8 = (long) (var2 + (var1 << 3) + (this.field3376 << 10));
		}

		class119 var10 = (class119) field3374.method3989(var8);
		if (var10 == null) {
			class113 var11 = this.method5033(var1, var2, (short) 1337);
			if (var11 == null) {
				return null;
			}

			var10 = var11.method2589(this.int704 + 64, this.int699 + 768, -50, -10, -50);
			field3374.method3983(var10, var8);
		}

		if (this.int689 >= 0) {
			var10 = var10.method2665(var3, var4, var5, var6, true, this.int689);
		}

		return var10;
	}

	public final boolean method5051(int var1) {
		if (this.models == null) {
			return true;
		} else {
			boolean var2 = true;

			for (int var3 = 0; var3 < this.models.length; var3++) {
				var2 &= class130.field1801.method4696(this.models[var3] & 65535, 0, (byte) 1);
			}

			return var2;
		}
	}

	public boolean method5024(int var1) {
		if (this.intArray116 == null) {
			return this.int709 != -1 || this.intArray114 != null;
		} else {
			for (int var2 = 0; var2 < this.intArray116.length; var2++) {
				if (this.intArray116[var2] != -1) {
					ObjectDef var3 = class110.getObjectDef(this.intArray116[var2]);
					if (var3.int709 != -1 || var3.intArray114 != null) {
						return true;
					}
				}
			}

			return false;
		}
	}

	public final class127 method5079(int var1, int var2, int[][] var3, int var4, int var5, int var6, int var7) {
		long var8;
		if (this.intArray117 == null) {
			var8 = (long) (var2 + (this.field3376 << 10));
		} else {
			var8 = (long) (var2 + (var1 << 3) + (this.field3376 << 10));
		}

		Object var10 = (class127) field3370.method3989(var8);
		if (var10 == null) {
			class113 var11 = this.method5033(var1, var2, (short) 1337);
			if (var11 == null) {
				return null;
			}

			if (!this.bool71) {
				var10 = var11.method2589(this.int704 + 64, this.int699 + 768, -50, -10, -50);
			} else {
				var11.field1486 = (short) (this.int704 + 64);
				var11.field1487 = (short) (this.int699 + 768);
				var11.method2585();
				var10 = var11;
			}

			field3370.method3983((class206) var10, var8);
		}

		if (this.bool71) {
			var10 = ((class113) var10).method2650();
		}

		if (this.int689 >= 0) {
			if (var10 instanceof class119) {
				var10 = ((class119) var10).method2665(var3, var4, var5, var6, true, this.int689);
			} else if (var10 instanceof class113) {
				var10 = ((class113) var10).method2567(var3, var4, var5, var6, true, this.int689);
			}
		}

		return (class127) var10;
	}

	public int method5035(int var1, int var2, byte var3) {
		return class67.method1668(this.iterableImpl1_4, var1, var2, (short) -3313);
	}

	public String method5036(int var1, String var2, int var3) {
		return class17.method171(this.iterableImpl1_4, var1, var2, (short) 255);
	}

	static void method5084(byte[] var0, byte var1) {
		Stream var2 = new Stream(var0);
		var2.field2339 = var0.length - 2;
		class319.field3802 = var2.readUShort();
		class7.field45 = new int[class319.field3802];
		class225.field2562 = new int[class319.field3802];
		class319.field3800 = new int[class319.field3802];
		class319.field3799 = new int[class319.field3802];
		class319.field3801 = new byte[class319.field3802][];
		var2.field2339 = var0.length - 7 - class319.field3802 * 8;
		class305.field3729 = var2.readUShort();
		class319.field3798 = var2.readUShort();
		int var3 = (var2.readUByte() & 255) + 1;

		int var4;
		for (var4 = 0; var4 < class319.field3802; var4++) {
			class7.field45[var4] = var2.readUShort();
		}

		for (var4 = 0; var4 < class319.field3802; var4++) {
			class225.field2562[var4] = var2.readUShort();
		}

		for (var4 = 0; var4 < class319.field3802; var4++) {
			class319.field3800[var4] = var2.readUShort();
		}

		for (var4 = 0; var4 < class319.field3802; var4++) {
			class319.field3799[var4] = var2.readUShort();
		}

		var2.field2339 = var0.length - 7 - class319.field3802 * 8 - (var3 - 1) * 3;
		class172.field2260 = new int[var3];

		for (var4 = 1; var4 < var3; var4++) {
			if (var1 <= -97) {
				return;
			}

			class172.field2260[var4] = var2.readMedium();
			if (class172.field2260[var4] == 0) {

				class172.field2260[var4] = 1;
			}
		}

		var2.field2339 = 0;

		for (var4 = 0; var4 < class319.field3802; var4++) {
			if (var1 <= -97) {
				return;
			}

			int var5 = class319.field3800[var4];
			int var6 = class319.field3799[var4];
			int var7 = var5 * var6;
			byte[] var8 = new byte[var7];
			class319.field3801[var4] = var8;
			int var9 = var2.readUByte();
			int var10;
			if (var9 == 0) {

				for (var10 = 0; var10 < var7; var10++) {
					var8[var10] = var2.readByte();
				}
			} else if (var9 == 1) {

				for (var10 = 0; var10 < var5; var10++) {
					for (int var11 = 0; var11 < var6; var11++) {
						var8[var10 + var11 * var5] = var2.readByte();
					}
				}
			}
		}

	}

	static final void method5085(int var0) {
		for (int var1 = 0; var1 < GameClient.field656; var1++) {
			if (var0 >= -652315077) {
				return;
			}

			--GameClient.field819[var1];
			if (GameClient.field819[var1] >= -10) {
				class91 var10 = GameClient.field719[var1];
				if (var10 == null) {
					Object var10000 = null;
					var10 = class91.method2071(class135.field1852, GameClient.field817[var1], 0);
					if (var10 == null) {
						continue;
					}

					GameClient.field819[var1] += var10.method2070();
					GameClient.field719[var1] = var10;
				}

				if (GameClient.field819[var1] < 0) {
					int var3;
					if (GameClient.field820[var1] != 0) {

						int var4 = (GameClient.field820[var1] & 255) * 128;
						int var5 = GameClient.field820[var1] >> 16 & 255;
						int var6 = var5 * 128 + 64 - class138.field1876.field931;
						if (var6 < 0) {
							var6 = -var6;
						}

						int var7 = GameClient.field820[var1] >> 8 & 255;
						int var8 = var7 * 128 + 64 - class138.field1876.field881;
						if (var8 < 0) {
							var8 = -var8;
						}

						int var9 = var8 + var6 - 128;
						if (var9 > var4) {

							GameClient.field819[var1] = -100;
							continue;
						}

						if (var9 < 0) {
							var9 = 0;
						}

						var3 = (var4 - var9) * GameClient.field815 / var4;
					} else {
						var3 = GameClient.field814;
					}

					if (var3 > 0) {
						class93 var11 = var10.method2069().method2115(class61.field577);
						class103 var12 = class103.method2287(var11, 100, var3);
						var12.method2258(GameClient.field676[var1] - 1);
						class36.field310.method2032(var12);
					}

					GameClient.field819[var1] = -100;
				}
			} else {
				--GameClient.field656;

				for (int var2 = var1; var2 < GameClient.field656; var2++) {
					GameClient.field817[var2] = GameClient.field817[var2 + 1];
					GameClient.field719[var2] = GameClient.field719[var2 + 1];
					GameClient.field676[var2] = GameClient.field676[var2 + 1];
					GameClient.field819[var2] = GameClient.field819[var2 + 1];
					GameClient.field820[var2] = GameClient.field820[var2 + 1];
				}

				--var1;
			}
		}

		if (GameClient.field813) {
			if (var0 >= -652315077) {
				return;
			}

			boolean var13;
			if (class217.field2460 != 0) {
				var13 = true;
			} else {
				var13 = class217.field2459.method4203(161064097);
			}

			if (!var13) {
				if (GameClient.field811 != 0 && GameClient.field812 != -1) {
					class63.method1554(Item.field1147, GameClient.field812, 0, GameClient.field811, false, (short) -23312);
				}

				GameClient.field813 = false;
			}
		}

	}
}
