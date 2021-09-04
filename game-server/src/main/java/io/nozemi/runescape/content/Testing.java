package io.nozemi.runescape.content;

import io.nozemi.runescape.events.ScriptRepository;
import io.nozemi.runescape.events.ScriptMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Testing {

    private static Logger logger = LogManager.getLogger(Testing.class);

    @ScriptMain
    public static void loggedIn(ScriptRepository scriptRepository) {
        scriptRepository.onNpcAction1(1306, script -> {
            script.player().chatNpc("You're now chatting with me! Believe it or not!", script.targetNpc(), 588)
                    .setAction(() -> {
                        script.player().getDialogueHandler().terminate();
                    });
            script.targetNpc().face(script.player());
            return null;
        });
    }
}
