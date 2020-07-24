package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupArrowEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class PickupArrowEvent implements Listener {
	@EventHandler
	@SuppressWarnings("deprecation")
    public void PickupArrow(PlayerPickupArrowEvent e) {
		Player p = e.getPlayer();
        if (!LoginManager.isLogin(p)) {
            e.setCancelled(true);
        }
    }

}
