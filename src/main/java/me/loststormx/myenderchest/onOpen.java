package me.loststormx.myenderchest;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.net.http.WebSocket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class onOpen implements Listener {

    @EventHandler
    private void onOpen(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getHolder(false) instanceof customMenu customMenu) {
            Bukkit.getLogger().info("enderchest closed");

            String url = "jdbc:sqlite:enderchestDATA";
            var sql = "SELECT items FROM " + event.getPlayer().getUniqueId().toString();

            try (var connection = DriverManager.getConnection(url)) {
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT Items FROM " + event.getPlayer().getUniqueId().toString());
                 ItemStack[] items = ItemStack.deserializeItemsFromBytes(resultSet.getBytes("Items"));

                customMenu.setContents(items);

            } catch (SQLException e) {
               Bukkit.getLogger().warning(e.getMessage());
            }
        }
    }
}