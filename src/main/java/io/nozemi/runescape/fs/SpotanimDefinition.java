package io.nozemi.runescape.fs;

import io.netty.buffer.Unpooled;
import io.nozemi.runescape.io.RSBuffer;

/**
 * Created by Jak on 12/12/2016.
 */
public class SpotanimDefinition implements Definition {
	
	int id;
	public int animationID = 1140458533;
	int resizeX = 711925632;
	int resizeY = 446051968;
	int rotation = 0;
	int ambient = 0;
	int contrast = 0;
	int modelID;
	short[] recolorToFind;
	short[] recolorToReplace;
	short[] retextureToFind;
	short[] retextureToReplace;
	
	public SpotanimDefinition(int id, byte[] data) {
		this.id = id;
		
		if (data != null && data.length > 0)
			decode(new RSBuffer(Unpooled.wrappedBuffer(data)));
	}
	
	private void decode(RSBuffer rsBuffer) {
		while (true) {
			int opcode = rsBuffer.readUByte();
			if (opcode == 0) {
				return;
			}
			decodeReadValues(rsBuffer, opcode);
		}
	}
	
	private void decodeReadValues(RSBuffer buffer, int opcode) {
		if (opcode == 1) {
			modelID = buffer.readUShort();
		} else if (opcode == 2) {
			animationID = buffer.readUShort();
		} else if (opcode == 4) {
			resizeX = buffer.readUShort();
		} else if (opcode == 5) {
			resizeY = buffer.readUShort();
		} else if (opcode == 6) {
			rotation = buffer.readUShort();
		} else if (opcode == 7) {
			ambient = buffer.readUByte();
		} else if (opcode == 8) {
			contrast = buffer.readUByte();
		} else {
			int index;
			int length;
			if (opcode == 40) {
				length = buffer.readUByte();
				recolorToFind = new short[length];
				recolorToReplace = new short[length];
				
				for (index = 0; index < length; index++) {
					recolorToFind[index] = (short) buffer.readUShort();
					recolorToReplace[index] = (short) buffer.readUShort();
				}
			} else if (opcode == 41) {
				length = buffer.readUByte();
				retextureToFind = new short[length];
				retextureToReplace = new short[length];
				
				for (index = 0; index < length; index++) {
					retextureToFind[index] = (short) buffer.readUShort();
					retextureToReplace[index] = (short) buffer.readUShort();
				}
			}
		}
		
	}
}
