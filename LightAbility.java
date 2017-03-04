package com.Swan.Korra.PKLight;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.projectkorra.projectkorra.Element;
import com.projectkorra.projectkorra.ability.ElementalAbility;
import com.projectkorra.projectkorra.configuration.ConfigManager;


public abstract class LightAbility extends ElementalAbility{

	public LightAbility(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}
	
	public Element getElement() {
		// TODO Auto-generated method stub
		return Main.Light;
	
	}
	
	public ChatColor getColor() {
	    return ChatColor.valueOf(ConfigManager.languageConfig.get().getString("Chat.Colors.Light"));
	    
	}    
	
}