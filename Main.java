// ProjectKorra Light is an addition to add new abilities and a new Element to the game! I do not claim ownership of ProjectKorra Core or any other parts
// ProjectKorra Light was created by Gareth_Swan

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

	public static Element Light;
		public void onEnable() {
		
		Light = new Element("Light", ElementType.BENDING, this);
		
		
		FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		ConfigManager.languageConfig.get().addDefault("Chat.Colors.Light", "WHITE");
		ConfigManager.languageConfig.get().addDefault("Chat.Prefixes.Light", "[Light]");
		ConfigManager.languageConfig.save();
		saveConfig();
		
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new LightListener(), ProjectKorra.plugin);
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new LightBlastListener(), ProjectKorra.plugin);
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new TestBeamListener(), ProjectKorra.plugin);
		CoreAbility.registerPluginAbilities(this, "com.Swan.Korra.PKLight");
		

	}
		public void onDisable() {
			ProjectKorra.log.info("ProjectKorraLight by Gareth Swan has been disabled");
		}
	
	
	
}