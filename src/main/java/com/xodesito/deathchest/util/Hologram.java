package com.xodesito.deathchest.util;

import com.xodesito.deathchest.DeathChest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import java.util.UUID;

public class Hologram {

    private ArmorStand armorStand;
    private String string;
    private Location location;

    public Hologram(String string, Location location) {
        this.string = string;
        this.location = location;
    }

    public void spawnHologram() {

            armorStand = (ArmorStand) location.getWorld().spawnEntity(location.add(0, 0.3, 0), EntityType.ARMOR_STAND);

            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setInvulnerable(true);
            armorStand.setInvisible(true);
            armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&', string));
            armorStand.setCustomNameVisible(true);

    }

    public void editHologram(String string) {
        armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&', string));
    }

    public void killHologram() {
        if (armorStand == null) {
            Bukkit.getConsoleSender().sendMessage("DEATHCHEST ERR: The value of armorstand equals to null.");
            return;
        }
        armorStand.remove();
    }

}
