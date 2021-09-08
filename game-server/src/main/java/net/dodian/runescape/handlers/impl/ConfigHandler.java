package net.dodian.runescape.handlers.impl;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.dodian.runescape.handlers.Handler;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ConfigHandler implements Handler {

    private static final File configFile = new File("./server.conf");

    private Config config;

    @Override
    public void initialize() {
        this.config = ConfigFactory.systemProperties()
                .withFallback(ConfigFactory.parseFileAnySyntax(configFile));
    }

    public Config config() {
        return config;
    }
}
