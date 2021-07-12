package client;

public class class28 {
	static class125 field248;
	static class95 field244;
	static class135 field249;
	static PaletteSprite[] field237;
	static String field238;
	static final int field241 = 1001;
	static final int field247 = 12;
	final class22 field246;
	public final int field240;
	int field235;
	public final class226 field243;
	public final class226 field236;
	final int field242;
	int field245;
	final int field239;

	class28(int var1, class226 var2, class226 var3, class22 var4) {
		this.field240 = var1;
		this.field243 = var2;
		this.field236 = var3;
		this.field246 = var4;
		class255 var5 = class255.field3246[this.field240];
		Sprite var6 = var5.method4815(false, (byte) 64);
		if (var6 != null) {
			this.field242 = var6.width;
			this.field239 = var6.height;
		} else {
			this.field242 = 0;
			this.field239 = 0;
		}

	}

	boolean method465(int var1, int var2, int var3) {
		class255 var4 = class255.field3246[this.field240];
		switch (var4.field3252.field3482) {
			case 0:
				if (var1 >= this.field235 - this.field242 / 2 && var1 <= this.field242 / 2 + this.field235) {
					break;
				}

				return false;
			case 1:
				if (var1 > this.field235 - this.field242 && var1 <= this.field235) {
					break;
				}

				return false;
			case 2:
				if (var1 < this.field235 || var1 >= this.field235 + this.field242) {
					return false;
				}
		}

		switch (var4.field3253.field3223) {
			case 0:
				if (var2 >= this.field245 && var2 < this.field245 + this.field239) {
					break;
				}

				return false;
			case 1:
				if (var2 < this.field245 - this.field239 / 2 || var2 > this.field239 / 2 + this.field245) {
					return false;
				}
				break;
			case 2:
				if (var2 <= this.field245 - this.field239 || var2 > this.field245) {
					return false;
				}
		}

		return true;
	}

	boolean method466(int var1, int var2, byte var3) {
		return this.field246 == null ? false : (var1 >= this.field235 - this.field246.field184 / 2 && var1 <= this.field246.field184 / 2 + this.field235 ? var2 >= this.field245 && var2 <= this.field246.field182 + this.field245 : false);
	}

	boolean method464(int var1, int var2, int var3) {
		return this.method465(var1, var2, -1022312970) ? true : this.method466(var1, var2, (byte) -43);
	}

	static final void method475(int var0) {
		Object var10000 = null;
		String var1 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
		class143.method3172(30, "", var1);
	}

	static final void method467(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
		Rasterizer2D.method5720(var2, var3, var4, var5);
		class122.method2862();

		for (int var10 = 0; var10 < var0.length; var10++) {
			if (var9 == -738682956) {
				return;
			}

			Widget var11 = var0[var10];
			if (var11 != null) {
				if (var11.parentHash != var1) {
					if (var1 != -1412584499) {
						continue;
					}

					if (var11 != GameClient.field583) {
						if (var9 == -738682956) {
							return;
						}
						continue;
					}
				}

				int var12;
				if (var8 == -1) {
					if (var9 == -738682956) {
						return;
					}

					GameClient.field786[GameClient.field603] = var11.field2618 + var6;
					GameClient.field787[GameClient.field603] = var7 + var11.int447;
					GameClient.field641[GameClient.field603] = var11.int472;
					GameClient.field789[GameClient.field603] = var11.int466;
					var12 = ++GameClient.field603 - 1;
				} else {
					var12 = var8;
				}

				var11.int504 = var12;
				var11.int473 = GameClient.field591;
				if (!var11.decodeCs2 || !class81.method1885(var11, (byte) -27)) {
					int var13;
					if (var11.interactType > 0) {
						var13 = var11.interactType;
						if (var13 == 324) {
							if (GameClient.field842 == -1) {
								GameClient.field842 = var11.spriteId;
								GameClient.field586 = var11.field2641;
							}

							if (GameClient.field841.field2571) {
								if (var9 == -738682956) {
									return;
								}

								var11.spriteId = GameClient.field842;
							} else {
								var11.spriteId = GameClient.field586;
							}
						} else if (var13 == 325) {
							if (GameClient.field842 == -1) {
								GameClient.field842 = var11.spriteId;
								GameClient.field586 = var11.field2641;
							}

							if (GameClient.field841.field2571) {
								var11.spriteId = GameClient.field586;
							} else {
								var11.spriteId = GameClient.field842;
							}
						} else if (var13 == 327) {
							var11.rotationX = 150;
							var11.rotationY = (int) (Math.sin((double) GameClient.field591 / 40.0D) * 256.0D) & 2047;
							var11.mediaType = 5;
							var11.mediaID = 0;
						} else if (var13 == 328) {
							var11.rotationX = 150;
							var11.rotationY = (int) (Math.sin((double) GameClient.field591 / 40.0D) * 256.0D) & 2047;
							var11.mediaType = 5;
							var11.mediaID = 1;
						}
					}

					var13 = var11.field2618 + var6;
					int var14 = var7 + var11.int447;
					int var15 = var11.alpha;
					int var16;
					int var17;
					if (var11 == GameClient.field583) {
						if (var1 != -1412584499 && !var11.bool47) {
							class132.field1814 = var0;
							class297.field3687 = var6;
							class1.field15 = var7;
							continue;
						}

						if (GameClient.field763 && GameClient.field601) {
							var16 = class48.field425;
							var17 = class48.field426 * 673804999;
							var16 -= GameClient.field753;
							var17 -= GameClient.field749;
							if (var16 < GameClient.field757) {
								var16 = GameClient.field757;
							}

							if (var16 + var11.int472 > GameClient.field757 + GameClient.field752.int472) {
								if (var9 == -738682956) {
									return;
								}

								var16 = GameClient.field757 + GameClient.field752.int472 - var11.int472;
							}

							if (var17 < GameClient.field758) {
								if (var9 == -738682956) {
									return;
								}

								var17 = GameClient.field758;
							}

							if (var17 + var11.int466 > GameClient.field758 + GameClient.field752.int466) {
								var17 = GameClient.field758 + GameClient.field752.int466 - var11.int466;
							}

							var13 = var16;
							var14 = var17;
						}

						if (!var11.bool47) {
							var15 = 128;
						}
					}

					int var10000;
					int var18;
					int var19;
					int var20;
					int var21;
					int var22;
					int var23;
					if (var11.widgetType == 2) {
						var16 = var2;
						var17 = var3;
						var18 = var4;
						var19 = var5;
					} else if (var11.widgetType == 9) {
						var20 = var13;
						var21 = var14;
						var22 = var13 + var11.int472;
						var23 = var14 + var11.int466;
						if (var22 < var13) {
							if (var9 == -738682956) {
								return;
							}

							var20 = var22;
							var22 = var13;
						}

						if (var23 < var14) {
							if (var9 == -738682956) {
								return;
							}

							var21 = var23;
							var23 = var14;
						}

						++var22;
						++var23;
						var16 = var20 > var2 ? var20 : var2;
						var17 = var21 > var3 ? var21 : var3;
						if (var22 < var4) {
							if (var9 == -738682956) {
								return;
							}

							var10000 = var22;
						} else {
							var10000 = var4;
						}

						var18 = var10000;
						var19 = var23 < var5 ? var23 : var5;
					} else {
						var20 = var13 + var11.int472;
						var21 = var14 + var11.int466;
						if (var13 > var2) {
							if (var9 == -738682956) {
								return;
							}

							var10000 = var13;
						} else {
							var10000 = var2;
						}

						var16 = var10000;
						var17 = var14 > var3 ? var14 : var3;
						var18 = var20 < var4 ? var20 : var4;
						var19 = var21 < var5 ? var21 : var5;
					}

					if (var11.decodeCs2) {
						if (var16 >= var18) {
							continue;
						}

						if (var17 >= var19) {
							if (var9 == -738682956) {
								return;
							}
							continue;
						}
					}

					int var24;
					int var26;
					int var27;
					int var28;
					int var29;
					int var30;
					int var31;
					int var32;
					int var34;
					int var35;
					int var36;
					int var38;
					int var40;
					int var41;
					int var42;
					int var44;
					int var45;
					int var46;
					int var50;
					int var53;
					if (var11.interactType != 0) {
						if (var11.interactType == 1336) {
							if (GameClient.field597) {
								var14 += 15;
								class63.field933.method5524("Fps:" + GameShell.field393, var13 + var11.int472, var14, 16776960, -1);
								var14 += 15;
								Runtime var69 = Runtime.getRuntime();
								var21 = (int) ((var69.totalMemory() - var69.freeMemory()) / 1024L);
								var22 = 16776960;
								if (var21 > 327680 && !GameClient.field585) {
									var22 = 16711680;
								}

								class63.field933.method5524("Mem:" + var21 + "k", var13 + var11.int472, var14, var22, -1);
								var14 += 15;
							}
							continue;
						}

						if (var11.interactType == 1337) {
							GameClient.field729 = var13;
							GameClient.field730 = var14;
							var22 = var11.int472;
							var23 = var11.int466;
							++GameClient.field687;
							class148.method3198();
							class162.method3380((byte) 2);
							class54.method1019((byte) -93);
							class24.method424(true, -1818336157);
							class67.method1655(1786186478);
							class24.method424(false, -1818336157);

							for (class79 var71 = (class79) GameClient.field710.method4098(); var71 != null; var71 = (class79) GameClient.field710.method4079()) {
								if (var71.field1121 == class13.field82 && GameClient.field591 <= var71.field1127) {
									if (GameClient.field591 >= var71.field1126) {
										if (var71.field1135 > 0) {
											Npc var60 = GameClient.field843[var71.field1135 - 1];
											if (var60 != null && var60.field931 >= 0 && var60.field931 < 13312 && var60.field881 >= 0 && var60.field881 < 13312) {
												var71.method1849(var60.field931, var60.field881, class27.method460(var60.field931, var60.field881, var71.field1121, -1573436795) - var71.field1123, GameClient.field591, 1078453344);
											}
										}

										if (var71.field1135 < 0) {
											var26 = -var71.field1135 - 1;
											Player var61;
											if (var26 == GameClient.field628) {
												var61 = class138.field1876;
											} else {
												var61 = GameClient.field610[var26];
											}

											if (var61 != null) {
												if (var9 == -738682956) {
													return;
												}

												if (var61.field931 >= 0 && var61.field931 < 13312 && var61.field881 >= 0 && var61.field881 < 13312) {
													if (var9 == -738682956) {
														return;
													}

													var71.method1849(var61.field931, var61.field881, class27.method460(var61.field931, var61.field881, var71.field1121, -1804521343) - var71.field1123, GameClient.field591, -769144122);
												}
											}
										}

										var71.method1850(GameClient.field700, -1768751642);
										field248.method2883(class13.field82, (int) var71.field1144, (int) var71.field1125, (int) var71.field1137, 60, var71, var71.field1140, -1L, false);
									}
								} else {
									var71.unlink();
								}
							}

							for (class70 var72 = (class70) GameClient.field711.method4098(); var72 != null; var72 = (class70) GameClient.field711.method4079()) {
								if (var9 == -738682956) {
									return;
								}

								if (var72.field1014 == class13.field82 && !var72.field1021) {
									if (GameClient.field591 >= var72.field1012) {
										var72.method1771(GameClient.field700, (byte) -58);
										if (var72.field1021) {
											if (var9 == -738682956) {
												return;
											}

											var72.unlink();
										} else {
											field248.method2883(var72.field1014, var72.field1015, var72.field1016, var72.field1017, 60, var72, 0, -1L, false);
										}
									}
								} else {
									var72.unlink();
								}
							}

							class43.method714(var13, var14, var22, var23, true, 2123332164);
							var20 = GameClient.field762;
							var21 = GameClient.field837;
							var22 = GameClient.field838;
							var23 = GameClient.field662;
							Rasterizer2D.method5720(var20, var21, var22 + var20, var23 + var21);
							class122.method2862();
							if (!GameClient.field822) {
								if (var9 == -738682956) {
									return;
								}

								var24 = GameClient.field649;
								if (GameClient.field738 / 256 > var24) {
									var24 = GameClient.field738 / 256;
								}

								if (GameClient.field823[4] && GameClient.field825[4] + 128 > var24) {
									if (var9 == -738682956) {
										return;
									}

									var24 = GameClient.field825[4] + 128;
								}

								var50 = GameClient.field717 & 2047;
								class49.method951(class109.field1428, ItemDef.field3478, class2.field23, var24, var50, var24 * 3 + 600, (byte) 35);
							}

							if (!GameClient.field822) {
								if (var9 == -738682956) {
									return;
								}

								var24 = class12.method108(65280);
							} else {
								if (class10.field61.field960) {
									var50 = class13.field82;
								} else {
									var26 = class27.method460(class109.field1431, class226.field2563, class13.field82, 1491299960);
									if (var26 - class123.field1702 < 800 && (class50.field443[class13.field82][class109.field1431 >> 7][class226.field2563 >> 7] & 4) != 0) {
										var50 = class13.field82;
									} else {
										var50 = 3;
									}
								}

								var24 = var50;
							}

							var50 = class109.field1431;
							var26 = class123.field1702;
							var27 = class226.field2563;
							var28 = class7.field41;
							var29 = class85.field1201;

							for (var30 = 0; var30 < 5; var30++) {
								if (GameClient.field823[var30]) {
									var31 = (int) (Math.random() * (double) (GameClient.field824[var30] * 2 + 1) - (double) GameClient.field824[var30] + Math.sin((double) GameClient.field705[var30] * ((double) GameClient.field826[var30] / 100.0D)) * (double) GameClient.field825[var30]);
									if (var30 == 0) {
										class109.field1431 += var31;
									}

									if (var30 == 1) {
										if (var9 == -738682956) {
											return;
										}

										class123.field1702 += var31;
									}

									if (var30 == 2) {
										if (var9 == -738682956) {
											return;
										}

										class226.field2563 += var31;
									}

									if (var30 == 3) {
										if (var9 == -738682956) {
											return;
										}

										class85.field1201 = var31 + class85.field1201 & 2047;
									}

									if (var30 == 4) {
										class7.field41 += var31;
										if (class7.field41 < 128) {
											if (var9 == -738682956) {
												return;
											}

											class7.field41 = 128;
										}

										if (class7.field41 > 383) {
											if (var9 == -738682956) {
												return;
											}

											class7.field41 = 383;
										}
									}
								}
							}

							var30 = class48.field425;
							var31 = class48.field426 * 673804999;
							if (class48.field431 != 0) {
								var30 = class48.field432;
								var31 = class48.field428;
							}

							label1618:
							{
								if (var30 >= var20 && var30 < var20 + var22 && var31 >= var21) {
									if (var9 == -738682956) {
										return;
									}

									if (var31 < var21 + var23) {
										GameShell.method913(var30 - var20, var31 - var21, (byte) 0);
										break label1618;
									}
								}

								class120.field1650 = false;
								class120.field1656 = 0;
							}

							class54.method1017(2135430291);
							Rasterizer2D.method5763(var20, var21, var22, var23, 0);
							class54.method1017(2138690876);
							var32 = class122.field1678;
							class122.field1678 = GameClient.field840;
							field248.method2912(class109.field1431, class123.field1702, class226.field2563, class7.field41, class85.field1201, var24);
							class122.field1678 = var32;
							class54.method1017(2110283382);
							field248.method3017();
							GameClient.field667 = 0;
							boolean var63 = false;
							var34 = -1;
							var35 = -1;
							var36 = class81.field1167;
							int[] var37 = class81.field1159;

							for (var38 = 0; var38 < var36 + GameClient.field622; var38++) {
								Object var39;
								if (var38 < var36) {
									var39 = GameClient.field610[var37[var38]];
									if (var37[var38] == GameClient.field707) {
										if (var9 == -738682956) {
											return;
										}

										var63 = true;
										var34 = var38;
										continue;
									}

									if (var39 == class138.field1876) {
										var35 = var38;
										continue;
									}
								} else {
									var39 = GameClient.field843[GameClient.field639[var38 - var36]];
								}

								class35.method628((class63) var39, var38, var20, var21, var22, var23, (byte) 13);
							}

							if (GameClient.field699) {
								if (var9 == -738682956) {
									return;
								}

								if (var35 != -1) {
									class35.method628(class138.field1876, var35, var20, var21, var22, var23, (byte) 14);
								}
							}

							if (var63) {
								class35.method628(GameClient.field610[GameClient.field707], var34, var20, var21, var22, var23, (byte) 2);
							}

							for (var38 = 0; var38 < GameClient.field667; var38++) {
								var53 = GameClient.field669[var38];
								var40 = GameClient.field670[var38];
								var41 = GameClient.field672[var38];
								var42 = GameClient.field671[var38];
								boolean var64 = true;

								while (var64) {
									var64 = false;

									for (var44 = 0; var44 < var38; var44++) {
										if (var40 + 2 > GameClient.field670[var44] - GameClient.field671[var44] && var40 - var42 < GameClient.field670[var44] + 2 && var53 - var41 < GameClient.field672[var44] + GameClient.field669[var44] && var41 + var53 > GameClient.field669[var44] - GameClient.field672[var44] && GameClient.field670[var44] - GameClient.field671[var44] < var40) {
											var40 = GameClient.field670[var44] - GameClient.field671[var44];
											var64 = true;
										}
									}
								}

								GameClient.field679 = GameClient.field669[var38];
								GameClient.field680 = GameClient.field670[var38] = var40;
								String var54 = GameClient.field721[var38];
								if (GameClient.field742 == 0) {
									if (var9 == -738682956) {
										return;
									}

									var45 = 16776960;
									if (GameClient.field673[var38] < 6) {
										var45 = GameClient.field731[GameClient.field673[var38]];
									}

									if (GameClient.field673[var38] == 6) {
										if (GameClient.field687 % 20 < 10) {
											if (var9 == -738682956) {
												return;
											}

											var10000 = 16711680;
										} else {
											var10000 = 16776960;
										}

										var45 = var10000;
									}

									if (GameClient.field673[var38] == 7) {
										var45 = GameClient.field687 % 20 < 10 ? 255 : 65535;
									}

									if (GameClient.field673[var38] == 8) {
										if (var9 == -738682956) {
											return;
										}

										if (GameClient.field687 % 20 < 10) {
											if (var9 == -738682956) {
												return;
											}

											var10000 = 45056;
										} else {
											var10000 = 8454016;
										}

										var45 = var10000;
									}

									if (GameClient.field673[var38] == 9) {
										var46 = 150 - GameClient.field675[var38];
										if (var46 < 50) {
											if (var9 == -738682956) {
												return;
											}

											var45 = var46 * 1280 + 16711680;
										} else if (var46 < 100) {
											var45 = 16776960 - (var46 - 50) * 327680;
										} else if (var46 < 150) {
											if (var9 == -738682956) {
												return;
											}

											var45 = (var46 - 100) * 5 + 65280;
										}
									}

									if (GameClient.field673[var38] == 10) {
										if (var9 == -738682956) {
											return;
										}

										var46 = 150 - GameClient.field675[var38];
										if (var46 < 50) {
											var45 = var46 * 5 + 16711680;
										} else if (var46 < 100) {
											if (var9 == -738682956) {
												return;
											}

											var45 = 16711935 - (var46 - 50) * 327680;
										} else if (var46 < 150) {
											var45 = (var46 - 100) * 327680 + 255 - (var46 - 100) * 5;
										}
									}

									if (GameClient.field673[var38] == 11) {
										var46 = 150 - GameClient.field675[var38];
										if (var46 < 50) {
											if (var9 == -738682956) {
												return;
											}

											var45 = 16777215 - var46 * 327685;
										} else if (var46 < 100) {
											var45 = (var46 - 50) * 327685 + 65280;
										} else if (var46 < 150) {
											var45 = 16777215 - (var46 - 100) * 327680;
										}
									}

									if (GameClient.field674[var38] == 0) {
										if (var9 == -738682956) {
											return;
										}

										class293.field3660.drawStr(var54, var20 + GameClient.field679, var21 + GameClient.field680, var45, 0);
									}

									if (GameClient.field674[var38] == 1) {
										class293.field3660.method5609(var54, var20 + GameClient.field679, var21 + GameClient.field680, var45, 0, GameClient.field687);
									}

									if (GameClient.field674[var38] == 2) {
										class293.field3660.method5575(var54, var20 + GameClient.field679, var21 + GameClient.field680, var45, 0, GameClient.field687);
									}

									if (GameClient.field674[var38] == 3) {
										class293.field3660.method5539(var54, var20 + GameClient.field679, var21 + GameClient.field680, var45, 0, GameClient.field687, 150 - GameClient.field675[var38]);
									}

									if (GameClient.field674[var38] == 4) {
										var46 = (150 - GameClient.field675[var38]) * (class293.field3660.method5517(var54) + 100) / 150;
										Rasterizer2D.method5790(var20 + GameClient.field679 - 50, var21, var20 + GameClient.field679 + 50, var21 + var23);
										class293.field3660.method5522(var54, var20 + GameClient.field679 + 50 - var46, var21 + GameClient.field680, var45, 0);
										Rasterizer2D.method5720(var20, var21, var20 + var22, var23 + var21);
									}

									if (GameClient.field674[var38] == 5) {
										var46 = 150 - GameClient.field675[var38];
										int var47 = 0;
										if (var46 < 25) {
											var47 = var46 - 25;
										} else if (var46 > 125) {
											var47 = var46 - 125;
										}

										Rasterizer2D.method5790(var20, var21 + GameClient.field680 - class293.field3660.field3695 - 1, var22 + var20, var21 + GameClient.field680 + 5);
										class293.field3660.drawStr(var54, var20 + GameClient.field679, var47 + var21 + GameClient.field680, var45, 0);
										Rasterizer2D.method5720(var20, var21, var20 + var22, var21 + var23);
									}
								} else {
									class293.field3660.drawStr(var54, var20 + GameClient.field679, var21 + GameClient.field680, 16776960, 0);
								}
							}

							if (GameClient.field599 == 2) {
								class238.method4594((GameClient.field602 - class62.baseX << 7) + GameClient.field605, (GameClient.field818 - GameClient.baseY << 7) + GameClient.field637, GameClient.field604 * 2, 111587198);
								if (GameClient.field679 > -1 && GameClient.field591 % 20 < 10) {
									class150.field1926[0].method5851(var20 + GameClient.field679 - 12, var21 + GameClient.field680 - 28);
								}
							}

							((class111) class122.field1667).method2537(GameClient.field700, (byte) 0);
							class16.method158(var20, var21, var22, var23, -327616642);
							class109.field1431 = var50;
							class123.field1702 = var26;
							class226.field2563 = var27;
							class7.field41 = var28;
							class85.field1201 = var29;
							if (GameClient.field625 && class185.method3786(true, false, -249249572) == 0) {
								if (var9 == -738682956) {
									return;
								}

								GameClient.field625 = false;
							}

							if (GameClient.field625) {
								if (var9 == -738682956) {
									return;
								}

								Rasterizer2D.method5763(var20, var21, var22, var23, 0);
								class83.method1933("Loading - please wait.", false, 1166040522);
							}

							GameClient.staticBoolArray6[var11.int504] = true;
							Rasterizer2D.method5720(var2, var3, var4, var5);
							continue;
						}

						if (var11.interactType == 1338) {
							class173.method3473(var11, var13, var14, var12, (short) -9115);
							Rasterizer2D.method5720(var2, var3, var4, var5);
							continue;
						}

						if (var11.interactType == 1339) {
							if (var9 == -738682956) {
								return;
							}

							class224 var68 = var11.method4517(false, -957474508);
							if (var68 != null) {
								if (GameClient.field810 < 3) {
									if (var9 == -738682956) {
										return;
									}

									class128.field1791.method5845(var13, var14, var68.field2553, var68.field2549, 25, 25, GameClient.field717, 256, var68.field2551, var68.field2550);
								} else {
									Rasterizer2D.method5742(var13, var14, 0, var68.field2551, var68.field2550);
								}
							}

							Rasterizer2D.method5720(var2, var3, var4, var5);
							continue;
						}

						if (var11.interactType == 1400) {
							class53.field476.method6018(var13, var14, var11.int472, var11.int466, GameClient.field591, 115608881);
						}

						if (var11.interactType == 1401) {
							if (var9 == -738682956) {
								return;
							}

							class53.field476.method6022(var13, var14, var11.int472, var11.int466, (byte) -56);
						}
					}

					boolean var58;
					if (var11.widgetType == 0) {
						if (!var11.decodeCs2) {
							if (var9 == -738682956) {
								return;
							}

							var58 = var11.hidden;
							if (var58 && var11 != class143.field1897) {
								continue;
							}
						}

						if (!var11.decodeCs2) {
							if (var11.scrollY > var11.scrollHeight - var11.int466) {
								var11.scrollY = var11.scrollHeight - var11.int466;
							}

							if (var11.scrollY < 0) {
								var11.scrollY = 0;
							}
						}

						method467(var0, var11.interfaceHash, var16, var17, var18, var19, var13 - var11.field2626, var14 - var11.scrollY, var12, 1436094149);
						if (var11.children != null) {
							if (var9 == -738682956) {
								return;
							}

							method467(var11.children, var11.interfaceHash, var16, var17, var18, var19, var13 - var11.field2626, var14 - var11.scrollY, var12, -1200897538);
						}

						class55 var48 = (class55) GameClient.field741.get((long) var11.interfaceHash);
						if (var48 != null) {
							class35.method630(var48.field501, var16, var17, var18, var19, var13, var14, var12, (byte) 46);
						}

						Rasterizer2D.method5720(var2, var3, var4, var5);
						class122.method2862();
					}

					if (!GameClient.field792) {
						if (var9 == -738682956) {
							return;
						}

						if (!GameClient.field723[var12] && GameClient.field790 <= 1) {
							continue;
						}
					}

					if (var11.widgetType == 0) {
						if (var9 == -738682956) {
							return;
						}

						if (!var11.decodeCs2 && var11.scrollHeight > var11.int466) {
							var20 = var13 + var11.int472;
							var21 = var11.scrollY;
							var22 = var11.int466;
							var23 = var11.scrollHeight;
							class243.field3139[0].method5829(var20, var14);
							class243.field3139[1].method5829(var20, var22 + var14 - 16);
							Rasterizer2D.method5763(var20, var14 + 16, 16, var22 - 32, GameClient.field643);
							var24 = var22 * (var22 - 32) / var23;
							if (var24 < 8) {
								var24 = 8;
							}

							var50 = var21 * (var22 - 32 - var24) / (var23 - var22);
							Rasterizer2D.method5763(var20, var14 + var50 + 16, 16, var24, GameClient.field584);
							Rasterizer2D.method5738(var20, var50 + var14 + 16, var24, GameClient.field646);
							Rasterizer2D.method5738(var20 + 1, var14 + var50 + 16, var24, GameClient.field646);
							Rasterizer2D.method5736(var20, var14 + var50 + 16, 16, GameClient.field646);
							Rasterizer2D.method5736(var20, var50 + var14 + 17, 16, GameClient.field646);
							Rasterizer2D.method5738(var20 + 15, var14 + var50 + 16, var24, GameClient.field836);
							Rasterizer2D.method5738(var20 + 14, var50 + var14 + 17, var24 - 1, GameClient.field836);
							Rasterizer2D.method5736(var20, var14 + var50 + var24 + 15, 16, GameClient.field836);
							Rasterizer2D.method5736(var20 + 1, var50 + var14 + var24 + 14, 15, GameClient.field836);
						}
					}

					if (var11.widgetType != 1) {
						if (var11.widgetType == 2) {
							var20 = 0;

							for (var21 = 0; var21 < var11.height; var21++) {
								for (var22 = 0; var22 < var11.width; var22++) {
									var23 = var13 + var22 * (var11.field2672 + 32);
									var24 = var21 * (var11.field2673 + 32) + var14;
									if (var20 < 20) {
										if (var9 == -738682956) {
											return;
										}

										var23 += var11.field2685[var20];
										var24 += var11.field2738[var20];
									}

									if (var11.field2724[var20] <= 0) {
										if (var11.field2676 != null && var20 < 20) {
											Sprite var59 = var11.method4509(var20, -1216140087);
											if (var59 != null) {
												var59.method5851(var23, var24);
											} else if (Widget.field2603) {
												if (var9 == -738682956) {
													return;
												}

												GameClient.requestRedraw(var11);
											}
										}
									} else {
										label1851:
										{
											label1814:
											{
												boolean var73 = false;
												boolean var62 = false;
												var27 = var11.field2724[var20] - 1;
												if (var23 + 32 > var2) {
													if (var9 == -738682956) {
														return;
													}

													if (var23 < var4 && var24 + 32 > var3) {
														if (var24 < var5) {
															break label1814;
														}

														if (var9 == -738682956) {
															return;
														}
													}
												}

												if (var11 != class276.field3559 || var20 != GameClient.field688) {
													break label1851;
												}
											}

											Sprite var51;
											label1683:
											{
												if (GameClient.field733 == 1) {
													if (var9 == -738682956) {
														return;
													}

													if (var20 == class13.field84 && var11.interfaceHash == class187.field2372) {
														if (var9 == -738682956) {
															return;
														}

														var51 = class21.method276(var27, var11.field2725[var20], 2, 0, 2, false, 445296746);
														break label1683;
													}
												}

												var51 = class21.method276(var27, var11.field2725[var20], 1, 3153952, 2, false, -1686094834);
											}

											if (var51 != null) {
												if (var11 == class276.field3559 && var20 == GameClient.field688) {
													if (var9 == -738682956) {
														return;
													}

													var50 = class48.field425 - GameClient.field678;
													var26 = class48.field426 * 673804999 - GameClient.field821;
													if (var50 < Custom.DRAG_THRESHOLD) {
														if (var9 == -738682956) {
															return;
														}

														if (var50 > -Custom.DRAG_THRESHOLD) {
															if (var9 == -738682956) {
																return;
															}

															var50 = 0;
														}
													}

													if (var26 < Custom.DRAG_THRESHOLD && var26 > -Custom.DRAG_THRESHOLD) {
														if (var9 == -738682956) {
															return;
														}

														var26 = 0;
													}

													if (GameClient.field693 < Custom.DRAG_THRESHOLD) {
														var50 = 0;
														var26 = 0;
													}

													var51.method5857(var50 + var23, var24 + var26, 128);
													if (var1 != -1) {
														Widget var52 = var0[var1 & 65535];
														if (var26 + var24 < Rasterizer2D.field3763) {
															if (var9 == -738682956) {
																return;
															}

															if (var52.scrollY > 0) {
																var30 = (Rasterizer2D.field3763 - var24 - var26) * GameClient.field700 / 3;
																if (var30 > GameClient.field700 * 10) {
																	var30 = GameClient.field700 * 10;
																}

																if (var30 > var52.scrollY) {
																	var30 = var52.scrollY;
																}

																var52.scrollY -= var30;
																GameClient.field821 += var30;
																GameClient.requestRedraw(var52);
															}
														}

														if (var26 + var24 + 32 > Rasterizer2D.field3764 && var52.scrollY < var52.scrollHeight - var52.int466) {
															if (var9 == -738682956) {
																return;
															}

															var30 = (var26 + var24 + 32 - Rasterizer2D.field3764) * GameClient.field700 / 3;
															if (var30 > GameClient.field700 * 10) {
																if (var9 == -738682956) {
																	return;
																}

																var30 = GameClient.field700 * 10;
															}

															if (var30 > var52.scrollHeight - var52.int466 - var52.scrollY) {
																var30 = var52.scrollHeight - var52.int466 - var52.scrollY;
															}

															var52.scrollY += var30;
															GameClient.field821 -= var30;
															GameClient.requestRedraw(var52);
														}
													}
												} else if (var11 == class240.field3096 && var20 == GameClient.field582) {
													var51.method5857(var23, var24, 128);
												} else {
													var51.method5851(var23, var24);
												}
											} else {
												GameClient.requestRedraw(var11);
											}
										}
									}

									++var20;
								}
							}
						} else if (var11.widgetType == 3) {
							if (class132.method3097(var11, -2063892769)) {
								if (var9 == -738682956) {
									return;
								}

								var20 = var11.field2631;
								if (var11 == class143.field1897 && var11.field2633 != 0) {
									var20 = var11.field2633;
								}
							} else {
								var20 = var11.color;
								if (var11 == class143.field1897) {
									if (var9 == -738682956) {
										return;
									}

									if (var11.field2632 != 0) {
										if (var9 == -738682956) {
											return;
										}

										var20 = var11.field2632;
									}
								}
							}

							if (var11.filled) {
								switch (var11.field2701.field3776) {
									case 1:
										Rasterizer2D.method5728(var13, var14, var11.int472, var11.int466, var11.color, var11.field2631, 256 - (var11.alpha & 255), 256 - (var11.field2608 & 255));
										break;
									case 2:
										Rasterizer2D.method5729(var13, var14, var11.int472, var11.int466, var11.color, var11.field2631, 256 - (var11.alpha & 255), 256 - (var11.field2608 & 255));
										break;
									case 3:
										Rasterizer2D.method5739(var13, var14, var11.int472, var11.int466, var11.color, var11.field2631, 256 - (var11.alpha & 255), 256 - (var11.field2608 & 255));
										break;
									case 4:
										Rasterizer2D.method5726(var13, var14, var11.int472, var11.int466, var11.color, var11.field2631, 256 - (var11.alpha & 255), 256 - (var11.field2608 & 255));
										break;
									default:
										if (var15 == 0) {
											Rasterizer2D.method5763(var13, var14, var11.int472, var11.int466, var20);
										} else {
											Rasterizer2D.method5727(var13, var14, var11.int472, var11.int466, var20, 256 - (var15 & 255));
										}
								}
							} else if (var15 == 0) {
								Rasterizer2D.method5734(var13, var14, var11.int472, var11.int466, var20);
							} else {
								Rasterizer2D.method5741(var13, var14, var11.int472, var11.int466, var20, 256 - (var15 & 255));
							}
						} else {
							class298 var65;
							if (var11.widgetType == 4) {
								var65 = var11.method4545(2002416924);
								if (var65 == null) {
									if (var9 == -738682956) {
										return;
									}

									if (Widget.field2603) {
										GameClient.requestRedraw(var11);
									}
								} else {
									String var75 = var11.componentString;
									if (class132.method3097(var11, -2063892769)) {
										if (var9 == -738682956) {
											return;
										}

										var21 = var11.field2631;
										if (var11 == class143.field1897 && var11.field2633 != 0) {
											if (var9 == -738682956) {
												return;
											}

											var21 = var11.field2633;
										}

										if (var11.field2717.length() > 0) {
											var75 = var11.field2717;
										}
									} else {
										var21 = var11.color;
										if (var11 == class143.field1897 && var11.field2632 != 0) {
											var21 = var11.field2632;
										}
									}

									if (var11.decodeCs2 && var11.itemId != -1) {
										label1821:
										{
											if (var9 == -738682956) {
												return;
											}

											ItemDef var76 = ItemDef.loadItemDef(var11.itemId);
											var75 = var76.name;
											if (var75 == null) {
												var75 = "null";
											}

											if (var76.stackable != 1) {
												if (var11.field2727 == 1) {
													break label1821;
												}

												if (var9 == -738682956) {
													return;
												}
											}

											if (var11.field2727 != -1) {
												var75 = class6.method71(16748608) + var75 + "</col>" + " " + 'x' + class35.method623(var11.field2727, (byte) 1);
											}
										}
									}

									if (var11 == GameClient.field744) {
										var75 = "Please wait...";
										var21 = var11.color;
									}

									if (!var11.decodeCs2) {
										var75 = class1.method11(var75, var11, 1244240994);
									}

									var65.method5526(var75, var13, var14, var11.int472, var11.int466, var21, var11.fontShadow ? 0 : -1, var11.fontHorizontalAlignment, var11.fontVerticalAlignment, var11.lineHeight);
								}
							} else if (var11.widgetType == 5) {
								Sprite var66;
								if (!var11.decodeCs2) {
									if (var9 == -738682956) {
										return;
									}

									var66 = var11.method4508(class132.method3097(var11, -2063892769), -172671235);
									if (var66 != null) {
										var66.method5851(var13, var14);
									} else if (Widget.field2603) {
										GameClient.requestRedraw(var11);
									}
								} else {
									if (var11.itemId != -1) {
										var66 = class21.method276(var11.itemId, var11.field2727, var11.outline, var11.shadow, var11.field2664, false, 1881886762);
									} else {
										var66 = var11.method4508(false, -220935646);
									}

									if (var66 == null) {
										if (Widget.field2603) {
											GameClient.requestRedraw(var11);
										}
									} else {
										var21 = var66.maxWidth;
										var22 = var66.maxHeight;
										if (!var11.bool42) {
											var23 = var11.int472 * 4096 / var21;
											if (var11.int436 != 0) {
												var66.method5870(var11.int472 / 2 + var13, var11.int466 / 2 + var14, var11.int436, var23);
											} else if (var15 != 0) {
												if (var9 == -738682956) {
													return;
												}

												var66.method5856(var13, var14, var11.int472, var11.int466, 256 - (var15 & 255));
											} else if (var21 == var11.int472 && var22 == var11.int466) {
												var66.method5851(var13, var14);
											} else {
												var66.method5853(var13, var14, var11.int472, var11.int466);
											}
										} else {
											if (var9 == -738682956) {
												return;
											}

											Rasterizer2D.method5790(var13, var14, var13 + var11.int472, var14 + var11.int466);
											var23 = (var21 - 1 + var11.int472) / var21;
											var24 = (var22 - 1 + var11.int466) / var22;

											for (var50 = 0; var50 < var23; var50++) {
												for (var26 = 0; var26 < var24; var26++) {
													if (var9 == -738682956) {
														return;
													}

													if (var11.int436 != 0) {
														var66.method5870(var21 / 2 + var13 + var50 * var21, var22 / 2 + var14 + var22 * var26, var11.int436, 4096);
													} else if (var15 != 0) {
														if (var9 == -738682956) {
															return;
														}

														var66.method5857(var13 + var50 * var21, var14 + var22 * var26, 256 - (var15 & 255));
													} else {
														var66.method5851(var13 + var21 * var50, var14 + var22 * var26);
													}
												}
											}

											Rasterizer2D.method5720(var2, var3, var4, var5);
										}
									}
								}
							} else {
								ItemDef var49;
								if (var11.widgetType == 6) {
									var58 = class132.method3097(var11, -2063892769);
									if (var58) {
										var21 = var11.field2653;
									} else {
										var21 = var11.animation;
									}

									class119 var74 = null;
									var23 = 0;
									if (var11.itemId != -1) {
										var49 = ItemDef.loadItemDef(var11.itemId);
										if (var49 != null) {
											var49 = var49.method5094(var11.field2727);
											var74 = var49.method5093(1, -2040430719);
											if (var74 != null) {
												var74.method2670();
												var23 = var74.field1781 / 2;
											} else {
												GameClient.requestRedraw(var11);
											}
										}
									} else if (var11.mediaType == 5) {
										if (var11.mediaID == 0) {
											var74 = GameClient.field841.method4468((class273) null, -1, (class273) null, -1, 960437328);
										} else {
											var74 = class138.field1876.vmethod3067(2119202332);
										}
									} else if (var21 == -1) {
										var74 = var11.method4510((class273) null, -1, var58, class138.field1876.field546, 931323458);
										if (var74 == null && Widget.field2603) {
											GameClient.requestRedraw(var11);
										}
									} else {
										class273 var70 = class3.method25(var21, -1932645201);
										var74 = var11.method4510(var70, var11.field2728, var58, class138.field1876.field546, 931323458);
										if (var74 == null && Widget.field2603) {
											GameClient.requestRedraw(var11);
										}
									}

									class122.method2827(var11.int472 / 2 + var13, var11.int466 / 2 + var14);
									var24 = class122.field1681[var11.rotationX] * var11.zoom >> 16;
									var50 = class122.field1693[var11.rotationX] * var11.zoom >> 16;
									if (var74 != null) {
										if (!var11.decodeCs2) {
											var74.method2682(0, var11.rotationY, 0, var11.rotationX, 0, var24, var50);
										} else {
											var74.method2670();
											if (var11.bool45) {
												if (var9 == -738682956) {
													return;
												}

												var74.method2710(0, var11.rotationY, var11.int477, var11.rotationX, var11.int457, var24 + var23 + var11.int474, var50 + var11.int474, var11.zoom);
											} else {
												var74.method2682(0, var11.rotationY, var11.int477, var11.rotationX, var11.int457, var23 + var24 + var11.int474, var50 + var11.int474);
											}
										}
									}

									class122.method2832();
								} else {
									if (var11.widgetType == 7) {
										var65 = var11.method4545(-1686552059);
										if (var65 == null) {
											if (var9 == -738682956) {
												return;
											}

											if (Widget.field2603) {
												if (var9 == -738682956) {
													return;
												}

												GameClient.requestRedraw(var11);
											}
											continue;
										}

										var21 = 0;

										for (var22 = 0; var22 < var11.height; var22++) {
											for (var23 = 0; var23 < var11.width; var23++) {
												if (var11.field2724[var21] > 0) {
													if (var9 == -738682956) {
														return;
													}

													String var25;
													label1752:
													{
														var49 = ItemDef.loadItemDef(var11.field2724[var21] - 1);
														if (var49.stackable != 1) {
															if (var11.field2725[var21] == 1) {
																var25 = class6.method71(16748608) + var49.name + "</col>";
																break label1752;
															}

															if (var9 == -738682956) {
																return;
															}
														}

														var25 = class6.method71(16748608) + var49.name + "</col>" + " " + 'x' + class35.method623(var11.field2725[var21], (byte) 1);
													}

													var26 = var23 * (var11.field2672 + 115) + var13;
													var27 = var14 + (var11.field2673 + 12) * var22;
													if (var11.fontHorizontalAlignment == 0) {
														var65.method5522(var25, var26, var27, var11.color, var11.fontShadow ? 0 : -1);
													} else if (var11.fontHorizontalAlignment == 1) {
														var65.drawStr(var25, var11.int472 / 2 + var26, var27, var11.color, var11.fontShadow ? 0 : -1);
													} else {
														int var10002 = var26 + var11.int472 - 1;
														int var10004 = var11.color;
														byte var10005;
														if (var11.fontShadow) {
															if (var9 == -738682956) {
																return;
															}

															var10005 = 0;
														} else {
															var10005 = -1;
														}

														var65.method5524(var25, var10002, var27, var10004, var10005);
													}
												}

												++var21;
											}
										}
									}

									if (var11.widgetType == 8) {
										if (var9 == -738682956) {
											return;
										}

										if (var11 == class141.field1888 && GameClient.field623 == GameClient.field732) {
											var20 = 0;
											var21 = 0;
											class298 var55 = class63.field933;
											String var56 = var11.componentString;

											String var67;
											for (var56 = class1.method11(var56, var11, 1717246035); var56.length() > 0; var21 = var21 + var55.field3695 + 1) {
												var50 = var56.indexOf("<br>");
												if (var50 != -1) {
													var67 = var56.substring(0, var50);
													var56 = var56.substring(var50 + 4);
												} else {
													var67 = var56;
													var56 = "";
												}

												var26 = var55.method5517(var67);
												if (var26 > var20) {
													var20 = var26;
												}
											}

											var20 += 6;
											var21 += 7;
											var50 = var13 + var11.int472 - 5 - var20;
											var26 = var14 + var11.int466 + 5;
											if (var50 < var13 + 5) {
												var50 = var13 + 5;
											}

											if (var20 + var50 > var4) {
												var50 = var4 - var20;
											}

											if (var21 + var26 > var5) {
												var26 = var5 - var21;
											}

											Rasterizer2D.method5763(var50, var26, var20, var21, 16777120);
											Rasterizer2D.method5734(var50, var26, var20, var21, 0);
											var56 = var11.componentString;
											var27 = var26 + var55.field3695 + 2;

											for (var56 = class1.method11(var56, var11, -1859043829); var56.length() > 0; var27 = var27 + var55.field3695 + 1) {
												var28 = var56.indexOf("<br>");
												if (var28 != -1) {
													var67 = var56.substring(0, var28);
													var56 = var56.substring(var28 + 4);
												} else {
													var67 = var56;
													var56 = "";
												}

												var55.method5522(var67, var50 + 3, var27, 0, -1);
											}
										}
									}

									if (var11.widgetType == 9) {
										if (var11.bool41) {
											var20 = var13;
											var21 = var14 + var11.int466;
											var22 = var13 + var11.int472;
											var23 = var14;
										} else {
											var20 = var13;
											var21 = var14;
											var22 = var13 + var11.int472;
											var23 = var14 + var11.int466;
										}

										if (var11.int461 == 1) {
											Rasterizer2D.method5765(var20, var21, var22, var23, var11.color);
										} else {
											var26 = var11.color;
											var27 = var11.int461;
											var28 = var22 - var20;
											var29 = var23 - var21;
											var30 = var28 >= 0 ? var28 : -var28;
											var31 = var29 >= 0 ? var29 : -var29;
											var32 = var30;
											if (var30 < var31) {
												var32 = var31;
											}

											if (var32 != 0) {
												int var33 = (var28 << 16) / var32;
												var34 = (var29 << 16) / var32;
												if (var34 <= var33) {
													var33 = -var33;
												} else {
													var34 = -var34;
												}

												var35 = var27 * var34 >> 17;
												var36 = var34 * var27 + 1 >> 17;
												int var57 = var27 * var33 >> 17;
												var38 = var33 * var27 + 1 >> 17;
												var24 = var20 - Rasterizer2D.field3765;
												var50 = var21 - Rasterizer2D.field3763;
												var53 = var24 + var35;
												var40 = var24 - var36;
												var41 = var24 + var28 - var36;
												var42 = var35 + var28 + var24;
												int var43 = var50 + var57;
												var44 = var50 - var38;
												var45 = var50 + var29 - var38;
												var46 = var50 + var29 + var57;
												class122.method2793(var53, var40, var41);
												class122.method2796(var43, var44, var45, var53, var40, var41, var26);
												class122.method2793(var53, var41, var42);
												class122.method2796(var43, var45, var46, var53, var41, var42, var26);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

	static final void method474(NpcDef definition, Npc npc, int var1, int var2, int var3) {
		if (GameClient.field771 < 400) {
			if (definition.intArray106 != null) {
				definition = definition.method5189(-1834963481);
			}

			if (definition != null) {
				if (definition.bool61) {
					if (definition.bool60 && GameClient.field748 != var1) {

					} else {
						String var5 = definition.name;

						int level = Math.max(definition.combatLevel, npc.customCombatLevel);
						if (level > 0) {
							var5 = var5 + class135.method3113(level, class138.field1876.field551, 37914027) + " " + " (" + "level-" + level + ")";
						}

						if (definition.bool60 && GameClient.field725) {
							class50.method993("Examine", class6.method71(16776960) + var5, 1003, var1, var2, var3, -394538433);
						}

						if (GameClient.field733 == 1) {
							class50.method993("Use", GameClient.field734 + " " + "->" + " " + class6.method71(16776960) + var5, 7, var1, var2, var3, 319517400);
						} else if (GameClient.field785) {
							if ((class63.field932 & 2) == 2) {
								class50.method993(GameClient.field612, GameClient.field739 + " " + "->" + " " + class6.method71(16776960) + var5, 8, var1, var2, var3, 637283359);
							}
						} else {
							int var6 = definition.bool60 && GameClient.field725 ? 2000 : 0;
							String[] var7 = definition.options;
							int var8;
							int var9;
							if (var7 != null) {
								for (var8 = 4; var8 >= 0; --var8) {
									if (var7[var8] != null) {
										if (!var7[var8].equalsIgnoreCase("Attack")) {
											var9 = 0;
											if (var8 == 0) {
												var9 = var6 + 9;
											}

											if (var8 == 1) {
												var9 = var6 + 10;
											}

											if (var8 == 2) {
												var9 = var6 + 11;
											}

											if (var8 == 3) {
												var9 = var6 + 12;
											}

											if (var8 == 4) {
												var9 = var6 + 13;
											}

											class50.method993(var7[var8], class6.method71(16776960) + var5, var9, var1, var2, var3, 794599756);
										}
									}
								}
							}

							if (var7 != null) {
								for (var8 = 4; var8 >= 0; --var8) {
									if (var7[var8] != null) {
										if (var7[var8].equalsIgnoreCase("Attack")) {
											short var10 = 0;
											if (GameClient.field780 != class77.field1074) {
												label188:
												{
													if (GameClient.field780 != class77.field1075) {
														if (class77.field1080 != GameClient.field780 || level <= class138.field1876.field551) {
															break label188;
														}
													}

													var10 = 2000;
												}

												var9 = 0;
												if (var8 == 0) {
													var9 = var10 + 9;
												}

												if (var8 == 1) {
													var9 = var10 + 10;
												}

												if (var8 == 2) {
													var9 = var10 + 11;
												}

												if (var8 == 3) {
													var9 = var10 + 12;
												}

												if (var8 == 4) {
													var9 = var10 + 13;
												}

												class50.method993(var7[var8], class6.method71(16776960) + var5, var9, var1, var2, var3, 329875173);
											}
										}
									}
								}
							}

							if (!definition.bool60 || !GameClient.field725) {
								class50.method993("Examine", class6.method71(16776960) + var5, 1003, var1, var2, var3, -1598701272);
							}
						}
					}
				}
			}
		}
	}
}
