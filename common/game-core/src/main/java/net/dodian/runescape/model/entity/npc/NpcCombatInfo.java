package net.dodian.runescape.model.entity.npc;

import net.dodian.runescape.events.Script;
import net.dodian.runescape.model.Entity;
import kotlin.jvm.functions.Function1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Bart on 10/6/2015.
 */
public class NpcCombatInfo {
	
	private static final Logger logger = LogManager.getLogger(NpcCombatInfo.class);
	
	public int[] ids;
	public int id;
	
	public Bonuses bonuses = new Bonuses();
	public Stats originalStats;
	public Stats stats;
	public Animations animations;
	public Sounds sounds;
	public int maxHit;
	public int attackSpeed = 4;
	public double slayerExperience = 0;
	public int slayerLevel = 0;
	public int deathLength = 5;
	public Scripts scripts;
	public boolean aggressive;
	public int aggroRadius = 1;
	public boolean retaliates = true;
	public boolean unstacked = false; // True means it won't stack on other npcs.
	public int respawnTime = 50;
	public int respawnTimeRandomOffset = 0;
	public boolean unAttackAble = false;
	public int dropRolls = 1;
	public boolean boss = false;
	
	public int poison;
	public int poisonChance = 100;
	
	public boolean poisonous() {
		return poison > 0 && poisonChance > 0;
	}
	
	public static class Stats {
		public int attack = 1;
		public int strength = 1;
		public int defence = 1;
		public int magic = 1;
		public int ranged = 1;
		public int health = 1;
		
		public Stats clone() {
			Stats stats = new Stats();
			stats.attack = attack;
			stats.strength = strength;
			stats.defence = defence;
			stats.magic = magic;
			stats.ranged = ranged;
			stats.health = health;
			return stats;
		}
		
		@Override
		public String toString() {
			return String.format("[%d, %d, %d, %d, %d, %d]", attack, strength, defence, health, ranged, magic);
		}
	}
	
	public static class Bonuses {
		public int attack;
		public int magic;
		public int ranged;
		public int strength;
		public int stabDefence;
		public int slashDefence;
		public int crushDefence;
		public int rangedDefence;
		public int magicDefence;
	}
	
	public static class Animations {
		public int attack;
		public int block;
		public int death;
	}
	
	public static class Sounds {
		public Integer[] attack;
		public Integer[] block;
		public Integer[] death;
	}
	
	public static class Scripts {
		public String hit;
		public String combat;
		public String dropTable;
		public String death;
		public String aggression;

		public Function1<Script, Object> hit_;
		public Function1<Script, Object> combat_;
		public Function1<Script, Object> death_;
		public Function1<Entity, Boolean> aggression_;
		
		public void resolve() {
			try {
				hit_ = (Function1<Script, Object>) resolveField(hit);
				combat_ = (Function1<Script, Object>) resolveField(combat);
				death_ = (Function1<Script, Object>) resolveField(death);
				aggression_ = (Function1<Entity, Boolean>) resolveField(aggression);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private static Object resolveField(String str) {
			if (str == null)
				return null;
			
			String scriptName = str.substring(str.lastIndexOf(".") + 1);
			String className = str.substring(0, str.lastIndexOf("."));
			
			Class<?> clazz;
			try {
				clazz = Class.forName(className);
				try {
					return clazz.getDeclaredField(scriptName).get(null);
				} catch (NullPointerException e) {
					logger.error("bad script mapping: " + className + " - " + scriptName);
					return null;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			} catch (ClassNotFoundException ce) {
				logger.error("Cannot find class! : " + className + " - " + scriptName);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		private static Object resolveClass(String str) throws Exception {
			if (str == null)
				return null;
			
			try {
				return Class.forName(str).newInstance();
			} catch (NullPointerException e) {
				logger.error("bad class name mapping: " + str);
				return null;
			}
		}
	}
	
}
