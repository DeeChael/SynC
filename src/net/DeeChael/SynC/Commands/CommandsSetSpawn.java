package net.DeeChael.SynC.Commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsSetSpawn implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsSetSpawn(Main main) {
	}
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s instanceof Player) {
			if (s.hasPermission("sync.setspawn")) {
				if (args.length == 0) {
					Player p = (Player) s;
					World w = p.getWorld();
					String wname = w.getName();
					Location setl = p.getLocation();
					w.setSpawnLocation(setl);
					Main.plugin.getConfig().set("World.SpawnWorld", wname);
					Main.plugin.saveConfig();
					Config.setSpawnReload();
					s.sendMessage(Config.msgsetspsuc);
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
