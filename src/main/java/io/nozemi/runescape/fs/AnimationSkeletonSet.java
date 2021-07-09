package io.nozemi.runescape.fs;

import nl.bartpelle.dawnguard.DataStore;
import io.nozemi.runescape.io.RSBuffer;

import java.util.HashMap;

/**
 * Created by Jonathan on 6/14/2017.
 */
public class AnimationSkeletonSet {
	
	byte[][] skeletonFileBytes;
	int id;
	public AnimationSkeleton[] animationSkeletons;
	public HashMap<Integer, AnimationSkin> loadedSkins;
	private static HashMap<Integer, AnimationSkeletonSet> cache = new HashMap<>();
	
	static int highest(int[] table) {
		int h = 0;
		for (int i : table)
			if (i > h)
				h = i;
		return h;
	}
	
	public static AnimationSkeletonSet get(DataStore store, int i) {
		if (cache.containsKey(i))
			return cache.get(i);
		AnimationSkeletonSet skeleton = new AnimationSkeletonSet(store, i);
		cache.put(i, skeleton);
		return skeleton;
	}
	
	public AnimationSkeletonSet(DataStore store, int i) {
		id = i;
		
		skeletonFileBytes = new byte[store.getIndex(0).getDescriptor().getLastFileId(id)][];
		int ii = 0;
		for (int idx : store.getIndex(0).getDescriptor().getFileIdTable(id)) {
			try {
				skeletonFileBytes[ii++] = store.getIndex(0).getContainer(id).getFileData(idx);
			} catch (Exception e) {
			}
		}
		
		loadedSkins = new HashMap<>();
		
		animationSkeletons = new AnimationSkeleton[store.getIndex(0).getDescriptor().getLastFileId(id)];
		
		ii = 0;
		for (int pidx : store.getIndex(0).getDescriptor().getFileIdTable(id)) {
			byte[] skel = skeletonFileBytes[ii++];
			if (skel == null)
				continue;
			
			RSBuffer skeletonBuffer = new RSBuffer(skel);
			skeletonBuffer.get().readerIndex(1);
			int id = skeletonBuffer.readUShort();
			
			// See if we need to load the skin
			AnimationSkin animSkin = null;
			if (loadedSkins.containsKey(id)) {
				animSkin = loadedSkins.get(id);
			}
			
			// Load the skin and add it to the table of already loaded skins
			if (animSkin == null) {
				animSkin = new AnimationSkin(id, store.getIndex(1).getContainer(id).getFileData(0));
				loadedSkins.put(id, animSkin);
			}
			
			//animationSkeletons[pidx] = new AnimationSkeleton(skel, animSkin);
		}
		
		skeletonFileBytes = null;
	}
	
}
