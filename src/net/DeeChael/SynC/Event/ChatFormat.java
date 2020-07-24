package net.DeeChael.SynC.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.API.ChatColor;

public class ChatFormat implements Listener {

	@EventHandler
	public void setChatFormat(AsyncPlayerChatEvent event){
    Player p = event.getPlayer();
    String playerdisplayname = p.getDisplayName();
    String playername = p.getName();
    String message = ChatColor.setChatColor(event.getMessage());
	event.setFormat(Config.chatformat.replace("%player_name%", playername).replace("%player_displayname%", playerdisplayname).replace("%message%", message));
	}
	
}
