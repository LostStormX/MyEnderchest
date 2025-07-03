package me.loststormx.myenderchest.Database;

import org.bukkit.Bukkit;

import java.sql.DriverManager;
import java.sql.SQLException;

public class dbCreation {
    public static void creation() {
        String url = "jdbc:sqlite:EnderchestDatabase";

        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                Bukkit.getLogger().info("Driver " + meta.getDriverName());
            }
        } catch (SQLException error) {
            Bukkit.getLogger().warning(error.getMessage());
        }
    }
}
