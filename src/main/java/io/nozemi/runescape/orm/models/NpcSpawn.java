package io.nozemi.runescape.orm.models;

import io.nozemi.runescape.util.SpawnDirection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NpcSpawn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int npcId;
    private int x;
    private int y;
    private int level;
    private int health;
    private boolean taskRequired;
    private int respawnDelay;
    private int combatLevel;
    private int walkRadius;
    private SpawnDirection direction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNpcId() {
        return npcId;
    }

    public void setNpcId(int npcId) {
        this.npcId = npcId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isTaskRequired() {
        return taskRequired;
    }

    public void setTaskRequired(boolean taskRequired) {
        this.taskRequired = taskRequired;
    }

    public int getRespawnDelay() {
        return respawnDelay;
    }

    public void setRespawnDelay(int respawnDelay) {
        this.respawnDelay = respawnDelay;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public void setCombatLevel(int combatLevel) {
        this.combatLevel = combatLevel;
    }

    public int getWalkRadius() {
        return walkRadius;
    }

    public void setWalkRadius(int walkRadius) {
        this.walkRadius = walkRadius;
    }

    public SpawnDirection getDirection() {
        return direction;
    }

    public void setDirection(SpawnDirection direction) {
        this.direction = direction;
    }
}
