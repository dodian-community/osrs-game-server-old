package io.nozemi.runescape.task;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.EntityList;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.NpcSyncInfo;
import io.nozemi.runescape.model.entity.player.PlayerSyncInfo;
import io.nozemi.runescape.net.message.game.command.UpdatePlayers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class NpcSyncTask implements Task {
	
	private static final Logger logger = LogManager.getLogger(NpcSyncTask.class);
	
	static class Job extends SubTask {
		
		/**
		 * Preallocated integer array to avoid continuous reallocation.
		 */
		private int[] rebuilt = new int[2048];
		private Player[] players;
		private Set<Integer> transmogged = new HashSet<>(32);
		private Set<Integer> withCustomCombatLevel = new HashSet<>(32);

		public Job(World world, Player... players) {
			super(world);
			this.players = players;
		}
		
		@Override
		public void execute() {
			for (Player player : players) {
				try {
					if (!player.bot())
						sync(player);
				} catch (Exception e) {
					logger.error("Error processing NPC sync for {}.", player, e);
				}
			}
		}
		
		private void sync(Player player) {
			transmogged.clear();
			withCustomCombatLevel.clear();

			boolean largeViewport = player.world().allocator().active(player.tile()).isPresent() && player.world().allocator().active(player.tile()).get().largeViewPort();
			
			RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(512));
			buffer.packet(largeViewport ? 8 : 33).writeSize(RSBuffer.SizeType.SHORT);
			
			buffer.startBitMode();
			encodeSurroundings(player, buffer, largeViewport);
			encodeMissing(player, buffer, largeViewport);//add new
			buffer.endBitMode();
			
			// Update other masks
			PlayerSyncInfo sync = player.sync();
			int max = sync.npcUpdateReqPtr();
			for (int i = 0; i < max; i++) {
				Npc npc = player.world().npcs().get(sync.npcUpdateRequests()[i]);
				
				if (npc == null) {
					buffer.writeByte(0);
					continue;
				}
				
				boolean newAdd = sync.isNewlyAddedNpc(npc.index());
				NpcSyncInfo npcSync = npc.sync();
				
				int mask = npcSync.calculatedFlag();
				if (transmogged.contains(npc.index()))
					mask |= NpcSyncInfo.Flag.TRANSMOG.value;
				if (withCustomCombatLevel.contains(npc.index()))
					mask |= NpcSyncInfo.Flag.COMBAT_LEVEL.value;
				
				// Possible forced values for newly added local Npcs
				int forceEntity = -1;
				Tile forceTile = null;
				
				// Newly added entities can have some masks for pre-existing masks we were unable to see when set
				// Because they were out of our viewport
				if (newAdd) {
					if (npcSync.FORCE_FACE_ID != -1) { // We're still facing
						int pid = npcSync.FORCE_FACE_ID;
						mask |= NpcSyncInfo.Flag.FACE_ENTITY.value;
						forceEntity = pid;
						// If they're facing an entity but that entity is out of view, resolve it to a coordinate
						if (pid > 32768) {
							if (!sync.hasInView(pid - 32768)) {
								Player targ = player.world().players().get(pid - 32768);
								if (targ != null)
									npcSync.FORCE_TILE = new Tile(targ.tile().x * 2 + 1, targ.tile().z * 2 + 1);
							}
						} else if (!sync.hasNpcInView(pid)) {
							Npc targNpc = player.world().npcs().get(pid);
							if (targNpc != null)
								npcSync.FORCE_TILE = new Tile(targNpc.tile().x * 2 + 1, targNpc.tile().z * 2 + 1);
						}
						
					}
					if (npcSync.FORCE_TILE != null) { // We're still facing
						mask |= NpcSyncInfo.Flag.FACE_TILE.value;
						forceTile = npcSync.FORCE_TILE;
					}
				}
				
				buffer.writeByte(mask);

				if (npcSync.hasFlag(NpcSyncInfo.Flag.GRAPHIC.value))
					buffer.writeBytes(npcSync.graphicSet());

				if (forceTile != null) {
					buffer.writeShort(forceTile.x);
					buffer.writeShortA(forceTile.z);
				} else if (npcSync.hasFlag(NpcSyncInfo.Flag.FACE_TILE.value))
					buffer.writeBytes(npcSync.faceTileSet());

				if (npcSync.hasFlag(NpcSyncInfo.Flag.HIT.value))
					buffer.writeBytes(npcSync.hitSet());

				if (npcSync.hasFlag(NpcSyncInfo.Flag.TRANSMOG.value) || transmogged.contains(npc.index()))
					buffer.writeShortA(npcSync.transmog() <= 0 ? npc.id() : npcSync.transmog());
				
				if (forceEntity != -1)
					buffer.writeLEShort(forceEntity);
				else if (npcSync.hasFlag(NpcSyncInfo.Flag.FACE_ENTITY.value))
					buffer.writeBytes(npcSync.faceEntitySet());
				
				if (npcSync.hasFlag(NpcSyncInfo.Flag.ANIMATION.value))
					buffer.writeBytes(npcSync.animationSet());

				if (npcSync.hasFlag(NpcSyncInfo.Flag.SHOUT.value))
					buffer.writeBytes(npcSync.shout());

				if (npcSync.hasFlag(NpcSyncInfo.Flag.COMBAT_LEVEL.value) || withCustomCombatLevel.contains(npc.index()))
					buffer.writeShort(npcSync.combatLevel());
			}

			player.write(new UpdatePlayers(buffer));
		}
		
		private void encodeSurroundings(Player player, RSBuffer buffer, boolean largeViewport) {
			PlayerSyncInfo playerSyncInfo = player.sync();
			int[] npcUpdateRequests = playerSyncInfo.npcUpdateRequests();
			int[] localNpcIndices = playerSyncInfo.localNpcIndices();
			buffer.writeBits(8, playerSyncInfo.localNpcPtr()); // Local npc count
			int[] rebuilt = this.rebuilt;
			int npcPointer = playerSyncInfo.npcUpdateReqPtr();
			
			int rebuiltptr = 0;
			for (int i = 0; i < playerSyncInfo.localNpcPtr(); i++) {
				int index = localNpcIndices[i];
				Npc npc = player.world().npcs().get(index);
				
				boolean visible = npc != null && player.tile().distance(npc.tile()) > (largeViewport ? 30 : 14); //I'm guessing its 30???
				
				// See if the player either logged out, or is out of our viewport
				if (npc == null || npc.hidden() || visible || player.tile().level != npc.tile().level) {
					buffer.writeBits(1, 1); // Yes, we need an update
					buffer.writeBits(2, 3); // Type 3: remove
					continue;
				}
				Player owner = npc.sync().owner; // After npc nullpointer check
				if (owner != null && owner != player && owner.looks().hidden()) {
					buffer.writeBits(1, 1); // Yes, we need an update
					buffer.writeBits(2, 3); // Type 3: remove
					continue;
				}
				
				NpcSyncInfo npcSyncInfo = npc.sync();
				boolean needsUpdate = npcSyncInfo.dirty();
				npc.inViewport(true); // Mark as in viewport
				
				if (needsUpdate) {
					buffer.writeBits(1, 1);
					
					int primaryStep = npcSyncInfo.primaryStep();
					int secondaryStep = npcSyncInfo.secondaryStep();
					boolean teleport = npcSyncInfo.teleported();
					
					if (teleport) {
						buffer.writeBits(2, 3); // Teleport (don't add to rebuilt, respawn after adding)
					} else if (primaryStep >= 0) {
						boolean run = secondaryStep >= 0;
						buffer.writeBits(2, run ? 2 : 1); // Step up your game
						
						buffer.writeBits(3, primaryStep);
						if (run)
							buffer.writeBits(3, secondaryStep);
						
						buffer.writeBits(1, npcSyncInfo.calculatedFlag() != 0 ? 1 : 0);
						
						rebuilt[rebuiltptr++] = index;
						if (npcSyncInfo.calculatedFlag() != 0) {
							npcUpdateRequests[npcPointer++] = npc.index();
						}
					} else {
						buffer.writeBits(2, 0); // No movement
						rebuilt[rebuiltptr++] = index;
						
						npcUpdateRequests[npcPointer++] = npc.index();
					}
				} else {
					buffer.writeBits(1, 0); // No updates at all
					rebuilt[rebuiltptr++] = index;
				}
			}
			
			System.arraycopy(rebuilt, 0, localNpcIndices, 0, rebuiltptr);
			playerSyncInfo.localNpcPtr(rebuiltptr);
			playerSyncInfo.npcUpdateReqPtr(npcPointer);
		}
		
		private void encodeMissing(Player player, RSBuffer buffer, boolean largeViewport) {
			PlayerSyncInfo playerSync = player.sync();
			int[] ln = playerSync.localNpcIndices();
			int lnp = playerSync.localNpcPtr();
			
			EntityList<Npc> npcs = player.world().npcs();
			List<Npc> entriesList = npcs.getEntriesList();
			int listSize = entriesList.size();
			boolean hideAllNpcs = player.sync().HIDE_ALL_NPCS;
			
			for (int idx = 0; idx < listSize; idx++) {
				Npc npc = entriesList.get(idx);
				
				boolean visible = npc != null && player.tile().distance(npc.tile()) > (largeViewport ? 30 : 14); //I'm guessing its 30???
				
				if (npc == null || npc.hidden() || playerSync.hasNpcInView(npc.index()) || visible || player.tile().level != npc.tile().level
						|| hideAllNpcs)
					continue;
				
				// Limit addition to 25 per cycle, and 255 local.
				if (lnp >= 254 || playerSync.newlyAddedNpcPtr >= 25) {
					break;
				}
				
				NpcSyncInfo npcSync = npc.sync();
				
				// Did this npc trigger mask updating?
				Player owner = npcSync.owner;
				// Hide pets if owner is invis
				if (owner != null && owner != player && owner.looks().hidden())
					continue;
				
				// These values are brought up to date pre-cycle.
				boolean facing = npcSync.FORCE_FACE_ID != -1 || npcSync.FORCE_TILE != null;
				
				int x = npc.tile().x - player.tile().x;
				int z = npc.tile().z - player.tile().z;
				
				if (largeViewport) {
					if (x < 127) {
						x += 256;
					}
					if (z < 127) {
						z += 256;
					}
				} else {
					if (x < 15) {
						x += 32;
					}
					
					if (z < 15) {
						z += 32;
					}
				}

				buffer.writeBits(15, npc.index());
				buffer.writeBits(largeViewport ? 8 : 5, x);
				buffer.writeBits(3, npcSync.FACE_DIR);
				buffer.writeBits(1, 1);
				buffer.writeBits(largeViewport ? 8 : 5, z);
				buffer.writeBits(14, npc.id());
				buffer.writeBits(1, (facing || npcSync.calculatedFlag() > 0 || npcSync.transmog() > 0) ? 1 : 0);
				
				ln[lnp++] = npc.index();
				playerSync.newlyAddedNpcs[playerSync.newlyAddedNpcPtr++] = npc.index();
			}
			
			// Only write the end if there's more bytes coming; otherwise the client knows it's empty.
			if (playerSync.npcUpdateReqPtr() > 0)
				buffer.writeBits(15, -1); // No more adding
			
			playerSync.localNpcPtr(lnp);
		}
	}
	
	@Override
	public void execute(World world) {
		
	}
	
	@Override
	public Collection<SubTask> createJobs(World world) {
		int numjobs = world.players().size() / 50 + 1;
		ArrayList<SubTask> tasks = new ArrayList<>(numjobs);
		List<Player> work = new ArrayList<>(5);
		
		// Create jobs which will cover 5 players per job
		world.players().forEach(p -> {
			work.add(p);
			
			if (work.size() == 50) {
				tasks.add(new Job(world, work.toArray(new Player[work.size()])));
				work.clear();
			}
		});
		
		// Remainders?
		if (!work.isEmpty()) {
			tasks.add(new Job(world, work.toArray(new Player[work.size()])));
		}
		
		return tasks;
	}
	
	@Override
	public boolean isAsyncSafe() {
		return true;
	}
	
}
