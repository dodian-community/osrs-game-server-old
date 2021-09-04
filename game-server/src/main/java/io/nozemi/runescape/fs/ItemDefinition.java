package io.nozemi.runescape.fs;

import io.netty.buffer.Unpooled;
import io.nozemi.runescape.io.RSBuffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bart Pelle on 10/4/2014.
 */
public class ItemDefinition implements Definition {
	
	public int resizey;
	public int xan2d;
	public int cost = 1;
	public int inventoryModel;
	public int resizez;
	public short[] recol_s;
	public short[] recol_d;
	public String name = "null";
	public int zoom2d = 2000;
	public int yan2d;
	public int zan2d;
	public int yof2d;
	private boolean stackable;
	public int[] countco;
	public boolean members = false;
	public String[] options = new String[5];
	public String[] ioptions = new String[5];
	public int maleModel0;
	public int maleModel1;
	public short[] retex_s;
	public short[] retex_d;
	public int femaleModel1;
	public int maleModel2;
	public int xof2d;
	public int manhead;
	public int manhead2;
	public int womanhead;
	public int womanhead2;
	public int[] countobj;
	public int femaleModel2;
	public int notelink;
	public int femaleModel0;
	public int resizex;
	public int noteModel;
	public int ambient;
	public int contrast;
	public int team;
	public boolean grandexchange;
	public boolean unprotectable;
	public boolean dummyitem;
	public int placeheld = -1;
	public int pheld14401 = -1;
	public int shiftClickDropType = -1;
	private int op139 = -1;
	private int op140 = -1;
	
	public int id;
	
	public ItemDefinition(int id, byte[] data) {
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

		//Bounty hunter emblem hardcoding.
		if (id == 12746 || (id >= 12748 && id <= 12756)) {
			unprotectable = true;
		} else if (id == 13190 || id == 13191 || id == 5020) { // Credit bonds
            if (id == 5020) name = "Vote ticket";

			stackable = true;
		} else if (id == 13189) { // Deadman pass
			stackable = false;
		} else if (id == 20997) { // Twisted bow make it cost 30m for now
			cost = 30_000_000;
		} else if (id == 13652) { // Dragon claws make it cost 30m for now
			cost = 30_000_000;
		} else if (id == 11836) { // fuck bandos boots
			cost = 100_000;
		} else if (id == 19566) {
            name = "Skotizo's key";
        }

		postDecode(id);
	}
	
	void decode(RSBuffer buffer, int code) {
		if (code == 1) {
			inventoryModel = buffer.readUShort();
		} else if (code == 2) {
			name = buffer.readString();
		} else if (code == 4) {
			zoom2d = buffer.readUShort();
		} else if (code == 5) {
			xan2d = buffer.readUShort();
		} else if (code == 6) {
			yan2d = buffer.readUShort();
		} else if (code == 7) {
			xof2d = buffer.readUShort();
			if (xof2d > 0x7FFF) {
				xof2d -= 0x10000;
			}
		} else if (code == 8) {
			yof2d = buffer.readUShort();
			if (yof2d > 0x7FFF) {
				yof2d -= 0x10000;
			}
		} else if (code == 11) {
			stackable = true;
		} else if (code == 12) {
			cost = buffer.readInt();
		} else if (code == 16) {
			members = true;
		} else if (code == 23) {
			maleModel0 = buffer.readUShort();
			buffer.readByte();
		} else if (code == 24) {
			maleModel1 = buffer.readUShort();
		} else if (code == 25) {
			femaleModel0 = buffer.readUShort();
			buffer.readByte();
		} else if (code == 26) {
			femaleModel1 = buffer.readUShort();
		} else if (code >= 30 && code < 35) {
			options[code - 30] = buffer.readString();
			if (options[code - 30].equalsIgnoreCase("null")) {
				options[code - 30] = null;
			}
		} else if (code >= 35 && code < 40) {
			ioptions[code - 35] = buffer.readString();
		} else if (code == 40) {
			int num = buffer.readUByte();
			recol_s = new short[num];
			recol_d = new short[num];
			
			for (int var4 = 0; var4 < num; ++var4) {
				recol_s[var4] = (short) buffer.readUShort();
				recol_d[var4] = (short) buffer.readUShort();
			}
		} else if (code == 41) {
			int num = buffer.readUByte();
			retex_s = new short[num];
			retex_d = new short[num];
			
			for (int var4 = 0; var4 < num; ++var4) {
				retex_s[var4] = (short) buffer.readUShort();
				retex_d[var4] = (short) buffer.readUShort();
			}
		} else if (code == 42) {
			shiftClickDropType = buffer.readByte();
		} else if (code == 65) {
			grandexchange = true;
		} else if (code == 78) {
			maleModel2 = buffer.readUShort();
		} else if (code == 79) {
			femaleModel2 = buffer.readUShort();
		} else if (code == 90) {
			manhead = buffer.readUShort();
		} else if (code == 91) {
			womanhead = buffer.readUShort();
		} else if (code == 92) {
			manhead2 = buffer.readUShort();
		} else if (code == 93) {
			womanhead2 = buffer.readUShort();
		} else if (code == 95) {
			zan2d = buffer.readUShort();
		} else if (code == 96) {
			dummyitem = buffer.readByte() == 1;
		} else if (code == 97) {
			notelink = buffer.readUShort();
		} else if (code == 98) {
			noteModel = buffer.readUShort();
		} else if (code >= 100 && code < 110) {
			if (countobj == null) {
				countobj = new int[10];
				countco = new int[10];
			}
			
			countobj[code - 100] = buffer.readUShort();
			countco[code - 100] = buffer.readUShort();
		} else if (code == 110) {
			resizex = buffer.readUShort();
		} else if (code == 111) {
			resizey = buffer.readUShort();
		} else if (code == 112) {
			resizez = buffer.readUShort();
		} else if (code == 113) {
			ambient = buffer.readByte();
		} else if (code == 114) {
			contrast = buffer.readByte() * 5;
		} else if (code == 115) {
			team = buffer.readUByte();
		} else if (code == 139) {
			op139 = buffer.readShort();
		} else if (code == 140) {
			op140 = buffer.readShort();
		} else if (code == 148) {
			placeheld = buffer.readUShort();
		} else if (code == 149) {
			pheld14401 = buffer.readUShort();
		} else if (code == 249) {
			int length = buffer.readUByte();
			int index;
			if (clientScriptData == null) {
				index = method32(length);
				clientScriptData = new HashMap<>(index);
			}
			for (index = 0; index < length; index++) {
				boolean stringData = buffer.readUByte() == 1;
				int key = buffer.readTriByte();
				clientScriptData.put(key, stringData ? buffer.readString() : buffer.readInt());
			}
		} else {
			throw new RuntimeException("cannot parse item definition, missing config code: " + code);
		}
	}

	void postDecode(int id) {
		if (id == 6808) {
			name = "Scroll of Imbuement";
		}
	}
	
	public static int method32(int var0) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}
	
	public Map<Integer, Object> clientScriptData;
	
	public boolean stackable() {
		return stackable || noteModel > 0 || id == 13215;
	}
	
	public boolean noted() {
		return noteModel > 0;
	}
	
}
