package io.nozemi.runescape.service.serializers;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.EquipSlot;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.model.uid.UIDProvider;
import io.nozemi.runescape.net.message.LoginRequestMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.function.Consumer;

/**
 * Created by Bart on 5-3-2015.
 * <p>
 * Simple default serializer to <b>only</b> use in single-server setups because it uses a local file to serialize the
 * player data to by means of GSON.
 */
public class JSONFileSerializer extends PlayerSerializer {
	
	private static final Logger logger = LogManager.getLogger(JSONFileSerializer.class);
	
	/**
	 * The folder containing the character files.
	 */
	private File characterFolder = new File("data/characters");
	
	public JSONFileSerializer() {
		/* Create folder if missing */
		characterFolder.mkdirs();
	}
	
	@Override
	public boolean loadPlayer(Player player, Object uid, String password, Consumer<PlayerLoadResult> fn, LoginRequestMessage loginRequestMessage) {
		player.putattrib(AttributeKey.NEW_ACCOUNT, true);

		//player.equipment().set(EquipSlot.HEAD, new Item(1040, 1));

		fn.accept(PlayerLoadResult.OK);
		return true;
	}
	
	public static PlayerLoadResult loadPlayer(Player player, InputStream inputStream, String password) {
		return PlayerLoadResult.OK;
	}
	
	@Override
	public void savePlayer(Player player, boolean removeOnline) {
		
	}
}
