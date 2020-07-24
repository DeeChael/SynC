package net.DeeChael.SynC.Commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsBan implements CommandExecutor {
	
	public CommandsBan(Main main) {

	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.ban")) {
			if (s instanceof Player) {
				Player banadmin = (Player) s;
				if (args.length == 0) {
					s.sendMessage(Config.msgkknoplr);
				} else if (args.length == 1) {
					OfflinePlayer banplayer = Bukkit.getOfflinePlayer(args[0]) ;
					String banname = banplayer.getName();
	        		Bukkit.getBanList(BanList.Type.NAME).addBan(banname, "未知", null, null);
	        		banadmin.sendMessage(Config.msgbanotherban.replace("%ban_player%", banplayer.getName()));
	        		if (Bukkit.getOfflinePlayer(args[0]).isOnline()) {
						Bukkit.getPlayer(args[0]).kickPlayer(Config.msgbanurban + "\n" + Config.msgkkkkresn.replace("%kick_reason%", "§7未知"));
					}
				} else if (args.length == 2) {
					OfflinePlayer banplayer = Bukkit.getOfflinePlayer(args[0]) ;
					String banname = banplayer.getName();
	    			String banreason = net.DeeChael.SynC.API.ChatColor.setChatColor(args[1]);
	        		Bukkit.getBanList(BanList.Type.NAME).addBan(banname, banreason, null, null);
	        		banadmin.sendMessage(Config.msgbanotherban.replace("%ban_player%", banplayer.getName()));
	        		if (Bukkit.getOfflinePlayer(args[0]).isOnline()) {
						Bukkit.getPlayer(args[0]).kickPlayer(Config.msgbanurban + "\n" + Config.msgkkkkresn.replace("%kick_reason%", banreason));
					}
				} else if (args.length >= 3) {
					s.sendMessage("§cUnknown Error");
				}
			} else {
				if (args.length == 0) {
					s.sendMessage(Config.msgkknoplr);
				} else if (args.length == 1) {
					String banplayer = Bukkit.getOfflinePlayer(args[0]).getName() ;
	        		Bukkit.getBanList(BanList.Type.NAME).addBan(banplayer, "未知", null, null);
	        		s.sendMessage(Config.msgbanotherban.replace("%ban_player%", Bukkit.getOfflinePlayer(args[0]).getName()));
	        		if (Bukkit.getOfflinePlayer(args[0]).isOnline()) {
						Bukkit.getPlayer(args[0]).kickPlayer(Config.msgbanurban + "\n" + Config.msgkkkkresn.replace("%kick_reason%", "§7未知"));
					}
				} else if (args.length == 2) {
					String banplayer = Bukkit.getOfflinePlayer(args[0]).getName() ;
	    			String banreason = net.DeeChael.SynC.API.ChatColor.setChatColor(args[1]);
	        		Bukkit.getBanList(BanList.Type.NAME).addBan(banplayer, banreason, null, null);
	        		s.sendMessage(Config.msgbanotherban.replace("%ban_player%", Bukkit.getOfflinePlayer(args[0]).getName()));
				if (Bukkit.getOfflinePlayer(args[0]).isOnline()) {
					Bukkit.getPlayer(args[0]).kickPlayer(Config.msgbanurban + "\n" + Config.msgkkkkresn.replace("%kick_reason%", banreason));
				}
				
				} else if (args.length >= 3) {
					s.sendMessage("§cUnknown Error");
				}
			}
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		
		return false;
	}

}
