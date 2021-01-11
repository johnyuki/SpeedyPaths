package com.johnyuki.speedypaths.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.johnyuki.speedypaths.SpeedyPaths;
import net.md_5.bungee.api.ChatColor;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(command.getName().equalsIgnoreCase("speedypaths")) {
                if(player.hasPermission("speedypaths.reload")) {
                    if(args.length > 0) {
                        if(args[0].equalsIgnoreCase("reload")) {
                            SpeedyPaths.plugin.reloadConfig();
                            player.sendMessage(ChatColor.GREEN + "Config reloaded.");
                        }
                    } else {
                        player.sendMessage(
                                ChatColor.GREEN + "=== SpeedyPaths ===\n" +
                                        ChatColor.GREEN + "/speedypaths reload - " + ChatColor.WHITE + "Reloads the config.yml"
                        );
                    }
                } else {
                    player.sendMessage(ChatColor.RED+"You do not have access to that command.");
                }
            }
        }
        return true;
    }
}