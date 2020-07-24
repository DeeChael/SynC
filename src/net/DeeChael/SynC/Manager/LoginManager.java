package net.DeeChael.SynC.Manager;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class LoginManager {
	public static ArrayList<Player> lm = new ArrayList<Player>();
	
    public static boolean isLogin(Player player) {
        return lm.contains(player);
    }
}
