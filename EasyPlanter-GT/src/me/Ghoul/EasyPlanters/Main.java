package me.Ghoul.EasyPlanters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import ToolManager.Tools;

public class Main extends JavaPlugin {

	public static String prefix = ChatColor.WHITE + "[" + ChatColor.GOLD + "EP" + ChatColor.WHITE + "]";
	public static Plugin instance;
	public static Plugin plugin;
	public double v = 3.0;

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.AQUA + "[-------------------------]");
		Bukkit.getConsoleSender()
				.sendMessage(Main.prefix + ChatColor.AQUA + getName() + ":" + " " + ChatColor.GOLD + "Was Enabled!");
		Bukkit.getConsoleSender()
				.sendMessage(Main.prefix + ChatColor.AQUA + "Plugin Version" + ":" + " " + ChatColor.GOLD + v);
		Bukkit.getConsoleSender()
				.sendMessage(Main.prefix + ChatColor.AQUA + "Author:" + " " + ChatColor.GOLD + "MythicGhoul");
		Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.AQUA + "[-------------------------]");

		instance = this;
		new QuickGrow(this);
		new SeedsRemoval(this);
		new Tools(this);
	}

	public JavaPlugin getPlugin() {
		// TODO Auto-generated method stub
		return null;
	}

}