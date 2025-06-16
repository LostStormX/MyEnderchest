package me.loststormx.myenderchest;


import com.google.common.base.Strings;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

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

    public static void dataUpdate(String playerid, byte[] bytes) {
        String url = "jdbc:sqlite:enderchestDATA";
        var sql = "UPDATE " + playerid + ","
                + "items = ?";
        try (var connection = DriverManager.getConnection(url);
             var pstmt = connection.prepareStatement(sql)) {

            pstmt.setBytes(1, bytes);


            pstmt.executeUpdate();

        } catch (SQLException error) {
            Bukkit.getLogger().warning(error.getMessage());
        }


    }

    public static void tableCreation(String playerid) {
        String url = "jdbc:sqlite:enderchestDATA";
        var table = "CREATE TABLE IF NO EXISTS " + playerid + "("
                + "items BLOB"
                + ");";

        Bukkit.getLogger().info(playerid + " table created");
    }

    public static void gettingDataFromTable(String playerid) {
        String url = "jdbc:sqlite:enderchestDATA";
        var sql = "SELECT items FROM " + playerid.toString();

        try (var connection = DriverManager.getConnection(url);
             var stmt = connection.createStatement();
             var rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                rs.getBlob("items");
            }

        } catch (SQLException error) {
            Bukkit.getLogger().warning(error.getMessage());
        }
    }
}