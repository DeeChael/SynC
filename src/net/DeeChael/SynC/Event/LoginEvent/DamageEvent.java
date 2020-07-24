package net.DeeChael.SynC.Event.LoginEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import net.DeeChael.SynC.Manager.LoginManager;

public class DamageEvent implements Listener {
    @EventHandler
    public void Damage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (!LoginManager.isLogin(p)) {
                e.setCancelled(true);
            }
        }
    }

}
