package client;

public class Widget extends class204 {

	public static boolean field2603 = false;
	public static Widget[][] LOADED;
	static class200 field2599 = new class200(200);
	static class200 field2601 = new class200(20);
	static class200 field2600 = new class200(50);
	static class247 staticJs5Index11;
	static class247 field2598;
	static class247 field2642;
	static class200 field2602 = new class200(8);
	public static final int field2597 = 1339;
	public static final int field2620 = 1400;
	public static final int field2652 = 1337;
	public static final int field2730 = 1401;
	public static final int field2741 = 6;
	public int field2641;
	public String[] regularOptions;
	public int parentHash = -1;
	public int[] field2724;
	public boolean decodeCs2 = false;
	public int int473;
	public int fontId;
	int field2650;
	public int[] field2676;
	public int spriteId;
	public int mediaType;
	public int int472 = 0;
	int field2651;
	public int mediaID;
	public boolean field2686;
	public int widgetType;
	public int int466 = 0;
	public int interfaceHash = -1;
	public boolean flipVertical;
	public int outline;
	public int int504;
	public int childId = -1;
	public boolean flipHorizontal;
	public int widthAlignment = 0;
	public int xAlignment = 0;
	public int[] field2725;
	public int field2709 = 0;
	public int x = 0;
	public int width = 0;
	public int field2618 = 0;
	public int interactType = 0;
	public int heightAlignment = 0;
	public int yAlignment = 0;
	public int shadow;
	public int y = 0;
	public int height = 0;
	public int int447 = 0;
	public boolean hidden = false;
	public int field2622 = 1;
	public int field2623 = 1;
	public int animation;
	public int field2653;
	public Widget[] children;
	public int field2732;
	public int[] field2719;
	public int[][] field2659;
	public int field2613;
	public int defaultSettings;
	public int alpha;
	public Object[] field2715;
	public int[] field2720;
	public int rotationX;
	public int field2728;
	public int rotationY;
	public int field2713;
	public int field2626 = 0;
	public int scrollY = 0;
	public int int489;
	public int scrollWidth = 0;
	public int scrollHeight = 0;
	public int int490;
	public int color = 0;
	public int field2631 = 0;
	public int field2632 = 0;
	public int field2633 = 0;
	public boolean filled = false;
	public class316 field2701;
	public int field2608;
	public int int461;
	public Object[] objectArray30;
	public boolean bool41;
	public boolean bool47;
	public int int436;
	public int fontHorizontalAlignment;
	public boolean bool40;
	public int fontVerticalAlignment;
	public boolean bool42;
	public String componentString;
	public int int457;
	public Object[] objectArray13;
	public int lineHeight;
	public int int474;
	public int field2672;
	public int field2673;
	public boolean fontShadow;
	public int int477;
	public int itemId;
	public int field2727;
	public int[] field2685;
	public int zoom;
	public int field2664;
	public int[] field2738;
	public String field2717;
	public int int464;
	public boolean bool45;
	public String[] field2677;
	public boolean field2726;
	public String string29;
	public Widget field2666;
	public String selectedActionName;
	public String field2722;
	public Object[] objectArray15;
	public String field2723;
	public Object[] cs2Triggers;
	public Object[] mouseEnteredScript;
	public boolean field2731;
	public boolean field2674;
	public Object[] mouseLeftScript;
	public int field2697;
	public int field2683;
	public int field2735;
	public int field2702;
	public Object[] objectArray14;
	public Object[] onConfigTrigger;
	public boolean field2740;
	public Object[] onItemUpdateTrigger;
	public Object[] onSkillUpdateTrigger;
	public Object[] objectArray17;
	public Object[] onClickListener;
	public Object[] objectArray11;
	public Object[] objectArray7;
	public Object[] field2654;
	public Object[] objectArray8;
	public Object[] field2714;
	public Object[] objectArray5;
	public Object[] objectArray9;
	public Object[] objectArray19;
	public int[] mouseWheelTrigger;
	public int[] configChangeTriggers;
	public int[] itemUpdateTriggers;
	public Object[] field2708;
	public Object[] field2637;
	public Object[] field2718;
	public Object[] field2711;
	public Object[] field2712;
	public Object[] field2716;
	public Object[] field2693;

	public Widget() {
		this.field2701 = class316.field3775;
		this.alpha = 0;
		this.field2608 = 0;
		this.int461 = 1;
		this.bool41 = false;
		this.spriteId = -1;
		this.field2641 = -1;
		this.int436 = 0;
		this.bool42 = false;
		this.outline = 0;
		this.shadow = 0;
		this.mediaType = 1;
		this.mediaID = -1;
		this.field2650 = 1;
		this.field2651 = -1;
		this.animation = -1;
		this.field2653 = -1;
		this.int457 = 0;
		this.int474 = 0;
		this.rotationX = 0;
		this.rotationY = 0;
		this.int477 = 0;
		this.zoom = 100;
		this.int464 = 0;
		this.field2732 = 0;
		this.bool45 = false;
		this.field2726 = false;
		this.field2664 = 2;
		this.fontId = -1;
		this.componentString = "";
		this.field2717 = "";
		this.lineHeight = 0;
		this.fontHorizontalAlignment = 0;
		this.fontVerticalAlignment = 0;
		this.fontShadow = false;
		this.field2672 = 0;
		this.field2673 = 0;
		this.defaultSettings = 0;
		this.string29 = "";
		this.field2666 = null;
		this.int489 = 0;
		this.int490 = 0;
		this.bool47 = false;
		this.selectedActionName = "";
		this.field2686 = false;
		this.field2713 = -1;
		this.field2722 = "";
		this.field2723 = "Ok";
		this.itemId = -1;
		this.field2727 = 0;
		this.field2728 = 0;
		this.field2613 = 0;
		this.field2731 = false;
		this.field2674 = false;
		this.field2697 = -1;
		this.field2683 = 0;
		this.field2735 = 0;
		this.field2702 = 0;
		this.int504 = -1;
		this.int473 = -1;
		this.bool40 = false;
		this.field2740 = false;
	}

	public static Widget get(int parentId, int childId) {
		return getLoaded(parentId << 16 | childId);
	}

	public static Widget getLoaded(int var0) {
	   int var2 = var0 >> 16;
	   int var3 = var0 & 65535;
	   if(LOADED[var2] == null || LOADED[var2][var3] == null) {
	      boolean var4 = class261.method4931(var2, (byte)-24);
	      if(!var4) {
	         return null;
	      }
	   }

	   return LOADED[var2][var3];
	}

	public static void setItem(Widget inter, int itemId, int itemAmount, int itemAmountSetting) {
		ItemDef def = ItemDef.loadItemDef(itemId);
		inter.itemId = itemId;
		inter.field2727 = itemAmount;
		inter.rotationX = def.xan2d;
		inter.rotationY = def.yan2d;
		inter.int477 = def.zan2d;
		inter.int457 = def.xof2d;
		inter.int474 = def.yof2d;
		inter.zoom = def.zoom2d;
		inter.field2664 = itemAmountSetting;
		if(inter.int464 > 0)
			inter.zoom = inter.zoom * 32 / inter.int464;
		else if(inter.width > 0)
			inter.zoom = inter.zoom * 32 / inter.width;
	}

	public void setOption(int i_1, String optionText) {
		if (this.regularOptions == null || this.regularOptions.length <= i_1) {
			String[] arr = new String[1 + i_1];
			if (this.regularOptions != null) {
				for (int i_5 = 0; i_5 < this.regularOptions.length; i_5++) {
					arr[i_5] = this.regularOptions[i_5];
				}
			}
			this.regularOptions = arr;
		}
		this.regularOptions[i_1] = optionText;
	}

	public Sprite method4508(boolean var1, int var2) {
		field2603 = false;
		int var3;
		if (var1) {
			var3 = this.field2641;
		} else {
			var3 = this.spriteId;
		}

		if (var3 == -1) {
			return null;
		} else {
			long var4 = ((this.flipVertical ? 1L : 0L) << 39) + (long) var3 + ((long) this.outline << 36) + ((this.flipHorizontal ? 1L : 0L) << 38) + ((long) this.shadow << 40);
			Sprite var6 = (Sprite) field2599.method3989(var4);
			if (var6 != null) {
				return var6;
			} else {
				var6 = class229.method4499(class154.field1956, var3, 0, -1120591902);
				if (var6 == null) {
					field2603 = true;
					return null;
				} else {
					if (this.flipHorizontal) {
						var6.method5842();
					}

					if (this.flipVertical) {
						var6.method5934();
					}

					if (this.outline > 0) {
						var6.method5844(this.outline);
					}

					if (this.outline >= 1) {
						var6.method5847(1);
					}

					if (this.outline >= 2) {
						var6.method5847(16777215);
					}

					if (this.shadow != 0) {
						var6.method5848(this.shadow);
					}

					field2599.method3983(var6, var4);
					return var6;
				}
			}
		}
	}

	void unpackNew(Stream buffer) {
		buffer.readUByte();
		this.decodeCs2 = true;
		this.widgetType = buffer.readUByte();
		this.interactType = buffer.readUShort();
		this.x = buffer.readShort();
		this.y = buffer.readShort();
		this.width = buffer.readUShort();
		if (this.widgetType == 9) {
			this.height = buffer.readShort();
		} else {
			this.height = buffer.readUShort();
		}

		this.widthAlignment = buffer.readByte();
		this.heightAlignment = buffer.readByte();
		this.xAlignment = buffer.readByte();
		this.yAlignment = buffer.readByte();

		this.parentHash = buffer.readUShort();
		if (this.parentHash == 65535) {
			this.parentHash = -1;
		} else {
			this.parentHash += this.interfaceHash & -65536;
		}

		this.hidden = buffer.readUByte() == 1;

		if (this.widgetType == 0) {
			this.scrollWidth = buffer.readUShort();
			this.scrollHeight = buffer.readUShort();
			this.bool40 = buffer.readUByte() == 1;
		}

		if (this.widgetType == 5) {
			this.spriteId = buffer.readInt();
			this.int436 = buffer.readUShort();
			this.bool42 = buffer.readUByte() == 1;
			this.alpha = buffer.readUByte();
			this.outline = buffer.readUByte();
			this.shadow = buffer.readInt();
			this.flipHorizontal = buffer.readUByte() == 1;
			this.flipVertical = buffer.readUByte() == 1;
		}

		if (this.widgetType == 6) {
			this.mediaType = 1;
			this.mediaID = buffer.readUShort();
			if (this.mediaID == 65535) {
				this.mediaID = -1;
			}

			this.int457 = buffer.readShort();
			this.int474 = buffer.readShort();
			this.rotationX = buffer.readUShort();
			this.rotationY = buffer.readUShort();
			this.int477 = buffer.readUShort();
			this.zoom = buffer.readUShort();
			this.animation = buffer.readUShort();
			if (this.animation == 65535) {

				this.animation = -1;
			}

			this.bool45 = buffer.readUByte() == 1;
			buffer.readUShort();
			if (this.widthAlignment != 0) {
				this.int464 = buffer.readUShort();
			}

			if (this.heightAlignment != 0) {
				buffer.readUShort();
			}
		}

		boolean ccbtn = false;
		if (this.widgetType == 4) {
			this.fontId = buffer.readUShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.componentString = buffer.readString();

			if (componentString.equalsIgnoreCase("clan setup") || componentString.equalsIgnoreCase("anyone")) {
				if (Custom.ccsetup(componentString)) {
					ccbtn = true;
				}
			}

			this.lineHeight = buffer.readUByte();
			this.fontHorizontalAlignment = buffer.readUByte();
			this.fontVerticalAlignment = buffer.readUByte();
			this.fontShadow = buffer.readUByte() == 1;
			this.color = buffer.readInt();
		}

		if (this.widgetType == 3) {
			this.color = buffer.readInt();
			this.filled = buffer.readUByte() == 1;
			this.alpha = buffer.readUByte();
		}

		if (this.widgetType == 9) {
			this.int461 = buffer.readUByte();
			this.color = buffer.readInt();
			this.bool41 = buffer.readUByte() == 1;
		}

		this.defaultSettings = buffer.readMedium();
		this.string29 = buffer.readString();
		int var3 = buffer.readUByte();
		if (var3 > 0) {
			this.regularOptions = new String[var3];

			for (int var4 = 0; var4 < var3; var4++) {
				this.regularOptions[var4] = buffer.readString();
			}
		}

		if (ccbtn) {
			regularOptions = new String[]{"Clan setup", "Reset banlist"};
			defaultSettings = 1022; // enable more than 1 op. this does 9 lol
		}

		this.int489 = buffer.readUByte();
		this.int490 = buffer.readUByte();
		this.bool47 = buffer.readUByte() == 1;
		this.selectedActionName = buffer.readString();

		this.cs2Triggers = this.decodeTriggers(buffer, -2110058003);
		this.mouseEnteredScript = this.decodeTriggers(buffer, -2110058003);
		this.mouseLeftScript = this.decodeTriggers(buffer, -2110058003);
		this.objectArray15 = this.decodeTriggers(buffer, -2110058003);
		this.objectArray14 = this.decodeTriggers(buffer, -2110058003);
		this.onConfigTrigger = this.decodeTriggers(buffer, -2110058003);
		this.onItemUpdateTrigger = this.decodeTriggers(buffer, -2110058003);
		this.onSkillUpdateTrigger = this.decodeTriggers(buffer, -2110058003);
		this.objectArray17 = this.decodeTriggers(buffer, -2110058003);
		this.onClickListener = this.decodeTriggers(buffer, -2110058003);
		this.objectArray11 = this.decodeTriggers(buffer, -2110058003);
		this.objectArray7 = this.decodeTriggers(buffer, -2110058003);
		this.objectArray8 = this.decodeTriggers(buffer, -2110058003);
		this.objectArray5 = this.decodeTriggers(buffer, -2110058003);
		this.objectArray9 = this.decodeTriggers(buffer, -2110058003);
		this.objectArray30 = this.decodeTriggers(buffer, -2110058003);
		this.objectArray13 = this.decodeTriggers(buffer, -2110058003);
		this.objectArray19 = this.decodeTriggers(buffer, -2110058003);
		this.mouseWheelTrigger = this.method4502(buffer, (byte) -4);
		this.configChangeTriggers = this.method4502(buffer, (byte) 66);
		this.itemUpdateTriggers = this.method4502(buffer, (byte) -20);
	}

	void method4549(Stream var1, int var2) {
		this.decodeCs2 = false;
		this.widgetType = var1.readUByte();
		this.field2709 = var1.readUByte();
		this.interactType = var1.readUShort();
		this.x = var1.readShort();
		this.y = var1.readShort();
		this.width = var1.readUShort();
		this.height = var1.readUShort();
		this.alpha = var1.readUByte();
		this.parentHash = var1.readUShort();
		if (this.parentHash == 65535) {
			this.parentHash = -1;
		} else {
			this.parentHash += this.interfaceHash & -65536;
		}

		this.field2713 = var1.readUShort();
		if (this.field2713 == 65535) {
			this.field2713 = -1;
		}

		int var3 = var1.readUByte();
		int var4;
		if (var3 > 0) {
			this.field2719 = new int[var3];
			this.field2720 = new int[var3];

			for (var4 = 0; var4 < var3; var4++) {
				this.field2719[var4] = var1.readUByte();
				this.field2720[var4] = var1.readUShort();
			}
		}

		var4 = var1.readUByte();
		int var5;
		int var6;
		int var7;
		if (var4 > 0) {
			this.field2659 = new int[var4][];

			for (var5 = 0; var5 < var4; var5++) {
				if (var2 == -12002445) {
					return;
				}

				var6 = var1.readUShort();
				this.field2659[var5] = new int[var6];

				for (var7 = 0; var7 < var6; var7++) {

					this.field2659[var5][var7] = var1.readUShort();
					if (this.field2659[var5][var7] == 65535) {
						this.field2659[var5][var7] = -1;
					}
				}
			}
		}

		boolean var10001;
		if (this.widgetType == 0) {
			this.scrollHeight = var1.readUShort();
			if (var1.readUByte() == 1) {
				if (var2 == -12002445) {
					return;
				}

				var10001 = true;
			} else {
				var10001 = false;
			}

			this.hidden = var10001;
		}

		if (this.widgetType == 1) {
			var1.readUShort();
			var1.readUByte();
		}

		if (this.widgetType == 2) {
			if (var2 == -12002445) {
				return;
			}

			this.field2724 = new int[this.width * this.height];
			this.field2725 = new int[this.width * this.height];
			var5 = var1.readUByte();
			if (var5 == 1) {
				this.defaultSettings |= 268435456;
			}

			var6 = var1.readUByte();
			if (var6 == 1) {
				this.defaultSettings |= 1073741824;
			}

			var7 = var1.readUByte();
			if (var7 == 1) {
				this.defaultSettings |= Integer.MIN_VALUE;
			}

			int var8 = var1.readUByte();
			if (var8 == 1) {

				this.defaultSettings |= 536870912;
			}

			this.field2672 = var1.readUByte();
			this.field2673 = var1.readUByte();
			this.field2685 = new int[20];
			this.field2738 = new int[20];
			this.field2676 = new int[20];

			int var9;
			for (var9 = 0; var9 < 20; var9++) {

				int var10 = var1.readUByte();
				if (var10 == 1) {
					this.field2685[var9] = var1.readShort();
					this.field2738[var9] = var1.readShort();
					this.field2676[var9] = var1.readInt();
				} else {
					this.field2676[var9] = -1;
				}
			}

			this.field2677 = new String[5];

			for (var9 = 0; var9 < 5; var9++) {

				String var12 = var1.readString();
				if (var12.length() > 0) {
					this.field2677[var9] = var12;
					this.defaultSettings |= 1 << var9 + 23;
				}
			}
		}

		if (this.widgetType == 3) {
			if (var1.readUByte() == 1) {
				if (var2 == -12002445) {
					return;
				}

				var10001 = true;
			} else {
				var10001 = false;
			}

			this.filled = var10001;
		}

		label388:
		{
			if (this.widgetType != 4) {
				if (this.widgetType != 1) {
					break label388;
				}

				if (var2 == -12002445) {
					return;
				}
			}

			this.fontHorizontalAlignment = var1.readUByte();
			this.fontVerticalAlignment = var1.readUByte();
			this.lineHeight = var1.readUByte();
			this.fontId = var1.readUShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.fontShadow = var1.readUByte() == 1;
		}

		if (this.widgetType == 4) {
			if (var2 == -12002445) {
				return;
			}

			this.componentString = var1.readString();
			this.field2717 = var1.readString();
		}

		if (this.widgetType == 1 || this.widgetType == 3 || this.widgetType == 4) {
			this.color = var1.readInt();
		}

		if (this.widgetType == 3 || this.widgetType == 4) {
			this.field2631 = var1.readInt();
			this.field2632 = var1.readInt();
			this.field2633 = var1.readInt();
		}

		if (this.widgetType == 5) {
			this.spriteId = var1.readInt();
			this.field2641 = var1.readInt();
		}

		if (this.widgetType == 6) {
			this.mediaType = 1;
			this.mediaID = var1.readUShort();
			if (this.mediaID == 65535) {
				this.mediaID = -1;
			}

			this.field2650 = 1;
			this.field2651 = var1.readUShort();
			if (this.field2651 == 65535) {
				if (var2 == -12002445) {
					return;
				}

				this.field2651 = -1;
			}

			this.animation = var1.readUShort();
			if (this.animation == 65535) {
				if (var2 == -12002445) {
					return;
				}

				this.animation = -1;
			}

			this.field2653 = var1.readUShort();
			if (this.field2653 == 65535) {
				this.field2653 = -1;
			}

			this.zoom = var1.readUShort();
			this.rotationX = var1.readUShort();
			this.rotationY = var1.readUShort();
		}

		if (this.widgetType == 7) {
			this.field2724 = new int[this.height * this.width];
			this.field2725 = new int[this.width * this.height];
			this.fontHorizontalAlignment = var1.readUByte();
			this.fontId = var1.readUShort();
			if (this.fontId == 65535) {
				if (var2 == -12002445) {
					return;
				}

				this.fontId = -1;
			}

			if (var1.readUByte() == 1) {
				if (var2 == -12002445) {
					return;
				}

				var10001 = true;
			} else {
				var10001 = false;
			}

			this.fontShadow = var10001;
			this.color = var1.readInt();
			this.field2672 = var1.readShort();
			this.field2673 = var1.readShort();
			var5 = var1.readUByte();
			if (var5 == 1) {
				this.defaultSettings |= 1073741824;
			}

			this.field2677 = new String[5];

			for (var6 = 0; var6 < 5; var6++) {
				if (var2 == -12002445) {
					return;
				}

				String var11 = var1.readString();
				if (var11.length() > 0) {
					this.field2677[var6] = var11;
					this.defaultSettings |= 1 << var6 + 23;
				}
			}
		}

		if (this.widgetType == 8) {
			if (var2 == -12002445) {
				return;
			}

			this.componentString = var1.readString();
		}

		label313:
		{
			if (this.field2709 != 2) {
				if (this.widgetType != 2) {
					break label313;
				}

				if (var2 == -12002445) {
					return;
				}
			}

			this.selectedActionName = var1.readString();
			this.field2722 = var1.readString();
			var5 = var1.readUShort() & 63;
			this.defaultSettings |= var5 << 11;
		}

		label307:
		{
			if (this.field2709 != 1 && this.field2709 != 4 && this.field2709 != 5) {
				if (var2 == -12002445) {
					return;
				}

				if (this.field2709 != 6) {
					break label307;
				}
			}

			this.field2723 = var1.readString();
			if (this.field2723.length() == 0) {
				if (this.field2709 == 1) {
					this.field2723 = "Ok";
				}

				if (this.field2709 == 4) {
					this.field2723 = "Select";
				}

				if (this.field2709 == 5) {
					if (var2 == -12002445) {
						return;
					}

					this.field2723 = "Select";
				}

				if (this.field2709 == 6) {
					this.field2723 = "Continue";
				}
			}
		}

		label299:
		{
			if (this.field2709 != 1 && this.field2709 != 4) {
				if (var2 == -12002445) {
					return;
				}

				if (this.field2709 != 5) {
					break label299;
				}
			}

			this.defaultSettings |= 4194304;
		}

		if (this.field2709 == 6) {
			this.defaultSettings |= 1;
		}

	}

	public class224 method4517(boolean var1, int var2) {
		if (this.field2641 == -1) {
			var1 = false;
		}

		int var3 = var1 ? this.field2641 : this.spriteId;
		if (var3 == -1) {
			return null;
		} else {
			long var4 = (long) var3 + ((long) this.outline << 36) + ((this.flipHorizontal ? 1L : 0L) << 38) + ((this.flipVertical ? 1L : 0L) << 39) + ((long) this.shadow << 40);
			class224 var6 = (class224) field2602.method3989(var4);
			if (var6 != null) {
				return var6;
			} else {
				Sprite var7 = this.method4508(var1, 1507049297);
				if (var7 == null) {
					return null;
				} else {
					Sprite var8 = var7.method5852();
					int[] var9 = new int[var8.height];
					int[] var10 = new int[var8.height];

					for (int var11 = 0; var11 < var8.height; var11++) {
						int var12 = 0;
						int var13 = var8.width;

						int var14;
						for (var14 = 0; var14 < var8.width; var14++) {
							if (var8.pixels[var14 + var11 * var8.width] == 0) {
								var12 = var14;
								break;
							}
						}

						for (var14 = var8.width - 1; var14 >= var12; --var14) {
							if (var8.pixels[var14 + var11 * var8.width] == 0) {
								var13 = var14 + 1;
								break;
							}
						}

						var9[var11] = var12;
						var10[var11] = var13 - var12;
					}

					var6 = new class224(var8.width, var8.height, var10, var9, var3);
					field2602.method3983(var6, var4);
					return var6;
				}
			}
		}
	}

	public class298 method4545(int var1) {
		field2603 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			class298 var2 = (class298) field2601.method3989((long) this.fontId);
			if (var2 != null) {
				return var2;
			} else {
				var2 = class58.method1058(class154.field1956, field2598, this.fontId, 0, -2132588897);
				if (var2 != null) {
					field2601.method3983(var2, (long) this.fontId);
				} else {
					field2603 = true;
				}

				return var2;
			}
		}
	}

	public Sprite method4509(int var1, int var2) {
		field2603 = false;
		if (var1 >= 0 && var1 < this.field2676.length) {
			int var3 = this.field2676[var1];
			if (var3 == -1) {
				return null;
			} else {
				Sprite var4 = (Sprite) field2599.method3989((long) var3);
				if (var4 != null) {
					return var4;
				} else {
					var4 = class229.method4499(class154.field1956, var3, 0, -472458798);
					if (var4 != null) {
						field2599.method3983(var4, (long) var3);
					} else {
						field2603 = true;
					}

					return var4;
				}
			}
		} else {
			return null;
		}
	}

	public class119 method4510(class273 var1, int var2, boolean var3, class227 var4, int var5) {
		field2603 = false;
		int var6;
		int var7;
		if (var3) {
			var6 = this.field2650;
			var7 = this.field2651;
		} else {
			var6 = this.mediaType;
			var7 = this.mediaID;
		}

		if (var6 == 0) {
			return null;
		} else if (var6 == 1 && var7 == -1) {
			return null;
		} else {
			class119 var8 = (class119) field2600.method3989((long) (var7 + (var6 << 16)));
			if (var8 == null) {
				class113 var9;
				if (var6 == 1) {
					var9 = class113.method2568(field2642, var7, 0);
					if (var9 == null) {
						field2603 = true;
						return null;
					}

					var8 = var9.method2589(64, 768, -50, -10, -50);
				}

				if (var6 == 2) {
					var9 = class270.loadNpcDef(var7).method5158((byte) -30);
					if (var9 == null) {
						field2603 = true;
						return null;
					}

					var8 = var9.method2589(64, 768, -50, -10, -50);
				}

				if (var6 == 3) {
					if (var4 == null) {
						return null;
					}

					var9 = var4.method4469(-299870207);
					if (var9 == null) {
						field2603 = true;
						return null;
					}

					var8 = var9.method2589(64, 768, -50, -10, -50);
				}

				if (var6 == 4) {
					ItemDef var10 = ItemDef.loadItemDef(var7);
					var9 = var10.method5092(10, (byte) 25);
					if (var9 == null) {
						field2603 = true;
						return null;
					}

					var8 = var9.method2589(var10.int637 + 64, var10.int609 + 768, -50, -10, -50);
				}

				field2600.method3983(var8, (long) (var7 + (var6 << 16)));
			}

			if (var1 != null) {
				var8 = var1.method5219(var8, var2, 1136380155);
			}

			return var8;
		}
	}

	Object[] decodeTriggers(Stream var1, int var2) {
		int var3 = var1.readUByte();
		if (var3 == 0) {
			return null;
		} else {
			Object[] var4 = new Object[var3];

			for (int var5 = 0; var5 < var3; var5++) {
				int var6 = var1.readUByte();
				if (var6 == 0) {
					var4[var5] = new Integer(var1.readInt());
				} else if (var6 == 1) {
					var4[var5] = var1.readString();
				}
			}

			this.field2686 = true;
			return var4;
		}
	}

	int[] method4502(Stream var1, byte var2) {
		int var3 = var1.readUByte();
		if (var3 == 0) {
			return null;
		} else {
			int[] var4 = new int[var3];

			for (int var5 = 0; var5 < var3; var5++) {
				var4[var5] = var1.readInt();
			}

			return var4;
		}
	}

	public void method4512(int var1, String var2) {
		if (this.regularOptions == null || this.regularOptions.length <= var1) {
			String[] var4 = new String[var1 + 1];
			if (this.regularOptions != null) {
				for (int var5 = 0; var5 < this.regularOptions.length; var5++) {
					var4[var5] = this.regularOptions[var5];
				}
			}

			this.regularOptions = var4;
		}

		this.regularOptions[var1] = var2;
	}

	public void method4507(int var1, int var2, int var3) {
		int var4 = this.field2724[var2];
		this.field2724[var2] = this.field2724[var1];
		this.field2724[var1] = var4;
		var4 = this.field2725[var2];
		this.field2725[var2] = this.field2725[var1];
		this.field2725[var1] = var4;
	}

	static int method4559(int var0, int var1, int var2) {
		class53 var3 = (class53) class53.field474.get((long) var0);
		return var3 == null ? -1 : (var1 >= 0 && var1 < var3.field477.length ? var3.field477[var1] : -1);
	}
}
