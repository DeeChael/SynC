package net.DeeChael.SynC.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;
import net.DeeChael.SynC.GUI.GUImenu;

public class CommandsMenu implements CommandExecutor {
	
	public CommandsMenu(Main main) {
		
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.gui.menu")) {
			if (s instanceof Player) {
				if (args.length == 0) {
					Player p = (Player) s;
					p.closeInventory();
					p.openInventory(GUImenu.defmenu);
				} else {
					s.sendMessage(Config.msgerrlong);
				}
			} else {
				s.sendMessage(Config.msgerrmstaplr);
			}
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		return false;
	}
	
}
