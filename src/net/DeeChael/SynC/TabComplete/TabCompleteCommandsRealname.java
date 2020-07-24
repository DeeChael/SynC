package net.DeeChael.SynC.TabComplete;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

public class TabCompleteCommandsRealname implements TabCompleter {

	  @Override
	  public List<String> onTabComplete(CommandSender s, Command cmd, String CommandLabel, String[] args){
	    List<String> completions = new ArrayList<>();
	    	if(args.length == 1){
	    		for(Player player : Bukkit.getOnlinePlayers()){
                  completions.add(player.getName());
                }
	  	      return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
	  	    }
	  return null;
	  }

}
