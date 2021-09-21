package net.dodian.orm.models.game

data class GameCharacter(
    var id: Int,
    var userId: Int,
    var username: String?,
    var isOnline: Boolean,
    var posX: Int,
    var posZ: Int,
    var level: Int,
    var runEnergy: Double,
    var experience: CharacterExperience?,
    var levels: CharacterLevels?
)

data class CharacterLevels (
    var attackLevel: Int,
    var defenceLevel: Int,
    var strengthLevel: Int,
    var hitpointsLevel: Int,
    var rangedLevel: Int,
    var prayerLevel: Int,
    var magicLevel: Int,
    var cookingLevel: Int,
    var woodcuttingLevel: Int,
    var fletchingLevel: Int,
    var fishingLevel: Int,
    var firemakingLevel: Int,
    var craftingLevel: Int,
    var smithingLevel: Int,
    var miningLevel: Int,
    var herbloreLevel: Int,
    var agilityLevel: Int,
    var thievingLevel: Int,
    var slayerLevel: Int,
    var farmingLevel: Int,
    var runecraftingLevel: Int,
    var hunterLevel: Int,
    var constructionLevel: Int
)

data class CharacterExperience(
    var attackExperience: Double,
    var defenceExperience: Double,
    var strengthExperience: Double,
    var hitpointsExperience: Double,
    var rangedExperience: Double,
    var prayerExperience: Double,
    var magicExperience: Double,
    var cookingExperience: Double,
    var woodcuttingExperience: Double,
    var fletchingExperience: Double,
    var fishingExperience: Double,
    var firemakingExperience: Double,
    var craftingExperience: Double,
    var smithingExperience: Double,
    var miningExperience: Double,
    var herbloreExperience: Double,
    var agilityExperience: Double,
    var thievingExperience: Double,
    var slayerExperience: Double,
    var farmingExperience: Double,
    var runecraftingExperience: Double,
    var hunterExperience: Double,
    var constructionExperience: Double
)