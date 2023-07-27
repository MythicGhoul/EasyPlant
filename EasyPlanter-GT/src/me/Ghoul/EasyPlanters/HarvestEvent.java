package me.Ghoul.EasyPlanters;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class HarvestEvent implements Listener {

	Main plugin;

	public HarvestEvent(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	public String prefix = ChatColor.WHITE + "[" + ChatColor.GOLD + "EP" + ChatColor.WHITE + "]";

	private static boolean isHoe(Player player) {
		ItemStack mainHandItem = player.getInventory().getItemInMainHand();
		return mainHandItem != null && mainHandItem.getType().toString().endsWith("_HOE");
	}

	@EventHandler
	public void onDoubleDropWheat(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		int mindrop = plugin.getConfig().getInt("Crops.Wheat.Min-Drop");
		int maxdrop = plugin.getConfig().getInt("Crops.Wheat.Max-Drop");
		int r2 = (int) Math.floor(Math.random() * (maxdrop - mindrop + 1) + mindrop);
		ItemStack drop = new ItemStack(b.getType(), r2);

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("" + ChatColor.AQUA + "-=]" + " "
				+ ChatColor.GOLD + ChatColor.BOLD + "Auto Hoe II" + " " + ChatColor.AQUA + "[=-")) {
			if (b.getType().equals(Material.WHEAT)) {
				e.setDropItems(false);
				b.getLocation().getWorld().dropItem(b.getLocation(), drop);
				b.getLocation().getWorld().dropItem(b.getLocation(), new ItemStack(Material.WHEAT_SEEDS, 2));
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(
						" " + ChatColor.GOLD + r2 + " " + "x" + " " + "Wheat" + " " + ChatColor.AQUA + "Dropped!"));

				Location l = p.getEyeLocation();
				Vector v = p.getLocation().getDirection();
				l.add(v.multiply(1.5));
				p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);
				QuickGrowBreak.onPlaceWheat(e);
				return;

			}
		}

	}

	@EventHandler
	public static void onHarvestWheat(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (!isHoe(p)) {
				return;
			}
			if (p.getInventory().contains(Material.WHEAT_SEEDS)) {

				Location l = p.getEyeLocation();
				Vector v = p.getLocation().getDirection();
				l.add(v.multiply(1.5));
				p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);

				if (b.getType() == Material.WHEAT) {
					cropBlockType = Material.WHEAT;

				}

				if (cropBlockType != null && isFullyGrown(b)) {
					replantCrop(b, b.getLocation(), cropBlockType);
					SeedsRemoval.consumeItem(p, 1, Material.WHEAT_SEEDS);
				}
			}
		} else {
			return;
		}
	}

	@EventHandler
	public static void onHarvestWheat2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {
				if (p.getInventory().contains(Material.WHEAT_SEEDS)) {
					if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
									+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-")) {

						Location l = p.getEyeLocation();
						Vector v = p.getLocation().getDirection();
						l.add(v.multiply(1.5));
						p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);

						if (b.getType() == Material.WHEAT) {
							cropBlockType = Material.WHEAT;

						}

						if (cropBlockType != null && isFullyGrown(b)) {
							replantCrop(b, b.getLocation(), cropBlockType);
							SeedsRemoval.consumeItem(p, 1, Material.WHEAT_SEEDS);
						}
					}
				} else {
					return;
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestNetherWart(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().contains(Material.NETHER_WART)) {
					if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD
									+ "Auto Hoe I" + " " + ChatColor.GOLD + "[=-")) {

						Location l = p.getEyeLocation();
						Vector v = p.getLocation().getDirection();
						l.add(v.multiply(1.5));
						p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);
						if (b.getType() == Material.NETHER_WART) {
							cropBlockType = Material.NETHER_WART;

						}

						if (cropBlockType != null && isFullyGrown(b)) {
							replantCrop(b, b.getLocation(), cropBlockType);
							SeedsRemoval.consumeItem(p, 1, Material.NETHER_WART);
						}
					}
				} else {
					return;
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestNetherWart2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().contains(Material.NETHER_WART)) {
					if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
									+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-")) {
						Location l = p.getEyeLocation();
						Vector v = p.getLocation().getDirection();
						l.add(v.multiply(1.5));
						p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);

						if (b.getType() == Material.NETHER_WART) {
							cropBlockType = Material.NETHER_WART;

						}

						if (cropBlockType != null && isFullyGrown(b)) {
							replantCrop(b, b.getLocation(), cropBlockType);
							SeedsRemoval.consumeItem(p, 1, Material.NETHER_WART);
						}
					}
				} else {
					return;
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestBeetRoot(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().contains(Material.BEETROOT_SEEDS)) {
					if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD
									+ "Auto Hoe I" + " " + ChatColor.GOLD + "[=-")) {

						Location l = p.getEyeLocation();
						Vector v = p.getLocation().getDirection();
						l.add(v.multiply(1.5));
						p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);
						if (b.getType() == Material.BEETROOTS) {
							cropBlockType = Material.BEETROOTS;

						}

						if (cropBlockType != null && isFullyGrown(b)) {
							replantCrop(b, b.getLocation(), cropBlockType);
							SeedsRemoval.consumeItem(p, 1, Material.BEETROOT_SEEDS);
						}
					}
				} else {
					return;
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestBeetRoot2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().contains(Material.BEETROOT_SEEDS)) {
					if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
									+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-"))

					{
						Location l = p.getEyeLocation();
						Vector v = p.getLocation().getDirection();
						l.add(v.multiply(1.5));
						p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);

						if (b.getType() == Material.BEETROOTS) {
							cropBlockType = Material.BEETROOTS;

						}

						if (cropBlockType != null && isFullyGrown(b)) {
							replantCrop(b, b.getLocation(), cropBlockType);
							SeedsRemoval.consumeItem(p, 1, Material.BEETROOT_SEEDS);
						}
					}
				} else {
					return;
				}
			}

		}
	}

	@EventHandler
	public static void onHarvestPotato(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().contains(Material.POTATO)) {
					if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD
									+ "Auto Hoe I" + " " + ChatColor.GOLD + "[=-"))
						return;
					{
						Location l = p.getEyeLocation();
						Vector v = p.getLocation().getDirection();
						l.add(v.multiply(1.5));
						p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);

						if (b.getType() == Material.POTATOES) {
							cropBlockType = Material.POTATOES;

						}

						if (cropBlockType != null && isFullyGrown(b)) {
							replantCrop(b, b.getLocation(), cropBlockType);
							SeedsRemoval.consumeItem(p, 1, Material.POTATO);
						}
					}
				} else {
					return;
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestPotato2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().contains(Material.POTATO)) {
					if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
									+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-"))
						return;
					{
						Location l = p.getEyeLocation();
						Vector v = p.getLocation().getDirection();
						l.add(v.multiply(1.5));
						p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);

						if (b.getType() == Material.POTATOES) {
							cropBlockType = Material.POTATOES;

						}

						if (cropBlockType != null && isFullyGrown(b)) {
							replantCrop(b, b.getLocation(), cropBlockType);
							SeedsRemoval.consumeItem(p, 1, Material.POTATO);
						}
					}
				} else {
					return;
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestCarrot(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().contains(Material.CARROT)) {
					if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD
									+ "Auto Hoe I" + " " + ChatColor.GOLD + "[=-"))
						return;
					{
						Location l = p.getEyeLocation();
						Vector v = p.getLocation().getDirection();
						l.add(v.multiply(1.5));
						p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);

						if (b.getType() == Material.CARROTS) {
							cropBlockType = Material.CARROTS;

						}

						if (cropBlockType != null && isFullyGrown(b)) {
							replantCrop(b, b.getLocation(), cropBlockType);
							SeedsRemoval.consumeItem(p, 1, Material.CARROT);
						}

					}
				} else {
					return;
				}

			}
		}
	}

	@EventHandler
	public static void onHarvestCarrot2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.getInventory().getItemInMainHand().getItemMeta() == null)
			return;
		if (p.getInventory().getItemInMainHand() == null)
			return;
		if (p.getMainHand() == null)
			return;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().contains(Material.CARROT)) {
					if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
									+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-"))
						return;
					{
						Location l = p.getEyeLocation();
						Vector v = p.getLocation().getDirection();
						l.add(v.multiply(1.5));
						p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, l, 1);

						if (b.getType() == Material.CARROTS) {
							cropBlockType = Material.CARROTS;

						}

						if (cropBlockType != null && isFullyGrown(b)) {
							replantCrop(b, b.getLocation(), cropBlockType);
							SeedsRemoval.consumeItem(p, 1, Material.CARROT);
						}

					}
				}
			} else {
				return;
			}
		}
	}

	public static void replantCrop(Block b, Location loc, Material cropBlockType) {
		Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
			loc.getBlock().setType(cropBlockType);
			loc.getBlock().getWorld().spawnParticle(Particle.WATER_DROP, b.getLocation(), 100, 0.5, 0.5, 0.5);
		}, 20L);
	}

	public static boolean isFullyGrown(Block block) {
		Ageable age = (Ageable) block.getBlockData();
		int max = age.getMaximumAge();

		return age.getAge() == max;
	}

}
