package io.nozemi.runescape.model.entity;

import io.netty.channel.Channel;
import io.nozemi.runescape.content.mechanics.VarbitAttributes;
import io.nozemi.runescape.crypto.IsaacRand;
import io.nozemi.runescape.model.*;
import io.nozemi.runescape.model.entity.player.*;
import io.nozemi.runescape.model.instance.InstancedMap;
import io.nozemi.runescape.model.instance.InstancedMapIdentifier;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.model.item.ItemContainer;
import io.nozemi.runescape.net.future.ClosingChannelFuture;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.command.*;
import io.nozemi.runescape.script.Timer;
import io.nozemi.runescape.script.TimerKey;
import io.nozemi.runescape.util.Tuple;
import io.nozemi.runescape.util.Varbit;
import io.nozemi.runescape.util.Varp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Player extends Entity {

    private static final Logger logger = LogManager.getLogger(Player.class);

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
    private int gametime;

    /**
     * Character Information
     */
    private String username;
    private Privilege privilege = Privilege.PLAYER;
    private Looks looks;
    private IronMode ironMode = IronMode.NONE;

    private Skills skills;

    private ItemContainer equipment;

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
        this.equipment = new ItemContainer(world, 14, ItemContainer.Type.REGULAR);

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
        skills = new Skills(this);
        skills.update();

        write(new SetPlayerOption(3, false, "Follow"));
        write(new SetPlayerOption(4, false, "Trade with"));

        int worldFlag = 1;
        write(new UpdateStateCustom(worldFlag));

        // Trigger scripts here(?)
        //message("Welcome to OS-Scape. On here, you die.");

        invokeScript(1350);
        write(new InvokeScript(389, skills.combatLevel()));

        pathQueue.setDefaultLastStep();

        boolean off = VarbitAttributes.varbiton(this, Varbit.KS_SKULLS_HIDDEN);
        write(UpdateStateCustom.skullToggle(!off));

        write(UpdateStateCustom.setErrorReportState(true));

        looks.update();

        // Sync varps
        varps.syncNonzero();
        varps.sync(Varp.CLAN_PRIVACY);
        varps.sync(Varp.CLIENT_SETTINGS);

        // Piety chivy plzzz
        //varps.varbit(3909, 8);

        // Since recent revisions, synching the varbit for attack options is required.
        // Since the varps are by default 0, and 0 does not get synched, attack options are missing.
        varps.sync(Varp.NPC_ATTACK_PRIORITY);
        varps.sync(Varp.PLAYER_ATTACK_PRIORITY);

        write(new UpdateSocialStatus(VarbitAttributes.varbit(this, VarbitAttributes.VarbitInfo.PUBLIC_CHAT_STATUS.getVarbitid()),
                VarbitAttributes.varbit(this, VarbitAttributes.VarbitInfo.TRADE_STATUS.getVarbitid())));
        write(new UpdateFriendsStatus(VarbitAttributes.varbit(this, VarbitAttributes.VarbitInfo.PM_STATUS.getVarbitid())));

        if (ironMode != IronMode.NONE) {
            varps.varbit(Varbit.IRON_MODE, ironMode.ordinal());
        }

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

    private boolean bot;
    public boolean bot() {
        return bot;
    }

    public void logout() {
        try {
            stopActions(true);
        } catch (Exception e) {
            logger.error("Exception during logout => stopactions for Player '{}'", username(), e);
        }

        try {
            // If we're in an instance, teleport to the proper tile before logging out.
            Optional<InstancedMap> active = world.allocator().active(tile);
            if (active.isPresent()) {
                InstancedMap mymap = active.get();
                if (mymap.getIdentifier().isPresent() && mymap.getIdentifier().get() == InstancedMapIdentifier.FIGHT_CAVE) {
                    // Teleport the player to the real position equivilent of where we were in the instance.
                    // We can then accurately place the player into an instance on login.
                    int instance_local_x = tile.x - mymap.bottomLeft().x;
                    int instance_local_z = tile.z - mymap.bottomLeft().z;
                    teleport(2368 + instance_local_x, 5056 + instance_local_z);
                } else {
                    // Teleport to the specified exit.
                    teleport(mymap.exit());
                }

                if (mymap.deallocatesOnLogout() && mymap.isCreatedFor(this)) {
                    world.allocator().deallocate(mymap);
                }
            }

        } catch (Exception e) {
            logger.error("Exception during logout => Cerb / Instances for Player '{}'", username(), e);
        }

        try {
            // Remove all NPCS owned by us
            List<Npc> remove = new LinkedList<>();
            world.npcs().forEach(n -> {
                // Unchecked cast from attribmap result Obj to Tuple
                if (n != null && ((Tuple<Integer, Player>) n.attribOr(AttributeKey.OWNING_PLAYER, new Tuple<>(-1, null))).first().equals(id)) {
                    remove.add(n);
                }
            });
            remove.forEach(world::unregisterNpc);
        } catch (Exception e) {
            logger.error("Exception during logout => owned Npcs for Player '{}'", username(), e);
        }

        try {
            // If we're logged in and the channel is active, begin with sending a logout message and closing the channel.
            // We use writeAndFlush here because otherwise the message won't be flushed cos of the next unregister() call.
            if (channel != null && channel.isActive()) {
                try {
                    // Are we trying to world hop?
                    if (attrib(AttributeKey.WORLDHOP_LOGOUTMSG) != null) {
                        channel.writeAndFlush(attrib(AttributeKey.WORLDHOP_LOGOUTMSG)).addListener(new ClosingChannelFuture());
                    } else {
                        channel.writeAndFlush(new Logout()).addListener(new ClosingChannelFuture());
                    }
                } catch (Exception e) {
                    // Silenced
                }
            }
        } catch (Exception e) {
            logger.error("Exception during logout => Channel closing for Player '{}'", username(), e);
        }

        // Then nicely unregister the player from the game.
        unregister();
    }

    public void unregister() {
        world.unregisterPlayer(this);
        //savePlayer(true);
        //saveHighscores();
    }

    public void updateWeaponInterface() {
        Item wep = equipment.get(EquipSlot.WEAPON);
        write(new InterfaceText(593, 1, wep == null ? "Unarmed" : wep.definition(world).name));
        write(new InterfaceText(593, 2, "Combat Lvl: " + (skills == null ? 3 : skills.combatLevel())));

        // Set the varp that holds our weapon interface panel type
        int panel = wep == null ? 0 : world.equipmentInfo().weaponType(wep.id());
        varps.varp(843, panel);
    }

    public boolean fire_logout() {
        boolean active = channel == null || channel.isActive();
        // Are we requested to be logged out?
        if ((Boolean) attribOr(AttributeKey.LOGOUT, false) || !active) {

            //Is the player in fight caves and hasn't already attempted to logout?
            int currentWave = this.attribOr(AttributeKey.TZHAAR_FIGHT_CAVES_WAVE, 0);
            boolean logoutWarningActivated = this.attribOr(AttributeKey.TZHAAR_LOGOUT_WARNING, false);

            //Inferno checks
            int infernoWave = this.attribOr(AttributeKey.INFERNO_SAVED_WAVE, 0);

            if (!timers.has(TimerKey.COMBAT_LOGOUT) && !timers.has(TimerKey.BLOODCHEST_HUNTED) && !dead() && ((boolean) attribOr(AttributeKey.NO_GPI, false) || !locked())) {
                logout();
                return true;
            } else {
                if (timers.has(TimerKey.COMBAT_LOGOUT)) {
                    message("You can't log out until 10 seconds after the end of combat.");
                } else if (timers.has(TimerKey.BLOODCHEST_HUNTED)) {
                    message("You're Hunted! You need to wait 60 seconds after picking up a key before logging out.");
                }
            }

            putattrib(AttributeKey.LOGOUT, false);
            clearattrib(AttributeKey.WORLDHOP_LOGOUTMSG);
        }
        return false;
    }

    private long nextSave = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10);

    @Override
    public void cycle() {

        gametime++; // Increment ticks we've played for

        if (fire_logout()) {
            // logout complete, no need to process other stuff
            return;
        }

        // First in p process, cycle the damaged queued on us.
        // This means we can die before any Script actions (such as combat) can execute.
        super.cycle_hits(true);

		/*if (isPlayer())
		    debug(String.format("%s: pcycle (first) ->  [e-pid:%s][pk-pid:%s]: %s %s", world.cycleCount(), index, pvpPid,
					timers.has(TimerKey.COMBAT_ATTACK) ? timers().left(TimerKey.COMBAT_ATTACK) : "-", dead()));*/

        // Now scripts after we're sure we haven't died from incoming damage this cycle.
        //world.server().scriptExecutor().cycle(Conditions.context(this));

        cycle_hits(false);

        // Decrease timers
        super.cycle();

        // Fire timers
        fire_timers();

        // Region enter and leave triggers
        int lastregion = attribOr(AttributeKey.LAST_REGION, -1);

        if (lastregion != tile.region()) {
            //world.server().scriptRepository().triggerRegionExit(this, lastregion);
            //world.server().scriptRepository().triggerRegionEnter(this, tile.region());
        }

        // Chunk enter and leave triggers (stop molesting my pretty code)
        int lastChunk = attribOr(AttributeKey.LAST_CHUNK, -1);
        if (lastChunk != tile.chunk()) {
            //world.server().scriptRepository().triggerChunkExit(this, lastChunk);
            //world.server().scriptRepository().triggerChunkEnter(this, tile.chunk());
        }

        if (attribOr(AttributeKey.WORLD_MAP, false)) {
            invokeScript(1749, tile().hash30());
        }

        // check if our last tile stepped on is the current.
//		if (pathQueue().lastStep() != null && !pathQueue.lastStep().equals(tile.x, tile.z)) {
//			world.server().scriptRepository().triggerWalkDestination(this);
//		}

        // Update last region and chunk ids
        putattrib(AttributeKey.LAST_REGION, tile.region());
        putattrib(AttributeKey.LAST_CHUNK, tile.chunk());


        if (System.currentTimeMillis() > nextSave) {
            //savePlayer(false);
            nextSave = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10 + world.random(5));
        }
    }

    private void fire_timers() {
        try {
            timerloop:
            for (Iterator<Timer> it = timers.timers().iterator(); it.hasNext(); ) {
                Timer entry = it.next();
                if (entry != null && entry.ticks() < 1) {
                    TimerKey key = entry.key();
                    int oldTicks, attemptsLeft = 50; // We cap attempts to 50 to avoid bugs.

                    while ((oldTicks = entry.ticks()) <= 0 && attemptsLeft-- >= 0) {
                        // This one is hardcoded: (disabled until more testing can be done)
                        if (key == TimerKey.CONNECTION_FORCE_LOGOUT && hp() > 0 && !dead() && !locked()) { // After 60s of no connection we are force logged.
                            logout();
                            return;
                        }

                        // Did it not get re-fired, or was the timer removed?
                        boolean cont = false;
                        if (entry == null || entry.ticks() == oldTicks || !timers.has(key)) {
                            timers.cancel(key);
                            cont = true;
                        }

                        //world.server().scriptRepository().triggerTimer(this, key); // Fire event

                        if (cont) {
                            continue timerloop; // Stop firing more events.
                        }
                    }

                    if (attemptsLeft < 0) {
                        timers.cancel(key);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error processing timers for {}.", this, e);
        }
    }
}
