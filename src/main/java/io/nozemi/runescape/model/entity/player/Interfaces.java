package io.nozemi.runescape.model.entity.player;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.command.*;
import io.nozemi.runescape.util.Int2IntArrayMapOSS;
import io.nozemi.runescape.util.SettingsBuilder;
import io.nozemi.runescape.util.Varbit;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class Interfaces {
	
	// Links them all up
	public static final int LOGIN_PROMPT_PANE = 165;
	
	// Specific display modes
	public static final int PANE_FIXED = 548;
	public static final int PANE_RESIZABLE_NORM = 161;
	public static final int PANE_RESIZABLE_LIST = 164;
	
	private Player player;
	private Int2IntArrayMapOSS visible = new Int2IntArrayMapOSS();
	private int activeRoot;
	private boolean resizable;
	
	public Interfaces(Player player) {
		this.player = player;
	}
	
	public void resizable(boolean b) {
		resizable = b;
	}
	
	public boolean resizable() {
		return resizable;
	}
	
	// Sends the interswitch packet to go from either (1) fixed (2) resize mode ONE (3) resize mode TWO to any other the others.
	// TODO add support for 165 to anything (login prompt screen)
	public void sendForMode(int fromMode, int toMode) {
		boolean fromFixed = fromMode == 0;
		boolean fromResize1 = fromMode == 1;
		boolean fromResize2 = fromMode == 2;
		boolean fromLoginPrompt = fromMode == 3;
		boolean toFixed = toMode == 0;
		boolean toResize1 = toMode == 1;
		boolean toResize2 = toMode == 2;
		boolean toLoginPrompt = toMode == 3;
		
		int fromId = fromLoginPrompt ? LOGIN_PROMPT_PANE : fromFixed ? PANE_FIXED : fromResize2 ? PANE_RESIZABLE_LIST : PANE_RESIZABLE_NORM;
		int toPane = toLoginPrompt ? LOGIN_PROMPT_PANE : toFixed ? PANE_FIXED : toResize2 ? PANE_RESIZABLE_LIST : PANE_RESIZABLE_NORM;
		sendRoot(toPane);
		
		for (InterSwitches is : InterSwitches.values()) {
			int fromChild = fromLoginPrompt ? is.loginPromptChild : fromFixed ? is.fixed : fromResize2 ? is.resizeFlatTabs : is.resizeSquareTabs;
			int toChild = toLoginPrompt ? is.loginPromptChild : toFixed ? is.fixed : toResize2 ? is.resizeFlatTabs : is.resizeSquareTabs;
			
			player.write(new InterfaceSwitch(fromId, fromChild, toPane, toChild));
			
			// Now, cleverly update the new parents for these widgets.
			int active = visible.remove((fromId << 16) | fromChild);
			visible.put((toPane << 16) | toChild, active);
			//player.debug("%d,%d -> %d,%d (%s)", fromId, fromChild, toPane, toChild, active);
			
		}
		setInterfaceSettings();
	}
	
	// Hold off on using this. Tabs won't even be interactable if you close EVERYTHING.
	// If you do ever want this functionality (unlikely) make sure to either skip or re-send essentials like tabs.
	public void closeAll() {
		// No questions, this is because of concurrent modification on the visible map.
		Integer[] keys = visible.keySet().stream().toArray(Integer[]::new);
		for (int k : keys) {
			close(k >> 16, k & 0xFFFF);
		}
	}
	
	public int whereIs(int id) {
		return visible.getKeyForValue(id);
	}
	
	// Tab ids
	public static final int ATTACKSTYLE_TAB = 593;
	public static final int SKILL_TAB = 320;
	public static final int QUEST_TAB = 259;
	public static final int INVENTORY_TAB = 149;
	public static final int EQUIPMENT_TAB = 387;
	public static final int PRAYER_TAB = 271;
	public static final int MAGIC_TAB = 218;
	public static final int LOGOUT_TAB = 182;
	public static final int SETTINGS_TAB = 261;
	public static final int CLANCHAT_TAB = 7;
	public static final int EMOTES_TAB = 216;
	public static final int MUSIC_TAB = 239;
	public static final int FRIENDS_TAB = 429;
	public static final int IGNORES_TAB = 432;
	public static final int LOBBY_PROMPT_TAB = 378;
	
	public static final int DISPLAYNAME_CHANGE_INTER = 589;
	
	// Specific tab ids
	public static final int CHATBOX = 162;
	public static final int MINIMAP_ORBS = 160;
	public static final int BLACK_SCREEN = 50;
	public static final int USERNAME_NOT_SURE = 163;
	public static final int XPCOUNTER = 122;
	
	// General interfaces
	public static final int SKULL = 90;
	
	public enum InterSwitches {
		// Yes, these are ablphabetically ordered to save time writing it down.
		// Ask Jak for a detailed dump of interfaces sent on login as of rev 119 and 120 (29/8/16)
		// Note: the ones with no links (total 6) are sent on real login, when 165 prompt continue is clicked. These are things like main, inventory, barrows overlay, cw overlay, chatbox.
		// Note 2 - 165 childs with no link to other modes default to solid (non clickthrough)
		CHATBOX(24, 29, 31, 1, 162, true), // Chatbox
		MAIN(21, 13, 13, 6, -1, false), // NO PRIMARY LINK. where 'MAIN' interfaces are sent
		C(14, 3, 3, 2, -1, true), // NO PRIMARY LINK. used on the #ironWinch.
		D(16, 6, 6, 3, -1, true), // NO PRIMARY LINK. where clanwars safe portal 'step north to fight' overlay goes. Corp overlay. Gwd KC inter.
		INVENTORY_INTER(64, 66, 64, 7, -1, false), // NO PRIMARY LINK. where 'inventory' interfaces are sent.
		COMBAT_TAB(66, 68, 66, 8, 593, true), // attack - appears out of order on login dump
		SKILLS_TAB(67, 69, 67, 9, 320, true), // skills
		QUEST_TAB(68, 70, 68, 10, 259, true), // quest
		INVENTORY_TAB(69, 71, 69, 11, 149, true), // inv
		EQUIPMENT_TAB(70, 72, 70, 12, 387, true), // equipment
		PRAYER_TAB(71, 73, 71, 13, 541, true), // prayer
		MAGIC_TAB(72, 74, 72, 14, 218, true), // magic
		CLAN_CHAT_TAB(73, 75, 73, 15, 7, true), // clanchat clan chat - appears out of order in login dump
		FRIENDS_TAB(74, 76, 74, 16, 429, true), // friends
		IGNORES_TAB(75, 77, 75, 17, 432, true), // ignores
		LOGOUT_TAB(76, 78, 76, 18, 182, true), // logout
		SETTINGS_TAB(77, 79, 77, 19, 261, true), // settings
		EMOTES_TAB(78, 80, 78, 20, 216, true), // emotes
		MUSIC_TAB(79, 81, 79, 21, 239, true), // music
		T(15, 4, 4, 22, -1, true), // NO PRIMARY LINK. where 'barrows' component is sent. Also the Wilderness Skull/Level! Deadman skulls.
		U(19, 9, 9, 23, 163, true), // username
		ORBS(11, 28, 28, 24, 160, true), // orbs
		XP_DROP(17, 7, 7, 4, 122, true), // xp drops
		X(18, 8, 8, 5, -1, false), // NO PRIMARY LINK. used in #IronWinch
		WORLD_MAP(22, 14, 14, 28, -1, false), // World map?
		;
		
		// The child ID assosiated with each game pane. Fixed, both resize modes, and the login prompt (165) previously called root/swap root/lobby (wrongly named)
		public int fixed, resizeSquareTabs, resizeFlatTabs, loginPromptChild, primaryWidget;
		public boolean clickthrough;
		
		InterSwitches(int fixedModeChild, int resizeSquareTabs, int resizeFlatTabs, int loginPrompt, int widget, boolean clickthrough) {
			this.fixed = fixedModeChild;
			this.resizeSquareTabs = resizeSquareTabs;
			this.resizeFlatTabs = resizeFlatTabs;
			this.loginPromptChild = loginPrompt;
			this.primaryWidget = widget;
			this.clickthrough = clickthrough;
		}
		
		// Finds the interswitch which is assosiated with a key widget id - such as tabs (inventory, prayer etc)
		public static InterSwitches forWidget(int i) {
			for (InterSwitches is : InterSwitches.values()) {
				if (is.primaryWidget == i) {
					return is;
				}
			}
			return null;
		}
	}
	
	// Sends a given widget onto the correct pane|childid - supports any display mode (fixed, both resizeables)
	public void sendWidgetOn(int interfaceId, InterSwitches position) {
		if (position == null) return;
		int toPane = !resizable ? PANE_FIXED : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? PANE_RESIZABLE_NORM : PANE_RESIZABLE_LIST;
		int toChild = !resizable ? position.fixed : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? position.resizeSquareTabs : position.resizeFlatTabs;
		send(interfaceId, toPane, toChild, position.clickthrough);
	}
	
	public void sendDefaultInterlink(InterSwitches es) {
		if (es == null) return;
		int toPane = !resizable ? PANE_FIXED : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? PANE_RESIZABLE_NORM : PANE_RESIZABLE_LIST;
		int toChild = !resizable ? es.fixed : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? es.resizeSquareTabs : es.resizeFlatTabs;
		send(es.primaryWidget, toPane, toChild, es.clickthrough);
	}
	
	// Regardless of display mode - must be sent. NOT the inter-switch packet - this is actual setInterface.
	// Always sent on login or world hopping.
	public void setupGamepane(boolean loginPromptGamescreen) {
		int toPane = loginPromptGamescreen ? 165 : !resizable ? PANE_FIXED : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? PANE_RESIZABLE_NORM : PANE_RESIZABLE_LIST;
		
		sendRoot(toPane);
		for (InterSwitches is : InterSwitches.values()) {
			if (is == InterSwitches.XP_DROP && player.varps().varbit(Varbit.XP_DROPS_VISIBLE) == 0) // doesn't send if not visible
				continue;
			if (is == InterSwitches.ORBS && player.varps().varbit(Varbit.DATAORBS_HIDDEN) == 1) // Orbs hidden
				continue;
			if (is.primaryWidget == -1 || is.fixed == -1) // On 07 login, clicking 165 continue, 165 sends these interswitches, but never an interface.
				continue;
			int toChild = !resizable ? is.fixed : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? is.resizeSquareTabs : is.resizeFlatTabs;
			send(is.primaryWidget, toPane, loginPromptGamescreen ? is.loginPromptChild : toChild, is.clickthrough);
			//System.out.printf("sent %d on %d,%d  trans=%s%n", is.primaryWidget, toPane, toChild, is.clickthrough);
		}
		setInterfaceSettings();
	}
	
	// Make some stuff clickable
	public void setInterfaceSettings() {
		// Unlock music buttons
		player.write(new InterfaceSettings(MUSIC_TAB, 1, 0, 600, new SettingsBuilder().option(0)));
		
		// Emote buttons
		player.write(new InterfaceSettings(EMOTES_TAB, 1, 0, 47, new SettingsBuilder().option(0)));

		player.write(new InterfaceSettings(SETTINGS_TAB, 85, 1, 4, 2));
		player.write(new InterfaceSettings(SETTINGS_TAB, 86, 1, 4, 2));
	}
	
	// Shows the text and login screen prompt (x days membership etc)
	public void loginScreen() {
		player.write(new InterfaceText(378, 14, "Never tell anyone your password, even if they claim to work for Jagex!"),
				new InterfaceText(378, 15, "You have <col=00ff00>4 unread messages <col=ffff00>in your message centre."),
				new InterfaceText(378, 18, "You have <col=00ff00>11<col=ffff00> days of Old School RuneScape member credit remaining."),
				new InterfaceText(378, 20, "A membership subscription grants access to the members-only features of both versions of RuneScape."),
				new InterfaceText(378, 21, "Keep your account secure."),
				new InterfaceText(378, 13, "You last logged in <col=ff0000>earlier today<col=000000>."),
				new InterfaceText(378, 16, "You have a Bank PIN!"),
				new InterfaceText(50, 3, "<col=6f0000>Dragon warhammers</col> are now available from <col=002f00>lizard shamans</col><br>and there's a task-only <col=2f2fdf>wyvern cave</col> expansion."));
		player.write(new InvokeScript(233, -1, 500, 0, 1391, 577, 13, 5, 4041, 3276804),
				new InvokeScript(233, 7157, 2400, 0, 188, 3, 250, 40, 4039, 3276805),
				new InvokeScript(1080, ""));
		
		setupGamepane(true); // TODO continue button (button 378, 6) needs to have support for going from 165 to whatever.
		player.initiate();
	}
	
	public void setting(int parent, int child, int start, int end, SettingsBuilder b) {
		player.write(new InterfaceSettings(parent, child, start, end, b));
	}
	
	public void setting(int parent, int child, int start, int end, int value) {
		player.write(new InterfaceSettings(parent, child, start, end, value));
	}
	
	public void text(int parent, int child, String text) {
		player.write(new InterfaceText(parent, child, text));
	}
	
	public void sendMain(int id) {
		sendMain(id, false);
	}
	
	public void sendInventory(int id) {
		sendInventory(id, false);
	}
	
	public void sendInventory(int id, boolean clickthrough) {
		send(id, activeRoot, inventoryComponent(), clickthrough);
	}
	
	public void sendMain(int id, boolean clickthrough) {
		send(id, activeRoot, mainComponent(), clickthrough);
	}
	
	public void sendWorldMap() {
		send(595, activeRoot, worldMapComponent(), true);
	}
	
	public void sendTab(int id, int target, boolean clickthrough) {
		send(id, activeRoot, target, clickthrough);
	}
	
	// Special cases where when you have 1 interface open and open another, it WILL NOT call the onInterClose hook.
	// This stops you interrupting whatever action like trading/staking you're doing, when instead you want to continue with it.
	public static final int TRADE1 = 335, TRADE2 = 334, STAKE1 = 482, STAKE2 = 481;
	
	public void send(int id, int target, int targetChild, boolean clickthrough) {
		
		// Make sure to invoke close interface on anything currently open. This is extra security.
		// We purposefully don't use close() in Interface because there is no need to send the close packet.
		Integer current = visible.remove((target << 16) | targetChild);
		
		// Process close trigger
		if (current != null) {
			
			// If an interface is already open in this position, call the onClose trigger.
			// EXCEPTIONS: Since 2nd trade/duel confirm screens do this (overwriting open faces) to NOT close these and just progress onto the next screen.
			if (!((current == TRADE1 && id == TRADE2) || (current == STAKE1 && id == STAKE2) || (current == STAKE2 && id == 476))) {
				//player.world().server().scriptRepository().triggerInterfaceClose(player, current);
			}
		}
		
		player.write(new OpenInterface(id, target, targetChild, clickthrough));
		visible.put((target << 16) | targetChild, id);
		//player.debug("replaced "+current+" with "+id+" at "+target+" "+targetChild+" transparent="+clickthrough);
	}
	
	public void closeWorldMap() {
		if (activeRoot == LOGIN_PROMPT_PANE)
			sendForMode(displayMode(true), displayMode(false));
		close(activeRoot, worldMapComponent());
		
		player.putattrib(AttributeKey.WORLD_MAP, false);
	}

	public void invokeScript(int scriptId, Object... args) {
		player.write(new InvokeScript(scriptId, args));
	}
	
	public void closeMain() {
		close(activeRoot, mainComponent());
	}
	
	public void close(int target, int targetChild) {
		close((target << 16) | targetChild);
	}
	
	public void close(int hash) {
		player.write(new CloseInterface(hash));
		Integer id = visible.remove(hash); // THE INTERFACE ASSOCIATED WITH THE PARENT|CHILD HASH (solid/overlay widget)
		
		// Process close trigger
		if (id != null) {
			//player.world().server().scriptRepository().triggerInterfaceClose(player, id); // use repo.onInterfaceClose(id)
			// Safety... restore the tabs after closing a main interface, IF they were hidden
			for (int i : new int[] {593, 320, 399, 149, 387, 541, 218, 7, 429, 432, 182, 261, 216, 239}) {
				if (!visible(i))
					sendWidgetOn(i, InterSwitches.forWidget(i));
			}
		}
	}
	
	public int closeById(int id) {
		int at = whereIs(id);
		if (at != -1)
			close(at);
		return at;
	}
	
	public boolean visible(int id) {
		return activeRoot == id || visible.containsValue(id);
	}
	
	public boolean visible(int root, int sub) {
		return visible.containsKey(root << 16 | sub);
	}
	
	public void sendRoot(int id) {
		player.write(new SetRootPane(id));
		activeRoot = id;
	}
	
	public int activeRoot() {
		return activeRoot;
	}
	
	public int mainComponent() {
		InterSwitches main = InterSwitches.MAIN;
		return !resizable ? main.fixed : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? main.resizeSquareTabs : main.resizeFlatTabs;
	}
	
	public int worldMapComponent() {
		InterSwitches wm = InterSwitches.WORLD_MAP;
		return activeRoot == LOGIN_PROMPT_PANE ? wm.loginPromptChild : !resizable ? wm.fixed : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? wm.resizeSquareTabs : wm.resizeFlatTabs;
	}
	
	public int mainComponentForMode(int mode) { // 0=fixed, 1=resize ONE, 2=resize TWO
		return mode == 0 ? 19 : 12;
	}
	
	public int inventoryComponent() {
		InterSwitches main = InterSwitches.INVENTORY_INTER;
		return !resizable ? main.fixed : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? main.resizeSquareTabs : main.resizeFlatTabs;
	}
	
	public int inventoryComponentForMode(int mode) { // 0=fixed, 1=resize ONE, 2=resize TWO
		return mode == 0 ? 61 : mode == 1 ? 60 : 58;
	}
	
	public int barrowsComponent() {
		InterSwitches main = InterSwitches.T;
		return !resizable ? main.fixed : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 0 ? main.resizeSquareTabs : main.resizeFlatTabs;
	}
	
	public int barrowsComponentForMode(int mode) {
		return mode == 0 ? 13 : 4;
	}
	
	public int activeMain() {
		return visible.getOrDefault(activeRoot() << 16 | mainComponent(), -1);
	}
	
	public int displayMode(boolean loginPrompt) {
		if (loginPrompt && activeRoot == LOGIN_PROMPT_PANE) {
			return 3;
		}
		if (!player.interfaces().resizable())
			return 0;
		if (player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 1)
			return 2;
		else
			return 1;
	}
}
