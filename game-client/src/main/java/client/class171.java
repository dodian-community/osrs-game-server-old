package client;

public class class171 {

	public static final class171 field2249 = new class171(5);
	public static final class171 field2242 = new class171(3);
	public static final class171 field2244 = new class171(7);
	public static final class171 field2243 = new class171(4);
	public static final class171 field2245 = new class171(14);
	public static final class171 field2246 = new class171(15);
	public static final class171 field2241 = new class171(6);
	public static final class171 field2248 = new class171(4);
	public static final class171 field2247 = new class171(2);
	public static final class171 field2250 = new class171(5);
	static byte[][] field2252;
	static final int field2251 = 7;

	class171(int var1) {
	}

	static final void method3451(class75 var0, int var1, int var2, int var3) {
		class39.method692(var0.field1066, var0.field1060, var0.field1061, var0.field1062, var0.field1063, var0.field1063, var1, var2, (byte) 67);
	}

	static final void method3450(int level, int localX, int localY, int objId, int rotation, int objType, class125 var6, class164 var7) {
		if (ClientObj.isRemoved(objId, localX, localY, level, objType, rotation)) return;

		if (!GameClient.field585 || (class50.field443[0][localX][localY] & 2) != 0 || (class50.field443[level][localX][localY] & 16) == 0) {
			if (level < class50.field442) {
				class50.field442 = level;
			}

			ObjectDef var9 = class110.getObjectDef(objId);
			int var10;
			int var11;
			if (rotation != 1 && rotation != 3) {
				var10 = var9.int693;
				var11 = var9.int688;
			} else {
				var10 = var9.int688;
				var11 = var9.int693;
			}

			int var12;
			int var13;
			if (var10 + localX <= 104) {
				var12 = (var10 >> 1) + localX;
				var13 = (var10 + 1 >> 1) + localX;
			} else {
				var12 = localX;
				var13 = localX + 1;
			}

			int var14;
			int var15;
			if (var11 + localY <= 104) {
				var14 = (var11 >> 1) + localY;
				var15 = localY + (var11 + 1 >> 1);
			} else {
				var14 = localY;
				var15 = localY + 1;
			}

			int[][] var16 = class50.field459[level];
			int var17 = var16[var12][var14] + var16[var13][var14] + var16[var12][var15] + var16[var13][var15] >> 2;
			int var18 = (localX << 7) + (var10 << 6);
			int var19 = (localY << 7) + (var11 << 6);
			long var20 = class76.method1804(localX, localY, 2, var9.int696 == 0, objId, 1782575928);
			int var22 = objType + (rotation << 6);
			if (var9.int706 == 1) {
				var22 += 256;
			}

			if (var9.method5024(2104848132)) {
				class181.method3528(level, localX, localY, var9, rotation, -596460194);
			}

			Object var23;
			if (objType == 22) {
				if (!GameClient.field585 || var9.int696 != 0 || var9.clipType == 1 || var9.bool73) {
					if (var9.int697 == -1 && var9.intArray116 == null) {
						var23 = var9.method5079(22, rotation, var16, var18, var17, var19, 1401656763);
					} else {
						var23 = new class85(objId, 22, rotation, level, localX, localY, var9.int697, true, (class127) null);
					}

					var6.method3009(level, localX, localY, var17, (class127) var23, var20, var22);
					if (var9.clipType == 1 && var7 != null) {
						var7.method3410(localX, localY, (byte) 90);
					}

				}
			} else {
				int var24;
				if (objType != 10 && objType != 11) {
					if (objType >= 12) {
						if (var9.int697 == -1 && var9.intArray116 == null) {
							var23 = var9.method5079(objType, rotation, var16, var18, var17, var19, 1401656763);
						} else {
							var23 = new class85(objId, objType, rotation, level, localX, localY, var9.int697, true, (class127) null);
						}

						var6.method2882(level, localX, localY, var17, 1, 1, (class127) var23, 0, var20, var22);
						if (objType <= 17 && objType != 13 && level > 0) {

							class37.field325[level][localX][localY] |= 2340;
						}

						if (var9.clipType != 0 && var7 != null) {
							var7.method3394(localX, localY, var10, var11, var9.isUnwalkable, (byte) 126);
						}

					} else if (objType == 0) {
						if (var9.int697 == -1 && var9.intArray116 == null) {

							var23 = var9.method5079(0, rotation, var16, var18, var17, var19, 1401656763);
						} else {
							var23 = new class85(objId, 0, rotation, level, localX, localY, var9.int697, true, (class127) null);
						}

						var6.method2927(level, localX, localY, var17, (class127) var23, (class127) null, class50.field450[rotation], 0, var20, var22);
						if (rotation == 0) {
							if (var9.bool69) {
								class50.field447[level][localX][localY] = 50;
								class50.field447[level][localX][localY + 1] = 50;
							}

							if (var9.bool68) {
								class37.field325[level][localX][localY] |= 585;
							}
						} else if (rotation == 1) {

							if (var9.bool69) {
								class50.field447[level][localX][localY + 1] = 50;
								class50.field447[level][localX + 1][localY + 1] = 50;
							}

							if (var9.bool68) {

								class37.field325[level][localX][localY + 1] |= 1170;
							}
						} else if (rotation == 2) {
							if (var9.bool69) {
								class50.field447[level][localX + 1][localY] = 50;
								class50.field447[level][localX + 1][localY + 1] = 50;
							}

							if (var9.bool68) {
								class37.field325[level][localX + 1][localY] |= 585;
							}
						} else if (rotation == 3) {
							if (var9.bool69) {
								class50.field447[level][localX][localY] = 50;
								class50.field447[level][localX + 1][localY] = 50;
							}

							if (var9.bool68) {
								class37.field325[level][localX][localY] |= 1170;
							}
						}

						if (var9.clipType != 0 && var7 != null) {
							var7.method3393(localX, localY, objType, rotation, var9.isUnwalkable, 1813323634);
						}

						if (var9.int698 != 16) {
							var6.method3053(level, localX, localY, var9.int698);
						}

					} else if (objType == 1) {
						if (var9.int697 == -1 && var9.intArray116 == null) {
							var23 = var9.method5079(1, rotation, var16, var18, var17, var19, 1401656763);
						} else {
							var23 = new class85(objId, 1, rotation, level, localX, localY, var9.int697, true, (class127) null);
						}

						var6.method2927(level, localX, localY, var17, (class127) var23, (class127) null, class50.field451[rotation], 0, var20, var22);
						if (var9.bool69) {
							if (rotation == 0) {
								class50.field447[level][localX][localY + 1] = 50;
							} else if (rotation == 1) {
								class50.field447[level][localX + 1][localY + 1] = 50;
							} else if (rotation == 2) {
								class50.field447[level][localX + 1][localY] = 50;
							} else if (rotation == 3) {
								class50.field447[level][localX][localY] = 50;
							}
						}

						if (var9.clipType != 0 && var7 != null) {

							var7.method3393(localX, localY, objType, rotation, var9.isUnwalkable, 1912386247);
						}

					} else {
						int var29;
						if (objType == 2) {
							var29 = rotation + 1 & 3;
							Object var30;
							Object var31;
							if (var9.int697 == -1 && var9.intArray116 == null) {
								var30 = var9.method5079(2, rotation + 4, var16, var18, var17, var19, 1401656763);
								var31 = var9.method5079(2, var29, var16, var18, var17, var19, 1401656763);
							} else {
								var30 = new class85(objId, 2, rotation + 4, level, localX, localY, var9.int697, true, (class127) null);
								var31 = new class85(objId, 2, var29, level, localX, localY, var9.int697, true, (class127) null);
							}

							var6.method2927(level, localX, localY, var17, (class127) var30, (class127) var31, class50.field450[rotation], class50.field450[var29], var20, var22);
							if (var9.bool68) {
								if (rotation == 0) {
									class37.field325[level][localX][localY] |= 585;
									class37.field325[level][localX][1 + localY] |= 1170;
								} else if (rotation == 1) {
									class37.field325[level][localX][1 + localY] |= 1170;
									class37.field325[level][localX + 1][localY] |= 585;
								} else if (rotation == 2) {
									class37.field325[level][localX + 1][localY] |= 585;
									class37.field325[level][localX][localY] |= 1170;
								} else if (rotation == 3) {
									class37.field325[level][localX][localY] |= 1170;
									class37.field325[level][localX][localY] |= 585;
								}
							}

							if (var9.clipType != 0) {

								if (var7 != null) {
									var7.method3393(localX, localY, objType, rotation, var9.isUnwalkable, 1627808892);
								}
							}

							if (var9.int698 != 16) {
								var6.method3053(level, localX, localY, var9.int698);
							}

						} else if (objType == 3) {
							if (var9.int697 == -1 && var9.intArray116 == null) {
								var23 = var9.method5079(3, rotation, var16, var18, var17, var19, 1401656763);
							} else {
								var23 = new class85(objId, 3, rotation, level, localX, localY, var9.int697, true, (class127) null);
							}

							var6.method2927(level, localX, localY, var17, (class127) var23, (class127) null, class50.field451[rotation], 0, var20, var22);
							if (var9.bool69) {
								if (rotation == 0) {
									class50.field447[level][localX][localY + 1] = 50;
								} else if (rotation == 1) {
									class50.field447[level][localX + 1][localY + 1] = 50;
								} else if (rotation == 2) {
									class50.field447[level][localX + 1][localY] = 50;
								} else if (rotation == 3) {

									class50.field447[level][localX][localY] = 50;
								}
							}

							if (var9.clipType != 0) {

								if (var7 != null) {
									var7.method3393(localX, localY, objType, rotation, var9.isUnwalkable, 1293513336);
								}
							}

						} else if (objType == 9) {
							label491:
							{
								if (var9.int697 == -1) {

									if (var9.intArray116 == null) {
										var23 = var9.method5079(objType, rotation, var16, var18, var17, var19, 1401656763);
										break label491;
									}
								}

								var23 = new class85(objId, objType, rotation, level, localX, localY, var9.int697, true, (class127) null);
							}

							var6.method2882(level, localX, localY, var17, 1, 1, (class127) var23, 0, var20, var22);
							if (var9.clipType != 0 && var7 != null) {
								var7.method3394(localX, localY, var10, var11, var9.isUnwalkable, (byte) 103);
							}

							if (var9.int698 != 16) {
								var6.method3053(level, localX, localY, var9.int698);
							}

						} else if (objType == 4) {
							if (var9.int697 == -1 && var9.intArray116 == null) {

								var23 = var9.method5079(4, rotation, var16, var18, var17, var19, 1401656763);
							} else {
								var23 = new class85(objId, 4, rotation, level, localX, localY, var9.int697, true, (class127) null);
							}

							var6.method2881(level, localX, localY, var17, (class127) var23, (class127) null, class50.field450[rotation], 0, 0, 0, var20, var22);
						} else {
							long var32;
							Object var34;
							if (objType == 5) {
								var29 = 16;
								var32 = var6.method2898(level, localX, localY);
								if (var32 != 0L) {

									var29 = class110.getObjectDef(class39.method673(var32)).int698;
								}

								if (var9.int697 == -1 && var9.intArray116 == null) {
									var34 = var9.method5079(4, rotation, var16, var18, var17, var19, 1401656763);
								} else {
									var34 = new class85(objId, 4, rotation, level, localX, localY, var9.int697, true, (class127) null);
								}

								var6.method2881(level, localX, localY, var17, (class127) var34, (class127) null, class50.field450[rotation], 0, var29 * class50.field452[rotation], var29 * class50.field453[rotation], var20, var22);
							} else if (objType == 6) {
								var29 = 8;
								var32 = var6.method2898(level, localX, localY);
								if (var32 != 0L) {
									var29 = class110.getObjectDef(class39.method673(var32)).int698 / 2;
								}

								if (var9.int697 == -1 && var9.intArray116 == null) {
									var34 = var9.method5079(4, rotation + 4, var16, var18, var17, var19, 1401656763);
								} else {
									var34 = new class85(objId, 4, rotation + 4, level, localX, localY, var9.int697, true, (class127) null);
								}

								var6.method2881(level, localX, localY, var17, (class127) var34, (class127) null, 256, rotation, var29 * class50.field458[rotation], var29 * class50.field449[rotation], var20, var22);
							} else if (objType == 7) {
								var24 = rotation + 2 & 3;
								if (var9.int697 == -1 && var9.intArray116 == null) {
									var23 = var9.method5079(4, var24 + 4, var16, var18, var17, var19, 1401656763);
								} else {
									var23 = new class85(objId, 4, var24 + 4, level, localX, localY, var9.int697, true, (class127) null);
								}

								var6.method2881(level, localX, localY, var17, (class127) var23, (class127) null, 256, var24, 0, 0, var20, var22);
							} else if (objType == 8) {
								var29 = 8;
								var32 = var6.method2898(level, localX, localY);
								if (var32 != 0L) {
									var29 = class110.getObjectDef(class39.method673(var32)).int698 / 2;
								}

								int var28 = rotation + 2 & 3;
								Object var27;
								if (var9.int697 == -1 && var9.intArray116 == null) {
									var34 = var9.method5079(4, rotation + 4, var16, var18, var17, var19, 1401656763);
									var27 = var9.method5079(4, var28 + 4, var16, var18, var17, var19, 1401656763);
								} else {
									var34 = new class85(objId, 4, rotation + 4, level, localX, localY, var9.int697, true, (class127) null);
									var27 = new class85(objId, 4, var28 + 4, level, localX, localY, var9.int697, true, (class127) null);
								}

								var6.method2881(level, localX, localY, var17, (class127) var34, (class127) var27, 256, rotation, var29 * class50.field458[rotation], var29 * class50.field449[rotation], var20, var22);
							}
						}
					}
				} else {
					if (var9.int697 == -1 && var9.intArray116 == null) {
						var23 = var9.method5079(10, rotation, var16, var18, var17, var19, 1401656763);
					} else {
						var23 = new class85(objId, 10, rotation, level, localX, localY, var9.int697, true, (class127) null);
					}

					if (var23 != null && var6.method2882(level, localX, localY, var17, var10, var11, (class127) var23, objType == 11 ? 256 : 0, var20, var22) && var9.bool69) {
						var24 = 15;
						if (var23 instanceof class119) {

							var24 = ((class119) var23).method2672() / 4;
							if (var24 > 30) {
								var24 = 30;
							}
						}

						for (int var25 = 0; var25 <= var10; var25++) {
							for (int var26 = 0; var26 <= var11; var26++) {
								if (var24 > class50.field447[level][var25 + localX][var26 + localY]) {
									class50.field447[level][var25 + localX][var26 + localY] = (byte) var24;
								}
							}
						}
					}

					if (var9.clipType != 0 && var7 != null) {

						var7.method3394(localX, localY, var10, var11, var9.isUnwalkable, (byte) 127);
					}

				}
			}
		}
	}
}
