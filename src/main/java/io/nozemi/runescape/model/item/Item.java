package io.nozemi.runescape.model.item;

import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.fs.DefinitionRepository;
import io.nozemi.runescape.fs.ItemDefinition;
import io.nozemi.runescape.model.World;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Bart Pelle on 8/31/2014.
 */
public final class Item {
	
	private int id;
	private int amount;
	private Map<ItemAttrib, Integer> properties;

	public Item() {

	}
	
	public Item(Item item) {
		this(item, item.getAmount());
	}
	
	public Item(Item item, int amount) {
		id = item.id;
		this.amount = amount >= 0 ? amount : 0;
		
		if (item.hasProperties())
			properties = new EnumMap<>(item.properties);
	}
	
	public Item(int id) {
		this.id = id;
		amount = 1;
	}
	
	public Item(int id, int amount) {
		this.id = id;
		this.amount = amount >= 0 ? amount : 0;
	}
	
	public int getId() {
		return id;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public boolean hasProperties() {
		return properties != null && properties.size() > 0;
	}

	public Map<ItemAttrib, Integer> getProperties() {
		return properties;
	}

	public Item property(ItemAttrib key, Integer value) {
		if (properties == null)
			properties = new EnumMap<>(ItemAttrib.class);
		properties.put(key, value);
		
		return this;
	}

	public int modifyProperty(ItemAttrib attrib, int modifier, int defaultValue) {
        int returnVal = hasProperties() ? property(attrib) + modifier : defaultValue;
        property(attrib, returnVal);

        return (property(attrib));
    }
	
	public Set<Map.Entry<ItemAttrib, Integer>> propset() {
		return properties.entrySet();
	}
	
	public Integer property(ItemAttrib key) {
		return hasProperties() ? properties.getOrDefault(key, 0) : 0;
	}
	
	public Integer propertyOr(ItemAttrib key, Integer defaultValue) {
		return hasProperties() ? properties.getOrDefault(key, defaultValue) : defaultValue;
	}
	
	public Item duplicateProperties(Item source) {
		properties = source.properties;
		return this;
	}
	
	/**
	 * Resolve this item's definition in the world's repository for definitions. No definition returns <code>null</code>.
	 *
	 * @param world The world to use to resolve the definition for this item.
	 * @return The item's definitions, or <code>null</code> if that didn't work out.
	 */
	public ItemDefinition definition(World world) {
		return GameInitializer.world().definitions().get(ItemDefinition.class, id);
	}
	
	public ItemDefinition definition(DefinitionRepository repo) {
		return repo.get(ItemDefinition.class, id);
	}
	
	public int realPrice(World world) {
		return realPrice(world, false);
	}
	
	public int realPrice(World world, boolean forceCoins) {
		// TODO: Implement price calculation
		return 0;
	}
	
	public String name(World world) {
		return definition(world).name;
	}
	
	public Item unnote(World world) {
		return unnote(world.definitions());
	}
	
	public Item unnote(DefinitionRepository repo) {
		ItemDefinition def = definition(repo);
		if (def.noteModel > 0) {
			return new Item(def.notelink, amount); // Properties check not required: properties do not stick to notes.
		}
		
		return this;
	}
	
	public Item note(World world) {
		ItemDefinition def = definition(world);
		if (def == null || def.noteModel > 0 || def.notelink < 1) {
			return this;
		}
		
		return new Item(def.notelink, amount);
	}
	
	public boolean noted(World world) {
		return noted(world.definitions());
	}
	
	public boolean noted(DefinitionRepository repo) {
		return unnote(repo) != this;
	}
	
	public boolean noteable(World world) {
		return id != note(world).getId();
	}
	
	public boolean stackable(World world) {
		return definition(world).stackable();
	}
	
	public boolean tradable(World world) {
		ItemDefinition def = definition(world);

		// TODO: Implement tradeable logic

		return true;
	}
	
	public boolean rawtradable(World world) {
		ItemDefinition def = definition(world);
		return (def == null || id == 995 || id == 13307 || def.grandexchange || def.noteModel > 0 || def.notelink > 0 || PVP_TRADABLES.contains(id));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Item i = (Item) obj;
		return i.id == id && i.amount == amount;
	}
	
	@Override
	public String toString() {
		return String.format("Item[id:%s, amt:%s%s]", id, amount, properties == null ? "" : ", attribs:"+properties);
	}
	
	private static final Set<Integer> INTERFACE_TRADABLES = new HashSet<Integer>() {
		{
			add(12791); // Rune pouch
		}
	};
	
	/**
	 * An extra list of some items which may not have a BM value but are tradeable on W2
	 */
	private static final Set<Integer> PVP_TRADABLES = new HashSet<Integer>() {
		{
			add(13190); // Credits
			add(12006); // Kraken tentacle
			add(6199); // Mystery box!
			add(12931); // Serpentine helm (charged)
			add(12904); // Toxic sotd (charged)
			add(12436); // Amulet of fury (or)
			add(12773); // Lava whip
			add(12774); // Ice whip
			add(12765); // Coloured D bow
			add(12766); // Coloured D bow
			add(12767); // Coloured D bow
			add(12768); // Coloured D bow
			add(12848); // G maul with clamp applied
			add(12796); // New look steam battlestaff
			add(12806); // New look malediction
			add(12807); // New look odium
			add(11770); // Seers ring (i)
			add(11771); // Archer ring (i)
			add(11772); // Warrior ring (i)
			add(11773); // Berserker ring (i)
			add(12692); // Treasonous ring (i)
			add(12691); // Tyrannical ring (i)
			add(13202); // Ring of the gods (i)
			add(11283); // Dragonfire shield charged
			add(12419); // Light infinity
			add(12420); // Light infinity
			add(12421); // Light infinity
			add(12457); // Dark infinity
			add(12458); // Dark infinity
			add(12459); // Dark infinity
			add(13438); // 3rd age box.
			add(13652); // D claws
			add(13655); // Gnome child hat
			add(9069); // Moonclan
			add(9070); // Moonclan
			add(9071); // Moonclan
			add(9072); // Moonclan
			add(9073); // Moonclan
			add(9074); // Moonclan
			add(8148); // Pet box

			add(12902); // TSOTD
			add(12924); // Blowpipe empty
			add(12926); // Blowpipe
			add(12929); // Serpentine empty
			add(11905); // Trident of the seas (full)
			add(11907); // Trident of the seas (used)
			add(11908); // Trident of the seas (empty)
			add(12899); // Trident of the swamp
			add(12900); // Trident of the swamp (empty)
			add(13197); // Tanzanite helm
			add(13199); // Magma helm
			add(12853); // Amulet of the damned
			add(11061); // Ancient mace
			add(19722); //Dragon defender (t)
			
			add(3606); // Blood key (easy)
			add(3608); // Blood key (medium)
			add(7297); // Blood key (hard)
			add(7299); // Blood key (elite)
			add(7302); // Blood key (master)

			add(20714); // Tome of Fire (charged)
			add(19484); // Dragon Javelin
			add(19582); // Dragon Javelin heads
			add(21633); //Wyvern shield
			add(22002); //Dragon ward
			add(19550); //Ring of suffering
			add(19710); //Ring of suffering(i)
			add(20655); //Ring of suffering r
			add(20657); //Ring of suffering r(i)
		}
	};
	
	private static final Set<Integer> ECO_TRADABLES = new HashSet<Integer>() {
		{
			// Basic items - would usually have charges
			add(13190); // Credits
			add(11283); // Dragonfire shield
			add(12006); // Abyssal tentacle
			add(12902); // TSOTD
			add(12904); // TSOTD
			add(12924); // Blowpipe
			add(12926); // Blowpipe
			add(12931); // Serpentine helm
			add(13197); // Tanzanite helm
			add(13199); // Magma helm
			add(11907); // Trident of the seas
			add(12899); // Trident of the swamp
			add(6199); // Mystery box!
			
			// Normally untradable
			add(13438); // 3rd age box.
			add(13652); // D claws
			add(13655); // Gnome child hat
			add(9069); // Moonclan
			add(9070); // Moonclan
			add(9071); // Moonclan
			add(9072); // Moonclan
			add(9073); // Moonclan
			add(9074); // Moonclan
			add(8148); // Pet box
			add(12853); // Amulet of the damned
			add(11061); // Ancient mace
			
			add(11770); // Seers ring (i)
			add(11771); // Archer ring (i)
			add(11772); // Warrior ring (i)
			add(11773); // Berserker ring (i)
		}
	};
	
	// If this item is an untradable item which is lost on death.
	// This is only required because on OSS - by default all untradables are kept.
	// However, to counter this, a lot of stuff on OSS is tradable - tent etc.
	// This then gets even more complex - as void is, like RS, untradable. OSS then loops through
	// This untradable (always kept) and removes (drops to floor) _some_ special items - like void.
	
	public boolean lostUntradable(World world) {
		if (skillcape()) { // Skill capes/hoods. Lost on death.
			return true;
		}
		if (id == 21633) {
			return true;
		}
		if (id >= 12414 && id <= 12418) { // dragon (g)
			return true;
		}
		if (id >= 8714 && id <= 8744) { // heraldic shields
			return true;
		}
		if (id >= 8682 && id <= 8712) { // heraldic helmets
			return true;
		}
		for (int i : LOST_UNTRADES) {
			if (id == i) return true;
		}
		//if (ItemsOnDeath.isCrystal(id)) return true;
		// Void would go here if it wasn't perma kept.
		// Might want to add some stuff in future like avas (currently perma kept)
		return false;
	}
	
	public boolean skillcape() {
		return id >= 9747 && id <= 9814;
	}
	
	// Untradables that are NOT always perma kept regardless of being in top-3 protected unskulled items.
	public static final int[] LOST_UNTRADES = new int[]{
			20000, // d scim (g)
			19722, // defender (t)
			19720, // occult (or)
			12436, // fury (or)
			20366, // torture (or)
			22249, //anguish (or)
			20368, // godsword (g)
			20370,  // godsword (g)
			20372,  // godsword (g)
			20374, // godsword (g)
			12419, 12420, 12421, 12457, 12458, 12459, // coloured infinity
			12773, 12774, // coloured whips
			12766, 12765, 12767, 12768, // coloured dark bows
			12807, 12806, // odium and malediction ornament shields
			12796, // steam staff
			12848, // granite clamp
			22242, //Dragon platebody
			22244, //Dragon kiteshield
			22234, //Dragon boots
			22296 //Staff of light
	};

	public Map<ItemAttrib, Integer> properties() {
		return this.properties;
	}
}
