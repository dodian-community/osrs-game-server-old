package io.nozemi.runescape.service.login;

import io.nozemi.runescape.net.message.LoginRequestMessage;
import io.nozemi.runescape.service.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

@Component
public class LoginService implements Service {

    private static final Logger logger = LogManager.getLogger(LoginService.class);

    private LinkedBlockingQueue<LoginRequestMessage> messages = new LinkedBlockingQueue<>();

    @Override
    public void setup() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void isAlive() {

    }

    public void enqueue(LoginRequestMessage message) {
        messages.add(message);
    }
}
