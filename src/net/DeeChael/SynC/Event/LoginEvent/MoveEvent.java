package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class MoveEvent implements Listener {
    @EventHandler
    public void Move(PlayerMoveEvent e) {
 		Player p = e.getPlayer();
         if (!LoginManager.isLogin(p)) {
             e.setCancelled(true);
         }
     }

}
