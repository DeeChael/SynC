package net.DeeChael.SynC;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.DeeChael.SynC.Commands.CommandsBan;
import net.DeeChael.SynC.Commands.CommandsBanIP;
import net.DeeChael.SynC.Commands.CommandsChangePassword;
import net.DeeChael.SynC.Commands.CommandsChat;
import net.DeeChael.SynC.Commands.CommandsChatCMD;
import net.DeeChael.SynC.Commands.CommandsFly;
import net.DeeChael.SynC.Commands.CommandsGameMode;
import net.DeeChael.SynC.Commands.CommandsKick;
import net.DeeChael.SynC.Commands.CommandsLogin;
import net.DeeChael.SynC.Commands.CommandsMenu;
import net.DeeChael.SynC.Commands.CommandsNick;
import net.DeeChael.SynC.Commands.CommandsRealname;
import net.DeeChael.SynC.Commands.CommandsRegister;
import net.DeeChael.SynC.Commands.CommandsSetSpawn;
import net.DeeChael.SynC.Commands.CommandsSpawn;
import net.DeeChael.SynC.Commands.CommandsSync;
import net.DeeChael.SynC.Commands.CommandsTell;
import net.DeeChael.SynC.Commands.CommandsUnban;
import net.DeeChael.SynC.Commands.CommandsUnbanIP;
import net.DeeChael.SynC.Commands.CommandsUnnick;
import net.DeeChael.SynC.Commands.CommandsXP;
import net.DeeChael.SynC.Event.ChatFormat;
import net.DeeChael.SynC.Event.GUIMenuEvent;
import net.DeeChael.SynC.Event.PlayerJoinCreateConfig;
import net.DeeChael.SynC.Event.PlayerJoinMessage;
import net.DeeChael.SynC.Event.PlayerJoinTitle;
import net.DeeChael.SynC.Event.PlayerLeftMessage;
import net.DeeChael.SynC.Event.PlayerKickMessage;

import net.DeeChael.SynC.Event.LoginEvent.ASyncChatEvent;
import net.DeeChael.SynC.Event.LoginEvent.AnimationEvent;
import net.DeeChael.SynC.Event.LoginEvent.BedEnterEvent;
import net.DeeChael.SynC.Event.LoginEvent.BreakEvent;
import net.DeeChael.SynC.Event.LoginEvent.BucketEmptyEvent;
//import net.DeeChael.SynC.Event.LoginEvent.BucketEvent;
import net.DeeChael.SynC.Event.LoginEvent.BucketFillEvent;
import net.DeeChael.SynC.Event.LoginEvent.DamageEvent;
import net.DeeChael.SynC.Event.LoginEvent.DropItemEvent;
import net.DeeChael.SynC.Event.LoginEvent.EditBookEvent;
import net.DeeChael.SynC.Event.LoginEvent.FishEvent;
import net.DeeChael.SynC.Event.LoginEvent.GamemodeChange;
import net.DeeChael.SynC.Event.LoginEvent.InteractEntityEvent;
import net.DeeChael.SynC.Event.LoginEvent.ItemConsumeEvent;
import net.DeeChael.SynC.Event.LoginEvent.JoinAndNotLoginOrRegister;
import net.DeeChael.SynC.Event.LoginEvent.MoveEvent;
import net.DeeChael.SynC.Event.LoginEvent.PickupArrowEvent;
import net.DeeChael.SynC.Event.LoginEvent.PickupItemEvent;
import net.DeeChael.SynC.Event.LoginEvent.PlaceEvent;

import net.DeeChael.SynC.GUI.GUImenu;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsBan;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsBanIP;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsChangePassword;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsChat;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsChatCMD;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsGameMode;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsKick;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsLogin;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsNick;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsRealname;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsRegister;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsSync;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsTell;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsUnban;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsUnbanIP;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsUnnick;
import net.DeeChael.SynC.TabComplete.TabCompleteCommandsXP;

public class Main extends JavaPlugin {
	public static Plugin plugin;

	@Override
    public void onEnable() {
        
		plugin = this;
        Config.loadMainConfig();

		getServer().getConsoleSender().sendMessage("¡ìc=================================");
		getServer().getConsoleSender().sendMessage("¡ìcEnable!");
		getServer().getConsoleSender().sendMessage("¡ìcServer Version: " + getServer().getVersion());
		getServer().getConsoleSender().sendMessage("¡ìcPlugin Name: SynC");
		getServer().getConsoleSender().sendMessage("¡ìcAuthor: Ç¨Ú¤DeeChael");
		getServer().getConsoleSender().sendMessage("¡ìcMy Website: https://www.deechael.net/");
		getServer().getConsoleSender().sendMessage("¡ìc=================================");
		
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinCreateConfig(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ChatFormat(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new GUIMenuEvent(), this);

        this.getCommand("tell").setExecutor(new CommandsTell(this));
        this.getCommand("kick").setExecutor(new CommandsKick(this));
        this.getCommand("gm").setExecutor(new CommandsGameMode(this));
        this.getCommand("spawn").setExecutor(new CommandsSpawn(this));
        this.getCommand("setspawn").setExecutor(new CommandsSetSpawn(this));
        this.getCommand("sync").setExecutor(new CommandsSync(this));
        this.getCommand("ban").setExecutor(new CommandsBan(this));
        this.getCommand("banip").setExecutor(new CommandsBanIP(this));
        this.getCommand("unban").setExecutor(new CommandsUnban(this));
        this.getCommand("unbanip").setExecutor(new CommandsUnbanIP(this));
        this.getCommand("fly").setExecutor(new CommandsFly(this));
        this.getCommand("chat").setExecutor(new CommandsChat(this));
        this.getCommand("chatcmd").setExecutor(new CommandsChatCMD(this));
        this.getCommand("xp").setExecutor(new CommandsXP(this));
        
        this.getCommand("tell").setTabCompleter(new TabCompleteCommandsTell());
        this.getCommand("kick").setTabCompleter(new TabCompleteCommandsKick());
        this.getCommand("gm").setTabCompleter(new TabCompleteCommandsGameMode());
        this.getCommand("sync").setTabCompleter(new TabCompleteCommandsSync());
        this.getCommand("ban").setTabCompleter(new TabCompleteCommandsBan());
        this.getCommand("banip").setTabCompleter(new TabCompleteCommandsBanIP());
        this.getCommand("unban").setTabCompleter(new TabCompleteCommandsUnban());
        this.getCommand("unbanip").setTabCompleter(new TabCompleteCommandsUnbanIP());
        this.getCommand("chat").setTabCompleter(new TabCompleteCommandsChat());
        this.getCommand("chatcmd").setTabCompleter(new TabCompleteCommandsChatCMD());
        this.getCommand("xp").setTabCompleter(new TabCompleteCommandsXP());
        
        if (Config.allownick == true) {
        	this.getCommand("nick").setExecutor(new CommandsNick(this));
    		this.getCommand("unnick").setExecutor(new CommandsUnnick(this));
    		this.getCommand("realname").setExecutor(new CommandsRealname(this));
    		
    		this.getCommand("nick").setTabCompleter(new TabCompleteCommandsNick());
            this.getCommand("unnick").setTabCompleter(new TabCompleteCommandsUnnick());
            this.getCommand("realname").setTabCompleter(new TabCompleteCommandsRealname());
        } else {
        }
        if (Config.allowmenu == true) {
        	this.getCommand("menu").setExecutor(new CommandsMenu(this));
    		GUImenu.createMenuMenu();
        } else {
        }
        if (Config.allowlogin == true) {
    		Bukkit.getServer().getPluginManager().registerEvents(new AnimationEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new ASyncChatEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new BedEnterEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new BreakEvent(), this);
    		//Bukkit.getServer().getPluginManager().registerEvents(new BucketEvent(), this); THIS IS ERROR CODE
    		Bukkit.getServer().getPluginManager().registerEvents(new BucketEmptyEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new BucketFillEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new DropItemEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new EditBookEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new FishEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new GamemodeChange(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new InteractEntityEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new ItemConsumeEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new MoveEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new PickupArrowEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new PickupItemEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
    		Bukkit.getServer().getPluginManager().registerEvents(new JoinAndNotLoginOrRegister(), this);
    		
    		this.getCommand("login").setExecutor(new CommandsLogin(this));
    		this.getCommand("register").setExecutor(new CommandsRegister(this));
    		this.getCommand("changepassword").setExecutor(new CommandsChangePassword(this));
    		
    		this.getCommand("login").setTabCompleter(new TabCompleteCommandsLogin());
            this.getCommand("register").setTabCompleter(new TabCompleteCommandsRegister());
            this.getCommand("changepassword").setTabCompleter(new TabCompleteCommandsChangePassword());
        } else {
        }
        if (Config.allowjoinmsg == true) {
        	Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinMessage(), this);
        	Bukkit.getServer().getPluginManager().registerEvents(new PlayerLeftMessage(), this);
        	Bukkit.getServer().getPluginManager().registerEvents(new PlayerKickMessage(), this);
        } else {
        }
        if (Config.allowjointitle == true) {
        	Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinTitle(), this);
        } else {
        }
	}
	@Override
    public void onDisable() {
		getServer().getConsoleSender().sendMessage("¡ìc=================================");
		getServer().getConsoleSender().sendMessage("¡ìcDisable!");
		getServer().getConsoleSender().sendMessage("¡ìcPlugin Name: SynC");
		getServer().getConsoleSender().sendMessage("¡ìcAuthor: Ç¨Ú¤DeeChael");
		getServer().getConsoleSender().sendMessage("¡ìcMy Website: https://www.deechael.net/");
		getServer().getConsoleSender().sendMessage("¡ìc=================================");
		
	}
	
}
