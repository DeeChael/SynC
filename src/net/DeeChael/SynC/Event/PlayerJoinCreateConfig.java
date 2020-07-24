package net.DeeChael.SynC.Event;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import net.DeeChael.SynC.Config;
import net.DeeChael.SynC.API.NameTag;

public class PlayerJoinCreateConfig implements Listener {
	
	@EventHandler
	public void PlayerJoinCreateCFG(PlayerLoginEvent event){
    Player p = event.getPlayer();
    UUID playeruuid = p.getUniqueId();
    String playername = p.getName();
    File playerfile = new File("plugins/SynC/playerdata", playeruuid + ".yml");
	FileConfiguration pfile = (FileConfiguration)YamlConfiguration.loadConfiguration(playerfile);
	 if (!playerfile.exists()) {
     	try {
     		playerfile.createNewFile();
     		pfile.set("data.Name", playername);
			pfile.set("data.NickName", playername);
			pfile.set("data.Language", Config.setlang);
			pfile.set("data.password", null);
			pfile.set("data.vanish", false);
     		pfile.save(playerfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
     }else {
    	 String name = pfile.getString("data.Name");
    	 String nickname = pfile.getString("data.NickName");
    	 if (!name.equals(nickname)) {
    		p.setDisplayName(nickname);
    		p.setPlayerListName(nickname);
    		NameTag.changeName(nickname, p);
    	 } else {
    	 }
     }
}
	
}
