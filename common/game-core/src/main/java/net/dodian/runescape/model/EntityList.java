package net.dodian.runescape.model;

import net.dodian.runescape.util.PermutedSequence;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class EntityList<T extends Entity> {
	
	private Entity[] entries;
	private List<Entity> entriesList;
	private PermutedSequence permutedSequence;
	private int size; // Current size, not capacity
	
	public EntityList(int size) {
		entries = new Entity[size];
		entriesList = Arrays.asList(entries);
		permutedSequence = new PermutedSequence(size);
	}
	
	public T get(int index) {
		if (index >= 1 && index < entries.length) {
			return (T) entries[index];
		}
		
		return null;
	}
	
	public T fastget(int index) {
		return (T) entries[index];
	}
	
	public int add(T obj) {
		for (int i = 1; i < entries.length; i++) {
			if (entries[i] == null) {
				entries[i] = obj;
				size++;
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean remove(T obj) {
		for (int i = 1; i < entries.length; i++) {
			if (entries[i] == obj) {
				entries[i].index(-1);
				entries[i] = null;
				size--;
				return true;
			}
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T remove(int index) {
		if (index < 1 || index >= entries.length)
			return null;
		
		T old = (T) entries[index];
		entries[index] = null;
		
		if (old != null)
			size--;
		
		return old;
	}
	
	public int count(Area area) {
		int count = 0;
		
		for (Entity entity : entries) {
			if (entity != null && area.contains(entity.tile())) {
				count++;
			}
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public void forEach(Consumer<? super T>... actions) {
		int size = entriesList.size();
		
		for (Consumer<? super T> a : actions) {
			for (int i = 0; i < size; i++) {
				Entity e = entriesList.get(i);
				if (e != null)
					((Consumer<? super Entity>) a).accept(e);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void forEachKt(Function1<? super T, Unit>... actions) {
		int size = entriesList.size();
		
		for (Function1<? super T, Unit> a : actions) {
			for (int i = 0; i < size; i++) {
				Entity e = entriesList.get(i);
				if (e != null)
					((Function1<? super Entity, Unit>) a).invoke(e);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void forEachInArea(Area area, Consumer<? super T>... actions) {
		int size = entriesList.size();
		
		for (Consumer<? super T> a : actions) {
			for (int i = 0; i < size; i++) {
				Entity e = entriesList.get(i);
				if (e != null && area.contains(e.tile()))
					((Consumer<? super Entity>) a).accept(e);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void forEachInAreaKt(Area area, Function1<? super T, Unit>... actions) {
		int size = entriesList.size();
		
		for (Function1<? super T, Unit> a : actions) {
			for (int i = 0; i < size; i++) {
				Entity e = entriesList.get(i);
				if (e != null && area.contains(e.tile()))
					((Function1<? super Entity, Unit>) a).invoke(e);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void forEachShuffled(Consumer<? super T>... actions) {
		if (entries.length != permutedSequence.size()) {
			permutedSequence = new PermutedSequence(entries.length);
		}
		
		for (Consumer<? super T> a : actions) {
			for (int i = 0; i < entries.length; i++) {
				Entity e = entries[permutedSequence.getNextIndex()];
				if (e != null) {
					((Consumer<? super Entity>) a).accept(e);
				}
			}
		}
		
		permutedSequence.reset();
	}
	
	public void forEachWithinDistance(Tile tile, int distance, Consumer<? super T>... actions) {
		for (Consumer<? super T> a : actions)
			entriesList.stream().filter(e -> e != null && e.tile().distance(tile) <= distance).forEach((Consumer<? super Entity>) a);
	}
	
	public Stream<T> stream() {
		return (Stream<T>) entriesList.stream();
	}
	
	public List<T> getEntriesList() {
		return (List<T>) entriesList;
	}
	
	public int size() {
		return size;
	}
	
	public Entity[] raw() {
		return entries;
	}
}
