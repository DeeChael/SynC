package net.DeeChael.SynC.Commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsBanIP implements CommandExecutor {
	
	public CommandsBanIP(Main main) {

	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.ban")) {
			if (args.length == 0) {
				s.sendMessage(Config.msgkknoplr);
			} else if (args.length == 1) {
				Player banplayer = Bukkit.getPlayer(args[0]) ;
				if (banplayer != null) {
	        		String playerip = banplayer.getAddress().toString();
	        		Bukkit.banIP(playerip);
	        		Bukkit.getBanList(BanList.Type.IP).addBan(playerip, "δ֪", null, null);
	        		banplayer.kickPlayer(Config.msgkkurkk + "\n" + Config.msgkkkkresn.replace("%kick_reason%", "δ֪"));
	        		s.sendMessage(Config.msgbanotherban.replace("%ban_player%", banplayer.getPlayer().getDisplayName()));
				} else {
					s.sendMessage(Config.msgerroffplr);
				}
			} else if (args.length >= 2) {
				Player banplayer = Bukkit.getPlayer(args[0]) ;
				if (banplayer != null) {
	        		String playerip = banplayer.getAddress().toString();
	    			String banreason = net.DeeChael.SynC.API.ChatColor.setChatColor(args[1]);
	    			Bukkit.banIP(playerip);
	        		Bukkit.getBanList(BanList.Type.IP).addBan(playerip, banreason, null, null);
	        		banplayer.kickPlayer(Config.msgkkurkk + "\n" + Config.msgkkkkresn.replace("%kick_reason%", banreason));
	        		s.sendMessage(Config.msgbanotherban.replace("%ban_player%", banplayer.getPlayer().getDisplayName()));
				} else {
					s.sendMessage(Config.msgerroffplr);
				}
			} else if (args.length >= 3) {
				s.sendMessage("��cUnknown Error");
			}
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		
		return false;
	}

}
