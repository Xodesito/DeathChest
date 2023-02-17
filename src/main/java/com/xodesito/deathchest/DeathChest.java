package com.xodesito.deathchest;

import com.xodesito.deathchest.cmd.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathChest extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("deathchest").setExecutor(new MainCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
