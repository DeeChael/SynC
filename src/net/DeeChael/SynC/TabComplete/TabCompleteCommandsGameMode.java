package net.DeeChael.SynC.TabComplete;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

public class TabCompleteCommandsGameMode implements TabCompleter {

	  @Override
	  public List<String> onTabComplete(CommandSender s, Command cmd, String CommandLabel, String[] args){
	    List<String> completions = new ArrayList<>();
	    	if(args.length == 1){
	  	      completions.add("0");
	  	      completions.add("1");
	  	      completions.add("2");
	          completions.add("3");
	  	      completions.add("s");
	  	      completions.add("c");
	  	      completions.add("a");
	  	      completions.add("w");
	  	      completions.add("l");
	  	      completions.add("survival");
	  	      completions.add("creative");
	  	      completions.add("adventure");
	  	      completions.add("spectator");
	  	      return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
	  	    } else if(args.length == 2){
	  	    	for(Player player : Bukkit.getOnlinePlayers()){
                    completions.add(player.getName());
                  }
	  	    	return StringUtil.copyPartialMatches(args[1], completions, new ArrayList<>());
	        }
	  return null;
	  }


}
