package net.dodian.runescape.util;

/**
 * Created by Bart on 8/25/2015.
 */
public class NpcSpawn {
	
	public int id;
	public int x;
	public int z;
	public int level;
	public int radius;
	public boolean PVPWorldExclusive = false;
	public boolean realismExclusive = false;
	public boolean economyExclusive = false;
	public boolean deadmanExclusive = false;
	public String direction = "S";
	
	public int dir() {
		switch (direction.toLowerCase()) {
			case "s":
				return 6;
			case "nw":
				return 0;
			case "n":
				return 1;
			case "ne":
				return 2;
			case "w":
				return 3;
			case "e":
				return 4;
			case "sw":
				return 5;
			case "se":
				return 7;
		}
		return 1;
	}
	
}
