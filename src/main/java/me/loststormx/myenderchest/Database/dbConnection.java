package me.loststormx.myenderchest.Database;

import org.bukkit.Bukkit;

import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    public static void connect() {
        var url = "jdbc:sqlite:c:/sqlite/db/EnderchestDatabase.db";


        try (var conn = DriverManager.getConnection(url)) {
            Bukkit.getLogger().info("Database Connection Established");
        } catch (SQLException error) {
            Bukkit.getLogger().warning(error.getMessage());
        }
    }
}
