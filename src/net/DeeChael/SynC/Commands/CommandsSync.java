package net.DeeChael.SynC.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsSync implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsSync(Main main) {
	}

	@Override
    public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.sync")) {
			if (args.length == 0) {
				s.sendMessage(Config.msgsyncerr0length);
				return true;
			} else if(args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					Config.reloadAllConfig();
					s.sendMessage(Config.msgsyncreload);
					return true;
				}else if (args[0].equalsIgnoreCase("help")) {
					int listcount = Config.helpmsgS.size();
				    for (int toolnumber = 0; toolnumber < listcount;toolnumber = toolnumber + 1) {
				    	String helpmessage = Config.helpmsgS.get(toolnumber);
				    	s.sendMessage(helpmessage.replace("&", "¡ì"));
				    }
					return true;
				} else {
					s.sendMessage(Config.msgsyncerr0length);
					return true;
				}
			}else if (args.length >= 2) {
				s.sendMessage(Config.msgerrlong);
				return true;
			}
		}else {
			s.sendMessage(Config.msgerrnoper);	
			return true;
		}
		
		return false;
	}

}
