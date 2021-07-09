package io.nozemi.runescape.service;

import org.springframework.stereotype.Component;

@Component
public interface Service {
    void setup();
    void start();
    void stop();
    void isAlive();
}
