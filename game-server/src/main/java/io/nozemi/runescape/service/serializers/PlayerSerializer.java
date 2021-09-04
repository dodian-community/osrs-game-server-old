package io.nozemi.runescape.service.serializers;


import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.uid.UIDProvider;
import io.nozemi.runescape.net.message.LoginRequestMessage;
import io.nozemi.runescape.service.Service;
import io.nozemi.runescape.orm.models.Character;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public abstract class PlayerSerializer implements Service {

    protected UIDProvider uidProvider;

    public abstract boolean loadPlayer(Player player, Object uid, String password, Consumer<PlayerLoadResult> fn, LoginRequestMessage loginRequestMessage);

    public abstract void savePlayer(Player player, boolean removeOnline);

    @Override
    public void setup() {
        // Implementation varies per serializer
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public boolean start() {
        return true;
    }

    @Override
    public boolean stop() {
        return true;
    }

    protected Character createCharacter(Player player) {
        Character character = new Character(player);
        character.setPosition(new Tile(2606, 3102));
        character.setRunEnergy(100.0);
        character.updatePlayer(player);
        return character;
    }
}
