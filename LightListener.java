package com.Swan.Korra.PKLight;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;

public class LightListener implements Listener{
	
	@EventHandler
	public void onSwing(PlayerAnimationEvent event) {
		if (event.isCancelled()) {
			return;
		}
		
		BendingPlayer bPlayer = BendingPlayer.getBendingPlayer(event.getPlayer());
		if (bPlayer.canBend(CoreAbility.getAbility("Light"))) {
		    new Light(event.getPlayer());	
		}
	}

}
