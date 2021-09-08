package net.dodian.runescape.fs;

/**
 * Created by Jonathan on 6/14/2017.
 */
public class AnimationSkeleton {
	public AnimationSkin skin = null;
	public int stepCount = -1;
	public boolean hasAlpha = false;
	public int[] opCodeTable;
	public int[] translator_x;
	public int[] translator_y;
	public int[] translator_z;
	
	private AnimationSkeleton() {
		// Don't allow public constructor from outside this class
		// Use Jak SkeleSet Decoder class statics
	}
	
	public static AnimationSkeleton plain() {
		return new AnimationSkeleton();
	}
}
