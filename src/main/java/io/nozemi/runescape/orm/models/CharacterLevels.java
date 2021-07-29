package io.nozemi.runescape.orm.models;

import io.nozemi.runescape.model.entity.player.Skills;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CharacterLevels {
    @Column(columnDefinition = "int default 1")
    private int attackLevel;
    @Column(columnDefinition = "int default 1")
    private int defenceLevel;
    @Column(columnDefinition = "int default 1")
    private int strengthLevel;
    @Column(columnDefinition = "int default 10")
    private int hitpointsLevel;
    @Column(columnDefinition = "int default 1")
    private int rangedLevel;
    @Column(columnDefinition = "int default 1")
    private int prayerLevel;
    @Column(columnDefinition = "int default 1")
    private int magicLevel;
    @Column(columnDefinition = "int default 1")
    private int cookingLevel;
    @Column(columnDefinition = "int default 1")
    private int woodcuttingLevel;
    @Column(columnDefinition = "int default 1")
    private int fletchingLevel;
    @Column(columnDefinition = "int default 1")
    private int fishingLevel;
    @Column(columnDefinition = "int default 1")
    private int firemakingLevel;
    @Column(columnDefinition = "int default 1")
    private int craftingLevel;
    @Column(columnDefinition = "int default 1")
    private int smithingLevel;
    @Column(columnDefinition = "int default 1")
    private int miningLevel;
    @Column(columnDefinition = "int default 1")
    private int herbloreLevel;
    @Column(columnDefinition = "int default 1")
    private int agilityLevel;
    @Column(columnDefinition = "int default 1")
    private int thievingLevel;
    @Column(columnDefinition = "int default 1")
    private int slayerLevel;
    @Column(columnDefinition = "int default 1")
    private int farmingLevel;
    @Column(columnDefinition = "int default 1")
    private int runecraftingLevel;
    @Column(columnDefinition = "int default 1")
    private int hunterLevel;
    @Column(columnDefinition = "int default 1")
    private int constructionLevel;
    
    public CharacterLevels() {
        
    }
    
    public CharacterLevels(Skills skills) {
        this.attackLevel = skills.levels()[Skills.ATTACK];
        this.defenceLevel = skills.levels()[Skills.DEFENCE];
        this.strengthLevel = skills.levels()[Skills.STRENGTH];
        this.hitpointsLevel = skills.levels()[Skills.HITPOINTS];
        this.rangedLevel = skills.levels()[Skills.RANGED];
        this.prayerLevel = skills.levels()[Skills.PRAYER];
        this.magicLevel = skills.levels()[Skills.MAGIC];
        this.cookingLevel = skills.levels()[Skills.COOKING];
        this.woodcuttingLevel = skills.levels()[Skills.WOODCUTTING];
        this.fletchingLevel = skills.levels()[Skills.FLETCHING];
        this.fishingLevel = skills.levels()[Skills.FISHING];
        this.firemakingLevel = skills.levels()[Skills.FIREMAKING];
        this.craftingLevel = skills.levels()[Skills.CRAFTING];
        this.smithingLevel = skills.levels()[Skills.SMITHING];
        this.miningLevel = skills.levels()[Skills.MINING];
        this.herbloreLevel = skills.levels()[Skills.HERBLORE];
        this.agilityLevel = skills.levels()[Skills.AGILITY];
        this.thievingLevel = skills.levels()[Skills.THIEVING];
        this.slayerLevel = skills.levels()[Skills.SLAYER];
        this.farmingLevel = skills.levels()[Skills.FARMING];
        this.runecraftingLevel = skills.levels()[Skills.RUNECRAFTING];
        this.hunterLevel = skills.levels()[Skills.HUNTER];
        this.constructionLevel = skills.levels()[Skills.CONSTRUCTION];
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getDefenceLevel() {
        return defenceLevel;
    }

    public void setDefenceLevel(int defenceLevel) {
        this.defenceLevel = defenceLevel;
    }

    public int getStrengthLevel() {
        return strengthLevel;
    }

    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    public int getHitpointsLevel() {
        return hitpointsLevel;
    }

    public void setHitpointsLevel(int hitpointsLevel) {
        this.hitpointsLevel = hitpointsLevel;
    }

    public int getRangedLevel() {
        return rangedLevel;
    }

    public void setRangedLevel(int rangedLevel) {
        this.rangedLevel = rangedLevel;
    }

    public int getPrayerLevel() {
        return prayerLevel;
    }

    public void setPrayerLevel(int prayerLevel) {
        this.prayerLevel = prayerLevel;
    }

    public int getMagicLevel() {
        return magicLevel;
    }

    public void setMagicLevel(int magicLevel) {
        this.magicLevel = magicLevel;
    }

    public int getCookingLevel() {
        return cookingLevel;
    }

    public void setCookingLevel(int cookingLevel) {
        this.cookingLevel = cookingLevel;
    }

    public int getWoodcuttingLevel() {
        return woodcuttingLevel;
    }

    public void setWoodcuttingLevel(int woodcuttingLevel) {
        this.woodcuttingLevel = woodcuttingLevel;
    }

    public int getFletchingLevel() {
        return fletchingLevel;
    }

    public void setFletchingLevel(int fletchingLevel) {
        this.fletchingLevel = fletchingLevel;
    }

    public int getFishingLevel() {
        return fishingLevel;
    }

    public void setFishingLevel(int fishingLevel) {
        this.fishingLevel = fishingLevel;
    }

    public int getFiremakingLevel() {
        return firemakingLevel;
    }

    public void setFiremakingLevel(int firemakingLevel) {
        this.firemakingLevel = firemakingLevel;
    }

    public int getCraftingLevel() {
        return craftingLevel;
    }

    public void setCraftingLevel(int craftingLevel) {
        this.craftingLevel = craftingLevel;
    }

    public int getSmithingLevel() {
        return smithingLevel;
    }

    public void setSmithingLevel(int smithingLevel) {
        this.smithingLevel = smithingLevel;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public void setMiningLevel(int miningLevel) {
        this.miningLevel = miningLevel;
    }

    public int getHerbloreLevel() {
        return herbloreLevel;
    }

    public void setHerbloreLevel(int herbloreLevel) {
        this.herbloreLevel = herbloreLevel;
    }

    public int getAgilityLevel() {
        return agilityLevel;
    }

    public void setAgilityLevel(int agilityLevel) {
        this.agilityLevel = agilityLevel;
    }

    public int getThievingLevel() {
        return thievingLevel;
    }

    public void setThievingLevel(int thievingLevel) {
        this.thievingLevel = thievingLevel;
    }

    public int getSlayerLevel() {
        return slayerLevel;
    }

    public void setSlayerLevel(int slayerLevel) {
        this.slayerLevel = slayerLevel;
    }

    public int getFarmingLevel() {
        return farmingLevel;
    }

    public void setFarmingLevel(int farmingLevel) {
        this.farmingLevel = farmingLevel;
    }

    public int getRunecraftingLevel() {
        return runecraftingLevel;
    }

    public void setRunecraftingLevel(int runecraftingLevel) {
        this.runecraftingLevel = runecraftingLevel;
    }

    public int getHunterLevel() {
        return hunterLevel;
    }

    public void setHunterLevel(int hunterLevel) {
        this.hunterLevel = hunterLevel;
    }

    public int getConstructionLevel() {
        return constructionLevel;
    }

    public void setConstructionLevel(int constructionLevel) {
        this.constructionLevel = constructionLevel;
    }
}
