package com.Swan.Korra.PKLight;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.projectkorra.projectkorra.GeneralMethods;
import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.configuration.ConfigManager;
import com.projectkorra.projectkorra.util.DamageHandler;
import com.projectkorra.projectkorra.util.ParticleEffect;

public class LightCharge extends LightAbility{
	
	private long cooldown;
	private long chargeTime;
	private double range;
	private double damage;
	private double speed;
	
	private Location origin;
	private Location location;
	private Vector direction;
	private boolean charged;
	private boolean firing;
	
	public LightCharge(Player player) {
		super(player);
		
		if (!bPlayer.canBend(this)) {
			return;
		}
		
		setFields();
		start();
	}
	
	public void setFields() {
		this.cooldown = ConfigManager.getConfig().getLong("ExtraAbilities.Gareth Swan.LightCharge.Cooldown");
		this.chargeTime = ConfigManager.getConfig().getLong("ExtraAbilities.Gareth Swan.LightCharge.ChargeTime");
		this.range = ConfigManager.getConfig().getLong("ExtraAbilities.Gareth Swan.LightCharge.Range");
		this.damage = ConfigManager.getConfig().getLong("ExtraAbilities.Gareth Swan.LightCharge.Damage");
		this.speed = ConfigManager.getConfig().getLong("ExtraAbilities.Gareth Swan.LightCharge.Speed");
		
		this.origin = player.getLocation().clone().add(0, 1, 0);
		this.location = origin.clone();
		this.direction = origin.getDirection();
	}

	public long getCooldown() {
		// TODO Auto-generated method stub
		return cooldown;
	}

	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "LightCharge";
	}

	public boolean isExplosiveAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isHarmlessAbility() {
		// TODO Auto-generated method stub
		return false;
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
		
		if (!bPlayer.canBendIgnoreBindsCooldowns(this)){
			remove();
			return;
		}
		if (!charged){
			if(!player.isSneaking()){
				remove();
				return;
			}
			if (System.currentTimeMillis() - getStartTime() > chargeTime) {
				charged = true;
			}
		} else {
			if (player.isSneaking()) {
				ParticleEffect.INSTANT_SPELL.display(origin, 0.2F, 0.2F, 0.2F, 0, 10);
			} else {
				firing = true;
			}
		}
		
		if (firing) {
			location.add(direction.multiply(speed));
			if (origin.distance(location) > range) {
				remove();
				return;
			}
			ParticleEffect.FIREWORKS_SPARK.display(location, 0.5F, 0.5F, 0.5F, 0, 30);
			
		}
					
		for (Entity entity : GeneralMethods.getEntitiesAroundPoint(location, 3)) {
			if (entity instanceof LivingEntity && entity.getUniqueId() !=player.getUniqueId()) {
				DamageHandler.damageEntity(entity, damage, this);
				remove();
				return;
			}
		}
	}
	
	public String getVersion() {
		return "";
	}
	
	public void load() {
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new LightChargeListener(), ProjectKorra.plugin);
		
		ConfigManager.getConfig().addDefault("ExtraAbilities.Gareth Swan.LightCharge.Cooldown", 3200);
		ConfigManager.getConfig().addDefault("ExtraAbilities.Gareth Swan.LightCharge.ChargeTime", 2000);
		ConfigManager.getConfig().addDefault("ExtraAbilities.Gareth Swan.LightCharge.Range", 32);
		ConfigManager.getConfig().addDefault("ExtraAbilities.Gareth Swan.LightCharge.Damage", 8);
		ConfigManager.getConfig().addDefault("ExtraAbilities.Gareth Swan.LightCharge.Speed", 1);
		ConfigManager.defaultConfig.save();
		
	}
	
	public String getAuthor() {
		return "Gareth Swan";
	}
	
	public void stop() {
		
	}

}
