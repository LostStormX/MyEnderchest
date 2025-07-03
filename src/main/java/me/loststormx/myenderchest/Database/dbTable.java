package me.loststormx.myenderchest.Database;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.w3c.dom.CDATASection;

import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbTable {

    public static void creation(Player player) {
        var url = "jdbc:sqlite:EnderchestDatabase";

        var UUID = player.getUniqueId();
        var sql = "CREATE TABLE IF NOT EXISTS " + UUID + " ("
                + "data BLOB"
                + ");";

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            stmt.execute(sql);

        } catch (SQLException error) {
            Bukkit.getLogger().warning(error.getMessage());
        }
    }

    public static void update(Player player, Blob DATA) {
        var url = "jdbc:sqlite:EnderchestDatabase";

        var UUID = player.getUniqueId();
        var sql = "UPDATE " + UUID + " SET data = ?";

        var data = DATA;

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setBlob(1, data);

            pstmt.executeUpdate();
        }catch (SQLException error) {
            Bukkit.getLogger().warning(error.getMessage());
        }
    }
}
