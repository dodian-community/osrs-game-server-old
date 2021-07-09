package io.nozemi.runescape.fs;

import io.nozemi.runescape.io.RSBuffer;

/**
 * Created by Jonathan on 6/14/2017.
 */
public class AnimationSkin {
	
	public int id;
	public int[][] affected_vertex_skins;
	public int frame_count;
	public int[] mesh_transformation_types;
	public boolean[] aBoolArray10025;
	public int[] anIntArray10026;
	
	AnimationSkin(int id_, byte[] data) {
		id = id_;
		RSBuffer buffer = new RSBuffer(data);
		frame_count = buffer.readUShort();
		mesh_transformation_types = new int[frame_count];
		affected_vertex_skins = new int[frame_count][];
		aBoolArray10025 = new boolean[frame_count];
		anIntArray10026 = new int[frame_count];
		for (int i_0_ = 0; i_0_ < frame_count; i_0_++) {
			mesh_transformation_types[i_0_] = buffer.readUByte();
			if (mesh_transformation_types[i_0_] == 6)
				mesh_transformation_types[i_0_] = 2;
		}
		for (int i_1_ = 0; i_1_ < frame_count; i_1_++)
			aBoolArray10025[i_1_] = buffer.readUByte() == 1;
		for (int i_2_ = 0; i_2_ < frame_count; i_2_++)
			anIntArray10026[i_2_] = buffer.readUShort();
		for (int frame = 0; frame < frame_count; frame++)
			affected_vertex_skins[frame] = new int[buffer.readCompact()];
		for (int frame = 0; frame < frame_count; frame++) {
			for (int affected = 0; affected < affected_vertex_skins[frame].length; affected++)
				affected_vertex_skins[frame][affected] = buffer.readCompact();
		}
	}
}
