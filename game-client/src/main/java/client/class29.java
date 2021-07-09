package client;

import java.awt.FontMetrics;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class class29 {
	public static final class29 field252 = new class29("details");
	public static final class29 field251 = new class29("compositemap");
	static FontMetrics field256;
	public static final class29 field262 = new class29("area");
	public static final class29 field257 = new class29("compositetexture");
	public static final class29 field254 = new class29("labels");
	static byte[][] field253;
	static class111 field250;
	static final int field258 = 19;
	static final int field259 = 106;
	static final int field260 = 37;
	static final int field261 = 72;
	public final String field255;

	class29(String var1) {
		this.field255 = var1;
	}

	static final void decodeMapPacket(class171 var0) {
		PacketBuffer buffer = GameClient.field626.field1219;
		int var3;
		int var4;
		int var5;
		byte var6;
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var13;
		int var14;
		int var38;
		int var40;
		if (class171.field2246 == var0) {
			int lifetime = buffer.readUShort();
			int entityIndex = buffer.readShort();
			byte toX = buffer.readByte();
			int toZ = buffer.readByteA();
			int endHeight = buffer.readUByte() * 4;
			int angle = buffer.readUByteS();
			int steepness = buffer.readUByteS();
			int tile = buffer.readUByteS();
			int fromX = (tile >> 4 & 7) + class57.mapBaseX;
			int fromZ = (tile & 7) + class226.mapBaseZ;
			int graphic = buffer.readShortA();
			int startHeight = buffer.readUByteA() * 4;
			int delay = buffer.readUShort();
			var5 = toX + fromX;
			var38 = toZ + fromZ;
			if (fromX >= 0 && fromZ >= 0 && fromX < 104 && fromZ < 104 && var5 >= 0 && var38 >= 0 && var5 < 104 && var38 < 104) {
				if (graphic != 65535) {
					fromX = fromX * 128 + 64;
					fromZ = fromZ * 128 + 64;
					var5 = var5 * 128 + 64;
					var38 = var38 * 128 + 64;
					class79 var16 = new class79(graphic, class13.field82, fromX, fromZ, class27.method460(fromX, fromZ, class13.field82, 17748493) - startHeight, delay + GameClient.field591, lifetime + GameClient.field591, angle, steepness, entityIndex, endHeight);
					var16.method1849(var5, var38, class27.method460(var5, var38, class13.field82, -860427024) - endHeight, delay + GameClient.field591, -432568951);
					GameClient.field710.method4073(var16);
				}
			}

		} else if (class171.field2243 == var0) {
			var3 = buffer.readUByteN();
			var4 = (var3 >> 4 & 7) + class57.mapBaseX;
			var5 = (var3 & 7) + class226.mapBaseZ;
			var38 = buffer.readUByteS();
			var7 = var38 >> 2;
			var8 = var38 & 3;
			var9 = GameClient.field846[var7];
			var10 = buffer.readShortA();
			if (var4 >= 0) {
				if (var5 >= 0 && var4 < 104 && var5 < 104) {
					class241.method4602(class13.field82, var4, var5, var9, var10, var7, var8, 0, -1, (byte) -35);
				}
			}

		} else if (class171.field2248 == var0) {
			var3 = buffer.readLEShortA();
			var4 = buffer.readUByte();
			var5 = var4 >> 2;
			var38 = var4 & 3;
			var7 = GameClient.field846[var5];
			var8 = buffer.readUByte();
			var9 = (var8 >> 4 & 7) + class57.mapBaseX;
			var10 = (var8 & 7) + class226.mapBaseZ;
			if (var9 >= 0 && var10 >= 0 && var9 < 103 && var10 < 103) {
				if (var7 == 0) {
					class128 var32 = class28.field248.method2894(class13.field82, var9, var10);
					if (var32 != null) {
						var40 = class39.method673(var32.field1786);
						if (var5 == 2) {
							var32.field1787 = new class85(var40, 2, var38 + 4, class13.field82, var9, var10, var3, false, var32.field1787);
							var32.field1788 = new class85(var40, 2, var38 + 1 & 3, class13.field82, var9, var10, var3, false, var32.field1788);
						} else {
							var32.field1787 = new class85(var40, var5, var38, class13.field82, var9, var10, var3, false, var32.field1787);
						}
					}
				}

				if (var7 == 1) {
					class133 var42 = class28.field248.method2895(class13.field82, var9, var10);
					if (var42 != null) {
						label401:
						{
							var40 = class39.method673(var42.field1824);
							if (var5 != 4) {

								if (var5 != 5) {
									if (var5 == 6) {
										var42.field1823 = new class85(var40, 4, var38 + 4, class13.field82, var9, var10, var3, false, var42.field1823);
									} else if (var5 == 7) {
										var42.field1823 = new class85(var40, 4, (var38 + 2 & 3) + 4, class13.field82, var9, var10, var3, false, var42.field1823);
									} else if (var5 == 8) {
										var42.field1823 = new class85(var40, 4, var38 + 4, class13.field82, var9, var10, var3, false, var42.field1823);
										var42.field1831 = new class85(var40, 4, (var38 + 2 & 3) + 4, class13.field82, var9, var10, var3, false, var42.field1831);
									}
									break label401;
								}
							}

							var42.field1823 = new class85(var40, 4, var38, class13.field82, var9, var10, var3, false, var42.field1823);
						}
					}
				}

				if (var7 == 2) {
					class134 var43 = class28.field248.method2896(class13.field82, var9, var10);
					if (var5 == 11) {
						var5 = 10;
					}

					if (var43 != null) {
						var43.field1844 = new class85(class39.method673(var43.field1848), var5, var38, class13.field82, var9, var10, var3, false, var43.field1844);
					}
				}

				if (var7 == 3) {
					class115 var44 = class28.field248.method2953(class13.field82, var9, var10);
					if (var44 != null) {
						var44.field1524 = new class85(class39.method673(var44.field1526), 22, var38, class13.field82, var9, var10, var3, false, var44.field1524);
					}
				}
			}

		} else if (class171.field2241 == var0) {
			var3 = buffer.readUShort();
			var4 = buffer.readUShort();
			var5 = buffer.readUByteS();
			var38 = (var5 >> 4 & 7) + class57.mapBaseX;
			var7 = (var5 & 7) + class226.mapBaseZ;
			var8 = buffer.readUByte();
			if (var38 >= 0 && var7 >= 0 && var38 < 104 && var7 < 104) {

				var38 = var38 * 128 + 64;
				var7 = var7 * 128 + 64;
				class70 var45 = new class70(var3, class13.field82, var38, var7, class27.method460(var38, var7, class13.field82, -1669844185) - var8, var4, GameClient.field591);
				GameClient.field711.method4073(var45);
			}

		} else {
			Item var34;
			if (class171.field2249 == var0) {
				var3 = buffer.readUByteS();
				var4 = (var3 >> 4 & 7) + class57.mapBaseX;
				var5 = (var3 & 7) + class226.mapBaseZ;
				var38 = buffer.readShortA();
				var7 = buffer.readUShortLE();
				if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
					var34 = new Item();
					var34.id = var38;
					var34.amt = var7;
					if (GameClient.field708[class13.field82][var4][var5] == null) {
						GameClient.field708[class13.field82][var4][var5] = new class205();
					}

					GameClient.field708[class13.field82][var4][var5].method4073(var34);
					class253.method4808(var4, var5, 970969852);
				}

			} else if (class171.field2247 == var0) {
				var3 = buffer.readUByte();
				var4 = var3 >> 2;
				var5 = var3 & 3;
				var38 = GameClient.field846[var4];
				var7 = buffer.readUByteS();
				var8 = (var7 >> 4 & 7) + class57.mapBaseX;
				var9 = (var7 & 7) + class226.mapBaseZ;
				if (var8 >= 0 && var9 >= 0) {

					if (var8 < 104 && var9 < 104) {
						class241.method4602(class13.field82, var8, var9, var38, -1, var4, var5, 0, -1, (byte) -112);
					}
				}

			} else if (class171.field2242 == var0) {
				var3 = buffer.readLEShortA();
				var4 = buffer.readUByteA();
				var5 = (var4 >> 4 & 7) + class57.mapBaseX;
				var38 = (var4 & 7) + class226.mapBaseZ;
				if (var5 >= 0 && var38 >= 0 && var5 < 104) {

					if (var38 < 104) {
						class205 var35 = GameClient.field708[class13.field82][var5][var38];
						if (var35 != null) {
							for (var34 = (Item) var35.method4098(); var34 != null; var34 = (Item) var35.method4079()) {

								if ((var3 & 32767) == var34.id) {
									var34.unlink();
									break;
								}
							}

							if (var35.method4098() == null) {
								GameClient.field708[class13.field82][var5][var38] = null;
							}

							class253.method4808(var5, var38, 1188783740);
						}
					}
				}

			} else {
				if (class171.field2245 == var0) {
					var3 = buffer.readUByteN();
					var4 = (var3 >> 4 & 7) + class57.mapBaseX;
					var5 = (var3 & 7) + class226.mapBaseZ;
					var6 = buffer.readByte();
					var7 = buffer.readUShort();
					var8 = buffer.readUByteN();
					var9 = var8 >> 2;
					var10 = var8 & 3;
					var11 = GameClient.field846[var9];
					byte var12 = buffer.readByte();
					var13 = buffer.readUShort();
					var14 = buffer.readUShortLE();
					byte var15 = buffer.readByteS();
					int var36 = buffer.readShortA();
					byte var17 = buffer.readByteA();
					Player var18;
					if (var36 == GameClient.field628) {
						var18 = class138.field1876;
					} else {
						var18 = GameClient.field610[var36];
					}

					if (var18 != null) {
						ObjectDef var19 = class110.getObjectDef(var7);
						int var20;
						int var21;
						if (var10 != 1 && var10 != 3) {
							var20 = var19.int693;
							var21 = var19.int688;
						} else {
							var20 = var19.int688;
							var21 = var19.int693;
						}

						int var22 = var4 + (var20 >> 1);
						int var23 = var4 + (var20 + 1 >> 1);
						int var24 = var5 + (var21 >> 1);
						int var25 = var5 + (var21 + 1 >> 1);
						int[][] var26 = class50.field459[class13.field82];
						int var27 = var26[var23][var25] + var26[var22][var24] + var26[var23][var24] + var26[var22][var25] >> 2;
						int var28 = (var4 << 7) + (var20 << 6);
						int var29 = (var5 << 7) + (var21 << 6);
						class119 var30 = var19.method5031(var9, var10, var26, var28, var27, var29, (byte) -15);
						if (var30 != null) {

							class241.method4602(class13.field82, var4, var5, var11, -1, 0, 0, var13 + 1, var14 + 1, (byte) -120);
							var18.field545 = var13 + GameClient.field591;
							var18.field555 = var14 + GameClient.field591;
							var18.field563 = var30;
							var18.field556 = var4 * 128 + var20 * 64;
							var18.field558 = var5 * 128 + var21 * 64;
							var18.field557 = var27;
							byte var31;
							if (var15 > var6) {
								var31 = var15;
								var15 = var6;
								var6 = var31;
							}

							if (var17 > var12) {
								var31 = var17;
								var17 = var12;
								var12 = var31;
							}

							var18.field559 = var15 + var4;
							var18.field565 = var6 + var4;
							var18.field547 = var17 + var5;
							var18.field553 = var5 + var12;
						}
					}
				}

				if (class171.field2250 == var0) {
					var3 = buffer.readUByteN();
					var4 = buffer.readUByte();
					var5 = var4 >> 4 & 15;
					var38 = var4 & 7;
					var7 = buffer.readUByteN();
					var8 = (var7 >> 4 & 7) + class57.mapBaseX;
					var9 = (var7 & 7) + class226.mapBaseZ;
					var10 = buffer.readLEShortA();
					if (var8 >= 0 && var9 >= 0) {

						if (var8 < 104) {

							if (var9 < 104) {
								var11 = var5 + 1;
								if (class138.field1876.field922[0] >= var8 - var11 && class138.field1876.field922[0] <= var8 + var11) {

									if (class138.field1876.field872[0] >= var9 - var11 && class138.field1876.field872[0] <= var11 + var9) {

										if (GameClient.field815 != 0 && var38 > 0 && GameClient.field656 < 50) {
											GameClient.field817[GameClient.field656] = var10;
											GameClient.field676[GameClient.field656] = var38;
											GameClient.field819[GameClient.field656] = var3;
											GameClient.field719[GameClient.field656] = null;
											GameClient.field820[GameClient.field656] = var5 + (var9 << 8) + (var8 << 16);
											++GameClient.field656;
										}
									}
								}
							}
						}
					}
				}

				if (class171.field2244 == var0) {
					var3 = buffer.readUByte();
					var4 = (var3 >> 4 & 7) + class57.mapBaseX;
					var5 = (var3 & 7) + class226.mapBaseZ;
					var38 = buffer.readShortA();
					var7 = buffer.readShortA();
					var8 = buffer.readLEShortA();
					if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
						class205 var33 = GameClient.field708[class13.field82][var4][var5];
						if (var33 != null) {
							for (Item var37 = (Item) var33.method4098(); var37 != null; var37 = (Item) var33.method4079()) {
								if ((var7 & 32767) == var37.id && var8 == var37.amt) {
									var37.amt = var38;
									break;
								}
							}

							class253.method4808(var4, var5, 1848236752);
						}
					}

				}
			}
		}
	}

	static void method478(byte var0) {
		int var1;
		if (GameClient.field609 == 0) {
			class28.field248 = new class125(4, 104, 104, class50.field459);

			for (var1 = 0; var1 < 4; var1++) {
				GameClient.field642[var1] = new class164(104, 104);
			}

			Npc.field1038 = new Sprite(512, 512);
			class78.field1100 = "Starting game engine...";
			class78.field1099 = 5;
			GameClient.field609 = 20;
		} else {
			int var2;
			int var3;
			int var4;
			int var5;
			if (GameClient.field609 == 20) {
				int[] var34 = new int[9];

				for (var2 = 0; var2 < 9; var2++) {
					if (var0 <= 2) {
						return;
					}

					var3 = var2 * 32 + 15 + 128;
					var4 = var3 * 3 + 600;
					var5 = class122.field1681[var3];
					var34[var2] = var5 * var4 >> 16;
				}

				class125.method2893(var34, 500, 800, 512, 334);
				class78.field1100 = "Prepared visibility map";
				class78.field1099 = 10;
				GameClient.field609 = 30;
			} else if (GameClient.field609 == 30) {
				class77.field1079 = class53.method1009(0, false, true, true, (byte) 95);
				class37.field326 = class53.method1009(1, false, true, true, (byte) 43);
				class97.field1329 = class53.method1009(2, true, false, true, (byte) 82);
				class224.field2548 = class53.method1009(3, false, true, true, (byte) 113);
				class135.field1852 = class53.method1009(4, false, true, true, (byte) 101);
				class246.field3159 = class53.method1009(5, true, true, true, (byte) 117);
				Item.field1147 = class53.method1009(6, true, true, true, (byte) 44);
				class21.field179 = class53.method1009(7, false, true, true, (byte) 83);
				class175.field2270 = class53.method1009(8, false, true, true, (byte) 44);
				ObjectDef.field3419 = class53.method1009(9, false, true, true, (byte) 85);
				class22.field183 = class53.method1009(10, false, true, true, (byte) 19);
				class61.field576 = class53.method1009(11, false, true, true, (byte) 55);
				GameClient.field854 = class53.method1009(12, false, true, true, (byte) 105);
				class50.field461 = class53.method1009(13, true, false, true, (byte) 31);
				class59.field543 = class53.method1009(14, false, true, true, (byte) 84);
				class36.field312 = class53.method1009(15, false, true, true, (byte) 7);
				class24.field207 = class53.method1009(16, true, true, true, (byte) 73);
				class78.field1100 = "Connecting to update server";
				class78.field1099 = 20;
				GameClient.field609 = 40;
			} else if (GameClient.field609 == 40) {
				byte var31 = 0;
				var1 = var31 + class77.field1079.method4720((byte) 75) * 4 / 100;
				var1 += class37.field326.method4720((byte) 43) * 4 / 100;
				var1 += class97.field1329.method4720((byte) 60) * 2 / 100;
				var1 += class224.field2548.method4720((byte) 97) * 2 / 100;
				var1 += class135.field1852.method4720((byte) -60) * 6 / 100;
				var1 += class246.field3159.method4720((byte) 21) * 4 / 100;
				var1 += Item.field1147.method4720((byte) -70) * 2 / 100;
				var1 += class21.field179.method4720((byte) 26) * 58 / 100;
				var1 += class175.field2270.method4720((byte) 82) * 2 / 100;
				var1 += ObjectDef.field3419.method4720((byte) -40) * 2 / 100;
				var1 += class22.field183.method4720((byte) 28) * 2 / 100;
				var1 += class61.field576.method4720((byte) -104) * 2 / 100;
				var1 += GameClient.field854.method4720((byte) -8) * 2 / 100;
				var1 += class50.field461.method4720((byte) 71) * 2 / 100;
				var1 += class59.field543.method4720((byte) -25) * 2 / 100;
				var1 += class36.field312.method4720((byte) 82) * 2 / 100;
				var1 += class24.field207.method4720((byte) -93) * 2 / 100;
				if (var1 != 100) {
					if (var1 != 0) {
						class78.field1100 = "Checking for updates - " + var1 + "%";
					}

					class78.field1099 = 30;
				} else {
					class32.method548(class77.field1079, "Animations", 2071314705);
					class32.method548(class37.field326, "Skeletons", -1236942081);
					class32.method548(class135.field1852, "Sound FX", -2085145407);
					class32.method548(class246.field3159, "Maps", -1634784952);
					class32.method548(Item.field1147, "Music Tracks", 1725658571);
					class32.method548(class21.field179, "Models", 920557913);
					class32.method548(class175.field2270, "Sprites", -749931524);
					class32.method548(class61.field576, "Music Jingles", 1786777642);
					class32.method548(class59.field543, "Music Samples", 2093879831);
					class32.method548(class36.field312, "Music Patches", 1404017034);
					class32.method548(class24.field207, "World Map", -578042915);
					class78.field1100 = "Loaded update list";
					class78.field1099 = 30;
					GameClient.field609 = 45;
				}
			} else {
				class249 var26;
				class249 var28;
				if (GameClient.field609 == 45) {
					if (var0 > 2) {
						class68.method1697(22050, !GameClient.field585, 2, -1337565581);
						class218 var33 = new class218();
						var33.method4257(9, 128, 2070435347);
						class28.field244 = class65.method1582(GameShell.field392, 0, 22050, 30833833);
						class28.field244.method2143(var33, -1537187837);
						var26 = class36.field312;
						class249 var27 = class59.field543;
						var28 = class135.field1852;
						class177.field2284 = var26;
						class217.field2464 = var27;
						class217.field2458 = var28;
						class217.field2459 = var33;
						class63.field879 = class65.method1582(GameShell.field392, 1, 2048, -817707269);
						class36.field310 = new class88();
						class63.field879.method2143(class36.field310, -1441806026);
						class61.field577 = new class102(22050, class95.field1300);
						class78.field1100 = "Prepared sound engine";
						class78.field1099 = 35;
						GameClient.field609 = 50;
						class1.field14 = new class296(class175.field2270, class50.field461);
					}
				} else if (GameClient.field609 == 50) {
					var1 = class295.method5498((byte) 106).length;
					GameClient.field631 = class1.field14.method5504(class295.method5498((byte) 71), (byte) -33);
					if (GameClient.field631.size() < var1) {
						class78.field1100 = "Loading fonts - " + GameClient.field631.size() * 100 / var1 + "%";
						class78.field1099 = 40;
					} else {
						class151.field1936 = (class298) GameClient.field631.get(class295.field3678);
						class63.field933 = (class298) GameClient.field631.get(class295.field3672);
						class293.field3660 = (class298) GameClient.field631.get(class295.field3668);
						class27.field228 = new class324(true);
						class78.field1100 = "Loaded fonts";
						class78.field1099 = 40;
						GameClient.field609 = 60;
					}
				} else if (GameClient.field609 == 60) {
					var1 = class224.method4426(class22.field183, class175.field2270, -1700861018);
					var2 = class11.method99(-1543564143);
					if (var1 < var2) {
						class78.field1100 = "Loading title screen - " + var1 * 100 / var2 + "%";
						class78.field1099 = 50;
					} else {
						class78.field1100 = "Loaded title screen";
						class78.field1099 = 50;
						class48.method947(5, 537461702);
						GameClient.field609 = 70;
					}
				} else if (GameClient.field609 == 70) {
					if (!class97.field1329.method4629(758366307)) {
						if (var0 > 2) {
							class78.field1100 = "Loading config - " + class97.field1329.method4755(1226405037) + "%";
							class78.field1099 = 60;
						}
					} else {
						class21.method277(class97.field1329, 1802927852);
						class58.method1069(class97.field1329, -1743479306);
						class257.method4851(class97.field1329, class21.field179, -1839091252);
						class249 var32 = class97.field1329;
						var26 = class21.field179;
						boolean var30 = GameClient.field585;
						ObjectDef.field3377 = var32;
						class130.field1801 = var26;
						ObjectDef.field3416 = var30;
						var28 = class97.field1329;
						class249 var29 = class21.field179;
						NpcDef.field3490 = var28;
						NpcDef.field3487 = var29;
						class249 var6 = class97.field1329;
						class7.field42 = var6;
						class249 var7 = class97.field1329;
						class249 var8 = class21.field179;
						boolean var9 = GameClient.field668;
						class298 var10 = class151.field1936;
						ItemDef.field3424 = var7;
						ItemDef.field3454 = var8;
						ItemDef.field3426 = var9;
						class86.field1212 = ItemDef.field3424.getFileCount(10);
						ItemDef.field3466 = var10;
						class249 var11 = class97.field1329;
						class249 var12 = class77.field1079;
						class249 var13 = class37.field326;
						class273.field3538 = var11;
						class273.field3536 = var12;
						class273.field3537 = var13;
						class249 var14 = class97.field1329;
						class249 var15 = class21.field179;
						class258.field3272 = var14;
						class258.field3279 = var15;
						class249 var16 = class97.field1329;
						class263.field3322 = var16;
						class249 var17 = class97.field1329;
						class0.field2 = var17;
						class254.field3232 = class0.field2.getFileCount(16);
						class11.method100(class224.field2548, class21.field179, class175.field2270, class50.field461, (short) 22982);
						class160.method3344(class97.field1329, (byte) -42);
						class249 var18 = class97.field1329;
						RuneScriptMap.field3338 = var18;
						class129.method3072(class97.field1329, 1157214039);
						class249 var19 = class97.field1329;
						class257.field3264 = var19;
						class249 var20 = class97.field1329;
						class264.field3327 = var20;
						class22.field185 = new class82();
						class250.method4766(class97.field1329, class175.field2270, class50.field461, 1897264020);
						class144.method3181(class97.field1329, class175.field2270, (byte) 15);
						class249 var21 = class97.field1329;
						class249 var22 = class175.field2270;
						class255.field3237 = var22;
						if (var21.method4629(1297481325)) {
							class255.field3236 = var21.getFileCount(35);
							class255.field3246 = new class255[class255.field3236];

							for (int var23 = 0; var23 < class255.field3236; var23++) {
								byte[] var24 = var21.method4625(35, var23, 1818456524);
								if (var24 != null) {
									class255.field3246[var23] = new class255(var23);
									class255.field3246[var23].method4816(new Stream(var24), 248610403);
									class255.field3246[var23].method4828(1083458707);
								}
							}
						}

						class78.field1100 = "Loaded config";
						class78.field1099 = 60;
						GameClient.field609 = 80;
					}
				} else if (GameClient.field609 == 80) {
					var1 = 0;
					if (class128.field1791 == null) {
						class128.field1791 = class137.method3127(class175.field2270, "compass", "", -1573456149);
					} else {
						++var1;
					}

					if (class136.field1862 == null) {
						class136.field1862 = class137.method3127(class175.field2270, "mapedge", "", -1180219858);
					} else {
						++var1;
					}

					if (class25.field214 == null) {
						if (var0 <= 2) {
							return;
						}

						class25.field214 = class13.method113(class175.field2270, "mapscene", "", 2135043627);
					} else {
						++var1;
					}

					if (class150.field1919 == null) {
						if (var0 <= 2) {
							return;
						}

						class150.field1919 = class21.method279(class175.field2270, "headicons_pk", "", 1309811201);
					} else {
						++var1;
					}

					if (class43.field369 == null) {
						if (var0 <= 2) {
							return;
						}

						class43.field369 = class21.method279(class175.field2270, "headicons_prayer", "", 1573697484);
					} else {
						++var1;
					}

					if (class150.field1926 == null) {
						if (var0 <= 2) {
							return;
						}

						class150.field1926 = class21.method279(class175.field2270, "headicons_hint", "", 582958788);
					} else {
						++var1;
					}

					if (class111.field1446 == null) {
						if (var0 <= 2) {
							return;
						}

						class111.field1446 = class21.method279(class175.field2270, "mapmarker", "", 1110499288);
					} else {
						++var1;
					}

					if (class161.field1997 == null) {
						class161.field1997 = class21.method279(class175.field2270, "cross", "", 1058120836);
					} else {
						++var1;
					}

					if (class36.field314 == null) {
						class36.field314 = class21.method279(class175.field2270, "mapdots", "", 1967121636);
					} else {
						++var1;
					}

					if (class243.field3139 == null) {
						class243.field3139 = class13.method113(class175.field2270, "scrollbar", "", 1220252918);
					} else {
						++var1;
					}

					if (class322.field3881 == null) {
						class322.field3881 = class13.method113(class175.field2270, "mod_icons", "", 1579114208);
						class322.field3881 = Custom.Icons.loadIcons(class322.field3881);
					} else {
						++var1;
					}

					if (var1 < 11) {
						class78.field1100 = "Loading sprites - " + var1 * 100 / 12 + "%";
						class78.field1099 = 70;
					} else {
						class299.field3698 = class322.field3881;
						class136.field1862.method5843();
						var2 = (int) (Math.random() * 21.0D) - 10;
						var3 = (int) (Math.random() * 21.0D) - 10;
						var4 = (int) (Math.random() * 21.0D) - 10;
						var5 = (int) (Math.random() * 41.0D) - 20;
						class25.field214[0].method5822(var2 + var5, var3 + var5, var4 + var5);
						class78.field1100 = "Loaded sprites";
						class78.field1099 = 70;
						GameClient.field609 = 90;
					}
				} else if (GameClient.field609 == 90) {
					if (!ObjectDef.field3419.method4629(2006214537)) {
						class78.field1100 = "Loading textures - " + "0%";
						class78.field1099 = 90;
					} else {
						field250 = new class111(ObjectDef.field3419, class175.field2270, 20, 0.8D, GameClient.field585 ? 64 : 128);
						class122.method2789(field250);
						class122.method2830(0.8D);
						GameClient.field609 = 100;
					}
				} else if (GameClient.field609 == 100) {
					if (var0 > 2) {
						var1 = field250.method2530(-1808085828);
						if (var1 < 100) {
							class78.field1100 = "Loading textures - " + var1 + "%";
							class78.field1099 = 90;
						} else {
							class78.field1100 = "Loaded textures";
							class78.field1099 = 90;
							GameClient.field609 = 110;
						}
					}
				} else if (GameClient.field609 == 110) {
					class26.field220 = new class57();
					GameShell.field392.method3249(class26.field220, 10, 120766326);
					class78.field1100 = "Loaded input handler";
					class78.field1099 = 92;
					GameClient.field609 = 120;
				} else if (GameClient.field609 == 120) {
					if (!class22.field183.method4646("huffman", "", -1256800993)) {
						class78.field1100 = "Loading wordpack - " + 0 + "%";
						class78.field1099 = 94;
					} else {
						class174 var25 = new class174(class22.field183.method4684("huffman", "", 222409025));
						class181.method3529(var25, (short) -23215);
						class78.field1100 = "Loaded wordpack";
						class78.field1099 = 94;
						GameClient.field609 = 130;
					}
				} else if (GameClient.field609 == 130) {
					if (var0 > 2) {
						if (!class224.field2548.method4629(1618976132)) {
							class78.field1100 = "Loading interfaces - " + class224.field2548.method4755(108630692) * 4 / 5 + "%";
							class78.field1099 = 96;
						} else if (!GameClient.field854.method4629(1827057888)) {
							class78.field1100 = "Loading interfaces - " + (80 + GameClient.field854.method4755(1663209922) / 6) + "%";
							class78.field1099 = 96;
						} else if (!class50.field461.method4629(1594096534)) {
							class78.field1100 = "Loading interfaces - " + (96 + class50.field461.method4755(399775338) / 50) + "%";
							class78.field1099 = 96;
						} else {
							class78.field1100 = "Loaded interfaces";
							class78.field1099 = 98;
							GameClient.field609 = 140;
						}
					}
				} else if (GameClient.field609 == 140) {
					if (var0 > 2) {
						class78.field1099 = 100;
						if (!class24.field207.method4704(field252.field255, -574756361)) {
							class78.field1100 = "Loading world map - " + class24.field207.method4687(field252.field255, 17959811) / 10 + "%";
						} else {
							if (class53.field476 == null) {
								class53.field476 = new class321();
								class53.field476.method6000(class24.field207, class293.field3660, GameClient.field631, class25.field214, (byte) 5);
							}

							var1 = class53.field476.method6094((byte) 15);
							if (var1 < 100) {
								class78.field1100 = "Loading world map - " + (var1 * 9 / 10 + 10) + "%";
							} else {
								class78.field1100 = "Loaded world map";
								GameClient.field609 = 150;
							}
						}
					}
				} else if (GameClient.field609 == 150) {
					class48.method947(10, 26829785);
				}
			}
		}
	}

	static void method476(int var0) {
		try {
			File var1 = new File(class18.userhomeDirectory, "random.dat");
			int var3;
			if (var1.exists()) {
				class155.field1968 = new class109(new class110(var1, "rw", 25L), 24, 0);
			} else {
				label39:
				for (int var2 = 0; var2 < class8.field52.length; var2++) {
					for (var3 = 0; var3 < class155.field1965.length; var3++) {
						File var4 = new File(class155.field1965[var3] + class8.field52[var2] + File.separatorChar + "random.dat");
						if (var4.exists()) {
							class155.field1968 = new class109(new class110(var4, "rw", 25L), 24, 0);
							break label39;
						}
					}
				}
			}

			if (class155.field1968 == null) {
				RandomAccessFile var5 = new RandomAccessFile(var1, "rw");
				var3 = var5.read();
				var5.seek(0L);
				var5.write(var3);
				var5.seek(0L);
				var5.close();
				class155.field1968 = new class109(new class110(var1, "rw", 25L), 24, 0);
			}
		} catch (IOException var6) {
			;
		}

	}

	static int method477(int var0, class84 var1, boolean var2, byte var3) {
		int var4;
		if (var0 == 3903) {
			var4 = class69.field999[--class69.field1003];
			class69.field999[++class69.field1003 - 1] = GameClient.field844[var4].method39((byte) 63);
			return 1;
		} else if (var0 == 3904) {
			var4 = class69.field999[--class69.field1003];
			class69.field999[++class69.field1003 - 1] = GameClient.field844[var4].field29;
			return 1;
		} else if (var0 == 3905) {
			var4 = class69.field999[--class69.field1003];
			class69.field999[++class69.field1003 - 1] = GameClient.field844[var4].field30;
			return 1;
		} else if (var0 == 3906) {
			var4 = class69.field999[--class69.field1003];
			class69.field999[++class69.field1003 - 1] = GameClient.field844[var4].field33;
			return 1;
		} else if (var0 == 3907) {
			var4 = class69.field999[--class69.field1003];
			class69.field999[++class69.field1003 - 1] = GameClient.field844[var4].field32;
			return 1;
		} else if (var0 == 3908) {
			var4 = class69.field999[--class69.field1003];
			class69.field999[++class69.field1003 - 1] = GameClient.field844[var4].field28;
			return 1;
		} else {
			int var13;
			if (var0 == 3910) {
				var4 = class69.field999[--class69.field1003];
				var13 = GameClient.field844[var4].method38(-1516792528);
				class69.field999[++class69.field1003 - 1] = var13 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == 3911) {
				var4 = class69.field999[--class69.field1003];
				var13 = GameClient.field844[var4].method38(-1351294277);
				class69.field999[++class69.field1003 - 1] = var13 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == 3912) {
				var4 = class69.field999[--class69.field1003];
				var13 = GameClient.field844[var4].method38(-890794497);
				class69.field999[++class69.field1003 - 1] = var13 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == 3913) {
				var4 = class69.field999[--class69.field1003];
				var13 = GameClient.field844[var4].method38(-1260495679);
				class69.field999[++class69.field1003 - 1] = var13 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var14;
				if (var0 == 3914) {
					--class69.field1003;
					var14 = class69.field999[class69.field1003] == 1;
					if (class19.field154 != null) {
						class19.field154.method9(class1.field11, var14, (byte) 48);
					}

					return 1;
				} else if (var0 == 3915) {
					--class69.field1003;
					var14 = class69.field999[class69.field1003] == 1;
					if (class19.field154 != null) {
						class19.field154.method9(class1.field13, var14, (byte) 70);
					}

					return 1;
				} else if (var0 == 3916) {
					class69.field1003 -= 2;
					var14 = class69.field999[class69.field1003] == 1;
					boolean var5 = class69.field999[class69.field1003 + 1] == 1;
					if (class19.field154 != null) {
						GameClient.field665.field575 = var5;
						class19.field154.method9(GameClient.field665, var14, (byte) 106);
					}

					return 1;
				} else if (var0 == 3917) {
					--class69.field1003;
					var14 = class69.field999[class69.field1003] == 1;
					if (class19.field154 != null) {
						class19.field154.method9(class1.field9, var14, (byte) 120);
					}

					return 1;
				} else if (var0 == 3918) {
					--class69.field1003;
					var14 = class69.field999[class69.field1003] == 1;
					if (class19.field154 != null) {
						class19.field154.method9(class1.field16, var14, (byte) 34);
					}

					return 1;
				} else if (var0 == 3919) {
					class69.field999[++class69.field1003 - 1] = class19.field154 == null ? 0 : class19.field154.field10.size();
					return 1;
				} else {
					class2 var12;
					if (var0 == 3920) {
						var4 = class69.field999[--class69.field1003];
						var12 = (class2) class19.field154.field10.get(var4);
						class69.field999[++class69.field1003 - 1] = var12.field19;
						return 1;
					} else if (var0 == 3921) {
						var4 = class69.field999[--class69.field1003];
						var12 = (class2) class19.field154.field10.get(var4);
						class69.field1001[++class55.field497 - 1] = var12.method16(1695060368);
						return 1;
					} else if (var0 == 3922) {
						var4 = class69.field999[--class69.field1003];
						var12 = (class2) class19.field154.field10.get(var4);
						class69.field1001[++class55.field497 - 1] = var12.method18(-1459489481);
						return 1;
					} else if (var0 == 3923) {
						var4 = class69.field999[--class69.field1003];
						var12 = (class2) class19.field154.field10.get(var4);
						long var6 = Stream.method3547(604838575) - class70.field1013 - var12.field20;
						int var8 = (int) (var6 / 3600000L);
						int var9 = (int) ((var6 - (long) (var8 * 3600000)) / 60000L);
						int var10 = (int) ((var6 - (long) (var8 * 3600000) - (long) (var9 * 60000)) / 1000L);
						String var11 = var8 + ":" + var9 / 10 + var9 % 10 + ":" + var10 / 10 + var10 % 10;
						class69.field1001[++class55.field497 - 1] = var11;
						return 1;
					} else if (var0 == 3924) {
						var4 = class69.field999[--class69.field1003];
						var12 = (class2) class19.field154.field10.get(var4);
						class69.field999[++class69.field1003 - 1] = var12.field17.field33;
						return 1;
					} else if (var0 == 3925) {
						var4 = class69.field999[--class69.field1003];
						var12 = (class2) class19.field154.field10.get(var4);
						class69.field999[++class69.field1003 - 1] = var12.field17.field30;
						return 1;
					} else if (var0 == 3926) {
						var4 = class69.field999[--class69.field1003];
						var12 = (class2) class19.field154.field10.get(var4);
						class69.field999[++class69.field1003 - 1] = var12.field17.field29;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}
}
