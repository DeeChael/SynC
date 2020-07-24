package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class BucketEmptyEvent implements Listener {
    @EventHandler
    public void BucketEmpty(PlayerBucketEmptyEvent e) {
		Player p = e.getPlayer();
        if (!LoginManager.isLogin(p)) {
            e.setCancelled(true);
        }
    }

}
