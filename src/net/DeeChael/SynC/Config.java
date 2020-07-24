package net.DeeChael.SynC;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	public static String setlang;
	
	public static String langyml = setlang + ".yml";
	
	public static File worldsetting = new File("plugins/SynC/", "WorldSettings.yml");
	public static File chatsetting = new File("plugins/SynC/", "ChatSettings.yml");
	public static File helpmessage = new File("plugins/SynC/", "HelpMessage.yml");
	public static File settings = new File("plugins/SynC/", "Settings.yml");
	public static File loginsettings = new File("plugins/SynC", "LoginSettings.yml");
	public static File customjoinmessage = new File("plugins/SynC", "CustomJoinMessage.yml");
	public static File playerdatafolder = new File(Main.plugin.getDataFolder() + "/playerdata", "");
	public static FileConfiguration worset = (FileConfiguration)YamlConfiguration.loadConfiguration(worldsetting);
	public static FileConfiguration chatset = (FileConfiguration)YamlConfiguration.loadConfiguration(chatsetting);
	public static FileConfiguration helpmsg = (FileConfiguration)YamlConfiguration.loadConfiguration(helpmessage);
	public static FileConfiguration sets = (FileConfiguration)YamlConfiguration.loadConfiguration(settings);
	public static FileConfiguration logsets = (FileConfiguration)YamlConfiguration.loadConfiguration(loginsettings);
	public static FileConfiguration joinmsg = (FileConfiguration)YamlConfiguration.loadConfiguration(customjoinmessage);
	
	public static Config cfg;

	public static boolean allownick;
	public static boolean allowmenu;
	public static boolean allowlogin;
	public static boolean allowjoinmsg;
	public static boolean allowjointitle;
	
	public static String join;
	public static String left;
	public static String kick;
	public static String title;
	public static String subtitle;
	
	public static List<String> helpmsgS;
	
	public static String spawnworld;
	
	public static String chatformat;
	
	public static int pwmax;
	public static int pwmin;
	public static int iplimit;
	
	public static String msgxpgetexp;
	public static String msgxpgetlv;
	
	public static String msgxpgivexp;
	public static String msgxpgivlv;
	
	public static String msgxpsetexp;
	public static String msgxpsetlv;
	
	public static String msgxprmvlv;
	
	public static String msgchatplzent;
	public static String msgchatplzentcmd;
	
	public static String msgflyslfen;
	public static String msgflyslfdis;
	
	public static String msgflyothen;
	public static String msgflyothdis;
	
	public static String msgloglogsuc;
	public static String msgloglogtip;
	
	public static String msglogregsuc;
	public static String msglogregtip;
	
	public static String msglogpwcsuc;
	public static String msglogpwctip;
	
	public static String msglogerrunlog;
	public static String msglogerrunreg;
	public static String msglogerrlong;
	public static String msglogerrshort;
	public static String msglogerrip;
	public static String msglogerrunsampw;
	public static String msglogerrwronpw;
	public static String msglogerrhvreg;
	public static String msglogerrhvlog;
	public static String msglogerrcntsame;
	
	public static String msgbanurban;
	public static String msgbanotherban;
	public static String msgbannoban;
	public static String msgbanunban;
	
	public static String msgsyncerr0length;
	public static String msgsyncreload;
	
	public static String msgsetspsuc;
	
	public static String msggmsfct;       
    public static String msggmsfsr;       
    public static String msggmsfat;       
    public static String msggmsfsp;       
    
    public static String msggmotct;       
    public static String msggmotsr;       
    public static String msggmotat;       
    public static String msggmotsp;       
    
    public static String msggmerrwm;      
    
    public static String msgkkurkk;       
    public static String msgkknoplr;      
    public static String msgkkkkresn;     
    public static String msgkksbikk;      
    public static String msgkkkkadm;      
    
    public static String msgtlnoplrnotxt; 
    public static String msgtlnotxt;      
    
    public static String msgnksfsucnk;    
    public static String msgnksfsucunnk;  
    
    public static String msgnkotsucunnk;  
    public static String msgnkotsucrlnm;  
    
    public static String msgnkerrnotxt;  
    public static String msgnkerrunnotxt; 
    public static String msgnkerrlong16;  
    public static String msgnkerrhvspc;   
    public static String msgnkerrnonk;    
    public static String msgnkerrotnonk;  
    
    public static String msgerrlong;      
    public static String msgerroffplr;    
    public static String msgerrnoper;     
    public static String msgerrmstaplr;   
    public static String msgerrwrncmd;    
    public static String msgerrwrnplrnm;  
	
    public static void loadMainConfig() {
    	Main.plugin.saveDefaultConfig();
    	Config.setlang = Main.plugin.getConfig().getString("Language");
    	loadOtherConfig();
    	getConfigString();
    }
    
    public static void loadOtherConfig() {
    	String langyml = setlang + ".yml";
        File language = new File("plugins/SynC/lang", langyml);
        FileConfiguration lang = (FileConfiguration)YamlConfiguration.loadConfiguration(language);
    	
    	//Events竟然不能自己创建文件夹
    	//所以玩家进入游戏就报错
    	//只能在这里手动创建一个文件夹了
    	playerdatafolder.mkdir();
    	
    	if (!language.exists()) {
    		//这里设置成false有个问题就是
    		//内容更新了话不会替换
    		//用户会报错
    		//不过有判断exists
    		//可以设置为true来着
    		Bukkit.getServer().getConsoleSender().sendMessage("§cCan't find SynC language file.");
    		Bukkit.getServer().getConsoleSender().sendMessage("§cAuto create SynC language zh_CN.yml and en_US.yml");
    		Main.plugin.saveResource("lang/zh_CN.yml", false);
    		Main.plugin.saveResource("lang/en_US.yml", false);
          }
    	
    	if (!worldsetting.exists()) {
    		Main.plugin.saveResource("WorldSettings.yml", false);
          }
    	
    	if (!chatsetting.exists()) {
    		Main.plugin.saveResource("ChatSettings.yml", false);
          }
    	
    	if (!helpmessage.exists()) {
    		Main.plugin.saveResource("HelpMessage.yml", false);
          }
    	
    	if (!settings.exists()) {
    		Main.plugin.saveResource("Settings.yml", false);
          }
     
    	if (!loginsettings.exists()) {
    		Main.plugin.saveResource("LoginSettings.yml", false);
    	}
    	
    	if (!customjoinmessage.exists()) {
    		Main.plugin.saveResource("CustomJoinMessage.yml", false);
    	}
    	
    	try {
			lang.load(language);
			worset.load(worldsetting);
			chatset.load(chatsetting);
			helpmsg.load(helpmessage);
			sets.load(settings);
			logsets.load(loginsettings);
			joinmsg.load(customjoinmessage);
			
		} catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
		      e.printStackTrace();
	    }
    	
    }
    
    public static void getConfigString() {
    	String langyml = setlang + ".yml";
        File language = new File("plugins/SynC/lang", langyml);
        FileConfiguration lang = (FileConfiguration)YamlConfiguration.loadConfiguration(language);
        
    	    Config.allownick = sets.getBoolean("AllowNick");
    	    Config.allowmenu = sets.getBoolean("Menu");
    	    Config.allowlogin = sets.getBoolean("Login");
    	    Config.allowjoinmsg = sets.getBoolean("JoinMessage");
    	    Config.allowjointitle = sets.getBoolean("JoinTitle");
    	    
    	    Config.join = joinmsg.getString("join").replace("&","§"); 
    	    Config.left = joinmsg.getString("left").replace("&","§"); 
    	    Config.kick = joinmsg.getString("kick").replace("&","§"); 
    	    Config.title = joinmsg.getString("title.title").replace("&","§"); 
    	    Config.subtitle = joinmsg.getString("title.subtitle").replace("&","§"); 
    	
    	    Config.helpmsgS = helpmsg.getStringList("HelpMessage"); 
    	
    	    Config.spawnworld = worset.getString("SpawnWorld");
    	    
    	    Config.chatformat = chatset.getString("Format").replace("&","§");
    	    
    	    Config.pwmax = logsets.getInt("max-password-length");
    	    Config.pwmin = logsets.getInt("min-password-length");
    	    Config.iplimit = logsets.getInt("ip-reglimit");
    	    
    	    Config.msgxpgetexp = lang.getString("message.xp.get.exp").replace("&","§");
    	    Config.msgxpgetlv = lang.getString("message.xp.get.level").replace("&","§");

    	    Config.msgxpgivexp = lang.getString("message.xp.give.exp").replace("&","§");
    	    Config.msgxpgivlv = lang.getString("message.xp.give.level").replace("&","§");
    	    
    	    Config.msgxpsetexp = lang.getString("message.xp.set.exp").replace("&","§");
    	    Config.msgxpsetlv = lang.getString("message.xp.set.level").replace("&","§");
    	    
    	    Config.msgxprmvlv = lang.getString("message.xp.remove.level").replace("&","§");
    	    
    	    Config.msgchatplzent = lang.getString("message.chat.pleaseenter").replace("&","§");
    	    Config.msgchatplzentcmd = lang.getString("message.chat.pleaseentercommand").replace("&","§");
    	    
    	    Config.msgflyslfen = lang.getString("message.fly.self.open").replace("&","§");
    	    Config.msgflyslfdis = lang.getString("message.fly.self.close").replace("&","§");
    	    
    	    Config.msgflyothen = lang.getString("message.fly.other.open").replace("&","§");
    	    Config.msgflyothdis = lang.getString("message.fly.other.close").replace("&","§");
    	    
    	    Config.msgloglogsuc = lang.getString("message.login.login.successful").replace("&","§");
    		Config.msgloglogtip = lang.getString("message.login.login.tips").replace("&","§");

    		Config.msglogregsuc = lang.getString("message.login.register.successful").replace("&","§");
    		Config.msglogregtip = lang.getString("message.login.register.tips").replace("&","§");

    		Config.msglogpwcsuc = lang.getString("message.login.changepassword.successful").replace("&","§");
    		Config.msglogpwctip = lang.getString("message.login.changepassword.tips").replace("&","§");
    		
    		Config.msglogerrunlog = lang.getString("message.login.error.unlogin").replace("&","§");
    		Config.msglogerrunreg = lang.getString("message.login.error.unregister").replace("&","§");
    		Config.msglogerrlong = lang.getString("message.login.error.longer").replace("&","§");
    		Config.msglogerrshort = lang.getString("message.login.error.shorter").replace("&","§");
    		Config.msglogerrip = lang.getString("message.login.error.ip").replace("&","§");
    		Config.msglogerrunsampw = lang.getString("message.login.error.unsamepassword").replace("&","§");
    	    Config.msglogerrwronpw = lang.getString("message.login.error.wrongpassword").replace("&", "§");
    	    Config.msglogerrhvreg = lang.getString("message.login.error.regged").replace("&","§");
    	    Config.msglogerrhvlog = lang.getString("message.login.error.logged").replace("&","§");
    	    Config.msglogerrcntsame = lang.getString("message.login.error.cannotsame").replace("&","§");
    	    
    	    Config.msgbanurban = lang.getString("message.ban.youarebanned").replace("&","§");
	        Config.msgbanotherban=lang.getString("message.ban.somebodyisbanned").replace("&","§");
	        Config.msgbannoban=lang.getString("message.ban.notbanned").replace("&","§");
	        Config.msgbanunban=lang.getString("message.ban.isunban").replace("&","§");
    	    
    	    Config.msgsyncerr0length = lang.getString("message.sync.error.zerolength").replace("&","§");
    	    Config.msgsyncreload = lang.getString("message.sync.reload").replace("&","§");
    	    
    	    Config.msgsetspsuc = lang.getString("message.setspawn.success").replace("&","§");
    	    
    	    Config.msggmsfct = lang.getString("message.gamemode.self.creative").replace("&","§");
	        Config.msggmsfsr=lang.getString("message.gamemode.self.survival").replace("&","§");
	        Config.msggmsfat=lang.getString("message.gamemode.self.adventure").replace("&","§");
	        Config.msggmsfsp=lang.getString("message.gamemode.self.spectator").replace("&","§");

	        Config.msggmotct=lang.getString("message.gamemode.other.creative").replace("&","§");
	        Config.msggmotsr=lang.getString("message.gamemode.other.survival").replace("&","§");
	        Config.msggmotat=lang.getString("message.gamemode.other.adventure").replace("&","§");
	        Config.msggmotsp=lang.getString("message.gamemode.other.spectator").replace("&","§");

	        Config.msggmerrwm=lang.getString("message.gamemode.error.wrongmode").replace("&","§");

	        Config.msgkkurkk=lang.getString("message.kick.youarekicked").replace("&","§");
	        Config.msgkknoplr=lang.getString("message.kick.noplayer").replace("&","§");
	        Config.msgkkkkresn=lang.getString("message.kick.kickreason").replace("&","§");
	        Config.msgkksbikk=lang.getString("message.kick.somebodyiskicked").replace("&","§");
	        Config.msgkkkkadm=lang.getString("message.kick.kickadmin").replace("&","§");

	        Config.msgtlnoplrnotxt=lang.getString("message.tell.error.noplayerandnotext").replace("&","§");
	        Config.msgtlnotxt=lang.getString("message.tell.error.notext").replace("&","§");

	        Config.msgnksfsucnk=lang.getString("message.nick.self.successnick").replace("&","§");
	        Config.msgnksfsucunnk=lang.getString("message.nick.self.successunnick").replace("&","§");

	        Config.msgnkotsucunnk=lang.getString("message.nick.other.successunnick").replace("&","§");
	        Config.msgnkotsucrlnm=lang.getString("message.nick.other.successseerealname").replace("&","§");

	        Config.msgnkerrnotxt=lang.getString("message.nick.error.notext").replace("&","§");
	        Config.msgnkerrunnotxt=lang.getString("message.nick.error.unnotext").replace("&","§");
	        Config.msgnkerrlong16=lang.getString("message.nick.error.longerthan16").replace("&","§");
	        Config.msgnkerrhvspc=lang.getString("message.nick.error.havespace").replace("&","§");
	        Config.msgnkerrnonk=lang.getString("message.nick.error.nonick").replace("&","§");
	        Config.msgnkerrotnonk=lang.getString("message.nick.error.othernonick").replace("&","§");

	        Config.msgerrlong=lang.getString("message.error.longer").replace("&","§");
	        Config.msgerroffplr=lang.getString("message.error.offlineplayer").replace("&","§");
	        Config.msgerrnoper=lang.getString("message.error.nopermission").replace("&","§");
	        Config.msgerrmstaplr=lang.getString("message.error.mustaplayer").replace("&","§");
	        Config.msgerrwrncmd=lang.getString("message.error.wrongcmd").replace("&","§");
	        Config.msgerrwrnplrnm=lang.getString("message.error.wrongplayername").replace("&","§");
    }
    
	
    public static void setSpawnReload() {
    	Config.spawnworld = worset.getString("SpawnWorld");
    }
    
    public static void reloadAllConfig() {
    	
    	String langyml = setlang + ".yml";
        File language = new File("plugins/SynC/lang", langyml);
        FileConfiguration lang = (FileConfiguration)YamlConfiguration.loadConfiguration(language);
        
    	Main.plugin.saveConfig();
    	Main.plugin.reloadConfig();
    	
    	try {
			lang.load(language);
			worset.load(worldsetting);
			chatset.load(chatsetting);
			helpmsg.load(helpmessage);
			sets.load(settings);
			logsets.load(loginsettings);
			joinmsg.load(customjoinmessage);
		} catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
		      e.printStackTrace();
	    }
    	
    	Config.allownick = sets.getBoolean("AllowNick");
  	    Config.allowmenu = sets.getBoolean("Menu");
  	    Config.allowlogin = sets.getBoolean("Login");
  	    Config.allowjoinmsg = sets.getBoolean("JoinMessage");
  	    Config.allowjointitle = sets.getBoolean("JoinTitle");
  	    
  	    Config.join = joinmsg.getString("join").replace("&","§"); 
	    Config.left = joinmsg.getString("left").replace("&","§"); 
	    Config.kick = joinmsg.getString("kick").replace("&","§"); 
	    Config.title = joinmsg.getString("title.title").replace("&","§"); 
	    Config.subtitle = joinmsg.getString("title.subtitle").replace("&","§"); 
    	
    	Config.helpmsgS = helpmsg.getStringList("HelpMessage"); 
    	
    	Config.spawnworld = worset.getString("SpawnWorld");
	    
	    Config.chatformat = chatset.getString("Format").replace("&","§");
	    
	    Config.pwmax = logsets.getInt("max-password-length");
	    Config.pwmin = logsets.getInt("min-password-length");
	    Config.iplimit = logsets.getInt("ip-reglimit");
	    
	    Config.msgxpgetexp = lang.getString("message.xp.get.exp").replace("&","§");
	    Config.msgxpgetlv = lang.getString("message.xp.get.level").replace("&","§");

	    Config.msgxpgivexp = lang.getString("message.xp.give.exp").replace("&","§");
	    Config.msgxpgivlv = lang.getString("message.xp.give.level").replace("&","§");
	    
	    Config.msgxpsetexp = lang.getString("message.xp.set.exp").replace("&","§");
	    Config.msgxpsetlv = lang.getString("message.xp.set.level").replace("&","§");
	    
	    Config.msgxprmvlv = lang.getString("message.xp.remove.level").replace("&","§");
	    
	    Config.msgchatplzent = lang.getString("message.chat.pleaseenter").replace("&","§");
	    Config.msgchatplzentcmd = lang.getString("message.chat.pleaseentercommand").replace("&","§");
	    
	    Config.msgflyslfen = lang.getString("message.fly.self.open").replace("&","§");
	    Config.msgflyslfdis = lang.getString("message.fly.self.close").replace("&","§");
	    
	    Config.msgflyothen = lang.getString("message.fly.other.open").replace("&","§");
	    Config.msgflyothdis = lang.getString("message.fly.other.close").replace("&","§");
	    
	    Config.msgloglogsuc = lang.getString("message.login.login.successful").replace("&","§");
		Config.msgloglogtip = lang.getString("message.login.login.tips").replace("&","§");

		Config.msglogregsuc = lang.getString("message.login.register.successful").replace("&","§");
		Config.msglogregtip = lang.getString("message.login.register.tips").replace("&","§");

		Config.msglogpwcsuc = lang.getString("message.login.changepassword.successful").replace("&","§");
		Config.msglogpwctip = lang.getString("message.login.changepassword.tips").replace("&","§");
		
		Config.msglogerrunlog = lang.getString("message.login.error.unlogin").replace("&","§");
		Config.msglogerrunreg = lang.getString("message.login.error.unregister").replace("&","§");
		Config.msglogerrlong = lang.getString("message.login.error.longer").replace("&","§");
		Config.msglogerrshort = lang.getString("message.login.error.shorter").replace("&","§");
		Config.msglogerrip = lang.getString("message.login.error.ip").replace("&","§");
		Config.msglogerrunsampw = lang.getString("message.login.error.unsamepassword").replace("&","§");
	    Config.msglogerrwronpw = lang.getString("message.login.error.wrongpassword").replace("&", "§");
	    Config.msglogerrhvreg = lang.getString("message.login.error.regged").replace("&","§");
	    Config.msglogerrhvlog = lang.getString("message.login.error.logged").replace("&","§");
	    Config.msglogerrcntsame = lang.getString("message.login.error.cannotsame").replace("&","§");
	    
	    Config.msgbanurban = lang.getString("message.ban.youarebanned").replace("&","§");
        Config.msgbanotherban=lang.getString("message.ban.somebodyisbanned").replace("&","§");
        Config.msgbannoban=lang.getString("message.ban.notbanned").replace("&","§");
        Config.msgbanunban=lang.getString("message.ban.isunban").replace("&","§");
        
	    Config.msgsyncerr0length = lang.getString("message.sync.error.zerolength").replace("&","§");
	    Config.msgsyncreload = lang.getString("message.sync.reload").replace("&","§");
	    
	    Config.msgsetspsuc = lang.getString("message.setspawn.success").replace("&","§");
	    
	    Config.msggmsfct = lang.getString("message.gamemode.self.creative").replace("&","§");
        Config.msggmsfsr=lang.getString("message.gamemode.self.survival").replace("&","§");
        Config.msggmsfat=lang.getString("message.gamemode.self.adventure").replace("&","§");
        Config.msggmsfsp=lang.getString("message.gamemode.self.spectator").replace("&","§");

        Config.msggmotct=lang.getString("message.gamemode.other.creative").replace("&","§");
        Config.msggmotsr=lang.getString("message.gamemode.other.survival").replace("&","§");
        Config.msggmotat=lang.getString("message.gamemode.other.adventure").replace("&","§");
        Config.msggmotsp=lang.getString("message.gamemode.other.spectator").replace("&","§");

        Config.msggmerrwm=lang.getString("message.gamemode.error.wrongmode").replace("&","§");

        Config.msgkkurkk=lang.getString("message.kick.youarekicked").replace("&","§");
        Config.msgkknoplr=lang.getString("message.kick.noplayer").replace("&","§");
        Config.msgkkkkresn=lang.getString("message.kick.kickreason").replace("&","§");
        Config.msgkksbikk=lang.getString("message.kick.somebodyiskicked").replace("&","§");
        Config.msgkkkkadm=lang.getString("message.kick.kickadmin").replace("&","§");

        Config.msgtlnoplrnotxt=lang.getString("message.tell.error.noplayerandnotext").replace("&","§");
        Config.msgtlnotxt=lang.getString("message.tell.error.notext").replace("&","§");

        Config.msgnksfsucnk=lang.getString("message.nick.self.successnick").replace("&","§");
        Config.msgnksfsucunnk=lang.getString("message.nick.self.successunnick").replace("&","§");

        Config.msgnkotsucunnk=lang.getString("message.nick.other.successunnick").replace("&","§");
        Config.msgnkotsucrlnm=lang.getString("message.nick.other.successseerealname").replace("&","§");

        Config.msgnkerrnotxt=lang.getString("message.nick.error.notext").replace("&","§");
        Config.msgnkerrunnotxt=lang.getString("message.nick.error.unnotext").replace("&","§");
        Config.msgnkerrlong16=lang.getString("message.nick.error.longerthan16").replace("&","§");
        Config.msgnkerrhvspc=lang.getString("message.nick.error.havespace").replace("&","§");
        Config.msgnkerrnonk=lang.getString("message.nick.error.nonick").replace("&","§");
        Config.msgnkerrotnonk=lang.getString("message.nick.error.othernonick").replace("&","§");

        Config.msgerrlong=lang.getString("message.error.longer").replace("&","§");
        Config.msgerroffplr=lang.getString("message.error.offlineplayer").replace("&","§");
        Config.msgerrnoper=lang.getString("message.error.nopermission").replace("&","§");
        Config.msgerrmstaplr=lang.getString("message.error.mustaplayer").replace("&","§");
        Config.msgerrwrncmd=lang.getString("message.error.wrongcmd").replace("&","§");
        Config.msgerrwrnplrnm=lang.getString("message.error.wrongplayername").replace("&","§");
    
    }
    
}
