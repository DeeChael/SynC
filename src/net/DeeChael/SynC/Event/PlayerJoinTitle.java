package net.DeeChael.SynC.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.DeeChael.SynC.Config;

public class PlayerJoinTitle implements Listener {

	@EventHandler
	public void sendPlayetJoinTitle(PlayerJoinEvent event){
    Player p = event.getPlayer();
    if (Config.allowjointitle == true) {
    	if (Config.subtitle == null) {
    		p.sendTitle(Config.title, null, 10, 70, 20);
    	} else if (Config.title == null) {
    		p.sendTitle(null, null, 0, 0, 0);
    	} else if (Config.title == null && Config.subtitle == null) {
    		p.sendTitle(null, null, 0, 0, 0);
    	} else {
    		p.sendTitle(Config.title, Config.subtitle, 10, 70, 20);
    	}
    } else {
    }
	}

}
