package net.dodian.runescape.content.tools.editmode.modes;

import net.dodian.runescape.util.SpawnDirection;

public abstract class NpcMode implements EditorMode {
    protected int npcId;
    protected int walkRadius;
    protected SpawnDirection spawnDirection;
    protected int respawnTimer;

    public int getNpcId() {
        return npcId;
    }

    public int getWalkRadius() {
        return walkRadius;
    }

    public SpawnDirection getSpawnDirection() {
        return spawnDirection;
    }

    public void setNpcId(int npcId) {
        this.npcId = npcId;
    }

    public void setSpawnDirection(SpawnDirection spawnDirection) {
        this.spawnDirection = spawnDirection;
    }

    public void setWalkRadius(int walkRadius) {
        this.walkRadius = walkRadius;
    }

    public int getRespawnTimer() {
        return respawnTimer;
    }

    public void setRespawnTimer(int respawnTimer) {
        this.respawnTimer = respawnTimer;
    }
}
