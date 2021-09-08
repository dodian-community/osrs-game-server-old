package net.dodian.runescape.model.entity.npc;

import net.dodian.runescape.model.AttributeKey;
import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.entity.Npc;
import net.dodian.runescape.model.entity.PathQueue;

/**
 * Created by Jak on 03/04/2017.
 */
public class NpcMovementSync {
	
	private static boolean[][] blockraster = new boolean[15][15];
	private static final int GRAPH_OFF = 6;
	private static final boolean CLEAR_QUEUE_IF_OBSTRUCTED = true;
	
	public static void npc_post_cycle_movement(Npc npc) {
		// Process path
		if (!npc.pathQueue().empty()) {
			// Is the path obstructed?
			if (npc.combatInfo() != null && npc.combatInfo().unstacked && isPathObstructed(npc, npc.pathQueue().peekNext())) {
				// Do we clear the queue when we hit a roadblock?
				if (CLEAR_QUEUE_IF_OBSTRUCTED) {
					npc.pathQueue().clear();
				}
				
				return;
			}
			
			PathQueue.Step walkStep = npc.pathQueue().next();
			int walkDirection = PathQueue.calculateDirectionOld(npc.tile().x, npc.tile().z, walkStep.x, walkStep.z);
			int runDirection = -1;
			npc.putattrib(AttributeKey.FACING_DIRECTION, walkDirection);
			npc.tile(new Tile(walkStep.x, walkStep.z, npc.tile().level));
			
			if ((walkStep.type == PathQueue.StepType.FORCED_RUN || npc.pathQueue().running()) && !npc.pathQueue().empty() && walkStep.type != PathQueue.StepType.FORCED_WALK) {
				PathQueue.Step runStep = npc.pathQueue().next();
				runDirection = PathQueue.calculateDirectionOld(npc.tile().x, npc.tile().z, runStep.x, runStep.z);
				npc.putattrib(AttributeKey.FACING_DIRECTION, runDirection);
				npc.tile(new Tile(walkStep.x, walkStep.z, npc.tile().level));
			}
			
			npc.sync().step(walkDirection, runDirection);
		} else {
			int currentOrDefaultFaceDir = npc.attribOr(AttributeKey.FACING_DIRECTION, -1);
			if (currentOrDefaultFaceDir == -1) { // Attrib doesn't exist yet.
				currentOrDefaultFaceDir = npc.spawnDirection();
				npc.putattrib(AttributeKey.FACING_DIRECTION, currentOrDefaultFaceDir);
			}
		}
		
		// Obtain the latest attribute values for this cycle.
		npc.sync().updateAttributeMapFlags();
	}
	
	
	private static void clearBlockRaster() {
		for (int i = 0; i < blockraster.length; i++)
			for (int ii = 0; ii < blockraster.length; ii++)
				blockraster[i][ii] = false;
	}
	
	private static boolean isPathObstructed(Npc npc, PathQueue.Step walkStep) {
		clearBlockRaster();
		int mysize = npc.size();

			/* Put the local npcs into the graph */
		final boolean[] inside = {false}; // TODO
		
		npc.world().npcs().forEachInArea(npc.bounds(4), n -> {
			if (n != npc && !inside[0]) { // If we figured we're inside.. then why process?
				
				// By having the size forced to 0 this gives the npc with the lowest index the ability to unstack
				// out from under others whom are on the exact same tile, as their borders and current tile will
				// have been shaved off the checks. Bald fucks.
				int sz = npc.index() > n.index() ? n.size() : 0;
				int dx = n.tile().x - npc.tile().x, dy = n.tile().z - npc.tile().z;
				
				// Graph is limited to 3 to avoid costly calcs with big monsters or crowded spots
				for (int x = 0; x < (sz > 4 ? 4 : sz); x++) {
					for (int y = 0; y < (sz > 4 ? 4 : sz); y++) {
						int ix = GRAPH_OFF + x + dx;
						int iy = GRAPH_OFF + y + dy;
						
						if (ix >= 0 && ix < blockraster.length && iy >= 0 && iy < blockraster.length) {
							blockraster[ix][iy] = true;
						}
						
						// Check if we're inside.
						if (dx + x >= 0 && dx + x < mysize && dy + y >= 0 && dy + y < mysize) {
							inside[0] = true;
						}
					}
				}
			}
		});
		
		// Last part: the checking
		boolean willIntersect = false;
		int dx = walkStep.x - npc.tile().x, dy = walkStep.z - npc.tile().z;
		
		// Make the actual check
		check:
		for (int x = 0; x < mysize; x++) {
			for (int y = 0; y < mysize; y++) {
				if (blockraster[GRAPH_OFF + dx + x][GRAPH_OFF + dy + y]) {
					willIntersect = true;
					break check; // Please don't waste my megahurtz
				}
			}
		}
		
		return willIntersect;
	}
	
}
