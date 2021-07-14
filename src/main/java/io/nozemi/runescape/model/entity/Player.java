package io.nozemi.runescape.model.entity;

import io.netty.channel.Channel;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.content.mechanics.VarbitAttributes;
import io.nozemi.runescape.content.tools.editmode.EditModeHandler;
import io.nozemi.runescape.crypto.IsaacRand;
import io.nozemi.runescape.handlers.impl.dialogue.DialogueHandler;
import io.nozemi.runescape.handlers.impl.dialogue.DialogueOptionAction;
import io.nozemi.runescape.handlers.impl.dialogue.InputValueAction;
import io.nozemi.runescape.model.*;
import io.nozemi.runescape.model.entity.player.*;
import io.nozemi.runescape.model.instance.InstancedMap;
import io.nozemi.runescape.model.instance.InstancedMapIdentifier;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.model.item.ItemContainer;
import io.nozemi.runescape.model.map.steroids.Direction;
import io.nozemi.runescape.model.map.steroids.RouteFinder;
import io.nozemi.runescape.net.future.ClosingChannelFuture;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.command.*;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.script.Timer;
import io.nozemi.runescape.script.TimerKey;
import io.nozemi.runescape.service.login.LoginService;
import io.nozemi.runescape.util.*;
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

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Player extends Entity implements BeanFactoryAware {

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
    private double weight;

    private Skills skills;

    private ItemContainer equipment;
    private ItemContainer inventory;

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
        this.equipment = new ItemContainer(world, 14, ItemContainer.Type.REGULAR);
        this.inventory = new ItemContainer(world, 28, ItemContainer.Type.REGULAR);

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
        skills.update();

        write(new SetPlayerOption(3, false, "Follow"));
        write(new SetPlayerOption(4, false, "Trade with"));

        int worldFlag = 1;
        write(new UpdateStateCustom(worldFlag));

        // Trigger scripts here(?)
        if(GameInitializer.config().hasPath("world.welcome-messages")) {
            GameInitializer.config().getList("world.welcome-messages")
                    .forEach(configValue -> message("" + configValue.unwrapped()));
        }

        if(this.attribOr(AttributeKey.DEBUG, false)) {
            this.message("<col=f5a442>Debug mode is enabled, type ::debug to toggle.");
        }

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

        skills.syncDirty();
    }

    @Override
    public PlayerSyncInfo sync() {
        return (PlayerSyncInfo) sync;
    }

    public void sound(int[] values) {
        if(values.length == 1) {
            this.sound(values[0]);
        } else if(values.length == 2) {
            this.sound(values[0], values[1]);
        } else if(values.length >= 3) {
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
        int panel = wep == null ? 0 : world.equipmentInfo().weaponType(wep.id());
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

    private RunEnergy runEnergy = new RunEnergy(this);
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

        if(this.dialogueHandler == null) {
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

        if(this.dialogueHandler == null) {
            this.setDialogueHandler(beanFactory.getBean(DialogueHandler.class));
        }

        this.getDialogueHandler().initialize(this, "Continue");

        return this.dialogueHandler;
    }
    
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

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
}
