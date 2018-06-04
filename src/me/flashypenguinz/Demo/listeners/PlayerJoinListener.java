package me.flashypenguinz.Demo.listeners;

import me.flashypenguinz.Demo.Demo;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

	private Demo demo;
	
	public PlayerJoinListener(Demo demo) {
		this.demo = demo;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		demo.deaths.put(event.getPlayer().getUniqueId(), 0);
	}
	
}
