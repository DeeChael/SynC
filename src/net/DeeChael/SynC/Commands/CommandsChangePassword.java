package net.DeeChael.SynC.Commands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

public class CommandsChangePassword implements CommandExecutor {

public CommandsChangePassword(Main main) {
		
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.changepassword")) {
			if (s instanceof Player) {
				Player p = (Player) s;
				UUID uuid = p.getUniqueId();
				File playerfile = new File("plugins/SynC/playerdata", uuid + ".yml");
				FileConfiguration pfile = (FileConfiguration)YamlConfiguration.loadConfiguration(playerfile);
				String password = pfile.getString("data.password").toString();
				 if (LoginManager.isLogin(p)) {
					 if (args.length == 0) {
						 s.sendMessage(Config.msglogpwctip);
					 } else if (args.length == 1) {
						 s.sendMessage(Config.msglogpwctip);
					 } else if (args.length == 2) {
						 s.sendMessage(Config.msglogpwctip);
					 } else if (args.length == 3) {
						 String oldpassword = args[0].toString();
						 String newpassword = args[1].toString();
						 String confirmnewpassword = args[2].toString();
						 if (oldpassword.equals(password)) {
							  if (!oldpassword.equals(newpassword)) {
								  if (newpassword.equals(confirmnewpassword)) {
									  s.sendMessage(Config.msglogpwcsuc);
									  try {
							     			pfile.set("data.password", newpassword);
											pfile.save(playerfile);
											pfile.load(playerfile);
										} catch (IOException e) {
											e.printStackTrace();
										} catch (InvalidConfigurationException e) {
											e.printStackTrace();
										}
								  } else {
									  s.sendMessage(Config.msglogerrunsampw);
								  }
							  } else {
								  s.sendMessage(Config.msglogerrcntsame);
							  }
						 } else {
							 s.sendMessage(Config.msglogerrwronpw);
						 }
					 } else if (args.length >= 4) {
						 s.sendMessage(Config.msglogpwctip);
					 } else {
						 s.sendMessage("¡ìcUnknown Error");
					 }
				 } else {
					 if (password == null) {
						 s.sendMessage(Config.msglogerrunreg);
						 s.sendMessage(Config.msglogregtip);
					 } else {
						 s.sendMessage(Config.msglogerrunlog);
						 s.sendMessage(Config.msgloglogtip);
					 }
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
