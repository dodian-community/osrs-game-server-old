package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;
import io.nozemi.runescape.script.TimerKey;

import java.lang.ref.WeakReference;

/**
 * Created by Bart on 5-2-2015.
 */
@PacketInfo(size = 6)
public class DialogueContinue implements Action {
	
	private int hash;
	private int slot;
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		hash = buf.readLEInt();
		slot = buf.readUShortA();
		
		if (slot == 0xFFFF)
			slot = -1;
		
		log(player, opcode, size, "inter=%d slot=%d", hash >> 16, hash & 0xFFFF, slot);
	}
	
	@Override
	public void process(Player player) {
		if (player.privilege().eligibleTo(Privilege.ADMIN) && player.<Boolean>attribOr(AttributeKey.DEBUG, false))
			player.message("Dialogue [%d:%d], slot: %d", hash >> 16, hash & 0xFFFF, slot);
		
		if (player.timers().has(TimerKey.DIALOGUE_CONTINUE)) {
			return;
		}
		
		int id = hash >> 16;
		int child = hash & 0xFFFF;
		
		Object returnval = null;
		if (id == 219 || id == 187 || id == 475) {
			returnval = slot;
		} else if (id == 270 || id == 309 || id == 304 || id == 303 || id == 305 || id == 154 || id == 306 || id == 582 || id == 94) {
			returnval = child;
		}

		//Stash the make X amount, if possible.
		if (slot > 0 && id == 270) player.putattrib(AttributeKey.MAKE_X_AMT, slot);
		
		if (id == 27 || id == 310 || id == 499 || id == 507) {
			player.putattrib(AttributeKey.INTERACTION_OPTION, 1);
			//player.world().server().scriptRepository().triggerButton(player, hash >> 16, hash & 0xFFFF, slot, 1, 0);
		} else {
			//player.world().server().scriptExecutor().continueFor(player, WaitReason.DIALOGUE, returnval);
		}
		
		if (id == 217 || id == 231) { // Player and Npc dialogue interfaces
			Entity speakingTo = ((WeakReference<Entity>) player.attribOr(AttributeKey.TARGET, new WeakReference<Entity>(null))).get();
			if (speakingTo != null) {
				player.faceTile(speakingTo.tile());
				
				// Not walking around and not already facing us.
				if (speakingTo.tile().nextTo(player.tile()) && (int) speakingTo.attribOr(AttributeKey.LAST_FACE_ENTITY_IDX, -1) != player.index() + 32768) {
					if (speakingTo.isNpc()) {
						final Npc npc = (Npc) speakingTo;
						if (npc.id() != 7494 && npc.id() != 7496 && npc.id() != 7497 && npc.id() != 7498 && npc.id() != 7499 && npc.id() != 7501 &&
								npc.id() != 7502 && npc.id() != 7503 && npc.id() != 7504 && npc.id() != 276 && npc.id() != 3343) {
							speakingTo.faceTile(player.tile());
						}
					} else {
						speakingTo.faceTile(player.tile());
					}
				}
			}
		}
	}
}
