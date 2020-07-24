package net.DeeChael.SynC.Commands;

import java.io.File;
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

public class CommandsRegister implements CommandExecutor {

public CommandsRegister(Main main) {
		
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.register")) {
			if (s instanceof Player) {
				Player p = (Player) s;
				UUID uuid = p.getUniqueId();
				File playerfile = new File("plugins/SynC/playerdata", uuid + ".yml");
				FileConfiguration pfile = (FileConfiguration)YamlConfiguration.loadConfiguration(playerfile);
				String password = pfile.getString("data.password");
				if (password == null) {
					if (args.length == 0) {
						s.sendMessage(Config.msglogregtip);
					} else if (args.length == 1) {
						s.sendMessage(Config.msglogregtip);
					} else if (args.length == 2) {
						if (args[0].equals(args[1])) {
							if (args[0].length() < Config.pwmax && args[0].length() > Config.pwmin) {
								String enterpassword = args[0].toString();
					     		try {
					     			pfile.set("data.password", enterpassword);
									pfile.save(playerfile);
									pfile.load(playerfile);
								} catch (IOException e) {
									e.printStackTrace();
								} catch (InvalidConfigurationException e) {
									e.printStackTrace();
								}
					     		LoginManager.lm.add(p);
								s.sendMessage(Config.msglogregsuc);
								if (p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR)) {
									p.setAllowFlight(true);
								} else {
									p.setAllowFlight(false);
								}
							} else {
								s.sendMessage(Config.msglogerrlong.replace("%password_maxlimit%", String.valueOf(Config.pwmax)));
								s.sendMessage(Config.msglogerrshort.replace("%password_minlimit%", String.valueOf(Config.pwmin)));
							}
						} else {
							s.sendMessage(Config.msglogerrunsampw);
						}
					}
				} else if (password != null) {
					s.sendMessage(Config.msglogerrhvreg);
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
