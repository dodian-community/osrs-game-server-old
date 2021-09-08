package net.dodian.runescape.net.packets.impl;

import com.typesafe.config.Config;
import net.dodian.orm.models.game.NpcSpawn;
import net.dodian.runescape.content.commands.CommandHandler;
import net.dodian.runescape.content.mechanics.Censor;
import net.dodian.runescape.content.editmode.EditModeHandler;
import net.dodian.runescape.content.editmode.modes.NpcSpawningMode;
import net.dodian.runescape.handlers.impl.ButtonHandler;
import net.dodian.runescape.handlers.impl.ConfigHandler;
import net.dodian.runescape.handlers.impl.DataHandler;
import net.dodian.runescape.model.AttributeKey;
import net.dodian.runescape.model.ChatMessage;
import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.entity.Npc;
import net.dodian.runescape.model.entity.PathQueue;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.entity.player.Privilege;
import net.dodian.runescape.net.packets.annotations.Filters;
import net.dodian.runescape.net.packets.annotations.MessageListener;
import net.dodian.runescape.net.packets.filters.AdvertisingFilter;
import net.dodian.runescape.net.packets.filters.PlayerIsAliveFilter;
import net.dodian.runescape.net.packets.filters.SwearingFilter;
import net.dodian.runescape.net.packets.models.*;
import net.dodian.runescape.orm.repositories.NpcSpawnsRepository;
import net.dodian.runescape.util.HuffmanCodec;
import net.dodian.runescape.util.Varbit;
import nl.bartpelle.dawnguard.DataStore;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PacketMessageHandler implements BeanFactoryAware {

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_AUTO_CHAT = 1;
    private static final int TYPE_CLAN_CHAT = 2;

    private final HuffmanCodec codec;
    private final ButtonHandler buttonHandler;
    private final CommandHandler commandHandler;
    private final NpcSpawnsRepository repository;

    private BeanFactory beanFactory;

    @Autowired
    public PacketMessageHandler(DataHandler dataHandler, ButtonHandler buttonHandler, ConfigHandler configHandler, CommandHandler commandHandler, NpcSpawnsRepository repository) {
        this.buttonHandler = buttonHandler;
        this.commandHandler = commandHandler;
        this.repository = repository;

        if(dataHandler.huffman() == null) {
            Config config = configHandler.config();
            DataStore dataStore = new DataStore(config.getString("server.filestore"));
            this.codec = new HuffmanCodec(dataStore);
        } else {
            this.codec = dataHandler.huffman();
        }
    }

    /**
     * Method handles public chatting for players.
     *
     * There is a Filter annotation here that isn't used yet.
     * Treat that as a placeholder for implementation in the future.
     *
     * @param chat The decoded packet from the client
     */
    @MessageListener
    @Filters({SwearingFilter.class, AdvertisingFilter.class})
    public void onMessage(PublicChat chat) {
        Player player = chat.getPlayer();

        byte[] stringData = new byte[256];
        codec.decode(chat.getData(), stringData, 0, 0, chat.getLen());
        String message = new String(stringData, 0, chat.getLen());

        int icon = player.calculateBaseIcon();

        ChatMessage chatMessage = new ChatMessage(message, chat.getEffect(), chat.getColor(), icon, chat.getType() == TYPE_AUTO_CHAT);
        player.sync().publicChatDampered = Censor.dampered(player, message);
        chatMessage.starred(Censor.starred(message));
        player.sync().publicChatMessage(chatMessage);
    }

    @MessageListener
    @Filters(PlayerIsAliveFilter.class)
    public void onButtonClick(ButtonAction action) {
        Player player = action.getPlayer();

        if (player.privilege().eligibleTo(Privilege.ADMIN) && player.<Boolean>attribOr(AttributeKey.DEBUG, false))
            player.message("Button option %d on [%d:%d], item: %d, slot: %d", action.getOption() + 1, action.getHash() >> 16, action.getHash() & 0xFFFF, action.getItem(), action.getSlot());

        if(player.dead()) {
            return;
        }

        if (player.interfaces().visible(action.getHash() >> 16)) {
            if (action.getHash() >> 16 != 382) {
                player.putattrib(AttributeKey.INTERACTION_OPTION, action.getOption() + 1);
                int parentId = action.getHash() >> 16;
                int childId = action.getHash() & 0xFFFF;
                buttonHandler.handleButton(player, parentId, childId, action.getOption() + 1, action.getItem());
            }
        }
    }

    @MessageListener
    public void onWalk(WalkMap walk) {
        Player player = walk.getPlayer();

        // Mode 2 is ctrl-shift clicking, teleporting to the tile.
        if (walk.getMode() == 2) {
            player.teleport(walk.getX(), walk.getZ(), player.tile().level);
            player.interfaces().closeMain();
            player.stopActions(true);
            return;
        }

        if(player.attribOr(AttributeKey.EDIT_MODE, false)) {
            if(player.getEditModeHandler() != null && player.getEditModeHandler().getMode().equals(EditModeHandler.Mode.SPAWNING_NPC)) {
                NpcSpawningMode npcSpawningMode = (NpcSpawningMode) player.getEditModeHandler().getEditorModeInstance();

                Npc npc = beanFactory.getBean(Npc.class);

                npc.setId(npcSpawningMode.getNpcId());
                npc.setWorld(player.world());
                npc.setSpawnTile(new Tile(walk.getX(), walk.getZ(), player.tile().level));

                npc.walkRadius(npcSpawningMode.getWalkRadius());
                npc.spawnDirection(npcSpawningMode.getSpawnDirection());

                player.world().registerNpc(npc);

                // TODO: Do persist again...
                //repository.save(new NpcSpawn(npc));

                player.message("Spawned NPC successfully at, %s, %s.", walk.getX(), walk.getZ());
            }

            return;
        }

        if (!player.locked() && !player.dead()) {
            double energy = player.attribOr(AttributeKey.RUN_ENERGY, 0.0);
            if (walk.getMode() == 1 && energy <= 1) {
                walk.setMode(0);
            }
            if (player.looks().trans() == 3008) {
                player.walkTo(walk.getX(), walk.getZ(), PathQueue.StepType.FORCED_WALK, true);
            } else {
                player.walkTo(walk.getX(), walk.getZ(), walk.getMode() == 1 ? PathQueue.StepType.FORCED_RUN : PathQueue.StepType.REGULAR, true);
            }
        }
    }

    @MessageListener
    public void onConsoleAction(ConsoleAction action) {
        String[] parts = action.getCommand().split(" ");
        String commandName = parts[0];
        String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);

        commandHandler.triggerCommand(action.getPlayer(), commandName, arguments);
    }

    @MessageListener
    public void onWindowStateChanged(WindowStateChanged stateChange) {

    }

    @MessageListener
    public void onDisplayModeChanged(ChangeDisplayMode displayModeChange) {
        Player player = displayModeChange.getPlayer();

        boolean wasResizable = player.interfaces().resizable();
        if ((wasResizable && displayModeChange.getDisplayMode() == 2) || (!wasResizable && displayModeChange.getDisplayMode() == 1)) { // dimension change only
            //System.err.println("same mode. ignoring...");
            return;
        }
        player.interfaces().resizable(displayModeChange.getDisplayMode() == 2);

        player.interfaces().sendForMode(!wasResizable ? 0 : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 1 ? 2 : 1,
                displayModeChange.getDisplayMode() == 1 ? 0 : displayModeChange.getDisplayMode() == 2 && player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 1 ? 2 : 1);
    }

    @MessageListener
    public void onPingPacket(PingPacket pingPacket) {

    }

    @MessageListener
    public void onPingPacket(ClickAction pingPacket) {

    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
