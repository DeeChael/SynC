package net.DeeChael.SynC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsSpawn implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsSpawn(Main main) {
	}
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s instanceof Player) {
			if (s.hasPermission("sync.spawn")) {
				if (args.length == 0) {
					Player p = (Player) s;
					World w = Bukkit.getWorld(Config.spawnworld);
					Location l = w.getSpawnLocation();
					p.teleport(l);
				}else {
					s.sendMessage(Config.msgerrwrncmd);
				}
				}
		} else {
			s.sendMessage(Config.msgerrmstaplr);
			return true;
		}
		

		return false;
	}
}
