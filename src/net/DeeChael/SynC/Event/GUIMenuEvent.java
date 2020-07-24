package net.DeeChael.SynC.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIMenuEvent implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) { 
	  if (event.getWhoClicked() instanceof Player) { 
		  Player p = (Player)event.getWhoClicked();
		  if (event.getView().getTitle().equalsIgnoreCase("��cSynC Menu")){
		     event.setCancelled(true);
		     p.updateInventory();       
		         if(event.getRawSlot() == 20 ) { 
		             p.sendMessage("��cYou clicked a red button");
		         } else if (event.getRawSlot() == 24) {
		        	 p.sendMessage("��aYou clicked a lime button");
		         }
		     }
	  } else {
		  return;
     } 
   }
	
}
