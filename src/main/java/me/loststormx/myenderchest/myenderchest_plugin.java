package me.loststormx.myenderchest;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import me.loststormx.myenderchest.Database.dbConnection;
import me.loststormx.myenderchest.Database.dbCreation;
import me.loststormx.myenderchest.EventListeners.onInventoryClose;
import me.loststormx.myenderchest.EventListeners.onInventoryOpen;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public final class myenderchest_plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Creating the main db
        dbCreation.creation();

        // Connect to the main db
        dbConnection.connect();

        getLogger().info("MyEnderChest Online");

        // Registering Listeners
        getServer().getPluginManager().registerEvents(new onInventoryClose(), this);
        getServer().getPluginManager().registerEvents(new onInventoryOpen(), this);

        // Registering Command Tree
        LiteralCommandNode<CommandSourceStack> root = Commands.literal("enderchest")
                .executes(ctx -> {
                    getLogger().info("command ran");

                    CommandSender sender = ctx.getSource().getSender();
                    Entity executor = ctx.getSource().getExecutor();

                    // checks whether if the executer is a player
                    if (!(executor instanceof Player player)) {
                        sender.sendMessage("Only players can run this command");
                        return Command.SINGLE_SUCCESS;
                    }

                    // opens the players enderchest
                    customInventory customInventory = new customInventory(this);
                    player.openInventory(customInventory.getInventory());

                    return Command.SINGLE_SUCCESS;
                })

                //.then(Commands.literal("enderchest view")
                //.executes(ctx -> {
                  //  String argumentProvided = ctx.getArgument("player", String.class);

                    //return Command.SINGLE_SUCCESS;
                //})

                //  }))
                //.then(Commands.literal("enderchest clear")
                //      .executes(ctx -> {

                //    }))

                .build();



        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register(root); });

        }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MyEnderChest Offline");
    }
}
