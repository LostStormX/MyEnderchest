package me.loststormx.myenderchest;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.sun.jdi.Bootstrap;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;



public final class myenderchest_plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("MyEnderChest Online");

        // Registering Tree
        LiteralCommandNode<CommandSourceStack> root = Commands.literal("enderchest")
                .executes(ctx -> {
                    CommandSender sender = ctx.getSource().getSender();
                    Entity executor = ctx.getSource().getExecutor();

                    // checks weather if the executer is a player
                    if (!(executor instanceof Player player)) {
                        sender.sendMessage(ChatColor.RED + "Only players can run this command");
                        return Command.SINGLE_SUCCESS;
                    }

                    getLogger().info("command ran");


                    return Command.SINGLE_SUCCESS;
                })

                //.then(Commands.literal("enderchest view")
                //.executes(ctx -> {

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
