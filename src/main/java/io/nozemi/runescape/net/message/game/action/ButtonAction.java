package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.handlers.impl.ButtonHandler;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.Interfaces;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Bart on 5-2-2015.
 */
@PacketInfo(size = 8)
@Component
public class ButtonAction implements Action {

	private final static Logger logger = LogManager.getLogger(ButtonAction.class);
	
	public static final int[] OPCODES = {63, 11, 20, 9, 78, 96, 25, 91, 22, 45};

	private final ButtonHandler buttonHandler;

	private int option;
	private int hash;
	private int item;
	private int slot;
	private int opcode;


	@Autowired
	public ButtonAction(ButtonHandler buttonHandler) {
		this.buttonHandler = buttonHandler;
	}
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		hash = buf.readInt();
		slot = buf.readUShort();
		item = buf.readUShort();
		
		if (item == 0xFFFF)
			item = -1;
		if (slot == 0xFFFF)
			slot = -1;

		/* Resolve option based on opcode */
		for (int i = 0; i < OPCODES.length; i++)
			if (OPCODES[i] == opcode)
				option = i;
		
		log(player, opcode, size, "inter=%d child=%d slot=%d option=%d item=%d", hash >> 16, hash & 0xFFFF, slot, option, item);
	}
	
	@Override
	public void process(Player player) {
		if (player.privilege().eligibleTo(Privilege.ADMIN) && player.<Boolean>attribOr(AttributeKey.DEBUG, false))
			player.message("Button option %d on [%d:%d], item: %d, slot: %d", option + 1, hash >> 16, hash & 0xFFFF, item, slot);
		
		if (player.dead()) {
			return;
		}
		if (player.interfaces().visible(hash >> 16)) {
			// 382 is a piano as of 24/11/2016 rev 125. maybe it used to be something else?
			if (hash >> 16 == 382) {
				//player.world().server().scriptExecutor().continueFor(player, WaitReason.DIALOGUE, hash & 0xFFFF);
			} else {
				player.putattrib(AttributeKey.INTERACTION_OPTION, option + 1);
				int parentId = hash >> 16;
				int childId = hash & 0xFFFF;

				buttonHandler.handleButton(player, parentId, childId, option + 1, item);
				/*player.putattrib(AttributeKey.BUTTON_SLOT, slot);
				player.putattrib(AttributeKey.BUTTON_ACTION, option + 1);
				player.putattrib(AttributeKey.ITEM_ID, item);
				player.putattrib(AttributeKey.CHILD_ID, childId);

				if(parentId == 182 && childId == 8) {
					player.putattrib(AttributeKey.LOGOUT, true);
				}
				//player.world().server().scriptRepository().triggerButton(player, hash >> 16, hash & 0xFFFF, slot, option + 1, item);*/
			}
		} else {
			//player.debug("Widget <col=FF0000>not visible</col> - %d,%d%n", hash >> 16, hash & 0xffff);
		}
	}
}
