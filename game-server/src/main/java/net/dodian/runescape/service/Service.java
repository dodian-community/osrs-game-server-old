package net.dodian.runescape.service;

import org.springframework.stereotype.Component;

@Component
public interface Service {
    void setup();
    boolean start();
    boolean stop();
    boolean isAlive();
}
