package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class BedEnterEvent implements Listener {
    @EventHandler
    public void BedEnter(PlayerBedEnterEvent e) {
		Player p = e.getPlayer();
        if (!LoginManager.isLogin(p)) {
            e.setCancelled(true);
        }
    }

}
