package net.dodian.runescape.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jonathan on 3/25/2017.
 * <p>
 * https://en.wikipedia.org/wiki/Permutation
 */
public class PermutedSequence {
	
	private final Random random = new Random();
	private final int size;
	private final int length;
	private int m;
	private int a;
	private int mask;
	private int v;
	
	public PermutedSequence(int size) {
		this.size = size;
		length = 1 << ((int) Math.ceil(Math.log(size) / Math.log(2)));
		setLength(length);
	}
	
	public void setLength(int length) {
		mask = length - 1;
		reset();
	}
	
	public int size() {
		return size;
	}
	
	public void reset() {
		m = (random.nextInt() << 3) | 5;
		a = (random.nextInt() << 1) | 1;
		v = (random.nextInt());
	}
	
	public int getNextIndex() {
		do {
			v = (m * v + a) & mask;
		} while (v >= size);
		return v;
	}
	
}