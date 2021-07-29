package io.nozemi.runescape.content.combat;

import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.EquipSlot;
import io.nozemi.runescape.model.entity.player.WeaponType;
import io.nozemi.runescape.model.item.Item;

public class WeaponSounds {

    public static int get(Player player) {
        Item weapon = player.equipment().get(EquipSlot.WEAPON);
        if(weapon != null) {
            int equipType = player.world().equipmentInfo().weaponType(weapon.getId());

            switch(weapon.getId()) {
                // God Swords
                case 11802:
                case 11804:
                case 11806:
                case 11808:
                case 20368:
                case 20370:
                case 20372:
                case 20374:
                    return 3846;

                // Other
                case 4153: // Granite Maul
                    return 2714;
                case 4726: // Guthan's Spear
                    return 1328;
                case 4755: // Verac's Flail
                    return 1323;
                case 4747: // Torag's Hammers
                    return 1332;
                case 4718: // Dharok's Greataxe
                    return 1321;
            }

            switch(equipType) {
                case WeaponType.LONGSWORD:
                    return 2500;
                case WeaponType.DAGGER:
                    return 2516;
                case WeaponType.PICKAXE:
                    return 2489;
                case WeaponType.MAGIC_STAFF:
                    return 2555;
                case WeaponType.AXE:
                    return 2498;
                case WeaponType.MACE:
                    return 2508;
                case WeaponType.HAMMER:
                    return 2567;
                case WeaponType.CROSSBOW:
                    return 2695;
                case WeaponType.BOW:
                    return 2693;
                case WeaponType.THROWN:
                    return 2696;
                case WeaponType.WHIP:
                    return 2720;
            }
        }

        return -1;
    }
}
