package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class PickupItemEvent implements Listener {
	@EventHandler
    public void PickupItem(EntityPickupItemEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (!LoginManager.isLogin(p)) {
                e.setCancelled(true);
            }
        }
    }

}
