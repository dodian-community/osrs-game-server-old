package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/11/2015.
 */
public class InterfaceItem extends Command {
	
	private int hash;
	private Item item;
	
	public InterfaceItem(int target, int targetChild, int id) {
		this(target, targetChild, new Item(id, 1));
	}
	
	public InterfaceItem(int target, int targetChild, int id, int amount) {
		this(target, targetChild, new Item(id, amount));
	}
	
	public InterfaceItem(int target, int targetChild, Item item) {
		hash = (target << 16) | targetChild;
		this.item = item;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(10));
		buffer.packet(54);

		buffer.writeShortA(item.id());
		buffer.writeInt(hash);
		buffer.writeLEInt(item.amount());

		return buffer;
	}
	
}
