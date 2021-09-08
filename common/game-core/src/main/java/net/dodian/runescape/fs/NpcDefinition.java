package net.dodian.runescape.fs;

import io.netty.buffer.Unpooled;
import net.dodian.runescape.io.RSBuffer;
import nl.bartpelle.dawnguard.DataStore;

import java.util.*;

/**
 * Created by Bart Pelle on 10/4/2014.
 */
public class NpcDefinition implements Definition {
	
	public int[] models;
	public String name = "null";
	public int size = 1;
	public int idleAnimation = -1;
	public int walkAnimation = -1;
	public int render3 = -1;
	public int render4 = -1;
	public int render5 = -1;
	public int render6 = -1;
	public int render7 = -1;
	short[] recol_s;
	short[] recol_d;
	short[] retex_s;
	short[] retex_d;
	int[] anIntArray2224;
	public boolean mapdot = true;
	public int combatlevel = -1;
	int width = -1;
	int height = -1;
	public boolean render = false;
	int anInt2242 = 0;
	int contrast = 0;
	public int headIcon = -1;
	public int turnValue = -1;
	int varbit = -1;
	public boolean rightclick = true;
	int varp = -1;
	public boolean aBool2227 = true;
	public int[] altForms;
	public boolean ispet = false;
	public int anInt2252 = -1;
	public String[] options = new String[5];
	public Map<Integer, Object> clientScriptData;
	
	public int id;
	
	private static List<Integer> discoverNPCAnims(DataStore store, int id, boolean debug) {
		NpcDefinition npcdef = new NpcDefinition(id, store.getIndex(2).getContainer(9).getFileData(id, true, true));
		int animId = npcdef.idleAnimation;
		if (debug) System.out.println("Beginning discovery for " + npcdef.name + ".");
		if (debug) System.out.print("Using stand animation to grab kinematic set... ");
		if (debug) System.out.println(animId);
		AnimationDefinition stand = new AnimationDefinition(animId, store.getIndex(2).getContainer(12).getFileData(animId, true, true));
		if (debug) System.out.print("Finding skin set... ");
		int set = stand.skeletonSets[0] >> 16;
		if (debug) System.out.println(set);
		if (debug) System.out.println("Using that set to find related animations...");
		int skin = AnimationSkeletonSet.get(store, set).loadedSkins.keySet().iterator().next();
		
		if (skin == 0) {
			return new ArrayList<>(0);
		}
		
		List<Integer> work = new LinkedList<>();
		for (int i = 0; i < 30000; i++) {
			AnimationDefinition a = new AnimationDefinition(i, store.getIndex(2).getContainer(12).getFileData(i, true, true));
			int skel = a.skeletonSets[0] >> 16;
			try {
				AnimationSkeletonSet sett = AnimationSkeletonSet.get(store, skel);
				if (sett.loadedSkins.keySet().contains(skin)) {
					work.add(i);
					//System.out.println("Animation #" + i + " uses player kinematic set.");
				}
				//System.out.println(skel);
			} catch (Exception e) {
				
			}
		}
		
		if (debug) System.out.println("Found a total of " + work.size() + " animations: " + work);
		return work;
	}
	
	public NpcDefinition(int id, byte[] data) {
		this.id = id;
		
		if (data != null && data.length > 0)
			decode(new RSBuffer(Unpooled.wrappedBuffer(data)));
	}
	
	void decode(RSBuffer buffer) {
		while (true) {
			int op = buffer.readUByte();
			if (op == 0)
				break;
			decode(buffer, op);
		}


		if (id == 7382) {
			name = "Blood Money Wares";
			options[1] = "View Shop";
		}

		if (id == 1306) {
			options[2] = "Set skin";
		}

		if (id == 6481) {
			options[2] = "View Shop";
		}

		if (id == 3008) {
			options[0] = "Talk";
			options[3] = "Trade";
		}
		if (id == 315) {
			options[3] = "Toggle-Options";
		}

		if (id == 3876) {
			name = "Exchange Employee";
		}

		if (id == 5169) {
			name = "Loyalty Point Shop";
			options[2] = "Trade";
		}

		if (id == 6773) {
			options[3] = "Toggle settings";
		}

		if (id == 2713) {
			name = "Credit Manager";
			options[0] = "View-shop";
			options[2] = "Buy-credits";
			options[3] = "Claim-credits";
		}

		if (id == 1815) {
			name = "Vote Manager";
			options[0] = "Trade";
			options[2] = "Cast-votes";
			options[3] = "Claim-votes";
		}

		if(id == 3894) {
			options[0] = null;
			options[2] = "Buy-items";
			options[3] = "Sell-items";
			options[4] = "Sets";
		}

		if(id == 6481) {
			/* Mac */
			options[0] = "Buy-capes";
			options[1] = "Decant-potions";
			options[2] = null;
			combatlevel = 0;
		}

		if(id == 535) {
			options[0] = "Repair-items";
			options[2] = "Upgrade-items";
		}

		if (id == 4398) {
			name = "OS-Scape Wizard";
			options[1] = "Teleport";
			options[2] = "Previous";
		}

		if (id == 4802) {
			name = "Cosmetics Shop";
			options[0] = "View Shop";
		}

		if (id == 4003) {
			name = "Crystal Seed";
			options[0] = "Exchange";
		}

		if(id == 5449) {
			name = "Bob";
			options[0] = "Decant Potions";
			options[1] = null;
			options[2] = null;
			options[3] = null;
		}

		if(id == 3343) {
			name = "OS-Scape Nurse";
			options[0] = "Heal";
			options[1] = null;
			options[2] = null;
		}

		if (id == 913) {
			combatlevel = 0;
			name = "Barrows Wares";
			options[0] = "View Shop";
			options[2] = "Repair Barrows";
		}

		if (id == 4718) {
			name = "Transportation Guide";
			options[3] = "Transport";
		}

		if (id == 4921) {
			combatlevel = 0;
			name = "Consumable Wares";
			options[0] = "View Shop";
		}

		if (id == 5523) {
			name = "Jewellery Wares";
			options[0] = "View Shop";
		}

		if (id == 1305) {
			name = "Cosmetic Wares";
			options[0] = "View Shop";
		}

		if (id == 7456) {
			name = "Misc Wares";
			options[0] = "View Shop";
		}

		if (id == 2995) {
			name = "Range Wares";
			options[0] = "View Shop";
		}

		if (id == 7477) {
			name = "Melee Wares";
			combatlevel = 0;
			options[0] = "View Shop";
		}

		if (id == 7042) {
			name = "Magic Wares";
			options[0] = "View Shop";
		}

		if (id == 4400) {
			name = "Lumbridge Wizard";
			options[2] = "Previous";
		}

		if (id == 2462) {
			name = "Shanomi";
			options[2] = "Trade";
		}

		if (id == 4159) {
			name = "Wizard";
			options[0] = "Teleport";
			options[1] = "Teleport-previous";
		}

		if (id == 276) { // Crier
			name = "OS-Scape Guide";
			options[0] = "View Help";
			options[1] = "Latest Updates";
		}

		if (id == 4398) {
			name = "Edgeville Wizard";
			options[1] = "Teleport";
			options[2] = "Previous";
		}

		if (id == 560) {
			options[2] = "Trade";
		}

		if (id == 1787) {
			name = "PvP Wizard";
			options[0] = "Talk-to";
			options[2] = "Edgeville";
			options[3] = "Canifis";
			options[4] = "Varrock";
		}

		if (id == 7690) {
			options[3] = "View Leaderboard";
		}

		if (id == 503) {
			name = "Bart";
			options[0] = "Claim-refunds";
			options[1] = null;
			options[2] = null;
		}

		if (id == 3461) {
			name = "Count's Assistant";
			options[0] = "Talk-to";
		}

		if (id == 3359) {
			name = "Zombie Priest";
			options[1] = null;
			combatlevel = 0;
		}

		if (id == 3310) {
			name = "Lottery Advisor";
			options[2] = "Deposit";
			options[3] = "Withdraw";
			options[4] = "Claim";
		}

		if (id == 2668) {
			options[2] = null;
			options[3] = null;
			options[4] = null;
		}

		if(id == 5906) {
			name = "Pet Manager";
		}

		if(id == 1120) {
			name = "Event Manager";
			options[2] = "Join";
		}

		if(id == 5442) {
			name = "Security Advisor";
		}

		if(id == 7316) {
			name = "Tournament Manager";
			options[0] = "Join";
			options[2] = "Information";
		}
	}
	
	void decode(RSBuffer buffer, int code) {
		if (code == 1) {
			int numModels = buffer.readUByte();
			models = new int[numModels];
			
			for (int mdl = 0; mdl < numModels; mdl++) {
				models[mdl] = buffer.readUShort();
			}
		} else if (code == 2) {
			name = buffer.readString();
		} else if (code == 12) {
			size = buffer.readUByte();
		} else if (code == 13) {
			idleAnimation = buffer.readUShort();
		} else if (code == 14) {
			walkAnimation = buffer.readUShort();
		} else if (code == 15) {
			render3 = buffer.readUShort();
		} else if (code == 16) {
			render4 = buffer.readUShort();
		} else if (code == 17) {
			walkAnimation = buffer.readUShort();
			render5 = buffer.readUShort();
			render6 = buffer.readUShort();
			render7 = buffer.readUShort();
		} else if (code >= 30 && code < 35) {
			options[code - 30] = buffer.readString();
			if (options[code - 30].equalsIgnoreCase("null")) {
				options[code - 30] = null;
			}
		} else if (code == 40) {
			int var5 = buffer.readUByte();
			recol_s = new short[var5];
			recol_d = new short[var5];
			
			for (int var4 = 0; var4 < var5; var4++) {
				recol_s[var4] = (short) buffer.readUShort();
				recol_d[var4] = (short) buffer.readUShort();
			}
		} else if (code == 41) {
			int var5 = buffer.readUByte();
			retex_s = new short[var5];
			retex_d = new short[var5];
			
			for (int var4 = 0; var4 < var5; var4++) {
				retex_s[var4] = (short) buffer.readUShort();
				retex_d[var4] = (short) buffer.readUShort();
			}
		} else if (code == 60) {
			int var5 = buffer.readUByte();
			anIntArray2224 = new int[var5];
			
			for (int var4 = 0; var4 < var5; var4++) {
				anIntArray2224[var4] = buffer.readUShort();
			}
		} else if (code == 93) {
			mapdot = false;
		} else if (code == 95) {
			combatlevel = buffer.readUShort();
		} else if (code == 97) {
			width = buffer.readUShort();
		} else if (code == 98) {
			height = buffer.readUShort();
		} else if (code == 99) {
			render = true;
		} else if (code == 100) {
			anInt2242 = buffer.readByte();
		} else if (code == 101) {
			contrast = buffer.readByte();
		} else if (code == 102) {
			headIcon = buffer.readUShort();
		} else if (code == 103) {
			turnValue = buffer.readUShort();
		} else if (code == 106 || code == 118) {
			varbit = buffer.readUShort();
			if (varbit == 65535) {
				varbit = -1;
			}
			
			varp = buffer.readUShort();
			if (varp == 65535) {
				varp = -1;
			}
			
			int ending = -1;
			if (code == 118) {
				ending = buffer.readUShort();
				if (ending == 65535) {
					ending = -1;
				}
			}
			
			int var5 = buffer.readUByte();
			altForms = new int[var5 + 2];
			
			for (int var4 = 0; var4 <= var5; var4++) {
				altForms[var4] = buffer.readUShort();
				if (altForms[var4] == 65535) {
					altForms[var4] = -1;
				}
			}
			altForms[var5 + 1] = ending;
		} else if (code == 107) {
			rightclick = false;
		} else if (code == 109) {
			aBool2227 = false;
		} else if (code == 111) {
			ispet = true;
		} else if (code == 249) {
			int length = buffer.readUByte();
			int index;
			if (clientScriptData == null) {
				index = method32(length);
				clientScriptData = new HashMap<>(index);
			}
			for (index = 0; index < length; index++) {
				boolean stringData = buffer.readUByte() == 1;
				int key = buffer.readTriByte();
				clientScriptData.put(key, stringData ? buffer.readString() : buffer.readInt());
			}
		} else {
			throw new RuntimeException("cannot parse npc definition, missing config code: " + code);
		}
	}
	
	public static int method32(int var0) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}
	
	public int[] renderpairs() {
		return new int[] {idleAnimation, render7, walkAnimation, render7, render5, render6, walkAnimation};
	}
}
