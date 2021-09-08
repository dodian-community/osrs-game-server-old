package net.dodian.runescape.model.entity.player;

import io.netty.buffer.Unpooled;
import net.dodian.runescape.GameInitializer;
import net.dodian.runescape.handlers.impl.DataHandler;
import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.*;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.entity.SyncInfo;
import net.dodian.runescape.util.HuffmanCodec;

import java.util.Arrays;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class PlayerSyncInfo extends SyncInfo {
	
	private byte[] looksBlock;
	private byte[] publicChatBlock, censoredPublicChatBlock;
	
	/* Related to player updating below */
	private int[] localPlayerIndices = new int[255];
	private int localPlayerPtr;
	private int[] removedPlayerIndices = new int[255];
	private int[] playerUpdateRequests = new int[255];
	private int playerUpdateReqPtr;
	private int[] newlyAdded = new int[30];
	private int newlyAddedPtr;
	
	/* Related to player updating below */
	private byte[] playerFlags = new byte[2048];
	private short[] visiblePlayerIndices = new short[2048];
	private short[] invisiblePlayerIndices = new short[2048];
	private int invisiblePlayerCount;
	private int visiblePlayerCount;
	private int[] lastRegionHashes = new int[2048];
	protected int movementMode;
	protected int teleportMode;
	
	/* Related to npc updating below */
	private int[] localNpcIndices = new int[255];
	private int localNpcPtr;
	private int[] removedNpcIndices = new int[255];
	private int[] npcUpdateRequests = new int[255];
	private int npcUpdateReqPtr;
	public int[] newlyAddedNpcs = new int[30];
	public int newlyAddedNpcPtr;
	private ForceMovement cachedMove;
	private boolean ready = false;
	public boolean publicChatDampered;
	
	/**
	 * This value is held in our players AttributeKey set, but this direct referenced is updated pre-cycle ot save having to use the map.
	 */
	public boolean HIDE_ALL_NPCS;
	
	public PlayerSyncInfo(Player player) {
		super(player);
	}
	
	public int[] localPlayerIndices() {
		return localPlayerIndices;
	}
	
	public int[] localNpcIndices() {
		return localNpcIndices;
	}
	
	public int localPlayerPtr() {
		return localPlayerPtr;
	}
	
	public int localNpcPtr() {
		return localNpcPtr;
	}
	
	public void localPlayerPtr(int i) {
		localPlayerPtr = i;
	}
	
	public void localNpcPtr(int i) {
		localNpcPtr = i;
	}
	
	public int[] removedPlayerIndices() {
		return removedPlayerIndices;
	}
	
	public int[] playerUpdateRequests() {
		return playerUpdateRequests;
	}
	
	public int[] npcUpdateRequests() {
		return npcUpdateRequests;
	}
	
	public int playerUpdateReqPtr() {
		return playerUpdateReqPtr;
	}
	
	public void playerUpdateReqPtr(int i) {
		playerUpdateReqPtr = i;
	}
	
	public int npcUpdateReqPtr() {
		return npcUpdateReqPtr;
	}
	
	public void npcUpdateReqPtr(int i) {
		npcUpdateReqPtr = i;
	}
	
	public int[] newlyAdded() {
		return newlyAdded;
	}
	
	public int newlyAddedPtr() {
		return newlyAddedPtr;
	}
	
	public int visiblePlayerCount() {
		return visiblePlayerCount;
	}
	
	public void visiblePlayerCount(int i) {
		visiblePlayerCount = i;
	}
	
	public void invisiblePlayerCount(int i) {
		invisiblePlayerCount = i;
	}
	
	public int invisiblePlayerCount() {
		return invisiblePlayerCount;
	}
	
	public short[] visiblePlayerIndices() {
		return visiblePlayerIndices;
	}
	
	public short[] invisiblePlayerIndices() {
		return invisiblePlayerIndices;
	}
	
	public byte[] playerFlags() {
		return playerFlags;
	}
	
	public int[] lastRegionHashes() {
		return lastRegionHashes;
	}
	
	public void init() {
		if (!ready) {
			ready = true;
			
			visiblePlayerIndices[visiblePlayerCount++] = (short) entity.index();
			
			for (int index = 1; index < 2048; index++) {
				if (index != entity.index()) {
					invisiblePlayerIndices[invisiblePlayerCount++] = (short) index;
					playerFlags[index] = (byte) 0;
				}
			}
		}
	}
	
	public int movementMode() {
		return movementMode;
	}
	
	public int teleportMode() {
		return teleportMode;
	}
	
	public void movementMode(int m) {
		movementMode = m;
		addFlag(Flag.MOVEMENT_MODE.value);
	}
	
	public void teleportMode(int m) {
		teleportMode = m;
		addFlag(Flag.TELEPORT_MODE.value);
	}
	
	public void calculateLooks() {
		byte[] l = ((Player) entity).looks().get();
		looksBlock = new byte[l.length + 1];
		for (int i = 0; i < l.length; i++) {
			looksBlock[i + 1] = l[i];
		}
		looksBlock[0] = (byte) (l.length + 128);
		addFlag(Flag.LOOKS.value);
	}
	
	public void animation(int id, int delay) {
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(animationSet));
		buffer.get().writerIndex(0);
		buffer.writeLEShortA(id);
		buffer.writeByteA(delay);
		
		addFlag(Flag.ANIMATION.value);
	}
	
	public void graphic(int id, int height, int delay) {
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(graphicSet));
		buffer.get().writerIndex(0);
		buffer.writeLEShortA(id);
		buffer.writeLEInt(height << 16 | delay);
		
		addFlag(Flag.GRAPHIC.value);
	}
	
	@Override
	public void facetile(Tile tile) {
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(facetile));
		buffer.get().writerIndex(0);
		
		/*buffer.writeLEShort(tile.x);
		buffer.writeLEShort(tile.z);*/
		
		facedTile = tile;
		addFlag(Flag.FACE_TILE.value);
		entity.clearattrib(AttributeKey.LAST_FACE_ENTITY_IDX);
		entity.putattrib(AttributeKey.LAST_FACE_TILE, tile);
		// Reset in walking/face entity
	}
	
	@Override
	public void faceEntity(Entity e) {
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(faceEntitySet));
		buffer.get().writerIndex(0);
		int val = e == null ? -1 : e.isNpc() ? e.index() : (e.index() + 32768);
		buffer.writeLEShort(val);
		if (e != null) {
			entity.putattrib(AttributeKey.LAST_FACE_ENTITY_IDX, val);
			entity.clearattrib(AttributeKey.LAST_FACE_TILE);
		} else {
			entity.clearattrib(AttributeKey.LAST_FACE_ENTITY_IDX);
		}
		
		
		addFlag(Flag.FACE_ENTITY.value);
	}
	
	public void forceMove(ForceMovement move) {
		cachedMove = move;
		addFlag(Flag.FORCE_MOVE.value);
	}
	
	public void forceMove(Player viewer, RSBuffer buffer) {
		buffer.writeByteA(cachedMove.dx1);
		buffer.writeByteS(cachedMove.dz1);
		buffer.writeByteA(cachedMove.dx2);
		buffer.writeByteS(cachedMove.dz2);
		buffer.writeShort(cachedMove.speed1);
		buffer.writeLEShortA(cachedMove.speed2);
		buffer.writeLEShortA(cachedMove.direction);
	}
	
	public void publicChatMessage(ChatMessage message) {
		HuffmanCodec huffman = GameInitializer.handler(DataHandler.class)
				.orElseThrow(() -> new RuntimeException("Failed to get DataHandler..."))
				.huffman();

		RSBuffer buffer = new RSBuffer(Unpooled.buffer(256));
		buffer.get().writerIndex(0);
		buffer.writeLEShort((message.colors() << 8) | message.effects());
		
		int icon = ((Player) entity).privilege().ordinal();
		/*if (icon == 0 || ((Player) entity).seniorModerator())
			icon = message.icon();*/
		
		buffer.writeByteA(icon);
		buffer.writeByteN(message.autochat() ? 1 : 0);
		buffer.get().markWriterIndex();
		
		byte[] huffmandata = new byte[256];
		int len = huffman.encode(message.text(), huffmandata);
		
		int textLen = message.text().length();
		buffer.writeByte(len + (textLen >= 0x80 ? 2 : 1));
		buffer.writeCompact(textLen);
		buffer.get().writeBytes(huffmandata, 0, len);
		
		publicChatBlock = new byte[buffer.get().writerIndex()];
		System.arraycopy(buffer.get().array(), 0, publicChatBlock, 0, publicChatBlock.length);

		// Encode the censored version if it needs to be.
		if (message.starred() != null && message.starred().length() > 0) {
			huffmandata = new byte[256];
			len = huffman.encode(message.starred(), huffmandata);
			textLen = message.starred().length();
			buffer.get().resetWriterIndex();
			buffer.writeByte(len + (textLen >= 0x80 ? 2 : 1));
			buffer.writeCompact(textLen);
			buffer.get().writeBytes(huffmandata, 0, len);

			censoredPublicChatBlock = new byte[buffer.get().writerIndex()];
			System.arraycopy(buffer.get().array(), 0, censoredPublicChatBlock, 0, censoredPublicChatBlock.length);
		}
		addFlag(Flag.CHAT.value);
	}
	
	public void shout(String message) {
		try {
			shout = new byte[message.getBytes().length + 1];
			RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(shout));
			buffer.get().writerIndex(0);
			buffer.writeString(message);
			addFlag(Flag.SHOUT.value);
		} catch (Exception e) {
			System.err.println("FAILED writing " + message + " len " + message.length() + " raw " + Arrays.toString(message.getBytes()));
			e.printStackTrace();
		}
	}
	
	@Override
	public void hit(Hit hit) {
		this.hits.add(hit);
		addFlag(Flag.HIT.value);
	}
	
	@Override
	public void suffixPrefixName(String[] strs) {
		if (strs == null || strs.length > 3)
			throw new UnsupportedOperationException("Strings mask must be 3 strings");
		tripleStrings = new byte[strs[0].length() + strs[1].length() + strs[2].length() + 3];
		RSBuffer buffer = new RSBuffer(Unpooled.wrappedBuffer(tripleStrings));
		buffer.get().writerIndex(0);
		for (String s : strs)
			buffer.writeString(s);
		addFlag(Flag.PREFIX_NAME_SUFFIX.value);
	}
	
	public byte[] looksBlock() {
		return looksBlock;
	}
	
	public byte[] chatMessageBlock() {
		return publicChatBlock;
	}

	public byte[] censoredPubChatMessageBlock() { return censoredPublicChatBlock; }
	
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
			buffer.writeCompact(hit.overkill() > 0 && hit.type() == Hit.Type.MISS ? Hit.Type.REGULAR.ordinal() : hit.type().ordinal());
			buffer.writeCompact(hit.overkill());
			buffer.writeCompact(hit.delay());
		}
		
		int size = entity.size();
		double lifePoints = entity.hp();
		double maxLifePoints = entity.maxHp();
		
		if (lifePoints > maxLifePoints) {
			lifePoints = maxLifePoints;
		}
		
		buffer.writeByte(1);
		buffer.writeCompact(size >= 5 ? 3 : size >= 3 ? 4 : 0); //is boss 3? if this is 0 we need another byte a at the end
		buffer.writeCompact(0);
		buffer.writeCompact(0);
		
		int render = (int) ((lifePoints / maxLifePoints) * (30 * size));
		if (lifePoints > 0 && render == 0) {
			render = 1;
		}
		
		buffer.writeByteA(render);
		
		byte[] b = new byte[buffer.get().readableBytes()];
		buffer.get().getBytes(buffer.get().readerIndex(), b);
		return b;
	}
	
	public void clear() {
		super.clear();
		playerUpdateReqPtr = 0;
		newlyAddedPtr = 0;
		npcUpdateReqPtr = 0;
		newlyAddedNpcPtr = 0;
		cachedMove = null;
		publicChatDampered = false;
		censoredPublicChatBlock = null;
	}
	
	public boolean hasInView(int index) {
		for (int i = 0; i < localPlayerPtr; i++)
			if (localPlayerIndices[i] == index)
				return true;
		return false;
	}
	
	public boolean hasNpcInView(int index) {
		for (int i = 0; i < localNpcPtr; i++)
			if (localNpcIndices[i] == index)
				return true;
		return false;
	}
	
	public boolean isNewlyAdded(int index) {
		for (int i = 0; i < newlyAddedPtr; i++)
			if (newlyAdded[i] == index)
				return true;
		return false;
	}
	
	public boolean isNewlyAddedNpc(int index) {
		for (int i = 0; i < newlyAddedNpcPtr; i++)
			if (newlyAddedNpcs[i] == index)
				return true;
		return false;
	}
	
	public void newlyAddedPtr(int p0) {
		newlyAddedPtr = p0;
	}
	
	public void updateAttributeMapFlags() {
		super.updateUniversalAttribStates();
		HIDE_ALL_NPCS = entity.attribOr(AttributeKey.NO_GPI, false);
	}
	
	public enum Flag {
		LOOKS(0x4),
		ANIMATION(0x20),
		FACE_ENTITY(0x10),
		SHOUT(0x8),
		HIT(0x1),
		FACE_TILE(0x2),
		CHAT(0x40),
		GRAPHIC(0x800),
		FORCE_MOVE(0x100),
		TELEPORT_MODE(0x200),
		MOVEMENT_MODE(0x1000),
		PREFIX_NAME_SUFFIX(0x400);
		
		public int value;
		
		private Flag(int v) {
			value = v;
		}
	}
	
}
