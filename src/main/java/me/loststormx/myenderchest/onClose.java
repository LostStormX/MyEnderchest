package me.loststormx.myenderchest;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.Driver;
import java.sql.DriverManager;

public class onClose implements Listener {

    public void storeDATA() {
        var url = "jdbc:sqlite:enderchestDATA";
        var sql = "UPDATE playerEnderchestTABLE,"
                + "DATA = ?";

        try (var connection = DriverManager.getConnection(url);
             var pstmt = connection.prepareStatement(sql)) {

        }

    }


    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getHolder(false) instanceof customMenu customMenu) {
            Bukkit.getLogger().info("custom menu closed");

            byte[] bytes = ItemStack.serializeItemsAsBytes(inventory.getContents());

            try (var connection = DriverManager.getConnection(url);
                 var pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, );
            }
        }
    }
}
