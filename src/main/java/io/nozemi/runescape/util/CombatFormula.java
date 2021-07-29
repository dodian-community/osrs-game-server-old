package io.nozemi.runescape.util;

import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.EquipSlot;
import io.nozemi.runescape.model.entity.player.Skills;
import io.nozemi.runescape.model.item.ItemContainer;
import io.nozemi.runescape.script.TimerKey;

/**
 * Created by Bart on 8/15/2015.
 */
public class CombatFormula {
	
	private static final int TWISTED_BOW = 20997;
	
	/**
	 * Calculates maximum possible damage using prayer, stats, armour bonuses and any extras.
	 *
	 * @param player
	 * @return
	 */
	public static int maximumMeleeHit(Player player) {
		EquipmentInfo.Bonuses bonuses = EquipmentInfo.totalBonuses(player, player.world().equipmentInfo());
		
		double prayerBonus = 1;
		
		// Prayer additions
		if (player.varps().varbit(Varbit.BURST_OF_STRENGTH) == 1) {
			prayerBonus = 1.05;
		} else if (player.varps().varbit(Varbit.SUPERHUMAN_STRENGTH) == 1) {
			prayerBonus = 1.10;
		} else if (player.varps().varbit(Varbit.ULTIMATE_STRENGTH) == 1) {
			prayerBonus = 1.15;
		} else if (player.varps().varbit(Varbit.CHIVALRY) == 1) {
			prayerBonus = 1.18;
		} else if (player.varps().varbit(Varbit.PIETY) == 1) {
			prayerBonus = 1.23;
		}
		
		// Void set grants 10% bonus here
		double extraBonus = voidMelee(player) ? 1.10 : 1.0;
		
		//If the player has a berserker neckalce & a toktz weapon
		double toktz_bonus = berserkerNecklace(player) ? 1.20 : 1.0;
		toktz_bonus *= (obbyArmour(player) && hasObbyWeapon(player) ? 1.10 : 1.0);
		
		int style = EquipmentInfo.attackStyleFor(player).equals(AttackStyle.AGGRESIVE) ? 3 : EquipmentInfo.attackStyleFor(player).equals(AttackStyle.CONTROLLED) ? 1 : 0;
		
		double effectiveStr = Math.ceil(player.skills().level(Skills.STRENGTH) * prayerBonus * extraBonus * toktz_bonus) + style;
		
		//TODO effectiveStr depends on prayer and style and e.g. salve ammy
		double baseDamage = 1.3 + (effectiveStr / 10d) + (bonuses.str / 80d) + ((effectiveStr * bonuses.str) / 640d);
		
		if (fullDharok(player)) {
			double hp = player.hp();
			double max = player.maxHp();
			double mult = Math.max(0, ((max - hp) / max) * 100d) + 100d;
			baseDamage *= (mult / 100);
		}
		
		// TODO attack specials
		return (int) baseDamage;
	}
	
	public static int maximumRangedHit(Player player, Entity target, boolean factorInAmmoRangeStr, boolean boltSpecial, int ammo) {
		EquipmentInfo.Bonuses bonuses = EquipmentInfo.totalBonuses(player, player.world().equipmentInfo(), !factorInAmmoRangeStr);

		double prayerBonus = 1;
		
		// Prayer additions
		if (player.varps().varbit(Varbit.EAGLE_EYE) == 1) {
			prayerBonus = 1.15;
		} else if (player.varps().varbit(Varbit.HAWK_EYE) == 1) {
			prayerBonus = 1.10;
		} else if (player.varps().varbit(Varbit.SHARP_EYE) == 1) {
			prayerBonus = 1.05;
		} else if (player.varps().varbit(Varbit.RIGOUR) == 1) {
			prayerBonus = 1.23;
		}
		
		double boltMultiplier = 1.0;
		
		if (boltSpecial) {
			switch (ammo) {
				case 9236: // Opal bolts
                case 21932: // Dragonstone opal
					boltMultiplier = 1.25;
					break;
				case 9243: // Diamond bolts
                case 21946:// Dragonstone diamond
					boltMultiplier = 1.15;
					break;
				case 9244: // Dragon bolts
				case 21948: // Dragonstone dragon bolt
					// If the player doesn't have any anti-fire equipment wielded, we apply the bolt special multiplier.
					if (target != null && target.isPlayer()) {
						if (!target.equipment().has(11283) && !target.equipment().has(11284) && !target.equipment().has(1540))
							boltMultiplier = 1.45; //Deals 45% extra damage
					} else {
						boltMultiplier = 1.45; //Deals 45% extra damage
					}

					break;
				case 9245: // Onyx bolts
                case 21950: // Dragonstone onyx
					boltMultiplier = 1.20;
					break;
			}
		}

		int effectiveLevel = (int) Math.floor(player.skills().level(Skills.RANGED) * prayerBonus);

		// Accurate mode gives you 3 extra levels in the algorithm.
		if (EquipmentInfo.attackStyleFor(player) == AttackStyle.ACCURATE) {
			effectiveLevel += 3;
		}

		effectiveLevel += 8;

		// Void effect adds 10%.
		if (voidRanger(player)) {
			effectiveLevel += effectiveLevel / 10;
		}

		double baseDamage = 0.5 + effectiveLevel * (bonuses.rangestr + 64d) / 640;
		
		// Append the Twisted bow computation, if we have enough data..
		int weapon = player.equipment().hasAt(EquipSlot.WEAPON) ? player.equipment().get(EquipSlot.WEAPON).getId() : -1;
		if (weapon == TWISTED_BOW && target != null && target.isNpc()) {
			int magicLevel = 0;

			if (((Npc) target).combatInfo() != null && ((Npc) target).combatInfo().stats != null)
				magicLevel = ((Npc) target).combatInfo().stats.magic;

			double damage = 250D + ((3 * magicLevel - 14D) / 100D) - (Math.pow(3 * magicLevel / 10.0 - 140.0, 2) / 100D);
			damage = Math.min(250, damage);
			baseDamage *= Math.min(2D, 1D + damage);
			return (int) baseDamage;
		}
		
		if (boltMultiplier != 1.0) { //If we're not using special effect then trunc
			return (int) (baseDamage * boltMultiplier);
		} else { //else floor it
			return (int) Math.floor(baseDamage * boltMultiplier);
		}
	}
	
	public static int modifyMagicDamage(Player player, int spell_maxhit, String spell_name) {
		EquipmentInfo.Bonuses b = EquipmentInfo.totalBonuses(player, player.world().equipmentInfo());
		double multi = 1 + ((b.magestr > 0 ? b.magestr : 1.0) / 100);
		
		if (spell_name.equals("Saradomin Strike") || spell_name.equals("Claws of Guthix") || spell_name.equals("Flames of Zamorak")) {
			if (player.timers().has(TimerKey.CHARGE_SPELL)) {
				spell_maxhit = 30;
			}
		}
		
		int weapon = player.equipment().get(3) == null ? -1 : player.equipment().get(3).getId();
		
		// 10% of level
		if (spell_name.equals("Magic dart")) {
			boolean staff_e = weapon == 21255;
			if (staff_e) { // Slayer's staff (e)
				spell_maxhit = 13;
			}
			spell_maxhit += (player.skills().level(Skills.MAGIC) / (staff_e ? 16.6 : 10.0));
		}
		
		// Occult necklace gives 10% bonus and Staff of the Death (+Toxic) gives 15% damage boost - done via equip bonuses on OSRS
		
		if (player.equipment().hasAny(11998, 12000)) { // Smoke staffs provide 10% extra dmg + accuracy
			multi += 0.10;
		} else if (player.equipment().hasAt(EquipSlot.WEAPON, 12899) && spell_name.contains("trident")) {
			// Toxic trident base damage is +3
			spell_maxhit += 3;
		}
		// Slayer helm and corp adjustments.
		/*multi *= MeleeSpecialAttacks.multi(player,
				((WeakReference<Entity>) player.attribOr(AttributeKey.TARGET, new WeakReference<Entity>(null))).get(), CombatStyle.MAGIC, false);*/

		return (int) (spell_maxhit * multi);
	}
	
	private static double twistedBowDamageMultiplier(int magicLevel) {
		//double accmod = (140 + ((3 * magicLevel - 10) / 100) - Math.pow((3 * magicLevel / 10) - 100, 2) / 100) / 100.0;
		double newAlgo = (259 + ((3 * magicLevel - 14) / 100) - Math.pow((3 * magicLevel / 10) - 140, 2) / 100) / 100.0;
		return Math.min(2.50, newAlgo);
		// TODO this formula is currently inaccurate, the real algorithm is NOT linear but exponential.
		//double mage = Math.max(10, Math.min(magicLevel, 250)) - 10;
		//return Math.min((60 + (mage * 0.5882)) / 100, 2.50);
	}
	
	public static boolean obbyArmour(Player player) {
		ItemContainer eq = player.equipment();
		return ((eq.hasAt(EquipSlot.HEAD, 21298) && eq.hasAt(EquipSlot.BODY, 21301) && eq.hasAt(EquipSlot.LEGS, 21304)));
	}
	
	public static boolean voidBase(Player player) {
		ItemContainer eq = player.equipment();
		return ((eq.hasAt(EquipSlot.BODY, 8839) && eq.hasAt(EquipSlot.LEGS, 8840)) || (eq.hasAt(EquipSlot.BODY, 13072) && eq.hasAt(EquipSlot.LEGS, 13073))) && eq.hasAt(EquipSlot.HANDS, 8842);
	}
	
	public static boolean voidRanger(Player player) {
		return player.equipment().hasAt(EquipSlot.HEAD, 11664) && voidBase(player);
	}
	
	public static boolean voidMelee(Player player) {
		return player.equipment().hasAt(EquipSlot.HEAD, 11665) && voidBase(player);
	}
	
	public static boolean berserkerNecklace(Player player) {
		return player.equipment().hasAt(EquipSlot.AMULET, 11128) && player.equipment().hasAny(6523, 6525, 6527, 6528);
	}
	
	public static boolean voidMagic(Player player) {
		return player.equipment().hasAt(EquipSlot.HEAD, 11663) && voidBase(player);
	}
	
	public static boolean fullDharok(Player player) {
		return player.equipment().hasAny(4718, 4886, 4887, 4888, 4889) && // Axe
				player.equipment().hasAny(4716, 4880, 4881, 4882, 4883) && // Helm
				player.equipment().hasAny(4720, 4892, 4893, 4894, 4895) && // Body
				player.equipment().hasAny(4722, 4898, 4899, 4900, 4901); // Legs
	}
	
	private static boolean hasGodSword(Player player) {
		return player.equipment().hasAny(11802, 11804, 11806, 11808, 20368, 20370, 20372, 20374);
	}
	
	public static boolean hasObbyWeapon(Player player) {
		ItemContainer eq = player.equipment();
		int[] weaponry = new int[]{6528, 6523, 6525};
		return ((eq.hasAt(EquipSlot.WEAPON, weaponry[0]) || (eq.hasAt(EquipSlot.WEAPON, weaponry[1]) || (eq.hasAt(EquipSlot.WEAPON, weaponry[2])))));
	}
}
