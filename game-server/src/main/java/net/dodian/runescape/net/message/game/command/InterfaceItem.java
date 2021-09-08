package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.item.Item;
import net.dodian.runescape.net.message.game.Command;

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

		buffer.writeShortA(item.getId());
		buffer.writeInt(hash);
		buffer.writeLEInt(item.getAmount());

		return buffer;
	}
	
}
