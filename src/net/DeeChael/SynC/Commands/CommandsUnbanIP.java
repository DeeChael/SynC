package net.DeeChael.SynC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.BanList.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsUnbanIP implements CommandExecutor {
	
	public CommandsUnbanIP(Main main) {

	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.ban")) {
			if (args.length == 0) {
				s.sendMessage(Config.msgkknoplr);
			} else if (args.length == 1) {
				String pip = args[0];
				String unbanmsg = Config.msgbanunban.replace("&", "¡ì").replace("%unban%", pip);
				Bukkit.unbanIP(pip);
				Bukkit.getBanList(Type.IP).pardon(pip);
				s.sendMessage(unbanmsg);
			}
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		
		
		return false;
	}

}
