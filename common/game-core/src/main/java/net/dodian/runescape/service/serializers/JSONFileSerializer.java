package net.dodian.runescape.service.serializers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.dodian.runescape.model.AttributeKey;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.uid.UIDProvider;
import net.dodian.runescape.model.uid.providers.SimpleUIDProvider;
import net.dodian.runescape.net.message.LoginRequestMessage;
import net.dodian.orm.models.character.Character;
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

	private final ObjectMapper mapper = new ObjectMapper()
			.findAndRegisterModules()
			.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
			.enable(SerializationFeature.INDENT_OUTPUT);

	private final UIDProvider uidProvider;

	/**
	 * The folder containing the character files.
	 */
	private File characterFolder = new File("data/characters");
	
	public JSONFileSerializer() {
		this.uidProvider = new SimpleUIDProvider();
		/* Create folder if missing */
		characterFolder.mkdirs();
	}
	
	@Override
	public boolean loadPlayer(Player player, Object uid, String password, Consumer<PlayerLoadResult> fn, LoginRequestMessage loginRequestMessage) {
		File characterFile = new File(characterFolder + File.separator + player.username() + ".json");

		if(characterFile.exists()) {
			try {
				Character character = mapper.readValue(characterFile, Character.class);
				//character.updatePlayer(player);
			} catch (IOException e) {
				logger.error("Failed to log character: '{}'.", player.username(), e);
			}
		} else {
			player.id(uidProvider.acquire(player));
			player.putattrib(AttributeKey.NEW_ACCOUNT, true);
			//this.createCharacter(player).updatePlayer(player);
			this.savePlayer(player, false);
		}

		fn.accept(PlayerLoadResult.OK);
		return true;
	}
	
	@Override
	public void savePlayer(Player player, boolean removeOnline) {
		File characterFile = new File(characterFolder + File.separator + player.username() + ".json");
		Character character = new Character(); // TODO: Need to put an actual ID
		try {
			mapper.writeValue(characterFile, character);
			logger.info("Saved character: {}", player.username());
		} catch (IOException e) {
			logger.error("Failed to save character...", e);
		}
	}
}
