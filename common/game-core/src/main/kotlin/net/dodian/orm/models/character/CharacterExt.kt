package net.dodian.orm.models.character

import net.dodian.orm.models.game.CharacterExperience
import net.dodian.orm.models.game.CharacterLevels
import net.dodian.orm.models.game.GameCharacter
import net.dodian.runescape.model.AttributeKey
import net.dodian.runescape.model.Tile
import net.dodian.runescape.model.entity.Player
import net.dodian.runescape.model.entity.player.Skills
import java.lang.RuntimeException

fun GameCharacter(player: Player): GameCharacter = GameCharacter(player, false).apply {}

fun GameCharacter(player: Player, online: Boolean): GameCharacter = GameCharacter(
    id = if (player.id() is Int) (player.id() as Int) else throw RuntimeException("Player needs to have an ID!"),
    userId = player.userId(),
    username = player.username(),
    isOnline = false,
    posX = player.tile().x,
    posZ = player.tile().z,
    level = player.tile().level,
    runEnergy = player.attribOr(AttributeKey.RUN_ENERGY, 0.0),
    experience = CharacterExperience(player.skills()),
    levels = CharacterLevels(player.skills())
).apply {}

fun GameCharacter.position(tile: Tile) {
    this.posX = tile.x
    this.posZ = tile.z
    this.level = tile.level
}

fun GameCharacter.runEnergy(runEnergy: Double) {
    this.runEnergy = runEnergy
}

fun Player.updateFromCharacter(character: GameCharacter) {
    this.username(character.username)

    if(this.inventory() != null) {
        //this.inventory(character.inventory())
    }

    if(this.equipment() != null) {
        //this.equipment(character.equipment())
    }

    this.tile(Tile(character.posX, character.posZ, character.level))
    this.putattrib(AttributeKey.RUN_ENERGY, character.runEnergy)
    this.skills().load(character.experience, character.levels)
}

fun CharacterExperience(skills: Skills): CharacterExperience = CharacterExperience(
    attackExperience = skills.xp()[Skills.ATTACK],
    defenceExperience = skills.xp()[Skills.DEFENCE],
    strengthExperience = skills.xp()[Skills.STRENGTH],
    hitpointsExperience = skills.xp()[Skills.HITPOINTS],
    rangedExperience = skills.xp()[Skills.RANGED],
    prayerExperience = skills.xp()[Skills.PRAYER],
    magicExperience = skills.xp()[Skills.MAGIC],
    cookingExperience = skills.xp()[Skills.COOKING],
    woodcuttingExperience = skills.xp()[Skills.WOODCUTTING],
    fletchingExperience = skills.xp()[Skills.FLETCHING],
    fishingExperience = skills.xp()[Skills.FISHING],
    firemakingExperience = skills.xp()[Skills.FIREMAKING],
    craftingExperience = skills.xp()[Skills.CRAFTING],
    smithingExperience = skills.xp()[Skills.SMITHING],
    miningExperience = skills.xp()[Skills.MINING],
    herbloreExperience = skills.xp()[Skills.HERBLORE],
    agilityExperience = skills.xp()[Skills.AGILITY],
    thievingExperience = skills.xp()[Skills.THIEVING],
    slayerExperience = skills.xp()[Skills.SLAYER],
    farmingExperience = skills.xp()[Skills.FARMING],
    runecraftingExperience = skills.xp()[Skills.RUNECRAFTING],
    hunterExperience = skills.xp()[Skills.HUNTER],
    constructionExperience = skills.xp()[Skills.CONSTRUCTION],
).apply {}

fun CharacterLevels(skills: Skills): CharacterLevels = CharacterLevels(
    attackLevel = skills.levels()[Skills.ATTACK],
    defenceLevel = skills.levels()[Skills.DEFENCE],
    strengthLevel = skills.levels()[Skills.STRENGTH],
    hitpointsLevel = skills.levels()[Skills.HITPOINTS],
    rangedLevel = skills.levels()[Skills.RANGED],
    prayerLevel = skills.levels()[Skills.PRAYER],
    magicLevel = skills.levels()[Skills.MAGIC],
    cookingLevel = skills.levels()[Skills.COOKING],
    woodcuttingLevel = skills.levels()[Skills.WOODCUTTING],
    fletchingLevel = skills.levels()[Skills.FLETCHING],
    fishingLevel = skills.levels()[Skills.FISHING],
    firemakingLevel = skills.levels()[Skills.FIREMAKING],
    craftingLevel = skills.levels()[Skills.CRAFTING],
    smithingLevel = skills.levels()[Skills.SMITHING],
    miningLevel = skills.levels()[Skills.MINING],
    herbloreLevel = skills.levels()[Skills.HERBLORE],
    agilityLevel = skills.levels()[Skills.AGILITY],
    thievingLevel = skills.levels()[Skills.THIEVING],
    slayerLevel = skills.levels()[Skills.SLAYER],
    farmingLevel = skills.levels()[Skills.FARMING],
    runecraftingLevel = skills.levels()[Skills.RUNECRAFTING],
    hunterLevel = skills.levels()[Skills.HUNTER],
    constructionLevel = skills.levels()[Skills.CONSTRUCTION],
).apply {}