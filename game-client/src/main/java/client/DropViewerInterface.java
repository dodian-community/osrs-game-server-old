package client;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DropViewerInterface {

	public static void init(String tableName, int petId, int petAverage, List<Integer[]> drops) {
		Widget infoX = Widget.get(522, 17);
		if(infoX != null)
			infoX.objectArray7 = null;

		Widget.getLoaded(383 << 16 | 1).children[1].componentString = "Viewing drop table for: " + tableName; //set title
		Widget.getLoaded(383 << 16 | 2).hidden = true; //hide "Exchange" button

		Widget parent = Widget.getLoaded(383 << 16 | 3);
		parent.children = null; //reset previous children

		Collections.sort(drops, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] d1, Integer[] d2) {
				int x = d1[4];
				int y = d2[4];
				return (x < y) ? -1 : ((x == y) ? 0 : 1);
			}
		});
		if(petId != 65535)
			drops.add(0, new Integer[]{petId, 1, -1, -1, petAverage}); //"pet" specifically identified by minAmount == -1

		int childId = 0;
		String[] columns = {"Min Amount", "Max Amount", "Drop Chance"};
		for(int i = 0; i < drops.size(); i++) {
			Integer[] drop = drops.get(i);

			int itemId = drop[0];
			int broadcastType = drop[1];
			int minAmount = drop[2];
			int maxAmount = drop[3];
			int average = drop[4];

			boolean pet = minAmount == -1;

			Widget bg = Custom.addChild(parent.interfaceHash, 5, childId++);
			bg.x = 0;
			bg.y = i * 38;
			bg.width = 424;
			bg.height = 38;
			bg.spriteId = 1040;
			bg.bool42 = true;
			bg.filled = true;
			bg.mouseEnteredScript = new Object[]{1015, -2147483645, -2147483643, 0, 255};
			if(i % 2 == 0) {
				bg.alpha = 0;
				bg.mouseLeftScript = new Object[]{1015, -2147483645, -2147483643, 0, 0};
			} else {
				bg.alpha = 125;
				bg.mouseLeftScript = new Object[]{1015, -2147483645, -2147483643, 0, 125};
			}
			bg.decodeCs2 = true;
			GameClient.requestRedraw(bg);
			Stream.client.method506(bg);

			ItemDef def = ItemDef.loadItemDef(itemId);
			boolean note = def.notedTemplate >= 0 && def.notedID >= 0;
			String name = (note ? ItemDef.loadItemDef(def.notedID).name : def.name);

			Widget examine = Custom.addChild(parent.interfaceHash, 5, childId++);
			examine.x = 0;
			examine.y = bg.y;
			examine.width = 40;
			examine.height = bg.height;
			examine.setOption(0, "Examine <col=ff9040>" + name + "</col>");
			GameClient.requestRedraw(examine);
			Stream.client.method506(examine);

			Widget item = Custom.addChild(parent.interfaceHash, 5, childId++);
			item.x = 3;
			item.y = bg.y + 3;
			item.width = 36;
			item.height = 32;
			Widget.setItem(item, itemId, (minAmount == maxAmount ? minAmount : (maxAmount / 2)), 0);
			item.shadow = 3355443;
			item.outline = 1;
			GameClient.requestRedraw(item);
			Stream.client.method506(item);

			Widget itemName = Custom.addChild(parent.interfaceHash, 4, childId++);
			itemName.x = 38;
			itemName.y = bg.y + 5;
			itemName.width = 140;
			itemName.height = 38;
			itemName.fontId = 495;
			itemName.fontShadow = true;
			itemName.color = 16750623;
			itemName.componentString = "<col=ffb83f>" + name;
			itemName.fontHorizontalAlignment = 1;
			itemName.fontVerticalAlignment = 0;
			GameClient.requestRedraw(itemName);
			Stream.client.method506(itemName);

			if(name.length() < 22) {
				Widget broadcast = Custom.addChild(parent.interfaceHash, 4, childId++);
				broadcast.x = itemName.x;
				broadcast.y = itemName.y + 16;
				broadcast.width = itemName.width;
				broadcast.height = 10;
				broadcast.fontId = 494;
				broadcast.fontShadow = true;
				broadcast.color = 16750623;
				broadcast.fontHorizontalAlignment = 1;
				broadcast.fontVerticalAlignment = 0;
				String b = "None";
				if (broadcastType == 0)
					b = "Friends";
				else if (broadcastType == 1)
					b = "World";
				else if (broadcastType == 2)
					b = "Global";
				broadcast.componentString = "Broadcast: <col=ffb83f>" + b;
				GameClient.requestRedraw(broadcast);
				Stream.client.method506(broadcast);
			}

			if(pet) {
				Widget info = Custom.addChild(parent.interfaceHash, 4, childId++);
				info.x = 170;
				info.y = bg.y + 1;
				info.width = 165;
				info.height = bg.height;
				info.fontId = 494;
				info.fontShadow = true;
				info.color = 16750623;
				info.componentString = "<col=F5DEB3>Pet unlocks do not affect<br><col=F5DEB3>drops and vice versa.";
				info.fontHorizontalAlignment = 1;
				info.fontVerticalAlignment = 1;
				GameClient.requestRedraw(info);
				Stream.client.method506(info);

				Widget column = Custom.addChild(parent.interfaceHash, 4, childId++);
				column.x = 340;
				column.y = bg.y + 7;
				column.width = 80;
				column.height = 32;
				column.fontId = 494;
				column.fontShadow = true;
				column.color = 16750623;
				column.fontHorizontalAlignment = 1;
				column.componentString = "Unlock Chance:";
				GameClient.requestRedraw(column);
				Stream.client.method506(column);

				Widget value = Custom.addChild(parent.interfaceHash, 4, childId++);
				value.x = column.x;
				value.y = column.y + 12;
				value.width = column.width;
				value.height = 10;
				value.fontId = 494;
				value.fontShadow = true;
				value.color = 16750623;
				value.fontHorizontalAlignment = 1;
				value.componentString = "<col=ffb83f>~ 1 / " + average;
				GameClient.requestRedraw(value);
				Stream.client.method506(value);
			} else {
				int x = 170;
				for(int c = 0; c < columns.length; c++) {
					String s = columns[c];
					Widget column = Custom.addChild(parent.interfaceHash, 4, childId++);
					column.x = x;
					column.y = bg.y + 7;
					column.width = 80;
					column.height = 32;
					column.fontId = 494;
					column.fontShadow = true;
					column.color = 16750623;
					column.fontHorizontalAlignment = 1;
					column.componentString = s + ":";
					GameClient.requestRedraw(column);
					Stream.client.method506(column);
					x += 85;

					Widget value = Custom.addChild(parent.interfaceHash, 4, childId++);
					value.x = column.x;
					value.y = column.y + 12;
					value.width = column.width;
					value.height = 10;
					value.fontId = 494;
					value.fontShadow = true;
					value.color = 16750623;
					value.fontHorizontalAlignment = 1;

					if(c == 0)
						value.componentString = "<col=ffb83f>" + (minAmount == 0 ? "-" : minAmount);
					else if(c == 1)
						value.componentString = "<col=ffb83f>" + (maxAmount == 0 ? "-" : maxAmount);
					else if(c == 2)
						value.componentString = "<col=ffb83f>" + (average == 1 ? "Always" : ("~ 1 / " + average));
					GameClient.requestRedraw(value);
					Stream.client.method506(value);
				}
			}
		}
		/**
		 * Scrolling
		 */
		parent.scrollY = 0;
		parent.scrollHeight = Math.max(parent.height, drops.size() * 38);
		ScriptInvocation var82 = new ScriptInvocation();
		var82.parameters = new Object[]{31, 25100292, 25100291, 792, 789, 790, 791, 773, 788};
		class68.method1696(var82);

		//var82 = new Class68();
		//var82.params = new Object[]{36, 25100292, 25100291, 0};
		//Class76.method1441(var82);

		/**
		 * Unlocking
		 */
		InterfaceEdits.unlock(parent.interfaceHash, 0, childId, 0);

		/**
		 * Refresh
		 */
		GameClient.requestRedraw(parent);
	}

}
