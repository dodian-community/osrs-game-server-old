package io.nozemi.runescape.content.interfaces;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.EquipSlot;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.model.item.ItemAttrib;
import io.nozemi.runescape.model.item.ItemContainer;
import io.nozemi.runescape.net.message.game.command.SetPlayerOption;
import io.nozemi.runescape.util.EquipmentInfo;
import io.nozemi.runescape.util.Varp;

import java.lang.ref.WeakReference;
import java.util.Map;

public class Equipment {

    public static void equip(Player player, int slot, Item toEquip, boolean interrupt) {
        EquipmentInfo equipmentInfo = player.world().equipmentInfo();
        int targetSlot = equipmentInfo.slotFor(toEquip.getId());
        int type = equipmentInfo.typeFor(toEquip.getId());

        if (targetSlot == -1)
            return;

        if (targetSlot == EquipSlot.WEAPON || targetSlot == EquipSlot.SHIELD) {
            // TODO: Implement the duel check later.
            /*if (DuelOptions.ruleToggledOn(player, DuelOptions.NO_WEAPON_SWITCH)) {
                player.message("You can't do that within a duel with no weapon switching enabled.")
                return
            }*/
        }

        Item currentItem = player.equipment().get(player.world().equipmentInfo().slotFor(toEquip.getId()));
        if (currentItem != null && currentItem.getId() == toEquip.getId() && currentItem.getAmount() == toEquip.getAmount() && !toEquip.definition(player.world()).stackable())//stackable items stack bolts ammo darts etc
            return;

        Map<Integer, Integer> reqs = player.world().equipmentInfo().requirementsFor(toEquip.getId());
        if (reqs != null && reqs.size() > 0) {
            reqs.forEach((key, item) -> {
                if (player.skills().xpLevel(key) < item) {
                    player.message("You need ${Skills.SKILL_INDEFINITES[req.key]} ${Skills.SKILL_NAMES[req.key]} level of ${req.value} to equip this.");
                    return;
                }
            });
        }

        /*if ((toEquip.getId() == AchievementDiary.ACHIEVEMENT_HOOD || toWear.id() == AchievementDiary.ACHIEVEMENT_CAPE) && !AchievementDiary.diaryHandler(player).completedAllAchievements(player)) {
            player.message("You must complete all achievement diary tasks to equip this item.")
            return
        }*/

        /*if (MAX_CAPES.contains(toWear.id()) && !MaxCape.hasTotalLevel(player)) {
            player.message("You need a Total Level of " + Mac.TOTAL_LEVEL_FOR_MAXED + " to wear this cape.")
            return
        }*/

        // Trying to equip a weapon that is 2 handed (type 5)
        /*if (targetSlot == 3 && type == 5 && Staking.in_duel(player)) {
            if (Staking.equipment_disabled(player, EquipSlot.SHIELD)) {
                player.message("Two-handed weapons are disabled for this stake.")
                return
            }
        }*/

        // Begin by setting the used item to null. This is to make it like osrs. Failing is scary but no worries!
        Item[] oldEquip = player.equipment().copy();
        Item[] oldInv = player.inventory().copy();

        Item toUnEquip = player.equipment().get(targetSlot);
        ItemContainer.Result removed = player.inventory().remove(toEquip, true, slot);

        // If type is 5 it is a two-handed weapon
        if (type == 5 && player.equipment().hasAt(EquipSlot.SHIELD)) {
            if (player.inventory().add(player.equipment().get(EquipSlot.SHIELD), false, (!player.equipment().hasAt(3)) ? slot : 0).failed()) {
                player.message("You don't have enough free space to do that.");
                player.equipment().restore(oldEquip);
                player.inventory().restore(oldInv);
                return;
            }
            player.equipment().set(EquipSlot.SHIELD, null);
        }

        // If we're trying to equip a shield and we have a 2h weapon equipped, unequip the 2h weapon
        if (targetSlot == EquipSlot.SHIELD && player.equipment().hasAt(EquipSlot.WEAPON)) {
            if (equipmentInfo.typeFor(player.equipment().get(EquipSlot.WEAPON).getId()) == 5) {
                // Is this indeed a 2h weapon?
                if (player.inventory().add(player.equipment().get(EquipSlot.WEAPON), false, slot).failed()) {
                    player.message("You don't have enough free space to do that.");
                    player.equipment().restore(oldEquip);
                    player.inventory().restore(oldInv);
                    return;
                }
                player.equipment().set(EquipSlot.WEAPON, null);
            }
        }

        if (targetSlot == EquipSlot.WEAPON) {
            // Weapons interrupt special attack
            player.varps().varp(Varp.SPECIAL_ENABLED, 0);

            // Remove auto-select
            /*SpellSelect.reset(player, true, false);
            boolean snowball = toEquip.getId() == 10501;
            if (snowball) {
                player.write(new SetPlayerOption(5, true, "Pelt"));
            }

            if (toEquip.getId() == 21015) { // Dinh's Bulwark
                player.graphic(1336);
            }*/
        }

        // By default, whatever item we're going to replace will be uneqipped
        // Only circumstance where it is not is arrows, where you can add more to the pile.
        boolean unEquip = true;
        // Do we already have that same item in that slot?
        if (player.equipment().hasAt(targetSlot, toEquip.getId())) {
            int newTot = player.equipment().count(toEquip.getId()) + toEquip.getAmount();
            if (newTot > Integer.MAX_VALUE || newTot < 0) {
                player.message("You don't have enough free space to do that.");
                player.equipment().restore(oldEquip);
                player.inventory().restore(oldInv);
                return;
            } else {
                // Dont un equip bolts, instead we'll stack them.
                unEquip = false;
                // Update the existing worn item total amount to combine the stackable quantities
                player.equipment().set(targetSlot, new Item(toEquip.getId(), newTot));
            }
        }

        // Finally, equip the item we had in mind.
        if (unEquip) {
            Item newItem = null;
            if (toUnEquip != null) {
                // On 07 there are two max capes, one has right-click equipment options and the other does not!
                int newId = (toUnEquip.getId() == 13342) ? 13280 : toUnEquip.getId();
                newItem = new Item(newId, toUnEquip.getAmount()).duplicateProperties(toUnEquip);

                // Take off the snowball. Replace with fight, attack or null.
                if (newItem.getId() == 10501) {
                    player.write(new SetPlayerOption(5, false, "null"));
                }
            }
            if (toUnEquip != null) { //TODO for now
                //player.world().server().scriptRepository().triggerItemUnequip(player, toUnequip.id())
            }
            ItemContainer.Result invResult = player.inventory().add(newItem == null ? toUnEquip : newItem, false, slot);
            if (toUnEquip != null && invResult.failed()) {
                player.message("You don't have enough free space to do that.");
                player.equipment().restore(oldEquip);
                player.inventory().restore(oldInv);
            } else {
                int newId2 = (toEquip.getId() == 13280) ? 13342 : toEquip.getId();
                Item newItem2 = new Item(newId2, toEquip.getAmount()).duplicateProperties(toEquip);
                // When successfully unequipping the pre-existing item in the target slot, wear the new one.
                player.equipment().set(targetSlot, newItem2);
            }
        }

        if (interrupt) {
            //WeakReference<Entity> ref = player.attrib(AttributeKey.TARGET) || WeakReference<Entity>(null);


            //val ref: WeakReference<Entity> = player.attrib<WeakReference<Entity>>(AttributeKey.TARGET) ?: WeakReference<Entity>(null)
            //val wep = player.equipment()[EquipSlot.WEAPON]
            //val requestedGmaulSpecs = player.attribOr<Int>(AttributeKey.GRANITE_MAUL_SPECIALS, 0)
            //if (wep == null || (wep.id() != 4153 && wep.id() != 12848) || (ref.get() != null) && !player.touches(ref.get()) || (wep.id() == 4153 && requestedGmaulSpecs > 0))
            //    player.stopActions(false)
        }

        //CombatSounds.weapon_equip_sounds(player, slot, toWear.id())
        player.updateWeaponInterface();
    }

    public static void checkTargetVenomGear(Entity attacker, Entity victim) {
        if(victim.isPlayer() && attacker.isNpc()) {
            // There is a chance for venom to apply when it has charges. Charge deduction is done on a different time - the same one as Barrows, it decays when in combat @ 733 scales/hour
            if (venomHelm(victim) && attacker.world().rollDie(6, 1)) {
                attacker.venom(victim);
            }
        }
    }

    public static boolean venomHelm(Entity target) {
        Item helm = target.equipment().get(EquipSlot.HEAD);

        if(helm == null) {
            return false;
        }

        if(helm.getId() == 12931 || helm.getId() == 13197 || helm.getId() == 13199) {
            if(helm.propertyOr(ItemAttrib.ZULRAH_SCALES, 0) > 0) {
                return true;
            }
        }

        return false;
    }
}
