package net.DeeChael.SynC.Commands;

import java.io.File;
import java.io.IOException;
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
import net.DeeChael.SynC.API.NameTag;

public class CommandsUnnick implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsUnnick(Main main) {

	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		
		if(args.length == 0) {
			if (s.hasPermission("sync.nick")) {
			if (s instanceof Player) {
				Player p = (Player) s;
				UUID playeruuid = p.getUniqueId();
				File playerfile = new File("plugins/SynC/playerdata", playeruuid + ".yml");
				FileConfiguration pfile = (FileConfiguration)YamlConfiguration.loadConfiguration(playerfile);
				String realname = (String) pfile.get("data.Name");
				String displayname = (String) pfile.get("data.NickName");
				
				if (displayname.equalsIgnoreCase(realname)) {
					p.sendMessage(Config.msgnkerrnonk);
					return true;
				} else {
					try {
						pfile.set("data.NickName", realname);
						pfile.save(playerfile);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.setDisplayName(realname);
					p.setPlayerListName(realname);
					NameTag.changeName(realname, p);
					p.sendMessage(Config.msgnksfsucunnk);
					return true;
				}
			} else {
				s.sendMessage(Config.msgerrmstaplr);
			}
				
			} else {
				s.sendMessage(Config.msgerrmstaplr);
			}
		} else if(args.length == 1) {
			if (s.hasPermission("sync.nickadmin")) {
				Player unnickp = Bukkit.getPlayer(args[0]);
				if (unnickp == null){
                    s.sendMessage(Config.msgerroffplr);
                    return true;
				}else {
					UUID playeruuid = unnickp.getUniqueId();
					File playerfile = new File("plugins/SynC/playerdata", playeruuid + ".yml");
					FileConfiguration pfile = (FileConfiguration)YamlConfiguration.loadConfiguration(playerfile);
					String realname = (String) pfile.get("data.Name");
					String displayname = (String) pfile.get("data.NickName");
					if (displayname.equalsIgnoreCase(realname)) {
						s.sendMessage(Config.msgnkerrotnonk.replace("%player%", realname));
						return true;
					} else {
						try {
    						pfile.set("data.NickName", realname);
							pfile.save(playerfile);
						} catch (IOException e) {
							e.printStackTrace();
						}
						unnickp.setDisplayName(realname);
						unnickp.setPlayerListName(realname);
						NameTag.changeName(realname, unnickp);				
						s.sendMessage(Config.msgnkotsucunnk.replace("%player%", displayname).replace("%realplayer%", realname));
						return true;
					}
				}
			}else {
				s.sendMessage(Config.msgerrnoper);
			}
		} else if(args.length >= 2) {
			s.sendMessage(Config.msgerrwrncmd);
		}
		return false;
	}

}
