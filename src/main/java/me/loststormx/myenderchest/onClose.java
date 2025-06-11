package me.loststormx.myenderchest;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class onClose implements Listener {

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getHolder(false) instanceof customMenu customMenu) {
            Bukkit.getLogger().info("custom menu closed");
        }
    }
}
