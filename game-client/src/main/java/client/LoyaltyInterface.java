package client;

import java.util.Arrays;
import java.util.List;

public class LoyaltyInterface {

	public static void init(int dayReward, int currentSpree, int highestSpree, int totalClaimedRewards, List<int[]> packs) {
		List<Integer> containerIds = Arrays.asList(25, 27, 29, 31, 33, 35, 37, 39, 41, 43);
		List<Integer> lockedContainerIds = Arrays.asList(15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
		Widget parent = Widget.get(264, 1);
		int childId = parent.children.length;
		/**
		 * Title
		 */
		Widget title = parent.children[1];
		title.componentString = "OS-Scape Loyalty Rewards";
		GameClient.requestRedraw(title);

		/**
		 * Reposition containers.
		 */
		for(int containerId : containerIds) {
			Widget inter = Widget.get(264, containerId);
			inter.componentString = "";
			inter.onClickListener = null;
			inter.mouseEnteredScript = null;
			inter.mouseLeftScript = null;
			inter.setOption(0, "Claim reward");
			inter.setOption(1, null);
			inter.setOption(2, null);
			inter.setOption(3, null);
			GameClient.requestRedraw(inter);
			Stream.client.method506(inter);
		}

		/**
		 * Hide old button content
		 */
		for(int i = 45; i < 65; i ++) {
			Widget inter = Widget.get(264, i);
			inter.hidden = true;
		}

		/**
		 * Set unlocked days
		 */
		for(int i = 0; i < dayReward; i ++) {
			Widget inter = Widget.get(264, lockedContainerIds.get(i));
			inter.hidden = true;
		}

		/**
		 * Hide statistics background
		 */
		Widget inter = Widget.get(264, 4);
		inter.hidden = true;

		/**
		 * Fill containers
		 */
		for(int i = 0; i < 10; i++) {
			Widget container = Widget.get(264, containerIds.get(i));
			int containerChild = 0;
			int[] pack = packs.get(i);
			int rewardId = pack[0];
			int rewardAmount = pack[1];
			Widget item = Custom.addChild(container.interfaceHash, 5, containerChild++);
			item.decodeCs2 = true;
			item.x = 30;
			item.y = 24;
			item.width = 36;
			item.height = 32;
			item.shadow = 3355443;
			item.outline = 1;
			item.fontVerticalAlignment = 1;
			item.fontHorizontalAlignment = 1;
			Widget.setItem(item, rewardId, (rewardAmount == 1) ? -1 : rewardAmount, 1);
			GameClient.requestRedraw(item);
			Stream.client.method506(item);

			Widget day = Custom.addChild(container.interfaceHash, 4, containerChild++);
			day.decodeCs2 = true;
			day.x = 0;
			day.y = -13;
			day.widthAlignment = 1;
			day.height = 50;
			day.fontVerticalAlignment = 1;
			day.fontHorizontalAlignment = 1;
			day.fontId = 496;
			day.fontShadow = true;
			day.color = 0xF39C12;
			day.componentString = "Day " + (i + 1);
			GameClient.requestRedraw(day);
			Stream.client.method506(day);

			Widget itemName = Custom.addChild(container.interfaceHash, 4, containerChild++);
			itemName.decodeCs2 = true;
			itemName.widthAlignment = 1;
			itemName.y = 39;
			itemName.height = 50;
			itemName.fontHorizontalAlignment = 1;
			itemName.fontVerticalAlignment = 1;
			itemName.fontId = 494;
			itemName.fontShadow = true;
			itemName.color = 0xD0D3D4;

			if(dayReward > (i + 1)) {
				Widget check = Custom.addChild(container.interfaceHash, 4, containerChild++);
				check.decodeCs2 = true;
				check.x = 2;
				check.y = 65;
				check.width = 500;
				check.height = 20;
				check.fontId = 494;
				check.componentString = "<img=78>";
				check.fontShadow = true;
				check.color = 0xff9040;
				GameClient.requestRedraw(check);
				Stream.client.method506(check);
			}

			ItemDef def = ItemDef.loadItemDef(rewardId);
			boolean note = def.notedTemplate >= 0 && def.notedID >= 0;
			itemName.componentString = (note ? ItemDef.loadItemDef(def.notedID).name : def.name);
			GameClient.requestRedraw(itemName);
			Stream.client.method506(itemName);
		}


		/**
		 * Statistics
		 */
		Widget statistics = Custom.addChild(parent.interfaceHash, 4, childId++);
		statistics.decodeCs2 = true;
		statistics.x = 278;
		statistics.y = 216;
		statistics.width = 170;
		statistics.height = 10;
		statistics.fontId = 496;
		statistics.componentString = "Statistics";
		statistics.fontShadow = true;
		statistics.color = 0xF39C12;
		GameClient.requestRedraw(statistics);
		Stream.client.method506(statistics);

		Widget spreeMsg = Custom.addChild(parent.interfaceHash, 4, childId++);
		spreeMsg.decodeCs2 = true;
		spreeMsg.x = 230;
		spreeMsg.y = 233;
		spreeMsg.width = 170;
		spreeMsg.height = 20;
		spreeMsg.fontId = 494;
		spreeMsg.componentString = "Current Spree:";
		spreeMsg.fontShadow = true;
		spreeMsg.color = 0xff9040;
		GameClient.requestRedraw(spreeMsg);
		Stream.client.method506(spreeMsg);

		Widget spreeMsg1 = Custom.addChild(parent.interfaceHash, 4, childId++);
		spreeMsg1.decodeCs2 = true;
		spreeMsg1.x = 307;
		spreeMsg1.y = 233;
		spreeMsg1.width = 170;
		spreeMsg1.height = 20;
		spreeMsg1.fontId = 494;
		spreeMsg1.componentString = "" + currentSpree;
		spreeMsg1.fontShadow = true;
		spreeMsg1.color = 0xD0D3D4;
		GameClient.requestRedraw(spreeMsg1);
		Stream.client.method506(spreeMsg1);

		Widget highestSpreeMsg = Custom.addChild(parent.interfaceHash, 4, childId++);
		highestSpreeMsg.decodeCs2 = true;
		highestSpreeMsg.x = 230;
		highestSpreeMsg.y = 247;
		highestSpreeMsg.width = 170;
		highestSpreeMsg.height = 20;
		highestSpreeMsg.fontId = 494;
		highestSpreeMsg.componentString = "Highest Spree:";
		highestSpreeMsg.fontShadow = true;
		highestSpreeMsg.color = 0xff9040;
		GameClient.requestRedraw(highestSpreeMsg);
		Stream.client.method506(highestSpreeMsg);

		Widget highestSpreeMsg1 = Custom.addChild(parent.interfaceHash, 4, childId++);
		highestSpreeMsg1.decodeCs2 = true;
		highestSpreeMsg1.x = 307;
		highestSpreeMsg1.y = 247;
		highestSpreeMsg1.width = 170;
		highestSpreeMsg1.height = 20;
		highestSpreeMsg1.fontId = 494;
		highestSpreeMsg1.componentString = "" + highestSpree;
		highestSpreeMsg1.fontShadow = true;
		highestSpreeMsg1.color = 0xD0D3D4;
		GameClient.requestRedraw(highestSpreeMsg1);
		Stream.client.method506(highestSpreeMsg1);

		Widget totalClaimed = Custom.addChild(parent.interfaceHash, 4, childId++);
		totalClaimed.decodeCs2 = true;
		totalClaimed.x = 230;
		totalClaimed.y = 262;
		totalClaimed.width = 170;
		totalClaimed.height = 20;
		totalClaimed.fontId = 494;
		totalClaimed.componentString = "Total Claimed Rewards:";
		totalClaimed.fontShadow = true;
		totalClaimed.color = 0xff9040;
		GameClient.requestRedraw(totalClaimed);
		Stream.client.method506(totalClaimed);

		Widget totalClaimed1 = Custom.addChild(parent.interfaceHash, 4, childId++);
		totalClaimed1.decodeCs2 = true;
		totalClaimed1.x = 346;
		totalClaimed1.y = 262;
		totalClaimed1.width = 170;
		totalClaimed1.height = 20;
		totalClaimed1.fontId = 494;
		totalClaimed1.componentString  = "" + totalClaimedRewards;
		totalClaimed1.fontShadow = true;
		totalClaimed1.color = 0xD0D3D4;
		GameClient.requestRedraw(totalClaimed1);
		Stream.client.method506(totalClaimed1);

		/**
		 * Top thank you message
		 */
		Widget thankYou = Custom.addChild(parent.interfaceHash, 4, childId++);
		thankYou.decodeCs2 = true;
		thankYou.x = 63;
		thankYou.y = 36;
		thankYou.width = 500;
		thankYou.height = 20;
		thankYou.fontId = 494;
		thankYou.componentString = "Thanks for playing OS-Scape! Select your <col=4dff4d>loyalty reward</col> below!";
		thankYou.fontShadow = true;
		thankYou.color = 0xff9040;
		GameClient.requestRedraw(thankYou);
		Stream.client.method506(thankYou);

		Widget heart = Custom.addChild(parent.interfaceHash, 4, childId++);
		heart.decodeCs2 = true;
		heart.x = 49;
		heart.y = 38;
		heart.width = 500;
		heart.height = 20;
		heart.fontId = 494;
		heart.componentString = "<img=76>";
		heart.fontShadow = true;
		heart.color = 0xff9040;
		GameClient.requestRedraw(heart);
		Stream.client.method506(heart);

	}

}
