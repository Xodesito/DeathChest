package com.xodesito.deathchest.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import java.util.UUID;

public class Hologram {

    private int entityId;

    public void spawnHologram(Location location, String line) {

            ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location.add(0, 0.3, 0), EntityType.ARMOR_STAND);
            entityId = armorStand.getEntityId();

            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setInvulnerable(true);
            armorStand.setInvisible(true);
            armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&', line));
            armorStand.setCustomNameVisible(true);

    }

    public void killHologram(int entityId) {
        Bukkit;
    }

}
