package com.Swan.Korra.PKLight;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.projectkorra.projectkorra.util.ParticleEffect;

public class Light extends LightAbility{
	
	private Location location;

	public Light(Player player) {
		super(player);
		
	player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 30 * 20, 1));
	}

	public long getCooldown() {
		return 100 * 1000; //The cooldown is in milliseconds. So this changes it to 100 seconds instead of 0.1 seconds.
	}

	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "Light";
	}

	public boolean isExplosiveAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isHarmlessAbility() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isIgniteAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSneakAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public void progress() {
		// TODO Auto-generated method stub
		
		if (!bPlayer.canBendIgnoreBinds(this)){
			remove();
			return;
					
		}
		location = player.getLocation().clone().add(0, 1, 0);
		ParticleEffect.FIREWORKS_SPARK.display(location, 0, 0, 0, 0.15f, 50);
	}

}
