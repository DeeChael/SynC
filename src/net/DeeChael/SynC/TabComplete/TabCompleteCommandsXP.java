package net.DeeChael.SynC.TabComplete;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

public class TabCompleteCommandsXP implements TabCompleter {

	  @Override
	  public List<String> onTabComplete(CommandSender s, Command cmd, String CommandLabel, String[] args){
	    List<String> completions = new ArrayList<>();
	    	if(args.length == 1){
	  	      completions.add("exp");
	  	      completions.add("level");
	  	      return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
	  	    } else if(args.length == 2){
	  	    	switch(args[0].toLowerCase()){
	  	    	case "exp":
	  	          completions.add("give");
	  	          completions.add("get");
	  	          break;
	  	    	case "level":
	  	          completions.add("give");
	  	          completions.add("set");
	  	          completions.add("get");
	  	          completions.add("remove");
	  	          break;
	  	    	}
	  	    	return StringUtil.copyPartialMatches(args[1], completions, new ArrayList<>());
	        } else if (args.length == 3) {
	        	switch(args[0].toLowerCase()){
	            case "exp":
	              switch(args[1].toLowerCase()){
	                case "give":
	                case "get":
	                  for(Player player : Bukkit.getOnlinePlayers()){
	                    completions.add(player.getName());
	                  }
	                  break;
	              }
	              break;
	            case "level":
	            	switch(args[1].toLowerCase()){
	                case "give":
	                case "set":
	                case "get":
	                case "remove":
	                  for(Player player : Bukkit.getOnlinePlayers()){
	                    completions.add(player.getName());
	                  }
	                  break;
	              }
	              break;
	        	}
	        	return StringUtil.copyPartialMatches(args[2], completions, new ArrayList<>());
	        } else if (args.length == 4) {
	        	switch(args[0].toLowerCase()){
	            case "exp":
	              switch(args[1].toLowerCase()){
	                case "give":
	                	completions.add("<exp>");
	                	break;
	                case "get":
	                  break;
	              }
	              break;
	            case "level":
	              switch(args[1].toLowerCase()){
	            	case "give":
	                case "set":
	                case "remove":
	                	completions.add("<level>");
	                	break;
	                case "get":
	                  break;
	              }
	              break;
	        	}
	        	return StringUtil.copyPartialMatches(args[3], completions, new ArrayList<>());
	        }
	  return null;
	  }

}
