package io.nozemi.runescape.orm.models;

import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.util.SpawnDirection;

import javax.persistence.*;

@Entity
@Table(name = "npc_spawns")
public class NpcSpawn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int npcId;
    private int x;
    private int y;
    private int level;
    private int health;
    @Column(columnDefinition = "boolean default false", nullable = true)
    private boolean taskRequired;
    @Column(columnDefinition = "integer default 0", nullable = true)
    private int slayerExperience;
    @Column(columnDefinition = "integer default 0", nullable = true)
    private int slayerLevel;
    private int respawnDelay;
    private int combatLevel;
    private int walkRadius;
    private SpawnDirection direction;
    @Column(columnDefinition = "boolean default false", nullable = true)
    private boolean attackAble;

    public NpcSpawn() {

    }

    public NpcSpawn(Npc npc) {
        this.npcId = npc.id();
        this.x = npc.tile().x;
        this.y = npc.tile().z;
        this.level = npc.tile().level;
        this.walkRadius = npc.walkRadius();
        this.direction = SpawnDirection.getById(npc.spawnDirection());

        this.respawnDelay = 0;
        this.combatLevel = 0;
        this.taskRequired = false;
        this.health = 0;
    }

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

    public int getSlayerExperience() {
        return slayerExperience;
    }

    public void setSlayerExperience(int slayerExperience) {
        this.slayerExperience = slayerExperience;
    }

    public void setSlayerLevel(int slayerLevel) {
        this.slayerLevel = slayerLevel;
    }

    public int getSlayerLevel() {
        return slayerLevel;
    }

    public boolean isAttackAble() {
        return attackAble;
    }
}
