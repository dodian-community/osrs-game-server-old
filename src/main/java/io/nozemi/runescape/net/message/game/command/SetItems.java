package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.model.item.ItemContainer;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class SetItems extends Command {
	
	private int target;
	private int targetChild;
	private int key;
	private Item[][] containers;
	
	public SetItems(int target, int targetChild, ItemContainer container) {
		this.target = target;
		this.targetChild = targetChild;
		this.containers = new Item[][]{container.copy()};
	}
	
	public SetItems(int target, int targetChild, Item[] container) {
		this.target = target;
		this.targetChild = targetChild;
		this.containers = new Item[][]{container.clone()};
	}
	
	public SetItems(int target, int targetChild, Item[][] containers) {
		this.target = target;
		this.targetChild = targetChild;
		this.containers = containers;
	}
	
	public SetItems(int key, int target, int targetChild, ItemContainer container) {
		this.key = key;
		this.target = target;
		this.targetChild = targetChild;
		this.containers = new Item[][]{container.copy()};
	}
	
	public SetItems(int key, ItemContainer container) {
		this.key = key;
		this.containers = new Item[][]{container.copy()};
	}
	
	public SetItems(int key, Item[] container) {
		this.key = key;
		this.containers = new Item[][]{container.clone()};
	}
	
	public SetItems(int key, Item[]... containers) {
		this.key = key;
		this.containers = containers;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(8));
		
		buffer.packet(7).writeSize(RSBuffer.SizeType.SHORT);
		
		buffer.writeInt(target == 0 ? -1 : ((target << 16) | targetChild));
		buffer.writeShort(key);
		
		int len = 0;
		for (Item[] i : containers)
			len += i.length;
		buffer.writeShort(len);
		
		for (Item[] container : containers) {
			for (Item item : container) {
				if (item == null) {
					buffer.writeByte(0);
					buffer.writeShort(0);
				} else {
					buffer.writeByte(Math.min(255, item.getAmount()));
					
					if (item.getAmount() >= 255) buffer.writeIntV2(item.getAmount());
					
					buffer.writeShort(item.getId() + 1);
				}
			}
		}
		
		return buffer;
	}
}
