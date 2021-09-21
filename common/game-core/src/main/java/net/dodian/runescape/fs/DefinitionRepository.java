package net.dodian.runescape.fs;

import com.typesafe.config.Config;
import net.dodian.runescape.handlers.Handler;
import net.dodian.runescape.handlers.impl.ConfigHandler;
import net.dodian.runescape.handlers.impl.DataHandler;
import net.dodian.runescape.util.map.MapDecryptionKeys;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import nl.bartpelle.dawnguard.DataStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Bart on 7/11/2015.
 */
@Component
public class DefinitionRepository {
	
	private static final Logger logger = LogManager.getLogger(DefinitionRepository.class);
	
	private Object2ObjectArrayMap<Class<? extends Definition>, Definition[]> definitionMaps = new Object2ObjectArrayMap<>();
	private DataStore store;

	@Autowired
	public DefinitionRepository(ConfigHandler configHandler, DataHandler dataHandler) {
		logger.info("Loading definition repository...");

		// TODO: Potentially won't work?
		//if(GameInitializer.handlers() == null) {
		//	GameInitializer.prepareHandlers(handlers);
		//}

		//DataHandler dataHandler = GameInitializer.handler(DataHandler.class)
		//		.orElseThrow(() -> new RuntimeException("Failed to get DataHandler"));

		//ConfigHandler configHandler = GameInitializer.handler(ConfigHandler.class)
		//		.orElseThrow(() -> new RuntimeException("Failed to get ConfigHandler"));

		configHandler.initialize();
		dataHandler.initialize();

		Config config = configHandler.config();

		store = dataHandler.dataStore();

		if(store == null) {
			throw new RuntimeException("Failed to get DataStore for server...");
		}

		boolean lazy = config.hasPath("definitions.lazy") && config.getBoolean("definitions.lazy");
		
		load(store, lazy);
	}
	
	public void load(DataStore store, boolean lazy) {
		// Load items
		int numItems = store.getIndex(2).getDescriptor().getLastFileId(10);
		ItemDefinition[] items = new ItemDefinition[numItems];
		definitionMaps.put(ItemDefinition.class, items);
		
		if (!lazy) {
			for (int id = 0; id < numItems; id++) {
				items[id] = loadDefinition(ItemDefinition.class, id);
			}
		}
		
		// Load npcs
		int numNpcs = store.getIndex(2).getDescriptor().getLastFileId(9);
		NpcDefinition[] npcs = new NpcDefinition[numNpcs];
		definitionMaps.put(NpcDefinition.class, npcs);
		
		if (!lazy) {
			for (int id = 0; id < numNpcs; id++) {
				npcs[id] = loadDefinition(NpcDefinition.class, id);
			}
		}
		
		// Load objects
		int numObjects = store.getIndex(2).getDescriptor().getLastFileId(6);
		ObjectDefinition[] objects = new ObjectDefinition[numObjects];
		definitionMaps.put(ObjectDefinition.class, objects);
		
		if (!lazy) {
			for (int id = 0; id < numObjects; id++) {
				objects[id] = loadDefinition(ObjectDefinition.class, id);
			}
		}
		
		// Load maps
		int maxMaps = 256 * 256;
		MapDefinition[] maps = new MapDefinition[maxMaps];
		definitionMaps.put(MapDefinition.class, maps);
		
		// This definition is a bit... hacky. It's to avoid recursive dependencies.
		if (!lazy) {
			for (int x = 0; x < 256; x++) {
				for (int z = 0; z < 256; z++) {
					int region = (x << 8) | z;
					
					try {
						int mapId = store.getIndex(5).getDescriptor().getArchiveID("m" + x + "_" + z);
						int landscapeId = store.getIndex(5).getDescriptor().getArchiveID("l" + x + "_" + z);
						if (mapId >= 0 && landscapeId >= 0) {
							maps[region] = new MapDefinition(x, z);
						}
					} catch (Exception ignored) {
						ignored.printStackTrace();
					}
				}
			}
			
			for (int x = 0; x < 256; x++) {
				for (int z = 0; z < 256; z++) {
					int region = (x << 8) | z;
					
					try {
						loadDefinition(MapDefinition.class, region);
					} catch (Exception ignored) {
						if (ignored.getMessage() == null || !ignored.getMessage().contains("Error while parsing archive header"))
							ignored.printStackTrace();
					}
				}
			}
		}
		
		// Load varbits
		int numVarbits = store.getIndex(2).getDescriptor().getLastFileId(14);
		VarbitDefinition[] varbits = new VarbitDefinition[numVarbits];
		definitionMaps.put(VarbitDefinition.class, varbits);
		
		if (!lazy) {
			for (int id = 0; id < numVarbits; id++) {
				varbits[id] = loadDefinition(VarbitDefinition.class, id);
			}
		}
		
		// Load enums
		int numEnums = store.getIndex(2).getDescriptor().getLastFileId(8);
		EnumDefinition[] enums = new EnumDefinition[numEnums];
		definitionMaps.put(EnumDefinition.class, enums);
		
		if (!lazy) {
			for (int id = 0; id < numEnums; id++) {
				enums[id] = loadDefinition(EnumDefinition.class, id);
			}
		}
		
		int spotAnimCount = store.getIndex(2).getDescriptor().getLastFileId(13);
		
		logger.info("Loaded {} item definitions.", numItems);
		logger.info("Loaded {} npc definitions.", numNpcs);
		logger.info("Loaded {} object definitions.", numObjects);
		logger.info("Loaded {} varbit definitions.", numVarbits);
		logger.info("Loaded {} enum definitions.", numEnums);
		logger.info("Loaded {} spotanim definitions.", spotAnimCount);
	}
	
	private <T extends Definition> T loadDefinition(Class<T> type, int id, boolean create) {
		if (type == ItemDefinition.class) {
			return (T) new ItemDefinition(id, store.getIndex(2).getContainer(10).getFileData(id, true, true));
		} else if (type == VarbitDefinition.class) {
			return (T) new VarbitDefinition(id, store.getIndex(2).getContainer(14).getFileData(id, true, true));
		} else if (type == EnumDefinition.class) {
			return (T) new EnumDefinition(id, store.getIndex(2).getContainer(8).getFileData(id, true, true));
		} else if (type == AnimationDefinition.class) {
			return (T) new AnimationDefinition(id, store.getIndex(2).getContainer(12).getFileData(id, true, true));
		} else if (type == NpcDefinition.class) {
			return (T) new NpcDefinition(id, store.getIndex(2).getContainer(9).getFileData(id, true, true));
		} else if (type == ObjectDefinition.class) {
			return (T) new ObjectDefinition(id, store.getIndex(2).getContainer(6).getFileData(id, true, true));
		} else if (type == MapDefinition.class) {
			int x = id >> 8;
			int z = id & 0xFF;
			int mapId = store.getIndex(5).getDescriptor().getArchiveID("m" + x + "_" + z);
			int landscapeId = store.getIndex(5).getDescriptor().getArchiveID("l" + x + "_" + z);
			
			MapDefinition[] arr = (MapDefinition[]) definitionMaps.get(type);
			
			if (landscapeId != -1 && mapId != -1 && store.getIndex(5).getDescriptor().archiveExists(landscapeId) && store.getIndex(5).getDescriptor().archiveExists(mapId)) {
				try {
					byte[] map = store.getFileDirect(5, mapId, 0);
					byte[] decrypted = store.getEncryptedFileDirect(5, landscapeId, 0, MapDecryptionKeys.get(id));
					
					if (arr[id] == null)
						arr[id] = new MapDefinition(x, z);
					
					arr[id].load(this, map, decrypted, false);
				} catch (Exception e) {
					//logger.error("Could not load map {} {}!", id, landscapeId, e);
				}
				
				return (T) arr[id];
			} else {
				// New empty map, used mainly when instancing.
				if (create) {
					arr[id] = new MapDefinition(x, z);
				}
				
				return (T) arr[id];
			}
		} else if (type == VarpDefinition.class) {
			return (T) new VarpDefinition(id, store.getIndex(2).getContainer(16).getFileData(id, true, true));
		} else if (type == SpotanimDefinition.class) {
			return (T) new SpotanimDefinition(id, store.getIndex(2).getContainer(13).getFileData(id, true, true));
		}
		
		return null;
	}
	
	private <T extends Definition> T loadDefinition(Class<T> type, int id) {
		return loadDefinition(type, id, false);
	}
	
	public <T extends Definition> T get(Class<T> type, int id) {
		return get(type, id, false);
	}
	
	public <T extends Definition> T get(Class<T> type, int id, boolean create) {
		T[] arr = (T[]) definitionMaps.get(type);
		
		if (id < 0 || id >= arr.length)
			return null;
		
		if (arr[id] == null) {
			return arr[id] = (T) loadDefinition(type, id, create);
		}
		
		return ((T[]) definitionMaps.get(type))[id];
	}
	
	public void unset(Class<? extends Definition> type, int id) {
		Object[] arr = (Object[]) definitionMaps.get(type);
		arr[id] = null;
	}
	
	public int total(Class<? extends Definition> type) {
		return definitionMaps.get(type).length;
	}
	
}
