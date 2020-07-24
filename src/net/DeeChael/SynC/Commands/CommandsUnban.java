package net.DeeChael.SynC.Commands;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsUnban implements CommandExecutor {
	
	public CommandsUnban(Main main) {

	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.ban")) {
			if (args.length == 0) {
				s.sendMessage(Config.msgkknoplr);
			} else if (args.length == 1) {
				String unbanname = Bukkit.getOfflinePlayer(args[0]).getName();
				if (Bukkit.getOfflinePlayer(args[0]).isBanned()) {
					String unbanmsg = Config.msgbanunban.replace("&", "¡ì").replace("%unban%", unbanname);
					Bukkit.getBanList(Type.NAME).pardon(unbanname);
					s.sendMessage(unbanmsg);
				} else {
					s.sendMessage(Config.msgbannoban);
				}
			}
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		
		
		return false;
	}

}
