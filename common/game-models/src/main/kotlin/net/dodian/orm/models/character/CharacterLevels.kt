package net.dodian.orm.models.character

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class CharacterLevels {
    @Column(columnDefinition = "int default 1")
    var attackLevel = 0

    @Column(columnDefinition = "int default 1")
    var defenceLevel = 0

    @Column(columnDefinition = "int default 1")
    var strengthLevel = 0

    @Column(columnDefinition = "int default 10")
    var hitpointsLevel = 0

    @Column(columnDefinition = "int default 1")
    var rangedLevel = 0

    @Column(columnDefinition = "int default 1")
    var prayerLevel = 0

    @Column(columnDefinition = "int default 1")
    var magicLevel = 0

    @Column(columnDefinition = "int default 1")
    var cookingLevel = 0

    @Column(columnDefinition = "int default 1")
    var woodcuttingLevel = 0

    @Column(columnDefinition = "int default 1")
    var fletchingLevel = 0

    @Column(columnDefinition = "int default 1")
    var fishingLevel = 0

    @Column(columnDefinition = "int default 1")
    var firemakingLevel = 0

    @Column(columnDefinition = "int default 1")
    var craftingLevel = 0

    @Column(columnDefinition = "int default 1")
    var smithingLevel = 0

    @Column(columnDefinition = "int default 1")
    var miningLevel = 0

    @Column(columnDefinition = "int default 1")
    var herbloreLevel = 0

    @Column(columnDefinition = "int default 1")
    var agilityLevel = 0

    @Column(columnDefinition = "int default 1")
    var thievingLevel = 0

    @Column(columnDefinition = "int default 1")
    var slayerLevel = 0

    @Column(columnDefinition = "int default 1")
    var farmingLevel = 0

    @Column(columnDefinition = "int default 1")
    var runecraftingLevel = 0

    @Column(columnDefinition = "int default 1")
    var hunterLevel = 0

    @Column(columnDefinition = "int default 1")
    var constructionLevel = 0

    constructor() {}
    constructor(
        attackLevel: Int,
        defenceLevel: Int,
        strengthLevel: Int,
        hitpointsLevel: Int,
        rangedLevel: Int,
        prayerLevel: Int,
        magicLevel: Int,
        cookingLevel: Int,
        woodcuttingLevel: Int,
        fletchingLevel: Int,
        fishingLevel: Int,
        firemakingLevel: Int,
        craftingLevel: Int,
        smithingLevel: Int,
        miningLevel: Int,
        herbloreLevel: Int,
        agilityLevel: Int,
        thievingLevel: Int,
        slayerLevel: Int,
        farmingLevel: Int,
        runecraftingLevel: Int,
        hunterLevel: Int,
        constructionLevel: Int
    ) {
        this.attackLevel = attackLevel
        this.defenceLevel = defenceLevel
        this.strengthLevel = strengthLevel
        this.hitpointsLevel = hitpointsLevel
        this.rangedLevel = rangedLevel
        this.prayerLevel = prayerLevel
        this.magicLevel = magicLevel
        this.cookingLevel = cookingLevel
        this.woodcuttingLevel = woodcuttingLevel
        this.fletchingLevel = fletchingLevel
        this.fishingLevel = fishingLevel
        this.firemakingLevel = firemakingLevel
        this.craftingLevel = craftingLevel
        this.smithingLevel = smithingLevel
        this.miningLevel = miningLevel
        this.herbloreLevel = herbloreLevel
        this.agilityLevel = agilityLevel
        this.thievingLevel = thievingLevel
        this.slayerLevel = slayerLevel
        this.farmingLevel = farmingLevel
        this.runecraftingLevel = runecraftingLevel
        this.hunterLevel = hunterLevel
        this.constructionLevel = constructionLevel
    }
}