package net.dodian.runescape.util.map;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class MapDecryptionKeys {
	
	private static Int2ObjectArrayMap<int[]> keys = new Int2ObjectArrayMap<>();
	private static final Logger logger = LogManager.getLogger(MapDecryptionKeys.class);
	
	public static void load(File from) throws IOException {
		if (!from.exists()) {
			logger.warn("Map decryption key file does not exist. Decryption keys will be sent as zeroes.");
			return;
		}
		
		ByteBuffer buffer = ByteBuffer.wrap(Files.readAllBytes(from.toPath()));
		while (buffer.remaining() > 0) {
			int map = buffer.getShort() & 0xFFFF;
			int[] k = new int[4];
			for (int i = 0; i < 4; i++)
				k[i] = buffer.getInt();
			keys.put(map, k);
		}
		
		logger.info("Loaded {} map decryption key sets.", keys.size());
	}
	
	public static int[] get(int region) {
		if (keys.containsKey(region)) {
			return keys.get(region);
		}
		int x = (region >> 8) << 6;
		int y = (region & 0xFF) << 6;
		logger.warn("Missing map decryption keys for map region {} located at {}, {}", region, x, y);
		keys.put(region, new int[4]);
		return new int[4];
	}

	static class ApiKeyResponse {
		public int region;
		public int[] keys;
	}
	
}
