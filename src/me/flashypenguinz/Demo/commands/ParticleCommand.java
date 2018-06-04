package me.flashypenguinz.Demo.commands;

import java.util.UUID;

import me.flashypenguinz.Demo.Demo;
import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ParticleCommand implements CommandExecutor {

	private Demo demo;

	public ParticleCommand(Demo demo) {
		this.demo = demo;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (command.getLabel().equalsIgnoreCase("particle")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "You must be a player to preform this command!");
				return false;
			}
			if (!demo.getConfig().getBoolean("particle")) {
				sender.sendMessage(ChatColor.RED
						+ "This command is currently disabled!");
				return false;
			}
			Player player = (Player) sender;
			if(!player.getUniqueId().equals(UUID.fromString("3bc839ad745d4a9d8a7c0b3ddbe44482"))) {
				player.sendMessage(ChatColor.RED+"Your UUID doesn't match the expected UUID!");
				return false;
			}
			player.sendMessage(ChatColor.GREEN+"Played particles in a circle!");
			Location loc = player.getLocation();

			int particles = 10;
			float r = 5;
			for (int i = 0; i < particles; i++) {
			    double angle = 2 * Math.PI * i / particles;
			    Location point = loc.clone().add(r * Math.cos(angle), 0.0d, r * Math.sin(angle));
			    
			    PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
						EnumParticle.EXPLOSION_LARGE, true, (float) point.getX(),
						(float) point.getY(), (float) point.getZ(), 0.5f, 0.5f, 0.5f, 1f, 1, null);
				((CraftPlayer) player).getHandle().playerConnection
						.sendPacket(packet);
			}
		}
		return false;
	}

}
