package net.DeeChael.SynC.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.DeeChael.SynC.Config;

public class PlayerJoinMessage implements Listener {

	@EventHandler
	public void setPlayerJoinMessage(PlayerJoinEvent event){
    Player p = event.getPlayer();
    String playername = p.getName();
    String playerdisplayname = p.getDisplayName();
    event.setJoinMessage(Config.join.replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname));
	}

}
