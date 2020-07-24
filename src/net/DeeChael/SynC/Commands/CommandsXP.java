package net.DeeChael.SynC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.Main;

public class CommandsXP implements CommandExecutor {
	
	public Config cfg;
	
	public CommandsXP(Main main) {
	}

	@SuppressWarnings({ "deprecation" })
	@Override
    public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
		if (s.hasPermission("sync.xp")) {
			if (args.length == 0) {
				s.sendMessage(Config.msgerrwrncmd);
			} else if (args.length == 1) {
				s.sendMessage(Config.msgerrwrncmd);
			} else if (args.length == 2) {
				s.sendMessage(Config.msgkknoplr);
			} else if (args.length == 3) {
				OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(args[2]);
				if (offlineplayer.isOnline()) {
					Player player = offlineplayer.getPlayer();
					String playername = player.getName();
					String playerdisplayname = player.getDisplayName();
					if (args[0].equalsIgnoreCase("exp")) {
						if (args[1].equalsIgnoreCase("get")) {
							float exp = player.getExp();
							s.sendMessage(Config.msgxpgetexp.replace("%player_exp%", String.valueOf(Math.round(exp))).replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname));
						} else {
							s.sendMessage(Config.msgerrwrncmd);
						}
					} else if (args[0].equalsIgnoreCase("level")) {
						if (args[1].equalsIgnoreCase("get")) {
							int lv = player.getLevel();
							s.sendMessage(Config.msgxpgetexp.replace("%player_exp%", String.valueOf(lv)).replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname));
						} else {
							s.sendMessage(Config.msgerrwrncmd);
						}
					} else {
						s.sendMessage(Config.msgerrwrncmd);
					}
				} else {
					s.sendMessage(Config.msgerroffplr);
				}
			} else if (args.length == 4) {
				OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(args[2]);
				if (offlineplayer.isOnline()) {
					Player player = offlineplayer.getPlayer();
					if (args[0].equalsIgnoreCase("exp")) {
						if (args[1].equalsIgnoreCase("give")) {
							String playername = player.getName();
							String playerdisplayname = player.getDisplayName();
							int exp = Integer.parseInt(args[3]);
							player.giveExp(exp);
							s.sendMessage(Config.msgxpgivexp.replace("%give_exp%", String.valueOf(exp)).replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname));
						} else {
							s.sendMessage(Config.msgerrwrncmd);
						}
					} else if (args[0].equalsIgnoreCase("level")) {
						if (args[1].equalsIgnoreCase("give")) {
							String playername = player.getName();
							String playerdisplayname = player.getDisplayName();
							int lv = Integer.parseInt(args[3]);
							player.giveExpLevels(lv);
							s.sendMessage(Config.msgxpgivlv.replace("%give_level%", String.valueOf(lv)).replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname));
						} else if (args[1].equalsIgnoreCase("set")) {
							String playername = player.getName();
							String playerdisplayname = player.getDisplayName();
							int lv = Integer.parseInt(args[3]);
							player.setLevel(lv);
							s.sendMessage(Config.msgxpsetlv.replace("%set_level%", String.valueOf(lv)).replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname));
						} else if (args[1].equalsIgnoreCase("remove")) {
							String playername = player.getName();
							String playerdisplayname = player.getDisplayName();
							int lv = Integer.parseInt(args[3]);
							player.giveExpLevels(-lv);
							s.sendMessage(Config.msgxprmvlv.replace("%remove_level%", String.valueOf(lv)).replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname));
						} else {
							s.sendMessage(Config.msgerrwrncmd);
						}
					} else {
						s.sendMessage(Config.msgerrwrncmd);
					}
				} else {
					s.sendMessage(Config.msgerroffplr);
				}
			} else {
				s.sendMessage(Config.msgerrlong);
			}
		} else {
			s.sendMessage(Config.msgerrnoper);
		}
		return false;
	}

}
