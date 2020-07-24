package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class BucketEvent implements Listener {
    @EventHandler
    public void Bucket(PlayerBucketEvent e) {
		Player p = e.getPlayer();
        if (!LoginManager.isLogin(p)) {
            e.setCancelled(true);
        }
    }

}
