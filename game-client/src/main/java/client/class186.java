package client;

public abstract class class186 {
	static boolean field2365 = false;
	static int[] field2367;
	public static final int field2366 = 16;
	static final int field2368 = 3;
	public static final int field2369 = 112;
	static final int field2370 = 27;

	abstract void vmethod3792(byte[] var1, int var2);

	abstract byte[] vmethod3789(byte var1);

	static void method3806(GameShell var0, int var1) {
		int var4;
		int var15;
		if (class78.field1107) {
			if (var1 != 943190296) {
				if (class48.field431 == 1 || !class253.field3229 && class48.field431 == 4) {
					int var2 = class78.field1082 + 280;
					if (class48.field432 >= var2) {

						if (class48.field432 <= var2 + 14 && class48.field428 >= 4 && class48.field428 <= 18) {
							class148.method3195(0, 0, (byte) -75);
							return;
						}
					}

					if (class48.field432 >= var2 + 15 && class48.field432 <= var2 + 80) {

						if (class48.field428 >= 4 && class48.field428 <= 18) {
							class148.method3195(0, 1, (byte) -11);
							return;
						}
					}

					int var3 = class78.field1082 + 390;
					if (class48.field432 >= var3) {

						if (class48.field432 <= var3 + 14) {

							if (class48.field428 >= 4 && class48.field428 <= 18) {
								class148.method3195(1, 0, (byte) -8);
								return;
							}
						}
					}

					if (class48.field432 >= var3 + 15 && class48.field432 <= var3 + 80 && class48.field428 >= 4 && class48.field428 <= 18) {
						class148.method3195(1, 1, (byte) -4);
					} else {
						var4 = class78.field1082 + 500;
						if (class48.field432 >= var4 && class48.field432 <= var4 + 14 && class48.field428 >= 4) {

							if (class48.field428 <= 18) {

								class148.method3195(2, 0, (byte) -54);
								return;
							}
						}

						if (class48.field432 >= var4 + 15 && class48.field432 <= var4 + 80) {

							if (class48.field428 >= 4 && class48.field428 <= 18) {
								class148.method3195(2, 1, (byte) -124);
								return;
							}
						}

						var15 = class78.field1082 + 610;
						if (class48.field432 >= var15 && class48.field432 <= var15 + 14 && class48.field428 >= 4 && class48.field428 <= 18) {
							class148.method3195(3, 0, (byte) -117);
						} else {
							if (class48.field432 >= var15 + 15 && class48.field432 <= var15 + 80) {

								if (class48.field428 >= 4) {

									if (class48.field428 <= 18) {
										class148.method3195(3, 1, (byte) -40);
										return;
									}
								}
							}

							if (class48.field432 >= class78.field1082 + 708 && class48.field428 >= 4) {

								if (class48.field432 <= class78.field1082 + 708 + 50) {

									if (class48.field428 <= 20) {
										class78.field1107 = false;
										class78.titleImage.method5849(class78.field1082, 0);
										class78.titleImageRight.method5849(class78.field1082 + 382, 0);
										//class78.logo.method5829(class78.field1082 + 382 - class78.logo.width1 / 2, 18);
										return;
									}
								}
							}

							if (class78.field1116 != -1) {
								class65 var6 = class65.field949[class78.field1116];
								class61.method1129(var6, (byte) 95);
								class78.field1107 = false;
								class78.titleImage.method5849(class78.field1082, 0);
								class78.titleImageRight.method5849(class78.field1082 + 382, 0);
								//class78.logo.method5829(class78.field1082 + 382 - class78.logo.width1 / 2, 18);
							}
						}
					}
				}

			}
		} else {
			if ((class48.field431 == 1 || !class253.field3229 && class48.field431 == 4) && class48.field432 >= class78.field1082 + 765 - 50 && class48.field428 >= 453) {
				class66 var10000 = class10.field61;
				boolean var10001;
				if (!class10.field61.field958) {
					if (var1 == 943190296) {
						return;
					}

					var10001 = true;
				} else {
					var10001 = false;
				}

				var10000.field958 = var10001;
				class54.method1018(152334198);
				if (!class10.field61.field958) {
					class219.method4325(Item.field1147, "scape main", "", 255, false, (byte) -8);
				} else {
					class9.method88((byte) 51);
				}
			}

			if (GameClient.field589 != 5) {
				if (class78.field1109 == -1L) {
					class78.field1109 = Stream.method3547(604838575) + 1000L;
				}

				long var12 = Stream.method3547(604838575);
				if (class10.method92(-1245329475) && class78.field1118 == -1L) {
					class78.field1118 = var12;
					if (class78.field1118 > class78.field1109) {
						class78.field1109 = class78.field1118;
					}
				}

				++class78.field1097;
				if (GameClient.field589 == 10 || GameClient.field589 == 11) {
					if (GameClient.field827 == 0) {
						if (class48.field431 == 1 || !class253.field3229 && class48.field431 == 4) {
							var4 = class78.field1082 + 5;
							short var5 = 463;
							byte var14 = 100;
							byte var7 = 35;
							if (class48.field432 >= var4 && class48.field432 <= var4 + var14 && class48.field428 >= var5) {
								if (var1 == 943190296) {
									return;
								}

								if (class48.field428 <= var5 + var7) {
									class59.method1078((short) -4721);
									return;
								}
							}
						}

						if (class49.field439 != null) {
							class59.method1078((short) -12265);
						}
					}

					var4 = class48.field431;
					var15 = class48.field432;
					int var22 = class48.field428;
					if (var4 == 0) {
						var15 = class48.field425;
						var22 = class48.field426 * 673804999;
					}

					if (!class253.field3229) {
						if (var1 == 943190296) {
							return;
						}

						if (var4 == 4) {
							var4 = 1;
						}
					}

					int var8;
					short var9;
					if (class78.field1081 == 0) {
						if (var1 == 943190296) {
							return;
						}

						boolean var16 = false;

						while (class1.method8(319934987)) {
							if (class163.field2016 == 84) {

								var16 = true;
							}
						}

						var8 = class78.field1091 - 80;
						var9 = 291;
						if (var4 == 1 && var15 >= var8 - 75 && var15 <= var8 + 75 && var22 >= var9 - 20 && var22 <= var9 + 20) {
							class270.method5156(class142.method3161("secure", true, (byte) 20) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false, -1107846037);
						}

						label1133:
						{
							var8 = class78.field1091 + 80;
							if (var4 == 1 && var15 >= var8 - 75 && var15 <= var8 + 75) {

								if (var22 >= var9 - 20) {
									if (var22 <= var9 + 20) {
										break label1133;
									}

								}
							}

							if (!var16) {
								return;
							}
						}

						if ((GameClient.field632 & 33554432) != 0) {
							class78.field1098 = "";
							class78.field1103 = "This is a <col=00ffff>Beta<col=ffffff> world.";
							class78.field1112 = "Your normal account will not be affected.";
							class78.field1105 = "";
							class78.field1081 = 1;
							class34.method586(1158823389);
						} else if ((GameClient.field632 & 4) != 0) {
							if ((GameClient.field632 & 1024) != 0) {
								class78.field1103 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
								class78.field1112 = "Players can attack each other almost everywhere";
								class78.field1105 = "and the Protect Item prayer won\'t work.";
							} else {
								class78.field1103 = "This is a <col=ff0000>PvP<col=ffffff> world.";
								class78.field1112 = "Players can attack each other";
								class78.field1105 = "almost everywhere.";
							}

							class78.field1098 = "Warning!";
							class78.field1081 = 1;
							class34.method586(631870235);
						} else if ((GameClient.field632 & 1024) != 0) {

							class78.field1103 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
							class78.field1112 = "The Protect Item prayer will";
							class78.field1105 = "not work on this world.";
							class78.field1098 = "Warning!";
							class78.field1081 = 1;
							class34.method586(-1821703316);
						} else {
							ScriptInvocation.method1030(false, 1525095412);
						}
					} else {
						int var17;
						short var19;
						if (class78.field1081 != 1) {
							short var18;
							if (class78.field1081 == 2) {
								var18 = 201;
								var17 = var18 + 52;
								if (var4 == 1) {
									if (var1 == 943190296) {
										return;
									}

									if (var22 >= var17 - 12 && var22 < var17 + 2) {
										class78.field1102 = 0;
									}
								}

								var17 += 15;
								if (var4 == 1 && var22 >= var17 - 12 && var22 < var17 + 2) {
									class78.field1102 = 1;
								}

								var17 += 15;
								var18 = 361;
								if (var4 == 1 && var22 >= var18 - 15 && var22 < var18) {
									class2.method22("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.", (byte) 127);
									class78.field1081 = 5;
									return;
								}

								var8 = class78.field1091 - 80;
								var9 = 321;
								if (var4 == 1 && var15 >= var8 - 75 && var15 <= var8 + 75 && var22 >= var9 - 20) {

									if (var22 <= var9 + 20) {
										class78.typedUsername = class78.typedUsername.trim();
										if (class78.typedUsername.length() == 0) {
											class2.method22("", "Please enter your username/email address.", "", (byte) 127);
											return;
										}

										if (class78.field1086.length() == 0) {
											class2.method22("", "Please enter your password.", "", (byte) 127);
											return;
										}

										class2.method22("", "Connecting to server...", "", (byte) 127);
										class87.method2005(false, -1062614111);
										class48.method947(20, 138043058);
										return;
									}
								}

								var8 = class78.field1090 + 180 + 80;
								if (var4 == 1 && var15 >= var8 - 75 && var15 <= var8 + 75 && var22 >= var9 - 20 && var22 <= var9 + 20) {
									class78.field1081 = 0;
									class78.typedUsername = "";
									class78.field1086 = "";
									class14.field104 = 0;
									class28.field238 = "";
									class78.field1104 = true;
								}

								boolean var23;
								label1076:
								{
									var8 = class78.field1091 + -117;
									var9 = 277;
									if (var15 >= var8) {
										if (var1 == 943190296) {
											return;
										}

										if (var15 < var8 + class67.field978) {

											if (var22 >= var9) {

												if (var22 < var9 + class66.field966) {

													var23 = true;
													break label1076;
												}
											}
										}
									}

									var23 = false;
								}

								class78.field1110 = var23;
								if (var4 == 1 && class78.field1110) {
									if (!class78.field1108) {

										var23 = true;
									} else {
										var23 = false;
									}

									class78.field1108 = var23;
									if (!class78.field1108) {

										if (class10.field61.field959 != null) {
											class10.field61.field959 = null;
											class54.method1018(-1928252900);
										}
									}
								}

								label1065:
								{
									var8 = class78.field1091 + 24;
									var9 = 277;
									if (var15 >= var8) {
										if (var1 == 943190296) {
											return;
										}

										if (var15 < var8 + class67.field978 && var22 >= var9 && var22 < var9 + class66.field966) {
											var23 = true;
											break label1065;
										}
									}

									var23 = false;
								}

								class78.field1115 = var23;
								if (var4 == 1 && class78.field1115) {
									class10.field61.field962 = !class10.field61.field962;
									if (!class10.field61.field962) {
										class78.typedUsername = "";
										class10.field61.field959 = null;
										class34.method586(1348972338);
									}

									class54.method1018(-2025294852);
								}

								while (true) {
									while (class1.method8(319934987)) {
										boolean var10 = false;

										for (int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); var11++) {
											if (class39.field342 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var11)) {
												var10 = true;
												break;
											}
										}

										if (class163.field2016 == 13) {
											class78.field1081 = 0;
											class78.typedUsername = "";
											class78.field1086 = "";
											class14.field104 = 0;
											class28.field238 = "";
											class78.field1104 = true;
										} else if (class78.field1102 == 0) {
											if (class163.field2016 == 85 && class78.typedUsername.length() > 0) {
												class78.typedUsername = class78.typedUsername.substring(0, class78.typedUsername.length() - 1);
											}

											if (class163.field2016 == 84 || class163.field2016 == 80) {
												class78.field1102 = 1;
											}

											if (var10 && class78.typedUsername.length() < 320) {
												class78.typedUsername = class78.typedUsername + class39.field342;
											}
										} else if (class78.field1102 == 1) {
											if (class163.field2016 == 85 && class78.field1086.length() > 0) {
												class78.field1086 = class78.field1086.substring(0, class78.field1086.length() - 1);
											}

											label1049:
											{
												if (class163.field2016 != 84) {
													if (class163.field2016 != 80) {
														break label1049;
													}

													if (var1 == 943190296) {
														return;
													}
												}

												class78.field1102 = 0;
											}

											if (class163.field2016 == 84) {
												class78.typedUsername = class78.typedUsername.trim();
												if (class78.typedUsername.length() == 0) {
													class2.method22("", "Please enter your username/email address.", "", (byte) 127);
													return;
												}

												if (class78.field1086.length() == 0) {
													class2.method22("", "Please enter your password.", "", (byte) 127);
													return;
												}

												class2.method22("", "Connecting to server...", "", (byte) 127);
												class87.method2005(false, -1676541894);
												class48.method947(20, -1371243967);
												return;
											}

											if (var10 && class78.field1086.length() < 20) {
												class78.field1086 = class78.field1086 + class39.field342;
											}
										}
									}

									return;
								}
							} else if (class78.field1081 == 3) {
								var17 = class78.field1090 + 180;
								var19 = 276;
								if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75) {
									if (var1 == 943190296) {
										return;
									}

									if (var22 >= var19 - 20) {

										if (var22 <= var19 + 20) {
											ScriptInvocation.method1030(false, 995391847);
										}
									}
								}

								var17 = class78.field1090 + 180;
								var19 = 326;
								if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
									class2.method22("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.", (byte) 127);
									class78.field1081 = 5;
									return;
								}
							} else {
								boolean var20;
								int var21;
								if (class78.field1081 == 4) {
									var17 = class78.field1090 + 180 - 80;
									var19 = 321;
									if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
										class28.field238.trim();
										if (class28.field238.length() != 6) {
											class2.method22("", "Please enter a 6-digit PIN.", "", (byte) 127);
											return;
										}

										class14.field104 = Integer.parseInt(class28.field238);
										class28.field238 = "";
										class87.method2005(true, -72700836);
										class2.method22("", "Connecting to server...", "", (byte) 127);
										class48.method947(20, -186647522);
										return;
									}

									if (var4 == 1 && var15 >= class78.field1090 + 180 - 9 && var15 <= class78.field1090 + 180 + 130 && var22 >= 263 && var22 <= 296) {
										class78.field1104 = !class78.field1104;
									}

									if (var4 == 1 && var15 >= class78.field1090 + 180 - 34) {
										if (var1 == 943190296) {
											return;
										}

										if (var15 <= class78.field1090 + 34 + 180 && var22 >= 351 && var22 <= 363) {
											class270.method5156(class142.method3161("secure", true, (byte) 20) + "m=totp-authenticator/disableTOTPRequest", true, false, -1183745448);
										}
									}

									var17 = class78.field1090 + 180 + 80;
									if (var4 == 1) {
										if (var1 == 943190296) {
											return;
										}

										if (var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
											class78.field1081 = 0;
											class78.typedUsername = "";
											class78.field1086 = "";
											class14.field104 = 0;
											class28.field238 = "";
										}
									}

									while (class1.method8(319934987)) {
										var20 = false;

										for (var21 = 0; var21 < "1234567890".length(); var21++) {
											if (class39.field342 == "1234567890".charAt(var21)) {
												var20 = true;
												break;
											}
										}

										if (class163.field2016 == 13) {
											class78.field1081 = 0;
											class78.typedUsername = "";
											class78.field1086 = "";
											class14.field104 = 0;
											class28.field238 = "";
										} else {
											if (class163.field2016 == 85) {
												if (var1 == 943190296) {
													return;
												}

												if (class28.field238.length() > 0) {
													class28.field238 = class28.field238.substring(0, class28.field238.length() - 1);
												}
											}

											if (class163.field2016 == 84) {
												class28.field238.trim();
												if (class28.field238.length() != 6) {
													if (var1 == 943190296) {
														return;
													}

													class2.method22("", "Please enter a 6-digit PIN.", "", (byte) 127);
													return;
												}

												class14.field104 = Integer.parseInt(class28.field238);
												class28.field238 = "";
												class87.method2005(true, 293509734);
												class2.method22("", "Connecting to server...", "", (byte) 127);
												class48.method947(20, 571937168);
												return;
											}

											if (var20 && class28.field238.length() < 6) {
												class28.field238 = class28.field238 + class39.field342;
											}
										}
									}
								} else if (class78.field1081 == 5) {
									var17 = class78.field1090 + 180 - 80;
									var19 = 321;
									if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20) {
										if (var1 == 943190296) {
											return;
										}

										if (var22 <= var19 + 20) {

											class234.method4590(1543629382);
											return;
										}
									}

									var17 = class78.field1090 + 180 + 80;
									if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
										if (var1 == 943190296) {
											return;
										}

										ScriptInvocation.method1030(true, 1248464352);
									}

									while (class1.method8(319934987)) {
										var20 = false;

										for (var21 = 0; var21 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); var21++) {
											if (class39.field342 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var21)) {
												var20 = true;
												break;
											}
										}

										if (class163.field2016 == 13) {
											ScriptInvocation.method1030(true, 541696326);
										} else {
											if (class163.field2016 == 85) {
												if (var1 == 943190296) {
													return;
												}

												if (class78.typedUsername.length() > 0) {
													class78.typedUsername = class78.typedUsername.substring(0, class78.typedUsername.length() - 1);
												}
											}

											if (class163.field2016 == 84) {
												class234.method4590(1611529761);
												return;
											}

											if (var20 && class78.typedUsername.length() < 320) {
												class78.typedUsername = class78.typedUsername + class39.field342;
											}
										}
									}
								} else if (class78.field1081 != 6) {
									if (class78.field1081 == 7) {
										var17 = class78.field1090 + 180 - 80;
										var19 = 321;
										if (var4 == 1) {
											if (var1 == 943190296) {
												return;
											}

											if (var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
												class270.method5156(class142.method3161("secure", true, (byte) 20) + "m=dob/set_dob.ws", true, false, -2135825175);
												class2.method22("", "Page has opened in a new window.", "(Please check your popup blocker.)", (byte) 127);
												class78.field1081 = 6;
												return;
											}
										}

										var17 = class78.field1090 + 180 + 80;
										if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75) {

											if (var22 >= var19 - 20 && var22 <= var19 + 20) {
												ScriptInvocation.method1030(true, 893887366);
											}
										}
									} else if (class78.field1081 == 8) {
										var17 = class78.field1090 + 180 - 80;
										var19 = 321;
										if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
											if (var1 == 943190296) {
												return;
											}

											class270.method5156("https://www.jagex.com/terms/privacy/#eight", true, false, -1935527203);
											class2.method22("", "Page has opened in a new window.", "(Please check your popup blocker.)", (byte) 127);
											class78.field1081 = 6;
											return;
										}

										var17 = class78.field1090 + 180 + 80;
										if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
											ScriptInvocation.method1030(true, 914838693);
										}
									}
								} else {
									while (class1.method8(319934987)) {
										if (var1 == 943190296) {
											return;
										}

										if (class163.field2016 != 84) {
											if (class163.field2016 != 13) {
												continue;
											}

										}

										ScriptInvocation.method1030(true, 893525518);
									}

									var18 = 321;
									if (var4 == 1 && var22 >= var18 - 20 && var22 <= var18 + 20) {
										ScriptInvocation.method1030(true, 1158459435);
									}
								}
							}
						} else {
							while (class1.method8(319934987)) {
								if (class163.field2016 == 84) {
									ScriptInvocation.method1030(false, 1438520718);
								} else if (class163.field2016 == 13) {
									class78.field1081 = 0;
								}
							}

							var17 = class78.field1091 - 80;
							var19 = 321;
							if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
								ScriptInvocation.method1030(false, 1054382891);
							}

							var17 = class78.field1091 + 80;
							if (var4 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
								if (var1 == 943190296) {
									return;
								}

								class78.field1081 = 0;
							}
						}
					}

				}
			}
		}
	}

	static final int method3805(int var0, int var1, int var2) {
		int var3 = class110.method2511(var0 - 1, var1 - 1, 1058679148) + class110.method2511(1 + var0, var1 - 1, 1058679148) + class110.method2511(var0 - 1, var1 + 1, 1058679148) + class110.method2511(1 + var0, 1 + var1, 1058679148);
		int var4 = class110.method2511(var0 - 1, var1, 1058679148) + class110.method2511(1 + var0, var1, 1058679148) + class110.method2511(var0, var1 - 1, 1058679148) + class110.method2511(var0, 1 + var1, 1058679148);
		int var5 = class110.method2511(var0, var1, 1058679148);
		return var3 / 16 + var4 / 8 + var5 / 4;
	}
}
