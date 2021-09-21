package net.dodian.runescape.service.logging;

import net.dodian.runescape.services.Service;
import org.springframework.stereotype.Component;

@Component
public class DataLoggingService implements Service {

    @Override
    public void setup() {

    }

    @Override
    public boolean start() {
        return true;
    }

    @Override
    public boolean stop() {
        return true;
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
