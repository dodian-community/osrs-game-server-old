package io.nozemi.runescape.model;

import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.item.Item;

import java.util.NoSuchElementException;

public class GroundItem {

    public static final int DEFAULT_LIFETIME = 180_000;
    public static final int UNTRADABLE_LIFETIME = 180_000;

    private Item item;
    private final Tile tile;
    private final Object ownerId;
    private final long spawned = System.currentTimeMillis();
    private boolean broadcasted = false;
    private boolean tradable = false;
    /**
     * If other players cannot see our items, maybe we've not played for 30 minutes OR its food in the wild (brew dropping)
     */
    private boolean hidden = false;
    private long lifetime = DEFAULT_LIFETIME;
    private boolean respawns = false;
    private int respawnTimer = 100;
    private Object pkedFrom;
    private boolean forceBroadcast;

    public GroundItem(World world, Item item, Tile tile, Object ownerId) {
        this.item = item;
        this.tile = tile;
        this.ownerId = ownerId;
        this.tradable = item.tradable(world) && world.flagTradable(item);

        if (ownerId != null && world.playerForId(ownerId).isPresent()) {
            try {
                Player owner = world.playerForId(ownerId).get();
                if (owner.gameTime() < 3000) {
                    hidden = true;
                }
            } catch (NoSuchElementException e) {
                //whoever the drop is for is offline. we still register is, they can login 30 sec later and it'll be on the floor.
            }
        }

        if (ownerId == null)
            broadcasted = true;
    }

    public boolean respawns() {
        return respawns;
    }

    public Object pkedFrom() {
        return pkedFrom;
    }

    public GroundItem pkedFrom(Object id) {
        pkedFrom = id;
        return this;
    }

    public int respawnTimer() {
        return respawnTimer;
    }

    public GroundItem respawns(boolean b) {
        respawns = b;
        return this;
    }
    public GroundItem respawnTimer(int v) {
        respawnTimer = v;
        return this;
    }

    public GroundItem hidden() {
        hidden = true;
        return this;
    }

    public GroundItem forceBroadcast(boolean b) {
        forceBroadcast = b;
        return this;
    }

    public boolean isHidden() {
        return hidden;
    }

    public GroundItem item(Item item) {
        this.item = item;
        return this;
    }

    public GroundItem lifetime(long lifetime) {
        this.lifetime = lifetime;
        return this;
    }

    public Item item() {
        return item;
    }

    public Object owner() {
        return ownerId;
    }

    public boolean ownerMatches(Player vs) {
        return vs.id().equals(ownerId);
    }

    public Tile tile() {
        return tile;
    }

    public boolean broadcasted() {
        return broadcasted;
    }

    public GroundItem broadcasted(boolean b) {
        broadcasted = b;
        return this;
    }

    public boolean shouldBroadcast() {
        return forceBroadcast || (!hidden && tradable && System.currentTimeMillis() >= spawned + 60_000);
    }

    public boolean shouldBeRemoved() {
        return !respawns && System.currentTimeMillis() >= spawned + lifetime;
    }

    public boolean valid(World world) {
        return world.groundItemValid(this);
    }
}
