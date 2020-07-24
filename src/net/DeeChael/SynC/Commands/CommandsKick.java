package net.DeeChael.SynC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsKick implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsKick(Main main) {

	}

	//我有一个独立作品叫JustKick
	//原本是想用数据包crash玩家客户端的
	//后来歪打正着做出了一个KICK
	//然后就直接搬到SynC里面了
	//所以玩家变量是crash
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("kick")) {
        	if (s.hasPermission("sync.kick")) {
        	if (s instanceof Player) {
        		Player kickadmin = (Player) s;
        		if (args.length == 0) {
            		s.sendMessage(Config.msgkknoplr);
            		return true;
            	} else if (args.length == 1) {
            		Player crash = Bukkit.getPlayer(args[0]) ;
            		if (crash != null) {
            		crash.kickPlayer(Config.msgkkurkk + "\n" + Config.msgkkkkresn.replace("%kick_reason%", "未知"));
            		kickadmin.sendMessage(Config.msgkksbikk.replace("%kick_player%", crash.getPlayer().getDisplayName()));
            		return true;
            		} else if (crash == null) {
            			s.sendMessage(Config.msgerroffplr);
            			return true;
            		} 
            	} else if (args.length == 2) {
             		Player crash = Bukkit.getPlayer(args[0]) ;
        			String kickreason = net.DeeChael.SynC.API.ChatColor.setChatColor(args[1]);
            		if (crash != null) {
            			crash.kickPlayer(Config.msgkkurkk + "\n" + Config.msgkkkkresn.replace("%kick_reason%", kickreason));
            			kickadmin.sendMessage(Config.msgkksbikk.replace("%kick_player%", crash.getPlayer().getDisplayName()));
                		return true;
            		} else if (crash == null) {
            			s.sendMessage(Config.msgerroffplr);
            			return true;
            		} 
            	} else {
            		s.sendMessage("§cUnknown Error");
            	}
        	} else {
        		if (args.length == 0) {
            		s.sendMessage(Config.msgkknoplr);
            		return true;
            	} else if (args.length == 1) {
            		Player crash = Bukkit.getPlayer(args[0]) ;
            		if (crash != null) {
            		crash.kickPlayer(Config.msgkkurkk + "\n" + Config.msgkkkkresn.replace("%kick_reason%", "未知"));
            		s.sendMessage(Config.msgkksbikk.replace("%kick_player%", crash.getPlayer().getDisplayName()));
            		return true;
            		} else if (crash == null) {
            			s.sendMessage(Config.msgerroffplr);
            			return true;
            		} 
            	} else if (args.length == 2) {
             		Player crash = Bukkit.getPlayer(args[0]) ;
        			String kickreason = net.DeeChael.SynC.API.ChatColor.setChatColor(args[1]);
            		if (crash != null) {
            			crash.kickPlayer(Config.msgkkurkk + "\n" + Config.msgkkkkresn.replace("%kick_reason%", kickreason));
                		s.sendMessage(Config.msgkksbikk.replace("%kick_player%", crash.getPlayer().getDisplayName()));
                		return true;
            		} else if (crash == null) {
            			s.sendMessage(Config.msgerroffplr);
            			return true;
            		} 
            	} else {
            		s.sendMessage("§cUnknown Error");
            	}
        	}
        		
        		
        } else {
        	s.sendMessage(Config.msgerrnoper);
        }
        }
		return false;
	}
}
