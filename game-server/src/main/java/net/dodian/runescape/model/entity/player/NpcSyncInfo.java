package net.dodian.runescape.model.entity.player;

import io.netty.buffer.Unpooled;
import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.AttributeKey;
import net.dodian.runescape.model.Entity;
import net.dodian.runescape.model.Hit;
import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.entity.Npc;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.entity.SyncInfo;
import net.dodian.runescape.util.Tuple;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class NpcSyncInfo extends SyncInfo {
	
	private int transmog;
	private int combatLevel;
	public Player owner;
	
	// Do this ONCE per update cycle instead of checking the enum attribute map multiple times (even tho EnumKeys are fast surely this is faster?)
	public void updateAttributeMapFlags() {
		super.updateUniversalAttribStates();
		try {
			Tuple<Integer, Player> ownerLink = entity.attrib(AttributeKey.OWNING_PLAYER);
			owner = ownerLink == null ? null : ownerLink.second();
		} catch (Exception jakIsAFaggot) {
			// You're a faggot if you're reading this, I hope you get coal for Christmas.
		}
	}
	
	public NpcSyncInfo(Npc npc) {
		super(npc);
	}

	public void combatLevel(int level) {
		combatLevel = level;
		addFlag(Flag.COMBAT_LEVEL.value);
	}

	public int combatLevel() {
		return combatLevel;
	}

	public void animation(int id, int delay) {
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(animationSet));
		buffer.get().writerIndex(0);
		buffer.writeShortA(id);
		buffer.writeByte(delay);
		
		addFlag(Flag.ANIMATION.value);
	}
	
	public void graphic(int id, int height, int delay) {
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(graphicSet));
		buffer.get().writerIndex(0);

		buffer.writeLEShortA(id);
		buffer.writeIntV1(height << 16 | delay);
		
		addFlag(Flag.GRAPHIC.value);
	}
	
	@Override
	public void hit(Hit hit) {
		this.hits.add(hit);
		addFlag(Flag.HIT.value);
	}
	
	@Override
	public void suffixPrefixName(String[] str) {
		throw new UnsupportedOperationException("NPC update does not support the Triple String flag");
	}
	
	public void shout(String message) {
		shout = new byte[message.length() + 1];
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(shout));
		buffer.get().writerIndex(0);
		buffer.writeString(message);
		addFlag(Flag.SHOUT.value);
	}
	
	@Override
	public void facetile(Tile tile) {
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(facetile));
		buffer.get().writerIndex(0);
		
		buffer.writeLEShort(tile.x);
		buffer.writeLEShort(tile.z);
		
		addFlag(Flag.FACE_TILE.value);
		entity.clearattrib(AttributeKey.LAST_FACE_ENTITY_IDX);
		entity.putattrib(AttributeKey.LAST_FACE_TILE, tile);
	}
	
	public int transmog() {
		return transmog;
	}
	
	public void transmog(int id) {
		transmog = id;
		addFlag(Flag.TRANSMOG.value);
	}
	
	@Override
	public void faceEntity(Entity e) {
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(faceEntitySet));
		buffer.get().writerIndex(0);
		int val = e == null ? -1 : e.isNpc() ? e.index() : (e.index() + 32768);
		buffer.writeLEShort(val);
		addFlag(Flag.FACE_ENTITY.value);
		if (e != null) {
			entity.putattrib(AttributeKey.LAST_FACE_ENTITY_IDX, val);
			entity.clearattrib(AttributeKey.LAST_FACE_TILE);
		} else {
			entity.clearattrib(AttributeKey.LAST_FACE_ENTITY_IDX);
		}
	}
	
	public byte[] animationSet() {
		return animationSet;
	}
	
	public byte[] graphicSet() {
		return graphicSet;
	}
	
	@Override
	public byte[] hitSet() {
		RSBuffer buffer = new RSBuffer(Unpooled.buffer(200));
		buffer.get().writerIndex(0);
		buffer.writeByteA(hits.size());
		
		for (int i = 0; i < hits.size(); i++) {
			Hit hit = hits.get(i);
			
			if (hit == null) {
				continue;
			}
			int type = hit.type().ordinal();
			buffer.writeCompact(type);
			buffer.writeCompact(hit.damage());
			buffer.writeCompact(hit.delay());
		}
		
		int size = entity.size();
		double lifePoints = entity.hp();
		double maxLifePoints = entity.maxHp();
		int barSize = size >= 5 ? 160 : 30;
		double ratio = (lifePoints / maxLifePoints) * barSize;
		if (lifePoints > maxLifePoints)
			lifePoints = maxLifePoints;
		
		if (!entity.dead() && ratio < 1) {
			ratio = 1;
		}
		
		buffer.writeByteA(1);
		buffer.writeCompact(size >= 5 ? 3 : 0); //is boss 3? if this is 0 we need another byte a at the end
		buffer.writeCompact(0);
		buffer.writeCompact(0);
		buffer.writeByteS((int) ratio);
		
		byte[] b = new byte[buffer.get().readableBytes()];
		buffer.get().getBytes(buffer.get().readerIndex(), b);
		return b;
	}
	
	public enum Flag {
		HIT(0x40),
		FACE_ENTITY(0x10),
		ANIMATION(0x20),
		FACE_TILE(0x1),
		SHOUT(0x2),
		GRAPHIC(0x4),
		TRANSMOG(0x8),
		COMBAT_LEVEL(0x80), // Custom - added to the client to render pet levels.
		;
		
		public int value;
		
		Flag(int v) {
			value = v;
		}
	}
	
}
