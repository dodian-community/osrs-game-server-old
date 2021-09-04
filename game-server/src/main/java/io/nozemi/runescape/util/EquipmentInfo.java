package io.nozemi.runescape.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.nozemi.runescape.fs.ItemDefinition;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.npc.NpcCombatInfo;
import io.nozemi.runescape.model.entity.player.EquipSlot;
import io.nozemi.runescape.model.entity.player.WeaponType;
import io.nozemi.runescape.model.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Bart on 8/14/2015.
 */
public class EquipmentInfo {
	
	private static final Logger logger = LogManager.getLogger(EquipmentInfo.class);
	
	// Stand, turn, walk, turn, sidestep, sidestep, run
	private static final int[] DEFAULT_RENDERPAIR = {808, 823, 819, 820, 821, 822, 824};
	private static final int[] DEFAULT_WEAPON_RENDERPAIR = {809, 823, 819, 820, 821, 822, 824};
	private static final Bonuses DEFAULT_BONUSES = new Bonuses();
	
	private Map<Integer, int[]> renderMap = new LinkedHashMap<>();
	private Map<Integer, Bonuses> bonuses = new LinkedHashMap<>();
	private Map<Integer, Integer> weaponTypes = new LinkedHashMap<>();
	private Map<Integer, Integer> weaponSpeeds = new LinkedHashMap<>();
	private Map<Integer, Map<Integer, Integer>> itemRequirements = new LinkedHashMap<>();
	private Map<Integer, EquipmentDefinition> equipmentDefinitions = new LinkedHashMap<>();

	private Gson gson = JGson.get();
	
	public EquipmentInfo(File equipmentDefinitions, File renderPairs, File bonuses, File weaponTypes, File weaponSpeeds) {
		//// 5=shield, 6=full body (no arms), 8/11 = showing/hiding beard, hair
		loadEquipmentDefinitions(equipmentDefinitions);
		loadRenderPairs(renderPairs);
		loadBonuses(bonuses);
		loadWeaponTypes(weaponTypes);
		loadWeaponSpeeds(weaponSpeeds);
		loadEquipmentRequirements(new File("data/list/requirements.txt"));
	}
	
	public static Bonuses totalBonuses(Entity entity, EquipmentInfo infoo) {
		return totalBonuses(entity, infoo, false);
	}
	
	public static Bonuses totalBonuses(Entity entity, EquipmentInfo info, boolean ignoreAmmo) {
		Bonuses bonuses = new Bonuses();
		
		if (entity.isPlayer()) {
			Player player = ((Player) entity);
			Item wep = player.equipment().get(EquipSlot.WEAPON);
			int wepid = wep != null ? wep.getId() : -1;
			
			for (int i = 0; i < 14; i++) {
				if (i == EquipSlot.AMMO && ignoreAmmo) {
					continue;
				}
				
				Item equipped = player.equipment().get(i);
				if (equipped != null) {
					if (i == EquipSlot.AMMO && ((wepid >= 4212 && wepid <= 4223) || wepid == 12926)) { // crystal bow /blowpipe ignore ammo
						// these don't fucking factor ammo
						continue;
					}
					Bonuses equip = info.bonuses(equipped.getId());
					
					bonuses.stab += equip.stab;
					bonuses.slash += equip.slash;
					bonuses.crush += equip.crush;
					bonuses.range += equip.range;
					bonuses.mage += equip.mage;
					
					bonuses.stabdef += equip.stabdef;
					bonuses.slashdef += equip.slashdef;
					bonuses.crushdef += equip.crushdef;
					bonuses.rangedef += equip.rangedef;
					bonuses.magedef += equip.magedef;
					
					bonuses.str += equip.str;
					bonuses.rangestr += equip.rangestr;
					bonuses.magestr += equip.magestr;
					bonuses.pray += equip.pray;
				}
			}
		} else {
			Npc npc = (Npc) entity;
			if (npc.combatInfo() != null) {
				NpcCombatInfo i = npc.combatInfo();
				bonuses.stabdef = i.bonuses.stabDefence;
				bonuses.slashdef = i.bonuses.slashDefence;
				bonuses.crushdef = i.bonuses.crushDefence;
				bonuses.rangedef = i.bonuses.rangedDefence;
				bonuses.magedef = i.bonuses.magicDefence;
				bonuses.crush = bonuses.stab = bonuses.slash = i.bonuses.attack;
			}
		}
		
		return bonuses;
	}
	
	public static Bonuses criticalBonuses(Player player) {
		EquipmentInfo info = player.world().equipmentInfo();
		Bonuses bonuses = new Bonuses();
		for (int i : new int[]{EquipSlot.BODY, EquipSlot.LEGS, EquipSlot.SHIELD, EquipSlot.HEAD}) {
			Item equipped = player.equipment().get(i);
			if (equipped != null) {
				Bonuses equip = info.bonuses(equipped.getId());
				
				bonuses.stab += equip.stab;
				bonuses.slash += equip.slash;
				bonuses.crush += equip.crush;
				bonuses.range += equip.range;
				bonuses.mage += equip.mage;
				
				bonuses.stabdef += equip.stabdef;
				bonuses.slashdef += equip.slashdef;
				bonuses.crushdef += equip.crushdef;
				bonuses.rangedef += equip.rangedef;
				bonuses.magedef += equip.magedef;
				
				bonuses.str += equip.str;
				bonuses.rangestr += equip.rangestr;
				bonuses.magestr += equip.magestr;
				bonuses.pray += equip.pray;
			}
		}
		return bonuses;
	}
	
	public static int prayerBonuses(Player player, EquipmentInfo info) {
		int pray = 0;
		
		for (int i = 0; i < 14; i++) {
			Item equipped = player.equipment().get(i);
			
			if (equipped != null) {
				pray += info.bonuses(equipped.getId()).pray;
			}
		}
		
		return pray;
	}
	
	private void loadEquipmentDefinitions(File file) {
		try {
			equipmentDefinitions = gson.fromJson(new FileReader(file), new TypeToken<HashMap<Integer, EquipmentDefinition>>() {
			}.getType());
			
			logger.info("Loaded {} equipment information definitions.", equipmentDefinitions.size());
		} catch (FileNotFoundException e) {
			logger.error("Could not load equipment information", e);
		}
	}
	
	private void loadRenderPairs(File file) {
		try (Scanner scanner = new Scanner(file)) {
			int numdef = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				int id = Integer.parseInt(line.split(":")[0]);
				String params[] = line.split(":")[1].split(",");
				int[] pair = new int[7];
				for (int i = 0; i < 7; i++)
					pair[i] = Integer.parseInt(params[i]);
				renderMap.put(id, pair);
				numdef++;
			}
			
			logger.info("Loaded {} equipment render pairs.", numdef);
		} catch (FileNotFoundException e) {
			logger.error("Could not load render pairs", e);
		}
	}
	
	private void loadBonuses(File file) {
		try {
			bonuses = gson.fromJson(new FileReader(file), new TypeToken<HashMap<Integer, Bonuses>>() {
			}.getType());
			
			logger.info("Loaded {} equipment bonuses.", bonuses.size());
		} catch (FileNotFoundException e) {
			logger.error("Could not load bonuses", e);
		}
	}
	
	private void loadWeaponTypes(File file) {
		try (Scanner scanner = new Scanner(file)) {
			int numdef = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				int id = Integer.parseInt(line.split(":")[0]);
				int type = Integer.parseInt(line.split(":")[1]);
				
				weaponTypes.put(id, type);
				numdef++;
			}
			
			logger.info("Loaded {} weapon types.", numdef);
		} catch (FileNotFoundException e) {
			logger.error("Could not load weapon types.", e);
		}
	}
	
	private void loadWeaponSpeeds(File file) {
		try (Scanner scanner = new Scanner(file)) {
			int numdef = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				int id = Integer.parseInt(line.split(":")[0]);
				int type = Integer.parseInt(line.split(":")[1]);
				
				weaponSpeeds.put(id, type);
				numdef++;
			}
			
			logger.info("Loaded {} weapon speeds.", numdef);
		} catch (FileNotFoundException e) {
			logger.error("Could not load weapon speeds.", e);
		}
	}
	
	private void loadEquipmentRequirements(File file) {
		try (Scanner scanner = new Scanner(file)) {
			int numdef = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				int id = Integer.parseInt(line.split(":")[0]);
				
				String reqs = line.split(":")[1];
				Map<Integer, Integer> map = new HashMap<>();
				for (String req : reqs.split(",")) {
					int lvl = Integer.parseInt(req.split("=")[0]);
					int needed = Integer.parseInt(req.split("=")[1]);
					map.put(lvl, needed);
				}
				
				itemRequirements.put(id, map);
				numdef++;
			}
			
			logger.info("Loaded {} item requirements.", numdef);
		} catch (FileNotFoundException e) {
			logger.error("Could not load item requirements.", e);
		}
	}
	
	public int slotFor(int id) {
		EquipmentDefinition def = equipmentDefinitions.get(id);
		if (def == null)
			return -1;
		
		return def.slot;
	}
	
	public int typeFor(int id) {
		EquipmentDefinition def = equipmentDefinitions.get(id);
		if (def == null)
			return 0;
		
		return def.type;
	}
	
	public boolean showBeard(int id) {
		EquipmentDefinition def = equipmentDefinitions.get(id);
		return def != null && (def.showBeard || typeFor(id) != 8);
	}
	
	public int[] renderPair(int id) {
		if (id == -1)
			return DEFAULT_RENDERPAIR;
		return renderMap.getOrDefault(id, DEFAULT_WEAPON_RENDERPAIR);
	}
	
	public int weaponType(int id) {
		return weaponTypes.getOrDefault(id, 0);
	}
	
	public static AttackType attackTypeFor(Player player) {
		int book = player.varps().varp(843);
		int style = player.varps().varp(43);
		switch (book) {
			case WeaponType.UNARMED:
			case WeaponType.SALAMANDER:
				return AttackType.NONE;
			case WeaponType.CROSSBOW:
				return AttackType.BOLT;
			case WeaponType.BOW:
				return AttackType.ARROW;
			case WeaponType.THROWN:
				return AttackType.THROWN;
			case WeaponType.WHIP:
				return AttackType.SLASH;
			case WeaponType.HAMMER:
				return AttackType.CRUSH;
			case WeaponType.DAGGER:
				switch (style) {
					case 2:
						return AttackType.SLASH;
					default:
						return AttackType.STAB;
				}
			case WeaponType.AXE:
				switch (style) {
					case 1:
						return AttackType.CRUSH;
					default:
						return AttackType.SLASH;
				}
			case WeaponType.PICKAXE:
				switch (style) {
					case 2:
						return AttackType.CRUSH;
					default:
						return AttackType.STAB;
				}
			case WeaponType.TWOHANDED:
				switch (style) {
					case 2:
						return AttackType.CRUSH;
					default:
						return AttackType.SLASH;
				}
			case WeaponType.MAGIC_STAFF:
				return AttackType.CRUSH;
			case WeaponType.LONGSWORD:
			case WeaponType.CLAWS:
				switch (style) {
					case 2:
						return AttackType.STAB;
					default:
						return AttackType.SLASH;
				}
			case WeaponType.MACE:
				switch (style) {
					case 2:
						return AttackType.STAB;
					default:
						return AttackType.CRUSH;
				}
			case WeaponType.SPEAR:
				switch (style) {
					case 0:
						return AttackType.STAB;
					case 1:
						return AttackType.SLASH;
					case 2:
						return AttackType.CRUSH;
					case 3:
						return AttackType.STAB;
				}
			case WeaponType.BULWARK: // Bulwark only has one attack option, which is crush.
				return AttackType.CRUSH;
		}
		return AttackType.SLASH;
	}
	
	public static AttackStyle attackStyleFor(Player player) {
		int book = player.varps().varp(843);
		int style = player.varps().varp(43);
		switch (book) {
			case WeaponType.BOW:
			case WeaponType.CROSSBOW:
			case WeaponType.THROWN:
				switch (style) {
					case 0:
						return AttackStyle.ACCURATE;
					case 1:
						return AttackStyle.RAPID;
					case 3:
						return AttackStyle.LONG_RANGE;
					default:
						return AttackStyle.SPECIAL;
				}
			case WeaponType.UNARMED:
				switch (style) {
					case 0:
						return AttackStyle.ACCURATE;
					case 1:
						return AttackStyle.AGGRESIVE;
					case 3:
						return AttackStyle.DEFENSIVE;
				}
			case WeaponType.WHIP:
				switch (style) {
					case 0:
						return AttackStyle.ACCURATE;
					case 1:
						return AttackStyle.CONTROLLED;
					case 3:
						return AttackStyle.DEFENSIVE;
				}
			case WeaponType.AXE:
			case WeaponType.HAMMER:
			case WeaponType.TWOHANDED:
			case WeaponType.PICKAXE:
			case WeaponType.DAGGER:
			case WeaponType.MAGIC_STAFF:
			case WeaponType.LONGSWORD:
			case WeaponType.MACE:
			case WeaponType.CLAWS:
				switch (style) {
					case 0:
						return AttackStyle.ACCURATE;
					case 1:
						return AttackStyle.AGGRESIVE;
					case 2:
						return AttackStyle.CONTROLLED;
					case 3:
						return AttackStyle.DEFENSIVE;
				}
			case WeaponType.SPEAR:
				if (style == 3)
					return AttackStyle.DEFENSIVE;
				return AttackStyle.CONTROLLED;
			case WeaponType.SALAMANDER:
				return AttackStyle.SPECIAL;
			case WeaponType.TRIDENT:
				switch (style) {
					case 0:
						return AttackStyle.ACCURATE;
					case 1:
						return AttackStyle.ACCURATE;
					case 3:
						return AttackStyle.LONG_RANGE;
				}
			case WeaponType.BULWARK:
				return AttackStyle.ACCURATE;
			
		}
		return AttackStyle.SPECIAL;
	}
	
	public static AttackMode xpModeFor(Player player) {
		int book = player.varps().varp(843);
		int style = player.varps().varp(43);
		
		switch (book) {
			case WeaponType.UNARMED:
				switch (style) {
					case 0:
						return AttackMode.ATTACK;
					case 1:
						return AttackMode.STRENGTH;
					case 3:
						return AttackMode.DEFENCE;
					default:
						return AttackMode.ATTACK;
				}
			case WeaponType.AXE:
			case WeaponType.HAMMER:
			case WeaponType.TWOHANDED:
			case WeaponType.PICKAXE:
			case WeaponType.DAGGER:
			case WeaponType.MAGIC_STAFF:
				switch (style) {
					case 0:
						return AttackMode.ATTACK;
					case 1:
						return AttackMode.STRENGTH;
					case 2:
						return AttackMode.STRENGTH;
					case 3:
						return AttackMode.DEFENCE;
					default:
						return AttackMode.ATTACK;
				}
			case WeaponType.BOW:
			case WeaponType.CROSSBOW:
			case WeaponType.THROWN:
				switch (style) {
					case 0:
						return AttackMode.RANGED;
					case 3:
						return AttackMode.SHARED;
					default:
						return AttackMode.RANGED;
				}
			case WeaponType.LONGSWORD:
			case WeaponType.MACE:
			case WeaponType.CLAWS:
				switch (style) {
					case 0:
						return AttackMode.ATTACK;
					case 1:
						return AttackMode.STRENGTH;
					case 2:
						return AttackMode.SHARED;
					case 3:
						return AttackMode.DEFENCE;
					default:
						return AttackMode.ATTACK;
				}
			case WeaponType.WHIP:
				switch (style) {
					case 0:
						return AttackMode.ATTACK;
					case 1:
						return AttackMode.SHARED;
					case 3:
						return AttackMode.DEFENCE;
				}
			case WeaponType.SPEAR:
				switch (style) {
					case 0:
						return AttackMode.SHARED;
					case 1:
						return AttackMode.SHARED;
					case 2:
						return AttackMode.SHARED;
					case 3:
						return AttackMode.DEFENCE;
				}
			case WeaponType.TRIDENT:
				switch (style) {
					case 0:
						return AttackMode.MAGIC;
					case 1:
						return AttackMode.MAGIC;
					case 3:
						return AttackMode.SHARED;
				}
			case WeaponType.CHINCHOMPA:
				switch (style) {
					case 0:
						return AttackMode.RANGED;
					case 1:
						return AttackMode.RANGED;
					case 3:
						return AttackMode.SHARED;
				}
			case WeaponType.HALBERD:
				switch (style) {
					case 0:
						return AttackMode.SHARED;
					case 1:
						return AttackMode.STRENGTH;
					case 3:
						return AttackMode.DEFENCE;
				}
			case WeaponType.STAFF_HALBERD:
				switch (style) {
					case 0:
						return AttackMode.ATTACK;
					case 1:
						return AttackMode.STRENGTH;
					case 3:
						return AttackMode.DEFENCE;
				}
			case WeaponType.SCYTHE:
				switch (style) {
					case 0:
						return AttackMode.ATTACK;
					case 1:
						return AttackMode.STRENGTH;
					case 3:
						return AttackMode.STRENGTH;
					case 4:
						return AttackMode.DEFENCE;
				}
				break;
			case WeaponType.SALAMANDER:
				switch (style) {
					case 0:
						return AttackMode.STRENGTH;
					case 1:
						return AttackMode.RANGED;
					case 2:
						return AttackMode.MAGIC;
				}
			case WeaponType.BULWARK:
				return AttackMode.ATTACK;
			default:
				player.message("Missing experience style for book %d style %d", book, style);
		}
		
		return AttackMode.ATTACK;
	}
	
	public static int blockAnimationFor(Player player) {
		int weapon = player.equipment().hasAt(EquipSlot.WEAPON) ? player.equipment().get(EquipSlot.WEAPON).getId() : 0;
		int shield = player.equipment().hasAt(EquipSlot.SHIELD) ? player.equipment().get(EquipSlot.SHIELD).getId() : 0;
		ItemDefinition shielddef = player.world().definitions().get(ItemDefinition.class, shield);
		boolean godbook = shield != 0 && shielddef.name != null && shielddef.name.toLowerCase().contains("book");
		
		if (weapon == 4084) { // Sled
			return 1466;
		}
		if (shield != 0) {
			// Defender?
			if ((shield >= 8844 && shield <= 8850) || shield == 12954 || shield == 19722) {
				return 4177;
			}
			// Metal shields prioritise over weapons. Not books though. Weapons can prioritise over those.
			if (!godbook)
				return 1156;
		}
		
		// If no weapon, return 424
		if (weapon == 0) {
			return 424;
		}
		
		// Individual cases here.
		switch (weapon) {
			case 22325:
				return 420;
			case 13263: // Abyssal bludgeon
				return 1666;
			case 7671:
			case 7673:
			case 11705:
			case 11706: // Boxing gloves
				return 3679;
			case 11838: // Godswords
			case 11802:
			case 11804:
			case 11806:
			case 11808:
			case 20368:
			case 20370:
			case 20372:
			case 20374:
				return 7056;
			case 19478: //Light ballista
				return 7219;
			case 19481: //Heavy ballista
				return 7219;
			case 11824: // Zammy spear
				return 1709;
			case 20779: // H'ween 2016 hunting knife
				return -1;
			case 21003: // Elder maul
				return 7517;
			case 21015: // Dinh's Bulwark
				return 7512;
		}
		
		// Book-based defaults
		int book = player.varps().varp(843);
		switch (book) {
			case WeaponType.WHIP:
				return 1659;
			case WeaponType.PICKAXE:
				return 397;
			case WeaponType.LONGSWORD:
				return 388;
			case WeaponType.MACE:
				return 403;
			case WeaponType.MAGIC_STAFF:
			case WeaponType.STAFF_HALBERD:
				return 420; // Heh blaze it fkn fagt
			case WeaponType.DAGGER:
				return 378;
			case WeaponType.TWOHANDED:
				return 410;
			case WeaponType.BOW:
				return 424;
			case WeaponType.SPEAR:
			case WeaponType.HALBERD:
				return 430;
			case WeaponType.CLAWS:
				return 397;
		}
		
		return 424;
	}


	public static int attackAnimationFor(Player player) {
		return attackAnimationFor(player, player.equipment().hasAt(EquipSlot.WEAPON) ? player.equipment().get(EquipSlot.WEAPON).getId() : 0);
	}
	
	public static int attackAnimationFor(Player player, int weapon) {
		int book = player.varps().varp(843);
		int style = player.varps().varp(43);
		
		// Handle individual cases first
		if (weapon != 0) {
			switch (weapon) {
				case 22325:
					return 8056;
				case 22324: // Rapier
					return 8145;
				case 20727: // leaf-bladed battleaxe
					return 7004;
                case 12727:
                    return 2323;
				case 10887: //anchor
					return 5865;
				case 13263: // Abyssal bludgeon
					return 3298;
				case 7671:
				case 7673:
				case 11705:
				case 11706: // Boxing gloves
					return 3678;
				case 12924: // Toxic blowpipe
				case 12926: // Toxic blowpipe
					return 5061;
				case 10033: // grey chins
				case 10034: // red chins
				case 11959: // blacl chins
					return 2779;
				case 4734: // Karil's crossbow
					return 2075;
				case 6522:
					return 3353;
				case 11791: // sotd
				case 12902: // uncharged tsotd
				case 12904: // t-sotd
					return 440; // proper spear emote
				case 1215: // dd
				case 1231: // ddp
				case 5680: // ddpp
				case 5698: // dds
				case 13265: // Abby dagger
				case 13267: // Abby dagger
				case 13269: // Abby dagger
				case 13271: // Abby dagger
					return style == 2 ? 390 : 402; // Dragon daggers
				case 11802: // gs
				case 11804: // gs
				case 11806: // gs
				case 11808: // gs
				case 20368: // gs
				case 20370: // gs
				case 20372: // gs
				case 20374: // gs
				case 11838: // sara sword
				case 12808: // blessed ss (full)
				case 12809: // blessed ss
					switch (style) {
						case 0:
							return 7045;
						case 1:
							return 7045;
						case 2:
							return 7054;
						case 3:
							return 7055;
					}
				case 4718: // Dharok's greataxe
				case 4886: // Dharok's greataxe
				case 4887: // Dharok's greataxe
				case 4888: // Dharok's greataxe
				case 4889: // Dharok's greataxe
					return style == 3 ? 2066 : 2067;
				case 4755: // Verac's flail
				case 4982: // Verac's flail
				case 4983: // Verac's flail
				case 4984: // Verac's flail
				case 4985: // Verac's flail
					return 2062;
				case 4747: // Torag's hamers
				case 4958: // Torag's hamers
				case 4959: // Torag's hamers
				case 4960: // Torag's hamers
				case 4961: // Torag's hamers
					return 2068;
				case 5061: // Toxic blowpipe
					return 5061;
				case 4153: // Granite maul
				case 7668: //Gadderhammer
				case 12848: // Granite clamp
					return 1665;
				case 6528: // Obsidian maul
				case 20756: //hill giant club
					return 2661;
				case 19478: // Light ballista
					return 7218;
				case 19481: // Heavy ballista
					return 7218;
				case 11824: // Zammy spear
					switch (style) {
						case 0:
						case 3:
							return 1711;
						case 1:
							return 1712;
						case 2:
							return 1710;
					}
				case 20779: // H'ween 2016 hunting knife
					return 7328;
				case 21003: // Elder maul
					return 7516;
				case 21015: // Dinh's Bulwark
					return 7511;
			}
		}
		
		// Then resolve the remaining ones from the guessing based on book type
		switch (book) {
			case WeaponType.UNARMED:
				return style == 1 ? 423 : 422;
			case WeaponType.AXE:
				return style == 2 ? 401 : 395;
			case WeaponType.HAMMER:
				return 401;
			case WeaponType.BOW:
				return 426;
			case WeaponType.CROSSBOW:
				return 4230;
			case WeaponType.LONGSWORD:
				return style == 2 ? 386 : 390;
			case WeaponType.TWOHANDED:
				return style == 2 ? 406 : 407;
			case WeaponType.PICKAXE:
				return style == 2 ? 400 : 401;
			case WeaponType.DAGGER:
				return style == 2 ? 390 : 386;
			case WeaponType.MAGIC_STAFF:
				return 419;
			case WeaponType.MACE:
				return style == 2 ? 400 : 401;
			case WeaponType.THROWN:
				return 929;
			case WeaponType.WHIP:
				return 1658;
			case WeaponType.SPEAR:
			case WeaponType.HALBERD:
				switch (style) {
					case 1:
						return 440;
					case 2:
						return 429;
					default:
						return 428;
				}
			case WeaponType.CLAWS:
				return 393;
		}
		
		return 422; // Fall back to fist fighting so people know it's a wrong anim and (hopefully) report it.
	}
	
	public Bonuses bonuses(int id) {
		return bonuses.getOrDefault(id, DEFAULT_BONUSES);
	}
	
	public int weaponSpeed(int id) {
		return weaponSpeeds.getOrDefault(id, 4);
	}
	
	public Map<Integer, Integer> requirementsFor(int id) {
		return itemRequirements.get(id);
	}
	
	public static class Bonuses {
		
		public int stab;
		public int slash;
		public int crush;
		public int range;
		public int mage;
		public int stabdef;
		public int slashdef;
		public int crushdef;
		public int rangedef;
		public int magedef;
		public int str;
		public int rangestr;
		public int magestr;
		public int pray;
		
		@Override
		public String toString() {
			return "Bonuses{" +
					"stab=" + stab +
					", slash=" + slash +
					", crush=" + crush +
					", range=" + range +
					", mage=" + mage +
					", stabdef=" + stabdef +
					", slashdef=" + slashdef +
					", crushdef=" + crushdef +
					", rangedef=" + rangedef +
					", magedef=" + magedef +
					", str=" + str +
					", rangestr=" + rangestr +
					", magestr=" + magestr +
					", pray=" + pray +
					'}';
		}
		
	}
	
	public static class EquipmentDefinition {
		
		public int slot = -1;
		public int type;
		public boolean showBeard;
	}
	
}
