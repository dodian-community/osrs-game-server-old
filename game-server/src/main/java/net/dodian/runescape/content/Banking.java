package net.dodian.runescape.content;

import net.dodian.runescape.content.npcs.Bankers;
import net.dodian.runescape.events.Script;
import net.dodian.runescape.events.ScriptMain;
import net.dodian.runescape.events.ScriptRepository;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.entity.player.IronMode;
import net.dodian.runescape.net.message.game.command.InterfaceSettings;
import net.dodian.runescape.net.message.game.command.InterfaceText;
import net.dodian.runescape.net.message.game.command.InvokeScript;
import net.dodian.runescape.util.Varbit;

import java.util.Arrays;

import static net.dodian.runescape.content.constants.ObjectConstants.BANK_BOOTH_1;

public class Banking {

    @ScriptMain
    public static void onSpeakToBanker(ScriptRepository scriptRepository) {
        Arrays.stream(Bankers.getBankerNpcIds()).forEach(id -> {
            scriptRepository.onNpcAction1(id, (script) -> {
                script.player().message("You arrived.");
                ((Player) script.getContext()).chatNpc("Good day, how may I help you?", script.targetNpc(), 588)
                    .setAction(() -> ((Player) script.getContext()).getDialogueHandler().terminate());
                return null;
            });

            scriptRepository.onNpcAction2(id, (script) -> {
                open(((Player) script.getContext()), script);
                return null;
            });
        });

        scriptRepository.onObject(BANK_BOOTH_1, (script) -> {
            open(((Player) script.getContext()), script);
            return null;
        });
    }

    private static void open(Player player, Script script) {
        if (player.ironMode() == IronMode.ULTIMATE) {
            player.message("As an ultimate iron man, you may not use the bank.");
            return;
        }

        player.write(new InvokeScript(InvokeScript.SETVARCS, -1, -2147483648));

        if (player.interfaces().resizable()) player.invokeScript(917, -1, -2);

        player.interfaces().sendMain(12, false);
        player.interfaces().sendInventory(15);

        player.write(new InterfaceSettings(12, 23, 0, 799, 1312254));
        player.write(new InterfaceSettings(12, 23, 809, 817, 2));
        player.write(new InterfaceSettings(12, 23, 818, 827, 1048576));
        player.write(new InterfaceSettings(12, 21, 10, 10, 1048578));
        player.write(new InterfaceSettings(12, 21, 11, 19, 1179714));
        player.write(new InterfaceSettings(15, 3, 0, 27, 1181438));
        player.write(new InterfaceSettings(15, 14, 0, 27, 1054));
        player.write(new InterfaceSettings(12, 46, 1, 800, 2));
        player.write(new InterfaceSettings(12, 49, 0, 3, 2));
        player.write(new InterfaceText(12, 18, "800"));
        player.varps().varbit(Varbit.BANK_YOUR_LOOT, 0);

        player.bank().makeDirty();

        player.invokeScript(1495, "The total amount of items you have in this bank over the max capacity.", 786439, 786474);
    }
}
