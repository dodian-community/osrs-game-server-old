package io.nozemi.runescape.orm.models;

import io.nozemi.runescape.model.entity.player.Skills;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CharacterExperience {
    @Column(columnDefinition = "double precision default 0.0")
    private double attackExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double defenceExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double strengthExperience;
    @Column(columnDefinition = "double precision default 1140.0")
    private double hitpointsExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double rangedExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double prayerExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double magicExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double cookingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double woodcuttingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double fletchingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double fishingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double firemakingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double craftingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double smithingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double miningExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double herbloreExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double agilityExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double thievingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double slayerExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double farmingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double runecraftingExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double hunterExperience;
    @Column(columnDefinition = "double precision default 0.0")
    private double constructionExperience;

    public CharacterExperience() {

    }

    public CharacterExperience(Skills skills) {
        this.attackExperience = skills.xp()[Skills.ATTACK];
        this.defenceExperience = skills.xp()[Skills.DEFENCE];
        this.strengthExperience = skills.xp()[Skills.STRENGTH];
        this.hitpointsExperience = skills.xp()[Skills.HITPOINTS];
        this.rangedExperience = skills.xp()[Skills.RANGED];
        this.prayerExperience = skills.xp()[Skills.PRAYER];
        this.magicExperience = skills.xp()[Skills.MAGIC];
        this.cookingExperience = skills.xp()[Skills.COOKING];
        this.woodcuttingExperience = skills.xp()[Skills.WOODCUTTING];
        this.fletchingExperience = skills.xp()[Skills.FLETCHING];
        this.fishingExperience = skills.xp()[Skills.FISHING];
        this.firemakingExperience = skills.xp()[Skills.FIREMAKING];
        this.craftingExperience = skills.xp()[Skills.CRAFTING];
        this.smithingExperience = skills.xp()[Skills.SMITHING];
        this.miningExperience = skills.xp()[Skills.MINING];
        this.herbloreExperience = skills.xp()[Skills.HERBLORE];
        this.agilityExperience = skills.xp()[Skills.AGILITY];
        this.thievingExperience = skills.xp()[Skills.THIEVING];
        this.slayerExperience = skills.xp()[Skills.SLAYER];
        this.farmingExperience = skills.xp()[Skills.FARMING];
        this.runecraftingExperience = skills.xp()[Skills.RUNECRAFTING];
        this.hunterExperience = skills.xp()[Skills.HUNTER];
        this.constructionExperience = skills.xp()[Skills.CONSTRUCTION];
    }

    public double getAttackExperience() {
        return attackExperience;
    }

    public void setAttackExperience(double attackExperience) {
        this.attackExperience = attackExperience;
    }

    public double getDefenceExperience() {
        return defenceExperience;
    }

    public void setDefenceExperience(double defenceExperience) {
        this.defenceExperience = defenceExperience;
    }

    public double getStrengthExperience() {
        return strengthExperience;
    }

    public void setStrengthExperience(double strengthExperience) {
        this.strengthExperience = strengthExperience;
    }

    public double getHitpointsExperience() {
        return hitpointsExperience;
    }

    public void setHitpointsExperience(double hitpointsExperience) {
        this.hitpointsExperience = hitpointsExperience;
    }

    public double getRangedExperience() {
        return rangedExperience;
    }

    public void setRangedExperience(double rangedExperience) {
        this.rangedExperience = rangedExperience;
    }

    public double getPrayerExperience() {
        return prayerExperience;
    }

    public void setPrayerExperience(double prayerExperience) {
        this.prayerExperience = prayerExperience;
    }

    public double getMagicExperience() {
        return magicExperience;
    }

    public void setMagicExperience(double magicExperience) {
        this.magicExperience = magicExperience;
    }

    public double getCookingExperience() {
        return cookingExperience;
    }

    public void setCookingExperience(double cookingExperience) {
        this.cookingExperience = cookingExperience;
    }

    public double getWoodcuttingExperience() {
        return woodcuttingExperience;
    }

    public void setWoodcuttingExperience(double woodcuttingExperience) {
        this.woodcuttingExperience = woodcuttingExperience;
    }

    public double getFletchingExperience() {
        return fletchingExperience;
    }

    public void setFletchingExperience(double fletchingExperience) {
        this.fletchingExperience = fletchingExperience;
    }

    public double getFishingExperience() {
        return fishingExperience;
    }

    public void setFishingExperience(double fishingExperience) {
        this.fishingExperience = fishingExperience;
    }

    public double getFiremakingExperience() {
        return firemakingExperience;
    }

    public void setFiremakingExperience(double firemakingExperience) {
        this.firemakingExperience = firemakingExperience;
    }

    public double getCraftingExperience() {
        return craftingExperience;
    }

    public void setCraftingExperience(double craftingExperience) {
        this.craftingExperience = craftingExperience;
    }

    public double getSmithingExperience() {
        return smithingExperience;
    }

    public void setSmithingExperience(double smithingExperience) {
        this.smithingExperience = smithingExperience;
    }

    public double getMiningExperience() {
        return miningExperience;
    }

    public void setMiningExperience(double miningExperience) {
        this.miningExperience = miningExperience;
    }

    public double getHerbloreExperience() {
        return herbloreExperience;
    }

    public void setHerbloreExperience(double herbloreExperience) {
        this.herbloreExperience = herbloreExperience;
    }

    public double getAgilityExperience() {
        return agilityExperience;
    }

    public void setAgilityExperience(double agilityExperience) {
        this.agilityExperience = agilityExperience;
    }

    public double getThievingExperience() {
        return thievingExperience;
    }

    public void setThievingExperience(double thievingExperience) {
        this.thievingExperience = thievingExperience;
    }

    public double getSlayerExperience() {
        return slayerExperience;
    }

    public void setSlayerExperience(double slayerExperience) {
        this.slayerExperience = slayerExperience;
    }

    public double getFarmingExperience() {
        return farmingExperience;
    }

    public void setFarmingExperience(double farmingExperience) {
        this.farmingExperience = farmingExperience;
    }

    public double getRunecraftingExperience() {
        return runecraftingExperience;
    }

    public void setRunecraftingExperience(double runecraftingExperience) {
        this.runecraftingExperience = runecraftingExperience;
    }

    public double getHunterExperience() {
        return hunterExperience;
    }

    public void setHunterExperience(double hunterExperience) {
        this.hunterExperience = hunterExperience;
    }

    public double getConstructionExperience() {
        return constructionExperience;
    }

    public void setConstructionExperience(double constructionExperience) {
        this.constructionExperience = constructionExperience;
    }
}
