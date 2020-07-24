package net.DeeChael.SynC.Commands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;
import net.DeeChael.SynC.API.NameTag;

public class CommandsNick implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsNick(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s instanceof Player) {
			if (s.hasPermission("sync.nick")) {
				Player nickplayer = (Player) s;
				if (args.length == 0) {
					s.sendMessage(Config.msgnkerrnotxt);
					return true;
				} else if (args.length == 1) {
					UUID playeruuid = nickplayer.getUniqueId();
					String nickname = args[0];
					String realname = nickplayer.getName();
					if (nickname.length() >= 16) {
						s.sendMessage(Config.msgnkerrlong16);
						return true;
					} else {
						File playerfile = new File("plugins/SynC/playerdata", playeruuid + ".yml");
						FileConfiguration pfile = (FileConfiguration)YamlConfiguration.loadConfiguration(playerfile);  
    						try {
    							pfile.set("data.Name", realname);
        						pfile.set("data.NickName", nickname);
								pfile.save(playerfile);
							} catch (IOException e) {
								e.printStackTrace();
							}
						nickplayer.setDisplayName(nickname);
						nickplayer.setPlayerListName(nickname);
						NameTag.changeName(nickname, nickplayer);
						nickplayer.sendMessage(Config.msgnksfsucnk.replace("%nickname%", nickname));
						return true;
					}
				} else if (args.length >= 2) {
					s.sendMessage(Config.msgnkerrhvspc);
					return true;
				}
			} else {
				s.sendMessage(Config.msgerrnoper);
			}
		} else {
			s.sendMessage(Config.msgerrmstaplr);
			return true;
		}
		

		return false;
	}
}
