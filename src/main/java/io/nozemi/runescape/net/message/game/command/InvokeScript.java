package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class InvokeScript extends Command {

	private static final Logger logger = LogManager.getLogger(InvokeScript.class);
	
	private int id;
	private Object[] args;
	private String types;
	private int size;
	public static final int OPEN_TAB = 915; // Force opens a tab
	public static final int SETVARCS = 917; // Set varcs 173 and 174 no idea what function is. Hide/showing some sort of component. Script 909,910
	
	public InvokeScript(int id, Object... args) {
		this.id = id;
		this.args = args;

		logger.info("Invoking script with id {} ...", id);

		/* Calculate types */
		size = 1 + 2 + 4;
		char[] chars = new char[args.length];
		for (int i = 0; i < args.length; i++) {
			chars[i] = args[i] instanceof String ? 's' : 'i';
			types += args[i] instanceof String ? args[i].toString().length() + 1 : 4;
		}
		types = new String(chars);
		size += types.length() + 1;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buf = new RSBuffer(player.channel().alloc().buffer(size));
		
		buf.packet(3).writeSize(RSBuffer.SizeType.SHORT);
		
		buf.writeString(types);
		for (int i = args.length - 1; i >= 0; i--) {
			if (args[i] instanceof String)
				buf.writeString(((String) args[i]));
			else
				buf.writeInt(((Number) args[i]).intValue());
		}
		buf.writeInt(id);
		
		return buf;
	}
}
