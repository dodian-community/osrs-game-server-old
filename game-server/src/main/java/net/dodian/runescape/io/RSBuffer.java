package net.dodian.runescape.io;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.dodian.runescape.util.BufferUtilities;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class RSBuffer {
	
	private ByteBuf backing;
	private int sizeIndicator = -1;
	private SizeType type;
	private int bitPosition;
	private int opcode = -1;
	private boolean finished;
	private boolean reusable;
	
	public static final int[] BIT_MASK = new int[32];
	
	public RSBuffer(byte[] backing) {
		this.backing = Unpooled.wrappedBuffer(backing);
	}
	
	public RSBuffer(ByteBuf backing) {
		this.backing = backing;
	}
	
	public ByteBuf get() {
		return backing;
	}
	
	public RSBuffer packet(int id) {
		opcode = id;
		return this;
	}
	
	public int packet() {
		return opcode;
	}
	
	public RSBuffer writeSize(SizeType type) {
		this.type = type;
		sizeIndicator = backing.writerIndex();
		
		if (type == SizeType.BYTE)
			backing.writeByte(0);
		else
			backing.writeShort(0);
		
		return this;
	}
	
	public RSBuffer writeByte(int v) {
		backing.writeByte(v);
		return this;
	}
	
	public byte readByte() {
		return backing.readByte();
	}
	
	public byte readByteN() {
		return (byte) -backing.readByte();
	}
	
	public short readUByte() {
		return backing.readUnsignedByte();
	}
	
	public byte readByteS() {
		return (byte) (128 - backing.readByte());
	}
	
	public byte readByteA() {
		return (byte) (128 + backing.readByte());
	}
	
	public short readUByteS() {
		return (short) (128 - backing.readUnsignedByte());
	}
	
	public RSBuffer writeByteA(int v) {
		backing.writeByte(v + 128);
		return this;
	}
	
	public RSBuffer writeByteS(int v) {
		backing.writeByte(128 - v);
		return this;
	}
	
	public RSBuffer writeByteN(int v) {
		backing.writeByte(-v);
		return this;
	}
	
	public RSBuffer writeShort(int v) {
		backing.writeShort(v);
		return this;
	}
	
	public RSBuffer writeLEShort(int v) {
		backing.writeByte(v);
		backing.writeByte(v >> 8);
		return this;
	}
	
	public RSBuffer writeLEShortA(int v) {
		backing.writeByte(v + 128);
		backing.writeByte(v >> 8);
		return this;
	}
	
	public RSBuffer writeShortA(int v) {
		backing.writeByte(v >> 8);
		backing.writeByte(v + 128);
		return this;
	}
	
	public RSBuffer writeTriByte(int v) {
		backing.writeByte(v >> 16);
		backing.writeByte(v >> 8);
		backing.writeByte(v);
		return this;
	}
	
	public short readShort() {
		return backing.readShort();
	}
	
	public int readUShort() {
		return backing.readUnsignedShort();
	}
	
	public int readULEShort() {
		return readUByte() | (readUByte() << 8);
	}
	
	public int readULEShortA() {
		return ((readByte() - 128) & 0xFF) | (readUByte() << 8);
	}
	
	public int readUShortA() {
		return (readUByte() << 8) | ((readByte() - 128) & 0xFF);
	}
	
	public int readTriByte() {
		return (readUByte() << 16) | (readUByte() << 8) | readUByte();
	}
	
	public RSBuffer writeLong(long v) {
		backing.writeLong(v);
		return this;
	}
	
	public RSBuffer writeInt(int v) {
		backing.writeInt(v);
		return this;
	}
	
	public RSBuffer writeLEInt(int v) {
		backing.writeByte(v);
		backing.writeByte(v >> 8);
		backing.writeByte(v >> 16);
		backing.writeByte(v >> 24);
		return this;
	}
	
	public RSBuffer writeIntV1(int v) {
		backing.writeByte(v >> 8);
		backing.writeByte(v);
		backing.writeByte(v >> 24);
		backing.writeByte(v >> 16);
		return this;
	}
	
	public RSBuffer writeIntV2(int v) {
		backing.writeByte(v >> 16);
		backing.writeByte(v >> 24);
		backing.writeByte(v);
		backing.writeByte(v >> 8);
		return this;
	}
	
	public int readInt() {
		return backing.readInt();
	}
	
	public int readLEInt() {
		return readUByte() | (readUByte() << 8) | (readUByte() << 16) | (readUByte() << 24);
	}
	
	public int readIntV1() {
		return (readUByte() << 8) | readUByte() | (readUByte() << 24) | (readUByte() << 16);
	}
	
	public int readIntV2() {
		return (readUByte() << 16) | (readUByte() << 24) | readUByte() | (readUByte() << 8);
	}
	
	public RSBuffer writeCompact(int v) {
		if (v >= 0x80) {
			writeShort(v + 0x8000);
		} else {
			writeByte(v);
		}
		return this;
	}
	
	public RSBuffer writeSignedCompact(int v) {
		if (v >= -64 && v <= 63) {
			backing.writeByte(v + 64);
		} else if (v >= -16384 && v <= 16383) {
			backing.writeShort(0x8000 | (v + 16384));
		} else {
			throw new RuntimeException("invalid value " + v);
		}
		return this;
	}
	
	public int readSignedCompact() {
		int current = backing.getByte(backing.readerIndex()) & 0xFF;
		if (current < 0x80) {
			return readUByte() - 0x40;
		} else {
			return readUShort() - 0xC000;
		}
	}
	
	public int readCompact() {
		int current = backing.getByte(backing.readerIndex()) & 0xFF;
		if (current < 0x80) {
			return readUByte();
		} else {
			return readUShort() - 0x8000;
		}
	}
	
	public RSBuffer writeString(String str) {
		if (str == null)
			str = "";
		
		backing.writeBytes(str.getBytes()).writeByte(0);
		return this;
	}
	
	public String readString() {
		return BufferUtilities.readString(backing);
	}
	
	public void startBitMode() {
		bitPosition = backing.writerIndex() * 8;
	}
	
	public void endBitMode() {
		backing.writerIndex((bitPosition + 7) / 8);
	}
	
	public int bitpos(int i) {
		return 8 * i - bitPosition;
	}
	
	public void writeBits(int numBits, int value) {
		int bytePos = bitPosition >> 3;
		int bitOffset = 8 - (bitPosition & 7);
		bitPosition += numBits;
		for (; numBits > bitOffset; bitOffset = 8) {
			backing.writerIndex(bytePos);
			backing.ensureWritable(1);
			
			backing.setByte(bytePos, backing.getByte(bytePos) & ~BIT_MASK[bitOffset]);
			backing.setByte(bytePos, backing.getByte(bytePos) | (value >> numBits - bitOffset & BIT_MASK[bitOffset]));
			
			backing.writerIndex(bytePos);
			backing.ensureWritable(1);
			backing.writerIndex(bytePos++);
			
			numBits -= bitOffset;
		}
		
		backing.writerIndex(bytePos);
		backing.ensureWritable(1);
		
		// checkCapacityPosition(bytePos);
		if (numBits == bitOffset) {
			backing.setByte(bytePos, backing.getByte(bytePos) & ~BIT_MASK[bitOffset]);
			backing.setByte(bytePos, backing.getByte(bytePos) | (value & BIT_MASK[bitOffset]));
		} else {
			backing.setByte(bytePos, backing.getByte(bytePos) & ~(BIT_MASK[numBits] << bitOffset - numBits));
			backing.setByte(bytePos, backing.getByte(bytePos) | ((value & BIT_MASK[numBits]) << bitOffset - numBits));
		}
	}
	
	static {
		for (int i = 0; i < 32; i++) {
			BIT_MASK[i] = (1 << i) - 1;
		}
	}
	
	public RSBuffer finish() {
		if (!finished && type != null) {
			if (type == SizeType.BYTE) {
				backing.setByte(sizeIndicator, backing.writerIndex() - sizeIndicator - 1);
			} else {
				backing.setShort(sizeIndicator, backing.writerIndex() - sizeIndicator - 2);
			}
			finished = true;
		}
		
		return this;
	}
	
	public void skip(int size) {
		backing.skipBytes(size);
	}
	
	public void writeBytes(byte[] bytes) {
		backing.writeBytes(bytes);
	}
	
	public boolean reusable() {
		return reusable;
	}
	
	public void reusable(boolean reusable) {
		this.reusable = reusable;
	}
	
	public static enum SizeType {
		BYTE, SHORT
	}
	
}
