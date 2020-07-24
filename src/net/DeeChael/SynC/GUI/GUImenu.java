package net.DeeChael.SynC.GUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUImenu {

	public static Inventory defmenu;
	
	public static ItemStack redglass;
	public static ItemStack limeglass;
	
	public static ItemStack blackglass;
	
	public static ItemMeta redglassMeta;
	public static ItemMeta limeglassMeta;
	
	public static List<String> redglassLore;
	public static List<String> limeglassLore;
	
	public static void createMenuMenu() {
		
		createMenu();
		createBGItem();
		createButtonItem();
		getButtonItemMeta();
		getButtonItemLore();
		changeButtonItemName();
		changeButtonItemLore();
		saveButtonItem();
		setButtonItem();
        setBGItem();
        
		Bukkit.getServer().getConsoleSender().sendMessage("§bDefaultMenu is created");
		
	}
	
	public static void createMenu() {
		GUImenu.defmenu = Bukkit.createInventory(null, 9*6, "§cSynC Menu");
	}
	
	public static void createBGItem() {
		GUImenu.blackglass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
	}
	
	public static void createButtonItem() {
		GUImenu.redglass = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		GUImenu.limeglass = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
	}
	
	public static void getButtonItemMeta() {
		GUImenu.redglassMeta = redglass.getItemMeta();
		GUImenu.limeglassMeta = limeglass.getItemMeta();
	}
	
	public static void getButtonItemLore() {
		GUImenu.redglassLore = new ArrayList<String>();
		redglassLore.add("§cThis is a red button");
		redglassLore.add("§eTry to click?");
		
		GUImenu.limeglassLore = new ArrayList<String>();
	    limeglassLore.add("§aThis is a lime button");
		limeglassLore.add("§eTry to click?");

	}
	
	public static void changeButtonItemName() {
		redglassMeta.setDisplayName("§cRedButton");
		limeglassMeta.setDisplayName("§aLimeButton");
	}
	
	public static void changeButtonItemLore() {
		redglassMeta.setLore(redglassLore);
		limeglassMeta.setLore(limeglassLore);
	}
	
	public static void saveButtonItem() {
		redglass.setItemMeta(redglassMeta);
		limeglass.setItemMeta(limeglassMeta);
	}
	
	public static void setButtonItem() {
		defmenu.setItem(20, redglass);
		defmenu.setItem(24, limeglass);
	}
	
	public static void setBGItem() {
		/*
		 *大佬别喷
		 *我这样搞也是没办法
		 *用for循环总是缺半边。。 
		 */
		defmenu.setItem(0, blackglass);
		defmenu.setItem(1, blackglass);
		defmenu.setItem(2, blackglass);
		defmenu.setItem(3, blackglass);
		defmenu.setItem(4, blackglass);
		defmenu.setItem(5, blackglass);
		defmenu.setItem(6, blackglass);
		defmenu.setItem(7, blackglass);
		defmenu.setItem(8, blackglass);
		defmenu.setItem(9, blackglass);
		defmenu.setItem(17, blackglass);
		defmenu.setItem(18, blackglass);
		defmenu.setItem(26, blackglass);
		defmenu.setItem(27, blackglass);
		defmenu.setItem(35, blackglass);
		defmenu.setItem(36, blackglass);
		defmenu.setItem(44, blackglass);
		defmenu.setItem(45, blackglass);
		defmenu.setItem(46, blackglass);
		defmenu.setItem(47, blackglass);
		defmenu.setItem(48, blackglass);
		defmenu.setItem(49, blackglass);
		defmenu.setItem(50, blackglass);
		defmenu.setItem(51, blackglass);
		defmenu.setItem(52, blackglass);
		defmenu.setItem(53, blackglass);
	}
 	
}
