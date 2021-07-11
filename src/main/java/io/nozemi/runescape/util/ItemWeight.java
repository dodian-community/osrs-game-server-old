package io.nozemi.runescape.util;

import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.net.message.game.command.SetWeight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Situations on 12/31/2015.
 */
public class ItemWeight {
	
	private static final Logger logger = LogManager.getLogger(ItemWeight.class);
	public static final transient int MAX_SIZE = 13352;
	private static final int[] WEIGHT_REDUCERS = {};
	private static Map<Integer, Double> itemWeight = new HashMap<>();
	
	private static Map<Integer, Double> equipweightOverrides = new HashMap<Integer, Double>() {{
		put(11850, -3.0); // Graceful hood
		put(11852, -4.0); // Graceful cape
		put(11854, -5.0); // Graceful top
		put(11856, -6.0); // Graceful legs
		put(11858, -3.0); // Graceful gloves
		put(11860, -4.0); // Graceful boots
	}};
	
	public static void init() {
		itemWeight.clear();
		
		try (BufferedReader reader = new BufferedReader(new FileReader("./data/list/item_weight.txt"))) {
			while (true) {
				String file = reader.readLine();
				if (file == null || file.trim().startsWith("//")) {
					break;
				}
				
				String[] values = file.split(":");
				itemWeight.put(Integer.valueOf(values[0]), Double.parseDouble(values[1]));
			}
			
			logger.info("Loaded " + itemWeight.size() + " item weights.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static double calculateWeight(Player player) {
		double weight = 0;
		
		for (Item item : player.inventory()) {
			if (item != null) {
				weight += getWeight(item.id());
			}
		}
		
		for (Item item : player.equipment()) {
			if (item != null) {
				if (equipweightOverrides.containsKey(item.id())) {
					weight += equipweightOverrides.get(item.id());
				} else {
					weight += getWeight(item.id());
				}
			}
		}
		
		player.setWeight(weight);
		player.write(new SetWeight(weight));
		return weight;
	}
	
	private static double getWeight(int itemId) {
		return itemWeight.getOrDefault(itemId, 0.0);
	}
	
}
