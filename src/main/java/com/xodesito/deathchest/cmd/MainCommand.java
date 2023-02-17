package com.xodesito.deathchest.cmd;

import com.xodesito.deathchest.DeathChest;
import com.xodesito.deathchest.deathchest.Chest;
import com.xodesito.deathchest.util.Hologram;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    private DeathChest plugin;

    public MainCommand(DeathChest plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Chest chest = new Chest(player.getUniqueId(), player.getLocation(), player.getInventory().getStorageContents());
        chest.spawnChest();
        return false;
    }
}
