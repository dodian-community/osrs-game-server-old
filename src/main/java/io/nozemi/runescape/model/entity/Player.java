package io.nozemi.runescape.model.entity;

import io.netty.channel.Channel;
import io.nozemi.runescape.crypto.IsaacRand;
import io.nozemi.runescape.model.*;
import io.nozemi.runescape.model.entity.player.*;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.command.*;
import io.nozemi.runescape.util.Varbit;
import io.nozemi.runescape.util.Varp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Player extends Entity {

    /**
     * Networking
     */
    private Channel channel;
    private IsaacRand inRand;
    private IsaacRand outRand;
    private boolean discardWrites;
    private String ip;
    private boolean logged; // Log packet history for this player?
    private long lastPing = System.currentTimeMillis();

    /**
     * Character Information
     */
    private String username;
    private Privilege privilege = Privilege.PLAYER;
    private Looks looks;
    private IronMode ironMode = IronMode.NONE;

    /**
     * Location Information
     */
    private Tile remoteLocation;
    private Tile activeMap;

    /**
     * Other
     */
    private Object id;
    private int gameTime;
    private Interfaces interfaces;
    /**
     * A list of pending actions which are decoded at the next game cycle.
     */
    private ConcurrentLinkedQueue<Action> pendingActions = new ConcurrentLinkedQueue<>();

    @Autowired
    public Player(World world) {
        this.sync = new PlayerSyncInfo(this);
        this.interfaces = new Interfaces(this);
        this.looks = new Looks(this);
        this.varps = new Varps(this);
        this.world = world;

        InetSocketAddress socketAddress;
        InetAddress inetaddress = null;
        if (channel != null) {
            socketAddress = (InetSocketAddress) channel.remoteAddress();
            inetaddress = socketAddress.getAddress();
        }
        ip = inetaddress == null ? "127.0.0.1" : inetaddress.getHostAddress();
    }

    /**
     * Sends everything required to make the user see the game.
     */
    public void initiate() {
        //skills.update();
        looks().update();

        // Send simple player options
        write(new SetPlayerOption(3, false, "Follow"));
        write(new SetPlayerOption(4, false, "Trade with"));
        /*if (equipment.get(3) != null && equipment.get(3).id() == 10501) // Snowball
            write(new SetPlayerOption(5, true, "Pelt"));*/

        int worldFlag = 1;

        write(new UpdateStateCustom(worldFlag));

        // Trigger a scripting event
        // TODO: Look into this
        //world.server().scriptRepository().triggerLogin(this);
        looks.update();

        // Sync varps
        varps.syncNonzero();
        varps.sync(Varp.CLAN_PRIVACY);
        varps.sync(Varp.CLIENT_SETTINGS);

        // Piety chivy plzzz
        varps.varbit(3909, 8);

        // Since recent revisions, synching the varbit for attack options is required.
        // Since the varps are by default 0, and 0 does not get synched, attack options are missing.
        varps.sync(Varp.NPC_ATTACK_PRIORITY);
        varps.sync(Varp.PLAYER_ATTACK_PRIORITY);

        /*world.server().service(PmService.class, true).ifPresent(pmService -> {
            pmService.onUserOnline(this);
        });*/

        // Please gib donations :(
        //world.server().service(BMTPostback.class, true).ifPresent(bmt -> bmt.acquire((Integer) id()));

        // Load our presets
        //presetRepository.load();

        // Set the correct varbit for the Iron Man mode.
        if (ironMode != IronMode.NONE) {
            varps.varbit(Varbit.IRON_MODE, ironMode.ordinal());
        }

        // Sets display name status to 'configured'. -1 means no name.
        invokeScript(1105, 1);
    }

    public void id(Object id) {
        this.id = id;
    }

    public Object id() {
        return id; // Temporary!
    }

    public Channel channel() {
        return this.channel;
    }

    public Player channel(Channel channel) {
        this.channel = channel;
        return this;
    }

    public IsaacRand inRand() {
        return this.inRand;
    }

    public Player inRand(IsaacRand rand) {
        this.inRand = rand;
        return this;
    }

    public IsaacRand outRand() {
        return this.outRand;
    }

    public Player outRand(IsaacRand rand) {
        this.outRand = rand;
        return this;
    }

    public String username() {
        return this.username;
    }

    public Player username(String username) {
        this.username = username;
        return this;
    }

    public String ip() {
        return ip;
    }

    public void logged(boolean b) {
        logged = b;
    }

    public boolean logged() {
        return logged;
    }

    public Interfaces interfaces() {
        return interfaces;
    }

    public Tile remoteLocation() {
        return remoteLocation;
    }

    public void updateRemoteLocation() {
        remoteLocation = tile;
    }

    public Tile activeMap() {
        return activeMap;
    }

    public void activeMap(Tile t) {
        activeMap = t;
    }

    public Area activeArea() {
        if (activeMap == null) {
            return new Area(tile.x - 52, tile.z - 52, tile.x + 52, tile.z + 52, tile().level);
        }

        return new Area(activeMap.x, activeMap.z, activeMap.x + 104, activeMap.z + 104, activeMap.level);
    }

    public boolean busy() {
        return (attribOr(AttributeKey.BUSY, false));
    }

    public void busy(boolean isBusy) {
        putattrib(AttributeKey.BUSY, isBusy);
    }

    public void write(Object... o) {
        // TODO: Fix this later? Causes a disconnect
        if(o[0] instanceof SendWidgetTimer) {
            return;
        }

        if (!discardWrites) {
            if (channel.isActive()) {
                for (Object msg : o) {
                    channel.write(msg);
                }
            }
        }
    }

    public int gameTime() {
        return gameTime;
    }

    public void gameTime(int t) {
        gameTime = t;
    }

    public Looks looks() {
        return looks;
    }

    public Privilege privilege() {
        return privilege;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public boolean isNpc() {
        return false;
    }

    @Override
    public void hp(int hp, int exceed) {

    }

    @Override
    public int hp() {
        return 1;
    }

    @Override
    public int maxHp() {
        return 1;
    }

    @Override
    protected void die() {

    }

    @Override
    public int attackAnimation() {
        return 0;
    }

    @Override
    public void post_cycle_movement() {

    }

    public void postcycle_dirty() {
        // Does weight need to be recomputed?
        /*if (inventory.dirty() || equipment.dirty()) {
            ItemWeight.calculateWeight(this);
        }

        // Sync inventory
        if (inventory.dirty()) {
            write(new SetItems(93, 149, 0, inventory));
            inventory.clean();
        }

        // Sync equipment if dirty
        if (equipment.dirty()) {
            write(new SetItems(94, equipment));
            looks.update();
            equipment.clean();

            // Also send the stuff required to make the weaponry panel proper
            updateWeaponInterface();
        }

        // Sync bank if dirty
        if (bank.dirty()) {
            write(new SetItems(95, bank));
            bank.clean();
        }

        //Sync looting bag if dirty
        if (lootingBag.dirty()) {
            write(new SetItems(516, lootingBag));
            lootingBag.clean();
        }

        // Sync skills if dirty
        skills.syncDirty();

        if (attribOr(AttributeKey.SHOP_DIRTY, false)) {
            Shop shop = attribOr(AttributeKey.SHOP, null);
            if (shop != null) {
                shop.refreshFor(this);
            }
            clearattrib(AttributeKey.SHOP_DIRTY);
        }*/
    }

    @Override
    public PlayerSyncInfo sync() {
        return (PlayerSyncInfo) sync;
    }

    public void sound(int id) {
        write(new PlaySound(id, 0));
    }

    public void sound(int id, int delay) {
        write(new PlaySound(id, delay));
    }

    public void sound(int id, int delay, int times) {
        write(new PlaySound(id, delay, times));
    }

    public void invokeScript(int id, Object... args) {
        write(new InvokeScript(id, args));
    }

    public boolean seesChunk(int x, int z) {
        return activeArea().contains(new Tile(x, z));
    }

    public ConcurrentLinkedQueue<Action> pendingActions() {
        return pendingActions;
    }

    public long lastPing() {
        return lastPing;
    }

    public void lastPing(long lastPing) {
        this.lastPing = lastPing;
    }
}
