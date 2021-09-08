package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;
import net.dodian.runescape.util.SettingsBuilder;

/**
 * Created by Bart on 8/11/2015.
 */
public class InterfaceSettings extends Command {
	
	private int hash;
	private int from;
	private int to;
	private int setting;
	
	public InterfaceSettings(int target, int targetChild, int from, int to, SettingsBuilder setting) {
		this(target, targetChild, from, to, setting.build());
	}
	
	public InterfaceSettings(int target, int targetChild, int from, int to, int setting) {
		hash = (target << 16) | targetChild;
		this.from = from;
		this.to = to;
		this.setting = setting;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(13));
		buffer.packet(35);

		buffer.writeShortA(from);
		buffer.writeIntV2(hash);
		buffer.writeIntV1(setting);
		buffer.writeLEShortA(to);
		
		return buffer;
	}
	
}
