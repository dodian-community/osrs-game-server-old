package io.nozemi.runescape.util;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;

/**
 * Created by Situations on 12/31/2015.
 */

public class RunEnergy {
	
	private final Player player;
	
	public RunEnergy(Player player) {
		this.player = player;
	}
	
	public void update() {
		double energy = player.attribOr(AttributeKey.RUN_ENERGY, 0.0);
		
		double add = player.getRecoveryRate();
		
		player.setRunningEnergy(energy + add, true);
	}
	
	public void drainForMove() {
		//if (player.world().realm().isDeadman() && player.world().server().config().hasPathOrNull("deadman.jaktestserver"))
		//	return;
		
		//Grabs the players energy %
		double energy = player.attribOr(AttributeKey.RUN_ENERGY, 0);
		//Grabs the change in energy
		double change = player.getEnergyDeprecation();
		//Check to see if the player has drank a stamina potion
		int stamina = player.attribOr(AttributeKey.STAMINA_POTION, 0);
		//If the player has drank a stamina potion, energy drain is reduced by 70%
		if (stamina > 0) change *= 0.3;
		//If for some reason the change is less then 0, we set it to 0.05
		if (change < 0) change = 0.05;
		
		//We apply the change to the players energy level
		player.setRunningEnergy(energy - change, true);
	}
}
