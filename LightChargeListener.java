package com.Swan.Korra.PKLight;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class LightChargeListener implements Listener{
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (event.isSneaking()) {
			new LightCharge(event.getPlayer());
		}
	}

}
