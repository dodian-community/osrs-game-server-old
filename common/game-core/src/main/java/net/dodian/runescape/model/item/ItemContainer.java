package net.dodian.runescape.model.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.dodian.runescape.GameInitializer;
import net.dodian.runescape.fs.ItemDefinition;
import net.dodian.runescape.model.GroundItem;
import net.dodian.runescape.model.World;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.util.Tuple;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Bart on 7/10/2015.
 */
@Component
@JsonIgnoreProperties({"beanFactory", "world", "empty", "iterator"})
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ItemContainer implements Iterable<Item>, BeanFactoryAware {
	
	private static final Tuple<Integer, Item> NULL_TUPLE = new Tuple<>(-1, null);

	private Item[] items;
	private Type type;
	private boolean dirty = true;
	private World world;
	
	/*public ItemContainer(int size, Type type) {
		this.world = beanFactory.getBean(World.class);
		items = new Item[size];
		this.type = type;
	}
	
	public ItemContainer(Item[] items, Type type) {
		this.world = beanFactory.getBean(World.class);
		this.items = items;
		this.type = type;
	}*/
	
	public Type type() {
		return type;
	}
	
	public int size() {
		return items.length;
	}

	public ItemContainer setSize(int size) {
		this.items = new Item[size];
		return this;
	}

	public ItemContainer setType(Type type) {
		this.type = type;
		return this;
	}
	
	public int nextFreeSlot() {
		for (int i = 0; i < size(); i++) {
			if (items[i] == null)
				return i;
		}
		
		return -1;
	}
	
	/**
	 * Searches for the item id specified in the argument and returns the item object corresponding.
	 * @param itemId
	 * @return
	 */
	public Item byId(int itemId) {
		for (int i = 0; i < items().length; i++) {
			if (items()[i] == null) {
				continue;
			}
			if (items()[i].getId() == itemId) {
				return items()[i];
			}
		}
		
		return null;
	}
	
	public void replace(int slot, int itemId) {
		if (slot >= size()) {
			throw new IllegalStateException("Slot cannot exceed container size!");
		}
		if (itemId == -1) {
			items[slot] = null;
		} else {
			items[slot] = new Item(itemId);
		}
		makeDirty();
	}
	
	public boolean isEmpty() {
		return freeSlots() == size();
	}
	
	public int freeSlots() {
		int slots = 0;
		
		for (int i = 0; i < size(); i++) {
			if (items[i] == null)
				slots++;
		}
		
		return slots;
	}
	
	public boolean hasItems() {
		for (int i = 0; i < size(); i++) {
			if (items[i] != null)
				return true;
		}
		return false;
	}
	
	public int occupiedSlots() {
		return size() - freeSlots();
	}
	
	public boolean full() {
		return nextFreeSlot() == -1;
	}
	
	public void empty() {
		for (int i = 0; i < size(); i++) {
			items[i] = null;
		}
		makeDirty();
	}
	
	public void makeDirty() {
		dirty = true;
	}
	
	public void clean() {
		dirty = false;
	}
	
	public boolean dirty() {
		return dirty;
	}
	
	public Result addOrDrop(Item item, Player player) {
		Result r = add(item, true);
		if (!r.success()) {
			world.spawnGroundItem(new GroundItem(world, new Item(item, r.requested - r.completed), player.tile(), player.id()));
		}
		return r;
	}
	
	public Result add(Item item) {
		return add(item, false);
	}
	
	public Result add(Item item, boolean force) {
		if (item == null || item.getAmount() <= 0)
			return new Result(item == null ? -1 : item.getAmount(), 0);
		
		int start = Math.min(0, slotOf(item.getId()));
		return add(item, force, start);
	}

	public Item[] getItems() {
		return items;
	}

	/**
	 * A flag checking if the container has room for the given item argument.
	 * @param item
	 * @return
	 */
	public boolean roomFor(Item item) { // TODO stackable & already has check.. needs World param
		return freeSlots() >= item.getAmount();
	}
	
	@Override
	public String toString() {
		return "ItemContainer{" +
				", items=" + Arrays.toString(items) +
				", type=" + type +
				", dirty=" + dirty +
				'}';
	}
	
	public Result add(Item item, boolean force, int start) {
		if (item == null || item.getAmount() <= 0)
			return new Result(item == null ? -1 : item.getAmount(), 0);
		
		if (start < 0)
			start = 0;

		if(world == null) {
			this.world = GameInitializer.world();
		}
		
		ItemDefinition def = item.definition(world);
		
		if (isBank()) {
			// Don't allow jail ores to be bankable. Or DMM keys.
			// How the heck do you have a placeholder in your inventory? Maybe we fucked pets again 4Head
		}
		
		boolean stackable = !item.hasProperties() && (def.stackable() || type == Type.FULL_STACKING);
		int amt = count(item.getId());
		
		// On banks, let's only count the first stack.
		if (stackable && type == Type.FULL_STACKING) {
			Tuple<Integer, Item> firstMatch = findFirst(item.getId());
			
			if (firstMatch.first() != -1) {
				amt = firstMatch.second().getAmount();
			}
		}
		
		// Determine if this is going to work in advance
		if (!force) {
			if (stackable && item.getAmount() > Integer.MAX_VALUE - amt) {
				return new Result(item.getAmount(), 0);
			} else if (!stackable && item.getAmount() > size() - amt) {
				return new Result(item.getAmount(), 0);
			}
		}
		
		// When depositing to bank, check for the placeholders. Only if it's not in bank yet!
		if (isBank() && def.placeheld > 0 && def.pheld14401 != 14401 && amt <= 0) { // If it was 14401, it's a placeholder.
			// Find that placeholder.
			Tuple<Integer, Item> placeholder = findFirst(def.placeheld);
			if (placeholder.first() >= 0) {
				set(placeholder.first(), null); // Kill placeholder
				start = placeholder.first(); // Begin iteration at that spot now
			}
		}
		
		// And complete the actual operation =)
		if (stackable) {
			int index = findFirst(item.getId()).first();
			
			if (index == -1) {
				if (nextFreeSlot() == -1)
					return new Result(item.getAmount(), 0);
				
				// It has been requested to insert the item at a specific place, or fallback to the available one.
				int targetSlot = items[start] == null ? start : nextFreeSlot();
				items[targetSlot] = new Item(item.getId(), item.getAmount());
				makeDirty();
				return new Result(item.getAmount(), item.getAmount(), targetSlot);
			} else {
				long cur = amt;
				long target = cur + item.getAmount();
				int add = (int) (target > Integer.MAX_VALUE ? Integer.MAX_VALUE - cur : item.getAmount());
				
				items[index] = new Item(item.getId(), amt + add);
				makeDirty();
				return new Result(item.getAmount(), add, index);
			}
		} else {
			List<Integer> slots = new LinkedList<>();
			int left = item.getAmount();
			for (int x = 0; x < size(); x++) {
				int i = (x + start) % size();
				if (items[i] == null) {
					items[i] = new Item(item, 1);
					slots.add(i);
					if (--left == 0) {
						break;
					}
				}
			}
			
			makeDirty();
			return new Result(item.getAmount(), item.getAmount() - left, slots.stream().mapToInt(i -> i).toArray());
		}
	}
	
	public Result remove(int id, boolean force) {
		Item item = new Item(id);
		return remove(item, force, findFirst(item.getId()).first());
	}
	
	public Result remove(int id, boolean force, int start) {
		Item item = new Item(id);
		return remove(item, force, start);
	}
	
	public Result remove(Item item, boolean force) {
		return remove(item, force, findFirst(item.getId()).first());
	}
	
	public Result remove(Item item, boolean force, int start) {
		if (item == null || item.getAmount() <= 0)
			return new Result(item == null ? -1 : item.getAmount(), 0);
		
		if (start < 0)
			start = 0;
		
		ItemDefinition def = item.definition(GameInitializer.world());
		boolean stackable = !item.hasProperties() && (def.stackable() || type == Type.FULL_STACKING);
		int amt = count(item.getId());
		
		// Do we even have this item?
		if (amt < 1) {
			return new Result(item.getAmount(), 0);
		}
		
		// Determine if this is going to work in advance
		if (!force) {
			if (item.getAmount() > amt) {
				return new Result(item.getAmount(), 0);
			}
		}
		
		// And complete the actual operation =)
		if (stackable) {
			Item i = items[start];
			if (i == null) {
				return new Result(item.getAmount(), 0);
			}
			int remove = Math.min(item.getAmount(), items[start].getAmount());
			items[start] = new Item(items[start], items[start].getAmount() - remove);
			
			if (items[start].getAmount() == 0)
				items[start] = null;
			
			makeDirty();
			return new Result(item.getAmount(), remove, start);
		} else {
			List<Integer> slots = new LinkedList<>();
			int left = item.getAmount();
			
			for (int x = 0; x < size(); x++) {
				int i = (x + start) % size();
				if (items[i] != null && items[i].getId() == item.getId()) {
					items[i] = null;
					slots.add(i);
					if (--left == 0) {
						break;
					}
				}
			}
			
			makeDirty();
			return new Result(item.getAmount(), item.getAmount() - left, slots.stream().mapToInt(i -> i).toArray());
		}
	}
	
	/**
	 * Deprecated. Please refrain from setting items directly, as it is not a transactional operation with any sort
	 * of item id validation anywhere. Instead, remove the item based on the id and amount of a previous transaction
	 * result.
	 */
	@Deprecated
	public void set(int slot, Item item) {
		if (item != null && item.getAmount() < 1)
			item = null;
		items[slot] = item;
		makeDirty();
	}
	
	public int count(int item) {
		long count = 0;
		
		// Stackability check here
		boolean stacks = new Item(item).definition(world).stackable();
		
		for (Item i : items) {
			if (i != null && i.getId() == item) {
				count += i.getAmount();
				
				// Avoid breaking the game by returning a 'fake' count on stackables (indicates game error)
				if (stacks)
					break;
			}
		}
		
		return (int) Math.min(Integer.MAX_VALUE, count);
	}
	
	public int countSlot(int slot, int itemId) {
		if (slot < 0 || slot >= items.length) {
			return 0;
		}
		
		Item item = items[slot];
		if (item == null || item.getId() != itemId) {
			return 0;
		}
		
		return Math.min(Integer.MAX_VALUE, item.getAmount());
	}
	
	public int count(Integer... matches) {
		List<Integer> list = Arrays.asList(matches);
		
		long count = 0;
		
		for (Item i : items) {
			if (i != null && list.contains(i.getId()))
				count += i.getAmount();
		}
		
		return (int) Math.min(Integer.MAX_VALUE, count);
	}
	
	public boolean insert(Item item, int at) {
		if (full() || at >= items.length)
			return false;
		
		// Create a new item array, fill it, insert and concat
		Item[] temp = new Item[items.length];
		for (int i = 0, t = 0; i < items.length; i++) {
			if (i == at) {
				temp[t++] = item;
			}
			
			if (items[i] != null)
				temp[t++] = items[i];
		}
		
		items = temp;
		makeDirty();
		return true;
	}
	
	public void pack() {
		Item[] temp = new Item[items.length];
		for (int i = 0, t = 0; i < items.length; i++) {
			if (items[i] != null)
				temp[t++] = items[i];
		}
		
		items = temp;
		makeDirty();
	}
	
	public boolean has(Item item) {
		return item != null && findFirst(item.getId()).first() != -1;
	}
	
	public boolean has(int item) {
		return findFirst(item).first() != -1;
	}
	
	public boolean hasAt(int slot, int item) {
		Item at = items[slot];
		return at != null && at.getId() == item;
	}
	
	public boolean hasAny(int... items) {
		for (int i : items)
			if (findFirst(i).first() != -1)
				return true;
		return false;
	}
	
	public boolean hasAny(Set<Integer> items) {
		return findFirst(items).first() != -1;
	}
	
	public boolean hasAll(Item... items) {
		for (Item i : items)
			if (i != null && findFirst(i.getId()).first() == -1)
				return false;
		return true;
	}
	
	public boolean hasAll(int... items) {
		for (int i : items)
			if (findFirst(i).first() == -1)
				return false;
		return true;
	}
	
	public boolean hasAllArr(Item[] items) {
		for (Item i : items)
			if (i != null && findFirst(i.getId()).first() == -1)
				return false;
		return true;
	}
	
	public boolean hasAllArr(int[] items) {
		for (int i : items)
			if (findFirst(i).first() == -1)
				return false;
		return true;
	}
	
	public boolean swap(int slot1, int slot2) {
		if (slot1 < 0 || slot1 >= items.length || slot2 < 0 || slot2 >= items.length)
			return false;
		
		Item temp = items[slot1];
		items[slot1] = items[slot2];
		items[slot2] = temp;
		makeDirty();
		return true;
	}
	
	public Item get(int slot) {
		if (slot < 0 || slot >= items.length) {
			return null;
		}
		return items[slot];
	}

	public int getId(int slot) {
		Item item = get(slot);
		return item == null ? -1 : item.getId();
	}
	
	public boolean hasAt(int slot) {
		return slot >= 0 & slot < size() && items[slot] != null;
	}
	
	public Tuple<Integer, Item> findFirst(int item) {
		for (int i = 0; i < size(); i++) {
			if (items[i] != null && items[i].getId() == item)
				return new Tuple<>(i, items[i]);
		}
		
		return NULL_TUPLE;
	}
	
	public Tuple<Integer, Item> findFirst(Set<Integer> matches) {
		for (int i = 0; i < size(); i++) {
			if (items[i] != null && matches.contains(items[i].getId()))
				return new Tuple<>(i, items[i]);
		}
		
		return NULL_TUPLE;
	}
	
	public List<Tuple<Integer, Item>> findAll(int item) {
		List<Tuple<Integer, Item>> results = new LinkedList<>();
		
		for (int i = 0; i < size(); i++) {
			if (items[i] != null && items[i].getId() == item)
				results.add(new Tuple<>(i, items[i]));
		}
		
		return results;
	}
	
	public Item[] copy() {
		return items.clone();
	}
	
	public Item[] items() {
		return items;
	}
	
	/**
	 * Set this containers items
	 *
	 * @param items
	 */
	public void items(Item[] items) {
		this.items = items;
		makeDirty();
	}
	
	public void restore(Item[] copy) {
		for (int i = 0; i < items.length; i++) {
			if (i < copy.length) {
				items[i] = copy[i];
			} else {
				items[i] = null;
			}
		}
	}
	
	public int slotOf(int id) {
		for (int i = 0; i < size(); i++) {
			if (items[i] != null && items[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Resolves the container to a total value
	 * @return
	 */
	public int valueOf() {
		int total = 0;
		for (int i = 0; i < size(); i++) {
			if (items[i] != null) {
				//total += world().prices().getOrElse(items[i].id(), 0) * items[i].amount();
			}
		}
		return total;
	}
	
	public Iterator<Item> iterator() {
		return Arrays.asList(items).iterator();
	}
	
	private boolean isBank() {
		return size() == 800;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.world = beanFactory.getBean(World.class);
	}

	public static enum Type {
		REGULAR, FULL_STACKING
	}
	
	public static class Result {
		private int requested;
		private int completed;
		private int[] effectedSlots;
		
		public Result(int requested, int completed, int... effectedSlots) {
			this.requested = requested;
			this.completed = completed;
			this.effectedSlots = effectedSlots;
		}
		
		public int requested() {
			return requested;
		}
		
		public int completed() {
			return completed;
		}
		
		public boolean success() {
			return completed == requested;
		}
		
		public boolean failed() {
			return !success();
		}
		
		public int[] effectedSlots() {
			return effectedSlots;
		}
		
		@Override
		public String toString() {
			return "Result{" +
					"requested=" + requested +
					", completed=" + completed +
					", effectedSlots=" + Arrays.toString(effectedSlots) +
					", success()=" + success() +
					'}';
		}
	}
	
}
