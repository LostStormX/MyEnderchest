package me.loststormx.myenderchest;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.net.http.WebSocket;

public class onOpen implements Listener {

    @EventHandler
    private void onOpen(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getHolder(false) instanceof customMenu customMenu) {
            Bukkit.getLogger().info("enderchest closed");



            ItemStack[] items =
            customMenu.setContents();
        }
    }
}
