package net.dodian.runescape.net.message.game.command;

import io.netty.buffer.Unpooled;
import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Jak on 22/01/2016. #Gundrilla all nighter whats up
 * A custom packet that will adjust the client-sided "world flag" value.
 * On RS, this value is only modifyable on login or when world hopping. This is why Jagex
 * have a PVP world and a normal world. The config and overlay is not programmed to work on the same world (thanks mod ash)
 * The world flag value is a bitpacked Integer, for flagging if the world is a high-risk world, f2p, members, tournament etc.
 */
public class UpdateStateCustom extends Command {
	
	// World flag info
	private int value;
	
	/**
	 * What info are we sending?
	 */
	private int type;
	
	// World flag descriptor
	public UpdateStateCustom(int flags) {
		this.value = flags;
		type = 1;
	}
	
	public UpdateStateCustom(int type, int flags) {
		this.type = type;
		this.value = flags;
	}
	
	private UpdateStateCustom() {
		// empty constructor
	}
	
	public static UpdateStateCustom skullToggle(boolean show) {
		UpdateStateCustom cmd = new UpdateStateCustom();
		cmd.type = 2;
		cmd.value = show ? 1 : 0; // 1=show, 0=hidden for skull state
		return cmd;
	}
	
	public void sendWorldId(int worldId) {
		this.type = 4;
		this.value = worldId;
	}
	
	public static UpdateStateCustom setErrorReportState(boolean send) {
		UpdateStateCustom cmd = new UpdateStateCustom();
		cmd.type = 3;
		cmd.value = send ? 1 : 0; // 1=send, 0=dont send
		return cmd;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		// Flag to allow sending this packet or not. Since this packet is custom, any normal deob will crash as the packet
		// Is unsupported.
		return new RSBuffer(Unpooled.buffer());
	}
}
