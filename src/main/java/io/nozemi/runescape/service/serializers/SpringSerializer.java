package io.nozemi.runescape.service.serializers;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.LoginRequestMessage;
import io.nozemi.runescape.orm.repositories.CharactersRepository;
import io.nozemi.runescape.orm.models.Character;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;

@Component
public class SpringSerializer extends PlayerSerializer {

    private final static Logger logger = LogManager.getLogger(SpringSerializer.class);

    private final CharactersRepository repository;

    @Autowired
    public SpringSerializer(CharactersRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean loadPlayer(Player player, Object uid, String password, Consumer<PlayerLoadResult> fn, LoginRequestMessage loginRequestMessage) {
        Optional<Character> optionalCharacter = repository.findFirstByUsername(player.username());
        if(optionalCharacter.isPresent()) {
            optionalCharacter.get().getPlayer(player);
            logger.info("Loading existing character.");
        } else {
            player.putattrib(AttributeKey.NEW_ACCOUNT, true);
            this.createCharacter(player).getPlayer(player);
            logger.info("Creating new character.");
            savePlayer(player, false);
        }
        fn.accept(PlayerLoadResult.OK);
        return true;
    }

    @Override
    public void savePlayer(Player player, boolean removeOnline) {
        this.repository.save(new Character(player));
    }
}
