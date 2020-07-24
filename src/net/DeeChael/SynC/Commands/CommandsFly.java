package net.DeeChael.SynC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsFly implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsFly(Main main) {
	}

	@Override
    public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.fly")) {
			if (s instanceof Player) {
				if (args.length == 0) {
					Player p = (Player) s;
					boolean fly = p.getAllowFlight();
				    if (fly == true) {
				    	p.setAllowFlight(false);
				    	p.setFlying(false);
				    	s.sendMessage(Config.msgflyslfdis);
				    	return true;
				    } else {
				    	p.setAllowFlight(true);
				    	p.setFlying(true);
				    	s.sendMessage(Config.msgflyslfen);
				    	return true;
				    }
				} else if (args.length == 1) {
					if (s.hasPermission("sync.flyadmin")) {
						Player p = Bukkit.getPlayer(args[0]);
						if (p != null) {
							boolean fly = p.getAllowFlight();
						    if (fly == true) {
						    	p.setAllowFlight(false);
						    	p.setFlying(false);
						    	p.sendMessage(Config.msgflyslfdis);
						    	s.sendMessage(Config.msgflyothdis.replace("%player%", p.getName()));
						    	return true;
						    } else {
						    	p.setAllowFlight(true);
						    	p.setFlying(true);
						    	p.sendMessage(Config.msgflyslfen);
						    	s.sendMessage(Config.msgflyothen.replace("%player%", p.getName()));
						    	return true;
						    }
						} else {
							s.sendMessage(Config.msgerroffplr);
						}
					} else {
						s.sendMessage(Config.msgerrnoper);
					}
				} else {
					s.sendMessage(Config.msgerrlong);
				}
			} else {
				if (args.length == 0) {
					s.sendMessage(Config.msgerrmstaplr);
				} else if (args.length == 1) {
					Player p = Bukkit.getPlayer(args[0]);
					if (p != null) {
						boolean fly = p.getAllowFlight();
					    if (fly == true) {
					    	p.setAllowFlight(false);
					    	p.setFlying(false);
					    	p.sendMessage(Config.msgflyslfdis);
					    	s.sendMessage(Config.msgflyothdis.replace("%player%", p.getName()));
					    	return true;
					    } else {
					    	p.setAllowFlight(true);
					    	p.setFlying(true);
					    	p.sendMessage(Config.msgflyslfen);
					    	s.sendMessage(Config.msgflyothen.replace("%player%", p.getName()));
					    	return true;
					    }
					} else {
						s.sendMessage(Config.msgerroffplr);
					}
				} else {
					s.sendMessage(Config.msgerrlong);
				}
			}
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		return false;
	}

}
