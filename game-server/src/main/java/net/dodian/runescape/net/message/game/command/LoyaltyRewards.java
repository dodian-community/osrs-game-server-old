package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.item.Item;
import net.dodian.runescape.net.message.game.Command;

public class LoyaltyRewards extends Command {

	private int dayReward, currentSpree, highestSpree, totalClaimedRewards;
	private Item[] loyaltyRewards;

	public LoyaltyRewards(int dayReward, int currentSpree, int highestSpree, int totalClaimedRewards, Item... loyaltyRewards) {
		this.dayReward = dayReward;
		this.currentSpree = currentSpree;
		this.highestSpree = highestSpree;
		this.totalClaimedRewards = totalClaimedRewards;
		this.loyaltyRewards = loyaltyRewards;
	}
	
	@Override
	protected RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(3 + 1 + 12 + (loyaltyRewards.length * 8))).packet(87).writeSize(RSBuffer.SizeType.SHORT);

		buffer.writeByte(dayReward);
		buffer.writeInt(currentSpree);
		buffer.writeInt(highestSpree);
		buffer.writeInt(totalClaimedRewards);

		for(Item reward : loyaltyRewards) {
			buffer.writeInt(reward.getId());
			buffer.writeInt(reward.getAmount());
		}
		
		return buffer;
	}

}
