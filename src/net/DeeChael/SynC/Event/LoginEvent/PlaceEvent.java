package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class PlaceEvent implements Listener {
	@EventHandler
    public void Place(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (!LoginManager.isLogin(p)) {
            e.setCancelled(true);
        }
    }

}
