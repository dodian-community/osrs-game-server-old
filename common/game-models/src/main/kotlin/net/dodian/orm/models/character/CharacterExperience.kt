package net.dodian.orm.models.character

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class CharacterExperience {
    @Column(columnDefinition = "double precision default 0.0")
    var attackExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var defenceExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var strengthExperience = 0.0

    @Column(columnDefinition = "double precision default 1140.0")
    var hitpointsExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var rangedExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var prayerExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var magicExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var cookingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var woodcuttingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var fletchingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var fishingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var firemakingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var craftingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var smithingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var miningExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var herbloreExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var agilityExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var thievingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var slayerExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var farmingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var runecraftingExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var hunterExperience = 0.0

    @Column(columnDefinition = "double precision default 0.0")
    var constructionExperience = 0.0

    constructor()

    constructor(
        attackExperience: Double,
        defenceExperience: Double,
        strengthExperience: Double,
        hitpointsExperience: Double,
        rangedExperience: Double,
        prayerExperience: Double,
        magicExperience: Double,
        cookingExperience: Double,
        woodcuttingExperience: Double,
        fletchingExperience: Double,
        fishingExperience: Double,
        firemakingExperience: Double,
        craftingExperience: Double,
        smithingExperience: Double,
        miningExperience: Double,
        herbloreExperience: Double,
        agilityExperience: Double,
        thievingExperience: Double,
        slayerExperience: Double,
        farmingExperience: Double,
        runecraftingExperience: Double,
        hunterExperience: Double,
        constructionExperience: Double
    ) {
        this.attackExperience = attackExperience
        this.defenceExperience = defenceExperience
        this.strengthExperience = strengthExperience
        this.hitpointsExperience = hitpointsExperience
        this.rangedExperience = rangedExperience
        this.prayerExperience = prayerExperience
        this.magicExperience = magicExperience
        this.cookingExperience = cookingExperience
        this.woodcuttingExperience = woodcuttingExperience
        this.fletchingExperience = fletchingExperience
        this.fishingExperience = fishingExperience
        this.firemakingExperience = firemakingExperience
        this.craftingExperience = craftingExperience
        this.smithingExperience = smithingExperience
        this.miningExperience = miningExperience
        this.herbloreExperience = herbloreExperience
        this.agilityExperience = agilityExperience
        this.thievingExperience = thievingExperience
        this.slayerExperience = slayerExperience
        this.farmingExperience = farmingExperience
        this.runecraftingExperience = runecraftingExperience
        this.hunterExperience = hunterExperience
        this.constructionExperience = constructionExperience
    }
}