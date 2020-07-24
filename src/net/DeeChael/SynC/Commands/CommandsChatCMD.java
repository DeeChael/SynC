package net.DeeChael.SynC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsChatCMD implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsChatCMD(Main main) {
	}

	@SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.letchat")) {
			if (args.length == 0) {
				s.sendMessage(Config.msgkknoplr);
			} else if (args.length == 1) {
				OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(args[0]);
				if (offlineplayer.isOnline()) {
					s.sendMessage(Config.msgchatplzentcmd);
				} else {
					s.sendMessage(Config.msgerroffplr);
				}
			} else if (args.length >= 2) {
				OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(args[0]);
				if (offlineplayer.isOnline()) {
					Player player = offlineplayer.getPlayer();
					StringBuilder sb = new StringBuilder();
        			for(int i = 1; i < args.length; ++i) {
        			     sb.append(args[i]).append(' ');
        			}
        			String command = net.DeeChael.SynC.API.ChatColor.setChatColor(sb.toString());
        			player.performCommand(command);
				} else {
					s.sendMessage(Config.msgerroffplr);
				}
			}
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		return false;
	}


}
