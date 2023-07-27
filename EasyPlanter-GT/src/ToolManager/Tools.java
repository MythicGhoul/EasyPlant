package ToolManager;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Ghoul.EasyPlanters.Main;

public class Tools {

	
	Main plugin;

	public Tools(Main plugin) {
		this.plugin = plugin;

	}
	
	public static ItemStack onAutoHoeI() {

		ItemStack is = new ItemStack(Material.IRON_HOE);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD + "Auto Hoe I" + " "
				+ ChatColor.GOLD + "[=-");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("" + ChatColor.GOLD + ChatColor.UNDERLINE + "Normal Hoe:");
		Lore.add(" ");
		Lore.add(ChatColor.GRAY + "Auto-Replanting");
		im.setLore(Lore);
		im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		is.setItemMeta(im);
		return is;

	}
	
	public static ItemStack onAutoHoeII() {

		ItemStack is = new ItemStack(Material.IRON_HOE);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD + "Auto Hoe II" + " "
				+ ChatColor.GOLD + "[=-");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("" + ChatColor.GOLD + ChatColor.UNDERLINE + "Normal Hoe:");
		Lore.add(" ");
		Lore.add(ChatColor.GRAY + "Auto-Replanting");
		Lore.add(ChatColor.GRAY + "Quick Growing");
		im.setLore(Lore);
		im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		is.setItemMeta(im);
		return is;

	}
}
