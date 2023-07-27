package me.Ghoul.EasyPlanters;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class SeedsRemoval implements Listener {

	Main plugin;

	public SeedsRemoval(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	public static boolean consumeItem(Player player, int count, Material mat) {
		Map<Integer, ? extends ItemStack> seeds = player.getInventory().all(mat);

		int found = 0;
		for (ItemStack stack : seeds.values())
			found += stack.getAmount();
		if (count > found)
			return false;

		for (Integer index : seeds.keySet()) {
			ItemStack stack = seeds.get(index);

			int removed = Math.min(count, stack.getAmount());
			count -= removed;

			if (stack.getAmount() == removed)
				player.getInventory().setItem(index, null);
			else
				stack.setAmount(stack.getAmount() - removed);

			if (count <= 0)
				break;
		}

		player.updateInventory();
		return true;
	}
}
