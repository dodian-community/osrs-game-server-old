package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.item.Item;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class UpdateItems extends Command {
	
	private int target;
	private int targetChild;
	private int key;
	private Item[] old;
	private Item[] current;
	
	public UpdateItems(int key, Item[] old, Item[] current) {
		this.key = key;
		this.old = old;
		this.current = current;
	}
	
	public UpdateItems(int key, int target, int targetChild, Item[] old, Item[] current) {
		this.key = key;
		this.target = target;
		this.targetChild = targetChild;
		this.old = old;
		this.current = current;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(8));
		
		buffer.packet(-1).writeSize(RSBuffer.SizeType.SHORT);
		
		buffer.writeInt(target == 0 ? -1 : ((target << 16) | targetChild));
		buffer.writeShort(key);
		
		for (int i = 0; i < Math.max(old.length, current.length); i++) {
			Item olditem = i >= old.length ? null : old[i];
			Item newitem = i >= current.length ? null : current[i];
			
			if ((olditem == null && newitem != null) ||
					(newitem == null && olditem != null) ||
					(olditem != null && newitem != null &&
							(olditem.getId() != newitem.getId() || olditem.getAmount() != newitem.getAmount()))) {
				buffer.writeCompact(i); // Item slot
				
				if (newitem == null) {
					buffer.writeShort(0);
				} else {
					buffer.writeShort(newitem.getId() + 1);
					buffer.writeByte(Math.min(255, newitem.getAmount()));
					
					if (newitem.getAmount() >= 255) buffer.writeInt(newitem.getAmount());
				}
			}
		}
		
		return buffer;
	}
}
