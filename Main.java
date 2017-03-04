package com.Swan.Korra.PKLight;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.Swan.Korra.PKLight.LightListener;
import com.projectkorra.projectkorra.Element;
import com.projectkorra.projectkorra.Element.ElementType;
import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.ability.CoreAbility;
import com.projectkorra.projectkorra.configuration.ConfigManager;

public class Main extends JavaPlugin{
	
		public void onEnable() {
		
		new Element("Light", ElementType.BENDING, this);
		
		
		FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		ConfigManager.languageConfig.get().addDefault("Chat.Colors.Light", "YELLOW");
		ConfigManager.languageConfig.get().addDefault("Chat.Prefixes.Light", "[Light]");
		ConfigManager.languageConfig.save();
		saveConfig();
		
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new LightListener(), ProjectKorra.plugin);
		CoreAbility.registerPluginAbilities(this, "com.Swan.Korra.ProjectKorraLight");
		

	}
	
	
	
}