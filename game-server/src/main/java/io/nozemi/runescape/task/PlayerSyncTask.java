package io.nozemi.runescape.task;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.Area;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.PlayerSyncInfo;
import io.nozemi.runescape.model.instance.InstancedMap;
import io.nozemi.runescape.net.message.game.Command;
import io.nozemi.runescape.net.message.game.command.DisplayInstancedMap;
import io.nozemi.runescape.net.message.game.command.DisplayMap;
import io.nozemi.runescape.net.message.game.command.UpdatePlayers;
import io.nozemi.runescape.util.Varp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class PlayerSyncTask implements Task {
	
	private static final Logger logger = LogManager.getLogger(PlayerSyncTask.class);
	
	static class Job extends SubTask {
		
		/**
		 * Preallocated integer array to avoid continuous reallocation.
		 */
		private int[] playerIndicesNeedingMaskUpdate = new int[2048];
		private int maskRequestCount = 0;
		private Player[] players;
		private Set<Integer> newlyAdded = new HashSet<>();
		
		public Job(World world, Player... players) {
			super(world);
			this.players = players;
		}
		
		@Override
		public void execute() {
			for (Player player : players)
				sync(player);
		}
		
		private void sync(Player player) {
			player.sync().init();
			
			RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(513));
			buffer.packet(56).writeSize(RSBuffer.SizeType.SHORT);
			
			processLocal(buffer, player, false);
			processLocal(buffer, player, true);
			
			processRemote(buffer, player, false);
			processRemote(buffer, player, true);
			
			int visiblePlayerCount = 0;
			int invisiblePlayerCount = 0;
			
			// Now reset counts and whatnot
			byte[] playerFlags = player.sync().playerFlags();
			short[] visiblePlayerIndices = player.sync().visiblePlayerIndices();
			short[] invisiblePlayerIndices = player.sync().invisiblePlayerIndices();
			
			for (int idx = 1; idx < 2048; idx++) {
				// Shift the cycle queue
				playerFlags[idx] >>= 1;
				
				// And set the visible indices and invisible indices accordingly
				Player p = player.world().players().get(idx);
				if (p == player || (p != null && canView(player, p))) {
					visiblePlayerIndices[++visiblePlayerCount - 1] = (short) idx;
				} else
					invisiblePlayerIndices[++invisiblePlayerCount - 1] = (short) idx;
			}
			
			for (int masky = 0; masky < maskRequestCount; masky++) {
				int index = playerIndicesNeedingMaskUpdate[masky];
				Player p = player.world().players().get(index);
				int mask = p.sync().calculatedFlag();
				
				if (newlyAdded.contains(p.index()))
					mask |= PlayerSyncInfo.Flag.LOOKS.value;

				// Surpress their message, if its not us.
				if (p.sync().hasFlag(PlayerSyncInfo.Flag.CHAT.value) && p.sync().publicChatDampered && p != player) {
					mask &= ~PlayerSyncInfo.Flag.CHAT.value;
					//System.out.println(String.format("%s not rendering msg of %s as dampered", player.name(), p.name()));
				}
				
				if (mask >> 8 != 0) {
					mask |= 0x80;
				}
				
				buffer.writeByte(mask);
				
				if (mask >> 8 != 0) {
					buffer.writeByte(mask >> 8);
				}

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.TELEPORT_MODE.value))
					buffer.writeByteS(p.sync().teleportMode());

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.SHOUT.value))
					buffer.get().writeBytes(p.sync().shout());

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.GRAPHIC.value))
					buffer.get().writeBytes(p.sync().graphicSet());

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.PREFIX_NAME_SUFFIX.value))
					buffer.get().writeBytes(p.sync().tripleStrings());

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.ANIMATION.value))
					buffer.get().writeBytes(p.sync().animationSet());

				if ((mask & PlayerSyncInfo.Flag.CHAT.value) != 0) {
					boolean hasCensoredBlock = player.varps().varp(Varp.PROFANITY) == 0 && p.sync().censoredPubChatMessageBlock() != null;
					buffer.get().writeBytes(hasCensoredBlock ? p.sync().censoredPubChatMessageBlock() : p.sync().chatMessageBlock());
				}

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.MOVEMENT_MODE.value))
					buffer.writeByteS(p.sync().movementMode());

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.HIT.value))
					buffer.get().writeBytes(p.sync().hitSet());

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.FORCE_MOVE.value))
					p.sync().forceMove(player, buffer);

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.FACE_ENTITY.value))
					buffer.get().writeBytes(p.sync().faceEntitySet());

				if (p.sync().hasFlag(PlayerSyncInfo.Flag.LOOKS.value) || newlyAdded.contains(p.index())) {
					buffer.get().writeBytes(p.sync().looksBlock());
				}
				
				if (p.sync().hasFlag(PlayerSyncInfo.Flag.FACE_TILE.value))
					buffer.get().writeShort(p.remoteLocation().angleTo(p.sync().facedTile()));
			}
			
			player.sync().visiblePlayerCount(visiblePlayerCount);
			player.sync().invisiblePlayerCount(invisiblePlayerCount);
			
			// Change mask request amount back to zero
			maskRequestCount = 0;
			newlyAdded.clear();
			
			Command mapPacket = null;
			if (player.activeMap() == null) {
				player.putattrib(AttributeKey.PREVIOUS_MAP, null);
				Optional<InstancedMap> activeMap = player.world().allocator().active(player.tile());
				mapPacket = activeMap.<Command>map(instancedMap -> (new DisplayInstancedMap(instancedMap, player))).orElseGet(() -> (new DisplayMap(player, false)));
				player.putattrib(AttributeKey.REGION_CHANGING, true);
			} else {
				Area prev = player.activeArea();
				int mapx = player.activeMap().x;
				int mapz = player.activeMap().z;
				int dx = player.tile().x - mapx;
				int dz = player.tile().z - mapz;
				
				if (dx < 16 || dz < 16 || dx >= 88 || dz >= 88) { // should this be 15 & 87 ?
					player.putattrib(AttributeKey.PREVIOUS_MAP, prev);
					Optional<InstancedMap> activeMap = player.world().allocator().active(player.tile());
					mapPacket = activeMap.<Command>map(instancedMap -> (new DisplayInstancedMap(instancedMap, player))).orElseGet(() -> (new DisplayMap(player, false)));
					player.putattrib(AttributeKey.REGION_CHANGING, true);
				}
				
				if (player.activeMap().level != player.tile().level) { // Our height changed.
					player.putattrib(AttributeKey.HEIGHT_CHANGING, true);
					player.world().syncDespawnOldHeight(player, player.activeArea());
					// NOTE: do NOT re-sync in the _pre-update_ when the h-level has changed. Do it _post_ update
				}
			}
			
			// And finally, write the packet
			if (mapPacket == null) {
				player.write(new UpdatePlayers(buffer));
			} else {
				player.write(mapPacket, new UpdatePlayers(buffer));
				/*RSBuffer mapEncoded = mapPacket.write(player);
				RSBuffer playerUpdateData = buffer.finish();
				mapEncoded.get().writeByte(56).writeBytes(playerUpdateData.get());
				player.write(new UpdatePlayers(mapEncoded));*/
			}
		}
		
		private void processLocal(RSBuffer buffer, Player player, boolean secondPass) {
			buffer.startBitMode();
			int skips = 0;
			
			byte[] playerFlags = player.sync().playerFlags();
			short[] visiblePlayerIndices = player.sync().visiblePlayerIndices();
			int visiblePlayerCount = player.sync().visiblePlayerCount();
			
			for (int counter = 0; counter < visiblePlayerCount; counter++) {
				int playerIndex = visiblePlayerIndices[counter];
				
				Player p = player.world().players().get(playerIndex);
				
				if (secondPass ? (playerFlags[playerIndex] & 0x1) != 0 : (playerFlags[playerIndex] & 0x1) == 0) {
					if (skips > 0) {
						skips--;
						playerFlags[playerIndex] |= 0x2;
					} else {
						boolean needsUpdate = p == null || !canView(player, p) || (p.sync().dirty() || newlyAdded.contains(playerIndex));
						
						if (!needsUpdate) {
							buffer.writeBits(1, 0);
							skips = calculateSkipCount(player, visiblePlayerIndices, counter + 1, visiblePlayerCount, !secondPass, false);
							
							writeSkips(buffer, skips);
							playerFlags[playerIndex] |= 0x2;
						} else {
							buffer.writeBits(1, 1);
							
							if (p == null || !canView(player, p)) {
								buffer.writeBits(1, 0);
								buffer.writeBits(2, 0);
								buffer.writeBits(1, 0); // We noes first change the position before nulling out ;)
							} else {
								encodeInfo(buffer, player, p);
							}
						}
					}
				}
			}
			buffer.endBitMode();
			
			if (skips != 0) {
				System.err.println("SKIPS IS NOT 0: " + skips);
			}
		}
		
		private void processRemote(RSBuffer buffer, Player player, boolean secondPass) {
			int skips = 0;
			buffer.startBitMode();
			
			byte[] playerFlags = player.sync().playerFlags();
			short[] invisiblePlayerIndices = player.sync().invisiblePlayerIndices();
			
			for (int counter = 0; counter < player.sync().invisiblePlayerCount(); counter++) {
				int playerIndex = invisiblePlayerIndices[counter];
				Player p = player.world().players().get(playerIndex);
				
				if (secondPass ? (playerFlags[playerIndex] & 0x1) == 0 : (playerFlags[playerIndex] & 0x1) != 0) {
					if (skips > 0) {
						skips--;
						playerFlags[playerIndex] |= 0x2;
					} else {
						boolean updateRequired = canView(player, p);//(p != null && p.needsUpdating());
						
						buffer.writeBits(1, updateRequired ? 1 : 0);
						if (!updateRequired) {
							skips = calculateSkipCount(player, invisiblePlayerIndices, counter + 1, player.sync().invisiblePlayerCount(), secondPass, true);
							
							writeSkips(buffer, skips);
							playerFlags[playerIndex] |= 0x2;
						} else if (encodeOutsideInfo(buffer, player, p)) {
							playerFlags[playerIndex] |= 0x2;
						}
					}
				}
			}
			
			buffer.endBitMode();
		}
		
		private void encodeInfo(RSBuffer packet, Player player, Player p) {
			if (p.sync().dirty()) {
				playerIndicesNeedingMaskUpdate[maskRequestCount++] = p.index();
			}
			
			packet.writeBits(1, p.sync().dirty() ? 1 : 0);
			
			Tile currentPos = p.tile();
			Tile remote = p.remoteLocation();
			int primaryStep = p.sync().primaryStep();
			int secondaryStep = p.sync().secondaryStep();
			
			if (secondaryStep != -1) {
				packet.writeBits(2, 2);
				packet.writeBits(4, secondaryStep);
			} else if (primaryStep != -1) {
				packet.writeBits(2, 1);
				packet.writeBits(3, primaryStep);
			} else if (!remote.equals(currentPos) || p.sync().teleported() || ((boolean) player.attribOr(AttributeKey.REGION_CHANGING, false))) {
				packet.writeBits(2, 3);
				int dx = currentPos.x - remote.x;
				int dy = currentPos.z - remote.z;
				int dh = currentPos.level - remote.level;
				
				int absdx = Math.abs(dx);
				int absdy = Math.abs(dy);
				
				if (dh < 0) {
					dh = 4 + dh;
				}
				
				boolean outOfRegion = (absdx > 15 || absdy > 15);
				packet.writeBits(1, outOfRegion ? 1 : 0); // Out of region teleport
				if (outOfRegion) {
					int diffhash = (dh & 0x3) << 28;
					diffhash |= (dx & 0x3FFF) << 14;
					diffhash |= dy & 0x3FFF;
					
					packet.writeBits(30, diffhash);
				} else {
					int diffhash = 0;
					
					if (dx < 15) {
						dx += 32;
					}
					if (dy < 15) {
						dy += 32;
					}
					
					diffhash |= (dh) << 10;
					diffhash |= (dx & 31) << 5;
					diffhash |= (dy & 31);
					
					packet.writeBits(12, diffhash);
				}
			} else {
				packet.writeBits(2, 0);
			}
			
			player.sync().lastRegionHashes()[p.index()] = p.tile().hash18();
		}
		
		private int calculateSkipCount(Player player, short[] indices, int start, int amt, boolean checkZero, boolean outside) {
			int skips = 0;
			
			byte[] playerFlags = player.sync().playerFlags();
			for (int counter = start; counter < amt; counter++) {
				int playerIndex = indices[counter];
				Player p = player.world().players().get(playerIndex);
				
				if ((checkZero && (playerFlags[playerIndex] & 0x1) == 0) || (!checkZero && (playerFlags[playerIndex] & 0x1) != 0)) {
					//boolean needsUpdate = p == null || !canView(player, p) || (p.needsUpdating() || indicesNewlyAdded.contains(playerIndex));
					if (outside) {
						if ((p != null && p.sync().dirty()) || canView(player, p)) {
							return skips;
						}
					} else {
						if (p == null || (p.sync().dirty()) || !canView(player, p)) {
							return skips;
						}
					}
					skips++;
				}
			}
			return skips;
		}
		
		private boolean encodeOutsideInfo(RSBuffer packet, Player player, Player p) {
			if (p == null) {
				packet.writeBits(2, 0);
			} else {
				if (canView(player, p)) {
					packet.writeBits(2, 0); /* Signal addition */
					
					if (p.tile().hash18() == player.sync().lastRegionHashes()[p.index()]) {
						packet.writeBits(1, 0); /* We are still in the same region. No change needed regarding regions. */
					} else {
						packet.writeBits(1, 1); /* We have lost region equality! */
						updateLocation(packet, player.sync().lastRegionHashes()[p.index()], p.tile().hash18());
					}
					
					packet.writeBits(13, p.tile().x & 0x1fff); /* Region-local X position */
					packet.writeBits(13, p.tile().z & 0x1fff); /* Region-local Y position */
					packet.writeBits(1, 1); /* Signal for mask updating */
					
					playerIndicesNeedingMaskUpdate[maskRequestCount++] = p.index();
					newlyAdded.add(p.index());
					player.sync().lastRegionHashes()[p.index()] = p.tile().hash18();
					return true;
				} else {
					packet.writeBits(2, 1);
					
					player.sync().lastRegionHashes()[p.index()] = p.tile().hash18();
				}
			}
			return false; // whether we added a new player or not
		}
		
		private void updateLocation(RSBuffer buffer, int previous, int current) {
			int prevRY = previous & 0xFF;
			int prevRX = previous >> 8;
			int prevH = previous >> 16;
			
			int curRY = current & 0xFF;
			int curRX = current >> 8;
			int curH = current >> 16;
			
			int dh = curH - prevH;
			int dx = curRX - prevRX;
			int dy = curRY - prevRY;
			
			if (prevRX == curRX && prevRY == curRY) {
				buffer.writeBits(2, 1);
				buffer.writeBits(2, dh);
			} else if (Math.abs(curRX - prevRX) <= 1 && Math.abs(curRY - prevRY) <= 1) {
				int opcode;
				if (dx == -1 && dy == -1)
					opcode = 0;
				else if (dx == 1 && dy == -1)
					opcode = 2;
				else if (dx == -1 && dy == 1)
					opcode = 5;
				else if (dx == 1 && dy == 1)
					opcode = 7;
				else if (dy == -1)
					opcode = 1;
				else if (dx == -1)
					opcode = 3;
				else if (dx == 1)
					opcode = 4;
				else
					opcode = 6;
				buffer.writeBits(2, 2);
				buffer.writeBits(5, (dh << 3) + (opcode & 0x7));
			} else {
				buffer.writeBits(2, 3);
				buffer.writeBits(18, (dh << 16) | ((dx & 0xFF) << 8) | (dy & 0xFF));
			}
		}
		
		private static void writeSkips(RSBuffer packet, int skips) {
			if (skips == 0) {
				packet.writeBits(2, 0);
			} else if (skips < 32) {
				packet.writeBits(2, 1);
				packet.writeBits(5, skips);
			} else if (skips < 256) {
				packet.writeBits(2, 2);
				packet.writeBits(8, skips);
			} else {
				packet.writeBits(2, 3);
				packet.writeBits(11, skips);
			}
		}
		
		private static boolean canView(Player eyes, Player shiny) {
			if (eyes == shiny) return true;
			if (eyes == null || shiny == null || shiny.finished() || eyes.finished())
				return false;
			
			if (eyes.tile().level != shiny.tile().level || shiny.looks().hidden())
				return false;
			
			int dx = Math.abs(eyes.tile().x - shiny.tile().x);
			int dy = Math.abs(eyes.tile().z - shiny.tile().z);
			
			return dx < 15 && dy < 15;
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
