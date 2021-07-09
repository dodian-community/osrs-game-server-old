package io.nozemi.runescape.net.message;

public class PreLoginResponseMessage {

    private final int serverBit;

    public PreLoginResponseMessage(int serverBit) {
        this.serverBit = serverBit;
    }
}
