// ProjectKorra Light is an addition to add new abilities and a new Element to the game! I do not claim ownership of ProjectKorra Core or any other parts
// ProjectKorra Light was created by Gareth_Swan

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
		// TODO Auto-generated method stub
		return 100 * 1000;
	}

	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "Light";
	}
	
	public String getDescription() {
		return "An ability granting the Lightbender temporary Nightvision!";
	}
	
	public String getInstructions() {
		return "Left click";
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