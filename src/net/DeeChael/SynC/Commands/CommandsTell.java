package net.DeeChael.SynC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsTell implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsTell(Main main) {
	}

	@Override
    public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (cmd.getName().equalsIgnoreCase("tell")) {
                if (!p.hasPermission("sync.chat")) {
                	s.sendMessage(Config.msgerrnoper);
                	return true;
                } else if (p.hasPermission("sync.chat")) {
                	if (args.length == 0) {
                		s.sendMessage(Config.msgtlnoplrnotxt);
                	return true;
                	} else if (args.length == 1) {
                		Player toplayer = Bukkit.getPlayer(args[0]);
                		if (toplayer == null) {
                			s.sendMessage(Config.msgerroffplr);
                			return true;
                		} else if (toplayer != null) {
                			s.sendMessage(Config.msgtlnotxt);
                    		return true;
                		}
                	} else if(args.length >= 2) {
                		Player toplayer = Bukkit.getPlayer(args[0]);            		
                		if (toplayer == null) {
                			s.sendMessage(Config.msgerroffplr);
                			return true;
                		} else if (toplayer != null) {
                			StringBuilder sb = new StringBuilder();
                			for(int i = 1; i < args.length; ++i) {
                			     sb.append(args[i]).append(' ');
                			}
                			String message = net.DeeChael.SynC.API.ChatColor.setChatColor(sb.toString());
                			p.sendMessage("¡ìdTo " + ChatColor.GRAY + toplayer.getDisplayName() + " ¡ìd>>> ¡ì7" + message);
            				toplayer.sendMessage("¡ìdFrom " + ChatColor.GRAY + p.getDisplayName() + " ¡ìd>>> ¡ì7" + message);
                			return true;	
                		}
                	} else {
            			s.sendMessage(Config.msgerrlong);
            			return true;
                        }
                  }
                }   
              }else {
            	  s.sendMessage(Config.msgerrmstaplr);
                  return true;
              }
		return false;
	}


}
