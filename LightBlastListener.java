// ProjectKorra Light is an addition to add new abilities and a new Element to the game! I do not claim ownership of ProjectKorra Core or any other parts
// ProjectKorra Light was created by Gareth_Swan

package com.Swan.Korra.PKLight;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.ability.CoreAbility;

public class LightBlastListener implements Listener{
	
	@EventHandler
	public void onSwing(PlayerAnimationEvent event) {
		if (event.isCancelled()) {
			return;
		}
		
		BendingPlayer bPlayer = BendingPlayer.getBendingPlayer(event.getPlayer());
		if (bPlayer.canBend(CoreAbility.getAbility("Light"))) {
		    new LightBlast(event.getPlayer());	
		}
	}

}