package net.DeeChael.SynC.API;

public class ChatColor {
	public static String setChatColor(String string) {
		String replaced = string.replace("&1", "¡ì1").replace("&2", "¡ì2").replace("&3", "¡ì3").replace("&4", "¡ì4").replace("&5", "¡ì5").replace("&6", "¡ì6").replace("&7", "¡ì7").replace("&8", "¡ì8").replace("&9", "¡ì9").replace("&0", "¡ì0").replace("&a", "¡ìa").replace("&b", "¡ìb").replace("&c", "¡ìc").replace("&d", "¡ìd").replace("&e", "¡ìe").replace("&f", "¡ìf").replace("&l", "¡ìl").replace("&m", "¡ìm").replace("&n", "¡ìn").replace("&o", "¡ìo").replace("&r", "¡ìr").replace("&k", "¡ìk");
		return replaced;
	}
}
