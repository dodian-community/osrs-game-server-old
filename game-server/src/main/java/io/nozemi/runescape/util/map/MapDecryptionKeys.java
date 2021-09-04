package io.nozemi.runescape.util.map;

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
	
	public static void main(String[] args) throws IOException {
		/*boolean loadFromApi = args.length > 0 && args[0].equals("--update");
		logger.warn("Packing map decryption keys into one file...");
		DataStore ds = new DataStore("data/filestore");

		if (loadFromApi) {
			logger.info("Updating from RuneLite API is enabled - missing keys will be downloaded.");
		}
		
		// Convert osbot to normal if needed
		boolean convertOsbot = false;
		if (convertOsbot) {
			for (int x = 0; x < 256; x++) {
				for (int z = 0; z < 256; z++) {
					int translated = ds.getIndex(5).getDescriptor().getArchiveID("l" + x + "_" + z);
					if (translated != -1) {
						int region = (x << 8) | z;
						try {
							Files.copy(new File("temp_osbot/" + translated + ".txt").toPath(), new File("temp/" + region + ".txt").toPath());
						} catch (Exception ignored) {
						}
					}
				}
			}
		}
		
		File dir = new File("temp");
		Map<Integer, int[]> keys = new HashMap<>();
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data/map/keys.bin"));

		for (File f : dir.listFiles()) {
			if (f.getName().endsWith(".txt")) {
				String[] key_s = new String(Files.readAllBytes(f.toPath())).split("\n");

				int[] key = new int[4];
				for (int i = 0; i < 4; i++) {
					key[i] = Integer.parseInt(key_s[i].trim());
				}

				keys.put(Integer.parseInt(f.getName().substring(0, f.getName().length() - 4)), key);
			}
		}

		ApiKeyResponse[] keysLocal = new Gson().fromJson(new FileReader("xteas.json"), ApiKeyResponse[].class);
		for (ApiKeyResponse keyu : keysLocal) {
			keys.put(keyu.region, keyu.keys);
		}
		logger.info("Loaded {} local xtea keys.", keysLocal.length);

		// Find missing keys
		loadFromApi = false;
		if (loadFromApi) {
			Map<Integer, int[]> missingKeys = new HashMap<>();

			for (int x = 0; x < 255; x++) {
				for (int y = 0; y < 255; y++) {
					// Resolve ID based on X, Y
					int archiveId = ds.getIndex(5).getDescriptor().getArchiveID("l" + x + "_" + y);
					if (archiveId < 1) {
						continue;
					}

					missingKeys.put((x << 8) | y, new int[4]);
				}
			}

			keys.forEach((k, v) -> {
				try {
					// Resolve ID based on X, Y
					int archiveId = ds.getIndex(5).getDescriptor().getArchiveID("l" + (k >> 8) + "_" + (k & 0xFF));
					if (archiveId < 1) {
						return;
					}

					// Grab container data with keys
					Container c = ds.getIndex(5).getContainer(archiveId, v);
					if (c == null) {
						return;
					}

					c.getFileData(0); // Trigger error if wrong
				} catch (Exception e) {
					// Assumed we can't do the ding tong
					missingKeys.put(k, v);
				}
			});

			logger.info("Missing: {}. Attempting to resolve from API...", missingKeys.size());

			ExecutorService fjp = Executors.newWorkStealingPool(16);
			final Gson gson = new Gson();

			CountDownLatch latch = new CountDownLatch(missingKeys.size());

			missingKeys.forEach((k, v) -> {
				fjp.submit(() -> {
					String data = "";

					try {
						URL u = new URL("http://api.runelite.net/runelite-1.4.7.1/xtea/" + k);
						HttpURLConnection urlConnection = (HttpURLConnection) u.openConnection();
						urlConnection.setRequestProperty("Accept", "application/json");
						urlConnection.setRequestProperty("Accept-Language", "nl,en-US;q=0.9,en;q=0.8,sv;q=0.7,da;q=0.6");
						urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

						data = IOUtils.toString(urlConnection.getInputStream(), "UTF-8");

						// Sensible minimum length to avoid parsing broken response data.
						if (data.length() > 5) {
							ApiKeyResponse keyData = gson.fromJson(data, ApiKeyResponse.class);
							keys.put(keyData.region, keyData.keys);
							logger.info("Grabbed key {}. Key requests remaining: {}.", k, latch.getCount());
						}
					} catch (Exception e) {
						logger.info("Could not grab key {}. Key requests remaining: {}. Ex: {}.", k, latch.getCount(), e.getClass().getSimpleName() + ": " + e.getMessage());
						// That's my name.
					}

					latch.countDown();
				});
			});

			// Wait until all keys are obtained (or have failed)..
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

/*		keys.forEach((k, v) -> {
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(new FileOutputStream("data/test/" + k + ".txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 4; i++) {
				writer.println(v[i]);
			}
			writer.close();
		});*/

		// Encode key data into the binary
		/*keys.forEach((k, v) -> {
			try {
				dos.writeShort((short) (int) k);
				for (int i = 0; i < 4; i++) {
					dos.writeInt(v[i]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});


		Files.copy(Paths.get("data/map/keys.bin"), Paths.get("data/map/keys2.bin"), StandardCopyOption.REPLACE_EXISTING);
		
		logger.warn("Finished packing a total of {} map decryption keys.", keys.size());*/
	}

	static class ApiKeyResponse {
		public int region;
		public int[] keys;
	}
	
}
