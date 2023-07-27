package me.Ghoul.EasyPlanters;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class QuickGrow implements Listener {

	Main plugin;

	public QuickGrow(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public static void onPlaceWheat(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {

			if (b.getBlockData() == null)
				return;
			if (b.getType() == Material.WHEAT) {
				if (p.getInventory().contains(Material.WHEAT_SEEDS)) {
					if (b.getBlockData() instanceof Ageable) {
						if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
							return;
						}
						Ageable ag = (Ageable) b.getBlockData();
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 60L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 120L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(3);
							b.setBlockData(ag);

						}, 240L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(4);
							b.setBlockData(ag);

						}, 300L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(5);
							b.setBlockData(ag);

						}, 400L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(6);
							b.setBlockData(ag);

						}, 500L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(7);
							b.setBlockData(ag);

						}, 600L);
						return;

					}
				} else {
					return;
				}
			}
		}
	}

	@EventHandler
	public void onPlaceCarrot(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {

			if (b.getBlockData() == null)
				return;
			if (b.getType() == Material.CARROTS) {
				if (p.getInventory().contains(Material.CARROT)) {
					if (b.getBlockData() instanceof Ageable) {
						if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
							return;
						}
						Ageable ag = (Ageable) b.getBlockData();
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 60L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 120L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(3);
							b.setBlockData(ag);

						}, 240L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(4);
							b.setBlockData(ag);

						}, 300L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(5);
							b.setBlockData(ag);

						}, 400L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(6);
							b.setBlockData(ag);

						}, 500L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(7);
							b.setBlockData(ag);

						}, 600L);
						return;

					}
				} else {
					return;
				}
			}
		}
	}

	@EventHandler
	public void onPlacePotato(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {

			if (b.getBlockData() == null)
				return;
			if (b.getType() == Material.POTATOES) {
				if (p.getInventory().contains(Material.POTATO)) {
					if (b.getBlockData() instanceof Ageable) {
						if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
							return;
						}
						Ageable ag = (Ageable) b.getBlockData();
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 60L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 120L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(3);
							b.setBlockData(ag);

						}, 240L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(4);
							b.setBlockData(ag);

						}, 300L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(5);
							b.setBlockData(ag);

						}, 400L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(6);
							b.setBlockData(ag);

						}, 500L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(7);
							b.setBlockData(ag);

						}, 600L);
						return;

					}
				} else {
					return;
				}
			}
		}
	}

	@EventHandler
	public void onPlaceBeets(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {

			if (b.getBlockData() == null)
				return;
			if (b.getType() == Material.BEETROOTS) {
				if (p.getInventory().contains(Material.BEETROOT_SEEDS)) {
					if (b.getBlockData() instanceof Ageable) {
						if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
							return;
						}
						Ageable ag = (Ageable) b.getBlockData();
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 100L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 300L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(3);
							b.setBlockData(ag);

						}, 500L);
						return;
					}
				}
			} else {
				return;
			}

		}

	}

	@EventHandler
	public void onPlaceWart(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {

			if (b.getBlockData() == null)
				return;

			if (b.getType() == Material.NETHER_WART) {
				if (p.getInventory().contains(Material.NETHER_WART)) {
					if (b.getBlockData() instanceof Ageable) {
						if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
							return;
						}
						Ageable ag = (Ageable) b.getBlockData();
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 100L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 300L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(3);
							b.setBlockData(ag);

						}, 500L);
						return;

					}
				} else {
					return;

				}
			}

		}
	}

	@EventHandler
	public void onPlaceBerries(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {

			if (b.getBlockData() == null)
				return;

			if (b.getType() == Material.SWEET_BERRY_BUSH) {
				if (p.getInventory().contains(Material.SWEET_BERRIES)) {
					if (b.getBlockData() instanceof Ageable) {
						if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
							return;
						}
						Ageable ag = (Ageable) b.getBlockData();
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 20L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 60L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(3);
							b.setBlockData(ag);

						}, 120L);
						return;

					}
				} else {
					return;

				}
			}

		}

	}

	@EventHandler
	public void onPlaceCocoa(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {

			if (b.getBlockData() == null)
				return;

			if (b.getType() == Material.COCOA) {
				if (p.getInventory().contains(Material.COCOA_BEANS)) {
					if (b.getBlockData() instanceof Ageable) {
						if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
							return;
						}
						Ageable ag = (Ageable) b.getBlockData();
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 60L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 120L);
						return;

					}
				} else {
					return;

				}
			}

		}

	}

	@EventHandler
	public void onPlaceMelon(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {

			if (b.getBlockData() == null)
				return;

			if (b.getType() == Material.MELON_STEM) {
				if (p.getInventory().contains(Material.MELON_SEEDS)) {
					if (b.getBlockData() instanceof Ageable) {
						if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
							return;
						}
						Ageable ag = (Ageable) b.getBlockData();
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 20L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 40L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(3);
							b.setBlockData(ag);

						}, 60L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(4);
							b.setBlockData(ag);

						}, 80L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(5);
							b.setBlockData(ag);

						}, 100L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(6);
							b.setBlockData(ag);

						}, 120L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(7);
							b.setBlockData(ag);

						}, 140L);
						return;

					}
				} else {
					return;

				}
			}
		}

	}

	@EventHandler
	public void onPlacePumpkin(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {

			if (b.getBlockData() == null)
				return;

			if (b.getType() == Material.PUMPKIN_STEM) {
				if (p.getInventory().contains(Material.PUMPKIN_SEEDS)) {
					if (b.getBlockData() instanceof Ageable) {
						if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
							return;
						}
						Ageable ag = (Ageable) b.getBlockData();
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 20L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 40L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(3);
							b.setBlockData(ag);

						}, 60L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(4);
							b.setBlockData(ag);

						}, 80L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(5);
							b.setBlockData(ag);

						}, 100L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(6);
							b.setBlockData(ag);

						}, 120L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(7);
							b.setBlockData(ag);

						}, 140L);
						return;

					}
				} else {
					return;

				}
			}
		}
	}
}
