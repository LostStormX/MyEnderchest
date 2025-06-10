package me.loststormx.myenderchest;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Myenderchest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("myEnderchest Initizalized");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
