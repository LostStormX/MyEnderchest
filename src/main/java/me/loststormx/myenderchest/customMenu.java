package me.loststormx.myenderchest;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class customMenu implements InventoryHolder {

    private final Inventory inventory;

    public customMenu(myenderchest_plugin plugin) {
        this.inventory = plugin.getServer().createInventory(this, 9 * 6, "Enderchest");
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
}
