package com.xodesito.deathchest.deathchest;

import com.xodesito.deathchest.DeathChest;
import com.xodesito.deathchest.util.Hologram;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class Chest {

    private DeathChest plugin;
    private UUID uuid;
    private Location location;
    private ItemStack[] items;


    public Chest(DeathChest plugin, UUID uuid, Location location, ItemStack[] items) {
        this.plugin = plugin;
        this.uuid = uuid;
        this.location = location;
        this.items = items;
    }

    public void spawnChest() {
        Player player = Bukkit.getPlayer(uuid);
        location.setPitch(0);
        location.setYaw(0);
        location.getBlock().setType(Material.CHEST);
        Block block = location.getBlock();
        org.bukkit.block.Chest chest = (org.bukkit.block.Chest) block.getState();
        Inventory inventory = chest.getInventory();
        chest.setCustomName(player.getName() + "'s inventory");

        for (ItemStack item : items) {

            if (item == null) continue;
            inventory.addItem(item);
        }

        Hologram hPlayerName = new Hologram("&6" + player.getName() + "'s inventory", player.getLocation());
        Hologram hChestTime = new Hologram("&cThe chest will disappear in seconds.", player.getLocation());
        hPlayerName.spawnHologram();

        new BukkitRunnable() {
            int time = 5;
            @Override
            public void run(){
                --time;
                hChestTime.spawnHologram();
                hChestTime.killHologram();
                Bukkit.getConsoleSender().sendMessage("Test! " + time);

                if (time == 0) {
                    cancel();
                    hChestTime.editHologram("&cThe chest will disappear in " + time + " seconds.");
                    block.setType(Material.AIR);
                }

            }
        }.runTaskTimer(plugin, 0, 20L);
    }

}
