package io.nozemi.runescape.util;

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
	
	public static void main(String[] args) {
		//System.out.println(TimerKey.values().length);
		LinkedList<String> blah2 = new LinkedList<>();
		blah2.add("1");
		blah2.add("2");
		blah2.add("3");
		blah2.add("4");
		for (int i = 0; i < blah2.size(); i++) {
			String h = blah2.get(i);
			if (h.equals("3")) {
				blah2.remove(i);
				i--;
				continue;
			}
			System.out.println(h);
		}
		List<Integer> blah = new ArrayList<>();
		blah.add(1);
		blah.add(2);
		blah.add(3);
		blah.add(4);
		
		PermutedSequence p = new PermutedSequence(blah.size());
		
		System.out.println(p.getNextIndex());
		System.out.println(p.getNextIndex());
		System.out.println(p.getNextIndex());
		System.out.println(p.getNextIndex());
		System.out.println();
		System.out.println(p.getNextIndex());
		System.out.println(p.getNextIndex());
		System.out.println(p.getNextIndex());
		System.out.println(p.getNextIndex());
		System.out.println();
		System.out.println(p.getNextIndex());
		System.out.println(p.getNextIndex());
		System.out.println(p.getNextIndex());
		System.out.println(p.getNextIndex());
	}
	
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