package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;
import io.nozemi.runescape.util.map.MapDecryptionKeys;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class DisplayMap extends Command { // Aka dipsleemap
	
	private int x;
	private int z;
	private boolean gameInit;
	
	public DisplayMap(Player player, boolean gameInit) {
		this(player, player.tile(), true, gameInit);
	}
	
	public DisplayMap(Player player, Tile tile, boolean setActive, boolean gameInit) {
		this.gameInit = gameInit;
		
		int x = tile.x;
		int z = tile.z;
		
		int base_x = x / 8;
		int base_z = z / 8;
		
		int botleft_x = (base_x - 6) * 8;
		int botleft_z = (base_z - 6) * 8;
		
		this.x = base_x;
		this.z = base_z;
		
		// Update last map
		if (setActive) {
			player.activeMap(new Tile(botleft_x, botleft_z, player.tile().level));
		}
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buf = new RSBuffer(player.channel().alloc().buffer(6 * (16 * 4)));
		
		buf.packet(36).writeSize(RSBuffer.SizeType.SHORT);
		
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
		
		boolean isTutIsland = false;
		if ((x / 8 == 48 || x / 8 == 49) && z / 8 == 48) {
			isTutIsland = true;
		}
		if (x / 8 == 48 && z / 8 == 148) {
			isTutIsland = true;
		}

		/* Calculate map keys needed */
		List<int[]> keys = new LinkedList<>();
		for (int rx = (x - (104 >> 4)) / 8; ((104 >> 4) + x) / 8 >= rx; rx++) {
			for (int rz = (z - (104 >> 4)) / 8; ((104 >> 4) + z) / 8 >= rz; rz++) {
				int mapid = rz + (rx << 8);
				if (!isTutIsland || rz != 49 && rz != 149 && rz != 147 && rx != 50 && (rx != 49 || rz != 47)) {
					keys.add(MapDecryptionKeys.get(mapid));
				}
			}
		}

		buf.writeShortA(x);
		buf.writeLEShortA(z);
		buf.writeShort(keys.size());
		
		for (int[] keyset : keys) {
			for (int key : keyset) {
				buf.writeInt(key);
			}
		}
		
		return buf;
	}
}
