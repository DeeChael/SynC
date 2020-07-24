package net.DeeChael.SynC.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import net.DeeChael.SynC.Config;

public class PlayerKickMessage implements Listener {

	@EventHandler
	public void setPlayerJoinMessage(PlayerKickEvent event){
    Player p = event.getPlayer();
    String playername = p.getName();
    String playerdisplayname = p.getDisplayName();
    event.setLeaveMessage(Config.kick.replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname));
	}



}
