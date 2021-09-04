package client;

import java.io.EOFException;

public class class82 {
	public static int field1179;
	static final String field1171 = "2";
	static final int field1172 = 1;
	static final int field1178 = 1;
	boolean field1176 = false;
	String[] field1170;
	int[] field1174;
	long field1177;
	boolean[] field1175;
	boolean[] field1173;

	class82() {
		this.field1174 = new int[class97.field1329.getFileCount(19)];
		this.field1170 = new String[class97.field1329.getFileCount(15)];
		this.field1175 = new boolean[this.field1174.length];

		int var1;
		for (var1 = 0; var1 < this.field1174.length; var1++) {
			class256 var2 = class21.method275(var1, -116299600);
			this.field1175[var1] = var2.field3256;
		}

		this.field1173 = new boolean[this.field1170.length];

		for (var1 = 0; var1 < this.field1170.length; var1++) {
			class257 var3 = class175.method3485(var1, -1879492666);
			this.field1173[var1] = var3.field3261;
		}

		for (var1 = 0; var1 < this.field1174.length; var1++) {
			this.field1174[var1] = -1;
		}

		this.method1887(-505500629);
	}

	class110 method1892(boolean var1, int var2) {
		return class22.method283("2", class112.field1455.field3144, var1, 1701266802);
	}

	boolean method1896(short var1) {
		return this.field1176;
	}

	void method1893(byte var1) {
		class110 var2 = this.method1892(true, -1191303198);

		try {
			int var3 = 3;
			int var4 = 0;

			int var5;
			for (var5 = 0; var5 < this.field1174.length; var5++) {
				if (var1 == 0) {
					return;
				}

				if (this.field1175[var5] && this.field1174[var5] != -1) {
					var3 += 6;
					++var4;
				}
			}

			var3 += 2;
			var5 = 0;

			for (int var6 = 0; var6 < this.field1170.length; var6++) {
				if (var1 == 0) {
					return;
				}

				if (this.field1173[var6]) {

					if (this.field1170[var6] != null) {

						var3 += 2 + class316.method5820(this.field1170[var6], (short) 256);
						++var5;
					}
				}
			}

			Stream var10 = new Stream(var3);
			var10.writeByte(1);
			var10.writeShort(var4);

			int var7;
			for (var7 = 0; var7 < this.field1174.length; var7++) {
				if (this.field1175[var7]) {
					if (var1 == 0) {
						return;
					}

					if (this.field1174[var7] != -1) {
						var10.writeShort(var7);
						var10.writeInt(this.field1174[var7]);
					}
				}
			}

			var10.writeShort(var5);

			for (var7 = 0; var7 < this.field1170.length; var7++) {
				if (this.field1173[var7] && this.field1170[var7] != null) {
					var10.writeShort(var7);
					var10.writeString(this.field1170[var7], -1020478938);
				}
			}

			var2.method2506(var10.field2338, 0, var10.field2339, -340873710);
		} catch (Exception var18) {
			;
		} finally {
			try {
				var2.method2507(746943081);
			} catch (Exception var17) {
				;
			}

		}

		this.field1176 = false;
		this.field1177 = Stream.method3547(604838575);
	}

	void method1887(int var1) {
		class110 var2 = this.method1892(false, 1701509936);

		try {
			byte[] var3 = new byte[(int) var2.method2509(-1632169843)];

			int var5;
			for (int var4 = 0; var4 < var3.length; var4 += var5) {
				var5 = var2.method2510(var3, var4, var3.length - var4, 1610759571);
				if (var5 == -1) {
					throw new EOFException();
				}
			}

			Stream var14 = new Stream(var3);
			if (var14.field2338.length - var14.field2339 < 1) {
				return;
			}

			int var15 = var14.readUByte();
			if (var15 < 0 || var15 > 1) {
				return;
			}

			int var16 = var14.readUShort();

			int var8;
			int var9;
			int var10;
			for (var8 = 0; var8 < var16; var8++) {
				var9 = var14.readUShort();
				var10 = var14.readInt();
				if (this.field1175[var9]) {
					this.field1174[var9] = var10;
				}
			}

			var8 = var14.readUShort();

			for (var9 = 0; var9 < var8; var9++) {
				var10 = var14.readUShort();
				String var11 = var14.readString();
				if (this.field1173[var10]) {
					this.field1170[var10] = var11;
				}
			}
		} catch (Exception var25) {
			;
		} finally {
			try {
				var2.method2507(746943081);
			} catch (Exception var24) {
				;
			}

		}

		this.field1176 = false;
	}

	void method1891(int var1) {
		int var2;
		for (var2 = 0; var2 < this.field1174.length; var2++) {
			if (!this.field1175[var2]) {
				this.field1174[var2] = -1;
			}
		}

		for (var2 = 0; var2 < this.field1170.length; var2++) {
			if (!this.field1173[var2]) {
				this.field1170[var2] = null;
			}
		}

	}

	String method1890(int var1, int var2) {
		return this.field1170[var1];
	}

	void method1902(int var1) {
		if (this.field1176 && this.field1177 < Stream.method3547(604838575) - 60000L) {
			this.method1893((byte) -46);
		}

	}

	int method1897(int var1, byte var2) {
		return this.field1174[var1];
	}

	void method1903(int var1, int var2, int var3) {
		this.field1174[var1] = var2;
		if (this.field1175[var1]) {
			this.field1176 = true;
		}

	}

	void method1889(int var1, String var2, int var3) {
		this.field1170[var1] = var2;
		if (this.field1173[var1]) {
			this.field1176 = true;
		}

	}

	static final void method1894(int var0) {
		if (class13.field82 != GameClient.field651) {
			if (var0 != 670209353) {
				return;
			}

			GameClient.field651 = class13.field82;
			int var1 = class13.field82;
			int[] var2 = Npc.field1038.pixels;
			int var3 = var2.length;

			int var4;
			for (var4 = 0; var4 < var3; var4++) {
				var2[var4] = 0;
			}

			int var5;
			int x;
			for (var4 = 1; var4 < 103; var4++) {
				var5 = (103 - var4) * 2048 + 24628;

				for (x = 1; x < 103; x++) {
					if ((class50.field443[var1][x][var4] & 24) == 0) {

						class28.field248.method2906(var2, var5, 512, var1, x, var4);
					}

					if (var1 < 3 && (class50.field443[var1 + 1][x][var4] & 8) != 0) {
						class28.field248.method2906(var2, var5, 512, var1 + 1, x, var4);
					}

					var5 += 4;
				}
			}

			var4 = (238 + (int) (Math.random() * 20.0D) - 10 << 16) + (238 + (int) (Math.random() * 20.0D) - 10 << 8) + (238 + (int) (Math.random() * 20.0D) - 10);
			var5 = 238 + (int) (Math.random() * 20.0D) - 10 << 16;
			Npc.field1038.method5850();

			int y;
			for (x = 1; x < 103; x++) {
				for (y = 1; y < 103; y++) {

					if ((class50.field443[var1][y][x] & 24) == 0) {
						class224.method4422(var1, y, x, var4, var5, -1148957073);
					}

					if (var1 < 3) {

						if ((class50.field443[var1 + 1][y][x] & 8) != 0) {
							class224.method4422(var1 + 1, y, x, var4, var5, 357213555);
						}
					}
				}
			}

			GameClient.mapIconCount = 0;

			for (x = 0; x < 104; x++) {
				for (y = 0; y < 104; y++) {
					long var8 = class28.field248.method2901(class13.field82, x, y);
					if (var8 != 0L) {
						int var10 = PacketBuilder.method673(var8);
						int var11 = class110.getObjectDef(var10).int700;
						if (var11 >= 0) {
							GameClient.mapIconImages[GameClient.mapIconCount] = class255.field3246[var11].method4815(false, (byte) -62);
							GameClient.mapIconTileX[GameClient.mapIconCount] = x;
							GameClient.mapIconTileY[GameClient.mapIconCount] = y;
							++GameClient.mapIconCount;
						}
					}

					int absX = class62.baseX + x;
					int absY = GameClient.baseY + y;

					if (absX == 3080 && absY == 3510) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.bloodMoneyIcon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}

					if (absX == 3083 && absY == 3507) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.donatorIcon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}

					if (absX == 3092 && absY == 3515) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.bankIcon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}

					if (absX == 3099 && absY == 3515) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.bankIcon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}

					if (absX == 3099 && absY == 3510) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.prayerIcon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}

					if (absX == 3099 && absY == 3510) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.prayerIcon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}

					if (absX == 3091 && absY == 3505) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.helpIcon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}

					if (absX == 3108 && absY == 3498) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.event_Icon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}

					if (absX == 3095 && absY == 3486) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.combatBagIcon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}

					if (absX == 3092 && absY == 3509) {
						GameClient.mapIconImages[GameClient.mapIconCount] = Custom.Icons.loyaltyIcon;
						GameClient.mapIconTileX[GameClient.mapIconCount] = x;
						GameClient.mapIconTileY[GameClient.mapIconCount] = y;
						GameClient.mapIconCount++;
					}
				}
			}

			class163.field2014.method5808((short) 8854);
		}

	}

	static void method1921(int var0, int var1, byte var2) {
		class172 var3 = class26.method433(OutgoingPacket.field2158, GameClient.field626.field1218, 511148297);
		var3.field2257.writeIntLE(var0);
		var3.field2257.writeShortA(var1);
		GameClient.field626.method1980(var3);
	}
}
