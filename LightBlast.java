// ProjectKorra Light is an addition to add new abilities and a new Element to the game! I do not claim ownership of ProjectKorra Core or any other parts
// ProjectKorra Light was created by Gareth_Swan

package com.Swan.Korra.PKLight;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.projectkorra.projectkorra.GeneralMethods;
import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.util.DamageHandler;
import com.projectkorra.projectkorra.util.ParticleEffect;

public class LightBlast extends LightAbility {
	
	private static double moveSpeed = 0.9;
	private static double collisionRadius = 1.6;
	private static double damage = 6;
	private static int range = 25;
	
	private Location location;
	private Location startLocation;
	
	public LightBlast(Player player) {
		super(player);
		if (!bPlayer.canBend(this)) {
			return;
		}
		location = player.getEyeLocation().clone();
		startLocation = player.getEyeLocation().clone();
		
		bPlayer.addCooldown(this);
		
		start();
		
	}

	public long getCooldown() {
		// TODO Auto-generated method stub
		return 1500L;
	}

	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "LightBlast";
	}

	public boolean isHarmlessAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSneakAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public void progress() {
		if (!bPlayer.canBendIgnoreCooldowns(this)){
			remove();
			return;
		}
		
		if (startLocation.distanceSquared(location) > range * range) {
			remove();
			return;
		}
		if (GeneralMethods.isSolid(location.getBlock())){
			remove();
			return;
		}
		
		location.add(this.location.getDirection().clone().normalize()
				.multiply(moveSpeed));
		ParticleEffect.SPELL.display(0, 0,0,1,20,location,128);
						
		for (Entity entity : GeneralMethods.getEntitiesAroundPoint(location,
				collisionRadius)) {
			if (entity instanceof Entity) {
				DamageHandler.damageEntity(entity, player, damage, this);
				
			}
			
			remove();
			return;
		}
		// TODO Auto-generated method stub
		
	}

	public String getAuthor() {
		// TODO Auto-generated method stub
		return "Gareth Swan";
	}

	public String getVersion() {
		// TODO Auto-generated method stub
		return "1.0";
	}

	public void load() {
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new LightBlastListener(), ProjectKorra.plugin);
		// TODO Auto-generated method stub
		
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getDescription() {
		return "An ability allowing the Lightbender to fire a blast of Light at their opponents, badly damaging them!"
				;
	}

	public boolean isExplosiveAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isIgniteAbility() {
		// TODO Auto-generated method stub
		return false;
	}

}
