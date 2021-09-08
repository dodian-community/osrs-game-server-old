package net.dodian.runescape.model.uid.providers;

import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.uid.UIDProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.RandomAccessFile;

/**
 * Created by Bart on 4-3-2015.
 * <p>
 * <p>Simple provider which uses a file as last UID and hands out a UID at incremental rate. This is <b>not</b> a
 * solution in multi-server environments, because the file will not be in sync. If you want a multi-server available
 * approach, please see .</p>
 * <p>
 * <p>Alternatively, there's a nice all-in-one solution if you're using SQL to save data: most SQL servers
 * have support for auto-incrementing IDs which you can use alongside your database server.</p>
 */
public class SimpleUIDProvider extends UIDProvider {
	
	private static final Logger logger = LogManager.getLogger(SimpleUIDProvider.class);
	
	private RandomAccessFile file;
	private int uid;
	
	public SimpleUIDProvider() {
		
		try {
			file = new RandomAccessFile(".uid", "rw");
			
			// Set uid to the last uid
			uid = file.readInt();
		} catch (Exception e) {
			logger.warn("Could not read .uid file, setting UID pointer to zero.");
			uid = 0;
		}
	}
	
	@Override
	public Object acquire(Player player) {
		synchronized (file) {
			int v = uid++;
			
			try {
				file.seek(0);
				file.writeInt(uid);
			} catch (Exception e) {
				logger.error("Could not update UID pointer to {}!", uid, e);
			}
			
			return v;
		}
	}
	
}
