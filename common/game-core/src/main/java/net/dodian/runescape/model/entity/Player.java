package net.dodian.runescape.model.entity;

import io.netty.channel.Channel;
import net.dodian.runescape.GameInitializer;
import net.dodian.runescape.content.combat.WeaponSounds;
import net.dodian.runescape.content.interfaces.Equipment;
import net.dodian.runescape.content.mechanics.VarbitAttributes;
import net.dodian.runescape.content.npcs.Bankers;
import net.dodian.runescape.content.npcs.NpcFacingPlayerPolicy;
import net.dodian.runescape.content.editmode.EditModeHandler;
import net.dodian.runescape.crypto.IsaacRand;
import net.dodian.runescape.events.ScriptExecutor;
import net.dodian.runescape.events.ScriptRepository;
import net.dodian.runescape.fs.ItemDefinition;
import net.dodian.runescape.fs.NpcDefinition;
import net.dodian.runescape.handlers.impl.dialogue.DialogueHandler;
import net.dodian.runescape.handlers.impl.dialogue.InputValueAction;
import net.dodian.runescape.model.*;
import net.dodian.runescape.model.entity.player.*;
import net.dodian.runescape.model.instance.InstancedMap;
import net.dodian.runescape.model.instance.InstancedMapIdentifier;
import net.dodian.runescape.model.item.Item;
import net.dodian.runescape.model.item.ItemContainer;
import net.dodian.runescape.model.map.MapObj;
import net.dodian.runescape.model.map.steroids.Direction;
import net.dodian.runescape.model.map.steroids.RangeStepSupplier;
import net.dodian.runescape.model.map.steroids.RouteFinder;
import net.dodian.runescape.net.future.ClosingChannelFuture;
import net.dodian.runescape.net.message.game.Action;
import net.dodian.runescape.net.message.game.command.*;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.script.Timer;
import net.dodian.runescape.script.TimerKey;
import net.dodian.runescape.service.login.LoginService;
import net.dodian.runescape.tasksystem.ExecuteInterface;
import net.dodian.runescape.tasksystem.InterruptibleTask;
import net.dodian.runescape.tasksystem.TaskManager;
import net.dodian.runescape.util.*;
import kotlin.ranges.IntRange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static net.dodian.runescape.content.combat.PlayerCombat.canAttack;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Player extends Entity implements BeanFactoryAware {

    private static final Logger logger = LogManager.getLogger(Player.class);

    /**
     * Account Information
     */
    private int userId;
    private int roleId;
    private int discordId;
    private String email;
    private String discordInfo;
    private boolean mfaEnabled;

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
    private int gameTime;
    private final ConcurrentLinkedQueue<GamePacket> pendingPackets = new ConcurrentLinkedQueue<>();

    /**
     * Character Information
     */
    private String username;
    private Privilege privilege = Privilege.PLAYER;
    private Looks looks;
    private IronMode ironMode = IronMode.NONE;
    private GameMode mode = GameMode.CLASSIC;
    private RunEnergy runEnergy = new RunEnergy(this);
    private double weight;

    private Skills skills;

    private ItemContainer equipment;
    private ItemContainer inventory;
    private ItemContainer bank;
    private ItemContainer lootingBag;

    /**
     * Location Information
     */
    private Tile remoteLocation;
    private Tile activeMap;

    /**
     * Other
     */
    private Object id;
    private Interfaces interfaces;
    private int defaultIcon;


    @Autowired
    public Player(World world) {
        this.sync = new PlayerSyncInfo(this);
        this.interfaces = new Interfaces(this);
        this.looks = new Looks(this);
        this.varps = new Varps(this);
        this.world = world;
        this.skills = new Skills(this);

        InetSocketAddress socketAddress;
        InetAddress inetaddress = null;
        if (channel != null) {
            socketAddress = (InetSocketAddress) channel.remoteAddress();
            inetaddress = socketAddress.getAddress();
        }
        ip = inetaddress == null ? "127.0.0.1" : inetaddress.getHostAddress();
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.equipment = beanFactory.getBean(ItemContainer.class)
                .setSize(14).setType(ItemContainer.Type.REGULAR);
        this.inventory = beanFactory.getBean(ItemContainer.class)
                .setSize(28).setType(ItemContainer.Type.REGULAR);
        this.bank = beanFactory.getBean(ItemContainer.class)
                .setSize(800).setType(ItemContainer.Type.FULL_STACKING);
        this.beanFactory = beanFactory;
    }

    /**
     * Sends everything required to make the user see the game.
     */
    public void initiate() {
        skills.update();

        write(new SetPlayerOption(3, false, "Follow"));
        write(new SetPlayerOption(4, false, "Trade with"));

        int worldFlag = 1;
        write(new UpdateStateCustom(worldFlag));

        // Trigger scripts here(?)
        if (GameInitializer.config().hasPath("world.welcome-messages")) {
            GameInitializer.config().getList("world.welcome-messages")
                    .forEach(configValue -> message("" + configValue.unwrapped()));
        }

        if (this.attribOr(AttributeKey.DEBUG, false)) {
            this.message("<col=f5a442>Debug mode is enabled, type ::debug to toggle.");
        }

        invokeScript(1350);
        write(new InvokeScript(389, skills.combatLevel()));

        pathQueue.setDefaultLastStep();

        boolean off = VarbitAttributes.varbiton(this, Varbit.KS_SKULLS_HIDDEN);
        write(UpdateStateCustom.skullToggle(!off));

        write(UpdateStateCustom.setErrorReportState(true));

        if (this.attribOr(AttributeKey.NEW_ACCOUNT, false)) {
            this.message("Welcome to your first time on Dodian! Don't hesitate to contact us for assistance if you have any issues!");

            this.sendScroll("Welcome to Dodian!",
                    //"Welcome to Dodian, since this is your first time logging in",
                    "Welcome to Dodian, " + this.username + "! Hope you enjoy your stay at Dodian.",
                    "Since this is the first time you're logging in, we would like",
                    "to let you know that you can reach out to staff for help at any time!",
                    "",
                    "Please respect and follow our rules. We don't really ask much,",
                    "we just want to keep a nice and welcoming community.",
                    "",
                    "You can find more information on our website."
            );
        }

        if (!this.mfaEnabled) {
            this.message("<col=ff0000><img=50> You don't have two factor authentication enabled. We would recommend you enable this. You can do so on our website.");
            //this.write(new AddMessage("https://google.com/", AddMessage.Type.URL));
            /*this.chatPlayer("Your account is unsecure, please consider activating two factor authentication. " +
                    "That way you will get a verification code in your authenticator app.", 588).setActions(()
                    -> this.chatPlayer("Activate two factor authentication to receive 2b gold.", 588)
                    .setActions(() -> this.optionsTitled("Activate Now?", "Yes", "No").setActions(
                                () -> {
                                    this.write(new AddMessage("https://dodian.net/", AddMessage.Type.URL));
                                    this.dialogueHandler.terminate();
                                },
                                () -> this.dialogueHandler.terminate()
                            )
                    )
            );*/
        }

        beanFactory.getBean(ScriptRepository.class).triggerLogin(this);
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

    public IronMode ironMode() {
        return ironMode;
    }

    public void ironMode(IronMode mode) {
        ironMode = mode;
    }

    public GameMode mode() {
        return mode;
    }

    public void mode(GameMode mode) {
        this.mode = mode;
    }

    public ItemContainer equipment() {
        return equipment;
    }

    public void equipment(ItemContainer itemContainer) {
        this.equipment = itemContainer;
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
        if (o[0] instanceof SendWidgetTimer) {
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

    public void privilege(Privilege privilege) {
        this.privilege = privilege;
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
    public void postCycleMovement() {
        Player player = this;
        Tile origin = tile();

        // Were we teleported?
        if (sync().teleported() || !remoteLocation().equals(tile())) {
            sync().teleportMode(127);
            pathQueue.clear();
            sync.clearMovement();
            //MultiwayCombat.tileChanged(player);
            //player.world().server().scriptRepository().triggerWalkDestination(player);
        }


        if (!player.pathQueue().empty()) {
            PathQueue.Step walkStep = player.pathQueue().next();
            int walkDirection = PathQueue.calculateDirection(player.tile().x, player.tile().z, walkStep.x, walkStep.z);
            int runDirection = -1;

            // Make sure this clip tile is still valid
            boolean legal = !walkStep.clipped || RouteFinder.isLegal(player.world(), player.tile(), Direction.orthogonal(walkStep.x - player.tile().x, walkStep.z - player.tile().z), 1);
            if (!legal) {
                walkDirection = -1;
                player.pathQueue().clear();
                player.write(new ChangeMapMarker(player.tile().x, player.tile().z));
            } else {
                player.putattrib(AttributeKey.FACING_DIRECTION, walkDirection);
                player.tile(new Tile(walkStep.x, walkStep.z, player.tile().level));
                player.sync().movementMode(1);

                boolean running = (walkStep.type == PathQueue.StepType.FORCED_RUN || player.pathQueue().running()) && !player.pathQueue().empty() && walkStep.type != PathQueue.StepType.FORCED_WALK;
                if (!running) {
                    player.runenergy().update();
                } else {
                    player.runenergy().drainForMove();

                    PathQueue.Step runStep = player.pathQueue().next();
                    runDirection = PathQueue.calculateRunDirection(origin.x, origin.z, runStep.x, runStep.z);
                    legal = !runStep.clipped || RouteFinder.isLegal(player.world(), player.tile(), Direction.orthogonal(runStep.x - player.tile().x, runStep.z - player.tile().z), 1);

                    if (!legal) {
                        runDirection = -1;
                        player.pathQueue().clear();
                        player.write(new ChangeMapMarker(player.tile().x, player.tile().z));
                    } else {
                        // New GPI has a thing where run mode can also take a walk step, e.g. diagonal and then pathfind
                        // its way there.
                        if (runDirection == -1) {
                            walkDirection = PathQueue.calculateDirection(origin.x, origin.z, runStep.x, runStep.z);
                        }

                        player.putattrib(AttributeKey.FACING_DIRECTION, runDirection);
                        player.tile(new Tile(runStep.x, runStep.z, player.tile().level));
                        player.sync().movementMode(2);
                    }
                }
                //MultiwayCombat.tileChanged(player);
                //player.world().server().scriptRepository().triggerWalkDestination(player);
            }

            player.sync().step(walkDirection, runDirection);
        } else {
            int currentOrDefaultFaceDir = player.attribOr(AttributeKey.FACING_DIRECTION, -1);
            if (currentOrDefaultFaceDir == -1) { // Attrib doesn't exist yet.
                currentOrDefaultFaceDir = 6;
                player.putattrib(AttributeKey.FACING_DIRECTION, currentOrDefaultFaceDir);
            }
            player.runenergy().update();
        }

        player.sync().updateAttributeMapFlags();

        if (player.reqPidMoveReset) {
            pathQueue.clear();
            player.reqPidMoveReset = false;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean reqPidMoveReset;

    public void postCycleDirty() {
        // Does weight need to be recomputed?
        if (inventory.dirty() || equipment.dirty()) {
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

        if (bank.dirty()) {
            write(new SetItems(95, bank));
            bank.clean();
        }

        skills.syncDirty();
    }

    @Override
    public PlayerSyncInfo sync() {
        return (PlayerSyncInfo) sync;
    }

    public void sound(int[] values) {
        if (values.length == 1) {
            this.sound(values[0]);
        } else if (values.length == 2) {
            this.sound(values[0], values[1]);
        } else if (values.length >= 3) {
            this.sound(values[0], values[1], values[2]);
        }
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

    public ConcurrentLinkedQueue<GamePacket> pendingPackets() {
        return pendingPackets;
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
        savePlayer(true);
        //saveHighscores();
    }

    public void updateWeaponInterface() {
        Item wep = equipment.get(EquipSlot.WEAPON);
        write(new InterfaceText(593, 1, wep == null ? "Unarmed" : wep.definition(world).name));
        write(new InterfaceText(593, 2, "Combat Lvl: " + (skills == null ? 3 : skills.combatLevel())));

        // Set the varp that holds our weapon interface panel type
        int panel = wep == null ? 0 : world.equipmentInfo().weaponType(wep.getId());
        varps.varp(843, panel);
    }

    public boolean fireLogout() {
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
        gameTime++; // Increment ticks we've played for

        if (fireLogout()) {
            // logout complete, no need to process other stuff
            return;
        }

        // First in p process, cycle the damaged queued on us.
        // This means we can die before any Script actions (such as combat) can execute.
        super.cycleHits(true);

        cycleHits(false);

        // Decrease timers
        super.cycle();

        // Fire timers
        fireTimers();

        if (attribOr(AttributeKey.WORLD_MAP, false)) {
            invokeScript(1749, tile().hash30());
        }

        // Update last region and chunk ids
        putattrib(AttributeKey.LAST_REGION, tile.region());
        putattrib(AttributeKey.LAST_CHUNK, tile.chunk());


        if (System.currentTimeMillis() > nextSave) {
            savePlayer(false);
            nextSave = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10 + world.random(5));
        }
    }

    public void savePlayer(boolean removeOnline) {
        LoginService.serializer().savePlayer(this, removeOnline);
    }

    private void fireTimers() {
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

    public Skills skills() {
        return skills;
    }

    @Override
    public Optional<Integer> killer() {
        // If we don't even have any killers, then return an empty optional.
        if (damagers.isEmpty())
            return Optional.empty();

        // Obtain a stream set of all information tracked.
        Set<Map.Entry<Integer, PlayerDamageTracker>> trackset = damagers.entrySet()
                .stream()
                .filter(info -> System.currentTimeMillis() - getDamagerLastTime().get(info.getKey()) <= 300000)
                .filter(info -> !info.getValue().killer().username().equalsIgnoreCase(username()))
                .collect(Collectors.toSet());

        // Try to find the killer based on hitters
        Comparator<Map.Entry<Integer, PlayerDamageTracker>> comparator = (e1, e2) -> e2.getValue().damage().compareTo(e1.getValue().damage());

        // Identify the result
        Map.Entry<Integer, PlayerDamageTracker> result = trackset.stream().sorted(comparator).findFirst().orElse(null);

        // An anti-farming mechanic on W2 - checks if you ate or just suicided. Why suicide?
        int[] totalDamageTaken = new int[1];
        trackset.forEach(e -> totalDamageTaken[0] += e.getValue().damage());

        int account_id = result != null ? result.getKey() : -1;
        if (isPlayer() && account_id != -1) {
            putattrib(AttributeKey.MOST_DAM_TRACKER, new Tuple<>(totalDamageTaken[0], result.getValue()));
            return Optional.ofNullable(account_id);
        } else {
            clearattrib(AttributeKey.MOST_DAM_TRACKER);
            return Optional.empty();
        }
    }

    public RunEnergy runenergy() {
        return runEnergy;
    }

    public double getEnergyDeprecation() {
        double weight = Math.max(0, Math.min(54, getWeight())); // Capped at 54kg - where stamina affect no longer works.. for a QoL. Stamina always helpful!
        return (0.67) + weight / 100.0;
    }

    public double getRecoveryRate() {
        return (8.0 + (skills.level(Skills.AGILITY) / 6.0)) / 100;
    }

    public void setRunningEnergy(double runningEnergy, boolean send) {
        if (runningEnergy > 100) {
            runningEnergy = 100;
        } else if (runningEnergy < 0) {
            runningEnergy = 0;
        }

        if (runningEnergy < 1.0) {
            varps().varp(Varp.RUNNING_ENABLED, 0);
        }

        putattrib(AttributeKey.RUN_ENERGY, runningEnergy);

        int re = (int) runningEnergy;
        if (send) {
            write(SetRunEnergy.get(re));
        }
    }

    public void defaultIcon(int i) {
        defaultIcon = i;
    }

    public int getDefaultIcon() {
        return defaultIcon;
    }

    public int calculateBaseIcon() {
        // If we have a prefixed icon, use that one.
        if (defaultIcon > 0) {
            return defaultIcon;
        }

        //If we are playing Ironman or Ultimate Ironman. Or... Hardcore ]:)
        if (ironMode == IronMode.REGULAR) {
            return 3;
        } else if (ironMode == IronMode.ULTIMATE) {
            return 4;
        } else if (ironMode == IronMode.HARDCORE) {
            return 14;
        }

        return 0;
    }

    public void message(String format, Object... params) {
        write(new AddMessage(params.length > 0 ? String.format(format, params) : format));
    }

    public ItemContainer inventory() {
        return inventory;
    }

    public void inventory(ItemContainer container) {
        this.inventory = container;
    }

    private final ConcurrentLinkedQueue<Action> pendingActions = new ConcurrentLinkedQueue<>();

    public ConcurrentLinkedQueue<Action> pendingActions() {
        return pendingActions;
    }

    private EditModeHandler editModeHandler;

    public void setEditModeHandler(EditModeHandler editModeHandler) {
        this.editModeHandler = editModeHandler;
    }

    public EditModeHandler getEditModeHandler() {
        return editModeHandler;
    }

    private DialogueHandler dialogueHandler;

    public void setDialogueHandler(DialogueHandler dialogueHandler) {
        this.dialogueHandler = dialogueHandler;
    }

    public DialogueHandler getDialogueHandler() {
        return dialogueHandler;
    }

    public DialogueHandler optionsTitled(String title, String... options) {
        return this.optionsTitled(false, title, options);
    }

    public DialogueHandler optionsTitled(boolean terminate, String title, String... options) {
        this.interfaces().send(219, 162, 550, false);
        this.write(new InvokeScript(58, title, String.join("|", options)));
        this.write(new InterfaceSettings(219, 0, 1, 5, 1));

        if (this.dialogueHandler == null) {
            this.setDialogueHandler(beanFactory.getBean(DialogueHandler.class));
        }

        this.getDialogueHandler().initialize(this, terminate, options);

        return this.dialogueHandler;
    }

    public DialogueHandler chatPlayer(String msg, int anim) {
        this.interfaces().send(217, 162, 550, false);
        this.write(new InterfaceText(217, 1, this.username()));
        this.write(new InterfaceText(217, 2, "Click here to continue"));
        this.write(new InterfaceText(217, 3, msg));
        this.write(new PlayerOnInterface(217, 0));
        this.write(new AnimateInterface(217, 0, anim));
        this.write(new InvokeScript(600, 1, 1, 16, 14221315));
        this.write(new InterfaceSettings(217, 2, -1, -1, 1));

        if (this.dialogueHandler == null) {
            this.setDialogueHandler(beanFactory.getBean(DialogueHandler.class));
        }

        this.getDialogueHandler().initialize(this, "Continue");

        return this.dialogueHandler;
    }


    public DialogueHandler chatNpc(String msg, Npc npc, int anim) {
        NpcDefinition def = this.world.definitions().get(NpcDefinition.class, npc.id());

        this.interfaces().send(231, 162, 550, false);
        this.write(new InterfaceText(231, 1, def.name));
        this.write(new InterfaceText(231, 2, "Click here to continue"));
        this.write(new InterfaceText(231, 3, msg));
        this.write(new NpcOnInterface(231, 0, npc.id()));
        this.write(new AnimateInterface(231, 0, anim));
        this.write(new InvokeScript(600, 1, 1, 16, 15138819));
        this.write(new InterfaceSettings(231, 2, -1, -1, 1));

        if (this.dialogueHandler == null) {
            this.setDialogueHandler(beanFactory.getBean(DialogueHandler.class));
        }

        this.getDialogueHandler().initialize(this, "Continue");

        // The default Npc facing player policy. Npcs only face the player when their chat option appears.
        // Not when you interact with them.

        npc.face(this);

        // Npcs after ~8 seconds will reset their face direction if still facing the player.
        // If a player runs off and we're still lookin' at them it's a bit freakyy.
        beanFactory.getBean(ScriptExecutor.class).executeScript(npc, new NpcFacingPlayerPolicy(this));

        //waitReason = WaitReason.DIALOGUE;
        //interruptCall = dialogueInterruptCall;
        //Fiber.park();

        //this.interfaces().close(162, 550);
        return this.dialogueHandler;
    }

    private BeanFactory beanFactory;

    private InputValueAction<Integer> inputIntegerAction;
    private InputValueAction<String> inputStringAction;

    public InputValueAction<Integer> getInputIntegerAction() {
        return inputIntegerAction;
    }

    public InputValueAction<String> getInputStringAction() {
        return inputStringAction;
    }

    public void inputInteger(String message, InputValueAction<Integer> action) {
        this.invokeScript(108, message);
        this.inputIntegerAction = action;
    }

    public void inputString(String message, InputValueAction<String> action) {
        this.invokeScript(110, message);
        this.inputStringAction = action;
    }

    public void userId(int userId) {
        this.userId = userId;
    }

    public int userId() {
        return this.userId;
    }

    public void mfaEnabled(boolean value) {
        this.mfaEnabled = value;
    }

    public void sendScroll(String title, String... lines) {
        if (interfaces.visible(275))
            interfaces.closeMain();
        interfaces.text(275, 2, title);
        int childId = 4;
        interfaces.text(275, childId++, "");
        for (String s : lines)
            interfaces.text(275, childId++, s);
        interfaces.invokeScript(917, -1, -1);
        for (int i = childId; i <= 133; i++)
            interfaces.text(275, i, "");
        interfaces.sendMain(275);
    }

    @Override
    public void stopActions(boolean cancelMoving) {
        super.stopActions(cancelMoving);

        if (dialogueHandler != null) {
            dialogueHandler.terminate();
        }
    }

    public void walkToThen(MapObj object, ExecuteInterface then) {
        int option = this.attrib(AttributeKey.INTERACTION_OPTION);

        if (object != null && object.interactAble()) {
            AtomicBoolean hasReached = new AtomicBoolean(false);

            InterruptibleTask.bound(this).isCancellableByWalking(false).execute(() -> {
                boolean reachable;

                this.faceObj(object);

                if (this.timers.has(TimerKey.SPEAR)) {
                    return;
                }

                if (option == -1 && this.privilege.eligibleTo(Privilege.ADMIN)) {

                }

                // TODO: Add remote object check
                if ((object.type() == 10 && object.tile() == this.tile)) {
                    reachable = true;
                } else {
                    logger.info("Yep, we're getting the last tile etc...");
                    reachable = (this.looks.trans() == 3008) ? this.walkTo(object, PathQueue.StepType.FORCED_WALK) : this.walkTo(object, PathQueue.StepType.REGULAR);

                    this.write(new ChangeMapMarker(this.pathQueue.peekLastTile()));

                    Tile lastTile = this.pathQueue.peekLast() != null ? this.pathQueue.peekLast().toTile() : this.tile;

                    if (this.frozen()) {
                        if (this.tile != lastTile) {
                            this.message("A magical force stops you from moving.");
                            this.sound(154);
                            this.pathQueue.clear();
                            reachable = false;
                        }
                    }

                    if (this.tile != lastTile) {
                        if (this.pathQueue.empty()) {
                            walkToThen(object, then);
                        }
                        hasReached.set(false);
                        return;
                    }
                }

                if (object.valid(this.world) && !hasReached.get()) {
                    if (option == -1) {

                    }
                }

                if (object.valid(this.world)) {
                    if (reachable) {
                        if (option == -1) {
                            // ITEM ON OBJECT
                            // TODO: Add item on object
                            hasReached.set(true);
                        } else {
                            hasReached.set(true);
                        }
                    } else {
                        this.message("You can't reach that.");
                        hasReached.set(true);
                    }
                }
            }).completeCondition(hasReached::get)
                    .onComplete(then)
                    .submit(TaskManager.playerEvents());
        }
    }

    public void walkToThen(Npc target, Tile destination, ExecuteInterface then) {
        AtomicBoolean hasReached = new AtomicBoolean(false);
        // TODO: Can I check if using FORCED_WALK can not cancel this, but NORMAL_WALK can?
        InterruptibleTask.bound(this).isCancellableByWalking(false).execute(() -> {
            boolean reachable = false;
            Tile targetTile = null;
            Tile lastTile = target.tile();
            Tile playerTile = this.tile;

            this.face(target);

            int option = this.attrib(AttributeKey.INTERACTION_OPTION);

            // Item on NPC option
            if (option == -1 && (int) this.attribOr(AttributeKey.ITEM_ID, -1) == 5733) {
                // TODO: Trigger item on npc
                return;
            }

            boolean isBanker = Bankers.isBanker(target);

            if (targetTile == null || (lastTile.x != target.tile().x || lastTile.z != target.tile().z)) {
                if (this.looks.trans() == 3008) {
                    reachable = this.walkTo(target, PathQueue.StepType.FORCED_WALK);
                } else {
                    reachable = this.walkTo(target, PathQueue.StepType.REGULAR);
                }

                if (this.pathQueue.peekLast() != null && this.pathQueue.peekLast().toTile() != null) {
                    targetTile = this.pathQueue.peekLast().toTile();
                } else {
                    targetTile = this.tile;
                }
            }

            lastTile = target.tile();
            this.face(target);


            if (this.frozen()) {
                this.message("A magical forcce stops you from moving.");
                this.sound(154);
                this.pathQueue().clear();
            }

            boolean forceOk = false;

            if (isBanker) {
                RangeStepSupplier supplier = new RangeStepSupplier(this, target, 3);
                if (supplier.reached(this.world())) {
                    if (this.tile().equals(targetTile)) {
                        forceOk = true;
                        hasReached.set(true);
                    }
                }
            }

            if (targetTile != null && (this.touches(target, reached(this, target)) || forceOk)) {
                if (reachable || forceOk) {
                    if (!this.locked()) {
                        hasReached.set(true);
                    }
                }
            }

            if (!hasReached.get()) {
                if (reachable) {
                    if (this.pathQueue.empty()) {
                        walkToThen(target, destination, then);
                    }
                } else if (!isBanker) {
                    this.message("Target is not reachable.");
                    hasReached.set(true);
                } else {
                    //hasReached.set(true);
                }
            }
        }).completeCondition(hasReached::get)
                .onComplete(then)
                .submit(TaskManager.playerEvents());
    }

    private Tile reached(Player player, Entity target) {
        int steps = player.pathQueue().running() ? 2 : 1;
        int otherSteps = target.pathQueue().running() ? 2 : 1;

        Tile otherTile = null;
        if (target.pathQueue().peekAfter(otherSteps) != null && target.pathQueue().peekAfter(otherSteps).toTile() != null) {
            otherTile = target.pathQueue().peekAfter(otherSteps).toTile();
        } else {
            otherTile = target.tile();
        }

        if (player.pathQueue().peekAfter(steps - 1) != null && player.pathQueue().peekAfter(steps - 1).toTile() != null) {
            return player.pathQueue().peekAfter(steps - 1).toTile();
        }

        return player.tile();
    }

    public ItemContainer bank() {
        return bank;
    }

    public boolean hasItem(int... ids) {
        for (int i : ids) {
            if (inventory.has(i)) return true;
            if (equipment.has(i)) return true;
            if (bank.has(i)) return true;
            //if (grandExchange.has(i)) return true;
        }
        return false;
    }

    public void debug(String format, Object... params) {
        if (privilege == Privilege.ADMIN) {
            if (attribOr(AttributeKey.DEBUG, false)) {
                write(new AddMessage(params.length > 0 ? String.format(format, (Object[]) params) : format));
            }
        }
    }

    public void prepareAttack() {
        WeakReference<Entity> ref = this.attrib(AttributeKey.TARGET) == null ? new WeakReference<>(null) : this.attrib(AttributeKey.TARGET);
        AtomicReference<Entity> target = new AtomicReference<>(ref.get());

        // Stuff that happens the first time we attack
        this.interfaces().closeMain();
        this.interfaces().close(162, 550); // Close chatbox

        if (this.varps().varbit(Varbit.AUTOCAST_SELECTED) != 0) {
            if (!this.timers().has(TimerKey.COMBAT_ATTACK)) { // There is a 1-tick delay before you start autocasting on RS
                this.timers().addOrSet(TimerKey.COMBAT_ATTACK, 1);
            }
        }

        if (target.get() != null) {
            this.face(target.get());
            if (!canAttack(this, target.get())) {
                this.debug("<col=FF0000>Can't attack mate. Tick %s", this.world().cycleCount());
                return;
            }
        }

        AtomicBoolean completed = new AtomicBoolean(false);
        InterruptibleTask.bound(this)
                .execute(() -> {
                    Tile tile = this.tile();

                    this.pathQueue().clear();

                    this.face(target.get());
                    this.varps().varp(Varp.ATTACK_PRIORITY_PID, target.get().index());

                    // Establish some stuff...
                    int weaponId = -1;
                    int ammoId = -1;
                    if (this.equipment().get(EquipSlot.WEAPON) != null) {
                        weaponId = this.equipment().get(EquipSlot.WEAPON).getId();
                    }
                    if (this.equipment().get(EquipSlot.AMMO) != null) {
                        ammoId = this.equipment().get(EquipSlot.AMMO).getId();
                    }

                    int weaponType = this.world().equipmentInfo().weaponType(weaponId);

                    String wepName = "";
                    String ammoName = "";

                    ItemDefinition weaponDef = new Item(weaponId).definition(this.world());
                    ItemDefinition ammoDef = new Item(ammoId).definition(this.world());

                    if (weaponDef != null) {
                        wepName = weaponDef.name;
                    }

                    if (ammoDef != null) {
                        ammoName = ammoDef.name;
                    }

                    if (target.get().isPlayer() && weaponId != 10501) {
                        completed.set(true);
                    }

                    // Put combat timer
                    this.timers().addOrSet(TimerKey.IN_COMBAT, 5);

                    // Range, mage or melee?
                    if (weaponType == WeaponType.BOW || weaponType == WeaponType.CROSSBOW || weaponType == WeaponType.THROWN || weaponType == WeaponType.CHINCHOMPA) {
                        int attackRange = attackRange(weaponId);
                        boolean inRange = this.tile().distance(target.get().tile()) <= attackRange;
                        RangeStepSupplier supplier = new RangeStepSupplier(this, target.get(), attackRange);

                        if (!supplier.reached(this.world()) && !this.frozen() && !this.stunned()) {
                            this.walkTo(target.get(), PathQueue.StepType.REGULAR);
                            this.pathQueue.trimToSize((this.pathQueue.running() ? 2 : 1));
                        }

                        boolean reached = supplier.reached(this.world());
                        if (!reached && inRange && this.frozen()) {
                            this.message("I can't reach that!");
                            this.sound(154);
                            completed.set(true);
                        } else if (reached) {
                            if (!this.timers().has(TimerKey.COMBAT_ATTACK)) {
                                boolean crystalBow = new IntRange(4212, 4223).contains(weaponId);

                                if (!new IntRange(4212, 4223).contains(weaponId) && ((weaponType == WeaponType.BOW || weaponType == WeaponType.CROSSBOW) && ammoName.equals(""))) {
                                    this.message("There's no ammo left in your quiver.");
                                    completed.set(true);
                                }

                                this.world().spawnSound(this.tile(), WeaponSounds.get(this), 0, 10);
                                this.animate(EquipmentInfo.attackAnimationFor(this));

                                int tileDist = tile.distance(target.get().tile());
                                int cyclesPerTile = 5;
                                int baseDelay = 41;
                                int startHeight = 40;
                                int endHeight = 36;
                                int curve = 15;
                                int graphic = -1;
                                boolean addRangeStr = false;

                                if(crystalBow) {
                                    addRangeStr = true;
                                    this.graphic(250, 96, 0);
                                    graphic = 249;
                                    if (weaponId == 4212) {
                                        this.equipment().remove(new Item(4212), true, EquipSlot.WEAPON);
                                        this.equipment().add(new Item(4214), true, EquipSlot.WEAPON);
                                        this.message("Your crystal bow has degraded!");
                                    }
                                }

                                // TODO: Bows need special love

                                // Crossbows are the other type of special needs
                                if (weaponType == WeaponType.CROSSBOW) {
                                    addRangeStr = true;
                                    cyclesPerTile = 3;
                                    curve = 5;
                                    graphic = 27;
                                }

                                target.get().putattrib(AttributeKey.LAST_DAMAGER, this);
                                target.get().putattrib(AttributeKey.LAST_WAS_ATTACKED_TIME, System.currentTimeMillis());
                                this.putattrib(AttributeKey.LAST_ATTACK_TIME, System.currentTimeMillis());
                                this.putattrib(AttributeKey.LAST_TARGET, target);

                                if (target.get().isPlayer()) {
                                    Player targ = (Player) target.get();
                                    targ.interfaces().closeMain();
                                    targ.interfaces().close(162, 550); // Close chatbox
                                }
                                this.interfaces().closeMain();
                                this.interfaces().close(162, 550); // Close chatbox
                                Equipment.checkTargetVenomGear(this, target.get());
                                blockAnim(target.get(), delayForBlock(weaponId, weaponType, tileDist));

                                //boolean notSpec = this.varps().varp(Varp.SPECIAL_ENABLED) == 0;
                                //boolean didSpec = !notSpec;

                                boolean targetIsDummy = false;

                                this.varps().varp(Varp.SPECIAL_ENABLED, 0);
                            }
                        }
                    } else if((this.equipment().hasAt(EquipSlot.WEAPON, 11905) || this.equipment().hasAt(EquipSlot.WEAPON, 11907)) && target.get().isNpc()) {
                        spellOnPlayer(-1, -1, 1167, 1252, 30, 1251, new Graphic(1253, 90), 227, 28, 1, 75, 0.0, "trident");

                        this.timers().addOrSet(TimerKey.COMBAT_ATTACK, 4);
                        this.timers().addOrSet(TimerKey.IN_COMBAT, 5);
                    } else {
                        int attackRange = 10;
                        boolean inRange = this.tile().distance(target.get().tile()) <= attackRange;

                        RangeStepSupplier supplier = new RangeStepSupplier(this, target.get(), attackRange);
                        boolean reached = supplier.reached(this.world(), target.get());

                        boolean touches = this.touches(target.get(), tile);

                        if(!touches && this.frozen()) {
                            if(inRange && !reached) {
                                this.message("I can't reach that!");
                                this.sound(154);
                                completed.set(true);
                            } else {
                                // No issues with the projectile path finder. Combat DOES NOT cancel, you just can't reach them this cycle.
                                this.message("A magical force stops you from moving.");
                                this.sound(154);
                            }
                        }

                        boolean stuck = false;

                        if(!touches) {
                            if(!this.frozen() && !this.stunned()) {
                                if(target.get().isNpc() && ((Npc) target.get()).combatInfo() != null && ((Npc) target.get()).combatInfo().unstacked) {
                                    moveCloserNoPeek(target.get(), tile);
                                } else {
                                    tile = moveCloser(target.get(), tile);
                                }
                            } else {
                                stuck = true;
                            }
                        }

                        if(!stuck && this.touches(target.get(), tile)) {
                            if(!this.timers().has(TimerKey.COMBAT_ATTACK)) {
                                Equipment.checkTargetVenomGear(this, target.get());
                                target.get().putattrib(AttributeKey.LAST_WAS_ATTACKED_TIME, System.currentTimeMillis());
                                target.get().putattrib(AttributeKey.LAST_DAMAGER, this);
                                this.putattrib(AttributeKey.LAST_ATTACK_TIME, System.currentTimeMillis());
                                this.putattrib(AttributeKey.LAST_TARGET, target);
                                if(target.get().isPlayer()) {
                                    Player targ = (Player) target.get();
                                    targ.interfaces().closeMain();
                                    targ.interfaces().close(162, 550); // Close Chatbox
                                }
                                this.interfaces().closeMain();
                                this.interfaces().close(162, 550); // Close Chatbox

                                boolean success = AccuracyFormula.doesHit(this, target.get(), CombatStyle.MELEE, 1.0) || this.hasAttrib(AttributeKey.ALWAYS_HIT);

                                if(success) {
                                    int max = CombatFormula.maximumMeleeHit(this);
                                    int damage = this.attribOr(AttributeKey.ALWAYS_HIT, this.world().random(max));
                                    if(this.attribOr(AttributeKey.DEBUG, false)) {
                                        this.message("Damage: " + damage);
                                    }
                                    Hit hit = target.get().hit(this, damage, 1, false).combatStyle(CombatStyle.MELEE).pidAdjust().block(false);

                                    hit.applyProtection();

                                    hit.submit().addXp();

                                    target.get().blockHit(hit);

                                } else {
                                    if(this.attribOr(AttributeKey.DEBUG, false)) {
                                        this.message("You missed... :(");
                                    }
                                    Hit hit = target.get().hitpvp(this, 0, 1, CombatStyle.MELEE).block(false).submit();
                                    target.get().blockHit(hit);
                                }

                                this.animate(EquipmentInfo.attackAnimationFor(this));
                                this.world().spawnSound(this.tile(), WeaponSounds.get(this), 0, 10);
                                this.timers().addOrSet(TimerKey.COMBAT_ATTACK, this.world().equipmentInfo().weaponSpeed(weaponId));
                                this.timers().addOrSet(TimerKey.IN_COMBAT, this.world().equipmentInfo().weaponSpeed(weaponId));
                            }
                        }

                        this.varps().varp(Varp.SPECIAL_ENABLED, 0);
                    }

                    target.set(ref.get());
                })
                .onComplete(() -> {
                    this.message("You've completed the thing!");
                    this.face(null);
                })
                .completeCondition(() -> target.get() == null || target.get().dead() || this.dead() || !canAttack(this, target.get()) || completed.get())
                .submit(TaskManager.playerEvents());
    }

    public int delayForBlock(int weaponId, int weaponType, int distance) {
        int delay = 46;
        int pt = 5; // Delay per tile between opponents

        return delay + (Math.max(1, distance) * pt); // Dist -1 cos initial delay is 1*pt larger than it should be
    }

    public void blockAnim(Entity target, int delayForBlock) {
        if (target.isNpc()) {
            if (!((Npc) target).sync().hasFlag(NpcSyncInfo.Flag.ANIMATION.value)) {
                if (((Npc)target).combatInfo() != null) {
                    if (((Npc)target).combatInfo().animations.block > 0)
                        target.animate(((Npc)target).combatInfo().animations.block, delayForBlock);
                } else {
                    target.animate(424, delayForBlock);
                }
            }
        } else if (target.isPlayer()) {
            if (!(((Player)target)).sync().hasFlag(PlayerSyncInfo.Flag.ANIMATION.value)) {
                target.animate(EquipmentInfo.blockAnimationFor(((Player)target)), delayForBlock);
            }
        }
    }

    public int attackRange(int weaponId) {
        int attackRange = 7;

        if (weaponId == 4212) {
            attackRange = 13; // Crystal Bow
        }

        if (new IntRange(4214, 4223).contains(weaponId)) {
            attackRange = 10; // Crystal Bows
        }

        if (Collections.singletonList(new int[]{839, 845, 847, 851, 855, 859}).contains(weaponId)) {
            attackRange = 9; // Long Bows
        }

        if (new IntRange(5654, 5667).contains(weaponId) || new IntRange(863, 876).contains(weaponId)) {
            attackRange = 4; // Knives
        }

        if (new IntRange(806, 817).contains(weaponId) || new IntRange(5628, 5641).contains(weaponId) || weaponId == 3093 || weaponId == 3094) {
            attackRange = 3; // Darts
        }

        // Check if selected style is long range, increasing the distance.
        if (EquipmentInfo.attackStyleFor(this) == AttackStyle.LONG_RANGE) {
            attackRange += 2;
        }

        if (attackRange > 10) {
            attackRange = 10; // Maximum distance of a distance-based attack is 10 tiles
        }

        return attackRange;
    }

    public void spellOnPlayer(int castSound, int hitSound, int animation, int projectile, int speed, int startGfx, Graphic gfx, int splashSound, int maxHit, int spellBook, int level, double xp, String name, Item... runes) {
        // TODO: Implement spell on player
    }

    public Tile moveCloser(Entity target, Tile tile) {
        int steps = this.pathQueue().running() ? 2 : 1;
        int otherSteps = target.pathQueue().running() ? 2 : 1;

        Tile otherTile = target.tile();
        if(target.pathQueue().peekAfter(otherSteps) != null) {
            otherTile = target.pathQueue().peekAfter(otherSteps).toTile();
        }

        this.stepTowards(target, otherTile, 25);


        if(this.pathQueue().peekAfter(steps - 1) != null) {
            return this.pathQueue().peekAfter(steps - 1).toTile();
        }

        return tile;
    }

    public Tile moveCloserNoPeek(Entity target, Tile tile) {
        int steps = this.pathQueue().running() ? 2 : 1;

        Tile otherTile = target.tile();

        this.stepTowards(target, otherTile, 25);

        if(this.pathQueue().peekAfter(steps - 1) != null) {
            return this.pathQueue().peekAfter(steps - 1).toTile();
        }

        return tile;
    }
}
