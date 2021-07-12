package io.nozemi.runescape.net.packets.handlers.impl.player;

import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.packets.handlers.PacketHandler;
import io.nozemi.runescape.net.packets.handlers.PacketListener;
import io.nozemi.runescape.net.packets.impl.ChangeDisplayMode;
import io.nozemi.runescape.net.packets.impl.WindowStateChanged;
import io.nozemi.runescape.util.Varbit;
import org.springframework.stereotype.Component;

@Component
public class WindowPacketsHandler extends PacketListener {

    @PacketHandler
    public void onWindowStateChanged(WindowStateChanged packet, Player player) {

    }

    @PacketHandler
    public void onDisplayModeChanged(ChangeDisplayMode packet, Player player) {
        boolean wasResizable = player.interfaces().resizable();
        if ((wasResizable && packet.getDisplayMode() == 2) || (!wasResizable && packet.getDisplayMode() == 1)) { // dimension change only
            //System.err.println("same mode. ignoring...");
            return;
        }
        player.interfaces().resizable(packet.getDisplayMode() == 2);

        player.interfaces().sendForMode(!wasResizable ? 0 : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 1 ? 2 : 1,
                packet.getDisplayMode() == 1 ? 0 : packet.getDisplayMode() == 2 && player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 1 ? 2 : 1);
    }
}
