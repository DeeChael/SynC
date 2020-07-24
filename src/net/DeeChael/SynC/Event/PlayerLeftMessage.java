package net.DeeChael.SynC.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.DeeChael.SynC.Config;

public class PlayerLeftMessage implements Listener {

	@EventHandler
	public void setPlayerJoinMessage(PlayerQuitEvent event){
    Player p = event.getPlayer();
    String playername = p.getName();
    String playerdisplayname = p.getDisplayName();
    event.setQuitMessage(Config.left.replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname));
	}


}
