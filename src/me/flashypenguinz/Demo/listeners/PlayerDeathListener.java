package me.flashypenguinz.Demo.listeners;

import java.util.UUID;

import me.flashypenguinz.Demo.Demo;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

	private Demo demo;
	
	public PlayerDeathListener(Demo demo) {
		this.demo = demo;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		UUID uuid = event.getEntity().getUniqueId();
		int currentDeaths = demo.deaths.get(uuid);
		currentDeaths++;
		demo.deaths.put(uuid, currentDeaths);
	}
	
}
