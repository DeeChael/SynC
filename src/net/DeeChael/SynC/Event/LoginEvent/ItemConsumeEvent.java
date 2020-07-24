package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class ItemConsumeEvent implements Listener {
    @EventHandler
    public void ItemConsume(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
        if (!LoginManager.isLogin(p)) {
            e.setCancelled(true);
        }
    }

}
