package me.flashypenguinz.Demo.commands;

import me.flashypenguinz.Demo.Demo;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathsCommand implements CommandExecutor {

	private Demo demo;
	private boolean enabled;

	public DeathsCommand(Demo demo) {
		this.demo = demo;
		this.enabled = false;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (command.getLabel().equalsIgnoreCase("deaths")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "You must be a player to preform this command!");
				return false;
			}
			Player player = (Player) sender;
			if (args.length == 0) {
				if (!enabled) {
					sender.sendMessage(ChatColor.RED
							+ "This command is currently disabled!");
					return false;
				}
				player.sendMessage(ChatColor.GREEN + "You have "
						+ ChatColor.DARK_GREEN
						+ demo.deaths.get(player.getUniqueId())
						+ ChatColor.GREEN + " death(s)!");
				return true;
			} else {
				if(args.length != 1) {
					player.sendMessage(ChatColor.RED+"You have too many arguments! Proper Usage: /deaths (true/false)");
					return false;
				}
				boolean value = Boolean.valueOf(args[0]);
				this.enabled = value;
				if(value)
					player.sendMessage(ChatColor.GRAY+"/deaths is now "+ChatColor.GREEN+"enabled!");
				else
					player.sendMessage(ChatColor.GRAY+"/deaths is now "+ChatColor.RED+"disabled!");
			}
		}
		return false;
	}

}
