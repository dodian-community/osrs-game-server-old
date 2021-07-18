package client;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.channels.SocketChannel;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Jonathan on 6/11/2017.
 */
public class Custom {
	public static boolean debugMode = false;
	
	public static boolean disable_client_background = true;
	public static boolean disable_flames = true;
	public static boolean disable_runes_in_flames = true;
	public static boolean disable_logo = true;
	
	public static final String REMEMBER_USERNAME = "Remember username?";
	public static int currentRealm;
	public static boolean rememberUsername;
	public static String rememberedUsername = "";
	public static String rememberMeImage = "";
	private static boolean accountSlotOneSaved;
	public static byte[] HWID = new byte[20];
	
	public static void storeUsername(String typedUsername) {
		rememberedUsername = typedUsername;
	}
	
	public static boolean ccsetup(String componentString) {
		return componentString.equalsIgnoreCase("clan setup");
	}

	public static String getFormattedTime(int time) {
		int seconds = time / 50;
		if (seconds < 60)
			return "0:" + (seconds < 10 ? "0" : "") + seconds;
		else {
			int mins = seconds / 60;
			int remainderSecs = seconds - (mins * 60);
			if (mins < 60) {
				return mins + ":" + (remainderSecs < 10 ? "0" : "") + remainderSecs + "";
			} else {
				int hours = mins / 60;
				int remainderMins = mins - (hours * 60);
				return (hours < 10 ? "0" : "") + hours + "h " + (remainderMins < 10 ? "0" : "") + remainderMins + "m " + (remainderSecs < 10 ? "0" : "") + remainderSecs + "s";
			}
		}
	}

	public static void handleCustomVarp(int id, int value) {
		id -= 20000;
		if(id == 0) {
			//WidgetTimer.SHOW_WIDGETS = value == 1;
			return;
		}
	}

	static {
		new Thread(() -> {
			HWID = sha(hwid());
			if (HWID == null || HWID.length == 0) {
				HWID = new byte[20];
			}
			getMacAddress();
		}).start();
	}

	public static void openBrowser(String string_76, boolean b, boolean b1) {
		class58.method1053(string_76, b, "", b1, (byte) 15);
	}
	
	public static void swapPrayers(boolean newStyle) {
		Widget[] prayerFolder = Widget.LOADED[541];
		if (prayerFolder == null) {
			return;
		}
		Widget temp = prayerFolder[30];
		boolean hasNew = temp.interfaceHash == 35455006;//..6
		
		// Switch if we are instructed to use the other style.
		if (hasNew != newStyle) {
			prayerFolder[30] = prayerFolder[26];
			prayerFolder[26] = temp;
			GameClient.requestRedraw(prayerFolder[30]);
			GameClient.requestRedraw(prayerFolder[26]);
			
			temp = prayerFolder[27];
			prayerFolder[27] = prayerFolder[31];
			prayerFolder[31] = temp;
			GameClient.requestRedraw(prayerFolder[27]);
			GameClient.requestRedraw(prayerFolder[31]);
			
			GameClient.updateForSetting(83);
			GameClient.staticIntArray105[++GameClient.staticInt244 - 1 & 31] = 83;
		}
	}

	public static Widget addChild(int interfaceHash, int childType, int childId) {
		if(childType == 0)
			throw new RuntimeException();
		Widget parent = Widget.getLoaded(interfaceHash);
		if(parent.children == null)
			parent.children = new Widget[childId + 1];
		if(parent.children.length <= childId) {
			Widget[] var35 = new Widget[childId + 1];
			for(int var10 = 0; var10 < parent.children.length; var10++)
				var35[var10] = parent.children[var10];
			parent.children = var35;
		}
		if(childId > 0 && parent.children[childId - 1] == null)
			throw new RuntimeException("" + (childId - 1));
		Widget child = new Widget();
		child.widgetType = childType;
		child.parentHash = child.interfaceHash = parent.interfaceHash;
		child.childId = childId;
		child.decodeCs2 = true;
		parent.children[childId] = child;
		GameClient.requestRedraw(parent);
		return child;
	}
	
	public static void reportException(String ex) {
		/*//System.err.println("Reporting: '"+ex+"'");
		int pos = Client.secureBuffer.off;
		Client.secureBuffer.writeOpcode(135);
		Client.secureBuffer.writeShort(0);
		
		int i_6 = Client.secureBuffer.off;
		
		Client.secureBuffer.writeByte(0); // type.. not used rn
		
		byte[] bytes = Custom.encodeString(ex);
		GameStream gamestream_7 = Client.secureBuffer;
		
		gamestream_7.writeCompact(bytes.length);
		int packedLen = StaticClass48.huffman.encode(bytes, 0, bytes.length, gamestream_7.buf, gamestream_7.off);
		gamestream_7.off += packedLen;
		
		Client.secureBuffer.setVarShort(Client.secureBuffer.off - i_6);
		
		//System.out.println("err start "+i_6+" end at "+Client.secureBuffer.off+" length "+packedLen);
		// force flush
		if (NodeSub14Sub2.loginConnection != null && gamestream_7.off > 0) {
			try {
				NodeSub14Sub2.loginConnection.writeToPending(gamestream_7.buf, 0, gamestream_7.off);
				Client.secureBuffer.off = 0;
			} catch (IOException e) {
				gamestream_7.off = pos;
				e.printStackTrace();
			}
		} else {
			System.err.println("no connection, can't write error to server");
		}*/
	}
	
	public static void reportException(Throwable throwable_1) {
		try {
			// Convert to single str
			StringWriter sw = new StringWriter();
			throwable_1.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			reportException(exceptionAsString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] encodeString(String string_5) {
		
		int i_10 = string_5.length();
		byte[] bytes = new byte[i_10];
		
		for (int i_12 = 0; i_12 < i_10; i_12++) {
			char var_13 = string_5.charAt(i_12);
			if ((var_13 <= 0 || var_13 >= 128) && (var_13 < 160 || var_13 > 255)) {
				if (var_13 == 8364) {
					bytes[i_12] = -128;
				} else if (var_13 == 8218) {
					bytes[i_12] = -126;
				} else if (var_13 == 402) {
					bytes[i_12] = -125;
				} else if (var_13 == 8222) {
					bytes[i_12] = -124;
				} else if (var_13 == 8230) {
					bytes[i_12] = -123;
				} else if (var_13 == 8224) {
					bytes[i_12] = -122;
				} else if (var_13 == 8225) {
					bytes[i_12] = -121;
				} else if (var_13 == 710) {
					bytes[i_12] = -120;
				} else if (var_13 == 8240) {
					bytes[i_12] = -119;
				} else if (var_13 == 352) {
					bytes[i_12] = -118;
				} else if (var_13 == 8249) {
					bytes[i_12] = -117;
				} else if (var_13 == 338) {
					bytes[i_12] = -116;
				} else if (var_13 == 381) {
					bytes[i_12] = -114;
				} else if (var_13 == 8216) {
					bytes[i_12] = -111;
				} else if (var_13 == 8217) {
					bytes[i_12] = -110;
				} else if (var_13 == 8220) {
					bytes[i_12] = -109;
				} else if (var_13 == 8221) {
					bytes[i_12] = -108;
				} else if (var_13 == 8226) {
					bytes[i_12] = -107;
				} else if (var_13 == 8211) {
					bytes[i_12] = -106;
				} else if (var_13 == 8212) {
					bytes[i_12] = -105;
				} else if (var_13 == 732) {
					bytes[i_12] = -104;
				} else if (var_13 == 8482) {
					bytes[i_12] = -103;
				} else if (var_13 == 353) {
					bytes[i_12] = -102;
				} else if (var_13 == 8250) {
					bytes[i_12] = -101;
				} else if (var_13 == 339) {
					bytes[i_12] = -100;
				} else if (var_13 == 382) {
					bytes[i_12] = -98;
				} else if (var_13 == 376) {
					bytes[i_12] = -97;
				} else {
					bytes[i_12] = 63;
				}
			} else {
				bytes[i_12] = (byte) var_13;
			}
		}
		return bytes;
	}
	
	public static class Icons {
		
		public static PaletteSprite[] loadIcons(PaletteSprite[] modicons) {
			if (modicons != null) {
				// Enlarge and insert helper icon
				String[] images = {"prayer_points", "saradomin_brew", "tournament", "check", "heart_icon", "heart", "timer_nine", "timer_eight", "timer_seven", "timer_six", "timer_five", "timer_four", "timer_three", "timer_two", "timer_one",
						"risk_prot", "dangerous", "stacked_bloodmoney", "presetsfive", "presetsfour", "presetsthree", "presetstwo", "presetsone",
						"presetsdash", "youtuber_bronze", "youtuber_silver", "youtuber_gold", "lottery", "srmod", "uncheckedBox", "checkedBox", "pvpsurvival",
						"whiterank", "blackrank", "goldrank", "purplerank", "greenrank", "bluerank", "redrank", "him", "pumpkin", "stacked_bloodmoney", "pvpironman",
						"hitbox", "skotizo", "helper", "coins", "sword", "shield", "shutdown", "bountyhiscore", "bounty5", "bounty4", "bounty3", "bounty2", "bounty1",
						"playtime", "votepoints", "vote", "announcement", "main", "pure", "berserker", "hybrid", "youtuber", "ratio", "deaths", "kills", "wilderness",
						"playersonline", "clockicon", "questionmark"};
				PaletteSprite[] sprites = new PaletteSprite[modicons.length - 10 + images.length];
				System.arraycopy(modicons, 0, sprites, 0, modicons.length);
				try {
					for (int i = 1; i < images.length; i++) {
						sprites[sprites.length - i] = getBasicImage(images[i - 1] + ".png");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return sprites;
			}
			return modicons;
		}
		
		//public static RGBSprite clientLogo;
		public static Sprite bloodMoneyIcon;
		public static Sprite diceIcon;
		public static Sprite transportationIcon;
		public static Sprite bloodSurvivalIcon;
		//public static RGBSprite rememberUsernameChecked;
		//public static RGBSprite rememberUsernameUnchecked;
		public static PaletteSprite infernoTitlebox;
		public static PaletteSprite infernoButton;
		public static Sprite petIcon;
		public static Sprite eventIcon;
		public static Sprite event_Icon;
		public static Sprite combatBagIcon;
		public static Sprite prayerIcon;
		public static Sprite bankIcon;
		public static Sprite helpIcon;
		public static Sprite donatorIcon;
		public static Sprite loyaltyIcon;
		
		public static void loadExtras(Component component) {
			byte[] clientBackgroundLeft = Custom.loadImage("ds2-left.png");
			byte[] clientBackgroundRight = Custom.loadImage("ds2-right.png");
			//byte[] accountBackground = Custom.loadImage("accountselectionbackground.png");

			class78.titleImage = new Sprite(clientBackgroundLeft, component);
			class78.titleImageRight = new Sprite(clientBackgroundRight, component);
			//clientLogo = new RGBSprite(loadImage("ecologo-client.png"), component);
			bloodMoneyIcon = new Sprite(loadImage("bmicon.png"), component);
			prayerIcon = new Sprite(loadImage("prayer_icon.png"), component);
			helpIcon = new Sprite(loadImage("help_icon.png"), component);
			combatBagIcon = new Sprite(loadImage("combat_bag_icon.png"), component);
			loyaltyIcon = new Sprite(loadImage("heart_icon.png"), component);
			event_Icon = new Sprite(loadImage("event_icon.png"), component);
			diceIcon = new Sprite(loadImage("dicing.png"), component);
			donatorIcon = new Sprite(loadImage("donator_icon.png"), component);
			transportationIcon = new Sprite(loadImage("transportation_icon.png"), component);
			bloodSurvivalIcon = new Sprite(loadImage("bloodysurvivalicon.png"), component);
			//rememberUsernameChecked = new Sprite(loadImage("checkedBox.png"), component);
			//rememberUsernameUnchecked = new Sprite(loadImage("uncheckedBox.png"), component);
			petIcon = new Sprite(loadImage("pet_icon.png"), component);
			bankIcon = new Sprite(loadImage("bank_icon.png"), component);
			eventIcon = new Sprite(loadImage("eventicon.png"), component);
			
			// Inferno:
			try {
				infernoTitlebox = getBasicImage("inferno-titlebox.png");
				infernoButton = getBasicImage("inferno-button.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class Items {
		
		public static void parseItemDef(int itemId, ItemDef def) {
			if (def == null) {
				return;
			}

			if(itemId == 21532) {
				def.name = "Fragments";
			}

			if (itemId == 5020) {
				def.stackable = 1;
				def.name = "Vote ticket";
				def.interfaceOptions[0] = "Redeem";
				def.interfaceOptions[1] = "Redeem-All";
				def.interfaceOptions[2] = "Redeem-X";
			}
			if (itemId == 13190) {
				def.name = "Credits";
				def.stackable = 1;
				def.op140 = -1;
				def.notedTemplate = -1;
				def.notedID = -1;
			} else if (itemId == 13191) {
				def.name = "Credit-only bond";
				def.stackable = 1;
				def.notedTemplate = -1;
				def.notedID = -1;
				def.inventoryModel = 29210;
				def.xan2d = 512;
				def.xof2d = 3;
				def.yof2d = 1;
				def.zoom2d = 2300;
				def.op140 = -1;
			} else if (itemId == 13189) {
				def.name = "Deadman pass";
				def.notedTemplate = -1;
				def.notedID = -1;
				def.inventoryModel = 29210;
				def.xan2d = 512;
				def.xof2d = 3;
				def.yof2d = 1;
				def.zoom2d = 2300;
				def.op140 = -1;
				def.interfaceOptions = new String[]{"Inspect", "Redeem", null, null, null};
				def.colorFind = new short[]{20416, 22451, 22181, 22449, 22305, 21435, 22464};
				def.colorReplace = new short[]{1984, 1971, 1701, 1969, 1825, 1979, 1984};
				def.stackable = 0;
			} else if (itemId == 6759) {
				def.name = "Boss casket";
				def.interfaceOptions = new String[]{"Open", null, null, null, null};
			}
			
			if (itemId == 6990) {
				ItemDef clone = ItemDef.loadItemDef(12020);
				clone(def, clone);
				def.name = "Dice Bag";
				def.interfaceOptions[0] = "Roll";
				def.interfaceOptions[1] = null;
				def.interfaceOptions[2] = null;
				def.interfaceOptions[3] = null;
				def.interfaceOptions[4] = null;
			}

			if(itemId == 1505) {
				def.name = "Obelisk destination scroll";
			}
			
			if (itemId == 21289 || itemId == 21287) { //Infernal Max and normal
				if (def.interfaceOptions[0] == null || (!def.interfaceOptions[0].equals("Fix"))) {
					def.interfaceOptions[0] = "Fix";
				}
			}
			
			// Broken items like Firecape (broken)
			for (int i = 20445; i < 20517; i += 2) {
				if (itemId == i) {
					if (def.interfaceOptions[0] == null || (def.interfaceOptions[0] != null &&
							!def.interfaceOptions[0].equals("Fix"))) {
						def.interfaceOptions[0] = "Fix";
					}
				}
			}
			for (int i = 20537; i < 20543; i += 2) {
				if (itemId == i) {
					if (def.interfaceOptions[0] == null || (def.interfaceOptions[0] != null &&
							!def.interfaceOptions[0].equals("Fix"))) {
						def.interfaceOptions[0] = "Fix";
					}
				}
			}
			
			if (itemId == 5520) {
				def.name = "Q&A Book";
			}
			
			if (itemId == 13438) {
				def.name = "3rd Age Mystery Box";
				def.interfaceOptions[0] = "Open";
				def.interfaceOptions[1] = null;
				def.interfaceOptions[2] = null;
				def.interfaceOptions[3] = null;
				def.interfaceOptions[4] = null;
			}
			
			if (itemId == 8148) {
				def.name = "Pet Box";
				def.interfaceOptions = new String[]{"Open", null, null, null, null};
			}
			
			if (itemId == 1857) {
				def.interfaceOptions = new String[5];
				def.interfaceOptions[0] = "0: Select";
				def.interfaceOptions[1] = "1: Equip";
				def.interfaceOptions[2] = "2: Op1";
				def.interfaceOptions[3] = "3: Op2";
				def.interfaceOptions[4] = "4: Drop";
				def.options = new String[5];
				def.options[0] = "action-0: ?";
				def.options[1] = "action-1: ?";
				def.options[2] = "action-2: pickup";
				def.options[3] = "action-3: lay";
				def.options[4] = "action-4: ?";
			}
			
			if (itemId == 717) {
				def.name = "Count's Clues";
			}
			
			if (itemId == 20766) {
				def.name = "Count's Key";
			}
			
			if (itemId == 3606 || itemId == 3608 || itemId == 7297) {
				ItemDef bloodyKey = ItemDef.loadItemDef(20526);
				
				switch (itemId) {
					case 3606:
						def.name = "Bloody key (easy)";
						break;
					case 3608:
						def.name = "Bloody key (medium)";
						break;
					case 7297:
						def.name = "Bloody key (hard)";
						break;
				}
				
				def.inventoryModel = bloodyKey.inventoryModel;
				def.xan2d = bloodyKey.xan2d;
				def.xof2d = bloodyKey.xof2d;
				def.yan2d = bloodyKey.yan2d;
				def.yof2d = bloodyKey.yof2d;
				def.zoom2d = bloodyKey.zoom2d;
			}
			
			if (itemId == 4670) {
				def.name = "Ruby of the Fallen";
				def.interfaceOptions = new String[]{"Gaze-into", null, null, null, null};
			}
			
			if (itemId == 6808) {
				def.name = "Scroll of Imbuement";
			}
			
			if (itemId == 7299 || itemId == 7302) {
				ItemDef bloodierKey = ItemDef.loadItemDef(20608);
				
				switch (itemId) {
					case 7299:
						def.name = "Bloody key (elite)";
						break;
					case 7302:
						def.name = "Bloody key (master)";
						break;
				}
				
				def.inventoryModel = bloodierKey.inventoryModel;
				def.xan2d = bloodierKey.xan2d;
				def.xof2d = bloodierKey.xof2d;
				def.yan2d = bloodierKey.yan2d;
				def.yof2d = bloodierKey.yof2d;
				def.zoom2d = bloodierKey.zoom2d;
				def.colorFind = bloodierKey.colorFind;
				def.colorReplace = bloodierKey.colorReplace;
			}
			
			if (itemId == 9717) {
				def.name = "The Blood Chest Vol.1";
			}
			
			if (itemId == 20900) { //troll partyhat
				ItemDef partyhatClone = ItemDef.loadItemDef(1042);
				def.name = partyhatClone.name;
				def.options = partyhatClone.options;
				def.inventoryModel = partyhatClone.inventoryModel;
				def.xan2d = partyhatClone.xan2d;
				def.yan2d = partyhatClone.yan2d;
				def.yof2d = partyhatClone.yof2d;
				def.xof2d = partyhatClone.xof2d;
				def.zoom2d = partyhatClone.zoom2d;
				def.colorFind = partyhatClone.colorFind;
				def.colorReplace = partyhatClone.colorReplace;
			}
			if (itemId == 20901) { //troll partyhat
				ItemDef partyhatClone = ItemDef.loadItemDef(1044);
				def.name = partyhatClone.name;
				def.options = partyhatClone.options;
				def.inventoryModel = partyhatClone.inventoryModel;
				def.xan2d = partyhatClone.xan2d;
				def.yan2d = partyhatClone.yan2d;
				def.yof2d = partyhatClone.yof2d;
				def.xof2d = partyhatClone.xof2d;
				def.zoom2d = partyhatClone.zoom2d;
				def.colorFind = partyhatClone.colorFind;
				def.colorReplace = partyhatClone.colorReplace;
			}
			if (itemId == 20902) { //troll partyhat
				ItemDef partyhatClone = ItemDef.loadItemDef(1046);
				def.name = partyhatClone.name;
				def.options = partyhatClone.options;
				def.inventoryModel = partyhatClone.inventoryModel;
				def.xan2d = partyhatClone.xan2d;
				def.yan2d = partyhatClone.yan2d;
				def.yof2d = partyhatClone.yof2d;
				def.xof2d = partyhatClone.xof2d;
				def.zoom2d = partyhatClone.zoom2d;
				def.colorFind = partyhatClone.colorFind;
				def.colorReplace = partyhatClone.colorReplace;
			}
			if (itemId == 20903) { //troll partyhat
				ItemDef partyhatClone = ItemDef.loadItemDef(1048);
				def.name = partyhatClone.name;
				def.options = partyhatClone.options;
				def.inventoryModel = partyhatClone.inventoryModel;
				def.xan2d = partyhatClone.xan2d;
				def.yan2d = partyhatClone.yan2d;
				def.yof2d = partyhatClone.yof2d;
				def.xof2d = partyhatClone.xof2d;
				def.zoom2d = partyhatClone.zoom2d;
				def.colorFind = partyhatClone.colorFind;
				def.colorReplace = partyhatClone.colorReplace;
			}
			
			if (itemId == 13215) {
				ItemDef platinumTokenClone = ItemDef.loadItemDef(13204);
				def.cost = platinumTokenClone.cost;
				def.femaleModel1 = platinumTokenClone.femaleModel1;
				def.femaleOffset = platinumTokenClone.femaleOffset;
				def.interfaceOptions = platinumTokenClone.interfaceOptions;
				def.inventoryModel = platinumTokenClone.inventoryModel;
				def.maleModel0 = platinumTokenClone.maleModel0;
				def.members = platinumTokenClone.members;
				def.name = "Bloody Token";
				def.stackable = platinumTokenClone.stackable;
				def.xan2d = platinumTokenClone.xan2d;
				def.yan2d = platinumTokenClone.yan2d;
				def.yof2d = platinumTokenClone.yof2d;
				def.zoom2d = platinumTokenClone.zoom2d;
				def.xof2d = platinumTokenClone.xof2d;
				def.zan2d = platinumTokenClone.zan2d;
				def.colorFind = new short[]{5813, 9139, 26006};
				def.colorReplace = new short[]{947, 948, 949};
				def.countCo = new int[]{2, 3, 4, 5, 0, 0, 0, 0, 0, 0};
				def.countObj = new int[]{13216, 13217, 13218, 13218, 0, 0, 0, 0, 0, 0};
			}
			
			if (itemId == 13216) {
				ItemDef platinumTokenClone = ItemDef.loadItemDef(3985);
				def.cost = platinumTokenClone.cost;
				def.femaleModel1 = platinumTokenClone.femaleModel1;
				def.name = "Bloody Token";
				def.femaleOffset = platinumTokenClone.femaleOffset;
				def.interfaceOptions = platinumTokenClone.interfaceOptions;
				def.inventoryModel = platinumTokenClone.inventoryModel;
				def.maleModel0 = platinumTokenClone.maleModel0;
				def.members = platinumTokenClone.members;
				def.stackable = platinumTokenClone.stackable;
				def.xan2d = platinumTokenClone.xan2d;
				def.yan2d = platinumTokenClone.yan2d;
				def.yof2d = platinumTokenClone.yof2d;
				def.zoom2d = platinumTokenClone.zoom2d;
				def.xof2d = platinumTokenClone.xof2d;
				def.zan2d = platinumTokenClone.zan2d;
				def.colorFind = new short[]{5813, 9139, 26006};
				def.colorReplace = new short[]{947, 948, 949};
			}
			
			if (itemId == 13217) {
				ItemDef platinumTokenClone = ItemDef.loadItemDef(3987);
				def.cost = platinumTokenClone.cost;
				def.femaleModel1 = platinumTokenClone.femaleModel1;
				def.name = "Bloody Token";
				def.femaleOffset = platinumTokenClone.femaleOffset;
				def.interfaceOptions = platinumTokenClone.interfaceOptions;
				def.inventoryModel = platinumTokenClone.inventoryModel;
				def.maleModel0 = platinumTokenClone.maleModel0;
				def.members = platinumTokenClone.members;
				def.stackable = platinumTokenClone.stackable;
				def.xan2d = platinumTokenClone.xan2d;
				def.yan2d = platinumTokenClone.yan2d;
				def.yof2d = platinumTokenClone.yof2d;
				def.zoom2d = platinumTokenClone.zoom2d;
				def.xof2d = platinumTokenClone.xof2d;
				def.zan2d = platinumTokenClone.zan2d;
				def.colorFind = new short[]{5813, 9139, 26006};
				def.colorReplace = new short[]{947, 948, 949};
			}
			
			if (itemId == 13218) {
				ItemDef platinumTokenClone = ItemDef.loadItemDef(3989);
				def.cost = platinumTokenClone.cost;
				def.femaleModel1 = platinumTokenClone.femaleModel1;
				def.femaleOffset = platinumTokenClone.femaleOffset;
				def.name = "Bloody Token";
				def.interfaceOptions = platinumTokenClone.interfaceOptions;
				def.inventoryModel = platinumTokenClone.inventoryModel;
				def.maleModel0 = platinumTokenClone.maleModel0;
				def.members = platinumTokenClone.members;
				def.stackable = platinumTokenClone.stackable;
				def.xan2d = platinumTokenClone.xan2d;
				def.yan2d = platinumTokenClone.yan2d;
				def.yof2d = platinumTokenClone.yof2d;
				def.zoom2d = platinumTokenClone.zoom2d;
				def.xof2d = platinumTokenClone.xof2d;
				def.zan2d = platinumTokenClone.zan2d;
				def.colorFind = new short[]{5813, 9139, 26006};
				def.colorReplace = new short[]{947, 948, 949};
			}

			if(itemId == 19566) {
				def.name = "Skotizo Key";
			}
		}
		
		private static void clone(ItemDef to, ItemDef src) {
			to.inventoryModel = src.inventoryModel;
			to.zoom2d = src.zoom2d;
			to.xan2d = src.xan2d;
			to.yan2d = src.yan2d;
			to.zan2d = src.zan2d;
			to.xof2d = src.xof2d;
			to.yof2d = src.yof2d;
			to.colorFind = src.colorFind;
			to.colorReplace = src.colorReplace;
			to.textureFind = src.textureFind;
			to.textureReplace = src.textureReplace;
			to.name = src.name;
			to.members = src.members;
			to.stackable = src.stackable;
			to.maleModel0 = src.maleModel0;
			to.maleModel1 = src.maleModel1;
			to.maleModel2 = src.maleModel2;
			to.femaleModel0 = src.femaleModel0;
			to.femaleModel1 = src.femaleModel1;
			to.femaleModel2 = src.femaleModel2;
			to.maleHeadModel = src.maleHeadModel;
			to.maleHeadModel2 = src.maleHeadModel2;
			to.femaleHeadModel = src.femaleHeadModel;
			to.femaleHeadModel2 = src.femaleHeadModel2;
			to.team = src.team;
			to.options = src.options;
			to.interfaceOptions = src.interfaceOptions;
			to.cost = 0;
		}
	}
	
	public static class Cs2 {
		
		public static void parseInst1112(int scriptId, String string, Widget widget) {
			if (string != null) {
				//if (string.contains("Quest"))
				//	System.out.println(string+" : "+widget.hashSplit());
				
				// When quest point varp is updated, make it say statistics instead of qp: X

				// Don't change the statistics (quest points: x) string after its set the first time
				/*if (string.equalsIgnoreCase("Statistics") && currentRealm == 2) {
					return;
				}
				if (scriptId == 1350 && !string.contains("Quests") && currentRealm != 1) {
					return;
				}*/
				
				if (string.equalsIgnoreCase("Members' Quests")) {
					//System.out.println(Player.currentRealm + ": " + scriptId);
					if (currentRealm == 2) { //PVP world
						widget.componentString = "<col=eb981f>Game Actions";
						GameClient.requestRedraw(widget);
						return;
					} else if (currentRealm == 3) { //OSRune
						return;
					}
				}
				
				if (string.equalsIgnoreCase("Free Quests")) {
					if (currentRealm == 2) { //PVP world
						widget.componentString = "<col=eb981f>Server Related";
						GameClient.requestRedraw(widget);
						return;
					} else if (currentRealm == 3) { //OSRune
						widget.componentString = "<col=eb981f>Server Related";
						GameClient.requestRedraw(widget);
						return;
					}
				}
				
				if (currentRealm == 2 && (scriptId == 184 || scriptId == 226 || scriptId == 177 || scriptId == 233)) { //GE
					widget.componentString = string.replace("coins", "BM").replace("coin", "BM");
					return;
				}
				
				if (!string.equals(widget.componentString)) {
					widget.componentString = string.replaceAll("RuneScape", "OS-Scape");
					GameClient.requestRedraw(widget);
				}
			}
		}
	}
	
	public static class Npcs {
		
		public static void parseNpcDef(int id, NpcDef def) {
			if (def == null) {
				return;
			}

			if (id == 7382) {
				def.name = "Blood Money Wares";
				setOption(def, "View Shop", 1);
			}
			
			if (id == 1306) {
				setOption(def, "Set skin", 2);
			}
			
			if (id == 6481) {
				setOption(def, "View Shop", 2);
			}
			
			if (id == 3008) {
				setOption(def, "Talk", 0);
				setOption(def, "Trade", 3);
			}
			if (id == 315) {
			    def.options[0] = null;
			    def.options[1] = null;
			    def.options[2] = null;
				setOption(def, "Toggle-Options", 3);
			}
			
			if (id == 3876) {
				def.name = "Exchange Employee";
			}
			
			if (id == 5169) {
				def.name = "Loyalty Point Shop";
				setOption(def, "Trade", 2);
			}
			
			if (id == 6773) {
				setOption(def, "Toggle settings", 2);
			}
			
			if (id == 2713) {
				def.name = "Credit Manager";
				def.options[0] = "View-shop";
				def.options[2] = "Buy-credits";
				def.options[3] = "Claim-credits";
			}

			if (id == 1815) {
				def.name = "Vote Manager";
				def.options[0] = "Rewards";
				def.options[2] = "Cast-votes";
				def.options[3] = "Claim-votes";
			}

			if(id == 3894) {
				def.options[0] = null;
				def.options[2] = "Sell-items";
				def.options[3] = "Wanted-items";
				def.options[4] = null;
			}

			if(id == 6481) {
				/* Mac */
				def.options[0] = "Buy-capes";
				def.options[2] = "Decant-potions";
				def.combatLevel = 0;
			}

			if(id == 535) {
				def.options[0] = "Repair-items";
				def.options[2] = "Upgrade-items";
				def.options[3] = "Crystal-enchanting";
			}

			if (id == 4398) {
				def.name = "OS-Scape Wizard";
				setOption(def, "Teleport", 1);
				setOption(def, "Previous", 2);
			}
			
			if (id == 4399) {
				def.name = "Varrock Wizard";
				setOption(def, "Previous", 2);
			}
			
			if (id == 4802) {
				def.name = "Cosmetics Wares";
				setOption(def, "View Shop", 0);
			}

			if (id == 4003) {
				def.name = "Crystal Seed";
				def.options[0] = "Exchange";
			}

			if(id == 5449) {
				def.name = "Bob";
				def.options[0] = "Decant Potions";
				def.options[1] = null;
				def.options[2] = null;
				def.options[3] = null;
			}

			if(id == 3343) {
				def.name = "OS-Scape Nurse";
				def.options[0] = "Heal";
				def.options[1] = null;
				def.options[2] = null;
			}

			if (id == 503) {
				def.name = "Bart";
				def.options[0] = "Claim-refunds";
				def.options[1] = null;
				def.options[2] = null;
			}
			
			if (id == 913) {
				clone(def, class270.loadNpcDef(1676));
				def.combatLevel = 0;
				def.name = "Barrows Wares";
				setOption(def, "View Shop", 0);
				setOption(def, "Repair Barrows", 2);
			}
			
			if (id == 4718) {
				def.name = "Transportation Guide";
				def.options[3] = "Transport";
			}
			
			if (id == 4921) {
				def.combatLevel = 0;
				def.name = "Consumable Wares";
				setOption(def, "View Shop", 0);
			}
			
			if (id == 5523) {
				def.name = "Jewellery Wares";
				setOption(def, "View Shop", 0);
			}
			
			if (id == 1305) {
				def.name = "Cosmetic Wares";
				setOption(def, "View Shop", 0);
			}
			
			if (id == 7456) {
				def.name = "Untradable Wares";
				setOption(def, "View Shop", 0);
				setOption(def, null, 2);
			}
			
			if (id == 2995) {
				def.name = "Range Wares";
				setOption(def, "View Shop", 0);
				setOption(def, null, 2);
			}
			
			if (id == 7477) {
				def.name = "Melee Wares";
				def.combatLevel = 0;
				setOption(def, "View Shop", 0);
			}
			
			if (id == 7042) {
				def.name = "Magic Wares";
				setOption(def, "View Shop", 0);
			}
			
			if (id == 4400) {
				def.name = "Lumbridge Wizard";
				setOption(def, "Previous", 2);
			}
			
			if (id == 2462) {
				def.name = "Shanomi";
				setOption(def, "Trade", 2);
			}
			
			if (id == 7707) {
				def.walkAnimation = def.idleAnimation;
				def.turn90CCAnimation = def.idleAnimation;
				def.turn90CWAnimation = def.idleAnimation;
				def.turn180Animation = def.idleAnimation;
			}
			
			if (id == 2643) {
				setOption(def, "op0", 0);
				setOption(def, "op1 aka attack", 1);
				setOption(def, "op2", 2);
				setOption(def, "op3", 3);
				setOption(def, "op4", 4);
			}
			if (id == 508 || id == 509 || id == 514 || id == 515) {
				setOption(def, "General store", 2);
				setOption(def, "Supplies", 3);
			}
			
			if (id == 4159) {
				def.name = "Wizard";
				setOption(def, "Teleport", 0);
				setOption(def, "Teleport-previous", 2);
			}
			
			if (id == 4293) {
				def.name = "Supplies Shop";
				setOption(def, "Shop 1", 0);
				setOption(def, null, 2);
				setOption(def, null, 3);
				setOption(def, null, 4);
			}
			
			if (id == 4295) {
				def.name = "Gear";
				setOption(def, "Magic", 0);
				setOption(def, "Range", 2);
				setOption(def, "Melee", 3);
			}
			
			if (id == 2200) { // Richard
				def.name = "Team capes";
				setOption(def, "View Shop", 0);
				setOption(def, null, 2);
			}
			
			if (id == 276) { // Crier
				def.name = "OS-Scape Guide";
				setOption(def, "View Help", 0);
				setOption(def, "Latest Updates", 2);
			}
			
			if (id == 4398) {
				def.name = "Edgeville Wizard";
				setOption(def, "Teleport", 1);
				setOption(def, "Previous", 2);
			}
			
			if (id == 5156) {
				def.name = "Donation Manager";
				setOption(def, "Talk-to", 0);
				setOption(def, "Teleports", 1);
				setOption(def, "Online Store", 2);
				setOption(def, "Donation Tiers", 3);
			}
			
			if (id == 560) {
				setOption(def, "Trade", 2);
			}
			
			if (id == 1787) {
				def.name = "PvP Wizard";
				setOption(def, "Talk-to", 0);
				setOption(def, "Edgeville", 2);
				setOption(def, "Canifis", 3);
				setOption(def, "Varrock", 4);
			}
			
			if (id == 6904) {
				def.name = "Shop";
				def.combatLevel = 0;
				setOption(def, "Melee Weapon", 0);
				setOption(def, "Melee Armor", 2);
			}
			
			if (id == 7690) {
				setOption(def, "View Leaderboard", 3);
			}
			
			if (id == 6906) {
				def.name = "Shop";
				def.combatLevel = 0;
				setOption(def, "Range Weapon", 0);
				setOption(def, "Range Armor", 2);
				setOption(def, "Range Ammo", 3);
			}
			
			if (id == 6908) {
				def.name = "Shop";
				def.combatLevel = 0;
				setOption(def, "Magic Weapon", 0);
				setOption(def, "Magic Robe", 2);
				setOption(def, "Rune", 3);
				setOption(def, "Teleport", 4);
			}
			
			if (id == 3481) {
				def.name = "Count";
				def.combatLevel = 0;
				//def.opcode112 = 3481;
				setOption(def, null, 1);
				setOption(def, "Talk-to", 0);
				
				setOption(def, "Answer Riddle", 2);
			}
			
			if (id == 3461) {
				def.name = "Count's Assistant";
				setOption(def, "Talk-to", 0);
			}
			
			if (id == 3359) {
				def.name = "Zombie Priest";
				setOption(def, null, 1);
				def.combatLevel = 0;
			}
			
			if (id == 3310) {
				def.name = "Lottery Advisor";
				setOption(def, "Deposit", 2);
				setOption(def, "Withdraw", 3);
				setOption(def, "Claim", 4);
			}
			
			if (id == 2668) {
				setOption(def, null, 2);
				setOption(def, null, 3);
				setOption(def, null, 4);
			}

			if(id == 5906) {
				def.name = "Pet Manager";
			}

			if(id == 1120) {
				def.name = "Event Manager";
				def.options[2] = "Join";
			}

			if(id == 5442) {
				def.name = "Security Advisor";
			}

			if(id == 7316) {
				def.name = "Tournament Manager";
				def.options[0] = "Join";
				def.options[2] = "Information";
			}
		}
		
		private static void clone(NpcDef from, NpcDef to) {
			from.idleAnimation = to.idleAnimation;
			from.bool59 = to.bool59;
			from.intArray106 = to.intArray106;
			from.size = to.size;
			from.intArray104 = to.intArray104;
			from.intArray105 = to.intArray105;
			from.shortArray2 = to.shortArray2;
			from.shortArray3 = to.shortArray3;
			from.shortArray4 = to.shortArray4;
			from.shortArray5 = to.shortArray5;
		}
		
		private static void setOption(NpcDef def, String string, int idx) {
			def.options[idx] = string;
		}
		
		public static void setEmbledOptionsForRealm(int current_realm, NpcDef emblemTrader) {
			if (emblemTrader != null) {
				emblemTrader.name = "Trader";
				emblemTrader.options = new String[]{null, null, current_realm == 3 ? "Trade" : null, "Toggleable-options", "Skull"};
			}
		}
	}
	
	public static class Interfaces {
		
		public static String INTER_310_TITLE_STRING = "Os-Scape Bestiary - Loot Table Lookup";
		
		public static void updateMappedContainer(int scriptId, Item[] stock) {
			RuneScriptMap script = Stream.loadRuneScriptMap(scriptId);
			
			script.csMapValueCount = stock.length;
			script.csMapKeysValues = new int[stock.length];
			script.csMapIntValues = new int[stock.length];
			
			for (int i = 0; i < stock.length; i++) {
				script.csMapKeysValues[i] = i;
				script.csMapIntValues[i] = stock[i].id;
			}
		}
	}
	
	public static class Objects {
		
		private static int[] bankChests = {6944, 7409, 4483, 11744, 11748, 24101, 24347, 25808, 26707, 27249, 27251,
				27264, 27253, 27291, 18491, 21301, 10058, 6943, 27718, 27719, 27720, 27721, 7478, 10060, 14886, 10562,
				28861};
		
		public static void parseObjDef(int id, ObjectDef def) {
			if (def == null) {
				return;
			}
			if (id == 7811) {
				def.name = "Blood Money Supplies";
				def.options[2] = null;
			}
			
			if (id == 13212 || id == 13213) {
				def.options[4] = null;
			}
			if (id == 29149) {
				setAncientsAltarOptions(currentRealm, def);
			}

			if(id == 26645) {
				def.name = "Fun PVP Portal";
			}

			if(id == 23709) {
				def.options[0] = "Use";
			}

			if(id == 26714) {
				def.options[0] = null;
				def.options[1] = null;
				def.options[2] = null;
				def.options[3] = null;
			}

			if(id == 18258) {
				def.options[0] = "Pray-at";
				def.options[1] = "Spellbook";
			}

			if (id == 24452) {
				def.options[1] = null;
			}
			
			if (id == 29150) {
				def.options[0] = "Pray at";
				def.options[1] = "Switch-ancient";
				def.options[2] = "Switch-lunar";
				def.options[3] = "Switch-normal";
				def.options[4] = null;
			}

			if (id == 29165) {
				def.name = "Pile Of Coins";
				def.options[0] = null;
				def.options[1] = null;
				def.options[2] = null;
				def.options[3] = null;
				def.options[4] = null;
			}

			if(id == 14845) {
				def.name = "PVP Instance Portal";
			}
			
			if (id == 14986) {
				def.name = "Bloody Key Chest";
				
				ObjectDef deadmanChest = class110.getObjectDef(27269);
				
				def.models = deadmanChest.models;
				def.recolorToFind = deadmanChest.recolorToFind;
				def.options = deadmanChest.options;
				def.recolorToReplace = deadmanChest.recolorToReplace;
			}

			if(id == 12120) {
				def.name = "Boss Key Chest";
			}

			if(id == 7811) {
				def.options[1] = null;
			}

			if(id == 26073) {
				def.options[0] = "Read";
			}
			
			//Remove the collect option (until we add GE)
			for (int i : bankChests) {
				if (id == i) {
					def.options[2] = null;
				}
			}

			if(id == 11508 || id == 11509) {
				def.clipType = 0;
			}

			if(id == 12309) {
				def.name = "Loyalty Chest";
				def.options[0] = "Open";
				def.options[1] = "Information";
				def.options[2] = null;
				def.options[3] = null;
				def.options[4] = null;
			}

			if(id == 29226) {
				def.name = "Pet list";
				def.options[4] = null;
			}

			if(id == 28925) {
				def.name = "Safe PVP Portal";
			}

			if(id == 6882) {
				def.name = "Crushed spears";
			}

			if(id == 29087) {
				def.name = "Tournament rewards";
				def.options[0] = "Collect";
			}

			if(id == 31846) {
				def.name = "Tournament board";
				def.options[0] = "View-schedule";
				def.options[1] = "View-hiscores";
			}

			if(id == 26747) {
				def.name = "Tournament orb";
			}
		}
		
		public static void setAncientsAltarOptions(int current_realm, ObjectDef ancientAltar) {
			if (current_realm == 3) { // OSR
				if (ancientAltar != null) {
					ancientAltar.options = new String[]{"Ancients", "Lunar", "Modern", "Arceuus", null};
				}
			} else if (current_realm == 2) { // PVP
				if (ancientAltar != null) {
					ancientAltar.options = new String[]{"Pray-at", "Ancients", "Lunar", "Modern", null};
				}
			} else if (current_realm == 1) {
				if (ancientAltar != null) {
					ancientAltar.options = new String[]{"Pray-at", null, null, null, null}; // Default
				}
			}
		}
		
	}
	
	public static class Packets {
		
		public static void loadPacketSizes(int[] packetSizes) {
			packetSizes[253] = 2;
			packetSizes[8] = 5;
		}
		
	}
	
	public static final byte[] loadImage(String f) {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] buf = new byte[20000];
			int x;
			InputStream resourceAsStream = Loader.class.getResourceAsStream("/" + f);
			while ((x = resourceAsStream.read(buf)) > 0) {
				byteArrayOutputStream.write(buf, 0, x);
			}
			resourceAsStream.close();
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			System.err.println("Error loading image: " + f);
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static PaletteSprite getBasicImage(String path) throws IOException {
		PaletteSprite sprite = new PaletteSprite();

		//System.out.printf("Loading image %s...\n", path);
		BufferedImage image = ImageIO.read(Loader.class.getResourceAsStream("/" + path));
		
		// Translate the image like a full downs moron
		sprite.width = sprite.width1 = image.getWidth();
		sprite.height = sprite.height1 = image.getHeight();
		sprite.offX = sprite.offY = 0; // Maybe support custom offset?
		
		int[] rgbArray = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), rgbArray, 0, image.getWidth());
		sprite.pixels = new byte[image.getWidth() * image.getHeight()];
		sprite.palette = new int[255];
		
		// Put black empty pixel
		int paletteIndex = 0;
		sprite.palette[paletteIndex++] = 1;
		
		for (int pixel = 0; pixel < sprite.pixels.length; pixel++) {
			int rgb = rgbArray[pixel] & 0xFFFFFF;
			
			// 0xFF00FF = empty
			if (rgb == 0xFF00FF) {
				sprite.pixels[pixel] = (byte) 0;
				continue;
			}
			
			// Find pixel index or add new pixel
			int find = pixelIndex(sprite.palette, paletteIndex, rgb);
			if (find == -1) {
				find = paletteIndex;
				sprite.palette[paletteIndex++] = rgb;
			}
			
			sprite.pixels[pixel] = (byte) find;
		}
		
		return sprite;
	}
	
	private static final int pixelIndex(int[] dest, int max, int pixel) {
		for (int i = 0; i < max; i++) {
			if (dest[i] == pixel)
				return i;
		}
		return -1;
	}
	
	public static void cleanLogFiles() {
		try {
			// Delete large error logs
			File log = new File(System.getProperty("user.home") + File.separatorChar + ".osscape" + File.separatorChar + "error-log.txt");
			if (log.exists()) {
				if (log.length() > 50000) { // That's a fat log.
					log.delete();
					System.out.println("Deleted large error log.");
				}
			}
		} catch (Exception e) {
			// silent
		}
	}
	
	public static int DRAG_THRESHOLD = 15;
	
	public static String usernameSlotOne, usernameSlotTwo, usernameSlotThree;
	public static String passwordSlotOne, passwordSlotTwo, passwordSlotThree;
	
	public static File DRAG_VALUE_USERHOME_ROOT = new File(System.getProperty("user.home") + "/oss-drag-value.txt");
	public static File REMEMBER_ME_USERHOME_ROOT = new File(System.getProperty("user.home") + "/remember-me-username.txt");
	public static File DRAG_VALUE_USERHOME_OSSFOLDER = new File(System.getProperty("user.home") + "/.osscape/oss-drag-value.txt");
	
	//Saved account information
	public static File SAVED_ACCOUNT_SLOT_ONE = new File(System.getProperty("user.home") + "/.osscape/saved-account-one.txt");
	public static File SAVED_ACCOUNT_SLOT_TWO = new File(System.getProperty("user.home") + "/.osscape/saved-account-two.txt");
	public static File SAVED_ACCOUNT_SLOT_THREE = new File(System.getProperty("user.home") + "/.osscape/saved-account-three.txt");
	
	public static void readDrag() {
		if (DRAG_VALUE_USERHOME_ROOT.exists()) {
			int drag = readDrag(DRAG_VALUE_USERHOME_ROOT);
			DRAG_THRESHOLD = drag;
			DRAG_VALUE_USERHOME_ROOT.delete(); // remove old in userhome
			writeDrag();
		} else if (DRAG_VALUE_USERHOME_OSSFOLDER.exists()) {
			DRAG_THRESHOLD = readDrag(DRAG_VALUE_USERHOME_OSSFOLDER);
		}
		
		if (REMEMBER_ME_USERHOME_ROOT.exists()) {
			try {
				String user = new Scanner(REMEMBER_ME_USERHOME_ROOT).nextLine().trim();
				if (!user.isEmpty()) {
					rememberedUsername = user;
					rememberUsername = true;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		if (SAVED_ACCOUNT_SLOT_ONE.exists()) {
			try (Scanner scanner = new Scanner(SAVED_ACCOUNT_SLOT_ONE)) {
				String line = scanner.nextLine();
				if (!line.isEmpty() && line.length() > 1) {
					String username = line.split(":")[0];
					String password = line.split(":")[1];
					
					if (!username.isEmpty() && !password.isEmpty()) {
						usernameSlotOne = username;
						passwordSlotOne = password;
						accountSlotOneSaved = true;
					}
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeRememberedUsername(String name) {
		if (name == null)
			name = "";
		
		try {
			FileOutputStream fos = new FileOutputStream(REMEMBER_ME_USERHOME_ROOT);
			fos.write((name + "\n").getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeSavedAccountUsername(String name, String password, int slot) {
		if (name == null)
			name = "";
		
		if (password == null)
			password = "";
		
		try {
			switch (slot) {
				case 1:
					FileOutputStream fos = new FileOutputStream(SAVED_ACCOUNT_SLOT_ONE);
					fos.write((name + ":" + password + "\n").getBytes());
					fos.close();
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static final String CACHEDIR = System.getProperty("user.home") + "/.osscape/";
	
	public static int readDrag(File f) {
		if (f.exists()) {
			try {
				Scanner s = new Scanner(f);
				int drag = Integer.parseInt(s.nextLine());
				s.close();
				return drag;
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
			}
		}
		return 15; // drag default is 15
	}
	
	public static void writeDrag() {
		try {
			if (!DRAG_VALUE_USERHOME_OSSFOLDER.exists()) {
				DRAG_VALUE_USERHOME_OSSFOLDER.createNewFile();
			}
			FileWriter w = new FileWriter(DRAG_VALUE_USERHOME_OSSFOLDER);
			w.write(String.valueOf(DRAG_THRESHOLD));
			w.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	public static void trackLaunch() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					String ip = new Scanner(new URL("https://api.ipify.org/").openStream()).nextLine();
					String data = String.format("{\"event\":\"Client Open\",\"properties\": {\"distinct_id\": \"%s\",\"token\":\"ccc011913e257ca482f497ffc08020d6\"}}", ip);
					byte[] encode = Base64.encode(data.getBytes(), Base64.NO_WRAP);
					URL url = new URL("http://api.mixpanel.com/track/?data=" + new String(encode));
					url.openStream().read();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public static File getErrorLog() {
		String home = class18.userhomeDirectory;
		if (home.length() < 1)
			home = System.getProperty("user.home");
		File log = new File(home + File.separatorChar + ".osscape" + File.separatorChar + "error-log.txt");
		if (!new File(log.getParent()).exists()) {
			new File(log.getParent()).mkdirs();
		}
		if (!log.exists()) {
			try {
				log.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return log;
	}
	
	public static void logException(Throwable e) {
		try {
			// Convert to single str
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			
			// Get error log writer
			BufferedWriter writer = new BufferedWriter(new FileWriter(getErrorLog(), true));
			writer.newLine();
			writeTimestamp(writer);
			writer.newLine();
			writer.write(exceptionAsString);
			writer.newLine();
			writer.flush();
			writer.close();
			System.err.printf("Captured error! Please report this! Located at %s%n", getErrorLog().getAbsolutePath());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private static void writeTimestamp(BufferedWriter writer) throws IOException {
		writer.write(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
	}
	
	public static void logExceptionText(String msg) {
		try {
			// Get error log writer
			BufferedWriter writer = new BufferedWriter(new FileWriter(getErrorLog(), true));
			writer.newLine();
			writeTimestamp(writer);
			writer.newLine();
			writer.write(msg);
			writer.newLine();
			writer.flush();
			writer.close();
			System.err.printf("Captured error! Please report this! Located at %s%n", getErrorLog().getAbsolutePath());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private static void reportJavaVersion() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					boolean hasJFX = false;
					try {
						Class.forName("javafx.scene.Scene").getDeclaredMethods();
						Class.forName("javafx.application.Application").getDeclaredMethods();
						hasJFX = true;
					} catch (Throwable e) {
						e.printStackTrace();
					}
					
					String base = "http://pvp.os-scape.com/javaversion.php?javafx_present=" + hasJFX + "&java_version="
							+ URLEncoder.encode(String.valueOf(System.getProperty("java.version")));
					
					new URL(base).openConnection().getInputStream().close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}
	
	public static byte[] sha(String data) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(data.getBytes());
			return md.digest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String hwid() {
		try {
			return Hardware4Win.getSerialNumber();
		} catch (Exception e) {
		}
		try {
			return Hardware4Mac.getSerialNumber();
		} catch (Exception e) {
		}
		try {
			return Hardware4Nix.getSerialNumber();
		} catch (Exception e) {
		}
		return "";
	}
	
	private static String macAddress = null;
	
	public static String getMacAddress() {
		if (macAddress != null) {
			return macAddress;
		}
		
		try {
			for (NetworkInterface interface_ : Collections.list(NetworkInterface.getNetworkInterfaces())) {
				if (interface_.isLoopback() || !interface_.isUp())
					continue;
				
				for (InetAddress address : Collections.list(interface_.getInetAddresses())) {
					if (!address.isReachable(3000))
						continue;
					
					try (SocketChannel socket = SocketChannel.open()) {
						socket.socket().setSoTimeout(3000);
						socket.socket().setReuseAddress(true);
						
						socket.bind(new InetSocketAddress(address, 0));
						
						socket.connect(new InetSocketAddress("google.com", 80));
					} catch (IOException ex) {
						continue;
					}
					
					byte[] macAddressBytes = interface_.getHardwareAddress();
					StringBuilder macAddressBuilder = new StringBuilder();
					for (int macAddressByteIndex = 0; macAddressByteIndex < macAddressBytes.length; macAddressByteIndex++) {
						String macAddressHexByte = String.format("%02X", macAddressBytes[macAddressByteIndex]);
						macAddressBuilder.append(macAddressHexByte);
						
						if (macAddressByteIndex != macAddressBytes.length - 1) {
							macAddressBuilder.append(":");
						}
					}
					macAddress = macAddressBuilder.toString();
					return macAddress;
				}
			}
		} catch (Exception e) {
		}
		return "";
	}
	
	private static class Hardware4Mac {
		
		private static String sn = null;
		
		public static final String getSerialNumber() {
			
			if (sn != null) {
				return sn;
			}
			
			OutputStream os = null;
			InputStream is = null;
			
			Runtime runtime = Runtime.getRuntime();
			Process process = null;
			try {
				process = runtime.exec(new String[]{"/usr/sbin/system_profiler", "SPHardwareDataType"});
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			os = process.getOutputStream();
			is = process.getInputStream();
			
			try {
				os.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			String marker = "Serial Number";
			try {
				while ((line = br.readLine()) != null) {
					if (line.contains(marker)) {
						sn = line.split(":")[1].trim();
						break;
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			
			if (sn == null) {
				throw new RuntimeException();
			}
			
			return sn;
		}
	}
	
	private static class Hardware4Nix {
		
		private static String sn = null;
		
		public static final String getSerialNumber() {
			
			if (sn == null) {
				readDmidecode();
			}
			if (sn == null) {
				readLshal();
			}
			if (sn == null) {
				throw new RuntimeException();
			}
			
			return sn;
		}
		
		private static BufferedReader read(String command) {
			
			OutputStream os = null;
			InputStream is = null;
			
			Runtime runtime = Runtime.getRuntime();
			Process process = null;
			try {
				process = runtime.exec(command.split(" "));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			os = process.getOutputStream();
			is = process.getInputStream();
			
			try {
				os.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return new BufferedReader(new InputStreamReader(is));
		}
		
		private static void readDmidecode() {
			
			String line = null;
			String marker = "Serial Number:";
			BufferedReader br = null;
			
			try {
				br = read("dmidecode -t system");
				while ((line = br.readLine()) != null) {
					if (line.indexOf(marker) != -1) {
						sn = line.split(marker)[1].trim();
						break;
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		
		private static void readLshal() {
			
			String line = null;
			String marker = "system.hardware.serial =";
			BufferedReader br = null;
			
			try {
				br = read("lshal");
				while ((line = br.readLine()) != null) {
					if (line.indexOf(marker) != -1) {
						sn = line.split(marker)[1].replaceAll("\\(string\\)|(\\')", "").trim();
						break;
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
	}
	
	private static class Hardware4Win {
		
		private static String sn = null;
		
		public static final String getSerialNumber() {
			
			if (sn != null) {
				return sn;
			}
			
			OutputStream os = null;
			InputStream is = null;
			
			Runtime runtime = Runtime.getRuntime();
			Process process = null;
			try {
				process = runtime.exec(new String[]{"wmic", "bios", "get", "serialnumber"});
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			os = process.getOutputStream();
			is = process.getInputStream();
			
			try {
				os.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			Scanner sc = new Scanner(is);
			try {
				while (sc.hasNext()) {
					String next = sc.next();
					if ("SerialNumber".equals(next)) {
						sn = sc.next().trim();
						break;
					}
				}
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			
			if (sn == null) {
				throw new RuntimeException();
			}
			
			return sn;
		}
	}

	public static String formatTimer(long millis) {
		String formatted = "";

		int minutes = (int) millis / 1000 / 60;
		int seconds = (int) millis / 1000 % 60;
		if (minutes > 0) {
			if (minutes >= 10) {
				formatted += minutes +":";
			} else {
				formatted += "0"+ minutes +":";
			}
		} else {
			formatted += "00:";
		}
		if (seconds > 0) {
			if (seconds >= 10) {
				formatted += seconds;
			} else {
				formatted += "0"+ seconds;
			}
		} else {
			formatted += "00";
		}

		return formatted;
	}
	
}

