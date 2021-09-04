package io.nozemi.runescape.service.serializers;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.LoginRequestMessage;
import io.nozemi.runescape.orm.models.User;
import io.nozemi.runescape.orm.repositories.CharactersRepository;
import io.nozemi.runescape.orm.models.Character;
import io.nozemi.runescape.orm.repositories.UsersRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;

@Component
public class SpringSerializer extends PlayerSerializer {

    private final static Logger logger = LogManager.getLogger(SpringSerializer.class);

    private final CharactersRepository charactersRepository;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final GoogleAuthenticator authenticaor;

    @Autowired
    public SpringSerializer(CharactersRepository charactersRepository, UsersRepository usersRepository) {
        this.charactersRepository = charactersRepository;
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.authenticaor = new GoogleAuthenticator();
    }

    @Override
    public boolean loadPlayer(Player player, Object uid, String password, Consumer<PlayerLoadResult> fn, LoginRequestMessage loginRequestMessage) {
        Optional<User> oUser = usersRepository.findFirstByUsername(loginRequestMessage.username());
        if(oUser.isEmpty()) {
            oUser = usersRepository.findFirstByEmail(loginRequestMessage.username());
        }

        if(oUser.isEmpty()) {
            User newUser = new User();
            newUser.setUsername(loginRequestMessage.username());
            newUser.setPassword(passwordEncoder.encode(password));
            usersRepository.save(newUser);
            oUser = usersRepository.findFirstByUsername(loginRequestMessage.username());
        }

        User user = oUser.get();

        player.userId(user.getId());
        player.id(user.getId());

        // Make sure that we can never allow players to login without password unless server is in development mode!
        if(!GameInitializer.isDevServer()
        || !GameInitializer.config().hasPath("account.check-password")
        || GameInitializer.config().getBoolean("account.check-password")) {
            if(!passwordEncoder.matches(loginRequestMessage.password(), user.getPassword())) {
                fn.accept(PlayerLoadResult.INVALID_DETAILS);
                return false;
            }
        }

        boolean check2fa = true;
        if(GameInitializer.config().hasPath("account.check-2fa")) {
            check2fa = GameInitializer.config().getBoolean("account.check-2fa");
        }

        // Make sure we only allow not checking for 2FA if server is in development mode.
        if((!GameInitializer.isTestServer() || check2fa) && user.getTwoFactorSecret() != null) {
            player.mfaEnabled(true);
            if(!authenticaor.authorize(user.getTwoFactorSecret(), loginRequestMessage.authPin())) {
                fn.accept(loginRequestMessage.authPin() == -1 ? PlayerLoadResult.ENTER_AUTH : PlayerLoadResult.AUTH_MISMATCH);
                return true;
            }
        }

        Optional<Character> optionalCharacter = charactersRepository.findFirstByUsername(player.username());
        if(optionalCharacter.isPresent()) {
            optionalCharacter.get().updatePlayer(player);
            logger.info("Loading existing character.");
        } else {
            player.putattrib(AttributeKey.NEW_ACCOUNT, true);
            this.createCharacter(player);
            logger.info("Creating new character.");
            savePlayer(player, false);
        }

        fn.accept(PlayerLoadResult.OK);
        return true;
    }

    @Override
    public void savePlayer(Player player, boolean removeOnline) {
        Character character = this.charactersRepository.findFirstByUsername(player.username())
                .orElse(new Character(player));

        character.update(player);

        this.charactersRepository.save(character);
    }
}
