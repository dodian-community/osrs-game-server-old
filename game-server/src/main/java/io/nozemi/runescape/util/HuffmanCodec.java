package io.nozemi.runescape.util;

import nl.bartpelle.dawnguard.DataStore;

public final class HuffmanCodec {
	
	private int[] masks;
	private byte[] sizes;
	private int[] keys;
	
	public HuffmanCodec(DataStore store) {
		this(store.getIndex(10).getContainerByName("huffman").getFileData(0, true, true));
	}
	
	public HuffmanCodec(byte[] sizes) {
		int numcodewords = sizes.length;
		int[] is_13_ = new int[33];
		masks = new int[numcodewords];
		this.sizes = sizes;
		int i_14_ = 0;
		keys = new int[8];
		
		for (int pos = 0; numcodewords > pos; pos++) {
			byte size = sizes[pos];
			
			if (size != 0) {
				int i_17_ = 1 << 32 - size;
				int mask = is_13_[size];
				masks[pos] = mask;
				
				int i_19_;
				if ((i_17_ & mask) != 0) {
					i_19_ = is_13_[size - 1];
				} else {
					for (int idx_ = size - 1; ~idx_ <= -2; --idx_) {
						int idk = is_13_[idx_];
						if (~idk != ~mask) {
							break;
						}
						
						int i_26_ = 1 << 32 + -idx_;
						if ((idk & i_26_) != 0) {
							is_13_[idx_] = is_13_[-1 + idx_];
							break;
						}
						
						is_13_[idx_] = i_26_ | idk;
					}
					
					i_19_ = mask | i_17_;
				}
				
				is_13_[size] = i_19_;
				
				for (int idx_ = size + 1; 32 >= idx_; idx_++) {
					if (mask == is_13_[idx_]) {
						is_13_[idx_] = i_19_;
					}
				}
				
				int idx = 0;
				
				for (int shift = 0; shift < size; shift++) {
					int i_26_ = 0x80000000 >>> shift;
					if ((i_26_ & mask) == 0) {
						idx++;
					} else {
						if (keys[idx] == 0) {
							keys[idx] = i_14_;
						}
						
						idx = keys[idx];
					}
					
					if (keys.length <= idx) {
						int[] realloc = new int[keys.length * 2];
						System.arraycopy(keys, 0, realloc, 0, keys.length);
						keys = realloc;
					}
				}
				
				keys[idx] = ~pos;
				if (idx >= i_14_) {
					i_14_ = idx + 1;
				}
			}
		}
		
	}
	
	public int decode(byte[] input, byte[] output, int i, int i_1_, int len) {
		if (len == 0) {
			return 0;
		} else {
			int idx = 0;
			len += i;
			
			int i_6_ = i_1_;
			
			while (true) {
				byte i_7_ = input[i_6_];
				if (i_7_ < 0) {
					idx = keys[idx];
				} else {
					++idx;
				}
				
				int i_8_;
				if (~(i_8_ = keys[idx]) > -1) {
					output[i++] = (byte) (~i_8_);
					if (len <= i) {
						break;
					}
					
					idx = 0;
				}
				
				if (~(64 & i_7_) != -1) {
					idx = keys[idx];
				} else {
					++idx;
				}
				
				if (0 > (i_8_ = keys[idx])) {
					output[i++] = (byte) (~i_8_);
					if (len <= i) {
						break;
					}
					
					idx = 0;
				}
				
				if (0 == (i_7_ & 32)) {
					++idx;
				} else {
					idx = keys[idx];
				}
				
				if (0 > (i_8_ = keys[idx])) {
					output[i++] = (byte) (~i_8_);
					if (~len >= ~i) {
						break;
					}
					
					idx = 0;
				}
				
				if (0 != (i_7_ & 16)) {
					idx = keys[idx];
				} else {
					++idx;
				}
				
				if (-1 < ~(i_8_ = keys[idx])) {
					output[i++] = (byte) (~i_8_);
					if (~len >= ~i) {
						break;
					}
					
					idx = 0;
				}
				
				if (0 == (i_7_ & 8)) {
					++idx;
				} else {
					idx = keys[idx];
				}
				
				if (0 > (i_8_ = keys[idx])) {
					output[i++] = (byte) (~i_8_);
					if (len <= i) {
						break;
					}
					
					idx = 0;
				}
				
				if (~(i_7_ & 4) == -1) {
					++idx;
				} else {
					idx = keys[idx];
				}
				
				if ((i_8_ = keys[idx]) < 0) {
					output[i++] = (byte) (~i_8_);
					if (~i <= ~len) {
						break;
					}
					
					idx = 0;
				}
				
				if (~(i_7_ & 2) == -1) {
					++idx;
				} else {
					idx = keys[idx];
				}
				
				if (~(i_8_ = keys[idx]) > -1) {
					output[i++] = (byte) (~i_8_);
					if (len <= i) {
						break;
					}
					
					idx = 0;
				}
				
				if (0 != (i_7_ & 1)) {
					idx = keys[idx];
				} else {
					++idx;
				}
				
				if (0 > (i_8_ = keys[idx])) {
					output[i++] = (byte) (~i_8_);
					if (~len >= ~i) {
						break;
					}
					
					idx = 0;
				}
				
				++i_6_;
			}
			
			return 1 + i_6_ - i_1_;
		}
	}
	
	public int encode(String text, byte[] output) {
		int key = 0;
		
		byte[] input = text.getBytes();
		int bitpos = 0;
		for (int pos = 0; pos < text.length(); pos++) {
			int data = input[pos] & 255;
			byte size = sizes[data];
			int mask = masks[data];
			
			if (size == 0) {
				throw new RuntimeException("No codeword for data value " + data);
			}
			
			int remainder = bitpos & 7;
			key &= -remainder >> 31;
			int offset = bitpos >> 3;
			bitpos += size;
			int i_41_ = (-1 + (remainder - -size) >> 3) + offset;
			remainder += 24;
			output[offset] = (byte) (key |= mask >>> remainder);
			if (~i_41_ < ~offset) {
				remainder -= 8;
				output[++offset] = (byte) (key = mask >>> remainder);
				if (~offset > ~i_41_) {
					remainder -= 8;
					output[++offset] = (byte) (key = mask >>> remainder);
					if (~offset > ~i_41_) {
						remainder -= 8;
						output[++offset] = (byte) (key = mask >>> remainder);
						if (i_41_ > offset) {
							remainder -= 8;
							output[++offset] = (byte) (key = mask << -remainder);
						}
					}
				}
			}
		}
		
		return 7 + bitpos >> 3;
	}
	
}