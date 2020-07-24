package net.DeeChael.SynC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsGameMode implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsGameMode(Main main) {
    }

	@Override
        public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.gm")) {
		if (args.length == 0) {
			s.sendMessage(Config.msgerrwrncmd);
		} else if (args.length == 1) {
			if (s instanceof Player) {
			     Player p = (Player) s;
                 if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative")) { 
                     p.setGameMode(GameMode.CREATIVE);
                     p.sendMessage(Config.msggmsfct);
                     return true;
                 }else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure")) {
                     p.setGameMode(GameMode.ADVENTURE);
                     p.sendMessage(Config.msggmsfat);
                     return true;
                 }else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("w") || args[0].equalsIgnoreCase("l") || args[0].equalsIgnoreCase("spectator")) {
                     p.setGameMode(GameMode.SPECTATOR);
                     p.sendMessage(Config.msggmsfsp);
                     return true;
                 }else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival")) {
                     p.setGameMode(GameMode.SURVIVAL);
                     p.sendMessage(Config.msggmsfsr);
                     return true;
                 }else{
                 	s.sendMessage(Config.msggmerrwm);
                 	return true;
                 }
		} else {
			s.sendMessage(Config.msgerrmstaplr);
		} 

            }else if (args.length == 2) {
    			Player p = (Player) s;
                Player n = Bukkit.getPlayer(args[1]);
                if (n == null) {
                        s.sendMessage(Config.msgerroffplr);
                    return true;
                }else if(n != null){
                    if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative")) {
                        n.setGameMode(GameMode.CREATIVE);
                        n.sendMessage(Config.msggmsfct);
                        p.sendMessage(Config.msggmotct.replace("%player%", n.getName()));
                    }else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure")) {
                        n.setGameMode(GameMode.ADVENTURE);
                        n.sendMessage(Config.msggmsfat);
                        p.sendMessage(Config.msggmotat.replace("%player%", n.getName()));
                    }else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("w") || args[0].equalsIgnoreCase("l") || args[0].equalsIgnoreCase("spectator")) {
                        n.setGameMode(GameMode.SPECTATOR);
                        n.sendMessage(Config.msggmsfsp);
                        p.sendMessage(Config.msggmotsp.replace("%player%", n.getName()));
                    }else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival")) {
                        n.setGameMode(GameMode.SURVIVAL);
                        n.sendMessage(Config.msggmsfsr);
                    	p.sendMessage(Config.msggmotsr.replace("%player%", n.getName()));
                    }else{
                        s.sendMessage("§c请输入正确的游戏模式");
                    }
                }
            } else if (args.length >= 3) {
                    s.sendMessage(Config.msgerrlong);
                return true;
            }
	} else {
		s.sendMessage(Config.msgerrnoper);
	}
		return false;
  }
}
