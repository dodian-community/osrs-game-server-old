package client;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.*;

//import netscape.javascript.JSObject;

public final class GameClient extends GameShell implements class288 {
	static boolean field580 = true;
	static int field598 = 0;
	static class153 field839;
	public static int field581 = 1;
	static Widget field583;
	static int field771;
	static int field683;
	static int field591 = 0;
	static int field589 = 0;
	public static final class87 field626;
	static int field715;
	static class157 field611;
	static int field603;
	static int field627;
	static int staticInt225;
	static long field791;
	static int field768;
	static int field632 = 0;
	static int field692;
	static int[] field720;
	static boolean[] staticBoolArray6;
	static int field615;
	static boolean[] field590;
	static int field777 = 0;
	static int field617;
	static class280 field804;
	static boolean field716;
	static int field729;
	static Player[] field610;
	static int field698;
	static boolean[] field723;
	public static boolean field668 = false;
	static boolean field772;
	static boolean field756;
	static int field730;
	static boolean[] field788;
	static boolean field585 = false;
	static boolean field792;
	static String[] field740;
	static int field801;
	static int field647;
	static int field827 = 0;
	static int field614;
	public static int field650;
	static boolean field601;
	static int field616;
	static int field587 = -1;
	static boolean field813;
	static boolean field588 = false;
	static int field753;
	static int[] field718;
	static int field749;
	static boolean field629;
	static boolean field625 = true;
	static String[] field735;
	static int[] field851;
	static int field757;
	static long field592 = 1L;
	static class202 interfaceSettings;
	static int field593 = -1;
	static Widget field752;
	static class202 field741;
	static int field594 = -1;
	static Widget field784;
	static int field790;
	static int[] field794;
	static int field595 = -1;
	static int[] field786;
	static int field618;
	static boolean field847 = true;
	static int[] field641;
	static int field758;
	static int field700;
	static int baseY;
	static boolean field728;
	static int field733;
	static boolean field689;
	static boolean field597 = false;
	static int field693;
	static boolean field785;
	static class146 field619;
	static int field599 = 0;
	static int[] field712;
	static int[] field787;
	static int field751;
	static int field600 = 0;
	static int[] field713;
	public static int field747;
	static int field633;
	static int field579 = 0;
	static int[] field789;
	static int field634;
	static int field678;
	static boolean field677;
	static int field696;
	static int field635;
	static int field602 = 0;
	static int field821;
	static int field636;
	static String field734;
	static class205 field638;
	static int field760;
	static String field612;
	static int field818 = 0;
	static int[] field640;
	static final class59 field849;
	static int field604 = 0;
	static String field739;
	static int field605 = 0;
	static int field688;
	static int field637 = 0;
	static class77 field607;
	static class164[] field642;
	static class77 field780;
	static int field815;
	static int field812;
	static int field609;
	static boolean field763;
	static boolean isInstanceMap;
	static int[] field850;
	static int[] field596;
	static int[] field766;
	static int field842;
	static int field853;
	static int field767;
	static class227 field841;
	static long field722;
	static int field586;
	static int field745;
	static int field686;
	static int field782;
	static boolean field776;
	static int field664;
	static byte[] field620;
	static int field582;
	static long[] field797;
	static int staticInt244;
	static Widget field755;
	static Npc[] field843;
	static int field810;
	static int field628;
	static boolean field807;
	static int field622;
	static int[][][] field645;
	static int[] field639;
	static int field687;
	static int field681;
	static int field624;
	static int field695;
	static int field682;
	static int[] field666;
	static boolean field822;
	static int field684;
	static int field694;
	static int field814;
	static int field803;
	static int field808;
	static int field717;
	static int field798;
	static int field656;
	static int field809;
	static int[] field817;
	static final int[] field846;
	static boolean field699;
	static int[] field676;
	static int field623;
	static int field732;
	static int[] field819;
	static int field643;
	static int field707;
	static HashMap field631;
	static class91[] field719;
	static Widget field744;
	static ArrayList field781;
	static int field651;
	static int field606;
	static int[] field820;
	static int field736;
	static class205 field714;
	static boolean[] field823;
	static class205[][][] field708;
	static int[] field824;
	static int[] field825;
	static class205 field710;
	static String[] field704;
	static int[] field826;
	static int field655;
	static int[] field705;
	static boolean[] field709;
	static class205 field711;
	static class249 field854;
	static int field811;
	static int field584;
	static int field762;
	static int field837;
	static int field838;
	static int field662;
	static int field649;
	static int mapIconCount;
	static int[] mapIconTileX;
	static short field802;
	static short field829;
	static int field775;
	static int[][] field761;
	static int[] mapIconTileY;
	static short field834;
	static short field835;
	static int field701;
	static int field646;
	static short field833;
	static short field848;
	static short field831;
	static Sprite[] mapIconImages;
	static short field832;
	static int field836;
	static int field840;
	static int field738;
	static int field799;
	static boolean field746;
	static boolean field663;
	static int[] field702;
	static int field660;
	static int field608;
	static int field748;
	static int field652;
	static int field653;
	static int[] field773;
	static int field770;
	static int field654;
	static int[] field800;
	static int field828;
	static class205 field778;
	static int field644;
	static int field657;
	static class205 field779;
	static int field613;
	static int[] staticIntArray105;
	static int field659;
	static int field750;
	static int field661;
	static int[] field706;
	static int field667;
	static int field648;
	static int[] field690;
	static int field769;
	static int[] field669;
	static int field742;
	static int[] field670;
	static int field743;
	static int[] field671;
	static class4[] field844;
	static int[] field672;
	static int[] field673;
	static int[] field674;
	static int[] field675;
	static String field796;
	static String[] field721;
	static int field793;
	static int field679;
	static int field680;
	static int field691;
	static boolean field621;
	static int field795;
	static int field630;
	static int field774;
	static int[] field731;
	static boolean field726;
	static int field658;
	static boolean field725;
	static final int[] field703;
	static class61 field665;
	static boolean field727;
	static int field737;
	static final String field685 = "oldschool";
	static final int field845 = 65;
	static final int field852 = 24624;

	static {
		field607 = class77.field1074;
		field780 = class77.field1074;
		field609 = 0;
		field692 = 0;
		field768 = 0;
		field614 = 0;
		field615 = 0;
		field616 = 0;
		field617 = 0;
		field618 = 0;
		field619 = class146.field1907;
		field620 = null;
		field843 = new Npc[32768];
		field622 = 0;
		field639 = new int[32768];
		field624 = 0;
		field666 = new int[250];
		field626 = new class87();
		field627 = 0;
		field756 = false;
		field629 = true;
		field804 = new class280();
		field631 = new HashMap();
		field633 = 0;
		field634 = 1;
		field635 = 0;
		field636 = 1;
		field751 = 0;
		field642 = new class164[4];
		isInstanceMap = false;
		field645 = new int[4][13][13];
		field846 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field700 = 0;
		field643 = 2301979;
		field584 = 5063219;
		field836 = 3353893;
		field646 = 7759444;
		field746 = false;
		field660 = 0;
		field649 = 128;
		field717 = 0;
		field608 = 0;
		field652 = 0;
		field653 = 0;
		field654 = 0;
		field655 = 0;
		field644 = 50;
		field657 = 0;
		field613 = 0;
		field659 = 0;
		field750 = 12;
		field661 = 6;
		field853 = 0;
		field663 = false;
		field664 = 0;
		field807 = false;
		field738 = 0;
		field667 = 0;
		field648 = 50;
		field669 = new int[field648];
		field670 = new int[field648];
		field671 = new int[field648];
		field672 = new int[field648];
		field673 = new int[field648];
		field674 = new int[field648];
		field675 = new int[field648];
		field721 = new String[field648];
		field761 = new int[104][104];
		field687 = 0;
		field679 = -1;
		field680 = -1;
		field681 = 0;
		field682 = 0;
		field803 = 0;
		field684 = 0;
		field621 = true;
		field686 = 0;
		field582 = 0;
		field688 = 0;
		field678 = 0;
		field821 = 0;
		field691 = 0;
		field689 = false;
		field693 = 0;
		field694 = 0;
		field677 = true;
		field610 = new Player[2048];
		field628 = -1;
		field698 = 0;
		field699 = true;
		field658 = 0;
		field701 = 0;
		field702 = new int[1000];
		field703 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
		field704 = new String[8];
		field709 = new boolean[8];
		field706 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
		field707 = -1;
		field708 = new class205[4][104][104];
		field714 = new class205();
		field710 = new class205();
		field711 = new class205();
		field712 = new int[25];
		field713 = new int[25];
		field640 = new int[25];
		field715 = 0;
		field716 = false;
		field771 = 0;
		field718 = new int[500];
		field851 = new int[500];
		field720 = new int[500];
		field794 = new int[500];
		field735 = new String[500];
		field740 = new String[500];
		field590 = new boolean[500];
		field725 = false;
		field726 = false;
		field727 = false;
		field728 = true;
		field729 = -1;
		field730 = -1;
		field623 = 0;
		field732 = 50;
		field733 = 0;
		field734 = null;
		field785 = false;
		field736 = -1;
		field737 = -1;
		field612 = null;
		field739 = null;
		field683 = -1;
		field741 = new class202(8);
		field742 = 0;
		field743 = 0;
		field744 = null;
		field745 = 0;
		field782 = 0;
		field747 = 0;
		field748 = -1;
		field776 = false;
		field784 = null;
		field583 = null;
		field752 = null;
		field753 = 0;
		field749 = 0;
		field755 = null;
		field601 = false;
		field757 = -1;
		field758 = -1;
		field772 = false;
		field696 = -1;
		field760 = -1;
		field763 = false;
		field801 = 1;
		staticIntArray105 = new int[32];
		staticInt244 = 0;
		field766 = new int[32];
		field767 = 0;
		field690 = new int[32];
		field769 = 0;
		field770 = 0;
		field647 = 0;
		field828 = 0;
		field793 = 0;
		field774 = 0;
		field775 = 0;
		field695 = 0;
		field638 = new class205();
		field778 = new class205();
		field779 = new class205();
		interfaceSettings = new class202(512);
		field603 = 0;
		staticInt225 = -2;
		staticBoolArray6 = new boolean[100];
		field788 = new boolean[100];
		field723 = new boolean[100];
		field786 = new int[100];
		field787 = new int[100];
		field641 = new int[100];
		field789 = new int[100];
		field790 = 0;
		field791 = 0L;
		field792 = true;
		field731 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		field630 = 0;
		field795 = 0;
		field796 = "";
		field797 = new long[100];
		field798 = 0;
		field799 = 0;
		field800 = new int[128];
		field773 = new int[128];
		field722 = -1L;
		field651 = -1;
		mapIconCount = 0;
		mapIconTileX = new int[1000];
		mapIconTileY = new int[1000];
		mapIconImages = new Sprite[1000];
		field808 = 0;
		field809 = 0;
		field810 = 0;
		field811 = 255;
		field812 = -1;
		field813 = false;
		field814 = 127;
		field815 = 127;
		field656 = 0;
		field817 = new int[50];
		field676 = new int[50];
		field819 = new int[50];
		field820 = new int[50];
		field719 = new class91[50];
		field822 = false;
		field823 = new boolean[5];
		field824 = new int[5];
		field825 = new int[5];
		field826 = new int[5];
		field705 = new int[5];
		field802 = 256;
		field829 = 205;
		field848 = 256;
		field831 = 320;
		field832 = 1;
		field833 = 32767;
		field834 = 1;
		field835 = 32767;
		field762 = 0;
		field837 = 0;
		field838 = 0;
		field662 = 0;
		field840 = 0;
		field841 = new class227();
		field842 = -1;
		field586 = -1;
		field844 = new class4[8];
		field665 = new class61();
		field650 = -1;
		field781 = new ArrayList(10);
		field606 = 0;
		field849 = new class59();
		field850 = new int[50];
		field596 = new int[50];
	}


	public static boolean killstreakSkullsEnabled;

	public static void requestRedraw(Widget widget_0) {
	   if(staticInt225 == widget_0.int473) {
	      staticBoolArray6[widget_0.int504] = true;
	   }

	}

	static final void updateForSetting(int var0) {
	   class295.method5501(113022464);
	   class6.method75(-1623615200);
	   int var2 = class63.method1549(var0, 327770594).field3230;
	   if(var2 != 0) {
	      int var3 = class225.field2558[var0];
	      if(var2 == 1) {
	         if(var3 == 1) {
	            class122.method2830(0.9D);
	            ((class111)class122.field1667).method2544(0.9D);
	         }
	
	         if(var3 == 2) {
	            class122.method2830(0.8D);
	            ((class111)class122.field1667).method2544(0.8D);
	         }
	
	         if(var3 == 3) {
	            class122.method2830(0.7D);
	            ((class111)class122.field1667).method2544(0.7D);
	         }
	
	         if(var3 == 4) {
	            class122.method2830(0.6D);
	            ((class111)class122.field1667).method2544(0.6D);
	         }
	
	         ItemDef.field3429.method3984();
	      }
	
	      if(var2 == 3) {
	         short var4 = 0;
	         if(var3 == 0) {
	
	            var4 = 255;
	         }
	
	         if(var3 == 1) {
	            var4 = 192;
	         }
	
	         if(var3 == 2) {
	
	            var4 = 128;
	         }
	
	         if(var3 == 3) {
	
	            var4 = 64;
	         }
	
	         if(var3 == 4) {
	
	            var4 = 0;
	         }
	
	         if(var4 != field811) {
	            if(field811 == 0 && field812 != -1) {
	
	               class63.method1554(Item.field1147, field812, 0, var4, false, (short)-30497);
	               field813 = false;
	            } else if(var4 == 0) {
	               class9.method88((byte)-51);
	               field813 = false;
	            } else if(class217.field2460 != 0) {
	               class309.field3740 = var4;
	            } else {
	               class217.field2459.method4236(var4, 1864388781);
	            }
	
	            field811 = var4;
	         }
	      }
	
	      if(var2 == 4) {
	         if(var3 == 0) {
	            field814 = 127;
	         }
	
	         if(var3 == 1) {
	            field814 = 96;
	         }
	
	         if(var3 == 2) {
	            field814 = 64;
	         }
	
	         if(var3 == 3) {
	            field814 = 32;
	         }
	
	         if(var3 == 4) {
	            field814 = 0;
	         }
	      }
	
	      if(var2 == 5) {
	         field715 = var3;
	      }
	
	      if(var2 == 6) {
	         field742 = var3;
	      }
	
	      if(var2 == 9) {
	         field743 = var3;
	      }
	
	      if(var2 == 10) {
	         if(var3 == 0) {
	            field815 = 127;
	         }
	
	         if(var3 == 1) {
	            field815 = 96;
	         }
	
	         if(var3 == 2) {
	            field815 = 64;
	         }
	
	         if(var3 == 3) {
	
	            field815 = 32;
	         }
	
	         if(var3 == 4) {
	            field815 = 0;
	         }
	      }
	
	      if(var2 == 17) {
	         field748 = var3 & 65535;
	      }
	
	      class77[] var5;
	      if(var2 == 18) {
	
	         var5 = new class77[]{class77.field1080, class77.field1074, class77.field1075, class77.field1076};
	         field607 = (class77)class76.method1803(var5, var3, (byte)0);
	         if(field607 == null) {
	            field607 = class77.field1080;
	         }
	      }
	
	      if(var2 == 19) {
	         if(var3 == -1) {
	            field707 = -1;
	         } else {
	            field707 = var3 & 2047;
	         }
	      }
	
	      if(var2 == 22) {
	
	         var5 = new class77[]{class77.field1080, class77.field1074, class77.field1075, class77.field1076};
	         field780 = (class77)class76.method1803(var5, var3, (byte)0);
	         if(field780 == null) {
	            field780 = class77.field1080;
	         }
	      }
	
	   }
	}

	void method1139(int var1) {
		if (field589 != 1000) {
			long var3 = Stream.method3547(604838575);
			int var5 = (int) (var3 - class250.field3203);
			class250.field3203 = var3;
			if (var5 > 200) {
				if (var1 <= 1135809572) {
					return;
				}

				var5 = 200;
			}

			boolean var2;
			label270:
			{
				class250.field3197 += var5;
				if (class250.field3207 == 0) {
					if (var1 <= 1135809572) {
						return;
					}

					if (class250.field3198 == 0 && class250.field3205 == 0 && class250.field3211 == 0) {
						var2 = true;
						break label270;
					}
				}

				if (class250.field3200 == null) {
					if (var1 <= 1135809572) {
						return;
					}

					var2 = false;
				} else {
					try {
						label276:
						{
							if (class250.field3197 > 30000) {
								throw new IOException();
							}

							class246 var6;
							Stream var7;
							while (class250.field3198 < 200 && class250.field3211 > 0) {
								var6 = (class246) class250.field3212.method4018();
								var7 = new Stream(4);
								var7.writeByte(1);
								var7.method3534((int) var6.field2421, -1989229937);
								class250.field3200.vmethod3347(var7.field2338, 0, 4, (byte) -100);
								class250.field3199.method4016(var6, var6.field2421);
								--class250.field3211;
								++class250.field3198;
							}

							while (class250.field3207 < 200 && class250.field3205 > 0) {
								var6 = (class246) class250.field3202.method3932();
								var7 = new Stream(4);
								var7.writeByte(0);
								var7.method3534((int) var6.field2421, -1860248896);
								class250.field3200.vmethod3347(var7.field2338, 0, 4, (byte) -108);
								var6.method4101();
								class250.field3206.method4016(var6, var6.field2421);
								--class250.field3205;
								++class250.field3207;
							}

							for (int var18 = 0; var18 < 100; var18++) {
								int var19 = class250.field3200.vmethod3349(1213474120);
								if (var19 < 0) {
									if (var1 <= 1135809572) {
										return;
									}

									throw new IOException();
								}

								if (var19 == 0) {
									break;
								}

								class250.field3197 = 0;
								byte var8 = 0;
								if (class250.field3208 == null) {
									var8 = 8;
								} else if (class250.field3210 == 0) {
									if (var1 <= 1135809572) {
										return;
									}

									var8 = 1;
								}

								int var9;
								int var10;
								int var11;
								int var13;
								if (var8 > 0) {
									var9 = var8 - class250.field3209.field2339;
									if (var9 > var19) {
										var9 = var19;
									}

									class250.field3200.vmethod3351(class250.field3209.field2338, class250.field3209.field2339, var9, -2097961075);
									if (class250.field3213 != 0) {
										for (var10 = 0; var10 < var9; var10++) {
											class250.field3209.field2338[var10 + class250.field3209.field2339] ^= class250.field3213;
										}
									}

									class250.field3209.field2339 += var9;
									if (class250.field3209.field2339 < var8) {
										break;
									}

									if (class250.field3208 == null) {
										class250.field3209.field2339 = 0;
										var10 = class250.field3209.readUByte();
										var11 = class250.field3209.readUShort();
										int var12 = class250.field3209.readUByte();
										var13 = class250.field3209.readInt();
										long var14 = (long) (var11 + (var10 << 16));
										class246 var16 = (class246) class250.field3199.get(var14);
										class192.field2391 = true;
										if (var16 == null) {
											var16 = (class246) class250.field3206.get(var14);
											class192.field2391 = false;
										}

										if (var16 == null) {
											if (var1 <= 1135809572) {
												return;
											}

											throw new IOException();
										}

										int var17 = var12 == 0 ? 5 : 9;
										class250.field3208 = var16;
										class301.field3713 = new Stream(var17 + var13 + class250.field3208.field3157);
										class301.field3713.writeByte(var12);
										class301.field3713.writeInt(var13);
										class250.field3210 = 8;
										class250.field3209.field2339 = 0;
									} else if (class250.field3210 == 0) {
										if (class250.field3209.field2338[0] == -1) {
											class250.field3210 = 1;
											class250.field3209.field2339 = 0;
										} else {
											class250.field3208 = null;
										}
									}
								} else {
									var9 = class301.field3713.field2338.length - class250.field3208.field3157;
									var10 = 512 - class250.field3210;
									if (var10 > var9 - class301.field3713.field2339) {
										if (var1 <= 1135809572) {
											return;
										}

										var10 = var9 - class301.field3713.field2339;
									}

									if (var10 > var19) {
										var10 = var19;
									}

									class250.field3200.vmethod3351(class301.field3713.field2338, class301.field3713.field2339, var10, -2006404155);
									if (class250.field3213 != 0) {
										if (var1 <= 1135809572) {
											return;
										}

										for (var11 = 0; var11 < var10; var11++) {
											class301.field3713.field2338[var11 + class301.field3713.field2339] ^= class250.field3213;
										}
									}

									class301.field3713.field2339 += var10;
									class250.field3210 += var10;
									if (var9 == class301.field3713.field2339) {
										if (class250.field3208.field2421 == 16711935L) {
											class185.field2359 = class301.field3713;

											for (var11 = 0; var11 < 256; var11++) {
												class249 var20 = class250.field3201[var11];
												if (var20 != null) {
													class185.field2359.field2339 = var11 * 8 + 5;
													var13 = class185.field2359.readInt();
													int var21 = class185.field2359.readInt();
													var20.method4723(var13, var21, -1996421048);
												}
											}
										} else {
											class250.field3196.reset();
											class250.field3196.update(class301.field3713.field2338, 0, var9);
											var11 = (int) class250.field3196.getValue();
											if (var11 != class250.field3208.field3156) {
												if (var1 <= 1135809572) {
													return;
												}

												try {
													class250.field3200.vmethod3346(1775992211);
												} catch (Exception var24) {
													;
												}

												++class250.field3214;
												class250.field3200 = null;
												class250.field3213 = (byte) ((int) (Math.random() * 255.0D + 1.0D));
												var2 = false;
												break label276;
											}

											class250.field3214 = 0;
											class250.field3215 = 0;
											class250.field3208.field3155.method4729((int) (class250.field3208.field2421 & 65535L), class301.field3713.field2338, (class250.field3208.field2421 & 16711680L) == 16711680L, class192.field2391, -1745310697);
										}

										class250.field3208.unlink();
										if (class192.field2391) {
											--class250.field3198;
										} else {
											--class250.field3207;
										}

										class250.field3210 = 0;
										class250.field3208 = null;
										class301.field3713 = null;
									} else {
										if (class250.field3210 != 512) {
											break;
										}

										class250.field3210 = 0;
									}
								}
							}

							var2 = true;
						}
					} catch (IOException var25) {
						try {
							class250.field3200.vmethod3346(1775992211);
						} catch (Exception var23) {
							;
						}

						++class250.field3215;
						class250.field3200 = null;
						var2 = false;
					}
				}
			}

			if (!var2) {
				if (var1 <= 1135809572) {
					return;
				}

				this.method1140(118360618);
			}

		}
	}

	public class291 vmethod5420(int var1) {
		return class138.field1876 != null ? class138.field1876.field552 : null;
	}

	void method1145(int var1) {
		int var2 = class82.field1179;
		int var3 = class243.field3138;
		if (super.field396 < var2) {
			if (var1 >= 819194505) {
				return;
			}

			var2 = super.field396;
		}

		if (super.field397 < var3) {
			var3 = super.field397;
		}

		if (class10.field61 != null) {
			try {
				GameClient var4 = Stream.client;
				int var5 = field792 ? 2 : 1;
				class41.method700(var4, "resize", new Object[]{Integer.valueOf(var5)}, 2114895599);
			} catch (Throwable var6) {
				;
			}
		}

	}

	protected final void vmethod1187(int var1) {
		if (class22.field185.method1896((short) 9220)) {
			if (var1 >= -1544066236) {
				return;
			}

			class22.field185.method1893((byte) 5);
		}

		if (class26.field220 != null) {
			class26.field220.field529 = false;
		}

		class26.field220 = null;
		field626.method1982((short) 822);
		if (class39.field337 != null) {
			class39 var2 = class39.field337;
			synchronized (class39.field337) {
				class39.field337 = null;
			}
		}

		class185.method3787((short) 29745);
		class33.field294 = null;
		if (class28.field244 != null) {
			class28.field244.method2147(-917768670);
		}

		if (class63.field879 != null) {
			if (var1 >= -1544066236) {
				return;
			}

			class63.field879.method2147(-2130967995);
		}

		Icon.method4605(-1507833078);
		Object var10 = class248.field3184;
		synchronized (class248.field3184) {
			if (class248.field3179 != 0) {
				class248.field3179 = 1;

				try {
					class248.field3184.wait();
				} catch (InterruptedException var6) {
					;
				}
			}
		}

		if (class28.field249 != null) {
			class28.field249.method3106(-1955026569);
			class28.field249 = null;
		}

		try {
			class155.field1969.method2493(-2129971155);

			for (int var5 = 0; var5 < class148.field1913; var5++) {
				class76.field1068[var5].method2493(-1555027176);
			}

			class155.field1970.method2493(-1642025271);
			class155.field1968.method2493(-1955251086);
		} catch (Exception var8) {
			;
		}

	}

	protected final void vmethod1505(int var1) {
		OutgoingPacket.method3446(new int[]{20, 260, 10000}, new int[]{1000, 100, 500}, 773113121);
		class26.field223 = field777 == 0 ? 43594 : field581 + 40000;
		class68.field996 = field777 == 0 ? 443 : field581 + 50000;
		class290.field3636 = class26.field223;
		class227.field2575 = class228.field2582;
		class227.field2572 = class228.field2583;
		class227.field2577 = class228.field2586;
		class227.field2578 = class228.field2585;
		class28.field249 = new class135();
		this.method772((byte) 0);
		this.method791(45124386);
		class33.field294 = this.method769((byte) 10);
		class34.field302 = new class162(255, class155.field1969, class155.field1970, 500000);
		class10.field61 = Item.method1859((short) -27003);
		this.method770(-1223644500);
		class313.method5714(this, class8.field55, (byte) -36);
		if (field777 != 0) {
			field597 = true;
		}

		class50.method991(class10.field61.field957, (byte) -16);
		class181.field2332 = new class67(class36.field306);
	}

	final void method1151(boolean var1, int var2) {
		class84.method1946(field683, class82.field1179, class243.field3138, var1, (byte) 76);
	}

	void method1141(int var1, int var2) {
		field839 = null;
		field611 = null;
		field692 = 0;
		if (class290.field3636 == class26.field223) {
			class290.field3636 = class68.field996;
		} else {
			class290.field3636 = class26.field223;
		}

		++field614;
		if (field614 >= 2) {
			label75:
			{
				if (var1 != 7) {
					if (var2 != 656785584) {
						return;
					}

					if (var1 != 9) {
						break label75;
					}

					if (var2 != 656785584) {
						return;
					}
				}

				if (field589 <= 5) {
					if (var2 != 656785584) {
						return;
					}

					this.method788("js5connect_full", 1327956818);
					field589 = 1000;
				} else {
					field768 = 3000;
				}

				return;
			}
		}

		if (field614 >= 2) {
			if (var2 != 656785584) {
				return;
			}

			if (var1 == 6) {
				this.method788("js5connect_outofdate", 1327956818);
				field589 = 1000;
				return;
			}
		}

		if (field614 >= 4) {
			if (field589 <= 5) {
				if (var2 != 656785584) {
					return;
				}

				this.method788("js5connect", 1327956818);
				field589 = 1000;
			} else {
				field768 = 3000;
			}
		}

	}

	final boolean method1149(byte var1) {
		int var2 = field771 - 1;
		return (field715 == 1 && field771 > 2 || class43.method713(var2, (byte) 0)) && !field590[var2];
	}

	protected final void vmethod1132(int var1) {
	}

	final boolean method1147(class87 var1, byte var2) {
		class157 var3 = var1.method1983(-1630505301);
		PacketBuffer buffer = var1.field1219;
		if (var3 == null) {
			return false;
		} else {
			String var6;
			int var7;
			try {
				if (var1.packetType == null) {
					if (var1.field1222) {
						if (!var3.vmethod3350(1, (byte) 1)) {
							return false;
						}

						var3.vmethod3351(var1.field1219.field2338, 0, 1, -2136260163);
						var1.field1228 = 0;
						var1.field1222 = false;
					}

					buffer.field2339 = 0;
					if (buffer.method3821(-1051001340)) {
						if (!var3.vmethod3350(1, (byte) 1)) {
							return false;
						}

						var3.vmethod3351(var1.field1219.field2338, 1, 1, -2069418764);
						var1.field1228 = 0;
					}

					var1.field1222 = true;
					IncomingPacket[] var5 = new IncomingPacket[]{IncomingPacket.field2100, IncomingPacket.field2050, IncomingPacket.field2051, IncomingPacket.INVOKE_CS2, IncomingPacket.field2053, IncomingPacket.field2054, IncomingPacket.field2055, IncomingPacket.field2122, IncomingPacket.field2083, IncomingPacket.field2065, IncomingPacket.field2059, IncomingPacket.field2060, IncomingPacket.field2061, IncomingPacket.field2062, IncomingPacket.field2063, IncomingPacket.field2106, IncomingPacket.field2107, IncomingPacket.field2069, IncomingPacket.field2128, IncomingPacket.field2105, IncomingPacket.field2116, IncomingPacket.field2111, IncomingPacket.field2071, IncomingPacket.field2072, IncomingPacket.field2114, IncomingPacket.field2074, IncomingPacket.field2075, IncomingPacket.field2058, IncomingPacket.field2077, IncomingPacket.field2078, IncomingPacket.field2131, IncomingPacket.field2080, IncomingPacket.field2081, IncomingPacket.NPC_UPDATE, IncomingPacket.field2079, IncomingPacket.field2084, IncomingPacket.DISPLAY_STATIC_MAP, IncomingPacket.field2086, IncomingPacket.field2087, IncomingPacket.field2088, IncomingPacket.field2089, IncomingPacket.field2090, IncomingPacket.field2091, IncomingPacket.field2092, IncomingPacket.field2093, IncomingPacket.field2076, IncomingPacket.field2095, IncomingPacket.field2096, IncomingPacket.field2097, IncomingPacket.VARP_SMALL, IncomingPacket.VARP_BIG, IncomingPacket.field2082, IncomingPacket.field2101, IncomingPacket.field2102, IncomingPacket.field2094, IncomingPacket.field2104, IncomingPacket.PLAYER_UPDATE, IncomingPacket.field2064, IncomingPacket.field2119, IncomingPacket.field2108, IncomingPacket.field2109, IncomingPacket.field2049, IncomingPacket.field2068, IncomingPacket.field2112, IncomingPacket.field2113, IncomingPacket.field2129, IncomingPacket.field2115, IncomingPacket.field2073, IncomingPacket.field2117, IncomingPacket.field2118, IncomingPacket.field2124, IncomingPacket.field2120, IncomingPacket.field2121, IncomingPacket.field2103, IncomingPacket.field2123, IncomingPacket.field2066, IncomingPacket.field2125, IncomingPacket.field2130, IncomingPacket.field2126, IncomingPacket.OPEN_INTERFACE, IncomingPacket.field2056, IncomingPacket.DISPLAY_INSTANCED_MAP, IncomingPacket.field2052, IncomingPacket.field2132,

							// Custom packets:
							IncomingPacket.SEND_JOURNAL, IncomingPacket.UPDATE_JOURNAL, IncomingPacket.UPDATE_DROPVIEWER,
							IncomingPacket.UPDATE_LOYALTY, IncomingPacket.UPDATE_SHOP, IncomingPacket.JAK_CANCER_PACKET,
							IncomingPacket.TELEPORT_INTERFACE};

					var7 = buffer.method3841(1847704780);
					if (var7 < 0 || var7 >= var5.length) {
						throw new IOException(var7 + " " + buffer.field2339);
					}

					IncomingPacket p = var1.packetType = var5[var7];

					if (p != IncomingPacket.NPC_UPDATE && p != IncomingPacket.PLAYER_UPDATE
							&& p != IncomingPacket.OPEN_INTERFACE && p != IncomingPacket.INVOKE_CS2
					&& p != IncomingPacket.field2084) {
						//System.out.printf("Packet: %s%n", var5[var7]);
					}

					var1.field1225 = var1.packetType.size;
				}

				if (var1.field1225 == -1) {
					if (!var3.vmethod3350(1, (byte) 1)) {
						return false;
					}

					var1.method1983(945295992).vmethod3351(buffer.field2338, 0, 1, -2033574373);
					var1.field1225 = buffer.field2338[0] & 255;
				}

				if (var1.field1225 == -2) {
					if (!var3.vmethod3350(2, (byte) 1)) {
						return false;
					}

					var1.method1983(-1522978876).vmethod3351(buffer.field2338, 0, 2, -2044323113);
					buffer.field2339 = 0;
					var1.field1225 = buffer.readUShort();
				}

				if (!var3.vmethod3350(var1.field1225, (byte) 1)) {
					return false;
				}

				buffer.field2339 = 0;
				var3.vmethod3351(buffer.field2338, 0, var1.field1225, -2012807793);
				var1.field1228 = 0;
				field804.method5244((byte) 92);
				var1.field1227 = var1.field1226;
				var1.field1226 = var1.field1215;
				var1.field1215 = var1.packetType;
				long var8;
				long var11;
				int var14;
				int var16;
				String var18;
				int var19;
				long var21;
				String var50;


				// Custom packets:
				if (IncomingPacket.SEND_JOURNAL == var1.packetType) {
					int active = buffer.readUByte();
					List<Object[]> categories = new ArrayList<Object[]>();
					while (buffer.field2339 < var1.field1225)
						categories.add(new Object[]{buffer.readString(), buffer.readCompact()});
					JournalInterface.init(active, categories);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.UPDATE_JOURNAL == var1.packetType) {
					int childId = buffer.readCompact();
					String text = buffer.readString();
					int colorIndex = buffer.readUByte();
					JournalInterface.update(childId, text, colorIndex);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.UPDATE_DROPVIEWER == var1.packetType) {
					String name = buffer.readString();
					int petId = buffer.readUShort();
					int petAverage = buffer.readUShort();
					List<Integer[]> drops = new ArrayList<Integer[]>();
					while (buffer.field2339 < var1.field1225) {
						Integer[] drop = new Integer[5];
						drop[0] = buffer.readUShort();    //id
						drop[1] = buffer.readUByte();     //broadcast
						drop[2] = buffer.readInt();       //min amount
						drop[3] = buffer.readInt();       //max amount
						drop[4] = buffer.readUShort();    //average
						drops.add(drop);
					}
					DropViewerInterface.init(name, petId, petAverage, drops);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.UPDATE_LOYALTY == var1.packetType) {
					int dayReward = buffer.readByte();
					int currentSpree = buffer.readInt();
					int highestSpree = buffer.readInt();
					int totalClaimedRewards = buffer.readInt();
					List<int[]> packs = new ArrayList<int[]>();
					while (buffer.field2339 < var1.field1225) {
						int[] pack = new int[2];
						pack[0] = buffer.readInt();
						pack[1] = buffer.readInt();
						packs.add(pack);
					}
					LoyaltyInterface.init(dayReward, currentSpree, highestSpree, totalClaimedRewards, packs);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.UPDATE_SHOP == var1.packetType) {
					String name = buffer.readString();
					int interfaceId = buffer.readInt();
					int size = buffer.readShort();
					int[][] items = new int[size][];
					Item[] stock = new Item[size];
					int scriptId = (interfaceId == 178 ? 878 : 1124);
					for (int i = 0; i < size; i++) {
						int itemId = buffer.readShort();
						int itemCost = buffer.readInt();
						Item it = new Item(itemId, itemCost);
						items[i] = new int[]{itemId, itemCost};
						stock[i] = it;
					}
					ShopInterface.init(name, items);
					Custom.Interfaces.updateMappedContainer(scriptId, stock);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.JAK_CANCER_PACKET == var1.packetType) {
					int action = buffer.readByte();

					if (action == 1) {
						GameClient.field632 = buffer.readInt();
					} else if (action == 2) {
						killstreakSkullsEnabled = buffer.readByte() == 1;
					} else if (action == 3) {
						boolean sendJagexClientErrorReport = buffer.readByte() == 1;
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.TELEPORT_INTERFACE == var1.packetType) {
					String title = buffer.readString();

					int catIndex = buffer.readUByte();
					String[] cats = new String[buffer.readUByte()];
					for(int i = 0; i < cats.length; i++)
						cats[i] = buffer.readString();

					int subIndex = buffer.readUByte();
					String[] subs = new String[buffer.readUByte()];
					for(int i = 0; i < subs.length; i++)
						subs[i] = buffer.readString();

					List<String> options = new ArrayList<String>();
					while(buffer.field2339 < var1.field1225)
						options.add(buffer.readString());

					TeleportInterface.init(title, catIndex, cats, subIndex, subs, options.toArray(new String[0]));

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2131 == var1.packetType) {
					var50 = buffer.readString();
					var21 = (long) buffer.readUShort();
					var8 = (long) buffer.readMedium();
					Icon var59 = (Icon) class76.method1803(class20.getIcons(), buffer.readUByte(), (byte) 0);
					var11 = (var21 << 32) + var8;
					boolean var61 = false;

					for (var14 = 0; var14 < 100; var14++) {
						if (var11 == field797[var14]) {
							var61 = true;
							break;
						}
					}

					if (class181.field2332.method1630(new class291(var50, class36.field306), -1614375319)) {
						var61 = true;
					}

					if (!var61 && field694 == 0) {
						field797[field798] = var11;
						field798 = (field798 + 1) % 100;

						String var15;
						try {
							var16 = buffer.readCompact();
							if (var16 > 32767) {
								var16 = 32767;
							}

							byte[] var63 = new byte[var16];
							buffer.field2339 += class300.field3712.method3480(buffer.field2338, buffer.field2339, var63, 0, var16, 1741371195);
							var18 = class78.method1831(var63, 0, var16, -1686140267);
							var15 = var18;
						} catch (Exception var47) {
							var15 = "Cabbage";
						}

						var15 = class299.method5521(class51.method998(var15, (byte) 1));
						byte var62;
						if (var59.field3126) {
							var62 = 7;
						} else {
							var62 = 3;
						}

						if (var59.field3128 != -1) {
							var19 = var59.field3128;
							var18 = "<img=" + var19 + ">";
							class143.method3172(var62, var18 + var50, var15);
						} else {
							class143.method3172(var62, var50, var15);
						}
					}

					var1.packetType = null;
					return true;
				}

				boolean var65;
				if (IncomingPacket.field2103 == var1.packetType) {
					var65 = buffer.readBoolean();
					if (var65) {
						if (class21.field175 == null) {
							class21.field175 = new class251();
						}
					} else {
						class21.field175 = null;
					}

					var1.packetType = null;
					return true;
				}

				int var9;
				int var26;
				int var27;
				int var28;
				long var29;
				if (IncomingPacket.field2084 == var1.packetType) {
					int start = buffer.readShortA();
					if (start == 65535) {
						start = -1;
					}

					int inter = buffer.readIntV2();
					int value = buffer.readIntV1();
					int end = buffer.readLEShortA();
					if (end == 65535) {
						end = -1;
					}

					System.out.printf("InterfaceSettings: targ=[%d:%d] child=%d..%d value=%d%n", inter>>16, inter&0xFFFF, start, end, value);

					for (var9 = start; var9 <= end; var9++) {
						var29 = ((long) inter << 32) + (long) var9;
						class204 var60 = interfaceSettings.get(var29);
						if (var60 != null) {
							var60.unlink();
						}

						interfaceSettings.method4016(new class211(value), var29);
					}

					var1.packetType = null;
					return true;
				}

				Widget var31;
				int var32;
				if (IncomingPacket.field2071 == var1.packetType) {
					var26 = buffer.readInt();
					var27 = buffer.readUShort();
					if (var26 < -70000) {
						var27 += 32768;
					}

					if (var26 >= 0) {
						var31 = Widget.getLoaded(var26);
					} else {
						var31 = null;
					}

					for (; buffer.field2339 < var1.field1225; class10.method96(var27, var28, var9 - 1, var32, -1588398214)) {
						var28 = buffer.readCompact();
						var9 = buffer.readUShort();
						var32 = 0;
						if (var9 != 0) {
							var32 = buffer.readUByte();
							if (var32 == 255) {
								var32 = buffer.readInt();
							}
						}

						if (var31 != null && var28 >= 0 && var28 < var31.field2724.length) {
							var31.field2724[var28] = var9;
							var31.field2725[var28] = var32;
						}
					}

					if (var31 != null) {
						requestRedraw(var31);
					}

					class295.method5501(911738943);
					field766[++field767 - 1 & 31] = var27 & 32767;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2108 == var1.packetType) {
					class226.mapBaseZ = buffer.readUByte();
					class57.mapBaseX = buffer.readUByteA();

					while (buffer.field2339 < var1.field1225) {
						var26 = buffer.readUByte();
						class171[] var57 = new class171[]{class171.field2249, class171.field2242, class171.field2244, class171.field2243, class171.field2245, class171.field2246, class171.field2241, class171.field2248, class171.field2247, class171.field2250};
						class171 var71 = var57[var26];
						class29.decodeMapPacket(var71);
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2117 == var1.packetType) {
					class97.method2213(1818249317);
					var1.packetType = null;
					return false;
				}

				if (IncomingPacket.field2100 == var1.packetType) {
					var26 = buffer.readIntV1();
					var27 = buffer.readShortA();
					var31 = Widget.getLoaded(var26);
					if (var31.mediaType != 2 || var27 != var31.mediaID) {
						var31.mediaType = 2;
						var31.mediaID = var27;
						requestRedraw(var31);
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.DISPLAY_STATIC_MAP == var1.packetType) {
					class51.method994(false, var1.field1219, -1213882472);
					var1.packetType = null;
					return true;
				}

				boolean var72;
				if (IncomingPacket.field2116 == var1.packetType) {
					var26 = buffer.readIntV2();
					var72 = buffer.readUByteN() == 1;
					var31 = Widget.getLoaded(var26);
					if (var72 != var31.hidden) {
						var31.hidden = var72;
						requestRedraw(var31);
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.INVOKE_CS2 == var1.packetType) {
					var50 = buffer.readString();
					Object[] var56 = new Object[var50.length() + 1];

					for (var7 = var50.length() - 1; var7 >= 0; --var7) {
						if (var50.charAt(var7) == 115) {
							var56[var7 + 1] = buffer.readString();
						} else {
							var56[var7 + 1] = new Integer(buffer.readInt());
						}
					}

					var56[0] = new Integer(buffer.readInt());
					System.out.printf("CS2(%s): %s%n", var50, Arrays.toString(var56));
					ScriptInvocation var70 = new ScriptInvocation();
					var70.parameters = var56;
					class68.method1696(var70);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.DISPLAY_INSTANCED_MAP == var1.packetType) {
					class51.method994(true, var1.field1219, 1345751427);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2121 == var1.packetType) {
					for (var26 = 0; var26 < class254.field3232; var26++) {
						class254 var55 = class63.method1549(var26, 327770594);
						if (var55 != null) {
							class225.field2559[var26] = 0;
							class225.field2558[var26] = 0;
						}
					}

					class295.method5501(531195184);
					staticInt244 += 32;
					var1.packetType = null;
					return true;
				}

				long var33;
				int var36;
				if (IncomingPacket.field2114 == var1.packetType) {
					var50 = buffer.readString();
					var21 = buffer.readLong();
					var8 = (long) buffer.readUShort();
					var29 = (long) buffer.readMedium();
					Icon var12 = (Icon) class76.method1803(class20.getIcons(), buffer.readUByte(), (byte) 0);
					var33 = var29 + (var8 << 32);
					boolean var69 = false;

					for (var16 = 0; var16 < 100; var16++) {
						if (var33 == field797[var16]) {
							var69 = true;
							break;
						}
					}

					if (var12.field3127 && class181.field2332.method1630(new class291(var50, class36.field306), -103152481)) {
						var69 = true;
					}

					if (!var69 && field694 == 0) {
						field797[field798] = var33;
						field798 = (field798 + 1) % 100;

						String var17;
						try {
							var36 = buffer.readCompact();
							if (var36 > 32767) {
								var36 = 32767;
							}

							byte[] var37 = new byte[var36];
							buffer.field2339 += class300.field3712.method3480(buffer.field2338, buffer.field2339, var37, 0, var36, 1017876494);
							String var20 = class78.method1831(var37, 0, var36, -1408823976);
							var17 = var20;
						} catch (Exception var46) {
							var17 = "Cabbage";
						}

						var17 = class299.method5521(class51.method998(var17, (byte) 1));
						if (var12.field3128 != -1) {
							var19 = var12.field3128;
							var18 = "<img=" + var19 + ">";
							class173.method3472(9, var18 + var50, var17, class172.method3457(var21), 1423471307);
						} else {
							class173.method3472(9, var50, var17, class172.method3457(var21), 114141709);
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2052 == var1.packetType) {
					field810 = buffer.readUByte();
					var1.packetType = null;
					return true;
				}

				String var66;
				String var75;
				if (IncomingPacket.field2111 == var1.packetType) {
					var26 = buffer.readCompact();
					var72 = buffer.readUByte() == 1;
					var66 = "";
					boolean var68 = false;
					if (var72) {
						var66 = buffer.readString();
						if (class181.field2332.method1630(new class291(var66, class36.field306), 783037314)) {
							var68 = true;
						}
					}

					var75 = buffer.readString();

					if (var26 == 69) {
						Custom.openBrowser(var75, true, false);
						var1.packetType = null;
						return true;
					}

					if (!var68) {
						class143.method3172(var26, var66, var75);
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2126 == var1.packetType) {
					var26 = buffer.readUShort();
					var27 = buffer.readUByte();
					var7 = buffer.readUShort();
					if (field814 != 0 && var27 != 0 && field656 < 50) {
						field817[field656] = var26;
						field676[field656] = var27;
						field819[field656] = var7;
						field719[field656] = null;
						field820[field656] = 0;
						++field656;
					}

					var1.packetType = null;
					return true;
				}

				int var39;
				if (IncomingPacket.field2097 == var1.packetType) {
					field822 = true;
					class50.field456 = buffer.readUByte();
					class237.field3082 = buffer.readUByte();
					class11.field68 = buffer.readUShort();
					Npc.field1033 = buffer.readUByte();
					class133.field1834 = buffer.readUByte();
					if (class133.field1834 >= 100) {
						var26 = class50.field456 * 128 + 64;
						var27 = class237.field3082 * 128 + 64;
						var7 = class27.method460(var26, var27, class13.field82, 434592086) - class11.field68;
						var28 = var26 - class109.field1431;
						var9 = var7 - class123.field1702;
						var32 = var27 - class226.field2563;
						var39 = (int) Math.sqrt((double) (var32 * var32 + var28 * var28));
						class7.field41 = (int) (Math.atan2((double) var9, (double) var39) * 325.949D) & 2047;
						class85.field1201 = (int) (Math.atan2((double) var28, (double) var32) * -325.949D) & 2047;
						if (class7.field41 < 128) {
							class7.field41 = 128;
						}

						if (class7.field41 > 383) {
							class7.field41 = 383;
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2066 == var1.packetType) {
					class29.decodeMapPacket(class171.field2242);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.PLAYER_UPDATE == var1.packetType) {
					class216.decodePlayerMasks(buffer, var1.field1225);
					class97.method2215(-902888602);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2061 == var1.packetType) {
					class29.decodeMapPacket(class171.field2248);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2056 == var1.packetType) {
					class57.mapBaseX = buffer.readUByteS();
					class226.mapBaseZ = buffer.readUByteA();

					for (var26 = class57.mapBaseX; var26 < class57.mapBaseX + 8; var26++) {
						for (var27 = class226.mapBaseZ; var27 < class226.mapBaseZ + 8; var27++) {
							if (field708[class13.field82][var26][var27] != null) {
								field708[class13.field82][var26][var27] = null;
								class253.method4808(var26, var27, 1420324028);
							}
						}
					}

					for (class62 var52 = (class62) field714.method4098(); var52 != null; var52 = (class62) field714.method4079()) {
						if (var52.field857 >= class57.mapBaseX && var52.field857 < class57.mapBaseX + 8 && var52.field858 >= class226.mapBaseZ && var52.field858 < class226.mapBaseZ + 8 && var52.field861 == class13.field82) {
							var52.field860 = 0;
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2049 == var1.packetType) {
					class29.decodeMapPacket(class171.field2249);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2118 == var1.packetType) {
					var26 = buffer.readUByte();
					var27 = buffer.readUByte();
					var7 = buffer.readUByte();
					var28 = buffer.readUByte();
					field823[var26] = true;
					field824[var26] = var27;
					field825[var26] = var7;
					field826[var26] = var28;
					field705[var26] = 0;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2069 == var1.packetType) {
					var26 = buffer.readUByteS();
					var27 = buffer.readUByteN();
					var66 = buffer.readString();
					if (var27 >= 1 && var27 <= 8) {
						if (var66.equalsIgnoreCase("null")) {
							var66 = null;
						}

						field704[var27 - 1] = var66;
						field709[var27 - 1] = var26 == 0;
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2105 == var1.packetType) {
					class29.decodeMapPacket(class171.field2244);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2092 == var1.packetType) {
					class29.decodeMapPacket(class171.field2250);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2075 == var1.packetType) {
					field808 = buffer.readUByte();
					if (field808 == 255) {
						field808 = 0;
					}

					field809 = buffer.readUByte();
					if (field809 == 255) {
						field809 = 0;
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2122 == var1.packetType) {
					var26 = buffer.readInt();
					var27 = buffer.readUShort();
					if (var26 < -70000) {
						var27 += 32768;
					}

					if (var26 >= 0) {
						var31 = Widget.getLoaded(var26);
					} else {
						var31 = null;
					}

					if (var31 != null) {
						for (var28 = 0; var28 < var31.field2724.length; var28++) {
							var31.field2724[var28] = 0;
							var31.field2725[var28] = 0;
						}
					}

					class121.method2782(var27, (byte) 32);
					var28 = buffer.readUShort();

					for (var9 = 0; var9 < var28; var9++) {
						var32 = buffer.readUByte();
						if (var32 == 255) {
							var32 = buffer.readIntV2();
						}

						var39 = buffer.readUShort();
						if (var31 != null && var9 < var31.field2724.length) {
							var31.field2724[var9] = var39;
							var31.field2725[var9] = var32;
						}

						class10.method96(var27, var9, var39 - 1, var32, -1755938649);
					}

					if (var31 != null) {
						requestRedraw(var31);
					}

					class295.method5501(1994667604);
					field766[++field767 - 1 & 31] = var27 & 32767;
					var1.packetType = null;
					return true;
				}

				Widget var74;
				if (IncomingPacket.field2101 == var1.packetType) {
					var26 = buffer.readIntV1();
					var27 = buffer.readUShort();
					var7 = buffer.readLEShortA();
					var28 = buffer.readUShortLE();
					var74 = Widget.getLoaded(var26);
					if (var28 != var74.rotationX || var27 != var74.rotationY || var7 != var74.zoom) {
						var74.rotationX = var28;
						var74.rotationY = var27;
						var74.zoom = var7;
						requestRedraw(var74);
					}

					var1.packetType = null;
					return true;
				}

				Widget var78;
				if (IncomingPacket.field2090 == var1.packetType) {
					var26 = buffer.readShort();
					var27 = buffer.readIntLE();
					var7 = buffer.readLEShortA(-146230491);
					var78 = Widget.getLoaded(var27);
					if (var7 != var78.x || var26 != var78.y || var78.xAlignment != 0 || var78.yAlignment != 0) {
						var78.x = var7;
						var78.y = var26;
						var78.xAlignment = 0;
						var78.yAlignment = 0;
						requestRedraw(var78);
						this.method506(var78);
						if (var78.widgetType == 0) {
							class163.method3388(Widget.LOADED[var27 >> 16], var78, false, 96383462);
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2112 == var1.packetType) {
					buffer.field2339 += 28;
					if (buffer.method3756(-560337220)) {
						class175.method3487(buffer, buffer.field2339 - 28, -6945047);
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2054 == var1.packetType) {
					field598 = buffer.readUShortLE() * 30;
					field775 = field801;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2094 == var1.packetType) {
					var26 = buffer.readShortA();
					if (var26 == 65535) {
						var26 = -1;
					}

					var27 = buffer.readInt();
					var7 = buffer.readIntLE();
					var78 = Widget.getLoaded(var27);
					ItemDef var77;
					if (!var78.decodeCs2) {
						if (var26 == -1) {
							var78.mediaType = 0;
							var1.packetType = null;
							return true;
						}

						var77 = ItemDef.loadItemDef(var26);
						var78.mediaType = 4;
						var78.mediaID = var26;
						var78.rotationX = var77.xan2d;
						var78.rotationY = var77.yan2d;
						var78.zoom = var77.zoom2d * 100 / var7;
						requestRedraw(var78);
					} else {
						var78.itemId = var26;
						var78.field2727 = var7;
						var77 = ItemDef.loadItemDef(var26);
						var78.rotationX = var77.xan2d;
						var78.rotationY = var77.yan2d;
						var78.int477 = var77.zan2d;
						var78.int457 = var77.xof2d;
						var78.int474 = var77.yof2d;
						var78.zoom = var77.zoom2d;
						if (var77.stackable == 1) {
							var78.field2664 = 1;
						} else {
							var78.field2664 = 2;
						}

						if (var78.int464 > 0) {
							var78.zoom = var78.zoom * 32 / var78.int464;
						} else if (var78.width > 0) {
							var78.zoom = var78.zoom * 32 / var78.width;
						}

						requestRedraw(var78);
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2058 == var1.packetType) {
					class143.field1899 = PacketBuffer.method3847(buffer.readUByte(), (short) 255);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2104 == var1.packetType) {
					var26 = buffer.readUByte();
					class132.method3096(var26, -1450282680);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2083 == var1.packetType) {
					class245.decodeNpcMasks(true, buffer);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2073 == var1.packetType) {
					field822 = true;
					class24.field203 = buffer.readUByte();
					class150.field1928 = buffer.readUByte();
					class224.field2555 = buffer.readUShort();
					class245.field3154 = buffer.readUByte();
					class84.field1197 = buffer.readUByte();
					if (class84.field1197 >= 100) {
						class109.field1431 = class24.field203 * 128 + 64;
						class226.field2563 = class150.field1928 * 128 + 64;
						class123.field1702 = class27.method460(class109.field1431, class226.field2563, class13.field82, 437504744) - class224.field2555;
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2074 == var1.packetType) {
					var26 = buffer.readInt();
					if (var26 != field853) {
						field853 = var26;
						if (field655 == 1) {
							field663 = true;
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2109 == var1.packetType) {
					field599 = buffer.readUByte();
					if (field599 == 1) {
						field600 = buffer.readUShort();
					}

					if (field599 >= 2 && field599 <= 6) {
						if (field599 == 2) {
							field605 = 64;
							field637 = 64;
						}

						if (field599 == 3) {
							field605 = 0;
							field637 = 64;
						}

						if (field599 == 4) {
							field605 = 128;
							field637 = 64;
						}

						if (field599 == 5) {
							field605 = 64;
							field637 = 0;
						}

						if (field599 == 6) {
							field605 = 64;
							field637 = 128;
						}

						field599 = 2;
						field602 = buffer.readUShort();
						field818 = buffer.readUShort();
						field604 = buffer.readUByte();
					}

					if (field599 == 10) {
						field579 = buffer.readUShort();
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2055 == var1.packetType) {
					class17.method172(buffer, var1.field1225, -2023648608);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2086 == var1.packetType) {
					var26 = buffer.readInt();
					var6 = buffer.readString();
					var31 = Widget.getLoaded(var26);
					if (!var6.equals(var31.componentString)) {
						var31.componentString = var6;
						requestRedraw(var31);
					}

					// Custom prayer swap code:
					if (var6.contains("Prayer positions:")) {
						Custom.swapPrayers(var6.contains("New"));
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.VARP_BIG == var1.packetType) {
					var26 = buffer.readIntLE();
					var27 = buffer.readUShortLE();

					if(var27 >= 20000) {
						Custom.handleCustomVarp(var27, var26);
						var1.packetType = null;
						return true;
					}

					System.out.printf("Varp: %d => %d%n", var27, var26);

					class225.field2559[var27] = var26;
					if (class225.field2558[var27] != var26) {
						class225.field2558[var27] = var26;
					}

					updateForSetting(var27);
					staticIntArray105[++staticInt244 - 1 & 31] = var27;

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2107 == var1.packetType) {
					var26 = buffer.readUShort();
					field683 = var26;
					this.method1151(false, -1642962644);
					class216.method4178(var26, 1403972661);
					class135.method3114(field683, 892303579);

					for (var27 = 0; var27 < 100; var27++) {
						staticBoolArray6[var27] = true;
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2060 == var1.packetType) {
					var26 = buffer.readInt();
					class55 var54 = (class55) field741.get((long) var26);
					if (var54 != null) {
						class20.method261(var54, true, 1473786828);
					}

					if (field744 != null) {
						requestRedraw(field744);
						field744 = null;
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2106 == var1.packetType) {
					if (class14.field94 != null) {
						class14.field94.method5489(buffer, 345415230);
					}

					class1.method13(1214880142);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2129 == var1.packetType) {
					var26 = buffer.readShortLE();
					var27 = buffer.readIntV2();
					var31 = Widget.getLoaded(var27);
					if (var26 != var31.animation || var26 == -1) {
						var31.animation = var26;
						var31.field2728 = 0;
						var31.field2613 = 0;
						requestRedraw(var31);
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2072 == var1.packetType) {
					for (var26 = 0; var26 < field610.length; var26++) {
						if (field610[var26] != null) {
							field610[var26].field903 = -1;
						}
					}

					for (var26 = 0; var26 < field843.length; var26++) {
						if (field843[var26] != null) {
							field843[var26].field903 = -1;
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2123 == var1.packetType) {
					class181.field2332.method1625(1458971090);
					field647 = field801;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2059 == var1.packetType) {
					class295.method5501(1479530238);
					var26 = buffer.readIntV1(); // xp
					var27 = buffer.readUByteA(); // skill
					var7 = buffer.readUByteN(); //lv
					field640[var27] = var26;
					field712[var27] = var7;
					field713[var27] = 1;

					for (var28 = 0; var28 < 98; var28++) {
						if (var26 >= class234.field2779[var28]) {
							field713[var27] = var28 + 2;
						}
					}

					field690[++field769 - 1 & 31] = var27;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2089 == var1.packetType) {
					var26 = buffer.readInt();
					var27 = buffer.readInt();
					var7 = class37.method661(-1520436203);
					class172 var81 = class26.method433(OutgoingPacket.field2176, field626.field1218, -1189497157);
					var81.field2257.writeByteA(GameShell.field393);
					var81.field2257.writeIntV1(var26);
					var81.field2257.writeIntV1(var27);
					var81.field2257.writeByteA(var7);
					field626.method1980(var81, (byte) 1);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2102 == var1.packetType) {
					class295.method5501(-693395802);
					field782 = buffer.readShort();
					field775 = field801;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2076 == var1.packetType) {
					if (field683 != -1) {
						var26 = field683;
						if (class261.method4931(var26, (byte) 34)) {
							class83.method1923(Widget.LOADED[var26], 0, 1406653934);
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2120 == var1.packetType) {
					class181.field2332.method1679(buffer, var1.field1225, -2029618051);
					field647 = field801;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2119 == var1.packetType) {
					class29.decodeMapPacket(class171.field2247);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2125 == var1.packetType) {
					class29.decodeMapPacket(class171.field2243);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2113 == var1.packetType) {
					if (var1.field1225 == 0) {
						class14.field94 = null;
					} else {
						if (class14.field94 == null) {
							class14.field94 = new class293(class36.field306, Stream.client);
						}

						class14.field94.method5463(buffer, -107804510);
					}

					class1.method13(2081017739);
					var1.packetType = null;
					return true;
				}

				String var10;
				int var35;
				if (IncomingPacket.field2115 == var1.packetType) {
					var50 = buffer.readString();
					class163.field2013 = var50;

					try {
						var6 = Stream.client.getParameter(class279.field3596.field3591);
						var66 = Stream.client.getParameter(class279.field3581.field3591);
						String var79 = var6 + "settings=" + var50 + "; version=1; path=/; domain=" + var66;
						if (var50.length() == 0) {
							var79 = var79 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
						} else {
							var75 = var79 + "; Expires=";
							var11 = Stream.method3547(604838575) + 94608000000L;
							class192.field2389.setTime(new Date(var11));
							int var13 = class192.field2389.get(7);
							var14 = class192.field2389.get(5);
							var35 = class192.field2389.get(2);
							var16 = class192.field2389.get(1);
							int var25 = class192.field2389.get(11);
							var36 = class192.field2389.get(12);
							var19 = class192.field2389.get(13);
							var10 = class192.field2390[var13 - 1] + ", " + var14 / 10 + var14 % 10 + "-" + class192.field2392[0][var35] + "-" + var16 + " " + var25 / 10 + var25 % 10 + ":" + var36 / 10 + var36 % 10 + ":" + var19 / 10 + var19 % 10 + " GMT";
							var79 = var75 + var10 + "; Max-Age=" + 94608000L;
						}

						GameClient var76 = Stream.client;
						var10 = "document.cookie=\"" + var79 + "\"";
						//JSObject.getWindow(var76).eval(var10);
					} catch (Throwable var45) {
						;
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2080 == var1.packetType) {
					var26 = buffer.readUByte();
					if (buffer.readUByte() == 0) {
						field844[var26] = new class4();
						buffer.field2339 += 18;
					} else {
						--buffer.field2339;
						field844[var26] = new class4(buffer, false);
					}

					field793 = field801;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2050 == var1.packetType) {
					class29.decodeMapPacket(class171.field2245);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2095 == var1.packetType) {
					class295.method5501(360507143);
					field745 = buffer.readUByte();
					field775 = field801;
					var1.packetType = null;
					return true;
				}

				Widget var53;
				if (IncomingPacket.field2088 == var1.packetType) {
					var26 = buffer.readIntLE();
					var53 = Widget.getLoaded(var26);

					for (var7 = 0; var7 < var53.field2724.length; var7++) {
						var53.field2724[var7] = -1;
						var53.field2724[var7] = 0;
					}

					requestRedraw(var53);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2068 == var1.packetType) {
					class226.mapBaseZ = buffer.readUByteA();
					class57.mapBaseX = buffer.readUByteS();
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2078 == var1.packetType) {
					var26 = buffer.readShortA();
					if (var26 == 65535) {
						var26 = -1;
					}

					if (var26 == -1 && !field813) {
						class9.method88((byte) 35);
					} else if (var26 != -1 && var26 != field812 && field811 != 0 && !field813) {
						class65.method1602(2, Item.field1147, var26, 0, field811, false, (byte) 38);
					}

					field812 = var26;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2051 == var1.packetType) {
					var26 = buffer.method3591(2079468396);
					var27 = buffer.readUShortLE();
					if (var27 == 65535) {
						var27 = -1;
					}

					class50.method965(var27, var26, (byte) -29);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2082 == var1.packetType) {
					field822 = false;

					for (var26 = 0; var26 < 5; var26++) {
						field823[var26] = false;
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2053 == var1.packetType) {
					var26 = buffer.readIntV1();
					var27 = buffer.readLEShortA();
					var7 = var27 >> 10 & 31;
					var28 = var27 >> 5 & 31;
					var9 = var27 & 31;
					var32 = (var28 << 11) + (var7 << 19) + (var9 << 3);
					Widget var80 = Widget.getLoaded(var26);
					if (var32 != var80.color) {
						var80.color = var32;
						requestRedraw(var80);
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2124 == var1.packetType) {
					var26 = buffer.readIntV2();
					var53 = Widget.getLoaded(var26);
					var53.mediaType = 3;
					var53.mediaID = class138.field1876.field546.method4483(-709591289);
					requestRedraw(var53);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.NPC_UPDATE == var1.packetType) {
					class245.decodeNpcMasks(false, buffer);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2065 == var1.packetType) {
					class29.decodeMapPacket(class171.field2246);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2081 == var1.packetType) {
					class29.decodeMapPacket(class171.field2241);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2093 == var1.packetType) {
					field795 = buffer.readUByteN();
					field630 = buffer.readUByteN();
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2132 == var1.packetType) {
					var65 = buffer.readUByte() == 1;
					if (var65) {
						class70.field1013 = Stream.method3547(604838575) - buffer.readLong();
						class19.field154 = new class1(buffer, true);
					} else {
						class19.field154 = null;
					}

					field774 = field801;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.VARP_SMALL == var1.packetType) {
					byte var64 = buffer.readByteS();
					var27 = buffer.readUShortLE();

					if(var27 >= 20000) {
						Custom.handleCustomVarp(var27, var64);
						var1.packetType = null;
						return true;
					}

					System.out.printf("Varp: %d => %d%n", var27, var64);
					class225.field2559[var27] = var64;
					if (class225.field2558[var27] != var64) {
						class225.field2558[var27] = var64;
					}

					updateForSetting(var27);
					staticIntArray105[++staticInt244 - 1 & 31] = var27;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2077 == var1.packetType) {
					var26 = buffer.readShortA();
					class177.method3507(var26, -1945852899);
					field766[++field767 - 1 & 31] = var26 & 32767;
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2087 == var1.packetType) {
					var26 = buffer.readUShort();
					var27 = buffer.readIntLE();
					var7 = buffer.readUShortLE();
					var78 = Widget.getLoaded(var27);
					var78.field2732 = var7 + (var26 << 16);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2062 == var1.packetType) {
					class181.field2332.field975.method5317(buffer, var1.field1225, 777447956);
					GameShell.method910(670224222);
					if (class14.field94 != null) {
						class14.field94.method5468(453420624);
					}

					field647 = field801;
					var1.packetType = null;
					return true;
				}

				class55 var40;
				if (IncomingPacket.field2063 == var1.packetType) {
					int from = buffer.readIntV2();
					int to = buffer.readIntV1();
					System.out.printf("InterSwitch: from [%d:%d] to [%d:%d]%n", from>>16, from & 0xFFFF, to>>16, to&0xFFFF);
					class55 var67 = (class55) field741.get((long) from);
					var40 = (class55) field741.get((long) to);
					if (var40 != null) {
						class20.method261(var40, var67 == null || var67.field501 != var40.field501, 2119625543);
					}

					if (var67 != null) {
						var67.unlink();
						field741.method4016(var67, (long) to);
					}

					var74 = Widget.getLoaded(from);
					if (var74 != null) {
						requestRedraw(var74);
					}

					var74 = Widget.getLoaded(to);
					if (var74 != null) {
						requestRedraw(var74);
						class163.method3388(Widget.LOADED[var74.interfaceHash >>> 16], var74, true, 747977817);
					}

					if (field683 != -1) {
						var32 = field683;
						if (class261.method4931(var32, (byte) -56)) {
							class83.method1923(Widget.LOADED[var32], 1, -514769835);
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2096 == var1.packetType) {
					class65 var51 = new class65();
					var51.field950 = buffer.readString();
					var51.field947 = buffer.readUShort();
					var27 = buffer.readInt();
					var51.field948 = var27;
					class48.method947(45, 50089105);
					var3.vmethod3346(1775992211);
					var3 = null;
					class61.method1129(var51, (byte) 59);
					var1.packetType = null;
					return false;
				}

				if (IncomingPacket.OPEN_INTERFACE == var1.packetType) {
					var26 = buffer.readUByteS();
					var27 = buffer.readIntLE();
					var7 = buffer.readShortA();
					System.out.printf("OpenInter: %d:%d id=%d walk=%d%n", var27>>16, var27 & 0xFFFF, var7, var26);
					var40 = (class55) field741.get((long) var27);
					if (var40 != null) {
						class20.method261(var40, var7 != var40.field501, 2130500083);
					}

					class55 var73 = new class55();
					var73.field501 = var7;
					var73.field494 = var26;
					field741.method4016(var73, (long) var27);
					class216.method4178(var7, 282926141);
					Widget var58 = Widget.getLoaded(var27);
					requestRedraw(var58);
					if (field744 != null) {
						requestRedraw(field744);
						field744 = null;
					}

					class170.method3448(-2129925873);
					class163.method3388(Widget.LOADED[var27 >> 16], var58, false, 1682135609);
					class135.method3114(var7, 892303579);
					if (field683 != -1) {
						var39 = field683;
						if (class261.method4931(var39, (byte) 45)) {
							class83.method1923(Widget.LOADED[var39], 1, 1324128726);
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2128 == var1.packetType) {
					var26 = buffer.readIntV1();
					var27 = buffer.readShortA();
					var31 = Widget.getLoaded(var26);
					if (var31 != null && var31.widgetType == 0) {
						if (var27 > var31.scrollHeight - var31.int466) {
							var27 = var31.scrollHeight - var31.int466;
						}

						if (var27 < 0) {
							var27 = 0;
						}

						if (var27 != var31.scrollY) {
							var31.scrollY = var27;
							requestRedraw(var31);
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2091 == var1.packetType) {
					var50 = buffer.readString();

					try {
						var28 = buffer.readCompact();
						if (var28 > 32767) {
							var28 = 32767;
						}

						byte[] var38 = new byte[var28];
						buffer.field2339 += class300.field3712.method3480(buffer.field2338, buffer.field2339, var38, 0, var28, 1593737515);
						var10 = class78.method1831(var38, 0, var28, -1618651695);
						var66 = var10;
					} catch (Exception var44) {
						var66 = "Cabbage";
					}

					var66 = class299.method5521(class51.method998(var66, (byte) 1));
					class143.method3172(6, var50, var66);
					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2079 == var1.packetType) {
					var26 = buffer.field2339 + var1.field1225;
					var27 = buffer.readUShort();
					var7 = buffer.readUShort();
					System.out.printf("Bulk inter open: %d, %d\n", var27, var7);
					if (var27 != field683) {
						field683 = var27;
						this.method1151(false, -696507338);
						class216.method4178(field683, -1061206166);
						class135.method3114(field683, 892303579);

						for (var28 = 0; var28 < 100; var28++) {
							staticBoolArray6[var28] = true;
						}
					}

					class55 var41;
					for (; var7-- > 0; var41.field496 = true) {
						var28 = buffer.readInt();
						var9 = buffer.readUShort();
						var32 = buffer.readUByte();
						System.out.printf("\tInterface: [%d:%d] id=%d walk=%d%n", var28>>16, var28&0xFFFF, var9, var32);
						var41 = (class55) field741.get((long) var28);
						if (var41 != null && var9 != var41.field501) {
							class20.method261(var41, true, 1591796041);
							var41 = null;
						}

						if (var41 == null) {
							class55 var42 = new class55();
							var42.field501 = var9;
							var42.field494 = var32;
							field741.method4016(var42, (long) var28);
							class216.method4178(var9, 1543859717);
							Widget var24 = Widget.getLoaded(var28);
							requestRedraw(var24);
							if (field744 != null) {
								requestRedraw(field744);
								field744 = null;
							}

							class170.method3448(-1701015218);
							class163.method3388(Widget.LOADED[var28 >> 16], var24, false, 1366569533);
							class135.method3114(var9, 892303579);
							if (field683 != -1) {
								var35 = field683;
								if (class261.method4931(var35, (byte) -67)) {
									class83.method1923(Widget.LOADED[var35], 1, -768415099);
								}
							}

							var41 = var42;
						}
					}

					for (var40 = (class55) field741.method4018(); var40 != null; var40 = (class55) field741.method4019()) {
						if (var40.field496) {
							var40.field496 = false;
						} else {
							class20.method261(var40, true, 1858743950);
						}
					}

					interfaceSettings = new class202(512);

					System.out.println("Settings:");
					while (buffer.field2339 < var26) {
						var28 = buffer.readInt();
						var9 = buffer.readUShort();
						var32 = buffer.readUShort();
						var39 = buffer.readInt();
						System.out.printf("\tSetting: [%d:%d] targ=%d..%d value=%d%n", var28>>16, var28&0xFFFF, var9, var32, var39);

						for (int var43 = var9; var43 <= var32; var43++) {
							var33 = ((long) var28 << 32) + (long) var43;
							interfaceSettings.method4016(new class211(var39), var33);
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2064 == var1.packetType) {
					for (var26 = 0; var26 < class225.field2558.length; var26++) {
						if (class225.field2558[var26] != class225.field2559[var26]) {
							class225.field2558[var26] = class225.field2559[var26];
							updateForSetting(var26);
							staticIntArray105[++staticInt244 - 1 & 31] = var26;
						}
					}

					var1.packetType = null;
					return true;
				}

				if (IncomingPacket.field2130 == var1.packetType) {
					var26 = buffer.readIntV1();
					var27 = buffer.readUShort();
					var31 = Widget.getLoaded(var26);
					if (var31.mediaType != 1 || var27 != var31.mediaID) {
						var31.mediaType = 1;
						var31.mediaID = var27;
						requestRedraw(var31);
					}

					var1.packetType = null;
					return true;
				}

				class5.method65("" + (var1.packetType != null ? var1.packetType.id : -1) + "," + (var1.field1226 != null ? var1.field1226.id : -1) + "," + (var1.field1227 != null ? var1.field1227.id : -1) + "," + var1.field1225, (Throwable) null, (byte) 5);
				class97.method2213(1818249317);
			} catch (IOException var48) {
				class30.method516(-2090947943);
			} catch (Exception var49) {
				var6 = "" + (var1.packetType != null ? var1.packetType.id : -1) + "," + (var1.field1226 != null ? var1.field1226.id : -1) + "," + (var1.field1227 != null ? var1.field1227.id : -1) + "," + var1.field1225 + "," + (class138.field1876.field922[0] + class62.baseX) + "," + (class138.field1876.field872[0] + baseY) + ",";

				for (var7 = 0; var7 < var1.field1225 && var7 < 50; var7++) {
					var6 = var6 + buffer.field2338[var7] + ",";
				}

				class5.method65(var6, var49, (byte) 62);
				class97.method2213(1818249317);
			}

			return true;
		}
	}

	final void method1476(int var1, int var2, int var3) {
		class184.method3785(var1, var2, 805819777);
		class28.field248.method2909(class13.field82, var1, var2, false);
		field716 = true;
	}

	protected final void vmethod1136(int var1) {
		++field591;
		this.method1139(1481813708);
		class84.method1955(952694011);

		int var2;
		try {
			if (class217.field2460 == 1) {
				var2 = class217.field2459.method4288(392205958);
				if (var2 > 0 && class217.field2459.method4203(1343580600)) {
					var2 -= class6.field37;
					if (var2 < 0) {
						var2 = 0;
					}

					class217.field2459.method4236(var2, 1769486649);
				} else {
					class217.field2459.method4202((byte) 6);
					class217.field2459.method4200(-1788128150);
					if (class138.field1871 != null) {
						class217.field2460 = 2;
					} else {
						class217.field2460 = 0;
					}

					class177.field2285 = null;
					Item.field1149 = null;
				}
			}
		} catch (Exception var9) {
			var9.printStackTrace();
			class217.field2459.method4202((byte) 27);
			class217.field2460 = 0;
			class177.field2285 = null;
			Item.field1149 = null;
			class138.field1871 = null;
		}

		class54.method1017(2123313201);
		class39 var6 = class39.field337;
		synchronized (class39.field337) {
			++class39.field353;
			class39.field350 = class39.field352;
			class39.field349 = 0;
			int var3;
			if (class39.field329 >= 0) {
				while (class39.field344 != class39.field329) {
					var3 = class39.field343[class39.field344];
					class39.field344 = class39.field344 + 1 & 127;
					if (var3 < 0) {
						class39.field341[~var3] = false;
					} else {
						if (!class39.field341[var3] && class39.field349 < class39.field338.length - 1) {
							class39.field338[++class39.field349 - 1] = var3;
						}

						class39.field341[var3] = true;
					}
				}
			} else {
				if (var1 <= 80127991) {
					return;
				}

				for (var3 = 0; var3 < 112; var3++) {
					class39.field341[var3] = false;
				}

				class39.field329 = class39.field344;
			}

			if (class39.field349 > 0) {
				class39.field353 = 0;
			}

			class39.field352 = class39.field351;
		}

		class48 var10 = class48.field429;
		synchronized (class48.field429) {
			class48.field419 = class48.field424;
			class48.field425 = class48.field422;
			class48.field426 = class48.field423 * -1660309769;
			class48.field431 = class48.field421;
			class48.field432 = class48.field420;
			class48.field428 = class48.field434;
			class48.field433 = class48.field430;
			class48.field421 = 0;
		}

		if (class33.field294 != null) {
			var2 = class33.field294.vmethod3278(-371619108);
			field695 = var2;
		}

		if (field589 == 0) {
			class29.method478((byte) 120);
			class43.field368.vmethod3330(2021286604);

			for (var2 = 0; var2 < 32; var2++) {
				GameShell.field394[var2] = 0L;
			}

			for (var2 = 0; var2 < 32; var2++) {
				if (var1 <= 80127991) {
					return;
				}

				GameShell.field404[var2] = 0L;
			}

			class8.field48 = 0;
		} else if (field589 == 5) {
			if (var1 <= 80127991) {
				return;
			}

			class186.method3806(this, 1188144739);
			class29.method478((byte) 55);
			class43.field368.vmethod3330(2102680178);

			for (var2 = 0; var2 < 32; var2++) {
				if (var1 <= 80127991) {
					return;
				}

				GameShell.field394[var2] = 0L;
			}

			for (var2 = 0; var2 < 32; var2++) {
				GameShell.field404[var2] = 0L;
			}

			class8.field48 = 0;
		} else if (field589 != 10 && field589 != 11) {
			if (field589 == 20) {
				class186.method3806(this, 1998708829);
				this.method1142(-2122262374);
			} else if (field589 == 25) {
				class15.method148(2126633421);
			}
		} else {
			class186.method3806(this, -1775785270);
		}

		if (field589 == 30) {
			this.method1143((byte) 51);
		} else {
			if (field589 != 40) {
				if (field589 != 45) {
					return;
				}

				if (var1 <= 80127991) {
					return;
				}
			}

			this.method1142(-994520186);
		}

	}

	void method1140(int var1) {
		if (class250.field3214 >= 4) {
			if (var1 != 1257526257) {
				this.method788("js5crc", 1327956818);
				field589 = 1000;
			}
		} else {
			if (class250.field3215 >= 4) {
				if (field589 <= 5) {
					this.method788("js5io", 1327956818);
					field589 = 1000;
					return;
				}

				field768 = 3000;
				class250.field3215 = 3;
			}

			--field768;
			if (field768 - 1 + 1 <= 0) {
				try {
					if (field692 == 0) {
						field839 = GameShell.field392.method3259(class54.gameHost, class290.field3636, 2079674302);
						++field692;
					}

					if (field692 == 1) {
						if (var1 == 1257526257) {
							return;
						}

						if (field839.field1946 == 2) {
							this.method1141(-1, 656785584);
							return;
						}

						if (field839.field1946 == 1) {
							++field692;
						}
					}

					if (field692 == 2) {
						if (field629) {
							if (var1 == 1257526257) {
								return;
							}

							field611 = GameShell.method911((Socket) field839.field1944, 40000, 5000, (byte) -53);
						} else {
							field611 = new class161((Socket) field839.field1944, GameShell.field392, 5000);
						}

						Stream var2 = new Stream(5);
						var2.writeByte(15);
						var2.writeInt(171);
						field611.vmethod3347(var2.field2338, 0, 5, (byte) -20);
						++field692;
						class229.field2589 = Stream.method3547(604838575);
					}

					if (field692 == 3) {
						label129:
						{
							label125:
							{
								if (field611.vmethod3349(165525723) <= 0) {
									if (var1 == 1257526257) {
										return;
									}

									if (field629) {
										break label125;
									}

									if (var1 == 1257526257) {
										return;
									}

									if (field589 > 5) {
										break label125;
									}
								}

								int var3 = field611.vmethod3353(1469970817);
								if (var3 != 0) {
									this.method1141(var3, 656785584);
									return;
								}

								++field692;
								break label129;
							}

							if (Stream.method3547(604838575) - class229.field2589 > 30000L) {
								this.method1141(-2, 656785584);
								return;
							}
						}
					}

					if (field692 == 4) {
						class36.method633(field611, field589 > 20, -2121353984);
						field839 = null;
						field611 = null;
						field692 = 0;
						field614 = 0;
					}
				} catch (IOException var4) {
					this.method1141(-3, 656785584);
				}

			}
		}
	}

	final void method1146(byte var1) {
		if (field683 != -1) {
			class21.method270(field683, 1316208853);
		}

		int var2;
		for (var2 = 0; var2 < field603; var2++) {
			if (var1 != 0) {
				return;
			}

			if (staticBoolArray6[var2]) {
				if (var1 != 0) {
					return;
				}

				field788[var2] = true;
			}

			field723[var2] = staticBoolArray6[var2];
			staticBoolArray6[var2] = false;
		}

		staticInt225 = field591;
		field729 = -1;
		field730 = -1;
		class132.field1819 = null;
		if (field683 != -1) {
			field603 = 0;
			class35.method630(field683, 0, 0, class82.field1179, class243.field3138, 0, 0, -1, (byte) 46);
		}

		Rasterizer2D.method5719();
		if (!field716) {
			if (field729 != -1) {
				class51.method997(field729, field730, 1470602086);
			}
		} else {
			class83.method1940(1621920950);
		}

		if (field790 == 3) {
			for (var2 = 0; var2 < field603; var2++) {
				if (field723[var2]) {
					if (var1 != 0) {
						return;
					}

					Rasterizer2D.method5727(field786[var2], field787[var2], field641[var2], field789[var2], 16711935, 128);
				} else if (field788[var2]) {
					Rasterizer2D.method5727(field786[var2], field787[var2], field641[var2], field789[var2], 16711680, 128);
				}
			}
		}

		var2 = class13.field82;
		int var3 = class138.field1876.field931;
		int var4 = class138.field1876.field881;
		int var5 = field700;

		for (class68 var6 = (class68) class68.field985.method4098(); var6 != null; var6 = (class68) class68.field985.method4079()) {
			if (var6.field987 != -1 || var6.field986 != null) {
				int var7 = 0;
				if (var3 > var6.field984) {
					var7 += var3 - var6.field984;
				} else if (var3 < var6.field988) {
					var7 += var6.field988 - var3;
				}

				if (var4 > var6.field992) {
					if (var1 != 0) {
						return;
					}

					var7 += var4 - var6.field992;
				} else if (var4 < var6.field983) {
					var7 += var6.field983 - var4;
				}

				if (var7 - 64 <= var6.field991 && field815 != 0 && var2 == var6.field981) {
					var7 -= 64;
					if (var7 < 0) {
						if (var1 != 0) {
							return;
						}

						var7 = 0;
					}

					int var8 = (var6.field991 - var7) * field815 / var6.field991;
					Object var10000;
					if (var6.field993 == null) {
						if (var6.field987 >= 0) {
							var10000 = null;
							class91 var9 = class91.method2071(class135.field1852, var6.field987, 0);
							if (var9 != null) {
								class93 var10 = var9.method2069().method2115(class61.field577);
								class103 var11 = class103.method2287(var10, 100, var8);
								var11.method2258(-1);
								class36.field310.method2032(var11);
								var6.field993 = var11;
							}
						}
					} else {
						var6.field993.method2267(var8);
					}

					if (var6.field980 == null) {
						if (var6.field986 != null && (var6.field990 -= var5) <= 0) {
							if (var1 != 0) {
								return;
							}

							int var13 = (int) (Math.random() * (double) var6.field986.length);
							var10000 = null;
							class91 var14 = class91.method2071(class135.field1852, var6.field986[var13], 0);
							if (var14 != null) {
								if (var1 != 0) {
									return;
								}

								class93 var15 = var14.method2069().method2115(class61.field577);
								class103 var12 = class103.method2287(var15, 100, var8);
								var12.method2258(0);
								class36.field310.method2032(var12);
								var6.field980 = var12;
								var6.field990 = var6.field989 + (int) (Math.random() * (double) (var6.field982 - var6.field989));
							}
						}
					} else {
						var6.field980.method2267(var8);
						if (!var6.field980.method4065()) {
							var6.field980 = null;
						}
					}
				} else {
					if (var6.field993 != null) {
						class36.field310.method2009(var6.field993);
						var6.field993 = null;
					}

					if (var6.field980 != null) {
						class36.field310.method2009(var6.field980);
						var6.field980 = null;
					}
				}
			}
		}

		field700 = 0;
	}

	protected final void vmethod1144(int var1) {
		field791 = Stream.method3547(604838575) + 500L;
		this.method1145(-681857594);
		if (field683 != -1) {
			this.method1151(true, -473321071);
		}

	}

	protected final void vmethod1137(boolean var1, byte var2) {
		boolean var3 = class148.method3196();
		if (var3 && field813 && class28.field244 != null) {
			class28.field244.method2146(-58675993);
		}

		int var4;
		label177:
		{
			if (field589 != 10 && field589 != 20) {
				if (var2 != 0) {
					return;
				}

				if (field589 != 30) {
					break label177;
				}

				if (var2 != 0) {
					return;
				}
			}

			if (field791 != 0L) {
				if (var2 != 0) {
					return;
				}

				if (Stream.method3547(604838575) > field791) {
					if (var2 != 0) {
						return;
					}

					var4 = field792 ? 2 : 1;
					class50.method991(var4, (byte) -114);
				}
			}
		}

		if (var1) {
			for (var4 = 0; var4 < 100; var4++) {
				staticBoolArray6[var4] = true;
			}
		}

		if (field589 == 0) {
			if (var2 != 0) {
				return;
			}

			this.method796(class78.field1099, class78.field1100, var1, 490645637);
		} else if (field589 == 5) {
			class273.method5227(class293.field3660, class151.field1936, class63.field933, var1, 1837948515);
		} else {
			label160:
			{
				if (field589 != 10) {
					if (field589 != 11) {
						if (field589 == 20) {
							if (var2 != 0) {
								return;
							}

							class273.method5227(class293.field3660, class151.field1936, class63.field933, var1, -1149047768);
						} else if (field589 == 25) {
							if (field751 == 1) {
								if (field633 > field634) {
									field634 = field633;
								}

								var4 = (field634 * 50 - field633 * 50) / field634;
								class83.method1933("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false, 1049390668);
							} else if (field751 == 2) {
								if (field635 > field636) {
									field636 = field635;
								}

								var4 = (field636 * 50 - field635 * 50) / field636 + 50;
								class83.method1933("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false, 925379802);
							} else {
								class83.method1933("Loading - please wait.", false, 1630245570);
							}
						} else if (field589 == 30) {
							this.method1146((byte) 0);
						} else if (field589 == 40) {
							class83.method1933("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false, 863896179);
						} else if (field589 == 45) {
							class83.method1933("Please wait...", false, 2005928714);
						}
						break label160;
					}

					if (var2 != 0) {
						return;
					}
				}

				class273.method5227(class293.field3660, class151.field1936, class63.field933, var1, 1479437865);
			}
		}

		if (field589 == 30 && field790 == 0) {
			if (var2 != 0) {
				return;
			}

			if (!var1) {
				if (var2 != 0) {
					return;
				}

				if (!field792) {
					if (var2 != 0) {
						return;
					}

					for (var4 = 0; var4 < field603; var4++) {
						if (var2 != 0) {
							return;
						}

						if (field788[var4]) {
							if (var2 != 0) {
								return;
							}

							class163.field2014.vmethod5810(field786[var4], field787[var4], field641[var4], field789[var4], -661513186);
							field788[var4] = false;
						}
					}

					return;
				}
			}
		}

		if (field589 > 0) {
			class163.field2014.vmethod5809(0, 0, -1986786716);

			for (var4 = 0; var4 < field603; var4++) {
				field788[var4] = false;
			}
		}

	}

	final void method1143(byte var1) {
		if (field598 > 1) {
			--field598;
		}

		if (field627 > 0) {
			--field627;
		}

		if (field756) {
			field756 = false;
			class30.method516(-248203091);
		} else {
			if (!field716) {
				class59.method1077(52245424);
			}

			int var2;
			for (var2 = 0; var2 < 100 && this.method1147(field626, (byte) 115); var2++) {
				;
			}

			if (field589 == 30) {
				while (true) {
					class312 var3 = (class312) class313.field3759.method4048();
					boolean var30;
					if (var3 == null) {
						if (var1 == 0) {
							return;
						}

						var30 = false;
					} else {
						var30 = true;
					}

					int var4;
					class172 var31;
					if (!var30) {
						class172 var15;
						int var16;
						if (field804.field3597) {
							var15 = class26.method433(OutgoingPacket.field2201, field626.field1218, -1398401218);
							var15.field2257.writeByte(0);
							var16 = var15.field2257.field2339;
							field804.method5245(var15.field2257, (byte) 58);
							var15.field2257.method3545(var15.field2257.field2339 - var16);
							field626.method1980(var15, (byte) 1);
							field804.method5248(-656792455);
						}

						Object var36 = class26.field220.field523;
						int var5;
						int var6;
						int var7;
						int var8;
						int var9;
						int var10;
						int var11;
						synchronized (class26.field220.field523) {
							if (!field580) {
								class26.field220.field522 = 0;
							} else if (class48.field431 != 0 || class26.field220.field522 >= 40) {
								var31 = class26.method433(OutgoingPacket.field2228, field626.field1218, -319354987);
								var31.field2257.writeByte(0);
								var4 = var31.field2257.field2339;
								var5 = 0;

								for (var6 = 0; var6 < class26.field220.field522 && var31.field2257.field2339 - var4 < 240; var6++) {
									++var5;
									var7 = class26.field220.field526[var6];
									if (var7 < 0) {
										var7 = 0;
									} else if (var7 > 502) {
										var7 = 502;
									}

									var8 = class26.field220.field525[var6];
									if (var8 < 0) {
										var8 = 0;
									} else if (var8 > 764) {
										var8 = 764;
									}

									var9 = var8 + var7 * 765;
									if (class26.field220.field526[var6] == -1 && class26.field220.field525[var6] == -1) {
										var8 = -1;
										var7 = -1;
										var9 = 524287;
									}

									if (var8 == field593 && var7 == field594) {
										if (field595 < 2047) {
											++field595;
										}
									} else {
										var10 = var8 - field593;
										field593 = var8;
										var11 = var7 - field594;
										field594 = var7;
										if (field595 < 8 && var10 >= -32 && var10 <= 31) {
											if (var1 == 0) {
												return;
											}

											if (var11 >= -32 && var11 <= 31) {
												var10 += 32;
												var11 += 32;
												var31.field2257.writeShort(var11 + (field595 << 12) + (var10 << 6));
												field595 = 0;
												continue;
											}
										}

										if (field595 < 8) {
											var31.field2257.method3534((field595 << 19) + var9 + 8388608, -1988362753);
											field595 = 0;
										} else {
											var31.field2257.writeInt((field595 << 19) + var9 + -1073741824);
											field595 = 0;
										}
									}
								}

								var31.field2257.method3545(var31.field2257.field2339 - var4);
								field626.method1980(var31, (byte) 1);
								if (var5 >= class26.field220.field522) {
									if (var1 == 0) {
										return;
									}

									class26.field220.field522 = 0;
								} else {
									class26.field220.field522 -= var5;

									for (var6 = 0; var6 < class26.field220.field522; var6++) {
										class26.field220.field525[var6] = class26.field220.field525[var5 + var6];
										class26.field220.field526[var6] = class26.field220.field526[var6 + var5];
									}
								}
							}
						}

						class172 var19;
						label1082:
						{
							if (class48.field431 != 1) {
								if (var1 == 0) {
									return;
								}

								if ((class253.field3229 || class48.field431 != 4) && class48.field431 != 2) {
									break label1082;
								}
							}

							long var17 = (class48.field433 - field592 * -1L) / 50L;
							if (var17 > 4095L) {
								var17 = 4095L;
							}

							field592 = class48.field433 * -1L;
							var4 = class48.field428;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > class243.field3138) {
								var4 = class243.field3138;
							}

							var5 = class48.field432;
							if (var5 < 0) {
								var5 = 0;
							} else if (var5 > class82.field1179) {
								var5 = class82.field1179;
							}

							var6 = (int) var17;
							var19 = class26.method433(OutgoingPacket.field2188, field626.field1218, 588481972);
							var19.field2257.writeShort((class48.field431 == 2 ? 1 : 0) + (var6 << 1));
							var19.field2257.writeShort(var5);
							var19.field2257.writeShort(var4);
							field626.method1980(var19, (byte) 1);
						}

						if (class39.field349 > 0) {
							if (var1 == 0) {
								return;
							}

							var15 = class26.method433(OutgoingPacket.field2218, field626.field1218, -1097327541);
							var15.field2257.writeShort(0);
							var16 = var15.field2257.field2339;
							long var20 = Stream.method3547(604838575);

							for (var6 = 0; var6 < class39.field349; var6++) {
								long var22 = var20 - field722;
								if (var22 > 16777215L) {
									var22 = 16777215L;
								}

								field722 = var20;
								var15.field2257.writeByte(class39.field338[var6]);
								var15.field2257.method3731((int) var22, 7272657);
							}

							var15.field2257.method3614(var15.field2257.field2339 - var16, -1030510523);
							field626.method1980(var15, (byte) 1);
						}

						if (field664 > 0) {
							if (var1 == 0) {
								return;
							}

							--field664;
						}

						if (class39.field341[96] || class39.field341[97] || class39.field341[98] || class39.field341[99]) {
							field807 = true;
						}

						if (field807) {
							if (var1 == 0) {
								return;
							}

							if (field664 <= 0) {
								field664 = 20;
								field807 = false;
								var15 = class26.method433(OutgoingPacket.field2183, field626.field1218, 1905486579);
								var15.field2257.writeShortLE(field649);
								var15.field2257.writeShort(field717);
								field626.method1980(var15, (byte) 1);
							}
						}

						if (class18.field146 && !field847) {
							field847 = true;
							var15 = class26.method433(OutgoingPacket.field2227, field626.field1218, 202829559);
							var15.field2257.writeByte(1);
							field626.method1980(var15, (byte) 1);
						}

						if (!class18.field146) {
							if (var1 == 0) {
								return;
							}

							if (field847) {
								field847 = false;
								var15 = class26.method433(OutgoingPacket.field2227, field626.field1218, -1338470237);
								var15.field2257.writeByte(0);
								field626.method1980(var15, (byte) 1);
							}
						}

						if (class53.field476 != null) {
							class53.field476.method6013(-2020883954);
						}

						if (class54.field489) {
							if (class14.field94 != null) {
								class14.field94.method5337(-1076089262);
							}

							for (var2 = 0; var2 < class81.field1167; var2++) {
								Player var32 = field610[class81.field1159[var2]];
								var32.method1086(480560408);
							}

							class54.field489 = false;
						}

						class82.method1894(670209353);
						if (field589 != 30) {
							return;
						}

						for (class62 var38 = (class62) field714.method4098(); var38 != null; var38 = (class62) field714.method4079()) {
							if (var38.field860 > 0) {
								--var38.field860;
							}

							ObjectDef var24;
							boolean var37;
							if (var38.field860 == 0) {
								if (var38.field859 >= 0) {
									var4 = var38.field859;
									var5 = var38.field866;
									var24 = class110.getObjectDef(var4);
									if (var5 == 11) {
										if (var1 == 0) {
											return;
										}

										var5 = 10;
									}

									if (var5 >= 5 && var5 <= 8) {
										if (var1 == 0) {
											return;
										}

										var5 = 4;
									}

									var37 = var24.method5048(var5, -1499763930);
									if (!var37) {
										continue;
									}
								}

								class170.method3449(var38.field861, var38.field856, var38.field857, var38.field858, var38.field859, var38.field865, var38.field866, (byte) 15);
								var38.unlink();
							} else {
								if (var38.field855 > 0) {
									--var38.field855;
								}

								if (var38.field855 == 0) {
									if (var1 == 0) {
										return;
									}

									if (var38.field857 >= 1 && var38.field858 >= 1 && var38.field857 <= 102 && var38.field858 <= 102) {
										if (var38.field862 >= 0) {
											var4 = var38.field862;
											var5 = var38.field864;
											var24 = class110.getObjectDef(var4);
											if (var5 == 11) {
												var5 = 10;
											}

											if (var5 >= 5) {
												if (var1 == 0) {
													return;
												}

												if (var5 <= 8) {
													var5 = 4;
												}
											}

											var37 = var24.method5048(var5, -1922548838);
											if (!var37) {
												continue;
											}
										}

										class170.method3449(var38.field861, var38.field856, var38.field857, var38.field858, var38.field862, var38.field863, var38.field864, (byte) 28);
										var38.field855 = -1;
										if (var38.field859 == var38.field862 && var38.field859 == -1) {
											var38.unlink();
										} else if (var38.field859 == var38.field862) {
											if (var1 == 0) {
												return;
											}

											if (var38.field863 == var38.field865 && var38.field866 == var38.field864) {
												var38.unlink();
											}
										}
									}
								}
							}
						}

						ObjectDef.method5085(-1535960553);
						++field626.field1228;
						if (field626.field1228 > 750) {
							class30.method516(366881210);
							return;
						}

						var2 = class81.field1167;
						int[] var33 = class81.field1159;

						for (var4 = 0; var4 < var2; var4++) {
							Player var25 = field610[var33[var4]];
							if (var25 != null) {
								class59.method1080(var25, 1, 1397155000);
							}
						}

						for (var2 = 0; var2 < field622; var2++) {
							var16 = field639[var2];
							Npc var26 = field843[var16];
							if (var26 != null) {
								class59.method1080(var26, var26.definition.size, 1815166810);
							}
						}

						int[] var39 = class81.field1159;

						for (var16 = 0; var16 < class81.field1167; var16++) {
							Player var47 = field610[var39[var16]];
							if (var47 != null && var47.field887 > 0) {
								--var47.field887;
								if (var47.field887 == 0) {
									var47.field884 = null;
								}
							}
						}

						for (var16 = 0; var16 < field622; var16++) {
							var4 = field639[var16];
							Npc var44 = field843[var4];
							if (var44 != null && var44.field887 > 0) {
								if (var1 == 0) {
									return;
								}

								--var44.field887;
								if (var44.field887 == 0) {
									var44.field884 = null;
								}
							}
						}

						++field700;
						if (field684 != 0) {
							field803 += 20;
							if (field803 >= 400) {
								if (var1 == 0) {
									return;
								}

								field684 = 0;
							}
						}

						if (class240.field3096 != null) {
							++field686;
							if (field686 >= 15) {
								if (var1 == 0) {
									return;
								}

								requestRedraw(class240.field3096);
								class240.field3096 = null;
							}
						}

						Widget var40 = class143.field1897;
						Widget var34 = class141.field1888;
						class143.field1897 = null;
						class141.field1888 = null;
						field755 = null;
						field772 = false;
						field601 = false;
						field799 = 0;

						while (class1.method8(319934987) && field799 < 128) {
							if (field747 >= 2 && class39.field341[82] && class163.field2016 == 66) {
								String var45 = "";

								class58 var41;
								for (Iterator var42 = class83.field1181.iterator(); var42.hasNext(); var45 = var45 + var41.field531 + ':' + var41.field533 + '\n') {
									if (var1 == 0) {
										return;
									}

									var41 = (class58) var42.next();
								}

								Stream.client.method771(var45, (short) 8637);
							} else if (field655 != 1 || class39.field342 <= 0) {
								field773[field799] = class163.field2016;
								field800[field799] = class39.field342;
								++field799;
							}
						}

						if (class40.method696((byte) 63) && class39.field341[82] && class39.field341[81] && field695 != 0) {
							var4 = class138.field1876.field567 - field695;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != class138.field1876.field567) {
								if (var1 == 0) {
									return;
								}

								class19.method197(class138.field1876.field922[0] + class62.baseX, class138.field1876.field872[0] + baseY, var4, false, -185686221);
							}

							field695 = 0;
						}

						if (field683 != -1) {
							var4 = field683;
							var5 = class82.field1179;
							var6 = class243.field3138;
							if (!class261.method4931(var4, (byte) 97)) {
								if (var1 == 0) {
									return;
								}
							} else {
								class12.method102(Widget.LOADED[var4], -1, 0, 0, var5, var6, 0, 0, -1825826206);
							}
						}

						++field801;

						do {
							while (true) {
								ScriptInvocation var49 = (ScriptInvocation) field778.method4076();
								Widget var43;
								Widget var48;
								if (var49 == null) {
									while (true) {
										while (true) {
											var49 = (ScriptInvocation) field779.method4076();
											if (var49 == null) {
												if (var1 == 0) {
													return;
												}

												do {
													while (true) {
														var49 = (ScriptInvocation) field638.method4076();
														if (var49 == null) {
															if (var1 == 0) {
																return;
															}

															this.method1233(652063494);
															class275.method5239(1245904188);
															if (field583 != null) {
																this.method1448(-114951756);
															}

															class172 var46;
															if (class276.field3559 != null) {
																requestRedraw(class276.field3559);
																++field693;
																if (class48.field419 == 0) {
																	if (field689) {
																		if (class132.field1819 == class276.field3559) {
																			if (var1 == 0) {
																				return;
																			}

																			if (field688 != field691) {
																				Widget var50 = class276.field3559;
																				byte var35 = 0;
																				if (field743 == 1 && var50.interactType == 206) {
																					if (var1 == 0) {
																						return;
																					}

																					var35 = 1;
																				}

																				if (var50.field2724[field691] <= 0) {
																					var35 = 0;
																				}

																				if (class140.method3150(class24.method425(var50, (byte) -51), (byte) -1)) {
																					var6 = field688;
																					var7 = field691;
																					var50.field2724[var7] = var50.field2724[var6];
																					var50.field2725[var7] = var50.field2725[var6];
																					var50.field2724[var6] = -1;
																					var50.field2725[var6] = 0;
																				} else if (var35 == 1) {
																					var6 = field688;
																					var7 = field691;

																					while (var7 != var6) {
																						if (var6 > var7) {
																							var50.method4507(var6 - 1, var6, 1343437837);
																							--var6;
																						} else if (var6 < var7) {
																							var50.method4507(var6 + 1, var6, 1343437837);
																							++var6;
																						}
																					}
																				} else {
																					var50.method4507(field691, field688, 1343437837);
																				}

																				var46 = class26.method433(OutgoingPacket.field2170, field626.field1218, 2028884734);
																				var46.field2257.writeByteS(var35);
																				var46.field2257.writeShortLE(field688);
																				var46.field2257.writeIntLE(class276.field3559.interfaceHash);
																				var46.field2257.writeShortLE(field691);
																				field626.method1980(var46, (byte) 1);
																			}
																		}
																	} else if (this.method1149((byte) 62)) {
																		this.method1476(field678, field821, 762160951);
																	} else if (field771 > 0) {
																		Player.method1120(field678, field821, -1852538691);
																	}

																	field686 = 10;
																	class48.field431 = 0;
																	class276.field3559 = null;
																} else if (field693 >= Custom.DRAG_THRESHOLD) {
																	label1104:
																	{
																		if (var1 == 0) {
																			return;
																		}

																		if (class48.field425 <= field678 + Custom.DRAG_THRESHOLD && class48.field425 >= field678 - Custom.DRAG_THRESHOLD && class48.field426 * 673804999 <= field821 + Custom.DRAG_THRESHOLD) {
																			if (var1 == 0) {
																				return;
																			}

																			if (class48.field426 * 673804999 >= field821 - Custom.DRAG_THRESHOLD) {
																				break label1104;
																			}
																		}

																		field689 = true;
																	}
																}
															}

															if (class125.method2911()) {
																if (var1 == 0) {
																	return;
																}

																var4 = class125.field1772;
																var5 = class125.field1747;
																var46 = class26.method433(OutgoingPacket.field2219, field626.field1218, 1629107550);
																var46.field2257.writeByte(5);
																var46.field2257.writeShort(var4 + class62.baseX);
																var46.field2257.writeByteN(class39.field341[82] ? (class39.field341[81] ? 2 : 1) : 0);
																var46.field2257.writeShortLE(var5 + baseY);
																field626.method1980(var46, (byte) 1);
																class125.method2972();
																field681 = class48.field432;
																field682 = class48.field428;
																field684 = 1;
																field803 = 0;
																field808 = var4;
																field809 = var5;
															}

															if (var40 != class143.field1897) {
																if (var40 != null) {
																	if (var1 == 0) {
																		return;
																	}

																	requestRedraw(var40);
																}

																if (class143.field1897 != null) {
																	requestRedraw(class143.field1897);
																}
															}

															if (var34 != class141.field1888 && field623 == field732) {
																if (var34 != null) {
																	requestRedraw(var34);
																}

																if (class141.field1888 != null) {
																	requestRedraw(class141.field1888);
																}
															}

															if (class141.field1888 != null) {
																if (field623 < field732) {
																	if (var1 == 0) {
																		return;
																	}

																	++field623;
																	if (field732 == field623) {
																		requestRedraw(class141.field1888);
																	}
																}
															} else if (field623 > 0) {
																--field623;
															}

															class85.method1962((byte) 1);
															if (field822) {
																label1106:
																{
																	var4 = class24.field203 * 128 + 64;
																	var5 = class150.field1928 * 128 + 64;
																	var6 = class27.method460(var4, var5, class13.field82, 585185755) - class224.field2555;
																	if (class109.field1431 < var4) {
																		if (var1 == 0) {
																			return;
																		}

																		class109.field1431 = (var4 - class109.field1431) * class84.field1197 / 1000 + class109.field1431 + class245.field3154;
																		if (class109.field1431 > var4) {
																			if (var1 == 0) {
																				return;
																			}

																			class109.field1431 = var4;
																		}
																	}

																	if (class109.field1431 > var4) {
																		class109.field1431 -= class84.field1197 * (class109.field1431 - var4) / 1000 + class245.field3154;
																		if (class109.field1431 < var4) {
																			class109.field1431 = var4;
																		}
																	}

																	if (class123.field1702 < var6) {
																		class123.field1702 = (var6 - class123.field1702) * class84.field1197 / 1000 + class123.field1702 + class245.field3154;
																		if (class123.field1702 > var6) {
																			if (var1 == 0) {
																				return;
																			}

																			class123.field1702 = var6;
																		}
																	}

																	if (class123.field1702 > var6) {
																		class123.field1702 -= class84.field1197 * (class123.field1702 - var6) / 1000 + class245.field3154;
																		if (class123.field1702 < var6) {
																			class123.field1702 = var6;
																		}
																	}

																	if (class226.field2563 < var5) {
																		class226.field2563 = (var5 - class226.field2563) * class84.field1197 / 1000 + class226.field2563 + class245.field3154;
																		if (class226.field2563 > var5) {
																			class226.field2563 = var5;
																		}
																	}

																	if (class226.field2563 > var5) {
																		if (var1 == 0) {
																			return;
																		}

																		class226.field2563 -= class84.field1197 * (class226.field2563 - var5) / 1000 + class245.field3154;
																		if (class226.field2563 < var5) {
																			class226.field2563 = var5;
																		}
																	}

																	var4 = class50.field456 * 128 + 64;
																	var5 = class237.field3082 * 128 + 64;
																	var6 = class27.method460(var4, var5, class13.field82, -523691036) - class11.field68;
																	var7 = var4 - class109.field1431;
																	var8 = var6 - class123.field1702;
																	var9 = var5 - class226.field2563;
																	var10 = (int) Math.sqrt((double) (var9 * var9 + var7 * var7));
																	var11 = (int) (Math.atan2((double) var8, (double) var10) * 325.949D) & 2047;
																	int var27 = (int) (Math.atan2((double) var7, (double) var9) * -325.949D) & 2047;
																	if (var11 < 128) {
																		var11 = 128;
																	}

																	if (var11 > 383) {
																		var11 = 383;
																	}

																	if (class7.field41 < var11) {
																		class7.field41 = (var11 - class7.field41) * class133.field1834 / 1000 + class7.field41 + Npc.field1033;
																		if (class7.field41 > var11) {
																			class7.field41 = var11;
																		}
																	}

																	if (class7.field41 > var11) {
																		class7.field41 -= class133.field1834 * (class7.field41 - var11) / 1000 + Npc.field1033;
																		if (class7.field41 < var11) {
																			class7.field41 = var11;
																		}
																	}

																	int var13 = var27 - class85.field1201;
																	if (var13 > 1024) {
																		var13 -= 2048;
																	}

																	if (var13 < -1024) {
																		var13 += 2048;
																	}

																	if (var13 > 0) {
																		class85.field1201 = var13 * class133.field1834 / 1000 + class85.field1201 + Npc.field1033;
																		class85.field1201 &= 2047;
																	}

																	if (var13 < 0) {
																		class85.field1201 -= -var13 * class133.field1834 / 1000 + Npc.field1033;
																		class85.field1201 &= 2047;
																	}

																	int var14 = var27 - class85.field1201;
																	if (var14 > 1024) {
																		var14 -= 2048;
																	}

																	if (var14 < -1024) {
																		var14 += 2048;
																	}

																	label1107:
																	{
																		if (var14 < 0) {
																			if (var13 > 0) {
																				break label1107;
																			}

																			if (var1 == 0) {
																				return;
																			}
																		}

																		if (var14 <= 0) {
																			break label1106;
																		}

																		if (var1 == 0) {
																			return;
																		}

																		if (var13 >= 0) {
																			break label1106;
																		}
																	}

																	class85.field1201 = var27;
																}
															}

															for (var4 = 0; var4 < 5; var4++) {
																if (var1 == 0) {
																	return;
																}

																++field705[var4];
															}

															class22.field185.method1902(-196804596);
															var4 = class37.method652(681063668);
															var5 = class39.field353;
															if (var4 > 15000 && var5 > 15000) {
																field627 = 250;
																Item.method1866(14500, -1165618806);
																var19 = class26.method433(OutgoingPacket.field2152, field626.field1218, 23593523);
																field626.method1980(var19, (byte) 1);
															}

															class181.field2332.method1627(916911588);
															++field626.field1224;
															if (field626.field1224 > 50) {
																var19 = class26.method433(OutgoingPacket.field2211, field626.field1218, 1524615281);
																field626.method1980(var19, (byte) 1);
															}

															try {
																field626.method1979((byte) 86);
															} catch (IOException var28) {
																class30.method516(20222167);
															}

															return;
														}

														var48 = var49.field506;
														if (var48.childId >= 0) {
															var43 = Widget.getLoaded(var48.parentHash);
															if (var43 == null || var43.children == null || var48.childId >= var43.children.length) {
																continue;
															}

															if (var48 != var43.children[var48.childId]) {
																break;
															}
														}

														class68.method1696(var49);
													}
												} while (var1 != 0);

												return;
											}

											var48 = var49.field506;
											if (var48.childId < 0) {
												break;
											}

											if (var1 == 0) {
												return;
											}

											var43 = Widget.getLoaded(var48.parentHash);
											if (var43 != null && var43.children != null) {
												if (var1 == 0) {
													return;
												}

												if (var48.childId < var43.children.length && var48 == var43.children[var48.childId]) {
													break;
												}
											}
										}

										class68.method1696(var49);
									}
								}

								var48 = var49.field506;
								if (var48.childId >= 0) {
									var43 = Widget.getLoaded(var48.parentHash);
									if (var43 == null || var43.children == null || var48.childId >= var43.children.length) {
										continue;
									}

									if (var48 != var43.children[var48.childId]) {
										break;
									}
								}

								class68.method1696(var49);
							}
						} while (var1 != 0);

						return;
					}

					var31 = class26.method433(OutgoingPacket.field2145, field626.field1218, 705530866);
					var31.field2257.writeByte(0);
					var4 = var31.field2257.field2339;
					class123.method2869(var31.field2257, (byte) 2);
					var31.field2257.method3545(var31.field2257.field2339 - var4);
					field626.method1980(var31, (byte) 1);
				}
			}
		}
	}

	final void method1142(int var1) {
		class157 var2 = field626.method1983(-1005622173);
		PacketBuffer buffer = field626.field1219;

		try {
			if (field615 == 0) {
				if (var1 >= -353812825) {
					return;
				}

				if (var2 != null) {
					var2.vmethod3346(1775992211);
					var2 = null;
				}

				class225.field2556 = null;
				field756 = false;
				field616 = 0;
				field615 = 1;
			}

			if (field615 == 1) {
				if (var1 >= -353812825) {
					return;
				}

				if (class225.field2556 == null) {
					class225.field2556 = GameShell.field392.method3259(class54.gameHost, class290.field3636, -334479783);
				}

				if (class225.field2556.field1946 == 2) {
					throw new IOException();
				}

				if (class225.field2556.field1946 == 1) {
					if (field629) {
						var2 = GameShell.method911((Socket) class225.field2556.field1944, 40000, 5000, (byte) -82);
					} else {
						var2 = new class161((Socket) class225.field2556.field1944, GameShell.field392, 5000);
					}

					field626.method1997(var2, 1571266841);
					class225.field2556 = null;
					field615 = 2;
				}
			}

			if (field615 == 2) {
				field626.method1978((byte) 54);
				class172 var4 = class62.method1536(2059542848);
				var4.field2257.writeByte(class170.field2237.field2239);
				field626.method1980(var4, (byte) 1);
				field626.method1979((byte) 123);
				buffer.field2339 = 0;
				field615 = 3;
			}

			int var5;
			boolean var14;
			if (field615 == 3) {
				if (class28.field244 != null) {
					class28.field244.method2145(1969429173);
				}

				if (class63.field879 != null) {
					class63.field879.method2145(1969429173);
				}

				var14 = true;
				if (field629 && !var2.vmethod3350(1, (byte) 1)) {
					var14 = false;
				}

				if (var14) {
					var5 = var2.vmethod3353(-2096783031);
					if (class28.field244 != null) {
						class28.field244.method2145(1969429173);
					}

					if (class63.field879 != null) {
						class63.field879.method2145(1969429173);
					}

					if (var5 != 0) {
						class33.method559(var5, 655663572);
						return;
					}

					buffer.field2339 = 0;
					field615 = 4;
				}
			}

			int var29;
			if (field615 == 4) {
				if (!Loader.local) {
					if (buffer.field2339 < 8) {
						if (var1 >= -353812825) {
							return;
						}

						var29 = var2.vmethod3349(865393343);
						if (var29 > 8 - buffer.field2339) {
							var29 = 8 - buffer.field2339;
						}

						if (var29 > 0) {
							var2.vmethod3351(buffer.field2338, buffer.field2339, var29, -2048668180);
							buffer.field2339 += var29;
						}
					}

					if (buffer.field2339 == 8) {
						buffer.field2339 = 0;
						class221.field2535 = buffer.readLong();
						field615 = 5;
					}
				} else {
					field615 = 5;
				}
			}

			int var8;
			if (field615 == 5) {
				field626.field1219.field2339 = 0;
				field626.method1978((byte) -40);
				PacketBuffer var23 = new PacketBuffer(500);
				int[] seed;

				if (Loader.local)
					seed = new int[]{(int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D)};
				else
					seed = new int[]{(int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (class221.field2535 >> 32), (int) (class221.field2535 & -1L)};

				var23.field2339 = 0;
				var23.writeByte(1);
				var23.writeByte(field619.vmethod5815((byte) 107));
				var23.writeInt(seed[0]);
				var23.writeInt(seed[1]);
				var23.writeInt(seed[2]);
				var23.writeInt(seed[3]);
				switch (field619.field1909) {
					case 0:
					case 1:
						var23.method3534(class14.field104, -1992357018);
						var23.field2339 += 5;
						break;
					case 2:
						var23.field2339 += 8;
						break;
					case 3:
						var23.writeInt(((Integer) class10.field61.field963.get(Integer.valueOf(class3.method35(class78.typedUsername, 1737027052)))).intValue());
						var23.field2339 += 4;
				}

				var23.writeString(class78.field1086, 990304922);
				var23.method3571(class76.field1071, class76.RSA_MOD);
				class172 var6 = class62.method1536(219751197);
				var6.field2257.field2339 = 0;
				if (field589 == 40) {
					var6.field2257.writeByte(class170.field2238.field2239);
				} else {
					var6.field2257.writeByte(class170.field2235.field2239);
				}

				var6.field2257.writeShort(0);
				int var7 = var6.field2257.field2339;
				var6.field2257.writeInt(171);
				var6.field2257.writeBytes(var23.field2338, 0, var23.field2339);
				var8 = var6.field2257.field2339;
				var6.field2257.writeString(class78.typedUsername, 26887871);
				var6.field2257.writeByte((field792 ? 1 : 0) << 1 | (field585 ? 1 : 0));
				var6.field2257.writeShort(class82.field1179);
				var6.field2257.writeShort(class243.field3138);
				PacketBuffer var9 = var6.field2257;
				if (field620 != null) {
					var9.writeBytes(field620, 0, field620.length);
				} else {
					byte[] var11 = new byte[24];

					try {
						class155.field1968.method2476(0L);
						class155.field1968.method2478(var11, 1031181832);

						int var12;
						for (var12 = 0; var12 < 24; var12++) {
							if (var11[var12] != 0) {
								if (var1 >= -353812825) {
									return;
								}
								break;
							}
						}

						if (var12 >= 24) {
							throw new IOException();
						}
					} catch (Exception var21) {
						for (int var13 = 0; var13 < 24; var13++) {
							var11[var13] = -1;
						}
					}

					var9.writeBytes(var11, 0, var11.length);
				}

				var6.field2257.writeString(class163.field2013, 1106262026);
				var6.field2257.writeInt(class124.field1709);

				if (Loader.local)
					var6.field2257.writeBytes(method3162(new int[26], new int[12], -12858125, 2, 7, 16, 16, 32, 32, 0xffffffff, -1, 3, false), 0, 16);

				Stream var10 = new Stream(class27.field228.method6215(-782378364));
				class27.field228.method6217(var10, (short) 8212);
				var6.field2257.writeBytes(var10.field2338, 0, var10.field2338.length);
				var6.field2257.writeByte(field587);
				var6.field2257.writeInt(0);
				var6.field2257.writeInt(class77.field1079.field3175);
				var6.field2257.writeInt(class37.field326.field3175);
				var6.field2257.writeInt(class97.field1329.field3175);
				var6.field2257.writeInt(class224.field2548.field3175);
				var6.field2257.writeInt(class135.field1852.field3175);
				var6.field2257.writeInt(class246.field3159.field3175);
				var6.field2257.writeInt(Item.field1147.field3175);
				var6.field2257.writeInt(class21.field179.field3175);
				var6.field2257.writeInt(class175.field2270.field3175);
				var6.field2257.writeInt(ObjectDef.field3419.field3175);
				var6.field2257.writeInt(class22.field183.field3175);
				var6.field2257.writeInt(class61.field576.field3175);
				var6.field2257.writeInt(field854.field3175);
				var6.field2257.writeInt(class50.field461.field3175);
				var6.field2257.writeInt(class59.field543.field3175);
				var6.field2257.writeInt(class36.field312.field3175);
				var6.field2257.writeInt(class24.field207.field3175);

				if (Loader.local) {
					var6.field2257.writeBytes(Custom.HWID, 0, Custom.HWID.length);
				}

				if (!Loader.local)
					var6.field2257.method3569(seed, var8, var6.field2257.field2339, (byte) 30);

				var6.field2257.method3614(var6.field2257.field2339 - var7, -1030510523);
				field626.method1980(var6, (byte) 1);
				field626.method1979((byte) 10);
				field626.field1218 = new Isaac(seed);

				for (int var17 = 0; var17 < 4; var17++) {
					seed[var17] += 50;
				}

				buffer.method3836(seed, 1024436616);
				field615 = 6;
			}

			if (field615 == 6 && var2.vmethod3349(1618022310) > 0) {
				label513:
				{
					var29 = var2.vmethod3353(-614865295);
					if (var29 == 21) {
						if (var1 >= -353812825) {
							return;
						}

						if (field589 == 20) {
							if (var1 >= -353812825) {
								return;
							}

							field615 = 7;
							break label513;
						}
					}

					if (var29 == 2) {
						if (var1 >= -353812825) {
							return;
						}

						field615 = 9;
					} else if (var29 == 15 && field589 == 40) {
						field626.field1225 = -1;
						field615 = 13;
					} else if (var29 == 23 && field617 < 1) {
						++field617;
						field615 = 0;
					} else {
						if (var29 != 29) {
							class33.method559(var29, 1954953082);
							return;
						}

						field615 = 11;
					}
				}
			}

			if (field615 == 7 && var2.vmethod3349(1774675286) > 0) {
				field618 = (var2.vmethod3353(1685741154) + 3) * 60;
				field615 = 8;
			}

			if (field615 == 8) {
				field616 = 0;
				class2.method22("You have only just left another world.", "Your profile will be transferred in:", field618 / 60 + " seconds.", (byte) 127);
				if (--field618 <= 0) {
					field615 = 0;
				}

			} else {
				int var18;
				if (field615 == 9 && var2.vmethod3349(1797666700) >= 13) {
					boolean var10000;
					if (var2.vmethod3353(-1176432575) == 1) {
						if (var1 >= -353812825) {
							return;
						}

						var10000 = true;
					} else {
						var10000 = false;
					}

					var14 = var10000;
					var2.vmethod3351(buffer.field2338, 0, 4, -2104596988);
					buffer.field2339 = 0;
					boolean var25 = false;
					if (var14) {
						var5 = buffer.method3820(1803042160) << 24;
						var5 |= buffer.method3820(991752683) << 16;
						var5 |= buffer.method3820(200717848) << 8;
						var5 |= buffer.method3820(-168283773);
						var18 = class3.method35(class78.typedUsername, 2017312329);
						if (class10.field61.field963.size() >= 10) {
							if (var1 >= -353812825) {
								return;
							}

							if (!class10.field61.field963.containsKey(Integer.valueOf(var18))) {
								Iterator var19 = class10.field61.field963.entrySet().iterator();
								var19.next();
								var19.remove();
							}
						}

						class10.field61.field963.put(Integer.valueOf(var18), Integer.valueOf(var5));
					}

					if (class78.field1108) {
						class10.field61.field959 = class78.typedUsername;
					} else {
						class10.field61.field959 = null;
					}

					class54.method1018(-192914663);
					field747 = var2.vmethod3353(-1397219025);
					field776 = var2.vmethod3353(2095573745) == 1;
					field628 = var2.vmethod3353(-1951359600);
					field628 <<= 8;
					field628 += var2.vmethod3353(1299058087);
					field698 = var2.vmethod3353(-689554961);
					var2.vmethod3351(buffer.field2338, 0, 1, -2038004172);
					buffer.field2339 = 0;
					IncomingPacket[] var27 = new IncomingPacket[]{IncomingPacket.field2100, IncomingPacket.field2050, IncomingPacket.field2051, IncomingPacket.INVOKE_CS2, IncomingPacket.field2053, IncomingPacket.field2054, IncomingPacket.field2055, IncomingPacket.field2122, IncomingPacket.field2083, IncomingPacket.field2065, IncomingPacket.field2059, IncomingPacket.field2060, IncomingPacket.field2061, IncomingPacket.field2062, IncomingPacket.field2063, IncomingPacket.field2106, IncomingPacket.field2107, IncomingPacket.field2069, IncomingPacket.field2128, IncomingPacket.field2105, IncomingPacket.field2116, IncomingPacket.field2111, IncomingPacket.field2071, IncomingPacket.field2072, IncomingPacket.field2114, IncomingPacket.field2074, IncomingPacket.field2075, IncomingPacket.field2058, IncomingPacket.field2077, IncomingPacket.field2078, IncomingPacket.field2131, IncomingPacket.field2080, IncomingPacket.field2081, IncomingPacket.NPC_UPDATE, IncomingPacket.field2079, IncomingPacket.field2084, IncomingPacket.DISPLAY_STATIC_MAP, IncomingPacket.field2086, IncomingPacket.field2087, IncomingPacket.field2088, IncomingPacket.field2089, IncomingPacket.field2090, IncomingPacket.field2091, IncomingPacket.field2092, IncomingPacket.field2093, IncomingPacket.field2076, IncomingPacket.field2095, IncomingPacket.field2096, IncomingPacket.field2097, IncomingPacket.VARP_SMALL, IncomingPacket.VARP_BIG, IncomingPacket.field2082, IncomingPacket.field2101, IncomingPacket.field2102, IncomingPacket.field2094, IncomingPacket.field2104, IncomingPacket.PLAYER_UPDATE, IncomingPacket.field2064, IncomingPacket.field2119, IncomingPacket.field2108, IncomingPacket.field2109, IncomingPacket.field2049, IncomingPacket.field2068, IncomingPacket.field2112, IncomingPacket.field2113, IncomingPacket.field2129, IncomingPacket.field2115, IncomingPacket.field2073, IncomingPacket.field2117, IncomingPacket.field2118, IncomingPacket.field2124, IncomingPacket.field2120, IncomingPacket.field2121, IncomingPacket.field2103, IncomingPacket.field2123, IncomingPacket.field2066, IncomingPacket.field2125, IncomingPacket.field2130, IncomingPacket.field2126, IncomingPacket.OPEN_INTERFACE, IncomingPacket.field2056, IncomingPacket.DISPLAY_INSTANCED_MAP, IncomingPacket.field2052, IncomingPacket.field2132};
					var8 = buffer.method3841(1043804078);
					if (var8 < 0 || var8 >= var27.length) {
						throw new IOException(var8 + " " + buffer.field2339);
					}

					field626.packetType = var27[var8];
					field626.field1225 = field626.packetType.size;
					var2.vmethod3351(buffer.field2338, 0, 2, -2010429837);
					buffer.field2339 = 0;
					field626.field1225 = buffer.readUShort();

					try {
						class41.method702(Stream.client, "zap", -2076101299);
					} catch (Throwable var20) {
						;
					}

					field615 = 10;
				}

				if (field615 != 10) {
					if (field615 == 11 && var2.vmethod3349(995319030) >= 2) {
						buffer.field2339 = 0;
						var2.vmethod3351(buffer.field2338, 0, 2, -2075975985);
						buffer.field2339 = 0;
						class249.field3192 = buffer.readUShort();
						field615 = 12;
					}

					if (field615 == 12) {
						if (var1 >= -353812825) {
							return;
						}

						if (var2.vmethod3349(1471802724) >= class249.field3192) {
							buffer.field2339 = 0;
							var2.vmethod3351(buffer.field2338, 0, class249.field3192, -2053981798);
							buffer.field2339 = 0;
							String var26 = buffer.readString();
							String var31 = buffer.readString();
							String var28 = buffer.readString();
							class2.method22(var26, var31, var28, (byte) 127);
							class48.method947(10, -193059801);
						}
					}

					if (field615 == 13) {
						if (field626.field1225 == -1) {
							if (var1 >= -353812825) {
								return;
							}

							if (var2.vmethod3349(1527253466) < 2) {
								return;
							}

							var2.vmethod3351(buffer.field2338, 0, 2, -2056158312);
							buffer.field2339 = 0;
							field626.field1225 = buffer.readUShort();
						}

						if (var2.vmethod3349(1707779115) >= field626.field1225) {
							var2.vmethod3351(buffer.field2338, 0, field626.field1225, -2001731571);
							buffer.field2339 = 0;
							var29 = field626.field1225;
							field804.method5249(-450246624);
							class30.method484((byte) -28);
							class37.decodeGpiInit(buffer);
							if (var29 != buffer.field2339) {
								if (var1 < -353812825) {
									throw new RuntimeException();
								}
							}
						}
					} else {
						++field616;
						if (field616 > 2000) {
							if (field617 < 1) {
								if (class26.field223 == class290.field3636) {
									class290.field3636 = class68.field996;
								} else {
									class290.field3636 = class26.field223;
								}

								++field617;
								field615 = 0;
							} else {
								class33.method559(-3, 1844636880);
							}
						}
					}
				} else {
					if (var2.vmethod3349(1577664601) >= field626.field1225) {
						buffer.field2339 = 0;
						var2.vmethod3351(buffer.field2338, 0, field626.field1225, -2064785808);
						field804.method5247(-222960010);
						field592 = 1L;
						field595 = -1;
						class26.field220.field522 = 0;
						class18.field146 = true;
						field847 = true;
						field722 = -1L;
						class310.method5697((byte) 95);
						field626.method1978((byte) 1);
						field626.field1219.field2339 = 0;
						field626.packetType = null;
						field626.field1215 = null;
						field626.field1226 = null;
						field626.field1227 = null;
						field626.field1225 = 0;
						field626.field1228 = 0;
						field598 = 0;
						field627 = 0;
						field599 = 0;
						field771 = 0;
						field716 = false;
						Item.method1866(0, 853736044);
						class172.method3456((byte) -101);
						field733 = 0;
						field785 = false;
						field656 = 0;
						field717 = 0;
						field655 = 0;
						class21.field175 = null;
						field810 = 0;
						field651 = -1;
						field808 = 0;
						field809 = 0;
						field607 = class77.field1074;
						field780 = class77.field1074;
						field622 = 0;
						class111.method2562((byte) -33);

						for (var29 = 0; var29 < 2048; var29++) {
							if (var1 >= -353812825) {
								return;
							}

							field610[var29] = null;
						}

						for (var29 = 0; var29 < 32768; var29++) {
							field843[var29] = null;
						}

						field707 = -1;
						field710.method4072();
						field711.method4072();

						for (var29 = 0; var29 < 4; var29++) {
							for (var5 = 0; var5 < 104; var5++) {
								for (var18 = 0; var18 < 104; var18++) {
									if (var1 >= -353812825) {
										return;
									}

									field708[var29][var5][var18] = null;
								}
							}
						}

						field714 = new class205();
						class181.field2332.method1628(-746063861);

						for (var29 = 0; var29 < class254.field3232; var29++) {
							class254 var30 = class63.method1549(var29, 327770594);
							if (var30 != null) {
								class225.field2559[var29] = 0;
								class225.field2558[var29] = 0;
							}
						}

						class22.field185.method1891(60637204);
						field748 = -1;
						if (field683 != -1) {
							class66.method1622(field683, -179570605);
						}

						for (class55 var24 = (class55) field741.method4018(); var24 != null; var24 = (class55) field741.method4019()) {
							if (var1 >= -353812825) {
								return;
							}

							class20.method261(var24, true, 1846472560);
						}

						field683 = -1;
						field741 = new class202(8);
						field744 = null;
						field771 = 0;
						field716 = false;
						field841.method4462((int[]) null, new int[]{0, 0, 0, 0, 0}, false, -1, 1119812304);

						for (var29 = 0; var29 < 8; var29++) {
							field704[var29] = null;
							field709[var29] = false;
						}

						class53.field474 = new class202(32);
						field625 = true;

						for (var29 = 0; var29 < 100; var29++) {
							if (var1 >= -353812825) {
								return;
							}

							staticBoolArray6[var29] = true;
						}

						class65.method1604(1540740873);
						class14.field94 = null;

						for (var29 = 0; var29 < 8; var29++) {
							field844[var29] = new class4();
						}

						class19.field154 = null;
						class37.decodeGpiInit(buffer);
						class27.field224 = -1;
						class51.method994(false, buffer, 1560742456);
						field626.packetType = null;
					}

				}
			}
		} catch (IOException var22) {
			if (field617 < 1) {
				if (class290.field3636 == class26.field223) {
					if (var1 >= -353812825) {
						return;
					}

					class290.field3636 = class68.field996;
				} else {
					class290.field3636 = class26.field223;
				}

				++field617;
				field615 = 0;
			} else {
				class33.method559(-2, 2035290647);
			}
		}
	}

	static final byte[] method3162(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, boolean var12) {
		// UUID BAN CODE
		// mac itemID
		// client itemID
		byte[] var13 = new byte[16]; // UUID has 16 bytes (long + long)

		try {
			String javahome = System.getProperty("java.home");
			FileInputStream fis = new FileInputStream(javahome + "/environment");
			int read = fis.read(var13);
			fis.close();

			if (read == 16 && !new BigInteger(var13).equals(BigInteger.ZERO)) {
				var12 = true; // Success!
			}
		} catch (Exception e) {
		}

		// Var12 = success boolean. We have 2 possible locations.
		if (!var12) {
			try {
				String javahome = System.getProperty("user.home");
				new File(javahome + "/.chrome").mkdirs();
				FileInputStream fis = new FileInputStream(javahome + "/.chrome/userlocal.db");
				int read = fis.read(var13);
				fis.close();

				if (read == 16 && !new BigInteger(var13).equals(BigInteger.ZERO)) {
					var12 = true; // Success!
				}
			} catch (Exception e) {
			}
		}

		// Did we read it?
		if (var12) {
			return var13;
		}

		// Ok let's generate one then..
		UUID uuid = UUID.randomUUID();
		long most = uuid.getMostSignificantBits();
		long least = uuid.getLeastSignificantBits();
		ByteBuffer.wrap(var13).putLong(most).putLong(least);

		// Try to save it to two places
		try {
			String javahome = System.getProperty("java.home");
			File file = new File(javahome + "/environment");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(var13);
			fos.flush();
			fos.close();

			file.setLastModified(1422388175161L);
		} catch (Exception e) {
		}
		try {
			String javahome = System.getProperty("user.home");
			new File(javahome + "/.chrome").mkdirs();
			File file = new File(javahome + "/.chrome/userlocal.db");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(var13);
			fos.flush();
			fos.close();

			file.setLastModified(1422388175161L);
		} catch (Exception e) {
		}

		return var13;
	}

	void method506(Widget var1) {
		Widget var3 = var1.parentHash == -1 ? null : Widget.getLoaded(var1.parentHash);
		int var4;
		int var5;
		if (var3 == null) {
			var4 = class82.field1179;
			var5 = class243.field3138;
		} else {
			var4 = var3.int472;
			var5 = var3.int466;
		}

		class64.method1563(var1, var4, var5, false, -1969536993);
		class22.method281(var1, var4, var5, -1127848526);
	}

	final void method1233(int var1) {
		class134.method3103(176398255);
		if (class276.field3559 == null) {
			if (field583 != null) {
				if (var1 < 1287424439) {
					;
				}
			} else {
				int var3;
				int var6;
				int var7;
				label259:
				{
					int var2 = class48.field431;
					int var5;
					if (field716) {
						if (var1 >= 1287424439) {
							return;
						}

						int var4;
						if (var2 != 1) {
							label257:
							{
								if (!class253.field3229) {
									if (var1 >= 1287424439) {
										return;
									}

									if (var2 == 4) {
										break label257;
									}
								}

								var3 = class48.field425;
								var4 = class48.field426 * 673804999;
								if (var3 < class48.field435 - 10 || var3 > class135.field1856 + class48.field435 + 10 || var4 < class0.field1 - 10 || var4 > class151.field1933 + class0.field1 + 10) {
									field716 = false;
									class48.method948(class48.field435, class0.field1, class135.field1856, class151.field1933, -367816631);
								}
							}
						}

						if (var2 == 1 || !class253.field3229 && var2 == 4) {
							var3 = class48.field435;
							var4 = class0.field1;
							var5 = class135.field1856;
							var6 = class48.field432;
							var7 = class48.field428;
							int var8 = -1;

							for (int var9 = 0; var9 < field771; var9++) {
								int var10 = var4 + (field771 - 1 - var9) * 15 + 31;
								if (var6 > var3 && var6 < var3 + var5 && var7 > var10 - 13 && var7 < var10 + 3) {
									var8 = var9;
								}
							}

							if (var8 != -1) {
								class112.method2564(var8, 464504900);
							}

							field716 = false;
							class48.method948(class48.field435, class0.field1, class135.field1856, class151.field1933, -1873086806);
						}
					} else {
						var3 = field771 - 1;
						if ((var2 == 1 || !class253.field3229 && var2 == 4) && var3 >= 0) {
							label254:
							{
								var5 = field720[var3];
								if (var5 != 39 && var5 != 40 && var5 != 41 && var5 != 42 && var5 != 43 && var5 != 33) {
									if (var1 >= 1287424439) {
										return;
									}

									if (var5 != 34 && var5 != 35 && var5 != 36 && var5 != 37 && var5 != 38 && var5 != 1005) {
										break label254;
									}
								}

								var6 = field718[var3];
								var7 = field851[var3];
								Widget var11 = Widget.getLoaded(var7);
								if (class7.method83(class24.method425(var11, (byte) 1), (short) 24612)) {
									break label259;
								}

								if (var1 >= 1287424439) {
									return;
								}

								if (class140.method3150(class24.method425(var11, (byte) -102), (byte) -1)) {
									if (var1 >= 1287424439) {
										return;
									}
									break label259;
								}
							}
						}

						if ((var2 == 1 || !class253.field3229 && var2 == 4) && this.method1149((byte) 62)) {
							var2 = 2;
						}

						if ((var2 == 1 || !class253.field3229 && var2 == 4) && field771 > 0) {
							if (var1 >= 1287424439) {
								return;
							}

							class112.method2564(var3, 464504900);
						}

						if (var2 == 2 && field771 > 0) {
							this.method1476(class48.field432, class48.field428, -1768014038);
						}
					}

					return;
				}

				if (class276.field3559 != null && !field689) {
					if (var1 >= 1287424439) {
						return;
					}

					if (field771 > 0 && !this.method1149((byte) 62)) {
						if (var1 >= 1287424439) {
							return;
						}

						Player.method1120(field678, field821, 1254704637);
					}
				}

				field689 = false;
				field693 = 0;
				if (class276.field3559 != null) {
					requestRedraw(class276.field3559);
				}

				class276.field3559 = Widget.getLoaded(var7);
				field688 = var6;
				field678 = class48.field432;
				field821 = class48.field428;
				if (var3 >= 0) {
					class229.field2588 = new class75();
					class229.field2588.field1066 = field718[var3];
					class229.field2588.field1060 = field851[var3];
					class229.field2588.field1061 = field720[var3];
					class229.field2588.field1062 = field794[var3];
					class229.field2588.field1063 = field735[var3];
				}

				requestRedraw(class276.field3559);
			}
		}
	}

	final void method1448(int var1) {
		requestRedraw(field583);
		++class6.field39;
		if (field772 && field601) {
			int var2 = class48.field425;
			int var3 = class48.field426 * 673804999;
			var2 -= field753;
			var3 -= field749;
			if (var2 < field757) {
				var2 = field757;
			}

			if (var2 + field583.int472 > field757 + field752.int472) {
				if (var1 != -114951756) {
					return;
				}

				var2 = field757 + field752.int472 - field583.int472;
			}

			if (var3 < field758) {
				var3 = field758;
			}

			if (var3 + field583.int466 > field758 + field752.int466) {
				var3 = field758 + field752.int466 - field583.int466;
			}

			int var4 = var2 - field696;
			int var5 = var3 - field760;
			int var6 = field583.int489;
			if (class6.field39 > field583.int490) {
				label122:
				{
					if (var4 <= var6) {
						if (var1 != -114951756) {
							return;
						}

						if (var4 >= -var6 && var5 <= var6 && var5 >= -var6) {
							break label122;
						}
					}

					field763 = true;
				}
			}

			int var7 = var2 - field757 + field752.field2626;
			int var8 = var3 - field758 + field752.scrollY;
			ScriptInvocation var9;
			if (field583.objectArray30 != null && field763) {
				var9 = new ScriptInvocation();
				var9.field506 = field583;
				var9.field511 = var7;
				var9.field508 = var8;
				var9.parameters = field583.objectArray30;
				class68.method1696(var9);
			}

			if (class48.field419 == 0) {
				if (var1 != -114951756) {
					return;
				}

				if (field763) {
					if (field583.objectArray13 != null) {
						var9 = new ScriptInvocation();
						var9.field506 = field583;
						var9.field511 = var7;
						var9.field508 = var8;
						var9.field507 = field755;
						var9.parameters = field583.objectArray13;
						class68.method1696(var9);
					}

					if (field755 != null) {
						Widget var10 = field583;
						int var11 = Isaac.method3865(class24.method425(var10, (byte) -50), (short) -25401);
						Widget var14;
						if (var11 == 0) {
							var14 = null;
						} else {
							int var12 = 0;

							while (true) {
								if (var12 >= var11) {
									var14 = var10;
									break;
								}

								var10 = Widget.getLoaded(var10.parentHash);
								if (var10 == null) {
									if (var1 != -114951756) {
										return;
									}

									var14 = null;
									break;
								}

								++var12;
							}
						}

						if (var14 != null) {
							class172 var13 = class26.method433(OutgoingPacket.field2164, field626.field1218, 200641505);
							var13.field2257.writeShortA(field583.childId);
							var13.field2257.writeLEShortA(field583.itemId);
							var13.field2257.writeIntV1(field755.interfaceHash);
							var13.field2257.writeShortLE(field755.itemId);
							var13.field2257.writeIntV2(field583.interfaceHash);
							var13.field2257.writeShort(field755.childId);
							field626.method1980(var13, (byte) 1);
						}
					}
				} else if (this.method1149((byte) 62)) {
					if (var1 != -114951756) {
						return;
					}

					this.method1476(field696 + field753, field749 + field760, -1379195924);
				} else if (field771 > 0) {
					if (var1 != -114951756) {
						return;
					}

					Player.method1120(field753 + field696, field749 + field760, -1878056731);
				}

				field583 = null;
			}

		} else {
			if (class6.field39 > 1) {
				if (var1 != -114951756) {
					return;
				}

				field583 = null;
			}

		}
	}

	public final void init() {
		try {
			if (this.method774(375421429)) {
				class279[] var1 = class51.method996((short) 128);

				for (int var2 = 0; var2 < var1.length; var2++) {
					class279 var3 = var1[var2];
					String var4 = this.getParameter(var3.field3591);
					if (var4 != null) {
						switch (Integer.parseInt(var3.field3591)) {
							case 2:
								if (field587 == -1) {
									field587 = Integer.parseInt(var4);
								}
								break;
							case 3:
								field777 = Integer.parseInt(var4);
								break;
							case 4:
								field632 = Integer.parseInt(var4);
								break;
							case 5:
								class26.field219 = Loader.WORLDLIST;
								break;
							case 6:
								field629 = Integer.parseInt(var4) != 0;
								break;
							case 7:
								if (var4.equalsIgnoreCase("true")) {
									;
								}
								break;
							case 8:
								field827 = Integer.parseInt(var4);
							case 9:
							case 12:
							default:
								break;
							case 10:
								class163.field2013 = var4;
								break;
							case 11:
								RuneScriptMap.field3346 = class179.method3517(Integer.parseInt(var4), 909001219);
								break;
							case 13:
								field581 = Integer.parseInt(var4);
								break;
							case 14:
								if (var4.equalsIgnoreCase("true")) {
									field668 = true;
								} else {
									field668 = false;
								}
								break;
							case 15:
								class112.field1455 = (class244) class76.method1803(class191.method3870((byte) 17), Integer.parseInt(var4), (byte) 0);
								if (class112.field1455 == class244.field3145) {
									class36.field306 = class322.field3880;
								} else {
									class36.field306 = class322.field3878;
								}
								break;
							case 16:
								class124.field1709 = Integer.parseInt(var4);
						}
					}
				}

				class177.method3513(2097572835);
				class54.gameHost = this.getCodeBase().getHost();
				String var7 = RuneScriptMap.field3346.field3135;
				byte var8 = 0;

				try {
					class177.method3509("oldschool", var7, var8, 17, (byte) 29);
				} catch (Exception var5) {
					class5.method65((String) null, var5, (byte) 68);
				}

				Stream.client = this;
				class152.field1940 = field587;
				this.method778(765, 503, 171, 1907342193);
			}
		} catch (RuntimeException var6) {
			throw class95.method2195(var6, "client.init(" + ')');
		}
	}

	static long method1535(int var0) {
		try {
			URL var1 = new URL(class142.method3161("services", false, (byte) 20) + "m=accountappeal/login.ws");
			URLConnection var2 = var1.openConnection();
			var2.setRequestProperty("connection", "close");
			var2.setDoInput(true);
			var2.setDoOutput(true);
			var2.setConnectTimeout(5000);
			OutputStreamWriter var3 = new OutputStreamWriter(var2.getOutputStream());
			var3.write("data1=req");
			var3.flush();
			InputStream var4 = var2.getInputStream();
			Stream var5 = new Stream(new byte[1000]);

			do {
				int var6 = var4.read(var5.field2338, var5.field2339, 1000 - var5.field2339);
				if (var6 == -1) {
					var5.field2339 = 0;
					long var8 = var5.readLong();
					return var8;
				}

				var5.field2339 += var6;
			} while (var5.field2339 < 1000);

			return 0L;
		} catch (Exception var10) {
			return 0L;
		}
	}
}
