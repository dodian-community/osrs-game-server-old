package io.nozemi.runescape.net.message;

import io.netty.channel.Channel;

public class LoginRequestMessage {
    private final Channel channel;
    private final String username;
    private final String password;
    private final int[] isaacSeed;
    private final int[] crcs;
    private int revision;
    private final byte[] randomDat;
    private int displayMode;
    private final boolean resizableInterfaces;
    private final String uuid;
    private final String hwid;
    private final String macAddress;
    private final int authPin;
    private long delayedUntil;
    private int retries;

    public LoginRequestMessage(Channel channel, String username, String password, int[] isaacSeed, int[] crcs,
                               int revision, byte[] randomDat, boolean resizableInterfaces, String uuid, int authPin,
                               String hwid, String macAddress) {
        this.channel = channel;
        this.username = username;
        this.password = password;
        this.isaacSeed = isaacSeed;
        this.crcs = crcs;
        this.retries = revision;
        this.randomDat = randomDat;
        this.resizableInterfaces = resizableInterfaces;
        this.uuid = uuid;
        this.hwid = hwid;
        this.macAddress = macAddress;
        this.authPin = authPin;
    }

    public String username() {
        return this.username;
    }

    public String password() {
        return this.password;
    }

    public int[] isaacSeed() {
        return this.isaacSeed;
    }

    public int[] crcs() {
        return this.crcs;
    }

    public int revision() {
        return this.retries;
    }

    public int authPin() {
        return this.authPin;
    }

    public byte[] randomDat() {
        return this.randomDat;
    }

    public String uuid() {
        return this.uuid;
    }

    public String hwid() {
        return this.hwid;
    }

    public String macAddress() {
        return this.macAddress;
    }

    public boolean resizableInterfaces() {
        return this.resizableInterfaces;
    }

    public Channel channel() {
        return this.channel;
    }

    public long delayedUntil() {
        return this.delayedUntil;
    }

    public void delayedUntil(long l) {
        this.delayedUntil = l;
    }

    public int retries() {
        return this.retries;
    }

    public void addRetry() {
        this.retries++;
    }
}
