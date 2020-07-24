package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class BreakEvent implements Listener {
    @EventHandler
    public void Break(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (!LoginManager.isLogin(p)) {
            e.setCancelled(true);
        }
    }

}
