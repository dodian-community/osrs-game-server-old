package client;

public class class15 implements class188 {
	static final class15 field106 = new class15(1, (byte) 3);
	static final class15 field108 = new class15(2, (byte) 0);
	static final class15 field107 = new class15(3, (byte) 1);
	static final class15 field112 = new class15(0, (byte) 2);
	public static final int field109 = 50;
	static final int field113 = 15;
	static final int field114 = 2097152;
	public static final int field115 = 82;
	final byte field111;
	final int field110;

	class15(int var1, byte var2) {
		this.field110 = var1;
		this.field111 = var2;
	}

	public int vmethod5815(byte var1) {
		return this.field111;
	}

	static class15[] method145(int var0) {
		return new class15[]{field106, field107, field108, field112};
	}

	static final void method148(int var0) {
		class14.method137(false, (byte) 16);
		GameClient.field633 = 0;
		boolean var1 = true;

		int var2;
		for (var2 = 0; var2 < class171.field2252.length; var2++) {
			if (class295.field3676[var2] != -1 && class171.field2252[var2] == null) {
				class171.field2252[var2] = class246.field3159.method4625(class295.field3676[var2], 0, -168684248);
				if (class171.field2252[var2] == null) {
					var1 = false;
					++GameClient.field633;
				}
			}

			if (class9.field56[var2] != -1 && class29.field253[var2] == null) {
				class29.field253[var2] = class246.field3159.method4628(class9.field56[var2], 0, class67.field973[var2], (byte) 18);
				if (class29.field253[var2] == null) {
					var1 = false;
					++GameClient.field633;
				}
			}
		}

		if (!var1) {
			if (var0 > 872266664) {
				GameClient.field751 = 1;
			}
		} else {
			GameClient.field635 = 0;
			var1 = true;

			int var4;
			int var5;
			for (var2 = 0; var2 < class171.field2252.length; var2++) {
				byte[] var3 = class29.field253[var2];
				if (var3 != null) {
					if (var0 <= 872266664) {
						return;
					}

					var4 = (class143.field1900[var2] >> 8) * 64 - class62.baseX;
					var5 = (class143.field1900[var2] & 255) * 64 - GameClient.baseY;
					if (GameClient.isInstanceMap) {
						if (var0 <= 872266664) {
							return;
						}

						var4 = 10;
						var5 = 10;
					}

					var1 &= class33.method557(var3, var4, var5, 1833687101);
				}
			}

			if (!var1) {
				if (var0 > 872266664) {
					GameClient.field751 = 2;
				}
			} else {
				if (GameClient.field751 != 0) {
					class83.method1933("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true, 1029300583);
				}

				class54.method1017(2115644056);
				class28.field248.method2903();

				for (var2 = 0; var2 < 4; var2++) {
					GameClient.field642[var2].method3392((byte) 87);
				}

				int var45;
				for (var2 = 0; var2 < 4; var2++) {
					if (var0 <= 872266664) {
						return;
					}

					for (var45 = 0; var45 < 104; var45++) {
						for (var4 = 0; var4 < 104; var4++) {
							class50.field443[var2][var45][var4] = 0;
						}
					}
				}

				class54.method1017(2133517273);
				class40.method695((byte) 1);
				var2 = class171.field2252.length;

				for (class68 var63 = (class68) class68.field985.method4098(); var63 != null; var63 = (class68) class68.field985.method4079()) {
					if (var63.field993 != null) {
						class36.field310.method2009(var63.field993);
						var63.field993 = null;
					}

					if (var63.field980 != null) {
						class36.field310.method2009(var63.field980);
						var63.field980 = null;
					}
				}

				class68.field985.method4072();
				class14.method137(true, (byte) 16);
				int var7;
				int var8;
				int var10;
				int var11;
				int var12;
				int var13;
				int var15;
				int var16;
				int var17;
				int var18;
				int var20;
				int var21;
				int var22;
				int var47;
				int var50;
				int var53;
				if (!GameClient.isInstanceMap) {
					byte[] var6;
					for (var45 = 0; var45 < var2; var45++) {
						var4 = (class143.field1900[var45] >> 8) * 64 - class62.baseX;
						var5 = (class143.field1900[var45] & 255) * 64 - GameClient.baseY;
						var6 = class171.field2252[var45];
						if (var6 != null) {
							class54.method1017(2130550865);
							var7 = class27.field224 * 8 - 48;
							var8 = class34.field301 * 8 - 48;
							class164[] var9 = GameClient.field642;

							for (var10 = 0; var10 < 4; var10++) {
								if (var0 <= 872266664) {
									return;
								}

								for (var11 = 0; var11 < 64; var11++) {
									for (var12 = 0; var12 < 64; var12++) {
										if (var11 + var4 > 0 && var4 + var11 < 103) {
											if (var0 <= 872266664) {
												return;
											}

											if (var12 + var5 > 0 && var12 + var5 < 103) {
												var9[var10].field2029[var11 + var4][var5 + var12] &= -16777217;
											}
										}
									}
								}
							}

							Stream var46 = new Stream(var6);

							for (var11 = 0; var11 < 4; var11++) {
								for (var12 = 0; var12 < 64; var12++) {
									for (var13 = 0; var13 < 64; var13++) {
										class65.method1603(var46, var11, var12 + var4, var13 + var5, var7, var8, 0, (short) -9209);
									}
								}
							}
						}
					}

					for (var45 = 0; var45 < var2; var45++) {
						var4 = (class143.field1900[var45] >> 8) * 64 - class62.baseX;
						var5 = (class143.field1900[var45] & 255) * 64 - GameClient.baseY;
						var6 = class171.field2252[var45];
						if (var6 == null && class34.field301 < 800) {
							class54.method1017(2135025977);
							class177.method3510(var4, var5, 64, 64, 885632790);
						}
					}

					class14.method137(true, (byte) 16);

					label1543:
					for (var45 = 0; var45 < var2; var45++) {
						byte[] var49 = class29.field253[var45];
						if (var49 != null) {
							var5 = (class143.field1900[var45] >> 8) * 64 - class62.baseX;
							var47 = (class143.field1900[var45] & 255) * 64 - GameClient.baseY;
							class54.method1017(2121940132);
							class125 var51 = class28.field248;
							class164[] var52 = GameClient.field642;
							Stream var67 = new Stream(var49);
							var10 = -1;

							do {
								var11 = var67.method3563((byte) 65);
								if (var11 == 0) {
									continue label1543;
								}

								var10 += var11;
								var12 = 0;

								while (true) {
									var13 = var67.readCompact();
									if (var13 == 0) {
										break;
									}

									var12 += var13 - 1;
									var50 = var12 & 63;
									var15 = var12 >> 6 & 63;
									var16 = var12 >> 12;
									var17 = var67.readUByte();
									var18 = var17 >> 2;
									var53 = var17 & 3;
									var20 = var5 + var15;
									var21 = var50 + var47;
									if (var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
										var22 = var16;
										if ((class50.field443[1][var20][var21] & 2) == 2) {
											var22 = var16 - 1;
										}

										class164 var56 = null;
										if (var22 >= 0) {
											var56 = var52[var22];
										}

										class171.method3450(var16, var20, var21, var10, var53, var18, var51, var56);
									}
								}
							} while (var0 > 872266664);

							return;
						}
					}
				}

				int var23;
				int var24;
				int var25;
				int var26;
				int var27;
				int var28;
				int var29;
				int var30;
				int var33;
				int var34;
				int var35;
				int var36;
				int var37;
				int var39;
				int var40;
				int var41;
				int var48;
				if (GameClient.isInstanceMap) {
					class164[] var19;
					Stream var57;
					for (var45 = 0; var45 < 4; var45++) {
						class54.method1017(2128347128);

						for (var4 = 0; var4 < 13; var4++) {
							for (var5 = 0; var5 < 13; var5++) {
								boolean var72 = false;
								var7 = GameClient.field645[var45][var4][var5];
								if (var7 != -1) {
									var8 = var7 >> 24 & 3;
									var48 = var7 >> 1 & 3;
									var10 = var7 >> 14 & 1023;
									var11 = var7 >> 3 & 2047;
									var12 = (var10 / 8 << 8) + var11 / 8;

									for (var13 = 0; var13 < class143.field1900.length; var13++) {
										if (class143.field1900[var13] == var12 && class171.field2252[var13] != null) {
											if (var0 <= 872266664) {
												return;
											}

											byte[] var14 = class171.field2252[var13];
											var15 = var4 * 8;
											var16 = var5 * 8;
											var17 = (var10 & 7) * 8;
											var18 = (var11 & 7) * 8;
											var19 = GameClient.field642;

											for (var20 = 0; var20 < 8; var20++) {
												for (var21 = 0; var21 < 8; var21++) {
													if (var15 + var20 > 0 && var15 + var20 < 103 && var21 + var16 > 0 && var21 + var16 < 103) {
														if (var0 <= 872266664) {
															return;
														}

														var19[var45].field2029[var15 + var20][var21 + var16] &= -16777217;
													}
												}
											}

											var57 = new Stream(var14);

											for (var21 = 0; var21 < 4; var21++) {
												for (var22 = 0; var22 < 64; var22++) {
													for (var23 = 0; var23 < 64; var23++) {
														if (var21 == var8 && var22 >= var17 && var22 < var17 + 8 && var23 >= var18) {
															if (var0 <= 872266664) {
																return;
															}

															if (var23 < var18 + 8) {
																var28 = var22 & 7;
																var29 = var23 & 7;
																var30 = var48 & 3;
																if (var30 == 0) {
																	var27 = var28;
																} else if (var30 == 1) {
																	var27 = var29;
																} else if (var30 == 2) {
																	if (var0 <= 872266664) {
																		return;
																	}

																	var27 = 7 - var28;
																} else {
																	var27 = 7 - var29;
																}

																class65.method1603(var57, var45, var27 + var15, var16 + class75.method1802(var22 & 7, var23 & 7, var48, (byte) 51), 0, 0, var48, (short) 3810);
																continue;
															}
														}

														class65.method1603(var57, 0, -1, -1, 0, 0, 0, (short) 2533);
													}
												}
											}

											var72 = true;
											break;
										}
									}
								}

								if (!var72) {
									class160.method3338(var45, var4 * 8, var5 * 8, 1518279696);
								}
							}
						}
					}

					for (var45 = 0; var45 < 13; var45++) {
						for (var4 = 0; var4 < 13; var4++) {
							var5 = GameClient.field645[0][var45][var4];
							if (var5 == -1) {
								class177.method3510(var45 * 8, var4 * 8, 8, 8, 885632790);
							}
						}
					}

					class14.method137(true, (byte) 16);

					for (var45 = 0; var45 < 4; var45++) {
						class54.method1017(2123495811);

						for (var4 = 0; var4 < 13; var4++) {
							label1440:
							for (var5 = 0; var5 < 13; var5++) {
								if (var0 <= 872266664) {
									return;
								}

								var47 = GameClient.field645[var45][var4][var5];
								if (var47 != -1) {
									if (var0 <= 872266664) {
										return;
									}

									var7 = var47 >> 24 & 3;
									var8 = var47 >> 1 & 3;
									var48 = var47 >> 14 & 1023;
									var10 = var47 >> 3 & 2047;
									var11 = (var48 / 8 << 8) + var10 / 8;

									for (var12 = 0; var12 < class143.field1900.length; var12++) {
										if (class143.field1900[var12] == var11 && class29.field253[var12] != null) {
											byte[] var59 = class29.field253[var12];
											var50 = var4 * 8;
											var15 = var5 * 8;
											var16 = (var48 & 7) * 8;
											var17 = (var10 & 7) * 8;
											class125 var54 = class28.field248;
											var19 = GameClient.field642;
											var57 = new Stream(var59);
											var21 = -1;

											while (true) {
												var22 = var57.method3563((byte) 39);
												if (var22 == 0) {
													continue label1440;
												}

												var21 += var22;
												var23 = 0;

												while (true) {
													var24 = var57.readCompact();
													if (var24 == 0) {
														break;
													}

													var23 += var24 - 1;
													var25 = var23 & 63;
													var26 = var23 >> 6 & 63;
													var27 = var23 >> 12;
													var28 = var57.readUByte();
													var29 = var28 >> 2;
													var30 = var28 & 3;
													if (var7 == var27 && var26 >= var16) {
														if (var0 <= 872266664) {
															return;
														}

														if (var26 < var16 + 8) {
															if (var0 <= 872266664) {
																return;
															}

															if (var25 >= var17 && var25 < var17 + 8) {
																ObjectDef var60 = class110.getObjectDef(var21);
																var34 = var26 & 7;
																var35 = var25 & 7;
																var37 = var60.int693;
																int var61 = var60.int688;
																if ((var30 & 1) == 1) {
																	var39 = var37;
																	var37 = var61;
																	var61 = var39;
																}

																var36 = var8 & 3;
																if (var36 == 0) {
																	var33 = var34;
																} else if (var36 == 1) {
																	var33 = var35;
																} else if (var36 == 2) {
																	var33 = 7 - var34 - (var37 - 1);
																} else {
																	var33 = 7 - var35 - (var61 - 1);
																}

																var39 = var50 + var33;
																var40 = var15 + class86.method1970(var26 & 7, var25 & 7, var8, var60.int693, var60.int688, var30, (byte) -1);
																if (var39 > 0 && var40 > 0) {
																	if (var0 <= 872266664) {
																		return;
																	}

																	if (var39 < 103 && var40 < 103) {
																		var41 = var45;
																		if ((class50.field443[1][var39][var40] & 2) == 2) {
																			var41 = var45 - 1;
																		}

																		class164 var62 = null;
																		if (var41 >= 0) {
																			if (var0 <= 872266664) {
																				return;
																			}

																			var62 = var19[var41];
																		}

																		class171.method3450(var45, var39, var40, var21, var8 + var30 & 3, var29, var54, var62);
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
						}
					}
				}

				for (int z = 0; z < 4; z++) {
					for (int localX = 0; localX < 104; localX++) {
						for (int localY = 0; localY < 104; localY++)
							ClientObj.spawn(localX, localY, z);
					}
				}

				class14.method137(true, (byte) 16);
				class54.method1017(2141277062);
				class125 var64 = class28.field248;
				class164[] var73 = GameClient.field642;

				for (var5 = 0; var5 < 4; var5++) {
					for (var47 = 0; var47 < 104; var47++) {
						for (var7 = 0; var7 < 104; var7++) {
							if ((class50.field443[var5][var47][var7] & 1) == 1) {
								var8 = var5;
								if ((class50.field443[1][var47][var7] & 2) == 2) {
									var8 = var5 - 1;
								}

								if (var8 >= 0) {
									var73[var8].method3395(var47, var7, -770386169);
								}
							}
						}
					}
				}

				class50.field457 += (int) (Math.random() * 5.0D) - 2;
				if (class50.field457 < -8) {
					class50.field457 = -8;
				}

				if (class50.field457 > 8) {
					class50.field457 = 8;
				}

				class50.field455 += (int) (Math.random() * 5.0D) - 2;
				if (class50.field455 < -16) {
					class50.field455 = -16;
				}

				if (class50.field455 > 16) {
					class50.field455 = 16;
				}

				for (var5 = 0; var5 < 4; var5++) {
					byte[][] var65 = class50.field447[var5];
					var12 = (int) Math.sqrt(5100.0D);
					var13 = var12 * 768 >> 8;

					for (var50 = 1; var50 < 103; var50++) {
						for (var15 = 1; var15 < 103; var15++) {
							var16 = class50.field459[var5][var15 + 1][var50] - class50.field459[var5][var15 - 1][var50];
							var17 = class50.field459[var5][var15][var50 + 1] - class50.field459[var5][var15][var50 - 1];
							var18 = (int) Math.sqrt((double) (var17 * var17 + var16 * var16 + 65536));
							var53 = (var16 << 8) / var18;
							var20 = 65536 / var18;
							var21 = (var17 << 8) / var18;
							var22 = (var53 * -50 + var21 * -50 + var20 * -10) / var13 + 96;
							var23 = (var65[var15 - 1][var50] >> 2) + (var65[var15][var50 - 1] >> 2) + (var65[var15 + 1][var50] >> 3) + (var65[var15][var50 + 1] >> 3) + (var65[var15][var50] >> 1);
							class50.field448[var15][var50] = var22 - var23;
						}
					}

					for (var50 = 0; var50 < 104; var50++) {
						if (var0 <= 872266664) {
							return;
						}

						class50.field454[var50] = 0;
						class305.field3725[var50] = 0;
						Npc.field1035[var50] = 0;
						class263.field3325[var50] = 0;
						class243.field3137[var50] = 0;
					}

					for (var50 = -5; var50 < 109; var50++) {
						for (var15 = 0; var15 < 104; var15++) {
							var16 = var50 + 5;
							if (var16 >= 0 && var16 < 104) {
								var17 = class50.field445[var5][var16][var15] & 255;
								if (var17 > 0) {
									class259 var74 = class49.method953(var17 - 1, 860567064);
									class50.field454[var15] += var74.field3284;
									class305.field3725[var15] += var74.field3287;
									Npc.field1035[var15] += var74.field3286;
									class263.field3325[var15] += var74.field3281;
									++class243.field3137[var15];
								}
							}

							var17 = var50 - 5;
							if (var17 >= 0 && var17 < 104) {
								if (var0 <= 872266664) {
									return;
								}

								var18 = class50.field445[var5][var17][var15] & 255;
								if (var18 > 0) {
									class259 var68 = class49.method953(var18 - 1, -1796283963);
									class50.field454[var15] -= var68.field3284;
									class305.field3725[var15] -= var68.field3287;
									Npc.field1035[var15] -= var68.field3286;
									class263.field3325[var15] -= var68.field3281;
									--class243.field3137[var15];
								}
							}
						}

						if (var50 >= 1) {
							if (var0 <= 872266664) {
								return;
							}

							if (var50 < 103) {
								var15 = 0;
								var16 = 0;
								var17 = 0;
								var18 = 0;
								var53 = 0;

								for (var20 = -5; var20 < 109; var20++) {
									if (var0 <= 872266664) {
										return;
									}

									var21 = var20 + 5;
									if (var21 >= 0) {
										if (var0 <= 872266664) {
											return;
										}

										if (var21 < 104) {
											var15 += class50.field454[var21];
											var16 += class305.field3725[var21];
											var17 += Npc.field1035[var21];
											var18 += class263.field3325[var21];
											var53 += class243.field3137[var21];
										}
									}

									var22 = var20 - 5;
									if (var22 >= 0 && var22 < 104) {
										var15 -= class50.field454[var22];
										var16 -= class305.field3725[var22];
										var17 -= Npc.field1035[var22];
										var18 -= class263.field3325[var22];
										var53 -= class243.field3137[var22];
									}

									if (var20 >= 1) {
										if (var0 <= 872266664) {
											return;
										}

										if (var20 < 103) {
											if (var0 <= 872266664) {
												return;
											}

											if (!GameClient.field585 || (class50.field443[0][var50][var20] & 2) != 0 || (class50.field443[var5][var50][var20] & 16) == 0) {
												if (var5 < class50.field442) {
													class50.field442 = var5;
												}

												var23 = class50.field445[var5][var50][var20] & 255;
												var24 = class165.field2033[var5][var50][var20] & 255;
												if (var23 > 0 || var24 > 0) {
													var25 = class50.field459[var5][var50][var20];
													var26 = class50.field459[var5][var50 + 1][var20];
													var27 = class50.field459[var5][var50 + 1][var20 + 1];
													var28 = class50.field459[var5][var50][var20 + 1];
													var29 = class50.field448[var50][var20];
													var30 = class50.field448[var50 + 1][var20];
													int var31 = class50.field448[var50 + 1][var20 + 1];
													int var32 = class50.field448[var50][var20 + 1];
													var33 = -1;
													var34 = -1;
													if (var23 > 0) {
														var35 = var15 * 256 / var18;
														var36 = var16 / var53;
														var37 = var17 / var53;
														var33 = class34.method560(var35, var36, var37, (byte) -10);
														var35 = var35 + class50.field457 & 255;
														var37 += class50.field455;
														if (var37 < 0) {
															var37 = 0;
														} else if (var37 > 255) {
															var37 = 255;
														}

														var34 = class34.method560(var35, var36, var37, (byte) -40);
													}

													if (var5 > 0) {
														boolean var70 = true;
														if (var23 == 0 && class50.field446[var5][var50][var20] != 0) {
															var70 = false;
														}

														if (var24 > 0 && !class1.method15(var24 - 1, (byte) 1).field3523) {
															var70 = false;
														}

														if (var70 && var25 == var26 && var25 == var27 && var25 == var28) {
															if (var0 <= 872266664) {
																return;
															}

															class37.field325[var5][var50][var20] |= 2340;
														}
													}

													var35 = 0;
													if (var34 != -1) {
														var35 = class122.field1675[class102.method2248(var34, 96, 158001383)];
													}

													if (var24 == 0) {
														var64.method3000(var5, var50, var20, 0, 0, -1, var25, var26, var27, var28, class102.method2248(var33, var29, 158001383), class102.method2248(var33, var30, 158001383), class102.method2248(var33, var31, 158001383), class102.method2248(var33, var32, 158001383), 0, 0, 0, 0, var35, 0);
													} else {
														var36 = class50.field446[var5][var50][var20] + 1;
														byte var71 = class19.field159[var5][var50][var20];
														class272 var38 = class1.method15(var24 - 1, (byte) -28);
														var39 = var38.field3526;
														int var42;
														int var43;
														if (var39 >= 0) {
															var41 = class122.field1667.vmethod3092(var39, 2017103535);
															var40 = -1;
														} else if (var38.field3533 == 16711935) {
															var40 = -2;
															var39 = -1;
															var41 = -2;
														} else {
															var40 = class34.method560(var38.field3525, var38.field3530, var38.field3531, (byte) -74);
															var42 = var38.field3525 + class50.field457 & 255;
															var43 = var38.field3531 + class50.field455;
															if (var43 < 0) {
																if (var0 <= 872266664) {
																	return;
																}

																var43 = 0;
															} else if (var43 > 255) {
																if (var0 <= 872266664) {
																	return;
																}

																var43 = 255;
															}

															var41 = class34.method560(var42, var38.field3530, var43, (byte) -122);
														}

														var42 = 0;
														if (var41 != -2) {
															var42 = class122.field1675[class30.method519(var41, 96, -1780304289)];
														}

														if (var38.field3528 != -1) {
															var43 = var38.field3527 + class50.field457 & 255;
															int var44 = var38.field3534 + class50.field455;
															if (var44 < 0) {
																var44 = 0;
															} else if (var44 > 255) {
																var44 = 255;
															}

															var41 = class34.method560(var43, var38.field3532, var44, (byte) -98);
															var42 = class122.field1675[class30.method519(var41, 96, 1273308958)];
														}

														var64.method3000(var5, var50, var20, var36, var71, var39, var25, var26, var27, var28, class102.method2248(var33, var29, 158001383), class102.method2248(var33, var30, 158001383), class102.method2248(var33, var31, 158001383), class102.method2248(var33, var32, 158001383), class30.method519(var40, var29, 903126267), class30.method519(var40, var30, 425513490), class30.method519(var40, var31, -1767056833), class30.method519(var40, var32, 767669812), var35, var42);
													}
												}
											}
										}
									}
								}
							}
						}
					}

					for (var50 = 1; var50 < 103; var50++) {
						for (var15 = 1; var15 < 103; var15++) {
							if ((class50.field443[var5][var15][var50] & 8) != 0) {
								if (var0 <= 872266664) {
									return;
								}

								var20 = 0;
							} else if (var5 > 0 && (class50.field443[1][var15][var50] & 2) != 0) {
								var20 = var5 - 1;
							} else {
								var20 = var5;
							}

							var64.method2876(var5, var15, var50, var20);
						}
					}

					class50.field445[var5] = null;
					class165.field2033[var5] = null;
					class50.field446[var5] = null;
					class19.field159[var5] = null;
					class50.field447[var5] = null;
				}

				var64.method3038(-50, -10, -50);

				for (var5 = 0; var5 < 104; var5++) {
					for (var47 = 0; var47 < 104; var47++) {
						if ((class50.field443[1][var5][var47] & 2) == 2) {
							var64.method3041(var5, var47);
						}
					}
				}

				var5 = 1;
				var47 = 2;
				var7 = 4;

				for (var8 = 0; var8 < 4; var8++) {
					if (var0 <= 872266664) {
						return;
					}

					if (var8 > 0) {
						if (var0 <= 872266664) {
							return;
						}

						var5 <<= 3;
						var47 <<= 3;
						var7 <<= 3;
					}

					for (var48 = 0; var48 <= var8; var48++) {
						for (var10 = 0; var10 <= 104; var10++) {
							for (var11 = 0; var11 <= 104; var11++) {
								short var69;
								if ((class37.field325[var48][var11][var10] & var5) != 0) {
									var12 = var10;
									var13 = var10;
									var50 = var48;

									for (var15 = var48; var12 > 0 && (class37.field325[var48][var11][var12 - 1] & var5) != 0; --var12) {
										if (var0 <= 872266664) {
											return;
										}
									}

									while (var13 < 104 && (class37.field325[var48][var11][var13 + 1] & var5) != 0) {
										if (var0 <= 872266664) {
											return;
										}

										++var13;
									}

									label1156:
									while (var50 > 0) {
										for (var16 = var12; var16 <= var13; var16++) {
											if ((class37.field325[var50 - 1][var11][var16] & var5) == 0) {
												break label1156;
											}
										}

										--var50;
									}

									label1145:
									while (var15 < var8) {
										if (var0 <= 872266664) {
											return;
										}

										for (var16 = var12; var16 <= var13; var16++) {
											if (var0 <= 872266664) {
												return;
											}

											if ((class37.field325[var15 + 1][var11][var16] & var5) == 0) {
												if (var0 <= 872266664) {
													return;
												}
												break label1145;
											}
										}

										++var15;
									}

									var16 = (var13 - var12 + 1) * (var15 + 1 - var50);
									if (var16 >= 8) {
										var69 = 240;
										var18 = class50.field459[var15][var11][var12] - var69;
										var53 = class50.field459[var50][var11][var12];
										class125.method2997(var8, 1, var11 * 128, var11 * 128, var12 * 128, var13 * 128 + 128, var18, var53);

										for (var20 = var50; var20 <= var15; var20++) {
											for (var21 = var12; var21 <= var13; var21++) {
												class37.field325[var20][var11][var21] &= ~var5;
											}
										}
									}
								}

								if ((class37.field325[var48][var11][var10] & var47) != 0) {
									var12 = var11;
									var13 = var11;
									var50 = var48;

									for (var15 = var48; var12 > 0 && (class37.field325[var48][var12 - 1][var10] & var47) != 0; --var12) {
										;
									}

									while (var13 < 104 && (class37.field325[var48][var13 + 1][var10] & var47) != 0) {
										++var13;
									}

									label1212:
									while (var50 > 0) {
										if (var0 <= 872266664) {
											return;
										}

										for (var16 = var12; var16 <= var13; var16++) {
											if (var0 <= 872266664) {
												return;
											}

											if ((class37.field325[var50 - 1][var16][var10] & var47) == 0) {
												break label1212;
											}
										}

										--var50;
									}

									label1198:
									while (var15 < var8) {
										for (var16 = var12; var16 <= var13; var16++) {
											if ((class37.field325[var15 + 1][var16][var10] & var47) == 0) {
												break label1198;
											}
										}

										++var15;
									}

									var16 = (var13 - var12 + 1) * (var15 + 1 - var50);
									if (var16 >= 8) {
										var69 = 240;
										var18 = class50.field459[var15][var12][var10] - var69;
										var53 = class50.field459[var50][var12][var10];
										class125.method2997(var8, 2, var12 * 128, var13 * 128 + 128, var10 * 128, var10 * 128, var18, var53);

										for (var20 = var50; var20 <= var15; var20++) {
											for (var21 = var12; var21 <= var13; var21++) {
												class37.field325[var20][var21][var10] &= ~var47;
											}
										}
									}
								}

								if ((class37.field325[var48][var11][var10] & var7) != 0) {
									var12 = var11;
									var13 = var11;
									var50 = var10;

									for (var15 = var10; var50 > 0 && (class37.field325[var48][var11][var50 - 1] & var7) != 0; --var50) {
										;
									}

									while (var15 < 104) {
										if (var0 <= 872266664) {
											return;
										}

										if ((class37.field325[var48][var11][var15 + 1] & var7) == 0) {
											break;
										}

										++var15;
									}

									label1268:
									while (var12 > 0) {
										if (var0 <= 872266664) {
											return;
										}

										for (var16 = var50; var16 <= var15; var16++) {
											if ((class37.field325[var48][var12 - 1][var16] & var7) == 0) {
												break label1268;
											}
										}

										--var12;
									}

									label1257:
									while (var13 < 104) {
										for (var16 = var50; var16 <= var15; var16++) {
											if (var0 <= 872266664) {
												return;
											}

											if ((class37.field325[var48][var13 + 1][var16] & var7) == 0) {
												if (var0 <= 872266664) {
													return;
												}
												break label1257;
											}
										}

										++var13;
									}

									if ((var15 - var50 + 1) * (var13 - var12 + 1) >= 4) {
										var16 = class50.field459[var48][var12][var50];
										class125.method2997(var8, 4, var12 * 128, var13 * 128 + 128, var50 * 128, var15 * 128 + 128, var16, var16);

										for (var17 = var12; var17 <= var13; var17++) {
											if (var0 <= 872266664) {
												return;
											}

											for (var18 = var50; var18 <= var15; var18++) {
												if (var0 <= 872266664) {
													return;
												}

												class37.field325[var48][var17][var18] &= ~var7;
											}
										}
									}
								}
							}
						}
					}
				}

				class14.method137(true, (byte) 16);
				var5 = class50.field442;
				if (var5 > class13.field82) {
					var5 = class13.field82;
				}

				if (var5 < class13.field82 - 1) {
					var5 = class13.field82 - 1;
				}

				if (GameClient.field585) {
					class28.field248.method2904(class50.field442);
				} else {
					class28.field248.method2904(0);
				}

				for (var47 = 0; var47 < 104; var47++) {
					for (var7 = 0; var7 < 104; var7++) {
						class253.method4808(var47, var7, 843953881);
					}
				}

				class54.method1017(2115471538);
				class160.method3342(-1653590324);
				ObjectDef.field3391.method3984();
				class172 var66;
				if (Stream.client.method801(-997320713)) {
					var66 = class26.method433(OutgoingPacket.field2148, GameClient.field626.field1218, 1258900384);
					var66.field2257.writeInt(1057001181);
					GameClient.field626.method1980(var66, (byte) 1);
				}

				if (!GameClient.isInstanceMap) {
					var47 = (class27.field224 - 6) / 8;
					var7 = (class27.field224 + 6) / 8;
					var8 = (class34.field301 - 6) / 8;
					var48 = (class34.field301 + 6) / 8;

					for (var10 = var47 - 1; var10 <= var7 + 1; var10++) {
						for (var11 = var8 - 1; var11 <= var48 + 1; var11++) {
							if (var0 <= 872266664) {
								return;
							}

							if (var10 < var47 || var10 > var7 || var11 < var8 || var11 > var48) {
								class246.field3159.method4648("m" + var10 + "_" + var11, -1722462563);
								class246.field3159.method4648("l" + var10 + "_" + var11, 1096462209);
							}
						}
					}
				}

				class48.method947(30, -1527918824);
				class54.method1017(2125462680);
				class49.method952((byte) -66);
				var66 = class26.method433(OutgoingPacket.field2224, GameClient.field626.field1218, 1547704312);
				GameClient.field626.method1980(var66, (byte) 1);
				class43.field368.vmethod3330(2019081810);

				for (var7 = 0; var7 < 32; var7++) {
					GameShell.field394[var7] = 0L;
				}

				for (var7 = 0; var7 < 32; var7++) {
					if (var0 <= 872266664) {
						return;
					}

					GameShell.field404[var7] = 0L;
				}

				class8.field48 = 0;
			}
		}
	}
}
