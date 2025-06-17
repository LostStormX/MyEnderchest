package me.loststormx.myenderchest;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class onClose implements Listener {

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getHolder(false) instanceof customMenu customMenu) {
            Bukkit.getLogger().info("enderchest closed");

            var player = event.getPlayer();
            String playerid = String.valueOf(player.getUniqueId());

            String url = "jdbc:sqlite:enderchestDATA";
            var sql = "UPDATE " + playerid + ","
                    + "items = ? ";

            try (var connection = DriverManager.getConnection(url);
                 var pstmt = connection.prepareStatement(sql)) {
                byte[] items = ItemStack.serializeItemsAsBytes(inventory.getContents());

                pstmt.setBytes(1, items);
                pstmt.executeUpdate();

            } catch (SQLException error) {
                Bukkit.getLogger().warning(error.getMessage());

            }
        }
    }
}
