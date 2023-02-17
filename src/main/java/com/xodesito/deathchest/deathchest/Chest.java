package com.xodesito.deathchest.deathchest;

import com.xodesito.deathchest.util.Hologram;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Chest {

    private UUID uuid;
    private Location location;
    private ItemStack[] items;


    public Chest(UUID uuid, Location location, ItemStack[] items) {
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

        /* Spawning holograms */
        Hologram hologram = new Hologram();
        hologram.spawnHologram(block.getLocation().add(0.5, 0.5, 0.5), "&d" + player.getName() + "'s inventory");
        hologram.spawnHologram(block.getLocation().add(0.5, 0.8, 0.5), "&cDisappearing in &45 minutes!");
    }

}
