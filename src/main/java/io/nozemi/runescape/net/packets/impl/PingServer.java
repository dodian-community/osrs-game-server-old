package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import org.springframework.stereotype.Component;

@Component
public class PingServer extends GamePacket {

    @Override
    public PingServer createFrom(RSBuffer packet) {
        return this;
    }
}
