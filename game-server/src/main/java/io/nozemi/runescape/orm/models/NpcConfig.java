package io.nozemi.runescape.orm.models;

import io.nozemi.runescape.orm.converters.IntArrayConverter;

import javax.persistence.*;

@Entity
@Table(name = "npc_configs")
public class NpcConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int npcId;
    private String name;
    @Column(columnDefinition = "integer default 3")
    private int combatLevel;
    @Column(columnDefinition = "integer default 20")
    private int health;
    @Column(columnDefinition = "boolean default true")
    private boolean retaliates;
    @Column(columnDefinition = "boolean default false")
    private boolean unstacked;
    @Column(columnDefinition = "integer default 60")
    private int respawnTime;
    @Column(columnDefinition = "integer default 0")
    private int respawnTimeRandomOffset;
    @Column(columnDefinition = "boolean default false")
    private boolean attackAble;
    @Column(columnDefinition = "boolean default false")
    private boolean boss;
    @Column(columnDefinition = "integer default 1")
    private int dropRolls;

    @Column(columnDefinition = "boolean default false")
    private boolean slayerRequired;
    @Column(columnDefinition = "integer default 0")
    private int slayerLevel;
    @Column(columnDefinition = "integer default 0")
    private int slayerExperience;

    @Column(columnDefinition = "boolean default false")
    private boolean aggressive;
    @Column(columnDefinition = "integer default 0")
    private int aggroRadius;

    @Column(columnDefinition = "integer default 4")
    private int attackSpeed;
    @Column(columnDefinition = "integer default 2")
    private int maxHit;

    @Convert(converter = IntArrayConverter.class)
    private Integer[] attackSound;
    @Convert(converter = IntArrayConverter.class)
    private Integer[] blockSound;
    @Convert(converter = IntArrayConverter.class)
    private Integer[] deathSound;

    @Column(columnDefinition = "integer default -1")
    private int attackAnimation;
    @Column(columnDefinition = "integer default -1")
    private int blockAnimation;
    @Column(columnDefinition = "integer default -1")
    private int deathAnimation;

    @Column(columnDefinition = "integer default 0")
    private int attackBonus;
    @Column(columnDefinition = "integer default 0")
    private int magicBonus;
    @Column(columnDefinition = "integer default 0")
    private int rangedBonus;
    @Column(columnDefinition = "integer default 0")
    private int strengthBonus;
    @Column(columnDefinition = "integer default 0")
    private int stabDefenceBonus;
    @Column(columnDefinition = "integer default 0")
    private int slashDefenceBonus;
    @Column(columnDefinition = "integer default 0")
    private int crushDefenceBonus;
    @Column(columnDefinition = "integer default 0")
    private int rangedDefenceBonus;
    @Column(columnDefinition = "integer default 0")
    private int magicDefenceBonus;

    @Column(columnDefinition = "integer default 1")
    private int attackLevel;
    @Column(columnDefinition = "integer default 1")
    private int strengthLevel;
    @Column(columnDefinition = "integer default 1")
    private int defenceLevel;
    @Column(columnDefinition = "integer default 1")
    private int magicLevel;
    @Column(columnDefinition = "integer default 1")
    private int rangedLevel;

    private String hitScript;
    private String combatScript;
    private String dropTableScript;
    private String deathScript;
    private String aggressionScript;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public void setCombatLevel(int combatLevel) {
        this.combatLevel = combatLevel;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isRetaliating() {
        return retaliates;
    }

    public void setRetaliates(boolean retaliates) {
        this.retaliates = retaliates;
    }

    public boolean isUnstacked() {
        return unstacked;
    }

    public void setUnstacked(boolean unstacked) {
        this.unstacked = unstacked;
    }

    public int getRespawnTime() {
        return respawnTime;
    }

    public void setRespawnTime(int respawnTime) {
        this.respawnTime = respawnTime;
    }

    public int getRespawnTimeRandomOffset() {
        return respawnTimeRandomOffset;
    }

    public void setRespawnTimeRandomOffset(int respawnTimeRandomOffset) {
        this.respawnTimeRandomOffset = respawnTimeRandomOffset;
    }

    public boolean isAttackAble() {
        return attackAble;
    }

    public void setAttackAble(boolean attackAble) {
        this.attackAble = attackAble;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public int getDropRolls() {
        return dropRolls;
    }

    public void setDropRolls(int dropRolls) {
        this.dropRolls = dropRolls;
    }

    public boolean isSlayerRequired() {
        return slayerRequired;
    }

    public void setSlayerRequired(boolean slayerRequired) {
        this.slayerRequired = slayerRequired;
    }

    public int getSlayerLevel() {
        return slayerLevel;
    }

    public void setSlayerLevel(int slayerLevel) {
        this.slayerLevel = slayerLevel;
    }

    public int getSlayerExperience() {
        return slayerExperience;
    }

    public void setSlayerExperience(int slayerExperience) {
        this.slayerExperience = slayerExperience;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public void setAggressive(boolean aggressive) {
        this.aggressive = aggressive;
    }

    public int getAggroRadius() {
        return aggroRadius;
    }

    public void setAggroRadius(int aggroRadius) {
        this.aggroRadius = aggroRadius;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getMaxHit() {
        return maxHit;
    }

    public void setMaxHit(int maxHit) {
        this.maxHit = maxHit;
    }

    public Integer[] getAttackSound() {
        return attackSound;
    }

    public void setAttackSound(Integer[] attackSound) {
        this.attackSound = attackSound;
    }

    public Integer[] getBlockSound() {
        return blockSound;
    }

    public void setBlockSound(Integer[] blockSound) {
        this.blockSound = blockSound;
    }

    public Integer[] getDeathSound() {
        return deathSound;
    }

    public void setDeathSound(Integer[] deathSound) {
        this.deathSound = deathSound;
    }

    public int getAttackAnimation() {
        return attackAnimation;
    }

    public void setAttackAnimation(int attackAnimation) {
        this.attackAnimation = attackAnimation;
    }

    public int getBlockAnimation() {
        return blockAnimation;
    }

    public void setBlockAnimation(int blockAnimation) {
        this.blockAnimation = blockAnimation;
    }

    public int getDeathAnimation() {
        return deathAnimation;
    }

    public void setDeathAnimation(int deathAnimation) {
        this.deathAnimation = deathAnimation;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getMagicBonus() {
        return magicBonus;
    }

    public void setMagicBonus(int magicBonus) {
        this.magicBonus = magicBonus;
    }

    public int getRangedBonus() {
        return rangedBonus;
    }

    public void setRangedBonus(int rangedBonus) {
        this.rangedBonus = rangedBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public int getStabDefenceBonus() {
        return stabDefenceBonus;
    }

    public void setStabDefenceBonus(int stabDefenceBonus) {
        this.stabDefenceBonus = stabDefenceBonus;
    }

    public int getSlashDefenceBonus() {
        return slashDefenceBonus;
    }

    public void setSlashDefenceBonus(int slashDefenceBonus) {
        this.slashDefenceBonus = slashDefenceBonus;
    }

    public int getCrushDefenceBonus() {
        return crushDefenceBonus;
    }

    public void setCrushDefenceBonus(int crushDefenceBonus) {
        this.crushDefenceBonus = crushDefenceBonus;
    }

    public int getRangedDefenceBonus() {
        return rangedDefenceBonus;
    }

    public void setRangedDefenceBonus(int rangedDefenceBonus) {
        this.rangedDefenceBonus = rangedDefenceBonus;
    }

    public int getMagicDefenceBonus() {
        return magicDefenceBonus;
    }

    public void setMagicDefenceBonus(int magicDefenceBonus) {
        this.magicDefenceBonus = magicDefenceBonus;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getStrengthLevel() {
        return strengthLevel;
    }

    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    public int getDefenceLevel() {
        return defenceLevel;
    }

    public void setDefenceLevel(int defenceLevel) {
        this.defenceLevel = defenceLevel;
    }

    public int getMagicLevel() {
        return magicLevel;
    }

    public void setMagicLevel(int magicLevel) {
        this.magicLevel = magicLevel;
    }

    public int getRangedLevel() {
        return rangedLevel;
    }

    public void setRangedLevel(int rangedLevel) {
        this.rangedLevel = rangedLevel;
    }

    public String getHitScript() {
        return hitScript;
    }

    public void setHitScript(String hitScript) {
        this.hitScript = hitScript;
    }

    public String getCombatScript() {
        return combatScript;
    }

    public void setCombatScript(String combatScript) {
        this.combatScript = combatScript;
    }

    public String getDropTableScript() {
        return dropTableScript;
    }

    public void setDropTableScript(String dropTableScript) {
        this.dropTableScript = dropTableScript;
    }

    public String getDeathScript() {
        return deathScript;
    }

    public void setDeathScript(String deathScript) {
        this.deathScript = deathScript;
    }

    public String getAggressionScript() {
        return aggressionScript;
    }

    public void setAggressionScript(String aggressionScript) {
        this.aggressionScript = aggressionScript;
    }
}
