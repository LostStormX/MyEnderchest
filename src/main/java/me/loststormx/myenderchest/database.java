package me.loststormx.myenderchest;


import org.bukkit.Bukkit;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class database {

    public static void main() {
        String url = "jdbc:sqlite:enderchestDATA";


        try (var connection = DriverManager.getConnection(url)) {
            if (connection == null) {
                Bukkit.getLogger().info("No database found");
                Bukkit.getLogger().info("New database created");
            }
            if (connection != null) {
                Bukkit.getLogger().info("Database Found");
            }
            connection.close();

        } catch (SQLException error) {
            Bukkit.getLogger().warning(error.getMessage());
        }
    }

    public static void tableCreation(String playerid) {
        String url = "jdbc:sqlite:enderchestDATA";
        var table = "CREATE TABLE IF NO EXISTS " + playerid.toString() + "("
                + "Items BLOB"
                + ");";

        Bukkit.getLogger().info(playerid + " table created");
    }
}