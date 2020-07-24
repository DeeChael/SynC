package net.DeeChael.SynC.Event.LoginEvent;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.DeeChael.SynC.Config;

public class JoinAndNotLoginOrRegister  implements Listener {
	
	@EventHandler
    public void Main(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		UUID uuid = p.getUniqueId();
		File playerfile = new File("plugins/SynC/playerdata", uuid + ".yml");
		FileConfiguration pfile = (FileConfiguration)YamlConfiguration.loadConfiguration(playerfile);
		String password = pfile.getString("data.password");
		if (password == null) {
			p.setAllowFlight(true);
			p.sendMessage(Config.msglogregtip);
		} else {
			p.setAllowFlight(true);
	        p.sendMessage(Config.msgloglogtip);
		}
    }

}
