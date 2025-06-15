package me.loststormx.myenderchest;


import org.bukkit.Bukkit;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {

    public static void main() {
        String url = "jdbc:sqlite:enderchestDATA";

        var DATATable = "CREATE TABLE IF NOT EXISTS playerEnderchestTABLE ("
                + "id TEXT NOT NULL"
                + "Items"
                + ");";

        try (var connection = DriverManager.getConnection(url)) {
            if (connection == null) {
                Bukkit.getLogger().info("No database found");
                Bukkit.getLogger().info("New database created");
            } if (connection != null) {
                Bukkit.getLogger().info("Database Found");

                var stmt = connection.createStatement();
                stmt.execute(DATATable);
            }
            connection.close();

        } catch (SQLException error) {
            Bukkit.getLogger().warning(error.getMessage());
        }
    }

    public static void dataUpdate() {

    }


}
