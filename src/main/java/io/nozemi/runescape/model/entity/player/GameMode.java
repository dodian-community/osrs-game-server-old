package io.nozemi.runescape.model.entity.player;

/**
 * Created by Bart on 11/30/2015.
 */
public enum GameMode {
	
	LAID_BACK(1, 1000, 20, 1, 1.3),
	CLASSIC(2, 250, 20, 3, 1.0),
	REALISM(4, 10, 10, 5, 0.9);
	
	private int uid;
	private int skillXp;
	private int combatXp;
	private int slayerPointMultiplier;
	private double skillPetMod;
	private static GameMode[] cache;
	
	GameMode(int uid, int combatXp, int skillXp, int slayerPointMultiplier, double skillPetMod) {
		this.uid = uid;
		this.skillXp = skillXp;
		this.combatXp = combatXp;
		this.slayerPointMultiplier = slayerPointMultiplier;
		this.skillPetMod = skillPetMod;
	}
	
	public int uid() {
		return uid;
	}
	
	public int skillXp() {
		return skillXp;
	}
	
	public int combatXp() {
		return combatXp;
	}
	
	public int slayerPointMultiplier() {
		return slayerPointMultiplier;
	}
	
	public double skillPetMod() {
		return skillPetMod;
	}
	
	public static GameMode forUid(int uid) {
		if (cache == null) {
			cache = values();
		}
		
		for (GameMode m : cache) {
			if (m.uid == uid)
				return m;
		}
		
		return null;
	}
	
}
