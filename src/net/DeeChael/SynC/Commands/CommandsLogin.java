package net.DeeChael.SynC.Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;
import net.DeeChael.SynC.Manager.LoginManager;

public class CommandsLogin implements CommandExecutor {
	
public CommandsLogin(Main main) {
		
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.login")) {
			if (s instanceof Player) {
				Player p = (Player) s;
				if (!LoginManager.isLogin(p)) {
					if (args.length == 0) {
						s.sendMessage(Config.msgloglogtip);
					} else if (args.length == 1) {
						UUID uuid = p.getUniqueId();
						File playerfile = new File("plugins/SynC/playerdata", uuid + ".yml");
						FileConfiguration pfile = (FileConfiguration)YamlConfiguration.loadConfiguration(playerfile);
						try {
							pfile.save(playerfile);
							pfile.load(playerfile);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (InvalidConfigurationException e) {
							e.printStackTrace();
						}
						if (pfile.getString("data.password") == null) {
							s.sendMessage(Config.msglogerrunreg);
							s.sendMessage(Config.msglogregtip);
						} else {
							String password = pfile.getString("data.password").toString();
							String enterpassword = args[0].toString();
							 if (enterpassword.equals(password)) {
								LoginManager.lm.add(p);
								s.sendMessage(Config.msgloglogsuc);
								if (p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR)) {
									p.setAllowFlight(true);
								}  else {
									p.setAllowFlight(false);
								}	
							} else if(!enterpassword.equals(password)) {
								s.sendMessage(Config.msglogerrwronpw);
							} else {
								s.sendMessage("¡ìcUnknown Error");
							}
						}
					} else if (args.length >= 2) {
						s.sendMessage(Config.msgerrlong);
					} else {
						s.sendMessage("¡ìcUnknown Error");
					}
				} else {
					s.sendMessage(Config.msglogerrhvlog);
				}
			} else {
				s.sendMessage(Config.msgerrmstaplr);
			}
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		return false;
	}
}
