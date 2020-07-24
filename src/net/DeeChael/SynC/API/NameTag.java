package net.DeeChael.SynC.API;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/*
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team; */

public class NameTag
{
	  @SuppressWarnings({ "unchecked", "deprecation" })
	    public static void changeName(String name, Player player) {
	        try {
	            Method getHandle = player.getClass().getMethod("getHandle");
	            Object entityPlayer = getHandle.invoke(player);
	            boolean gameProfileExists = false;
	            try {
	                Class.forName("net.minecraft.util.com.mojang.authlib.GameProfile");
	                Class.forName("com.mojang.authlib.GameProfile");
	                gameProfileExists = true;
	            } catch (ClassNotFoundException ignored) {
	 
	            }
	            if (!gameProfileExists) {
	                Field nameField = entityPlayer.getClass().getSuperclass().getDeclaredField("name");
	                nameField.setAccessible(true);
	                nameField.set(entityPlayer, name);
	            } else {
	                Object profile = entityPlayer.getClass().getMethod("getProfile").invoke(entityPlayer);
	                Field ff = profile.getClass().getDeclaredField("name");
	                ff.setAccessible(true);
	                ff.set(profile, name);
	            }
	            if (Bukkit.class.getMethod("getOnlinePlayers", new Class<?>[0]).getReturnType() == Collection.class) {
	                Collection<? extends Player> players = (Collection<? extends Player>) Bukkit.class.getMethod("getOnlinePlayers").invoke(null);
	                for (Player p : players) {
	                    p.hidePlayer(player);
	                    p.showPlayer(player);
	                }
	            } else {
	                Player[] players = ((Player[]) Bukkit.class.getMethod("getOnlinePlayers").invoke(null));
	                for (Player p : players) {
	                    p.hidePlayer(player);
	                    p.showPlayer(player);
	                }
	            }
	        } catch (NoSuchMethodException | SecurityException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	        } catch (InvocationTargetException e) {
	            e.printStackTrace();
	        } catch (NoSuchFieldException e) {
	            e.printStackTrace();
	        }
	 
	   }
}
