package io.nozemi.web.models;

import io.nozemi.runescape.model.World;

public class WorldInfo {
    /**
     * Server's player count.
     */
    private final int playerCount;

    /**
     * Server's uptime in seconds.
     */
    private final long uptime;

    private final long totalMemory;
    private final long freeMemory;
    private final long reservedMemory;

    public WorldInfo(World world) {
        playerCount = world.players().size();
        uptime = (System.currentTimeMillis() - world.getWorldStartup()) / 1000;

        long totalMem = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long freeMem = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        long maxMem = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        this.totalMemory = totalMem;
        this.freeMemory = freeMem;
        this.reservedMemory = maxMem;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public long getUptime() {
        return uptime;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public long getReservedMemory() {
        return reservedMemory;
    }

    public long getTotalMemory() {
        return totalMemory;
    }
}
