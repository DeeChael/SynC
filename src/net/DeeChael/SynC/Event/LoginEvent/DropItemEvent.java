package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class DropItemEvent implements Listener {
    @EventHandler
    public void DropItem(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
        if (!LoginManager.isLogin(p)) {
            e.setCancelled(true);
        }
    }

}
