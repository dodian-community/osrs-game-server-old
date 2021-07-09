package client;

import java.util.ArrayList;
import java.util.List;

public class JournalInterface {

	public static final Object[][] JOURNALS = {
			//tab name, tab icon, tab btn icon
			{"Journal", 776, 835}, {"Presets", 1052, 1054}};

	public static Object[] ACTIVE_JOURNAL = JOURNALS[0];

	public static void init(int active, List<Object[]> categories) {
		if (Widget.get(259, 4).children == null) {
			// Interface isn't loaded
			System.out.println("??");
			return;
		}
		ACTIVE_JOURNAL = JOURNALS[active];

		// Tab name & icon (Forces tab to refresh using varp 1055)
		GameClient.updateForSetting(1055);
		GameClient.staticIntArray105[GameClient.staticInt244++ & 0x1f] = 1055;

		// Tab title
		Widget title = Widget.getLoaded(259 << 16);
		title.componentString = (String) ACTIVE_JOURNAL[0];
		title.fontHorizontalAlignment = 0;
		title.x = 10;
		GameClient.requestRedraw(title);
		Stream.client.method506(title);

		// Children
		Widget[] children = Widget.LOADED[259];
		int childCount = Widget.staticJs5Index11.getFileCount(259);
		ArrayList<Widget> newChildren = new ArrayList<Widget>();
		for (int i = 0; i < childCount; i++)
			newChildren.add(children[i]);

		// Tab nav buttons
		Widget baseBtn1 = children[1];
		Widget baseBtn2 = children[2];
		Widget baseBtn3 = children[3];
		baseBtn1.hidden = baseBtn2.hidden = baseBtn3.hidden = true;
/*
        Widget journalBtn;
        journalBtn = new Widget();
        journalBtn.cs2Inter = true;
        journalBtn.parentHash = baseBtn1.parentHash;
        journalBtn.widgetType = baseBtn1.widgetType;
        journalBtn.y = baseBtn1.y;
        journalBtn.width = baseBtn1.width;
        journalBtn.height = baseBtn1.height;
        journalBtn.decodeCs2 = true;
        journalBtn.mouseEnteredScript = baseBtn1.mouseEnteredScript;
        journalBtn.mouseLeftScript = baseBtn1.mouseLeftScript;
        newChildren.add(journalBtn);

        Widget presetsBtn;
        presetsBtn = new Widget();
        presetsBtn.cs2Inter = true;
        presetsBtn.parentHash = baseBtn1.parentHash;
        presetsBtn.widgetType = baseBtn1.widgetType;
        presetsBtn.y = baseBtn1.y;
        presetsBtn.width = baseBtn1.width;
        presetsBtn.height = baseBtn1.height;
        presetsBtn.decodeCs2 = true;
        presetsBtn.mouseEnteredScript = baseBtn1.mouseEnteredScript;
        presetsBtn.mouseLeftScript = baseBtn1.mouseLeftScript;
        newChildren.add(presetsBtn);

        Widget[] navBtns = {journalBtn, presetsBtn};
        int navX = 190;
        for (int i = (navBtns.length - 1); i >= 0; i--) {
            Widget btn = navBtns[i];
            if (!btn.hidden) {
                Object[] btnType = JOURNALS[i];
                btn.x = (navX -= 18);
                btn.spriteId = (Integer) btnType[2];
                btn.setOption(0, "View " + btnType[0]);
                Client.requestRedraw(btn);
            }
        }*/

		// Footer text
		Widget footerText = new Widget();
		footerText.parentHash = -1;
		footerText.widgetType = 4;
		footerText.x = title.x;
		footerText.y = 250;
		footerText.width = 171;
		footerText.fontId = 494;
		footerText.color = title.color;
		footerText.fontShadow = true;
		footerText.componentString = "";
		newChildren.add(footerText);

		Widget cpText = new Widget();
		cpText.parentHash = -1;
		cpText.widgetType = 4;
		cpText.x = title.x;
		cpText.y = 250;
		cpText.width = 171;
		cpText.fontId = 494;
		cpText.color = title.color;
		cpText.fontShadow = true;
		cpText.fontHorizontalAlignment = 2;
		cpText.componentString = "OS-Scape.com";
		newChildren.add(cpText);

		// Children
		for (int i = childCount; i < newChildren.size(); i++) {
			Widget child = newChildren.get(i);
			child.interfaceHash = 259 << 16 | i;
			if (child.widgetType == 5) {
				long var37 = ((long) child.interfaceHash << 32) + (long) -1;

				class204 var60 = GameClient.interfaceSettings.get(var37);
				if (var60 != null) {
					var60.unlink();
				}

				GameClient.interfaceSettings.method4016(new class211(2), var37);
			}
			GameClient.requestRedraw(child);
			Stream.client.method506(child);
		}
		Widget.LOADED[259] = newChildren.toArray(new Widget[newChildren.size()]);

		// Tab list children
		int listHash = 259 << 16 | 4;
		Widget list = Widget.getLoaded(listHash);
		list.children = null;

		int childId = 0;
		int yPosition = 9;
		ArrayList<Object[]> headers = new ArrayList<Object[]>();
		for (Object[] cat : categories) {
			String name = (String) cat[0];
			int size = (Integer) cat[1];
			if (!name.isEmpty()) {
				headers.add(new Object[]{yPosition, name});
				yPosition += 20;
			}
			for (int i = 0; i < size; i++) {
				Widget child = Custom.addChild(listHash, 4, childId++);
				child.x = 10;
				child.y = yPosition;
				child.width = 152;
				child.height = 15;
				child.fontId = 494;
				child.fontShadow = true;
				child.componentString = "child: " + (childId - 1);
				child.decodeCs2 = true;
				child.mouseEnteredScript = new Object[]{85, -2147483645, -2147483643, 16777215};
				child.mouseLeftScript = new Object[]{85, -2147483645, -2147483643, child.color};
				child.setOption(0, "Select");
				GameClient.requestRedraw(child);
				Stream.client.method506(child);
				yPosition += 15;
			}
		}
		for (Object[] obj : headers) {
			Widget child = Custom.addChild(listHash, 4, childId++);
			child.x = 10;
			child.y = (Integer) obj[0];
			child.width = 152;
			child.height = 15;
			child.fontId = 496;
			child.color = 16750899;
			child.fontShadow = true;
			child.componentString = (String) obj[1];
			GameClient.requestRedraw(child);
			Stream.client.method506(child);
		}

		// Tab list background
		Widget background = Widget.getLoaded(259 << 16 | 5);
		if (background.int466 < yPosition) {
			background.int466 = yPosition;
			GameClient.requestRedraw(background);
		}

		// Scrolling
		list.scrollY = 0;
		list.scrollHeight = Math.max(list.height, yPosition + 5);

		ScriptInvocation var70 = new ScriptInvocation();
		var70.parameters = new Object[]{31, 259 << 16 | 7, listHash, 792, 789, 790, 791, 773, 788};
		class68.method1696(var70);

		// Unlocking children
		InterfaceEdits.unlock(listHash, 0, childId, 0);

		// Refresh
		GameClient.requestRedraw(list);
	}

	public static void update(int childId, String text, int colorIndex) {
		if (Widget.get(259, 4).children == null) {
			// Interface isn't loaded
			return;
		}
		Widget child = Widget.getLoaded(259 << 16 | 4).children[childId];
		child.componentString = text;
		if (colorIndex != 255) {
			int[] colors = {
					// OSRS colors
					16711680,   //red
					0xffff00,   //yellow
					65280,      //green

					// Custom colors
					class68.method1693("FFA500", 16, true),   //orange
					class68.method1693("FF4500", 16, true),   //orange red
					class68.method1693("FF6347", 16, true),   //tomato
					class68.method1693("DC143C", 16, true),   //crimson

					class68.method1693("0000FF", 16, true),   //blue
					class68.method1693("0040ff", 16, true),   //cool blue
					class68.method1693("1E90FF", 16, true),   //baby blue
					class68.method1693("00FFFF", 16, true),   //cyan

					class68.method1693("800080", 16, true),   //purple
					class68.method1693("EE82EE", 16, true),   //violet
					class68.method1693("FFC0CB", 16, true),   //pink

					class68.method1693("FFFFFF", 16, true),   //white
					class68.method1693("F5DEB3", 16, true),   //wheat
					class68.method1693("C0C0C0", 16, true),   //silver

					class68.method1693("808000", 16, true),   //olive
					class68.method1693("D37E2A", 16, true),   //bronze
					class68.method1693("FFD700", 16, true),   //gold
			};
			int color = colors[colorIndex];
			child.color = color;
			if (child.mouseLeftScript == null)
				new Throwable(childId + ", \"" + text + "\", " + colorIndex).printStackTrace();
			else child.mouseLeftScript[3] = color;
			GameClient.requestRedraw(child);
		}
	}

}
