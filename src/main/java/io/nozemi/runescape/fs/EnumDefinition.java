package io.nozemi.runescape.fs;

import io.netty.buffer.Unpooled;
import io.nozemi.runescape.io.RSBuffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bart on 7/20/15.
 */
public class EnumDefinition implements Definition {
	
	public int id;
	
	private int keytype;
	private int valuetype;
	private int defaultInt;
	private String defaultString;
	
	private Map<Integer, Object> enums = new HashMap<>();
	
	public EnumDefinition(int id, byte[] data) {
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
	
	void decode(RSBuffer buffer, int code) {
		if (code == 1) {
			keytype = buffer.readByte();
		} else if (code == 2) {
			valuetype = buffer.readByte();
		} else if (code == 3) {
			defaultString = buffer.readString();
		} else if (code == 4) {
			defaultInt = buffer.readInt();
		} else if (code == 5 || code == 6) {
			int count = buffer.readUShort();
			
			for (int i = 0; i < count; i++) {
				int key = buffer.readInt();
				
				if (code == 5) {
					enums.put(key, buffer.readString());
				} else {
					enums.put(key, buffer.readInt());
				}
			}
		} else {
			throw new RuntimeException("unrecognized enum code " + code);
		}
	}
	
	public int keyType() {
		return keytype;
	}
	
	public int valueType() {
		return valuetype;
	}
	
	public int defaultInt() {
		return defaultInt;
	}
	
	public String defaultString() {
		return defaultString;
	}
	
	public int getInt(int key) {
		return (int) enums.getOrDefault(key, defaultInt);
	}
	
	public String getString(int key) {
		return enums.getOrDefault(key, defaultString).toString();
	}
	
	public Map<Integer, Object> enums() {
		return enums;
	}
	
	@Override
	public String toString() {
		return "EnumDefinition {" +
				"\n\tid=" + id +
				",\n\tkeytype=" + keytype +
				",\n\tvaluetype=" + valuetype +
				",\n\tdefaultInt=" + defaultInt +
				",\n\tdefaultString='" + defaultString + '\'' +
				",\n\tenums = {" + formatEnumsMap() +
				"\n\t}" +
				"\n}\n";
	}
	
	private boolean formatInterfaces = false;
	
	private String formatEnumsMap() {
		StringBuilder b = new StringBuilder();
		enums.forEach((key, value) -> {
			if (formatInterfaces) {
				int id = key >> 16;
				int id2 = value instanceof Integer ? (Integer) value >> 16 : 0;
				int child = key & 0xffff;
				int child2 = value instanceof Integer ? (Integer) value & 0xffff : 0;
				
				b.append("\n\t\t").append(id + "," + child).append("=").append(id2 + "," + child2);
			} else {
				b.append("\n\t\t").append(key).append("=").append(value);
			}
		});
		return b.toString();
	}
	
	
}
