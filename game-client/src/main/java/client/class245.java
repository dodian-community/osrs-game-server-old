package client;

public class class245 extends class204 {
	static int field3154;
	static final int field3148 = 19136776;
	static final int field3153 = 2;
	int field3150;
	class162 field3151;
	byte[] field3149;
	class249 field3152;

	static final void method4620(Widget[] var0, int var1, int var2) {
		for (int var3 = 0; var3 < var0.length; var3++) {
			if (var2 >= 2125156941) {
				return;
			}

			Widget var4 = var0[var3];
			if (var4 != null && var4.parentHash == var1) {
				if (var4.decodeCs2) {

					if (class81.method1885(var4, (byte) -14)) {
						continue;
					}
				}

				if (var4.widgetType == 0) {
					if (!var4.decodeCs2) {

						if (class81.method1885(var4, (byte) -60) && var4 != class143.field1897) {
							continue;
						}
					}

					method4620(var0, var4.interfaceHash, -559150068);
					if (var4.children != null) {

						method4620(var4.children, var4.interfaceHash, 1032932105);
					}

					class55 var5 = (class55) GameClient.field741.get((long) var4.interfaceHash);
					if (var5 != null) {
						class21.method270(var5.field501, 346135598);
					}
				}

				if (var4.widgetType == 6) {
					int var6;
					if (var4.animation != -1 || var4.field2653 != -1) {
						boolean var8 = class132.method3097(var4, -2063892769);
						if (var8) {
							var6 = var4.field2653;
						} else {
							var6 = var4.animation;
						}

						if (var6 != -1) {
							class273 var7 = class3.method25(var6, 116122662);

							for (var4.field2613 += GameClient.field700; var4.field2613 > var7.field3541[var4.field2728]; GameClient.requestRedraw(var4)) {
								var4.field2613 -= var7.field3541[var4.field2728];
								++var4.field2728;
								if (var4.field2728 >= var7.field3540.length) {
									var4.field2728 -= var7.field3544;
									if (var4.field2728 < 0 || var4.field2728 >= var7.field3540.length) {
										var4.field2728 = 0;
									}
								}
							}
						}
					}

					if (var4.field2732 != 0) {

						if (!var4.decodeCs2) {
							int var9 = var4.field2732 >> 16;
							var6 = var4.field2732 << 16 >> 16;
							var9 *= GameClient.field700;
							var6 *= GameClient.field700;
							var4.rotationX = var9 + var4.rotationX & 2047;
							var4.rotationY = var6 + var4.rotationY & 2047;
							GameClient.requestRedraw(var4);
						}
					}
				}
			}
		}

	}

	static final void decodeNpcMasks(boolean largeScene, PacketBuffer buffer) {
		GameClient.field701 = 0;
		GameClient.field624 = 0;
		PacketBuffer var3 = GameClient.field626.field1219;
		var3.startBitMode();
		int var4 = var3.readBits(8);
		int var5;
		if (var4 < GameClient.field622) {
			for (var5 = var4; var5 < GameClient.field622; var5++) {
				GameClient.field702[++GameClient.field701 - 1] = GameClient.field639[var5];
			}
		}

		if (var4 > GameClient.field622) {
			throw new RuntimeException("");
		} else {
			GameClient.field622 = 0;

			int var6;
			int var8;
			int var9;
			int var10;
			int var11;
			int var12;
			for (var5 = 0; var5 < var4; var5++) {
				var6 = GameClient.field639[var5];
				Npc var7 = GameClient.field843[var6];
				var8 = var3.readBits(1);
				if (var8 == 0) {
					GameClient.field639[++GameClient.field622 - 1] = var6;
					var7.field914 = GameClient.field591;
				} else {
					var9 = var3.readBits(2);
					if (var9 == 0) {
						GameClient.field639[++GameClient.field622 - 1] = var6;
						var7.field914 = GameClient.field591;
						GameClient.field666[++GameClient.field624 - 1] = var6;
					} else if (var9 == 1) {
						GameClient.field639[++GameClient.field622 - 1] = var6;
						var7.field914 = GameClient.field591;
						var10 = var3.readBits(3);
						var7.method1794(var10, (byte) 1, (byte) 70);
						var11 = var3.readBits(1);
						if (var11 == 1) {
							GameClient.field666[++GameClient.field624 - 1] = var6;
						}
					} else if (var9 == 2) {
						GameClient.field639[++GameClient.field622 - 1] = var6;
						var7.field914 = GameClient.field591;
						var10 = var3.readBits(3);
						var7.method1794(var10, (byte) 2, (byte) 127);
						var11 = var3.readBits(3);
						var7.method1794(var11, (byte) 2, (byte) 64);
						var12 = var3.readBits(1);
						if (var12 == 1) {
							GameClient.field666[++GameClient.field624 - 1] = var6;
						}
					} else if (var9 == 3) {
						GameClient.field702[++GameClient.field701 - 1] = var6;
					}
				}
			}

			class30.method500(largeScene, buffer, 993240466);

			int var15;
			for (var15 = 0; var15 < GameClient.field624; var15++) {
				var4 = GameClient.field666[var15];
				Npc npc = GameClient.field843[var4];
				int mask = buffer.readUByte();

				int var17;
				if ((mask & 0x4) != 0) { // Graphic
					npc.field891 = buffer.readLEShortA();
					var17 = buffer.readIntV1();
					npc.field871 = var17 >> 16;
					npc.field911 = (var17 & 65535) + GameClient.field591;
					npc.field876 = 0;
					npc.field910 = 0;
					if (npc.field911 > GameClient.field591) {
						npc.field876 = -1;
					}

					if (npc.field891 == 65535) {
						npc.field891 = -1;
					}
				}

				if ((mask & 0x1) != 0) { // Face tile
					var17 = buffer.readUShortLE();
					var8 = buffer.readUShortLE();
					var9 = npc.field931 - (var17 - class62.baseX - class62.baseX) * 64;
					var10 = npc.field881 - (var8 - GameClient.baseY - GameClient.baseY) * 64;
					if (var9 != 0 || var10 != 0) {
						npc.field920 = (int) (Math.atan2((double) var9, (double) var10) * 325.949D) & 2047;
					}
				}

				if ((mask & 0x40) != 0) { // Hit
					var17 = buffer.readUByteA();
					int var13;
					if (var17 > 0) {
						for (var8 = 0; var8 < var17; var8++) {
							var10 = -1;
							var11 = -1;
							var12 = -1;
							var9 = buffer.readCompact();
							if (var9 == 32767) {
								var9 = buffer.readCompact();
								var11 = buffer.readCompact();
								var10 = buffer.readCompact();
								var12 = buffer.readCompact();
							} else if (var9 != 32766) {
								var11 = buffer.readCompact();
							} else {
								var9 = -1;
							}

							var13 = buffer.readCompact();
							npc.method1542(var9, var11, var10, var12, GameClient.field591, var13, (byte) 44);
						}
					}

					var8 = buffer.readUByteA();
					if (var8 > 0) {
						for (var9 = 0; var9 < var8; var9++) {
							var10 = buffer.readCompact();
							var11 = buffer.readCompact();
							if (var11 != 32767) {
								var12 = buffer.readCompact();
								var13 = buffer.readUByteS();
								int var14 = var11 > 0 ? buffer.readUByteS() : var13;
								npc.method1543(var10, GameClient.field591, var11, var12, var13, var14, 409078602);
							} else {
								npc.method1557(var10, -1135645906);
							}
						}
					}
				}

				if ((mask & 0x8) != 0) {
					npc.definition = class270.loadNpcDef(buffer.readShortA());
					npc.field874 = npc.definition.size;
					npc.field924 = npc.definition.turnValue;
					npc.field899 = npc.definition.walkAnimation;
					npc.field880 = npc.definition.turn180Animation;
					npc.field870 = npc.definition.turn90CWAnimation;
					npc.field882 = npc.definition.turn90CCAnimation;
					npc.field893 = npc.definition.idleAnimation;
					npc.field877 = npc.definition.op15;
					npc.field878 = npc.definition.op16;
				}

				if ((mask & 0x10) != 0) {
					npc.field897 = buffer.readUShortLE();
					if (npc.field897 == 65535) {
						npc.field897 = -1;
					}
				}

				if ((mask & 0x20) != 0) {
					label312:
					{
						var17 = buffer.readShortA();
						if (var17 == 65535) {
							var17 = -1;
						}

						var8 = buffer.readUByte();
						if (var17 == npc.field903) {

							if (var17 != -1) {
								var9 = class3.method25(var17, -269452261).field3553;
								if (var9 == 1) {
									npc.field904 = 0;
									npc.field901 = 0;
									npc.field906 = var8;
									npc.field907 = 0;
								}

								if (var9 == 2) {
									npc.field907 = 0;
								}
								break label312;
							}
						}

						if (var17 == -1 || npc.field903 == -1 || class3.method25(var17, 1221940475).field3547 >= class3.method25(npc.field903, -1185750462).field3547) {
							npc.field903 = var17;
							npc.field904 = 0;
							npc.field901 = 0;
							npc.field906 = var8;
							npc.field907 = 0;
							npc.field930 = npc.field909;
						}
					}
				}

				if ((mask & 0x2) != 0) {
					npc.field884 = buffer.readString();
					npc.field887 = 100;
				}

				if ((mask & 0x80) != 0) {
					npc.customCombatLevel = buffer.readShort();
				}
			}

			for (var15 = 0; var15 < GameClient.field701; var15++) {
				var4 = GameClient.field702[var15];
				if (GameClient.field843[var4].field914 != GameClient.field591) {
					GameClient.field843[var4].definition = null;
					GameClient.field843[var4] = null;
				}
			}

			if (buffer.field2339 != GameClient.field626.field1225) {
				throw new RuntimeException(buffer.field2339 + "," + GameClient.field626.field1225);
			} else {
				for (var15 = 0; var15 < GameClient.field622; var15++) {
					if (GameClient.field843[GameClient.field639[var15]] == null) {
						throw new RuntimeException(var15 + "," + GameClient.field622);
					}
				}

			}
		}
	}
}
