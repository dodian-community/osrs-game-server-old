package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.instance.InstancedMap;
import net.dodian.runescape.net.message.game.Command;
import net.dodian.runescape.util.map.MapDecryptionKeys;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bart Pelle on 3/28/2016.
 */
public class DisplayInstancedMap extends Command { // Aka dipsleemap
	
	private int x;
	private int z;
	private int localX;
	private int localZ;
	private int level;
	private int[][] xteaKeys;
	private InstancedMap map;
	private boolean gameInit;
	
	public DisplayInstancedMap(InstancedMap map, Player player) {
		this(map, player, player.tile(), true, false);
	}
	
	public DisplayInstancedMap(InstancedMap map, Player player, Tile tile, boolean setActive, boolean gameInit) {
		this.gameInit = gameInit;
		this.map = map;
		
		int x = tile.x;
		int z = tile.z;
		
		int base_x = x / 8;
		int base_z = z / 8;
		
		int botleft_x = (base_x - 6) * 8;
		int botleft_z = (base_z - 6) * 8;
		
		this.x = base_x;
		this.z = base_z;
		this.localX = x - botleft_x;
		this.localZ = z - botleft_z;
		level = tile.level;
		
		// Update last map
		if (setActive) {
			player.activeMap(new Tile(botleft_x, botleft_z, player.tile().level));
		}
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buf = new RSBuffer(player.channel().alloc().buffer(12 + 4 * 4 * 9));
		
		buf.packet(81).writeSize(RSBuffer.SizeType.SHORT);
		
		if (gameInit) {
			player.updateRemoteLocation();
			
			buf.startBitMode();
			buf.writeBits(30, player.tile().hash30());
			
			for (int i = 1; i < 2048; i++) { // i=2 cause we skip our own info
				if (i == player.index()) continue;
				
				Player at = player.world().players().get(i);
				if (at == null) buf.writeBits(18, 0);
				else {
					buf.writeBits(18, at.tile().hash18());
					player.sync().lastRegionHashes()[i] = at.tile().hash18();
				}
			}
			
			buf.endBitMode();
		}

		buf.writeLEShort(x);
		buf.writeLEShort(z);
		buf.writeByte(0); // ? not level since boolean

		int mapCountPos = buf.get().writerIndex();
		buf.writeShort(2); // mapcount

		buf.startBitMode();
		int[][][] built = map.buildForMessage(player);
		for (int i = 0; i < 4; i++) {
			for (int x = 0; x < 13; x++) {
				for (int z = 0; z < 13; z++) {
					int val = built[i][x][z];
					
					if (val < 1) {
						buf.writeBits(1, 0);
					} else {
						buf.writeBits(1, 1);
						buf.writeBits(26, val);
					}
				}
			}
		}
		buf.endBitMode();
		
		List<Integer> keysSent = new LinkedList<>();
		
		for (int level = 0; level < 4; level++) {
			for (int x = 0; x < 13; x++) {
				for (int z = 0; z < 13; z++) {
					int copyHash = built[level][x][z];
					
					if (copyHash != -1) {
						int baseX = copyHash >> 14 & 0x3ff;
						int baseZ = copyHash >> 3 & 0x7ff;
						int region = baseZ / 8 + (baseX / 8 << 8);
						
						// Has this map already been loaded?
						if (keysSent.contains(region)) {
							region = -1;
						}
						
						if (region > 0) {
							keysSent.add(region);
							
							int[] keys = MapDecryptionKeys.get(region);
							if (keys != null) {
								for (int key : keys)
									buf.writeInt(key);
							} else {
								for (int i = 0; i < 4; i++)
									buf.writeInt(0);
							}
						}
					}
				}
			}
		}
		
		buf.get().setShort(mapCountPos, keysSent.size());
		return buf;
	}
}
