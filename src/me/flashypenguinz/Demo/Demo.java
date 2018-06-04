package me.flashypenguinz.Demo;

import java.util.HashMap;
import java.util.UUID;

import me.flashypenguinz.Demo.commands.DeathsCommand;
import me.flashypenguinz.Demo.commands.ParticleCommand;
import me.flashypenguinz.Demo.listeners.PlayerDeathListener;
import me.flashypenguinz.Demo.listeners.PlayerJoinListener;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Demo extends JavaPlugin {

	public HashMap<UUID, Integer> deaths = new HashMap<UUID, Integer>();
	
	@Override
	public void onEnable() {
		setupConfig();
		registerListeners();
		registerCommands();
	}
	
	private void registerCommands() {
		getCommand("particle").setExecutor(new ParticleCommand(this));
		getCommand("deaths").setExecutor(new DeathsCommand(this));
	}
	
	private void registerListeners() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerJoinListener(this), this);
		pm.registerEvents(new PlayerDeathListener(this), this);
	}
	
	private void setupConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
}
