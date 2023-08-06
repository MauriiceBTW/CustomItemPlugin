package me.maurice.customitemproject;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItemPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("customitem").setExecutor(new CustomItemCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
