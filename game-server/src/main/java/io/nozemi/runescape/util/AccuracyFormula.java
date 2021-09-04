package io.nozemi.runescape.util;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.CombatStyle;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.EquipSlot;
import io.nozemi.runescape.model.entity.player.Skills;
import io.nozemi.runescape.model.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;
import java.util.Map;

/**
 * Created by Bart on 8/22/2015.
 */
public class AccuracyFormula {

	private static final Logger logger = LogManager.getLogger(AccuracyFormula.class);

	public static final SecureRandom srand = new SecureRandom();

	private static final int TWISTED_BOW = 20997;

	public static boolean doesHit(Entity entity, Entity enemy, CombatStyle style, double multiplier) {
		return doesHit(entity, enemy, style, 1, multiplier);
	}

	public static boolean doesHit(Entity entity, Entity enemy, CombatStyle style, int spellLevel, double multiplier) {
		EquipmentInfo.Bonuses playerBonuses = EquipmentInfo.totalBonuses(entity, entity.world().equipmentInfo());
		EquipmentInfo.Bonuses targetBonuses = EquipmentInfo.totalBonuses(enemy, entity.world().equipmentInfo());

		/*
			S E T T I N G S

			S T A R T
		*/

		//attack stances
		int off_stance_bonus = 0;
		int def_stance_bonus = 0;
		if (entity.isPlayer()) {
			final AttackStyle attackStyle = EquipmentInfo.attackStyleFor((Player) entity);
			off_stance_bonus = attackStyle.equals(AttackStyle.ACCURATE) ? 3 : attackStyle.equals(AttackStyle.CONTROLLED) ? 1 : 0; //accurate, aggressive, controlled, defensive
			def_stance_bonus = attackStyle.equals(AttackStyle.DEFENSIVE) || attackStyle.equals(AttackStyle.LONG_RANGE) ? 3 : attackStyle.equals(AttackStyle.CONTROLLED) ? 1 : 0; //accurate, aggressive, controlled, defensive
		}

		//requirements
		int off_weapon_requirement = 1; //weapon attack level requirement
		int off_spell_requirement = spellLevel; //spell magic level requirement

		//base levels
		int off_base_attack_level = 1;
		int off_base_ranged_level = 1;
		int off_base_magic_level = 1;
		int attackerWeaponId = -1;
		double twistedBowMultiplier = 1.0; // Defaults to no change (x1)
		double toktz_bonus = 1.0;

		if (entity.isPlayer()) {
			Player player = ((Player) entity);
			final Item weapon = player.equipment().get(EquipSlot.WEAPON);

			if (weapon != null) {
				attackerWeaponId = weapon.getId(); // Used below in Twisted bow computation.

				final Map<Integer, Integer> requiredLevels = player.world().equipmentInfo().requirementsFor(weapon.getId());
				if (requiredLevels != null) {
					final Integer requiredLevel = requiredLevels.get(Skills.ATTACK);
					if (requiredLevel != null)
						off_weapon_requirement = requiredLevel;
				}
			}

			off_base_attack_level = (int) (player.skills().xpLevel(Skills.ATTACK)) + ((player.skills().xpLevel(Skills.ATTACK)) / 3);
			off_base_ranged_level = player.skills().xpLevel(Skills.RANGED);
			off_base_magic_level = player.skills().xpLevel(Skills.MAGIC);
		} else {
			Npc npc = ((Npc) entity);
			if (npc.combatInfo() != null && npc.combatInfo().stats != null) {
				off_base_attack_level = (int) (npc.combatInfo().stats.attack);
				off_base_ranged_level = npc.combatInfo().stats.ranged;
				off_base_magic_level = npc.combatInfo().stats.magic;
			} else {
				logger.error("Npc id {} index {} name {} missing combat info or stats.", npc.id(), npc.index(), npc.def().name);
			}
		}

		//current levels
		double off_current_attack_level = 1;
		double off_current_ranged_level = 1;
		double off_current_magic_level = 1;

		if (entity.isPlayer()) {
			Player player = ((Player) entity);
			off_current_attack_level = player.skills().level(Skills.ATTACK);
			off_current_ranged_level = player.skills().level(Skills.RANGED);
			off_current_magic_level = player.skills().level(Skills.MAGIC);
		} else {
			Npc npc = ((Npc) entity);
			if (npc.combatInfo() != null && npc.combatInfo().stats != null) {
				off_current_attack_level = (int) (npc.combatInfo().stats.attack);
				off_current_ranged_level = npc.combatInfo().stats.ranged;
				off_current_magic_level = npc.combatInfo().stats.magic;
			}
		}

		off_current_attack_level *= 1.1;
		off_current_ranged_level *= 1.15;
		off_current_magic_level *= 1.15;

		double def_current_defence_level = 1;
		double def_current_magic_level = 1;

		if (enemy.isPlayer()) {
			Player opp = (Player) enemy;
			def_current_defence_level = opp.skills().level(Skills.DEFENCE);
			def_current_magic_level = opp.skills().level(Skills.MAGIC);

			int hpmissing = opp.maxHp() - opp.hp();
			/*if (hpmissing > 0 && Equipment.hasAmmyOfDamned(opp) && Equipment.fullTorag(opp)) {
				// Calc % increase. 1% per 1hp missing.
				double multi = 0.01D * hpmissing;
				def_current_defence_level += def_current_defence_level * multi;
			}*/
		} else {
			Npc npc = ((Npc) enemy);
			if (npc.combatInfo() != null && npc.combatInfo().stats != null) {
				def_current_defence_level = npc.combatInfo().stats.defence;
				def_current_magic_level = npc.combatInfo().stats.magic;
			}
		}

		if (entity.isPlayer()) {
			if (attackerWeaponId == TWISTED_BOW) {
				twistedBowMultiplier = twistedBowAccuracyMultiplier((int) def_current_magic_level);
			}
			if (CombatFormula.obbyArmour((Player) entity) && CombatFormula.hasObbyWeapon((Player) entity)) {
				toktz_bonus = 1.10;
			}
		}

		//prayer bonuses
		double off_attack_prayer_bonus = 1.0;
		double off_ranged_prayer_bonus = 1.0;
		double off_magic_prayer_bonus = 1.0;
		double def_defence_prayer_bonus = 1.0;

		// Prayers
		if (entity.isPlayer()) {
			Player p = (Player) entity;
			if (p.varps().varbit(Varbit.CLARITY_OF_THOUGHT) == 1)
				off_attack_prayer_bonus += 0.05; // 5% attack level boost
			else if (p.varps().varbit(Varbit.IMPROVED_REFLEXIS) == 1)
				off_attack_prayer_bonus += 0.10; // 10% attack level boost
			else if (p.varps().varbit(Varbit.INCREDIBLE_REFLEXES) == 1)
				off_attack_prayer_bonus += 0.15; // 15% attack level boost
			else if (p.varps().varbit(Varbit.CHIVALRY) == 1)
				off_attack_prayer_bonus += 0.15; // 15% attack level boost
			else if (p.varps().varbit(Varbit.PIETY) == 1)
				off_attack_prayer_bonus += 0.20; // 20% attack level boost

			if (p.varps().varbit(Varbit.SHARP_EYE) == 1)
				off_ranged_prayer_bonus += 0.05; // 5% range level boost
			else if (p.varps().varbit(Varbit.HAWK_EYE) == 1)
				off_ranged_prayer_bonus += 0.10; // 10% range level boost
			else if (p.varps().varbit(Varbit.EAGLE_EYE) == 1)
				off_ranged_prayer_bonus += 0.15; // 15% range level boost
			else if (p.varps().varbit(Varbit.RIGOUR) == 1)
				off_ranged_prayer_bonus += 0.20; // 20% range level boost

			if (p.varps().varbit(Varbit.MYSTIC_WILL) == 1)
				off_magic_prayer_bonus += 0.05; // 5% magic level boost
			else if (p.varps().varbit(Varbit.MYSTIC_LORE) == 1)
				off_magic_prayer_bonus += 0.10; // 10% magic level boost
			else if (p.varps().varbit(Varbit.MYSTIC_MIGHT) == 1)
				off_magic_prayer_bonus += 0.15; // 15% magic level boost
			else if (p.varps().varbit(Varbit.AUGURY) == 1)
				off_magic_prayer_bonus += 0.25; // 25% magic level boost
		}

		if (enemy.isPlayer()) {
			Player p = (Player) enemy;

			if (p.varps().varbit(Varbit.THICK_SKIN) == 1)
				def_defence_prayer_bonus += 0.05; // 5% def level boost
			else if (p.varps().varbit(Varbit.ROCK_SKIN) == 1)
				def_defence_prayer_bonus += 0.10; // 10% def level boost
			else if (p.varps().varbit(Varbit.STEEL_SKIN) == 1)
				def_defence_prayer_bonus += 0.15; // 15% def level boost

			if (p.varps().varbit(Varbit.CHIVALRY) == 1)
				def_defence_prayer_bonus += 0.20; // 20% def level boost
			else if (p.varps().varbit(Varbit.PIETY) == 1)
				def_defence_prayer_bonus += 0.25; // 25% def level boost
			else if (p.varps().varbit(Varbit.RIGOUR) == 1)
				def_defence_prayer_bonus += 0.25; // 25% def level boost
			else if (p.varps().varbit(Varbit.AUGURY) == 1)
				def_defence_prayer_bonus += 0.25; // 25% def level boost
		}

		//additional bonus
		double off_additional_bonus = multiplier;

		//Magic on lava dragons
		if (entity.isPlayer() && enemy.isNpc()) {
			final Npc npc = (Npc) enemy;

			if (npc.id() == 6593 && style.equals(CombatStyle.MAGIC)) {
				off_additional_bonus += 0.500;
			}
		}

		//if the player is using a smoke battlestaff
		if (entity.isPlayer()) {
			if (entity.equipment().hasAny(11998, 12000) && style.equals(CombatStyle.MAGIC)) {
				off_additional_bonus += 0.10;
			}
		}

		//equipment bonuses
		int off_equipment_stab_attack = playerBonuses.stab;
		int off_equipment_slash_attack = playerBonuses.slash;
		int off_equipment_crush_attack = playerBonuses.crush;
		int off_equipment_ranged_attack = playerBonuses.range;
		int off_equipment_magic_attack = playerBonuses.mage;

		int def_equipment_stab_defence = targetBonuses.stabdef;
		int def_equipment_slash_defence = targetBonuses.slashdef;
		int def_equipment_crush_defence = targetBonuses.crushdef;
		int def_equipment_ranged_defence = targetBonuses.rangedef;
		int def_equipment_magic_defence = targetBonuses.magedef;

		if (enemy.isNpc()) {
			Npc npc = (Npc) enemy;
			if (npc.combatInfo() != null && npc.combatInfo().stats != null && npc.combatInfo().boss) {
				def_equipment_ranged_defence -= (def_current_defence_level * 0.50); //I don't like this solution but this formula is fucked.
			}
		}

		//protect from * prayers
		boolean def_protect_from_melee = false;
		boolean def_protect_from_ranged = false;
		boolean def_protect_from_magic = false;

		if (entity.isNpc() && enemy.isPlayer()) {
			Player player = ((Player) enemy);
			def_protect_from_melee = player.varps().varbit(Varbit.PROTECT_FROM_MELEE) == 1;
			def_protect_from_ranged = player.varps().varbit(Varbit.PROTECT_FROM_MISSILES) == 1;
			def_protect_from_magic = player.varps().varbit(Varbit.PROTECT_FROM_MAGIC) == 1;
		}

		//chance bonuses
		double off_special_attack_bonus = 1.0;
		double off_void_bonus = 1.0;

		if (entity.isPlayer()) {
			final Player player = (Player) entity;
			if (style.equals(CombatStyle.MELEE) && CombatFormula.voidMelee(player))
				off_void_bonus = 1.10;
			else if (style.equals(CombatStyle.RANGE) && CombatFormula.voidRanger(player))
				off_void_bonus = 1.10;
			else if (style.equals(CombatStyle.MAGIC) && CombatFormula.voidMagic(player))
				off_void_bonus = 1.30;
		}

		/*
			S E T T I N G S

			E N D
		*/



		/*
			C A L C U L A T E D
			V A R I A B L E S

			S T A R T
		*/

		//experience bonuses
		double off_spell_bonus = 0;
		double off_weapon_bonus = 0;

		//effective levels
		double effective_attack = 0;
		double effective_magic = 0;
		double effective_defence = 0;

		//relevent equipment bonuses
		int off_equipment_bonus = 0;
		int def_equipment_bonus = 0;

		//augmented levels
		double augmented_attack = 0;
		double augmented_defence = 0;

		//hit chances
		double hit_chance = 0;
		double off_hit_chance = 0;
		double def_block_chance = 0;

		/*
			C A L C U L A T E D
			V A R I A B L E S

			E N D
		*/

		AttackType off_style = null;
		if (entity.isPlayer()) {
			off_style = EquipmentInfo.attackTypeFor((Player) entity);
		}

		//determine effective attack
		switch (style) {
			case MELEE:
				if (off_base_attack_level > off_weapon_requirement) {
					off_weapon_bonus = (off_base_attack_level - off_weapon_requirement) * .3;
				}

				effective_attack = Math.floor((((off_current_attack_level * off_attack_prayer_bonus) * off_additional_bonus) + off_stance_bonus + off_weapon_bonus) * toktz_bonus);
				effective_defence = Math.floor((def_current_defence_level * def_defence_prayer_bonus) + def_stance_bonus);
				if (off_style != null) {
					switch (off_style) {
						case STAB:
							off_equipment_bonus = off_equipment_stab_attack;
							def_equipment_bonus = def_equipment_stab_defence;
							break;
						case SLASH:
							off_equipment_bonus = off_equipment_slash_attack;
							def_equipment_bonus = def_equipment_slash_defence;
							break;
						case CRUSH:
							off_equipment_bonus = off_equipment_crush_attack;
							def_equipment_bonus = def_equipment_crush_defence;
							break;
						default:
							off_equipment_bonus = Math.max(Math.max(off_equipment_stab_attack, off_equipment_slash_attack), off_equipment_crush_attack);
							def_equipment_bonus = Math.max(Math.max(def_equipment_stab_defence, def_equipment_slash_defence), def_equipment_crush_defence);
							break;
					}
				} else {
					off_equipment_bonus = Math.max(Math.max(off_equipment_stab_attack, off_equipment_slash_attack), off_equipment_crush_attack);
					def_equipment_bonus = Math.max(Math.max(def_equipment_stab_defence, def_equipment_slash_defence), def_equipment_crush_defence);
				}
				break;
			case RANGE:
/*				if (off_base_ranged_level > off_weapon_requirement) {
					off_weapon_bonus = (off_base_ranged_level - off_weapon_requirement) * .3;
				}*/
				effective_attack = Math.floor((((off_current_ranged_level * off_ranged_prayer_bonus) * off_additional_bonus) + off_stance_bonus + off_weapon_bonus) * twistedBowMultiplier);
				effective_defence = Math.floor((def_current_defence_level * def_defence_prayer_bonus) + def_stance_bonus);
				off_equipment_bonus = off_equipment_ranged_attack;
				def_equipment_bonus = def_equipment_ranged_defence;
				break;
			case MAGIC:
				//if (off_base_magic_level > off_spell_requirement) {
				//	off_spell_bonus = (off_base_magic_level - off_spell_requirement) * .3;
				//	System.out.println(off_base_magic_level + ". " + off_spell_requirement + " " + off_spell_bonus);
				//}
				effective_attack = Math.floor(((off_current_magic_level * off_magic_prayer_bonus) * off_additional_bonus) + off_spell_bonus);
				effective_magic = Math.floor(def_current_magic_level * .7);
				effective_defence = Math.floor((def_current_defence_level * def_defence_prayer_bonus) * .3);
				effective_defence = effective_defence + effective_magic;
				off_equipment_bonus = off_equipment_magic_attack;
				def_equipment_bonus = def_equipment_magic_defence;
				break;
		}

		//determine augmented levels
		augmented_attack = Math.floor(((effective_attack + 8) * (off_equipment_bonus + 64.)));
		augmented_defence = Math.floor(((effective_defence + 8) * (def_equipment_bonus + 64.)));

		//determine hit chance
		if (augmented_attack < augmented_defence) {
			hit_chance = augmented_attack / ((augmented_defence + 1.) * 2.);
		} else {
			hit_chance = 1. - ((augmented_defence + 2.) / ((augmented_attack + 1.) * 2.));
		}

		switch (style) {
			case MELEE:
				if (def_protect_from_melee) {
					off_hit_chance = Math.floor((((hit_chance * off_special_attack_bonus) * off_void_bonus) * .6) * 100.);
					def_block_chance = Math.floor(101 - ((((hit_chance * off_special_attack_bonus) * off_void_bonus) * .6) * 100.));
				} else {
					off_hit_chance = Math.floor(((hit_chance * off_special_attack_bonus) * off_void_bonus) * 100.);
					def_block_chance = Math.floor(101 - (((hit_chance * off_special_attack_bonus) * off_void_bonus) * 100.));
				}
				break;
			case RANGE:
				if (def_protect_from_ranged) {
					off_hit_chance = Math.floor((((hit_chance * off_special_attack_bonus) * off_void_bonus) * .6) * 100.);
					def_block_chance = Math.floor(101 - ((((hit_chance * off_special_attack_bonus) * off_void_bonus) * .6) * 100.));
				} else {
					off_hit_chance = Math.floor(((hit_chance * off_special_attack_bonus) * off_void_bonus) * 100.);
					def_block_chance = Math.floor(101 - (((hit_chance * off_special_attack_bonus) * off_void_bonus) * 100.));
				}
				break;
			case MAGIC:
				if (def_protect_from_magic) {
					off_hit_chance = Math.floor(((hit_chance * off_void_bonus) * .6) * 100.);
					def_block_chance = Math.floor(101 - (((hit_chance * off_void_bonus) * .6) * 100.));
				} else {
					off_hit_chance = Math.floor((hit_chance * off_void_bonus) * 100.);
					def_block_chance = Math.floor(101 - ((hit_chance * off_void_bonus) * 100.));
				}
				break;
		}

		if (entity.isPlayer() && (boolean) entity.attribOr(AttributeKey.DEBUG, false)) {
/*
			System.out.println("\nYour chance to hit is: " + off_hit_chance + "%");
			System.out.println("Your opponents chance to block is: " + def_block_chance + "%");
			System.out.println("Your attack is " + augmented_attack + " and his def is " + augmented_defence);
			System.out.println("Attack bonus " + off_equipment_bonus + ", atk lv " + effective_attack);
			System.out.println("Def bonus " + def_equipment_bonus + ", atk lv " + effective_defence);
			System.out.println("stab bonus " + def_equipment_stab_defence);
			System.out.println("slash bonus " + def_equipment_slash_defence);
			System.out.println("crash bonus " + def_equipment_crush_defence);*/
			String msg = String.format("Atk %d v def %d. Bonus %d vs %d. Level %d vs %d. Relative %d%% hit > %d%% block%n",
					(int) augmented_attack, (int) augmented_defence,
					off_equipment_bonus, def_equipment_bonus, (int) effective_attack, (int) effective_defence, (int) off_hit_chance, (int) def_block_chance);
			//System.out.println(msg);
			entity.message(msg);
			//System.out.println(targetBonuses);
		}

		off_hit_chance = (int) (srand.nextFloat() * off_hit_chance);
		def_block_chance = (int) (srand.nextFloat() * def_block_chance);

		//print roll
		//System.out.println("\nYou rolled: " + (int) off_hit_chance);
		//System.out.println("Your opponent rolled: " + (int) def_block_chance);

		//determine hit
/*		if (DEBUG && entity.isPlayer()) {
			System.out.println("Success =  " + off_hit_chance + " > " + def_block_chance);
		}*/
		return off_hit_chance > def_block_chance;
	} //end main

	private static final double twistedBowAccuracyMultiplier(int magicLevel) {
		return Math.min(140, (140 + ((3 * magicLevel - 10) / 100) - Math.pow((3 * magicLevel / 10) - 100, 2) / 100)) / 100.0;
		// TODO this formula is currently inaccurate, the real algorithm is NOT linear but exponential.
		//double mage = Math.max(10, Math.min(magicLevel, 350)) - 10;
		//return Math.min((45 + (mage * 0.4412)) / 100, 1.50);
	}

}
