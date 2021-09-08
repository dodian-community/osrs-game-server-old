/*
	* Copyright (C) 2007-2017 Sebastiano Vigna
	*
	* Licensed under the Apache License, Version 2.0 (the "License");
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	*
	*     http://www.apache.org/licenses/LICENSE-2.0
	*
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	*/
package net.dodian.runescape.util;

import it.unimi.dsi.fastutil.ints.*;
import it.unimi.dsi.fastutil.objects.AbstractObjectIterator;
import it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A simple, brute-force implementation of a map based on two parallel backing arrays.
 * <p>
 * <p>The main purpose of this
 * implementation is that of wrapping cleanly the brute-force approach to the storage of a very
 * small number of pairs: just put them into two parallel arrays and scan linearly to find an item.
 */
public class Int2IntArrayMapOSS extends AbstractInt2IntMap implements java.io.Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	/**
	 * The keys (valid up to {@link #size}, excluded).
	 */
	private transient int[] key;
	/**
	 * The values (parallel to {@link #key}).
	 */
	private transient int[] value;
	/**
	 * The number of valid entries in {@link #key} and {@link #value}.
	 */
	private int size;
	
	/**
	 * Creates a new empty array map with given key and value backing arrays. The resulting map will have as many entries as the given arrays.
	 * <p>
	 * <p>It is responsibility of the caller that the elements of <code>key</code> are distinct.
	 *
	 * @param key   the key array.
	 * @param value the value array (it <em>must</em> have the same length as <code>key</code>).
	 */
	public Int2IntArrayMapOSS(final int[] key, final int[] value) {
		this.key = key;
		this.value = value;
		size = key.length;
		if (key.length != value.length)
			throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
	}
	
	/**
	 * Creates a new empty array map.
	 */
	public Int2IntArrayMapOSS() {
		this.key = IntArrays.EMPTY_ARRAY;
		this.value = IntArrays.EMPTY_ARRAY;
	}
	
	/**
	 * Creates a new empty array map of given capacity.
	 *
	 * @param capacity the initial capacity.
	 */
	public Int2IntArrayMapOSS(final int capacity) {
		this.key = new int[capacity];
		this.value = new int[capacity];
	}
	
	/**
	 * Creates a new empty array map copying the entries of a given map.
	 *
	 * @param m a map.
	 */
	public Int2IntArrayMapOSS(final Int2IntMap m) {
		this(m.size());
		putAll(m);
	}
	
	/**
	 * Creates a new empty array map copying the entries of a given map.
	 *
	 * @param m a map.
	 */
	public Int2IntArrayMapOSS(final Map<? extends Integer, ? extends Integer> m) {
		this(m.size());
		putAll(m);
	}
	
	/**
	 * Creates a new array map with given key and value backing arrays, using the given number of elements.
	 * <p>
	 * <p>It is responsibility of the caller that the first <code>size</code> elements of <code>key</code> are distinct.
	 *
	 * @param key   the key array.
	 * @param value the value array (it <em>must</em> have the same length as <code>key</code>).
	 * @param size  the number of valid elements in <code>key</code> and <code>value</code>.
	 */
	public Int2IntArrayMapOSS(final int[] key, final int[] value, final int size) {
		this.key = key;
		this.value = value;
		this.size = size;
		if (key.length != value.length)
			throw new IllegalArgumentException("Keys and values have different lengths (" + key.length + ", " + value.length + ")");
		if (size > key.length)
			throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the backing-arrays size (" + key.length + ")");
	}
	
	private final class EntrySet extends AbstractObjectSet<Entry> implements FastEntrySet {
		@Override
		public ObjectIterator<Entry> iterator() {
			return new AbstractObjectIterator<Entry>() {
				int curr = -1, next = 0;
				
				@Override
				public boolean hasNext() {
					return next < size;
				}
				
				@Override
				
				public Entry next() {
					if (!hasNext()) throw new NoSuchElementException();
					return new BasicEntry(key[curr = next], value[next++]);
				}
				
				@Override
				public void remove() {
					if (curr == -1) throw new IllegalStateException();
					curr = -1;
					final int tail = size-- - next--;
					System.arraycopy(key, next + 1, key, next, tail);
					System.arraycopy(value, next + 1, value, next, tail);
				}
			};
		}
		
		@Override
		public ObjectIterator<Entry> fastIterator() {
			return /*new AbstractObjectIterator<Int2IntMap.Entry>() {
				int next = 0, curr = -1;
				final BasicEntry entry = new BasicEntry((0), (0));
				
				@Override
				public boolean hasNext() {
					return next < size;
				}
				
				@Override
				
				public Entry next() {
					if (!hasNext()) throw new NoSuchElementException();
					entry.key = key[curr = next];
					entry.value = value[next++];
					return entry;
				}
				
				@Override
				public void remove() {
					if (curr == -1) throw new IllegalStateException();
					curr = -1;
					final int tail = size-- - next--;
					System.arraycopy(key, next + 1, key, next, tail);
					System.arraycopy(value, next + 1, value, next, tail);
				}
			};*/ null;
		}
		
		@Override
		public int size() {
			return size;
		}
		
		@Override
		
		public boolean contains(Object o) {
			if (!(o instanceof Map.Entry)) return false;
			final Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
			if (e.getKey() == null || !(e.getKey() instanceof Integer)) return false;
			if (e.getValue() == null || !(e.getValue() instanceof Integer)) return false;
			final int k = ((((Integer) (e.getKey())).intValue()));
			return Int2IntArrayMapOSS.this.containsKey(k) && ((Int2IntArrayMapOSS.this.get(k)) == (((((Integer) (e.getValue())).intValue()))));
		}
		
		@Override
		
		public boolean remove(final Object o) {
			if (!(o instanceof Map.Entry)) return false;
			final Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
			if (e.getKey() == null || !(e.getKey() instanceof Integer)) return false;
			if (e.getValue() == null || !(e.getValue() instanceof Integer)) return false;
			final int k = ((((Integer) (e.getKey())).intValue()));
			final int v = ((((Integer) (e.getValue())).intValue()));
			final int oldPos = Int2IntArrayMapOSS.this.findKey(k);
			if (oldPos == -1 || !((v) == (Int2IntArrayMapOSS.this.value[oldPos]))) return false;
			final int tail = size - oldPos - 1;
			System.arraycopy(Int2IntArrayMapOSS.this.key, oldPos + 1, Int2IntArrayMapOSS.this.key, oldPos, tail);
			System.arraycopy(Int2IntArrayMapOSS.this.value, oldPos + 1, Int2IntArrayMapOSS.this.value, oldPos, tail);
			Int2IntArrayMapOSS.this.size--;
			return true;
		}
	}
	
	@Override
	public FastEntrySet int2IntEntrySet() {
		return new EntrySet();
	}
	
	private int findKey(final int k) {
		final int[] key = this.key;
		for (int i = size; i-- != 0; ) if (((key[i]) == (k))) return i;
		return -1;
	}
	
	@Override
	
	public int get(final int k) {
		final int[] key = this.key;
		for (int i = size; i-- != 0; ) if (((key[i]) == (k))) return value[i];
		return defRetValue;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void clear() {
		size = 0;
	}
	
	@Override
	public boolean containsKey(final int k) {
		return findKey(k) != -1;
	}
	
	@Override
	public boolean containsValue(int v) {
		for (int i = size; i-- != 0; ) if (((value[i]) == (v))) return true;
		return false;
	}
	
	public int getKeyForValue(int v) {
		final int[] key = this.key;
		for (int i = size; i-- != 0; )
			if (((value[i]) == (v)))
				return key[i];
		return -1;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	
	public int put(int k, int v) {
		final int oldKey = findKey(k);
		if (oldKey != -1) {
			final int oldValue = value[oldKey];
			value[oldKey] = v;
			return oldValue;
		}
		if (size == key.length) {
			final int[] newKey = new int[size == 0 ? 2 : size * 2];
			final int[] newValue = new int[size == 0 ? 2 : size * 2];
			for (int i = size; i-- != 0; ) {
				newKey[i] = key[i];
				newValue[i] = value[i];
			}
			key = newKey;
			value = newValue;
		}
		key[size] = k;
		value[size] = v;
		size++;
		return defRetValue;
	}
	
	@Override
	
	public int remove(final int k) {
		final int oldPos = findKey(k);
		if (oldPos == -1) return defRetValue;
		final int oldValue = value[oldPos];
		final int tail = size - oldPos - 1;
		System.arraycopy(key, oldPos + 1, key, oldPos, tail);
		System.arraycopy(value, oldPos + 1, value, oldPos, tail);
		size--;
		return oldValue;
	}
	
	@Override
	public IntSet keySet() {
		return new IntArraySet(key, size);
	}
	
	@Override
	public IntCollection values() {
		return IntCollections.unmodifiable(new IntArraySet(value, size));
	}
	
	/**
	 * Returns a deep copy of this map.
	 * <p>
	 * <P>This method performs a deep copy of this hash map; the data stored in the
	 * map, however, is not cloned. Note that this makes a difference only for object keys.
	 *
	 * @return a deep copy of this map.
	 */
	@Override
	
	public Int2IntArrayMapOSS clone() {
		Int2IntArrayMapOSS c;
		try {
			c = (Int2IntArrayMapOSS) super.clone();
		} catch (CloneNotSupportedException cantHappen) {
			throw new InternalError();
		}
		c.key = key.clone();
		c.value = value.clone();
		return c;
	}
	
	private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
		s.defaultWriteObject();
		for (int i = 0; i < size; i++) {
			s.writeInt(key[i]);
			s.writeInt(value[i]);
		}
	}
	
	private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();
		key = new int[size];
		value = new int[size];
		for (int i = 0; i < size; i++) {
			key[i] = s.readInt();
			value[i] = s.readInt();
		}
	}
}
