package io.nozemi.runescape.model.entity.player;

import io.nozemi.runescape.content.mechanics.VarbitAttributes;
import io.nozemi.runescape.fs.EnumDefinition;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.command.InvokeScript;
import io.nozemi.runescape.net.message.game.command.UpdateSkill;
import io.nozemi.runescape.orm.models.CharacterExperience;
import io.nozemi.runescape.orm.models.CharacterLevels;
import io.nozemi.runescape.util.Varbit;

import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class Skills {
	
	public static final int SKILL_COUNT = 24;
	private static final int[] XP_TABLE = new int[100];
	public static boolean USE_EXPERIMENTAL_PERFORMANCE = true;
	
	private double[] xps = new double[SKILL_COUNT];
	private int[] levels = new int[SKILL_COUNT];
	private Player player;
	private int combat;
	private boolean[] dirty = new boolean[SKILL_COUNT];
	
	public Skills(Player player) {
		this.player = player;
		
		Arrays.fill(levels, 1);

		/* Hitpoints differs :) */
		xps[HITPOINTS] = levelToXp(10);
		levels[HITPOINTS] = 10;
	}
	
	public void update() {
		for (int skill = 0; skill < SKILL_COUNT; skill++) {
			player.write(new UpdateSkill(skill, levels[skill], (int) xps[skill]));
		}
	}
	
	public void syncDirty() {
		for (int skill = 0; skill < SKILL_COUNT; skill++) {
			if (dirty[skill]) {
				player.write(new UpdateSkill(skill, levels[skill], (int) xps[skill]));
				dirty[skill] = false;
			}
		}
	}
	
	public void makeDirty(int skill) {
		if (USE_EXPERIMENTAL_PERFORMANCE) {
			dirty[skill] = true;
		} else {
			player.write(new UpdateSkill(skill, levels[skill], (int) xps[skill]));
		}
	}
	
	/**
	 * Returns the current level a stat is at, could be 50/99 for HP.
	 * <br>Use XP to get the real level.
	 *
	 * @param skill
	 * @return
	 */
	public int level(int skill) {
		return levels[skill];
	}
	
	/**
	 * Gets the level which your XP qualifies you for
	 */
	public int xpLevel(int skill) {
		return xpToLevel((int) xps[skill]);
	}
	
	public int[] levels() {
		return levels;
	}
	
	public double[] xp() {
		return xps;
	}
	
	public void setLevel(int skill, int lvtemp) {
		levels[skill] = lvtemp;
		makeDirty(skill);
	}
	
	public boolean __addXp(int skill, double amt) {
		return __addXp(skill, amt, true);
	}
	
	public boolean __addXp(int skill, double amt, boolean multiplied) {
		Entity target = ((WeakReference<Entity>) player.attribOr(AttributeKey.TARGET, new WeakReference<>(null))).get();
		// Active target and facing. Can't tell if combat script is running.
		boolean pvp = target != null && target.isPlayer() && target.index() + 32768 == (int) player.attribOr(AttributeKey.LAST_FACE_ENTITY_IDX, 0);
		boolean combatxp = skill == ATTACK || skill == STRENGTH || skill == DEFENCE || skill == RANGED || skill == MAGIC || skill == HITPOINTS;
		boolean xplocked = VarbitAttributes.varbiton(player, Varbit.XPLOCKED);
		boolean x1xp = VarbitAttributes.varbiton(player, Varbit.XP_X1);
		
		if (combatxp && xplocked) { // don't get combat exp when locked.
			return false;
		}
		
		if (target != null && target.isNpc() && combatxp) { // Don't add exp if the target is hidden or locked.
			Npc npc = (Npc) target;
			if (npc.hidden() || (npc.locked() && !npc.isDamageOkLocked()))
				return false;
		}

		// TODO: Handle XP multiplier
		if (World.xpMultiplier > 1) {
			amt *= World.xpMultiplier;
		}
		
		int oldLevel = xpToLevel((int) xps[skill]);
		xps[skill] = Math.min(200000000, xps[skill] + amt);
		int newLevel = xpToLevel((int) xps[skill]);
		
		if (newLevel > oldLevel) {
			if (levels[skill] < newLevel)
				levels[skill] += newLevel - oldLevel;
			player.graphic(199, 124, 0);
		}
		
		makeDirty(skill);
		
		if (oldLevel != newLevel) {
			int levels = newLevel - oldLevel;
			if (levels == 1) {
				player.message("Congratulations, you just advanced %s %s level.", SKILL_INDEFINITES[skill], SKILL_NAMES[skill]);
			} else {
				player.message("Congratulations, you just advanced %d %s levels.", levels, SKILL_NAMES[skill]);
			}
			
			recalculateCombat();
		}
		
		return oldLevel != newLevel;
	}
	
	public void update(int skill) {
		recalculateCombat();
		makeDirty(skill);
	}
	
	public int internalIdOf(int skillId) {
		return player.world().definitions().get(EnumDefinition.class, 1482).getInt(skillId);
	}
	
	public int toSkillId(int internalId) {
		return player.world().definitions().get(EnumDefinition.class, 681).getInt(internalId);
	}
	
	public String levelUpMessage(int skill, int level) {
		int internal = internalIdOf(skill);
		String first = player.world().definitions().get(EnumDefinition.class, 1477).getString(internal);
		return first + " You have reached level " + level + ".";
	}
	
	/**
	 * @param skill
	 * @param change
	 */
	public void alterSkill(int skill, int change) {
		levels[skill] += change;
		if (change > 0 && levels[skill] > xpLevel(skill) + change) { // Cap at realLvl (99) + boost (20) = 118
			levels[skill] = xpLevel(skill) + change;
		}
		if (levels[skill] < 0) { // Min 0
			levels[skill] = 0;
		}
		update(skill);
	}
	
	public void replenishSkill(int skill, int change) {
		if (levels[skill] < xpLevel(skill)) // Current level under real level
			levels[skill] = Math.min(xpLevel(skill), level(skill) + change);//cap replenish at 99
		update(skill);
	}
	
	public void replenishStats() {
		if (player.dead() || player.hp() < 1)
			return;
		
		for (int i = 0; i < SKILL_COUNT; i++) {
			if (i == PRAYER) // Prayer does not replenish this way
				continue;
			// TODO: Look at this max cape thing
			if (i == HITPOINTS && (player.varps().varbit(Varbit.RAPID_HEAL) == 1))// || Equipment.wearingMaxCape(player))) // Another Timer deals with this.
				continue;
			
			if (levels[i] < xpLevel(i)) {
				levels[i]++;
				update(i);
			} else if (levels[i] > xpLevel(i)) {
				levels[i]--;
				update(i);
			}
		}
	}
	
	public void replenishStatsToNorm() {
		for (int i = 0; i < SKILL_COUNT; i++) {
			if (levels[i] < xpLevel(i)) {
				levels[i] = xpLevel(i);
				update(i);
			}
		}
	}
	
	public void resetStats() {
		for (int i = 0; i < SKILL_COUNT; i++) {
			levels[i] = xpLevel(i);
		}
		update();
	}
	
	public void recalculateCombat() {
		int old = combat;
		double defence = xpLevel(Skills.DEFENCE);
		double attack = xpLevel(Skills.ATTACK);
		double strength = xpLevel(Skills.STRENGTH);
		double prayer = xpLevel(Skills.PRAYER);
		double ranged = xpLevel(Skills.RANGED);
		double magic = xpLevel(Skills.MAGIC);
		double hp = xpLevel(Skills.HITPOINTS);
		
		int baseMelee = (int) Math.floor(0.25 * (defence + hp + Math.floor(prayer / 2d)) + 0.325 * (attack + strength));
		int baseRanged = (int) Math.floor(0.25 * (defence + hp + Math.floor(prayer / 2d)) + 0.325 * (Math.floor(ranged / 2) + ranged));
		int baseMage = (int) Math.floor(0.25 * (defence + hp + Math.floor(prayer / 2d)) + 0.325 * (Math.floor(magic / 2) + magic));
		combat = Math.max(Math.max(baseMelee, baseMage), baseRanged);
		
		// If our combat changed, we need to update our looks as that contains our cb level too.
		if (combat != old && player.looks() != null) {
			player.looks().update();

			// Make the player's attack panel up to date
			player.updateWeaponInterface();
			player.write(new InvokeScript(389, combat));
		}
	}
	
	public int combatLevel() {
		return combat;
	}
	
	public int totalLevel() {
		int total = 0;
		
		for (int i = 0; i < xps.length; i++) {
			total += xpLevel(i);
		}

		//Max total level is 2277 in osrs however this calculates slightly over.
		if (total > 2277) {
			total = 2277;
		}
		
		return total;
	}
	
	/**
	 * A flag checking if the skill is allowed to be done in the world instance. This method was created
	 * during our PVP skilling update.
	 * @param player
	 * @param skill
	 * @return
	 */
	public static boolean disabled(Player player, int skill) {
		if (player.privilege().eligibleTo(Privilege.ADMIN)) {
			return false;
		}
		
		// Before: Skills.FISHING, Skills.HUNTER, Skills.WOODCUTTING, Skills.THIEVING, Skills.MINING, Skills.SLAYER
		int[] whitelisted = new int[] {Skills.WOODCUTTING, Skills.MINING, Skills.THIEVING, Skills.FISHING, Skills.HUNTER, Skills.SLAYER };
		
		if (Arrays.stream(whitelisted).noneMatch(id -> id == skill)) {
			player.message("This skill is disabled in this world.");
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Converts given XP to the equivilent skill level.
	 *
	 * @param xp
	 * @return
	 */
	public static int xpToLevel(int xp) {
		// Most-frequently used variants.
		if (xp >= 13034431)
			return 99;
		if (xp < 84)
			return 1;
		
		int lv = 1;
		for (; lv < 100; lv++) {
			if (xp < XP_TABLE[lv])
				break;
		}
		
		return lv > 99 ? 99 : lv;
	}
	
	/**
	 * Converts skill level to EXP
	 *
	 * @param level skill id
	 * @return XP equivilent to given skill level
	 */
	public static int levelToXp(int level) {
		return XP_TABLE[Math.min(99, Math.max(0, level - 1))];
	}
	
	static {
		// Calculate XP table
		for (int lv = 1, points = 0; lv < 100; lv++) {
			points += Math.floor(lv + 300 * Math.pow(2, lv / 7D));
			XP_TABLE[lv] = points / 4;
		}
	}
	
	public static final int ATTACK = 0;
	public static final int DEFENCE = 1;
	public static final int STRENGTH = 2;
	public static final int HITPOINTS = 3;
	public static final int RANGED = 4;
	public static final int PRAYER = 5;
	public static final int MAGIC = 6;
	public static final int COOKING = 7;
	public static final int WOODCUTTING = 8;
	public static final int FLETCHING = 9;
	public static final int FISHING = 10;
	public static final int FIREMAKING = 11;
	public static final int CRAFTING = 12;
	public static final int SMITHING = 13;
	public static final int MINING = 14;
	public static final int HERBLORE = 15;
	public static final int AGILITY = 16;
	public static final int THIEVING = 17;
	public static final int SLAYER = 18;
	public static final int FARMING = 19;
	public static final int RUNECRAFTING = 20;
	public static final int HUNTER = 21;
	public static final int CONSTRUCTION = 22;
	// 23 ... sailing meme skill or unreleased w.e
	
	public static final String[] SKILL_NAMES = {
			"Attack", "Defence", "Strength", "Hitpoints", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching",
			"Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblore", "Agility", "Thieving", "Slayer",
			"Farming", "Runecrafting", "Hunter", "Construction"
	};
	public static final String[] SKILL_INDEFINITES = {
			"an", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "an", "a", "a", "a", "a", "a", "a"
	};

	public double totalXp() {
		double xp = 0.0D;
		for (int i = 0; i < 23; i++) // 23 kills yo .. skill.length is 24!
			xp += xp()[i];
		return xp;
	}

	public void load(CharacterExperience stats, CharacterLevels levels) {
		this.xps[ATTACK] = stats.getAttackExperience();
		this.xps[DEFENCE] = stats.getDefenceExperience();
		this.xps[STRENGTH] = stats.getStrengthExperience();
		this.xps[HITPOINTS] = Math.max(stats.getHitpointsExperience(), levelToXp(10));
		this.xps[RANGED] = stats.getRangedExperience();
		this.xps[PRAYER] = stats.getPrayerExperience();
		this.xps[MAGIC] = stats.getMagicExperience();
		this.xps[COOKING] = stats.getCookingExperience();
		this.xps[WOODCUTTING] = stats.getWoodcuttingExperience();
		this.xps[FLETCHING] = stats.getFletchingExperience();
		this.xps[FISHING] = stats.getFishingExperience();
		this.xps[FIREMAKING] = stats.getFiremakingExperience();
		this.xps[CRAFTING] = stats.getCraftingExperience();
		this.xps[SMITHING] = stats.getSmithingExperience();
		this.xps[MINING] = stats.getMiningExperience();
		this.xps[HERBLORE] = stats.getHerbloreExperience();
		this.xps[AGILITY] = stats.getAgilityExperience();
		this.xps[THIEVING] = stats.getThievingExperience();
		this.xps[SLAYER] = stats.getSlayerExperience();
		this.xps[FARMING] = stats.getFarmingExperience();
		this.xps[RUNECRAFTING] = stats.getRunecraftingExperience();
		this.xps[HUNTER] = stats.getHunterExperience();
		this.xps[CONSTRUCTION] = stats.getConstructionExperience();
		
		this.levels[ATTACK] = levels.getAttackLevel();
		this.levels[DEFENCE] = levels.getDefenceLevel();
		this.levels[STRENGTH] = levels.getStrengthLevel();
		this.levels[HITPOINTS] = Math.max(levels.getHitpointsLevel(), 10);
		this.levels[RANGED] = levels.getRangedLevel();
		this.levels[PRAYER] = levels.getPrayerLevel();
		this.levels[MAGIC] = levels.getMagicLevel();
		this.levels[COOKING] = levels.getCookingLevel();
		this.levels[WOODCUTTING] = levels.getWoodcuttingLevel();
		this.levels[FLETCHING] = levels.getFletchingLevel();
		this.levels[FISHING] = levels.getFishingLevel();
		this.levels[FIREMAKING] = levels.getFiremakingLevel();
		this.levels[CRAFTING] = levels.getCraftingLevel();
		this.levels[SMITHING] = levels.getSmithingLevel();
		this.levels[MINING] = levels.getMiningLevel();
		this.levels[HERBLORE] = levels.getHerbloreLevel();
		this.levels[AGILITY] = levels.getAgilityLevel();
		this.levels[THIEVING] = levels.getThievingLevel();
		this.levels[SLAYER] = levels.getSlayerLevel();
		this.levels[FARMING] = levels.getFarmingLevel();
		this.levels[RUNECRAFTING] = levels.getRunecraftingLevel();
		this.levels[HUNTER] = levels.getHunterLevel();
		this.levels[CONSTRUCTION] = levels.getConstructionLevel();
		this.update();
		this.recalculateCombat();
	}
}
