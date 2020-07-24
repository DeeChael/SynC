package net.DeeChael.SynC.TabComplete;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

public class TabCompleteCommandsSync implements TabCompleter {

	  @Override
	  public List<String> onTabComplete(CommandSender s, Command cmd, String CommandLabel, String[] args){
	    List<String> completions = new ArrayList<>();
	    	if(args.length == 1){
	  	      completions.add("help");
	  	      completions.add("reload");
	  	      return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
	  	    }
	  return null;
	  }

}
