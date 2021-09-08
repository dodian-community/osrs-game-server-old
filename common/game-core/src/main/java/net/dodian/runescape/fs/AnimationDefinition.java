package net.dodian.runescape.fs;

import io.netty.buffer.Unpooled;
import net.dodian.runescape.io.RSBuffer;

/**
 * Created by jonathan on 6/14/17.
 */
public class AnimationDefinition implements Definition {
	
	private int id;
	public int framestep = -1;
	public boolean oneSq = false;
	public int forcePrio = 5;
	public int leftHandItem = -1;
	public int rightHandItem = -1;
	public int maxSound = 99;
	public int walkResets = -1;
	public int priority = -1;
	public int delayType = 2;
	public int[] delays;
	int[] flowdata;
	public int[] skeletonSets;
	int[] frame2Ids;
	public int[] sounds;
	
	public AnimationDefinition(int id, byte[] data) {
		this.id = id;
		
		if (data != null && data.length > 0)
			decode(new RSBuffer(Unpooled.wrappedBuffer(data)));
	}
	
	void decode(RSBuffer buffer) {
		while (true) {
			int op = buffer.readUByte();
			if (op == 0)
				break;
			decode(buffer, op);
		}
	}
	
	void decode(RSBuffer buffer, int opcode) {
		int count;
		int i_5;
		if (opcode == 1) {
			count = buffer.readUShort();
			this.delays = new int[count];
			
			for (i_5 = 0; i_5 < count; i_5++) {
				this.delays[i_5] = buffer.readUShort();
			}
			
			this.skeletonSets = new int[count];
			
			for (i_5 = 0; i_5 < count; i_5++) {
				this.skeletonSets[i_5] = buffer.readUShort();
			}
			
			for (i_5 = 0; i_5 < count; i_5++) {
				this.skeletonSets[i_5] += buffer.readUShort() << 16;
			}
		} else if (opcode == 2) {
			this.framestep = buffer.readUShort();
		} else if (opcode == 3) {
			count = buffer.readUByte();
			this.flowdata = new int[1 + count];
			
			for (i_5 = 0; i_5 < count; i_5++) {
				this.flowdata[i_5] = buffer.readUByte();
			}
			
			this.flowdata[count] = 9999999;
		} else if (opcode == 4) {
			this.oneSq = true;
		} else if (opcode == 5) {
			this.forcePrio = buffer.readUByte();
		} else if (opcode == 6) {
			this.leftHandItem = buffer.readUShort();
		} else if (opcode == 7) {
			this.rightHandItem = buffer.readUShort();
		} else if (opcode == 8) {
			this.maxSound = buffer.readUByte();
		} else if (opcode == 9) {
			this.walkResets = buffer.readUByte();
		} else if (opcode == 10) {
			this.priority = buffer.readUByte();
		} else if (opcode == 11) {
			this.delayType = buffer.readUByte();
		} else if (opcode == 12) {
			count = buffer.readUByte();
			this.frame2Ids = new int[count];
			
			for (i_5 = 0; i_5 < count; i_5++) {
				this.frame2Ids[i_5] = buffer.readUShort();
			}
			
			for (i_5 = 0; i_5 < count; i_5++) {
				this.frame2Ids[i_5] += buffer.readUShort() << 16;
			}
		} else if (opcode == 13) {
			count = buffer.readUByte();
			this.sounds = new int[count];
			
			for (i_5 = 0; i_5 < count; i_5++) {
				this.sounds[i_5] = buffer.readTriByte();
			}
		} else {
			throw new RuntimeException("unrecognized varbit code " + opcode);
		}
	}
	
}
