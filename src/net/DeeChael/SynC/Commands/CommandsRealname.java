package net.DeeChael.SynC.Commands;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsRealname implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsRealname(Main main) {

	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
	
		if (s.hasPermission("sync.nickadmin")) {
			
			if (args.length == 0) {
				s.sendMessage(Config.msgnkerrunnotxt);
			} else if (args.length == 1) {
				Player realplayer = Bukkit.getPlayer(args[0]);
				if (realplayer == null) {
					s.sendMessage(Config.msgerroffplr);
				} else {
					UUID playeruuid = realplayer.getUniqueId();
					File playerfile = new File("plugins/SynC/playerdata", playeruuid + ".yml");
					FileConfiguration pfile = (FileConfiguration)YamlConfiguration.loadConfiguration(playerfile);
					String realname = (String) pfile.get("data.Name");
					String displayname = (String) pfile.get("data.NickName");
					if (displayname.equalsIgnoreCase(realname)) {
						s.sendMessage(Config.msgnkerrotnonk.replace("%player%", realname));
					} else {
						s.sendMessage(Config.msgnkotsucrlnm.replace("%player%", displayname).replace("%realplayer%", realname));
					}
				}
			} else if (args.length >= 2) {
				s.sendMessage(Config.msgerrwrnplrnm);
			}	
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		return false;
	}

}
